package com.urbandroid.sleep.smartwatch;

import android.content.Context;
import android.os.Handler;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.hr.polar.BleSmartWatch;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.generic.GenericWatch;
import com.urbandroid.sleep.smartwatch.pebble.Pebble;
import com.urbandroid.sleep.smartwatch.pebble.RePebble;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaser;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaserProvider;
import com.urbandroid.sleep.smartwatch.polar.Polar;
import com.urbandroid.sleep.smartwatch.wear.Wear;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SmartWatchProvider {
    private static SmartWatch currentSmartWatch;

    public static void asyncSmartwatchConnect(Context context, IConnectivityCallback iConnectivityCallback, long j, boolean z) {
        SleepPhaser sleepPhaser;
        Logger.logInfo("SmartWatch: Async smart watch connect called");
        if (currentSmartWatch != null) {
            Logger.logInfo("SmartWatch: Returning immediately callback for still already registered watch.");
            iConnectivityCallback.status(currentSmartWatch, true);
            return;
        }
        Settings settings = SharedApplicationContext.getSettings();
        IConnectivityCallback waitForFirstConnectedWatch = new WaitForFirstConnectedWatch(iConnectivityCallback, j, z, 0);
        try {
            sleepPhaser = SleepPhaserProvider.getSleepPhaser(context);
        } catch (Exception e) {
            Logger.logSevere(e);
            sleepPhaser = null;
        }
        if (sleepPhaser != null && settings.isSleepPhaserSleepTracking()) {
            Logger.logInfo("SmartWatch: connect SleepPhaser");
            if (sleepPhaser.isConnected()) {
                waitForFirstConnectedWatch.status(sleepPhaser, true);
                return;
            } else {
                sleepPhaser.asyncConnectionCheck(waitForFirstConnectedWatch, j);
                return;
            }
        }
        if (settings.isDirectBleWearableSelectedForTracking()) {
            Logger.logInfo("SmartWatch: connect BTLE");
            BleSmartWatch.INSTANCE.getInstance(context).asyncConnectionCheck(waitForFirstConnectedWatch, j);
            return;
        }
        if (!settings.isSmartwatchEnabled()) {
            Logger.logInfo("SmartWatch: connect NO WATCH");
            iConnectivityCallback.status(null, false);
            return;
        }
        if (settings.isWearableEligibleForTracking(Wearable.PEBBLE_TIME) || settings.isWearableEligibleForTracking(Wearable.PEBBLE_GADGETBRIDGE)) {
            Logger.logInfo("SmartWatch: connect PEBBLE");
            new Pebble(context).asyncConnectionCheck(waitForFirstConnectedWatch, j);
        }
        if (settings.isWearableEligibleForTracking(Wearable.REPEBBLE)) {
            Logger.logInfo("SmartWatch: connect RePebble");
            new RePebble(context).asyncConnectionCheck(waitForFirstConnectedWatch, j);
        }
        if (settings.isWearableEligibleForTracking(Wearable.WEAR_OS) || settings.isWearableEligibleForTracking(Wearable.SAMSUNG_WEAR) || settings.isWearableEligibleForTracking(Wearable.WEAR_OS_3_PLUS)) {
            Logger.logInfo("SmartWatch: connect WEAR");
            new Wear(context).asyncConnectionCheck(waitForFirstConnectedWatch, j);
        }
        if (settings.isWearableEligibleForTracking(Wearable.POLAR_SDK)) {
            Logger.logInfo("SmartWatch: connect Polar SDK");
            new Polar(context).asyncConnectionCheck(waitForFirstConnectedWatch, j);
        }
        new GenericWatch(context).asyncConnectionCheck(waitForFirstConnectedWatch, j);
    }

    public static SmartWatch getSmartWatch(Context context) {
        return currentSmartWatch;
    }

    public static void releaseSmartwatch() {
        Logger.logInfo("SmartWatch: releasing smart watch");
        currentSmartWatch = null;
    }

    public static void setSmartwatchInstanceIfNotTrackingYet(SmartWatch smartWatch) {
        if (SharedApplicationContext.getSettings().getSelectedWearable() != Wearable.AUTO) {
            if (SleepService.isRunning()) {
                Logger.logInfo("SmartWatch: NOT ADDING watch tracking running");
                return;
            } else {
                Logger.logInfo("SmartWatch: Setting current watch: ".concat(smartWatch != null ? smartWatch.getClass().getSimpleName() : "NULL"));
                currentSmartWatch = smartWatch;
                return;
            }
        }
        if (currentSmartWatch == null) {
            if (SleepService.isRunning()) {
                Logger.logInfo("SmartWatch: NOT ADDING watch tracking running");
                return;
            } else {
                Logger.logInfo("SmartWatch: Setting current watch: ".concat(smartWatch != null ? smartWatch.getClass().getSimpleName() : "NULL"));
                currentSmartWatch = smartWatch;
                return;
            }
        }
        Logger.logInfo("SmartWatch: Adding current watch: ".concat(smartWatch != null ? smartWatch.getClass().getSimpleName() : "NULL"));
        SmartWatch smartWatch2 = currentSmartWatch;
        if (!(smartWatch2 instanceof MultiSmartWatch)) {
            MultiSmartWatch multiSmartWatch = new MultiSmartWatch();
            currentSmartWatch = multiSmartWatch;
            multiSmartWatch.add(smartWatch2);
        }
        ((MultiSmartWatch) currentSmartWatch).add(smartWatch);
    }

    public static class WaitForFirstConnectedWatch implements IConnectivityCallback {
        private boolean done;
        private Handler h;
        private final IConnectivityCallback outerCallback;
        private final boolean registerAsCurrent;
        private Runnable timeoutRunnable;

        private WaitForFirstConnectedWatch(final IConnectivityCallback iConnectivityCallback, long j, boolean z) {
            this.done = false;
            this.outerCallback = iConnectivityCallback;
            this.registerAsCurrent = z;
            this.timeoutRunnable = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.SmartWatchProvider.WaitForFirstConnectedWatch.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WaitForFirstConnectedWatch.this.done) {
                        return;
                    }
                    WaitForFirstConnectedWatch.this.done = true;
                    iConnectivityCallback.status(null, false);
                }
            };
            Handler handler = new Handler();
            this.h = handler;
            handler.postDelayed(this.timeoutRunnable, j);
        }

        @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
        public void cancel() {
            Logger.logDebug("SmartWatch: Cancelling wait for watch callback. Done already: " + this.done);
            if (this.done) {
                return;
            }
            this.done = true;
            this.outerCallback.status(null, false);
        }

        @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
        public boolean isCancelled() {
            return this.done || this.outerCallback.isCancelled();
        }

        @Override // com.urbandroid.sleep.smartwatch.IConnectivityCallback
        public void status(SmartWatch smartWatch, boolean z) {
            Logger.logDebug("SmartWatch: CONNECTED " + smartWatch + " " + z);
            if (z) {
                if (!this.done || SharedApplicationContext.getSettings().getSelectedWearable() == Wearable.AUTO) {
                    if (this.registerAsCurrent) {
                        SmartWatchProvider.setSmartwatchInstanceIfNotTrackingYet(smartWatch);
                    }
                    this.outerCallback.status(smartWatch, z);
                    this.done = true;
                }
            }
        }

        public /* synthetic */ WaitForFirstConnectedWatch(IConnectivityCallback iConnectivityCallback, long j, boolean z, int i) {
            this(iConnectivityCallback, j, z);
        }
    }
}
