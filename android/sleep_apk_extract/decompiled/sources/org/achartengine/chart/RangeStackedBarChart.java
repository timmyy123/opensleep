package org.achartengine.chart;

import org.achartengine.chart.BarChart;

/* JADX INFO: loaded from: classes5.dex */
public class RangeStackedBarChart extends RangeBarChart {
    public static final String TYPE = "RangeStackedBar";

    public RangeStackedBarChart() {
        super(BarChart.Type.STACKED);
    }

    @Override // org.achartengine.chart.RangeBarChart, org.achartengine.chart.BarChart, org.achartengine.chart.XYChart
    public String getChartType() {
        return TYPE;
    }
}
