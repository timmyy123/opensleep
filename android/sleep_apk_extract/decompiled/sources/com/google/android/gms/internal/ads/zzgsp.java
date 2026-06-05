package com.google.android.gms.internal.ads;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgsp {
    public static final Deferred zza(CoroutineScope coroutineScope, zzgsm zzgsmVar, Function2 function2) {
        coroutineScope.getClass();
        zzgsmVar.getClass();
        function2.getClass();
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new zzgso(zzgsmVar, function2, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object zzd(Mutex mutex, Continuation continuation) {
        Object objLock = mutex.lock(null, continuation);
        return objLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLock : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object zze(Mutex mutex, Continuation continuation) {
        if (IntrinsicsKt.wrapWithContinuationImpl(zzgsn.zza, mutex, continuation) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            IntrinsicsKt.intercepted(continuation).resumeWith(Result.m2357constructorimpl(Unit.INSTANCE));
        }
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutine_suspended : Unit.INSTANCE;
    }
}
