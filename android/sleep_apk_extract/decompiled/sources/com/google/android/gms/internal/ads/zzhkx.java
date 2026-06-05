package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class zzhkx {
    final long[] zza;
    final long[] zzb;
    final long[] zzc;

    public zzhkx(zzhkx zzhkxVar) {
        this.zza = Arrays.copyOf(zzhkxVar.zza, 10);
        this.zzb = Arrays.copyOf(zzhkxVar.zzb, 10);
        this.zzc = Arrays.copyOf(zzhkxVar.zzc, 10);
    }

    public void zza(long[] jArr, long[] jArr2) {
        System.arraycopy(jArr2, 0, jArr, 0, 10);
    }

    public final void zzb(zzhkx zzhkxVar, int i) {
        zzhkw.zza(this.zza, zzhkxVar.zza, i);
        zzhkw.zza(this.zzb, zzhkxVar.zzb, i);
        zzhkw.zza(this.zzc, zzhkxVar.zzc, i);
    }

    public zzhkx(long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = jArr3;
    }
}
