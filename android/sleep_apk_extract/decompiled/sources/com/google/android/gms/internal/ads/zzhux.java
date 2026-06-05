package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhux {

    @Nullable
    private zzhuu zza = null;

    @Nullable
    private ECPoint zzb = null;

    @Nullable
    private Integer zzc = null;

    public /* synthetic */ zzhux(byte[] bArr) {
    }

    public final zzhux zza(zzhuu zzhuuVar) {
        this.zza = zzhuuVar;
        return this;
    }

    public final zzhux zzb(ECPoint eCPoint) {
        this.zzb = eCPoint;
        return this;
    }

    public final zzhux zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhuy zzd() throws GeneralSecurityException {
        zziaz zziazVarZza;
        zzhuu zzhuuVar = this.zza;
        if (zzhuuVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without parameters");
            return null;
        }
        ECPoint eCPoint = this.zzb;
        if (eCPoint == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without public point");
            return null;
        }
        zzhlg.zza(eCPoint, zzhuuVar.zzd().zza().getCurve());
        if (this.zza.zza() && this.zzc == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key without ID requirement with parameters with ID requirement");
            return null;
        }
        if (!this.zza.zza() && this.zzc != null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot create key with ID requirement with parameters without ID requirement");
            return null;
        }
        if (this.zza.zzf() == zzhut.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zzf() == zzhut.zzc || this.zza.zzf() == zzhut.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhut.zza) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown EcdsaParameters.Variant: ".concat(this.zza.zzf().toString()));
                return null;
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhuy(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }
}
