package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.util.DecimalFormatUtil;

/* JADX INFO: loaded from: classes4.dex */
public class IrregularityIndexChartExtractor implements IValueExtractor {
    private Context context;

    public IrregularityIndexChartExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#chart_sri";
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
        if (this.context == null) {
            return "SRI %";
        }
        return this.context.getString(R.string.irregularity_index_short) + " %";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        double irregularityIndex = iMeasureRecord.getIrregularityIndex();
        if (irregularityIndex == -1.0d) {
            return -1.0E42d;
        }
        return irregularityIndex * 100.0d;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        if (d == -1.0d) {
            return "";
        }
        return getUnit() + " " + DecimalFormatUtil.getZeroDigit().format(d * 100.0d);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        if ("".equals(str)) {
            return -1.0d;
        }
        return Double.parseDouble(str.substring(getUnit().length(), str.length() - 1).trim()) / 100.0d;
    }
}
