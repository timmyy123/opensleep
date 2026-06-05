package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import android.graphics.Paint;
import androidx.core.content.res.ResourcesCompat;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.regression.Point;
import com.urbandroid.sleep.addon.stats.model.regression.PointSeries;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.util.Collection;
import java.util.List;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class MultiScatterChartBuilder {
    private Context context;
    private XYMultipleSeriesDataset dataset;
    private XYMultipleSeriesRenderer renderer;

    public MultiScatterChartBuilder(Context context) {
        this.context = context;
    }

    public MultiScatterChartBuilder buildChart(Context context, String str, String str2, String str3, List<PointSeries> list, int[] iArr, PointStyle[] pointStyleArr) {
        this.dataset = new XYMultipleSeriesDataset();
        MinMaxFinder minMaxFinder = new MinMaxFinder();
        int iMax = 0;
        for (PointSeries pointSeries : list) {
            XYSeries xYSeries = new XYSeries("  " + pointSeries.getYName() + "  ");
            minMaxFinder.addFinder(pointSeries.getMinMaxFinder());
            Collection<Point> corePoints = pointSeries.getCorePoints();
            for (Point point : corePoints) {
                xYSeries.add(point.getX(), point.getY());
            }
            this.dataset.addSeries(xYSeries);
            iMax = Math.max(iMax, corePoints.size());
        }
        this.renderer = buildRenderer(iArr, pointStyleArr, iMax > 500);
        double dAbs = Math.abs(minMaxFinder.getMaxValueX() - minMaxFinder.getMinValueX()) * 0.1d;
        double minValueX = minMaxFinder.getMinValueX() - dAbs;
        double maxValueX = minMaxFinder.getMaxValueX() + dAbs;
        double dAbs2 = Math.abs(minMaxFinder.getMaxValue() - minMaxFinder.getMinValue()) * 0.1d;
        double minValue = minMaxFinder.getMinValue() - dAbs2;
        double maxValue = minMaxFinder.getMaxValue() + dAbs2;
        this.renderer.setXAxisMin(minValueX);
        this.renderer.setXAxisMax(maxValueX);
        this.renderer.setYAxisMin(minValue);
        this.renderer.setYAxisMax(maxValue);
        this.renderer.setChartTitle(str);
        this.renderer.setMarginsColor(ColorUtil.i(context, R.color.bg_charts));
        this.renderer.setBackgroundColor(ColorUtil.i(context, R.color.bg_charts));
        this.renderer.setXTitle(str2);
        this.renderer.setYTitle(str3);
        this.renderer.setAxesColor(ColorUtil.i(context, R.color.quaternary));
        this.renderer.setLabelsColor(ColorUtil.i(context, R.color.tertiary));
        this.renderer.setInScroll(true);
        this.renderer.setZoomEnabled(false, false);
        this.renderer.setPanEnabled(false, false);
        this.renderer.setClickEnabled(false);
        this.renderer.setShowLabels(true);
        return this;
    }

    public XYMultipleSeriesRenderer buildRenderer(int[] iArr, PointStyle[] pointStyleArr, boolean z) {
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
        AbstractChartBuilder.commonRendererAdjust(this.context, xYMultipleSeriesRenderer);
        xYMultipleSeriesRenderer.setPointSize(ActivityUtils.getDip(getContext(), 5));
        xYMultipleSeriesRenderer.setAntialiasing(true);
        xYMultipleSeriesRenderer.setMargins(new int[]{ActivityUtils.getDip(this.context, 36), ActivityUtils.getDip(this.context, 72), ActivityUtils.getDip(this.context, 64), ActivityUtils.getDip(this.context, 8)});
        Paint.Align align = Paint.Align.LEFT;
        xYMultipleSeriesRenderer.setXLabelsAlign(align);
        xYMultipleSeriesRenderer.setXLabelsAlign(align);
        xYMultipleSeriesRenderer.setYLabels(5);
        xYMultipleSeriesRenderer.setFitLegend(true);
        xYMultipleSeriesRenderer.setLegendHeight(ActivityUtils.getDip(getContext(), 240));
        xYMultipleSeriesRenderer.setShowAxes(false);
        if (z) {
            xYMultipleSeriesRenderer.setPointSize(5.0f);
        } else {
            xYMultipleSeriesRenderer.setPointSize(8.0f);
        }
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(getContext(), R.font.product));
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 14));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            XYSeriesRenderer xYSeriesRenderer = new XYSeriesRenderer();
            xYSeriesRenderer.setColor(iArr[i]);
            xYSeriesRenderer.setPointStyle(pointStyleArr[i]);
            xYSeriesRenderer.setFillPoints(true);
            xYSeriesRenderer.setLineWidth(ActivityUtils.getDip(getContext(), 3));
            xYMultipleSeriesRenderer.addSeriesRenderer(xYSeriesRenderer);
        }
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(this.context, R.font.product));
        xYMultipleSeriesRenderer.setShowTickMarks(false);
        xYMultipleSeriesRenderer.setShowGrid(true);
        xYMultipleSeriesRenderer.setShowGridX(true);
        xYMultipleSeriesRenderer.setShowGridY(true);
        xYMultipleSeriesRenderer.setShowCustomTextGridY(true);
        xYMultipleSeriesRenderer.setShowCustomTextGridX(true);
        xYMultipleSeriesRenderer.setXLabelsPadding(ActivityUtils.getDip(getContext(), 4));
        xYMultipleSeriesRenderer.setAxesColor(ColorUtil.i(this.context, R.color.transparent));
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(this.context, R.font.product));
        return xYMultipleSeriesRenderer;
    }

    public GraphicalView createView(Context context) {
        GraphicalView scatterChartView = ChartFactory.getScatterChartView(context, this.dataset, this.renderer);
        scatterChartView.setPadding(0, 0, 0, 0);
        return scatterChartView;
    }

    public Context getContext() {
        return this.context;
    }
}
