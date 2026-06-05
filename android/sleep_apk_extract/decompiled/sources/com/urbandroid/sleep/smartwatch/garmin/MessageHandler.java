package com.urbandroid.sleep.smartwatch.garmin;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQApp;
import com.garmin.android.connectiq.IQDevice;
import com.urbandroid.common.logging.Logger;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
class MessageHandler {
    private static final MessageHandler ourInstance = new MessageHandler();
    private float[] maxFloatValues = null;
    private float[] maxRawFloatValues = null;
    private Boolean launchAppPromptAlreadyShownInCurrentSession = Boolean.FALSE;
    private long watchAppOpenTime = -1;
    private QueueToWatch queueToWatch = QueueToWatch.getInstance();

    private MessageHandler() {
    }

    public static MessageHandler getInstance() {
        return ourInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMessageFromSleep$0(Context context, IQDevice iQDevice, IQApp iQApp, ConnectIQ.IQOpenApplicationStatus iQOpenApplicationStatus) {
        Logger.logDebug("Garmin: MessageHandler onOpenAppOnWatch response: " + iQOpenApplicationStatus);
        if (iQOpenApplicationStatus == ConnectIQ.IQOpenApplicationStatus.PROMPT_NOT_SHOWN_ON_DEVICE || iQOpenApplicationStatus == ConnectIQ.IQOpenApplicationStatus.UNKNOWN_FAILURE) {
            this.launchAppPromptAlreadyShownInCurrentSession = Boolean.FALSE;
        }
        if (iQOpenApplicationStatus.equals(ConnectIQ.IQOpenApplicationStatus.APP_IS_ALREADY_RUNNING)) {
            Logger.logDebug("Garmin: MessageHandler  app is running " + iQOpenApplicationStatus);
            sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.STARTED_ON_WATCH"), context);
            sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.CONFIRM_CONNECTED"), context);
        }
    }

    public static void sendExplicitBroadcastToSleep(Intent intent, Context context) {
        intent.setPackage("com.urbandroid.sleep");
        context.sendBroadcast(intent);
    }

    public void handleMessageFromSleep(Intent intent, Context context) {
        String action = intent != null ? intent.getAction() : "";
        String str = action != null ? action : "";
        if (str.equals("com.urbandroid.sleep.watch.START_TRACKING")) {
            Logger.logDebug("Garmin: MessageHandler START_WATCH_APP");
            Utils.dumpIntent(intent);
            if (intent.hasExtra("DO_HR_MONITORING")) {
                this.queueToWatch.enqueue(new MessageToWatch("StartHRTracking"));
                Logger.logInfo("Garmin: MessageHandler TO_WATCH_TRACKING_START_HR");
            }
            if (intent.hasExtra("DO_OXIMETER_MONITORING")) {
                this.queueToWatch.enqueue(new MessageToWatch("StartOxiTracking"));
                Logger.logInfo("Garmin: MessageHandler TO_WATCH_TRACKING_START_OXI");
            }
            this.queueToWatch.enqueue(new MessageToWatch("StartTracking"));
            Logger.logDebug("Garmin: MessageHandler TO_WATCH_TRACKING_START");
        }
        if (str.equals("com.urbandroid.sleep.watch.STOP_TRACKING")) {
            Logger.logDebug("Garmin: MessageHandler TO_WATCH_STOP");
            this.queueToWatch.emptyQueue();
            this.queueToWatch.enqueue(new MessageToWatch("StopApp"));
        }
        if (str.equals("com.urbandroid.sleep.watch.SET_PAUSE")) {
            long longExtra = intent.getLongExtra("TIMESTAMP", 0L);
            Logger.logDebug("Garmin: MessageHandler TO_WATCH_PAUSE " + longExtra);
            this.queueToWatch.enqueue(new MessageToWatch("Pause", Long.valueOf(longExtra)));
        }
        if (str.equals("com.urbandroid.sleep.watch.SET_BATCH_SIZE")) {
            long longExtra2 = intent.getLongExtra("SIZE", 0L);
            Logger.logDebug("Garmin: MessageHandler TO_WATCH_BATCH_SIZE " + longExtra2);
            this.queueToWatch.enqueue(new MessageToWatch("BatchSize", Long.valueOf(longExtra2)));
        }
        if (str.equals("com.urbandroid.sleep.watch.START_ALARM")) {
            long intExtra = intent.getIntExtra("DELAY", 0);
            Logger.logDebug("Garmin: MessageHandler TO_WATCH_ALARM_START, delay " + intExtra);
            this.queueToWatch.enqueue(new MessageToWatch("StartAlarm", Long.valueOf(intExtra)));
        }
        if (str.equals("com.urbandroid.sleep.watch.STOP_ALARM")) {
            Logger.logDebug("Garmin: MessageHandler TO_WATCH_ALARM_STOP");
            this.queueToWatch.enqueue(new MessageToWatch("StopAlarm"));
        }
        if (str.equals("com.urbandroid.sleep.watch.UPDATE_ALARM")) {
            long longExtra3 = intent.getLongExtra("TIMESTAMP", 0L);
            Logger.logDebug("Garmin: MessageHandler TO_WATCH_ALARM_SET " + longExtra3);
            this.queueToWatch.enqueue(new MessageToWatch("SetAlarm", Long.valueOf(longExtra3)));
        }
        if (str.equals("com.urbandroid.sleep.watch.HINT")) {
            Long longOrIntExtraAsLong = Utils.getLongOrIntExtraAsLong(intent, "REPEAT", 0L);
            if (longOrIntExtraAsLong == null) {
                return;
            }
            Logger.logDebug("Garmin: MessageHandler Sending hint to watch, with repeat " + longOrIntExtraAsLong);
            this.queueToWatch.enqueue(new MessageToWatch("Hint", longOrIntExtraAsLong));
        }
        if (str.equals("com.urbandroid.sleep.watch.CHECK_CONNECTED")) {
            this.queueToWatch.remove(new MessageToWatch("StopApp"));
            try {
                this.watchAppOpenTime = System.currentTimeMillis();
                if (this.launchAppPromptAlreadyShownInCurrentSession.booleanValue()) {
                    return;
                }
                Logger.logDebug("Garmin: MessageHandler Checking watch connection...");
                Logger.logDebug("Garmin: MessageHandler Setting onOpenAppOnWatch listener");
                this.launchAppPromptAlreadyShownInCurrentSession = Boolean.TRUE;
                CIQManager.getInstance().onOpenAppOnWatch(new MessageHandler$$ExternalSyntheticLambda0(this, context));
            } catch (Exception e) {
                Logger.logSevere("Garmin: Error ", e);
            }
        }
    }

    public void handleMessageFromWatch(String str, String[] strArr, Context context) {
        int i;
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Garmin: MessageHandler From watch: ", str, MqttTopic.TOPIC_LEVEL_SEPARATOR);
        sbM5m.append(Arrays.toString(strArr));
        Logger.logDebug(sbM5m.toString());
        this.launchAppPromptAlreadyShownInCurrentSession = Boolean.FALSE;
        str.getClass();
        i = 0;
        switch (str) {
            case "DISMISS":
                sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.DISMISS_FROM_WATCH"), context);
                break;
            case "RESUME":
                sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.RESUME_FROM_WATCH"), context);
                break;
            case "SNOOZE":
                sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.SNOOZE_FROM_WATCH"), context);
                break;
            case "STOPPING":
                sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"), context);
                this.queueToWatch.emptyQueue();
                this.queueToWatch.enqueue(new MessageToWatch("StopApp"));
                break;
            case "DATA_NEW":
                this.maxRawFloatValues = new float[strArr.length];
                while (i < strArr.length) {
                    try {
                        this.maxRawFloatValues[i] = (Float.parseFloat(strArr[i]) * 9.806f) / 1000.0f;
                    } catch (NumberFormatException unused) {
                        this.maxRawFloatValues[i] = 0.0f;
                    }
                    i++;
                }
                break;
            case "HR":
                float f = Float.parseFloat(strArr[0]);
                Logger.logInfo("Garmin: MessageHandler : received HR data from watch " + f);
                Intent intent = new Intent("com.urbandroid.sleep.watch.HR_DATA_UPDATE");
                intent.putExtra("DATA", new float[]{f});
                sendExplicitBroadcastToSleep(intent, context);
                break;
            case "RR":
                float[] fArrStringArrayToFloatArray = Utils.stringArrayToFloatArray((String[]) Arrays.copyOfRange(strArr, 0, strArr.length - 2));
                int i2 = Integer.parseInt(strArr[strArr.length - 1]);
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i2, "Garmin: MessageHandler : received RR data from watch ", str, " ", ": ");
                sbM.append(Arrays.toString(fArrStringArrayToFloatArray));
                Logger.logInfo(sbM.toString());
                Intent intent2 = new Intent("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
                intent2.putExtra("com.urbandroid.sleep.EXTRA_DATA_RR", true);
                intent2.putExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", i2);
                intent2.putExtra("com.urbandroid.sleep.EXTRA_DATA_BATCH", fArrStringArrayToFloatArray);
                sendExplicitBroadcastToSleep(intent2, context);
                break;
            case "DATA":
                this.maxFloatValues = new float[strArr.length];
                while (i < strArr.length) {
                    try {
                        this.maxFloatValues[i] = Float.parseFloat(strArr[i]);
                    } catch (NumberFormatException unused2) {
                        this.maxFloatValues[i] = 0.0f;
                    }
                    i++;
                }
                break;
            case "SPO2":
                float[] fArrStringArrayToFloatArray2 = Utils.stringArrayToFloatArray((String[]) Arrays.copyOfRange(strArr, 0, strArr.length - 3));
                int i3 = Integer.parseInt(strArr[strArr.length - 2]);
                int i4 = Integer.parseInt(strArr[strArr.length - 1]);
                StringBuilder sbM2 = Fragment$$ExternalSyntheticOutline1.m(i4, "Garmin: MessageHandler : received SpO2 data from watch ", str, " ", ": ");
                sbM2.append(Arrays.toString(fArrStringArrayToFloatArray2));
                Logger.logInfo(sbM2.toString());
                Intent intent3 = new Intent("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
                intent3.putExtra("com.urbandroid.sleep.EXTRA_DATA_SPO2", true);
                intent3.putExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", i4);
                intent3.putExtra("com.urbandroid.sleep.EXTRA_DATA_FRAMERATE", i3);
                intent3.putExtra("com.urbandroid.sleep.EXTRA_DATA_BATCH", fArrStringArrayToFloatArray2);
                sendExplicitBroadcastToSleep(intent3, context);
                break;
            case "PAUSE":
                sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.PAUSE_FROM_WATCH"), context);
                break;
            case "STARTING":
                sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.STARTED_ON_WATCH"), context);
                sendExplicitBroadcastToSleep(new Intent("com.urbandroid.sleep.watch.CONFIRM_CONNECTED"), context);
                break;
        }
        if (this.maxRawFloatValues != null) {
            Intent intent4 = new Intent("com.urbandroid.sleep.watch.DATA_UPDATE");
            intent4.putExtra("MAX_RAW_DATA", this.maxRawFloatValues);
            float[] fArr = this.maxFloatValues;
            if (fArr != null) {
                intent4.putExtra("MAX_DATA", fArr);
            }
            sendExplicitBroadcastToSleep(intent4, context);
            this.maxRawFloatValues = null;
            this.maxFloatValues = null;
        }
    }

    public void handleMessageFromWatchUsingCIQ(List<Object> list, ConnectIQ.IQMessageStatus iQMessageStatus, Context context) {
        String[] strArrSplit = list.toArray()[0].toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "").split(",");
        handleMessageFromWatch(strArrSplit[0], (String[]) Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length), context);
    }

    public void handleMessageFromWatchUsingHTTP(String str, String str2, Context context) {
        Logger.logDebug("Garmin: MessageHandler handleMessageFromWatchUsingHTTP: " + str + " " + str2);
        handleMessageFromWatch(str, str2.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(" ", "").split(","), context);
    }
}
