package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.nest.platform.mesh.interaction.EventFlowKt$subscribeEvents$$inlined$transform$1$1", f = "EventFlow.kt", l = {40}, m = "emit")
public final class zztn extends ContinuationImpl {
    /* synthetic */ Object zza;
    int zzb;
    final /* synthetic */ zzto zzc;
    Object zzd;
    Object zze;
    OnSimpleEvent zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztn(zzto zztoVar, Continuation continuation) {
        super(continuation);
        this.zzc = zztoVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzb |= Integer.MIN_VALUE;
        return this.zzc.emit(null, this);
    }
}
