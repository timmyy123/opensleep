package com.urbandroid.sleep.service.invites;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InviteUtils {
    public static void invite(Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", activity.getResources().getString(R.string.app_name_long));
            intent.putExtra("android.intent.extra.TEXT", activity.getResources().getString(R.string.market_text_featured) + "\n\nhttps://play.google.com/store/apps/details?id=com.urbandroid.sleep");
            activity.startActivity(Intent.createChooser(intent, activity.getResources().getString(R.string.invite_friends)));
        } catch (Exception unused) {
            Toast.makeText(activity, R.string.general_unspecified_error, 0).show();
        }
    }
}
