package com.urbandroid.sleep.smartwatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes5.dex */
public class IntentBasedConnectivityChecker {
    private BroadcastReceiver broadcastReceiver;
    private final IConnectivityCallback callback;
    private final Context context;
    private Handler h;
    private final SmartWatch watch;

    public IntentBasedConnectivityChecker(Context context, final IConnectivityCallback iConnectivityCallback, SmartWatch smartWatch, final Runnable runnable, String str, long j, final long j2, long j3) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.watch = smartWatch;
        this.callback = iConnectivityCallback;
        this.h = new Handler();
        this.broadcastReceiver = new ReplyReceiver(this, 0);
        Logger.logInfo("SmartWatch: ConnectivityChecker registering receiver for " + str + " watch " + smartWatch);
        ContextCompat.registerReceiver(applicationContext, this.broadcastReceiver, new IntentFilter(str), 2);
        this.h.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.smartwatch.IntentBasedConnectivityChecker.2
            @Override // java.lang.Runnable
            public void run() {
                IntentBasedConnectivityChecker.this.unregisterReceiver(false);
            }
        }, j);
        Runnable runnable2 = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.IntentBasedConnectivityChecker.3
            @Override // java.lang.Runnable
            public void run() {
                if (IntentBasedConnectivityChecker.this.broadcastReceiver == null) {
                    return;
                }
                if (iConnectivityCallback.isCancelled()) {
                    IntentBasedConnectivityChecker.this.unregisterReceiver(false);
                    return;
                }
                Runnable runnable3 = runnable;
                if (runnable3 != null) {
                    runnable3.run();
                }
                IntentBasedConnectivityChecker.this.h.postDelayed(this, j2);
            }
        };
        Handler handler = this.h;
        if (j3 > 0) {
            handler.postDelayed(runnable2, j3);
        } else {
            handler.post(runnable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterReceiver(boolean z) {
        if (this.broadcastReceiver != null) {
            Logger.logInfo("SmartWatch: ConnectivityChecker STOP " + this.watch + " connected " + z + " this " + hashCode());
            this.context.unregisterReceiver(this.broadcastReceiver);
            this.broadcastReceiver = null;
            this.callback.status(this.watch, z);
        }
    }

    public class ReplyReceiver extends LoggingReceiver {
        private ReplyReceiver() {
        }

        @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            super.onReceive(context, intent);
            Logger.logInfo("SmartWatch: ConnectivityChecker CONNECTED " + intent.getAction() + " Watch type: " + IntentBasedConnectivityChecker.this.watch + " this " + hashCode());
            IntentBasedConnectivityChecker.this.unregisterReceiver(true);
        }

        public /* synthetic */ ReplyReceiver(IntentBasedConnectivityChecker intentBasedConnectivityChecker, int i) {
            this();
        }
    }

    public IntentBasedConnectivityChecker(final Context context, IConnectivityCallback iConnectivityCallback, SmartWatch smartWatch, final String str, String str2, long j, long j2) {
        this(context, iConnectivityCallback, smartWatch, new Runnable() { // from class: com.urbandroid.sleep.smartwatch.IntentBasedConnectivityChecker.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent(str);
                if (Environment.isHoneycombOrGreater()) {
                    intent.addFlags(32);
                }
                ContextExtKt.sendExplicitBroadcast(context, intent, new Settings(context).getEligibleAddonPackages());
            }
        }, str2, j, j2, 0L);
    }
}
