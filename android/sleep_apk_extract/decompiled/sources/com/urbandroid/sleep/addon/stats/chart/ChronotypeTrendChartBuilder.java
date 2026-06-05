package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import androidx.core.content.res.ResourcesCompat;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes4.dex */
public class ChronotypeTrendChartBuilder extends AbstractRangeChart2Builder<StatRecord> {
    private Date since;
    private Date[] xAxisDates;

    public ChronotypeTrendChartBuilder(Context context) {
        super(context);
        this.since = null;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        super.adjustRenderer(xYMultipleSeriesRenderer, minMaxFinder);
        xYMultipleSeriesRenderer.setZoomEnabled(false, false);
        xYMultipleSeriesRenderer.setPanEnabled(false, false);
        xYMultipleSeriesRenderer.setXAxisMin(this.since.getTime());
        xYMultipleSeriesRenderer.setDisplayValues(false);
        xYMultipleSeriesRenderer.setBarWidth(ActivityUtils.getDip(getContext(), 3));
        xYMultipleSeriesRenderer.setBarSpacing(ActivityUtils.getDip(getContext(), 1));
        xYMultipleSeriesRenderer.setShowTickMarks(false);
        xYMultipleSeriesRenderer.setShowAxes(false);
        xYMultipleSeriesRenderer.setTextTypeface(ResourcesCompat.getFont(getContext(), R.font.product));
        xYMultipleSeriesRenderer.setChartTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setLabelsTextSize(ActivityUtils.getDip(getContext(), 14));
        xYMultipleSeriesRenderer.setLegendTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setAxisTitleTextSize(ActivityUtils.getDip(getContext(), 13));
        xYMultipleSeriesRenderer.setShowGrid(false);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<StatRecord> filterRecords(List<StatRecord> list) {
        return list;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(this.context, R.color.score_deep_sleep), ColorUtil.i(this.context, R.color.rating)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getDatePattern() {
        return this.longPattern;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return getContext().getResources().getStringArray(R.array.period_array)[6] + " " + getContext().getResources().getString(R.string.trend).toLowerCase();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        PointStyle pointStyle = PointStyle.POINT;
        return new PointStyle[]{pointStyle, pointStyle};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        return new String[]{getContext().getResources().getString(R.string.owl), getContext().getResources().getString(R.string.lark)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        return getContext().getResources().getString(R.string.lark) + " / " + getContext().getResources().getString(R.string.owl);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractDateChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Date[] prepareXAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        if (this.xAxisDates == null) {
            prepareYAxis(list, new MinMaxFinder());
        }
        for (Date date : this.xAxisDates) {
            minMaxFinder.addDate(date);
        }
        return this.xAxisDates;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<double[]> prepareYAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        if (list.size() == 0) {
            return new ArrayList();
        }
        Collections.sort(list, new Comparator<StatRecord>() { // from class: com.urbandroid.sleep.addon.stats.chart.ChronotypeTrendChartBuilder.1
            @Override // java.util.Comparator
            public int compare(StatRecord statRecord, StatRecord statRecord2) {
                return statRecord.getToDate().compareTo(statRecord2.getToDate());
            }
        });
        this.since = list.get(0).getFromDate();
        List<Pair<Date, Float>> chronotypeHistory = SocialJetlagStats.create(list, this.context).getChronotypeHistory(2, 1);
        double[] dArr = new double[chronotypeHistory.size() * 2];
        double[] dArr2 = new double[chronotypeHistory.size() * 2];
        for (int i = 0; i < chronotypeHistory.size(); i++) {
            float fFloatValue = chronotypeHistory.get(i).getSecond().floatValue();
            int i2 = i * 2;
            dArr[i2] = 0.5d;
            int i3 = i2 + 1;
            dArr[i3] = 0.5d;
            dArr2[i2] = 0.5d;
            dArr2[i3] = 0.5d;
            if (fFloatValue != -1.0f) {
                double d = fFloatValue;
                if (d <= 0.45d) {
                    dArr[i2] = d;
                } else if (d >= 0.55d) {
                    dArr2[i3] = d;
                } else {
                    dArr[i2] = 0.49d;
                    dArr[i3] = 0.5d;
                    dArr2[i2] = 0.5d;
                    dArr2[i3] = 0.51d;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dArr2);
        arrayList.add(dArr);
        this.xAxisDates = new Date[chronotypeHistory.size() * 2];
        for (int i4 = 0; i4 < chronotypeHistory.size(); i4++) {
            Date first = chronotypeHistory.get(i4).getFirst();
            Date[] dateArr = this.xAxisDates;
            int i5 = i4 * 2;
            dateArr[i5] = first;
            dateArr[i5 + 1] = first;
        }
        minMaxFinder.addValue(0.0d);
        minMaxFinder.addValue(1.0d);
        return arrayList;
    }
}
