package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfd {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;

    @Nullable
    private Integer zzc = null;

    @Nullable
    private Integer zzd = null;
    private zzhfe zze = null;
    private zzhff zzf = zzhff.zzc;

    public /* synthetic */ zzhfd(byte[] bArr) {
    }

    public final zzhfd zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhfd zzb(int i) throws InvalidAlgorithmParameterException {
        if (i < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i)));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzhfd zzc(int i) throws GeneralSecurityException {
        if (i < 12 || i > 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i)));
        }
        this.zzc = Integer.valueOf(i);
        return this;
    }

    public final zzhfd zzd(int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i)));
        }
        this.zzd = Integer.valueOf(i);
        return this;
    }

    public final zzhfd zze(zzhff zzhffVar) {
        this.zzf = zzhffVar;
        return this;
    }

    public final zzhfd zzf(zzhfe zzhfeVar) {
        this.zze = zzhfeVar;
        return this;
    }

    public final zzhfg zzg() throws GeneralSecurityException {
        if (this.zza == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("AES key size is not set");
            return null;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("HMAC key size is not set");
            return null;
        }
        if (this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("iv size is not set");
            return null;
        }
        Integer num = this.zzd;
        if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("tag size is not set");
            return null;
        }
        if (this.zze == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("hash type is not set");
            return null;
        }
        if (this.zzf == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("variant is not set");
            return null;
        }
        int iIntValue = num.intValue();
        zzhfe zzhfeVar = this.zze;
        if (zzhfeVar == zzhfe.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
            }
        } else if (zzhfeVar == zzhfe.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
            }
        } else if (zzhfeVar == zzhfe.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
            }
        } else if (zzhfeVar == zzhfe.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
            }
        } else {
            if (zzhfeVar != zzhfe.zze) {
                zzbuy$$ExternalSyntheticBUOutline0.m("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                return null;
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
            }
        }
        return new zzhfg(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze, null);
    }
}
