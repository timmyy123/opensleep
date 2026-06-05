package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhzm implements zzhdi {
    private final zzhjq zza;
    private final byte[] zzb;

    private zzhzm(byte[] bArr, byte[] bArr2) {
        this.zza = new zzhjq(bArr);
        this.zzb = bArr2;
    }

    public static zzhdi zzb(zzhgh zzhghVar) {
        return new zzhzm(zzhghVar.zze().zzc(zzhdo.zza()), zzhghVar.zzc().zzc());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 28) {
            zzbuy$$ExternalSyntheticBUOutline0.m("ciphertext too short");
            return null;
        }
        return this.zza.zzb(ByteBuffer.wrap(bArr, 12, length - 12), Arrays.copyOf(bArr, 12), bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        if (length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzhnz.zze(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
        zzbuy$$ExternalSyntheticBUOutline0.m("Decryption failed (OutputPrefix mismatch).");
        return null;
    }
}
