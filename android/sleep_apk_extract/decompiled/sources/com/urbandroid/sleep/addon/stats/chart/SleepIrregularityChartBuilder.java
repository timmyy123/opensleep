package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes4.dex */
public class SleepIrregularityChartBuilder extends AbstractSleepIrregularityChartBuilder {
    public SleepIrregularityChartBuilder(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractSleepIrregularityChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        super.adjustRenderer(xYMultipleSeriesRenderer, minMaxFinder);
        xYMultipleSeriesRenderer.setXAxisMin(((AbstractSleepIrregularityChartBuilder) this).since.getTime());
        xYMultipleSeriesRenderer.setDisplayValues(false);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return getContext().getResources().getString(R.string.sleep_variance) + " " + getContext().getResources().getString(R.string.axis_minute);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractSleepIrregularityChartBuilder
    public List<Pair<Date, Float>> getHistory(Collection<StatRecord> collection) {
        return SocialJetlagStats.create(collection, this.context).getSleepIrregularityHistory(30, 1);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        return new String[]{getContext().getResources().getString(R.string.sleep_variance)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        return getContext().getResources().getString(R.string.axis_minute);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractSleepIrregularityChartBuilder
    public float processValue(float f) {
        return Math.round(f * 60.0f);
    }
}
