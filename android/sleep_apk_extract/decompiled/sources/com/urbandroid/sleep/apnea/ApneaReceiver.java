package com.urbandroid.sleep.apnea;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.lucid.LucidPlayer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;

/* JADX INFO: loaded from: classes4.dex */
public class ApneaReceiver extends LoggingReceiver {
    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SmartLight smartLight;
        super.onReceive(context, intent);
        Logger.logInfo("ApneaReceiver: onReceive");
        Settings settings = new Settings(context);
        if (settings.isOximeterAlarm()) {
            GlobalInitializator.initializeIfRequired(context);
            new LucidPlayer().play(context, !SharedApplicationContext.getSettings().isHintHeadphonesOnly() ? 4 : 3, 100, Uri.parse(settings.getApneaAlarmRingtone()), 1);
            int apneaAlarmRepeat = settings.getApneaAlarmRepeat();
            if (apneaAlarmRepeat > 0) {
                int i = apneaAlarmRepeat * 2;
                long[] jArr = new long[i];
                for (int i2 = 0; i2 < i; i2 += 2) {
                    jArr[i2] = 300;
                    jArr[i2 + 1] = 300;
                }
                Logger.logInfo("ApneaReceiver: vibrate()");
                ((Vibrator) context.getSystemService("vibrator")).vibrate(jArr, -1);
            }
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(context);
            if (smartWatch != null) {
                Logger.logInfo("ApneaReceiver: smartwatch");
                smartWatch.hint(apneaAlarmRepeat);
            }
            if (settings.isSmartlightEnabled() && settings.isSmartLightLucidDreaming() && (smartLight = SmartLightProvider.getSmartLight(context)) != null) {
                Logger.logInfo("ApneaReceiver: smartlight");
                smartLight.hint(apneaAlarmRepeat);
            }
        }
    }
}
