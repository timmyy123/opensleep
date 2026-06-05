package com.urbandroid.sleep.domain;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityFiles;
import com.urbandroid.common.util.Environment;
import com.urbandroid.service.thread.ThreadService;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.domain.DeepSleepDetector;
import com.urbandroid.sleep.hr.polar.BleSmartWatch;
import com.urbandroid.sleep.nearby.pairtracking.PairTracking;
import com.urbandroid.sleep.sensor.AccelManager;
import com.urbandroid.sleep.sensor.IAccelManager;
import com.urbandroid.sleep.sensor.aggregator.ActivityAggregatorAccel;
import com.urbandroid.sleep.sensor.aggregator.ActivityAggregatorSonar;
import com.urbandroid.sleep.sensor.aggregator.IActivityAggregator;
import com.urbandroid.sleep.sensor.sonar.SonarAccelManager;
import com.urbandroid.sleep.sensor.sonar.SonarConsumer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.generic.DataFrequencyGuard;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaser;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StringBufferPersister;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* JADX INFO: loaded from: classes4.dex */
public class AccelSleepRecorder {
    private static long MAX_PAUSE_LENGTH_IN_MILLIS = 7200000;
    private IAccelManager accelManager;
    private IActivityAggregator activityAggregator;
    private int backfillBufferSize;
    private Context context;
    private DeepSleepDetector deepSleepDetector;
    private int framerate;
    private int maxExpectedDelayedPoints;
    private PairTracking pairTracking;
    private StringBufferPersister persister;
    private IAccelManager phoneAccelManager;
    private IActivityAggregator phoneActivityAggregator;
    private ExpectedTrackingRange range;
    private final SleepRecord record;
    private long refreshRate;
    private SensorType sensorType;
    private final SmartWatch smartWatch;
    private SonarConsumer sonarConsumer;
    boolean wasPausedLastTime;
    private AtomicBoolean started = new AtomicBoolean(false);
    private Handler h = new Handler();
    private int updateCount = 0;
    private Runnable updaterThread = new Runnable() { // from class: com.urbandroid.sleep.domain.AccelSleepRecorder.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AccelSleepRecorder.this.started.get()) {
                    AccelSleepRecorder accelSleepRecorder = AccelSleepRecorder.this;
                    accelSleepRecorder.processChangesAndUpdateGraph(false, accelSleepRecorder.updateCount);
                    AccelSleepRecorder.this.updateCount++;
                } else {
                    Logger.logInfo("Updater thread terminated");
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    };
    private final LinkedList<PauseHistoryRecord> pauseHistory = new LinkedList<>();
    private boolean disabled = false;
    private boolean fillingEnabled = true;
    private final DataFrequencyGuard dataFrequencyGuard = new DataFrequencyGuard();

