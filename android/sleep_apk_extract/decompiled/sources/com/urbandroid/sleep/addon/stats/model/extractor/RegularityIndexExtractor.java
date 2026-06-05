package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.util.DecimalFormatUtil;

/* JADX INFO: loaded from: classes4.dex */
public class RegularityIndexExtractor implements IValueExtractor {
    private Context context;

    public RegularityIndexExtractor(Context context) {
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
        return context != null ? context.getString(R.string.sleep_variance) : "SRI";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        return "%";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        if (iMeasureRecord.getIrregularityIndex() != -1.0f) {
            return iMeasureRecord.getIrregularityIndex();
        }
        return -1.0d;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getValuePresentation(double d) {
        if (d == -1.0d) {
            return "";
        }
        return DecimalFormatUtil.getZeroDigit().format(d * 100.0d) + getUnit();
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double parseValueFromPresentation(String str) {
        if ("".equals(str)) {
            return -1.0d;
        }
        return Double.parseDouble(str.substring(0, str.length() - 2).trim()) / 100.0d;
    }
}
