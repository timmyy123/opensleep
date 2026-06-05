package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "e", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.nest.platform.mesh.interaction.SubscriptionFlowKt$subscribeTraitsMultiple$3", f = "SubscriptionFlow.kt", l = {}, m = "invokeSuspend")
final class zzuy extends SuspendLambda implements Function2 {
    /* synthetic */ Object zza;

    public zzuy(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        zzuy zzuyVar = new zzuy(continuation);
        zzuyVar.zza = obj;
        return zzuyVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzuy) create((Throwable) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        Throwable th = (Throwable) this.zza;
        Boolean boolBoxBoolean = Boxing.boxBoolean(th instanceof SubscriptionException);
        if (boolBoxBoolean.booleanValue()) {
            zzuz.zza().zza().zza("Restarting subscription due to subscription state change: %s", th.getMessage());
            return boolBoxBoolean;
        }
        zzuz.zza().zzd().zza("Unexpected exception during subscription, not retrying: %s", th.getMessage());
        return boolBoxBoolean;
    }
}
