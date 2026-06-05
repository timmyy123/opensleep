package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzdol implements zzbpq {
    private final WeakReference zza;
    private final WeakReference zzb;

    public /* synthetic */ zzdol(zzdon zzdonVar, View view, byte[] bArr) {
        this.zza = new WeakReference(zzdonVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzot)).booleanValue()) {
            this.zzb = new WeakReference(view);
        } else {
            this.zzb = new WeakReference(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        zzdon zzdonVar = (zzdon) this.zza.get();
        if (zzdonVar == null) {
            return;
        }
        zzdonVar.zzC().zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzot)).booleanValue()) {
            zzdonVar.zzB((View) this.zzb.get());
        }
    }
}
