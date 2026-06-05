package com.urbandroid.smartlight.ikea.tradfri;

import com.urbandroid.smartlight.ikea.tradfri.Client;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated", f = "Client.kt", l = {231, 233, 243, 246, 256}, m = "setState-bMdYcbs")
public final class Client$Authenticated$setState$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Client.Authenticated this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Client$Authenticated$setState$1(Client.Authenticated authenticated, Continuation<? super Client$Authenticated$setState$1> continuation) {
        super(continuation);
        this.this$0 = authenticated;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2168setStatebMdYcbs = this.this$0.m2168setStatebMdYcbs(null, null, null, null, null, false, this);
        return objM2168setStatebMdYcbs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2168setStatebMdYcbs : Result.m2356boximpl(objM2168setStatebMdYcbs);
    }
}
