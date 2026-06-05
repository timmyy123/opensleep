package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfka implements zzetr {
    final /* synthetic */ zzfkc zza;

    public zzfka(zzfkc zzfkcVar) {
        Objects.requireNonNull(zzfkcVar);
        this.zza = zzfkcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        zzfkc zzfkcVar = this.zza;
        synchronized (zzfkcVar) {
            zzfkcVar.zzx(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkc zzfkcVar = this.zza;
        zzdvm zzdvmVar = (zzdvm) obj;
        synchronized (zzfkcVar) {
            try {
                zzfkcVar.zzx(zzdvmVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeu)).booleanValue()) {
                    zzdvmVar.zzh().zza = zzfkcVar.zzv();
                }
                zzfkcVar.zzw().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
