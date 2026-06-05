package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.extractor.metadata.emsg.EventMessage;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1736m6 implements H9 {
    public static byte[] A0e;
    public static String[] A0f = {"ywSCwlzG1SMdvvW", "WbYO2rYjmhbf4R3oYDPvQZ3H98amgjSr", "Za", "aa8pMmtLKrvpWkukTfymetmlHniL9M", "752FE5aLUbaesINptKDix8v", "1m6bsNbzXuacY99BBbBsLUDHw0asFdhp", "tFAwrqTGVJ2tUOf2i", "X0elgRXJnrwhMbXNAucG6j3nQ1B9k96A"};
    public static final HD A0g;
    public static final C1981qI A0h;
    public static final byte[] A0i;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public SparseArray<J7> A0D;
    public C02284v A0E;
    public HA A0F;
    public J7 A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public InterfaceC0528Hd[] A0K;
    public InterfaceC0528Hd[] A0L;
    public final int A0M;
    public final DrmInitData A0N;
    public final C02284v A0O;
    public final C02284v A0P;
    public final C02284v A0Q;
    public final C02284v A0R;
    public final C02284v A0S;
    public final AnonymousClass53 A0T;
    public final InterfaceC0528Hd A0U;
    public final I0 A0V;
    public final JO A0W;
    public final ArrayDeque<C1744mE> A0X;
    public final ArrayDeque<J6> A0Y;
    public final List<C1981qI> A0Z;
    public final boolean A0a;
    public final boolean A0b;
    public final boolean A0c;
    public final byte[] A0d;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(J7 j7, int i, long j, int i2, C02284v c02284v, int i3) {
        boolean z;
        long j2;
        int i4;
        int iA0L;
        int iA0C;
        int i5 = i3;
        long j3 = j;
        c02284v.A0f(8);
        int iA00 = AbstractC0570Iu.A00(c02284v.A0C());
        JO jo = j7.A05;
        JQ jq = j7.A07;
        J1 j1 = jq.A06;
        jq.A0C[i] = c02284v.A0L();
        jq.A0E[i] = jq.A04;
        if ((iA00 & 1) != 0) {
            long[] jArr = jq.A0E;
            String[] strArr = A0f;
            if (strArr[1].charAt(23) == strArr[5].charAt(23)) {
                A0f[2] = "02";
                jArr[i] = jArr[i] + ((long) c02284v.A0C());
                z = (iA00 & 4) == 0;
                int iA0L2 = j1.A01;
                if (z) {
                    iA0L2 = c02284v.A0L();
                }
                boolean z2 = (iA00 & 256) == 0;
                boolean z3 = (iA00 & 512) == 0;
                boolean z4 = (iA00 & 1024) == 0;
                boolean z5 = (iA00 & 2048) == 0;
                j2 = 0;
                if (jo.A08 != null && jo.A08.length == 1 && jo.A08[0] == 0) {
                    j2 = jo.A09[0];
                }
                int[] iArr = jq.A0B;
                long[] jArr2 = jq.A0D;
                boolean[] zArr = jq.A0G;
                boolean z6 = (jo.A03 == 2 || (i2 & 1) == 0) ? false : true;
                i4 = i5 + jq.A0C[i];
                long j4 = jo.A06;
                if (i > 0) {
                    j3 = jq.A05;
                }
                while (i5 < i4) {
                    int iA0L3 = z2 ? c02284v.A0L() : j1.A00;
                    if (z3) {
                        iA0L = c02284v.A0L();
                        String[] strArr2 = A0f;
                        if (strArr2[3].length() != strArr2[6].length()) {
                            String[] strArr3 = A0f;
                            strArr3[1] = "prYCRILb9XoLiqEuzjLvSymHGedE7tyJ";
                            strArr3[5] = "tQPxWhVMkiMqfE1WSn5JfVNHf8FlQpL7";
                        }
                    } else {
                        iA0L = j1.A03;
                    }
                    if (i5 == 0 && z) {
                        iA0C = iA0L2;
                    } else if (z4) {
                        iA0C = c02284v.A0C();
                    } else if (A0f[4].length() == 23) {
                        A0f[4] = "VUSN2W3IkwtruuiuKY2zNmE";
                        iA0C = j1.A01;
                    }
                    jArr2[i5] = C5C.A0U((((long) (z5 ? c02284v.A0C() : 0)) + j3) - j2, 1000000L, j4);
                    zArr[i5] = ((iA0C >> 16) & 1) == 0 && (!z6 || i5 == 0);
                    iArr[i5] = iA0L;
                    j3 += (long) iA0L3;
                    i5++;
                }
                jq.A05 = j3;
                return i4;
            }
        } else {
            if ((iA00 & 4) == 0) {
            }
            int iA0L22 = j1.A01;
            if (z) {
            }
            if ((iA00 & 256) == 0) {
            }
            if ((iA00 & 512) == 0) {
            }
            if ((iA00 & 1024) == 0) {
            }
            if ((iA00 & 2048) == 0) {
            }
            j2 = 0;
            if (jo.A08 != null) {
                j2 = jo.A09[0];
            }
            int[] iArr2 = jq.A0B;
            long[] jArr22 = jq.A0D;
            boolean[] zArr2 = jq.A0G;
            if (jo.A03 == 2) {
                i4 = i5 + jq.A0C[i];
                long j42 = jo.A06;
                if (i > 0) {
                }
                while (i5 < i4) {
                }
                jq.A05 = j3;
                return i4;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, C1777my> A04(C02284v c02284v, long j) throws C3K {
        long jA0R;
        long jA0R2;
        c02284v.A0f(8);
        int iA01 = AbstractC0570Iu.A01(c02284v.A0C());
        c02284v.A0g(4);
        long jA0Q = c02284v.A0Q();
        if (iA01 == 0) {
            jA0R = c02284v.A0Q();
            jA0R2 = j + c02284v.A0Q();
        } else {
            jA0R = c02284v.A0R();
            jA0R2 = j + c02284v.A0R();
        }
        long jA0U = C5C.A0U(jA0R, 1000000L, jA0Q);
        c02284v.A0g(2);
        int iA0M = c02284v.A0M();
        int[] iArr = new int[iA0M];
        long[] jArr = new long[iA0M];
        long[] jArr2 = new long[iA0M];
        long[] jArr3 = new long[iA0M];
        long jA0U2 = jA0U;
        for (int i = 0; i < iA0M; i++) {
            int iA0C = c02284v.A0C();
            if ((Integer.MIN_VALUE & iA0C) != 0) {
                throw new C3K(A0B(634, 28, 93));
            }
            long jA0Q2 = c02284v.A0Q();
            iArr[i] = Integer.MAX_VALUE & iA0C;
            jArr[i] = jA0R2;
            jArr3[i] = jA0U2;
            jA0R += jA0Q2;
            jA0U2 = C5C.A0U(jA0R, 1000000L, jA0Q);
            String[] strArr = A0f;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0f[7] = "mBjUzKzbBV9DJWZlH52EoviqXd7Fx3w7";
            jArr2[i] = jA0U2 - jArr3[i];
            c02284v.A0g(4);
            jA0R2 += (long) iArr[i];
        }
        return Pair.create(Long.valueOf(jA0U), new C1777my(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static J7 A09(C02284v c02284v, SparseArray<J7> sparseArray, boolean z) {
        c02284v.A0f(8);
        int iA00 = AbstractC0570Iu.A00(c02284v.A0C());
        J7 j7A08 = A08(sparseArray, c02284v.A0C(), z);
        if (j7A08 == null) {
            return null;
        }
        if ((iA00 & 1) != 0) {
            long jA0R = c02284v.A0R();
            j7A08.A07.A04 = jA0R;
            j7A08.A07.A03 = jA0R;
        }
        J1 j1 = j7A08.A04;
        j7A08.A07.A06 = new J1((iA00 & 2) != 0 ? c02284v.A0L() - 1 : j1.A02, (iA00 & 8) != 0 ? c02284v.A0L() : j1.A00, (iA00 & 16) != 0 ? c02284v.A0L() : j1.A03, (iA00 & 32) != 0 ? c02284v.A0L() : j1.A01);
        return j7A08;
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0e, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        String[] strArr = A0f;
        if (strArr[1].charAt(23) != strArr[5].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0f;
        strArr2[1] = "BGZmKOZPo9hBykc2GdFNUQpHC0I3sPv1";
        strArr2[5] = "CvUkm70dQ0grN9w1V6xWMg6HVylPciNL";
        A0e = new byte[]{84, 88, 95, 106, 113, 115, 62, 109, 119, 100, 123, 62, 114, 123, 109, 109, 62, 106, 118, 127, 112, 62, 118, 123, 127, 122, 123, 108, 62, 114, 123, 112, 121, 106, 118, 62, 54, 107, 112, 109, 107, 110, 110, 113, 108, 106, 123, 122, 55, 48, 99, 72, 82, 84, 95, 6, 69, 73, 83, 72, 82, 6, 79, 72, 6, 85, 68, 65, 86, 6, 7, 27, 6, 23, 6, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 83, 72, 85, 83, 86, 86, 73, 84, 82, 67, 66, 15, 8, 73, 98, 120, 126, 117, 44, 111, 99, 121, 98, 120, 44, 101, 98, 44, 127, 107, 124, 104, 44, 45, 49, 44, 61, 44, 36, 121, 98, 127, 121, 124, 124, 99, 126, 120, 105, 104, 37, 34, 104, 92, 79, 73, 67, 75, 64, 90, 75, 74, 99, 94, 26, 107, 86, 90, 92, 79, 77, 90, 65, 92, 57, 23, 30, 31, 2, 25, 30, 23, 80, 30, 21, 23, 17, 4, 25, 6, 21, 80, 31, 22, 22, 3, 21, 4, 80, 4, 31, 80, 3, 17, 29, 0, 28, 21, 80, 20, 17, 4, 17, 94, 116, 83, 75, 92, 81, 84, 89, 29, 115, 124, 113, 29, 81, 88, 83, 90, 73, 85, 113, 88, 92, 91, 29, 92, 73, 82, 80, 29, 89, 88, 91, 84, 83, 88, 78, 29, 88, 69, 73, 88, 83, 89, 88, 89, 29, 92, 73, 82, 80, 29, 78, 84, 71, 88, 29, 21, 72, 83, 78, 72, 77, 77, 82, 79, 73, 88, 89, 20, 19, 62, 23, 19, 20, 82, 19, 6, 29, 31, 82, 5, 27, 6, 26, 82, 30, 23, 28, 21, 6, 26, 82, 76, 82, 64, 67, 70, 69, 70, 74, 65, 68, 70, 69, 82, 90, 7, 28, 1, 7, 2, 2, 29, 0, 6, 23, 22, 91, 92, 2, 43, 32, 41, 58, 38, 110, 35, 39, 61, 35, 47, 58, 45, 38, 116, 110, 82, 123, 123, 110, 120, 105, 61, 105, 114, 61, 120, 115, 126, 111, 100, 109, 105, 116, 114, 115, 61, 121, 124, 105, 124, 61, 106, 124, 110, 61, 115, 120, 122, 124, 105, 116, 107, 120, 51, 123, 82, 82, 71, 81, 64, 20, 64, 91, 20, 81, 90, 80, 20, 91, 82, 20, 89, 80, 85, 64, 20, 67, 85, 71, 20, 90, 81, 83, 85, 64, 93, 66, 81, 26, 61, 4, 23, 0, 0, 27, 22, 27, 28, 21, 82, 38, 0, 19, 17, 25, 55, 28, 17, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 2, 6, 27, 29, 28, 48, 29, 10, 82, 2, 19, 0, 19, 31, 23, 6, 23, 0, 1, 82, 27, 1, 82, 7, 28, 1, 7, 2, 2, 29, 0, 6, 23, 22, 92, 84, 108, 110, 119, 119, 98, 99, 39, 119, 116, 116, 111, 39, 102, 115, 104, 106, 39, 47, 97, 102, 110, 107, 98, 99, 39, 115, 104, 39, 98, 127, 115, 117, 102, 100, 115, 39, 114, 114, 110, 99, 46, 60, 4, 6, 31, 31, 6, 1, 8, 79, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 27, 0, 2, 79, 24, 6, 27, 7, 79, 3, 10, 1, 8, 27, 7, 79, 81, 79, 93, 94, 91, 88, 91, 87, 92, 89, 91, 88, 79, 71, 26, 1, 28, 26, 31, 31, 0, 29, 27, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 70, 65, 79, 119, 117, 108, 108, 117, 114, 123, 60, 105, 114, 111, 105, 108, 108, 115, 110, 104, 121, 120, 60, 121, 113, 111, 123, 60, 106, 121, 110, 111, 117, 115, 114, 38, 60, 57, 2, 9, 20, 28, 9, 15, 24, 9, 8, 76, 1, 3, 3, 26, 76, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 3, 20, 66, 71, 124, 119, 106, 98, 119, 113, 102, 119, 118, 50, 97, 115, 123, 125, 50, 119, 124, 102, 96, 107, 50, 113, 125, 103, 124, 102, 40, 50, 107, 80, 86, 95, 80, 90, 82, 91, 90, 30, 87, 80, 90, 87, 76, 91, 93, 74, 30, 76, 91, 88, 91, 76, 91, 80, 93, 91, 107, 92, 79, 84, 92, 95, 81, 88, 29, 81, 88, 83, 90, 73, 85, 29, 89, 88, 78, 94, 79, 84, 77, 73, 84, 82, 83, 29, 84, 83, 29, 78, 90, 77, 89, 29, 91, 82, 72, 83, 89, 29, 21, 72, 83, 78, 72, 77, 77, 82, 79, 73, 88, 89, 20, 83, 66, 66, 94, 91, 81, 83, 70, 91, 93, 92, 29, 74, 31, 87, 95, 65, 85, 66, 83, 83, 79, 74, 64, 66, 87, 74, 76, 77, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 91, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 78, 83, 23, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 85, 87, 87, 70, 89, 84, 85, 95, 31, 88, 85, 70, 83, 40, 55, 58, 59, 49, 113, 51, 46, 106};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0I(C02284v c02284v, Uri uri) {
        String str;
        String str2;
        long jA05;
        long jA0U;
        long jA0Q;
        if (this.A0L == null || this.A0L.length == 0) {
            return;
        }
        c02284v.A0f(8);
        int iA01 = AbstractC0570Iu.A01(c02284v.A0C());
        long jA0U2 = -9223372036854775807L;
        switch (iA01) {
            case 0:
                str = (String) AbstractC02053y.A01(c02284v.A0U());
                str2 = (String) AbstractC02053y.A01(c02284v.A0U());
                if (A0f[2].length() != 2) {
                    throw new RuntimeException();
                }
                A0f[0] = "4yWaL9iFGGaDiXT";
                long jA0Q2 = c02284v.A0Q();
                jA0U2 = C5C.A0U(c02284v.A0Q(), 1000000L, jA0Q2);
                jA05 = this.A0C != -9223372036854775807L ? this.A0C + jA0U2 : -9223372036854775807L;
                jA0U = C5C.A0U(c02284v.A0Q(), 1000L, jA0Q2);
                jA0Q = c02284v.A0Q();
                break;
                break;
            case 1:
                long jA0Q3 = c02284v.A0Q();
                jA05 = C5C.A0U(c02284v.A0R(), 1000000L, jA0Q3);
                jA0U = C5C.A0U(c02284v.A0Q(), 1000L, jA0Q3);
                jA0Q = c02284v.A0Q();
                str = (String) AbstractC02053y.A01(c02284v.A0U());
                str2 = (String) AbstractC02053y.A01(c02284v.A0U());
                break;
            default:
                AbstractC02134g.A07(A0B(128, 22, 77), A0B(550, 35, 127) + iA01);
                return;
        }
        byte[] bArr = new byte[c02284v.A07()];
        c02284v.A0k(bArr, 0, c02284v.A07());
        int i = 0;
        C02284v c02284v2 = new C02284v(this.A0V.A01(new EventMessage(str, str2, jA0U, jA0Q, bArr)));
        int iA07 = c02284v2.A07();
        InterfaceC0528Hd[] interfaceC0528HdArr = this.A0L;
        int length = interfaceC0528HdArr.length;
        int i2 = 0;
        while (i2 < length) {
            InterfaceC0528Hd interfaceC0528Hd = interfaceC0528HdArr[i2];
            c02284v2.A0f(i);
            interfaceC0528Hd.AKf(uri);
            interfaceC0528Hd.AIr(c02284v2, iA07);
            i2++;
            i = 0;
        }
        if (jA05 == -9223372036854775807L) {
            this.A0Y.addLast(new J6(jA0U2, iA07));
            this.A03 += iA07;
            return;
        }
        if (this.A0T != null) {
            jA05 = this.A0T.A05(jA05);
        }
        if (this.A0b && this.A0A != -9223372036854775807L) {
            jA05 = this.A0A;
        }
        for (InterfaceC0528Hd interfaceC0528Hd2 : this.A0L) {
            interfaceC0528Hd2.AIu(jA05, 1, iA07, 0, null);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0J(C02284v c02284v, C02284v c02284v2, String str, JQ jq) throws C3K {
        c02284v.A0f(8);
        int iA0C = c02284v.A0C();
        if (c02284v.A0C() != 1936025959) {
            return;
        }
        int iA01 = AbstractC0570Iu.A01(iA0C);
        if (A0f[2].length() != 2) {
            throw new RuntimeException();
        }
        A0f[0] = "QrVDtjxvyixdHPq";
        if (iA01 == 1) {
            c02284v.A0g(4);
        }
        if (c02284v.A0C() != 1) {
            throw new C3K(A0B(50, 39, 69));
        }
        c02284v2.A0f(8);
        int iA0C2 = c02284v2.A0C();
        if (c02284v2.A0C() != 1936025959) {
            return;
        }
        int iA012 = AbstractC0570Iu.A01(iA0C2);
        if (iA012 == 1) {
            if (c02284v2.A0Q() == 0) {
                throw new C3K(A0B(662, 55, 94));
            }
        } else if (iA012 >= 2) {
            c02284v2.A0g(4);
        }
        if (c02284v2.A0Q() != 1) {
            throw new C3K(A0B(89, 39, 111));
        }
        c02284v2.A0g(1);
        int iA0I = c02284v2.A0I();
        int i = (iA0I & 240) >> 4;
        int i2 = iA0I & 15;
        boolean z = c02284v2.A0I() == 1;
        if (z) {
            int iA0I2 = c02284v2.A0I();
            byte[] bArr = new byte[16];
            c02284v2.A0k(bArr, 0, bArr.length);
            byte[] bArr2 = null;
            if (iA0I2 == 0) {
                int iA0I3 = c02284v2.A0I();
                bArr2 = new byte[iA0I3];
                c02284v2.A0k(bArr2, 0, iA0I3);
            }
            jq.A08 = true;
            jq.A07 = new JP(z, str, iA0I2, bArr, i, i2, bArr2);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0R(C1744mE c1744mE) throws C3K {
        AbstractC02053y.A0A(this.A0W == null, A0B(585, 20, 15));
        DrmInitData drmInitDataA05 = A05(c1744mE.A02);
        C1744mE c1744mE2 = (C1744mE) AbstractC02053y.A01(c1744mE.A06(1836475768));
        SparseArray<J1> sparseArray = new SparseArray<>();
        long jA01 = -9223372036854775807L;
        int size = c1744mE2.A02.size();
        int i = 0;
        while (true) {
            if (i < size) {
                C1743mD c1743mD = c1744mE2.A02.get(i);
                if (((AbstractC0570Iu) c1743mD).A00 == 1953654136) {
                    Pair<Integer, J1> pairA03 = A03(c1743mD.A00);
                    int iIntValue = ((Integer) pairA03.first).intValue();
                    Object obj = pairA03.second;
                    if (A0f[7].charAt(29) == '0') {
                        break;
                    }
                    A0f[0] = "KUxAVqQLzsv7ujT";
                    sparseArray.put(iIntValue, (J1) obj);
                } else {
                    int i2 = ((AbstractC0570Iu) c1743mD).A00;
                    if (A0f[7].charAt(29) != '0') {
                        A0f[2] = "EA";
                        if (i2 == 1835362404) {
                            jA01 = A01(c1743mD.A00);
                        }
                    } else {
                        String[] strArr = A0f;
                        strArr[3] = "P1l2XCTjN0GLzwkC984rH7zDpCyyqZ";
                        strArr[6] = "39xRaNo9QFkrA6tLq";
                        if (i2 == 237072518) {
                        }
                    }
                }
                i++;
            } else {
                SparseArray sparseArray2 = new SparseArray();
                int size2 = c1744mE.A01.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C1744mE c1744mE3 = c1744mE.A01.get(i3);
                    if (((AbstractC0570Iu) c1744mE3).A00 == 1953653099) {
                        JO joA0A = A0A(J0.A0J(c1744mE3, c1744mE.A07(1836476516), jA01, drmInitDataA05, (this.A0M & 16) != 0, false));
                        if (joA0A != null) {
                            sparseArray2.put(joA0A.A00, joA0A);
                        }
                    }
                }
                int size3 = sparseArray2.size();
                if (this.A0D.size() != 0) {
                    AbstractC02053y.A08(this.A0D.size() == size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        JO jo = (JO) sparseArray2.valueAt(i4);
                        this.A0D.get(jo.A00).A08(jo, A06(sparseArray, jo.A00));
                    }
                    return;
                }
                for (int i5 = 0; i5 < size3; i5++) {
                    JO jo2 = (JO) sparseArray2.valueAt(i5);
                    J7 j7 = new J7(this.A0F.AKS(i5, jo2.A03));
                    j7.A08(jo2, A06(sparseArray, jo2.A00));
                    this.A0D.put(jo2.A00, j7);
                    this.A08 = Math.max(this.A08, jo2.A04);
                }
                A0D();
                HA ha = this.A0F;
                if (A0f[7].charAt(29) != '0') {
                    String[] strArr2 = A0f;
                    strArr2[3] = "NZTZhjA83sW4NrmiIOwSslFR5UdjBx";
                    strArr2[6] = "jWtg8I2sGrLmtghr5";
                    ha.A6O();
                    return;
                }
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[PHI: r0 r3
      0x006a: PHI (r0v33 com.facebook.ads.redexgen.X.mD) = (r0v12 com.facebook.ads.redexgen.X.mD), (r0v38 com.facebook.ads.redexgen.X.mD) binds: [B:43:0x0106, B:17:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r3v6 com.facebook.ads.redexgen.X.JP) = (r3v1 com.facebook.ads.redexgen.X.JP), (r3v7 com.facebook.ads.redexgen.X.JP) binds: [B:43:0x0106, B:17:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0T(C1744mE c1744mE, SparseArray<J7> sparseArray, int i, byte[] bArr, boolean z) throws C3K {
        JP jpA00;
        C1743mD c1743mDA07;
        J7 j7A09 = A09(c1744mE.A07(1952868452).A00, sparseArray, z);
        if (j7A09 == null) {
            return;
        }
        JQ jq = j7A09.A07;
        long jA02 = jq.A05;
        j7A09.A05();
        if (c1744mE.A07(1952867444) != null) {
            int i2 = i & 2;
            if (A0f[0].length() != 15) {
                throw new RuntimeException();
            }
            A0f[4] = "8CfIIEomKXR2z1rzEceKdGz";
            if (i2 == 0) {
                jA02 = A02(c1744mE.A07(1952867444).A00);
            }
        }
        A0U(c1744mE, j7A09, jA02, i);
        JO jo = j7A09.A05;
        if (A0f[2].length() != 2) {
            jpA00 = jo.A00(jq.A06.A02);
            c1743mDA07 = c1744mE.A07(1935763834);
            if (c1743mDA07 != null) {
                A0W(jpA00, c1743mDA07.A00, jq);
            }
        } else {
            String[] strArr = A0f;
            strArr[1] = "KgLNgt4jXc3ey27lHSoy2KaHmXxTtgSL";
            strArr[5] = "0TnPqkkfx8cOSuGK7tHkJ8yHXf83oy0i";
            jpA00 = jo.A00(jq.A06.A02);
            c1743mDA07 = c1744mE.A07(1935763834);
            if (c1743mDA07 != null) {
            }
        }
        C1743mD c1743mDA072 = c1744mE.A07(1935763823);
        if (c1743mDA072 != null) {
            C02284v c02284v = c1743mDA072.A00;
            if (A0f[7].charAt(29) != '0') {
                A0f[2] = "tW";
                A0K(c02284v, jq);
            } else {
                A0f[0] = "kXc0iULHRQw05uA";
                A0K(c02284v, jq);
            }
        }
        C1743mD c1743mDA073 = c1744mE.A07(1936027235);
        if (c1743mDA073 != null) {
            A0L(c1743mDA073.A00, jq);
        }
        C1743mD c1743mDA074 = c1744mE.A07(1935828848);
        C1743mD c1743mDA075 = c1744mE.A07(1936158820);
        if (c1743mDA074 != null && c1743mDA075 != null) {
            A0J(c1743mDA074.A00, c1743mDA075.A00, jpA00 != null ? jpA00.A02 : null, jq);
        }
        int size = c1744mE.A02.size();
        for (int i3 = 0; i3 < size; i3++) {
            C1743mD c1743mD = c1744mE.A02.get(i3);
            if (((AbstractC0570Iu) c1743mD).A00 == 1970628964) {
                A0M(c1743mD.A00, jq, bArr);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0W(JP jp, C02284v c02284v, JQ jq) throws C3K {
        int i = jp.A00;
        c02284v.A0f(8);
        if ((AbstractC0570Iu.A00(c02284v.A0C()) & 1) == 1) {
            c02284v.A0g(8);
        }
        int iA0I = c02284v.A0I();
        int iA0L = c02284v.A0L();
        if (iA0L != jq.A00) {
            throw new C3K(A0B(308, 17, 45) + iA0L + A0B(0, 2, 27) + jq.A00);
        }
        int i2 = 0;
        if (iA0I == 0) {
            boolean[] zArr = jq.A0F;
            for (int i3 = 0; i3 < iA0L; i3++) {
                int iA0I2 = c02284v.A0I();
                i2 += iA0I2;
                zArr[i3] = iA0I2 > i;
            }
        } else {
            i2 = 0 + (iA0I * iA0L);
            Arrays.fill(jq.A0F, 0, iA0L, iA0I > i);
        }
        jq.A02(i2);
    }

    static {
        A0E();
        A0g = new HD() { // from class: com.facebook.ads.redexgen.X.mA
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C1736m6.A0b();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
        A0i = new byte[]{-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
        A0h = new C01722p().A11(A0B(717, 18, 81)).A14();
    }

    public C1736m6() {
        this(0);
    }

    public C1736m6(int i) {
        this(i, null);
    }

    public C1736m6(int i, AnonymousClass53 anonymousClass53) {
        this(i, anonymousClass53, null, null);
    }

    public C1736m6(int i, AnonymousClass53 anonymousClass53, JO jo, DrmInitData drmInitData) {
        this(i, anonymousClass53, jo, drmInitData, Collections.emptyList());
    }

    public C1736m6(int i, AnonymousClass53 anonymousClass53, JO jo, DrmInitData drmInitData, List<C1981qI> list) {
        this(i, anonymousClass53, jo, drmInitData, list, null, false, false, false);
    }

    public C1736m6(int i, AnonymousClass53 anonymousClass53, JO jo, DrmInitData drmInitData, List<C1981qI> list, InterfaceC0528Hd interfaceC0528Hd, boolean z, boolean z2, boolean z3) {
        this.A0A = -9223372036854775807L;
        this.A0M = (jo != null ? 8 : 0) | i;
        this.A0T = anonymousClass53;
        this.A0W = jo;
        this.A0N = drmInitData;
        this.A0Z = Collections.unmodifiableList(list);
        this.A0U = interfaceC0528Hd;
        this.A0c = z;
        this.A0b = z2;
        this.A0a = z3;
        this.A0V = new I0();
        this.A0O = new C02284v(16);
        this.A0R = new C02284v(HS.A03);
        this.A0Q = new C02284v(5);
        this.A0P = new C02284v();
        this.A0d = new byte[16];
        this.A0S = new C02284v(this.A0d);
        this.A0X = new ArrayDeque<>();
        this.A0Y = new ArrayDeque<>();
        this.A0D = new SparseArray<>();
        this.A08 = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        this.A0C = -9223372036854775807L;
        A0C();
    }

    public static long A01(C02284v c02284v) {
        c02284v.A0f(8);
        int fullAtom = c02284v.A0C();
        return AbstractC0570Iu.A01(fullAtom) == 0 ? c02284v.A0Q() : c02284v.A0R();
    }

    public static long A02(C02284v c02284v) {
        c02284v.A0f(8);
        int fullAtom = c02284v.A0C();
        int version = AbstractC0570Iu.A01(fullAtom);
        return version == 1 ? c02284v.A0R() : c02284v.A0Q();
    }

    public static Pair<Integer, J1> A03(C02284v c02284v) {
        c02284v.A0f(12);
        int defaultSampleDescriptionIndex = c02284v.A0C();
        int trackId = c02284v.A0L();
        int defaultSampleFlags = c02284v.A0L();
        int defaultSampleSize = c02284v.A0L();
        int defaultSampleDuration = c02284v.A0C();
        return Pair.create(Integer.valueOf(defaultSampleDescriptionIndex), new J1(trackId - 1, defaultSampleFlags, defaultSampleSize, defaultSampleDuration));
    }

    public static DrmInitData A05(List<C1743mD> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C1743mD c1743mD = list.get(i);
            int leafChildrenSize = A0f[4].length();
            if (leafChildrenSize != 23) {
                throw new RuntimeException();
            }
            A0f[0] = "gRucWkmmr3YeQcV";
            C1743mD c1743mD2 = c1743mD;
            int leafChildrenSize2 = ((AbstractC0570Iu) c1743mD2).A00;
            if (leafChildrenSize2 == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = c1743mD2.A00.A00;
                UUID uuidA02 = JH.A02(bArr);
                if (uuidA02 == null) {
                    AbstractC02134g.A07(A0B(128, 22, 77), A0B(455, 42, 100));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA02, A0B(766, 9, 61), bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private J1 A06(SparseArray<J1> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (J1) AbstractC02053y.A01(sparseArray.get(i));
    }

    public static J7 A07(SparseArray<J7> sparseArray) {
        J7 j7 = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            J7 j7ValueAt = sparseArray.valueAt(i);
            if (j7ValueAt.A02 != j7ValueAt.A07.A01) {
                long nextTrackRunOffset = j7ValueAt.A07.A0E[j7ValueAt.A02];
                if (nextTrackRunOffset < j) {
                    j7 = j7ValueAt;
                    j = nextTrackRunOffset;
                }
            }
        }
        return j7;
    }

    public static J7 A08(SparseArray<J7> sparseArray, int i, boolean z) {
        if (sparseArray.size() == 1 && !z) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i);
    }

    private final JO A0A(JO jo) {
        return jo;
    }

    private void A0C() {
        this.A02 = 0;
        this.A00 = 0;
    }

    /* JADX WARN: Incorrect condition in loop: B:21:0x007e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0D() {
        if (this.A0L == null) {
            this.A0L = new InterfaceC0528Hd[2];
            int i = 0;
            if (this.A0U != null) {
                this.A0L[0] = this.A0U;
                i = 0 + 1;
            }
            int emsgTrackOutputCount = this.A0M;
            if ((emsgTrackOutputCount & 4) != 0) {
                InterfaceC0528Hd[] interfaceC0528HdArr = this.A0L;
                int i2 = i + 1;
                if (A0f[7].charAt(29) == '0') {
                    throw new RuntimeException();
                }
                String[] strArr = A0f;
                strArr[1] = "2Ynf6gmdLfe6xE9EEWKUzFfHKl41sL7a";
                strArr[5] = "AN0qqeacVBgpTr6ZS3JdezHHRUzhKU8l";
                interfaceC0528HdArr[i] = this.A0F.AKS(this.A0D.size(), 5);
                i = i2;
            }
            this.A0L = (InterfaceC0528Hd[]) Arrays.copyOf(this.A0L, i);
            for (InterfaceC0528Hd interfaceC0528Hd : this.A0L) {
                interfaceC0528Hd.A6e(A0h);
            }
        }
        if (this.A0K == null) {
            this.A0K = new InterfaceC0528Hd[this.A0Z.size()];
            for (int i3 = 0; i3 < i; i3++) {
                HA ha = this.A0F;
                int i4 = this.A0D.size();
                InterfaceC0528Hd output = ha.AKS(i4 + 1 + i3, 3);
                output.A6e(this.A0Z.get(i3));
                this.A0K[i3] = output;
            }
        }
    }

    private void A0F(long j) {
        while (!this.A0Y.isEmpty()) {
            J6 j6RemoveFirst = this.A0Y.removeFirst();
            this.A03 -= j6RemoveFirst.A00;
            long jA05 = j + j6RemoveFirst.A01;
            if (this.A0T != null) {
                jA05 = this.A0T.A05(jA05);
            }
            for (InterfaceC0528Hd interfaceC0528Hd : this.A0L) {
                interfaceC0528Hd.AIu(jA05, 1, j6RemoveFirst.A00, this.A03, null);
            }
        }
    }

    private void A0G(long j) throws C3K {
        while (!this.A0X.isEmpty() && this.A0X.peek().A00 == j) {
            A0P(this.A0X.pop());
        }
        A0C();
    }

    public static void A0H(C02284v c02284v, int i, JQ jq) throws C3K {
        c02284v.A0f(i + 8);
        int fullAtom = c02284v.A0C();
        int flags = AbstractC0570Iu.A00(fullAtom);
        int fullAtom2 = flags & 1;
        if (fullAtom2 == 0) {
            int fullAtom3 = flags & 2;
            boolean z = fullAtom3 != 0;
            int sampleCount = c02284v.A0L();
            int fullAtom4 = jq.A00;
            if (sampleCount == fullAtom4) {
                Arrays.fill(jq.A0F, 0, sampleCount, z);
                int fullAtom5 = c02284v.A07();
                jq.A02(fullAtom5);
                jq.A04(c02284v);
                return;
            }
            StringBuilder sbAppend = new StringBuilder().append(A0B(308, 17, 45)).append(sampleCount).append(A0B(0, 2, 27));
            int fullAtom6 = jq.A00;
            throw new C3K(sbAppend.append(fullAtom6).toString());
        }
        throw new C3K(A0B(399, 56, 17));
    }

    public static void A0K(C02284v c02284v, JQ jq) throws C3K {
        c02284v.A0f(8);
        int flags = c02284v.A0C();
        int fullAtom = AbstractC0570Iu.A00(flags) & 1;
        if (fullAtom == 1) {
            c02284v.A0g(8);
        }
        int iA0L = c02284v.A0L();
        if (iA0L == 1) {
            int entryCount = AbstractC0570Iu.A01(flags);
            jq.A03 += entryCount == 0 ? c02284v.A0Q() : c02284v.A0R();
            return;
        }
        throw new C3K(A0B(605, 29, 113) + iA0L);
    }

    public static void A0L(C02284v c02284v, JQ jq) throws C3K {
        A0H(c02284v, 0, jq);
    }

    public static void A0M(C02284v c02284v, JQ jq, byte[] bArr) throws C3K {
        c02284v.A0f(8);
        c02284v.A0k(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0i)) {
            return;
        }
        A0H(c02284v, 16, jq);
    }

    private void A0N(InterfaceC1772ms interfaceC1772ms) throws IOException {
        int i = ((int) this.A07) - this.A00;
        if (this.A0E != null) {
            interfaceC1772ms.readFully(this.A0E.A00, 8, i);
            A0V(new C1743mD(this.A01, this.A0E), interfaceC1772ms);
        } else {
            interfaceC1772ms.AK3(i);
        }
        A0G(interfaceC1772ms.A8n());
    }

    private void A0O(InterfaceC1772ms interfaceC1772ms) throws IOException {
        J7 j7ValueAt = null;
        long j = Long.MAX_VALUE;
        int size = this.A0D.size();
        int i = 0;
        while (true) {
            if (i < size) {
                J7 nextTrackBundle = this.A0D.valueAt(i);
                JQ jq = nextTrackBundle.A07;
                if (jq.A0A) {
                    long nextDataOffset = jq.A03;
                    String[] strArr = A0f;
                    if (strArr[3].length() == strArr[6].length()) {
                        break;
                    }
                    A0f[4] = "mIjUpcDFQdM2YkTgY6cnbvy";
                    if (nextDataOffset < j) {
                        j = jq.A03;
                        j7ValueAt = this.A0D.valueAt(i);
                    }
                }
                i++;
            } else {
                if (j7ValueAt != null) {
                    int iA8n = (int) (j - interfaceC1772ms.A8n());
                    if (iA8n >= 0) {
                        interfaceC1772ms.AK3(iA8n);
                        j7ValueAt.A07.A05(interfaceC1772ms);
                        return;
                    }
                    throw new C3K(A0B(325, 39, 126));
                }
                if (A0f[4].length() == 23) {
                    A0f[0] = "NbtoUSPOiQE3wq0";
                    this.A02 = 3;
                    return;
                }
            }
        }
        throw new RuntimeException();
    }

    private void A0P(C1744mE c1744mE) throws C3K {
        if (((AbstractC0570Iu) c1744mE).A00 == 1836019574) {
            A0R(c1744mE);
        } else if (((AbstractC0570Iu) c1744mE).A00 == 1836019558) {
            A0Q(c1744mE);
        } else {
            if (this.A0X.isEmpty()) {
                return;
            }
            this.A0X.peek().A08(c1744mE);
        }
    }

    private void A0Q(C1744mE c1744mE) throws C3K {
        A0S(c1744mE, this.A0D, this.A0M, this.A0d, this.A0c);
        DrmInitData drmInitDataA05 = this.A0N != null ? null : A05(c1744mE.A02);
        if (drmInitDataA05 != null) {
            int i = this.A0D.size();
            for (int trackCount = 0; trackCount < i; trackCount++) {
                this.A0D.valueAt(trackCount).A07(drmInitDataA05);
            }
        }
        if (this.A0B != -9223372036854775807L) {
            int size = this.A0D.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.A0D.valueAt(i2).A06(this.A0B);
            }
            this.A0B = -9223372036854775807L;
        }
    }

    public static void A0S(C1744mE c1744mE, SparseArray<J7> sparseArray, int i, byte[] bArr, boolean z) throws C3K {
        int size = c1744mE.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1744mE child = c1744mE.A01.get(i2);
            int i3 = ((AbstractC0570Iu) child).A00;
            if (i3 == 1953653094) {
                boolean z2 = true;
                if (size <= 1 || !z) {
                    z2 = false;
                }
                A0T(child, sparseArray, i, bArr, z2);
            }
        }
    }

    public static void A0U(C1744mE c1744mE, J7 j7, long j, int i) {
        int i2 = 0;
        int i3 = 0;
        List<C1743mD> list = c1744mE.A02;
        int size = list.size();
        int i4 = 0;
        while (true) {
            String[] strArr = A0f;
            if (strArr[1].charAt(23) != strArr[5].charAt(23)) {
                throw new RuntimeException();
            }
            A0f[0] = "3b9EJYgpciD07do";
            if (i4 < size) {
                C1743mD c1743mD = list.get(i4);
                if (((AbstractC0570Iu) c1743mD).A00 == 1953658222) {
                    C02284v trunData = c1743mD.A00;
                    trunData.A0f(12);
                    int iA0L = trunData.A0L();
                    if (iA0L > 0) {
                        i3 += iA0L;
                        i2++;
                    }
                }
                i4++;
            } else {
                j7.A02 = 0;
                j7.A00 = 0;
                j7.A01 = 0;
                j7.A07.A03(i2, i3);
                int i5 = 0;
                int trunStartPosition = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    C1743mD c1743mD2 = list.get(i6);
                    if (((AbstractC0570Iu) c1743mD2).A00 == 1953658222) {
                        trunStartPosition = A00(j7, i5, j, i, c1743mD2.A00, trunStartPosition);
                        i5++;
                    }
                }
                return;
            }
        }
    }

    private void A0V(C1743mD c1743mD, InterfaceC1772ms interfaceC1772ms) throws C3K {
        Uri uriA9P;
        if (!this.A0X.isEmpty()) {
            this.A0X.peek().A09(c1743mD);
            return;
        }
        if (((AbstractC0570Iu) c1743mD).A00 == 1936286840) {
            Pair<Long, C1777my> pairA04 = A04(c1743mD.A00, interfaceC1772ms.A8n());
            this.A0C = ((Long) pairA04.first).longValue();
            this.A0F.AJ7((HY) pairA04.second);
            if (A0f[2].length() != 2) {
                throw new RuntimeException();
            }
            A0f[2] = "jw";
            this.A0H = true;
            return;
        }
        if (((AbstractC0570Iu) c1743mD).A00 != 1701671783 || (uriA9P = interfaceC1772ms.A9P()) == null) {
            return;
        }
        A0I(c1743mD.A00, uriA9P);
    }

    public static boolean A0X(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    public static boolean A0Y(int i) {
        if (i != 1751411826 && i != 1835296868 && i != 1836476516 && i != 1936286840 && i != 1937011556 && i != 1952867444 && i != 1952868452 && i != 1953196132 && i != 1953654136 && i != 1953658222 && i != 1886614376) {
            if (A0f[0].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[1] = "pufslWDHGkolcxIdleA53YlHTmcCni23";
            strArr[5] = "pxTVwd0BvZHkKJbeu8mcyfUHnPvesqsQ";
            if (i != 1935763834 && i != 1935763823 && i != 1936027235 && i != 1970628964 && i != 1935828848 && i != 1936158820 && i != 1701606260 && i != 1835362404 && i != 1701671783) {
                return false;
            }
        }
        return true;
    }

    private boolean A0Z(InterfaceC1772ms interfaceC1772ms) throws IOException {
        if (this.A00 == 0) {
            if (!interfaceC1772ms.AHR(this.A0O.A00, 0, 8, true)) {
                return false;
            }
            this.A00 = 8;
            this.A0O.A0f(0);
            this.A07 = this.A0O.A0Q();
            this.A01 = this.A0O.A0C();
        }
        if (this.A07 == 1) {
            interfaceC1772ms.readFully(this.A0O.A00, 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A07 = this.A0O.A0R();
        } else if (this.A07 == 0) {
            long jA8O = interfaceC1772ms.A8O();
            if (jA8O == -1 && !this.A0X.isEmpty()) {
                jA8O = this.A0X.peek().A00;
            }
            if (jA8O != -1) {
                long jA8n = jA8O - interfaceC1772ms.A8n();
                int trackCount = this.A00;
                this.A07 = jA8n + ((long) trackCount);
            }
        }
        if (this.A07 >= this.A00) {
            long jA8n2 = interfaceC1772ms.A8n() - ((long) this.A00);
            if (this.A01 == 1836019558) {
                int size = this.A0D.size();
                for (int i = 0; i < size; i++) {
                    JQ jq = this.A0D.valueAt(i).A07;
                    jq.A02 = jA8n2;
                    jq.A03 = jA8n2;
                    jq.A04 = jA8n2;
                }
            }
            if (this.A01 == 1835295092) {
                this.A0G = null;
                this.A09 = this.A07 + jA8n2;
                if (!this.A0H) {
                    this.A0F.AJ7(new C1767mn(this.A08, jA8n2));
                    this.A0H = true;
                }
                this.A02 = 2;
                return true;
            }
            boolean zA0X = A0X(this.A01);
            String[] strArr = A0f;
            if (strArr[3].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0f[7] = "BTpsgrbOJA5y808qoKaZGmPima83kMX9";
            if (zA0X) {
                long jA8n3 = (interfaceC1772ms.A8n() + this.A07) - 8;
                this.A0X.push(new C1744mE(this.A01, jA8n3));
                if (this.A07 == this.A00) {
                    A0G(jA8n3);
                } else {
                    A0C();
                }
            } else if (A0Y(this.A01)) {
                if (this.A00 != 8) {
                    throw new C3K(A0B(208, 51, 94));
                }
                if (this.A07 <= 2147483647L) {
                    this.A0E = new C02284v((int) this.A07);
                    System.arraycopy(this.A0O.A00, 0, this.A0E.A00, 0, 8);
                    this.A02 = 1;
                } else {
                    throw new C3K(A0B(259, 49, 17));
                }
            } else if (this.A07 <= 2147483647L) {
                this.A0E = null;
                this.A02 = 1;
            } else {
                throw new C3K(A0B(497, 53, 12));
            }
            return true;
        }
        throw new C3K(A0B(2, 48, 125));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02bb  */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A0a(InterfaceC1772ms interfaceC1772ms) throws IOException {
        JP jpA00;
        int iAIp;
        int i = 4;
        int i2 = 1;
        int i3 = 0;
        if (this.A02 == 3) {
            if (this.A0G == null) {
                J7 j7A07 = A07(this.A0D);
                if (j7A07 == null) {
                    int iA8n = (int) (this.A09 - interfaceC1772ms.A8n());
                    if (A0f[0].length() == 15) {
                        A0f[4] = "i1YiOY4gD0FAVv8vBgekv9L";
                        if (iA8n >= 0) {
                            interfaceC1772ms.AK3(iA8n);
                            A0C();
                            return false;
                        }
                        throw new C3K(A0B(364, 35, 87));
                    }
                } else {
                    int iA8n2 = (int) (j7A07.A07.A0E[j7A07.A02] - interfaceC1772ms.A8n());
                    if (iA8n2 < 0) {
                        AbstractC02134g.A07(A0B(128, 22, 77), A0B(150, 40, 19));
                        iA8n2 = 0;
                    }
                    interfaceC1772ms.AK3(iA8n2);
                    this.A0G = j7A07;
                }
            }
            this.A06 = this.A0G.A07.A0B[this.A0G.A01];
            if (this.A0G.A01 < this.A0G.A03) {
                interfaceC1772ms.AK3(this.A06);
                if (A0f[4].length() != 23) {
                    this.A0G.A02();
                    if (!this.A0G.A09()) {
                        this.A0G = null;
                    }
                } else {
                    A0f[0] = "A3KFlo0OZ1vz3cN";
                    this.A0G.A02();
                    if (!this.A0G.A09()) {
                    }
                }
                this.A02 = 3;
                return true;
            }
            if (this.A0G.A05.A02 == 1) {
                this.A06 -= 8;
                interfaceC1772ms.AK3(8);
            }
            this.A04 = this.A0G.A04();
            this.A06 += this.A04;
            this.A02 = 4;
            this.A05 = 0;
            JQ jq = this.A0G.A07;
            JO jo = this.A0G.A05;
            InterfaceC0528Hd interfaceC0528Hd = this.A0G.A06;
            int i4 = this.A0G.A01;
            long jA00 = jq.A00(i4);
            if (this.A0T != null) {
            }
            int i5 = jo.A01;
            if (A0f[0].length() == 15) {
            }
        } else {
            JQ jq2 = this.A0G.A07;
            JO jo2 = this.A0G.A05;
            InterfaceC0528Hd interfaceC0528Hd2 = this.A0G.A06;
            int i42 = this.A0G.A01;
            long jA002 = jq2.A00(i42);
            if (this.A0T != null) {
                jA002 = this.A0T.A05(jA002);
            }
            int i52 = jo2.A01;
            if (A0f[0].length() == 15) {
                if (i52 != 0) {
                    byte[] bArr = this.A0Q.A00;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i6 = jo2.A01 + 1;
                    int i7 = 4 - jo2.A01;
                    while (this.A04 < this.A06) {
                        if (this.A05 == 0) {
                            interfaceC1772ms.readFully(bArr, i7, i6);
                            this.A0Q.A0f(i3);
                            int iA0C = this.A0Q.A0C();
                            if (iA0C >= i2) {
                                this.A05 = iA0C - 1;
                                this.A0R.A0f(i3);
                                interfaceC0528Hd2.AIr(this.A0R, i);
                                interfaceC0528Hd2.AIr(this.A0Q, i2);
                                this.A0J = this.A0K.length > 0 && HS.A0I(jo2.A07.A0W, bArr[i]);
                                this.A04 += 5;
                                if (A0f[2].length() != 2) {
                                    throw new RuntimeException();
                                }
                                String[] strArr = A0f;
                                strArr[3] = "rGJs1bdDcV9vWCpHaV2ADCTyGiB9Xi";
                                strArr[6] = "SO50y9aywvhjzs541";
                                this.A06 += i7;
                                i2 = 1;
                            } else {
                                throw new C3K(A0B(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 18, 94));
                            }
                        } else {
                            if (this.A0J) {
                                this.A0P.A0d(this.A05);
                                interfaceC1772ms.readFully(this.A0P.A00, i3, this.A05);
                                interfaceC0528Hd2.AIr(this.A0P, this.A05);
                                iAIp = this.A05;
                                int iA02 = HS.A02(this.A0P.A00, this.A0P.A0A());
                                this.A0P.A0f(A0B(756, 10, 83).equals(jo2.A07.A0W) ? 1 : 0);
                                this.A0P.A0e(iA02);
                                AbstractC0594Js.A03(jA002, this.A0P, this.A0K);
                            } else {
                                iAIp = interfaceC0528Hd2.AIp(interfaceC1772ms, this.A05, false);
                            }
                            this.A04 += iAIp;
                            this.A05 -= iAIp;
                            i = 4;
                            i2 = 1;
                            i3 = 0;
                        }
                    }
                } else {
                    if (this.A0I) {
                        AbstractC0519Gu.A07(this.A06, this.A0S);
                        int iA0A = this.A0S.A0A();
                        interfaceC0528Hd2.AIr(this.A0S, iA0A);
                        this.A06 += iA0A;
                        this.A04 += iA0A;
                        this.A0I = false;
                    }
                    while (this.A04 < this.A06) {
                        int i8 = this.A06 - this.A04;
                        if (A0f[4].length() != 23) {
                            break;
                        }
                        A0f[4] = "4fzpRPid5Z3e8Rz7esUDMjQ";
                        this.A04 += interfaceC0528Hd2.AIp(interfaceC1772ms, i8, false);
                    }
                }
                boolean z = jq2.A0G[i42];
                C0526Hb c0526Hb = null;
                jpA00 = this.A0G.A00();
                ?? r11 = z;
                if (jpA00 != null) {
                    int i9 = (z ? 1 : 0) | 1073741824;
                    c0526Hb = jpA00.A01;
                    r11 = i9;
                }
                int i10 = r11;
                if (this.A0G != null) {
                    i10 = r11;
                    if (this.A0G.A05 != null) {
                        i10 = r11;
                        if (this.A0G.A05.A07 != null) {
                            String str = this.A0G.A05.A07.A0W;
                            String[] strArr2 = A0f;
                            if (strArr2[3].length() != strArr2[6].length()) {
                                A0f[2] = "aG";
                                i10 = r11;
                                if (str == A0B(735, 21, 64)) {
                                    i10 = (r11 == true ? 1 : 0) | true;
                                }
                            }
                        }
                    }
                }
                long j = jA002;
                interfaceC0528Hd2.AIu(jA002, i10, this.A06, 0, c0526Hb);
                this.A0A = j;
                A0F(j);
                if (!this.A0G.A09()) {
                    String[] strArr3 = A0f;
                    if (strArr3[1].charAt(23) != strArr3[5].charAt(23)) {
                        this.A0G = null;
                    } else {
                        String[] strArr4 = A0f;
                        strArr4[1] = "si2y9gsn9mC0ma4HRQ4DLaiHkSELP0XP";
                        strArr4[5] = "aeCrUYztm6cMo33HVXFI6qvHQZYHBxKr";
                        this.A0G = null;
                    }
                }
                this.A02 = 3;
                return true;
            }
            String[] strArr5 = A0f;
            strArr5[1] = "1reQ2pcS16Hgv6ya8EYaKcYHA8e9gTqM";
            strArr5[5] = "zXUoCiVQDhh6v7GYUtROZrCHyvEA77y8";
            if (i52 != 0) {
            }
            boolean z2 = jq2.A0G[i42];
            C0526Hb c0526Hb2 = null;
            jpA00 = this.A0G.A00();
            ?? r112 = z2;
            if (jpA00 != null) {
            }
            int i102 = r112;
            if (this.A0G != null) {
            }
            long j2 = jA002;
            interfaceC0528Hd2.AIu(jA002, i102, this.A06, 0, c0526Hb2);
            this.A0A = j2;
            A0F(j2);
            if (!this.A0G.A09()) {
            }
            this.A02 = 3;
            return true;
        }
        throw new RuntimeException();
    }

    public static /* synthetic */ H9[] A0b() {
        return new H9[]{new C1736m6()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A0F = ha;
        if (this.A0W != null) {
            J7 j7 = new J7(ha.AKS(0, this.A0W.A03));
            j7.A08(this.A0W, new J1(0, 0, 0, 0));
            this.A0D.put(0, j7);
            A0D();
            this.A0F.A6O();
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC1772ms interfaceC1772ms, HV hv) throws IOException {
        while (true) {
            int i = this.A02;
            if (A0f[0].length() != 15) {
                throw new RuntimeException();
            }
            String[] strArr = A0f;
            strArr[3] = "yYIiClYY3RZS73RDJ5vLPk2bDdZFXU";
            strArr[6] = "bGm4sUzBrXbQjG5ES";
            switch (i) {
                case 0:
                    if (!A0Z(interfaceC1772ms)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    A0N(interfaceC1772ms);
                    break;
                case 2:
                    A0O(interfaceC1772ms);
                    break;
                default:
                    if (A0a(interfaceC1772ms)) {
                        return 0;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j, long j2) {
        int size = this.A0D.size();
        for (int i = 0; i < size; i++) {
            this.A0D.valueAt(i).A05();
        }
        this.A0Y.clear();
        this.A03 = 0;
        this.A0B = j2;
        this.A0X.clear();
        this.A0I = false;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC1772ms interfaceC1772ms) throws IOException {
        return JM.A01(interfaceC1772ms);
    }
}
