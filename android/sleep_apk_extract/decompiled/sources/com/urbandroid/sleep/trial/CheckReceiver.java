package com.urbandroid.sleep.trial;

import android.content.Context;
import android.content.Intent;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class CheckReceiver extends LoggingReceiver {
    private static boolean alreadyChecked = false;

    public static boolean isAlreadyChecked() {
        return alreadyChecked;
    }

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        alreadyChecked = true;
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        int intExtra = intent.getIntExtra("res", 0);
        zza$$ExternalSyntheticOutline0.m(intExtra, "CheckResult: ");
        if (intExtra > 0) {
            new Settings(context).setLicenseChecker(intExtra);
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setPlainEvent("License_verification_" + intExtra);
        }
    }
}
