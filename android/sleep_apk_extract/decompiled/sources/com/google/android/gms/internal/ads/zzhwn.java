package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhwn {

    @Nullable
    private zzhwq zza = null;

    @Nullable
    private zziba zzb = null;

    @Nullable
    private zziba zzc = null;

    @Nullable
    private zziba zzd = null;

    @Nullable
    private zziba zze = null;

    @Nullable
    private zziba zzf = null;

    @Nullable
    private zziba zzg = null;

    public /* synthetic */ zzhwn(byte[] bArr) {
    }

    public final zzhwn zza(zzhwq zzhwqVar) {
        this.zza = zzhwqVar;
        return this;
    }

    public final zzhwn zzb(zziba zzibaVar, zziba zzibaVar2) {
        this.zzc = zzibaVar;
        this.zzd = zzibaVar2;
        return this;
    }

    public final zzhwn zzc(zziba zzibaVar) {
        this.zzb = zzibaVar;
        return this;
    }

    public final zzhwn zzd(zziba zzibaVar, zziba zzibaVar2) {
        this.zze = zzibaVar;
        this.zzf = zzibaVar2;
        return this;
    }

    public final zzhwn zze(zziba zzibaVar) {
        this.zzg = zzibaVar;
        return this;
    }

    public final zzhwo zzf() throws GeneralSecurityException {
        zzhwq zzhwqVar = this.zza;
        if (zzhwqVar == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without a RSA SSA PKCS1 public key");
            return null;
        }
        if (this.zzc == null || this.zzd == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without prime factors");
            return null;
        }
        if (this.zzb == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without private exponent");
            return null;
        }
        if (this.zze == null || this.zzf == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without prime exponents");
            return null;
        }
        if (this.zzg == null) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Cannot build without CRT coefficient");
            return null;
        }
        BigInteger bigIntegerZzd = zzhwqVar.zzf().zzd();
        BigInteger bigIntegerZzd2 = this.zza.zzd();
        BigInteger bigIntegerZzb = this.zzc.zzb(zzhdo.zza());
        BigInteger bigIntegerZzb2 = this.zzd.zzb(zzhdo.zza());
        BigInteger bigIntegerZzb3 = this.zzb.zzb(zzhdo.zza());
        BigInteger bigIntegerZzb4 = this.zze.zzb(zzhdo.zza());
        BigInteger bigIntegerZzb5 = this.zzf.zzb(zzhdo.zza());
        BigInteger bigIntegerZzb6 = this.zzg.zzb(zzhdo.zza());
        if (!bigIntegerZzb.isProbablePrime(10)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("p is not a prime");
            return null;
        }
        if (!bigIntegerZzb2.isProbablePrime(10)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("q is not a prime");
            return null;
        }
        if (!bigIntegerZzb.multiply(bigIntegerZzb2).equals(bigIntegerZzd2)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Prime p times prime q is not equal to the public key's modulus");
            return null;
        }
        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerZzb.subtract(bigInteger);
        BigInteger bigIntegerSubtract2 = bigIntegerZzb2.subtract(bigInteger);
        if (!bigIntegerZzd.multiply(bigIntegerZzb3).mod(bigIntegerSubtract.divide(bigIntegerSubtract.gcd(bigIntegerSubtract2)).multiply(bigIntegerSubtract2)).equals(bigInteger)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("D is invalid.");
            return null;
        }
        if (!bigIntegerZzd.multiply(bigIntegerZzb4).mod(bigIntegerSubtract).equals(bigInteger)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("dP is invalid.");
            return null;
        }
        if (!bigIntegerZzd.multiply(bigIntegerZzb5).mod(bigIntegerSubtract2).equals(bigInteger)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("dQ is invalid.");
            return null;
        }
        if (bigIntegerZzb2.multiply(bigIntegerZzb6).mod(bigIntegerZzb).equals(bigInteger)) {
            return new zzhwo(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, null);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("qInv is invalid.");
        return null;
    }
}
