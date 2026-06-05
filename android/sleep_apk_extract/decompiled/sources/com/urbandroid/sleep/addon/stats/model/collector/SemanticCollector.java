package com.urbandroid.sleep.addon.stats.model.collector;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.addon.stats.model.extractor.BedtimeHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DurationExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.model.regression.RegressionCollector;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SemanticCollector implements IStatCollector {
    private DurationCollector durationCollector;
    private RegressionCollector durationRegressionCollector;
    private IValueExtractor measureExtractor;
    private BeforeMidnightCollector midnightCollector;
    private RegressionCollector midnightRegressionCollector;
    private TagMapStatCollector tagCollector;
    private WeekdayCollector weekdayCollector;
    private Date yearLimit;

    public SemanticCollector(Context context, Measure measure, String... strArr) {
        IValueExtractor extractor = measure.getExtractor(context);
        this.measureExtractor = extractor;
        this.weekdayCollector = new WeekdayCollector(extractor, strArr[0]);
        this.durationCollector = new DurationCollector(this.measureExtractor, strArr[1]);
        this.midnightCollector = new BeforeMidnightCollector(this.measureExtractor, strArr[2]);
        this.tagCollector = new TagMapStatCollector(context, measure, strArr[3]);
        this.midnightRegressionCollector = new RegressionCollector(new BedtimeHourExtractor(context), this.measureExtractor);
        this.durationRegressionCollector = new RegressionCollector(new DurationExtractor(context), this.measureExtractor);
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -365);
        this.yearLimit = calendar.getTime();
    }

    public RegressionCollector getDurationRegressionCollector() {
        return this.durationRegressionCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public List<String> getLabels() {
        return null;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public String getMeasureTitle() {
        return null;
    }

    public BeforeMidnightCollector getMidnightCollector() {
        return this.midnightCollector;
    }

    public RegressionCollector getMidnightRegressionCollector() {
        return this.midnightRegressionCollector;
    }

    public TagMapStatCollector getTagCollector() {
        return this.tagCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public String getTitle() {
        return null;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.IStatCollector
    public List<Double> getValues() {
        return null;
    }

    public WeekdayCollector getWeekdayCollector() {
        return this.weekdayCollector;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.collector.ICollector
    public void put(IStatRecord iStatRecord) {
        this.weekdayCollector.put(iStatRecord);
        this.durationCollector.put(iStatRecord);
        this.midnightCollector.put(iStatRecord);
        if (iStatRecord.getToDate().after(this.yearLimit)) {
            this.midnightRegressionCollector.put(iStatRecord);
            this.durationRegressionCollector.put(iStatRecord);
        }
        this.tagCollector.put(iStatRecord);
    }
}
