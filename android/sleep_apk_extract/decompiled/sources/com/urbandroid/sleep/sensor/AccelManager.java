package com.urbandroid.sleep.sensor;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import androidx.core.content.ContextCompat;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.SleepLockManager;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class AccelManager extends BaseAccelManager implements IAccelManager, SensorEventListener {
    private final int WAKE_CODE;
    private Set<Object> accelListeners;
    private SensorEventListener batchingEventListener;
    private Context context;
    private int counter;
    private FlipGestureDetector gestureDetector;
    private boolean runInBatchingMode;
    private SensorManager sensorManager;
    private long timestampOffset;
    private BroadcastReceiver wakeReceiver;

    public AccelManager(Context context, boolean z, int i, boolean z2) {
        super(z ? 15 : 1, i, z2);
        this.WAKE_CODE = 243256883;
        this.counter = 0;
        this.accelListeners = new HashSet();
        this.context = context;
        this.runInBatchingMode = z;
        Logger.logInfo("AccelManager:Using AccelManager");
        if (SharedApplicationContext.getSettings().isFlipToSnooze() || SharedApplicationContext.getSettings().isFlipToPause()) {
            this.gestureDetector = new FlipGestureDetector(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntentBuilder getWakePendingIntent() {
        return PendingIntentBuilder.get(this.context, 243256883, new Intent("com.urbandroid.sleep.WAKE_BATCH_TRACKING"), 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlarmClock(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
            Logger.logSevere("Cannot set EXACT alarms");
            alarmManager.setAndAllowWhileIdle(0, j, pendingIntent);
        } else {
            Intent intent = new Intent(this.context, (Class<?>) AlarmClock.class);
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j, PendingIntentBuilder.get(this.context, 72849, intent, 134217728).getActivity()), pendingIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExactAndAllowWhileIdle(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
            alarmManager.setExactAndAllowWhileIdle(0, j, pendingIntent);
        } else {
            Logger.logSevere("Cannot set EXACT alarms");
            alarmManager.setAndAllowWhileIdle(0, j, pendingIntent);
        }
    }

    public boolean isRunInBatchingMode() {
        return this.runInBatchingMode;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        zza$$ExternalSyntheticOutline0.m(i, "AccelManager: Accuracy changed: ");
    }

    public void onFlushCompleted(Sensor sensor) {
        batchFlushFinished();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        FlipGestureDetector flipGestureDetector = this.gestureDetector;
        if (flipGestureDetector != null && this.counter % 10 == 0) {
            try {
                flipGestureDetector.update(f, f2, f3);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        this.counter++;
        long j = sensorEvent.timestamp / 1000000;
        if (this.timestampOffset == 0) {
            this.timestampOffset = System.currentTimeMillis() - j;
            Logger.logInfo("AccelManager:Resetting timestamp offset to: " + this.timestampOffset);
        }
        onValuesUpdate(f, f2, f3, this.timestampOffset + j);
        Iterator<Object> it = this.accelListeners.iterator();
        if (it.hasNext()) {
            throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
        }
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start(int i) {
        if (this.gestureDetector != null) {
            SharedApplicationContext.getSettings().setFlipDetectionRunning(true);
        }
        measurementRestarted();
        SensorManager sensorManager = (SensorManager) this.context.getSystemService("sensor");
        this.sensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        int i2 = 0;
        int iMin = this.runInBatchingMode ? Math.min(60000, defaultSensor.getFifoReservedEventCount() * 50) : 0;
        if (this.runInBatchingMode && iMin < 1000) {
            Logger.logInfo("AccelManager:Batching mode not enabled, too short queue: " + defaultSensor.getFifoReservedEventCount() + " -> sleep time: " + iMin);
            Settings settings = new Settings(this.context);
            if (settings.doSensorBatching(this.context)) {
                Logger.logInfo("Disabling sensor batching as we cannot support it");
                settings.setBatteryOptimized(false);
                SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                editorEdit.putBoolean("sensor_batching", false);
                editorEdit.apply();
            }
            this.runInBatchingMode = false;
        }
        if (!this.runInBatchingMode) {
            SensorManager sensorManager2 = this.sensorManager;
            sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(1), i);
            return;
        }
        if (iMin < 10000) {
            Logger.logInfo("AccelManager:Short queue -> Forcing normal delay.");
            i = 3;
        }
        this.batchingEventListener = new BatchingListener(this, i2);
        Logger.logInfo("AccelManager:Initializing batched accelerometer. Max events: " + defaultSensor.getFifoMaxEventCount() + " Max reserved events: " + defaultSensor.getFifoReservedEventCount());
        if (!this.sensorManager.registerListener(this.batchingEventListener, defaultSensor, i, Experiments.getInstance().isBatchingFixExperiment() ? iMin * 1000 : 60000000)) {
            Logger.logSevere("AccelManager:Batching cannot be properly initialized. Falling back to old behavior");
            this.runInBatchingMode = false;
            return;
        }
        final AlarmManager alarmManager = (AlarmManager) this.context.getSystemService("alarm");
        final long j = Experiments.getInstance().isBatchingFixExperiment() ? iMin : 60000L;
        if (Experiments.getInstance().useAndroidMDozeHackBatching()) {
            setAlarmClock(alarmManager, System.currentTimeMillis() + j, getWakePendingIntent().getExplicitBroadcast());
        } else {
            setExactAndAllowWhileIdle(alarmManager, System.currentTimeMillis() + j, getWakePendingIntent().getExplicitBroadcast());
        }
        final PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) this.context.getSystemService("power")).newWakeLock(1, SleepLockManager.getWakeLockTag(this.context, "SleepBatching"));
        wakeLockNewWakeLock.acquire(4000L);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.sensor.AccelManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Logger.logInfo("AccelManager:Got a wake event.. let's hold lock for a while");
                Logger.logInfo("AccelManager: awake " + new Date(System.currentTimeMillis()));
                wakeLockNewWakeLock.acquire(4000L);
                AccelManager.this.batchFlushStarted();
                AccelManager.this.sensorManager.flush(AccelManager.this.batchingEventListener);
                boolean zUseAndroidMDozeHackBatching = Experiments.getInstance().useAndroidMDozeHackBatching();
                AccelManager accelManager = AccelManager.this;
                AlarmManager alarmManager2 = alarmManager;
                if (zUseAndroidMDozeHackBatching) {
                    accelManager.setAlarmClock(alarmManager2, System.currentTimeMillis() + j, AccelManager.this.getWakePendingIntent().getExplicitBroadcast());
                } else {
                    accelManager.setExactAndAllowWhileIdle(alarmManager2, System.currentTimeMillis() + j, AccelManager.this.getWakePendingIntent().getExplicitBroadcast());
                }
            }
        };
        this.wakeReceiver = broadcastReceiver;
        ContextCompat.registerReceiver(this.context, broadcastReceiver, new IntentFilter("com.urbandroid.sleep.WAKE_BATCH_TRACKING"), 4);
    }

    @Override // com.urbandroid.sleep.sensor.BaseAccelManager, com.urbandroid.sleep.sensor.IAccelManager
    public void stop() {
        super.stop();
        if (this.runInBatchingMode) {
            getWakePendingIntent().cancelAlarmBroadcast();
            BroadcastReceiver broadcastReceiver = this.wakeReceiver;
            if (broadcastReceiver != null) {
                this.context.unregisterReceiver(broadcastReceiver);
                this.wakeReceiver = null;
            }
        }
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.batchingEventListener;
            if (sensorEventListener == null) {
                sensorEventListener = this;
            }
            sensorManager.unregisterListener(sensorEventListener);
            this.batchingEventListener = null;
            this.sensorManager = null;
            resetZerosCount();
        } else {
            Logger.logWarning("AccelManager:Stopping accel manager without starting it.");
        }
        if (this.gestureDetector != null) {
            SharedApplicationContext.getSettings().setFlipDetectionRunning(false);
        }
    }

    public class BatchingListener implements SensorEventListener, SensorEventListener2 {
        private BatchingListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            AccelManager.this.onAccuracyChanged(sensor, i);
        }

        @Override // android.hardware.SensorEventListener2
        public void onFlushCompleted(Sensor sensor) {
            AccelManager.this.onFlushCompleted(sensor);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            AccelManager.this.onSensorChanged(sensorEvent);
        }

        public /* synthetic */ BatchingListener(AccelManager accelManager, int i) {
            this();
        }
    }

    public AccelManager(Context context, boolean z, int i) {
        this(context, z, i, true);
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void start() {
        start(this.runInBatchingMode ? 3 : 1);
    }
}
