package com.urbandroid.sleep.addon.taskerplugin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.urbandroid.common.util.ComponentUtil;
import com.urbandroid.sleep.addon.taskerplugin.SleepAction;
import com.urbandroid.sleep.addon.taskerplugin.bundle.BundleScrubber;
import com.urbandroid.sleep.addon.taskerplugin.bundle.PluginBundleManager;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class FireReceiver extends BroadcastReceiver {
    public static void setEnabled(Context context, boolean z) {
        ComponentUtil.setEnabled(context, FireReceiver.class, z);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !new Settings(context).isTasker()) {
            return;
        }
        GlobalInitializator.initializeIfRequired(context);
        if (!"com.twofortyfouram.locale.intent.action.FIRE_SETTING".equals(intent.getAction())) {
            Locale locale = Locale.US;
            Log.e("SleepAsAndroid", "Received unexpected Intent action " + intent.getAction());
            return;
        }
        BundleScrubber.scrub(intent);
        Bundle bundleExtra = intent.getBundleExtra("com.twofortyfouram.locale.intent.extra.BUNDLE");
        BundleScrubber.scrub(bundleExtra);
        if (PluginBundleManager.isBundleValid(bundleExtra)) {
            SleepAction sleepActionFindByAction = SleepAction.findByAction(bundleExtra.getString("com.urbandroid.sleep.taskerplugin.extra.EVENT"));
            if (sleepActionFindByAction != null) {
                sleepActionFindByAction.execute(context);
            } else {
                Toast.makeText(context, "Sleep Action not found", 1).show();
            }
        }
    }
}
