package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhdz {
    private static final zzhdx zza = zzhdy.zza;
    private final zzhdq zzb;
    private final zzhds zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzhdx zzg;
    private final int zzh;

    public /* synthetic */ zzhdz(zzhdq zzhdqVar, int i, int i2, boolean z, boolean z2, zzhdx zzhdxVar, byte[] bArr) {
        this.zzb = zzhdqVar;
        this.zzh = i;
        int i3 = i - 2;
        this.zzc = i3 != 1 ? i3 != 3 ? zzhds.zzb : zzhds.zzc : zzhds.zza;
        this.zzd = i2;
        this.zze = z;
        this.zzf = z2;
        this.zzg = zzhdxVar;
    }

    public final zzhdq zza() {
        this.zzg.zza(this);
        return this.zzb;
    }

    public final zzhds zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    public final /* synthetic */ int zzj() {
        return this.zzh;
    }
}
