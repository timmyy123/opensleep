package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.ContextExtKt$contextScope$scope$1;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoader;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.alarmclock.StatsActivity;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0014\u0010\u0013\u001a\u00020\u00112\n\u0010\u0014\u001a\u00060\u0002R\u00020\u0000H\u0017J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/ScoreCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/ScoreCard$ScoreViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "score", "Lcom/urbandroid/sleep/addon/stats/SleepScore;", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;Lcom/urbandroid/sleep/addon/stats/SleepScore;)V", "job", "Lkotlinx/coroutines/Job;", "createViewHolder", "v", "Landroid/view/View;", "onCardClicked", "", ViewHierarchyConstants.VIEW_KEY, "bindView", "viewHolder", "isThemeCard", "", "getNameResource", "", "onCardDestroyed", "ScoreViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScoreCard extends DashboardCard<ScoreViewHolder> {
    private final CoroutineScope coroutineScope;
    private Job job;
    private SleepScore score;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/ScoreCard$ScoreViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/ScoreCard;Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class ScoreViewHolder extends LayeredViewHolder {
        final /* synthetic */ ScoreCard this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScoreViewHolder(ScoreCard scoreCard, View view) {
            super(view);
            view.getClass();
            this.this$0 = scoreCard;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.dashboard.card.ScoreCard$bindView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.fragment.dashboard.card.ScoreCard$bindView$1", f = "ScoreCard.kt", l = {45, 49}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ScoreViewHolder $viewHolder;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ScoreViewHolder scoreViewHolder, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$viewHolder = scoreViewHolder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ScoreCard.this.new AnonymousClass1(this.$viewHolder, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x008c, code lost:
        
            if (com.urbandroid.sleep.addon.stats.StatRepoBinderKt.bindScoreCard$default(r3, r4, r5, 6, null, r11, 8, null) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StatsRepoLoader statsRepoLoader = StatsRepoLoader.INSTANCE;
                Activity context = ScoreCard.this.getContext();
                context.getClass();
                StatRepo.Mode mode = StatRepo.Mode.SCORE;
                this.label = 1;
                obj = statsRepoLoader.load(context, 14, mode, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            StatRepo statRepo = (StatRepo) obj;
            CardView cardView = (CardView) this.$viewHolder.itemView.findViewById(R.id.foreground);
            Activity context2 = ScoreCard.this.getContext();
            context2.getClass();
            cardView.setCardBackgroundColor(new ContextExtKt$contextScope$scope$1(context2).getArgb(R.color.tint_background));
            if (statRepo != null) {
                Activity context3 = ScoreCard.this.getContext();
                context3.getClass();
                View view = this.$viewHolder.itemView;
                view.getClass();
                ViewGroup viewGroup = (ViewGroup) view;
                this.L$0 = SpillingKt.nullOutSpilledVariable(statRepo);
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreCard(Activity activity, CoroutineScope coroutineScope, SleepScore sleepScore) {
        super(activity, DashboardCard.Type.SCORE, R.layout.card_score);
        activity.getClass();
        coroutineScope.getClass();
        sleepScore.getClass();
        this.coroutineScope = coroutineScope;
        this.score = sleepScore;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(ScoreViewHolder viewHolder) {
        viewHolder.getClass();
        Activity context = getContext();
        context.getClass();
        SleepScore sleepScore = ContextExtKt.getSettings(context).getSleepScore();
        sleepScore.getClass();
        this.score = sleepScore;
        this.job = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(viewHolder, null), 3, null);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public ScoreViewHolder createViewHolder(View v) {
        v.getClass();
        return new ScoreViewHolder(this, v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.score;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        Intent intent = new Intent(getContext(), (Class<?>) StatsActivity.class);
        intent.putExtra("fromScoreCard", true);
        getContext().startActivity(intent);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardDestroyed() {
        Job job = this.job;
        if (job != null) {
            Job.cancel$default(job, null, 1, null);
        }
    }
}
