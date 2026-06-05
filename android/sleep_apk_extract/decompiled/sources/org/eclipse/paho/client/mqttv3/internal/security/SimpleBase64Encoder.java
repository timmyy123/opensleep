package org.eclipse.paho.client.mqttv3.internal.security;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleBase64Encoder {
    private static final char[] PWDCHARS_ARRAY = {'.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final String PWDCHARS_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[(length * 3) / 4];
        int i = 0;
        int i2 = 0;
        while (true) {
            if (length < 4) {
                break;
            }
            long jFrom64 = from64(bytes, i, 4);
            length -= 4;
            i += 4;
            for (int i3 = 2; i3 >= 0; i3--) {
                bArr[i2 + i3] = (byte) (jFrom64 & 255);
                jFrom64 >>= 8;
            }
            i2 += 3;
        }
        if (length == 3) {
            long jFrom642 = from64(bytes, i, 3);
            for (int i4 = 1; i4 >= 0; i4--) {
                bArr[i2 + i4] = (byte) (jFrom642 & 255);
                jFrom642 >>= 8;
            }
        }
        if (length == 2) {
            bArr[i2] = (byte) (from64(bytes, i, 2) & 255);
        }
        return bArr;
    }

    public static String encode(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(((length + 2) / 3) * 4);
        int i = 0;
        while (length >= 3) {
            stringBuffer.append(to64(((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255), 4));
            i += 3;
            length -= 3;
        }
        if (length == 2) {
            stringBuffer.append(to64(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255), 3));
        }
        if (length == 1) {
            stringBuffer.append(to64(bArr[i] & 255, 2));
        }
        return stringBuffer.toString();
    }

    private static final long from64(byte[] bArr, int i, int i2) {
        int i3 = 0;
        long j = 0;
        while (i2 > 0) {
            i2--;
            int i4 = i + 1;
            byte b = bArr[i];
            long j2 = b == 47 ? 1L : 0L;
            if (b >= 48 && b <= 57) {
                j2 = b - 46;
            }
            if (b >= 65 && b <= 90) {
                j2 = b - 53;
            }
            if (b >= 97 && b <= 122) {
                j2 = b - 59;
            }
            j += j2 << i3;
            i3 += 6;
            i = i4;
        }
        return j;
    }

    private static final String to64(long j, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        while (i > 0) {
            i--;
            stringBuffer.append(PWDCHARS_ARRAY[(int) (63 & j)]);
            j >>= 6;
        }
        return stringBuffer.toString();
    }
}
