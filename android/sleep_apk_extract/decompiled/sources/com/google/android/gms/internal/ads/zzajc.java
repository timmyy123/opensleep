package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzajc implements zzao {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzajc(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    public static zzajc zzb(zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        String strZzh = zzas.zzh(zzetVar.zzK(zzetVar.zzB(), StandardCharsets.US_ASCII));
        String strZzK = zzetVar.zzK(zzetVar.zzB(), StandardCharsets.UTF_8);
        int iZzB2 = zzetVar.zzB();
        int iZzB3 = zzetVar.zzB();
        int iZzB4 = zzetVar.zzB();
        int iZzB5 = zzetVar.zzB();
        int iZzB6 = zzetVar.zzB();
        byte[] bArr = new byte[iZzB6];
        zzetVar.zzm(bArr, 0, iZzB6);
        return new zzajc(iZzB, strZzh, strZzK, iZzB2, iZzB3, iZzB4, iZzB5, bArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzajc.class == obj.getClass()) {
            zzajc zzajcVar = (zzajc) obj;
            if (this.zza == zzajcVar.zza && this.zzb.equals(zzajcVar.zzb) && this.zzc.equals(zzajcVar.zzc) && this.zzd == zzajcVar.zzd && this.zze == zzajcVar.zze && this.zzf == zzajcVar.zzf && this.zzg == zzajcVar.zzg && Arrays.equals(this.zzh, zzajcVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza + 527;
        int iHashCode = this.zzb.hashCode() + (i * 31);
        int iHashCode2 = this.zzc.hashCode() + (iHashCode * 31);
        byte[] bArr = this.zzh;
        return Arrays.hashCode(bArr) + (((((((((iHashCode2 * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31);
    }

    public final String toString() {
        String str = this.zzb;
        int length = String.valueOf(str).length();
        String str2 = this.zzc;
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(str2.length() + length + 32), "Picture: mimeType=", str, ", description=", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void zza(zzam zzamVar) {
        zzamVar.zzf(this.zzh, this.zza);
    }
}
