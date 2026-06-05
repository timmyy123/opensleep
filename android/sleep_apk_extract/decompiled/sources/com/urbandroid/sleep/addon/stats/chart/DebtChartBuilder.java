package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.achartengine.chart.PointStyle;

/* JADX INFO: loaded from: classes4.dex */
public class DebtChartBuilder extends AbstractTimeChartBuilder<StatRecord> {
    private int ideal;

    public DebtChartBuilder(Context context) {
        super(context);
        this.ideal = 420;
        this.ideal = new Settings(context).getIdealSleepMinutes();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public MinMaxFinder createMinMaxFinder() {
        return new MinMaxFinder();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getBelowColors() {
        return new int[]{ColorUtil.addAlpha(ColorUtil.i(this.context, R.color.positive), 99), ColorUtil.addAlpha(ColorUtil.i(this.context, R.color.negative_light), 99), 0};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(this.context, R.color.positive), ColorUtil.i(this.context, R.color.negative_light), ColorUtil.i(this.context, R.color.average)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return getContext().getString(R.string.stats_caption_debt);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder, com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getHelpUrl() {
        return "https://sleep.urbandroid.org/docs//sleep/charts.html#deficit";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        PointStyle pointStyle = PointStyle.POINT;
        return new PointStyle[]{pointStyle, pointStyle, pointStyle};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        return new String[]{getContext().getResources().getString(R.string.total_surplus), getContext().getResources().getString(R.string.stats_caption_total), ""};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        return getContext().getResources().getString(R.string.axis_hour);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<double[]> prepareYAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        double[] dArr = new double[list.size()];
        double[] dArr2 = new double[list.size()];
        double[] dArr3 = new double[list.size()];
        Calendar calendar = Calendar.getInstance();
        if (minMaxFinder.getMaxDate() != null) {
            calendar.setTime(minMaxFinder.getMaxDate());
        }
        calendar.add(5, -(getDays(list) - 1));
        Date time = calendar.getTime();
        Logger.logInfo("Debt: " + getDays(list));
        float f = ((float) this.ideal) / 60.0f;
        double d = 0.0d;
        for (int i = 0; i < list.size(); i++) {
            StatRecord statRecord = list.get(i);
            double dMax = Math.max(statRecord.getLengthInHours() - f, -f);
            dArr[i] = dMax;
            minMaxFinder.addValue(dMax);
            addLabel(getLabels(), statRecord);
            if (statRecord.getLengthInHours() < 0.2d || time.after(statRecord.getToDate())) {
                dArr2[i] = d;
                dArr3[i] = d;
            } else {
                d += dArr[i];
                if (d >= 0.0d) {
                    dArr2[i] = 0.0d;
                    dArr3[i] = d;
                } else {
                    dArr2[i] = d;
                    dArr3[i] = 0.0d;
                }
                if (i > 0) {
                    double d2 = dArr2[i];
                    if (d2 == 0.0d && dArr3[i] != 0.0d) {
                        dArr2[i - 1] = 0.0d;
                    } else if (d2 != 0.0d && dArr3[i] == 0.0d) {
                        dArr3[i - 1] = 0.0d;
                    }
                }
                minMaxFinder.addValue(dArr2[i]);
                minMaxFinder.addValue(dArr3[i]);
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dArr3);
        arrayList.add(dArr2);
        arrayList.add(dArr);
        return arrayList;
    }
}
