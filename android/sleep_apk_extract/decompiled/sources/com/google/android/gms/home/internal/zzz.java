package com.google.android.gms.home.internal;

import com.google.android.gms.internal.serialization.ReceiveHandle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalInteractionClient", f = "InternalInteractionClient.kt", l = {638}, m = "registerEventSubscriber-OCNOtTU")
final class zzz extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ InternalInteractionClient zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(InternalInteractionClient internalInteractionClient, Continuation continuation) {
        super(continuation);
        this.zzb = internalInteractionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objZzA = this.zzb.zzA(null, null, null, this);
        return objZzA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objZzA : ReceiveHandle.zzb((String) objZzA);
    }
}
