package com.google.android.gms.home.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/google/android/gms/home/internal/InternalInteractionClient$readObjects$2$callback$1", "Lcom/google/android/gms/home/interaction/internal/IReadObjectsCallback$Stub;", "onComplete", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/google/android/gms/common/api/Status;", "result", "Lcom/google/android/gms/home/interaction/ReadObjectsResult;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzq extends com.google.android.gms.internal.serialization.zzbc {
    final /* synthetic */ TaskCompletionSource zza;

    public zzq(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.serialization.zzbd
    public final void zze(Status status, com.google.android.gms.internal.serialization.zzp zzpVar) {
        status.getClass();
        TaskUtil.setResultOrApiException(status, zzpVar != null ? zzpVar.zza() : null, this.zza);
    }
}
