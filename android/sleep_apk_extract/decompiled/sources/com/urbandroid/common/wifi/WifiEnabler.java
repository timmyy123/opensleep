package com.urbandroid.common.wifi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.SleepPermissionCompat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class WifiEnabler {
    private static WifiEnabler instance;
    private Context context;
    private WifiManagerWrapper wifiManager;
    private final AtomicBoolean wasEnabledBefore = new AtomicBoolean(false);
    private final AtomicReference<? extends Set<String>> applicants = new AtomicReference<>(new HashSet());
    private final AtomicBoolean forceClose = new AtomicBoolean(false);

    public interface OnConnectListener {
        void connected(WifiContext wifiContext);

        void failed();

        void timeouted();
    }

    public WifiEnabler(Context context) {
        this.context = context;
        this.wifiManager = new WifiManagerWrapper(context);
    }

    private void cleanApplicants() {
        synchronized (this.applicants) {
            Logger.logInfo("WifiEnabler: removing all applicants: " + this.applicants.get());
            this.applicants.get().clear();
        }
    }

    private void disableInternal(String str) {
        synchronized (this.applicants) {
            try {
                Logger.logInfo("WifiEnabler: DISABLE (applicantId:" + str + ")");
                if (this.wifiManager.isWifiDisabled()) {
                    Logger.logInfo("WifiEnabler: no wifi - cleaning applicants");
                    cleanApplicants();
                    return;
                }
                if (!this.applicants.get().contains(str)) {
                    Logger.logInfo("WifiEnabler: applicant (applicantId: " + str + ") not registered");
                    return;
                }
                unregisterApplicant(str);
                try {
                    if (this.applicants.get().size() == 0) {
                        Logger.logInfo("WifiEnabler: final Wifi OFF (applicantId:" + str + ")");
                        this.wasEnabledBefore.set(false);
                        this.wifiManager.setWifiEnabled(false);
                        Logger.logInfo("WifiEnabler: Wifi OFF (applicantId:" + str + ")");
                    } else {
                        Logger.logInfo("WifiEnabler: Wifi not disabled yet - active applicants: " + this.applicants.get());
                    }
                } catch (SecurityException e) {
                    Logger.logSevere("WifiEnabler: Failure disable wifi", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized WifiEnabler getInstance() {
        WifiEnabler wifiEnabler;
        wifiEnabler = instance;
        if (wifiEnabler == null) {
            throw new RuntimeException("WifiEnabler not initialized");
        }
        return wifiEnabler;
    }

    public static synchronized void initialize(Context context) {
        if (instance == null) {
            instance = new WifiEnabler(context);
            if (new Settings(context).isAirplaneModeAutomatic()) {
                instance.setForceClose(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String logState(boolean z) {
        return z ? "ON" : "OFF";
    }

    private void registerApplicant(String str) {
        synchronized (this.applicants) {
            this.applicants.get().add(str);
            Logger.logInfo("WifiEnabler: register (applicantId: " + str + "), applicants: " + this.applicants.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleWifiChecker(WifiContext wifiContext, Handler handler, OnConnectListener onConnectListener, int i) {
        handler.postDelayed(new WifiChecker(this, this.context, wifiContext, handler, onConnectListener, i, 0), 1000L);
    }

    public void disable(String str) {
        Logger.logInfo("WifiEnabler: WifiContext DISABLE (applicantId:" + str + ")");
        boolean z = !this.wasEnabledBefore.get() || (this.forceClose.get() && SleepService.isRunningTimely());
        Logger.logInfo("WifiEnabler: should DISABLE: " + z + " (wasBefore: " + this.wasEnabledBefore.get() + ", force: " + this.forceClose.get() + ", sleeping: " + SleepService.isRunningTimely() + ")");
        if (z) {
            disableInternal(str);
        } else {
            unregisterApplicant(str);
        }
    }

    public WifiContext enable(final String str, int i, OnConnectListener onConnectListener) {
        boolean zIsWifiConnected;
        synchronized (this.applicants) {
            try {
                WifiContext wifiContext = new WifiContext() { // from class: com.urbandroid.common.wifi.WifiEnabler.1
                    @Override // com.urbandroid.common.wifi.WifiContext
                    public void disable() {
                        WifiEnabler.this.disable(str);
                    }
                };
                Logger.logInfo("WifiEnabler: ENABLE (applicantId:" + str + ")");
                if (this.applicants.get().isEmpty()) {
                    this.wasEnabledBefore.set(this.wifiManager.isWifiEnabled());
                    Logger.logInfo("WifiEnabler: first ENABLE, wasEnabledBefore " + this.wasEnabledBefore.get() + " (applicantId:" + str + ")");
                } else if (this.wifiManager.isWifiDisabled()) {
                    cleanApplicants();
                }
                if (!SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.CHANGE_WIFI_STATE")) {
                    Logger.logSevere("WifiEnabler: set Wifi ON - missing CHANGE_WIFI_STATE permission");
                    onConnectListener.failed();
                    return wifiContext;
                }
                try {
                    zIsWifiConnected = isWifiConnected();
                } catch (SecurityException e) {
                    unregisterApplicant(str);
                    onConnectListener.failed();
                    Logger.logSevere("WifiEnabler:  Failure enabling wifi", e);
                }
                if (!zIsWifiConnected && Build.VERSION.SDK_INT >= 29) {
                    Logger.logSevere("WifiEnabler: android Q or above - setWifiEnabled deprecated and not working anymore");
                    onConnectListener.failed();
                    return wifiContext;
                }
                registerApplicant(str);
                if (zIsWifiConnected) {
                    Logger.logInfo("WifiEnabler: already ON, (applicantId:" + str + ")");
                    onConnectListener.connected(wifiContext);
                } else {
                    this.wifiManager.setWifiEnabled(true);
                    Logger.logInfo("WifiEnabler: set Wifi ON, (applicantId:" + str + ")");
                    scheduleWifiChecker(wifiContext, new Handler(), onConnectListener, i);
                }
                return wifiContext;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Set<String> getActiveParticipants() {
        HashSet hashSet;
        synchronized (this.applicants) {
            hashSet = new HashSet(this.applicants.get());
        }
        return hashSet;
    }

    public boolean hasActiveParticipants() {
        boolean z;
        synchronized (this.applicants) {
            z = !this.applicants.get().isEmpty();
        }
        return z;
    }

    public boolean isAnyNetworkConnected() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean isWifiConnected() {
        NetworkInfo networkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnected();
    }

    public void setForceClose(boolean z) {
        zza$$ExternalSyntheticOutline0.m("WifiEnabler: setForceClose ", z);
        this.forceClose.set(z);
    }

    public void setForceDisabled() {
        Logger.logInfo("WifiEnabler: EXPLICIT force disable after ");
        this.wasEnabledBefore.set(false);
    }

    public void setKeepEnabled() {
        Logger.logInfo("WifiEnabler: EXPLICIT keep enabled after ");
        this.wasEnabledBefore.set(true);
    }

    public boolean setWifi(Context context, boolean z) {
        Logger.logInfo("WifiEnabler: EXPLICIT setWifi " + logState(z));
        if (hasActiveParticipants()) {
            if (z) {
                setKeepEnabled();
            } else {
                setForceDisabled();
            }
            Logger.logInfo("WifiEnabler: EXPLICIT Wifi not turned " + logState(z) + " due to " + getActiveParticipants() + ", will do this later");
            return true;
        }
        if (!this.wifiManager.isInTargetState(z)) {
            try {
                Logger.logInfo("WifiEnabler: EXPLICIT turn WiFi " + logState(z) + " NOW");
                this.wifiManager.setWifiEnabled(z);
                return true;
            } catch (Exception e) {
                Logger.logInfo("WifiEnabler: EXPLICIT did not turn Wifi " + logState(z));
                Logger.logSevere(e);
            }
        }
        return false;
    }

    public void unregisterApplicant(String str) {
        synchronized (this.applicants) {
            this.applicants.get().remove(str);
            Logger.logInfo("WifiEnabler: unregister, (applicantId:" + str + "), applicants: " + this.applicants.get());
        }
    }

    public class WifiChecker implements Runnable {
        private final Context context;
        private final Handler handler;
        private final int leftSeconds;
        private final OnConnectListener listener;
        private final WifiContext wifiContext;

        private WifiChecker(Context context, WifiContext wifiContext, Handler handler, OnConnectListener onConnectListener, int i) {
            this.context = context;
            this.wifiContext = wifiContext;
            this.leftSeconds = i;
            this.listener = onConnectListener;
            this.handler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zIsWifiConnected = WifiEnabler.this.isWifiConnected();
            if (this.leftSeconds % 10 == 0 || zIsWifiConnected) {
                Logger.logDebug("WifiEnabler: CHECKER Wifi " + WifiEnabler.this.logState(zIsWifiConnected) + " [" + this.listener.hashCode() + "]");
            }
            if (zIsWifiConnected) {
                Logger.logDebug("WifiEnabler: CHECKER Connected, " + WifiEnabler.this.applicants.get() + " [" + this.listener.hashCode() + "]");
                this.listener.connected(this.wifiContext);
                return;
            }
            int i = this.leftSeconds;
            WifiEnabler wifiEnabler = WifiEnabler.this;
            if (i != 0) {
                wifiEnabler.scheduleWifiChecker(this.wifiContext, this.handler, this.listener, i - 1);
                return;
            }
            Logger.logDebug("WifiEnabler: CHECKER Timeout, " + wifiEnabler.applicants.get() + " [" + this.listener.hashCode() + "]");
            if (WifiEnabler.this.isAnyNetworkConnected()) {
                Logger.logDebug("WifiEnabler: Mobile Data connected");
                this.listener.connected(this.wifiContext);
            } else {
                this.listener.timeouted();
                this.wifiContext.disable();
            }
        }

        public /* synthetic */ WifiChecker(WifiEnabler wifiEnabler, Context context, WifiContext wifiContext, Handler handler, OnConnectListener onConnectListener, int i, int i2) {
            this(context, wifiContext, handler, onConnectListener, i);
        }
    }

    public WifiContext enable(Class cls, int i, OnConnectListener onConnectListener) {
        return enable(cls.getSimpleName(), i, onConnectListener);
    }

    public WifiContext enable(Class cls, OnConnectListener onConnectListener) {
        return enable(cls, 15, onConnectListener);
    }
}
