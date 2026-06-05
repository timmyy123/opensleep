package com.urbandroid.sleep.gui;

import com.urbandroid.sleep.service.SharedApplicationContext;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.gui.GraphListClickHandler$showItemOptionsDialog$1$dialog$1$1$1", f = "GraphListClickHandler.kt", l = {}, m = "invokeSuspend", v = 2)
public final class GraphListClickHandler$showItemOptionsDialog$1$dialog$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ String $to;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphListClickHandler$showItemOptionsDialog$1$dialog$1$1$1(String str, String str2, Continuation<? super GraphListClickHandler$showItemOptionsDialog$1$dialog$1$1$1> continuation) {
        super(2, continuation);
        this.$from = str;
        this.$to = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphListClickHandler$showItemOptionsDialog$1$dialog$1$1$1(this.$from, this.$to, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphListClickHandler$showItemOptionsDialog$1$dialog$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(obj);
        SharedApplicationContext.getInstance().getSleepRecordRepository().renameTags(this.$from, this.$to);
        return Unit.INSTANCE;
    }
}
