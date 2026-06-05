package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class HrvGainExtractor implements IValueExtractor {
    private final Context context;

    public HrvGainExtractor(Context context) {
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
        return context == null ? "HRV" : context.getString(R.string.hrv_gain);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        float hrvAfter = iMeasureRecord.getHrvAfter();
        float hrvBefore = iMeasureRecord.getHrvBefore();
        if (hrvAfter == -1.0f || hrvBefore == -1.0f) {
            return -1.0E42d;
        }
        return hrvAfter - hrvBefore;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        StringBuilder sb = d < 0.0d ? new StringBuilder("") : new StringBuilder(MqttTopic.SINGLE_LEVEL_WILDCARD);
        sb.append(Math.round(d));
        return sb.toString();
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        return 0.0d;
    }
}
