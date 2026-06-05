package com.urbandroid.sleep;

import android.content.Intent;
import android.os.Bundle;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.SleepStarter;

/* JADX INFO: loaded from: classes4.dex */
public class SleepTrackStartHelperActivity extends BaseActivity {
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        if (getIntent() == null || !"CompletedActionStatus".equals(getIntent().getStringExtra("actionStatus"))) {
            new SleepStarter().startSleep(getApplicationContext());
            finish();
        } else {
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"));
            finish();
        }
    }
}
