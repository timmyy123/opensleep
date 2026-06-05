package com.urbandroid.sleep.sensor.extra;

import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.sensor.extra.ExtraDataCollector;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/ExtraDataAggregator;", "C", "Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;", "", "aggregate", "", "collector", "record", "Lcom/urbandroid/sleep/domain/SleepRecord;", "(Lcom/urbandroid/sleep/sensor/extra/ExtraDataCollector;Lcom/urbandroid/sleep/domain/SleepRecord;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ExtraDataAggregator<C extends ExtraDataCollector> {
    void aggregate(C collector, SleepRecord record);
}
