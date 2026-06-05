package com.urbandroid.sleep.smartwatch.garmin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.Wearable;

/* JADX INFO: loaded from: classes5.dex */
public class GarminReceiver extends BroadcastReceiver {
    private boolean sleepInstalled = true;

    private void startCommServicesBecauseWatchSaidSo(Context context) {
        startProviderServiceBecauseWatchSaidSo(context);
        Intent intent = new Intent("com.urbandroid.sleep.watch.STARTED_ON_WATCH");
        intent.setPackage("com.urbandroid.sleep");
        context.sendBroadcast(intent);
    }

    private void startProviderServiceBecauseWatchSaidSo(Context context) {
        Logger.logInfo("Garmin: Receiver:  ConnectIQ intent received, starting provider service...");
        Utils.startForegroundService(context, new Intent(context, (Class<?>) GarminProviderService.class));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9 A[PHI: r16
      0x00b9: PHI (r16v12 byte) = 
      (r16v0 byte)
      (r16v0 byte)
      (r16v0 byte)
      (r16v0 byte)
      (r16v3 byte)
      (r16v0 byte)
      (r16v4 byte)
      (r16v0 byte)
      (r16v5 byte)
      (r16v0 byte)
      (r16v6 byte)
      (r16v0 byte)
      (r16v7 byte)
      (r16v0 byte)
      (r16v8 byte)
      (r16v0 byte)
      (r16v9 byte)
      (r16v0 byte)
      (r16v10 byte)
     binds: [B:28:0x00b6, B:67:0x011d, B:63:0x0112, B:59:0x0108, B:61:0x010b, B:55:0x00fe, B:57:0x0101, B:51:0x00f4, B:53:0x00f7, B:47:0x00ea, B:49:0x00ed, B:43:0x00e0, B:45:0x00e3, B:39:0x00d6, B:41:0x00d9, B:35:0x00cc, B:37:0x00cf, B:31:0x00c2, B:33:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String str;
        Logger.logInfo("Garmin: Receiver:  onReceive: " + intent.getAction());
        GlobalInitializator.initializeIfRequired(context);
        if (new Settings(context).isWearableSelected(Wearable.ADDON_URBANDROID_GARMIN)) {
            try {
                if ("com.garmin.android.connectiq.INCOMING_MESSAGE".equals(intent.getAction()) && !GarminProviderService.RUNNING.booleanValue() && intent.hasExtra("com.garmin.android.connectiq.EXTRA_APPLICATION_ID") && ("1FC99D3F06FE4B02BBABD497CB05874B".equals(intent.getStringExtra("com.garmin.android.connectiq.EXTRA_APPLICATION_ID")) || "21CAD9617B914811B0B27EA6240DE29B".equals(intent.getStringExtra("com.garmin.android.connectiq.EXTRA_APPLICATION_ID")))) {
                    if (!GarminProviderService.RUNNING.booleanValue()) {
                        startCommServicesBecauseWatchSaidSo(context);
                    }
                }
            } catch (IllegalArgumentException e) {
                Logger.logInfo("Garmin: Receiver: ", e);
            }
            Logger.logInfo("Garmin: Receiver intent: " + intent.getAction().toString());
            String action = intent.getAction() != null ? intent.getAction() : "";
            Boolean bool = GarminProviderService.RUNNING;
            action.getClass();
            byte b = -1;
            switch (action.hashCode()) {
                case -1934775263:
                    if (!action.equals("com.urbandroid.sleep.watch.START_TRACKING")) {
                        str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    } else {
                        str = "com.urbandroid.sleep.watch.STOP_ALARM";
                        b = 0;
                    }
                    break;
                case -1921058751:
                    if (action.equals("com.urbandroid.sleep.watch.STOP_ALARM")) {
                        str = "com.urbandroid.sleep.watch.STOP_ALARM";
                        b = 1;
                        break;
                    }
                    break;
                case -1854596123:
                    if (action.equals("com.urbandroid.sleep.watch.CHECK_CONNECTED")) {
                        b = 2;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
                case -1021645561:
                    if (action.equals("com.urbandroid.sleep.watch.START_ALARM")) {
                        b = 3;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
                case -291818132:
                    if (action.equals("com.urbandroid.sleep.watch.SET_PAUSE")) {
                        b = 4;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
                case -52158809:
                    if (action.equals("com.urbandroid.sleep.watch.STOP_TRACKING")) {
                        b = 5;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
                case -34004780:
                    if (action.equals("com.urbandroid.sleep.watch.HINT")) {
                        b = 6;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
                case 463493168:
                    if (action.equals("com.urbandroid.sleep.watch.SET_BATCH_SIZE")) {
                        b = 7;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
                case 865944712:
                    if (action.equals("com.urbandroid.sleep.watch.UPDATE_ALARM")) {
                        b = 8;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
                case 1963799617:
                    if (action.equals("com.urbandroid.sleep.watch.REPORT")) {
                        b = 9;
                    }
                    str = "com.urbandroid.sleep.watch.STOP_ALARM";
                    break;
            }
            switch (b) {
                case 0:
                    Intent intent2 = new Intent(context, (Class<?>) GarminProviderService.class);
                    intent2.setAction("com.urbandroid.sleep.watch.START_TRACKING");
                    if (intent.hasExtra("DO_HR_MONITORING")) {
                        intent2.putExtra("DO_HR_MONITORING", true);
                    }
                    Utils.startForegroundService(context, intent2);
                    break;
                case 1:
                    if (bool.booleanValue()) {
                        Intent intent3 = new Intent(context, (Class<?>) GarminProviderService.class);
                        intent3.setAction(str);
                        Utils.startForegroundService(context, intent3);
                    }
                    break;
                case 2:
                    Logger.logDebug("Garmin: Receiver: Check connected");
                    Intent intent4 = new Intent(context, (Class<?>) GarminProviderService.class);
                    intent4.setAction("com.urbandroid.sleep.watch.CHECK_CONNECTED");
                    Utils.startForegroundService(context, intent4);
                    break;
                case 3:
                    if (bool.booleanValue()) {
                        Intent intent5 = new Intent(context, (Class<?>) GarminProviderService.class);
                        intent5.putExtra("DELAY", intent.getIntExtra("DELAY", 0));
                        intent5.setAction("com.urbandroid.sleep.watch.START_ALARM");
                        Utils.startForegroundService(context, intent5);
                    }
                    break;
                case 4:
                    if (bool.booleanValue()) {
                        Intent intent6 = new Intent(context, (Class<?>) GarminProviderService.class);
                        intent6.setAction("com.urbandroid.sleep.watch.SET_PAUSE");
                        intent6.putExtra("TIMESTAMP", intent.getLongExtra("TIMESTAMP", 0L));
                        Utils.startForegroundService(context, intent6);
                    }
                    break;
                case 5:
                    Logger.logInfo("Garmin: Received stop watch app, service running? " + bool);
                    if (bool.booleanValue()) {
                        Intent intent7 = new Intent(context, (Class<?>) GarminProviderService.class);
                        intent7.setAction("com.urbandroid.sleep.watch.STOP_TRACKING");
                        Utils.startForegroundService(context, intent7);
                    }
                    break;
                case 6:
                    if (bool.booleanValue()) {
                        Intent intent8 = new Intent(context, (Class<?>) GarminProviderService.class);
                        intent8.setAction("com.urbandroid.sleep.watch.HINT");
                        intent8.putExtra("REPEAT", Utils.getLongOrIntExtraAsLong(intent, "REPEAT", 0L));
                        Utils.startForegroundService(context, intent8);
                    }
                    break;
                case 7:
                    if (bool.booleanValue()) {
                        Intent intent9 = new Intent(context, (Class<?>) GarminProviderService.class);
                        intent9.setAction("com.urbandroid.sleep.watch.SET_BATCH_SIZE");
                        intent9.putExtra("SIZE", intent.getLongExtra("SIZE", 0L));
                        Utils.startForegroundService(context, intent9);
                    }
                    break;
                case 8:
                    if (bool.booleanValue()) {
                        Intent intent10 = new Intent(context, (Class<?>) GarminProviderService.class);
                        intent10.setAction("com.urbandroid.sleep.watch.UPDATE_ALARM");
                        intent10.putExtra("TIMESTAMP", intent.getLongExtra("TIMESTAMP", 0L));
                        Utils.startForegroundService(context, intent10);
                    }
                    break;
                case 9:
                    Logger.logInfo("Generating on demand report");
                    Logger.logInfo(context.getPackageName());
                    ErrorReporter.getInstance().generateOnDemandReport(null, "Manual report", intent.hasExtra("USER_COMMENT") ? intent.getStringExtra("USER_COMMENT") : "No comment");
                    break;
            }
        }
    }
}
