package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzh {
    private int zza;
    private int zzb;
    private int zzc;
    private byte[] zzd;
    private int zze;
    private int zzf;

    public /* synthetic */ zzh(zzi zziVar, byte[] bArr) {
        this.zza = zziVar.zzb;
        this.zzb = zziVar.zzc;
        this.zzc = zziVar.zzd;
        this.zzd = zziVar.zze;
        this.zze = zziVar.zzf;
        this.zzf = zziVar.zzg;
    }

    public final zzh zza(int i) {
        this.zza = i;
        return this;
    }

    public final zzh zzb(int i) {
        this.zzb = i;
        return this;
    }

    public final zzh zzc(int i) {
        this.zzc = i;
        return this;
    }

    public final zzh zzd(byte[] bArr) {
        this.zzd = bArr;
        return this;
    }

    public final zzh zze(int i) {
        this.zze = i;
        return this;
    }

    public final zzh zzf(int i) {
        this.zzf = i;
        return this;
    }

    public final zzi zzg() {
        return new zzi(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, null);
    }

    public zzh() {
        this.zza = -1;
        this.zzb = -1;
        this.zzc = -1;
        this.zze = -1;
        this.zzf = -1;
    }
}
