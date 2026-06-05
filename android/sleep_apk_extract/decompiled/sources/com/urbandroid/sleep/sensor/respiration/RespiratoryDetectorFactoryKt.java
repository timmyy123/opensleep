package com.urbandroid.sleep.sensor.respiration;

import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;
import com.urbandroid.sleep.sensor.respiration.v1.RespiratoryDetectorV1;
import com.urbandroid.sleep.sensor.respiration.v1.RespiratoryListenerV1;
import com.urbandroid.sleep.sensor.respiration.v2.BreathLoggerKt;
import com.urbandroid.sleep.sensor.respiration.v2.ClockKt;
import com.urbandroid.sleep.sensor.respiration.v2.PostProcessRespiratoryEventsKt;
import com.urbandroid.sleep.sensor.respiration.v2.RespiratoryDetectorV21;
import com.urbandroid.sleep.sensor.respiration.v2.RespiratoryListenerV2;
import com.urbandroid.util.Experiments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"createRespiratoryDetector", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector;", "sampleRate", "", "postProcessRespiratoryEvents", "", "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class RespiratoryDetectorFactoryKt {
    public static final RespiratoryDetector createRespiratoryDetector(float f) {
        Experiments experiments = Experiments.getInstance();
        SleepRecord record = CurrentSleepRecord.getInstance().getRecord();
        if (!experiments.isRespiratoryDetectionV2Experiment()) {
            return new RespiratoryDetectorV1(f, record == null ? new RespiratoryDetector.NullRespiratoryListener() : new RespiratoryListenerV1(record));
        }
        return new RespiratoryDetectorV21(f, ClockKt.systemClock(), experiments.isRespiratoryDetailsPersistentExperiment() ? BreathLoggerKt.androidSleepDataLogger() : null, record == null ? new RespiratoryDetector.NullRespiratoryListener() : new RespiratoryListenerV2(record));
    }

    public static final void postProcessRespiratoryEvents(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        if (Experiments.getInstance().isRespiratoryDetectionV2Experiment()) {
            PostProcessRespiratoryEventsKt.postProcessRespiratoryEvents(sleepRecord);
        } else {
            RespiratoryDetectorV1.postProcessRespiratoryEvents(sleepRecord);
        }
    }
}
