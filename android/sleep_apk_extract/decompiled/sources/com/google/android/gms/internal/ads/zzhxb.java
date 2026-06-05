package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhxb {

    @Nullable
    private zzhwy zza = null;

    @Nullable
    private BigInteger zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhxb(byte[] bArr) {
    }

    public final zzhxb zza(zzhwy zzhwyVar) {
        this.zza = zzhwyVar;
        return this;
    }

    public final zzhxb zzb(BigInteger bigInteger) {
        this.zzb = bigInteger;
        return this;
    }

    public final zzhxb zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhxc zzd() throws GeneralSecurityException {
        zziaz zziazVarZza;
        if (this.zza == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters");
            return null;
        }
        BigInteger bigInteger = this.zzb;
        if (bigInteger == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without modulus");
            return null;
        }
        int iBitLength = bigInteger.bitLength();
        int iZzc = this.zza.zzc();
        if (iBitLength != iZzc) {
            throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(new StringBuilder(String.valueOf(iBitLength).length() + 56 + String.valueOf(iZzc).length()), iBitLength, "Got modulus size ", iZzc, ", but parameters requires modulus size "));
        }
        if (this.zza.zza() && this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzc != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zze() == zzhwx.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zze() == zzhwx.zzc || this.zza.zze() == zzhwx.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzhwx.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown RsaSsaPssParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
                return null;
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhxc(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }
}
