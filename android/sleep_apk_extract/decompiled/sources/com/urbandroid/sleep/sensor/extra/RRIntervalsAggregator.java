package com.urbandroid.sleep.sensor.extra;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.Events;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.extra.ExtraDataCollector;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0002J\u001e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0002J\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/RRIntervalsAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector$Buffered;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "windowSize", "", "median5", "Lcom/urbandroid/sleep/snoring/feature/FloatFunction;", "kotlin.jvm.PlatformType", "median13", "avgNNs", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "aggregate", "", "collector", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "createSdnnEvent", "windowStart", "nns", "", "updateSdannEvent", "computeNNs", "data", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RRIntervalsAggregator implements ExtraDataAggregator<ExtraDataCollector.Buffered>, FeatureLogger {
    private final String tag = "DataCollector RRIntervalsAggregator";
    private final long windowSize = Utils.getMinutesInMillis(5);
    private final FloatFunction median5 = Moving.quantilePrecise(5, 0.5f);
    private final FloatFunction median13 = Moving.quantilePrecise(13, 0.5f);
    private final ArrayList<Float> avgNNs = new ArrayList<>();

    private final void createSdnnEvent(SleepRecord record, long windowStart, List<Float> nns) {
        float fStddev = ScienceUtil.stddev(CollectionsKt.toFloatArray(nns));
        long j = (this.windowSize / 2) + windowStart;
        String str = Logger.defaultTag;
        Logger.logInfo(str, getTag() + ": " + ("aggregate: event: " + j + " " + fStddev), null);
        record.getEvents().addEvent(new Event(j, EventLabel.SDNN, fStddev));
    }

    private final void updateSdannEvent(SleepRecord record, List<Float> nns) {
        synchronized (this.avgNNs) {
            try {
                this.avgNNs.add(Float.valueOf(ScienceUtil.avg(CollectionsKt.toFloatArray(nns))));
                String str = "update avgNNs: " + this.avgNNs.size();
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
                if (this.avgNNs.size() >= 12) {
                    Events events = record.getEvents();
                    EventLabel eventLabel = EventLabel.SDANN;
                    events.clearLabels(eventLabel);
                    float fStddev = ScienceUtil.stddev(CollectionsKt.toFloatArray(this.avgNNs));
                    String str2 = "update sdann: " + fStddev + " " + this.avgNNs.size();
                    Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
                    record.getEvents().addEvent(new Event(record.getFromTime() + 1, eventLabel, fStddev));
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataAggregator
    public void aggregate(ExtraDataCollector.Buffered collector, SleepRecord record) {
        collector.getClass();
        record.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long fromTime = record.getFromTime();
        long secondsInMillis = Utils.getSecondsInMillis(30);
        while (true) {
            secondsInMillis += fromTime;
            long j = this.windowSize + secondsInMillis;
            if (j >= jCurrentTimeMillis) {
                return;
            }
            List<ExtraValue> listConsume = collector.consume(Long.valueOf(j));
            if (!listConsume.isEmpty()) {
                String str = "aggregate: data: " + listConsume.size() + " " + CollectionsKt.first((List<? extends Object>) listConsume) + " " + CollectionsKt.last((List<? extends Object>) listConsume);
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
                List<ExtraValue> list = listConsume;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Float.valueOf(((ExtraValue) it.next()).getValue()));
                }
                List<Float> listComputeNNs = computeNNs(arrayList);
                if (!listComputeNNs.isEmpty()) {
                    createSdnnEvent(record, secondsInMillis, listComputeNNs);
                    updateSdannEvent(record, listComputeNNs);
                }
            }
            fromTime = this.windowSize;
        }
    }

    public final List<Float> computeNNs(List<Float> data2) {
        data2.getClass();
        float f = (this.windowSize / 2000.0f) / 14.0f;
        int size = data2.size();
        ArrayList arrayList = new ArrayList();
        for (Object obj : data2) {
            float fFloatValue = ((Number) obj).floatValue();
            if (300.0f <= fFloatValue && fFloatValue <= 2000.0f) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            float fApply = this.median5.apply(((Number) obj2).floatValue());
            if (Math.abs(fApply - r4) / fApply <= 0.15d) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList2) {
            float fApply2 = this.median13.apply(((Number) obj3).floatValue());
            if (Math.abs(fApply2 - r4) / fApply2 <= 0.2d) {
                arrayList3.add(obj3);
            }
        }
        int size2 = arrayList3.size();
        float f2 = size2;
        float f3 = f2 / size;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(size, size2, "computeSDNN ", " ", " ");
        sbM.append(f3);
        sbM.append(" ");
        sbM.append(f);
        sbM.append(" ");
        sbM.append(arrayList3);
        String string = sbM.toString();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + string, null);
        if (f2 >= f && f3 >= 0.5d) {
            return arrayList3;
        }
        String strM = Fragment$$ExternalSyntheticOutline1.m(size, size2, "Not enough valid RR values: ", " ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        return CollectionsKt.emptyList();
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }
}
