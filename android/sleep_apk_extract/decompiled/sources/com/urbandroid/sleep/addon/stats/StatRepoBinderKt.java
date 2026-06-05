package com.urbandroid.sleep.addon.stats;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.login.widget.ToolTipPopup;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.ContextExtKt$contextScope$scope$1;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.filter.AcceptAllFilter;
import com.urbandroid.sleep.addon.stats.filter.IFilter;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.addon.stats.model.collector.AverageStatRecord;
import com.urbandroid.sleep.domain.achievement.Achievement;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.gui.view.PieView;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.YieldKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a8\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/model/StatRepo;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/view/ViewGroup;", "viewGroup", "", "maxScoreMeasures", "Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "filter", "", "bindScoreCard", "(Lcom/urbandroid/sleep/addon/stats/model/StatRepo;Landroid/content/Context;Landroid/view/ViewGroup;ILcom/urbandroid/sleep/addon/stats/filter/IFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbandroid/sleep/addon/stats/SleepScore;", "score", "group", "", "themeWhite", "renderScorePieToView", "(Landroid/content/Context;Lcom/urbandroid/sleep/addon/stats/SleepScore;Landroid/view/ViewGroup;Z)V", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class StatRepoBinderKt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.StatRepoBinderKt$bindScoreCard$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.StatRepoBinderKt", f = "StatRepoBinder.kt", l = {51, 55, 60}, m = "bindScoreCard", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatRepoBinderKt.bindScoreCard(null, null, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.StatRepoBinderKt$bindScoreCard$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/addon/stats/StatRepoBinderKt$bindScoreCard$3", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass3 extends Animatable2.AnimationCallback {
        final /* synthetic */ AnimatedVectorDrawable $animateVector;
        final /* synthetic */ Handler $h;

        public AnonymousClass3(Handler handler, AnimatedVectorDrawable animatedVectorDrawable) {
            this.$h = handler;
            this.$animateVector = animatedVectorDrawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationEnd$lambda$0(AnimatedVectorDrawable animatedVectorDrawable) {
            if (animatedVectorDrawable != null) {
                animatedVectorDrawable.start();
            }
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            this.$h.postDelayed(new SleepStats$8$$ExternalSyntheticLambda0(this.$animateVector, 1), ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x025d -> B:40:0x0264). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object bindScoreCard(StatRepo statRepo, Context context, ViewGroup viewGroup, int i, IFilter iFilter, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        ViewGroup viewGroup2;
        int i2;
        StatRepo statRepo2;
        int i3;
        AverageStatRecord averageStatRecord;
        SleepScore sleepScore;
        IFilter iFilter2;
        Settings settings;
        ViewGroup viewGroup3;
        List list;
        StatRepo statRepo3;
        ViewGroup viewGroup4;
        Object obj;
        Context context2;
        final Context context3;
        int i4;
        List list2;
        int i5;
        IFilter iFilter3;
        AverageStatRecord averageStatRecord2;
        SleepScore sleepScore2;
        final Settings settings2;
        Iterable iterable;
        StatRepo statRepo4;
        ViewGroup viewGroup5;
        ViewGroup viewGroup6;
        List list3;
        Iterator it;
        StatRepo statRepo5;
        List list4;
        int i6;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i7 = anonymousClass1.label;
            if ((i7 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i7 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object obj2 = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i8 = anonymousClass12.label;
        if (i8 == 0) {
            viewGroup2 = null;
            ResultKt.throwOnFailure(obj2);
            Settings settings3 = ContextExtKt.getSettings(context);
            SleepScore sleepScore3 = new SleepScore();
            ViewGroup viewGroup7 = (ViewGroup) viewGroup.findViewById(R.id.score_flow);
            List<StatRecord> mergedStatRecords = statRepo.getMergedStatRecords();
            mergedStatRecords.getClass();
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : mergedStatRecords) {
                StatRecord statRecord = (StatRecord) obj3;
                statRecord.getClass();
                if (iFilter.filter(statRecord)) {
                    arrayList.add(obj3);
                }
            }
            AverageStatRecord averageStatRecord3 = new AverageStatRecord(context, arrayList);
            PieView.Companion companion = PieView.INSTANCE;
            List<SleepScore.ScoreMeasure> all_measures = StatsRepoLoaderKt.getALL_MEASURES();
            anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(statRepo);
            anonymousClass12.L$1 = context;
            anonymousClass12.L$2 = viewGroup;
            anonymousClass12.L$3 = iFilter;
            anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(statRepo);
            anonymousClass12.L$5 = settings3;
            anonymousClass12.L$6 = sleepScore3;
            anonymousClass12.L$7 = viewGroup7;
            anonymousClass12.L$8 = SpillingKt.nullOutSpilledVariable(arrayList);
            anonymousClass12.L$9 = SpillingKt.nullOutSpilledVariable(averageStatRecord3);
            anonymousClass12.I$0 = i;
            anonymousClass12.label = 1;
            i2 = 2;
            Object viewsForStatRecord = companion.getViewsForStatRecord(R.layout.view_pie, context, averageStatRecord3, all_measures, i, -1, true, -1, sleepScore3, anonymousClass12);
            if (viewsForStatRecord != coroutine_suspended) {
                statRepo2 = statRepo;
                i3 = i;
                averageStatRecord = averageStatRecord3;
                sleepScore = sleepScore3;
                iFilter2 = iFilter;
                settings = settings3;
                viewGroup3 = viewGroup7;
                list = arrayList;
                statRepo3 = statRepo2;
                viewGroup4 = viewGroup;
                obj = viewsForStatRecord;
                context2 = context;
            }
            return coroutine_suspended;
        }
        if (i8 == 1) {
            obj = obj2;
            viewGroup2 = null;
            int i9 = anonymousClass12.I$0;
            AverageStatRecord averageStatRecord4 = (AverageStatRecord) anonymousClass12.L$9;
            List list5 = (List) anonymousClass12.L$8;
            viewGroup3 = (ViewGroup) anonymousClass12.L$7;
            sleepScore = (SleepScore) anonymousClass12.L$6;
            settings = (Settings) anonymousClass12.L$5;
            statRepo2 = (StatRepo) anonymousClass12.L$4;
            iFilter2 = (IFilter) anonymousClass12.L$3;
            viewGroup4 = (ViewGroup) anonymousClass12.L$2;
            Context context4 = (Context) anonymousClass12.L$1;
            statRepo3 = (StatRepo) anonymousClass12.L$0;
            ResultKt.throwOnFailure(obj);
            i3 = i9;
            context2 = context4;
            i2 = 2;
            list = list5;
            averageStatRecord = averageStatRecord4;
        } else if (i8 == 2) {
            viewGroup2 = null;
            i4 = anonymousClass12.I$0;
            list2 = (List) anonymousClass12.L$10;
            averageStatRecord = (AverageStatRecord) anonymousClass12.L$9;
            list = (List) anonymousClass12.L$8;
            viewGroup3 = (ViewGroup) anonymousClass12.L$7;
            sleepScore = (SleepScore) anonymousClass12.L$6;
            settings = (Settings) anonymousClass12.L$5;
            statRepo2 = (StatRepo) anonymousClass12.L$4;
            iFilter2 = (IFilter) anonymousClass12.L$3;
            viewGroup4 = (ViewGroup) anonymousClass12.L$2;
            context3 = (Context) anonymousClass12.L$1;
            statRepo3 = (StatRepo) anonymousClass12.L$0;
            ResultKt.throwOnFailure(obj2);
            viewGroup3.removeAllViews();
            List list6 = list2;
            Iterator it2 = list6.iterator();
            AverageStatRecord averageStatRecord5 = averageStatRecord;
            i5 = i4;
            iFilter3 = iFilter2;
            averageStatRecord2 = averageStatRecord5;
            sleepScore2 = sleepScore;
            settings2 = settings;
            iterable = list6;
            statRepo4 = statRepo3;
            viewGroup5 = viewGroup3;
            viewGroup6 = viewGroup4;
            list3 = list;
            it = it2;
            statRepo5 = statRepo2;
            list4 = list2;
            i6 = 0;
            if (!it.hasNext()) {
            }
        } else {
            if (i8 != 3) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i6 = anonymousClass12.I$1;
            i5 = anonymousClass12.I$0;
            it = (Iterator) anonymousClass12.L$12;
            iterable = (Iterable) anonymousClass12.L$11;
            list4 = (List) anonymousClass12.L$10;
            averageStatRecord2 = (AverageStatRecord) anonymousClass12.L$9;
            list3 = (List) anonymousClass12.L$8;
            ViewGroup viewGroup8 = (ViewGroup) anonymousClass12.L$7;
            SleepScore sleepScore4 = (SleepScore) anonymousClass12.L$6;
            settings2 = (Settings) anonymousClass12.L$5;
            viewGroup2 = null;
            StatRepo statRepo6 = (StatRepo) anonymousClass12.L$4;
            IFilter iFilter4 = (IFilter) anonymousClass12.L$3;
            viewGroup6 = (ViewGroup) anonymousClass12.L$2;
            Context context5 = (Context) anonymousClass12.L$1;
            StatRepo statRepo7 = (StatRepo) anonymousClass12.L$0;
            ResultKt.throwOnFailure(obj2);
            StatRepo statRepo8 = statRepo6;
            sleepScore2 = sleepScore4;
            viewGroup5 = viewGroup8;
            context3 = context5;
            statRepo4 = statRepo7;
            iFilter3 = iFilter4;
            statRepo5 = statRepo8;
            if (!it.hasNext()) {
                Object next = it.next();
                Iterable iterable2 = iterable;
                PieView pieView = (PieView) next;
                viewGroup5.addView(pieView);
                anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(statRepo4);
                anonymousClass12.L$1 = context3;
                anonymousClass12.L$2 = viewGroup6;
                anonymousClass12.L$3 = iFilter3;
                anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(statRepo5);
                anonymousClass12.L$5 = settings2;
                anonymousClass12.L$6 = sleepScore2;
                anonymousClass12.L$7 = viewGroup5;
                anonymousClass12.L$8 = SpillingKt.nullOutSpilledVariable(list3);
                anonymousClass12.L$9 = SpillingKt.nullOutSpilledVariable(averageStatRecord2);
                anonymousClass12.L$10 = list4;
                anonymousClass12.L$11 = SpillingKt.nullOutSpilledVariable(iterable2);
                anonymousClass12.L$12 = it;
                anonymousClass12.L$13 = SpillingKt.nullOutSpilledVariable(next);
                anonymousClass12.L$14 = SpillingKt.nullOutSpilledVariable(pieView);
                anonymousClass12.I$0 = i5;
                anonymousClass12.I$1 = i6;
                anonymousClass12.I$2 = 0;
                anonymousClass12.label = 3;
                if (YieldKt.yield(anonymousClass12) != coroutine_suspended) {
                    iterable = iterable2;
                    statRepo8 = statRepo5;
                    iFilter4 = iFilter3;
                    statRepo7 = statRepo4;
                    statRepo4 = statRepo7;
                    iFilter3 = iFilter4;
                    statRepo5 = statRepo8;
                    if (!it.hasNext()) {
                        if (list4.size() == 0) {
                            Handler handler = new Handler();
                            View viewInflate = InflatorUtil.INSTANCE.get(context3).inflate(R.layout.no_data_droid, viewGroup2, false);
                            View viewFindViewById = viewGroup6.findViewById(R.id.stats_avg);
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(8);
                            }
                            View viewFindViewById2 = viewGroup6.findViewById(R.id.stats_total);
                            if (viewFindViewById2 != null) {
                                viewFindViewById2.setVisibility(8);
                            }
                            View viewFindViewById3 = viewGroup6.findViewById(R.id.sort);
                            if (viewFindViewById3 != null) {
                                viewFindViewById3.setVisibility(8);
                            }
                            View viewFindViewById4 = viewInflate.findViewById(R.id.no_data_image);
                            viewFindViewById4.getClass();
                            Drawable drawable = ((ImageView) viewFindViewById4).getDrawable();
                            drawable.getClass();
                            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                            animatedVectorDrawable.registerAnimationCallback(new AnonymousClass3(handler, animatedVectorDrawable));
                            animatedVectorDrawable.start();
                            viewGroup5.addView(viewInflate);
                        } else {
                            View viewFindViewById5 = viewGroup6.findViewById(R.id.stats_avg);
                            if (viewFindViewById5 != null) {
                                viewFindViewById5.setVisibility(0);
                            }
                            View viewFindViewById6 = viewGroup6.findViewById(R.id.stats_total);
                            if (viewFindViewById6 != null) {
                                viewFindViewById6.setVisibility(0);
                            }
                            View viewFindViewById7 = viewGroup6.findViewById(R.id.sort);
                            if (viewFindViewById7 != null) {
                                viewFindViewById7.setVisibility(0);
                            }
                        }
                        ViewGroup viewGroup9 = (ViewGroup) viewGroup6.findViewById(R.id.score_value);
                        viewGroup9.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.addon.stats.StatRepoBinderKt$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                StatRepoBinderKt.bindScoreCard$lambda$2$0(settings2, context3, view);
                            }
                        });
                        renderScorePieToView(context3, sleepScore2, viewGroup9, true);
                        if (iFilter3 instanceof AcceptAllFilter) {
                            settings2.setSleepScore(sleepScore2.getScore(), sleepScore2.getScoreMax());
                        }
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) obj);
        anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(statRepo3);
        anonymousClass12.L$1 = context2;
        anonymousClass12.L$2 = viewGroup4;
        anonymousClass12.L$3 = iFilter2;
        anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(statRepo2);
        anonymousClass12.L$5 = settings;
        anonymousClass12.L$6 = sleepScore;
        anonymousClass12.L$7 = viewGroup3;
        anonymousClass12.L$8 = SpillingKt.nullOutSpilledVariable(list);
        anonymousClass12.L$9 = SpillingKt.nullOutSpilledVariable(averageStatRecord);
        anonymousClass12.L$10 = mutableList;
        anonymousClass12.I$0 = i3;
        anonymousClass12.label = i2;
        if (YieldKt.yield(anonymousClass12) != coroutine_suspended) {
            context3 = context2;
            i4 = i3;
            list2 = mutableList;
            viewGroup3.removeAllViews();
            List list62 = list2;
            Iterator it22 = list62.iterator();
            AverageStatRecord averageStatRecord52 = averageStatRecord;
            i5 = i4;
            iFilter3 = iFilter2;
            averageStatRecord2 = averageStatRecord52;
            sleepScore2 = sleepScore;
            settings2 = settings;
            iterable = list62;
            statRepo4 = statRepo3;
            viewGroup5 = viewGroup3;
            viewGroup6 = viewGroup4;
            list3 = list;
            it = it22;
            statRepo5 = statRepo2;
            list4 = list2;
            i6 = 0;
            if (!it.hasNext()) {
            }
        }
        return coroutine_suspended;
    }

    public static /* synthetic */ Object bindScoreCard$default(StatRepo statRepo, Context context, ViewGroup viewGroup, int i, IFilter iFilter, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 12;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            iFilter = new AcceptAllFilter();
        }
        return bindScoreCard(statRepo, context, viewGroup, i3, iFilter, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindScoreCard$lambda$2$0(Settings settings, Context context, View view) {
        settings.setChartTrendLastSelectedGraphTitle(context.getString(R.string.score));
        if (!TrialFilter.getInstance().isTrialExpired()) {
            SleepStats.startFirst(context);
        } else if (context instanceof Activity) {
            Toast.makeText(context, R.string.expire_info_freemium_first, 1).show();
        }
    }

    private static final void renderScorePieToView(Context context, SleepScore sleepScore, ViewGroup viewGroup, boolean z) {
        if (viewGroup != null) {
            new ContextExtKt$contextScope$scope$1(context);
            viewGroup.removeAllViews();
            new Settings(context).setAchievement(Achievement.Type.SCORE, MathKt.roundToInt(sleepScore.getScorePercentage() * 100.0f));
            PieView pieViewFill = new PieView(context, null, 0, 0, 14, null).fill(R.layout.view_pie_score_card, R.drawable.empty, String.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(MathKt.roundToInt(sleepScore.getScorePercentage() * 100.0f), 0), 100)), null, null, sleepScore.getScorePercentage(), z);
            pieViewFill.setColorRes(R.color.positive_light);
            viewGroup.addView(pieViewFill);
        }
    }
}
