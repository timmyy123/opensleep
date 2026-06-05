package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/google/android/gms/home/internal/InternalInteractionClient$registerSubscriber$unregister$1$statusCallback$1", "Lcom/google/android/gms/common/api/internal/IStatusCallback$Stub;", "onResult", "", "result", "Lcom/google/android/gms/common/api/Status;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzac extends IStatusCallback.Stub {
    final /* synthetic */ TaskCompletionSource zza;

    public zzac(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status result) {
        result.getClass();
        if ((result.getStatusCode() == 8 && !result.hasResolution()) || (result.getStatusCode() == 49009 && Intrinsics.areEqual(result.getStatusMessage(), "Invalid session"))) {
            this.zza.setResult(Boolean.TRUE);
        }
        TaskUtil.setResultOrApiException(result, Boolean.TRUE, this.zza);
    }
}
