package com.urbandroid.sleep.sensor.respiration.v2;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.apache.commons.math3.stat.StatUtils;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"postProcessRespiratoryEvents", "", "sleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class PostProcessRespiratoryEventsKt {
    public static final void postProcessRespiratoryEvents(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        Logger.logInfo("RespiratoryDetectorV2: postProcessRespiratoryEvents");
        Events events = sleepRecord.getEvents();
        List<IEvent> events2 = EventsUtil.getEvents(events.getCopiedEvents(), EventLabel.RR);
        events2.getClass();
        List<IEvent> list = events2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(((IEvent) it.next()).getValue()));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        double d = StatUtils.mode(CollectionsKt___CollectionsKt.toDoubleArray(arrayList))[0];
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Number) obj).doubleValue() == d) {
                arrayList2.add(obj);
            }
        }
        int size = arrayList2.size();
        double size2 = ((double) size) / ((double) arrayList.size());
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(arrayList.size(), size, "RespiratoryDetectorV2: RR count: ", " ", " ");
        sbM.append(size2);
        Logger.logInfo(sbM.toString());
        if (size2 >= 0.8d) {
            Logger.logInfo("RespiratoryDetectorV2: too high sameRatesRatio, removing all respiration-related events. " + size2);
            events.clearLabels(EventLabel.RR, EventLabel.APNEA);
        }
    }
}
