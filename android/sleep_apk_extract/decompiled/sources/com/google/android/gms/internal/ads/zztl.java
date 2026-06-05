package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zztl {
    private final zzv zza;
    private final zzv zzb;
    private final int zzc;
    private final int zzd;
    private final zzre zze;
    private final zzck zzf;

    private zztl(zzv zzvVar, zzv zzvVar2, int i, int i2, zzre zzreVar, zzck zzckVar) {
        this.zza = zzvVar;
        this.zzb = zzvVar2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = zzreVar;
        this.zzf = zzckVar;
    }

    public final /* synthetic */ zztl zza(zzre zzreVar) {
        return new zztl(this.zza, this.zzb, this.zzc, this.zzd, zzreVar, this.zzf);
    }

    public final /* synthetic */ long zzb(long j) {
        return zzfl.zzt(j, this.zza.zzI);
    }

    public final /* synthetic */ long zzc(long j) {
        return zzfl.zzt(j, this.zze.zzb);
    }

    public final /* synthetic */ zzry zzd() {
        zzre zzreVar = this.zze;
        return new zzry(zzreVar.zza, zzreVar.zzb, zzreVar.zzc, false, false, zzreVar.zze);
    }

    public final /* synthetic */ boolean zze() {
        return Objects.equals(this.zza.zzp, "audio/raw");
    }

    public final /* synthetic */ zzv zzf() {
        return this.zza;
    }

    public final /* synthetic */ zzv zzg() {
        return this.zzb;
    }

    public final /* synthetic */ int zzh() {
        return this.zzc;
    }

    public final /* synthetic */ int zzi() {
        return this.zzd;
    }

    public final /* synthetic */ zzre zzj() {
        return this.zze;
    }

    public final /* synthetic */ zzck zzk() {
        return this.zzf;
    }

    public /* synthetic */ zztl(zzv zzvVar, zzv zzvVar2, int i, int i2, zzre zzreVar, zzck zzckVar, byte[] bArr) {
        this(zzvVar, zzvVar2, i, i2, zzreVar, zzckVar);
    }
}
