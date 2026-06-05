package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhwy extends zzhxi {
    public static final BigInteger zza = BigInteger.valueOf(65537);
    private final int zzb;
    private final BigInteger zzc;
    private final zzhwx zzd;
    private final zzhww zze;
    private final zzhww zzf;
    private final int zzg;

    public /* synthetic */ zzhwy(int i, BigInteger bigInteger, zzhwx zzhwxVar, zzhww zzhwwVar, zzhww zzhwwVar2, int i2, byte[] bArr) {
        this.zzb = i;
        this.zzc = bigInteger;
        this.zzd = zzhwxVar;
        this.zze = zzhwwVar;
        this.zzf = zzhwwVar2;
        this.zzg = i2;
    }

    public static zzhwv zzb() {
        return new zzhwv(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhwy)) {
            return false;
        }
        zzhwy zzhwyVar = (zzhwy) obj;
        return zzhwyVar.zzb == this.zzb && Objects.equals(zzhwyVar.zzc, this.zzc) && zzhwyVar.zzd == this.zzd && zzhwyVar.zze == this.zze && zzhwyVar.zzf == this.zzf && zzhwyVar.zzg == this.zzg;
    }

    public final int hashCode() {
        return Objects.hash(zzhwy.class, Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze, this.zzf, Integer.valueOf(this.zzg));
    }

    public final String toString() {
        BigInteger bigInteger = this.zzc;
        zzhww zzhwwVar = this.zzf;
        zzhww zzhwwVar2 = this.zze;
        String strValueOf = String.valueOf(this.zzd);
        String strValueOf2 = String.valueOf(zzhwwVar2);
        String strValueOf3 = String.valueOf(zzhwwVar);
        String strValueOf4 = String.valueOf(bigInteger);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int length3 = strValueOf3.length();
        int i = this.zzg;
        int length4 = String.valueOf(i).length();
        int length5 = strValueOf4.length();
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 55 + length2 + 17 + length3 + 19 + length4 + 18 + length5 + 6 + String.valueOf(i2).length() + 13);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "RSA SSA PSS Parameters (variant: ", strValueOf, ", signature hashType: ", strValueOf2);
        zzba$$ExternalSyntheticOutline0.m(sb, ", mgf1 hashType: ", strValueOf3, ", saltLengthBytes: ", i);
        zzba$$ExternalSyntheticOutline0.m(sb, ", publicExponent: ", strValueOf4, ", and ", i2);
        sb.append("-bit modulus)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhwx.zzd;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final BigInteger zzd() {
        return this.zzc;
    }

    public final zzhwx zze() {
        return this.zzd;
    }

    public final zzhww zzf() {
        return this.zze;
    }

    public final zzhww zzg() {
        return this.zzf;
    }

    public final int zzh() {
        return this.zzg;
    }
}
