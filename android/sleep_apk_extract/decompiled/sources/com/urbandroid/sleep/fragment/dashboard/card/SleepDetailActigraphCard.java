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
import com.urbandroid.sleep.graph.GraphEditActivity;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.util.ColorUtil;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class SleepDetailActigraphCard extends DashboardCard<SleepRecordViewHolder> {
    private final SleepRecord sleepRecord;

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

    public SleepDetailActigraphCard(Activity activity, SleepRecord sleepRecord) {
        super(activity, DashboardCard.Type.SLEEP_ACTIGRAPH, R.layout.card_sleep_detail_actigraph);
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
        sleepGraphInitializer.initActigraph(graphView, sleepRecord);
        graphView.setGradientFullColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard));
        graphView.setGradientTransColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard_trans));
        graphView.setCardColor(ColorUtil.i(getContext(), R.color.graph_time_segments));
        graphView.setBackgroundResource(R.drawable.card_dashboard);
        graphView.setForceXAxisOffset(false);
        graphView.setDrawXAxisBars(true);
        graphView.setSleepGraphColor(ColorUtil.i(getContext(), R.color.bg_card));
        graphView.setSleepGraphLineColor(ColorUtil.i(getContext(), R.color.actigraph));
        graphView.setDoDrawGraphLine(true);
        graphView.setDrawXAxis(false);
        graphView.setDrawIntervals(false);
        graphView.setXAxisLabels(new TimeAxisLabels(getContext(), sleepRecord.getFrom(), sleepRecord.getTo(), sleepRecord.getTimezone(), sleepRecord.getHistory().size(), 60));
        graphView.setDoBlur(TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord));
        if (sleepRecord.hasHypnogram()) {
            sleepRecordViewHolder.tags.setImageResource(R.drawable.empty_ab);
            return;
        }
        Set<String> tags = sleepRecord.getTags(Tag.TAG_QUANTITY_VALUE_PATTERN);
        boolean zIsEmpty = tags.isEmpty();
        ImageView imageView = sleepRecordViewHolder.tags;
        if (zIsEmpty) {
            imageView.setImageResource(R.drawable.empty_ab);
        } else {
            imageView.setImageDrawable(Tag.tagToBitmap(getContext(), tags, true, false));
        }
    }

    public static void openDetail(Activity activity, View view, SleepRecord sleepRecord, boolean z) {
        GraphEditActivity.startForResult(activity, sleepRecord, z);
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
    public void onCardClicked(View view) {
        openDetail(getContext(), view, this.sleepRecord, false);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder sleepRecordViewHolder) {
        bindSleepRecordToView(this.sleepRecord, sleepRecordViewHolder);
    }
}
