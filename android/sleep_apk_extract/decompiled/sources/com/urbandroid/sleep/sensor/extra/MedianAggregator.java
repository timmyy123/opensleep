package com.urbandroid.sleep.sensor.extra;

import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.TimeType;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.extra.ExtraDataCollector;
import com.urbandroid.util.ScienceUtil;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/MedianAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector$Buffered;", "Lcom/urbandroid/common/FeatureLogger;", "eventLabel", "Lcom/urbandroid/sleep/domain/EventLabel;", "window", "Lcom/urbandroid/common/TimeType;", "currentTimeMillis", "Lkotlin/Function0;", "", "<init>", "(Lcom/urbandroid/sleep/domain/EventLabel;Lcom/urbandroid/common/TimeType;Lkotlin/jvm/functions/Function0;)V", "tag", "", "getTag", "()Ljava/lang/String;", "aggregate", "", "collector", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MedianAggregator implements ExtraDataAggregator<ExtraDataCollector.Buffered>, FeatureLogger {
    private final Function0<Long> currentTimeMillis;
    private final EventLabel eventLabel;
    private final String tag;
    private final TimeType window;

    public MedianAggregator(EventLabel eventLabel, TimeType timeType, Function0<Long> function0) {
        eventLabel.getClass();
        timeType.getClass();
        function0.getClass();
        this.eventLabel = eventLabel;
        this.window = timeType;
        this.currentTimeMillis = function0;
        this.tag = "DataCollector MedianAggregator ";
    }

    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataAggregator
    public void aggregate(ExtraDataCollector.Buffered collector, SleepRecord record) {
        collector.getClass();
        record.getClass();
        long jLongValue = this.currentTimeMillis.invoke().longValue();
        long millis = this.window.getMillis();
        long fromTime = record.getFromTime();
        while (true) {
            long j = fromTime + millis;
            if (j >= jLongValue) {
                return;
            }
            List<ExtraValue> listConsume = collector.consume(Long.valueOf(j));
            if (!listConsume.isEmpty()) {
                List<ExtraValue> list = listConsume;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Float.valueOf(((ExtraValue) it.next()).getValue()));
                }
                float fPercentile = ScienceUtil.percentile(CollectionsKt.toFloatArray(arrayList), 50.0f);
                record.getEvents().addEvent(new Event((millis / 2) + fromTime, this.eventLabel, fPercentile));
            }
            fromTime = j;
        }
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public /* synthetic */ MedianAggregator(EventLabel eventLabel, TimeType timeType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventLabel, timeType, (i & 4) != 0 ? new HttpClientConfig$$ExternalSyntheticLambda4(9) : function0);
    }
}
