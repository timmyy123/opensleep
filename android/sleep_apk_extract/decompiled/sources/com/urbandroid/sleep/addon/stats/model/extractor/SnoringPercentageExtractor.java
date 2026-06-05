package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;

/* JADX INFO: loaded from: classes4.dex */
public class SnoringPercentageExtractor extends AbstractPercentageValueExtractor {
    private Context context;

    public SnoringPercentageExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#snoring";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.snore;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        if (this.context == null) {
            return "Snoring %";
        }
        return this.context.getString(R.string.stats_caption_snore) + " %";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        return "%";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        return Math.round((((double) iMeasureRecord.getSnore()) / Math.max(((double) iMeasureRecord.getLengthInHours()) * 3600.0d, 1.0d)) * 100.0d);
    }
}
