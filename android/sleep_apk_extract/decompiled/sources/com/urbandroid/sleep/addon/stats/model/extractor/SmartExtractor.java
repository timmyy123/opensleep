package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;

/* JADX INFO: loaded from: classes4.dex */
public class SmartExtractor extends AbstractValueExtractor {
    private Context context;

    public SmartExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.AbstractValueExtractor, com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#smart-wakeup";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.duration;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        Context context = this.context;
        return context == null ? "Smart Wake" : context.getString(R.string.settings_category_smart);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        Context context = this.context;
        return context == null ? "min" : context.getString(R.string.bed_time_min);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        return iMeasureRecord.getSmart();
    }
}
