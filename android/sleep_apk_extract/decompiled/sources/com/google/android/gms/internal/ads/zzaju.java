package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaju extends zzajo {
    public final String zza;
    public final String zzb;

    public zzaju(String str, String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaju.class == obj.getClass()) {
            zzaju zzajuVar = (zzaju) obj;
            if (this.zzf.equals(zzajuVar.zzf) && Objects.equals(this.zza, zzajuVar.zza) && Objects.equals(this.zzb, zzajuVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return this.zzb.hashCode() + (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zzb;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str2.length() + length + 6), str, ": url=", str2);
    }
}
