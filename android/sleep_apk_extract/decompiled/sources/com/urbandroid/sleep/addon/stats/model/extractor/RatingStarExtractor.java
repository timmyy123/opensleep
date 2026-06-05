package com.urbandroid.sleep.addon.stats.model.extractor;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;

/* JADX INFO: loaded from: classes4.dex */
public class RatingStarExtractor extends AbstractValueExtractor {
    private Context context;

    public RatingStarExtractor(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.AbstractValueExtractor, com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#rating";
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public int getMeasureColor() {
        return R.color.rating;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getMeasureName() {
        Context context = this.context;
        return context == null ? "Rating" : context.getString(R.string.axis_rating);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public String getUnit() {
        Context context = this.context;
        return context == null ? "*" : context.getString(R.string.axis_rating);
    }

    @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
    public double getValue(IMeasureRecord iMeasureRecord) {
        return iMeasureRecord.getRating();
    }
}
