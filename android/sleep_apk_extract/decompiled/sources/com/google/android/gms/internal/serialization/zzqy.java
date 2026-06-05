package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.internal.impl.StructureController$special$$inlined$map$1$2", f = "StructureController.kt", l = {50}, m = "emit")
public final class zzqy extends ContinuationImpl {
    /* synthetic */ Object zza;
    int zzb;
    final /* synthetic */ zzqz zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqy(zzqz zzqzVar, Continuation continuation) {
        super(continuation);
        this.zzc = zzqzVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzb |= Integer.MIN_VALUE;
        return this.zzc.emit(null, this);
    }
}
