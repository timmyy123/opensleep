package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfo extends zzheu {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzhfn zzd;

    public /* synthetic */ zzhfo(int i, int i2, int i3, zzhfn zzhfnVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzhfnVar;
    }

    public static zzhfm zzb() {
        return new zzhfm(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhfo)) {
            return false;
        }
        zzhfo zzhfoVar = (zzhfo) obj;
        return zzhfoVar.zza == this.zza && zzhfoVar.zzb == this.zzb && zzhfoVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzhfo.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = strValueOf.length();
        int i = this.zzb;
        int length2 = String.valueOf(i).length();
        int length3 = String.valueOf(16).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(FileInsert$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(length, 30, length2, 10, length3), 15, String.valueOf(i2).length(), 10));
        zzba$$ExternalSyntheticOutline0.m(sb, "AesEax Parameters (variant: ", strValueOf, ", ", i);
        return zzba$$ExternalSyntheticOutline0.m(sb, "-byte IV, 16-byte tag, and ", i2, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhfn.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final zzhfn zze() {
        return this.zzd;
    }
}
