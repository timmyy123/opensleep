package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhos {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;
    private zzhot zzc = null;
    private zzhou zzd = zzhou.zzd;

    public /* synthetic */ zzhos(byte[] bArr) {
    }

    public final zzhos zza(int i) {
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhos zzb(int i) {
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzhos zzc(zzhou zzhouVar) {
        this.zzd = zzhouVar;
        return this;
    }

    public final zzhos zzd(zzhot zzhotVar) {
        this.zzc = zzhotVar;
        return this;
    }

    public final zzhov zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("key size is not set");
            return null;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("tag size is not set");
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
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
        }
        Integer num2 = this.zzb;
        int iIntValue = num2.intValue();
        zzhot zzhotVar = this.zzc;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (zzhotVar == zzhot.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (zzhotVar == zzhot.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (zzhotVar == zzhot.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (zzhotVar == zzhot.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (zzhotVar != zzhot.zze) {
                zzbuy$$ExternalSyntheticBUOutline0.m("unknown hash type; must be SHA256, SHA384 or SHA512");
                return null;
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new zzhov(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
    }
}
