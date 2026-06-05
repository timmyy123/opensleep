package com.urbandroid.sleep.smartwatch.pebble;

import android.content.Context;
import android.content.Intent;
import com.getpebble.android.kit.Constants;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import com.urbandroid.sleep.smartwatch.Wearable;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class PebbleStartReceiver extends AbstractStartSmartwatchReceiver {
    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public String getName() {
        return "Pebble";
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public void handleIntent(Context context, Intent intent, boolean z) {
        if (Constants.INTENT_APP_RECEIVE.equals(intent.getAction())) {
            int intExtra = intent.getIntExtra(Constants.TRANSACTION_ID, -1);
            boolean z2 = SharedApplicationContext.getSettings().getSelectedWearable() == Wearable.REPEBBLE;
            String stringExtra = intent.getStringExtra(Constants.MSG_DATA);
            if (stringExtra == null || stringExtra.isEmpty()) {
                return;
            }
            if (!z && !z2) {
                PebbleKit.sendAckToPebble(context, intExtra);
                return;
            }
            try {
                if (PebbleDictionary.fromJson(stringExtra).getInteger(6) != null) {
                    Logger.logInfo("Pebble requested tracking startup");
                    Intent intent2 = new Intent();
                    intent2.setAction("com.urbandroid.sleep.ACTION_TRACKING_UPDATE_SMARTWATCH");
                    ContextExtKt.sendExplicitBroadcast(context, intent2);
                    if (z2) {
                        SmartWatchProvider.setSmartwatchInstanceIfNotTrackingYet(new RePebble(context.getApplicationContext()));
                    } else {
                        SmartWatchProvider.setSmartwatchInstanceIfNotTrackingYet(new Pebble(context.getApplicationContext()));
                    }
                    if (!SleepService.isRunning()) {
                        if (SharedApplicationContext.getSettings().canStartScreensFromBackground()) {
                            new SleepStarter().startSleep(context);
                        } else {
                            new SleepStarter().startSleepSkipUiButStartManually(context);
                        }
                    }
                }
                if (z2) {
                    return;
                }
                PebbleKit.sendAckToPebble(context, intExtra);
            } catch (Exception e) {
                Logger.logWarning("Pebble start failure.", e);
            }
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public boolean isBlocked() {
        return Pebble.isPebbleStartBlocked();
    }

    @Override // com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver
    public boolean isMessageForSleep(Context context, Intent intent) {
        if (intent.getAction() == null || !intent.getAction().equals(Constants.INTENT_APP_RECEIVE)) {
            return false;
        }
        return Pebble.APP_UUID.equals((UUID) intent.getSerializableExtra("uuid"));
    }
}
