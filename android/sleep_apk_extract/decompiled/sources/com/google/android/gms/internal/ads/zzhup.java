package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhup {
    private zzhus zza = null;
    private zzhuq zzb = null;
    private zzhur zzc = null;
    private zzhut zzd = zzhut.zzd;

    public /* synthetic */ zzhup(byte[] bArr) {
    }

    public final zzhup zza(zzhus zzhusVar) {
        this.zza = zzhusVar;
        return this;
    }

    public final zzhup zzb(zzhuq zzhuqVar) {
        this.zzb = zzhuqVar;
        return this;
    }

    public final zzhup zzc(zzhur zzhurVar) {
        this.zzc = zzhurVar;
        return this;
    }

    public final zzhup zzd(zzhut zzhutVar) {
        this.zzd = zzhutVar;
        return this;
    }

    public final zzhuu zze() throws GeneralSecurityException {
        zzhus zzhusVar = this.zza;
        if (zzhusVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("signature encoding is not set");
            return null;
        }
        zzhuq zzhuqVar = this.zzb;
        if (zzhuqVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("EC curve type is not set");
            return null;
        }
        zzhur zzhurVar = this.zzc;
        if (zzhurVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("hash type is not set");
            return null;
        }
        zzhut zzhutVar = this.zzd;
        if (zzhutVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("variant is not set");
            return null;
        }
        if (zzhuqVar == zzhuq.zza && zzhurVar != zzhur.zza) {
            zzbuy$$ExternalSyntheticBUOutline0.m("NIST_P256 requires SHA256");
            return null;
        }
        if (zzhuqVar == zzhuq.zzb && zzhurVar != zzhur.zzb && zzhurVar != zzhur.zzc) {
            zzbuy$$ExternalSyntheticBUOutline0.m("NIST_P384 requires SHA384 or SHA512");
            return null;
        }
        if (zzhuqVar != zzhuq.zzc || zzhurVar == zzhur.zzc) {
            return new zzhuu(zzhusVar, zzhuqVar, zzhurVar, zzhutVar, null);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("NIST_P521 requires SHA512");
        return null;
    }
}
