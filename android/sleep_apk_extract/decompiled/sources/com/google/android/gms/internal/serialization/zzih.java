package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\n"}, d2 = {"R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "<anonymous>"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.google.home.automation.internal.impl.AutomationController$special$$inlined$flatMapLatest$1", f = "AutomationController.kt", l = {189}, m = "invokeSuspend")
public final class zzih extends SuspendLambda implements Function3 {
    int zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ AutomationController zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzih(Continuation continuation, AutomationController automationController) {
        super(3, continuation);
        this.zzc = automationController;
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        zzih zzihVar = new zzih((Continuation) obj3, this.zzc);
        zzihVar.zzd = (FlowCollector) obj;
        zzihVar.zzb = obj2;
        return zzihVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.zza != 0) {
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.zzd;
            InteractionClient interactionClient = (InteractionClient) this.zzb;
            Flow flowZzc = interactionClient != null ? zzuz.zzc(interactionClient, this.zzc.zzb, CollectionsKt.emptyList()) : FlowKt.emptyFlow();
            this.zza = 1;
            if (FlowKt.emitAll(flowCollector, flowZzc, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
