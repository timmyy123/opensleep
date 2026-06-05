package com.google.android.gms.home.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalInteractionClient", f = "InternalInteractionClient.kt", l = {870, 891, 895, 1022, 913}, m = "refreshOAuthToken")
final class zzs extends ContinuationImpl {
    Object zza;
    Object zzb;
    /* synthetic */ Object zzc;
    final /* synthetic */ InternalInteractionClient zzd;
    int zze;
    InternalInteractionClient zzf;
    String zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(InternalInteractionClient internalInteractionClient, Continuation continuation) {
        super(continuation);
        this.zzd = internalInteractionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzc = obj;
        this.zze |= Integer.MIN_VALUE;
        return this.zzd.zzN(null, null, this);
    }
}
