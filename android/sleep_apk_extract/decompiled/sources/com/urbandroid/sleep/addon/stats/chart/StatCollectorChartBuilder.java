package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import android.graphics.Paint;
import androidx.core.content.res.ResourcesCompat;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.collector.IStatCollector;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.util.Iterator;
import java.util.List;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.CombinedXYChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class StatCollectorChartBuilder implements IChartBuilder {
    private Context context;
    private XYMultipleSeriesDataset dataset;
    private XYMultipleSeriesRenderer renderer;
    private String title = "";
    private boolean showTitle = true;
    private boolean hasAverage = false;
    private String unit = null;

    public StatCollectorChartBuilder(Context context) {
        this.context = context;
    }

    private int getColorFromTitle(String str) {
        if (str.trim().equals(this.context.getString(R.string.sleep_duration))) {
            return R.color.duration;
        }
        if (str.trim().equals(this.context.getString(R.string.stats_caption_snore))) {
            return R.color.snore;
        }
        if (str.trim().equals(this.context.getString(R.string.axis_rating))) {
            return R.color.rating;
        }
        if (str.trim().equals(this.context.getString(R.string.sleep_efficiency) + " %")) {
            return R.color.efficiency;
        }
        if (str.trim().equals(this.context.getString(R.string.hrv_gain))) {
            return R.color.hrv;
        }
        if (str.trim().equals(this.context.getString(R.string.label_deep_sleep) + " %")) {
            return R.color.score_deep_sleep;
        }
        if (str.trim().equals(this.context.getString(R.string.rr_disturbace))) {
            return R.color.rdi;
        }
        if (str.trim().equals(this.context.getString(R.string.hr_short))) {
            return R.color.hr;
        }
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder();
        sb.append(this.context.getString(R.string.low));
        sb.append(" ");
        sb.append(this.context.getString(R.string.hr_short));
        return strTrim.equals(sb.toString()) ? R.color.hr : R.color.hrv;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public StatCollectorChartBuilder buildChart(Context context, List<IStatCollector> list) {
        int i;
        this.dataset = new XYMultipleSeriesDataset();
        MinMaxFinder minMaxFinder = new MinMaxFinder();
        StringBuilder sb = new StringBuilder();
        Iterator<IStatCollector> it = list.iterator();
        while (it.hasNext()) {
            IStatCollector next = it.next();
            XYSeries xYSeries = new XYSeries("  " + next.getMeasureTitle() + "  ");
            XYSeries xYSeries2 = new XYSeries("  " + context.getString(R.string.axis_average) + "  ");
            sb.append(next.getMeasureTitle());
            sb.append(", ");
            List<Double> values = next.getValues();
            List<String> labels = next.getLabels();
            double dDoubleValue = 0.0d;
            for (int i2 = 0; i2 < values.size(); i2++) {
                if (" AVERAGE".equals(labels.get(i2))) {
                    this.hasAverage = true;
                    dDoubleValue = values.get(i2).doubleValue();
                }
            }
            double d = dDoubleValue;
            int i3 = 0;
            while (i3 < values.size()) {
                Iterator<IStatCollector> it2 = it;
                IStatCollector iStatCollector = next;
                double dDoubleValue2 = values.get(i3).doubleValue();
                iStatCollector.getLabels().get(i3);
                List<Double> list2 = values;
                double d2 = i3;
                xYSeries2.add(d2, dDoubleValue);
                xYSeries.add(d2, dDoubleValue2);
                minMaxFinder.addValue(dDoubleValue2);
                i3++;
                minMaxFinder.addValueX(i3);
                if (dDoubleValue2 < d) {
                    d = dDoubleValue2;
                }
                it = it2;
                next = iStatCollector;
                values = list2;
            }
            Iterator<IStatCollector> it3 = it;
            minMaxFinder.addValueX(-1.0d);
            minMaxFinder.addValue(Math.max(0.0d, d * 0.95d));
            this.dataset.addSeries(xYSeries);
            if (this.hasAverage) {
                this.dataset.addSeries(xYSeries2);
            }
            it = it3;
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        this.title = sb.toString();
        if (list.size() == 1) {
            if (this.hasAverage) {
                int[] iArr = {ColorUtil.i(context, getColorFromTitle(list.get(0).getMeasureTitle().trim())), ColorUtil.i(context, R.color.average)};
                PointStyle pointStyle = PointStyle.CIRCLE;
                this.renderer = buildRenderer(iArr, new PointStyle[]{pointStyle, pointStyle});
            } else {
                this.renderer = buildRenderer(new int[]{ColorUtil.i(context, getColorFromTitle(list.get(0).getMeasureTitle().trim()))}, new PointStyle[]{PointStyle.CIRCLE});
            }
        } else if (list.size() <= 0 || !list.get(0).getMeasureTitle().trim().equals(context.getString(R.string.stats_caption_sleep))) {
            this.renderer = buildRenderer(new int[]{ColorUtil.i(context, R.color.score_deep_sleep), ColorUtil.i(context, R.color.rating), ColorUtil.i(context, R.color.efficiency)}, new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND, PointStyle.TRIANGLE});
        } else {
            this.renderer = buildRenderer(new int[]{ColorUtil.i(context, R.color.duration), ColorUtil.i(context, R.color.rating)}, new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND});
        }
        Iterator<IStatCollector> it4 = list.iterator();
        if (it4.hasNext()) {
            List<String> labels2 = it4.next().getLabels();
            for (int i4 = 0; i4 < labels2.size(); i4++) {
                boolean zEquals = " AVERAGE".equals(labels2.get(i4));
                XYMultipleSeriesRenderer xYMultipleSeriesRenderer = this.renderer;
                if (zEquals) {
                    xYMultipleSeriesRenderer.addXTextLabel(i4, context.getString(R.string.axis_average));
                } else {
                    xYMultipleSeriesRenderer.addXTextLabel(i4, labels2.get(i4));
                }
            }
            i = 0;
            this.renderer.setXLabels(0);
        } else {
            i = 0;
        }
        if (list.size() <= 0 || list.get(i).getTitle() == null || !this.showTitle) {
            this.renderer.setMargins(new int[]{ActivityUtils.getDip(context, 16), ActivityUtils.getDip(context, 72), ActivityUtils.getDip(context, 64), ActivityUtils.getDip(context, 8)});
        } else {
            this.renderer.setChartTitle(list.get(i).getTitle());
            this.renderer.setMargins(new int[]{ActivityUtils.getDip(context, 36), ActivityUtils.getDip(context, 72), ActivityUtils.getDip(context, 64), ActivityUtils.getDip(context, 8)});
        }
        this.renderer.setMarginsColor(ColorUtil.i(context, R.color.bg_charts));
        this.renderer.setBackgroundColor(ColorUtil.i(context, R.color.bg_charts));
        this.renderer.setBarSpacing(1.0d);
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer2 = this.renderer;
        String string = this.unit;
        if (string == null) {
            string = sb.toString();
        }
        xYMultipleSeriesRenderer2.setYTitle(string);
        double dMin = Math.min(minMaxFinder.getMaxValueX(), 8.0d);
        boolean z = minMaxFinder.getMaxValueX() > 8.0d;
        this.renderer.setPanEnabled(z, false);
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer3 = this.renderer;
        if (z) {
            xYMultipleSeriesRenderer3.setXAxisMin(minMaxFinder.getMaxValueX() - dMin);
            this.renderer.setXAxisMax(minMaxFinder.getMaxValueX() + 1.0d);
            this.renderer.setPanLimits(new double[]{-1.0d, minMaxFinder.getMaxValueX() + 1.0d, 0.0d, 0.0d});
        } else {
            xYMultipleSeriesRenderer3.setXAxisMin(minMaxFinder.getMinValueX());
            this.renderer.setXAxisMax(minMaxFinder.getMaxValueX());
        }
        this.renderer.setYAxisMin(minMaxFinder.getMinValue());
        this.renderer.setYAxisMax(minMaxFinder.getMaxValue());
        this.renderer.setAxesColor(ColorUtil.i(context, R.color.quaternary));
        this.renderer.setLabelsColor(ColorUtil.i(context, R.color.tertiary));
        this.renderer.setShowLabels(true);
        this.renderer.setFitLegend(true);
        this.renderer.setLegendHeight(SleepStats.getDip(360));
        this.renderer.setXLabels(0);
        this.renderer.setZoomEnabled(false, false);
        this.renderer.setPanEnabled(true, false);
        this.renderer.setClickEnabled(false);
        this.renderer.setShowLabels(true);
        this.renderer.setTextTypeface(ResourcesCompat.getFont(context, R.font.product));
        this.renderer.setChartTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        this.renderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 14));
        this.renderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        this.renderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        AbstractChartBuilder.commonRendererAdjust(context, this.renderer);
        return this;
    }

    public XYMultipleSeriesRenderer buildRenderer(int[] iArr, PointStyle[] pointStyleArr) {
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
        AbstractChartBuilder.commonRendererAdjust(this.context, xYMultipleSeriesRenderer);
        xYMultipleSeriesRenderer.setPointSize(ActivityUtils.getDip(getContext(), 5));
        xYMultipleSeriesRenderer.setAntialiasing(true);
        xYMultipleSeriesRenderer.setXLabelsAlign(Paint.Align.CENTER);
        xYMultipleSeriesRenderer.setXLabelsAngle(45.0f);
        xYMultipleSeriesRenderer.setXLabelsPadding(ActivityUtils.getDip(getContext(), 64));
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
        xYMultipleSeriesRenderer.setLegendHeight(ActivityUtils.getDip(getContext(), 240));
        xYMultipleSeriesRenderer.setShowTickMarks(false);
        xYMultipleSeriesRenderer.setAxesColor(ColorUtil.i(this.context, R.color.transparent));
        xYMultipleSeriesRenderer.setShowAxes(false);
        return xYMultipleSeriesRenderer;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public GraphicalView createView(Context context) {
        GraphicalView barChartView;
        if (this.hasAverage) {
            barChartView = ChartFactory.getCombinedXYChartView(context, this.dataset, this.renderer, new CombinedXYChart.XYCombinedChartDef[]{new CombinedXYChart.XYCombinedChartDef(BarChart.TYPE, 0), new CombinedXYChart.XYCombinedChartDef(LineChart.TYPE, 1)});
        } else {
            barChartView = ChartFactory.getBarChartView(context, this.dataset, this.renderer, BarChart.Type.DEFAULT);
        }
        barChartView.setPadding(0, 0, 0, 0);
        return barChartView;
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

    public IChartBuilder setShowTitle(boolean z) {
        this.showTitle = z;
        return this;
    }

    public StatCollectorChartBuilder setUnit(String str) {
        this.unit = str;
        return this;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public /* bridge */ /* synthetic */ IChartBuilder buildChart(Context context, List list) {
        return buildChart(context, (List<IStatCollector>) list);
    }
}
