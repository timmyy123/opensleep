package org.achartengine.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.Serializable;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.chart.CombinedXYChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes5.dex */
public class CombinedRoundXYChart extends XYChart {
    private CombinedXYChart.XYCombinedChartDef[] chartDefinitions;
    private XYChart[] mCharts;
    private Class<?>[] xyChartTypes;

    public static class XYCombinedChartDef implements Serializable {
        private int[] seriesIndex;
        private String type;

        public XYCombinedChartDef(String str, int... iArr) {
            this.type = str;
            this.seriesIndex = iArr;
        }

        public boolean containsSeries(int i) {
            return getChartSeriesIndex(i) >= 0;
        }

        public int getChartSeriesIndex(int i) {
            for (int i2 = 0; i2 < getSeriesIndex().length; i2++) {
                if (this.seriesIndex[i2] == i) {
                    return i2;
                }
            }
            return -1;
        }

        public int[] getSeriesIndex() {
            return this.seriesIndex;
        }

        public String getType() {
            return this.type;
        }
    }

    public CombinedRoundXYChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, CombinedXYChart.XYCombinedChartDef[] xYCombinedChartDefArr) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.xyChartTypes = new Class[]{TimeChart.class, RoundLineChart.class, CubicLineChart.class, RoundBarChart.class, BubbleChart.class, ScatterChart.class, RoundRangeBarChart.class, RangeStackedBarChart.class};
        this.chartDefinitions = xYCombinedChartDefArr;
        int length = xYCombinedChartDefArr.length;
        this.mCharts = new XYChart[length];
        for (int i = 0; i < length; i++) {
            try {
                this.mCharts[i] = getXYChart(xYCombinedChartDefArr[i].getType());
            } catch (Exception unused) {
            }
            if (this.mCharts[i] == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown chart type ", xYCombinedChartDefArr[i].getType());
                throw null;
            }
            XYMultipleSeriesDataset xYMultipleSeriesDataset2 = new XYMultipleSeriesDataset();
            XYMultipleSeriesRenderer xYMultipleSeriesRenderer2 = new XYMultipleSeriesRenderer();
            for (int i2 : xYCombinedChartDefArr[i].getSeriesIndex()) {
                xYMultipleSeriesDataset2.addSeries(xYMultipleSeriesDataset.getSeriesAt(i2));
                xYMultipleSeriesRenderer2.addSeriesRenderer(xYMultipleSeriesRenderer.getSeriesRendererAt(i2));
            }
            xYMultipleSeriesRenderer2.setBarWidth(xYMultipleSeriesRenderer.getBarWidth());
            xYMultipleSeriesRenderer2.setBarSpacing(xYMultipleSeriesRenderer.getBarSpacing());
            xYMultipleSeriesRenderer2.setPointSize(xYMultipleSeriesRenderer.getPointSize());
            this.mCharts[i].setDatasetRenderer(xYMultipleSeriesDataset2, xYMultipleSeriesRenderer2);
        }
    }

    private int getChartSeriesIndex(int i) {
        int i2 = 0;
        while (true) {
            CombinedXYChart.XYCombinedChartDef[] xYCombinedChartDefArr = this.chartDefinitions;
            if (i2 >= xYCombinedChartDefArr.length) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Unknown series with index "));
                return 0;
            }
            if (xYCombinedChartDefArr[i2].containsSeries(i)) {
                return this.chartDefinitions[i2].getChartSeriesIndex(i);
            }
            i2++;
        }
    }

    private XYChart getXYChart(String str) {
        int length = this.xyChartTypes.length;
        XYChart xYChart = null;
        for (int i = 0; i < length && xYChart == null; i++) {
            XYChart xYChart2 = (XYChart) this.xyChartTypes[i].newInstance();
            if (str.equals(xYChart2.getChartType())) {
                xYChart = xYChart2;
            }
        }
        return xYChart;
    }

    @Override // org.achartengine.chart.XYChart
    public ClickableArea[] clickableAreasForPoints(List<Float> list, List<Double> list2, float f, int i, int i2) {
        return getXYChart(i).clickableAreasForPoints(list, list2, f, getChartSeriesIndex(i), i2);
    }

    @Override // org.achartengine.chart.AbstractChart
    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer simpleSeriesRenderer, float f, float f2, int i, Paint paint) {
        getXYChart(i).drawLegendShape(canvas, simpleSeriesRenderer, f, f2, getChartSeriesIndex(i), paint);
    }

    @Override // org.achartengine.chart.XYChart
    public void drawSeries(Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, int i2) {
        XYChart xYChart = getXYChart(i);
        xYChart.setScreenR(getScreenR());
        xYChart.setCalcRange(getCalcRange(this.mDataset.getSeriesAt(i).getScaleNumber()), 0);
        xYChart.drawSeries(canvas, paint, list, xYSeriesRenderer, f, getChartSeriesIndex(i), i2);
    }

    @Override // org.achartengine.chart.XYChart
    public String getChartType() {
        return "Combined";
    }

    @Override // org.achartengine.chart.AbstractChart
    public int getLegendShapeWidth(int i) {
        return getXYChart(i).getLegendShapeWidth(getChartSeriesIndex(i));
    }

    private XYChart getXYChart(int i) {
        int i2 = 0;
        while (true) {
            CombinedXYChart.XYCombinedChartDef[] xYCombinedChartDefArr = this.chartDefinitions;
            if (i2 < xYCombinedChartDefArr.length) {
                if (xYCombinedChartDefArr[i2].containsSeries(i)) {
                    return this.mCharts[i2];
                }
                i2++;
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Unknown series with index "));
                return null;
            }
        }
    }

    @Override // org.achartengine.chart.XYChart
    public void drawSeries(XYSeries xYSeries, Canvas canvas, Paint paint, List<Float> list, XYSeriesRenderer xYSeriesRenderer, float f, int i, XYMultipleSeriesRenderer.Orientation orientation, int i2) {
        XYChart xYChart = getXYChart(i);
        xYChart.setScreenR(getScreenR());
        xYChart.setCalcRange(getCalcRange(this.mDataset.getSeriesAt(i).getScaleNumber()), 0);
        xYChart.drawSeries(xYSeries, canvas, paint, list, xYSeriesRenderer, f, getChartSeriesIndex(i), orientation, i2);
    }

    public CombinedRoundXYChart(XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, CombinedXYChart.XYCombinedChartDef[] xYCombinedChartDefArr, XYChart[] xYChartArr) {
        super(xYMultipleSeriesDataset, xYMultipleSeriesRenderer);
        this.xyChartTypes = new Class[]{TimeChart.class, RoundLineChart.class, CubicLineChart.class, RoundBarChart.class, BubbleChart.class, ScatterChart.class, RoundRangeBarChart.class, RangeStackedBarChart.class};
        this.chartDefinitions = xYCombinedChartDefArr;
        this.mCharts = xYChartArr;
    }
}
