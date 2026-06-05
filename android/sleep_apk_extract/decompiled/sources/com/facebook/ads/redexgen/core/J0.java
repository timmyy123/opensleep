package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MdtaMetadataEntry;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import com.facebook.internal.NativeProtocol;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.home.platform.traits.ValidationIssue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public abstract class J0 {
    public static byte[] A00;
    public static String[] A01 = {"3VpIAtFn", "NjWxo0tcAFilzYXB2gd1dub2S4KYfC0G", "7dc9OwNzjfbA4WDbGdH3UDrd", "kTLJpOKA", "odl5U202HvuloegJiYsgd2o0Bsn6ktlS", "Tqd8q9EAW1nxLdrfn3G624yWy86zlBE3", "GM6CYLF4x47fKf9mrP144TBtf3lMkKEe", "FJhXpGWKImafMZTrlZrsHtUKnb1aBvQ9"};
    public static final byte[] A02;

    @MetaExoPlayerCustomization("Needed for oculus customization")
    public static final int[] A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorInfo A0B(C02284v c02284v) {
        C01592a c01592a = new C01592a();
        C02274u c02274u = new C02274u(c02284v.A0l());
        c02274u.A08(c02284v.A09() * 8);
        c02274u.A0A(1);
        c02274u.A04(3);
        c02274u.A09(6);
        c02274u.A0H();
        c02274u.A0H();
        c02274u.A09(13);
        c02274u.A07();
        int iA04 = c02274u.A04(4);
        String strA0M = A0M(178, 11, 68);
        if (iA04 != 1) {
            AbstractC02134g.A06(strA0M, A0M(593, 22, 87) + iA04);
            return c01592a.A03();
        }
        if (c02274u.A0H()) {
            AbstractC02134g.A06(strA0M, A0M(563, 30, 42));
            return c01592a.A03();
        }
        boolean zA0H = c02274u.A0H();
        c02274u.A07();
        if (zA0H && c02274u.A04(8) > 127) {
            AbstractC02134g.A06(strA0M, A0M(189, 18, 61));
            return c01592a.A03();
        }
        int iA042 = c02274u.A04(3);
        c02274u.A07();
        if (c02274u.A0H()) {
            AbstractC02134g.A06(strA0M, A0M(615, 40, 96));
            return c01592a.A03();
        }
        if (c02274u.A0H()) {
            AbstractC02134g.A06(strA0M, A0M(655, 36, 7));
            return c01592a.A03();
        }
        if (c02274u.A0H()) {
            AbstractC02134g.A06(strA0M, A0M(494, 46, 123));
            return c01592a.A03();
        }
        int iA043 = c02274u.A04(5);
        for (int i = 0; i <= iA043; i++) {
            c02274u.A09(12);
            if (c02274u.A04(5) > 7) {
                c02274u.A07();
            }
        }
        int iA044 = c02274u.A04(4);
        int iA045 = c02274u.A04(4);
        c02274u.A09(iA044 + 1);
        c02274u.A09(iA045 + 1);
        if (c02274u.A0H()) {
            c02274u.A09(7);
        }
        c02274u.A09(7);
        boolean zA0H2 = c02274u.A0H();
        if (zA0H2) {
            c02274u.A09(2);
        }
        boolean zA0H3 = c02274u.A0H();
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        A01[2] = "spdqEdfVqdQubNKbzHaSCSbA";
        if ((zA0H3 ? 2 : c02274u.A04(1)) > 0) {
            boolean zA0H4 = c02274u.A0H();
            if (A01[5].charAt(23) != 'W') {
                A01[5] = "fpomjt14ZeQUreCUx8H2Qj9W8NeulNVr";
                if (!zA0H4) {
                    c02274u.A09(1);
                }
            } else {
                String[] strArr2 = A01;
                strArr2[7] = "VYuT40g5EEwFWTEBAX27ZdDSMSIcM78J";
                strArr2[4] = "WUQpgtHZDasrpP5hdEQLNs2AngJpMhTI";
                if (!zA0H4) {
                }
            }
        }
        if (zA0H2) {
            c02274u.A09(3);
        }
        c02274u.A09(3);
        boolean zA0H5 = c02274u.A0H();
        if (iA042 == 2 && zA0H5) {
            c02274u.A07();
        }
        boolean z = iA042 != 1 && c02274u.A0H();
        if (c02274u.A0H()) {
            int iA046 = c02274u.A04(8);
            int iA047 = c02274u.A04(8);
            c01592a.A01(ColorInfo.A00(iA046)).A00(((z || iA046 != 1 || iA047 != 13 || c02274u.A04(8) != 0) ? c02274u.A04(1) : 1) != 1 ? 2 : 1).A02(ColorInfo.A01(iA047));
        }
        return c01592a.A03();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Metadata A0F(C1744mE c1744mE) {
        C1743mD c1743mDA07 = c1744mE.A07(1751411826);
        C1743mD c1743mDA072 = c1744mE.A07(1801812339);
        C1743mD c1743mDA073 = c1744mE.A07(1768715124);
        if (c1743mDA07 == null || c1743mDA072 == null || c1743mDA073 == null || A03(c1743mDA07.A00) != 1835299937) {
            return null;
        }
        C02284v c02284v = c1743mDA072.A00;
        c02284v.A0f(12);
        int iA0C = c02284v.A0C();
        String[] strArr = new String[iA0C];
        for (int i = 0; i < iA0C; i++) {
            int iA0C2 = c02284v.A0C();
            c02284v.A0g(4);
            strArr[i] = c02284v.A0W(iA0C2 - 8);
        }
        C02284v c02284v2 = c1743mDA073.A00;
        c02284v2.A0f(8);
        ArrayList arrayList = new ArrayList();
        while (c02284v2.A07() > 8) {
            int iA09 = c02284v2.A09();
            int iA0C3 = c02284v2.A0C();
            int iA0C4 = c02284v2.A0C() - 1;
            if (iA0C4 < 0 || iA0C4 >= strArr.length) {
                AbstractC02134g.A07(A0M(178, 11, 68), A0M(359, 41, 107) + iA0C4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryA09 = JB.A09(c02284v2, iA09 + iA0C3, strArr[iA0C4]);
                if (mdtaMetadataEntryA09 != null) {
                    arrayList.add(mdtaMetadataEntryA09);
                }
            }
            c02284v2.A0f(iA09 + iA0C3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0572Iw A0G(C02284v c02284v, int i) {
        c02284v.A0f(i + 8 + 4);
        c02284v.A0g(1);
        A02(c02284v);
        c02284v.A0g(2);
        int iA0I = c02284v.A0I();
        if ((iA0I & 128) != 0) {
            c02284v.A0g(2);
        }
        if ((iA0I & 64) != 0) {
            c02284v.A0g(c02284v.A0I());
        }
        if ((iA0I & 32) != 0) {
            c02284v.A0g(2);
        }
        c02284v.A0g(1);
        A02(c02284v);
        String strA05 = C3J.A05(c02284v.A0I());
        if (A0M(947, 10, 17).equals(strA05) || A0M(989, 13, 117).equals(strA05) || A0M(1002, 16, 39).equals(strA05)) {
            return new C0572Iw(strA05, null, -1L, -1L);
        }
        c02284v.A0g(4);
        long jA0Q = c02284v.A0Q();
        long jA0Q2 = c02284v.A0Q();
        c02284v.A0g(1);
        int iA02 = A02(c02284v);
        byte[] bArr = new byte[iA02];
        c02284v.A0k(bArr, 0, iA02);
        if (jA0Q2 <= 0) {
            jA0Q2 = -1;
        }
        if (jA0Q <= 0) {
            jA0Q = -1;
        }
        return new C0572Iw(strA05, bArr, jA0Q2, jA0Q);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0575Iz A0I(C02284v c02284v) {
        long jA0Q;
        c02284v.A0f(8);
        int iA01 = AbstractC0570Iu.A01(c02284v.A0C());
        c02284v.A0g(iA01 == 0 ? 8 : 16);
        int iA0C = c02284v.A0C();
        c02284v.A0g(4);
        boolean z = true;
        int iA09 = c02284v.A09();
        int i = iA01 == 0 ? 4 : 8;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (c02284v.A0l()[iA09 + i2] != -1) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            c02284v.A0g(i);
            jA0Q = -9223372036854775807L;
        } else {
            jA0Q = iA01 == 0 ? c02284v.A0Q() : c02284v.A0R();
            if (jA0Q == 0) {
                jA0Q = -9223372036854775807L;
            }
        }
        c02284v.A0g(16);
        int iA0C2 = c02284v.A0C();
        int iA0C3 = c02284v.A0C();
        c02284v.A0g(4);
        int iA0C4 = c02284v.A0C();
        int iA0C5 = c02284v.A0C();
        return new C0575Iz(iA0C, jA0Q, (iA0C2 == 0 && iA0C3 == 65536 && iA0C4 == (-NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) && iA0C5 == 0) ? 90 : (iA0C2 == 0 && iA0C3 == (-NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) && iA0C4 == 65536 && iA0C5 == 0) ? 270 : (iA0C2 == (-NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) && iA0C3 == 0 && iA0C4 == 0 && iA0C5 == (-NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) ? 180 : 0);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    public static JO A0J(C1744mE c1744mE, C1743mD c1743mD, long j, DrmInitData drmInitData, boolean z, boolean z2) throws C3K {
        C1744mE c1744mEA06;
        long j2 = j;
        C1744mE c1744mE2 = (C1744mE) AbstractC02053y.A01(c1744mE.A06(1835297121));
        int iA01 = A01(A03(((C1743mD) AbstractC02053y.A01(c1744mE2.A07(1751411826))).A00));
        if (iA01 == -1) {
            return null;
        }
        C0575Iz c0575IzA0I = A0I(((C1743mD) AbstractC02053y.A01(c1744mE.A07(1953196132))).A00);
        if (j2 == -9223372036854775807L) {
            j2 = c0575IzA0I.A02;
        }
        long jA05 = A05(c1743mD.A00);
        long jA0U = j2 == -9223372036854775807L ? -9223372036854775807L : C5C.A0U(j2, 1000000L, jA05);
        C1744mE c1744mE3 = (C1744mE) AbstractC02053y.A01(((C1744mE) AbstractC02053y.A01(c1744mE2.A06(1835626086))).A06(1937007212));
        Pair<Long, String> pairA06 = A06(((C1743mD) AbstractC02053y.A01(c1744mE2.A07(1835296868))).A00);
        C1743mD c1743mDA07 = c1744mE3.A07(1937011556);
        if (c1743mDA07 == null) {
            throw C3K.A01(A0M(288, 63, 20), null);
        }
        C0574Iy c0574IyA0H = A0H(c1743mDA07.A00, c0575IzA0I.A00, c0575IzA0I.A01, (String) pairA06.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z && (c1744mEA06 = c1744mE.A06(1701082227)) != null) {
            Pair<long[], long[]> pairA09 = A09(c1744mEA06);
            String[] strArr = A01;
            if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "IbqpVMf9BLmnuF5BFBlg7Wi48qFbo4Yh";
            strArr2[4] = "amD11xiy90bj3UvdeHvItss5MLCDKaRi";
            if (pairA09 != null) {
                jArr = (long[]) pairA09.first;
                jArr2 = (long[]) pairA09.second;
            }
        }
        if (c0574IyA0H.A02 == null) {
            return null;
        }
        return new JO(c0575IzA0I.A00, iA01, ((Long) pairA06.first).longValue(), jA05, jA0U, c0574IyA0H.A02, c0574IyA0H.A01, c0574IyA0H.A03, c0574IyA0H.A00, jArr, jArr2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JP A0K(C02284v c02284v, int i, int i2, String str) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            c02284v.A0f(i3);
            int iA0C = c02284v.A0C();
            if (c02284v.A0C() == 1952804451) {
                int iA01 = AbstractC0570Iu.A01(c02284v.A0C());
                c02284v.A0g(1);
                int i4 = 0;
                int i5 = 0;
                if (iA01 == 0) {
                    c02284v.A0g(1);
                } else {
                    int iA0I = c02284v.A0I();
                    i4 = (iA0I & 240) >> 4;
                    i5 = iA0I & 15;
                }
                boolean z = c02284v.A0I() == 1;
                int iA0I2 = c02284v.A0I();
                byte[] bArr = new byte[16];
                c02284v.A0k(bArr, 0, bArr.length);
                byte[] bArr2 = null;
                if (z && iA0I2 == 0) {
                    int iA0I3 = c02284v.A0I();
                    bArr2 = new byte[iA0I3];
                    c02284v.A0k(bArr2, 0, iA0I3);
                }
                return new JP(z, str, iA0I2, bArr, i4, i5, bArr2);
            }
            i3 += iA0C;
        }
        return null;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    public static JR A0L(JO jo, C1744mE c1744mE, HK hk) throws C3K {
        InterfaceC0573Ix c1741mB;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        String strA0M;
        long j;
        JO jo2;
        String strA0M2;
        long[] jArr;
        int i;
        int[] iArr;
        C1743mD c1743mDA07 = c1744mE.A07(1937011578);
        if (c1743mDA07 != null) {
            c1741mB = new C1742mC(c1743mDA07, jo.A07);
        } else {
            C1743mD c1743mDA072 = c1744mE.A07(1937013298);
            if (c1743mDA072 == null) {
                throw C3K.A01(A0M(400, 42, 111), null);
            }
            c1741mB = new C1741mB(c1743mDA072);
        }
        int iA8v = c1741mB.A8v();
        String[] strArr = A01;
        if (strArr[7].charAt(30) != strArr[4].charAt(30)) {
            A01[5] = "VWWx1kGHZbX2q2PAsWKgJgHWMUDi0u3b";
            if (iA8v == 0) {
                return new JR(jo, new long[0], new int[0], 0, new long[0], new int[0], 0L);
            }
            boolean z = false;
            C1743mD c1743mDA073 = c1744mE.A07(1937007471);
            if (c1743mDA073 == null) {
                z = true;
                c1743mDA073 = (C1743mD) AbstractC02053y.A01(c1744mE.A07(1668232756));
            }
            C02284v c02284v = c1743mDA073.A00;
            C02284v c02284v2 = ((C1743mD) AbstractC02053y.A01(c1744mE.A07(1937011555))).A00;
            C02284v c02284v3 = ((C1743mD) AbstractC02053y.A01(c1744mE.A07(1937011827))).A00;
            C1743mD c1743mDA074 = c1744mE.A07(1937011571);
            C02284v c02284v4 = c1743mDA074 != null ? c1743mDA074.A00 : null;
            C1743mD c1743mDA075 = c1744mE.A07(1668576371);
            C02284v c02284v5 = c1743mDA075 != null ? c1743mDA075.A00 : null;
            C0571Iv c0571Iv = new C0571Iv(c02284v2, c02284v, z);
            c02284v3.A0f(12);
            int iA0L = c02284v3.A0L() - 1;
            int iA0L2 = c02284v3.A0L();
            int iA0L3 = c02284v3.A0L();
            int iA0L4 = 0;
            int iA0L5 = 0;
            int iA0C = 0;
            if (c02284v5 != null) {
                c02284v5.A0f(12);
                iA0L5 = c02284v5.A0L();
            }
            int iA0L6 = -1;
            int iA0L7 = 0;
            if (c02284v4 != null) {
                c02284v4.A0f(12);
                iA0L7 = c02284v4.A0L();
                if (iA0L7 > 0) {
                    iA0L6 = c02284v4.A0L() - 1;
                } else {
                    c02284v4 = null;
                }
            }
            int iA8A = c1741mB.A8A();
            String str = jo.A07.A0W;
            int i2 = 0;
            long j2 = 0;
            if (iA8A != -1 && (A0M(967, 9, 94).equals(str) || A0M(897, 15, 77).equals(str) || A0M(882, 15, 96).equals(str)) && iA0L == 0 && iA0L5 == 0 && iA0L7 == 0) {
                long[] jArr2 = new long[c0571Iv.A05];
                String[] strArr2 = A01;
                if (strArr2[1].charAt(26) != strArr2[6].charAt(26)) {
                    A01[2] = "it49YraTc1fDpxLwGLRBh0ec";
                    iArr = new int[c0571Iv.A05];
                } else {
                    String[] strArr3 = A01;
                    strArr3[0] = "cQxifTbk";
                    strArr3[3] = "kvbBtLxb";
                    iArr = new int[c0571Iv.A05];
                }
                while (c0571Iv.A02()) {
                    jArr2[c0571Iv.A00] = c0571Iv.A02;
                    iArr[c0571Iv.A00] = c0571Iv.A01;
                }
                J3 j3A00 = J4.A00(iA8A, jArr2, iArr, iA0L3);
                jArrCopyOf = j3A00.A04;
                iArrCopyOf = j3A00.A03;
                i2 = j3A00.A00;
                jArrCopyOf2 = j3A00.A05;
                iArrCopyOf2 = j3A00.A02;
                j = j3A00.A01;
                jo2 = jo;
            } else {
                jArrCopyOf = new long[iA8v];
                iArrCopyOf = new int[iA8v];
                jArrCopyOf2 = new long[iA8v];
                iArrCopyOf2 = new int[iA8v];
                long j3 = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    strA0M = A0M(178, 11, 68);
                    if (i4 >= iA8v) {
                        i4 = iA8v;
                        break;
                    }
                    boolean zA02 = true;
                    while (i3 == 0) {
                        zA02 = c0571Iv.A02();
                        if (!zA02) {
                            break;
                        }
                        if (A01[5].charAt(23) != 'W') {
                            throw new RuntimeException();
                        }
                        A01[5] = "M5jbBIfsv36G8eW66Ax72viWGVpCEb4z";
                        j3 = c0571Iv.A02;
                        i3 = c0571Iv.A01;
                    }
                    if (!zA02) {
                        AbstractC02134g.A07(strA0M, A0M(442, 28, 94));
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i4);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i4);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i4);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i4);
                        break;
                    }
                    if (c02284v5 != null) {
                        while (iA0L4 == 0 && iA0L5 > 0) {
                            iA0L4 = c02284v5.A0L();
                            iA0C = c02284v5.A0C();
                            iA0L5--;
                        }
                        iA0L4--;
                    }
                    jArrCopyOf[i4] = j3;
                    iArrCopyOf[i4] = c1741mB.AHS();
                    if (iArrCopyOf[i4] > i2) {
                        i2 = iArrCopyOf[i4];
                    }
                    jArrCopyOf2[i4] = j2 + ((long) iA0C);
                    iArrCopyOf2[i4] = c02284v4 == null ? 1 : 0;
                    if (i4 == iA0L6) {
                        iArrCopyOf2[i4] = 1;
                        iA0L7--;
                        if (iA0L7 > 0) {
                            iA0L6 = ((C02284v) AbstractC02053y.A01(c02284v4)).A0L() - 1;
                        }
                    }
                    j2 += (long) iA0L3;
                    iA0L2--;
                    if (iA0L2 == 0 && iA0L > 0) {
                        iA0L2 = c02284v3.A0L();
                        iA0L3 = c02284v3.A0C();
                        iA0L--;
                    }
                    j3 += (long) iArrCopyOf[i4];
                    i3--;
                    i4++;
                }
                j = j2 + ((long) iA0C);
                boolean z2 = true;
                if (c02284v5 != null) {
                    while (true) {
                        if (iA0L5 <= 0) {
                            break;
                        }
                        if (c02284v5.A0L() != 0) {
                            z2 = false;
                            break;
                        }
                        c02284v5.A0C();
                        iA0L5--;
                    }
                }
                if (iA0L7 == 0 && iA0L2 == 0 && i3 == 0 && iA0L == 0 && iA0L4 == 0 && z2) {
                    jo2 = jo;
                } else {
                    jo2 = jo;
                    StringBuilder sbAppend = new StringBuilder().append(A0M(ValidationIssue.UNSUPPORTED_ENTITY_TYPE_FIELD_NUMBER, 32, 24)).append(jo2.A00).append(A0M(144, 34, 36)).append(iA0L7).append(A0M(14, 35, 65)).append(iA0L2).append(A0M(85, 26, 14)).append(i3).append(A0M(111, 33, 41)).append(iA0L).append(A0M(49, 36, 31)).append(iA0L4);
                    if (!z2) {
                        strA0M2 = A0M(0, 14, 12);
                    } else if (A01[5].charAt(23) != 'W') {
                        strA0M2 = A0M(0, 0, 93);
                    } else {
                        String[] strArr4 = A01;
                        strArr4[7] = "aaylILcGBS6VDtnpev9y5b4BJZBYR2y3";
                        strArr4[4] = "0XgNPN0ZQsO4pNqGOHtpLFxyHM4aJjFv";
                        strA0M2 = A0M(0, 0, 93);
                    }
                    AbstractC02134g.A07(strA0M, sbAppend.append(strA0M2).toString());
                }
                iA8v = i4;
            }
            long j4 = jo2.A06;
            if (A01[2].length() == 24) {
                String[] strArr5 = A01;
                strArr5[7] = "ipyvZTOv07cYtbuH1DKg84aCsuigBUI1";
                strArr5[4] = "ch7TyunNM6oXEfHdpbs8btnx2NdPJSj4";
                long jA0U = C5C.A0U(j, 1000000L, j4);
                if (jo2.A08 == null) {
                    C5C.A13(jArrCopyOf2, 1000000L, jo2.A06);
                    return new JR(jo, jArrCopyOf, iArrCopyOf, i2, jArrCopyOf2, iArrCopyOf2, jA0U);
                }
                if (jo2.A08.length == 1 && jo2.A03 == 1 && jArrCopyOf2.length >= 2) {
                    long j5 = ((long[]) AbstractC02053y.A01(jo2.A09))[0];
                    long jA0U2 = j5 + C5C.A0U(jo2.A08[0], jo2.A06, jo2.A05);
                    jArrCopyOf2 = jArrCopyOf2;
                    if (A0V(jArrCopyOf2, j, j5, jA0U2)) {
                        long jA0U3 = C5C.A0U(j5 - jArrCopyOf2[0], jo2.A07.A0G, jo2.A06);
                        long jA0U4 = C5C.A0U(j - jA0U2, jo2.A07.A0G, jo2.A06);
                        if ((jA0U3 != 0 || jA0U4 != 0) && jA0U3 <= 2147483647L && jA0U4 <= 2147483647L) {
                            hk.A00 = (int) jA0U3;
                            hk.A01 = (int) jA0U4;
                            C5C.A13(jArrCopyOf2, 1000000L, jo2.A06);
                            return new JR(jo, jArrCopyOf, iArrCopyOf, i2, jArrCopyOf2, iArrCopyOf2, C5C.A0U(jo2.A08[0], 1000000L, jo2.A05));
                        }
                    }
                }
                if (jo2.A08.length == 1 && jo2.A08[0] == 0) {
                    long j6 = ((long[]) AbstractC02053y.A01(jo2.A09))[0];
                    for (int i5 = 0; i5 < jArrCopyOf2.length; i5++) {
                        jArrCopyOf2[i5] = C5C.A0U(jArrCopyOf2[i5] - j6, 1000000L, jo2.A06);
                    }
                    return new JR(jo, jArrCopyOf, iArrCopyOf, i2, jArrCopyOf2, iArrCopyOf2, C5C.A0U(j - j6, 1000000L, jo2.A06));
                }
                boolean z3 = jo2.A03 == 1;
                int i6 = 0;
                int i7 = 0;
                boolean z4 = false;
                int[] iArr2 = new int[jo2.A08.length];
                int[] iArr3 = new int[jo2.A08.length];
                long[] jArr3 = jo2.A09;
                if (A01[5].charAt(23) != 'W') {
                    jArr = (long[]) AbstractC02053y.A01(jArr3);
                    i = 0;
                } else {
                    String[] strArr6 = A01;
                    strArr6[0] = "YPXXFbwg";
                    strArr6[3] = "nX0rcUWc";
                    jArr = (long[]) AbstractC02053y.A01(jArr3);
                    i = 0;
                }
                while (true) {
                    if (i < jo2.A08.length) {
                        long j7 = jArr[i];
                        if (j7 != -1) {
                            long jA0U5 = C5C.A0U(jo2.A08[i], jo2.A06, jo2.A05);
                            iArr2[i] = C5C.A0L(jArrCopyOf2, j7, true, true);
                            iArr3[i] = C5C.A0K(jArrCopyOf2, j7 + jA0U5, z3, false);
                            while (iArr2[i] < iArr3[i] && (iArrCopyOf2[iArr2[i]] & 1) == 0) {
                                iArr2[i] = iArr2[i] + 1;
                            }
                            i6 += iArr3[i] - iArr2[i];
                            String[] strArr7 = A01;
                            if (strArr7[1].charAt(26) == strArr7[6].charAt(26)) {
                                break;
                            }
                            String[] strArr8 = A01;
                            strArr8[0] = "N8MUiUXq";
                            strArr8[3] = "O0bSFd8k";
                            z4 |= i7 != iArr2[i];
                            i7 = iArr3[i];
                        }
                        i++;
                    } else {
                        boolean z5 = z4 | (i6 != iA8v);
                        long[] jArr4 = z5 ? new long[i6] : jArrCopyOf;
                        int[] iArr4 = z5 ? new int[i6] : iArrCopyOf;
                        if (z5) {
                            i2 = 0;
                        }
                        String[] strArr9 = A01;
                        if (strArr9[7].charAt(30) != strArr9[4].charAt(30)) {
                            A01[5] = "xPfk6NQdScK777382m5CuwBWtM3rjqH6";
                            int[] iArr5 = z5 ? new int[i6] : iArrCopyOf2;
                            long[] jArr5 = new long[i6];
                            long j8 = 0;
                            int i8 = 0;
                            for (int i9 = 0; i9 < jo2.A08.length; i9++) {
                                long j9 = jo2.A09[i9];
                                int i10 = iArr2[i9];
                                int i11 = iArr3[i9];
                                if (z5) {
                                    int i12 = i11 - i10;
                                    System.arraycopy(jArrCopyOf, i10, jArr4, i8, i12);
                                    System.arraycopy(iArrCopyOf, i10, iArr4, i8, i12);
                                    System.arraycopy(iArrCopyOf2, i10, iArr5, i8, i12);
                                } else if (A01[5].charAt(23) != 'W') {
                                    A01[2] = "bpFLG5yiCjaNBTatiJL832yJ";
                                } else {
                                    String[] strArr10 = A01;
                                    strArr10[0] = "uU6cy1oD";
                                    strArr10[3] = "C1luViVj";
                                }
                                while (i10 < i11) {
                                    jArr5[i8] = C5C.A0U(j8, 1000000L, jo2.A05) + C5C.A0U(Math.max(0L, jArrCopyOf2[i10] - j9), 1000000L, jo2.A06);
                                    if (z5 && iArr4[i8] > i2) {
                                        i2 = iArrCopyOf[i10];
                                    }
                                    i8++;
                                    i10++;
                                }
                                j8 += jo2.A08[i9];
                            }
                            return new JR(jo, jArr4, iArr4, i2, jArr5, iArr5, C5C.A0U(j8, 1000000L, jo2.A05));
                        }
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    public static String A0M(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0P() {
        A00 = new byte[]{70, 74, 9, 30, 30, 25, 74, 3, 4, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6, 3, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7, 85, 66, 74, 70, 78, 73, 78, 73, 64, 116, 70, 74, 87, 75, 66, 84, 102, 83, 115, 78, 74, 66, 84, 83, 70, 74, 87, 99, 66, 75, 83, 70, 7, 85, 89, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, 20, 24, 16, 23, 16, 23, 30, 42, 24, 20, 9, 21, 28, 10, 56, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 45, 16, 20, 28, 10, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 24, 20, 9, 54, 31, 31, 10, 28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 89, 68, 72, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 5, 9, 1, 6, 1, 6, 15, 59, 9, 5, 24, 4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 27, 33, 6, 43, 0, 29, 6, 3, 72, 99, 111, 61, 42, 34, 46, 38, 33, 38, 33, 40, 27, 38, 34, 42, 60, 59, 46, 34, 63, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 42, 35, 59, 46, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 39, 46, 33, 40, 42, 60, 111, 120, 98, 48, 39, 47, 35, 43, 44, 43, 44, 37, 17, 59, 44, 33, 42, 48, 45, 44, 43, 56, 35, 54, 43, 45, 44, 17, 35, 47, 50, 46, 39, 49, 98, 99, 86, 77, 79, 114, 67, 80, 81, 71, 80, 81, 30, 35, 56, 62, 40, 40, 50, 45, 62, 123, 52, 57, 46, 4, 40, 50, 33, 62, 55, 16, 29, 17, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 23, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 27, 16, 10, 94, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 28, 18, 94, 28, 17, 6, 94, 24, 17, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 94, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 31, 29, 21, 94, 8, 47, 55, 32, 45, 40, 37, 97, 50, 32, 44, 49, 45, 36, 97, 51, 32, 53, 36, 97, 39, 46, 51, 97, 5, 46, 45, 35, 56, 97, 21, 51, 52, 36, 9, 5, 97, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 17, 97, 50, 53, 51, 36, 32, 44, 123, 97, 63, 19, 30, 20, 29, 0, 31, 23, 22, 82, 1, 19, 31, 2, 30, 23, 82, 6, 19, 16, 30, 23, 82, 90, 1, 6, 16, 30, 91, 82, 31, 27, 1, 1, 27, 28, 21, 82, 1, 19, 31, 2, 30, 23, 82, 22, 23, 1, 17, 0, 27, 2, 6, 27, 29, 28, 82, 90, 1, 6, 1, 22, 91, 33, 30, 27, 29, 38, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15, 10, 94, 102, 100, 125, 125, 104, 105, 45, 96, 104, 121, 108, 105, 108, 121, 108, 45, 122, 100, 121, 101, 45, 120, 99, 102, 99, 98, 122, 99, 45, 102, 104, 116, 45, 100, 99, 105, 104, 117, 55, 45, 93, 123, 104, 106, 98, 41, 97, 104, 122, 41, 103, 102, 41, 122, 104, 100, 121, 101, 108, 41, 125, 104, 107, 101, 108, 41, 122, 96, 115, 108, 41, 96, 103, 111, 102, 123, 100, 104, 125, 96, 102, 103, 109, 86, 93, 64, 72, 93, 91, 76, 93, 92, 24, 93, 86, 92, 24, 87, 94, 24, 91, 80, 77, 86, 83, 24, 92, 89, 76, 89, 90, 97, 124, 122, 127, 127, 96, 125, 123, 106, 107, 47, 108, 96, 99, 96, 125, 47, 123, 118, 127, 106, 53, 47, 72, 115, 110, 104, 109, 109, 114, 111, 105, 120, 121, 61, 116, 115, 116, 105, 116, 124, 113, 66, 121, 116, 110, 109, 113, 124, 100, 66, 121, 120, 113, 124, 100, 66, 109, 111, 120, 110, 120, 115, 105, 66, 123, 113, 124, 122, 105, 82, 79, 73, 76, 76, 83, 78, 72, 89, 88, 28, 81, 89, 88, 85, 93, 28, 78, 93, 72, 89, 18, 25, 34, 63, 57, 60, 60, 35, 62, 56, 41, 40, 108, 35, 46, 57, 19, 41, 52, 56, 41, 34, 63, 37, 35, 34, 19, 42, 32, 45, 43, 100, 95, 66, 68, 65, 65, 94, 67, 69, 84, 85, 17, 94, 83, 68, 110, 69, 72, 65, 84, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 17, 83, 104, 117, 115, 118, 118, 105, 116, 114, 99, 98, 38, 116, 99, 98, 115, 101, 99, 98, 89, 117, 114, 111, 106, 106, 89, 118, 111, 101, 114, 115, 116, 99, 89, 110, 99, 103, 98, 99, 116, 52, 15, 18, 20, 17, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 21, 4, 5, 65, 21, 8, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 8, 15, 6, 62, 8, 15, 7, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 62, 17, 19, 4, 18, 4, 15, 21, 62, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, 6, 96, 113, 113, 109, 104, 98, 96, 117, 104, 110, 111, 46, 117, 117, 108, 109, 42, 121, 108, 109, 33, 48, 48, 44, 41, 35, 33, 52, 41, 47, 46, 111, 56, 109, 35, 33, 45, 37, 50, 33, 109, 45, 47, 52, 41, 47, 46, 78, 95, 95, 67, 70, 76, 78, 91, 70, 64, 65, 0, 87, 2, 66, 95, 27, 2, 76, 74, 78, 2, 25, 31, 23, 95, 78, 78, 82, 87, 93, 95, 74, 87, 81, 80, 17, 70, 19, 83, 78, 10, 19, 72, 74, 74, 61, 44, 44, 48, 53, 63, 61, 40, 53, 51, 50, 115, 36, 113, 45, 41, 53, 63, 55, 40, 53, 49, 57, 113, 40, 36, 111, 59, 80, 68, 85, 88, 94, 30, 2, 86, 65, 65, 58, 46, 63, 50, 52, 116, 58, 56, 104, 42, 62, 47, 34, 36, 100, 42, 40, 127, 46, 58, 43, 38, 32, 96, 46, 35, 46, 44, 34, 54, 39, 42, 44, 108, 34, 46, 49, 110, 52, 33, 77, 89, 72, 69, 67, 3, 73, 77, 79, 31, 3, 23, 6, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 77, 4, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 3, 1, 103, 115, 98, 111, 105, 41, 97, 49, 55, 55, 43, 103, 106, 103, 113, 74, 94, 79, 66, 68, 4, 76, 28, 26, 26, 6, 70, 71, 74, 92, 34, 54, 39, 42, 44, 108, 46, 43, 34, 114, 23, 3, 18, 31, 25, 89, 27, 30, 27, 71, 96, 116, 101, 104, 110, 46, 108, 113, 53, 96, 44, 109, 96, 117, 108, 22, 2, 19, 30, 24, 88, 26, 7, 18, 16, 68, 80, 65, 76, 74, 10, 74, 85, 80, 86, 89, 77, 92, 81, 87, 23, 74, 89, 79, 74, 94, 79, 66, 68, 4, 95, 89, 94, 78, 6, 67, 79, 114, 102, 119, 122, 124, 60, 101, 125, 119, 61, 119, 
        103, 96, 32, 52, 37, 40, 46, 110, 55, 47, 37, 111, 37, 53, 50, 111, 41, 37, 68, 80, 65, 76, 74, 10, 83, 75, 65, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 65, 81, 86, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 77, 65, 30, 85, 87, 74, 67, 76, 73, 64, 24, 73, 71, 87, 88, 76, 93, 80, 86, 22, 79, 87, 93, 23, 93, 77, 74, 23, 76, 81, 93, 2, 73, 75, 86, 95, 80, 85, 92, 4, 73, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 54, 55, 54, 100, 87, 86, 87, 71, 79, 73, 66, 79, 50, 52, 63, 34, 74, 65, 64, 69, 77, 104, 93, 70, 68, 122, 64, 83, 76, 9, 68, 92, 90, 93, 9, 75, 76, 9, 89, 70, 90, 64, 93, 64, 95, 76, 49, 37, 58, 54, 119, 54, 35, 56, 58, 119, 62, 36, 119, 58, 54, 57, 51, 54, 35, 56, 37, 46, 59, 43, 32, 33, 104, 41, 60, 39, 37, 104, 33, 59, 104, 37, 41, 38, 44, 41, 60, 39, 58, 49, 15, 30, 21, 24, 91, 26, 15, 20, 22, 91, 18, 8, 91, 22, 26, 21, 31, 26, 15, 20, 9, 2, 5, 26, 23, 22, 28, 92, 64, 20, 3, 3, 67, 92, 81, 80, 90, 26, 84, 67, 5, 4, 35, 60, 49, 48, 58, 122, 52, 35, 54, 72, 87, 90, 91, 81, 17, 90, 81, 82, 92, 71, 19, 72, 87, 77, 87, 81, 80, 68, 91, 86, 87, 93, 29, 90, 87, 68, 81, 26, 5, 8, 9, 3, 67, 1, 28, 9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 95, 64, 77, 76, 70, 6, 81, 4, 95, 71, 77, 7, 70, 71, 27, 7, 95, 89, 17, 3, 28, 17, 16, 26, 90, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 88, 3, 27, 17, 91, 26, 27, 71, 91, 3, 5, 76};
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008a, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
    
        if (r6 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
    
        r3 = new com.facebook.ads.redexgen.core.C01722p().A0g(r37).A11(r6).A0w(r13).A0r(r29).A0f(r28).A0Y(r27).A0l(r38).A13(r26).A0o(r11).A12(r12).A0u(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
    
        if (r8 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f2, code lost:
    
        if (r5 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f4, code lost:
    
        if (r7 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f6, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00f9, code lost:
    
        if (r4 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fb, code lost:
    
        r4 = r4.array();
        r2 = com.facebook.ads.redexgen.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0111, code lost:
    
        if (r2[7].charAt(30) == r2[4].charAt(30)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0113, code lost:
    
        r2 = com.facebook.ads.redexgen.core.J0.A01;
        r2[1] = "iNSGYMD2WjZqNKpCGRiE11Ag0KcZMJ4O";
        r2[6] = "kUdBVFFCHZ7OFsLW60c88KXDOWnZQcPh";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011f, code lost:
    
        r3.A0t(new com.facebook.ads.androidx.media3.common.ColorInfo(r8, r5, r7, r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0127, code lost:
    
        if (r17 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0129, code lost:
    
        r3.A0a(com.facebook.ads.redexgen.core.AbstractC0365As.A03(r17.A00)).A0j(com.facebook.ads.redexgen.core.AbstractC0365As.A03(r17.A01));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0140, code lost:
    
        r40.A02 = r3.A14();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0148, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0149, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b6 A[PHI: r2
      0x01b6: PHI (r2v12 int) = (r2v11 int), (r2v56 int) binds: [B:58:0x01b3, B:48:0x0171] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0284  */
    @MetaExoPlayerCustomization("Adding Colorspace support for AV1")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0R(C02284v c02284v, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, C0574Iy c0574Iy, int i6) throws C3K {
        int iA0C;
        String[] strArr;
        DrmInitData drmInitDataA01 = drmInitData;
        int iIntValue = i;
        c02284v.A0f(i2 + 8 + 8);
        c02284v.A0g(16);
        int iA0M = c02284v.A0M();
        int iA0M2 = c02284v.A0M();
        boolean z = false;
        float fA00 = 1.0f;
        c02284v.A0g(50);
        int iA09 = c02284v.A09();
        if (iIntValue == 1701733238) {
            Pair<Integer, JP> pairA08 = A08(c02284v, i2, i3);
            if (pairA08 != null) {
                iIntValue = ((Integer) pairA08.first).intValue();
                drmInitDataA01 = drmInitDataA01 == null ? null : drmInitDataA01.A01(((JP) pairA08.second).A02);
                c0574Iy.A03[i6] = (JP) pairA08.second;
            }
            c02284v.A0f(iA09);
        }
        String strA0M = null;
        if (iIntValue == 1831958048) {
            strA0M = A0M(1243, 10, 10);
        } else if (iIntValue == 1211250227) {
            strA0M = A0M(1186, 10, 21);
        }
        List<byte[]> listA04 = null;
        String str = null;
        byte[] bArrA0W = null;
        int i7 = -1;
        C0572Iw c0572IwA0G = null;
        int iA00 = -1;
        int i8 = -1;
        int iA01 = -1;
        ByteBuffer byteBufferA0N = null;
        while (true) {
            int i9 = iA09 - i2;
            if (A01[5].charAt(23) == 'W') {
                A01[5] = "UV8763Z4eJ1eqclMrzFGVnLWDHgV5Y7v";
                if (i9 < i3) {
                    c02284v.A0f(iA09);
                    int iA092 = c02284v.A09();
                    int iA0C2 = c02284v.A0C();
                    if (iA0C2 != 0 || c02284v.A09() - i2 != i3) {
                        boolean z2 = iA0C2 > 0;
                        String strA0M2 = A0M(1090, 30, 79);
                        if (A01[5].charAt(23) != 'W') {
                            HB.A01(z2, strA0M2);
                            iA0C = c02284v.A0C();
                            if (iA0C == 1635148611) {
                                HB.A01(strA0M == null, null);
                                strA0M = A0M(1206, 9, 51);
                                c02284v.A0f(iA092 + 8);
                                C0520Gv c0520GvA00 = C0520Gv.A00(c02284v);
                                listA04 = c0520GvA00.A05;
                                c0574Iy.A00 = c0520GvA00.A02;
                                if (!z) {
                                    fA00 = c0520GvA00.A00;
                                }
                                str = c0520GvA00.A04;
                            } else if (iA0C == 1752589123) {
                                HB.A01(strA0M == null, null);
                                strA0M = A0M(1233, 10, 84);
                                c02284v.A0f(iA092 + 8);
                                HL hlA00 = HL.A00(c02284v);
                                listA04 = hlA00.A08;
                                c0574Iy.A00 = hlA00.A05;
                                if (!z) {
                                    fA00 = hlA00.A00;
                                }
                                str = hlA00.A07;
                                iA00 = hlA00.A02;
                                i8 = hlA00.A01;
                                iA01 = hlA00.A03;
                            } else if (iA0C == 1685480259 || iA0C == 1685485123) {
                                H6 h6A00 = H6.A00(c02284v);
                                if (h6A00 != null) {
                                    str = h6A00.A02;
                                    strA0M = A0M(1215, 18, 88);
                                }
                            } else if (iA0C == 1987076931) {
                                HB.A01(strA0M == null, null);
                                strA0M = iIntValue == 1987063864 ? A0M(1253, 19, 79) : A0M(1272, 19, 19);
                                c02284v.A0f(iA092 + 12);
                                c02284v.A0g(2);
                                boolean z3 = (c02284v.A0I() & 1) != 0;
                                int iA0I = c02284v.A0I();
                                int iA0I2 = c02284v.A0I();
                                iA00 = ColorInfo.A00(iA0I);
                                i8 = z3 ? 1 : 2;
                                iA01 = ColorInfo.A01(iA0I2);
                            } else {
                                String[] strArr2 = A01;
                                if (strArr2[7].charAt(30) != strArr2[4].charAt(30)) {
                                    A01[5] = "obOtuNmXmw3Srs7TxB3R2veWOWOW6QJb";
                                    if (iA0C == 1635135811) {
                                        HB.A01(strA0M == null, null);
                                        strA0M = A0M(1196, 10, 83);
                                        c02284v.A0f(iA092 + 8);
                                        ColorInfo colorInfoA0B = A0B(c02284v);
                                        iA00 = colorInfoA0B.A02;
                                        i8 = colorInfoA0B.A01;
                                        iA01 = colorInfoA0B.A03;
                                    } else if (iA0C == 1668050025) {
                                        if (byteBufferA0N == null) {
                                            byteBufferA0N = A0N();
                                        }
                                        byteBufferA0N.position(21);
                                        byteBufferA0N.putShort(c02284v.A0b());
                                        byteBufferA0N.putShort(c02284v.A0b());
                                        if (A01[5].charAt(23) != 'W') {
                                            String[] strArr3 = A01;
                                            strArr3[7] = "cMBnz4dZXlFeWyM9hfqqzsh9zqwjLPKg";
                                            strArr3[4] = "lv8fWd8FNFrcw1jaRvaQVznvgsfH83Rg";
                                        } else {
                                            String[] strArr4 = A01;
                                            strArr4[0] = "x7EuuBNN";
                                            strArr4[3] = "05WogHTT";
                                        }
                                    } else if (iA0C == 1835295606) {
                                        if (byteBufferA0N == null) {
                                            byteBufferA0N = A0N();
                                        }
                                        short sA0b = c02284v.A0b();
                                        short sA0b2 = c02284v.A0b();
                                        short sA0b3 = c02284v.A0b();
                                        short sA0b4 = c02284v.A0b();
                                        short sA0b5 = c02284v.A0b();
                                        short sA0b6 = c02284v.A0b();
                                        short sA0b7 = c02284v.A0b();
                                        short sA0b8 = c02284v.A0b();
                                        long jA0Q = c02284v.A0Q();
                                        long jA0Q2 = c02284v.A0Q();
                                        byteBufferA0N.position(1);
                                        byteBufferA0N.putShort(sA0b5);
                                        byteBufferA0N.putShort(sA0b6);
                                        byteBufferA0N.putShort(sA0b);
                                        byteBufferA0N.putShort(sA0b2);
                                        byteBufferA0N.putShort(sA0b3);
                                        byteBufferA0N.putShort(sA0b4);
                                        byteBufferA0N.putShort(sA0b7);
                                        byteBufferA0N.putShort(sA0b8);
                                        byteBufferA0N.putShort((short) (jA0Q / 10000));
                                        byteBufferA0N.putShort((short) (jA0Q2 / 10000));
                                    } else if (iA0C == 1681012275) {
                                        HB.A01(strA0M == null, null);
                                        strA0M = A0M(1186, 10, 21);
                                    } else if (iA0C == 1702061171) {
                                        HB.A01(strA0M == null, null);
                                        c0572IwA0G = A0G(c02284v, iA092);
                                        strA0M = c0572IwA0G.A02;
                                        byte[] bArr = c0572IwA0G.A03;
                                        if (bArr != null) {
                                            listA04 = BP.A04(bArr);
                                        }
                                    } else if (iA0C == 1885434736) {
                                        fA00 = A00(c02284v, iA092);
                                        z = true;
                                    } else if (iA0C == 1937126244) {
                                        bArrA0W = A0W(c02284v, iA092, iA0C2);
                                    } else if (iA0C == 1936995172) {
                                        int iA0I3 = c02284v.A0I();
                                        c02284v.A0g(3);
                                        if (iA0I3 == 0) {
                                            switch (c02284v.A0I()) {
                                                case 0:
                                                    i7 = 0;
                                                    break;
                                                case 1:
                                                    i7 = 1;
                                                    break;
                                                case 2:
                                                    i7 = 2;
                                                    break;
                                                case 3:
                                                    i7 = 3;
                                                    break;
                                            }
                                        }
                                        String[] strArr5 = A01;
                                        if (strArr5[0].length() != strArr5[3].length()) {
                                            throw new RuntimeException();
                                        }
                                        String[] strArr6 = A01;
                                        strArr6[7] = "0aivzU98O0ZXtjwpHxuX2T7FoukhoekU";
                                        strArr6[4] = "nV94P8gaAxhOD3b386SRtcx64PXkWIfI";
                                    } else if (iA0C == 1668246642 && iA00 == -1 && i8 == -1 && iA01 == -1) {
                                        int iA0C3 = c02284v.A0C();
                                        if (iA0C3 == 1852009592 || iA0C3 == 1852009571) {
                                            int iA0M3 = c02284v.A0M();
                                            int iA0M4 = c02284v.A0M();
                                            c02284v.A0g(2);
                                            boolean z4 = iA0C2 == 19 && (c02284v.A0I() & 128) != 0;
                                            iA00 = ColorInfo.A00(iA0M3);
                                            i8 = z4 ? 1 : 2;
                                            iA01 = ColorInfo.A01(iA0M4);
                                        } else {
                                            AbstractC02134g.A07(A0M(178, 11, 68), A0M(470, 24, 105) + AbstractC0570Iu.A02(iA0C3));
                                            strArr = A01;
                                            if (strArr[7].charAt(30) == strArr[4].charAt(30)) {
                                            }
                                        }
                                    } else {
                                        strArr = A01;
                                        if (strArr[7].charAt(30) == strArr[4].charAt(30)) {
                                            String[] strArr7 = A01;
                                            strArr7[0] = "ZXEhGysO";
                                            strArr7[3] = "dMfXFnuv";
                                        } else {
                                            String[] strArr8 = A01;
                                            strArr8[0] = "PjY9iWjn";
                                            strArr8[3] = "RXgmgrZF";
                                        }
                                    }
                                } else if (iA0C == 1635135811) {
                                }
                            }
                        } else {
                            A01[2] = "a7F234D58gsc4SWrdwKeU3Lp";
                            HB.A01(z2, strA0M2);
                            iA0C = c02284v.A0C();
                            if (iA0C == 1635148611) {
                            }
                        }
                        iA09 += iA0C2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0T(C02284v c02284v, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, C0574Iy c0574Iy, int i5) throws C3K {
        int iA0M;
        int iA0J;
        int iIntValue = i;
        DrmInitData drmInitDataA01 = drmInitData;
        c02284v.A0f(i2 + 8 + 8);
        int iA0M2 = 0;
        if (z) {
            iA0M2 = c02284v.A0M();
            c02284v.A0g(6);
        } else {
            c02284v.A0g(8);
        }
        int iA0C = 0;
        int i6 = -1;
        String str2 = null;
        C0572Iw c0572IwA0G = null;
        if (A01[2].length() == 24) {
            String[] strArr = A01;
            strArr[0] = "6JAwliLs";
            strArr[3] = "MHNM5nZH";
            if (iA0M2 == 0 || iA0M2 == 1) {
                iA0M = c02284v.A0M();
                c02284v.A0g(6);
                iA0J = c02284v.A0J();
                c02284v.A0f(c02284v.A09() - 4);
                iA0C = c02284v.A0C();
                if (iA0M2 == 1) {
                    c02284v.A0g(16);
                }
            } else {
                if (iA0M2 != 2) {
                    return;
                }
                c02284v.A0g(16);
                iA0J = (int) Math.round(c02284v.A06());
                iA0M = c02284v.A0L();
                c02284v.A0g(20);
            }
            int iA09 = c02284v.A09();
            if (iIntValue == 1701733217) {
                Pair<Integer, JP> pairA08 = A08(c02284v, i2, i3);
                if (pairA08 != null) {
                    iIntValue = ((Integer) pairA08.first).intValue();
                    if (drmInitDataA01 != null) {
                        drmInitDataA01 = drmInitDataA01.A01(((JP) pairA08.second).A02);
                    } else if (A01[2].length() != 24) {
                        drmInitDataA01 = null;
                    } else {
                        String[] strArr2 = A01;
                        strArr2[0] = "GRTMmxkT";
                        strArr2[3] = "8R10f2wp";
                        drmInitDataA01 = null;
                    }
                    JP[] jpArr = c0574Iy.A03;
                    JP jp = (JP) pairA08.second;
                    String[] strArr3 = A01;
                    if (strArr3[1].charAt(26) != strArr3[6].charAt(26)) {
                        String[] strArr4 = A01;
                        strArr4[7] = "lvh8KGFHktoLjastkJ82cPetj14Rk4EU";
                        strArr4[4] = "lCZg4scnRLhDwR3AaCs1YjGUJehF9RDz";
                        jpArr[i5] = jp;
                    } else {
                        String[] strArr5 = A01;
                        strArr5[0] = "dju2geGd";
                        strArr5[3] = "bzT2ebja";
                        jpArr[i5] = jp;
                    }
                } else {
                    String[] strArr6 = A01;
                    if (strArr6[0].length() != strArr6[3].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr7 = A01;
                    strArr7[7] = "gPFMLbY3dC1lU3feUmGywMAQlXFn4oyw";
                    strArr7[4] = "p7gqQJ524nkvgJLmUWGAgmNX9hqHunnJ";
                }
                c02284v.A0f(iA09);
            }
            String strA0M = null;
            if (iIntValue == 1633889587) {
                strA0M = A0M(822, 9, 61);
            } else if (iIntValue == 1700998451) {
                strA0M = A0M(862, 10, 74);
            } else if (iIntValue == 1633889588) {
                String[] strArr8 = A01;
                if (strArr8[7].charAt(30) != strArr8[4].charAt(30)) {
                    String[] strArr9 = A01;
                    strArr9[0] = "ajRR6yPd";
                    strArr9[3] = "wapOpR6f";
                    strA0M = A0M(831, 9, 45);
                } else {
                    strA0M = A0M(831, 9, 45);
                }
            } else if (iIntValue == 1685353315) {
                String[] strArr10 = A01;
                if (strArr10[1].charAt(26) != strArr10[6].charAt(26)) {
                    A01[2] = "KJpCB4t3K52AuUO24XLWBqo9";
                    strA0M = A0M(989, 13, 117);
                }
            } else {
                String[] strArr11 = A01;
                if (strArr11[7].charAt(30) != strArr11[4].charAt(30)) {
                    String[] strArr12 = A01;
                    strArr12[1] = "E8vPAuGqR2xNMC3W8Z6piDguEQA0iYD6";
                    strArr12[6] = "JqGyLM9U6ZTAdL5rS6oZcwJBCNvZXK39";
                    if (iIntValue != 1685353320) {
                        if (iIntValue == 1685353324) {
                            strA0M = A0M(1002, 16, 39);
                        } else if (iIntValue == 1685353317) {
                            strA0M = A0M(1018, 28, 67);
                        } else if (iIntValue == 1685353336) {
                            strA0M = A0M(1046, 28, 95);
                        } else {
                            String[] strArr13 = A01;
                            if (strArr13[0].length() != strArr13[3].length()) {
                                String[] strArr14 = A01;
                                strArr14[0] = "UBbPjz2J";
                                strArr14[3] = "vZen3GMl";
                                if (iIntValue == 1935764850) {
                                    strA0M = A0M(812, 10, 87);
                                } else if (iIntValue == 1935767394) {
                                    strA0M = A0M(850, 12, 37);
                                } else if (iIntValue == 1819304813 || iIntValue == 1936684916) {
                                    strA0M = A0M(967, 9, 94);
                                    i6 = 2;
                                } else if (iIntValue == 1953984371) {
                                    strA0M = A0M(967, 9, 94);
                                    i6 = ClientDefaults.MAX_MSG_SIZE;
                                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                                    strA0M = A0M(947, 10, 17);
                                } else if (iIntValue == 1835557169) {
                                    strA0M = A0M(912, 10, 37);
                                } else if (iIntValue == 1835560241) {
                                    strA0M = A0M(922, 10, 16);
                                } else if (iIntValue == 1634492771) {
                                    if (A01[2].length() != 24) {
                                        String[] strArr15 = A01;
                                        strArr15[7] = "Tx0aPYhLQcdbhycZDJ63DJlxAHLYnZiL";
                                        strArr15[4] = "3h5vNAL3r5q44mC2VqL1y1SAaDe1rbn7";
                                        strA0M = A0M(840, 1, 31);
                                    } else {
                                        A01[5] = "qx3Rs2jX7JB6Nuy9TisbRByWp1zn9Qj8";
                                        strA0M = A0M(840, 10, 41);
                                    }
                                } else if (iIntValue == 1634492791) {
                                    strA0M = A0M(882, 15, 96);
                                } else if (iIntValue == 1970037111) {
                                    strA0M = A0M(897, 15, 77);
                                } else if (iIntValue == 1332770163) {
                                    strA0M = A0M(957, 10, 67);
                                } else if (iIntValue == 1716281667) {
                                    strA0M = A0M(872, 10, 4);
                                } else if (iIntValue == 1835823201) {
                                    strA0M = A0M(976, 13, 77);
                                }
                            } else {
                                A01[2] = "gBDk9Jrqoo24V0L1mHSTaoLt";
                                if (iIntValue == 1935764850) {
                                }
                            }
                        }
                    }
                } else {
                    String[] strArr16 = A01;
                    strArr16[0] = "jXw0aAnX";
                    strArr16[3] = "tHH1zIUY";
                    if (iIntValue != 1685353320) {
                    }
                }
            }
            List<byte[]> listA04 = null;
            while (iA09 - i2 < i3) {
                c02284v.A0f(iA09);
                int iA0C2 = c02284v.A0C();
                boolean z2 = iA0C2 > 0;
                String strA0M2 = A0M(1090, 30, 79);
                String[] strArr17 = A01;
                if (strArr17[7].charAt(30) != strArr17[4].charAt(30)) {
                    A01[2] = "1WqyRoRGMALZfYpxNfh8k5AQ";
                    HB.A01(z2, strA0M2);
                    int iA0C3 = c02284v.A0C();
                    if (iA0C3 == 1835557187) {
                        int i7 = iA0C2 - 13;
                        byte[] bArr = new byte[i7];
                        c02284v.A0f(13 + iA09);
                        c02284v.A0k(bArr, 0, i7);
                        listA04 = BP.A04(bArr);
                    } else if (iA0C3 == 1702061171) {
                        int iA04 = iA0C3 == 1702061171 ? iA09 : A04(c02284v, 1702061171, iA09, iA0C2);
                        if (iA04 != -1) {
                            c0572IwA0G = A0G(c02284v, iA04);
                            strA0M = c0572IwA0G.A02;
                            byte[] bArr2 = c0572IwA0G.A03;
                            if (bArr2 != null) {
                                if (A0M(932, 15, 103).equals(strA0M)) {
                                    C0511Gm c0511GmA03 = AbstractC0512Gn.A03(bArr2);
                                    iA0J = c0511GmA03.A01;
                                    iA0M = c0511GmA03.A00;
                                    str2 = c0511GmA03.A02;
                                }
                                listA04 = BP.A04(bArr2);
                            }
                        }
                    } else {
                        if (z) {
                            if (A01[5].charAt(23) == 'W') {
                                String[] strArr18 = A01;
                                strArr18[0] = "uRIbW45A";
                                strArr18[3] = "EDIb1o31";
                                if (iA0C3 == 2002876005) {
                                }
                            } else if (iA0C3 == 2002876005) {
                            }
                        }
                        if (iA0C3 == 1684103987) {
                            c02284v.A0f(iA09 + 8);
                            c0574Iy.A02 = AbstractC0516Gr.A07(c02284v, Integer.toString(i4), str, drmInitDataA01);
                        } else if (iA0C3 == 1684366131) {
                            c02284v.A0f(iA09 + 8);
                            c0574Iy.A02 = AbstractC0516Gr.A08(c02284v, Integer.toString(i4), str, drmInitDataA01);
                        } else if (iA0C3 == 1684103988) {
                            c02284v.A0f(iA09 + 8);
                            c0574Iy.A02 = AbstractC0519Gu.A03(c02284v, Integer.toString(i4), str, drmInitDataA01);
                        } else {
                            String[] strArr19 = A01;
                            if (strArr19[7].charAt(30) != strArr19[4].charAt(30)) {
                                String[] strArr20 = A01;
                                strArr20[7] = "XWUeG0Lj6KL9JW7Z7jfQ0rtemNqiryGw";
                                strArr20[4] = "DGFAmtAGFYrNnmS6p9Hy3BCjcLzUjlt2";
                                if (iA0C3 == 1684892784) {
                                    if (iA0C <= 0) {
                                        throw C3K.A01(A0M(239, 49, 39) + iA0C, null);
                                    }
                                    iA0M = 2;
                                    iA0J = iA0C;
                                } else if (iA0C3 == 1684305011 || iA0C3 == 1969517683) {
                                    c0574Iy.A02 = new C01722p().A0g(i4).A11(strA0M).A0b(iA0M).A0m(iA0J).A0u(drmInitDataA01).A10(str).A14();
                                } else if (iA0C3 == 1682927731) {
                                    int i8 = iA0C2 - 8;
                                    byte[] bArrCopyOf = Arrays.copyOf(A02, A02.length + i8);
                                    c02284v.A0f(iA09 + 8);
                                    c02284v.A0k(bArrCopyOf, A02.length, i8);
                                    listA04 = HT.A06(bArrCopyOf);
                                } else if (iA0C3 == 1684425825) {
                                    int i9 = iA0C2 - 12;
                                    byte[] bArr3 = new byte[i9 + 4];
                                    bArr3[0] = 102;
                                    bArr3[1] = 76;
                                    bArr3[2] = 97;
                                    bArr3[3] = 67;
                                    c02284v.A0f(iA09 + 12);
                                    c02284v.A0k(bArr3, 4, i9);
                                    listA04 = BP.A04(bArr3);
                                } else if (iA0C3 == 1634492771) {
                                    int i10 = iA0C2 - 12;
                                    byte[] bArr4 = new byte[i10];
                                    c02284v.A0f(iA09 + 12);
                                    c02284v.A0k(bArr4, 0, i10);
                                    Pair<Integer, Integer> pairA00 = AnonymousClass46.A00(bArr4);
                                    iA0J = ((Integer) pairA00.first).intValue();
                                    iA0M = ((Integer) pairA00.second).intValue();
                                    listA04 = BP.A04(bArr4);
                                }
                            } else if (iA0C3 == 1684892784) {
                            }
                        }
                    }
                    iA09 += iA0C2;
                }
            }
            if (c0574Iy.A02 != null || strA0M == null) {
                return;
            }
            C01722p c01722pA10 = new C01722p().A0g(i4).A11(strA0M).A0w(str2).A0b(iA0M).A0m(iA0J).A0i(i6).A12(listA04).A0u(drmInitDataA01).A10(str);
            if (c0572IwA0G != null) {
                c01722pA10.A0a(AbstractC0365As.A03(c0572IwA0G.A00)).A0j(AbstractC0365As.A03(c0572IwA0G.A01));
            }
            c0574Iy.A02 = c01722pA10.A14();
            return;
        }
        throw new RuntimeException();
    }

    static {
        A0P();
        A03 = new int[]{-3374493, -128628077, -2011932550, 38936541};
        A02 = C5C.A1G(A0M(351, 8, 8));
    }

    public static float A00(C02284v c02284v, int i) {
        c02284v.A0f(i + 8);
        int vSpacing = c02284v.A0L();
        int hSpacing = c02284v.A0L();
        return vSpacing / hSpacing;
    }

    public static int A01(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "Iy7m3jJh";
        strArr2[3] = "9tkcHcc8";
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        if (i == 1835365473) {
            return 5;
        }
        return -1;
    }

    public static int A02(C02284v c02284v) {
        int iA0I = c02284v.A0I();
        int i = iA0I & 127;
        while (true) {
            int i2 = iA0I & 128;
            String[] strArr = A01;
            String str = strArr[7];
            String str2 = strArr[4];
            int size = str.charAt(30);
            int currentByte = str2.charAt(30);
            if (size == currentByte) {
                throw new RuntimeException();
            }
            A01[5] = "pSNibJ1kKp1RE21akOqiyNuWX3n84SWQ";
            if (i2 == 128) {
                iA0I = c02284v.A0I();
                int i3 = i << 7;
                String[] strArr2 = A01;
                String str3 = strArr2[0];
                String str4 = strArr2[3];
                int size2 = str3.length();
                int currentByte2 = str4.length();
                if (size2 != currentByte2) {
                    String[] strArr3 = A01;
                    strArr3[0] = "dUXzi2Ex";
                    strArr3[3] = "FqHw8aws";
                    int currentByte3 = iA0I & 127;
                    i = i3 | currentByte3;
                } else {
                    A01[2] = "53iEjHDa99dBpQfClHLnj3Lr";
                    int currentByte4 = iA0I & 127;
                    i = i3 | currentByte4;
                }
            } else {
                return i;
            }
        }
    }

    public static int A03(C02284v c02284v) {
        c02284v.A0f(16);
        return c02284v.A0C();
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A04(C02284v c02284v, int i, int i2, int i3) throws C3K {
        int childAtomSize = c02284v.A09();
        HB.A01(childAtomSize >= i2, null);
        while (childAtomPosition < i3) {
            c02284v.A0f(childAtomSize);
            int iA0C = c02284v.A0C();
            boolean z = iA0C > 0;
            if (A01[5].charAt(23) != 'W') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "6gtDIh58mAlo0zqgdjwPUqi1ndJRBK82";
            strArr[4] = "DRBAnAjKoyJp6qnYv3HHxzBKoLLYYD5q";
            HB.A01(z, A0M(1090, 30, 79));
            int childAtomPosition = c02284v.A0C();
            if (childAtomPosition == i) {
                return childAtomSize;
            }
            childAtomSize += iA0C;
        }
        return -1;
    }

    public static long A05(C02284v c02284v) {
        int fullAtom = 8;
        c02284v.A0f(8);
        if (AbstractC0570Iu.A01(c02284v.A0C()) != 0) {
            fullAtom = 16;
        }
        c02284v.A0g(fullAtom);
        return c02284v.A0Q();
    }

    public static Pair<Long, String> A06(C02284v c02284v) {
        c02284v.A0f(8);
        int fullAtom = AbstractC0570Iu.A01(c02284v.A0C());
        int languageCode = fullAtom == 0 ? 8 : 16;
        c02284v.A0g(languageCode);
        long jA0Q = c02284v.A0Q();
        int version = fullAtom == 0 ? 4 : 8;
        c02284v.A0g(version);
        int iA0M = c02284v.A0M();
        int languageCode2 = iA0M >> 10;
        StringBuilder sbAppend = new StringBuilder().append(A0M(0, 0, 93)).append((char) ((languageCode2 & 31) + 96));
        int languageCode3 = iA0M >> 5;
        StringBuilder sbAppend2 = sbAppend.append((char) ((languageCode3 & 31) + 96));
        int languageCode4 = iA0M & 31;
        return Pair.create(Long.valueOf(jA0Q), sbAppend2.append((char) (languageCode4 + 96)).toString());
    }

    public static Pair<Integer, JP> A07(C02284v c02284v, int i, int i2) throws C3K {
        int i3 = i + 8;
        int childAtomType = -1;
        int childAtomSize = 0;
        String strA0W = null;
        Integer numValueOf = null;
        while (true) {
            int childPosition = i3 - i;
            if (childPosition < i2) {
                c02284v.A0f(i3);
                int iA0C = c02284v.A0C();
                int iA0C2 = c02284v.A0C();
                int schemeInformationBoxPosition = A01[2].length();
                if (schemeInformationBoxPosition != 24) {
                    break;
                }
                String[] strArr = A01;
                strArr[0] = "312zVnav";
                strArr[3] = "fwhHyPzp";
                if (iA0C2 == 1718775137) {
                    int childPosition2 = c02284v.A0C();
                    numValueOf = Integer.valueOf(childPosition2);
                } else if (iA0C2 == 1935894637) {
                    c02284v.A0g(4);
                    strA0W = c02284v.A0W(4);
                } else if (iA0C2 == 1935894633) {
                    childAtomType = i3;
                    childAtomSize = iA0C;
                }
                i3 += iA0C;
            } else {
                int schemeInformationBoxPosition2 = A01[2].length();
                if (schemeInformationBoxPosition2 == 24) {
                    A01[5] = "Q2dt9svTwucQVjxlQtJloRQWafbIItZ7";
                    if (A0M(1082, 4, 74).equals(strA0W) || A0M(1074, 4, 51).equals(strA0W) || A0M(1086, 4, 55).equals(strA0W) || A0M(1078, 4, 82).equals(strA0W)) {
                        boolean z = true;
                        HB.A01(numValueOf != null, A0M(1120, 22, 49));
                        HB.A01(childAtomType != -1, A0M(1142, 22, 46));
                        JP jpA0K = A0K(c02284v, childAtomType, childAtomSize, strA0W);
                        if (jpA0K == null) {
                            z = false;
                        }
                        HB.A01(z, A0M(1164, 22, 29));
                        return Pair.create(numValueOf, (JP) C5C.A0f(jpA0K));
                    }
                    return null;
                }
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050 A[PHI: r0
      0x0050: PHI (r0v16 'childPosition' int) = (r0v13 'childPosition' int), (r0v19 'childPosition' int) binds: [B:20:0x007e, B:12:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081 A[PHI: r0
      0x0081: PHI (r0v14 'childPosition' int) = (r0v13 'childPosition' int), (r0v19 'childPosition' int) binds: [B:20:0x007e, B:12:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, JP> A08(C02284v c02284v, int i, int i2) throws C3K {
        int childPosition;
        boolean z;
        Pair<Integer, JP> pairA07;
        int iA09 = c02284v.A09();
        while (true) {
            int i3 = iA09 - i;
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[3];
            int length = str.length();
            int childPosition2 = str2.length();
            if (length != childPosition2) {
                throw new RuntimeException();
            }
            A01[2] = "alPn9WvAmZr8sIghV9sZ4SJG";
            if (i3 < i2) {
                c02284v.A0f(iA09);
                String[] strArr2 = A01;
                String str3 = strArr2[1];
                String str4 = strArr2[6];
                int iCharAt = str3.charAt(26);
                int childPosition3 = str4.charAt(26);
                if (iCharAt != childPosition3) {
                    String[] strArr3 = A01;
                    strArr3[0] = "bSC6gQO3";
                    strArr3[3] = "sEisHoVo";
                    childPosition = c02284v.A0C();
                    z = childPosition > 0;
                } else {
                    String[] strArr4 = A01;
                    strArr4[1] = "sCQufaVXehZdAx160HDrkvqq2FYTSg6V";
                    strArr4[6] = "xgFgm7GbjtAXUGsxujgneuzUGgVoDuJS";
                    childPosition = c02284v.A0C();
                    if (childPosition > 0) {
                    }
                }
                HB.A01(z, A0M(1090, 30, 79));
                int childAtomType = c02284v.A0C();
                if (childAtomType == 1936289382 && (pairA07 = A07(c02284v, iA09, childPosition)) != null) {
                    return pairA07;
                }
                iA09 += childPosition;
            } else {
                return null;
            }
        }
    }

    public static Pair<long[], long[]> A09(C1744mE c1744mE) {
        long jA0P;
        C1743mD elstAtom = c1744mE.A07(1701606260);
        if (elstAtom == null) {
            return null;
        }
        C02284v c02284v = elstAtom.A00;
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "nlx0JEXKjNTNdSyjBy8qhdzuridSUNe7";
        strArr2[4] = "QPF9oPdHODxNb0EXvgymvar5stnTE0Tg";
        c02284v.A0f(8);
        int version = AbstractC0570Iu.A01(c02284v.A0C());
        int fullAtom = c02284v.A0L();
        long[] jArr = new long[fullAtom];
        long[] jArr2 = new long[fullAtom];
        for (int i = 0; i < fullAtom; i++) {
            jArr[i] = version == 1 ? c02284v.A0R() : c02284v.A0Q();
            if (version == 1) {
                jA0P = c02284v.A0P();
            } else {
                int entryCount = c02284v.A0C();
                jA0P = entryCount;
            }
            jArr2[i] = jA0P;
            int entryCount2 = c02284v.A0b();
            if (entryCount2 == 1) {
                c02284v.A0g(2);
            } else {
                throw new IllegalArgumentException(A0M(540, 23, 90));
            }
        }
        return Pair.create(jArr, jArr2);
    }

    public static Pair<Metadata, Metadata> A0A(C1743mD c1743mD) {
        C02284v c02284v = c1743mD.A00;
        c02284v.A0f(8);
        Metadata metadataA0E = null;
        Metadata metadataA0D = null;
        while (true) {
            int iA07 = c02284v.A07();
            String[] strArr = A01;
            if (strArr[7].charAt(30) == strArr[4].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "ATF6ss1I";
            strArr2[3] = "jntry4xS";
            if (iA07 >= 8) {
                int iA09 = c02284v.A09();
                int iA0C = c02284v.A0C();
                int iA0C2 = c02284v.A0C();
                if (iA0C2 == 1835365473) {
                    c02284v.A0f(iA09);
                    metadataA0E = A0E(c02284v, iA09 + iA0C);
                } else if (iA0C2 == 1936553057) {
                    c02284v.A0f(iA09);
                    metadataA0D = A0D(c02284v, iA09 + iA0C);
                }
                c02284v.A0f(iA09 + iA0C);
            } else {
                return Pair.create(metadataA0E, metadataA0D);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return new com.facebook.ads.androidx.media3.common.Metadata(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Metadata A0C(C02284v c02284v, int i) {
        c02284v.A0g(8);
        ArrayList arrayList = new ArrayList();
        while (c02284v.A09() < i) {
            Id3Frame id3FrameA04 = JB.A04(c02284v);
            if (A01[2].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "lHUs7TBcARFSvdLvQvihflkVmEpZ1MYm";
            strArr[4] = "ww6ZL200nHcHREaExV9g08P8Dpl3Z1fQ";
            if (id3FrameA04 != null) {
                arrayList.add(id3FrameA04);
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        String[] strArr2 = A01;
        if (strArr2[1].charAt(26) != strArr2[6].charAt(26)) {
            String[] strArr3 = A01;
            strArr3[7] = "WnDUA4AhIDsAjF22CXXz4OtQUCX0JoWn";
            strArr3[4] = "j7UA12dewj7emLVLNadXlb6UYVuvbHls";
        }
    }

    public static Metadata A0D(C02284v c02284v, int i) {
        c02284v.A0g(12);
        while (true) {
            int iA09 = c02284v.A09();
            if (A01[5].charAt(23) != 'W') {
                throw new RuntimeException();
            }
            A01[2] = "yKVAIw0tCkGB7M4Cua27Coqh";
            if (iA09 >= i) {
                return null;
            }
            int atomSize = c02284v.A09();
            int iA0C = c02284v.A0C();
            int atomPosition = c02284v.A0C();
            if (atomPosition == 1935766900) {
                if (iA0C < 14) {
                    return null;
                }
                c02284v.A0g(5);
                int iA0I = c02284v.A0I();
                if (iA0I != 12 && iA0I != 13) {
                    return null;
                }
                float f = iA0I == 12 ? 240.0f : 120.0f;
                c02284v.A0g(1);
                return new Metadata(new SmtaMetadataEntry(f, c02284v.A0I()));
            }
            c02284v.A0f(atomSize + iA0C);
        }
    }

    public static Metadata A0E(C02284v c02284v, int i) {
        c02284v.A0g(8);
        A0Q(c02284v);
        while (c02284v.A09() < i) {
            int iA09 = c02284v.A09();
            int atomType = c02284v.A0C();
            int atomSize = c02284v.A0C();
            if (atomSize == 1768715124) {
                c02284v.A0f(iA09);
                return A0C(c02284v, iA09 + atomType);
            }
            c02284v.A0f(iA09 + atomType);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0574Iy A0H(C02284v c02284v, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws C3K {
        c02284v.A0f(12);
        int iA0C = c02284v.A0C();
        C0574Iy c0574Iy = new C0574Iy(iA0C);
        for (int childStartPosition = 0; childStartPosition < iA0C; childStartPosition++) {
            int iA09 = c02284v.A09();
            int iA0C2 = c02284v.A0C();
            HB.A01(iA0C2 > 0, A0M(1090, 30, 79));
            int iA0C3 = c02284v.A0C();
            if (iA0C3 != 1635148593 && iA0C3 != 1635148595 && iA0C3 != 1701733238 && iA0C3 != 1831958048 && iA0C3 != 1836070006 && iA0C3 != 1752589105 && iA0C3 != 1751479857 && iA0C3 != 1932670515 && iA0C3 != 1211250227 && iA0C3 != 1987063864 && iA0C3 != 1987063865 && iA0C3 != 1635135537 && iA0C3 != 1685479798 && iA0C3 != 1685479729 && iA0C3 != 1685481573 && iA0C3 != 1685481521) {
                if (A01[5].charAt(23) == 'W') {
                    String[] strArr = A01;
                    strArr[0] = "Lno9V07i";
                    strArr[3] = "YEniY2O3";
                    if (iA0C3 == 1836069985 || iA0C3 == 1701733217 || iA0C3 == 1633889587 || iA0C3 == 1700998451 || iA0C3 == 1633889588) {
                        A0T(c02284v, iA0C3, iA09, iA0C2, i, str, z, drmInitData, c0574Iy, childStartPosition);
                    } else if (A01[2].length() != 24) {
                        String[] strArr2 = A01;
                        strArr2[1] = "oNdMvJKT47PBcE7ne9hrfWimoE8yMs3Y";
                        strArr2[6] = "E91ArCAwNKvmlCTKVUGyb2erGBttgGv0";
                        if (iA0C3 != 1835823201) {
                            if (iA0C3 != 1685353315 && iA0C3 != 1685353317 && iA0C3 != 1685353320 && iA0C3 != 1685353324 && iA0C3 != 1685353336 && iA0C3 != 1935764850 && iA0C3 != 1935767394 && iA0C3 != 1819304813 && iA0C3 != 1936684916 && iA0C3 != 1953984371 && iA0C3 != 778924082 && iA0C3 != 778924083 && iA0C3 != 1835557169 && iA0C3 != 1835560241 && iA0C3 != 1634492771 && iA0C3 != 1634492791 && iA0C3 != 1970037111 && iA0C3 != 1332770163 && iA0C3 != 1716281667) {
                                String[] strArr3 = A01;
                                if (strArr3[0].length() == strArr3[3].length()) {
                                    A01[5] = "mlJGx5h1gegl7007OPiYCkGWkqECmimV";
                                    if (iA0C3 == 1414810956) {
                                        iA09 = iA09;
                                        iA0C2 = iA0C2;
                                        A0S(c02284v, iA0C3, iA09, iA0C2, i, str, c0574Iy);
                                    } else {
                                        if (A01[5].charAt(23) != 'W') {
                                            throw new RuntimeException();
                                        }
                                        A01[2] = "522w9jUs1Cdec5FzFXJEv7rx";
                                        if (iA0C3 != 1954034535 && iA0C3 != 2004251764 && iA0C3 != 1937010800 && iA0C3 != 1664495672) {
                                            if (iA0C3 == 1835365492) {
                                                A0U(c02284v, iA0C3, iA09, i, c0574Iy);
                                            } else if (iA0C3 == 1667329389) {
                                                c0574Iy.A02 = new C01722p().A0g(i).A11(A0M(711, 27, 38)).A14();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        A01[2] = "3e9ArAGLRrjfeL1rnoEKSVyw";
                        if (iA0C3 != 1835823201) {
                        }
                    }
                }
                throw new RuntimeException();
            }
            A0R(c02284v, iA0C3, iA09, iA0C2, i, i2, drmInitData, c0574Iy, childStartPosition);
            c02284v.A0f(iA09 + iA0C2);
        }
        return c0574Iy;
    }

    public static ByteBuffer A0N() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kO != com.google.common.base.Function<com.facebook.ads.androidx.media3.extractor.mp4.Track, com.facebook.ads.androidx.media3.extractor.mp4.Track> */
    public static List<JR> A0O(C1744mE c1744mE, HK hk, long j, DrmInitData drmInitData, boolean z, boolean z2, InterfaceC1632kO<JO, JO> interfaceC1632kO) throws C3K {
        JO joA4B;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c1744mE.A01.size(); i++) {
            C1744mE c1744mE2 = c1744mE.A01.get(i);
            if (((AbstractC0570Iu) c1744mE2).A00 == 1953653099 && (joA4B = interfaceC1632kO.A4B(A0J(c1744mE2, (C1743mD) AbstractC02053y.A01(c1744mE.A07(1836476516)), j, drmInitData, z, z2))) != null) {
                C1744mE c1744mE3 = (C1744mE) AbstractC02053y.A01(c1744mE2.A06(1835297121));
                if (A01[2].length() != 24) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "jveTcVJC";
                strArr[3] = "kDhQUkZe";
                arrayList.add(A0L(joA4B, (C1744mE) AbstractC02053y.A01(((C1744mE) AbstractC02053y.A01(c1744mE3.A06(1835626086))).A06(1937007212)), hk));
            }
        }
        return arrayList;
    }

    public static void A0Q(C02284v c02284v) {
        int iA09 = c02284v.A09();
        c02284v.A0g(4);
        if (c02284v.A0C() != 1751411826) {
            iA09 += 4;
        }
        c02284v.A0f(iA09);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<byte[]> */
    public static void A0S(C02284v c02284v, int i, int i2, int i3, int i4, String str, C0574Iy c0574Iy) {
        String strA0M;
        c02284v.A0f(i2 + 8 + 8);
        BP bpA04 = null;
        long j = Long.MAX_VALUE;
        if (i == 1414810956) {
            strA0M = A0M(691, 20, 103);
        } else if (i == 1954034535) {
            strA0M = A0M(784, 28, 58);
            int sampleDescriptionLength = (i3 - 8) - 8;
            byte[] bArr = new byte[sampleDescriptionLength];
            c02284v.A0k(bArr, 0, sampleDescriptionLength);
            bpA04 = BP.A04(bArr);
        } else if (i == 2004251764) {
            strA0M = A0M(763, 21, 88);
        } else if (i == 1937010800) {
            strA0M = A0M(691, 20, 103);
            j = 0;
        } else if (i == 1664495672) {
            strA0M = A0M(738, 25, 73);
            c0574Iy.A01 = 1;
        } else {
            throw new IllegalStateException();
        }
        c0574Iy.A02 = new C01722p().A0g(i4).A11(strA0M).A10(str).A0s(j).A12(bpA04).A14();
    }

    public static void A0U(C02284v c02284v, int i, int i2, int i3, C0574Iy c0574Iy) {
        c02284v.A0f(i2 + 8 + 8);
        if (i == 1835365492) {
            c02284v.A0U();
            String strA0U = c02284v.A0U();
            if (strA0U != null) {
                c0574Iy.A02 = new C01722p().A0g(i3).A11(strA0U).A14();
            }
        }
    }

    public static boolean A0V(long[] jArr, long j, long j2, long j3) {
        int latestDelayIndex = jArr.length - 1;
        int iA07 = C5C.A07(4, 0, latestDelayIndex);
        int lastIndex = jArr.length;
        int latestDelayIndex2 = C5C.A07(lastIndex - 4, 0, latestDelayIndex);
        if (jArr[0] <= j2) {
            long j4 = jArr[iA07];
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[3];
            int length = str.length();
            int lastIndex2 = str2.length();
            if (length != lastIndex2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "4d2838LB6zuHL2SDSRFgaAe0bfX5eWcN";
            strArr2[4] = "2DmC9sheXkti4jYQDflGydtNBiOhlXlc";
            if (j2 < j4 && jArr[latestDelayIndex2] < j3 && j3 <= j) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] A0W(C02284v c02284v, int i, int i2) {
        int i3 = i + 8;
        while (childPosition < i2) {
            c02284v.A0f(i3);
            int iA0C = c02284v.A0C();
            int iA0C2 = c02284v.A0C();
            String[] strArr = A01;
            String str = strArr[7];
            String str2 = strArr[4];
            int childAtomSize = str.charAt(30);
            int childPosition = str2.charAt(30);
            if (childAtomSize == childPosition) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "QfAHDCYR";
            strArr2[3] = "If6V2JqI";
            if (iA0C2 == 1886547818) {
                int childPosition2 = i3 + iA0C;
                return Arrays.copyOfRange(c02284v.A0l(), i3, childPosition2);
            }
            i3 += iA0C;
        }
        return null;
    }
}
