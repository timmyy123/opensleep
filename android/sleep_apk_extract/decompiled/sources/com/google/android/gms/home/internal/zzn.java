package com.google.android.gms.home.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalInteractionClient", f = "InternalInteractionClient.kt", l = {1014, 821, 836, 838}, m = "makeSendCommandsApiCall")
final class zzn extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    /* synthetic */ Object zzd;
    final /* synthetic */ InternalInteractionClient zze;
    int zzf;
    InternalInteractionClient zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(InternalInteractionClient internalInteractionClient, Continuation continuation) {
        super(continuation);
        this.zze = internalInteractionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzd = obj;
        this.zzf |= Integer.MIN_VALUE;
        return this.zze.zzM(null, null, this);
    }
}
