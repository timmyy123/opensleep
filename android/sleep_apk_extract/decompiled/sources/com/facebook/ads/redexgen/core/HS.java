package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class HS {
    public static byte[] A00;
    public static int[] A01;
    public static String[] A02 = {"unNLyNh5FR3GyMG68d", "fnHIAbwwkFQ1ZGNlnsc", "DMpYp1jOlcNpO4pJgPWh22Zerf91QM8t", "RZoQ8h3", "L8G6Aqwau6BJqNFKfla", "ElXYWWCxJdBggdMs0Hio0yCYqdZAyfAp", "A3sl", "vST53OIiICW6hrmD3wtDRemD3zmWyZSx"};
    public static final byte[] A03;
    public static final float[] A04;
    public static final Object A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 24
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static HP A06(byte[] bArr, int i, int i2) {
        HU hu = new HU(bArr, i, i2);
        int iA00 = -1;
        int i3 = -1;
        int iA01 = -1;
        hu.A07(4);
        int iA05 = hu.A05(3);
        hu.A06();
        int iA052 = hu.A05(2);
        boolean zA0A = hu.A0A();
        int iA053 = hu.A05(5);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (A02[0].length() == 10) {
                break;
            }
            String[] strArr = A02;
            strArr[2] = "xkwe1O9uU2dqAY7xWUY4fbTlKQKyvcwL";
            strArr[7] = "HeYhRuPqM40BhEn67WYdTTzYcbU6v3bu";
            if (i5 < 32) {
                if (hu.A0A()) {
                    i4 |= 1 << i5;
                }
                i5++;
            } else {
                int[] iArr = new int[6];
                for (int i6 = 0; i6 < iArr.length; i6++) {
                    iArr[i6] = hu.A05(8);
                }
                int iA054 = hu.A05(8);
                int i7 = 0;
                for (int i8 = 0; i8 < iA05; i8++) {
                    if (hu.A0A()) {
                        i7 += 89;
                    }
                    if (hu.A0A()) {
                        i7 += 8;
                    }
                }
                hu.A07(i7);
                if (iA05 > 0) {
                    hu.A07((8 - iA05) * 2);
                }
                int iA04 = hu.A04();
                int iA042 = hu.A04();
                if (iA042 == 3) {
                    hu.A06();
                }
                int iA043 = hu.A04();
                int iA044 = hu.A04();
                if (hu.A0A()) {
                    int iA045 = hu.A04();
                    int iA046 = hu.A04();
                    int iA047 = hu.A04();
                    int iA048 = hu.A04();
                    iA043 -= (iA045 + iA046) * ((iA042 == 1 || iA042 == 2) ? 2 : 1);
                    int i9 = (iA047 + iA048) * (iA042 == 1 ? 2 : 1);
                    String[] strArr2 = A02;
                    if (strArr2[4].length() != strArr2[1].length()) {
                        A02[6] = "Hn3sdMz19WVmWCBK";
                        iA044 -= i9;
                    } else {
                        A02[3] = "Jz4JSkPN0248kFDgiRzzjLGO7q";
                        iA044 -= i9;
                    }
                }
                hu.A04();
                hu.A04();
                int iA049 = hu.A04();
                for (int i10 = hu.A0A() ? 0 : iA05; i10 <= iA05; i10++) {
                    hu.A04();
                    hu.A04();
                    hu.A04();
                }
                hu.A04();
                hu.A04();
                hu.A04();
                hu.A04();
                hu.A04();
                hu.A04();
                if (hu.A0A() && hu.A0A()) {
                    A0D(hu);
                }
                hu.A07(2);
                if (hu.A0A()) {
                    hu.A07(8);
                    hu.A04();
                    hu.A04();
                    hu.A06();
                }
                A0E(hu);
                if (hu.A0A()) {
                    for (int i11 = 0; i11 < hu.A04(); i11++) {
                        hu.A07(iA049 + 4 + 1);
                    }
                }
                hu.A07(2);
                float f = 1.0f;
                boolean zA0A2 = hu.A0A();
                if (A02[0].length() != 10) {
                    String[] strArr3 = A02;
                    strArr3[2] = "CMlgeA8zQVByZrA2VMXzsS0jeMyo18qQ";
                    strArr3[7] = "QAK33uwHUZwexufQvU3o8DPmyRQmvUMz";
                    if (zA0A2) {
                        if (hu.A0A()) {
                            int iA055 = hu.A05(8);
                            if (iA055 == 255) {
                                int iA056 = hu.A05(16);
                                int iA057 = hu.A05(16);
                                if (iA056 != 0 && iA057 != 0) {
                                    f = iA056 / iA057;
                                }
                            } else if (iA055 < A04.length) {
                                f = A04[iA055];
                            } else {
                                AbstractC02134g.A07(A0B(0, 11, 63), A0B(11, 35, 126) + iA055);
                            }
                        }
                        if (hu.A0A()) {
                            hu.A06();
                        }
                        if (hu.A0A()) {
                            hu.A07(3);
                            boolean zA0A3 = hu.A0A();
                            if (hu.A0A()) {
                                int iA058 = hu.A05(8);
                                int iA059 = hu.A05(8);
                                hu.A07(8);
                                iA00 = ColorInfo.A00(iA058);
                                i3 = zA0A3 ? 1 : 2;
                                if (A02[6].length() != 3) {
                                    A02[0] = "HGrGkdvIc2AkT14Ejxxa4aXBUNVha";
                                    iA01 = ColorInfo.A01(iA059);
                                } else {
                                    iA01 = ColorInfo.A01(iA059);
                                }
                            }
                        }
                        if (hu.A0A()) {
                            hu.A04();
                            hu.A04();
                        }
                        hu.A06();
                        if (hu.A0A()) {
                            iA044 *= 2;
                        }
                    }
                    return new HP(iA052, zA0A, iA053, i4, iArr, iA054, iA04, iA043, iA044, f, iA00, i3, iA01);
                }
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 26 out of bounds for length 26
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HR A0A(byte[] bArr, int i, int i2) {
        int iA04;
        boolean zA0A;
        int iA05;
        int i3;
        int i4;
        HU hu = new HU(bArr, i, i2);
        int iA052 = hu.A05(8);
        int iA053 = hu.A05(8);
        int iA054 = hu.A05(8);
        int iA042 = hu.A04();
        int iA043 = 1;
        if (iA052 != 100 && iA052 != 110 && iA052 != 122 && iA052 != 244 && iA052 != 44 && iA052 != 83 && iA052 != 86 && iA052 != 118 && iA052 != 128 && iA052 != 138) {
            int iA044 = hu.A04() + 4;
            iA04 = hu.A04();
            int iA045 = 0;
            boolean zA0A2 = false;
            if (iA04 != 0) {
            }
            int iA046 = hu.A04();
            hu.A06();
            int iA047 = hu.A04() + 1;
            int iA048 = hu.A04() + 1;
            zA0A = hu.A0A();
            int i5 = (2 - (zA0A ? 1 : 0)) * iA048;
            if (!zA0A) {
            }
            hu.A06();
            int i6 = iA047 * 16;
            int i7 = i5 * 16;
            if (hu.A0A()) {
            }
            float f = 1.0f;
            if (hu.A0A()) {
                iA05 = hu.A05(8);
                if (iA05 != 255) {
                }
            }
            return new HR(iA052, iA053, iA054, iA042, iA046, i6, i7, f, zA0A, zA0A, iA044, iA04, iA045, zA0A2);
        }
        iA043 = hu.A04();
        zA0A = iA043 == 3 ? hu.A0A() : false;
        hu.A04();
        hu.A04();
        hu.A06();
        boolean zA0A3 = hu.A0A();
        if (A02[0].length() != 10) {
            A02[0] = "qzm7RlaVhvQtMB0zhtauZ";
            if (zA0A3) {
                int i8 = iA043 != 3 ? 8 : 12;
                int i9 = 0;
                while (i9 < i8) {
                    if (hu.A0A()) {
                        A0F(hu, i9 < 6 ? 16 : 64);
                    }
                    i9++;
                }
            }
            int iA0442 = hu.A04() + 4;
            iA04 = hu.A04();
            int iA0452 = 0;
            boolean zA0A22 = false;
            if (iA04 != 0) {
                iA0452 = hu.A04() + 4;
                if (A02[5].charAt(3) != 'Y') {
                    A02[3] = "2NWfLRVEjhOO9";
                } else {
                    A02[5] = "fn7YpbzvxXlInri96XbQTTrdseuocXrx";
                }
            } else if (iA04 == 1) {
                zA0A22 = hu.A0A();
                hu.A03();
                hu.A03();
                long jA04 = hu.A04();
                String[] strArr = A02;
                if (strArr[4].length() == strArr[1].length()) {
                    String[] strArr2 = A02;
                    strArr2[2] = "sL3yo27N596gnAOXUx3X3jVDrWZXEmHs";
                    strArr2[7] = "EWRRgQnwInix360952oSCS5kmFFjSZxj";
                    for (int i10 = 0; i10 < jA04; i10++) {
                        hu.A04();
                    }
                }
            } else {
                String[] strArr3 = A02;
                if (strArr3[4].length() != strArr3[1].length()) {
                    throw new RuntimeException();
                }
                A02[3] = "4FZcyZVF6YdFmLSwekyzJ";
            }
            int iA0462 = hu.A04();
            hu.A06();
            int iA0472 = hu.A04() + 1;
            int iA0482 = hu.A04() + 1;
            zA0A = hu.A0A();
            int i52 = (2 - (zA0A ? 1 : 0)) * iA0482;
            if (!zA0A) {
                hu.A06();
            }
            hu.A06();
            int i62 = iA0472 * 16;
            int i72 = i52 * 16;
            if (hu.A0A()) {
                int iA049 = hu.A04();
                int iA0410 = hu.A04();
                int iA0411 = hu.A04();
                int iA0412 = hu.A04();
                if (iA043 == 0) {
                    i3 = 1;
                    i4 = 2 - (zA0A ? 1 : 0);
                } else {
                    i3 = iA043 == 3 ? 1 : 2;
                    i4 = (2 - (zA0A ? 1 : 0)) * (iA043 == 1 ? 2 : 1);
                }
                i62 -= (iA049 + iA0410) * i3;
                i72 -= (iA0411 + iA0412) * i4;
            }
            float f2 = 1.0f;
            if (hu.A0A() && hu.A0A()) {
                iA05 = hu.A05(8);
                if (iA05 != 255) {
                    int iA055 = hu.A05(16);
                    int iA056 = hu.A05(16);
                    if (iA055 != 0 && iA056 != 0) {
                        f2 = iA055 / iA056;
                    }
                } else if (iA05 < A04.length) {
                    f2 = A04[iA05];
                } else {
                    AbstractC02134g.A07(A0B(0, 11, 63), A0B(11, 35, 126) + iA05);
                }
            }
            return new HR(iA052, iA053, iA054, iA042, iA0462, i62, i72, f2, zA0A, zA0A, iA0442, iA04, iA0452, zA0A22);
        }
        throw new RuntimeException();
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A00 = new byte[]{-7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, 0, 25, 20, 31, 0, 31, 20, 23, 63, 88, 79, 98, 90, 79, 77, 94, 79, 78, 10, 75, 93, 90, 79, 77, 94, 73, 92, 75, 94, 83, 89, 73, 83, 78, 77, 10, 96, 75, 86, 95, 79, 36, 10, 66, 53, 48, 49, 59, -5, 45, 66, 47, 23, 10, 5, 6, 16, -48, 9, 6, 23, 4};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 19 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0E(HU hu) {
        int iA04;
        int iA042;
        int[] iArrCopyOf;
        int iA043 = hu.A04();
        int i = -1;
        int i2 = -1;
        int[] iArr = new int[0];
        int[] iArrCopyOf2 = new int[0];
        int i3 = 0;
        while (i3 < iA043) {
            if (i3 != 0 && hu.A0A()) {
                int i4 = i + i2;
                int iA044 = (1 - ((hu.A0A() ? 1 : 0) * 2)) * (hu.A04() + 1);
                boolean[] zArr = new boolean[i4 + 1];
                for (int i5 = 0; i5 <= i4; i5++) {
                    if (hu.A0A()) {
                        zArr[i5] = true;
                    } else {
                        zArr[i5] = hu.A0A();
                    }
                }
                iA04 = 0;
                int[] iArr2 = new int[i4 + 1];
                int[] iArr3 = new int[i4 + 1];
                for (int i6 = i2 - 1; i6 >= 0; i6--) {
                    int i7 = iArrCopyOf2[i6] + iA044;
                    if (i7 < 0 && zArr[i + i6]) {
                        iArr2[iA04] = i7;
                        iA04++;
                    }
                }
                if (iA044 < 0 && zArr[i4]) {
                    iArr2[iA04] = iA044;
                    iA04++;
                }
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = iArr[i8] + iA044;
                    if (A02[0].length() == 10) {
                        throw new RuntimeException();
                    }
                    A02[0] = "0xLwbNcICqBOIGnxvrVU0VkzUAjp";
                    if (i9 < 0) {
                        boolean z = zArr[i8];
                        if (A02[6].length() != 3) {
                            String[] strArr = A02;
                            strArr[2] = "OJAEm2QqqrF2kr0XAoMunq3AjjwiYhOO";
                            strArr[7] = "NvnxbUpcm9NzKSDUaYgmh21cCcr7HCKV";
                            if (z) {
                                int i10 = iA04 + 1;
                                iArr2[iA04] = i9;
                                if (A02[0].length() != 10) {
                                    A02[0] = "ZxDUqDztknTqk0noe7cSqrpf0";
                                    iA04 = i10;
                                } else {
                                    iA04 = i10;
                                }
                            }
                        } else {
                            String[] strArr2 = A02;
                            strArr2[2] = "O1Oy4mT2J3IqGA0cLz7TSW3zbNH41BLw";
                            strArr2[7] = "bMAFoAVZGrulVErqDQ8z4qjQetYlIImf";
                            if (z) {
                            }
                        }
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr2, iA04);
                iA042 = 0;
                for (int i11 = i - 1; i11 >= 0; i11--) {
                    int i12 = iArr[i11] + iA044;
                    if (i12 > 0 && zArr[i11]) {
                        iArr3[iA042] = i12;
                        iA042++;
                    }
                }
                if (iA044 > 0) {
                    boolean z2 = zArr[i4];
                    String[] strArr3 = A02;
                    if (strArr3[4].length() != strArr3[1].length()) {
                        A02[6] = "tgnVuwGZauQZxVLXvW8ZTDaij";
                        if (z2) {
                            iArr3[iA042] = iA044;
                            iA042++;
                        }
                    } else {
                        A02[0] = "U";
                        if (z2) {
                        }
                    }
                }
                for (int i13 = 0; i13 < i2; i13++) {
                    int i14 = iArrCopyOf2[i13] + iA044;
                    if (i14 > 0 && zArr[i + i13]) {
                        iArr3[iA042] = i14;
                        iA042++;
                    }
                }
                if (A02[5].charAt(3) != 'Y') {
                    A02[5] = "VNLYj4nIEG05kgLFUbTjhWBq9LKgRHZO";
                    iArrCopyOf2 = Arrays.copyOf(iArr3, iA042);
                } else {
                    String[] strArr4 = A02;
                    strArr4[2] = "zCcqrsPkSftUPRel4Z8ZE6iGY8rnHFMe";
                    strArr4[7] = "knHf2kXaFD2hm93xyPTTBZZ0wItiA7C5";
                    iArrCopyOf2 = Arrays.copyOf(iArr3, iA042);
                }
            } else {
                iA04 = hu.A04();
                iA042 = hu.A04();
                iArrCopyOf = new int[iA04];
                for (int i15 = 0; i15 < iA04; i15++) {
                    iArrCopyOf[i15] = hu.A04() + 1;
                    hu.A06();
                }
                iArrCopyOf2 = new int[iA042];
                for (int i16 = 0; i16 < iA042; i16++) {
                    iArrCopyOf2[i16] = hu.A04() + 1;
                    hu.A06();
                }
            }
            i = iA04;
            i2 = iA042;
            iArr = iArrCopyOf;
            if (A02[0].length() != 10) {
                String[] strArr5 = A02;
                strArr5[4] = "MHTDjP3q9jqJvcAulQ6";
                strArr5[1] = "VeGKMo1LwbXx0TG7y0g";
                i3++;
            } else {
                i3++;
            }
        }
    }

    static {
        A0C();
        A03 = new byte[]{0, 0, 0, 1};
        A04 = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        A05 = new Object();
        A01 = new int[10];
    }

    public static int A00(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int A02(byte[] bArr, int i) {
        int i2;
        synchronized (A05) {
            int scratchEscapeCount = 0;
            int i3 = 0;
            while (scratchEscapeCount < i) {
                scratchEscapeCount = A03(bArr, scratchEscapeCount, i);
                if (scratchEscapeCount < i) {
                    if (A01.length <= i3) {
                        A01 = Arrays.copyOf(A01, A01.length * 2);
                    }
                    A01[i3] = scratchEscapeCount;
                    scratchEscapeCount += 3;
                    i3++;
                }
            }
            i2 = i - i3;
            int unescapedPosition = 0;
            int escapedPosition = 0;
            for (int unescapedLength = 0; unescapedLength < i3; unescapedLength++) {
                int scratchEscapeCount2 = A01[unescapedLength];
                int scratchEscapeCount3 = scratchEscapeCount2 - unescapedPosition;
                System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, scratchEscapeCount3);
                int escapedPosition2 = escapedPosition + scratchEscapeCount3;
                int position = escapedPosition2 + 1;
                bArr[escapedPosition2] = 0;
                escapedPosition = position + 1;
                bArr[position] = 0;
                unescapedPosition += scratchEscapeCount3 + 3;
            }
            System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, i2 - escapedPosition);
        }
        return i2;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0002 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(byte[] bArr, int i, int i2) {
        while (i < i) {
            int i3 = bArr[i];
            if (i3 == 0) {
                int i4 = i + 1;
                if (bArr[i4] == 0) {
                    int i5 = i + 2;
                    if (bArr[i5] == 3) {
                        return i;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A04(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        boolean z2;
        int i3 = i2 - i;
        AbstractC02053y.A08(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            A0H(zArr);
            int length = i - 3;
            return length;
        }
        if (i3 > 1 && zArr[1]) {
            int length2 = bArr[i];
            if (length2 == 1) {
                A0H(zArr);
                int length3 = i - 2;
                return length3;
            }
        }
        if (i3 > 2 && zArr[2]) {
            int length4 = bArr[i];
            if (length4 == 0) {
                int length5 = i + 1;
                byte b = bArr[length5];
                if (A02[0].length() == 10) {
                    throw new RuntimeException();
                }
                A02[6] = "PQW9C7kUOKDoPPw";
                if (b == 1) {
                    A0H(zArr);
                    int length6 = i - 1;
                    return length6;
                }
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            int length7 = bArr[i5];
            if ((length7 & 254) == 0) {
                int length8 = i5 - 2;
                if (bArr[length8] == 0) {
                    int length9 = i5 - 1;
                    if (bArr[length9] == 0) {
                        int length10 = bArr[i5];
                        if (length10 == 1) {
                            A0H(zArr);
                            int length11 = i5 - 2;
                            return length11;
                        }
                    }
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (i3 > 2) {
            int length12 = i2 - 3;
            if (bArr[length12] == 0) {
                int length13 = i2 - 2;
                byte b2 = bArr[length13];
                if (A02[6].length() == 3) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[4] = "tLizWOaN0OsagnuSy28";
                strArr[1] = "ZOtg0UvXTXpiFnpoxfp";
                if (b2 == 0) {
                    int length14 = i2 - 1;
                    z = bArr[length14] == 1;
                }
            }
        } else if (i3 == 2) {
            boolean z3 = zArr[2];
            if (A02[5].charAt(3) != 'Y') {
                throw new RuntimeException();
            }
            A02[0] = "TtHOfwpayoR";
            if (z3) {
                int length15 = i2 - 2;
                if (bArr[length15] == 0) {
                    int length16 = i2 - 1;
                    z = bArr[length16] == 1;
                }
            }
        } else if (zArr[1]) {
            int i6 = i2 - 1;
            String[] strArr2 = A02;
            String str = strArr2[2];
            String str2 = strArr2[7];
            int iCharAt = str.charAt(3);
            int length17 = str2.charAt(3);
            if (iCharAt != length17) {
                String[] strArr3 = A02;
                strArr3[2] = "UGNUjS5TseBxte9hZy6MdiMKKivw8YU8";
                strArr3[7] = "gAwFNStsKHXv5jMh5dTnIzvsHbrqE6D6";
                int length18 = bArr[i6];
                z = length18 == 1;
            } else {
                A02[5] = "MYPYXnk67e7ylj87wlpJJbRJ3uYkeY13";
                int length19 = bArr[i6];
                if (length19 == 1) {
                }
            }
        }
        zArr[0] = z;
        if (i3 > 1) {
            int length20 = i2 - 2;
            if (bArr[length20] == 0) {
                int length21 = i2 - 1;
                z2 = bArr[length21] == 0;
            }
        } else if (zArr[2]) {
            int length22 = i2 - 1;
            z2 = bArr[length22] == 0;
        }
        zArr[1] = z2;
        int length23 = i2 - 1;
        zArr[2] = bArr[length23] == 0;
        return i2;
    }

    public static HP A05(byte[] bArr, int i, int i2) {
        return A06(bArr, i + 2, i2);
    }

    public static HQ A07(byte[] bArr, int i, int i2) {
        return A08(bArr, i + 1, i2);
    }

    public static HQ A08(byte[] bArr, int i, int i2) {
        HU data2 = new HU(bArr, i, i2);
        int iA04 = data2.A04();
        int seqParameterSetId = data2.A04();
        data2.A06();
        return new HQ(iA04, seqParameterSetId, data2.A0A());
    }

    public static HR A09(byte[] bArr, int i, int i2) {
        return A0A(bArr, i + 1, i2);
    }

    public static void A0D(HU hu) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int matrixId = 1;
                if (!hu.A0A()) {
                    hu.A04();
                } else {
                    int sizeId = i << 1;
                    int iMin = Math.min(64, 1 << (sizeId + 4));
                    if (i > 1) {
                        hu.A03();
                    }
                    for (int sizeId2 = 0; sizeId2 < iMin; sizeId2++) {
                        hu.A03();
                    }
                }
                if (i == 3) {
                    matrixId = 3;
                }
                i2 += matrixId;
            }
        }
    }

    public static void A0F(HU hu, int i) {
        int i2 = 8;
        int lastScale = 8;
        for (int nextScale = 0; nextScale < i; nextScale++) {
            if (lastScale != 0) {
                int lastScale2 = hu.A03();
                lastScale = ((lastScale2 + i2) + 256) % 256;
            }
            if (lastScale != 0) {
                i2 = lastScale;
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0G(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i = 0;
        int value = 0;
        while (length < iPosition) {
            int length = byteBuffer.get(value);
            int offset = length & PHIpAddressSearchManager.END_IP_SCAN;
            if (i == 3) {
                if (offset == 1) {
                    int length2 = value + 1;
                    int consecutiveZeros = byteBuffer.get(length2) & 31;
                    if (consecutiveZeros == 7) {
                        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                        int length3 = value - 3;
                        byteBufferDuplicate.position(length3);
                        byteBufferDuplicate.limit(iPosition);
                        byteBuffer.position(0);
                        byteBuffer.put(byteBufferDuplicate);
                        return;
                    }
                }
            } else if (offset == 0) {
                i++;
            }
            if (offset != 0) {
                i = 0;
            }
            value++;
        }
        byteBuffer.clear();
    }

    public static void A0H(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0I(String str, byte b) {
        if (A0B(46, 9, 96).equals(str) && (b & 31) == 6) {
            return true;
        }
        return A0B(55, 10, 53).equals(str) && ((b & 126) >> 1) == 39;
    }
}
