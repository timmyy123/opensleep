package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhog {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;
    private zzhoh zzc = zzhoh.zzd;

    public /* synthetic */ zzhog(byte[] bArr) {
    }

    public final zzhog zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i * 8)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhog zzb(int i) throws GeneralSecurityException {
        if (i < 10 || i > 16) {
            throw new GeneralSecurityException(zzba$$ExternalSyntheticOutline0.m(i, "Invalid tag size for AesCmacParameters: ", new StringBuilder(String.valueOf(i).length() + 40)));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzhog zzc(zzhoh zzhohVar) {
        this.zzc = zzhohVar;
        return this;
    }

    public final zzhoi zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        byte[] bArr = null;
        if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("key size not set");
            return null;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("tag size not set");
            return null;
        }
        if (this.zzc != null) {
            return new zzhoi(num.intValue(), this.zzb.intValue(), this.zzc, bArr);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("variant not set");
        return null;
    }
}
