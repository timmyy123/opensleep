package com.google.android.gms.internal.serialization;

import com.google.home.HomeException;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.NonCancellable;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/google/nest/platform/mesh/interaction/SubscribeTraitsEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.nest.platform.mesh.interaction.SubscriptionFlowKt$subscribeTraitsMultiple$1$1", f = "SubscriptionFlow.kt", l = {119, 129, 131}, m = "invokeSuspend")
final class zzuw extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ InteractionClient zzc;
    final /* synthetic */ SubscriptionParams zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzuw(InteractionClient interactionClient, SubscriptionParams subscriptionParams, Continuation continuation) {
        super(2, continuation);
        this.zzc = interactionClient;
        this.zzd = subscriptionParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        zzuw zzuwVar = new zzuw(this.zzc, this.zzd, continuation);
        zzuwVar.zze = obj;
        return zzuwVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzuw) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v13, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref$ObjectRef ref$ObjectRef;
        HomeException e;
        Object zza;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzb;
        Ref$ObjectRef ref$ObjectRef4 = 1;
        try {
        } catch (Throwable th) {
            NonCancellable nonCancellable = NonCancellable.INSTANCE;
            zzuu zzuuVar = new zzuu(ref$ObjectRef4, this.zzc, null);
            this.zze = th;
            this.zza = null;
            this.zzb = 3;
            if (BuildersKt.withContext(nonCancellable, zzuuVar, this) != coroutine_suspended) {
                throw th;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zzuv zzuvVar = new zzuv((ProducerScope) this.zze);
            Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
            try {
                InteractionClient interactionClient = this.zzc;
                FilterQuery objectFilter = this.zzd.getObjectFilter();
                List traitFilter = this.zzd.getTraitFilter();
                this.zze = ref$ObjectRef5;
                this.zza = ref$ObjectRef5;
                this.zzb = 1;
                Object objZzf = interactionClient.zzf(zzuvVar, objectFilter, traitFilter, this);
                if (objZzf != coroutine_suspended) {
                    Ref$ObjectRef ref$ObjectRef6 = ref$ObjectRef5;
                    zza = objZzf;
                    ref$ObjectRef2 = ref$ObjectRef6;
                    ref$ObjectRef = ref$ObjectRef6;
                }
            } catch (HomeException e2) {
                ref$ObjectRef = ref$ObjectRef5;
                e = e2;
                if (e.getError().getCode() == 17) {
                    throw e;
                }
                zzuz.zza().zzd().zza("Failed to register trait subscriber. Exception: %s", e.getMessage());
                ref$ObjectRef3 = ref$ObjectRef;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            Object obj2 = this.zze;
            if (i != 2) {
                Throwable th2 = (Throwable) obj2;
                ResultKt.throwOnFailure(obj);
                throw th2;
            }
            Ref$ObjectRef ref$ObjectRef7 = (Ref$ObjectRef) obj2;
            ResultKt.throwOnFailure(obj);
            ref$ObjectRef4 = ref$ObjectRef7;
            throw new KotlinNothingValueException();
        }
        Ref$ObjectRef ref$ObjectRef8 = (Ref$ObjectRef) this.zza;
        ref$ObjectRef = (Ref$ObjectRef) this.zze;
        try {
            ResultKt.throwOnFailure(obj);
            zza = ((ReceiveHandle) obj).getZza();
            ref$ObjectRef2 = ref$ObjectRef8;
            ref$ObjectRef = ref$ObjectRef;
        } catch (HomeException e3) {
            e = e3;
            if (e.getError().getCode() == 17) {
            }
        }
        ref$ObjectRef2.element = (String) zza;
        ref$ObjectRef3 = ref$ObjectRef;
        this.zze = ref$ObjectRef3;
        this.zza = null;
        this.zzb = 2;
        ref$ObjectRef4 = ref$ObjectRef3;
        if (DelayKt.awaitCancellation(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        throw new KotlinNothingValueException();
    }
}
