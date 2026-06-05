package com.urbandroid.sleep.addon.stats.model.extractor;

import com.urbandroid.common.util.DateUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMinutesToHourValueExtractor implements IValueExtractor {
    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        return DateUtil.formatDuration((int) d);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        if (str.split(":").length != 2) {
            return Double.parseDouble(str);
        }
        return Integer.parseInt(r2[1]) + (Integer.parseInt(r2[0]) * 60);
    }
}
