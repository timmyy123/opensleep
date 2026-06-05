package com.urbandroid.sleep.trial;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock;

/* JADX INFO: loaded from: classes4.dex */
public class PremiumCloudReceiver extends LoggingReceiver {
    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (action.equals("com.urbandroid.sleep.SCP")) {
            Intent intent2 = new Intent(context, (Class<?>) AlarmClock.class);
            intent2.putExtra("com.urbandroid.sleep.START_CLOUD_PURCHASE", true);
            intent2.setFlags(268566528);
            context.startActivity(intent2);
            return;
        }
        if (action.equals("com.urbandroid.sleep.CCP")) {
            long cloudTimestamp = TrialFilter.getCloudTimestamp(context);
            Intent intent3 = new Intent("com.urbandroid.sleep.addon.port.backup.StatusCheck");
            intent3.putExtra("TS", cloudTimestamp);
            ContextExtKt.sendExplicitBroadcast(context, intent3);
        }
    }
}
