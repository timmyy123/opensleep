package com.urbandroid.sleep.addon.stats.model.aggregator;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.IStatRecord;
import com.urbandroid.sleep.addon.stats.model.collector.ICollector;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepFloatExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepLengthExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DurationExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvAfterExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RegularityIndexExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoozeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoringExtractor;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class PeriodAggregators {
    private Set<ICollector> aggregators = new HashSet();
    private MeasureAverageAggregator deepSleepAggregator;
    private MeasureAverageAggregator deepSleepLengthAggregator;
    private Date from;
    private MeasureAverageAggregator hrAggregator;
    private MeasureAverageAggregator hrvAfterAggregator;
    private MeasureAverageAggregator hrvAggregator;
    private MeasureAverageAggregator lengthAggregator;
    private SleepIrregularityMeasureAggregator sleepIrregularityMeasureAggregator;
    private MeasureAverageAggregator sleepRegularityIndexMeasureAggregator;
    private MeasureAverageAggregator snoozeAggregator;
    private MeasureAverageAggregator snoringAggregator;
    private SocialJetLagMeasureAggregator socialJetLagMeasureAggregator;
    private TagAggregator tagAggregator;
    private Date to;

    public PeriodAggregators(Context context, Date date, Date date2) {
        this.snoringAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new SnoringExtractor(context)));
        this.lengthAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new DurationExtractor(context)));
        this.deepSleepAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new DeepSleepFloatExtractor(context)));
        this.deepSleepLengthAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new DeepSleepLengthExtractor(context)));
        this.hrvAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new HrvExtractor(context)));
        this.hrvAfterAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new HrvAfterExtractor(context)));
        this.hrAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new HrExtractor(context)));
        this.tagAggregator = (TagAggregator) addAggegator(new TagAggregator(date, date2));
        this.snoozeAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new SnoozeExtractor(context)));
        this.socialJetLagMeasureAggregator = (SocialJetLagMeasureAggregator) addAggegator(new SocialJetLagMeasureAggregator(date, date2, context));
        this.sleepIrregularityMeasureAggregator = (SleepIrregularityMeasureAggregator) addAggegator(new SleepIrregularityMeasureAggregator(date, date2, context));
        this.sleepRegularityIndexMeasureAggregator = (MeasureAverageAggregator) addAggegator(new MeasureAverageAggregator(date, date2, new RegularityIndexExtractor(context)));
        this.from = date;
        this.to = date2;
    }

    private ICollector addAggegator(ICollector iCollector) {
        this.aggregators.add(iCollector);
        return iCollector;
    }

    public MeasureAverageAggregator getDeepSleepAggregator() {
        return this.deepSleepAggregator;
    }

    public MeasureAverageAggregator getHrAggregator() {
        return this.hrAggregator;
    }

    public MeasureAverageAggregator getHrvAfterAggregator() {
        return this.hrvAfterAggregator;
    }

    public MeasureAverageAggregator getHrvAggregator() {
        return this.hrvAggregator;
    }

    public MeasureAverageAggregator getLengthAggregator() {
        return this.lengthAggregator;
    }

    public SleepIrregularityMeasureAggregator getSleepIrregularityMeasureAggregator() {
        return this.sleepIrregularityMeasureAggregator;
    }

    public MeasureAverageAggregator getSleepRegularityIndexMeasureAggregator() {
        return this.sleepRegularityIndexMeasureAggregator;
    }

    public MeasureAverageAggregator getSnoringAggregator() {
        return this.snoringAggregator;
    }

    public SocialJetLagMeasureAggregator getSocialjetLagAggregator() {
        return this.socialJetLagMeasureAggregator;
    }

    public TagAggregator getTagAggregator() {
        return this.tagAggregator;
    }

    public void put(IStatRecord iStatRecord) {
        Iterator<ICollector> it = this.aggregators.iterator();
        while (it.hasNext()) {
            it.next().put(iStatRecord);
        }
    }

    public String toString() {
        return "snore " + this.snoringAggregator.getMeasure() + " len " + this.lengthAggregator.getMeasure() + " DS " + this.deepSleepAggregator.getMeasure();
    }
}
