package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zznk extends zzf implements zzjv {
    private final zzlh zzb;
    private final zzds zzc;

    public zznk(zzjt zzjtVar) {
        zzds zzdsVar = new zzds(zzdo.zza);
        this.zzc = zzdsVar;
        try {
            this.zzb = new zzlh(zzjtVar, this);
            zzdsVar.zza();
        } catch (Throwable th) {
            this.zzc.zza();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzA() {
        this.zzc.zzd();
        return this.zzb.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzB(float f) {
        this.zzc.zzd();
        this.zzb.zzB(f);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzC(Surface surface) {
        this.zzc.zzd();
        this.zzb.zzC(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzD(zznp zznpVar) {
        this.zzc.zzd();
        this.zzb.zzD(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzE(zznp zznpVar) {
        this.zzc.zzd();
        this.zzb.zzE(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final int zzF() {
        this.zzc.zzd();
        this.zzb.zzF();
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzG(zzxm zzxmVar) {
        this.zzc.zzd();
        this.zzb.zzG(zzxmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzH() {
        this.zzc.zzd();
        this.zzb.zzH();
    }

    public final zzjk zzI() {
        this.zzc.zzd();
        return this.zzb.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzf
    public final void zzc(int i, long j, int i2, boolean z) {
        this.zzc.zzd();
        this.zzb.zzc(i, j, 5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final Looper zzd() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zze(zzaz zzazVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzf(zzaz zzazVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzg() {
        this.zzc.zzd();
        this.zzb.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzh() {
        this.zzc.zzd();
        return this.zzb.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzi() {
        this.zzc.zzd();
        return this.zzb.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzj(boolean z) {
        this.zzc.zzd();
        this.zzb.zzj(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzk() {
        this.zzc.zzd();
        return this.zzb.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzl() {
        this.zzc.zzd();
        this.zzb.zzl();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzm() {
        this.zzc.zzd();
        this.zzb.zzm();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzav zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzo() {
        this.zzc.zzd();
        this.zzb.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbn zzp() {
        this.zzc.zzd();
        return this.zzb.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbf zzq() {
        this.zzc.zzd();
        return this.zzb.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzr() {
        this.zzc.zzd();
        return this.zzb.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzs() {
        this.zzc.zzd();
        return this.zzb.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzt() {
        this.zzc.zzd();
        return this.zzb.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzu() {
        this.zzc.zzd();
        return this.zzb.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzv() {
        this.zzc.zzd();
        return this.zzb.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzw() {
        this.zzc.zzd();
        return this.zzb.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzx() {
        this.zzc.zzd();
        return this.zzb.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzy() {
        this.zzc.zzd();
        return this.zzb.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzz() {
        this.zzc.zzd();
        return this.zzb.zzz();
    }
}
