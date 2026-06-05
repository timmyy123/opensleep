package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import android.graphics.Paint;
import androidx.core.content.res.ResourcesCompat;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.extractor.BedtimeHourExtractor;
import com.urbandroid.sleep.addon.stats.model.regression.Point;
import com.urbandroid.sleep.addon.stats.model.regression.PointSeries;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class RegressionCollectorChartBuilder implements IChartBuilder {
    private Context context;
    private XYMultipleSeriesDataset dataset;
    private XYMultipleSeriesRenderer renderer;
    private boolean showTitle = true;
    private String title = "";

    public RegressionCollectorChartBuilder(Context context) {
        this.context = context;
    }

    private String createYLabel(List<PointSeries> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<PointSeries> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getYName());
            sb.append(", ");
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        this.title = sb.toString();
        return sb.toString();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public RegressionCollectorChartBuilder buildChart(Context context, List<PointSeries> list) {
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
            iMax = Math.max(iMax, corePoints.size());
            this.dataset.addSeries(xYSeries);
        }
        if (minMaxFinder.getMaxValue() > 100.0d) {
            minMaxFinder.setMaxValue(100.0d);
        }
        int[] iArr = {ColorUtil.i(context, R.color.score_deep_sleep), ColorUtil.i(context, R.color.rating), ColorUtil.i(context, R.color.efficiency)};
        PointStyle pointStyle = PointStyle.CIRCLE;
        this.renderer = buildRenderer(iArr, new PointStyle[]{pointStyle, pointStyle, pointStyle}, iMax > 500);
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
        int i = 0;
        for (int iRound = (int) Math.round(minValueX); iRound < Math.round(maxValueX); iRound++) {
            double d = iRound;
            this.renderer.addXTextLabel(d, DateUtil.formatMinutes(Integer.valueOf(((int) BedtimeHourExtractor.adjustHourBack(d)) * 60)));
            i++;
            if (i > 30) {
                break;
            }
        }
        this.renderer.setXLabels(0);
        if (isShowTitle() && list.size() > 0) {
            this.renderer.setChartTitle(list.get(0).getXName());
        }
        this.renderer.setMarginsColor(ColorUtil.i(context, R.color.bg_charts));
        this.renderer.setBackgroundColor(ColorUtil.i(context, R.color.bg_charts));
        this.renderer.setYTitle(createYLabel(list));
        this.renderer.setShowAxes(false);
        this.renderer.setLabelsColor(ColorUtil.i(context, R.color.tertiary));
        this.renderer.setZoomEnabled(false, false);
        this.renderer.setPanEnabled(false, false);
        this.renderer.setClickEnabled(false);
        this.renderer.setShowLabels(true);
        this.renderer.setShowTickMarks(false);
        this.renderer.setAxesColor(ColorUtil.i(context, R.color.transparent));
        this.renderer.setTextTypeface(ResourcesCompat.getFont(context, R.font.product));
        AbstractChartBuilder.commonRendererAdjust(getContext(), this.renderer);
        return this;
    }

    public XYMultipleSeriesRenderer buildRenderer(int[] iArr, PointStyle[] pointStyleArr, boolean z) {
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
        AbstractChartBuilder.commonRendererAdjust(this.context, xYMultipleSeriesRenderer);
        xYMultipleSeriesRenderer.setAntialiasing(true);
        xYMultipleSeriesRenderer.setMargins(new int[]{ActivityUtils.getDip(this.context, 36), ActivityUtils.getDip(this.context, 72), ActivityUtils.getDip(this.context, 64), ActivityUtils.getDip(this.context, 8)});
        Paint.Align align = Paint.Align.LEFT;
        xYMultipleSeriesRenderer.setXLabelsAlign(align);
        xYMultipleSeriesRenderer.setXLabelsAlign(align);
        xYMultipleSeriesRenderer.setXLabelsAngle(45.0f);
        xYMultipleSeriesRenderer.setYLabels(5);
        xYMultipleSeriesRenderer.setFitLegend(true);
        xYMultipleSeriesRenderer.setLegendHeight(SleepStats.getDip(240));
        if (z) {
            xYMultipleSeriesRenderer.setPointSize(ActivityUtils.getDip(getContext(), 5));
        } else {
            xYMultipleSeriesRenderer.setPointSize(ActivityUtils.getDip(getContext(), 5));
        }
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
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 14));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setShowTickMarks(false);
        return xYMultipleSeriesRenderer;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public GraphicalView createView(Context context) {
        GraphicalView scatterChartView = ChartFactory.getScatterChartView(context, this.dataset, this.renderer);
        scatterChartView.setPadding(0, 0, 0, 0);
        return scatterChartView;
    }

    public Context getContext() {
        return this.context;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return this.title;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return null;
    }

    public boolean isShowTitle() {
        return this.showTitle;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public /* bridge */ /* synthetic */ IChartBuilder buildChart(Context context, List list) {
        return buildChart(context, (List<PointSeries>) list);
    }
}
