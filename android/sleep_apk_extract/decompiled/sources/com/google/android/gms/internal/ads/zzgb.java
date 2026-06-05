package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgb implements zzao {
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzgb(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgb)) {
            return false;
        }
        zzgb zzgbVar = (zzgb) obj;
        return this.zza == zzgbVar.zza && this.zzb == zzgbVar.zzb && this.zzc == zzgbVar.zzc;
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(this.zza) + 527;
        int iHashCode2 = Long.hashCode(this.zzb);
        return Long.hashCode(this.zzc) + ((iHashCode2 + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        long j2 = this.zzb;
        int length2 = String.valueOf(j2).length();
        long j3 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 12 + String.valueOf(j3).length());
        zzba$$ExternalSyntheticOutline0.m(sb, "Mp4Timestamp: creation time=", j, ", modification time=");
        sb.append(j2);
        return zzba$$ExternalSyntheticOutline0.m(j3, ", timescale=", sb);
    }
}
