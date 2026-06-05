package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.addon.stats.ChartFragment;
import com.urbandroid.sleep.addon.stats.SleepStats;
import com.urbandroid.sleep.addon.stats.chart.AbstractChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DebtChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DeepSleepChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DeepSleepTrendChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.DurationChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.ExtractorChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.HourChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.IChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.RatingChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.SnoringChartBuilder;
import com.urbandroid.sleep.addon.stats.model.NoRecordsException;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.addon.stats.model.extractor.AwakeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.BedtimeHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepTrendExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvGainExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RatingExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RegularityIndexExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoringExtractor;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/* JADX INFO: loaded from: classes4.dex */
public class ChartCard extends PageAwareDashboardCard<ChartViewHolder> {
    private static int DAYS = 45;
    private List<IChartBuilder> chartBuilders;
    private String currentChartTitle;
    private int index;
    private List<StatRecord> statRecords;
    private ChartViewHolder viewHolder;

    public static class ChartViewHolder extends LayeredViewHolder {
        public CardView card;
        public ViewGroup chart;
        public TextView title;
        public TextView titleNext;

        public ChartViewHolder(View view) {
            super(view);
            this.card = (CardView) view.findViewById(R.id.foreground);
            this.title = (TextView) view.findViewById(R.id.title);
            this.titleNext = (TextView) view.findViewById(R.id.titleNext);
            this.chart = (ViewGroup) view.findViewById(R.id.chart);
        }
    }

    public ChartCard(Activity activity) {
        super(activity, DashboardCard.Type.CHART, R.layout.card_chart);
        this.chartBuilders = new ArrayList();
        this.index = -1;
    }

