package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhwp {

    @Nullable
    private zzhwm zza = null;

    @Nullable
    private BigInteger zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhwp(byte[] bArr) {
    }

    public final zzhwp zza(zzhwm zzhwmVar) {
        this.zza = zzhwmVar;
        return this;
    }

    public final zzhwp zzb(BigInteger bigInteger) {
        this.zzb = bigInteger;
        return this;
    }

    public final zzhwp zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhwq zzd() throws GeneralSecurityException {
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
        if (this.zza.zze() == zzhwl.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zze() == zzhwl.zzc || this.zza.zze() == zzhwl.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzhwl.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown RsaSsaPkcs1Parameters.Variant: ".concat(String.valueOf(this.zza.zze())));
                return null;
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhwq(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }
}
