package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.automation.internal.impl.AutomationController$special$$inlined$map$1$2", f = "AutomationController.kt", l = {51, 50}, m = "emit")
public final class zzii extends ContinuationImpl {
    /* synthetic */ Object zza;
    int zzb;
    final /* synthetic */ zzij zzc;
    Object zzd;
    Object zze;
    Object zzf;
    Object zzg;
    zzij zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzii(zzij zzijVar, Continuation continuation) {
        super(continuation);
        this.zzc = zzijVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzb |= Integer.MIN_VALUE;
        return this.zzc.emit(null, this);
    }
}
