package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzajj extends zzajo {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    public zzajj(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajj.class == obj.getClass()) {
            zzajj zzajjVar = (zzajj) obj;
            if (Objects.equals(this.zza, zzajjVar.zza) && Objects.equals(this.zzb, zzajjVar.zzb) && Objects.equals(this.zzc, zzajjVar.zzc) && Arrays.equals(this.zzd, zzajjVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int iHashCode = this.zzb.hashCode() + (((str != null ? str.hashCode() : 0) + 527) * 31);
        return Arrays.hashCode(this.zzd) + ((this.zzc.hashCode() + (iHashCode * 31)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final String toString() {
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        int length2 = String.valueOf(str2).length();
        String str3 = this.zzb;
        int length3 = str3.length() + FileInsert$$ExternalSyntheticOutline0.m(length, 11, length2, 11);
        String str4 = this.zzc;
        StringBuilder sb = new StringBuilder(str4.length() + length3 + 14);
        FileInsert$$ExternalSyntheticOutline0.m(sb, str, ": mimeType=", str2, ", filename=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, str3, ", description=", str4);
    }
}
