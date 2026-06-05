package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfge implements zzdcu, zzdeq, zzfht, com.google.android.gms.ads.internal.overlay.zzr, zzdfi, zzddh, zzdky {
    private final zzfmj zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();
    private zzfge zzi = null;

    public zzfge(zzfmj zzfmjVar) {
        this.zza = zzfmjVar;
    }

    public static zzfge zzn(zzfge zzfgeVar) {
        zzfge zzfgeVar2 = new zzfge(zzfgeVar.zza);
        zzfgeVar2.zzi = zzfgeVar;
        return zzfgeVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzdJ(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.zzb;
        zzfhl.zza(atomicReference, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfft
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzbgm) obj).zzd(zzeVar);
            }
        });
        zzfhl.zza(atomicReference, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzffu
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzbgm) obj).zzc(zzeVar.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdT() {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzdT();
        } else {
            zzfhl.zza(this.zzf, zzffp.zza);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdU(final int i) {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzdU(i);
        } else {
            zzfhl.zza(this.zzf, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzffv
                @Override // com.google.android.gms.internal.ads.zzfhk
                public final /* synthetic */ void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzr) obj).zzdU(i);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdq() {
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzdu();
        } else {
            zzfhl.zza(this.zzd, zzfgb.zza);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzdv();
        } else {
            zzfhl.zza(this.zzf, zzffq.zza);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdx() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdy() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdz() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzh();
            return;
        }
        zzfhl.zza(this.zzf, zzffr.zza);
        AtomicReference atomicReference = this.zzd;
        zzfhl.zza(atomicReference, zzffz.zza);
        zzfhl.zza(atomicReference, zzfga.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final void zzj(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzj(zzeVar);
        } else {
            zzfhl.zza(this.zzd, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzffw
                @Override // com.google.android.gms.internal.ads.zzfhk
                public final /* synthetic */ void zza(Object obj) {
                    ((zzbgq) obj).zze(zzeVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdeq
    public final void zzl() {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzl();
        } else {
            zzfhl.zza(this.zze, zzffo.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final void zzm(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzm(zztVar);
        } else {
            zzfhl.zza(this.zzg, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzffx
                @Override // com.google.android.gms.internal.ads.zzfhk
                public final /* synthetic */ void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzdq) obj).zze(zztVar);
                }
            });
        }
    }

    public final void zzo(zzbgm zzbgmVar) {
        this.zzb.set(zzbgmVar);
    }

    public final void zzp(zzbgq zzbgqVar) {
        this.zzd.set(zzbgqVar);
    }

    public final void zzq(com.google.android.gms.ads.internal.overlay.zzr zzrVar) {
        this.zzf.set(zzrVar);
    }

    public final void zzr(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzg.set(zzdqVar);
    }

    public final void zzs(zzfsy zzfsyVar) {
        this.zzh.set(zzfsyVar);
    }

    public final void zzt(final zzbgj zzbgjVar) {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzt(zzbgjVar);
        } else {
            zzfhl.zza(this.zzb, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzffs
                @Override // com.google.android.gms.internal.ads.zzfhk
                public final /* synthetic */ void zza(Object obj) {
                    ((zzbgm) obj).zzb(zzbgjVar);
                }
            });
        }
    }

    public final void zzu() {
        zzfge zzfgeVar = this.zzi;
        if (zzfgeVar != null) {
            zzfgeVar.zzu();
            return;
        }
        this.zza.zzb();
        zzfhl.zza(this.zzc, zzffy.zza);
        zzfhl.zza(this.zzd, zzfgc.zza);
        zzfhl.zza(this.zzh, zzfgd.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfht
    public final void zzv(zzfht zzfhtVar) {
        this.zzi = (zzfge) zzfhtVar;
    }
}
