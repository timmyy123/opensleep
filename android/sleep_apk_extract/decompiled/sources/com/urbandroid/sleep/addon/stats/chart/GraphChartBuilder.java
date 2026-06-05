package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import android.graphics.Color;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.TimeChart;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class GraphChartBuilder extends AbstractHeatMapRangeChartBuilder<StatRecord> {
    private boolean is24hourFormat;

    public GraphChartBuilder(Context context, List<float[]> list) {
        super(context, list);
        this.is24hourFormat = false;
        this.is24hourFormat = new Settings(context).is24HourFormat();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        super.adjustRenderer(xYMultipleSeriesRenderer, minMaxFinder);
        int i = 0;
        while (i < 25) {
            if (i % 2 == 0) {
                int i2 = i < 12 ? i + 12 : i - 12;
                String string = i2 + ":00";
                if (!this.is24hourFormat) {
                    if (i2 < 1) {
                        string = "12am";
                    } else if (i2 < 12) {
                        string = i2 + "am";
                    } else if (i2 < 13) {
                        string = "12pm";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i2 - 12);
                        sb.append("pm");
                        string = sb.toString();
                    }
                }
                xYMultipleSeriesRenderer.addYTextLabel(i, string);
            }
            i++;
        }
        xYMultipleSeriesRenderer.setDisplayValues(false);
        xYMultipleSeriesRenderer.setMargins(new int[]{ActivityUtils.getDip(this.context, 16), ActivityUtils.getDip(this.context, 80), ActivityUtils.getDip(this.context, 64), ActivityUtils.getDip(this.context, 8)});
        xYMultipleSeriesRenderer.setPanEnabled(true, true);
        xYMultipleSeriesRenderer.setZoomEnabled(false, true);
        xYMultipleSeriesRenderer.setBarSpacing(0.0d);
        xYMultipleSeriesRenderer.setYLabels(0);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{Color.argb(180, 100, 250, 100)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return getContext().getResources().getString(R.string.actigraph);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder, com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#graphs";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        return new PointStyle[]{PointStyle.DIAMOND};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        return new String[]{getContext().getResources().getString(R.string.non_deep_sleep_sensitivity_title)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        return getContext().getResources().getString(R.string.axis_pattern_titles);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractDateChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Date[] prepareXAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        if (list.size() > 0) {
            calendar.setTime(list.get(0).getToDate());
            calendar.set(11, 0);
            calendar.set(12, 1);
        }
        for (StatRecord statRecord : list) {
            Date toDate = statRecord.getToDate();
            TimeZone timeZone = statRecord.getTimeZone();
            if (DateUtil.isSameDate(statRecord.getToDate(), statRecord.getTimeZone(), statRecord.getFromDate(), statRecord.getTimeZone()) && statRecord.getToHour() > 12.0d && statRecord.getFromHour() > 12.0d) {
                toDate = new Date(toDate.getTime() + TimeChart.DAY);
            }
            while (!calendar.getTime().after(statRecord.getToDate()) && !DateUtil.isSameDate(calendar.getTime(), calendar.getTimeZone(), toDate, timeZone) && !calendar.getTime().after(minMaxFinder.getMaxDate())) {
                arrayList.add(calendar.getTime());
                arrayList.add(calendar.getTime());
                calendar.add(5, 1);
            }
            arrayList.add(calendar.getTime());
            arrayList.add(calendar.getTime());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            minMaxFinder.addDate((Date) it.next());
            minMaxFinder.addValueX(DateUtil.getDaysSince(r0));
        }
        return (Date[]) arrayList.toArray(new Date[0]);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<double[]> prepareYAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        double d;
        Double dValueOf = Double.valueOf(0.0d);
        ArrayList arrayList = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        Collections.sort(list, new Comparator<StatRecord>() { // from class: com.urbandroid.sleep.addon.stats.chart.GraphChartBuilder.1
            @Override // java.util.Comparator
            public int compare(StatRecord statRecord, StatRecord statRecord2) {
                return statRecord.getToDate().compareTo(statRecord2.getToDate());
            }
        });
        if (list.size() > 0) {
            calendar.setTime(list.get(0).getToDate());
            calendar.set(11, 0);
            calendar.set(12, 1);
        }
        int i = 0;
        for (StatRecord statRecord : list) {
            Date toDate = statRecord.getToDate();
            TimeZone timeZone = statRecord.getTimeZone();
            if (!DateUtil.isSameDate(statRecord.getToDate(), statRecord.getTimeZone(), statRecord.getFromDate(), statRecord.getTimeZone()) || statRecord.getToHour() <= 12.0d || statRecord.getFromHour() <= 12.0d) {
                d = 12.0d;
            } else {
                d = 12.0d;
                toDate = new Date(toDate.getTime() + TimeChart.DAY);
            }
            while (!calendar.getTime().after(statRecord.getToDate()) && !DateUtil.isSameDate(calendar.getTime(), calendar.getTimeZone(), toDate, timeZone) && !calendar.getTime().after(minMaxFinder.getMaxDate())) {
                arrayList.add(dValueOf);
                arrayList.add(dValueOf);
                calendar.add(6, 1);
                getHeatMap().add(i, null);
                i++;
            }
            double fromHour = statRecord.getFromHour();
            double toHour = statRecord.getToHour();
            double d2 = fromHour < d ? fromHour + d : fromHour - d;
            double d3 = toHour < d ? toHour + d : toHour - d;
            if (d3 < d2) {
                d3 += 24.0d;
            }
            arrayList.add(Double.valueOf(d2));
            arrayList.add(Double.valueOf(d3));
            minMaxFinder.addValue(d2);
            minMaxFinder.addValue(d3);
            i++;
        }
        double[] dArr = new double[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            dArr[i2] = ((Double) arrayList.get(i2)).doubleValue();
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(dArr);
        return arrayList2;
    }
}
