package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.nest.platform.mesh.interaction.EventFlowKt$subscribeEvents$1$1", f = "EventFlow.kt", l = {69}, m = "invokeSuspend")
final class zztq extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ Ref$ObjectRef zzb;
    final /* synthetic */ InteractionClient zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztq(Ref$ObjectRef ref$ObjectRef, InteractionClient interactionClient, Continuation continuation) {
        super(2, continuation);
        this.zzb = ref$ObjectRef;
        this.zzc = interactionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new zztq(this.zzb, this.zzc, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zztq) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            if (this.zza != 0) {
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.zzb.element;
                if (str == null) {
                    return null;
                }
                InteractionClient interactionClient = this.zzc;
                this.zza = 1;
                obj = interactionClient.zzh(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(((Boolean) obj).booleanValue());
        } catch (Exception e) {
            zztt.zza().zzd().zza("Failed to unregister event subscriber. Exception: %s", e.getMessage());
            return Unit.INSTANCE;
        }
    }
}
