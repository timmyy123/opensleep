package com.urbandroid.sleep.addon.stats.filter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FilterFactory {
    public static IFilter getFilter(int i, String str) {
        return i != 0 ? i != 1 ? i != 2 ? new TagFilter(str) : new WeekendFilter() : new WeekdaysFilter() : new AcceptAllFilter();
    }
}
