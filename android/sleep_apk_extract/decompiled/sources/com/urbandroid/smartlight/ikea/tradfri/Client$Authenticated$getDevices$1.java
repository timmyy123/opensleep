package com.urbandroid.smartlight.ikea.tradfri;

import com.urbandroid.smartlight.ikea.tradfri.Client;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated", f = "Client.kt", l = {263, 263}, m = "getDevices")
public final class Client$Authenticated$getDevices$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Client.Authenticated this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Client$Authenticated$getDevices$1(Client.Authenticated authenticated, Continuation<? super Client$Authenticated$getDevices$1> continuation) {
        super(continuation);
        this.this$0 = authenticated;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDevices(this);
    }
}
