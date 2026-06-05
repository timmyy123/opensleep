package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhex {

    @Nullable
    private zzhfg zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private zzibb zzc = null;

    @Nullable
    private Integer zzd = null;

    public /* synthetic */ zzhex(byte[] bArr) {
    }

    public final zzhex zza(zzhfg zzhfgVar) {
        this.zza = zzhfgVar;
        return this;
    }

    public final zzhex zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhex zzc(zzibb zzibbVar) {
        this.zzc = zzibbVar;
        return this;
    }

    public final zzhex zzd(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzhey zze() throws GeneralSecurityException {
        zziaz zziazVarZzb;
        zzhfg zzhfgVar = this.zza;
        if (zzhfgVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters");
            return null;
        }
        zzibb zzibbVar = this.zzb;
        if (zzibbVar == null || this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without key material");
            return null;
        }
        if (zzhfgVar.zzc() != zzibbVar.zzd()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("AES key size mismatch");
            return null;
        }
        if (zzhfgVar.zzd() != this.zzc.zzd()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("HMAC key size mismatch");
            return null;
        }
        if (this.zza.zza() && this.zzd == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzd != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zzg() == zzhff.zzc) {
            zziazVarZzb = zzhms.zza;
        } else if (this.zza.zzg() == zzhff.zzb) {
            zziazVarZzb = zzhms.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzg() != zzhff.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzg())));
                return null;
            }
            zziazVarZzb = zzhms.zzb(this.zzd.intValue());
        }
        return new zzhey(this.zza, this.zzb, this.zzc, zziazVarZzb, this.zzd, null);
    }
}
