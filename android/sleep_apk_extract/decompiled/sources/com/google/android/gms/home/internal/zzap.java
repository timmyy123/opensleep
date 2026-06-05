package com.google.android.gms.home.internal;

import com.google.home.platform.traits.ValidationIssue;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalInteractionClient", f = "InternalInteractionClient.kt", l = {200, ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER, 218}, m = "shutdown")
final class zzap extends ContinuationImpl {
    Object zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ InternalInteractionClient zzc;
    int zzd;
    InternalInteractionClient zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzap(InternalInteractionClient internalInteractionClient, Continuation continuation) {
        super(continuation);
        this.zzc = internalInteractionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        return this.zzc.zzb(this);
    }
}
