package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzfne implements zzhbt {
    final /* synthetic */ zzfnh zza;
    final /* synthetic */ zzfnj zzb;

    public zzfne(zzfnj zzfnjVar, zzfnh zzfnhVar) {
        this.zza = zzfnhVar;
        Objects.requireNonNull(zzfnjVar);
        this.zzb = zzfnjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfnj zzfnjVar = this.zzb;
        synchronized (zzfnjVar) {
            zzfnjVar.zzf(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfnj zzfnjVar = this.zzb;
        synchronized (zzfnjVar) {
            try {
                zzfnjVar.zzf(null);
                zzfnjVar.zze().addFirst(this.zza);
                if (zzfnjVar.zzg() == 1) {
                    zzfnjVar.zzd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
