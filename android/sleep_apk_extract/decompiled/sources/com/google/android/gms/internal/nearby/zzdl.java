package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: loaded from: classes3.dex */
final class zzdl implements OnFailureListener {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdq zzb;

    public zzdl(zzdq zzdqVar, String str) {
        this.zza = str;
        this.zzb = zzdqVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        if ((exc instanceof ApiException) && ((ApiException) exc).getStatusCode() == 8003) {
            return;
        }
        this.zzb.zzk(this.zza);
    }
}
