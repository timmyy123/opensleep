package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzajd implements zzao {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzajd(int i, String str, String str2, String str3, boolean z, int i2) {
        boolean z2 = true;
        if (i2 != -1 && i2 <= 0) {
            z2 = false;
        }
        zzgtj.zza(z2);
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajd.class == obj.getClass()) {
            zzajd zzajdVar = (zzajd) obj;
            if (this.zza == zzajdVar.zza && Objects.equals(this.zzb, zzajdVar.zzb) && Objects.equals(this.zzc, zzajdVar.zzc) && Objects.equals(this.zzd, zzajdVar.zzd) && this.zze == zzajdVar.zze && this.zzf == zzajdVar.zzf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        int iHashCode = str != null ? str.hashCode() : 0;
        int i = this.zza;
        String str2 = this.zzc;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        int i2 = ((i + 527) * 31) + iHashCode;
        String str3 = this.zzd;
        return (((((((i2 * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        int length2 = String.valueOf(str2).length();
        int i = this.zza;
        int length3 = String.valueOf(i).length();
        int i2 = this.zzf;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 28, length2, 11, length3) + 19 + String.valueOf(i2).length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, "IcyHeaders: name=\"", str, "\", genre=\"", str2);
        return zzba$$ExternalSyntheticOutline0.m(sb, i, "\", bitrate=", i2, ", metadataInterval=");
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void zza(zzam zzamVar) {
        String str = this.zzc;
        if (str != null) {
            zzamVar.zzu(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzamVar.zzt(str2);
        }
    }
}
