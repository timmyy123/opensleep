package com.urbandroid.sleep.addon.stats.model;

import java.util.Date;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface IStatRecord extends IMeasureRecord {
    int getCount();

    double getFromHour();

    Set<String> getTags();

    Date getToDate();
}
