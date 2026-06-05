package com.urbandroid.sleep.sensor.respiration.v2;

import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/v2/RespiratoryListenerV2;", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector$RespiratoryListener;", "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "<init>", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "onBreathDetected", "", "timestamp", "", "halesPerMinute", "", "onApneaDetected", "numberOfApneaEvents", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RespiratoryListenerV2 implements RespiratoryDetector.RespiratoryListener {
    private final SleepRecord sleepRecord;

    public RespiratoryListenerV2(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        this.sleepRecord = sleepRecord;
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector.RespiratoryListener
    public void onApneaDetected(long timestamp, int numberOfApneaEvents) {
        this.sleepRecord.getEvents().addEvent(new Event(timestamp, EventLabel.APNEA));
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector.RespiratoryListener
    public void onBreathDetected(long timestamp, int halesPerMinute) {
        this.sleepRecord.getEvents().addEvent(new Event(timestamp, EventLabel.RR, halesPerMinute));
    }
}
