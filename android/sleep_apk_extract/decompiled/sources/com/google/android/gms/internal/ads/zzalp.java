package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
final class zzalp implements zzahb {
    private final SparseArray zza;
    private final SparseArray zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    public /* synthetic */ zzalp(SparseArray sparseArray, SparseArray sparseArray2, long j, long j2, int i, byte[] bArr) {
        this.zza = sparseArray;
        this.zzb = sparseArray2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        SparseArray sparseArray = this.zza;
        int i = this.zze;
        long[] jArr = (long[]) sparseArray.get(i);
        SparseArray sparseArray2 = this.zzb;
        long[] jArr2 = (long[]) sparseArray2.get(i);
        if (jArr == null || jArr2 == null) {
            jArr = (long[]) sparseArray.get(i);
            jArr2 = (long[]) sparseArray2.get(i);
            if (jArr == null || jArr2 == null) {
                jArr = (long[]) sparseArray.valueAt(0);
                jArr2 = (long[]) sparseArray2.valueAt(0);
            }
        }
        if (jArr.length == 0 || j < jArr[0]) {
            zzahc zzahcVar = new zzahc(0L, this.zzd);
            return new zzagz(zzahcVar, zzahcVar);
        }
        int iZzo = zzfl.zzo(jArr, j, true, true);
        zzahc zzahcVar2 = new zzahc(jArr[iZzo], jArr2[iZzo]);
        return new zzagz(zzahcVar2, zzahcVar2);
    }
}
