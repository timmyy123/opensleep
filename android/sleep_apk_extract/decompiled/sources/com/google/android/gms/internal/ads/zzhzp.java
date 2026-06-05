package com.google.android.gms.internal.ads;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
final class zzhzp implements zzhek {
    private final byte[] zza;
    private final byte[] zzb;
    private final byte[] zzc;

    public /* synthetic */ zzhzp(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (!zzhkr.zza(1)) {
            Events$$ExternalSyntheticBUOutline0.m(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
            throw null;
        }
        if (bArr.length != 32) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Given public key's length is not 32.");
            throw null;
        }
        this.zza = (byte[]) bArr.clone();
        this.zzb = bArr2;
        this.zzc = bArr3;
        zzhlc.zzd();
    }

    private final void zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 64) {
            zzbuy$$ExternalSyntheticBUOutline0.m("The length of the signature is not 64.");
        } else {
            if (zzhlc.zzc(bArr2, bArr, this.zza)) {
                return;
            }
            zzbuy$$ExternalSyntheticBUOutline0.m("Signature check failed.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        if (length == 0 && this.zzc.length == 0) {
            zzb(bArr, bArr2);
            return;
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            zzbuy$$ExternalSyntheticBUOutline0.m("Invalid signature (output prefix mismatch)");
            return;
        }
        byte[] bArr4 = this.zzc;
        if (bArr4.length != 0) {
            bArr2 = zzhzl.zza(bArr2, bArr4);
        }
        zzb(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
    }
}
