package io.rebble.pebblekit2.client;

import io.rebble.pebblekit2.client.BasePebbleListenerService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "io.rebble.pebblekit2.client.BasePebbleListenerService$Binder", f = "BasePebbleListenerService.kt", l = {69, 83}, m = "request", v = 2)
public final class BasePebbleListenerService$Binder$request$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BasePebbleListenerService.Binder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePebbleListenerService$Binder$request$1(BasePebbleListenerService.Binder binder, Continuation<? super BasePebbleListenerService$Binder$request$1> continuation) {
        super(continuation);
        this.this$0 = binder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.request(null, null, this);
    }
}
