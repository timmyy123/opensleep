package com.urbandroid.sleep.sensor.respiration.v1;

import com.facebook.AuthenticationTokenClaims;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.respiration.RespiratoryDetector;

/* JADX INFO: loaded from: classes4.dex */
public class RespiratoryListenerV1 implements RespiratoryDetector.RespiratoryListener {
    private SleepRecord sleepRecord;

    public RespiratoryListenerV1(SleepRecord sleepRecord) {
        this.sleepRecord = sleepRecord;
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector.RespiratoryListener
    public void onApneaDetected(long j, int i) {
        if (EventsUtil.getEvents(this.sleepRecord.getEvents().getCopiedEvents(), j - AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED, j, EventLabel.RR).size() > 5) {
            this.sleepRecord.getEvents().addEvent(new Event(j, EventLabel.APNEA));
        }
    }

    @Override // com.urbandroid.sleep.sensor.respiration.RespiratoryDetector.RespiratoryListener
    public void onBreathDetected(long j, int i) {
        this.sleepRecord.getEvents().addEvent(new Event(j, EventLabel.RR, i));
    }
}
