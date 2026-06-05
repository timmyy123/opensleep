package com.urbandroid.smartlight.ikea.tradfri;

import com.urbandroid.smartlight.ikea.tradfri.Tradfri;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.smartlight.ikea.tradfri.Tradfri$Gateway$Companion", f = "Tradfri.kt", l = {44}, m = "resolve-yxL6bBk")
public final class Tradfri$Gateway$Companion$resolve$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Tradfri.Gateway.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tradfri$Gateway$Companion$resolve$1(Tradfri.Gateway.Companion companion, Continuation<? super Tradfri$Gateway$Companion$resolve$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM2169resolveyxL6bBk = this.this$0.m2169resolveyxL6bBk(null, null, null, null, this);
        return objM2169resolveyxL6bBk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM2169resolveyxL6bBk : Result.m2356boximpl(objM2169resolveyxL6bBk);
    }
}
