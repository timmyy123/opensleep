package com.urbandroid.sleep.alarmclock.volume;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.media.lullaby.LullabyService;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class LullabyVolumeDown {
    private Context context;
    private int streamType;
    private int volumeDownAfter;
    private boolean volumeDownFinished = false;
    private VolumeControlRunnable volumeControlRunnable = null;
    private Thread volumeControlThread = null;
    private long lastUpdate = -1;
    private long elapsedInDeepSleep = 0;
    private long elapsed = 0;

    public LullabyVolumeDown(Context context, int i, int i2) {
        this.volumeDownAfter = 900000;
        this.context = context;
        this.volumeDownAfter = parseVolumeDownAfterPreferenceValue(i2);
        this.streamType = i;
        listenForVolumeDownAfterPreferenceChange();
    }

    private boolean isEnabled() {
        return this.volumeDownAfter != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$listenForVolumeDownAfterPreferenceChange$0(SharedPreferences sharedPreferences, String str) {
        if (str.contentEquals("media_decreasing_volume_after")) {
            this.volumeDownAfter = parseVolumeDownAfterPreferenceValue(SharedApplicationContext.getSettings().getLullabyVolumeDownAfter());
            Logger.logInfo("Lullaby: timeout changes " + this.volumeDownAfter);
            reset();
            this.volumeDownFinished = false;
        }
    }

    private void listenForVolumeDownAfterPreferenceChange() {
        SharedApplicationContext.getSettings().getDefaultSharedPreferences(this.context).registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.urbandroid.sleep.alarmclock.volume.LullabyVolumeDown$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                this.f$0.lambda$listenForVolumeDownAfterPreferenceChange$0(sharedPreferences, str);
            }
        });
    }

    private int parseVolumeDownAfterPreferenceValue(int i) {
        if (i < -1) {
            return 360000;
        }
        if (i == -1) {
            return -1;
        }
        if (i == 0) {
            return 360000;
        }
        return i;
    }

    public void finish() {
        Logger.logDebug("LullabyVolumeDown: FINISH ");
        if (this.volumeControlRunnable != null) {
            Logger.logDebug("LullabyVolumeDown: RESET");
            this.volumeControlRunnable.reset();
            this.volumeControlThread.interrupt();
        }
        this.volumeControlRunnable = null;
    }

    public void reset() {
        this.elapsedInDeepSleep = 0L;
        this.elapsed = 0L;
    }

    public void update(boolean z) {
        String str;
        if (isEnabled() && !this.volumeDownFinished) {
            StringBuilder sb = new StringBuilder("LullabyVolumeDown: Update: Deep sleep ");
            sb.append(z);
            sb.append(" elapsedInDeepSleep: ");
            sb.append(this.elapsedInDeepSleep);
            sb.append(" ?> ");
            sb.append(this.volumeDownAfter);
            sb.append(" finished:  ");
            if (this.volumeControlRunnable == null) {
                str = "n/a";
            } else {
                str = this.volumeControlRunnable.isFinished() + " volume done: " + this.volumeControlRunnable.isReachedTargetVolume();
            }
            sb.append(str);
            Logger.logDebug(sb.toString());
            if (this.lastUpdate == -1) {
                this.lastUpdate = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.lastUpdate;
            this.lastUpdate = System.currentTimeMillis();
            long j = this.elapsed + jCurrentTimeMillis;
            this.elapsed = j;
            if (z || j > 5400000) {
                this.elapsedInDeepSleep += jCurrentTimeMillis;
                this.volumeDownAfter = new Settings(this.context).getLullabyVolumeDownAfter();
                Logger.logDebug("LullabyVolumeDown: Since last elapsedInDeepSleep: " + this.elapsedInDeepSleep + " ?> " + this.volumeDownAfter);
                if (this.elapsedInDeepSleep > this.volumeDownAfter && this.volumeControlRunnable == null) {
                    Logger.logInfo("LullabyVolumeDown: Starting runnable ");
                    this.volumeControlRunnable = new VolumeControlRunnable(this.context, null, 30000, false, this.streamType, false, -1, -1, -1, 0L);
                    Thread thread = new Thread(this.volumeControlRunnable);
                    this.volumeControlThread = thread;
                    thread.start();
                    zza$$ExternalSyntheticOutline0.m(this.context, "com.urbandroid.sleep.LULLABY_VOLUME_DOWN");
                }
            } else {
                Logger.logDebug("LullabyVolumeDown: Not deep sleep");
                VolumeControlRunnable volumeControlRunnable = this.volumeControlRunnable;
                if (volumeControlRunnable != null && !volumeControlRunnable.isFinished()) {
                    Logger.logDebug("LullabyVolumeDown: pausing 90000");
                    this.volumeControlRunnable.setPause(90000);
                }
            }
            VolumeControlRunnable volumeControlRunnable2 = this.volumeControlRunnable;
            if (volumeControlRunnable2 == null || !volumeControlRunnable2.isReachedTargetVolume()) {
                return;
            }
            Logger.logDebug("LullabyVolumeDown: REACHED VOLUME ");
            if (LullabyService.isRunning()) {
                zza$$ExternalSyntheticOutline0.m(this.context, "com.urbandroid.sleep.ACTION_LULLABY_AUTO_STOP_PLAYBACK");
            } else if (new Settings(this.context).isLullabyTurnOffWiFi()) {
                WifiEnabler.getInstance().setWifi(this.context, false);
            }
            this.volumeDownFinished = true;
        }
    }
}
