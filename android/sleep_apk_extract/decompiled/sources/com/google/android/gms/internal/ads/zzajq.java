package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzajq extends zzajo {
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzajq(String str, String str2, String str3) {
        super("----");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajq.class == obj.getClass()) {
            zzajq zzajqVar = (zzajq) obj;
            if (Objects.equals(this.zzb, zzajqVar.zzb) && Objects.equals(this.zza, zzajqVar.zza) && Objects.equals(this.zzc, zzajqVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + 527;
        int iHashCode2 = this.zzb.hashCode();
        return this.zzc.hashCode() + ((iHashCode2 + (iHashCode * 31)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        int length2 = str2.length();
        String str3 = this.zzb;
        StringBuilder sb = new StringBuilder(str3.length() + length2 + length + 9 + 14);
        FileInsert$$ExternalSyntheticOutline0.m(sb, str, ": domain=", str2, ", description=");
        sb.append(str3);
        return sb.toString();
    }
}
