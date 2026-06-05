package com.google.android.gms.internal.ads;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
final class zzgbr extends SuspendLambda implements Function2 {
    /* synthetic */ Object zza;
    final /* synthetic */ zzgat zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgbr(zzgat zzgatVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzgatVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzgbr zzgbrVar = new zzgbr(this.zzb, continuation);
        zzgbrVar.zza = obj;
        return zzgbrVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzgbr) create((zzgax) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzgaz zzgazVarZza = zzgay.zza((zzgav) ((zzgax) this.zza).zzbp());
        zzihj zzihjVarZzb = zzgazVarZza.zzb();
        zzgat zzgatVar = this.zzb;
        String strZza = zzgatVar.zza();
        strZza.getClass();
        zzgazVarZza.zzc(zzihjVarZzb, strZza, zzgatVar);
        return zzgazVarZza.zza();
    }
}
