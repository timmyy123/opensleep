package com.urbandroid.sleep.smartwatch.pebble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.TimeZone;
import java.util.UUID;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes5.dex */
public class Pebble implements SmartWatch {
    private static long pebbleStartDisabledTill;
    private final PebbleAccelManager accelManager;
    private PebbleKit.PebbleDataReceiver alarmReceiver;
    private final Context context;
    private PebbleKit.PebbleDataReceiver dataReceiver;
    private ResendNAckedTemplate enableHrResender;
    private ResendNAckedTemplate hintResender;
    private ResendNAckedTemplate setBatchSizeResender;
    private ResendNAckedTemplate startAlarmResender;
    private ResendNAckedTemplate suspendStatusResender;
    public static final UUID APP_UUID = UUID.fromString("24b0a1e5-f0b1-440d-8e53-8f26688a3f07");
    private static int transationIdCounter = 0;
    private static LinkedList<ResendNAckedTemplate> queuedTemplates = new LinkedList<>();
    private static final Object QUEUE_LOCK = new Object();
    private boolean trackingRunning = false;
    private final boolean isNewActigrahy = true;
    private Runnable startAppRunnable = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.2
        @Override // java.lang.Runnable
        public void run() {
            Logger.logInfo("Pebble: Restarting app on pebble");
            Pebble.this.startApp();
        }
    };
    private int lastTransactionId = -1;
    private Handler handler = new Handler();

    public Pebble(Context context) {
        this.context = context.getApplicationContext();
        this.accelManager = new PebbleAccelManager(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNextTransationId() {
        int i = transationIdCounter + 1;
        transationIdCounter = i;
        if (i > 255) {
            transationIdCounter = 0;
        }
        return transationIdCounter;
    }

    public static boolean isPebbleStartBlocked() {
        long j = pebbleStartDisabledTill;
        return j != 0 && j > System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] readAccelUpdateBatch(PebbleDictionary pebbleDictionary) {
        Long integer;
        try {
            integer = pebbleDictionary.getInteger(1);
        } catch (Exception e) {
            Logger.logSevere(e);
            integer = null;
        }
        if (integer != null) {
            return new int[]{integer.intValue()};
        }
        byte[] bytes = pebbleDictionary.getBytes(5);
        try {
            byte[] bytes2 = pebbleDictionary.getBytes(9);
            if (bytes2 != null) {
                if (bytes2.length > 0) {
                    bytes = bytes2;
                }
            }
        } catch (Exception unused) {
        }
        if (bytes == null) {
            return null;
        }
        int[] iArr = new int[bytes.length / 2];
        for (int i = 0; i < bytes.length; i += 2) {
            iArr[i / 2] = (bytes[i] * 127) + bytes[i + 1];
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int readHr(PebbleDictionary pebbleDictionary) {
        Long integer;
        if (!pebbleDictionary.contains(8) || (integer = pebbleDictionary.getInteger(8)) == null) {
            return -1;
        }
        return integer.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setEnableHr, reason: merged with bridge method [inline-methods] */
    public void lambda$startTracking$0() {
        if (this.trackingRunning) {
            Logger.logInfo("Pebble: enabling hr");
            ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.9
                @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
                public PebbleDictionary doCreateDictionary() {
                    PebbleDictionary pebbleDictionary = new PebbleDictionary();
                    pebbleDictionary.addInt8(10, (byte) 1);
                    return pebbleDictionary;
                }
            };
            this.enableHrResender = resendNAckedTemplate;
            resendNAckedTemplate.send();
        }
    }

    public void asyncConnectionCheck(final IConnectivityCallback iConnectivityCallback, long j) {
        final long jCurrentTimeMillis = System.currentTimeMillis() + j;
        new Runnable() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.logSevere("Pebble running connectivity check " + System.currentTimeMillis() + " < " + jCurrentTimeMillis);
                if (System.currentTimeMillis() > jCurrentTimeMillis || iConnectivityCallback.isCancelled()) {
                    iConnectivityCallback.status(Pebble.this, false);
                } else if (Pebble.this.isConnected()) {
                    iConnectivityCallback.status(Pebble.this, true);
                } else {
                    new Handler().postDelayed(this, 500L);
                }
            }
        }.run();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public IAccelManager getAccelManager() {
        return this.accelManager;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        return "Pebble";
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(final int i) {
        ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
            public PebbleDictionary doCreateDictionary() {
                PebbleDictionary pebbleDictionary = new PebbleDictionary();
                pebbleDictionary.addInt8(8, (byte) i);
                return pebbleDictionary;
            }
        };
        this.hintResender = resendNAckedTemplate;
        resendNAckedTemplate.send();
    }

    public boolean isConnected() {
        try {
            try {
                PebbleKit.FirmwareVersionInfo watchFWVersion = PebbleKit.getWatchFWVersion(this.context);
                if (watchFWVersion != null) {
                    Logger.logInfo("Pebble firmware " + watchFWVersion.getMajor() + "." + watchFWVersion.getMinor());
                }
                boolean z = TrialFilter.getInstance().isPebble() && watchFWVersion != null && watchFWVersion.getMajor() >= 2 && PebbleKit.isWatchConnected(this.context);
                Logger.logInfo("Pebble: connected " + z);
                return z;
            } catch (Exception unused) {
                Logger.logSevere("Pebble firmware check failed");
                return false;
            }
        } catch (Exception e) {
            Logger.logWarning("Pebble: Failed to check pebble connection", e);
            return false;
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(final int i) {
        if (this.trackingRunning) {
            Logger.logInfo("Setting Pebble batch size to: " + i);
            ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
                public PebbleDictionary doCreateDictionary() {
                    PebbleDictionary pebbleDictionary = new PebbleDictionary();
                    pebbleDictionary.addInt8(5, (byte) i);
                    return pebbleDictionary;
                }
            };
            this.setBatchSizeResender = resendNAckedTemplate;
            resendNAckedTemplate.send();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(final boolean z) {
        if (this.trackingRunning) {
            ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
                public PebbleDictionary doCreateDictionary() {
                    PebbleDictionary pebbleDictionary = new PebbleDictionary();
                    pebbleDictionary.addInt8(6, z ? (byte) 1 : (byte) 0);
                    return pebbleDictionary;
                }
            };
            this.suspendStatusResender = resendNAckedTemplate;
            resendNAckedTemplate.send();
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(final int i) {
        if (!startApp()) {
            Logger.logSevere("Pebble: App not installed, startAlarm()");
            return;
        }
        PebbleKit.PebbleDataReceiver pebbleDataReceiver = new PebbleKit.PebbleDataReceiver(APP_UUID) { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.5
            @Override // com.getpebble.android.kit.PebbleKit.PebbleDataReceiver
            public void receiveData(Context context, int i2, PebbleDictionary pebbleDictionary) {
                Long integer = pebbleDictionary.getInteger(2);
                if (integer != null) {
                    Logger.logInfo("Pebble: Snooze received: " + integer);
                    ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE"));
                }
                Long integer2 = pebbleDictionary.getInteger(3);
                if (integer2 != null) {
                    Logger.logInfo("Pebble: Dismiss received: " + integer2);
                    ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.alarmclock.ALARM_DISMISS_CAPTCHA"));
                }
            }
        };
        this.alarmReceiver = pebbleDataReceiver;
        PebbleKit.registerReceivedDataHandler(this.context, pebbleDataReceiver);
        ResendNAckedTemplate resendNAckedTemplate = new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
            public PebbleDictionary doCreateDictionary() {
                PebbleDictionary pebbleDictionary = new PebbleDictionary();
                pebbleDictionary.addInt32(1, i);
                return pebbleDictionary;
            }
        };
        this.startAlarmResender = resendNAckedTemplate;
        resendNAckedTemplate.send();
    }

    public boolean startApp() {
        try {
            Logger.logInfo("Pebble: Starting app");
            PebbleKit.startAppOnPebble(this.context, APP_UUID);
            return true;
        } catch (IllegalArgumentException e) {
            Logger.logSevere("Pebble app not installed, startApp()", e);
            return false;
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener smartWatchListener) {
        try {
            this.trackingRunning = true;
            if (!startApp()) {
                Logger.logSevere("Pebble: app not installed, startTracking()");
                return;
            }
            Logger.logInfo("Pebble: Starting tracking");
            PebbleKit.PebbleDataReceiver pebbleDataReceiver = new PebbleKit.PebbleDataReceiver(APP_UUID) { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.11
                @Override // com.getpebble.android.kit.PebbleKit.PebbleDataReceiver
                public void receiveData(Context context, int i, PebbleDictionary pebbleDictionary) {
                    if (Pebble.this.lastTransactionId == i) {
                        return;
                    }
                    Pebble.this.lastTransactionId = i;
                    String string = pebbleDictionary.getString(999);
                    if (string != null) {
                        SharedApplicationContext.getSettings().setPebbleTimelineToken(string);
                        return;
                    }
                    int[] accelUpdateBatch = Pebble.this.readAccelUpdateBatch(pebbleDictionary);
                    if (accelUpdateBatch != null) {
                        if (System.currentTimeMillis() % 40 == 0 && accelUpdateBatch.length > 0) {
                            Logger.logDebug("Pebble accel data received: first value " + accelUpdateBatch[0] + " size " + accelUpdateBatch.length);
                        }
                        for (int i2 : accelUpdateBatch) {
                            Pebble.this.accelManager.pushNewData(i2);
                        }
                    } else {
                        Long integer = pebbleDictionary.getInteger(4);
                        if (integer != null) {
                            Logger.logInfo("Pebble: Pause received: " + integer);
                            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.ACTION_PAUSE_TRACKING"));
                        }
                        Long integer2 = pebbleDictionary.getInteger(7);
                        if (integer2 != null) {
                            Logger.logInfo("Pebble: Resume received: " + integer2);
                            ContextExtKt.sendExplicitBroadcast(context, new Intent("com.urbandroid.sleep.ACTION_RESUME_TRACKING"));
                        }
                    }
                    int hr = Pebble.this.readHr(pebbleDictionary);
                    if (hr > -1) {
                        zza$$ExternalSyntheticOutline0.m(hr, "Pebble: HR ");
                        HrDataProducer.produce(context, hr, System.currentTimeMillis());
                    }
                    if (Pebble.this.trackingRunning) {
                        Pebble.this.handler.removeCallbacks(Pebble.this.startAppRunnable);
                        Pebble.this.handler.postDelayed(Pebble.this.startAppRunnable, 240000L);
                    }
                }
            };
            this.dataReceiver = pebbleDataReceiver;
            PebbleKit.registerReceivedDataHandler(this.context, pebbleDataReceiver);
            if (new Settings(this.context).isHrWear()) {
                this.handler.postDelayed(new Endpoint$$ExternalSyntheticLambda0(this, 8), 5000L);
            }
        } catch (Exception e) {
            Logger.logSevere("Pebble start error", e);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        PebbleKit.PebbleDataReceiver pebbleDataReceiver = this.alarmReceiver;
        if (pebbleDataReceiver != null) {
            this.context.unregisterReceiver(pebbleDataReceiver);
            this.alarmReceiver = null;
        }
        ResendNAckedTemplate resendNAckedTemplate = this.startAlarmResender;
        if (resendNAckedTemplate != null) {
            resendNAckedTemplate.cancel();
            this.startAlarmResender = null;
        }
        ResendNAckedTemplate resendNAckedTemplate2 = this.setBatchSizeResender;
        if (resendNAckedTemplate2 != null) {
            resendNAckedTemplate2.cancel();
            this.setBatchSizeResender = null;
        }
        ResendNAckedTemplate resendNAckedTemplate3 = this.enableHrResender;
        if (resendNAckedTemplate3 != null) {
            resendNAckedTemplate3.cancel();
            this.enableHrResender = null;
        }
        ResendNAckedTemplate resendNAckedTemplate4 = this.suspendStatusResender;
        if (resendNAckedTemplate4 != null) {
            resendNAckedTemplate4.cancel();
            this.suspendStatusResender = null;
        }
        ResendNAckedTemplate resendNAckedTemplate5 = this.hintResender;
        if (resendNAckedTemplate5 != null) {
            resendNAckedTemplate5.cancel();
            this.hintResender = null;
        }
        new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.7
            @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
            public PebbleDictionary doCreateDictionary() {
                Logger.logInfo("Pebble: Sending stop alarm.");
                PebbleDictionary pebbleDictionary = new PebbleDictionary();
                pebbleDictionary.addInt8(2, (byte) 1);
                return pebbleDictionary;
            }
        }.send();
        if (this.trackingRunning) {
            return;
        }
        this.handler.removeCallbacks(this.startAppRunnable);
        try {
            PebbleKit.closeAppOnPebble(this.context, APP_UUID);
        } catch (Exception e) {
            Logger.logSevere("Pebble stop error", e);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        this.trackingRunning = false;
        Logger.logInfo("Pebble: Stopping tracking");
        PebbleKit.PebbleDataReceiver pebbleDataReceiver = this.dataReceiver;
        if (pebbleDataReceiver != null) {
            this.context.unregisterReceiver(pebbleDataReceiver);
            this.dataReceiver = null;
        }
        this.handler.removeCallbacks(this.startAppRunnable);
        try {
            PebbleKit.closeAppOnPebble(this.context, APP_UUID);
        } catch (Exception e) {
            Logger.logSevere("Pebble stop error", e);
        }
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(final long j) {
        new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
            public PebbleDictionary doCreateDictionary() {
                PebbleDictionary pebbleDictionary = new PebbleDictionary();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(j);
                int i = calendar.get(10);
                if (new Settings(Pebble.this.context).is24HourFormat()) {
                    i = calendar.get(11);
                }
                int i2 = calendar.get(12);
                zza$$ExternalSyntheticOutline0.m(i, i2, "Pebble: updating alarm ", ":");
                if (j - System.currentTimeMillis() < TimeChart.DAY) {
                    pebbleDictionary.addUint8(3, (byte) i);
                    pebbleDictionary.addUint8(4, (byte) i2);
                }
                int offset = (int) ((j + ((long) TimeZone.getDefault().getOffset(j))) / 1000);
                Logger.logInfo("Pebble: updating alarm " + j);
                Logger.logInfo("Pebble: updating alarm, timezone adjusted " + (((long) offset) - j));
                pebbleDictionary.addUint32(9, offset);
                return pebbleDictionary;
            }
        }.send();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(final long j) {
        new ResendNAckedTemplate() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate
            public PebbleDictionary doCreateDictionary() {
                PebbleDictionary pebbleDictionary = new PebbleDictionary();
                Logger.logInfo("Pebble: updating pause " + j);
                int offset = (int) ((j + ((long) TimeZone.getDefault().getOffset(j))) / 1000);
                Logger.logInfo("Pebble: updating pause, timezone adjusted " + (((long) offset) - j));
                pebbleDictionary.addUint32(7, offset);
                return pebbleDictionary;
            }
        }.send();
    }

    public abstract class ResendNAckedTemplate {
        private PebbleKit.PebbleAckReceiver ackReceiver;
        private PebbleKit.PebbleNackReceiver nackReceiver;
        private int trackedTransactionId;
        private boolean finished = false;
        private Runnable resendRunnable = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.logInfo("Pebble: resending message, transaction: " + ResendNAckedTemplate.this.trackedTransactionId + " class " + getClass().getSimpleName());
                PebbleKit.sendDataToPebbleWithTransactionId(Pebble.this.context, Pebble.APP_UUID, ResendNAckedTemplate.this.doCreateDictionary(), ResendNAckedTemplate.this.trackedTransactionId);
            }
        };

        public ResendNAckedTemplate() {
            this.trackedTransactionId = Pebble.this.getNextTransationId();
        }

        private void doSend() {
            PebbleDictionary pebbleDictionaryDoCreateDictionary = doCreateDictionary();
            UUID uuid = Pebble.APP_UUID;
            this.nackReceiver = new PebbleKit.PebbleNackReceiver(uuid) { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate.2
                @Override // com.getpebble.android.kit.PebbleKit.PebbleNackReceiver
                public void receiveNack(Context context, int i) {
                    if (i == ResendNAckedTemplate.this.trackedTransactionId) {
                        Pebble.this.handler.postDelayed(ResendNAckedTemplate.this.resendRunnable, 2000L);
                    }
                }
            };
            this.ackReceiver = new PebbleKit.PebbleAckReceiver(uuid) { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate.3
                @Override // com.getpebble.android.kit.PebbleKit.PebbleAckReceiver
                public void receiveAck(Context context, int i) {
                    if (i == ResendNAckedTemplate.this.trackedTransactionId) {
                        Logger.logInfo("Pebble: message acked, transaction: " + ResendNAckedTemplate.this.trackedTransactionId + " class " + getClass().getSimpleName());
                        ResendNAckedTemplate.this.unregister();
                        ResendNAckedTemplate.this.finished = true;
                        synchronized (Pebble.QUEUE_LOCK) {
                            ResendNAckedTemplate.this.removeSelfAndExecuteNext();
                        }
                    }
                }
            };
            Pebble.this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.smartwatch.pebble.Pebble.ResendNAckedTemplate.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ResendNAckedTemplate.this.finished) {
                        return;
                    }
                    ResendNAckedTemplate.this.cancel();
                    synchronized (Pebble.QUEUE_LOCK) {
                        ResendNAckedTemplate.this.removeSelfAndExecuteNext();
                    }
                }
            }, 20000L);
            PebbleKit.registerReceivedNackHandler(Pebble.this.context, this.nackReceiver);
            PebbleKit.registerReceivedAckHandler(Pebble.this.context, this.ackReceiver);
            Logger.logInfo("Pebble: sending message, transaction: " + this.trackedTransactionId + " class " + getClass().getSimpleName());
            PebbleKit.sendDataToPebbleWithTransactionId(Pebble.this.context, uuid, pebbleDictionaryDoCreateDictionary, this.trackedTransactionId);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeSelfAndExecuteNext() {
            if (Pebble.queuedTemplates.getFirst() != this) {
                Logger.logSevere("Pebble: Unexpected first element in resend queue!!");
                return;
            }
            Pebble.queuedTemplates.removeFirst();
            if (Pebble.queuedTemplates.isEmpty()) {
                return;
            }
            ((ResendNAckedTemplate) Pebble.queuedTemplates.getFirst()).doSend();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void unregister() {
            PebbleKit.PebbleAckReceiver pebbleAckReceiver = this.ackReceiver;
            if (pebbleAckReceiver != null) {
                unregister(pebbleAckReceiver);
                this.ackReceiver = null;
            }
            PebbleKit.PebbleNackReceiver pebbleNackReceiver = this.nackReceiver;
            if (pebbleNackReceiver != null) {
                unregister(pebbleNackReceiver);
                this.nackReceiver = null;
            }
        }

        public void cancel() {
            Pebble.this.handler.removeCallbacks(this.resendRunnable);
            unregister();
        }

        public abstract PebbleDictionary doCreateDictionary();

        public void send() {
            synchronized (Pebble.QUEUE_LOCK) {
                try {
                    Logger.logInfo("Pebble: Adding to pebble queue.");
                    Pebble.queuedTemplates.addLast(this);
                    if (Pebble.queuedTemplates.size() <= 1) {
                        doSend();
                        return;
                    }
                    Logger.logInfo("Pebble queue non-empty. Post-add: " + Pebble.queuedTemplates.size() + " ... waiting.");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private void unregister(BroadcastReceiver broadcastReceiver) {
            if (broadcastReceiver != null) {
                Pebble.this.context.unregisterReceiver(broadcastReceiver);
            }
        }
    }
}
