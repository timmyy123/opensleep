package com.google.android.gms.internal.ads;

import android.view.Surface;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzacv implements zzaeu {
    private final zzadu zza;
    private final zzadv zzb;
    private final zzaec zzc;
    private final Queue zzd;
    private Surface zze;
    private zzv zzf;
    private long zzg;
    private zzaer zzh;
    private Executor zzi;
    private zzadr zzj;

    public zzacv(zzadu zzaduVar, zzadv zzadvVar, zzdo zzdoVar) {
        this.zza = zzaduVar;
        this.zzb = zzadvVar;
        zzaduVar.zzg(zzdoVar);
        this.zzc = new zzaec(new zzacu(this, null), zzaduVar, zzadvVar);
        this.zzd = new ArrayDeque();
        this.zzf = new zzt().zzO();
        this.zzg = -9223372036854775807L;
        this.zzh = zzaer.zzb;
        this.zzi = zzacq.zza;
        this.zzj = zzaco.zza;
    }

    public final /* synthetic */ Surface zzA() {
        return this.zze;
    }

    public final /* synthetic */ zzaer zzB() {
        return this.zzh;
    }

    public final /* synthetic */ Executor zzC() {
        return this.zzi;
    }

    public final /* synthetic */ zzadr zzD() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zza() {
        this.zzb.zzd();
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzb() {
        this.zzb.zzd();
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzc(zzaer zzaerVar, Executor executor) {
        this.zzh = zzaerVar;
        this.zzi = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzd(zzv zzvVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzf() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzg(boolean z) {
        if (z) {
            this.zza.zzl();
        }
        this.zzb.zzd();
        this.zzc.zza();
        this.zzd.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh(boolean z) {
        return this.zza.zzi(z);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzi() {
        this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzj() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final Surface zzk() {
        Surface surface = this.zze;
        surface.getClass();
        return surface;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzl(zzadr zzadrVar) {
        this.zzj = zzadrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzm(float f) {
        this.zza.zzn(f);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzn(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzo(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzp(Surface surface, zzeu zzeuVar) {
        this.zze = surface;
        this.zza.zzd(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzq() {
        this.zze = null;
        this.zza.zzd(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzr(int i) {
        this.zza.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzs(int i, zzv zzvVar, long j, int i2, List list) {
        zzgtj.zzi(list.isEmpty());
        int i3 = zzvVar.zzw;
        zzv zzvVar2 = this.zzf;
        if (i3 != zzvVar2.zzw || zzvVar.zzx != zzvVar2.zzx) {
            this.zzc.zzc(i3, zzvVar.zzx);
        }
        float f = zzvVar.zzA;
        if (f != this.zzf.zzA) {
            this.zza.zze(f);
        }
        this.zzf = zzvVar;
        if (j != this.zzg) {
            this.zzc.zzd(i2, j);
            this.zzg = j;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzt() {
        this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzu(long j, zzaes zzaesVar) {
        this.zzd.add(zzaesVar);
        this.zzc.zze(j);
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacp
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzy();
            }
        });
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzv(long j, long j2) throws zzaet {
        try {
            this.zzc.zzb(j, j2);
        } catch (zzjk e) {
            throw new zzaet(e, this.zzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzw(boolean z) {
        this.zza.zzj(z);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzx() {
    }

    public final /* synthetic */ void zzy() {
        this.zzh.zza();
    }

    public final /* synthetic */ Queue zzz() {
        return this.zzd;
    }
}
