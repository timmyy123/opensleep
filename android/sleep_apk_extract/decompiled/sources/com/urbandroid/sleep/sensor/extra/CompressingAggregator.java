package com.urbandroid.sleep.sensor.extra;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Minutes;
import com.urbandroid.common.Seconds;
import com.urbandroid.common.TimeType;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.extra.ExtraDataCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/CompressingAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataAggregator;", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;", "Lcom/urbandroid/common/FeatureLogger;", "eventLabel", "Lcom/urbandroid/sleep/domain/EventLabel;", "minValue", "", "minDelta", "maxExtrapolationTime", "Lcom/urbandroid/common/TimeType;", "maxFreq", "<init>", "(Lcom/urbandroid/sleep/domain/EventLabel;FFLcom/urbandroid/common/TimeType;Lcom/urbandroid/common/TimeType;)V", "tag", "", "getTag", "()Ljava/lang/String;", "aggregate", "", "collector", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CompressingAggregator implements ExtraDataAggregator<ExtraDataCollector>, FeatureLogger {
    private final EventLabel eventLabel;
    private final TimeType maxExtrapolationTime;
    private final TimeType maxFreq;
    private final float minDelta;
    private final float minValue;
    private final String tag;

    public /* synthetic */ CompressingAggregator(EventLabel eventLabel, float f, float f2, TimeType timeType, TimeType timeType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventLabel, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? 1.0f : f2, (i & 8) != 0 ? Minutes.m981boximpl(Utils.getMinutes(1)) : timeType, (i & 16) != 0 ? Seconds.m989boximpl(Utils.getSeconds(1)) : timeType2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.urbandroid.sleep.domain.Event, com.urbandroid.sleep.domain.IEvent] */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.urbandroid.sleep.domain.Event, com.urbandroid.sleep.domain.IEvent] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.urbandroid.sleep.domain.Event, com.urbandroid.sleep.domain.IEvent] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v11, types: [com.urbandroid.sleep.domain.Events] */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.urbandroid.sleep.domain.Events] */
    /* JADX WARN: Type inference failed for: r3v17, types: [com.urbandroid.sleep.domain.Events] */
    @Override // com.urbandroid.sleep.sensor.extra.ExtraDataAggregator
    public void aggregate(ExtraDataCollector collector, SleepRecord record) {
        List<ExtraValue> listListOf;
        collector.getClass();
        record.getClass();
        if (collector instanceof ExtraDataCollector.Buffered) {
            listListOf = ExtraDataCollector.Buffered.consume$default((ExtraDataCollector.Buffered) collector, null, 1, null);
        } else {
            if (!(collector instanceof ExtraDataCollector.SingleValue)) {
                Home$$ExternalSyntheticBUOutline0.m();
                return;
            }
            Float fValueOf = Float.valueOf(((ExtraDataCollector.SingleValue) collector).consume());
            if (fValueOf.floatValue() == -1.0f) {
                fValueOf = null;
            }
            listListOf = fValueOf != null ? CollectionsKt.listOf(new ExtraValue(fValueOf.floatValue(), System.currentTimeMillis())) : null;
        }
        List<IEvent> events = EventsUtil.getEvents(record.getEvents().getCopiedEvents(), this.eventLabel);
        events.getClass();
        ?? LastOrNull = CollectionsKt.lastOrNull((List<? extends ??>) events);
        if (listListOf != null) {
            for (ExtraValue extraValue : listListOf) {
                long timestamp = extraValue.getTimestamp();
                float value = extraValue.getValue();
                if (LastOrNull != 0) {
                    IEvent iEvent = (IEvent) LastOrNull;
                    float value2 = iEvent.getValue();
                    float f = this.minValue;
                    if (value2 >= f || value >= f) {
                        if (timestamp - iEvent.getTimestamp() > this.maxExtrapolationTime.getMillis() && value >= this.minValue) {
                            LastOrNull = new Event(1 + timestamp, this.eventLabel, value);
                            String str = "Adding event after " + this.maxExtrapolationTime.getMinutes() + " min " + this.eventLabel + "=" + value + " @ " + Utils.getPrettyDate(timestamp);
                            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
                            record.getEvents().addEvent(LastOrNull);
                        } else if (Math.abs(iEvent.getValue() - value) > this.minDelta && timestamp - iEvent.getTimestamp() > this.maxFreq.getMillis()) {
                            LastOrNull = new Event(1 + timestamp, this.eventLabel, value);
                            String str2 = "Adding event " + this.eventLabel + "=" + value + " @ " + Utils.getPrettyDate(timestamp);
                            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
                            record.getEvents().addEvent(LastOrNull);
                        }
                    }
                } else {
                    LastOrNull = new Event(timestamp, this.eventLabel, value);
                    String str3 = "Adding first event " + this.eventLabel + "=" + value + " @ " + Utils.getPrettyDate(timestamp);
                    Logger.logInfo(Logger.defaultTag, getTag() + ": " + str3, null);
                    record.getEvents().addEvent(LastOrNull);
                }
            }
        }
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public CompressingAggregator(EventLabel eventLabel, float f, float f2, TimeType timeType, TimeType timeType2) {
        eventLabel.getClass();
        timeType.getClass();
        timeType2.getClass();
        this.eventLabel = eventLabel;
        this.minValue = f;
        this.minDelta = f2;
        this.maxExtrapolationTime = timeType;
        this.maxFreq = timeType2;
        this.tag = "DataCollector CompressingAggregator ";
    }
}
