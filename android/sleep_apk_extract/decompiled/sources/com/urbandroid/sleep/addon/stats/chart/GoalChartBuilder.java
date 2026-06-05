package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.TimeChart;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class GoalChartBuilder extends AbstractTimeChartBuilder<StatRecord> {
    private Date[] dates;
    private IValueExtractor extractor;
    private Date fromTime;
    private Goal goal;
    private Date toTime;

    public GoalChartBuilder(Context context, Goal goal) {
        super(context);
        this.goal = goal;
        this.extractor = Goal.createExtractor(context, goal.type);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer, MinMaxFinder minMaxFinder) {
        AbstractChartBuilder.commonRendererAdjust(this.context, xYMultipleSeriesRenderer);
        xYMultipleSeriesRenderer.setZoomEnabled(false, false);
        xYMultipleSeriesRenderer.setPanEnabled(false, false);
        xYMultipleSeriesRenderer.setDisplayValues(false);
        xYMultipleSeriesRenderer.setPointSize(ActivityUtils.getDip(this.context, 3));
        double d = this.goal.base;
        xYMultipleSeriesRenderer.addYTextLabel(d, this.extractor.getValuePresentation(d));
        double d2 = this.goal.target;
        xYMultipleSeriesRenderer.addYTextLabel(d2, this.extractor.getValuePresentation(d2));
        xYMultipleSeriesRenderer.addYTextLabel(minMaxFinder.getMaxValue(), "");
        xYMultipleSeriesRenderer.addYTextLabel(minMaxFinder.getMinValue(), "");
        minMaxFinder.getMinValue();
        minMaxFinder.getMaxValue();
        xYMultipleSeriesRenderer.setMarginsColor(ColorUtil.i(this.context, R.color.bg_main));
        xYMultipleSeriesRenderer.setBackgroundColor(ColorUtil.i(this.context, R.color.bg_main));
        xYMultipleSeriesRenderer.setAxesColor(ColorUtil.i(this.context, R.color.quaternary));
        xYMultipleSeriesRenderer.setGridColor(ColorUtil.i(this.context, R.color.transparent));
        xYMultipleSeriesRenderer.setShowGrid(false);
        xYMultipleSeriesRenderer.setShowGridY(true);
        xYMultipleSeriesRenderer.setYLabels(0);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public MinMaxFinder createMinMaxFinder() {
        return new MinMaxFinder();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(this.context, R.color.goal_progress), ColorUtil.i(this.context, R.color.goal_target)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int getDays() {
        super.getDays();
        return (this.goal.getGoalDays() * 2) + ((int) ((System.currentTimeMillis() - this.goal.endTime) / TimeChart.DAY));
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return Goal.INSTANCE.getGoalTitle(this.context, this.extractor);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        PointStyle pointStyle = PointStyle.POINT;
        return new PointStyle[]{pointStyle, pointStyle};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getContext().getResources().getString(R.string.axis_average) + " " + this.extractor.getMeasureName().toLowerCase());
        StringBuilder sb = new StringBuilder(" ");
        sb.append(getContext().getResources().getString(R.string.goal));
        arrayList.add(sb.toString());
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return null;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getYTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public boolean isRangeLimited() {
        return false;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractDateChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public Date[] prepareXAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        calendar.add(5, -27);
        Date time2 = calendar.getTime();
        Calendar calendar2 = Calendar.getInstance();
        Date time3 = calendar2.getTime();
        calendar2.setTime(new Date(Math.max(this.goal.startTime, time2.getTime())));
        calendar2.add(5, -3);
        DateUtil.resetCalendarTimeDayStart(calendar2);
        this.fromTime = calendar2.getTime();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTimeInMillis(Math.max(this.goal.endTime, time.getTime()));
        calendar3.add(5, 2);
        DateUtil.resetCalendarTimeDayStart(calendar3);
        this.toTime = calendar3.getTime();
        minMaxFinder.addDate(this.fromTime);
        minMaxFinder.addDate(this.toTime);
        ArrayList arrayList = new ArrayList();
        calendar2.setTime(this.fromTime);
        while (true) {
            if (!calendar2.getTime().before(time3) && !calendar2.getTime().before(this.toTime)) {
                Date[] dateArr = (Date[]) arrayList.toArray(new Date[0]);
                this.dates = dateArr;
                return dateArr;
            }
            arrayList.add(calendar2.getTime());
            calendar2.add(5, 1);
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<double[]> prepareYAxis(List<StatRecord> list, MinMaxFinder minMaxFinder) {
        int i;
        Logger.logInfo("Goal: minMax BEFORE " + this.extractor.getValuePresentation(minMaxFinder.getMinValue()) + " -> " + this.extractor.getValuePresentation(minMaxFinder.getMaxValue()));
        Date[] dateArr = this.dates;
        double[] dArr = new double[dateArr.length];
        double[] dArr2 = new double[dateArr.length];
        Date date = new Date(System.currentTimeMillis() + 1);
        Goal goal = this.goal;
        Math.abs((goal.target - goal.base) / 8.0d);
        Logger.logInfo("Goal: minMax BASE " + this.extractor.getValuePresentation(this.goal.base) + " TARGET " + this.extractor.getValuePresentation(this.goal.target));
        Goal goal2 = this.goal;
        double dAbs = Math.abs(goal2.target - goal2.base) * 1.0d;
        Goal goal3 = this.goal;
        double dAbs2 = Math.abs(goal3.target - goal3.base) * 0.3d;
        Goal goal4 = this.goal;
        minMaxFinder.setMaxValue(Math.max(goal4.target, goal4.base) + dAbs);
        Goal goal5 = this.goal;
        minMaxFinder.setMinValue(Math.min(goal5.target, goal5.base) - dAbs);
        minMaxFinder.addValue(this.goal.current + dAbs2);
        minMaxFinder.addValue(this.goal.current - dAbs2);
        Logger.logInfo("Goal: minMax BEFORE " + this.extractor.getValuePresentation(minMaxFinder.getMinValue()) + " -> " + this.extractor.getValuePresentation(minMaxFinder.getMaxValue()));
        Calendar calendar = Calendar.getInstance();
        Date[] dateArr2 = this.dates;
        int length = dateArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Date date2 = dateArr2[i2];
            boolean zAfter = date2.after(date);
            long time = date2.getTime();
            Goal goal6 = this.goal;
            Date date3 = date;
            Date[] dateArr3 = dateArr2;
            boolean z = time > goal6.startTime;
            List<StatRecord> listFilterGoalRecords = Goal.filterGoalRecords(goal6, list, date2, 30);
            Goal goal7 = this.goal;
            if (z) {
                i = length;
                dArr[i3] = goal7.target;
            } else {
                i = length;
                dArr[i3] = goal7.base;
            }
            calendar.setTime(date2);
            addLabel(getLabels(), calendar);
            this.goal.getProgressWholeDays(date2);
            if (!zAfter) {
                dArr2[i3] = Goal.createAggregator(this.context, this.goal.type).aggregate(listFilterGoalRecords);
            } else if (i3 > 0) {
                dArr2[i3] = dArr2[i3 - 1];
            }
            i3++;
            i2++;
            length = i;
            date = date3;
            dateArr2 = dateArr3;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dArr2);
        arrayList.add(dArr);
        Logger.logInfo("Goal: minMax AFTER " + this.extractor.getValuePresentation(minMaxFinder.getMinValue()) + " -> " + this.extractor.getValuePresentation(minMaxFinder.getMaxValue()));
        return arrayList;
    }
}
