package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhxt implements zzhek {
    static final zzhli zza;
    static final zzhli zzb;
    static final zzhli zzc;
    private static final byte[] zze = new byte[0];
    private static final byte[] zzf = {0};
    private final ECPublicKey zzg;
    private final String zzh;
    private final zzhzs zzi;
    private final byte[] zzj;
    private final byte[] zzk;

    @Nullable
    private final Provider zzl;

    static {
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zziai.SHA256, zzhur.zza);
        zzhlhVarZza.zza(zziai.SHA384, zzhur.zzb);
        zzhlhVarZza.zza(zziai.SHA512, zzhur.zzc);
        zza = zzhlhVarZza.zzb();
        zzhlh zzhlhVarZza2 = zzhli.zza();
        zzhlhVarZza2.zza(zzhzs.IEEE_P1363, zzhus.zza);
        zzhlhVarZza2.zza(zzhzs.DER, zzhus.zzb);
        zzb = zzhlhVarZza2.zzb();
        zzhlh zzhlhVarZza3 = zzhli.zza();
        zzhlhVarZza3.zza(zzhzr.NIST_P256, zzhuq.zza);
        zzhlhVarZza3.zza(zzhzr.NIST_P384, zzhuq.zzb);
        zzhlhVarZza3.zza(zzhzr.NIST_P521, zzhuq.zzc);
        zzc = zzhlhVarZza3.zzb();
    }

    private zzhxt(ECPublicKey eCPublicKey, zziai zziaiVar, zzhzs zzhzsVar, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(2)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
            throw null;
        }
        this.zzh = zziaw.zza(zziaiVar);
        this.zzg = eCPublicKey;
        this.zzi = zzhzsVar;
        this.zzj = bArr;
        this.zzk = bArr2;
        this.zzl = provider;
    }

    public static zzhek zzb(zzhuy zzhuyVar, @Nullable Provider provider) {
        return new zzhxt((ECPublicKey) (provider != null ? KeyFactory.getInstance("EC", provider) : (KeyFactory) zzhzz.zzf.zzb("EC")).generatePublic(new ECPublicKeySpec(zzhuyVar.zzd(), zzhzt.zzb((zzhzr) zzc.zzb(zzhuyVar.zzf().zzd())))), (zziai) zza.zzb(zzhuyVar.zzf().zze()), (zzhzs) zzb.zzb(zzhuyVar.zzf().zzc()), zzhuyVar.zze().zzc(), zzhuyVar.zzf().zzf().equals(zzhut.zzc) ? zzf : zze, provider);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        byte b;
        int i6;
        byte b2;
        Signature signature;
        byte[] bArr3;
        if (this.zzi == zzhzs.IEEE_P1363) {
            EllipticCurve curve = this.zzg.getParams().getCurve();
            int length = bArr.length;
            int iBitLength = (zzhlg.zzc(curve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
            if (length != iBitLength + iBitLength) {
                zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature");
                return;
            }
            bArr = zzhzt.zza(bArr);
        }
        int length2 = bArr.length;
        if (length2 >= 8 && bArr[0] == 48) {
            int i7 = bArr[1] & 255;
            if (i7 == 129) {
                i7 = bArr[2] & 255;
                if (i7 >= 128) {
                    i = 2;
                    if (i7 == (length2 - 1) - i && bArr[i + 1] == 2 && (i5 = (i4 = (i3 = i + 3) + (i2 = bArr[i + 2] & 255)) + 1) < length2 && i2 != 0) {
                        b = bArr[i3];
                        if ((b & 255) < 128 && ((i2 <= 1 || b != 0 || (bArr[i + 4] & 255) >= 128) && bArr[i4] == 2)) {
                            i6 = bArr[i5] & 255;
                            if (i4 + 2 + i6 == length2 && i6 != 0) {
                                b2 = bArr[i + 5 + i2];
                                if ((b2 & 255) < 128 && (i6 <= 1 || b2 != 0 || (bArr[i + 6 + i2] & 255) >= 128)) {
                                    String str = this.zzh;
                                    Provider provider = this.zzl;
                                    signature = provider == null ? Signature.getInstance(str, provider) : (Signature) zzhzz.zzc.zzb(str);
                                    signature.initVerify(this.zzg);
                                    signature.update(bArr2);
                                    bArr3 = this.zzk;
                                    if (bArr3.length > 0) {
                                        signature.update(bArr3);
                                    }
                                    try {
                                        if (signature.verify(bArr)) {
                                            return;
                                        }
                                    } catch (RuntimeException unused) {
                                    }
                                    zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature");
                                    return;
                                }
                            }
                        }
                    }
                }
            } else if (i7 != 128 && i7 <= 129) {
                i = 1;
                if (i7 == (length2 - 1) - i) {
                    b = bArr[i3];
                    if ((b & 255) < 128) {
                        i6 = bArr[i5] & 255;
                        if (i4 + 2 + i6 == length2) {
                            b2 = bArr[i + 5 + i2];
                            if ((b2 & 255) < 128) {
                                String str2 = this.zzh;
                                Provider provider2 = this.zzl;
                                if (provider2 == null) {
                                }
                                signature.initVerify(this.zzg);
                                signature.update(bArr2);
                                bArr3 = this.zzk;
                                if (bArr3.length > 0) {
                                }
                                if (signature.verify(bArr)) {
                                }
                                zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature");
                                return;
                            }
                        }
                    }
                }
            }
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature");
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzj;
        int length = bArr3.length;
        if (length == 0) {
            zzc(bArr, bArr2);
        } else if (zzhnz.zze(bArr3, bArr)) {
            zzc(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        } else {
            zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature (output prefix mismatch)");
        }
    }
}
