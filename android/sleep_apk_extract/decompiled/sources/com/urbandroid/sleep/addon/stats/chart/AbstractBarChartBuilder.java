package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.graphics.Paint;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.util.List;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractBarChartBuilder {
    private Context context;
    private XYMultipleSeriesDataset dataset;
    private XYMultipleSeriesRenderer renderer;

    public AbstractBarChartBuilder(Context context) {
        this.context = context;
    }

    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        AbstractChartBuilder.commonRendererAdjust(this.context, xYMultipleSeriesRenderer);
    }

    public AbstractBarChartBuilder buildChart(Context context, SocialJetlagStats socialJetlagStats) {
        this.dataset = new XYMultipleSeriesDataset();
        MinMaxFinder minMaxFinder = new MinMaxFinder();
        List<double[]> yAxisValues = getYAxisValues(socialJetlagStats);
        int i = 0;
        for (String str : getSeriesTitles()) {
            XYSeries xYSeries = new XYSeries(FileInsert$$ExternalSyntheticOutline0.m(" ", str, "  "));
            int i2 = 0;
            while (i2 < getXAxisTitles().length) {
                double d = yAxisValues.get(i)[i2];
                xYSeries.add(i2, d);
                minMaxFinder.addValue(d);
                i2++;
                minMaxFinder.addValueX(i2);
            }
            minMaxFinder.addValueX(-1.0d);
            minMaxFinder.addValue(0.0d);
            this.dataset.addSeries(xYSeries);
            i++;
        }
        XYMultipleSeriesRenderer xYMultipleSeriesRendererBuildRenderer = buildRenderer(getColors());
        this.renderer = xYMultipleSeriesRendererBuildRenderer;
        xYMultipleSeriesRendererBuildRenderer.setXAxisMin(minMaxFinder.getMinValueX());
        this.renderer.setXAxisMax(minMaxFinder.getMaxValueX());
        this.renderer.setYAxisMin(minMaxFinder.getMinValue());
        this.renderer.setYAxisMax(minMaxFinder.getMaxValue());
        adjustRenderer(this.renderer, minMaxFinder);
        return this;
    }

    public XYMultipleSeriesRenderer buildRenderer(int[] iArr) {
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
        xYMultipleSeriesRenderer.setPointSize(ActivityUtils.getDip(getContext(), 8));
        xYMultipleSeriesRenderer.setAntialiasing(true);
        xYMultipleSeriesRenderer.setXLabelsAlign(Paint.Align.CENTER);
        xYMultipleSeriesRenderer.setYLabels(5);
        for (int i : iArr) {
            XYSeriesRenderer xYSeriesRenderer = new XYSeriesRenderer();
            xYSeriesRenderer.setColor(i);
            xYSeriesRenderer.setFillPoints(true);
            xYSeriesRenderer.setLineWidth(ActivityUtils.getDip(getContext(), 3));
            xYMultipleSeriesRenderer.addSeriesRenderer(xYSeriesRenderer);
        }
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(this.context, 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setXLabels(0);
        for (int i2 = 0; i2 < getXAxisTitles().length; i2++) {
            xYMultipleSeriesRenderer.addXTextLabel(i2, getXAxisTitles()[i2]);
        }
        xYMultipleSeriesRenderer.setChartTitle(getTitle());
        xYMultipleSeriesRenderer.setMargins(new int[]{ActivityUtils.getDip(this.context, 48), ActivityUtils.getDip(this.context, 72), ActivityUtils.getDip(this.context, 64), ActivityUtils.getDip(this.context, 8)});
        xYMultipleSeriesRenderer.setMarginsColor(ColorUtil.i(this.context, R.color.bg_charts));
        xYMultipleSeriesRenderer.setBackgroundColor(ColorUtil.i(this.context, R.color.bg_charts));
        xYMultipleSeriesRenderer.setBarSpacing(1.0d);
        xYMultipleSeriesRenderer.setYTitle(getYLabel());
        xYMultipleSeriesRenderer.setXTitle(getXLabel());
        xYMultipleSeriesRenderer.setAxesColor(ColorUtil.i(this.context, R.color.quaternary));
        xYMultipleSeriesRenderer.setLabelsColor(ColorUtil.i(this.context, R.color.tertiary));
        xYMultipleSeriesRenderer.setInScroll(true);
        xYMultipleSeriesRenderer.setClickEnabled(true);
        xYMultipleSeriesRenderer.setShowLabels(true);
        xYMultipleSeriesRenderer.setFitLegend(true);
        xYMultipleSeriesRenderer.setLegendHeight(SleepStats.getDip(240));
        return xYMultipleSeriesRenderer;
    }

    public GraphicalView createView(Context context) {
        GraphicalView barChartView = ChartFactory.getBarChartView(context, this.dataset, this.renderer, BarChart.Type.DEFAULT);
        barChartView.setPadding(0, 0, 0, 0);
        return barChartView;
    }

    public abstract int[] getColors();

    public Context getContext() {
        return this.context;
    }

    public abstract String[] getSeriesTitles();

    public abstract String getTitle();

    public abstract String[] getXAxisTitles();

    public String getXLabel() {
        return "";
    }

    public abstract List<double[]> getYAxisValues(SocialJetlagStats socialJetlagStats);

    public abstract String getYLabel();
}
