package com.urbandroid.sleep.mic;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.sleep.smartlight.SmartLightProvider;

/* JADX INFO: loaded from: classes4.dex */
public class SnoringReceiver extends LoggingReceiver {
    public static final String ANTISNORING_ACTION = "com.urbandroid.sleep.ANTISNORING_ACTION";

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SmartLight smartLight;
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        Settings settings = new Settings(context);
        Handler handler = new Handler();
        if (!settings.isRecordingMasterSwitchEnabled() || settings.getRecordingAntisnoreResponse() <= 0) {
            return;
        }
        if (settings.isAntiSnoringNotification()) {
            Alarms.showAntiSnoringNotification(context, handler, settings.getAntiSnoringLoop());
        } else {
            new AntiSnorer(context, false).performResponse();
        }
        if (settings.isSmartlightEnabled() && settings.isSmartLightAntiSnoring() && (smartLight = SmartLightProvider.getSmartLight(context)) != null) {
            Logger.logInfo("Antisnoring: smartlight");
            smartLight.hint(3);
        }
    }
}
