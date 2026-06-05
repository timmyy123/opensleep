package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventPair;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.graph.TimeAxisLabels;
import com.urbandroid.sleep.service.health.session.SleepRecordHealthSession;
import com.urbandroid.util.ColorUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001&B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\u0016\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailPhasesCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailPhasesCard$SleepRecordViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;)V", "viewHolder", "", "bindSleepRecordToView", "(Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailPhasesCard$SleepRecordViewHolder;)V", "Landroid/widget/TextView;", "textView", "", "labelRes", "", "percentage", "color", "", "start", "updatePercentage", "(Landroid/widget/TextView;IFIZ)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailPhasesCard$SleepRecordViewHolder;", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "(Landroid/view/View;)V", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailPhasesCard$SleepRecordViewHolder;)V", "getNameResource", "()I", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailPhasesCard extends DashboardCard<SleepRecordViewHolder> {
    private final SleepRecord sleepRecord;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailPhasesCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "sleepRem", "getSleepRem", "setSleepRem", "sleepDeep", "getSleepDeep", "setSleepDeep", "sleepLight", "getSleepLight", "setSleepLight", "sleepAwake", "getSleepAwake", "setSleepAwake", "Lcom/urbandroid/sleep/graph/GraphView;", "graph", "Lcom/urbandroid/sleep/graph/GraphView;", "getGraph", "()Lcom/urbandroid/sleep/graph/GraphView;", "setGraph", "(Lcom/urbandroid/sleep/graph/GraphView;)V", "Landroidx/cardview/widget/CardView;", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "setCard", "(Landroidx/cardview/widget/CardView;)V", "Landroid/widget/ImageView;", "tags", "Landroid/widget/ImageView;", "getTags", "()Landroid/widget/ImageView;", "setTags", "(Landroid/widget/ImageView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private CardView card;
        private GraphView graph;
        private TextView sleepAwake;
        private TextView sleepDeep;
        private TextView sleepLight;
        private TextView sleepRem;
        private ImageView tags;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            this.sleepRem = (TextView) view.findViewById(R.id.sleep_rem);
            this.sleepDeep = (TextView) view.findViewById(R.id.sleep_deep);
            this.sleepLight = (TextView) view.findViewById(R.id.sleep_light);
            this.sleepAwake = (TextView) view.findViewById(R.id.sleep_awake);
            View viewFindViewById2 = view.findViewById(R.id.row_graph);
            viewFindViewById2.getClass();
            this.graph = (GraphView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.foreground);
            viewFindViewById3.getClass();
            this.card = (CardView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.tags);
            viewFindViewById4.getClass();
            this.tags = (ImageView) viewFindViewById4;
        }

        public final GraphView getGraph() {
            return this.graph;
        }

        public final TextView getSleepAwake() {
            return this.sleepAwake;
        }

        public final TextView getSleepDeep() {
            return this.sleepDeep;
        }

        public final TextView getSleepLight() {
            return this.sleepLight;
        }

        public final TextView getSleepRem() {
            return this.sleepRem;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepDetailPhasesCard(Activity activity, SleepRecord sleepRecord) {
        super(activity, DashboardCard.Type.SLEEP_PHASES, R.layout.card_sleep_detail_phases);
        sleepRecord.getClass();
        this.sleepRecord = sleepRecord;
    }

    private final void bindSleepRecordToView(SleepRecord sleepRecord, SleepRecordViewHolder viewHolder) {
        viewHolder.getTitle().setText(getNameResource());
        GraphView graph = viewHolder.getGraph();
        if (sleepRecord == null || graph == null) {
            graph.setVisibility(4);
            viewHolder.getTitle().setText(R.string.no_history_records);
            return;
        }
        graph.setVisibility(0);
        graph.resetIntervals();
        SleepRecord segmentedSleepRecord = new SleepRecordHealthSession(sleepRecord, new Events$$ExternalSyntheticBUOutline0(7)).toSegmentedSleepRecord();
        float eventLabelPercentage = SleeprecordExtKt.getEventLabelPercentage(segmentedSleepRecord, new EventPair(EventLabel.DEEP_START, EventLabel.DEEP_END));
        float eventLabelPercentage2 = SleeprecordExtKt.getEventLabelPercentage(segmentedSleepRecord, new EventPair(EventLabel.REM_START, EventLabel.REM_END));
        float eventLabelPercentage3 = SleeprecordExtKt.getEventLabelPercentage(segmentedSleepRecord, new EventPair(EventLabel.LIGHT_START, EventLabel.LIGHT_END));
        updatePercentage$default(this, viewHolder.getSleepDeep(), R.string.label_deep_sleep, eventLabelPercentage, ColorUtil.i(getContext(), R.color.deep_sleep_color), false, 16, null);
        updatePercentage$default(this, viewHolder.getSleepLight(), R.string.label_light_sleep, eventLabelPercentage3, ColorUtil.i(getContext(), R.color.light_sleep), false, 16, null);
        updatePercentage$default(this, viewHolder.getSleepRem(), R.string.rem, eventLabelPercentage2, ColorUtil.i(getContext(), R.color.rem_sleep), false, 16, null);
        updatePercentage$default(this, viewHolder.getSleepAwake(), R.string.awake, 1.0f - (sleepRecord.getSleepLengthMinutes() / sleepRecord.getMeasurementLength()), ColorUtil.i(getContext(), R.color.awake_color), false, 16, null);
        SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(getContext());
        graph.setEquidistantValues(new float[0], segmentedSleepRecord.shouldUseExactFitView());
        graph.resetIntervals();
        graph.setRotateYAxisLabels(false);
        sleepGraphInitializer.initActigraph(graph, segmentedSleepRecord);
        sleepGraphInitializer.initHypnogram(graph, segmentedSleepRecord);
        sleepGraphInitializer.populatePhases(graph, segmentedSleepRecord);
        graph.setDrawXAxisBars(true);
        graph.setDrawGraph(false);
        graph.setGradientFullColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard));
        graph.setGradientTransColor(ColorUtil.i(getContext(), R.color.bg_card_dashboard_trans));
        graph.setCardColor(ColorUtil.i(getContext(), R.color.graph_time_segments));
        graph.setXAxisLabels(new TimeAxisLabels(getContext(), segmentedSleepRecord.getFrom(), segmentedSleepRecord.getTo(), segmentedSleepRecord.getTimezone(), segmentedSleepRecord.getHistory().size(), 60));
        graph.setDrawXAxis(false);
        graph.setDrawXAxisBars(true);
        graph.setForceXAxisOffset(true);
        graph.setBackgroundResource(R.drawable.card_dashboard);
        graph.setDoBlur(TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord));
        graph.setDoGradient(false);
        graph.setDrawGradientBackground(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String bindSleepRecordToView$lambda$0(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        return "";
    }

    private final void updatePercentage(TextView textView, int labelRes, float percentage, int color, boolean start) {
        StringBuilder sb;
        if (textView != null) {
            try {
                if (start) {
                    int iRoundToInt = MathKt.roundToInt(RangesKt___RangesKt.coerceAtMost(RangesKt.coerceAtLeast(percentage, 0.0f), 1.0f) * 100.0f);
                    String string = textView.getContext().getString(labelRes);
                    sb = new StringBuilder();
                    sb.append(iRoundToInt);
                    sb.append("% ");
                    sb.append(string);
                } else {
                    String string2 = textView.getContext().getString(labelRes);
                    int iRoundToInt2 = MathKt.roundToInt(RangesKt___RangesKt.coerceAtMost(RangesKt.coerceAtLeast(percentage, 0.0f), 1.0f) * 100.0f);
                    sb = new StringBuilder();
                    sb.append(string2);
                    sb.append(" ");
                    sb.append(iRoundToInt2);
                    sb.append("%");
                }
                textView.setText(sb.toString());
            } catch (Exception unused) {
            }
            textView.setTextColor(color);
        }
    }

    public static /* synthetic */ void updatePercentage$default(SleepDetailPhasesCard sleepDetailPhasesCard, TextView textView, int i, float f, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z = true;
        }
        sleepDetailPhasesCard.updatePercentage(textView, i, f, i2, z);
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
        return R.string.sleep_phases;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        SleepDetailActigraphCard.openDetail(getContext(), view, this.sleepRecord, false);
    }
}
