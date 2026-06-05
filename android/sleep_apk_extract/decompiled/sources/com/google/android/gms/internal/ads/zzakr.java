package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzakr implements zzao {
    public final float zza;
    public final zzakq zzb;
    public final zzakq zzc;

    private zzakr(float f, zzakq zzakqVar, zzakq zzakqVar2) {
        this.zza = f;
        this.zzb = zzakqVar;
        this.zzc = zzakqVar2;
    }

    public static zzakr zzb(float f, int i, int i2) {
        zzakq zzakqVarZza = zzakq.zza(i);
        zzakq zzakqVarZza2 = zzakq.zza(i2);
        if (f <= 0.0f && zzakqVarZza == null && zzakqVarZza2 == null) {
            return null;
        }
        return new zzakr(f, zzakqVarZza, zzakqVarZza2);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzakr)) {
            return false;
        }
        zzakr zzakrVar = (zzakr) obj;
        return Float.compare(this.zza, zzakrVar.zza) == 0 && Objects.equals(this.zzb, zzakrVar.zzb) && Objects.equals(this.zzc, zzakrVar.zzc);
    }

    public final int hashCode() {
        int iHashCode = Float.hashCode(this.zza) * 31;
        zzakq zzakqVar = this.zzb;
        int iHashCode2 = (iHashCode + (zzakqVar != null ? zzakqVar.hashCode() : 0)) * 31;
        zzakq zzakqVar2 = this.zzc;
        return iHashCode2 + (zzakqVar2 != null ? zzakqVar2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String strValueOf2 = String.valueOf(this.zzc);
        float f = this.zza;
        int length = String.valueOf(f).length();
        StringBuilder sb = new StringBuilder(length + 37 + strValueOf.length() + 10 + strValueOf2.length());
        sb.append("ReplayGain Xing/Info: peak=");
        sb.append(f);
        sb.append(", field 1=");
        sb.append(strValueOf);
        return FileInsert$$ExternalSyntheticOutline0.m(sb, ", field 2=", strValueOf2);
    }
}
