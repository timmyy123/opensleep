package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.serialization.zzcu;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzbk implements RemoteCall {
    static final /* synthetic */ zzbk zza = new zzbk();

    private /* synthetic */ zzbk() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        ((zzcu) ((PermissionsClientImpl) obj).getService()).zze(new zzbg((TaskCompletionSource) obj2));
    }
}
