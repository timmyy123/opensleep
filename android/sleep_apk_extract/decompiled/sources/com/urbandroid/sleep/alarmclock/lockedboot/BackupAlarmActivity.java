package com.urbandroid.sleep.alarmclock.lockedboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.KeyguardUtil;

/* JADX INFO: loaded from: classes4.dex */
public class BackupAlarmActivity extends BaseActivity {
    private BroadcastReceiver stopReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.lockedboot.BackupAlarmActivity.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i("SleepAsAndroidDB", "STOP");
            BackupAlarmActivity.this.finish();
        }
    };

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_backup_alarm);
        getWindow().addFlags(2097280);
        KeyguardUtil.disable(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_PRESENT");
        intentFilter.addAction("stop");
        ContextCompat.registerReceiver(this, this.stopReceiver, intentFilter, 2);
        findViewById(R.id.dismiss).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.lockedboot.BackupAlarmActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScreenUnlockActivity.start(BackupAlarmActivity.this);
            }
        });
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.stopReceiver);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (KeyguardUtil.isKeyguard(this)) {
            return;
        }
        finish();
    }
}
