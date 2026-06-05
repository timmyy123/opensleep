package com.urbandroid.sleep.fragment;

import android.app.Activity;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoaderKt;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.domain.SleepGraphInitializer;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecords;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.gui.view.PieView;
import com.urbandroid.sleep.service.Settings;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.fragment.StatsFragmentNew$DayAdapter$Holder$bind$1", f = "StatsFragmentNew.kt", l = {363}, m = "invokeSuspend", v = 2)
public final class StatsFragmentNew$DayAdapter$Holder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StatRepo.DayMonth $day;
    final /* synthetic */ boolean $last;
    final /* synthetic */ List<SleepRecord> $records;
    final /* synthetic */ List<SleepRecord> $sriRecords;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ StatsFragmentNew.DayAdapter.Holder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StatsFragmentNew$DayAdapter$Holder$bind$1(StatRepo.DayMonth dayMonth, StatsFragmentNew.DayAdapter.Holder holder, List<? extends SleepRecord> list, List<? extends SleepRecord> list2, boolean z, Continuation<? super StatsFragmentNew$DayAdapter$Holder$bind$1> continuation) {
        super(2, continuation);
        this.$day = dayMonth;
        this.this$0 = holder;
        this.$records = list;
        this.$sriRecords = list2;
        this.$last = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(StatsFragmentNew.DayAdapter.Holder holder, List list, View view) {
        Intent startIntent$default = SleepDetailActivity.Companion.getStartIntent$default(SleepDetailActivity.INSTANCE, holder.getContext(), SleepRecords.getLongestRecord(list), false, 4, null);
        if (!new Settings(holder.getContext()).isTransitionAnimation()) {
            holder.getContext().startActivity(startIntent$default);
            return;
        }
        Pair pairCreate = Pair.create(holder.getParentLayout(), "box");
        pairCreate.getClass();
        ActivityOptionsCompat activityOptionsCompatMakeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(holder.getContext(), pairCreate);
        activityOptionsCompatMakeSceneTransitionAnimation.getClass();
        ContextCompat.startActivity(holder.getContext(), startIntent$default, activityOptionsCompatMakeSceneTransitionAnimation.toBundle());
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StatsFragmentNew$DayAdapter$Holder$bind$1 statsFragmentNew$DayAdapter$Holder$bind$1 = new StatsFragmentNew$DayAdapter$Holder$bind$1(this.$day, this.this$0, this.$records, this.$sriRecords, this.$last, continuation);
        statsFragmentNew$DayAdapter$Holder$bind$1.L$0 = obj;
        return statsFragmentNew$DayAdapter$Holder$bind$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StatsFragmentNew$DayAdapter$Holder$bind$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        AttributeSet attributeSet;
        Object objViewsForSleepRecord$default;
        View.OnClickListener onClickListener;
        TextView textView;
        LinearLayout linearLayout;
        Calendar calendar;
        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Calendar time = this.$day.getTime();
            TextView textView2 = (TextView) this.this$0.getParentLayout().findViewById(R.id.day);
            LinearLayout linearLayout2 = (LinearLayout) this.this$0.getParentLayout().findViewById(R.id.graph_layout);
            linearLayout2.removeAllViews();
            StatsFragmentNew.DayAdapter.Holder holder = this.this$0;
            AlarmFragment$$ExternalSyntheticLambda3 alarmFragment$$ExternalSyntheticLambda3 = new AlarmFragment$$ExternalSyntheticLambda3(holder, this.$records, i2);
            PieView.Companion companion = PieView.INSTANCE;
            Activity activity = holder.getContext();
            List<SleepRecord> list = this.$records;
            List<SleepRecord> list2 = this.$sriRecords;
            List<SleepScore.ScoreMeasure> all_measures = StatsRepoLoaderKt.getALL_MEASURES();
            int size = StatsRepoLoaderKt.getALL_MEASURES().size();
            this.L$0 = coroutineScope2;
            this.L$1 = time;
            this.L$2 = textView2;
            this.L$3 = linearLayout2;
            this.L$4 = alarmFragment$$ExternalSyntheticLambda3;
            this.label = 1;
            coroutineScope = coroutineScope2;
            attributeSet = null;
            objViewsForSleepRecord$default = PieView.Companion.viewsForSleepRecord$default(companion, R.layout.view_pie_small, activity, list, list2, all_measures, size, -1, false, R.layout.view_pie_score_small, null, this, 512, null);
            if (objViewsForSleepRecord$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            onClickListener = alarmFragment$$ExternalSyntheticLambda3;
            textView = textView2;
            linearLayout = linearLayout2;
            calendar = time;
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            View.OnClickListener onClickListener2 = (View.OnClickListener) this.L$4;
            linearLayout = (LinearLayout) this.L$3;
            textView = (TextView) this.L$2;
            calendar = (Calendar) this.L$1;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope2;
            attributeSet = null;
            onClickListener = onClickListener2;
            objViewsForSleepRecord$default = obj;
        }
        ViewGroup viewGroup = (ViewGroup) this.this$0.getParentLayout().findViewById(R.id.pies);
        viewGroup.removeAllViews();
        CoroutineScopeKt.ensureActive(coroutineScope);
        for (PieView pieView : (List) objViewsForSleepRecord$default) {
            viewGroup.addView(pieView);
            pieView.setOnClickListener(onClickListener);
            CoroutineScopeKt.ensureActive(coroutineScope);
        }
        for (SleepRecord sleepRecord : CollectionsKt.sortedWith(this.$records, new Comparator() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$DayAdapter$Holder$bind$1$invokeSuspend$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((SleepRecord) t).getToTime()), Long.valueOf(((SleepRecord) t2).getToTime()));
            }
        })) {
            GraphView graphView = new GraphView(this.this$0.getContext(), attributeSet);
            StatsFragmentNew.DayAdapter.Holder holder2 = this.this$0;
            graphView.resetIntervals();
            graphView.setCardColor(ContextCompat.getColor(graphView.getContext(), R.color.bg_card));
            graphView.setRotateYAxisLabels(false);
            graphView.setDoGradient(false);
            graphView.setGradientFullColor(graphView.getContext().getResources().getColor(R.color.transparent));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, holder2.getDip(36), RangesKt.coerceAtLeast(sleepRecord.getMeasurementLength(), 1.0f));
            layoutParams.setMargins(holder2.getDip(16), 0, holder2.getDip(16), 0);
            graphView.setLayoutParams(layoutParams);
            SleepGraphInitializer sleepGraphInitializer = new SleepGraphInitializer(this.this$0.getContext());
            StatsFragmentNew.DayAdapter.Holder holder3 = this.this$0;
            if (sleepRecord.hasHypnogram()) {
                sleepGraphInitializer.initHypnogram(graphView, sleepRecord);
                sleepGraphInitializer.populateHypnogramOrPhases(holder3.getContext(), graphView, sleepRecord);
                graphView.setDrawXAxisBars(true);
            } else {
                sleepGraphInitializer.initActigraph(graphView, sleepRecord);
            }
            linearLayout.addView(graphView);
            this.this$0.getParentLayout().setOnClickListener(onClickListener);
        }
        textView.setText(DateUtil.getShortDateInstanceWithoutYears(this.this$0.getContext(), calendar.getTimeZone()).format(calendar.getTime()) + " " + DateUtil.getShortDateWeekOnlyInstanceWithoutYears(this.this$0.getContext(), calendar.getTimeZone()).format(calendar.getTime()));
        this.this$0.getParentLayout().setOnClickListener(onClickListener);
        if (this.$last) {
            ViewGroup.LayoutParams layoutParams2 = this.this$0.getParentLayout().getLayoutParams();
            layoutParams2.getClass();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, ActivityUtils.getDip(this.this$0.getContext(), 120));
            ViewGroup parentLayout = this.this$0.getParentLayout();
            ViewGroup.LayoutParams layoutParams3 = parentLayout.getLayoutParams();
            if (layoutParams3 == null) {
                Types$$ExternalSyntheticBUOutline0.m$1("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                return attributeSet;
            }
            parentLayout.setLayoutParams(layoutParams3);
        }
        CoroutineScopeKt.ensureActive(coroutineScope);
        return Unit.INSTANCE;
    }
}
