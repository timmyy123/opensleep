package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;

/* JADX INFO: loaded from: classes4.dex */
public class DeepSleepLengthExtractor extends AbstractHourValueExtractor {
    private Context context;

    public DeepSleepLengthExtractor(Context context) {
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
        Context context = this.context;
        return context == null ? "Deep sleep " : context.getString(R.string.label_deep_sleep);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        Context context = this.context;
        return context == null ? "h" : context.getString(R.string.axis_hour);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        return iMeasureRecord.getLengthInHours() * iMeasureRecord.getQuality();
    }
}
