package com.urbandroid.sleep.addon.stats.model.extractor;

import com.urbandroid.common.util.DateUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractHourValueExtractor implements IValueExtractor {
    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        return DateUtil.formatDuration((int) Math.round(d * 60.0d));
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2) {
            return Double.parseDouble(str);
        }
        return (((double) Integer.parseInt(strArrSplit[1])) / 60.0d) + ((double) Integer.parseInt(strArrSplit[0]));
    }
}
