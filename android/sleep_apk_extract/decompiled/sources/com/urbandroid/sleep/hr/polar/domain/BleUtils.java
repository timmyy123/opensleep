package com.urbandroid.sleep.hr.polar.domain;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class BleUtils {
    public static int convertArrayToSignedInt(byte[] bArr, int i, int i2) {
        int iConvertArrayToUnsignedLong = (int) convertArrayToUnsignedLong(bArr, i, i2);
        return (bArr[(i + i2) + (-1)] & 128) != 0 ? ((-1) << (i2 * 8)) | iConvertArrayToUnsignedLong : iConvertArrayToUnsignedLong;
    }

    public static int convertArrayToUnsignedInt(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 |= (bArr[i4 + i] & PHIpAddressSearchManager.END_IP_SCAN) << (i4 * 8);
        }
        return i3;
    }

    public static long convertArrayToUnsignedLong(byte[] bArr, int i, int i2) {
        long j = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j |= (((long) bArr[i3 + i]) & 255) << (i3 * 8);
        }
        return j;
    }

    public static void validate(boolean z, String str) {
        if (z) {
            return;
        }
        Types$$ExternalSyntheticBUOutline0.m$2(str);
    }
}
