package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhoi extends zzhoy {
    private final int zza;
    private final int zzb;
    private final zzhoh zzc;

    public /* synthetic */ zzhoi(int i, int i2, zzhoh zzhohVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzhohVar;
    }

    public static zzhog zzb() {
        return new zzhog(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhoi)) {
            return false;
        }
        zzhoi zzhoiVar = (zzhoi) obj;
        return zzhoiVar.zza == this.zza && zzhoiVar.zze() == zze() && zzhoiVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return Objects.hash(zzhoi.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzc);
        int length = strValueOf.length();
        int i = this.zzb;
        int length2 = String.valueOf(i).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 32, length2, 16, String.valueOf(i2).length()) + 10);
        zzba$$ExternalSyntheticOutline0.m(sb, "AES-CMAC Parameters (variant: ", strValueOf, ", ", i);
        return zzba$$ExternalSyntheticOutline0.m(sb, "-byte tags, and ", i2, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzc != zzhoh.zzd;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        zzhoh zzhohVar = this.zzc;
        if (zzhohVar == zzhoh.zzd) {
            return this.zzb;
        }
        if (zzhohVar == zzhoh.zza || zzhohVar == zzhoh.zzb || zzhohVar == zzhoh.zzc) {
            return this.zzb + 5;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown variant");
        return 0;
    }

    public final zzhoh zzf() {
        return this.zzc;
    }
}
