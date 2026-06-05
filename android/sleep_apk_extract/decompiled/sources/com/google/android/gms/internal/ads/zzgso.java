package com.google.android.gms.internal.ads;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes5.dex */
final class zzgso extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzgsm zzc;
    final /* synthetic */ Function2 zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgso(zzgsm zzgsmVar, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzgsmVar;
        this.zzd = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzgso zzgsoVar = new zzgso(this.zzc, this.zzd, continuation);
        zzgsoVar.zze = obj;
        return zzgsoVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzgso) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Function2 function2;
        Mutex mutexZza;
        Throwable th;
        Mutex mutex;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzb;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScopeKt.ensureActive((CoroutineScope) this.zze);
                zzgsm zzgsmVar = this.zzc;
                function2 = this.zzd;
                mutexZza = zzgsmVar.zza();
                this.zze = mutexZza;
                this.zza = function2;
                this.zzb = 1;
                if (zzgsp.zze(mutexZza, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                mutex = (Mutex) this.zze;
                try {
                    ResultKt.throwOnFailure(obj);
                    Mutex.unlock$default(mutex, null, 1, null);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    Mutex.unlock$default(mutex, null, 1, null);
                    throw th;
                }
            }
            function2 = (Function2) this.zza;
            Mutex mutex2 = (Mutex) this.zze;
            ResultKt.throwOnFailure(obj);
            mutexZza = mutex2;
            this.zze = mutexZza;
            this.zza = null;
            this.zzb = 2;
            Object objCoroutineScope = CoroutineScopeKt.coroutineScope(function2, this);
            if (objCoroutineScope != coroutine_suspended) {
                Mutex mutex3 = mutexZza;
                obj = objCoroutineScope;
                mutex = mutex3;
                Mutex.unlock$default(mutex, null, 1, null);
                return obj;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutexZza;
            th = th3;
            mutex = mutex4;
            Mutex.unlock$default(mutex, null, 1, null);
            throw th;
        }
    }
}
