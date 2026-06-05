package com.urbandroid.sleep.fragment;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.ContextExtKt$contextScope$scope$1;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.addon.stats.FilterAdapter;
import com.urbandroid.sleep.addon.stats.StatRepoBinderKt;
import com.urbandroid.sleep.addon.stats.filter.IFilter;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.addon.stats.model.collector.AverageStatRecord;
import com.urbandroid.sleep.alarmclock.StatsActivity;
import com.urbandroid.sleep.alarmclock.settings.BedtimeSettingsActivity;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.fragment.StatsFragmentNew$ScoreAdapter$Holder$bind$1", f = "StatsFragmentNew.kt", l = {219}, m = "invokeSuspend", v = 2)
public final class StatsFragmentNew$ScoreAdapter$Holder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StatsFragmentNew.ScoreAdapter this$0;
    final /* synthetic */ StatsFragmentNew.ScoreAdapter.Holder this$1;
    final /* synthetic */ StatsFragmentNew this$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsFragmentNew$ScoreAdapter$Holder$bind$1(StatsFragmentNew.ScoreAdapter scoreAdapter, StatsFragmentNew.ScoreAdapter.Holder holder, StatsFragmentNew statsFragmentNew, Continuation<? super StatsFragmentNew$ScoreAdapter$Holder$bind$1> continuation) {
        super(2, continuation);
        this.this$0 = scoreAdapter;
        this.this$1 = holder;
        this.this$2 = statsFragmentNew;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4(StatsFragmentNew.ScoreAdapter scoreAdapter, View view) {
        ViewIntent.urlCustomTab(scoreAdapter.context, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$5(StatsFragmentNew.ScoreAdapter scoreAdapter, View view) {
        SimpleSettingsActivity.startHighlight(scoreAdapter.context, BedtimeSettingsActivity.class, "target_sleep_time_minutes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$6(StatsFragmentNew.ScoreAdapter scoreAdapter, View view) {
        SimpleSettingsActivity.startHighlight(scoreAdapter.context, BedtimeSettingsActivity.class, "target_sleep_time_minutes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$7$0(StatsFragmentNew statsFragmentNew, View view) {
        new MeasureOrderDialogFragment().show(statsFragmentNew.getParentFragmentManager(), "sort");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StatsFragmentNew$ScoreAdapter$Holder$bind$1(this.this$0, this.this$1, this.this$2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StatsFragmentNew$ScoreAdapter$Holder$bind$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [T, android.view.View] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StatsFragmentNew$ScoreAdapter$Holder$bind$1 statsFragmentNew$ScoreAdapter$Holder$bind$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        final int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StatRepo statRepo = this.this$0.statRepo;
            Activity activity = this.this$0.context;
            ViewGroup viewGroup = this.this$1.view;
            IFilter filter = this.this$0.filter.getFilter();
            this.label = 1;
            statsFragmentNew$ScoreAdapter$Holder$bind$1 = this;
            if (StatRepoBinderKt.bindScoreCard$default(statRepo, activity, viewGroup, 0, filter, statsFragmentNew$ScoreAdapter$Holder$bind$1, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            statsFragmentNew$ScoreAdapter$Holder$bind$1 = this;
        }
        final int i3 = 0;
        if (statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2.getActivity() != null && (statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2.getActivity() instanceof StatsActivity)) {
            ((LinearLayout) statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.filters)).setPadding(0, ActivityUtils.getDip(statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0.context, 8), 0, 0);
        }
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.period);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.tag_filter);
        if (statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2.getActivity() instanceof StatsActivity) {
            FragmentActivity activity2 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2.getActivity();
            appCompatSpinner = activity2 != null ? (AppCompatSpinner) activity2.findViewById(R.id.period_activity) : null;
            FragmentActivity activity3 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2.getActivity();
            ref$ObjectRef.element = activity3 != null ? (AppCompatSpinner) activity3.findViewById(R.id.tag_filter_activity) : 0;
            View viewFindViewById = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.filters);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
        }
        final FilterAdapter filterAdapter = new FilterAdapter(statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0.context);
        StatsFragmentNew.ScoreAdapter scoreAdapter = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0;
        filterAdapter.setTags(new ArrayList(scoreAdapter.statRepo.getAvailableTags()));
        filterAdapter.setCounts(scoreAdapter.statRepo.getAvailableTagCounts());
        final StatsFragmentNew.ScoreAdapter scoreAdapter2 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0;
        final StatsFragmentNew statsFragmentNew = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2;
        ArrayAdapter arrayAdapter = new ArrayAdapter(appCompatSpinner.getContext(), R.layout.spinner, appCompatSpinner.getContext().getResources().getTextArray(R.array.period_array));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        appCompatSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        appCompatSpinner.setSelection(scoreAdapter2.periodPosition);
        appCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$ScoreAdapter$Holder$bind$1$1$2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (scoreAdapter2.periodPosition != position) {
                    BuildersKt__Builders_commonKt.launch$default(scoreAdapter2.scope, null, null, new StatsFragmentNew$ScoreAdapter$Holder$bind$1$1$2$onItemSelected$1(statsFragmentNew, position, scoreAdapter2, filterAdapter, ref$ObjectRef.element.getSelectedItemPosition(), null), 3, null);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        T t = ref$ObjectRef.element;
        final StatsFragmentNew.ScoreAdapter scoreAdapter3 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0;
        final StatsFragmentNew statsFragmentNew2 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2;
        AppCompatSpinner appCompatSpinner2 = (AppCompatSpinner) t;
        appCompatSpinner2.setAdapter((SpinnerAdapter) filterAdapter);
        Integer numBoxInt = Boxing.boxInt(filterAdapter.resolvePosition(scoreAdapter3.filter.getItem()));
        Integer num = Boxing.boxBoolean(numBoxInt.intValue() != -1).booleanValue() ? numBoxInt : null;
        appCompatSpinner2.setSelection(num != null ? num.intValue() : 0);
        filterAdapter.setDropDownViewResource(R.layout.charts_spinner_dropdown_item);
        appCompatSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Integer numValueOf = Integer.valueOf(filterAdapter.resolvePosition(scoreAdapter3.filter.getItem()));
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                if (position != (numValueOf != null ? numValueOf.intValue() : 0)) {
                    BuildersKt__Builders_commonKt.launch$default(scoreAdapter3.scope, null, null, new StatsFragmentNew$ScoreAdapter$Holder$bind$1$2$2$onItemSelected$1(statsFragmentNew2, scoreAdapter3, filterAdapter, position, null), 3, null);
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        CardView cardView = (CardView) statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.foreground);
        if (cardView != null) {
            cardView.setCardBackgroundColor(new ContextExtKt$contextScope$scope$1(statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0.context).getArgb(R.color.tint_background));
        }
        View viewFindViewById2 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.doc);
        final StatsFragmentNew.ScoreAdapter scoreAdapter4 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0;
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$ScoreAdapter$Holder$bind$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i4 = i3;
                StatsFragmentNew.ScoreAdapter scoreAdapter5 = scoreAdapter4;
                switch (i4) {
                    case 0:
                        StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$4(scoreAdapter5, view);
                        break;
                    case 1:
                        StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$5(scoreAdapter5, view);
                        break;
                    default:
                        StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$6(scoreAdapter5, view);
                        break;
                }
            }
        });
        View viewFindViewById3 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.stats_avg);
        if (viewFindViewById3 != null) {
            final StatsFragmentNew.ScoreAdapter scoreAdapter5 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0;
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$ScoreAdapter$Holder$bind$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i4 = i2;
                    StatsFragmentNew.ScoreAdapter scoreAdapter52 = scoreAdapter5;
                    switch (i4) {
                        case 0:
                            StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$4(scoreAdapter52, view);
                            break;
                        case 1:
                            StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$5(scoreAdapter52, view);
                            break;
                        default:
                            StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$6(scoreAdapter52, view);
                            break;
                    }
                }
            });
        }
        View viewFindViewById4 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.stats_total);
        final int i4 = 2;
        if (viewFindViewById4 != null) {
            final StatsFragmentNew.ScoreAdapter scoreAdapter6 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0;
            viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$ScoreAdapter$Holder$bind$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i42 = i4;
                    StatsFragmentNew.ScoreAdapter scoreAdapter52 = scoreAdapter6;
                    switch (i42) {
                        case 0:
                            StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$4(scoreAdapter52, view);
                            break;
                        case 1:
                            StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$5(scoreAdapter52, view);
                            break;
                        default:
                            StatsFragmentNew$ScoreAdapter$Holder$bind$1.invokeSuspend$lambda$6(scoreAdapter52, view);
                            break;
                    }
                }
            });
        }
        TextView textView = (TextView) statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.sort);
        if (textView != null) {
            StatsFragmentNew statsFragmentNew3 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$2;
            ViewExtKt.show(textView);
            textView.setOnClickListener(new AlarmFragment$$ExternalSyntheticLambda0(statsFragmentNew3, i4));
        }
        int idealSleepMinutes = ContextExtKt.getSettings(statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0.context).getIdealSleepMinutes();
        List<StatRecord> mergedStatRecords = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0.statRepo.getMergedStatRecords();
        mergedStatRecords.getClass();
        StatsFragmentNew.ScoreAdapter scoreAdapter7 = statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : mergedStatRecords) {
            StatRecord statRecord = (StatRecord) obj2;
            IFilter filter2 = scoreAdapter7.filter.getFilter();
            statRecord.getClass();
            if (filter2.filter(statRecord)) {
                arrayList.add(obj2);
            }
        }
        AverageStatRecord averageStatRecord = new AverageStatRecord(statsFragmentNew$ScoreAdapter$Holder$bind$1.this$0.context, arrayList);
        TextView textView2 = (TextView) statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.view.findViewById(R.id.stats_total);
        if (textView2 != null) {
            statsFragmentNew$ScoreAdapter$Holder$bind$1.this$1.addDebtToView(textView2, (int) (((averageStatRecord.getLengthInHours() * 60.0f) - idealSleepMinutes) * arrayList.size()));
        }
        return Unit.INSTANCE;
    }
}
