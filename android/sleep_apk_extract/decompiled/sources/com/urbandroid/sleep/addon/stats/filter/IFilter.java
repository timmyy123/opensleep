package com.urbandroid.sleep.addon.stats.filter;

import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "", "filter", "", "record", "Lcom/urbandroid/sleep/addon/stats/model/IStatRecord;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface IFilter {
    boolean filter(IStatRecord record);

    boolean filter(SleepRecord record);
}
