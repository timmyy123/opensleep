package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.sleep.addon.stats.util.StatUtil;
import com.urbandroid.util.ColorUtil;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractSleepIrregularityChartBuilder extends AbstractTimeChartBuilder<StatRecord> {
    protected Date since;
    private Date[] xAxisDates;

    public AbstractSleepIrregularityChartBuilder(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        super.adjustRenderer(xYMultipleSeriesRenderer, minMaxFinder);
        xYMultipleSeriesRenderer.setXAxisMin(this.since.getTime());
        xYMultipleSeriesRenderer.setDisplayValues(false);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<StatRecord> filterRecords(List<StatRecord> list) {
        return list;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(this.context, R.color.irregularity)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder, com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#irregularity";
    }

    public abstract List<Pair<Date, Float>> getHistory(Collection<StatRecord> collection);

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        PointStyle pointStyle = PointStyle.POINT;
        return new PointStyle[]{pointStyle, pointStyle};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return null;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public boolean isShowGraphTitle() {
        return false;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractDateChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Date[] prepareXAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        if (this.xAxisDates == null) {
            prepareYAxis(list, minMaxFinder);
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
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -getDays(list));
        this.since = calendar.getTime();
        Date sinceDate = StatUtil.getSinceDate(list);
        if (sinceDate.after(this.since)) {
            this.since = sinceDate;
        }
        list.sort(Comparator.comparing(new Color$$ExternalSyntheticLambda0(5)));
        List<Pair<Date, Float>> history = getHistory(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Calendar calendar2 = Calendar.getInstance();
        for (Pair<Date, Float> pair : history) {
            if (pair.getSecond().floatValue() > 0.0f) {
                float fProcessValue = processValue(pair.getSecond().floatValue());
                arrayList.add(Float.valueOf(fProcessValue));
                if (pair.getFirst().after(this.since)) {
                    minMaxFinder.addValue(fProcessValue);
                }
                arrayList2.add(pair.getFirst());
                minMaxFinder.addDate(pair.getFirst());
                calendar2.setTime(pair.getFirst());
                addLabel(getLabels(), calendar2);
            }
        }
        double[] dArr = new double[arrayList.size() * 2];
        for (int i = 0; i < arrayList.size(); i++) {
            dArr[i] = ((Float) arrayList.get(i)).floatValue();
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(dArr);
        this.xAxisDates = new Date[arrayList2.size()];
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            this.xAxisDates[i2] = (Date) arrayList2.get(i2);
        }
        return arrayList3;
    }

    public abstract float processValue(float f);
}
