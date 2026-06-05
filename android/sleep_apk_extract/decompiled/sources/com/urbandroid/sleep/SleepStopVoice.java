package com.urbandroid.sleep;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.RatingActivity;

/* JADX INFO: loaded from: classes4.dex */
public class SleepStopVoice extends BaseActivity {
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(getApplicationContext());
        setContentView(R.layout.activity_sleep_stop_voice);
        RatingActivity.initNextAlarmDismiss(this, (ViewGroup) findViewById(R.id.root));
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        Alarm alarmCalculateNextAlert = Alarms.calculateNextAlert(getApplicationContext());
        if (!isVoiceInteraction() || alarmCalculateNextAlert == null || alarmCalculateNextAlert.time - System.currentTimeMillis() >= 14400000) {
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"));
            finish();
        } else {
            Logger.logInfo("VOICE: Is voice interaction ");
            getVoiceInteractor().submitRequest(new VoiceInteractor.ConfirmationRequest(new VoiceInteractor.Prompt(getString(R.string.voice_interaction_stop_confirm, DateUtil.formatTime(getApplicationContext(), alarmCalculateNextAlert.time))), null) { // from class: com.urbandroid.sleep.SleepStopVoice.1
                @Override // android.app.VoiceInteractor.ConfirmationRequest
                public void onConfirmationResult(boolean z, Bundle bundle2) {
                    zza$$ExternalSyntheticOutline0.m(SleepStopVoice.this.getApplicationContext(), "com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK");
                    if (z) {
                        Alarms.skipNextAlarm(SleepStopVoice.this.getApplicationContext(), Alarms.calculateNextAlert(SleepStopVoice.this.getApplicationContext()));
                    }
                    SleepStopVoice.this.finish();
                }
            });
        }
    }
}
