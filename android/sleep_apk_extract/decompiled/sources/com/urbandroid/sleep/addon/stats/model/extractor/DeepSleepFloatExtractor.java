package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;

/* JADX INFO: loaded from: classes4.dex */
public class DeepSleepFloatExtractor extends AbstractPercentageFloatValueExtractor {
    private Context context;

    public DeepSleepFloatExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#deep-sleep";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.score_deep_sleep;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        if (this.context == null) {
            return "Deep sleep %";
        }
        return this.context.getString(R.string.label_deep_sleep) + " %";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        return "%";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        return iMeasureRecord.getQuality();
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.AbstractPercentageFloatValueExtractor, com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        return Math.round(d * 100.0d) + "%";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.AbstractPercentageFloatValueExtractor, com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        return Double.parseDouble(str.substring(0, str.length() - 1)) / 100.0d;
    }
}
