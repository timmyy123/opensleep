package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractHeatMapRangeChartBuilder<T extends StatRecord> extends AbstractDateChartBuilder<T> {
    private List<float[]> heatMap;

    public AbstractHeatMapRangeChartBuilder(Context context, List<float[]> list) {
        super(context);
        if (list == null) {
            this.heatMap = new ArrayList();
        } else {
            this.heatMap = new ArrayList(list);
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public GraphicalView getChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, String str) {
        return ChartFactory.getHeatTimeRangeBarChartView(context, xYMultipleSeriesDataset, xYMultipleSeriesRenderer, BarChart.Type.DEFAULT, str, this.heatMap);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Context getContext() {
        return this.context;
    }

    public List<float[]> getHeatMap() {
        return this.heatMap;
    }
}
