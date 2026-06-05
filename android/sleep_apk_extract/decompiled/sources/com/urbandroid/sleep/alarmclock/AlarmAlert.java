package com.urbandroid.sleep.alarmclock;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmAlert extends AlarmAlertFullScreen {
    private int mKeyguardRetryCount;
    private final int MAX_KEYGUARD_CHECKS = 5;
    private final Handler mHandler = new Handler() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlert.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AlarmAlert.this.handleScreenOff((KeyguardManager) message.obj);
        }
    };
    private final BroadcastReceiver mScreenOffReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.alarmclock.AlarmAlert.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AlarmAlert.this.handleScreenOff((KeyguardManager) context.getSystemService("keyguard"));
        }
    };

    private boolean checkRetryCount() {
        Logger.logDebug("Key guard check count: " + this.mKeyguardRetryCount);
        int i = this.mKeyguardRetryCount;
        this.mKeyguardRetryCount = i + 1;
        if (i < 5) {
            return true;
        }
        Logger.logSevere("Tried to read keyguard status too many times, bailing...");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScreenOff(KeyguardManager keyguardManager) {
        if (AlarmKlaxon.restartRequested) {
            Logger.logInfo("Do not force full screen. It can negatively interact with restarting");
            return;
        }
        if (!keyguardManager.inKeyguardRestrictedInputMode() && checkRetryCount()) {
            Logger.logDebug("NOT Going to launch full screen version");
            if (checkRetryCount()) {
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(0, keyguardManager), 500L);
                return;
            }
            return;
        }
        if (isCaptchaInProgress()) {
            return;
        }
        Logger.logDebug("Going to launch full screen version");
        Intent intent = new Intent(this, (Class<?>) AlarmAlertFullScreen.class);
        intent.putExtra("intent.extra.alarm", (Serializable) this.alarm);
        intent.putExtra("screen_off", true);
        intent.putExtra("CREATION_SOURCE", "AlarmAlert-FullScreenRestart");
        startActivity(intent);
        finish();
    }

    @Override // com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen, androidx.view.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.logDebug("Creating AlarmAlert non-full screen dialog");
        ContextCompat.registerReceiver(this, this.mScreenOffReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"), 2);
    }

    @Override // com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mScreenOffReceiver);
        this.mHandler.removeMessages(0);
    }
}
