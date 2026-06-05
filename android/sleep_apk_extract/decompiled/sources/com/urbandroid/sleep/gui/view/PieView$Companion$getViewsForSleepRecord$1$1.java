package com.urbandroid.sleep.gui.view;

import android.content.Context;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.gui.view.PieView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/sleep/gui/view/PieView;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.gui.view.PieView$Companion$getViewsForSleepRecord$1$1", f = "PieView.kt", l = {180}, m = "invokeSuspend", v = 2)
public final class PieView$Companion$getViewsForSleepRecord$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PieView>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ StatRecord $it;
    final /* synthetic */ int $layout;
    final /* synthetic */ int $max;
    final /* synthetic */ List<SleepScore.ScoreMeasure> $measures;
    final /* synthetic */ SleepScore $score;
    final /* synthetic */ int $scorePieLayout;
    final /* synthetic */ int $shrinkAfter;
    final /* synthetic */ boolean $themeWhite;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PieView$Companion$getViewsForSleepRecord$1$1(int i, Context context, StatRecord statRecord, List<? extends SleepScore.ScoreMeasure> list, int i2, int i3, boolean z, int i4, SleepScore sleepScore, Continuation<? super PieView$Companion$getViewsForSleepRecord$1$1> continuation) {
        super(2, continuation);
        this.$layout = i;
        this.$context = context;
        this.$it = statRecord;
        this.$measures = list;
        this.$max = i2;
        this.$shrinkAfter = i3;
        this.$themeWhite = z;
        this.$scorePieLayout = i4;
        this.$score = sleepScore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PieView$Companion$getViewsForSleepRecord$1$1(this.$layout, this.$context, this.$it, this.$measures, this.$max, this.$shrinkAfter, this.$themeWhite, this.$scorePieLayout, this.$score, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PieView>> continuation) {
        return ((PieView$Companion$getViewsForSleepRecord$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        PieView.Companion companion = PieView.INSTANCE;
        int i2 = this.$layout;
        Context context = this.$context;
        StatRecord statRecord = this.$it;
        statRecord.getClass();
        List<SleepScore.ScoreMeasure> list = this.$measures;
        int i3 = this.$max;
        int i4 = this.$shrinkAfter;
        boolean z = this.$themeWhite;
        int i5 = this.$scorePieLayout;
        SleepScore sleepScore = this.$score;
        this.label = 1;
        Object viewsForStatRecord = companion.getViewsForStatRecord(i2, context, statRecord, list, i3, i4, z, i5, sleepScore, this);
        return viewsForStatRecord == coroutine_suspended ? coroutine_suspended : viewsForStatRecord;
    }
}
