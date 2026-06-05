package com.google.android.gms.home.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalPermissionsClient", f = "InternalPermissionsClient.kt", l = {115}, m = "getConsentScreenIntentSender")
final class zzbe extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ InternalPermissionsClient zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbe(InternalPermissionsClient internalPermissionsClient, Continuation continuation) {
        super(continuation);
        this.zzb = internalPermissionsClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzc(null, this);
    }
}
