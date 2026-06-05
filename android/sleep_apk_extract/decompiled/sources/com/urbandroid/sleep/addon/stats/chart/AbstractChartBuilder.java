package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.graphics.Paint;
import android.text.format.DateFormat;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.sleep.addon.stats.util.PercentileMinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.TimeChart;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractChartBuilder<T extends StatRecord> implements IChartBuilder<T> {
    protected Context context;
    protected XYMultipleSeriesDataset dataset;
    protected String longPattern;
    protected XYMultipleSeriesRenderer renderer;
    protected String shortPattern;
    private int days = -1;
    private Map<Long, String> labels = new HashMap();
    private boolean showGraphTitle = false;
    private int currentMonth = -1;
    private int currentYear = -1;

    public AbstractChartBuilder(Context context) {
        this.shortPattern = "d. MMM";
        this.longPattern = "MM/d/yy";
        this.context = context;
        try {
            this.shortPattern = ((SimpleDateFormat) DateUtil.getShortDateInstanceWithoutYears(context, TimeZone.getDefault())).toPattern();
            this.longPattern = ((SimpleDateFormat) DateFormat.getDateFormat(context)).toPattern();
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public static void commonRendererAdjust(Context context, XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        xYMultipleSeriesRenderer.setShowGridX(true);
        xYMultipleSeriesRenderer.setShowGridY(false);
        xYMultipleSeriesRenderer.setLabelsColor(ColorUtil.i(context, R.color.tertiary));
        xYMultipleSeriesRenderer.setGridColor(ColorUtil.i(context, R.color.shade));
        xYMultipleSeriesRenderer.setGridLineWidth(ActivityUtils.getDip(context, 1));
        xYMultipleSeriesRenderer.setShowLabels(true);
        xYMultipleSeriesRenderer.setFitLegend(true);
        xYMultipleSeriesRenderer.setLegendHeight(SleepStats.getDip(240));
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(context, R.font.product));
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(context, 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(context, 14));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(context, 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(context, 13));
        Paint.Align align = Paint.Align.CENTER;
        xYMultipleSeriesRenderer.setXLabelsAlign(align);
        xYMultipleSeriesRenderer.setYLabelsAlign(align);
        xYMultipleSeriesRenderer.setXLabelsPadding(ActivityUtils.getDip(context, 2));
        xYMultipleSeriesRenderer.setYLabelsPadding(ActivityUtils.getDip(context, 24));
    }

    public void addLabel(Map<Long, String> map, Calendar calendar) {
        String strValueOf;
        if (this.currentMonth == -1) {
            this.currentMonth = calendar.get(2);
        }
        if (this.currentYear == -1) {
            this.currentYear = calendar.get(1);
        }
        if (this.currentYear != calendar.get(1) && isShowAvg30().booleanValue()) {
            map.put(Long.valueOf(calendar.getTimeInMillis()), String.valueOf(calendar.get(1)).substring(2));
            this.currentYear = calendar.get(1);
            this.currentMonth = calendar.get(2);
            return;
        }
        strValueOf = "";
        if (this.currentMonth != calendar.get(2)) {
            map.put(Long.valueOf(calendar.getTimeInMillis()), ((getDays() == SleepStats.PERIODS[4] && this.currentMonth % 2 == 0) || (getDays() == SleepStats.PERIODS[5] && this.currentMonth % 3 == 0) || getDays() < SleepStats.PERIODS[4]) ? calendar.getDisplayName(2, 1, Locale.getDefault()) : "");
            this.currentMonth = calendar.get(2);
            return;
        }
        if (getDays() <= SleepStats.PERIODS[1]) {
            Long lValueOf = Long.valueOf(calendar.getTimeInMillis());
            if (getDays() == SleepStats.PERIODS[0] || (getDays() == SleepStats.PERIODS[1] && calendar.get(5) % 2 == 0)) {
                strValueOf = String.valueOf(calendar.get(5));
            }
            map.put(lValueOf, strValueOf);
            return;
        }
        if (getDays() < SleepStats.PERIODS[2] || getDays() >= SleepStats.PERIODS[3]) {
            return;
        }
        int i = calendar.get(5);
        if (i == 10 || i == 20) {
            map.put(Long.valueOf(calendar.getTimeInMillis()), String.valueOf(i));
        }
    }

    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        commonRendererAdjust(this.context, xYMultipleSeriesRenderer);
    }

    public void adjustSeriesRenderer(XYSeriesRenderer xYSeriesRenderer) {
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public AbstractChartBuilder<T> buildChart(Context context, List<T> list) {
        MinMaxFinder minMaxFinder;
        int i;
        if (list == null) {
            return null;
        }
        List<T> listFilterRecords = filterRecords(list);
        MinMaxFinder minMaxFinderCreateMinMaxFinder = createMinMaxFinder();
        String[] titles = getTitles(listFilterRecords);
        ArrayList arrayList = new ArrayList();
        Date[] dateArrPrepareXAxis = prepareXAxis(listFilterRecords, minMaxFinderCreateMinMaxFinder);
        for (int i2 = 0; i2 < titles.length; i2++) {
            arrayList.add(dateArrPrepareXAxis);
        }
        List<double[]> listPrepareYAxis = prepareYAxis(listFilterRecords, minMaxFinderCreateMinMaxFinder);
        String[] titles2 = getTitles(listFilterRecords);
        if (isRangeLimited()) {
            minMaxFinderCreateMinMaxFinder.setMinDate(getDays(listFilterRecords));
        }
        int[] colors = getColors(listFilterRecords);
        int[] belowColors = getBelowColors();
        if (belowColors == null) {
            belowColors = new int[colors.length];
        }
        PointStyle[] pointStyles = getPointStyles(listFilterRecords);
        if (pointStyles == null) {
            int length = titles2.length;
            PointStyle[] pointStyleArr = new PointStyle[length];
            for (int i3 = 0; i3 < length; i3++) {
                pointStyleArr[i3] = PointStyle.POINT;
            }
            pointStyles = pointStyleArr;
        }
        XYMultipleSeriesRenderer xYMultipleSeriesRendererBuildRenderer = buildRenderer(colors, belowColors, pointStyles);
        this.renderer = xYMultipleSeriesRendererBuildRenderer;
        if (this instanceof ExtractorChartBuilder) {
            xYMultipleSeriesRendererBuildRenderer.setXLabels(0);
        }
        if ((this instanceof AbstractHeatMapRangeChartBuilder) || (this instanceof ExtractorRangeChartBuilder)) {
            minMaxFinder = minMaxFinderCreateMinMaxFinder;
            this.dataset = buildDateDataset2(titles2, arrayList, listPrepareYAxis);
            setChartSettings(this.renderer, isShowGraphTitle() ? getGraphTitle() : null, getXTitle(), getYTitle(), com.urbandroid.sleep.addon.stats.util.DateUtil.getDaysSince(minMaxFinder.getMinDate()), com.urbandroid.sleep.addon.stats.util.DateUtil.getDaysSince(minMaxFinder.getMaxDate()), minMaxFinder.getMinValue(), minMaxFinder.getMaxValue(), ColorUtil.i(context, R.color.tertiary), ColorUtil.i(context, R.color.tertiary));
            i = 0;
            this.renderer.setPanLimits(new double[]{0.0d, System.currentTimeMillis() + TimeChart.DAY, minMaxFinder.getMinValue(), minMaxFinder.getMaxValue()});
        } else {
            this.dataset = buildDateDataset(titles2, arrayList, listPrepareYAxis);
            minMaxFinder = minMaxFinderCreateMinMaxFinder;
            setChartSettings(this.renderer, isShowGraphTitle() ? getGraphTitle() : null, getXTitle(), getYTitle(), minMaxFinderCreateMinMaxFinder.getMinDate().getTime(), minMaxFinderCreateMinMaxFinder.getMaxDate().getTime(), minMaxFinderCreateMinMaxFinder.getMinValue(), minMaxFinderCreateMinMaxFinder.getMaxValue(), ColorUtil.i(context, R.color.tertiary), ColorUtil.i(context, R.color.tertiary));
            double dCurrentTimeMillis = System.currentTimeMillis() + TimeChart.DAY;
            this.renderer.setPanLimits(new double[]{r1 - (((long) SleepStats.DAYS) * 345600000), dCurrentTimeMillis, minMaxFinder.getMaxValue() * (-0.4d), minMaxFinder.getMaxValue() * 1.4d});
            this.renderer.setZoomLimits(new double[]{r1 - (((long) SleepStats.DAYS) * 345600000), dCurrentTimeMillis, minMaxFinder.getMaxValue() * (-0.4d), minMaxFinder.getMaxValue() * 1.4d});
            this.renderer.setZoomInLimitY(1.0d);
            i = 0;
        }
        if (getLabels().size() > 0) {
            this.renderer.setXLabels(i);
            Iterator<Long> it = getLabels().keySet().iterator();
            while (it.hasNext()) {
                this.renderer.addXTextLabel(r2.longValue(), getLabels().get(it.next()));
            }
        }
        adjustRenderer(this.renderer, minMaxFinder);
        return this;
    }

    public XYMultipleSeriesDataset buildDateDataset(String[] strArr, List<Date[]> list, List<double[]> list2) {
        XYMultipleSeriesDataset xYMultipleSeriesDataset = new XYMultipleSeriesDataset();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            TimeSeries timeSeries = new TimeSeries(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder(" "), strArr[i], "  "));
            Date[] dateArr = list.get(i);
            double[] dArr = list2.get(i);
            int iMin = Math.min(dateArr.length, dArr.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                timeSeries.add(dateArr[i2], dArr[i2]);
            }
            xYMultipleSeriesDataset.addSeries(timeSeries);
        }
        return xYMultipleSeriesDataset;
    }

    public XYMultipleSeriesDataset buildDateDataset2(String[] strArr, List<Date[]> list, List<double[]> list2) {
        XYMultipleSeriesDataset xYMultipleSeriesDataset = new XYMultipleSeriesDataset();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            XYSeries xYSeries = new XYSeries(FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("  "), strArr[i], "  "));
            Date[] dateArr = list.get(0);
            double[] dArr = list2.get(i);
            int iMin = Math.min(dArr.length, dateArr.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                xYSeries.add(com.urbandroid.sleep.addon.stats.util.DateUtil.getDaysSince(dateArr[i2]), dArr[i2]);
            }
            xYMultipleSeriesDataset.addSeries(xYSeries);
        }
        return xYMultipleSeriesDataset;
    }

    public XYMultipleSeriesRenderer buildRenderer(int[] iArr, int[] iArr2, PointStyle[] pointStyleArr) {
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer = new XYMultipleSeriesRenderer();
        xYMultipleSeriesRenderer.setPointSize(ActivityUtils.getDip(this.context, 3));
        xYMultipleSeriesRenderer.setAntialiasing(true);
        xYMultipleSeriesRenderer.setMarginsColor(ColorUtil.i(this.context, R.color.bg_charts));
        xYMultipleSeriesRenderer.setBackgroundColor(ColorUtil.i(this.context, R.color.bg_charts));
        if (isShowBars().booleanValue()) {
            if (getDays() <= SleepStats.PERIODS[1]) {
                xYMultipleSeriesRenderer.setBarWidth(ActivityUtils.getDip(this.context, 8));
            }
            if (getDays() <= SleepStats.PERIODS[0]) {
                xYMultipleSeriesRenderer.setBarWidth(ActivityUtils.getDip(this.context, 16));
            }
        }
        xYMultipleSeriesRenderer.setBarSpacing(1.0d);
        xYMultipleSeriesRenderer.setYLabels(10);
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            XYSeriesRenderer xYSeriesRenderer = new XYSeriesRenderer();
            xYSeriesRenderer.setColor(iArr[i]);
            if (iArr2[i] > 0) {
                xYSeriesRenderer.setFillBelowLine(true);
                xYSeriesRenderer.setFillBelowLineColor(iArr2[i]);
            }
            if (pointStyleArr != null) {
                xYSeriesRenderer.setPointStyle(pointStyleArr[i]);
            }
            xYSeriesRenderer.setFillPoints(true);
            int i2 = 0;
            for (int i3 = 0; i3 < SleepStats.PERIODS.length; i3++) {
                if (getDays() >= SleepStats.PERIODS[i3]) {
                    i2 = i3;
                }
            }
            xYSeriesRenderer.setLineWidth(Math.max(((SleepStats.PERIODS.length - i2) * ActivityUtils.getDip(this.context, 1)) / 2.0f, ActivityUtils.getDip(this.context, 2)));
            xYMultipleSeriesRenderer.addSeriesRenderer(xYSeriesRenderer);
            adjustSeriesRenderer(xYSeriesRenderer);
        }
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(this.context, 1));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(this.context, 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(this.context, 13));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(this.context, 13));
        xYMultipleSeriesRenderer.setFitLegend(true);
        xYMultipleSeriesRenderer.setGridColor(ColorUtil.i(this.context, R.color.quaternary));
        xYMultipleSeriesRenderer.setAxesColor(ColorUtil.i(this.context, R.color.transparent));
        xYMultipleSeriesRenderer.setShowTickMarks(false);
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(this.context, R.font.product));
        xYMultipleSeriesRenderer.setShowAxes(false);
        return xYMultipleSeriesRenderer;
    }

    public MinMaxFinder createMinMaxFinder() {
        return new PercentileMinMaxFinder();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public View createView(Context context) {
        return getChartView(context, this.dataset, this.renderer, getDatePattern());
    }

    public List<T> filterRecords(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (SleepStats.FILTER_INSTANCE.filter(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public int[] getBelowColors() {
        return getColors();
    }

    public Calendar getCalendar(StatRecord statRecord) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(statRecord.getToDate());
        if (SleepStats.CUTOFF != 0 && calendar.get(11) > SleepStats.CUTOFF) {
            calendar.add(6, 1);
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public abstract GraphicalView getChartView(Context context, XYMultipleSeriesDataset xYMultipleSeriesDataset, XYMultipleSeriesRenderer xYMultipleSeriesRenderer, String str);

    public abstract int[] getColors();

    public int[] getColors(List<T> list) {
        return getColors();
    }

    public Context getContext() {
        return this.context;
    }

    public String getDatePattern() {
        return getDays() > 200 ? this.longPattern : this.shortPattern;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getDays(List<T> list) {
        int iCurrentTimeMillis;
        if (list.size() > 0) {
            long time = -1;
            for (T t : list) {
                if (t.getFromDate() != null && t.getFromDate().getTime() > time) {
                    time = t.getFromDate().getTime();
                }
            }
            iCurrentTimeMillis = time > 0 ? (((int) (System.currentTimeMillis() - time)) / 3600000) / 24 : 0;
        }
        return getDays() + iCurrentTimeMillis;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return null;
    }

    public Map<Long, String> getLabels() {
        return this.labels;
    }

    public PointStyle[] getPointStyles(List<T> list) {
        return getPointStyles();
    }

    public XYMultipleSeriesRenderer getRenderer() {
        return this.renderer;
    }

    public abstract String[] getTitles();

    public String[] getTitles(List<T> list) {
        return getTitles();
    }

    public abstract String getXTitle();

    public abstract String getYTitle();

    public boolean isRangeLimited() {
        return true;
    }

    public Boolean isShowAvg() {
        return Boolean.TRUE;
    }

    public Boolean isShowAvg30() {
        return Boolean.valueOf(getDays() >= SleepStats.PERIODS[4]);
    }

    public Boolean isShowBars() {
        return Boolean.valueOf(getDays() <= SleepStats.PERIODS[1]);
    }

    public boolean isShowGraphTitle() {
        return this.showGraphTitle;
    }

    public abstract Date[] prepareXAxis(List<T> list, MinMaxFinder minMaxFinder);

    public abstract List<double[]> prepareYAxis(List<T> list, MinMaxFinder minMaxFinder);

    public void setChartSettings(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, String str, String str2, String str3, double d, double d2, double d3, double d4, int i, int i2) {
        if (str != null) {
            xYMultipleSeriesRenderer.setChartTitle(str);
            xYMultipleSeriesRenderer.setMargins(new int[]{ActivityUtils.getDip(this.context, 36), ActivityUtils.getDip(this.context, 72), ActivityUtils.getDip(this.context, 64), ActivityUtils.getDip(this.context, 8)});
        } else {
            xYMultipleSeriesRenderer.setMargins(new int[]{ActivityUtils.getDip(this.context, 16), ActivityUtils.getDip(this.context, 72), ActivityUtils.getDip(this.context, 64), ActivityUtils.getDip(this.context, 8)});
        }
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(this.context, 13));
        xYMultipleSeriesRenderer.setXTitle(str2);
        xYMultipleSeriesRenderer.setYTitle(str3);
        xYMultipleSeriesRenderer.setXAxisMin(d);
        xYMultipleSeriesRenderer.setXAxisMax(d2);
        xYMultipleSeriesRenderer.setYAxisMin(d3);
        xYMultipleSeriesRenderer.setYAxisMax(d4);
        xYMultipleSeriesRenderer.setAxesColor(i);
        xYMultipleSeriesRenderer.setLabelsColor(i2);
        xYMultipleSeriesRenderer.setZoomEnabled(false, true);
        xYMultipleSeriesRenderer.setPanEnabled(true, true);
        xYMultipleSeriesRenderer.setClickEnabled(false);
        xYMultipleSeriesRenderer.setShowLabels(true);
    }

    public AbstractChartBuilder<T> setDays(int i) {
        this.days = i;
        return this;
    }

    public AbstractChartBuilder setShowGraphTitle(boolean z) {
        this.showGraphTitle = z;
        return this;
    }

    public PointStyle[] getPointStyles() {
        return null;
    }

    public int getDays() {
        int i = this.days;
        return i == -1 ? SleepStats.DAYS : i;
    }

    public void addLabel(Map<Long, String> map, StatRecord statRecord) {
        addLabel(map, getCalendar(statRecord));
    }
}
