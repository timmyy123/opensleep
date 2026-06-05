package com.urbandroid.sleep.gui;

import com.urbandroid.sleep.gui.IFilterListAdapter;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseFilter implements IFilterListAdapter.IFilter {
    private String filterString;
    private long from;
    private boolean starred;
    private long to;

    public NoiseFilter(NoiseFilter noiseFilter) {
        this.filterString = noiseFilter.getFilterString();
        this.starred = noiseFilter.isStarred();
        this.from = noiseFilter.getFrom();
        this.to = noiseFilter.getTo();
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter.IFilter
    public String getFilterString() {
        return this.filterString;
    }

    public long getFrom() {
        return this.from;
    }

    public long getTo() {
        return this.to;
    }

    public boolean isStarred() {
        return this.starred;
    }

    public void setFilterString(String str) {
        this.filterString = str;
    }

    public void setFrom(long j) {
        this.from = j;
    }

    public void setStarred(boolean z) {
        this.starred = z;
    }

    public NoiseFilter(String str, boolean z, long j, long j2) {
        this.filterString = str;
        this.starred = z;
        this.from = j;
        this.to = j2;
    }
}
