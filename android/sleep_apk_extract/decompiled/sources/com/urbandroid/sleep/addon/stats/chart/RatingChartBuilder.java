package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.PointStyle;

/* JADX INFO: loaded from: classes4.dex */
public class RatingChartBuilder extends AbstractNoMoveTimeChartBuilder<StatRecord> {
    public RatingChartBuilder(Context context) {
        super(context);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(this.context, R.color.rating)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return getContext().getResources().getString(R.string.axis_rating);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder, com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#rating";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        return new PointStyle[]{PointStyle.POINT};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        return new String[]{getContext().getResources().getString(R.string.axis_average)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        return getContext().getResources().getString(R.string.axis_rating);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<double[]> prepareYAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        double[] dArr = new double[list.size()];
        double d = 0.0d;
        double dMax = 0.0d;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            StatRecord statRecord = list.get(i3);
            double rating = statRecord.getRating();
            if (minMaxFinder.isAfterDays(getDays(list), statRecord.getFromDate())) {
                if (rating > 0.0d) {
                    if (dMax > 0.0d && i2 == 0) {
                        i2 = 1;
                    }
                    dMax += rating;
                    i2++;
                }
                double dMax2 = dMax / ((double) Math.max(i2, 1));
                dArr[i3] = dMax2;
                minMaxFinder.addValue(dMax2);
            } else {
                if (rating > 0.0d) {
                    d += rating;
                    i++;
                }
                dMax = d / ((double) Math.max(i, 1));
                dArr[i3] = dMax;
            }
        }
        minMaxFinder.addValue(Math.min(minMaxFinder.getMaxValue() + 1.0d, 5.0d));
        minMaxFinder.addValue(Math.max(minMaxFinder.getMinValue() - 1.0d, 0.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(dArr);
        return arrayList;
    }
}
