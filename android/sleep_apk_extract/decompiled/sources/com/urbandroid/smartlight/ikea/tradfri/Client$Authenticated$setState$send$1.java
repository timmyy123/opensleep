package com.urbandroid.smartlight.ikea.tradfri;

import com.urbandroid.smartlight.ikea.tradfri.Client;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Client$Authenticated", f = "Client.kt", l = {198}, m = "setState_bMdYcbs$send")
public final class Client$Authenticated$setState$send$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public Client$Authenticated$setState$send$1(Continuation<? super Client$Authenticated$setState$send$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Client.Authenticated.setState_bMdYcbs$send(null, null, null, this);
    }
}
