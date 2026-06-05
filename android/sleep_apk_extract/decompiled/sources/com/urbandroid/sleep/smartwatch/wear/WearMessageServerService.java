package com.urbandroid.sleep.smartwatch.wear;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.WearableListenerService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.SleepStarter;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.sensor.extra.Spo2DataProducer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.AbstractStartSmartwatchReceiver;
import com.urbandroid.sleep.smartwatch.MultiSmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchProvider;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class WearMessageServerService extends WearableListenerService {
    private final boolean isNewActigraphy = true;
    private final DecimalFormat format = new DecimalFormat("0.00");

    private void confirm() {
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
        if (smartWatch != null && (smartWatch instanceof Wear)) {
            ((Wear) smartWatch).confirm();
        } else {
            Logger.logInfo("SmartWatch: no doing confirm no smartwatch");
            new SendMessageTemplate(getApplicationContext(), "/sleep/confirm").execute();
        }
    }

    private void confirmOnPhone() {
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
        if (smartWatch != null && (smartWatch instanceof Wear)) {
            ((Wear) smartWatch).confirmOnPhone();
        } else {
            Logger.logInfo("SmartWatch: no doing confirm no smartwatch");
            new SendMessageTemplate(getApplicationContext(), "/sleep/confirmOnPhone").execute();
        }
    }

    private void stopAlarm() {
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
        if (smartWatch != null) {
            smartWatch.stopAlarm();
        } else {
            Logger.logInfo("SmartWatch: no doing confirm no smartwatch");
            new SendMessageTemplate(getApplicationContext(), "/sleep/stopAlarm").execute();
        }
    }

    public SmartWatch getWearSmartWatch(Context context) {
        SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(context);
        if (!(smartWatch instanceof Wear) && (smartWatch instanceof MultiSmartWatch)) {
            for (SmartWatch smartWatch2 : ((MultiSmartWatch) smartWatch).getWatches()) {
                if (smartWatch2 instanceof Wear) {
                    return smartWatch2;
                }
            }
        }
        return smartWatch;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.MessageApi.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessageReceived(MessageEvent messageEvent) {
        int i;
        int i2;
        int i3;
        ByteBuffer byteBuffer;
        super.onMessageReceived(messageEvent);
        GlobalInitializator.initializeIfRequired(getApplicationContext());
        String path = messageEvent.getPath();
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("WEAR Message received ", path, " ID ");
        sbM5m.append(messageEvent.getRequestId());
        sbM5m.append(" node ");
        sbM5m.append(messageEvent.getSourceNodeId());
        Logger.logInfo(sbM5m.toString());
        if ("/sleep/setAlarm".equals(path)) {
            return;
        }
        if (!SharedApplicationContext.getSettings().isSmartwatchEnabled()) {
            Logger.logDebug("WEAR Getting messages from Wear but smartwatch tracking not enabled");
            if (SleepService.isRunning()) {
                Logger.logDebug("WEAR Not enabling smartwatch as sleep tracking already running");
                return;
            } else {
                Logger.logDebug("WEAR Enabling smartwatch");
                SharedApplicationContext.getSettings().setSmartwatchEnabled(true);
            }
        }
        path.getClass();
        i = 6;
        i2 = 0;
        switch (path) {
            case "/sleep/batchHr":
                SmartWatch wearSmartWatch = getWearSmartWatch(this);
                if (wearSmartWatch == null) {
                    Logger.logWarning("WEAR Getting messages from Wear but smartwatch not initialized");
                    return;
                }
                if (!(wearSmartWatch instanceof Wear)) {
                    Logger.logWarning("WEAR Getting messages from non-Wear smartwatch " + wearSmartWatch.getClass());
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(messageEvent.getData());
                StringBuilder sb = new StringBuilder();
                while (byteBufferWrap.hasRemaining()) {
                    float f = byteBufferWrap.getFloat();
                    if (i2 < 6) {
                        sb.append(" ");
                        sb.append(this.format.format(f));
                    }
                    arrayList.add(Float.valueOf(f));
                    i2++;
                }
                HrDataProducer.produce(getApplicationContext(), arrayList, 10000L);
                Logger.logInfo("WEAR HR Batch " + i2 + " Data" + ((Object) sb));
                break;
                break;
            case "/sleep/batchRr":
                int length = messageEvent.getData().length / 4;
                System.currentTimeMillis();
                ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(messageEvent.getData());
                float[] fArr = new float[length];
                StringBuilder sb2 = new StringBuilder();
                while (byteBufferWrap2.hasRemaining()) {
                    float f2 = byteBufferWrap2.getFloat();
                    if (i2 < 6) {
                        sb2.append(" ");
                        sb2.append(this.format.format(f2));
                    }
                    fArr[i2] = f2;
                    i2++;
                }
                Intent intent = new Intent("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
                intent.putExtra("com.urbandroid.sleep.EXTRA_DATA_RR", true);
                intent.putExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", System.currentTimeMillis());
                intent.putExtra("com.urbandroid.sleep.EXTRA_DATA_BATCH", fArr);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
                Logger.logInfo("WEAR RR Batch " + i2 + " Data " + ((Object) sb2));
                break;
            case "/sleep/resume":
                ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_RESUME_TRACKING"));
                confirm();
                break;
            case "/sleep/snooze":
                ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE"));
                if (AlarmKlaxon.isRunning()) {
                    confirm();
                    break;
                } else {
                    stopAlarm();
                    break;
                }
                break;
            case "/sleep/batchSdnn":
                int length2 = messageEvent.getData().length / 4;
                System.currentTimeMillis();
                Logger.logInfo("WEAR Message SDNN " + length2);
                ByteBuffer byteBufferWrap3 = ByteBuffer.wrap(messageEvent.getData());
                float[] fArr2 = new float[length2];
                StringBuilder sb3 = new StringBuilder();
                while (byteBufferWrap3.hasRemaining()) {
                    float f3 = byteBufferWrap3.getFloat();
                    if (i2 < i) {
                        sb3.append(" ");
                        i3 = i2;
                        sb3.append(this.format.format(f3));
                    } else {
                        i3 = i2;
                    }
                    fArr2[i3] = f3;
                    i2 = i3 + 1;
                    i = 6;
                }
                Intent intent2 = new Intent("com.urbandroid.sleep.ACTION_EXTRA_DATA_UPDATE");
                intent2.putExtra("com.urbandroid.sleep.EXTRA_DATA_SDNN", true);
                intent2.putExtra("com.urbandroid.sleep.EXTRA_DATA_TIMESTAMP", System.currentTimeMillis());
                intent2.putExtra("com.urbandroid.sleep.EXTRA_DATA_BATCH", fArr2);
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
                Logger.logInfo("WEAR SDNN Batch " + i2 + " Data " + sb3.toString());
                break;
            case "/sleep/batchSpo2":
                long jCurrentTimeMillis = System.currentTimeMillis() - ((long) ((messageEvent.getData().length / 4) * 1000));
                ByteBuffer byteBufferWrap4 = ByteBuffer.wrap(messageEvent.getData());
                StringBuilder sb4 = new StringBuilder();
                while (byteBufferWrap4.hasRemaining()) {
                    float f4 = byteBufferWrap4.getFloat();
                    if (i2 < 6) {
                        sb4.append(" ");
                        sb4.append(this.format.format(f4));
                    }
                    Spo2DataProducer.produce(getApplicationContext(), f4, ((long) (i2 * 1000)) + jCurrentTimeMillis);
                    i2++;
                }
                StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i2, "WEAR SPO2 Batch ", " Data ");
                sbM65m.append(sb4.toString());
                Logger.logInfo(sbM65m.toString());
                break;
            case "/sleep/batch":
                SmartWatch wearSmartWatch2 = getWearSmartWatch(this);
                if (wearSmartWatch2 == null) {
                    Logger.logWarning("WEAR Getting messages from Wear but smartwatch not initialized");
                    return;
                }
                if (!(wearSmartWatch2 instanceof Wear)) {
                    Logger.logWarning("WEAR Getting messages from non-Wear smartwatch " + wearSmartWatch2.getClass());
                    return;
                }
                WearAccelManager accelManager = ((Wear) wearSmartWatch2).getAccelManager();
                StringBuilder sb5 = new StringBuilder();
                StringBuilder sb6 = new StringBuilder();
                int i4 = -1;
                for (ByteBuffer byteBufferWrap5 = ByteBuffer.wrap(messageEvent.getData()); byteBufferWrap5.hasRemaining(); byteBufferWrap5 = byteBuffer) {
                    float f5 = byteBufferWrap5.getFloat();
                    if (i2 >= 30) {
                        byteBuffer = byteBufferWrap5;
                        sb5.append("...");
                    } else if (f5 == -6.66334E20f) {
                        sb5.append("|");
                        byteBuffer = byteBufferWrap5;
                    } else {
                        sb5.append(" ");
                        byteBuffer = byteBufferWrap5;
                        sb5.append(this.format.format(f5));
                    }
                    if (f5 == -6.66334E20f) {
                        i4++;
                    } else if (i4 == 0) {
                        i4 = -1;
                    }
                    if (f5 != -6.66334E20f && i4 >= 1) {
                        accelManager.pushNewData(f5);
                        sb6.append(" ");
                        sb6.append(this.format.format(f5));
                    }
                    i2++;
                }
                StringBuilder sb7 = new StringBuilder("WEAR Batch ");
                sb7.append(i2);
                sb7.append(" Data");
                sb7.append((Object) sb5);
                sb7.append(" ");
                int length3 = sb6.length();
                Object obj = sb6;
                if (length3 <= 0) {
                    obj = "";
                }
                sb7.append(obj);
                Logger.logInfo(sb7.toString());
                break;
                break;
            case "/sleep/pause":
                ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_PAUSE_TRACKING"));
                confirm();
                break;
        }
        if ("/sleep/dismiss".equals(path)) {
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA"));
            if (AlarmKlaxon.isRunning()) {
                confirmOnPhone();
                return;
            } else {
                stopAlarm();
                return;
            }
        }
        if ("/sleep/startTrack".equals(path)) {
            SmartWatch smartWatch = SmartWatchProvider.getSmartWatch(this);
            if (AbstractStartSmartwatchReceiver.isTrackingStartAllowed(this, "Wear")) {
                if (smartWatch == null) {
                    SmartWatchProvider.setSmartwatchInstanceIfNotTrackingYet(new Wear(getApplicationContext()));
                }
                ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.ACTION_TRACKING_UPDATE_SMARTWATCH"));
                if (!SleepService.isRunning()) {
                    if (SharedApplicationContext.getSettings().canStartScreensFromBackground()) {
                        new SleepStarter().startSleep(getApplicationContext());
                    } else {
                        new SleepStarter().startSleepSkipUiButStartManually(getApplicationContext());
                    }
                }
            }
            confirm();
            Settings settings = new Settings(getApplicationContext());
            if (settings.isHrWear()) {
                new SendMessageTemplate(getApplicationContext(), "/sleep/doHrMonitoring").execute();
            }
            if (settings.isOximeterWatch()) {
                new SendMessageTemplate(getApplicationContext(), "/sleep/doOximeter").execute();
                return;
            }
            return;
        }
        if ("/sleep/stopTrack".equals(path)) {
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.urbandroid.sleep.alarmclock.STOP_SLEEP_TRACK"));
            confirm();
            return;
        }
        if ("/sleep/hasConnectivity".equals(path)) {
            Logger.logInfo("WEAR Sending has connectivity intent com.ubandroid.sleep.smartwatch.wear.ACTION_HAS_CONNECTIVITY");
            ContextExtKt.sendExplicitBroadcast(getApplicationContext(), new Intent("com.ubandroid.sleep.smartwatch.wear.ACTION_HAS_CONNECTIVITY"));
            return;
        }
        if ("/sleep/log".equals(path)) {
            Logger.logInfo("WEAR LOG: ".concat(new String(messageEvent.getData())));
            return;
        }
        if ("/sleep/eventLabel".equals(path)) {
            try {
                Event eventUnmarshal = EventsUtil.unmarshal(new String(messageEvent.getData(), "UTF8"));
                if (CurrentSleepRecord.getInstance().getRecord() != null) {
                    CurrentSleepRecord.getInstance().getRecord().getEvents().addEvent(eventUnmarshal);
                }
                Logger.logDebug("WEAR EVENT: " + eventUnmarshal);
            } catch (UnsupportedEncodingException e) {
                Logger.logSevere(e);
            }
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService
    public void onPeerConnected(Node node) {
        super.onPeerConnected(node);
        Logger.logInfo("WEAR peer connected.");
    }

    @Override // com.google.android.gms.wearable.WearableListenerService
    public void onPeerDisconnected(Node node) {
        super.onPeerDisconnected(node);
        Logger.logInfo("WEAR peer disconnected.");
    }
}
