package com.urbandroid.common.wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.urbandroid.common.logging.Logger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class WifiManagerWrapper {
    private WifiManager wifiManager;
    private AtomicReference<WifiState> state = new AtomicReference<>(WifiState.OTHER);
    private Handler h = new Handler();

    public enum WifiState {
        ENABLED,
        DISABLED,
        OTHER
    }

    public WifiManagerWrapper(Context context) {
        this.wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isInTargetState(boolean z) {
        boolean z2;
        if (!isWifiEnabled() || !z) {
            z2 = isWifiDisabled() && !z;
        }
        return z2;
    }

    public synchronized boolean isWifiDisabled() {
        if (this.state.get() == WifiState.OTHER) {
            return this.wifiManager.getWifiState() == 0 || this.wifiManager.getWifiState() == 1;
        }
        return this.state.get() == WifiState.DISABLED;
    }

    public synchronized boolean isWifiEnabled() {
        if (this.state.get() == WifiState.OTHER) {
            return this.wifiManager.getWifiState() == 2 || this.wifiManager.getWifiState() == 3;
        }
        return this.state.get() == WifiState.ENABLED;
    }

    public synchronized void setWifiEnabled(boolean z) {
        try {
            Logger.logInfo("WifiEnabler: WifiManager SET Wifi ".concat(z ? "ON" : "OFF"));
            try {
                this.wifiManager.setWifiEnabled(z);
            } catch (NullPointerException e) {
                Logger.logSevere(e);
            }
            this.state.set(z ? WifiState.ENABLED : WifiState.DISABLED);
            this.h.post(new Runnable() { // from class: com.urbandroid.common.wifi.WifiManagerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    WifiManagerWrapper.this.state.set(WifiState.OTHER);
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }
}
