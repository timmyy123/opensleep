package com.urbandroid.sleep.addon.stats;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.chart.ChartLoadAsyncTask;
import com.urbandroid.sleep.addon.stats.chart.ChartLoadSyncTask;
import com.urbandroid.sleep.addon.stats.chart.ChronotypeBarChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.ChronotypeTrendChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DebtChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DeepSleepChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DeepSleepTrendChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DiffExtractorRangeChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DurationChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.ExtractorChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.ExtractorRangeChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.GoalChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.GraphChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.HourChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.MultiScatterChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.RatingChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.RegressionCollectorChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.SleepIrregularityChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.SleepScoreChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.SnoringChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.SocialJetlagBarChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.StatCollectorChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.WakeupHourChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.group.ChartBuilderGroup;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.addon.stats.model.collector.AverageStatRecord;
import com.urbandroid.sleep.addon.stats.model.collector.IStatCollector;
import com.urbandroid.sleep.addon.stats.model.collector.SemanticCollector;
import com.urbandroid.sleep.addon.stats.model.collector.WeekdayCollector;
import com.urbandroid.sleep.addon.stats.model.extractor.AwakeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.BedtimeHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.EfficiencyPercentageExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.FallAsleepHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.FallAsleepMinutesExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvAfterExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvBeforeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvGainExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IrregularityIndexChartExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.MinHrExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RatingExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RdiExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SmartExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoozeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoringExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoringPercentageExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.WakeUpHourExtractor;
import com.urbandroid.sleep.addon.stats.model.regression.Point;
import com.urbandroid.sleep.addon.stats.model.regression.PointSeries;
import com.urbandroid.sleep.addon.stats.model.regression.PointSeriesImpl;
import com.urbandroid.sleep.addon.stats.model.regression.RegressionCollector;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecord;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecords;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.PopulationChronoStats;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.SocialJetlagStats;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.addon.stats.util.StatUtil;
import com.urbandroid.sleep.domain.goal.Goal;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.achartengine.chart.PointStyle;

