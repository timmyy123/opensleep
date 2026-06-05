package com.urbandroid.sleep.sensor.extra;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.TimeType;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.extra.ExtraDataCollector;
import com.urbandroid.util.HeartRateUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/MedianHeartRateAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector$Buffered;", "Lcom/urbandroid/common/FeatureLogger;", "eventLabel", "Lcom/urbandroid/sleep/domain/EventLabel;", "window", "Lcom/urbandroid/common/Millis;", "minDelta", "", "maxExtrapolationTime", "Lcom/urbandroid/common/TimeType;", "<init>", "(Lcom/urbandroid/sleep/domain/EventLabel;JFLcom/urbandroid/common/TimeType;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "tag", "", "getTag", "()Ljava/lang/String;", "aggregate", "", "collector", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MedianHeartRateAggregator implements ExtraDataAggregator<ExtraDataCollector.Buffered>, FeatureLogger {
    private final EventLabel eventLabel;
    private final TimeType maxExtrapolationTime;
    private final float minDelta;
    private final String tag;
    private final long window;

    private MedianHeartRateAggregator(EventLabel eventLabel, long j, float f, TimeType timeType) {
        eventLabel.getClass();
        timeType.getClass();
        this.eventLabel = eventLabel;
        this.window = j;
        this.minDelta = f;
        this.maxExtrapolationTime = timeType;
        this.tag = "DataCollector MedianHeartRateAggregator ";
    }

    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataAggregator
    public void aggregate(ExtraDataCollector.Buffered collector, SleepRecord record) {
        collector.getClass();
        record.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long fromTime = record.getFromTime() + this.window;
        while (fromTime < jCurrentTimeMillis - this.window) {
            List<ExtraValue> listConsume = collector.consume(Long.valueOf(fromTime));
            if (!listConsume.isEmpty()) {
                List<ExtraValue> list = listConsume;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Float.valueOf(((ExtraValue) it.next()).getValue()));
                }
                float medianHeartRate = HeartRateUtilKt.getMedianHeartRate(CollectionsKt.toFloatArray(arrayList));
                List<IEvent> events = EventsUtil.getEvents(record.getEvents().getCopiedEvents(), this.eventLabel);
                events.getClass();
                IEvent iEvent = (IEvent) CollectionsKt.lastOrNull((List) events);
                if (medianHeartRate <= 0.0f) {
                    String str = Logger.defaultTag;
                    Logger.logSevere(str, getTag() + ": " + ("HR events: insufficient or invalid " + medianHeartRate + "}"), null);
                } else if (record.getEvents() != null) {
                    long j = fromTime - (this.window / 2);
                    if (iEvent != null && j - iEvent.getTimestamp() > this.maxExtrapolationTime.getMillis()) {
                        record.getEvents().addEvent(new Event(j, this.eventLabel, medianHeartRate));
                        String str2 = "Adding event after " + this.maxExtrapolationTime.getMinutes() + " min " + this.eventLabel + "=" + medianHeartRate + " @ " + Utils.getPrettyDate(j);
                        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
                    } else if (iEvent == null || Math.abs(iEvent.getValue() - medianHeartRate) >= this.minDelta) {
                        EventLabel eventLabel = this.eventLabel;
                        String prettyDate = Utils.getPrettyDate(j);
                        StringBuilder sb = new StringBuilder("Adding event ");
                        sb.append(eventLabel);
                        sb.append("=");
                        sb.append(medianHeartRate);
                        sb.append(" @ ");
                        String strM = FileInsert$$ExternalSyntheticOutline0.m(sb, prettyDate, " ");
                        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
                        record.getEvents().addEvent(new Event(j, this.eventLabel, medianHeartRate));
                    }
                } else {
                    String str3 = Logger.defaultTag;
                    Logger.logSevere(str3, getTag() + ": " + ("HR events: cannot record events. " + medianHeartRate), null);
                }
            }
            fromTime += this.window;
        }
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public /* synthetic */ MedianHeartRateAggregator(EventLabel eventLabel, long j, float f, TimeType timeType, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventLabel, j, f, timeType);
    }
}
