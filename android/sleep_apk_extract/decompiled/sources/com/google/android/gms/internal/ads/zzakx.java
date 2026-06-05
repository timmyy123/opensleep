package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzakx implements zzahf {
    public final int zza;
    public final long zzb;
    public final int zzc;

    public zzakx(int i, long j, int i2) {
        this.zza = i;
        this.zzb = j;
        this.zzc = i2;
    }

    public final String toString() {
        String strZzz = zzfl.zzz(this.zza);
        int length = strZzz.length();
        long j = this.zzb;
        int length2 = String.valueOf(j).length();
        int i = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 29, length2, 16, String.valueOf(i).length()) + 1);
        Fragment$$ExternalSyntheticOutline1.m67m(sb, "AtomSizeTooSmall{type=", strZzz, ", size=");
        sb.append(j);
        sb.append(", minHeaderSize=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }
}