    public AccelSleepRecorder(final Context context, SleepRecord sleepRecord, int i, SmartWatch smartWatch, ExpectedTrackingRange expectedTrackingRange) {
        this.record = sleepRecord;
        this.range = expectedTrackingRange;
        if (sleepRecord == null) {
            Logger.logWarning("AccelSleepRecorder: Start with null sleep record.");
        } else {
            Logger.logInfo("AccelSleepRecorder: record version " + sleepRecord.getVersion());
        }
        this.framerate = i;
        this.context = context;
        this.smartWatch = smartWatch;
        new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.domain.AccelSleepRecorder.2
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                new ActivityFiles(context).deleteOldFiles(3);
                return null;
            }
        }.execute(new Void[0]);
        this.persister = new StringBufferPersister("Activity", 1000);
    }

    private void appendActivity(StringBuilder sb, IActivityAggregator.Result result) {
        sb.append(result.rawActivity);
        sb.append(",");
        sb.append(result.actigraph);
        sb.append(",");
        sb.append(result.isSomeActivity ? 1 : 0);
        sb.append(",");
        sb.append(result.isHighActivity ? 1 : 0);
    }

    private long estimatedLastPointTimestamp() {
        SleepRecord sleepRecord = this.record;
        if (sleepRecord == null || sleepRecord.getFrom() == null) {
            return 0L;
        }
        return this.record.getFrom().getTime() + ((long) (this.record.getRecordCount() * this.framerate));
    }

    private int expectedRecordLength(long j) {
        return (int) ((j - this.record.getFrom().getTime()) / ((long) this.framerate));
    }

    private IActivityAggregator.Result[] getChanges(boolean z) {
        IAccelManager iAccelManager;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.context);
        boolean zIsAwakeDetectionHighActivity = SharedApplicationContext.getSettings().isAwakeDetectionHighActivity();
        float[] fArrResetChanges = this.accelManager.resetChanges(z);
        restartIfAllValuesAreZero(this.accelManager, fArrResetChanges);
        float[] fArrProcess = this.dataFrequencyGuard.process(fArrResetChanges);
        IActivityAggregator.Result[] resultArr = new IActivityAggregator.Result[fArrProcess.length];
        for (int i = 0; i < fArrProcess.length; i++) {
            resultArr[i] = this.activityAggregator.update(fArrProcess[i]);
            if (zIsAwakeDetectionHighActivity && this.sensorType.isAccelerometer()) {
                localBroadcastManager.sendBroadcast(ActivityEventsKt.createRawActivityIntent(this.sensorType, resultArr[i].actigraph));
            }
        }
        if (zIsAwakeDetectionHighActivity && !this.sensorType.isAccelerometer() && (iAccelManager = this.phoneAccelManager) != null) {
            float[] fArrResetChanges2 = iAccelManager.resetChanges(z);
            restartIfAllValuesAreZero(this.phoneAccelManager, fArrResetChanges2);
            for (float f : fArrResetChanges2) {
                localBroadcastManager.sendBroadcast(ActivityEventsKt.createRawActivityIntent(SensorType.PHONE_ACCEL, this.phoneActivityAggregator.update(f).actigraph));
            }
        }
        return resultArr;
    }

    private PauseHistoryRecord getLastPauseEndRecord() {
        if (this.pauseHistory.isEmpty()) {
            return null;
        }
        if (!this.pauseHistory.getLast().isPaused) {
            return this.pauseHistory.getLast();
        }
        Logger.logSevere("Last pause point is not pause end?");
        return null;
    }

    private PauseHistoryRecord getPauseHistoryRecordBeforeTimestamp(long j) {
        LinkedList<PauseHistoryRecord> linkedList = this.pauseHistory;
        ListIterator<PauseHistoryRecord> listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            PauseHistoryRecord pauseHistoryRecordPrevious = listIterator.previous();
            if (pauseHistoryRecordPrevious.timestamp <= j) {
                return pauseHistoryRecordPrevious;
            }
        }
        return null;
    }

    private boolean isPairTrackingEnabled() {
        return PairTracking.INSTANCE.shouldPairTrackingBeUsed(this.context);
    }

    private void persist(IActivityAggregator.Result result, IActivityAggregator.Result result2) {
        if (this.persister != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append(",");
            appendActivity(sb, result);
            if (result2 != null) {
                sb.append(",");
                appendActivity(sb, result2);
            }
            sb.append("\n");
            this.persister.update(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processChangesAndUpdateGraph(boolean z, int i) throws JSONException {
        boolean z2 = this.smartWatch != null;
        IActivityAggregator.Result[] changes = getChanges(z);
        if (changes != null && changes.length > 0) {
            backfillPointsIfRequired(changes.length, z);
        }
        int i2 = 0;
        while (i2 < changes.length) {
            int i3 = i2 + 1;
            if (isPaused(estimatedLastPointTimestamp() + ((long) (this.framerate * i3)))) {
                changes[i2] = new IActivityAggregator.Result(-0.01f);
            }
            i2 = i3;
        }
        boolean zIsPaused = isPaused();
        if (z2 && !zIsPaused && this.wasPausedLastTime) {
            this.smartWatch.setSuspended(false);
        }
        if (this.disabled) {
            for (int i4 = 0; i4 < changes.length; i4++) {
                if (changes[i4].actigraph != -0.01f) {
                    changes[i4] = new IActivityAggregator.Result(-0.001f);
                }
            }
        }
        this.wasPausedLastTime = zIsPaused;
        for (int i5 = 0; i5 < changes.length; i5++) {
            PairTracking pairTracking = this.pairTracking;
            if (pairTracking == null) {
                persist(changes[i5]);
            } else {
                IActivityAggregator.Result result = changes[i5];
                IActivityAggregator.Result resultUpdate = pairTracking.update(result);
                persist(result, resultUpdate);
                changes[i5] = resultUpdate;
            }
        }
        for (IActivityAggregator.Result result2 : changes) {
            this.deepSleepDetector.update(result2);
        }
        updateGraphValue(changes, z);
    }

    private void restartIfAllValuesAreZero(IAccelManager iAccelManager, float[] fArr) {
        if (Environment.isMOrGreater() && (iAccelManager instanceof AccelManager) && !((AccelManager) iAccelManager).isRunInBatchingMode()) {
            for (float f : fArr) {
                if (f != 0.0f) {
                    return;
                }
            }
            if (fArr.length > 0) {
                Logger.logInfo("AccelSleepRecorder: got ZERO values");
                iAccelManager.stop();
                iAccelManager.start();
            }
        }
    }

    private void startPairTracking() {
        if (isPairTrackingEnabled()) {
            this.pairTracking = new PairTracking(this.context);
        } else {
            this.pairTracking = null;
        }
    }

    private void stopPairTracking() {
        PairTracking pairTracking = this.pairTracking;
        if (pairTracking != null) {
            pairTracking.close();
            this.pairTracking = null;
        }
    }

    private float transformChange(float f) {
        if (this.record.getVersion() >= 10003 || f < 0.0f) {
            return f;
        }
        double d = f;
        return d < 1.0d ? f * f : (float) Math.sqrt(d);
    }

    private void updateGraphValue(IActivityAggregator.Result[] resultArr, boolean z) {
        float[] fArr = new float[resultArr.length];
        for (int i = 0; i < resultArr.length; i++) {
            IActivityAggregator.Result result = resultArr[i];
            fArr[i] = result.actigraph;
            this.record.addTempHistory(result.rawActivity);
        }
        updateGraphValue(fArr, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void updateGraphValueWait(float[] fArr) {
        try {
            SleepRecord sleepRecord = this.record;
            if (sleepRecord != null) {
                if (sleepRecord.isFinished()) {
                    Logger.logDebug("WARN: Trying to add data to already finished sleep record");
                } else {
                    float[] fArr2 = new float[fArr.length];
                    for (int i = 0; i < fArr.length; i++) {
                        fArr2[i] = transformChange(fArr[i]);
                    }
                    int recordCount = this.record.getRecordCount();
                    this.record.setTo(new Date());
                    this.record.addRecordIfNotFinished(fArr2);
                    int recordCount2 = this.record.getRecordCount();
                    if (recordCount / 100 != recordCount2 / 100) {
                        List<Float> history = this.record.getHistory();
                        ListIterator<Float> listIterator = history.listIterator(history.size());
                        String str = "";
                        for (int i2 = 0; listIterator.hasPrevious() && i2 < 10; i2++) {
                            str = str + String.valueOf(listIterator.previous()) + ", ";
                        }
                        Logger.logDebug("RecLen: " + recordCount2 + " Last few record: " + str + " ..");
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void addPause(long j) {
        PauseHistoryRecord lastPauseEndRecord;
        try {
            if (isPaused()) {
                lastPauseEndRecord = getLastPauseEndRecord();
                lastPauseEndRecord.updateTimestamp(lastPauseEndRecord.timestamp + j);
            } else {
                this.pauseHistory.add(new PauseHistoryRecord(true, System.currentTimeMillis(), 0));
                lastPauseEndRecord = new PauseHistoryRecord(0 == true ? 1 : 0, System.currentTimeMillis() + j, 0 == true ? 1 : 0);
                this.pauseHistory.add(lastPauseEndRecord);
                SmartWatch smartWatch = this.smartWatch;
                if (smartWatch != null) {
                    smartWatch.setSuspended(true);
                }
            }
            long j2 = lastPauseEndRecord.timestamp;
            Logger.logInfo("Pausing recording till: " + j2 + " Added: " + j);
            long jCurrentTimeMillis = System.currentTimeMillis() + MAX_PAUSE_LENGTH_IN_MILLIS;
            if (j2 > jCurrentTimeMillis) {
                lastPauseEndRecord.updateTimestamp(jCurrentTimeMillis);
                j2 = jCurrentTimeMillis;
            }
            SmartWatch smartWatch2 = this.smartWatch;
            if (smartWatch2 != null) {
                smartWatch2.updatePause(j2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void backfillPointsIfRequired(int i, boolean z) {
        SleepRecord sleepRecord;
        if (!this.fillingEnabled || (sleepRecord = this.record) == null || sleepRecord.getFrom() == null) {
            return;
        }
        int iExpectedRecordLength = expectedRecordLength(System.currentTimeMillis()) - this.record.getRecordCount();
        int i2 = 0;
        int i3 = i > 0 ? (iExpectedRecordLength - i) - this.maxExpectedDelayedPoints : z ? iExpectedRecordLength - this.backfillBufferSize : 0;
        if (i3 <= 0) {
            return;
        }
        zza$$ExternalSyntheticOutline0.m(Fragment$$ExternalSyntheticOutline1.m(i3, iExpectedRecordLength, "Going to backfill ", " points. Expected updates: ", " Received: "), i);
        float[] fArr = new float[i3];
        while (i2 < i3) {
            int i4 = i2 + 1;
            fArr[i2] = isPaused(estimatedLastPointTimestamp() + ((long) (this.framerate * i4))) ? -0.01f : -0.001f;
            i2 = i4;
        }
        updateGraphValue(fArr, z);
        PairTracking pairTracking = this.pairTracking;
        if (pairTracking != null) {
            pairTracking.backfill(fArr);
        }
        persist(fArr);
    }

    public void disableFilling() {
        this.fillingEnabled = false;
    }

    public synchronized void finishPause() {
        try {
            Logger.logInfo("Disabling accel pause.");
            PauseHistoryRecord lastPauseEndRecord = getLastPauseEndRecord();
            if (lastPauseEndRecord != null) {
                lastPauseEndRecord.updateTimestamp(System.currentTimeMillis());
            }
            SmartWatch smartWatch = this.smartWatch;
            if (smartWatch != null) {
                smartWatch.updatePause(0L);
                this.smartWatch.setSuspended(false);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() {
        processChangesAndUpdateGraph(true, this.updateCount);
        this.updateCount++;
    }

    public int getCountOfZeroValuesInRow() {
        IAccelManager iAccelManager = this.accelManager;
        if (iAccelManager != null) {
            return iAccelManager.getCountOfZeroValuesInRow();
        }
        return 0;
    }

    public synchronized long getRemainingPauseMillis() {
        PauseHistoryRecord lastPauseEndRecord = getLastPauseEndRecord();
        if (lastPauseEndRecord == null) {
            return 0L;
        }
        long jCurrentTimeMillis = lastPauseEndRecord.timestamp - System.currentTimeMillis();
        return jCurrentTimeMillis > 0 ? jCurrentTimeMillis : 0L;
    }

    public DeepSleepDetector.SleepPhase getSleepPhase() {
        return this.deepSleepDetector.getSleepPhase();
    }

    public synchronized boolean isPaused(long j) {
        PauseHistoryRecord pauseHistoryRecordBeforeTimestamp = getPauseHistoryRecordBeforeTimestamp(j);
        if (pauseHistoryRecordBeforeTimestamp == null) {
            return false;
        }
        return pauseHistoryRecordBeforeTimestamp.isPaused;
    }

    public boolean isStarted() {
        return this.started.get();
    }

    public void resetZerosCount() {
        IAccelManager iAccelManager = this.accelManager;
        if (iAccelManager != null) {
            iAccelManager.resetZerosCount();
        }
    }

    public synchronized void setDisabled(boolean z) {
        try {
            Logger.logInfo("Setting disabled sleep recording mode: " + z);
            this.disabled = z;
            IAccelManager iAccelManager = this.accelManager;
            if (z) {
                iAccelManager.stop();
                IAccelManager iAccelManager2 = this.phoneAccelManager;
                if (iAccelManager2 != null) {
                    iAccelManager2.stop();
                }
                stopPairTracking();
            } else {
                iAccelManager.start();
                IAccelManager iAccelManager3 = this.phoneAccelManager;
                if (iAccelManager3 != null) {
                    iAccelManager3.start();
                }
                startPairTracking();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setSonarConsumer(SonarConsumer sonarConsumer) {
        this.sonarConsumer = sonarConsumer;
    }

    public synchronized void start(int i) {
        try {
            this.updateCount = 0;
            Settings settings = new Settings(this.context);
            boolean zDoSensorBatching = settings.doSensorBatching(this.context);
            boolean zIsAwakeDetectionHighActivity = settings.isAwakeDetectionHighActivity();
            boolean zIsFlipToPause = settings.isFlipToPause();
            if (this.sonarConsumer != null) {
                this.sensorType = SensorType.SONAR;
            } else {
                SmartWatch smartWatch = this.smartWatch;
                if (smartWatch == null) {
                    this.sensorType = SensorType.PHONE_ACCEL;
                } else if (smartWatch instanceof SleepPhaser) {
                    this.sensorType = SensorType.SLEEPPHASER;
                } else if (smartWatch instanceof BleSmartWatch) {
                    this.sensorType = SensorType.BLE_ACCEL;
                } else {
                    this.sensorType = SensorType.SMARTWATCH;
                }
            }
            StringBuilder sb = new StringBuilder("AccelSleepRecorder start: sensorType=");
            sb.append(this.sensorType);
            sb.append(", runsInBatchMode=");
            sb.append(zDoSensorBatching);
            sb.append(", isAwakeDetectionHighActivity=");
            sb.append(zIsAwakeDetectionHighActivity);
            sb.append(", isFlipToPause=");
            sb.append(zIsFlipToPause);
            sb.append(", isPairTrackingEnabled=");
            sb.append(isPairTrackingEnabled());
            sb.append(", autoTracking=");
            sb.append(this.range != null);
            Logger.logInfo(sb.toString());
            if (this.sensorType.isSmartWatch() || this.sensorType.isPhaser() || this.sensorType.isBleAccel()) {
                this.accelManager = this.smartWatch.getAccelManager();
                this.activityAggregator = new ActivityAggregatorAccel(this.sensorType);
            } else if (this.sensorType.isSonar()) {
                this.accelManager = new SonarAccelManager(this.context, this.sonarConsumer);
                this.activityAggregator = new ActivityAggregatorSonar();
            } else {
                this.accelManager = new AccelManager(this.context, zDoSensorBatching, this.framerate);
                this.activityAggregator = new ActivityAggregatorAccel(this.sensorType);
            }
            if ((zIsAwakeDetectionHighActivity || zIsFlipToPause) && !this.sensorType.isPhoneAccel()) {
                Logger.logInfo("AccelManager creating supplementary AccelManager");
                this.phoneAccelManager = new AccelManager(this.context, false, this.framerate);
                this.phoneActivityAggregator = new ActivityAggregatorAccel(SensorType.PHONE_ACCEL);
            }
            PairTracking.INSTANCE.clearData();
            startPairTracking();
            if (!isPairTrackingEnabled() || Experiments.getInstance().isActigraphyImprovementsExperiment1()) {
                this.deepSleepDetector = new DeepSleepDetectorV8(this.sensorType.isWearableAccelerometer());
            } else {
                this.deepSleepDetector = new DeepSleepDetectorV6(this.sensorType.isWearableAccelerometer());
            }
            Logger.logInfo("AccelManager class: " + this.accelManager.getClass() + " Max batch size: " + this.accelManager.getMaxBatchSize());
            this.backfillBufferSize = this.accelManager.getMaxBatchSize();
            this.maxExpectedDelayedPoints = this.accelManager.getMaxDelayedPoints();
            this.accelManager.start(i);
            IAccelManager iAccelManager = this.phoneAccelManager;
            if (iAccelManager != null) {
                iAccelManager.start(i);
            }
            SleepRecord sleepRecord = this.record;
            if (sleepRecord != null) {
                sleepRecord.getHistory().size();
            }
            this.wasPausedLastTime = isPaused();
            int i2 = this.framerate;
            if (zDoSensorBatching) {
                i2 /= 3;
            }
            long j = i2;
            this.refreshRate = j;
            this.h.postDelayed(this.updaterThread, j);
            this.dataFrequencyGuard.start();
            this.started.set(true);
            Logger.logDebug("Starting accelerometer updater thread");
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void stop() {
        try {
            this.h.removeCallbacks(this.updaterThread);
            Logger.logInfo("Stopping sleep recorder");
            this.accelManager.stop();
            IAccelManager iAccelManager = this.phoneAccelManager;
            if (iAccelManager != null) {
                iAccelManager.stop();
            }
            StringBufferPersister stringBufferPersister = this.persister;
            if (stringBufferPersister != null) {
                stringBufferPersister.flush();
            }
            stopPairTracking();
            this.started.set(false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static class PauseHistoryRecord {
        private final boolean isPaused;
        private long timestamp;

        private PauseHistoryRecord(boolean z, long j) {
            this.isPaused = z;
            this.timestamp = j;
        }

        public void updateTimestamp(long j) {
            this.timestamp = j;
        }

        public /* synthetic */ PauseHistoryRecord(boolean z, long j, int i) {
            this(z, j);
        }
    }

    public synchronized boolean isPaused() {
        return isPaused(System.currentTimeMillis());
    }

    private void updateGraphValue(final float[] fArr, boolean z) {
        Runnable runnable = new Runnable() { // from class: com.urbandroid.sleep.domain.AccelSleepRecorder.3
            @Override // java.lang.Runnable
            public void run() {
                AccelSleepRecorder.this.updateGraphValueWait(fArr);
            }
        };
        if (z) {
            runnable.run();
        } else {
            ThreadService.getInstance().scheduleForExecution(runnable);
        }
    }

    private void persist(IActivityAggregator.Result result) {
        persist(result, null);
    }

    private void persist(float[] fArr) {
        if (this.persister == null || fArr == null) {
            return;
        }
        for (float f : fArr) {
            persist(new IActivityAggregator.Result(f));
        }
    }
}
