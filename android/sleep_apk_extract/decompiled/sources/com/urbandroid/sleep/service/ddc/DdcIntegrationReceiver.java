package com.urbandroid.sleep.service.ddc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;

/* JADX INFO: loaded from: classes4.dex */
public class DdcIntegrationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT".equals(intent.getAction()) && TrialFilter.getInstance().isDdc()) {
            GlobalInitializator.initializeIfRequired(context);
            Logger.logInfo("DDC forwarding bedtime");
            Intent intent2 = new Intent("com.urbandroid.sleep.alarmclock.TIME_TO_BED_ALARM_ALERT");
            intent2.setPackage("com.urbandroid.ddc");
            context.sendBroadcast(intent2);
        }
    }
}
