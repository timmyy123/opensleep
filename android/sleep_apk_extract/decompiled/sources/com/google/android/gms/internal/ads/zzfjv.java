package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfjv implements zzetr {
    final /* synthetic */ zzfjw zza;

    public zzfjv(zzfjw zzfjwVar) {
        Objects.requireNonNull(zzfjwVar);
        this.zza = zzfjwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzfjw zzfjwVar = this.zza;
        synchronized (zzfjwVar) {
            zzfjwVar.zzx(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfjw zzfjwVar = this.zza;
        zzdvm zzdvmVar = (zzdvm) obj;
        synchronized (zzfjwVar) {
            try {
                zzfjwVar.zzx(zzdvmVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeu)).booleanValue()) {
                    zzdvmVar.zzh().zza = zzfjwVar.zzv();
                }
                zzfjwVar.zzw().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
