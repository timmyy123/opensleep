package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractNoMoveTimeChartBuilder<T extends StatRecord> extends AbstractTimeChartBuilder<T> {
    public AbstractNoMoveTimeChartBuilder(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractTimeChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public GraphicalView getChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, String str) {
        return super.getChartView(context, xYMultipleSeriesDataset, xYMultipleSeriesRenderer, str);
    }
}
