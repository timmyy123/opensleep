package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: loaded from: classes3.dex */
final class zzam implements OnFailureListener {
    final /* synthetic */ GoogleApi zza;
    final /* synthetic */ ListenerHolder.ListenerKey zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzao zzd;

    public zzam(zzao zzaoVar, GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, boolean z) {
        this.zza = googleApi;
        this.zzb = listenerKey;
        this.zzc = z;
        this.zzd = zzaoVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        int statusCode;
        synchronized (this.zzd) {
            try {
                if (!(exc instanceof ApiException) || ((statusCode = ((ApiException) exc).getStatusCode()) != 8001 && statusCode != 8002)) {
                    this.zzd.zzg(this.zza, this.zzb);
                } else if (this.zzc) {
                    this.zzd.zzc.remove(this.zzb);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
