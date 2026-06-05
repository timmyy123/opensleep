package com.urbandroid.sleep.addon.stats.model.aggregator;

import com.urbandroid.sleep.addon.stats.model.StatRecord;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IListAggregator {
    double aggregate(List<StatRecord> list);
}
