package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzbi implements RemoteCall {
    static final /* synthetic */ zzbi zza = new zzbi();

    private /* synthetic */ zzbi() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        InternalPermissionsClient.zzf((PermissionsClientImpl) obj, (TaskCompletionSource) obj2);
    }
}
