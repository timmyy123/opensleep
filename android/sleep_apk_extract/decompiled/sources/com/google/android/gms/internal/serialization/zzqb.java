package com.google.android.gms.internal.serialization;

import com.google.home.matter.serialization.ScopedCommandId;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.home.internal.impl.MatterTraitClientImpl", f = "MatterTraitClientImpl.kt", l = {67}, m = "sendCommand")
final class zzqb extends ContinuationImpl {
    Object zza;
    long zzb;
    /* synthetic */ Object zzc;
    final /* synthetic */ zzqd zzd;
    int zze;
    zzqd zzf;
    ScopedCommandId zzg;
    Ref$ObjectRef zzh;
    Ref$ObjectRef zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqb(zzqd zzqdVar, Continuation continuation) {
        super(continuation);
        this.zzd = zzqdVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.zzc = obj;
        this.zze |= Integer.MIN_VALUE;
        return this.zzd.sendCommand(null, null, null, null, false, this);
    }
}
