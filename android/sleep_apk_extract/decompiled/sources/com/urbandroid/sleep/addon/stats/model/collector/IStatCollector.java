package com.urbandroid.sleep.addon.stats.model.collector;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface IStatCollector extends ICollector {
    List<String> getLabels();

    String getMeasureTitle();

    String getTitle();

    List<Double> getValues();
}
