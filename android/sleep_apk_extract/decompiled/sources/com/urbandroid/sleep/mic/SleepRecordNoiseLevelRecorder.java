package com.urbandroid.sleep.mic;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.audio.NoiseLevelRecorder;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.util.Experiments;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRecordNoiseLevelRecorder implements NoiseLevelRecorder {
    private static final long BUCKET_LENGTH_SECONDS = SleepService.FRAMERATE / 1000;
    private float currentBucketMaximum;
    private long currentBucketStartTimestamp;
    private final SleepRecord currentRecord;
    private boolean fillingEnabled = true;

    public SleepRecordNoiseLevelRecorder(SleepRecord sleepRecord) {
        this.currentBucketStartTimestamp = 0L;
        this.currentRecord = sleepRecord;
        this.currentBucketStartTimestamp = (sleepRecord == null || sleepRecord.getHistory().size() == 0) ? System.currentTimeMillis() : sleepRecord.getFrom().getTime() + ((long) (sleepRecord.getHistory().size() * SleepService.FRAMERATE));
    }

    @Override // com.urbandroid.sleep.audio.NoiseLevelRecorder
    public void addNoiseLevel(float f) {
        SleepRecord sleepRecord = this.currentRecord;
        if (sleepRecord == null || sleepRecord.isFinished()) {
            return;
        }
        backfillPointsIfRequired();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - (BUCKET_LENGTH_SECONDS * 1000) <= this.currentBucketStartTimestamp) {
            if (f > this.currentBucketMaximum) {
                this.currentBucketMaximum = f;
                return;
            }
            return;
        }
        int noiseRecordCount = this.currentRecord.getNoiseRecordCount();
        this.currentRecord.addNoiseRecordIfNotFinished(this.currentBucketMaximum);
        this.currentBucketMaximum = f;
        this.currentBucketStartTimestamp = jCurrentTimeMillis;
        if (Experiments.getInstance().isMoreDebuggingExperiment()) {
            int noiseRecordCount2 = this.currentRecord.getNoiseRecordCount();
            if (noiseRecordCount / 100 != noiseRecordCount2 / 100) {
                List<Float> noiseHistory = this.currentRecord.getNoiseHistory();
                ListIterator<Float> listIterator = noiseHistory.listIterator(noiseHistory.size());
                String string = "";
                for (int i = 0; listIterator.hasPrevious() && i < 100; i++) {
                    StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(string);
                    sbM.append(String.valueOf(listIterator.previous()));
                    sbM.append(", ");
                    string = sbM.toString();
                }
                Logger.logDebug("NOISE RecLen: " + noiseRecordCount2 + " Last few record: " + string + " ..");
            }
        }
    }

    public void backfillPointsIfRequired() {
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.fillingEnabled) {
            i = (int) ((jCurrentTimeMillis - this.currentBucketStartTimestamp) / ((long) SleepService.FRAMERATE));
            if (i > 1) {
                StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Filling ", " missing noise points. Last update: ");
                sbM65m.append(this.currentBucketStartTimestamp);
                sbM65m.append(" vs now ");
                sbM65m.append(jCurrentTimeMillis);
                Logger.logDebug(sbM65m.toString());
            }
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i - 1; i2++) {
            SleepRecord sleepRecord = this.currentRecord;
            if (sleepRecord != null) {
                sleepRecord.addNoiseRecordIfNotFinished(-0.001f);
                this.currentBucketStartTimestamp += (long) SleepService.FRAMERATE;
            }
        }
    }

    public void disableFilling() {
        this.fillingEnabled = false;
    }
}
