package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhwm extends zzhxi {
    public static final BigInteger zza = BigInteger.valueOf(65537);
    private final int zzb;
    private final BigInteger zzc;
    private final zzhwl zzd;
    private final zzhwk zze;

    public /* synthetic */ zzhwm(int i, BigInteger bigInteger, zzhwl zzhwlVar, zzhwk zzhwkVar, byte[] bArr) {
        this.zzb = i;
        this.zzc = bigInteger;
        this.zzd = zzhwlVar;
        this.zze = zzhwkVar;
    }

    public static zzhwj zzb() {
        return new zzhwj(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhwm)) {
            return false;
        }
        zzhwm zzhwmVar = (zzhwm) obj;
        return zzhwmVar.zzb == this.zzb && Objects.equals(zzhwmVar.zzc, this.zzc) && zzhwmVar.zzd == this.zzd && zzhwmVar.zze == this.zze;
    }

    public final int hashCode() {
        return Objects.hash(zzhwm.class, Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze);
    }

    public final String toString() {
        BigInteger bigInteger = this.zzc;
        zzhwk zzhwkVar = this.zze;
        String strValueOf = String.valueOf(this.zzd);
        String strValueOf2 = String.valueOf(zzhwkVar);
        String strValueOf3 = String.valueOf(bigInteger);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int length3 = strValueOf3.length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 47, length2, 18, length3, 6, String.valueOf(i).length()) + 13);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "RSA SSA PKCS1 Parameters (variant: ", strValueOf, ", hashType: ", strValueOf2);
        zzba$$ExternalSyntheticOutline0.m(sb, ", publicExponent: ", strValueOf3, ", and ", i);
        sb.append("-bit modulus)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhwl.zzd;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final BigInteger zzd() {
        return this.zzc;
    }

    public final zzhwl zze() {
        return this.zzd;
    }

    public final zzhwk zzf() {
        return this.zze;
    }
}
