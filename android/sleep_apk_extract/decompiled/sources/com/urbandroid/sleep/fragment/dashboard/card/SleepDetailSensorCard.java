package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.graph.GraphLegend;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001#B)\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailSensorCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailSensorCard$SleepRecordViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard$Type;", "type", "Lcom/urbandroid/sleep/graph/GraphLegend;", "legend", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard$Type;Lcom/urbandroid/sleep/graph/GraphLegend;)V", "viewHolder", "", "bindSleepRecordToView", "(Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailSensorCard$SleepRecordViewHolder;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailSensorCard$SleepRecordViewHolder;", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailSensorCard$SleepRecordViewHolder;)V", "", "getNameResource", "()I", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Lcom/urbandroid/sleep/graph/GraphLegend;", "getLegend", "()Lcom/urbandroid/sleep/graph/GraphLegend;", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailSensorCard extends DashboardCard<SleepRecordViewHolder> {
    private final GraphLegend legend;
    private final SleepRecord sleepRecord;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailSensorCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "Lcom/urbandroid/sleep/graph/GraphView;", "graph", "Lcom/urbandroid/sleep/graph/GraphView;", "getGraph", "()Lcom/urbandroid/sleep/graph/GraphView;", "setGraph", "(Lcom/urbandroid/sleep/graph/GraphView;)V", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "setCard", "(Landroidx/cardview/widget/CardView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private CardView card;
        private GraphView graph;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.foreground);
            viewFindViewById.getClass();
            this.card = (CardView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.row_graph);
            viewFindViewById2.getClass();
            this.graph = (GraphView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.title);
            viewFindViewById3.getClass();
            this.title = (TextView) viewFindViewById3;
        }

        public final GraphView getGraph() {
            return this.graph;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepDetailSensorCard(Activity activity, SleepRecord sleepRecord, DashboardCard.Type type, GraphLegend graphLegend) {
        super(activity, type, R.layout.card_sleep_detail_sensor);
        sleepRecord.getClass();
        type.getClass();
        graphLegend.getClass();
        this.sleepRecord = sleepRecord;
        this.legend = graphLegend;
    }

    private final void bindSleepRecordToView(SleepRecord sleepRecord, SleepRecordViewHolder viewHolder) {
        SleepGraphInitializer sleepGraphInitializer;
        Float fValueOf = Float.valueOf(0.0f);
        viewHolder.getTitle().setText(this.legend.getTitleResource());
        GraphView graph = viewHolder.getGraph();
        if (sleepRecord == null || graph == null) {
            graph.setVisibility(4);
            viewHolder.getTitle().setText(R.string.no_history_records);
            return;
        }
        graph.setVisibility(0);
        graph.resetIntervals();
        SleepGraphInitializer sleepGraphInitializer2 = new SleepGraphInitializer(getContext());
        graph.setEquidistantValues(new float[0], sleepRecord.shouldUseExactFitView());
        graph.resetIntervals();
        graph.setRotateYAxisLabels(false);
        if (sleepRecord.hasActigraph()) {
            sleepGraphInitializer2.initActigraph(graph, sleepRecord);
            sleepGraphInitializer = sleepGraphInitializer2;
        } else {
            sleepGraphInitializer = sleepGraphInitializer2;
            sleepRecord.setHistory(CollectionsKt.toList(CollectionsKt.arrayListOf(fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf, fValueOf)));
            sleepGraphInitializer.initActigraph(graph, sleepRecord);
        }
        graph.setGradientFullColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard));
        graph.setGradientTransColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard_trans));
        graph.setCardColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard));
        graph.setBackgroundResource(R.drawable.card_dashboard);
        graph.setDrawXAxisBars(true);
        graph.setDrawGraph(false);
        graph.setDrawIntervals(false);
        graph.setDoBlur(TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord));
        GraphLegend graphLegend = this.legend;
        if (graphLegend == GraphLegend.HRV) {
            sleepGraphInitializer.initTimeSerieHrv(sleepRecord, graph, true);
        } else if (graphLegend == GraphLegend.RESPIRATORY_RATE) {
            sleepGraphInitializer.initTimeSerieRr(sleepRecord, graph, true);
        } else {
            sleepGraphInitializer.initTimeSerie(sleepRecord, graph, graphLegend, true);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        bindSleepRecordToView(this.sleepRecord, viewHolder);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return this.legend.getTitleResource();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        SleepDetailActigraphCard.openDetail(getContext(), view, this.sleepRecord, false);
    }
}
