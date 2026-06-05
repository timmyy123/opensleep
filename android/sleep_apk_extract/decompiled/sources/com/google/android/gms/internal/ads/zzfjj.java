package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfjj implements OnAdMetadataChangedListener, zzdef, zzdcu, zzdcr, zzddh, zzdfi, zzfht, zzdky {
    private final zzfmj zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();
    private final AtomicReference zzi = new AtomicReference();
    private zzfjj zzj = null;

    public zzfjj(zzfmj zzfmjVar) {
        this.zza = zzfmjVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.onAdMetadataChanged();
        } else {
            zzfhl.zza(this.zzb, zzfji.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzd(final zzcbp zzcbpVar, final String str, final String str2) {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzd(zzcbpVar, str, str2);
            return;
        }
        zzfhl.zza(this.zzd, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfio
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                zzcbp zzcbpVar2 = zzcbpVar;
                ((zzccl) obj).zzg(new zzccz(zzcbpVar2.zzb(), zzcbpVar2.zzc()));
            }
        });
        zzfhl.zza(this.zzf, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfip
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                zzcbp zzcbpVar2 = zzcbpVar;
                ((zzccq) obj).zze(new zzccz(zzcbpVar2.zzb(), zzcbpVar2.zzc()), str, str2);
            }
        });
        zzfhl.zza(this.zze, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfiq
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzcbv) obj).zzi(zzcbpVar);
            }
        });
        zzfhl.zza(this.zzg, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfir
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzcbq) obj).zze(zzcbpVar, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzdJ(zzeVar);
            return;
        }
        final int i = zzeVar.zza;
        AtomicReference atomicReference = this.zzc;
        zzfhl.zza(atomicReference, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfiv
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzccp) obj).zzg(zzeVar);
            }
        });
        zzfhl.zza(atomicReference, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfim
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzccp) obj).zzf(i);
            }
        });
        zzfhl.zza(this.zze, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfin
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzcbv) obj).zzk(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzdK();
        } else {
            zzfhl.zza(this.zze, zzfjd.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzds();
            return;
        }
        this.zza.zzb();
        zzfhl.zza(this.zzd, zzfix.zza);
        zzfhl.zza(this.zze, zzfjc.zza);
        zzfhl.zza(this.zzi, zzfjh.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzdt();
            return;
        }
        AtomicReference atomicReference = this.zzd;
        zzfhl.zza(atomicReference, zzfiz.zza);
        zzfhl.zza(this.zze, zzfjb.zza);
        zzfhl.zza(atomicReference, zzfiw.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzdu();
        } else {
            zzfhl.zza(this.zzd, zzfiy.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zze();
        } else {
            zzfhl.zza(this.zze, zzfje.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzf();
        } else {
            zzfhl.zza(this.zze, zzfjf.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzg();
        } else {
            zzfhl.zza(this.zzc, zzfja.zza);
            zzfhl.zza(this.zze, zzfjg.zza);
        }
    }

    public final void zzh(zzccp zzccpVar) {
        this.zzc.set(zzccpVar);
    }

    public final void zzi(zzccl zzcclVar) {
        this.zzd.set(zzcclVar);
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final void zzj(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzj(zzeVar);
            return;
        }
        AtomicReference atomicReference = this.zzd;
        zzfhl.zza(atomicReference, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfis
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzccl) obj).zzi(zzeVar);
            }
        });
        zzfhl.zza(atomicReference, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfit
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzccl) obj).zzh(zzeVar.zza);
            }
        });
    }

    public final void zzk(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    public final void zzl(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzh.set(zzdqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final void zzm(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfjj zzfjjVar = this.zzj;
        if (zzfjjVar != null) {
            zzfjjVar.zzm(zztVar);
        } else {
            zzfhl.zza(this.zzh, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzfiu
                @Override // com.google.android.gms.internal.ads.zzfhk
                public final /* synthetic */ void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzdq) obj).zze(zztVar);
                }
            });
        }
    }

    @Deprecated
    public final void zzn(zzcbv zzcbvVar) {
        this.zze.set(zzcbvVar);
    }

    public final void zzo(zzfsy zzfsyVar) {
        this.zzi.set(zzfsyVar);
    }

    public final void zzp(zzccq zzccqVar) {
        this.zzf.set(zzccqVar);
    }

    @Deprecated
    public final void zzq(zzcbq zzcbqVar) {
        this.zzg.set(zzcbqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfht
    public final void zzv(zzfht zzfhtVar) {
        this.zzj = (zzfjj) zzfhtVar;
    }
}
