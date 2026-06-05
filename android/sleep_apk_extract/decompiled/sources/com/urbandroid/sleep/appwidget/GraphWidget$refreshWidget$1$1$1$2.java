package com.urbandroid.sleep.appwidget;

import android.content.Context;
import android.widget.RemoteViews;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.appwidget.GraphWidget$refreshWidget$1$1$1$2", f = "GraphWidget.kt", l = {}, m = "invokeSuspend", v = 2)
public final class GraphWidget$refreshWidget$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<StatRecord> $merged;
    final /* synthetic */ SleepRecord $sleepRecord;
    final /* synthetic */ RemoteViews $viewsBig;
    final /* synthetic */ RemoteViews $viewsSmall;
    int label;
    final /* synthetic */ GraphWidget this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphWidget$refreshWidget$1$1$1$2(List<StatRecord> list, GraphWidget graphWidget, Context context, RemoteViews remoteViews, SleepRecord sleepRecord, RemoteViews remoteViews2, Continuation<? super GraphWidget$refreshWidget$1$1$1$2> continuation) {
        super(2, continuation);
        this.$merged = list;
        this.this$0 = graphWidget;
        this.$context = context;
        this.$viewsSmall = remoteViews;
        this.$sleepRecord = sleepRecord;
        this.$viewsBig = remoteViews2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphWidget$refreshWidget$1$1$1$2(this.$merged, this.this$0, this.$context, this.$viewsSmall, this.$sleepRecord, this.$viewsBig, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphWidget$refreshWidget$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        List<StatRecord> list = this.$merged;
        list.getClass();
        StatRecord statRecord = (StatRecord) CollectionsKt.firstOrNull((List) list);
        if (statRecord == null) {
            return null;
        }
        GraphWidget graphWidget = this.this$0;
        Context context = this.$context;
        RemoteViews remoteViews = this.$viewsSmall;
        SleepRecord sleepRecord = this.$sleepRecord;
        RemoteViews remoteViews2 = this.$viewsBig;
        graphWidget.updateViews(context, remoteViews, sleepRecord, statRecord);
        graphWidget.updateViews(context, remoteViews2, sleepRecord, statRecord);
        return Unit.INSTANCE;
    }
}
