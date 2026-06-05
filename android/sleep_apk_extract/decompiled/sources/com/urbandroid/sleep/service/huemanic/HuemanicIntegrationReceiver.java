package com.urbandroid.sleep.service.huemanic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;

/* JADX INFO: loaded from: classes4.dex */
public class HuemanicIntegrationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK".equals(intent.getAction()) && TrialFilter.getInstance().isHuemanic()) {
            GlobalInitializator.initializeIfRequired(context);
            Logger.logInfo("Humanic intent " + intent.getAction());
            Intent intent2 = new Intent("com.urbandroid.sleep.ACTION_LULLABY_STOP_PLAYBACK");
            intent2.setPackage("com.urbandroid.hue");
            context.sendBroadcast(intent2);
        }
    }
}
