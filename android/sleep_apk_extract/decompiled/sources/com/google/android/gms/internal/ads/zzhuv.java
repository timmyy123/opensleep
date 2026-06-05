package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhuv {
    private zzhuy zza = null;
    private zziba zzb = null;

    public /* synthetic */ zzhuv(byte[] bArr) {
    }

    public final zzhuv zza(zzhuy zzhuyVar) {
        this.zza = zzhuyVar;
        return this;
    }

    public final zzhuv zzb(zziba zzibaVar) {
        this.zzb = zzibaVar;
        return this;
    }

    public final zzhuw zzc() throws GeneralSecurityException {
        zzhuy zzhuyVar = this.zza;
        byte[] bArr = null;
        if (zzhuyVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without a ecdsa public key");
            return null;
        }
        zziba zzibaVar = this.zzb;
        if (zzibaVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without a private value");
            return null;
        }
        BigInteger bigIntegerZzb = zzibaVar.zzb(zzhdo.zza());
        ECPoint eCPointZzd = zzhuyVar.zzd();
        zzhuq zzhuqVarZzd = zzhuyVar.zzf().zzd();
        BigInteger order = zzhuqVarZzd.zza().getOrder();
        if (bigIntegerZzb.signum() <= 0 || bigIntegerZzb.compareTo(order) >= 0) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Invalid private value");
            return null;
        }
        if (zzhlg.zzd(bigIntegerZzb, zzhuqVarZzd.zza()).equals(eCPointZzd)) {
            return new zzhuw(this.zza, this.zzb, bArr);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Invalid private value");
        return null;
    }
}
