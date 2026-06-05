package com.urbandroid.common.headset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.VolumeUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class HeadsetPlugChecker {
    private final Context context;
    private final AtomicReference<BroadcastReceiver> receiver = new AtomicReference<>();
    private final AtomicBoolean headset = new AtomicBoolean(false);

    public interface Listener {
        void headsetPlugged();

        void headsetUnplugged();
    }

    private HeadsetPlugChecker(Context context) {
        this.context = context;
    }

    public static HeadsetPlugChecker from(Context context) {
        return new HeadsetPlugChecker(context);
    }

    public synchronized void close() {
        if (this.receiver.get() != null) {
            try {
                this.context.unregisterReceiver(this.receiver.get());
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    public boolean isPlugged() {
        return this.headset.get();
    }

    public synchronized HeadsetPlugChecker start(final Listener listener) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        this.receiver.set(new BroadcastReceiver() { // from class: com.urbandroid.common.headset.HeadsetPlugChecker.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null && "android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    boolean z = false;
                    boolean z2 = VolumeUtil.getHeadsetState(context) > 0;
                    if (Experiments.getInstance().isUserWithHeadphonesProblems()) {
                        Logger.logInfo("User with headset problems ");
                    } else {
                        z = z2;
                    }
                    if (HeadsetPlugChecker.this.headset.get() != z) {
                        Listener listener2 = listener;
                        if (z) {
                            listener2.headsetPlugged();
                        } else {
                            listener2.headsetUnplugged();
                        }
                        HeadsetPlugChecker.this.headset.set(z);
                        Logger.logInfo("Headset update " + z);
                    }
                }
            }
        });
        ContextCompat.registerReceiver(this.context, this.receiver.get(), intentFilter, 2);
        return this;
    }
}
