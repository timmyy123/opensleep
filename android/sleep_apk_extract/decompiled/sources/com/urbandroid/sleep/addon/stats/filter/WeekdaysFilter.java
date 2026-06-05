package com.urbandroid.sleep.addon.stats.filter;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/filter/WeekdaysFilter;", "Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "<init>", "()V", "weekendFilter", "Lcom/urbandroid/sleep/addon/stats/filter/WeekendFilter;", "filter", "", "record", "Lcom/urbandroid/sleep/addon/stats/model/IStatRecord;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WeekdaysFilter implements IFilter {
    private final WeekendFilter weekendFilter = new WeekendFilter();

    @Override // com.urbandroid.sleep.addon.stats.filter.IFilter
    public boolean filter(IStatRecord record) {
        record.getClass();
        return !this.weekendFilter.filter(record);
    }

    @Override // com.urbandroid.sleep.addon.stats.filter.IFilter
    public boolean filter(SleepRecord record) {
        record.getClass();
        return !this.weekendFilter.filter(record);
    }
}
