package com.urbandroid.util;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.MiscSettingsActivity;
import com.urbandroid.sleep.service.Settings;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class TtsService extends ForegroundService {
    private static String lastText = null;
    private static long lastTextTs = -1;

    public TtsService() {
        super("servicesChannel", 3893);
    }

    private static boolean didAlreadySayThis(String str) {
        return lastText != null && System.currentTimeMillis() - lastTextTs <= 360000 && lastText.equals(str);
    }

    public static void speak(Context context, int i, String str, String str2, float f, int i2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Logger.logInfo("TTS: DND=" + notificationManager.getCurrentInterruptionFilter() + " stream " + i2);
        if (i2 == -1 && notificationManager.getCurrentInterruptionFilter() >= 2) {
            Logger.logInfo("TTS: not speaking, DND=" + notificationManager.getCurrentInterruptionFilter());
            return;
        }
        if (i2 == 3 && notificationManager.getCurrentInterruptionFilter() == 3) {
            Logger.logInfo("TTS: not speaking MUSIC, DND=" + notificationManager.getCurrentInterruptionFilter());
            return;
        }
        if (i2 == 4) {
            Logger.logInfo("TTS: speak in alarm, DND=" + notificationManager.getCurrentInterruptionFilter());
        }
        if (str2 == null || didAlreadySayThis(str2)) {
            Logger.logInfo("TTS: ignoring same text " + lastText + " ts " + lastTextTs);
            return;
        }
        if (new Settings(context).isTextToSpeech()) {
            Logger.logInfo("TTS: start service, res " + i + " text, '" + str2 + "'");
            Intent intent = new Intent(context, (Class<?>) TtsService.class);
            intent.putExtra("extra_res", i);
            intent.putExtra("extra_param", str);
            intent.putExtra("extra_text", str2);
            intent.putExtra("extra_vol", f);
            intent.putExtra("extra_stream", i2);
            ContextExtKt.startForegroundServiceWithLog(context, intent);
            lastText = str2;
            lastTextTs = System.currentTimeMillis();
        }
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.urbandroid.common.ForegroundService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.urbandroid.common.ForegroundService, com.urbandroid.common.LoggingService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Intent intent2 = new Intent(this, (Class<?>) MiscSettingsActivity.class);
        intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("extra_text");
            int intExtra = intent.getIntExtra("extra_res", -1);
            String stringExtra2 = intent.getStringExtra("extra_param");
            float floatExtra = intent.getFloatExtra("extra_vol", 0.7f);
            int intExtra2 = intent.getIntExtra("extra_stream", -1);
            NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "servicesChannel").setContentIntent(PendingIntentBuilder.get(this, 3893, intent2, 0).getActivity()).setColor(ColorUtil.i(this, R.color.tint_notification)).setContentTitle(getString(R.string.text_to_speech_title)).setContentText(intExtra > 0 ? getResources().getString(intExtra) : intent.getStringExtra("android.intent.extra.TEXT"));
            contentText.setSmallIcon(R.drawable.ic_action_talk_white);
            startForegroundOnce(contentText.build());
            Logger.logInfo("TTS: service start, text '" + stringExtra + "', res " + intExtra + " vol " + floatExtra);
            if (intExtra != -1) {
                new TtsUtil().speak(getApplicationContext(), intExtra, stringExtra2, floatExtra, intExtra2);
            } else if (stringExtra != null && stringExtra.length() > 0) {
                new TtsUtil().speak(getApplicationContext(), stringExtra, floatExtra, intExtra2);
            }
        }
        stopSelf();
        return 2;
    }

    public static void speak(Context context, int i, String str) {
        speak(context, i, str, (String) null);
    }

    public static void speak(Context context, int i, float f) {
        speak(context, i, null, null, f, -1);
    }

    public static void speak(Context context, String str) {
        speak(context, -1, (String) null, str);
    }

    public static void speak(Context context, String str, float f, int i) {
        speak(context, -1, null, str, f, i);
    }

    public static void speak(Context context, int i, String str, String str2) {
        speak(context, i, str, str2, 0.7f, -1);
    }

    public static void speak(Context context, int i) {
        speak(context, i, (String) null, (String) null);
    }
}
