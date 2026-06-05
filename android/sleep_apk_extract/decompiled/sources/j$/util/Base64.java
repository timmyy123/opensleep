package j$.util;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
/* JADX INFO: loaded from: classes2.dex */
public class Base64 {

    /* JADX INFO: compiled from: r8-map-id-95537330f69b202a4035b5b884a891be1388aa78d91a250b52eaf3a913c20e9b */
    public static class Encoder {
        public static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        public static final char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        public static final Encoder d = new Encoder(false);
        public static final Encoder e = new Encoder(true);
        public final boolean a;

        public Encoder(boolean z) {
            this.a = z;
        }

        public String encodeToString(byte[] bArr) {
            byte[] bArr2 = bArr;
            int length = ((bArr2.length + 2) / 3) * 4;
            byte[] bArrCopyOf = new byte[length];
            int length2 = bArr2.length;
            char[] cArr = b;
            char[] cArr2 = c;
            boolean z = this.a;
            char[] cArr3 = z ? cArr2 : cArr;
            int i = (length2 / 3) * 3;
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int iMin = Math.min(i2 + i, i);
                char[] cArr4 = z ? cArr2 : cArr;
                int i4 = i2;
                int i5 = i3;
                while (i4 < iMin) {
                    int i6 = i4 + 2;
                    int i7 = ((bArr[i4 + 1] & 255) << 8) | ((bArr2[i4] & 255) << 16);
                    i4 += 3;
                    int i8 = i7 | (bArr[i6] & 255);
                    bArrCopyOf[i5] = (byte) cArr4[(i8 >>> 18) & 63];
                    bArrCopyOf[i5 + 1] = (byte) cArr4[(i8 >>> 12) & 63];
                    int i9 = i5 + 3;
                    bArrCopyOf[i5 + 2] = (byte) cArr4[(i8 >>> 6) & 63];
                    i5 += 4;
                    bArrCopyOf[i9] = (byte) cArr4[i8 & 63];
                    bArr2 = bArr;
                }
                int i10 = ((iMin - i2) / 3) * 4;
                i3 += i10;
                if (i10 == -1 && iMin < length2) {
                    throw null;
                }
                bArr2 = bArr;
                i2 = iMin;
            }
            if (i2 < length2) {
                int i11 = i2 + 1;
                int i12 = bArr[i2] & 255;
                int i13 = i3 + 1;
                bArrCopyOf[i3] = (byte) cArr3[i12 >> 2];
                if (i11 == length2) {
                    bArrCopyOf[i13] = (byte) cArr3[(i12 << 4) & 63];
                    int i14 = i3 + 3;
                    bArrCopyOf[i3 + 2] = 61;
                    i3 += 4;
                    bArrCopyOf[i14] = 61;
                } else {
                    int i15 = bArr[i11] & 255;
                    bArrCopyOf[i13] = (byte) cArr3[((i12 << 4) & 63) | (i15 >> 4)];
                    int i16 = i3 + 3;
                    bArrCopyOf[i3 + 2] = (byte) cArr3[(i15 << 2) & 63];
                    i3 += 4;
                    bArrCopyOf[i16] = 61;
                }
            }
            if (i3 != length) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3);
            }
            return new String(bArrCopyOf, 0, 0, bArrCopyOf.length);
        }
    }

    public static Encoder getEncoder() {
        return Encoder.d;
    }

    public static Encoder getUrlEncoder() {
        return Encoder.e;
    }
}
