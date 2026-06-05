package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;

/* JADX INFO: loaded from: classes4.dex */
public class FallAsleepMinutesExtractor extends AbstractMinuteValueExtractor {
    private Context context;

    public FallAsleepMinutesExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#fall-asleep-hour";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.efficiency;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        Context context = this.context;
        return context != null ? context.getString(R.string.fall_asleep_time) : "Fall asleep time";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        Context context = this.context;
        return context == null ? "min" : context.getString(R.string.bed_time_min);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        if (!(iMeasureRecord instanceof StatRecord)) {
            return 0.0d;
        }
        StatRecord statRecord = (StatRecord) iMeasureRecord;
        return (statRecord.getFallAsleep() - statRecord.getFromDate().getTime()) / 60000.0d;
    }
}
