package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfnp {
    private final zzfnh zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfnp(final zzfmn zzfmnVar, final zzfng zzfngVar, final zzfnh zzfnhVar) {
        this.zza = zzfnhVar;
        this.zzb = zzhbw.zzh(zzhbw.zzj(zzfngVar.zza(zzfnhVar), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfno
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfngVar, zzfmnVar, zzfnhVar, (zzfmw) obj);
            }
        }, zzfnhVar.zza()), Exception.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfnm
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzd(zzfngVar, (Exception) obj);
            }
        }, zzfnhVar.zza());
    }

    public final synchronized void zza(zzhbt zzhbtVar) {
        zzfnh zzfnhVar = this.zza;
        zzhbw.zzr(zzhbw.zzj(this.zzb, zzfnn.zza, zzfnhVar.zza()), zzhbtVar, zzfnhVar.zza());
    }

    public final synchronized ListenableFuture zzb(zzfnh zzfnhVar) {
        if (!this.zzd && !this.zzc) {
            zzfnh zzfnhVar2 = this.zza;
            if (zzfnhVar2.zzb() != null && zzfnhVar.zzb() != null && zzfnhVar2.zzb().equals(zzfnhVar.zzb())) {
                this.zzc = true;
                return this.zzb;
            }
        }
        return null;
    }

    public final /* synthetic */ ListenableFuture zzc(zzfng zzfngVar, zzfmn zzfmnVar, zzfnh zzfnhVar, zzfmw zzfmwVar) {
        synchronized (this) {
            try {
                this.zzd = true;
                zzfngVar.zzb(zzfmwVar);
                if (this.zzc) {
                    return zzhbw.zza(new zzfnf(zzfmwVar, zzfnhVar));
                }
                zzfmnVar.zzb(zzfnhVar.zzb(), zzfmwVar);
                return zzhbw.zza(null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ ListenableFuture zzd(zzfng zzfngVar, Exception exc) {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }
}
