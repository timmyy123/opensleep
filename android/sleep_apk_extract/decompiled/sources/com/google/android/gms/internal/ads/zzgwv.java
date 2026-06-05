package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgwv extends zzgwg {
    Object[] zzd;
    private int zze;

    public zzgwv(int i, boolean z) {
        super(i);
        this.zzd = new Object[zzgww.zzo(i)];
    }

    @Override // com.google.android.gms.internal.ads.zzgwh
    public final /* bridge */ /* synthetic */ zzgwh zzd(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzgwv zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzo = zzgww.zzo(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzo <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzgwf.zza(iHashCode);
                while (true) {
                    int i = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i];
                    if (obj2 == null) {
                        objArr2[i] = obj;
                        this.zze += iHashCode;
                        zza(obj);
                        return this;
                    }
                    if (obj2.equals(obj)) {
                        return this;
                    }
                    iZza = i + 1;
                }
            }
        }
        this.zzd = null;
        zza(obj);
        return this;
    }

    public final zzgwv zzg(Iterable iterable) {
        iterable.getClass();
        if (this.zzd == null) {
            zzc(iterable);
            return this;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzf(it.next());
        }
        return this;
    }

    public final zzgww zzh() {
        zzgww zzgwwVarZzw;
        int i = this.zzb;
        if (i == 0) {
            return zzgyn.zza;
        }
        if (i == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzgyx(obj);
        }
        if (this.zzd == null || zzgww.zzo(i) != this.zzd.length) {
            zzgwwVarZzw = zzgww.zzw(this.zzb, this.zza);
            this.zzb = zzgwwVarZzw.size();
        } else {
            int i2 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzgww.zzx(i2, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i2);
            }
            zzgwwVarZzw = new zzgyn(objArrCopyOf, this.zze, this.zzd, r6.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzgwwVarZzw;
    }

    public zzgwv() {
        super(4);
    }
}
