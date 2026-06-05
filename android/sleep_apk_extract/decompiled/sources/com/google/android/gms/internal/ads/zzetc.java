package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzbh;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzetc implements AppEventListener, zzdfx, zzdef, zzdcu, zzddl, com.google.android.gms.ads.internal.client.zza, zzdcr, zzdfi, zzddh, zzdky {
    final zzdzl zza;
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);
    private final AtomicReference zzk = new AtomicReference();
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkl)).intValue());

    public zzetc(zzdzl zzdzlVar) {
        this.zza = zzdzlVar;
    }

    private final void zzs() {
        if (this.zzi.get() && this.zzj.get()) {
            BlockingQueue<Pair> blockingQueue = this.zzb;
            for (final Pair pair : blockingQueue) {
                zzfhl.zza(this.zzd, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzesm
                    @Override // com.google.android.gms.internal.ads.zzfhk
                    public final /* synthetic */ void zza(Object obj) {
                        Pair pair2 = pair;
                        ((com.google.android.gms.ads.internal.client.zzcl) obj).zzb((String) pair2.first, (String) pair2.second);
                    }
                });
            }
            blockingQueue.clear();
            this.zzh.set(false);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmh)).booleanValue()) {
            return;
        }
        zzfhl.zza(this.zzc, zzesr.zza);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final synchronized void onAppEvent(final String str, final String str2) {
        if (!this.zzh.get()) {
            zzfhl.zza(this.zzd, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzesk
                @Override // com.google.android.gms.internal.ads.zzfhk
                public final /* synthetic */ void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzcl) obj).zzb(str, str2);
                }
            });
            return;
        }
        if (!this.zzb.offer(new Pair(str, str2))) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("The queue for app events is full, dropping the new event.");
            zzdzl zzdzlVar = this.zza;
            if (zzdzlVar != null) {
                zzdzk zzdzkVarZza = zzdzlVar.zza();
                zzdzkVarZza.zzc("action", "dae_action");
                zzdzkVarZza.zzc("dae_name", str);
                zzdzkVarZza.zzc("dae_data", str2);
                zzdzkVarZza.zzd();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfhk zzfhkVar = new zzfhk() { // from class: com.google.android.gms.internal.ads.zzesn
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzbh) obj).zzd(zzeVar);
            }
        };
        AtomicReference atomicReference = this.zzc;
        zzfhl.zza(atomicReference, zzfhkVar);
        zzfhl.zza(atomicReference, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzesh
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((zzbh) obj).zzc(zzeVar.zza);
            }
        });
        zzfhl.zza(this.zzf, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzesi
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzbk) obj).zzc(zzeVar);
            }
        });
        this.zzh.set(false);
        this.zzb.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
        zzfhl.zza(this.zzc, zzeso.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
        zzfhl.zza(this.zzc, zzess.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        zzfhl.zza(this.zzc, zzesu.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
        zzfhl.zza(this.zzc, zzesv.zza);
        zzfhl.zza(this.zzg, zzeta.zza);
        zzfhl.zza(this.zzk, zzetb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
        zzfhl.zza(this.zzc, zzesq.zza);
        AtomicReference atomicReference = this.zzg;
        zzfhl.zza(atomicReference, zzesx.zza);
        zzfhl.zza(atomicReference, zzesy.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmh)).booleanValue()) {
            zzfhl.zza(this.zzc, zzest.zza);
        }
        zzfhl.zza(this.zzg, zzesz.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final synchronized void zzg() {
        zzfhl.zza(this.zzc, zzesp.zza);
        zzfhl.zza(this.zzf, zzesw.zza);
        this.zzj.set(true);
        zzs();
    }

    public final synchronized zzbh zzi() {
        return (zzbh) this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzddh
    public final void zzj(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzfhl.zza(this.zzg, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzesl
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzcs) obj).zzb(zzeVar);
            }
        });
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzcl zzk() {
        return (com.google.android.gms.ads.internal.client.zzcl) this.zzd.get();
    }

    public final void zzl(zzbh zzbhVar) {
        this.zzc.set(zzbhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final void zzm(final com.google.android.gms.ads.internal.client.zzt zztVar) {
        zzfhl.zza(this.zze, new zzfhk() { // from class: com.google.android.gms.internal.ads.zzesj
            @Override // com.google.android.gms.internal.ads.zzfhk
            public final /* synthetic */ void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzdq) obj).zze(zztVar);
            }
        });
    }

    public final void zzn(zzfsy zzfsyVar) {
        this.zzk.set(zzfsyVar);
    }

    public final void zzo(com.google.android.gms.ads.internal.client.zzcl zzclVar) {
        this.zzd.set(zzclVar);
        this.zzi.set(true);
        zzs();
    }

    public final void zzp(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zze.set(zzdqVar);
    }

    public final void zzq(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        this.zzf.set(zzbkVar);
    }

    public final void zzr(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzg.set(zzcsVar);
    }
}
