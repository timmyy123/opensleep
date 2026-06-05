package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzamm implements zzahf {
    public final int zza;
    public final zzhaf zzb;

    public zzamm(int i, int[] iArr) {
        this.zza = i;
        this.zzb = iArr != null ? zzhaf.zzf(iArr) : zzhaf.zza();
    }

    public final String toString() {
        zzhaf zzhafVar = this.zzb;
        ArrayList arrayList = new ArrayList(zzhafVar.zzh());
        for (int i = 0; i < zzhafVar.zzh(); i++) {
            arrayList.add(zzfl.zzz(zzhafVar.zzi(i)));
        }
        String strZzz = zzfl.zzz(this.zza);
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(strZzz.length() + 37, 1, string));
        sb.append("UnsupportedBrands{major=");
        sb.append(strZzz);
        sb.append(", compatible=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
