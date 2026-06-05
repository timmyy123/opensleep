package com.urbandroid.sleep;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/StartShortcutActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleShortcut", "i", "Landroid/content/Intent;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StartShortcutActivity extends Activity {
    private final void handleShortcut(Intent i) {
        String action;
        if (i == null || Build.VERSION.SDK_INT < 25 || (action = i.getAction()) == null) {
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode == -295445338) {
            if (action.equals("com.urbandroid.sleep.ACTION_START_IDEAL_SLEEP_TRACK_FROM_ACTIVITY")) {
                Context applicationContext = getApplicationContext();
                applicationContext.getClass();
                Intent intentPutExtra = new Intent("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK_WITH_IDEAL_ALARM_ACTION").putExtra("SKIP_UI", false);
                intentPutExtra.getClass();
                ContextExtKt.sendExplicitBroadcast$default(applicationContext, intentPutExtra, null, 2, null);
                return;
            }
            return;
        }
        if (iHashCode != -275462383) {
            if (iHashCode == 1634982448 && action.equals("com.urbandroid.sleep.ACTION_START_SLEEP_TRACK_FROM_ACTIVITY")) {
                new SleepStarter().startSleep(getApplicationContext());
                return;
            }
            return;
        }
        if (action.equals("com.urbandroid.sleep.ACTION_START_NAP1_FROM_ACTIVITY")) {
            int intExtra = i.getIntExtra("minutes", 15);
            Alarms.addQuickAlarm(getApplicationContext(), intExtra, FileInsert$$ExternalSyntheticOutline0.m$1(getResources().getString(R.string.nap_alarm_label), " ", DateUtil.formatMinutes(Integer.valueOf(intExtra))), true);
            new SleepStarter().startSleep(getApplicationContext());
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        handleShortcut(getIntent());
        finish();
    }
}
