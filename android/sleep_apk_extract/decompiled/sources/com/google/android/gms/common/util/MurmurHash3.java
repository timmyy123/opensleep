package com.google.android.gms.common.util;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MurmurHash3 {
    public static int murmurhash3_x86_32(byte[] bArr, int i, int i2, int i3) {
        int i4;
        int i5 = i;
        while (true) {
            i4 = (i2 & (-4)) + i;
            if (i5 >= i4) {
                break;
            }
            int i6 = ((bArr[i5] & PHIpAddressSearchManager.END_IP_SCAN) | ((bArr[i5 + 1] & PHIpAddressSearchManager.END_IP_SCAN) << 8) | ((bArr[i5 + 2] & PHIpAddressSearchManager.END_IP_SCAN) << 16) | (bArr[i5 + 3] << 24)) * (-862048943);
            int i7 = i3 ^ (((i6 >>> 17) | (i6 << 15)) * 461845907);
            i3 = (((i7 >>> 19) | (i7 << 13)) * 5) - 430675100;
            i5 += 4;
        }
        int i8 = i2 & 3;
        if (i8 == 1) {
            int i9 = ((bArr[i4] & PHIpAddressSearchManager.END_IP_SCAN) | i) * (-862048943);
            i3 ^= ((i9 >>> 17) | (i9 << 15)) * 461845907;
        } else {
            if (i8 != 2) {
                i = i8 == 3 ? (bArr[i4 + 2] & PHIpAddressSearchManager.END_IP_SCAN) << 16 : 0;
            }
            i |= (bArr[i4 + 1] & PHIpAddressSearchManager.END_IP_SCAN) << 8;
            int i92 = ((bArr[i4] & PHIpAddressSearchManager.END_IP_SCAN) | i) * (-862048943);
            i3 ^= ((i92 >>> 17) | (i92 << 15)) * 461845907;
        }
        int i10 = i3 ^ i2;
        int i11 = (i10 ^ (i10 >>> 16)) * (-2048144789);
        int i12 = (i11 ^ (i11 >>> 13)) * (-1028477387);
        return i12 ^ (i12 >>> 16);
    }
}
