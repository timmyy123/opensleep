package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.internal.impl.HomeDeviceImpl$type$$inlined$transform$1$1", f = "HomeDeviceImpl.kt", l = {44}, m = "emit")
public final class zzpd extends ContinuationImpl {
    /* synthetic */ Object zza;
    int zzb;
    final /* synthetic */ zzpe zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpd(zzpe zzpeVar, Continuation continuation) {
        super(continuation);
        this.zzc = zzpeVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzb |= Integer.MIN_VALUE;
        return this.zzc.emit(null, this);
    }
}
