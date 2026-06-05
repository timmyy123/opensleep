package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzaiw implements zzaiv {
    private final long zza;
    private final String zzb;

    public zzaiw(long j, long j2, String str) {
        this.zza = j;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaiw.class == obj.getClass()) {
            zzaiw zzaiwVar = (zzaiw) obj;
            if (this.zza == zzaiwVar.zza && Objects.equals(this.zzb, zzaiwVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = Long.hashCode(-9223372036854775807L) + ((Long.hashCode(this.zza) + 527) * 31);
        return this.zzb.hashCode() + (iHashCode * 31);
    }

    public final String toString() {
        long j = this.zza;
        Object objValueOf = j == -9223372036854775807L ? "UNSET" : Long.valueOf(j);
        String str = this.zzb;
        String string = objValueOf.toString();
        int length = string.length();
        String strConcat = ", title=".concat(str);
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(strConcat.length() + length + 21), "Chapter: startTimeMs=", string, "", strConcat);
    }
}
