package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;

/* JADX INFO: loaded from: classes4.dex */
public class HrvBeforeExtractor extends AbstractMinuteValueExtractor {
    private final Context context;

    public HrvBeforeExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/hrv-tracking/";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.hrv;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        Context context = this.context;
        return context == null ? "HRV" : context.getString(R.string.hrv_before);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        float hrvBefore = iMeasureRecord.getHrvBefore();
        if (hrvBefore == -1.0f) {
            return -1.0E42d;
        }
        return hrvBefore;
    }
}
