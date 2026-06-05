package com.urbandroid.sleep.service.health;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.health.api.SensorRecord;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0082\u0002\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0002¨\u0006\u000b"}, d2 = {"toEventLabel", "Lcom/urbandroid/sleep/domain/EventLabel;", "Lcom/urbandroid/sleep/service/health/api/SensorRecord;", "contains", "", "", "event", "Lcom/urbandroid/sleep/domain/IEvent;", "has", "Lcom/urbandroid/sleep/domain/SleepRecord;", "sensorRecord", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SensorSynchronizationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean contains(List<? extends SensorRecord> list, IEvent iEvent) {
        list.getClass();
        List<? extends SensorRecord> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (SensorRecord sensorRecord : list2) {
            if (toEventLabel(sensorRecord) == iEvent.getLabel() && sensorRecord.getFrom() == iEvent.getTimestamp() && sensorRecord.getValue() == iEvent.getValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean has(SleepRecord sleepRecord, SensorRecord sensorRecord) {
        return sleepRecord.getEvents().hasLabel(toEventLabel(sensorRecord), sensorRecord.getFrom(), sensorRecord.getValue());
    }

    private static final EventLabel toEventLabel(SensorRecord sensorRecord) {
        if (sensorRecord instanceof SensorRecord.HeartRate) {
            return EventLabel.HR;
        }
        if (sensorRecord instanceof SensorRecord.SPO2) {
            return EventLabel.SPO2;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }
}
