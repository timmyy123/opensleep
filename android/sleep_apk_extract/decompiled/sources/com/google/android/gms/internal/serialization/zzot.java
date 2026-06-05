package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.internal.impl.GhpCoreMetadataController$special$$inlined$mapNotNull$1$2", f = "GhpCoreMetadataController.kt", l = {52}, m = "emit")
public final class zzot extends ContinuationImpl {
    /* synthetic */ Object zza;
    int zzb;
    final /* synthetic */ zzou zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzot(zzou zzouVar, Continuation continuation) {
        super(continuation);
        this.zzc = zzouVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzb |= Integer.MIN_VALUE;
        return this.zzc.emit(null, this);
    }
}
