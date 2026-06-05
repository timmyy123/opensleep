package com.google.android.gms.home.internal;

import android.util.Log;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.internal.serialization.zzaej;
import com.google.android.gms.internal.serialization.zzaen;
import com.google.home.HomeException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/google/protos/home/internal/interaction_api/SendCommandsResponse;", "request", "Lcom/google/protos/home/internal/interaction_api/SendCommandsRequest;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.google.android.gms.home.internal.InternalInteractionClient$sendCommands$4", f = "InternalInteractionClient.kt", l = {753, 756, 760}, m = "invokeSuspend")
final class zzal extends SuspendLambda implements Function2 {
    int zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ InternalInteractionClient zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(InternalInteractionClient internalInteractionClient, Continuation continuation) {
        super(2, continuation);
        this.zzc = internalInteractionClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        zzal zzalVar = new zzal(this.zzc, continuation);
        zzalVar.zzb = obj;
        return zzalVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((zzaej) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r6 != r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        if (r6 == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        if (r6 != r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0077, code lost:
    
        return (com.google.android.gms.internal.serialization.zzaen) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return (com.google.android.gms.internal.serialization.zzaen) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r1 != 2) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws HomeException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        zzaej zzaejVar = this.zza;
        try {
            if (zzaejVar == 0) {
                ResultKt.throwOnFailure(obj);
                zzaej zzaejVar2 = (zzaej) this.zzb;
                InternalInteractionClient internalInteractionClient = this.zzc;
                this.zzb = zzaejVar2;
                this.zza = 1;
                obj = internalInteractionClient.zzL(zzaejVar2, this);
                zzaejVar = zzaejVar2;
            } else if (zzaejVar != 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                zzaej zzaejVar3 = (zzaej) this.zzb;
                ResultKt.throwOnFailure(obj);
                zzaejVar = zzaejVar3;
            }
            return (zzaen) obj;
        } catch (UnsupportedApiCallException unused) {
            Log.w(this.zzc.zzf, "SendCommandsLarge API is not available. Falling back to Legacy path.");
            InternalInteractionClient internalInteractionClient2 = this.zzc;
            this.zzb = null;
            this.zza = 2;
            obj = internalInteractionClient2.zzK(zzaejVar, this);
        } catch (HomeException e) {
            if (e.getError().getCode() != 17) {
                throw e;
            }
            Log.w(this.zzc.zzf, "SendCommandsLarge API is disabled. Falling back to Legacy path.");
            InternalInteractionClient internalInteractionClient3 = this.zzc;
            this.zzb = null;
            this.zza = 3;
            obj = internalInteractionClient3.zzK(zzaejVar, this);
        }
    }
}