    private void bindViewDelayed(ChartViewHolder chartViewHolder, boolean z) {
        List<StatRecord> list = this.statRecords;
        if (list == null || list.size() <= 7) {
            setCardVisibility(getContext(), (ViewGroup) chartViewHolder.itemView, false);
            return;
        }
        setCardVisibility(getContext(), (ViewGroup) chartViewHolder.itemView, true);
        IChartBuilder chartBuilder = getChartBuilder(this.index);
        IChartBuilder chartBuilder2 = getChartBuilder(this.index + 1);
        chartViewHolder.chart.removeAllViews();
        IChartBuilder iChartBuilderBuildChart = chartBuilder.buildChart(getContext(), this.statRecords);
        chartViewHolder.title.setText(iChartBuilderBuildChart.getGraphTitle());
        if (z) {
            chartViewHolder.titleNext.setText(chartBuilder2.getGraphTitle());
        }
        if (iChartBuilderBuildChart instanceof AbstractChartBuilder) {
            adjustRenderer(((AbstractChartBuilder) iChartBuilderBuildChart).getRenderer());
        }
        View viewCreateView = iChartBuilderBuildChart.createView(getContext());
        viewCreateView.setPadding(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        chartViewHolder.chart.addView(viewCreateView, layoutParams);
    }

    private IChartBuilder getChartBuilder(int i) {
        List<IChartBuilder> list = this.chartBuilders;
        return list.get(i % list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean selectChartByTitle(List<IChartBuilder> list, String str) {
        this.index = 0;
        for (int i = 0; i < list.size(); i++) {
            String graphTitle = list.get(i).getGraphTitle();
            if (i == 0) {
                this.currentChartTitle = graphTitle;
            }
            if (graphTitle.equals(str)) {
                this.index = i;
                this.currentChartTitle = graphTitle;
                return true;
            }
        }
        return false;
    }

    public void adjustRenderer(XYMultipleSeriesRenderer xYMultipleSeriesRenderer) {
        if (xYMultipleSeriesRenderer != null) {
            int i = ColorUtil.i(getContext(), R.color.bg_card_dashboard_trans);
            xYMultipleSeriesRenderer.setGridColor(i);
            xYMultipleSeriesRenderer.setBackgroundColor(i);
            xYMultipleSeriesRenderer.setPanEnabled(false);
            xYMultipleSeriesRenderer.setPanEnabled(false, false);
            xYMultipleSeriesRenderer.setZoomEnabled(false);
            xYMultipleSeriesRenderer.setAxesColor(i);
            xYMultipleSeriesRenderer.setXLabels(0);
            xYMultipleSeriesRenderer.setYLabels(0);
            xYMultipleSeriesRenderer.setMarginsColor(i);
            xYMultipleSeriesRenderer.setShowAxes(true);
            xYMultipleSeriesRenderer.setShowLegend(false);
            xYMultipleSeriesRenderer.setShowLabels(false);
            xYMultipleSeriesRenderer.setShowLabels(false);
            xYMultipleSeriesRenderer.setLegendHeight(0);
            xYMultipleSeriesRenderer.setXLabelsAngle(0.0f);
            xYMultipleSeriesRenderer.setYLabelsAngle(0.0f);
            xYMultipleSeriesRenderer.setXTitle(null);
            xYMultipleSeriesRenderer.setYTitle(null);
            xYMultipleSeriesRenderer.setChartTitle(null);
            xYMultipleSeriesRenderer.setDisplayValues(false);
            xYMultipleSeriesRenderer.setShowTickMarks(false);
            for (SimpleSeriesRenderer simpleSeriesRenderer : xYMultipleSeriesRenderer.getSeriesRenderers()) {
                if (simpleSeriesRenderer instanceof XYSeriesRenderer) {
                    ((XYSeriesRenderer) simpleSeriesRenderer).setDisplayChartValues(false);
                }
            }
            int dip = ActivityUtils.getDip(getContext(), 4);
            xYMultipleSeriesRenderer.setMargins(new int[]{dip, dip, dip, dip});
            xYMultipleSeriesRenderer.setClickEnabled(false);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(final ChartViewHolder chartViewHolder) {
        if (chartViewHolder != null) {
            this.viewHolder = chartViewHolder;
            if (this.statRecords != null) {
                bindViewDelayed(chartViewHolder);
                return;
            }
            int i = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt(SleepStats.KEY_PERIOD, 8);
            DAYS = i;
            int iMax = Math.max(7, i);
            DAYS = iMax;
            DAYS = Math.min(90, iMax);
            new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.fragment.dashboard.card.ChartCard.1
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(6, -(ChartCard.DAYS * 2));
                    StatRepo statRepo = new StatRepo();
                    try {
                        statRepo.initialize(ChartCard.this.getContext(), calendar.getTime(), StatRepo.Mode.STATS);
                        ChartCard.this.statRecords = statRepo.getMergedStatRecords();
                        ChartCard.this.chartBuilders.add(new DebtChartBuilder(ChartCard.this.getContext()).setDays(ChartCard.DAYS));
                        ChartCard.this.chartBuilders.add(new DurationChartBuilder(ChartCard.this.getContext()).setDays(ChartCard.DAYS));
                        RegularityIndexExtractor regularityIndexExtractor = new RegularityIndexExtractor(ChartCard.this.getContext());
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, regularityIndexExtractor)) {
                            ChartCard.this.chartBuilders.add(new ExtractorChartBuilder(ChartCard.this.getContext(), regularityIndexExtractor).minMaxOffset(0.0d).setDays(ChartCard.DAYS));
                        }
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, new DeepSleepExtractor(ChartCard.this.getContext()))) {
                            ChartCard.this.chartBuilders.add(new DeepSleepChartBuilder(ChartCard.this.getContext()).setDays(ChartCard.DAYS));
                        }
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, new DeepSleepTrendExtractor(ChartCard.this.getContext()))) {
                            ChartCard.this.chartBuilders.add(new DeepSleepTrendChartBuilder(ChartCard.this.getContext()).setDays(ChartCard.DAYS));
                        }
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, new SnoringExtractor(ChartCard.this.getContext()))) {
                            ChartCard.this.chartBuilders.add(new SnoringChartBuilder(ChartCard.this.getContext()).setDays(ChartCard.DAYS));
                        }
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, new RatingExtractor(ChartCard.this.getContext()))) {
                            ChartCard.this.chartBuilders.add(new RatingChartBuilder(ChartCard.this.getContext()).setDays(ChartCard.DAYS));
                        }
                        BedtimeHourExtractor bedtimeHourExtractor = new BedtimeHourExtractor(ChartCard.this.getContext());
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, bedtimeHourExtractor)) {
                            ChartCard.this.chartBuilders.add(new HourChartBuilder(ChartCard.this.getContext(), bedtimeHourExtractor).setDays(ChartCard.DAYS));
                        }
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, new AwakeExtractor(ChartCard.this.getContext()))) {
                            ChartCard.this.chartBuilders.add(new ExtractorChartBuilder(ChartCard.this.getContext(), new AwakeExtractor(ChartCard.this.getContext())).setDays(ChartCard.DAYS));
                        }
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, new HrExtractor(ChartCard.this.getContext()))) {
                            ChartCard.this.chartBuilders.add(new ExtractorChartBuilder(ChartCard.this.getContext(), new HrExtractor(ChartCard.this.getContext())).setDays(ChartCard.DAYS));
                        }
                        if (ChartFragment.hasMeasureCount(3, ChartCard.this.statRecords, new HrvGainExtractor(ChartCard.this.getContext()))) {
                            ChartCard.this.chartBuilders.add(new ExtractorChartBuilder(ChartCard.this.getContext(), new HrvGainExtractor(ChartCard.this.getContext())).setDays(ChartCard.DAYS));
                        }
                        if (ChartCard.this.index == -1) {
                            Settings settings = new Settings(ChartCard.this.getContext());
                            ChartCard.this.currentChartTitle = settings.getChartTrendLastSelectedGraphTitleFromCard();
                            ChartCard chartCard = ChartCard.this;
                            if (!chartCard.selectChartByTitle(chartCard.chartBuilders, settings.getChartTrendLastSelectedGraphTitle())) {
                                ChartCard chartCard2 = ChartCard.this;
                                chartCard2.selectChartByTitle(chartCard2.chartBuilders, settings.getChartTrendLastSelectedGraphTitleFromCard());
                            }
                        }
                    } catch (NoRecordsException unused) {
                    }
                    return null;
                }

                @Override // android.os.AsyncTask
                public void onPostExecute(Void r1) {
                    super.onPostExecute(r1);
                    ChartCard.this.bindViewDelayed(chartViewHolder);
                }
            }.execute(new Void[0]);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public ChartViewHolder createViewHolder(View view) {
        return new ChartViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.advanced_stats;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void next() {
        if (this.chartBuilders.size() > 0) {
            int size = (this.index + 1) % this.chartBuilders.size();
            this.index = size;
            this.currentChartTitle = this.chartBuilders.get(size).getGraphTitle();
            new Settings(getContext()).setChartTrendLastSelectedGraphTitle(this.currentChartTitle);
            new Settings(getContext()).setChartTrendLastSelectedGraphTitleFromCard(this.currentChartTitle);
            bindViewDelayed(this.viewHolder, false);
        }
        refresh();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        if (this.currentChartTitle != null) {
            new Settings(getContext()).setChartTrendLastSelectedGraphTitle(this.currentChartTitle);
            new Settings(getContext()).setChartTrendLastSelectedGraphTitleFromCard(this.currentChartTitle);
        }
        if (!TrialFilter.getInstance().isTrialExpired()) {
            SleepStats.startFirst(getContext());
        } else if (getContext() instanceof AlarmClock) {
            ((AlarmClock) getContext()).showPurchaseDialog();
        } else {
            Toast.makeText(getContext(), R.string.unlock_text, 1).show();
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard
    public void prev() {
        next();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindViewDelayed(ChartViewHolder chartViewHolder) {
        bindViewDelayed(chartViewHolder, true);
    }
}
