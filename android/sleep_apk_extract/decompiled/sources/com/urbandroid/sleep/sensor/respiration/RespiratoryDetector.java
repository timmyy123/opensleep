package com.urbandroid.sleep.sensor.respiration;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector;", "", "detect", "", "data", "", "activity", "", "dataBroken", "trackingFinished", "RespiratoryListener", "NullRespiratoryListener", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface RespiratoryDetector {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector$NullRespiratoryListener;", "Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector$RespiratoryListener;", "<init>", "()V", "onBreathDetected", "", "timestamp", "", "halesPerMinute", "", "onApneaDetected", "numberOfApneaEvents", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class NullRespiratoryListener implements RespiratoryListener {
        @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector.RespiratoryListener
        public void onApneaDetected(long timestamp, int numberOfApneaEvents) {
        }

        @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector.RespiratoryListener
        public void onBreathDetected(long timestamp, int halesPerMinute) {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/sensor/respiration/RespiratoryDetector$RespiratoryListener;", "", "onBreathDetected", "", "timestamp", "", "halesPerMinute", "", "onApneaDetected", "numberOfApneaEvents", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface RespiratoryListener {
        void onApneaDetected(long timestamp, int numberOfApneaEvents);

        void onBreathDetected(long timestamp, int halesPerMinute);
    }

    void dataBroken();

    void detect(float[] data2, int activity);

    void trackingFinished();
}
