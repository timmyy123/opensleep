package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zziay implements zzhdi {
    private final zzhjt zza;
    private final byte[] zzb;

    private zziay(byte[] bArr, byte[] bArr2) {
        this.zza = new zzhjt(bArr);
        this.zzb = bArr2;
    }

    public static zzhdi zzb(zzhic zzhicVar) {
        return new zziay(zzhicVar.zze().zzc(zzhdo.zza()), zzhicVar.zzc().zzc());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 40) {
            zzbuy$$ExternalSyntheticBUOutline0.m("ciphertext too short");
            return null;
        }
        return this.zza.zzb(ByteBuffer.wrap(bArr, 24, length - 24), Arrays.copyOf(bArr, 24), bArr2);
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
