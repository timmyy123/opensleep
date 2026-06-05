package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfy {

    @Nullable
    private zzhgg zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhfy(byte[] bArr) {
    }

    public final zzhfy zza(zzhgg zzhggVar) {
        this.zza = zzhggVar;
        return this;
    }

    public final zzhfy zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhfy zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhfz zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZzb;
        zzhgg zzhggVar = this.zza;
        if (zzhggVar == null || (zzibbVar = this.zzb) == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters and/or key material");
            return null;
        }
        if (zzhggVar.zzc() != zzibbVar.zzd()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size mismatch");
            return null;
        }
        if (zzhggVar.zza() && this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzc != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zzd() == zzhgf.zzc) {
            zziazVarZzb = zzhms.zza;
        } else if (this.zza.zzd() == zzhgf.zzb) {
            zziazVarZzb = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzhgf.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
                return null;
            }
            zziazVarZzb = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhfz(this.zza, this.zzb, zziazVarZzb, this.zzc, null);
    }
}
