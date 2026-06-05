package com.urbandroid.sleep.lucid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;

/* JADX INFO: loaded from: classes4.dex */
public class LucidReceiver extends LoggingReceiver {
    private LucidPlayer player = new LucidPlayer();

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SmartLight smartLight;
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        Settings settings = new Settings(context);
        int lucidLoop = settings.getLucidLoop();
        if (settings.getLucidEnabled()) {
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(lucidLoop, "LucidReceiver: Lucid dreaming ", " vibrate ");
            sbM65m.append(settings.isLucidVibrate());
            Logger.logInfo(sbM65m.toString());
            Context applicationContext = context.getApplicationContext();
            if ("com.urbandroid.sleep.alarmclock.ALARM_DONE".equals(intent.getAction()) || "com.urbandroid.sleep.alarmclock.alarm_killed".equals(intent.getAction())) {
                Logger.logInfo("LucidReceiver: DeepSleepreceiver - Alarm Done");
                this.player.resume();
                return;
            }
            if ("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START_INTERNAL".equals(intent.getAction())) {
                Logger.logInfo("LucidReceiver: DeepSleepreceiver - Alarm Start");
                this.player.suspend();
                return;
            }
            try {
                this.player.play(applicationContext, !settings.isHintHeadphonesOnly() ? 4 : 3, settings.getLucidVolume(), Uri.parse(settings.getLucidRingtone()), lucidLoop);
                Logger.logInfo("LucidReceiver: playing " + settings.getLucidRingtone());
                if (settings.isLucidVibrate()) {
                    SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(context);
                    Logger.logInfo("LucidReceiver: smartwatch " + smartWatch);
                    if (smartWatch != null) {
                        Logger.logInfo("LucidReceiver: vibrate smartwatch");
                        smartWatch.hint(lucidLoop);
                    } else {
                        int i = lucidLoop * 2;
                        long[] jArr = new long[i];
                        for (int i2 = 0; i2 < i; i2 += 2) {
                            jArr[i2] = 3000;
                            jArr[i2 + 1] = 500;
                        }
                        Logger.logInfo("LucidReceiver: vibrate phone");
                        ((Vibrator) context.getSystemService("vibrator")).vibrate(jArr, -1);
                    }
                }
                if (settings.isSmartlightEnabled() && settings.isSmartLightLucidDreaming() && (smartLight = SmartLightProvider.getSmartLight(context)) != null) {
                    Logger.logInfo("LucidReceiver: Lucid dreaming smartlight");
                    smartLight.hint(lucidLoop);
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }
}
