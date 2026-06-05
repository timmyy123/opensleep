package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.chart.achartoverride.HeatTimeRangeBarChart;
import com.urbandroid.sleep.addon.stats.chart.achartoverride.TimeRangeBarChart;
import com.urbandroid.sleep.addon.stats.chart.achartoverride.TimeRangeBarChart2;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.CombinedRoundXYChart;
import org.achartengine.chart.CombinedXYChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.RoundBarChart;
import org.achartengine.chart.RoundTimeChart;
import org.achartengine.chart.ScatterChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ChartFactory {
    private static void checkParameters(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
    }

    public static final GraphicalView getBarChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type) {
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        return new GraphicalView(context, new RoundBarChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type));
    }

    public static final GraphicalView getCombinedXYChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, CombinedXYChart.XYCombinedChartDef[] xYCombinedChartDefArr) {
        if (xYMultipleSeriesDataset == null || xYMultipleSeriesRenderer == null || xYCombinedChartDefArr == null || xYMultipleSeriesDataset.getSeriesCount() != xYCombinedChartDefArr.length) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Dataset, renderer and types should be not null and the datasets series count should be equal to the types length");
            return null;
        }
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        return new GraphicalView(context, new CombinedRoundXYChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, xYCombinedChartDefArr));
    }

    public static final GraphicalView getHeatTimeRangeBarChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type, String str, List<float[]> list) {
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        return new GraphicalView(context, new HeatTimeRangeBarChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type, str, list));
    }

    public static final GraphicalView getScatterChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        return new GraphicalView(context, new ScatterChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer));
    }

    public static final GraphicalView getTimeChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, String str) {
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        RoundTimeChart roundTimeChart = new RoundTimeChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        roundTimeChart.setDateFormat(str);
        return new GraphicalView(context, roundTimeChart);
    }

    public static final GraphicalView getTimeMixedChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, String str) {
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        return getCombinedXYChartView(context, xYMultipleSeriesDataset, xYMultipleSeriesRenderer, new CombinedXYChart.XYCombinedChartDef[]{new CombinedXYChart.XYCombinedChartDef(LineChart.TYPE, 0), new CombinedXYChart.XYCombinedChartDef(BarChart.TYPE, 1)});
    }

    public static final GraphicalView getTimeRangeBarChart2View(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type, String str) {
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        return new GraphicalView(context, new TimeRangeBarChart2(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type, str));
    }

    public static final GraphicalView getTimeRangeBarChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, BarChart.Type type, String str) {
        checkParameters(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        return new GraphicalView(context, new TimeRangeBarChart(xYMultipleSeriesDataset, xYMultipleSeriesRenderer, type, str));
    }
}
