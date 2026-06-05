package com.urbandroid.sleep.addon.stats.model.extractor;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMinuteValueExtractor implements IValueExtractor {
    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        return "" + Math.round(d);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        return Integer.parseInt(str);
    }
}
