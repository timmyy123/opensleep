package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhzu implements zzhdi {
    private final zziak zza;
    private final zzheg zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzhzu(zziak zziakVar, zzheg zzhegVar, int i, byte[] bArr) {
        this.zza = zziakVar;
        this.zzb = zzhegVar;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzhdi zzb(zzhey zzheyVar) {
        zzhze zzhzeVar = new zzhze(zzheyVar.zze().zzc(zzhdo.zza()), zzheyVar.zzg().zzf());
        String strValueOf = String.valueOf(zzheyVar.zzg().zzh());
        return new zzhzu(zzhzeVar, new zziap(new zziao("HMAC".concat(strValueOf), new SecretKeySpec(zzheyVar.zzf().zzc(zzhdo.zza()), "HMAC")), zzheyVar.zzg().zze()), zzheyVar.zzg().zze(), zzheyVar.zzc().zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int length = bArr.length;
        int i = this.zzc;
        int length2 = bArr3.length;
        if (length < i + length2) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Decryption failed (ciphertext too short).");
            return null;
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Decryption failed (OutputPrefix mismatch).");
            return null;
        }
        int i2 = length - i;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i2);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i2, length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrCopyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        if (MessageDigest.isEqual(((zziap) this.zzb).zzc(zzhzl.zza(bArr2, bArrCopyOfRange, bArrCopyOf)), bArrCopyOfRange2)) {
            return this.zza.zza(bArrCopyOfRange);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("invalid MAC");
        return null;
    }
}
