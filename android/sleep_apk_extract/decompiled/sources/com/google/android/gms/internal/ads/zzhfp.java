package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhfp {

    @Nullable
    private zzhfx zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhfp(byte[] bArr) {
    }

    public final zzhfp zza(zzhfx zzhfxVar) {
        this.zza = zzhfxVar;
        return this;
    }

    public final zzhfp zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhfp zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhfq zzd() throws GeneralSecurityException {
        zzibb zzibbVar;
        zziaz zziazVarZzb;
        zzhfx zzhfxVar = this.zza;
        if (zzhfxVar == null || (zzibbVar = this.zzb) == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters and/or key material");
            return null;
        }
        if (zzhfxVar.zzc() != zzibbVar.zzd()) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Key size mismatch");
            return null;
        }
        if (zzhfxVar.zza() && this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzc != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zzd() == zzhfw.zzc) {
            zziazVarZzb = zzhms.zza;
        } else if (this.zza.zzd() == zzhfw.zzb) {
            zziazVarZzb = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzhfw.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
                return null;
            }
            zziazVarZzb = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhfq(this.zza, this.zzb, zziazVarZzb, this.zzc, null);
    }
}
