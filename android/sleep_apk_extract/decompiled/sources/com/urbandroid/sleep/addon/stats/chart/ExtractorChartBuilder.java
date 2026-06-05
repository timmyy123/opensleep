package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ScienceUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u001cJ+\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b#\u0010\u000eJ#\u0010(\u001a\u00020'2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010&\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b(\u0010)J7\u0010.\u001a\u00020-2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010%\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b1\u00102R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00103R$\u00104\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010<R\u0014\u0010>\u001a\u00020:8\u0002X\u0082D¢\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010?\u001a\u00020:8\u0002X\u0082D¢\u0006\u0006\n\u0004\b?\u0010<R\u0018\u0010B\u001a\u00020:*\u00020:8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/ExtractorChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/chart/AbstractTimeChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "extractor", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;)V", "", "minMaxOffset", "(D)Lcom/urbandroid/sleep/addon/stats/chart/ExtractorChartBuilder;", "", "getYTitle", "()Ljava/lang/String;", "getXTitle", "getGraphTitle", "", "records", "", "getTitles", "(Ljava/util/List;)[Ljava/lang/String;", "", "isShowBars", "()Ljava/lang/Boolean;", "", "getColors", "()[I", "()[Ljava/lang/String;", "", "Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;", "minMaxFinder", "", "prepareYAxis", "(Ljava/util/List;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)Ljava/util/List;", "getHelpUrl", "Lorg/achartengine/renderer/XYMultipleSeriesRenderer;", "renderer", "finder", "", "adjustRenderer", "(Lorg/achartengine/renderer/XYMultipleSeriesRenderer;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)V", "Lorg/achartengine/model/XYMultipleSeriesDataset;", "dataset", "datePattern", "Lorg/achartengine/GraphicalView;", "getChartView", "(Landroid/content/Context;Lorg/achartengine/model/XYMultipleSeriesDataset;Lorg/achartengine/renderer/XYMultipleSeriesRenderer;Ljava/lang/String;)Lorg/achartengine/GraphicalView;", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "getExtractor", "()Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "D", "avg", "Ljava/lang/Double;", "getAvg", "()Ljava/lang/Double;", "setAvg", "(Ljava/lang/Double;)V", "", "AVERAGE_COLOR", "I", "AVERAGE_COLOR_BARS", "SHOW_ROLLING_AVG_DAYS", "SHOW_AVG_DAYS", "getArgb", "(I)I", "argb", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class ExtractorChartBuilder extends AbstractTimeChartBuilder<StatRecord> {
    private final int AVERAGE_COLOR;
    private final int AVERAGE_COLOR_BARS;
    private final int SHOW_AVG_DAYS;
    private final int SHOW_ROLLING_AVG_DAYS;
    private Double avg;
    private final IValueExtractor extractor;
    private double minMaxOffset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtractorChartBuilder(Context context, IValueExtractor iValueExtractor) {
        super(context);
        context.getClass();
        iValueExtractor.getClass();
        this.extractor = iValueExtractor;
        this.minMaxOffset = 1.0d;
        int argb = getArgb(R.color.average);
        this.AVERAGE_COLOR = argb;
        this.AVERAGE_COLOR_BARS = argb;
        this.SHOW_ROLLING_AVG_DAYS = 180;
        this.SHOW_AVG_DAYS = 15;
    }

    private final int getArgb(int i) {
        return ColorUtil.i(this.context, i);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer renderer, MinMaxFinder finder) {
        super.adjustRenderer(renderer, finder);
        renderer.getClass();
        renderer.setChartTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        renderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 14));
        renderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        renderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        if (isShowBars().booleanValue() && finder != null && finder.getMinValue() < 0.0d) {
            renderer.setYAxisMin(0.0d);
        }
        renderer.setPanEnabled(true, true);
    }

    public final Double getAvg() {
        return this.avg;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractTimeChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public GraphicalView getChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String datePattern) {
        if (isShowBars().booleanValue()) {
            GraphicalView timeMixedChartView = ChartFactory.getTimeMixedChartView(context, dataset, renderer, datePattern);
            timeMixedChartView.getClass();
            return timeMixedChartView;
        }
        GraphicalView timeChartView = ChartFactory.getTimeChartView(context, dataset, renderer, datePattern);
        timeChartView.getClass();
        return timeChartView;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return !isShowAvg().booleanValue() ? new int[]{getArgb(this.extractor.getMeasureColor())} : isShowBars().booleanValue() ? new int[]{this.AVERAGE_COLOR_BARS, getArgb(this.extractor.getMeasureColor())} : new int[]{getArgb(this.extractor.getMeasureColor()), this.AVERAGE_COLOR};
    }

    public final IValueExtractor getExtractor() {
        return this.extractor;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        String measureName = this.extractor.getMeasureName();
        measureName.getClass();
        return measureName;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder, com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return this.extractor.getHelpUrl();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        if (!isShowAvg().booleanValue()) {
            String measureName = this.extractor.getMeasureName();
            measureName.getClass();
            return new String[]{measureName};
        }
        if (!isShowBars().booleanValue()) {
            String measureName2 = this.extractor.getMeasureName();
            measureName2.getClass();
            return new String[]{measureName2, FileInsert$$ExternalSyntheticOutline0.m$1(getContext().getResources().getString(R.string.axis_average), this.avg != null ? FileInsert$$ExternalSyntheticOutline0.m(" (", new DecimalFormat("#.#").format(this.avg), ")") : "")};
        }
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(getContext().getResources().getString(R.string.axis_average), this.avg != null ? FileInsert$$ExternalSyntheticOutline0.m(" (", new DecimalFormat("#.#").format(this.avg), ")") : "");
        String measureName3 = this.extractor.getMeasureName();
        measureName3.getClass();
        return new String[]{strM$1, measureName3};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        String unit = this.extractor.getUnit();
        unit.getClass();
        return unit;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Boolean isShowBars() {
        Boolean boolIsShowBars = super.isShowBars();
        boolIsShowBars.getClass();
        return boolIsShowBars;
    }

    public final ExtractorChartBuilder minMaxOffset(double minMaxOffset) {
        this.minMaxOffset = minMaxOffset;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<double[]> prepareYAxis(List<? extends StatRecord> records, MinMaxFinder minMaxFinder) {
        List<? extends StatRecord> list = records;
        list.getClass();
        minMaxFinder.getClass();
        double[] dArr = new double[list.size()];
        int size = list.size();
        double[] dArr2 = new double[size];
        ArrayList arrayList = new ArrayList();
        int size2 = list.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        double d = 0.0d;
        double dMax = 0.0d;
        while (i < size2) {
            StatRecord statRecord = list.get(i);
            double value = this.extractor.getValue(statRecord);
            addLabel(getLabels(), statRecord);
            if (value != -1.0E42d) {
                dArr[i] = value;
                arrayList.add(Double.valueOf(value));
                if (arrayList.size() > 30) {
                    arrayList.remove(0);
                }
                if (isShowAvg30().booleanValue()) {
                    dArr[i] = ScienceUtil.avg((Double[]) arrayList.toArray(new Double[0]));
                }
                if (minMaxFinder.isAfterDays(getDays(records), statRecord.getFromDate())) {
                    if (value >= 0.0d) {
                        if (dMax > 0.0d && i3 == 0) {
                            i3 = 1;
                        }
                        i3++;
                        dMax += value;
                    }
                    int i4 = i3;
                    dArr2[i] = dMax / ((double) Math.max(i4, 1));
                    minMaxFinder.addValue(dArr[i]);
                    minMaxFinder.addValue(dArr2[i]);
                    i3 = i4;
                } else {
                    if (value > 0.0d) {
                        d += value;
                        i2++;
                    }
                    dMax = d / ((double) Math.max(i2, 1));
                    dArr2[i] = dMax;
                }
            } else if (isShowBars().booleanValue()) {
                dArr[i] = 0.0d;
                dArr2[i] = 0.0d;
                if (i > 0) {
                    dArr2[i] = dArr2[i - 1];
                }
            } else if (i > 0) {
                int i5 = i + 1;
                if (size > i5) {
                    double d2 = dArr[i5];
                    if (d2 != -1.0E42d && d2 > 0.0d) {
                        dArr[i] = (dArr[i - 1] + d2) / 2.0d;
                    } else {
                        dArr[i] = dArr[i - 1];
                    }
                    dArr2[i] = dArr2[i - 1];
                }
            }
            i++;
            list = records;
        }
        minMaxFinder.addValue(minMaxFinder.getMaxValue() + this.minMaxOffset);
        minMaxFinder.addValue(minMaxFinder.getMinValue() - this.minMaxOffset);
        ArrayList arrayList2 = new ArrayList();
        if (isShowBars().booleanValue()) {
            if (isShowAvg().booleanValue()) {
                arrayList2.add(dArr2);
            }
            arrayList2.add(dArr);
        } else {
            arrayList2.add(dArr);
            if (isShowAvg().booleanValue()) {
                arrayList2.add(dArr2);
            }
        }
        if (isShowAvg().booleanValue()) {
            this.avg = ArraysKt.lastOrNull(dArr2);
        }
        return arrayList2;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles(List<StatRecord> records) {
        String strM;
        if (records != null && isShowAvg30().booleanValue()) {
            String strM2 = FileInsert$$ExternalSyntheticOutline0.m(this.extractor.getMeasureName(), " (", getContext().getResources().getString(R.string.days, "30"), " Ø)");
            String string = getContext().getResources().getString(R.string.axis_average);
            if (this.avg != null) {
                strM = FileInsert$$ExternalSyntheticOutline0.m(" (", new DecimalFormat("#.#").format(this.avg), ")");
            } else {
                strM = "";
            }
            return new String[]{strM2, FileInsert$$ExternalSyntheticOutline0.m$1(string, strM)};
        }
        return getTitles();
    }
}
