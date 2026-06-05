package com.google.android.gms.home.internal;

import com.google.android.gms.internal.serialization.ReceiveHandle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalInteractionClient", f = "InternalInteractionClient.kt", l = {478}, m = "registerTraitSubscriber-t1JN82g")
final class zzad extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ InternalInteractionClient zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(InternalInteractionClient internalInteractionClient, Continuation continuation) {
        super(continuation);
        this.zzb = internalInteractionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objZzH = this.zzb.zzH(null, null, this);
        return objZzH == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objZzH : ReceiveHandle.zzb((String) objZzH);
    }
}
