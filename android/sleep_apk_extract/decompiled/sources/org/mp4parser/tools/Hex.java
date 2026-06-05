package org.mp4parser.tools;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Hex {
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String encodeHex(byte[] bArr, int i) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1) + (i > 0 ? length / i : 0)];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i > 0 && i3 % i == 0 && i2 > 0) {
                cArr[i2] = '-';
                i2++;
            }
            int i4 = i2 + 1;
            char[] cArr2 = DIGITS;
            byte b = bArr[i3];
            cArr[i2] = cArr2[(b & 240) >>> 4];
            i2 += 2;
            cArr[i4] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static String encodeHex(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        StringBuilder sb = new StringBuilder();
        while (byteBufferDuplicate.remaining() > 0) {
            byte b = byteBufferDuplicate.get();
            char[] cArr = DIGITS;
            sb.append(cArr[(b & 240) >>> 4]);
            sb.append(cArr[b & 15]);
        }
        return sb.toString();
    }

    public static String encodeHex(byte[] bArr) {
        return encodeHex(bArr, 0);
    }
}
