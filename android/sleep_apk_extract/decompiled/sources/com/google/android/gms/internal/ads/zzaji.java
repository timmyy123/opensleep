package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaji extends zzajo {
    public final String zza;
    public final String zzb;
    public final String zzc;

    public zzaji(String str, String str2, String str3) {
        super("COMM");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaji.class == obj.getClass()) {
            zzaji zzajiVar = (zzaji) obj;
            if (Objects.equals(this.zzb, zzajiVar.zzb) && Objects.equals(this.zza, zzajiVar.zza) && Objects.equals(this.zzc, zzajiVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzb.hashCode() + ((this.zza.hashCode() + 527) * 31);
        String str = this.zzc;
        return (iHashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zzc;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zza;
        int length3 = str3.length();
        String str4 = this.zzb;
        StringBuilder sb = new StringBuilder(str4.length() + length3 + length + 11 + 14 + 7 + length2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, str, ": language=", str3, ", description=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, str4, ", text=", str2);
    }
}
