package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
public final class zzno {
    private final zzs zza;
    private final SparseArray zzb;

    public zzno(zzs zzsVar, SparseArray sparseArray) {
        this.zza = zzsVar;
        SparseArray sparseArray2 = new SparseArray(zzsVar.zzb());
        for (int i = 0; i < zzsVar.zzb(); i++) {
            int iZzc = zzsVar.zzc(i);
            zznn zznnVar = (zznn) sparseArray.get(iZzc);
            zznnVar.getClass();
            sparseArray2.append(iZzc, zznnVar);
        }
        this.zzb = sparseArray2;
    }

    public final zznn zza(int i) {
        zznn zznnVar = (zznn) this.zzb.get(i);
        zznnVar.getClass();
        return zznnVar;
    }

    public final boolean zzb(int i) {
        return this.zza.zza(i);
    }

    public final int zzc() {
        return this.zza.zzb();
    }

    public final int zzd(int i) {
        return this.zza.zzc(i);
    }
}
