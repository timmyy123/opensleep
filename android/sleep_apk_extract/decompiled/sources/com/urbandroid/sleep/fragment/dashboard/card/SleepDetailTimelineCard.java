package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.util.ColorUtil;

/* JADX INFO: loaded from: classes4.dex */
public class SleepDetailTimelineCard extends DashboardCard<SleepRecordViewHolder> {
    private SleepRecord sleepRecord;

    public static class SleepRecordViewHolder extends LayeredViewHolder {
        public CardView card;
        public GraphView graph;
        public TextView subtitle;
        public TextView title;

        public SleepRecordViewHolder(View view) {
            super(view);
            this.card = (CardView) view.findViewById(R.id.foreground);
            this.graph = (GraphView) view.findViewById(R.id.row_graph);
            this.title = (TextView) view.findViewById(R.id.title);
            this.subtitle = (TextView) view.findViewById(R.id.row_graph_subtitle);
        }
    }

    public SleepDetailTimelineCard(Activity activity, SleepRecord sleepRecord) {
        super(activity, DashboardCard.Type.SLEEP_TIMELINE, R.layout.card_sleep_detail_timeline);
        this.sleepRecord = sleepRecord;
    }

    private void bindSleepRecordToView(SleepRecord sleepRecord, SleepRecordViewHolder sleepRecordViewHolder) {
        sleepRecordViewHolder.title.setText(getNameResource());
        GraphView graphView = sleepRecordViewHolder.graph;
        if (sleepRecord == null || graphView == null) {
            graphView.setVisibility(4);
            sleepRecordViewHolder.title.setText(R.string.no_history_records);
            return;
        }
        sleepRecordViewHolder.title.setText(R.string.actigraph);
        graphView.setVisibility(0);
        graphView.resetIntervals();
        SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(getContext());
        graphView.setEquidistantValues(new float[0], sleepRecord.shouldUseExactFitView());
        graphView.resetIntervals();
        graphView.setRotateYAxisLabels(false);
        graphView.setDrawGraph(false);
        graphView.setDrawXAxisBars(false);
        sleepGraphInitializer.initActigraph(graphView, sleepRecord);
        graphView.setGradientFullColor(ColorUtil.i(getContext(), R.color.bg_main));
        graphView.setGradientTransColor(ColorUtil.i(getContext(), R.color.bg_main));
        graphView.setCardColor(ColorUtil.i(getContext(), R.color.bg_main));
        graphView.setTextOutlineColor(ColorUtil.i(getContext(), R.color.bg_main));
        graphView.setBackgroundResource(R.drawable.card_dashboard);
        graphView.setDrawIntervals(false);
        graphView.setXAxisLabels(new TimeAxisLabels(getContext(), sleepRecord.getFrom(), sleepRecord.getTo(), sleepRecord.getTimezone(), sleepRecord.getHistory().size(), 60));
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean canBeSwiped() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View view) {
        return new SleepRecordViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.actigraph;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isPinnable() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder sleepRecordViewHolder) {
        bindSleepRecordToView(this.sleepRecord, sleepRecordViewHolder);
    }
}
