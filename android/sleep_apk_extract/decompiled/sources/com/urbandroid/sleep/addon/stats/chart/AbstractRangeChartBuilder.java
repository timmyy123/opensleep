package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractRangeChartBuilder<T extends StatRecord> extends AbstractDateChartBuilder<T> {
    public AbstractRangeChartBuilder(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public GraphicalView getChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, String str) {
        return ChartFactory.getTimeRangeBarChartView(context, xYMultipleSeriesDataset, xYMultipleSeriesRenderer, BarChart.Type.DEFAULT, str);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Context getContext() {
        return this.context;
    }
}
