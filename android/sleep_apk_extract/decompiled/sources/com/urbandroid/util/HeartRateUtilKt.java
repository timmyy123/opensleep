package com.urbandroid.util;

import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.Events;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0005¨\u0006\u0007"}, d2 = {"getMedianHeartRate", "", "hrs", "", "getHr", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getMinHr", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class HeartRateUtilKt {
    public static final float getHr(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        Events events = sleepRecord.getEvents();
        EventLabel eventLabel = EventLabel.HR;
        if (!events.hasLabel(eventLabel) || sleepRecord.getEvents().labelSize(eventLabel) <= 5) {
            return -1.0f;
        }
        List<IEvent> events2 = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), eventLabel);
        events2.getClass();
        List<IEvent> list = events2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((IEvent) it.next()).getValue()));
        }
        return getMedianHeartRate(CollectionsKt.toFloatArray(arrayList));
    }

    public static final float getMedianHeartRate(float[] fArr) {
        fArr.getClass();
        int length = fArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f = fArr[i2];
            if (f < 27.0f || f > 150.0f) {
                fArr[i2] = Float.NaN;
                i++;
            }
        }
        if (length - i >= length / 3) {
            return ScienceUtil.percentile(fArr, 50.0f);
        }
        return -1.0f;
    }

    public static final float getMinHr(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        Events events = sleepRecord.getEvents();
        EventLabel eventLabel = EventLabel.HR;
        if (!events.hasLabel(eventLabel) || sleepRecord.getEvents().labelSize(eventLabel) <= 5) {
            return -1.0f;
        }
        List<IEvent> events2 = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), eventLabel);
        events2.getClass();
        List<IEvent> list = events2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((IEvent) it.next()).getValue()));
        }
        Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) arrayList);
        if (fMinOrNull != null) {
            return fMinOrNull.floatValue();
        }
        return -1.0f;
    }
}
