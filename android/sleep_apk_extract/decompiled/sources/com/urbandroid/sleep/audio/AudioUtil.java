package com.urbandroid.sleep.audio;

/* JADX INFO: loaded from: classes.dex */
public abstract class AudioUtil {
    public static byte[] toByte(float[] fArr) {
        int length = fArr.length;
        byte[] bArr = new byte[fArr.length * 2];
        int i = 0;
        int i2 = 0;
        while (i != length) {
            short s = (short) (fArr[i] * 32767.0f);
            bArr[i2] = (byte) (s & 255);
            bArr[i2 + 1] = (byte) ((s & 65280) >> 8);
            i++;
            i2 += 2;
        }
        return bArr;
    }
}
