package com.google.android.gms.internal.ads;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes3.dex */
public final class zzghc {
    private final byte[] zza = new byte[256];
    private int zzb;
    private int zzc;

    public zzghc(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zza[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zza;
            byte b = bArr2[i3];
            i2 = (i2 + b + bArr[i3 % bArr.length]) & PHIpAddressSearchManager.END_IP_SCAN;
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i = this.zzb;
        int i2 = this.zzc;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zza;
            i = (i + 1) & PHIpAddressSearchManager.END_IP_SCAN;
            byte b = bArr2[i];
            i2 = (i2 + b) & PHIpAddressSearchManager.END_IP_SCAN;
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + b) & PHIpAddressSearchManager.END_IP_SCAN] ^ bArr[i3]);
        }
        this.zzb = i;
        this.zzc = i2;
    }
}
