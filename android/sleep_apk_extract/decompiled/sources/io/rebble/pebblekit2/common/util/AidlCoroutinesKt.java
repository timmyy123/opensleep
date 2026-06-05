package io.rebble.pebblekit2.common.util;

import android.os.Bundle;
import android.os.DeadObjectException;
import io.rebble.pebblekit2.common.SendDataCallback;
import io.rebble.pebblekit2.common.UniversalRequestResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"request", "Landroid/os/Bundle;", "Lio/rebble/pebblekit2/common/UniversalRequestResponse;", "bundle", "(Lio/rebble/pebblekit2/common/UniversalRequestResponse;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class AidlCoroutinesKt {
    public static final Object request(UniversalRequestResponse universalRequestResponse, Bundle bundle, Continuation<? super Bundle> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            universalRequestResponse.request(bundle, new SendDataCallback.Stub() { // from class: io.rebble.pebblekit2.common.util.AidlCoroutinesKt$request$2$callback$1
                @Override // io.rebble.pebblekit2.common.SendDataCallback
                public void onResult(Bundle bundle2) {
                    bundle2.getClass();
                    safeContinuation.resumeWith(Result.m2357constructorimpl(bundle2));
                }
            });
        } catch (DeadObjectException unused) {
            safeContinuation.resumeWith(Result.m2357constructorimpl(null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
