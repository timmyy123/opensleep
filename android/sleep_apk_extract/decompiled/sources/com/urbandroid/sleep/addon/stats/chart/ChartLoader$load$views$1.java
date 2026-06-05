package com.urbandroid.sleep.addon.stats.chart;

import android.view.View;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$views$1", f = "ChartLoader.kt", l = {55, 59}, m = "invokeSuspend", v = 2)
public final class ChartLoader$load$views$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<View>>, Object> {
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ ChartLoader this$0;

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$views$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.addon.stats.chart.ChartLoader$load$views$1$1", f = "ChartLoader.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ int $index;
        int label;
        final /* synthetic */ ChartLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChartLoader chartLoader, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = chartLoader;
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.this$0.charts.add(this.this$0.viewCreator.invoke(this.this$0, Boxing.boxInt(this.$index))));
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChartLoader$load$views$1(ChartLoader chartLoader, Continuation<? super ChartLoader$load$views$1> continuation) {
        super(2, continuation);
        this.this$0 = chartLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChartLoader$load$views$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<View>> continuation) {
        return ((ChartLoader$load$views$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:
    
        if (r9.progressUpdate(r5, r8) != r0) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x005d -> B:7:0x0015). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        int i3;
        int i4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.this$0.viewCount;
            i2 = 0;
            if (i2 < i) {
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i4 = this.I$1;
                i3 = this.I$0;
                ResultKt.throwOnFailure(obj);
                i = i4;
                i2 = i3 + 1;
                if (i2 < i) {
                    return this.this$0.charts;
                }
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, i2, null);
                this.I$0 = i2;
                this.I$1 = i;
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) != coroutine_suspended) {
                    i3 = i2;
                    i4 = i;
                    ChartLoader chartLoader = this.this$0;
                    int i6 = chartLoader.viewCount;
                    this.I$0 = i3;
                    this.I$1 = i4;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            i4 = this.I$1;
            i3 = this.I$0;
            ResultKt.throwOnFailure(obj);
            ChartLoader chartLoader2 = this.this$0;
            int i62 = chartLoader2.viewCount;
            this.I$0 = i3;
            this.I$1 = i4;
            this.label = 2;
        }
    }
}
