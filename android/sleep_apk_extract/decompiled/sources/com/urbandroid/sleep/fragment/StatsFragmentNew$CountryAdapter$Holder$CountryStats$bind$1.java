package com.urbandroid.sleep.fragment;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoaderKt;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.MeasureRecord;
import com.urbandroid.sleep.alarmclock.CountriesActivity;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import com.urbandroid.sleep.gui.view.PieView;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.fragment.StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1", f = "StatsFragmentNew.kt", l = {486}, m = "invokeSuspend", v = 2)
public final class StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $country;
    final /* synthetic */ IMeasureRecord $record;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ StatsFragmentNew.CountryAdapter.Holder.CountryStats this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1(StatsFragmentNew.CountryAdapter.Holder.CountryStats countryStats, IMeasureRecord iMeasureRecord, String str, Continuation<? super StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1> continuation) {
        super(2, continuation);
        this.this$0 = countryStats;
        this.$record = iMeasureRecord;
        this.$country = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(StatsFragmentNew.CountryAdapter.Holder.CountryStats countryStats, View view) {
        countryStats.getContext().startActivity(new Intent(countryStats.getContext(), (Class<?>) CountriesActivity.class));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1 statsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1 = new StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1(this.this$0, this.$record, this.$country, continuation);
        statsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1.L$0 = obj;
        return statsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TextView textView;
        Object objViewsForStatRecord$default;
        TextView textView2;
        View.OnClickListener onClickListener;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextView textView3 = (TextView) this.this$0.getParentLayout().findViewById(R.id.day);
            TextView textView4 = (TextView) this.this$0.getParentLayout().findViewById(R.id.title_secondary);
            IMeasureRecord iMeasureRecord = this.$record;
            iMeasureRecord.getClass();
            int evidence = ((MeasureRecord) iMeasureRecord).getEvidence();
            textView4.setText(this.this$0.getAll() ? evidence < 50 ? "< 50" : NumberFormat.getInstance().format(Boxing.boxInt(((MeasureRecord) this.$record).getEvidence())) : this.this$0.getContext().getString(R.string.stats_caption_others));
            AlarmFragment$$ExternalSyntheticLambda0 alarmFragment$$ExternalSyntheticLambda0 = this.this$0.getAll() ? null : new AlarmFragment$$ExternalSyntheticLambda0(this.this$0, i2);
            PieView.Companion companion = PieView.INSTANCE;
            Activity activity = this.this$0.getContext();
            IMeasureRecord iMeasureRecord2 = this.$record;
            List<SleepScore.ScoreMeasure> all_measures = StatsRepoLoaderKt.getALL_MEASURES();
            int size = StatsRepoLoaderKt.getALL_MEASURES().size();
            this.L$0 = coroutineScope;
            this.L$1 = textView3;
            this.L$2 = textView4;
            this.L$3 = alarmFragment$$ExternalSyntheticLambda0;
            this.I$0 = evidence;
            this.label = 1;
            AlarmFragment$$ExternalSyntheticLambda0 alarmFragment$$ExternalSyntheticLambda02 = alarmFragment$$ExternalSyntheticLambda0;
            textView = textView4;
            objViewsForStatRecord$default = PieView.Companion.viewsForStatRecord$default(companion, R.layout.view_pie_small, activity, iMeasureRecord2, all_measures, size, -1, false, R.layout.view_pie_score_small, null, this, 256, null);
            if (objViewsForStatRecord$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            textView2 = textView3;
            onClickListener = alarmFragment$$ExternalSyntheticLambda02;
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            View.OnClickListener onClickListener2 = (View.OnClickListener) this.L$3;
            TextView textView5 = (TextView) this.L$2;
            textView2 = (TextView) this.L$1;
            ResultKt.throwOnFailure(obj);
            textView = textView5;
            onClickListener = onClickListener2;
            objViewsForStatRecord$default = obj;
        }
        ViewGroup viewGroup = (ViewGroup) this.this$0.getParentLayout().findViewById(R.id.pies);
        viewGroup.removeAllViews();
        CoroutineScopeKt.ensureActive(coroutineScope);
        for (PieView pieView : (List) objViewsForStatRecord$default) {
            viewGroup.addView(pieView);
            pieView.setOnClickListener(onClickListener);
            CoroutineScopeKt.ensureActive(coroutineScope);
        }
        textView2.setText(this.$country == null ? this.this$0.getContext().getString(R.string.stats_caption_others_world) : new Locale(Locale.getDefault().getLanguage(), this.$country).getDisplayCountry());
        textView.getClass();
        ViewExtKt.show(textView);
        this.this$0.getParentLayout().setOnClickListener(onClickListener);
        CoroutineScopeKt.ensureActive(coroutineScope);
        return Unit.INSTANCE;
    }
}
