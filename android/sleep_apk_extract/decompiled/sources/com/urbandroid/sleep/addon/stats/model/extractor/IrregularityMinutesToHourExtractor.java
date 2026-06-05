package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;

/* JADX INFO: loaded from: classes4.dex */
public class IrregularityMinutesToHourExtractor extends AbstractMinutesToHourValueExtractor {
    private Context context;

    public IrregularityMinutesToHourExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#irregularity";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.irregularity;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        Context context = this.context;
        return context != null ? context.getString(R.string.sleep_variance) : "Regularity";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        Context context = this.context;
        return context == null ? "h" : context.getString(R.string.axis_hour);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        float sleepIrregularityAgainstSettings;
        if (iMeasureRecord.getIrregularityInMinutes() != -1.0f) {
            sleepIrregularityAgainstSettings = iMeasureRecord.getIrregularityInMinutes();
        } else {
            if (!(iMeasureRecord instanceof StatRecord)) {
                return -1.0d;
            }
            sleepIrregularityAgainstSettings = SleeprecordExtKt.getSleepIrregularityAgainstSettings((StatRecord) iMeasureRecord) * 60.0f;
        }
        return sleepIrregularityAgainstSettings;
    }
}
