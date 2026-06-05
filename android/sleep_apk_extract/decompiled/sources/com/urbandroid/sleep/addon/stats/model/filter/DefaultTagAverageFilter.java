package com.urbandroid.sleep.addon.stats.model.filter;

import com.urbandroid.sleep.addon.stats.model.collector.Average;
import com.urbandroid.sleep.domain.tag.Tag;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultTagAverageFilter implements ITagAverageFilter {
    private final List<String> allowedTags;
    private final double minTagCoverage;
    private final int minTags;
    private final long totalRecordCount;

    public DefaultTagAverageFilter(long j, int i, double d) {
        this.totalRecordCount = j;
        this.minTags = i;
        this.minTagCoverage = d;
        this.allowedTags = new ArrayList();
        for (Tag tag : Tag.values()) {
            this.allowedTags.add(tag.getTagName());
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.model.filter.ITagAverageFilter
    public boolean accept(String str, Average average) {
        return this.allowedTags.contains(str) && average.getCount() >= this.minTags && ((double) average.getCount()) / ((double) this.totalRecordCount) >= this.minTagCoverage;
    }

    public DefaultTagAverageFilter(long j) {
        this(j, 30, 0.04d);
    }
}
