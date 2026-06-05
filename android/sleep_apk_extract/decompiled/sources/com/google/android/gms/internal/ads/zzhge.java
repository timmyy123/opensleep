package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhge {

    @Nullable
    private Integer zza = null;
    private zzhgf zzb = zzhgf.zzc;

    public /* synthetic */ zzhge(byte[] bArr) {
    }

    public final zzhge zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhge zzb(zzhgf zzhgfVar) {
        this.zzb = zzhgfVar;
        return this;
    }

    public final zzhgg zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        byte[] bArr = null;
        if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size is not set");
            return null;
        }
        if (this.zzb != null) {
            return new zzhgg(num.intValue(), this.zzb, bArr);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Variant is not set");
        return null;
    }
}
