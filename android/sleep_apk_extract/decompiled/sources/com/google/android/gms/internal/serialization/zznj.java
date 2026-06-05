package com.google.android.gms.internal.serialization;

import com.google.home.TraitFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.google.home.internal.impl.ComponentImpl$trait$$inlined$transform$1", f = "ComponentImpl.kt", l = {36}, m = "invokeSuspend")
public final class zznj extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ Flow zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ TraitFactory zzd;
    final /* synthetic */ zznq zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zznj(Flow flow, Continuation continuation, String str, TraitFactory traitFactory, zznq zznqVar) {
        super(2, continuation);
        this.zzb = flow;
        this.zzc = str;
        this.zzd = traitFactory;
        this.zze = zznqVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        zznj zznjVar = new zznj(this.zzb, continuation, this.zzc, this.zzd, this.zze);
        zznjVar.zzf = obj;
        return zznjVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zznj) create((FlowCollector) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.zza != 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.zzf;
            Flow flow = this.zzb;
            zzni zzniVar = new zzni(flowCollector, this.zzc, this.zzd, this.zze);
            this.zza = 1;
            if (flow.collect(zzniVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
