package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfh {

    @Nullable
    private zzhfo zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhfh(byte[] bArr) {
    }

    public final zzhfh zza(zzhfo zzhfoVar) {
        this.zza = zzhfoVar;
        return this;
    }

    public final zzhfh zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhfh zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhfi zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZzb;
        zzhfo zzhfoVar = this.zza;
        if (zzhfoVar == null || (zzibbVar = this.zzb) == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters and/or key material");
            return null;
        }
        if (zzhfoVar.zzc() != zzibbVar.zzd()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size mismatch");
            return null;
        }
        if (zzhfoVar.zza() && this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzc != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zze() == zzhfn.zzc) {
            zziazVarZzb = zzhms.zza;
        } else if (this.zza.zze() == zzhfn.zzb) {
            zziazVarZzb = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzhfn.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
                return null;
            }
            zziazVarZzb = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhfi(this.zza, this.zzb, zziazVarZzb, this.zzc, null);
    }
}
