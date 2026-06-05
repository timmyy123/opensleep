package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhoa {

    @Nullable
    private zzhoi zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhoa(byte[] bArr) {
    }

    public final zzhoa zza(zzhoi zzhoiVar) {
        this.zza = zzhoiVar;
        return this;
    }

    public final zzhoa zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhoa zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhob zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZza;
        zzhoi zzhoiVar = this.zza;
        if (zzhoiVar == null || (zzibbVar = this.zzb) == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters and/or key material");
            return null;
        }
        if (zzhoiVar.zzc() != zzibbVar.zzd()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size mismatch");
            return null;
        }
        if (zzhoiVar.zza() && this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzc != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zzf() == zzhoh.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zzf() == zzhoh.zzc || this.zza.zzf() == zzhoh.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhoh.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
                return null;
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhob(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }
}
