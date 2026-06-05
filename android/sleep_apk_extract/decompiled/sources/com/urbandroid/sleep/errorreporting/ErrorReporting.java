package com.urbandroid.sleep.errorreporting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.Wearable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ErrorReporting {
    public static void reportWearableThroughAddonActivity(Context context, String str) {
        Wearable selectedWearable = new Settings(context).getSelectedWearable();
        String str2 = selectedWearable != null ? selectedWearable.addonPackageName : null;
        if (str2 == null) {
            reportWearableThroughBroadcast(context, str);
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, str2.concat(".ErrorReportActivity")));
        if (str != null) {
            intent.putExtra("USER_COMMENT", str);
        }
        intent.addFlags(32);
        context.startActivity(intent);
    }

    public static void reportWearableThroughBroadcast(Context context, String str) {
        Intent intent = new Intent("com.urbandroid.sleep.watch.REPORT");
        if (str != null) {
            intent.putExtra("USER_COMMENT", str);
        }
        intent.addFlags(32);
        ContextExtKt.sendExplicitBroadcast(context.getApplicationContext(), intent, new Settings(context).getEligibleAddonPackages());
    }
}
