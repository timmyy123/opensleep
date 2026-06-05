package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhwj {
    private static final BigInteger zze;
    private static final BigInteger zzf;

    @Nullable
    private Integer zza = null;

    @Nullable
    private BigInteger zzb = zzhwm.zza;

    @Nullable
    private zzhwk zzc = null;
    private zzhwl zzd = zzhwl.zzd;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        zze = bigIntegerValueOf;
        zzf = bigIntegerValueOf.pow(256);
    }

    public /* synthetic */ zzhwj(byte[] bArr) {
    }

    public final zzhwj zza(int i) {
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhwj zzb(BigInteger bigInteger) {
        this.zzb = bigInteger;
        return this;
    }

    public final zzhwj zzc(zzhwl zzhwlVar) {
        this.zzd = zzhwlVar;
        return this;
    }

    public final zzhwj zzd(zzhwk zzhwkVar) {
        this.zzc = zzhwkVar;
        return this;
    }

    public final zzhwm zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("key size is not set");
            return null;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("publicExponent is not set");
            return null;
        }
        if (this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("hash type is not set");
            return null;
        }
        if (this.zzd == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("variant is not set");
            return null;
        }
        if (num.intValue() < 2048) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 2048 bits", this.zza));
        }
        BigInteger bigInteger = this.zzb;
        int iCompareTo = bigInteger.compareTo(zzhwm.zza);
        if (iCompareTo != 0) {
            if (iCompareTo < 0) {
                throw new InvalidAlgorithmParameterException("Public exponent must be at least 65537.");
            }
            if (bigInteger.mod(zze).equals(BigInteger.ZERO)) {
                throw new InvalidAlgorithmParameterException("Invalid public exponent");
            }
            if (bigInteger.compareTo(zzf) > 0) {
                throw new InvalidAlgorithmParameterException("Public exponent cannot be larger than 2^256.");
            }
        }
        return new zzhwm(this.zza.intValue(), this.zzb, this.zzd, this.zzc, null);
    }
}
