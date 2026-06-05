package com.urbandroid.smartlight.ikea.tradfri;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated$DeviceTransition$start$1", f = "Client.kt", l = {117, 118, 120, 121, 124, 125, 129}, m = "invokeSuspend$applyState")
public final class Client$Authenticated$DeviceTransition$start$1$applyState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public Client$Authenticated$DeviceTransition$start$1$applyState$1(Continuation<? super Client$Authenticated$DeviceTransition$start$1$applyState$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Client$Authenticated$DeviceTransition$start$1.invokeSuspend$applyState(false, null, null, null, null, this);
    }
}
