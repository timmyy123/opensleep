package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfm {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;

    @Nullable
    private Integer zzc = null;
    private zzhfn zzd = zzhfn.zzc;

    public /* synthetic */ zzhfm(byte[] bArr) {
    }

    public final zzhfm zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhfm zzb(int i) throws GeneralSecurityException {
        if (i != 12 && i != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i)));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzhfm zzc(int i) {
        this.zzc = 16;
        return this;
    }

    public final zzhfm zzd(zzhfn zzhfnVar) {
        this.zzd = zzhfnVar;
        return this;
    }

    public final zzhfo zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size is not set");
            return null;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("IV size is not set");
            return null;
        }
        if (this.zzd == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Variant is not set");
            return null;
        }
        if (this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Tag size is not set");
            return null;
        }
        int iIntValue = num.intValue();
        int iIntValue2 = this.zzb.intValue();
        this.zzc.getClass();
        return new zzhfo(iIntValue, iIntValue2, 16, this.zzd, null);
    }
}
