package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.NewSleepGraphYDescriptionAxisLabels;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.util.ColorUtil;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SleepDetailHypnogramCard extends DashboardCard<SleepRecordViewHolder> {
    private SleepRecord sleepRecord;

    public static class SleepRecordViewHolder extends LayeredViewHolder {
        public CardView card;
        public GraphView graph;
        public TextView subtitle;
        public ImageView tags;
        public TextView title;

        public SleepRecordViewHolder(View view) {
            super(view);
            this.card = (CardView) view.findViewById(R.id.foreground);
            this.graph = (GraphView) view.findViewById(R.id.row_graph);
            this.title = (TextView) view.findViewById(R.id.title);
            this.subtitle = (TextView) view.findViewById(R.id.row_graph_subtitle);
            this.tags = (ImageView) view.findViewById(R.id.tags);
        }
    }

    public SleepDetailHypnogramCard(Activity activity, SleepRecord sleepRecord) {
        super(activity, DashboardCard.Type.SLEEP_HYPNOGRAM, R.layout.card_sleep_detail_hypnogram);
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
        graphView.setVisibility(0);
        graphView.resetIntervals();
        SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(getContext());
        graphView.setEquidistantValues(new float[0], sleepRecord.shouldUseExactFitView());
        graphView.resetIntervals();
        graphView.setRotateYAxisLabels(false);
        sleepGraphInitializer.initActigraph(graphView, sleepRecord);
        sleepGraphInitializer.initHypnogram(graphView, sleepRecord);
        sleepGraphInitializer.populateHypnogram(graphView, sleepRecord);
        graphView.setDrawXAxisBars(true);
        graphView.setDrawGraph(false);
        graphView.setDrawGraph(false);
        graphView.setGradientFullColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard));
        graphView.setGradientTransColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard_trans));
        graphView.setCardColor(ColorUtil.i(getContext(), R.color.graph_time_segments));
        graphView.setXAxisLabels(new TimeAxisLabels(getContext(), sleepRecord.getFrom(), sleepRecord.getTo(), sleepRecord.getTimezone(), sleepRecord.getHistory().size(), 60));
        graphView.setDrawXAxis(false);
        graphView.setDrawXAxisBars(true);
        graphView.setYAxisLabels(new NewSleepGraphYDescriptionAxisLabels(getContext()));
        graphView.setForceXAxisOffset(true);
        graphView.setBackgroundResource(R.drawable.card_dashboard);
        graphView.setDoBlur(TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord));
        Set<String> tags = sleepRecord.getTags(Tag.TAG_QUANTITY_VALUE_PATTERN);
        boolean zIsEmpty = tags.isEmpty();
        ImageView imageView = sleepRecordViewHolder.tags;
        if (zIsEmpty) {
            imageView.setImageResource(R.drawable.empty_ab);
        } else {
            imageView.setImageDrawable(Tag.tagToBitmap(getContext(), tags, true, false));
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View view) {
        return new SleepRecordViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.hypnogram;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        SleepDetailActigraphCard.openDetail(getContext(), view, this.sleepRecord, false);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder sleepRecordViewHolder) {
        bindSleepRecordToView(this.sleepRecord, sleepRecordViewHolder);
    }
}
