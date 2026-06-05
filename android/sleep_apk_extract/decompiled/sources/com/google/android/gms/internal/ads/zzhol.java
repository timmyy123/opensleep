package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhol {

    @Nullable
    private zzhov zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhol(byte[] bArr) {
    }

    public final zzhol zza(zzhov zzhovVar) {
        this.zza = zzhovVar;
        return this;
    }

    public final zzhol zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhol zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhom zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZza;
        zzhov zzhovVar = this.zza;
        if (zzhovVar == null || (zzibbVar = this.zzb) == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters and/or key material");
            return null;
        }
        if (zzhovVar.zzc() != zzibbVar.zzd()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size mismatch");
            return null;
        }
        if (zzhovVar.zza() && this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzc != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zzf() == zzhou.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zzf() == zzhou.zzc || this.zza.zzf() == zzhou.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhou.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
                return null;
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhom(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }
}
