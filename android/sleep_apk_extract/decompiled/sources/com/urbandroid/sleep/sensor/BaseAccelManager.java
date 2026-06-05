package com.urbandroid.sleep.sensor;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.Experiments;
import com.urbandroid.util.StringBufferPersister;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseAccelManager implements IAccelManager {
    private long batchSize;
    private StringBufferPersister bufferPersister;
    private long countOfChangesSinceStart;
    private long firstBatchTimestamp;
    private final int framerate;
    private final boolean isNewActigraphy;
    private long lastBatchTimestamp;
    private long latestFinishedPeriodTime;
    private final int maxBatchSize;
    private float nonBatchingChange;
    private long periodBoundaryBaseTime;
    private long startTimestamp;
    private float accelX = 0.0f;
    private float accelY = 0.0f;
    private float accelZ = 0.0f;
    private boolean firstValue = true;
    private int countOfZeroValuesInRow = 0;
    private LinkedList<Float> bachedRawChanges = new LinkedList<>();
    private long lastBatchTimestampChangeTime = 0;
    private long compensationOffset = 0;
    private List<Float> aggregatedValues = new LinkedList();
    private boolean batchInProgress = false;
    private long rawLastEventTimestampDebugOnly = 0;

    public BaseAccelManager(int i, int i2, boolean z) {
        this.maxBatchSize = i;
        this.framerate = i2;
        if (Experiments.getInstance().isRawActigraphyPersistentExperiment()) {
            this.bufferPersister = new StringBufferPersister("Activity_raw", 10000, true);
        }
        this.isNewActigraphy = z;
    }

    private synchronized void aggregateFinishedBatches() {
        try {
            long j = this.firstBatchTimestamp;
            if (j == 0) {
                return;
            }
            if (this.periodBoundaryBaseTime == 0) {
                this.periodBoundaryBaseTime = j;
                this.latestFinishedPeriodTime = j;
            }
            LinkedList linkedList = new LinkedList();
            long j2 = this.latestFinishedPeriodTime;
            int i = this.framerate;
            while (true) {
                j2 += (long) i;
                if (j2 >= this.lastBatchTimestamp) {
                    this.aggregatedValues.addAll(linkedList);
                    return;
                }
                long j3 = this.firstBatchTimestamp;
                float f = (j2 - j3) / (r3 - j3);
                int size = (int) (this.bachedRawChanges.size() * f);
                Logger.logInfo("Batch finished. Finished count: " + size + " Finish ratio: " + f + " Batch end time: " + j2 + " Last batch event: " + this.lastBatchTimestamp);
                float f2 = 0.0f;
                while (size > 0) {
                    LinkedList<Float> linkedList2 = this.bachedRawChanges;
                    if (linkedList2 == null || linkedList2.size() <= 0) {
                        break;
                    }
                    float fFloatValue = this.bachedRawChanges.removeFirst().floatValue();
                    if (fFloatValue > f2) {
                        f2 = fFloatValue;
                    }
                    size--;
                }
                linkedList.add(Float.valueOf(f2));
                this.firstBatchTimestamp = j2;
                this.latestFinishedPeriodTime = j2;
                i = this.framerate;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized float[] resetChangesBatched(boolean z) {
        try {
            aggregateFinishedBatches();
            int i = 0;
            if (!z && this.latestFinishedPeriodTime + ((long) (this.framerate / 2)) < System.currentTimeMillis()) {
                if (this.aggregatedValues.size() > 0) {
                    Logger.logInfo("Ignoring aggreagation. LFPT: " + this.latestFinishedPeriodTime + " CO: " + this.compensationOffset + " Now: " + System.currentTimeMillis());
                }
                return new float[0];
            }
            int size = this.aggregatedValues.size();
            float[] fArr = new float[size];
            Iterator<Float> it = this.aggregatedValues.iterator();
            while (it.hasNext()) {
                fArr[i] = it.next().floatValue();
                i++;
            }
            Logger.logInfo("Flushed " + size + " aggregated periods.");
            this.aggregatedValues.clear();
            return fArr;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void batchFlushFinished() {
        try {
            if (this.batchSize > 0) {
                Logger.logInfo("Got batch of size: " + this.batchSize + " Last batch timestamp " + this.lastBatchTimestamp + " Debug only timestamp: " + this.rawLastEventTimestampDebugOnly);
            }
            this.batchSize = 0L;
            this.batchInProgress = false;
            aggregateFinishedBatches();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void batchFlushStarted() {
        this.batchSize = 0L;
        this.batchInProgress = true;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public synchronized int getCountOfZeroValuesInRow() {
        return this.countOfZeroValuesInRow;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxBatchSize() {
        return this.maxBatchSize;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public int getMaxDelayedPoints() {
        return 0;
    }

    public synchronized void measurementRestarted() {
        this.firstValue = true;
        if (this.maxBatchSize > 0) {
            this.firstBatchTimestamp = System.currentTimeMillis();
            this.compensationOffset = 0L;
            this.periodBoundaryBaseTime = 0L;
            this.latestFinishedPeriodTime = 0L;
            this.lastBatchTimestamp = 0L;
            this.lastBatchTimestampChangeTime = 0L;
            this.bachedRawChanges.clear();
            this.aggregatedValues.clear();
            this.countOfChangesSinceStart = 0L;
            this.batchInProgress = false;
            this.batchSize = 0L;
            this.countOfZeroValuesInRow = 0;
        }
    }

    public void onValuesUpdate(float f, float f2, float f3, long j) {
        this.rawLastEventTimestampDebugOnly = j;
        if (this.firstValue) {
            this.startTimestamp = System.currentTimeMillis();
            this.countOfChangesSinceStart = 0L;
        }
        if (this.batchInProgress) {
            this.batchSize++;
        }
        if (this.isNewActigraphy) {
            onValuesUpdateNew(f, f2, f3, j);
        } else {
            onValuesUpdateLegacy(f, f2, f3, j);
        }
        StringBufferPersister stringBufferPersister = this.bufferPersister;
        if (stringBufferPersister != null) {
            stringBufferPersister.update(f + "," + f2 + "," + f3 + "\n");
        }
        this.countOfChangesSinceStart++;
        this.firstValue = false;
    }

    public void onValuesUpdateLegacy(float f, float f2, float f3, long j) {
        float f4 = this.accelX - f;
        float f5 = this.accelY - f2;
        float f6 = this.accelZ - f3;
        if (f4 < 0.0f) {
            f4 = -f4;
        }
        if (f5 < 0.0f) {
            f5 = -f5;
        }
        if (f6 < 0.0f) {
            f6 = -f6;
        }
        int i = this.maxBatchSize;
        boolean z = this.firstValue;
        if (i == 1) {
            updateNonBatchingChange(z ? 0.0f : f4 + f5 + f6);
        } else {
            updateBatchingChange(z ? 0.0f : f4 + f5 + f6, j);
        }
        this.accelX = f;
        this.accelY = f2;
        this.accelZ = f3;
    }

    public void onValuesUpdateNew(float f, float f2, float f3, long j) {
        float f4 = f3 * f3;
        float fSqrt = (float) Math.sqrt(f4 + (f2 * f2) + (f * f));
        int i = this.maxBatchSize;
        boolean z = this.firstValue;
        if (i == 1) {
            if (z) {
                fSqrt = 0.0f;
            }
            updateNonBatchingChange(fSqrt);
        } else {
            if (z) {
                fSqrt = 0.0f;
            }
            updateBatchingChange(fSqrt, j);
        }
    }

    public synchronized float resetChangeNonBatched() {
        float f;
        try {
            f = this.nonBatchingChange;
            if (f == 0.0f) {
                this.countOfZeroValuesInRow++;
            } else {
                this.countOfZeroValuesInRow = 0;
            }
            this.nonBatchingChange = 0.0f;
        } catch (Throwable th) {
            throw th;
        }
        return f;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public float[] resetChanges(boolean z) {
        return this.maxBatchSize == 1 ? new float[]{resetChangeNonBatched()} : resetChangesBatched(z);
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public synchronized void resetZerosCount() {
        this.countOfZeroValuesInRow = 0;
    }

    @Override // com.urbandroid.sleep.sensor.IAccelManager
    public void stop() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis > this.startTimestamp) {
            Logger.logInfo("Accel total values received: " + this.countOfChangesSinceStart + " Values per second: " + ((this.countOfChangesSinceStart * 1000) / (jCurrentTimeMillis - this.startTimestamp)));
        }
        StringBufferPersister stringBufferPersister = this.bufferPersister;
        if (stringBufferPersister != null) {
            stringBufferPersister.flush();
        }
    }

    public synchronized void updateBatchingChange(float f, long j) {
        boolean z;
        try {
            long jCurrentTimeMillis = j - System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis) < 10000) {
                if (this.compensationOffset != 0) {
                    Logger.logInfo("Forcing no comp offset -> raw diff is: " + jCurrentTimeMillis);
                }
                this.compensationOffset = 0L;
                z = true;
            } else {
                z = false;
            }
            long j2 = j + this.compensationOffset;
            long j3 = this.lastBatchTimestamp;
            long j4 = j2 - j3;
            if (!z && j3 != 0 && Math.abs(j4) > 60000) {
                if (Experiments.getInstance().isNewBatchingCompensationAlgorithm()) {
                    this.compensationOffset += -j4;
                    j2 = this.lastBatchTimestamp;
                    Logger.logInfo("Weird timestamp update! Got batch with more than 1 minutes difference. Timestamp received: " + j2 + " Diff: " + j4 + " New offset: " + this.compensationOffset);
                } else {
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - this.lastBatchTimestampChangeTime;
                    int i = this.framerate;
                    long j5 = this.latestFinishedPeriodTime + ((long) i);
                    long j6 = 0;
                    for (long j7 = j2 - ((long) i); j5 < j7; j7 = j7) {
                        j5 += (long) this.framerate;
                        j6++;
                    }
                    this.latestFinishedPeriodTime = j5;
                    this.firstBatchTimestamp = j5;
                    Logger.logInfo("Weird timestamp update! Got batch with more than 1 minutes difference. Timestamp received: " + j2 + " Diff: " + j4 + "  Estimated real diff: " + jCurrentTimeMillis2 + ". Skipped: " + j6);
                }
            }
            this.lastBatchTimestamp = j2;
            this.lastBatchTimestampChangeTime = System.currentTimeMillis();
            this.bachedRawChanges.add(Float.valueOf(f));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void updateNonBatchingChange(float f) {
        if (f > this.nonBatchingChange) {
            this.nonBatchingChange = f;
        }
    }
}
