package com.urbandroid.sleep.addon.stats.chart;

import android.content.Context;
import android.graphics.Paint;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.addon.stats.util.MinMaxFinder;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.CombinedXYChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.TimeChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u001bH\u0016¢\u0006\u0004\b\"\u0010#J/\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010$2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010*J1\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020%H\u0016¢\u0006\u0004\b2\u00103J7\u00108\u001a\u0002072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u00105\u001a\u0004\u0018\u0001042\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00106\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b8\u00109R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010:R\u0018\u0010;\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010<R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR3\u0010F\u001a\u001e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00160Cj\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u0016`E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/GoalBarChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/chart/AbstractTimeChartBuilder;", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/goal/Goal;", "goal", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal;)V", "Ljava/util/Date;", "date", "", "records", "Lcom/urbandroid/sleep/addon/stats/model/IMeasureRecord;", "getRecordForDate", "(Ljava/util/Date;Ljava/util/List;)Lcom/urbandroid/sleep/addon/stats/model/IMeasureRecord;", "", "isRangeLimited", "()Z", "", "getDays", "()I", "", "getYTitle", "()Ljava/lang/String;", "getXTitle", "getGraphTitle", "", "Lorg/achartengine/chart/PointStyle;", "getPointStyles", "()[Lorg/achartengine/chart/PointStyle;", "", "getColors", "()[I", "getTitles", "()[Ljava/lang/String;", "", "Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;", "minMaxFinder", "prepareXAxis", "(Ljava/util/List;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)[Ljava/util/Date;", "createMinMaxFinder", "()Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;", "", "prepareYAxis", "(Ljava/util/List;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)Ljava/util/List;", "Lorg/achartengine/renderer/XYMultipleSeriesRenderer;", "renderer", "finder", "", "adjustRenderer", "(Lorg/achartengine/renderer/XYMultipleSeriesRenderer;Lcom/urbandroid/sleep/addon/stats/util/MinMaxFinder;)V", "Lorg/achartengine/model/XYMultipleSeriesDataset;", "dataset", "datePattern", "Lorg/achartengine/GraphicalView;", "getChartView", "(Landroid/content/Context;Lorg/achartengine/model/XYMultipleSeriesDataset;Lorg/achartengine/renderer/XYMultipleSeriesRenderer;Ljava/lang/String;)Lorg/achartengine/GraphicalView;", "Lcom/urbandroid/sleep/domain/goal/Goal;", "fromTime", "Ljava/util/Date;", "toTime", "dates", "[Ljava/util/Date;", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "extractor", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "labels", "Ljava/util/HashMap;", "getLabels", "()Ljava/util/HashMap;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoalBarChartBuilder extends AbstractTimeChartBuilder<StatRecord> {
    private Date[] dates;
    private final IValueExtractor extractor;
    private Date fromTime;
    private final Goal goal;
    private final HashMap<Long, String> labels;
    private Date toTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoalBarChartBuilder(Context context, Goal goal) {
        super(context);
        goal.getClass();
        this.goal = goal;
        this.dates = new Date[0];
        this.extractor = Goal.INSTANCE.createExtractor(context, goal.type);
        this.labels = new HashMap<>();
    }

    private final IMeasureRecord getRecordForDate(Date date, List<StatRecord> records) {
        Object obj = null;
        if (records == null) {
            return null;
        }
        Iterator<T> it = records.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            StatRecord statRecord = (StatRecord) next;
            if (DateUtil.isSameDate(statRecord != null ? statRecord.getToDate() : null, date)) {
                obj = next;
                break;
            }
        }
        return (StatRecord) obj;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public void adjustRenderer(XYMultipleSeriesRenderer renderer, MinMaxFinder finder) {
        renderer.getClass();
        finder.getClass();
        AbstractChartBuilder.commonRendererAdjust(this.context, renderer);
        renderer.setDisplayValues(false);
        renderer.setPointSize(ActivityUtils.getDip(this.context, 4));
        double d = this.goal.target;
        renderer.addYTextLabel(d, this.extractor.getValuePresentation(d));
        renderer.setMarginsColor(ColorUtil.i(this.context, R.color.bg_main));
        renderer.setBackgroundColor(ColorUtil.i(this.context, R.color.bg_main));
        renderer.setShowLegend(true);
        renderer.setShowGrid(false);
        renderer.setShowAxes(false);
        renderer.setDisplayValues(false);
        renderer.setPointSize(ActivityUtils.getDip(this.context, 3));
        double d2 = this.goal.base;
        renderer.addYTextLabel(d2, this.extractor.getValuePresentation(d2));
        double d3 = this.goal.target;
        renderer.addYTextLabel(d3, this.extractor.getValuePresentation(d3));
        renderer.addYTextLabel(finder.getMaxValue(), "");
        renderer.addYTextLabel(finder.getMinValue(), this.extractor.getValuePresentation(finder.getMinValue()));
        renderer.setXLabels(0);
        renderer.setYLabels(0);
        renderer.setXLabelsAlign(Paint.Align.CENTER);
        Iterator<Map.Entry<Long, String>> it = this.labels.entrySet().iterator();
        while (it.hasNext()) {
            renderer.addXTextLabel(r8.getKey().longValue(), it.next().getValue());
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public MinMaxFinder createMinMaxFinder() {
        return new MinMaxFinder();
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractTimeChartBuilder, com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public GraphicalView getChartView(Context context, XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, String datePattern) {
        GraphicalView combinedXYChartView = ChartFactory.getCombinedXYChartView(context, dataset, renderer, new CombinedXYChart.XYCombinedChartDef[]{new CombinedXYChart.XYCombinedChartDef(BarChart.TYPE, 0), new CombinedXYChart.XYCombinedChartDef(BarChart.TYPE, 1), new CombinedXYChart.XYCombinedChartDef(LineChart.TYPE, 2)});
        combinedXYChartView.getClass();
        return combinedXYChartView;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int[] getColors() {
        return new int[]{ColorUtil.i(this.context, R.color.positive), ColorUtil.i(this.context, R.color.negative), ColorUtil.i(this.context, R.color.goal_target)};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public int getDays() {
        return (this.goal.getGoalDays() * 2) + ((int) ((System.currentTimeMillis() - this.goal.endTime) / TimeChart.DAY));
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.IChartBuilder
    public String getGraphTitle() {
        return "";
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public PointStyle[] getPointStyles() {
        PointStyle pointStyle = PointStyle.POINT;
        return new PointStyle[]{pointStyle, pointStyle, pointStyle};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String[] getTitles() {
        String string = getContext().getResources().getString(R.string.sucess);
        string.getClass();
        String string2 = getContext().getResources().getString(R.string.failed);
        string2.getClass();
        String string3 = getContext().getResources().getString(R.string.goal);
        string3.getClass();
        return new String[]{string, string2, string3};
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public String getXTitle() {
        return "";
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
    public Date[] prepareXAxis(List<? extends StatRecord> records, MinMaxFinder minMaxFinder) {
        minMaxFinder.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        com.urbandroid.common.util.DateUtil.resetCalendarTimeDayStart(calendar);
        this.toTime = calendar.getTime();
        calendar.add(5, -this.goal.getGoalDays());
        com.urbandroid.common.util.DateUtil.resetCalendarTimeDayStart(calendar);
        this.fromTime = calendar.getTime();
        ArrayList arrayList = new ArrayList();
        minMaxFinder.setMinDate(7);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(this.goal.startTime);
        com.urbandroid.common.util.DateUtil.resetCalendarTimeDayStart(calendar2);
        if (calendar2.before(calendar)) {
            calendar.setTime(calendar2.getTime());
            this.fromTime = calendar.getTime();
        }
        Logger.logInfo("Goal: cal daily chart " + calendar.getTime());
        Logger.logInfo("Goal: start daily chart " + calendar2.getTime());
        while (calendar.getTime().before(this.toTime)) {
            Date time = calendar.getTime();
            time.getClass();
            arrayList.add(time);
            calendar.add(5, 1);
            long timeInMillis = ((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 3600000) / 24;
            Logger.logInfo("Goal: daily chart " + calendar.getTime() + " " + calendar2.getTime() + " " + timeInMillis);
            if (timeInMillis > this.goal.getGoalDays()) {
                long goalDays = timeInMillis - ((long) this.goal.getGoalDays());
                HashMap<Long, String> map = this.labels;
                if (goalDays > 99) {
                    map.put(Long.valueOf(calendar.getTimeInMillis()), "");
                } else {
                    map.put(Long.valueOf(calendar.getTimeInMillis()), MqttTopic.SINGLE_LEVEL_WILDCARD + (timeInMillis - ((long) this.goal.getGoalDays())));
                }
            } else {
                this.labels.put(Long.valueOf(calendar.getTimeInMillis()), String.valueOf(timeInMillis));
            }
        }
        Date[] dateArr = (Date[]) arrayList.toArray(new Date[0]);
        this.dates = dateArr;
        return dateArr;
    }

    @Override // com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder
    public List<double[]> prepareYAxis(List<StatRecord> records, MinMaxFinder minMaxFinder) {
        Calendar calendar;
        double d;
        Date[] dateArr;
        GoalBarChartBuilder goalBarChartBuilder = this;
        List<StatRecord> list = records;
        Date[] dateArr2 = goalBarChartBuilder.dates;
        double[] dArr = new double[dateArr2.length];
        double[] dArr2 = new double[dateArr2.length];
        double[] dArr3 = new double[dateArr2.length];
        Calendar calendar2 = Calendar.getInstance();
        double d2 = goalBarChartBuilder.goal.target;
        Date[] dateArr3 = goalBarChartBuilder.dates;
        int length = dateArr3.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Date date = dateArr3[i];
            int i3 = i;
            double d3 = goalBarChartBuilder.goal.target;
            dArr[i2] = d3;
            if (minMaxFinder != null) {
                minMaxFinder.addValue(d3 * 1.12d);
            }
            calendar2.setTime(date);
            IMeasureRecord recordForDate = goalBarChartBuilder.getRecordForDate(date, list);
            if (recordForDate != null) {
                double value = goalBarChartBuilder.extractor.getValue(recordForDate);
                Goal goal = goalBarChartBuilder.goal;
                calendar = calendar2;
                d = d2;
                if (goal.type == Goal.Type.IRREGULARITY) {
                    Goal.Companion companion = Goal.INSTANCE;
                    value = companion.createAggregator(goalBarChartBuilder.context, goalBarChartBuilder.goal.type).aggregate(companion.filterGoalRecords(goal, list, date, 30));
                }
                if (value > 0.0d) {
                    dArr2[i2] = value;
                    if (minMaxFinder != null) {
                        minMaxFinder.addValue(value);
                    }
                    Goal goal2 = goalBarChartBuilder.goal;
                    double d4 = goal2.target;
                    double d5 = goal2.base;
                    boolean z = d4 >= d5;
                    dateArr = dateArr3;
                    Logger.logInfo("Goal: " + date + " - " + d5 + " -> " + value + " -> " + d4 + " " + z);
                    if ((z && dArr2[i2] < d) || (!z && dArr2[i2] > d)) {
                        dArr3[i2] = dArr2[i2];
                        dArr2[i2] = 0.0d;
                    }
                }
                i2++;
                i = i3 + 1;
                goalBarChartBuilder = this;
                list = records;
                calendar2 = calendar;
                d2 = d;
                dateArr3 = dateArr;
            } else {
                calendar = calendar2;
                d = d2;
            }
            dateArr = dateArr3;
            i2++;
            i = i3 + 1;
            goalBarChartBuilder = this;
            list = records;
            calendar2 = calendar;
            d2 = d;
            dateArr3 = dateArr;
        }
        if (minMaxFinder != null) {
            minMaxFinder.addValue(minMaxFinder.getMinValue() * 0.96d);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dArr2);
        arrayList.add(dArr3);
        arrayList.add(dArr);
        return arrayList;
    }
}
