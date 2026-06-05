package com.urbandroid.sleep.addon.stats.model.extractor;

import com.urbandroid.util.DecimalFormatUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractPercentageValueExtractor implements IValueExtractor {
    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        return DecimalFormatUtil.getZeroDigit().format(d) + "%";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        return Double.parseDouble(str.substring(0, str.length() - 1));
    }
}
