package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhgg extends zzheu {
    private final int zza;
    private final zzhgf zzb;

    public /* synthetic */ zzhgg(int i, zzhgf zzhgfVar, byte[] bArr) {
        this.zza = i;
        this.zzb = zzhgfVar;
    }

    public static zzhge zzb() {
        return new zzhge(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhgg)) {
            return false;
        }
        zzhgg zzhggVar = (zzhgg) obj;
        return zzhggVar.zza == this.zza && zzhggVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzhgg.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        int length = strValueOf.length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(i).length() + 10);
        zzba$$ExternalSyntheticOutline0.m(sb, "AesGcmSiv Parameters (variant: ", strValueOf, ", ", i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzb != zzhgf.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzhgf zzd() {
        return this.zzb;
    }
}
