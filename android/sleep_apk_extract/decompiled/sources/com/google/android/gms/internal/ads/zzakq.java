package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzakq {
    public final int zza;
    public final int zzb;
    public final float zzc;

    private zzakq(int i, int i2, float f) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
    }

    public static /* synthetic */ zzakq zza(int i) {
        int i2 = i >> 13;
        if (i2 == 0) {
            return null;
        }
        return new zzakq(i2, (i >> 10) & 7, ((i & 511) * ((i & 512) != 0 ? -1 : 1)) / 10.0f);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakq)) {
            return false;
        }
        zzakq zzakqVar = (zzakq) obj;
        return this.zza == zzakqVar.zza && this.zzb == zzakqVar.zzb && Float.compare(this.zzc, zzakqVar.zzc) == 0;
    }

    public final int hashCode() {
        int i = this.zza;
        float f = this.zzc;
        return Float.hashCode(f) + (((i * 31) + this.zzb) * 31);
    }

    public final String toString() {
        int i = this.zza;
        int length = String.valueOf(i).length();
        int i2 = this.zzb;
        int length2 = String.valueOf(i2).length();
        float f = this.zzc;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 28, length2, 7, String.valueOf(f).length()) + 1);
        Fragment$$ExternalSyntheticOutline1.m(sb, "GainField{name=", i, ", originator=", i2);
        sb.append(", gain=");
        sb.append(f);
        sb.append("}");
        return sb.toString();
    }
}