/* JADX INFO: loaded from: classes4.dex */
public class ChartFragment extends Fragment {
    private int chartId;

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.ChartFragment$1, reason: invalid class name */
    public class AnonymousClass1 extends ChartLoadAsyncTask {
        private ChartBuilderGroup group;
        final /* synthetic */ Activity val$context;
        final /* synthetic */ List val$filteredRecords;
        final /* synthetic */ List val$records;
        final /* synthetic */ SleepScore val$sleepScore;
        final /* synthetic */ SleepStats val$stats;
        final /* synthetic */ ViewGroup val$trendChartView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewGroup viewGroup, Activity activity, ProgressBar progressBar, Activity activity2, SleepScore sleepScore, List list, List list2, SleepStats sleepStats, ViewGroup viewGroup2) {
            super(viewGroup, activity, progressBar);
            this.val$context = activity2;
            this.val$sleepScore = sleepScore;
            this.val$filteredRecords = list;
            this.val$records = list2;
            this.val$stats = sleepStats;
            this.val$trendChartView = viewGroup2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createViews$0(Activity activity, int i) {
            new Settings(activity).setChartTrendLastSelectedGraphTitle(this.group.getBuilderTitle(i));
        }

        @Override // com.urbandroid.sleep.addon.stats.chart.ChartLoadAsyncTask
        public void createViews(List<View> list) {
            if (this.val$context == null || !ChartFragment.this.isAdded() || this.val$context.isFinishing()) {
                return;
            }
            String chartTrendLastSelectedGraphTitle = new Settings(this.val$context).getChartTrendLastSelectedGraphTitle();
            ChartBuilderGroup chartBuilderGroup = new ChartBuilderGroup(this.val$context);
            this.group = chartBuilderGroup;
            chartBuilderGroup.setListener(new ChartFragment$1$$ExternalSyntheticLambda0(this, this.val$context));
            this.group.addBuilder(new SleepScoreChartBuilder(this.val$context).buildChart(this.val$context, Collections.singletonList(this.val$sleepScore)));
            this.group.addBuilder(new DebtChartBuilder(this.val$context).buildChart((Context) this.val$context, this.val$filteredRecords));
            this.group.addBuilder(new DurationChartBuilder(this.val$context).buildChart((Context) this.val$context, this.val$filteredRecords));
            if (StatUtil.hasSleepIrregularityHistory(this.val$context, this.val$records, SleepStats.DAYS)) {
                IrregularityIndexChartExtractor irregularityIndexChartExtractor = new IrregularityIndexChartExtractor(this.val$context);
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, irregularityIndexChartExtractor).buildChart((Context) this.val$context, this.val$records));
                this.group.addBuilder(new DiffExtractorRangeChartBuilder(this.val$context, irregularityIndexChartExtractor.getMeasureName() + " (+/-)", irregularityIndexChartExtractor).buildChart((Context) this.val$context, this.val$records));
                this.group.addBuilder(new SleepIrregularityChartBuilder(this.val$context).buildChart((Context) this.val$context, this.val$records));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new DeepSleepExtractor(this.val$context))) {
                this.group.addBuilder(new DeepSleepChartBuilder(this.val$context).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new DeepSleepExtractor(this.val$context))) {
                this.group.addBuilder(new DeepSleepTrendChartBuilder(this.val$context).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new AwakeExtractor(this.val$context))) {
                ChartBuilderGroup chartBuilderGroup2 = this.group;
                Activity activity = this.val$context;
                chartBuilderGroup2.addBuilder(new ExtractorChartBuilder(activity, new AwakeExtractor(activity)).buildChart((Context) this.val$context, this.val$filteredRecords));
                ChartBuilderGroup chartBuilderGroup3 = this.group;
                Activity activity2 = this.val$context;
                chartBuilderGroup3.addBuilder(new ExtractorChartBuilder(activity2, new EfficiencyPercentageExtractor(activity2)).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new SnoringPercentageExtractor(this.val$context))) {
                ChartBuilderGroup chartBuilderGroup4 = this.group;
                Activity activity3 = this.val$context;
                chartBuilderGroup4.addBuilder(new ExtractorChartBuilder(activity3, new SnoringPercentageExtractor(activity3)).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new SnoringExtractor(this.val$context))) {
                this.group.addBuilder(new SnoringChartBuilder(this.val$context).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new RatingExtractor(this.val$context))) {
                this.group.addBuilder(new RatingChartBuilder(this.val$context).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            this.group.addBuilder(new GraphChartBuilder(this.val$context, this.val$stats.getHeatMap()).buildChart((Context) this.val$context, (List) this.val$stats.getRawStatRecords()));
            BedtimeHourExtractor bedtimeHourExtractor = new BedtimeHourExtractor(this.val$context);
            FallAsleepHourExtractor fallAsleepHourExtractor = new FallAsleepHourExtractor(this.val$context);
            WakeUpHourExtractor wakeUpHourExtractor = new WakeUpHourExtractor(this.val$context);
            this.group.addBuilder(new HourChartBuilder(this.val$context, bedtimeHourExtractor).buildChart((Context) this.val$context, this.val$filteredRecords));
            this.group.addBuilder(new HourChartBuilder(this.val$context, fallAsleepHourExtractor).buildChart((Context) this.val$context, this.val$filteredRecords));
            this.group.addBuilder(new WakeupHourChartBuilder(this.val$context, wakeUpHourExtractor).buildChart((Context) this.val$context, this.val$filteredRecords));
            ChartBuilderGroup chartBuilderGroup5 = this.group;
            Activity activity4 = this.val$context;
            chartBuilderGroup5.addBuilder(new ExtractorChartBuilder(activity4, new FallAsleepMinutesExtractor(activity4)).buildChart((Context) this.val$context, this.val$filteredRecords));
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new SmartExtractor(this.val$context))) {
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, new SmartExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new SnoozeExtractor(this.val$context))) {
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, new SnoozeExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new HrExtractor(this.val$context))) {
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, new HrExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new MinHrExtractor(this.val$context))) {
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, new MinHrExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new HrvExtractor(this.val$context))) {
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, new HrvExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new HrvAfterExtractor(this.val$context))) {
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, new HrvAfterExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
                ChartBuilderGroup chartBuilderGroup6 = this.group;
                Activity activity5 = this.val$context;
                chartBuilderGroup6.addBuilder(new ExtractorRangeChartBuilder(activity5, activity5.getString(R.string.hrv_gain), new HrvBeforeExtractor(this.val$stats.getApplication()), new HrvAfterExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new RdiExtractor(this.val$context))) {
                this.group.addBuilder(new ExtractorChartBuilder(this.val$context, new RdiExtractor(this.val$stats.getApplication())).buildChart((Context) this.val$context, this.val$filteredRecords));
            }
            this.group.setSelected(chartTrendLastSelectedGraphTitle);
            addView(this.val$trendChartView);
            ChartBuilderGroup chartBuilderGroup7 = this.group;
            if (chartBuilderGroup7 != null) {
                chartBuilderGroup7.build((Spinner) this.val$trendChartView.findViewById(R.id.select), (ViewGroup) this.val$trendChartView.findViewById(R.id.chart_parent));
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.ChartFragment$3, reason: invalid class name */
    public class AnonymousClass3 extends ChartLoadAsyncTask {
        private ChartBuilderGroup group;
        final /* synthetic */ Activity val$context;
        final /* synthetic */ List val$filteredRecords;
        final /* synthetic */ Handler val$h;
        final /* synthetic */ SleepStats val$stats;
        final /* synthetic */ ViewGroup val$tagsChartView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ViewGroup viewGroup, Activity activity, ProgressBar progressBar, Activity activity2, SleepStats sleepStats, List list, Handler handler, ViewGroup viewGroup2) {
            super(viewGroup, activity, progressBar);
            this.val$context = activity2;
            this.val$stats = sleepStats;
            this.val$filteredRecords = list;
            this.val$h = handler;
            this.val$tagsChartView = viewGroup2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createViews$0(ViewGroup viewGroup) {
            addView(viewGroup);
        }

        @Override // com.urbandroid.sleep.addon.stats.chart.ChartLoadAsyncTask
        public void createViews(List<View> list) {
            if (this.val$context == null || !ChartFragment.this.isAdded() || this.val$context.isFinishing() || this.val$stats.getStatRepo() == null || this.val$stats.getStatRepo().getQualityCollector() == null || this.val$stats.getStatRepo().getRatingCollector() == null) {
                return;
            }
            this.group = new ChartBuilderGroup(this.val$context);
            SemanticCollector lengthCollector = this.val$stats.getStatRepo().getLengthCollector();
            SemanticCollector qualityCollector = this.val$stats.getStatRepo().getQualityCollector();
            SemanticCollector ratingCollector = this.val$stats.getStatRepo().getRatingCollector();
            SemanticCollector snoringCollector = this.val$stats.getStatRepo().getSnoringCollector();
            SemanticCollector efficiencyCollector = this.val$stats.getStatRepo().getEfficiencyCollector();
            SemanticCollector rdiCollector = this.val$stats.getStatRepo().getRdiCollector();
            SemanticCollector hrCollector = this.val$stats.getStatRepo().getHrCollector();
            SemanticCollector minHrCollector = this.val$stats.getStatRepo().getMinHrCollector();
            SemanticCollector hrvCollector = this.val$stats.getStatRepo().getHrvCollector();
            SemanticCollector hrvGainCollector = this.val$stats.getStatRepo().getHrvGainCollector();
            ArrayList arrayList = new ArrayList();
            arrayList.add(lengthCollector.getTagCollector());
            int i = 0;
            this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(this.val$context.getString(R.string.axis_hour)).setShowTitle(false).buildChart(this.val$context, arrayList));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(qualityCollector.getTagCollector());
            this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(this.val$context.getString(R.string.label_deep_sleep) + " %").setShowTitle(false).buildChart(this.val$context, arrayList2));
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(ratingCollector.getTagCollector());
            this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(this.val$context.getString(R.string.rate)).setShowTitle(false).buildChart(this.val$context, arrayList3));
            ArrayList arrayList4 = new ArrayList();
            arrayList4.add(snoringCollector.getTagCollector());
            this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(this.val$context.getString(R.string.axis_minute)).setShowTitle(false).buildChart(this.val$context, arrayList4));
            ArrayList arrayList5 = new ArrayList();
            arrayList5.add(efficiencyCollector.getTagCollector());
            this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(this.val$context.getString(R.string.axis_minute)).setShowTitle(false).buildChart(this.val$context, arrayList5));
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new HrExtractor(this.val$context))) {
                ArrayList arrayList6 = new ArrayList();
                arrayList6.add(hrCollector.getTagCollector());
                this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(ChartFragment.this.getString(R.string.hr_short)).setShowTitle(false).buildChart(this.val$context, arrayList6));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new MinHrExtractor(this.val$context))) {
                ArrayList arrayList7 = new ArrayList();
                arrayList7.add(minHrCollector.getTagCollector());
                this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(ChartFragment.this.getString(R.string.low) + " " + ChartFragment.this.getString(R.string.hr_short)).setShowTitle(false).buildChart(this.val$context, arrayList7));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new HrvGainExtractor(this.val$context))) {
                ArrayList arrayList8 = new ArrayList();
                arrayList8.add(hrvGainCollector.getTagCollector());
                this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(ChartFragment.this.getString(R.string.hrv_gain)).setShowTitle(false).buildChart(this.val$context, arrayList8));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new HrvExtractor(this.val$context))) {
                ArrayList arrayList9 = new ArrayList();
                arrayList9.add(hrvCollector.getTagCollector());
                this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(ChartFragment.this.getString(R.string.hrv_gain)).setShowTitle(false).buildChart(this.val$context, arrayList9));
            }
            if (ChartFragment.hasMeasure(this.val$filteredRecords, new RdiExtractor(this.val$context))) {
                ArrayList arrayList10 = new ArrayList();
                arrayList10.add(rdiCollector.getTagCollector());
                this.group.addBuilder(new StatCollectorChartBuilder(this.val$context).setUnit(ChartFragment.this.getString(R.string.rr_disturbace)).setShowTitle(false).buildChart(this.val$context, arrayList10));
            }
            this.val$h.post(new ChartFragment$3$$ExternalSyntheticLambda0(this, this.val$tagsChartView, i));
        }

        @Override // com.urbandroid.sleep.addon.stats.chart.ChartLoadAsyncTask, android.os.AsyncTask
        public void onPostExecute(List<View> list) {
            ChartBuilderGroup chartBuilderGroup = this.group;
            if (chartBuilderGroup != null) {
                chartBuilderGroup.build((Spinner) this.val$tagsChartView.findViewById(R.id.select), (ViewGroup) this.val$tagsChartView.findViewById(R.id.chart_parent));
            }
            super.onPostExecute(list);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.ChartFragment$5, reason: invalid class name */
    public class AnonymousClass5 extends ChartLoadSyncTask {
        final /* synthetic */ Handler val$h;
        final /* synthetic */ SleepStats val$stats;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(ViewGroup viewGroup, Activity activity, ProgressBar progressBar, Handler handler, SleepStats sleepStats) {
            super(viewGroup, activity, progressBar);
            this.val$h = handler;
            this.val$stats = sleepStats;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createViews$0(Activity activity, Goal goal, SleepStats sleepStats) {
            addView(new GoalChartBuilder(activity, goal).buildChart((Context) activity, (List) sleepStats.getMergedStatRecords()).createView(activity));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createViews$1(Activity activity) {
            addView(ChartFragment.this.getNoRecordsMessageView(activity.getString(R.string.no_history_records)));
        }

        @Override // com.urbandroid.sleep.addon.stats.chart.ChartLoadSyncTask
        public void createViews(List<View> list) {
            final FragmentActivity activity = ChartFragment.this.getActivity();
            if (activity == null || !ChartFragment.this.isAdded() || activity.isFinishing()) {
                return;
            }
            final Goal currentGoal = new Settings(ChartFragment.this.getActivity()).getCurrentGoal();
            Handler handler = this.val$h;
            if (currentGoal == null) {
                handler.post(new ChartFragment$3$$ExternalSyntheticLambda0(this, activity, 1));
                return;
            }
            try {
                final SleepStats sleepStats = this.val$stats;
                handler.post(new Runnable() { // from class: com.urbandroid.sleep.addon.stats.ChartFragment$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createViews$0(activity, currentGoal, sleepStats);
                    }
                });
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMessageView, reason: not valid java name */
    public static /* bridge */ /* synthetic */ View m1171$$Nest$mgetMessageView(ChartFragment chartFragment, String str) {
        return chartFragment.getMessageView(str, R.drawable.ic_alert, R.layout.chart_message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getAdviceTextView(Context context, RegressionCollector regressionCollector) {
        double localMax = regressionCollector.getLocalMax();
        if (localMax < 0.0d) {
            return null;
        }
        return getMessageView(Html.fromHtml(context.getString(R.string.advice_text, "<b>" + regressionCollector.getYName() + "</b>", "<b>" + regressionCollector.getXName() + "</b>", "<b>" + DateUtil.formatMinutes(Integer.valueOf((int) Math.round(BedtimeHourExtractor.adjustHourBack(localMax) * 60.0d))) + "</b>")), R.drawable.ic_lightbulb, R.layout.chart_message);
    }

    private View getMessageView(CharSequence charSequence, int i, boolean z, int i2) {
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(i2, (ViewGroup) null, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.text);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.icon);
        textView.setText(charSequence);
        textView.setPadding(SleepStats.getDip(8), 0, SleepStats.getDip(8), 0);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.secondary));
        if (i != -1) {
            imageView.setImageDrawable(getContext().getResources().getDrawable(i));
            if (z) {
                imageView.setPadding(SleepStats.getDip(8), 0, SleepStats.getDip(8), 0);
                imageView.setColorFilter(getContext().getResources().getColor(R.color.secondary));
            }
        }
        return viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getNoAdvice(Context context, RegressionCollector... regressionCollectorArr) {
        boolean z = true;
        for (RegressionCollector regressionCollector : regressionCollectorArr) {
            if (regressionCollector.getLocalMax() >= 0.0d) {
                z = false;
            }
        }
        if (z) {
            return getMessageView(context.getString(R.string.advice_no), R.drawable.ic_alert, R.layout.chart_message);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getNoRecordsMessageView(String str) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setGravity(17);
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(str);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.secondary));
        linearLayout.addView(textView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getSeparatorView() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setPadding(0, SleepStats.getDip(16), 0, 0);
        return textView;
    }

    public static boolean hasMeasure(List<StatRecord> list, IValueExtractor iValueExtractor) {
        Iterator<StatRecord> it = list.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            double value = iValueExtractor.getValue(it.next());
            if (value >= 0.0d) {
                d += value;
            }
        }
        return d > 0.0d;
    }

    public static boolean hasMeasureCount(int i, List<StatRecord> list, IValueExtractor iValueExtractor) {
        Iterator<StatRecord> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (iValueExtractor.getValue(it.next()) > 0.0d) {
                i2++;
            }
        }
        return i2 >= i;
    }

    public static ChartFragment newInstance(int i) {
        Logger.logInfo("SleepStats: onNewInstance");
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_CHART", i);
        ChartFragment chartFragment = new ChartFragment();
        chartFragment.setArguments(bundle);
        return chartFragment;
    }

    private Point toPoint(ChronoRecord chronoRecord) {
        return new Point(chronoRecord.getToHour(), chronoRecord.getLength());
    }

    private List<Point> toPoints(Collection<ChronoRecord> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<ChronoRecord> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(toPoint(it.next()));
        }
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Logger.logInfo("SleepStats: onCreate");
        super.onCreate(bundle);
        this.chartId = getArguments().getInt("ARG_CHART");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Logger.logInfo("SleepStats: onCreateView");
        Handler handler = new Handler();
        final FragmentActivity activity = getActivity();
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_chart, viewGroup, false);
        ProgressBar progressBar = (ProgressBar) viewGroup2.findViewById(R.id.progress);
        final SleepStats sleepStats = (SleepStats) getActivity();
        if (sleepStats == null || sleepStats.getMergedStatRecords() == null || sleepStats.getMergedStatRecords().size() == 0) {
            Logger.logInfo("SleepStats: no data  " + sleepStats);
            if (sleepStats != null) {
                Logger.logInfo("SleepStats: no data  " + sleepStats.getMergedStatRecords());
            }
            sleepStats.noData = true;
            return getNoRecordsMessageView(activity.getString(R.string.no_history_records));
        }
        Logger.logInfo("SleepStats: onCreateView " + this.chartId + " period: " + sleepStats.getPeriod());
        ArrayList arrayList = new ArrayList(sleepStats.getMergedStatRecords());
        final List<StatRecord> listFilterSelectedRecords = StatUtil.filterSelectedRecords(new ArrayList(arrayList));
        ViewGroup viewGroup3 = (ViewGroup) layoutInflater.inflate(R.layout.chart_group, viewGroup, false);
        ViewGroup viewGroup4 = (ViewGroup) layoutInflater.inflate(R.layout.chart_group, viewGroup, false);
        int i = this.chartId;
        if (i != 0) {
            if (i == 1) {
                new AnonymousClass3(viewGroup2, getActivity(), progressBar, activity, sleepStats, listFilterSelectedRecords, handler, viewGroup4).setViewCount(3).execute(new Void[0]);
                return viewGroup2;
            }
            if (i == 2) {
                new ChartLoadSyncTask(viewGroup2, getActivity(), progressBar) { // from class: com.urbandroid.sleep.addon.stats.ChartFragment.2
                    @Override // com.urbandroid.sleep.addon.stats.chart.ChartLoadSyncTask
                    public void createViews(List<View> list) {
                        if (activity == null || !ChartFragment.this.isAdded() || activity.isFinishing()) {
                            return;
                        }
                        float fCalculateChronotype = ((StatRepo) sleepStats.getStatRepo()).calculateChronotype();
                        new Settings(ChartFragment.this.getActivity()).setChronotype(fCalculateChronotype);
                        SocialJetlagStats socialJetlagStatsCreate = SocialJetlagStats.create(StatUtil.filterSelectedRecords(sleepStats.getMergedStatRecords()), activity);
                        List list2 = listFilterSelectedRecords;
                        if (list2 == null || list2.size() < 1) {
                            addView(ChartFragment.m1171$$Nest$mgetMessageView(ChartFragment.this, activity.getResources().getString(R.string.no_history_records)));
                            return;
                        }
                        if (fCalculateChronotype != -1.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(activity.getString(R.string.chronotype));
                            sb.append("<br><b><big>");
                            sb.append(activity.getString(socialJetlagStatsCreate.getChronotype() < 0.5f ? R.string.lark : R.string.owl));
                            sb.append(" ");
                            sb.append(String.valueOf(Math.round(PopulationChronoStats.getChronotypeRank(socialJetlagStatsCreate.getChronotype()))));
                            sb.append("</big></b><br><i>");
                            String strM = FileInsert$$ExternalSyntheticOutline0.m(sb, activity.getResources().getStringArray(R.array.period_array)[SleepStats.PERIOD_INDEX], "</i>");
                            Logger.logInfo("Message: ".concat(strM));
                            addView(ChartFragment.m1170$$Nest$mgetMessageView(ChartFragment.this, Html.fromHtml(strM), socialJetlagStatsCreate.getChronotype() < 0.5f ? R.drawable.lark : R.drawable.owl));
                        }
                        float midSleepFreeDays = socialJetlagStatsCreate.getMidSleepFreeDays();
                        int i2 = ((double) socialJetlagStatsCreate.getChronotype()) < 0.5d ? R.color.rating : R.color.score_deep_sleep;
                        if (!Float.isNaN(midSleepFreeDays)) {
                            addView(new ChronotypeBarChartBuilder(activity, i2).buildChart(activity, socialJetlagStatsCreate).createView(activity));
                        }
                        if (sleepStats.getMergedStatRecords().size() > 100) {
                            addView(new ChronotypeTrendChartBuilder(activity).setShowGraphTitle(true).buildChart((Context) activity, (List) sleepStats.getMergedStatRecords()).createView(activity));
                        }
                        if (socialJetlagStatsCreate.size() > 10) {
                            PointSeriesImpl pointSeriesImpl = new PointSeriesImpl("", activity.getString(R.string.working_days), ChartFragment.this.toPoints(socialJetlagStatsCreate.getBusyDays()));
                            PointSeriesImpl pointSeriesImpl2 = new PointSeriesImpl("", activity.getString(R.string.free_days), ChartFragment.this.toPoints(socialJetlagStatsCreate.getFreeDays()));
                            PointSeriesImpl pointSeriesImpl3 = new PointSeriesImpl("", activity.getString(R.string.outliers), ChartFragment.this.toPoints(socialJetlagStatsCreate.getUnclassifiedDays()));
                            MultiScatterChartBuilder multiScatterChartBuilder = new MultiScatterChartBuilder(activity);
                            Activity activity2 = activity;
                            String string = activity2.getString(R.string.wake_up_hour);
                            String string2 = activity.getString(R.string.sleep_duration);
                            List<PointSeries> listAsList = Arrays.asList(pointSeriesImpl, pointSeriesImpl2, pointSeriesImpl3);
                            int[] iArr = {ColorUtil.i(activity, R.color.score_deep_sleep), ColorUtil.i(activity, R.color.duration), ColorUtil.i(activity, R.color.quaternary)};
                            PointStyle pointStyle = PointStyle.CIRCLE;
                            addView(multiScatterChartBuilder.buildChart(activity2, "", string, string2, listAsList, iArr, new PointStyle[]{pointStyle, pointStyle, pointStyle}).createView(activity));
                        }
                        if (socialJetlagStatsCreate.size() > 20) {
                            addView(new SocialJetlagBarChartBuilder(activity).buildChart(activity, socialJetlagStatsCreate).createView(activity));
                        }
                    }
                }.setViewCount(6).execute(new Void[0]);
                return viewGroup2;
            }
            if (i == 3) {
                new ChartLoadSyncTask(viewGroup2, getActivity(), progressBar) { // from class: com.urbandroid.sleep.addon.stats.ChartFragment.4
                    @Override // com.urbandroid.sleep.addon.stats.chart.ChartLoadSyncTask
                    public void createViews(List<View> list) {
                        if (activity == null || !ChartFragment.this.isAdded() || activity.isFinishing()) {
                            return;
                        }
                        SemanticCollector lengthCollector = sleepStats.getStatRepo().getLengthCollector();
                        SemanticCollector qualityCollector = sleepStats.getStatRepo().getQualityCollector();
                        SemanticCollector ratingCollector = sleepStats.getStatRepo().getRatingCollector();
                        SemanticCollector snoringCollector = sleepStats.getStatRepo().getSnoringCollector();
                        SemanticCollector efficiencyCollector = sleepStats.getStatRepo().getEfficiencyCollector();
                        addView(ChartFragment.this.getNoAdvice(activity, qualityCollector.getDurationRegressionCollector(), ratingCollector.getDurationRegressionCollector(), qualityCollector.getMidnightRegressionCollector(), ratingCollector.getMidnightRegressionCollector()));
                        addView(ChartFragment.this.getAdviceTextView(activity, qualityCollector.getDurationRegressionCollector()));
                        addView(ChartFragment.this.getAdviceTextView(activity, ratingCollector.getDurationRegressionCollector()));
                        addView(ChartFragment.this.getAdviceTextView(activity, efficiencyCollector.getDurationRegressionCollector()));
                        addView(ChartFragment.this.getAdviceTextView(activity, qualityCollector.getMidnightRegressionCollector()));
                        addView(ChartFragment.this.getAdviceTextView(activity, ratingCollector.getMidnightRegressionCollector()));
                        addView(ChartFragment.this.getAdviceTextView(activity, efficiencyCollector.getMidnightRegressionCollector()));
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(qualityCollector.getMidnightRegressionCollector());
                        arrayList2.add(ratingCollector.getMidnightRegressionCollector());
                        arrayList2.add(efficiencyCollector.getMidnightRegressionCollector());
                        addView(new RegressionCollectorChartBuilder(activity).buildChart((Context) activity, (List<PointSeries>) arrayList2).createView((Context) activity));
                        addView(ChartFragment.this.getSeparatorView());
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(qualityCollector.getDurationRegressionCollector());
                        arrayList3.add(ratingCollector.getDurationRegressionCollector());
                        arrayList3.add(efficiencyCollector.getDurationRegressionCollector());
                        addView(new RegressionCollectorChartBuilder(activity).buildChart((Context) activity, (List<PointSeries>) arrayList3).createView((Context) activity));
                        addView(ChartFragment.this.getSeparatorView());
                        WeekdayCollector regularityIndexCollector = sleepStats.getStatRepo().getRegularityIndexCollector();
                        ArrayList arrayList4 = new ArrayList();
                        arrayList4.add(regularityIndexCollector);
                        addView(new StatCollectorChartBuilder(activity).setUnit(activity.getString(R.string.irregularity_index_short)).setShowTitle(false).buildChart(activity, arrayList4).createView(activity));
                        addView(ChartFragment.this.getSeparatorView());
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.add(qualityCollector.getMidnightCollector());
                        arrayList5.add(ratingCollector.getMidnightCollector());
                        arrayList5.add(efficiencyCollector.getMidnightCollector());
                        addView(new StatCollectorChartBuilder(activity).buildChart((Context) activity, (List<IStatCollector>) arrayList5).createView((Context) activity));
                        addView(ChartFragment.this.getSeparatorView());
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.add(lengthCollector.getMidnightCollector());
                        addView(new StatCollectorChartBuilder(activity).setUnit(activity.getString(R.string.axis_hour)).buildChart((Context) activity, (List<IStatCollector>) arrayList6).createView((Context) activity));
                        ArrayList arrayList7 = new ArrayList();
                        arrayList7.add(qualityCollector.getWeekdayCollector());
                        arrayList7.add(ratingCollector.getWeekdayCollector());
                        arrayList7.add(efficiencyCollector.getWeekdayCollector());
                        addView(new StatCollectorChartBuilder(activity).buildChart((Context) activity, (List<IStatCollector>) arrayList7).createView((Context) activity));
                        addView(ChartFragment.this.getSeparatorView());
                        ArrayList arrayList8 = new ArrayList();
                        arrayList8.add(lengthCollector.getWeekdayCollector());
                        addView(new StatCollectorChartBuilder(activity).setUnit(activity.getString(R.string.axis_hour)).buildChart((Context) activity, (List<IStatCollector>) arrayList8).createView((Context) activity));
                        addView(ChartFragment.this.getSeparatorView());
                        ArrayList arrayList9 = new ArrayList();
                        arrayList9.add(snoringCollector.getMidnightCollector());
                        addView(new StatCollectorChartBuilder(activity).buildChart((Context) activity, (List<IStatCollector>) arrayList9).createView((Context) activity));
                        addView(ChartFragment.this.getSeparatorView());
                    }
                }.setViewCount(14).execute(new Void[0]);
                return viewGroup2;
            }
            if (i != 4) {
                return viewGroup2;
            }
            new AnonymousClass5(viewGroup2, getActivity(), progressBar, handler, sleepStats).setViewCount(1).execute(new Void[0]);
            return viewGroup2;
        }
        AverageStatRecord averageStatRecord = new AverageStatRecord(activity, listFilterSelectedRecords);
        SleepScore sleepScore = new SleepScore();
        sleepScore.setAge(new Settings(activity).getAge());
        sleepScore.updateMeasure(SleepScore.ScoreMeasure.DURATION, averageStatRecord.getLengthInHours() * 60.0f);
        if (averageStatRecord.getIrregularityInMinutes() > 0.0f) {
            sleepScore.updateMeasure(SleepScore.ScoreMeasure.IRREGULARITY, averageStatRecord.getIrregularityInMinutes());
        }
        if (averageStatRecord.getQuality() > 0.0f) {
            sleepScore.updateMeasure(SleepScore.ScoreMeasure.DEEP_SLEEP, averageStatRecord.getQuality());
        }
        float lengthInHours = (averageStatRecord.getLengthInHours() * 60.0f) / (averageStatRecord.getTrackLengthInHours() * 60.0f);
        if (lengthInHours < 1.0f && lengthInHours > 0.0f) {
            sleepScore.updateMeasure(SleepScore.ScoreMeasure.EFFICIENCY, lengthInHours);
        }
        if (averageStatRecord.getSnore() > 0) {
            sleepScore.updateMeasure(SleepScore.ScoreMeasure.SNORE, (averageStatRecord.getSnore() / 60) / ((averageStatRecord.getLengthInHours() * 60.0f) + 1.0f));
        }
        if (averageStatRecord.getRating() > 0.0f) {
            sleepScore.updateMeasure(SleepScore.ScoreMeasure.RATING, averageStatRecord.getRating());
        }
        if (averageStatRecord.getHrvAfter() > 0.0f) {
            sleepScore.updateMeasure(SleepScore.ScoreMeasure.HRV, averageStatRecord.getHrvAfter() - averageStatRecord.getHrvBefore());
        }
        if (averageStatRecord.getRdi() > 0) {
            sleepScore.updateMeasure(SleepScore.ScoreMeasure.RDI, averageStatRecord.getRdi());
        }
        new AnonymousClass1(viewGroup2, getActivity(), progressBar, activity, sleepScore, listFilterSelectedRecords, arrayList, sleepStats, viewGroup3).setViewCount(1).execute(new Void[0]);
        return viewGroup2;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMessageView, reason: not valid java name */
    public static /* bridge */ /* synthetic */ View m1170$$Nest$mgetMessageView(ChartFragment chartFragment, Spanned spanned, int i) {
        return chartFragment.getMessageView(spanned, i, false, R.layout.chart_message_big);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Point> toPoints(ChronoRecords chronoRecords) {
        return toPoints(chronoRecords.getRecords().values());
    }

    private View getMessageView(CharSequence charSequence, int i, int i2) {
        return getMessageView(charSequence, i, true, i2);
    }
}
