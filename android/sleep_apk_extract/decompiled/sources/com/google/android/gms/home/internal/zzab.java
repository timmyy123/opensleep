package com.google.android.gms.home.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/google/android/gms/home/internal/InternalInteractionClient$registerSubscriber$register$1$resultCallback$1", "Lcom/google/android/gms/home/interaction/internal/IRegisterSubscriberCallback$Stub;", "onRegistered", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/google/android/gms/common/api/Status;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzab extends com.google.android.gms.internal.serialization.zzbf {
    final /* synthetic */ ConcurrentHashMap zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ TaskCompletionSource zzc;

    public zzab(ConcurrentHashMap concurrentHashMap, String str, TaskCompletionSource taskCompletionSource) {
        this.zza = concurrentHashMap;
        this.zzb = str;
        this.zzc = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.serialization.zzbg
    public final void zze(Status status) {
        status.getClass();
        if (!Intrinsics.areEqual(status, Status.RESULT_SUCCESS)) {
            this.zza.remove(this.zzb);
        }
        TaskUtil.trySetResultOrApiException(status, null, this.zzc);
    }
}
