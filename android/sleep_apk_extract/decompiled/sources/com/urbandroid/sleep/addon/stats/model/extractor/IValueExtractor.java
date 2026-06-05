package com.urbandroid.sleep.addon.stats.model.extractor;

import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;

/* JADX INFO: loaded from: classes4.dex */
public interface IValueExtractor {
    String getHelpUrl();

    int getMeasureColor();

    String getMeasureName();

    String getUnit();

    double getValue(IMeasureRecord iMeasureRecord);

    String getValuePresentation(double d);

    double parseValueFromPresentation(String str);
}
