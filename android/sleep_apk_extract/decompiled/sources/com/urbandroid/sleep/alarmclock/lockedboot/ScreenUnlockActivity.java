package com.urbandroid.sleep.alarmclock.lockedboot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.KeyguardUtil;

/* JADX INFO: loaded from: classes4.dex */
public class ScreenUnlockActivity extends BaseActivity {
    public static void start(Context context) {
        context.startActivity(new Intent(context, (Class<?>) ScreenUnlockActivity.class));
    }

    public static void startBackup(Context context) {
        context.startActivity(new Intent(context, (Class<?>) BackupAlarmActivity.class));
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_backup_alarm_unlock);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (KeyguardUtil.isKeyguard(this)) {
            return;
        }
        startBackup(this);
        finish();
    }
}
