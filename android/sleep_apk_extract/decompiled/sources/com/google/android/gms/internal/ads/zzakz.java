package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzakz {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzet zzf;
    private final zzet zzg;
    private int zzh;
    private int zzi;

    public zzakz(zzet zzetVar, zzet zzetVar2, boolean z) throws zzat {
        this.zzg = zzetVar;
        this.zzf = zzetVar2;
        this.zze = z;
        zzetVar2.zzh(12);
        this.zza = zzetVar2.zzH();
        zzetVar.zzh(12);
        this.zzi = zzetVar.zzH();
        zzagc.zza(zzetVar.zzB() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        boolean z = this.zze;
        zzet zzetVar = this.zzf;
        this.zzd = z ? zzetVar.zzJ() : zzetVar.zzz();
        if (this.zzb == this.zzh) {
            zzet zzetVar2 = this.zzg;
            this.zzc = zzetVar2.zzH();
            zzetVar2.zzk(4);
            int i2 = this.zzi - 1;
            this.zzi = i2;
            this.zzh = i2 > 0 ? (-1) + zzetVar2.zzH() : -1;
        }
        return true;
    }
}
