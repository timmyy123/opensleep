package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
abstract class BigendianEncoding {
    private static final char[] ENCODING = buildEncodingArray();
    private static final byte[] DECODING = buildDecodingArray();

    private static byte[] buildDecodingArray() {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i = 0; i < 16; i++) {
            bArr["0123456789abcdef".charAt(i)] = (byte) i;
        }
        return bArr;
    }

    private static char[] buildEncodingArray() {
        char[] cArr = new char[512];
        for (int i = 0; i < 256; i++) {
            cArr[i] = "0123456789abcdef".charAt(i >>> 4);
            cArr[i | 256] = "0123456789abcdef".charAt(i & 15);
        }
        return cArr;
    }

    private static void byteToBase16(byte b, char[] cArr, int i) {
        int i2 = b & 255;
        char[] cArr2 = ENCODING;
        cArr[i] = cArr2[i2];
        cArr[i + 1] = cArr2[i2 | 256];
    }

    public static void longToBase16String(long j, char[] cArr, int i) {
        byteToBase16((byte) ((j >> 56) & 255), cArr, i);
        byteToBase16((byte) ((j >> 48) & 255), cArr, i + 2);
        byteToBase16((byte) ((j >> 40) & 255), cArr, i + 4);
        byteToBase16((byte) ((j >> 32) & 255), cArr, i + 6);
        byteToBase16((byte) ((j >> 24) & 255), cArr, i + 8);
        byteToBase16((byte) ((j >> 16) & 255), cArr, i + 10);
        byteToBase16((byte) ((j >> 8) & 255), cArr, i + 12);
        byteToBase16((byte) (j & 255), cArr, i + 14);
    }

    public static void longToByteArray(long j, byte[] bArr, int i) {
        Utils.checkArgument(bArr.length >= i + 8, "array too small");
        bArr[i + 7] = (byte) (j & 255);
        bArr[i + 6] = (byte) ((j >> 8) & 255);
        bArr[i + 5] = (byte) ((j >> 16) & 255);
        bArr[i + 4] = (byte) ((j >> 24) & 255);
        bArr[i + 3] = (byte) ((j >> 32) & 255);
        bArr[i + 2] = (byte) ((j >> 40) & 255);
        bArr[i + 1] = (byte) ((j >> 48) & 255);
        bArr[i] = (byte) ((j >> 56) & 255);
    }
}
