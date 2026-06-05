package com.google.android.gms.home.internal;

import com.google.android.gms.internal.serialization.ReceiveHandle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalInteractionClient", f = "InternalInteractionClient.kt", l = {367, 465}, m = "registerSubscriber-1fiRZeI")
final class zzaa extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    Object zzd;
    Object zze;
    Object zzf;
    int zzg;
    /* synthetic */ Object zzh;
    final /* synthetic */ InternalInteractionClient zzi;
    int zzj;
    InternalInteractionClient zzk;
    String zzl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(InternalInteractionClient internalInteractionClient, Continuation continuation) {
        super(continuation);
        this.zzi = internalInteractionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zzh = obj;
        this.zzj |= Integer.MIN_VALUE;
        Object objZzG = this.zzi.zzG(0, null, null, null, null, null, null, null, this);
        return objZzG == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objZzG : ReceiveHandle.zzb((String) objZzG);
    }
}
