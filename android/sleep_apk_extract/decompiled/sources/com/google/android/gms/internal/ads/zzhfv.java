package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfv {

    @Nullable
    private Integer zza = null;

    @Nullable
    private Integer zzb = null;

    @Nullable
    private Integer zzc = null;
    private zzhfw zzd = zzhfw.zzc;

    public /* synthetic */ zzhfv(byte[] bArr) {
    }

    public final zzhfv zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhfv zzb(int i) {
        this.zzb = 12;
        return this;
    }

    public final zzhfv zzc(int i) {
        this.zzc = 16;
        return this;
    }

    public final zzhfv zzd(zzhfw zzhfwVar) {
        this.zzd = zzhfwVar;
        return this;
    }

    public final zzhfx zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size is not set");
            return null;
        }
        if (this.zzd == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Variant is not set");
            return null;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("IV size is not set");
            return null;
        }
        if (this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Tag size is not set");
            return null;
        }
        int iIntValue = num.intValue();
        this.zzb.getClass();
        this.zzc.getClass();
        return new zzhfx(iIntValue, 12, 16, this.zzd, null);
    }
}
