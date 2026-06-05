package com.urbandroid.sleep.addon.stats.filter;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/filter/WeekendFilter;", "Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "<init>", "()V", "filter", "", "record", "Lcom/urbandroid/sleep/addon/stats/model/IStatRecord;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "date", "Ljava/util/Date;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WeekendFilter implements IFilter {
    private final boolean filter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(7) == 1 || calendar.get(7) == 7;
    }

    @Override // com.urbandroid.sleep.addon.stats.filter.IFilter
    public boolean filter(SleepRecord record) {
        record.getClass();
        Date to = record.getTo();
        if (to != null) {
            return filter(to);
        }
        return false;
    }

    @Override // com.urbandroid.sleep.addon.stats.filter.IFilter
    public boolean filter(IStatRecord record) {
        record.getClass();
        Date toDate = record.getToDate();
        toDate.getClass();
        return filter(toDate);
    }
}
