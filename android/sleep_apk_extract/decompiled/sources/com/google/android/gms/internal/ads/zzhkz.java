package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class zzhkz {
    final zzhla zza;
    final long[] zzb;

    public zzhkz(zzhkz zzhkzVar) {
        this.zza = new zzhla(zzhkzVar.zza);
        this.zzb = Arrays.copyOf(zzhkzVar.zzb, 10);
    }

    public zzhkz(zzhla zzhlaVar, long[] jArr) {
        this.zza = zzhlaVar;
        this.zzb = jArr;
    }
}
