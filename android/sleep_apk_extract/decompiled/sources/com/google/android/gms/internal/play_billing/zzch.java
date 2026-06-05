package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzch extends zzci {
    Object[] zza;
    int zzb;
    boolean zzc;

    public zzch(int i) {
        zzbw.zza(i, "initialCapacity");
        this.zza = new Object[i];
        this.zzb = 0;
    }

    private final void zzd(int i) {
        int length = this.zza.length;
        int iZzc = zzci.zzc(length, this.zzb + i);
        if (iZzc > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, iZzc);
            this.zzc = false;
        }
    }

    public final zzch zza(Object obj) {
        obj.getClass();
        zzd(1);
        Object[] objArr = this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
        return this;
    }

    public final void zzb(Object[] objArr, int i) {
        zzdd.zzb(objArr, i);
        zzd(i);
        System.arraycopy(objArr, 0, this.zza, this.zzb, i);
        this.zzb += i;
    }
}
