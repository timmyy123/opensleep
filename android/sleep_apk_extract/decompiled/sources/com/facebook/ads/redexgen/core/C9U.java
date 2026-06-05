package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ApicFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.BinaryFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ChapterFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.CommentFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.MlltFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.PrivFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.UrlLinkFrame;
import com.google.home.platform.traits.ValidationIssue;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9U, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9U extends AbstractC1753mZ {
    public static byte[] A01;
    public static String[] A02 = {"dfkl9gE5OREu5AXL5lY0ohuUUe3SXBJr", "hKeIXQ7stisHjmNWZz70dNldldiAaQvi", "Ev47ZYJBP4qmoN0JeJrCKxe3cHeEd2Mz", "un9uiXmeOTgIIo", "Wd16eevQjbu9Ian59LTBbcV1NeBW6y6R", "QoAdFFIsNXY7HGA7Qc965AL0CxX7pFDa", "35FvwnlVw7oPAj", "U3kKyqEMJJ2afey5JgaPdqN5tYmvQhts"};
    public static final IE A03;
    public final IE A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static ApicFrame A04(C02284v c02284v, int i, int i2) {
        int iA02;
        String strA01;
        int iA0I = c02284v.A0I();
        Charset charsetA0M = A0M(iA0I);
        byte[] bArr = new byte[i - 1];
        c02284v.A0k(bArr, 0, i - 1);
        String strA0J = A0J(ValidationIssue.AUTOMATION_TOO_LARGE_FIELD_NUMBER, 6, 90);
        if (i2 == 2) {
            iA02 = 2;
            strA01 = strA0J + AbstractC1616k7.A01(new String(bArr, 0, 3, AbstractC1618k9.A00));
            if (A0J(418, 9, 47).equals(strA01)) {
                strA01 = A0J(408, 10, 122);
            }
        } else {
            iA02 = A02(bArr, 0);
            strA01 = AbstractC1616k7.A01(new String(bArr, 0, iA02, AbstractC1618k9.A00));
            if (strA01.indexOf(47) == -1) {
                strA01 = strA0J + strA01;
            }
        }
        int i3 = bArr[iA02 + 1] & 255;
        int i4 = iA02 + 2;
        int iA03 = A03(bArr, i4, iA0I);
        return new ApicFrame(strA01, new String(bArr, i4, iA03 - i4, charsetA0M), i3, A0Q(bArr, A00(iA0I) + iA03, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 20 out of bounds for length 19
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static ChapterFrame A06(C02284v c02284v, int i, int i2, boolean z, int i3, IE ie) {
        int iA09 = c02284v.A09();
        int iA02 = A02(c02284v.A0l(), iA09);
        String str = new String(c02284v.A0l(), iA09, iA02 - iA09, AbstractC1618k9.A00);
        c02284v.A0f(iA02 + 1);
        int iA0C = c02284v.A0C();
        int iA0C2 = c02284v.A0C();
        long jA0Q = c02284v.A0Q();
        if (jA0Q == 4294967295L) {
            jA0Q = -1;
        }
        long jA0Q2 = c02284v.A0Q();
        if (jA0Q2 == 4294967295L) {
            jA0Q2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = iA09 + i;
        while (true) {
            int iA092 = c02284v.A09();
            if (A02[5].charAt(22) == 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "yxJytYiELIVuKxluLLGjsQCljTQ6t8ax";
            strArr[0] = "riKuEgzQ5i9bwl4lr9MCLXtR5zTvU4EY";
            if (iA092 >= i4) {
                return new ChapterFrame(str, iA0C, iA0C2, jA0Q, jA0Q2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
            }
            Id3Frame id3FrameA0B = A0B(i2, c02284v, z, i3, ie);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static GeobFrame A09(C02284v c02284v, int i) {
        int iA0I = c02284v.A0I();
        Charset charsetA0M = A0M(iA0I);
        byte[] bArr = new byte[i - 1];
        c02284v.A0k(bArr, 0, i - 1);
        int iA02 = A02(bArr, 0);
        String str = new String(bArr, 0, iA02, AbstractC1618k9.A00);
        int i2 = iA02 + 1;
        int iA03 = A03(bArr, i2, iA0I);
        String strA0L = A0L(bArr, i2, iA03, charsetA0M);
        int iA00 = A00(iA0I) + iA03;
        int iA032 = A03(bArr, iA00, iA0I);
        return new GeobFrame(str, strA0L, A0L(bArr, iA00, iA032, charsetA0M), A0Q(bArr, A00(iA0I) + iA032, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static MlltFrame A0C(C02284v c02284v, int i) {
        int iA0M = c02284v.A0M();
        int iA0K = c02284v.A0K();
        int iA0K2 = c02284v.A0K();
        int iA0I = c02284v.A0I();
        int iA0I2 = c02284v.A0I();
        C02274u c02274u = new C02274u();
        c02274u.A0C(c02284v);
        int i2 = ((i - 10) * 8) / (iA0I + iA0I2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iA04 = c02274u.A04(iA0I);
            int iA042 = c02274u.A04(iA0I2);
            iArr[i3] = iA04;
            iArr2[i3] = iA042;
            if (A02[5].charAt(22) == 'F') {
                throw new RuntimeException();
            }
            A02[4] = "fcLz7frwMRu6ITyb";
        }
        return new MlltFrame(iA0M, iA0K, iA0K2, iArr, iArr2);
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 13);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0N() {
        A01 = new byte[]{26, 15, 9, 103, 109, 43, 109, 43, 109, 43, 41, 111, 41, 111, 41, 111, 41, 111, 6, 10, 76, 88, 75, 71, 79, 121, 67, 80, 79, 23, 37, 0, 21, 0, 65, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 65, 18, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 21, 65, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 65, 3, 4, 65, 0, 15, 65, 40, 37, 82, 65, 21, 0, 6, 76, 107, 99, 102, 111, 110, 42, 126, 101, 42, 110, 111, 105, 101, 110, 111, 42, 108, 120, 107, 103, 111, 48, 42, 99, 110, 55, 114, 85, 93, 88, 81, 80, 20, 64, 91, 20, 66, 85, 88, 93, 80, 85, 64, 81, 20, 125, 112, 7, 20, 64, 85, 83, 20, 67, 93, 64, 92, 20, 89, 85, 94, 91, 70, 98, 81, 70, 71, 93, 91, 90, 9, 39, 19, 0, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 4, 65, 18, 8, 27, 4, 65, 4, 25, 2, 4, 4, 5, 18, 65, 19, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 8, 15, 8, 15, 6, 65, 21, 0, 6, 65, 5, 0, 21, 0, 74, 103, 48, 71, 102, 96, 108, 103, 102, 113, 85, 109, 111, 118, 118, 99, 98, 38, 79, 66, 53, 38, 114, 103, 97, 38, 113, 111, 114, 110, 38, 107, 103, 108, 105, 116, 80, 99, 116, 117, 111, 105, 104, 59, 52, 38, 103, 104, 98, 38, 115, 104, 98, 99, 96, 111, 104, 99, 98, 38, 101, 105, 107, 118, 116, 99, 117, 117, 111, 105, 104, 38, 117, 101, 110, 99, 107, 99, 104, 80, 82, 75, 75, 94, 95, 27, 114, 127, 8, 27, 79, 90, 92, 27, 76, 82, 79, 83, 27, 78, 85, 72, 78, 75, 75, 84, 73, 79, 94, 95, 27, 86, 90, 81, 84, 73, 109, 94, 73, 72, 82, 84, 85, 6, 42, 18, 16, 9, 9, 16, 23, 30, 89, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 9, 22, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 28, 29, 89, 26, 22, 20, 9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, 10, 10, 28, 29, 89, 22, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 89, 28, 23, 26, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 9, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 28, 29, 89, 31, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 24, 20, 28, 62, 50, 50, 50, 119, 76, 71, 90, 82, 71, 65, 86, 71, 70, 2, 68, 75, 80, 81, 86, 2, 86, 74, 80, 71, 71, 2, 64, 91, 86, 71, 81, 2, 77, 68, 2, 107, 102, 17, 2, 86, 67, 69, 2, 74, 71, 67, 70, 71, 80, 24, 2, 18, 90, 121, 118, 118, 118, 62, 58, 54, 48, 50, 120, 30, 26, 22, 16, 18, 88, 29, 7, 18, 16, 75, 79, 67, 69, 71, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 72, 82, 69};
    }

    static {
        A0N();
        A03 = new IE() { // from class: com.facebook.ads.redexgen.X.mT
            @Override // com.facebook.ads.redexgen.core.IE
            public final boolean A6Q(int i, int i2, int i3, int i4, int i5) {
                return C9U.A0O(i, i2, i3, i4, i5);
            }
        };
    }

    public C9U() {
        this(null);
    }

    public C9U(IE ie) {
        this.A00 = ie;
    }

    public static int A00(int i) {
        if (i == 0 || i == 3) {
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A01(C02284v c02284v, int i) {
        byte[] bArrA0l = c02284v.A0l();
        int iA09 = c02284v.A09();
        int i2 = iA09;
        while (startPosition < iA09 + i) {
            int startPosition = bArrA0l[i2];
            if ((startPosition & PHIpAddressSearchManager.END_IP_SCAN) == 255 && bArrA0l[i2 + 1] == 0) {
                int i3 = i2 + 2;
                int i4 = i2 + 1;
                int relativePosition = (i - (i2 - iA09)) - 2;
                String[] strArr = A02;
                String str = strArr[1];
                String str2 = strArr[7];
                int startPosition2 = str.charAt(20);
                if (startPosition2 != str2.charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[1] = "XZV6e8MYnWgHLOD3ZLXsdTcFpPsY6V3F";
                strArr2[7] = "PRKMokf209xLCZShYH0Zduqvqdx50TVA";
                System.arraycopy(bArrA0l, i3, bArrA0l, i4, relativePosition);
                i--;
            }
            i2++;
        }
        return i;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0001 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A02(byte[] bArr, int i) {
        while (i < i) {
            int i2 = bArr[i];
            if (i2 == 0) {
                return i;
            }
            i++;
        }
        int i3 = bArr.length;
        return i3;
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(byte[] bArr, int i, int i2) {
        int iA02 = A02(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iA02;
        }
        while (iA02 < terminationPos - 1) {
            int terminationPos = iA02 - i;
            if (terminationPos % 2 == 0) {
                int terminationPos2 = iA02 + 1;
                if (bArr[terminationPos2] == 0) {
                    return iA02;
                }
            }
            int terminationPos3 = iA02 + 1;
            iA02 = A02(bArr, terminationPos3);
        }
        int terminationPos4 = bArr.length;
        return terminationPos4;
    }

    public static BinaryFrame A05(C02284v c02284v, int i, String str) {
        byte[] bArr = new byte[i];
        c02284v.A0k(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterTocFrame A07(C02284v c02284v, int i, int i2, boolean z, int elementIdEndIndex, IE ie) {
        int iA09 = c02284v.A09();
        int iA02 = A02(c02284v.A0l(), iA09);
        String str = new String(c02284v.A0l(), iA09, iA02 - iA09, AbstractC1618k9.A00);
        c02284v.A0f(iA02 + 1);
        int framePosition = c02284v.A0I();
        boolean z2 = (framePosition & 2) != 0;
        boolean z3 = (framePosition & 1) != 0;
        int iA0I = c02284v.A0I();
        String[] strArr = new String[iA0I];
        for (int i3 = 0; i3 < iA0I; i3++) {
            int startIndex = c02284v.A09();
            int iA022 = A02(c02284v.A0l(), startIndex);
            int elementIdEndIndex2 = iA022 - startIndex;
            strArr[i3] = new String(c02284v.A0l(), startIndex, elementIdEndIndex2, AbstractC1618k9.A00);
            c02284v.A0f(iA022 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i4 = iA09 + i;
        while (c02284v.A09() < i4) {
            Id3Frame id3FrameA0B = A0B(i2, c02284v, z, elementIdEndIndex, ie);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static CommentFrame A08(C02284v c02284v, int i) {
        if (i < 4) {
            return null;
        }
        int textStartIndex = c02284v.A0I();
        Charset charsetA0M = A0M(textStartIndex);
        byte[] bArr = new byte[3];
        c02284v.A0k(bArr, 0, 3);
        String description = new String(bArr, 0, 3);
        int encoding = i - 4;
        byte[] data2 = new byte[encoding];
        int encoding2 = i - 4;
        c02284v.A0k(data2, 0, encoding2);
        int encoding3 = A03(data2, 0, textStartIndex);
        String language = new String(data2, 0, encoding3, charsetA0M);
        int iA00 = A00(textStartIndex) + encoding3;
        int encoding4 = A03(data2, iA00, textStartIndex);
        return new CommentFrame(description, language, A0L(data2, iA00, encoding4, charsetA0M));
    }

    public static IF A0A(C02284v c02284v) {
        int iA07 = c02284v.A07();
        String strA0J = A0J(170, 10, 14);
        if (iA07 < 10) {
            AbstractC02134g.A07(strA0J, A0J(30, 31, 108));
            return null;
        }
        int iA0K = c02284v.A0K();
        boolean z = false;
        if (iA0K != 4801587) {
            AbstractC02134g.A07(strA0J, A0J(348, 50, 47) + String.format(A0J(0, 4, 50), Integer.valueOf(iA0K)));
            return null;
        }
        int iA0I = c02284v.A0I();
        c02284v.A0g(1);
        int flags = c02284v.A0I();
        int iA0H = c02284v.A0H();
        if (iA0I == 2) {
            int id = flags & 64;
            int id2 = id != 0 ? 1 : 0;
            if (id2 != 0) {
                AbstractC02134g.A07(strA0J, A0J(180, 68, 11));
                return null;
            }
        } else if (iA0I == 3) {
            int id3 = flags & 64;
            int id4 = id3 != 0 ? 1 : 0;
            if (id4 != 0) {
                int id5 = c02284v.A0C();
                c02284v.A0g(id5);
                iA0H -= id5 + 4;
            }
        } else if (iA0I == 4) {
            int id6 = flags & 64;
            int id7 = id6 != 0 ? 1 : 0;
            if (id7 != 0) {
                int majorVersion = c02284v.A0H();
                int id8 = majorVersion - 4;
                c02284v.A0g(id8);
                iA0H -= majorVersion;
            }
            int id9 = flags & 16;
            int id10 = id9 != 0 ? 1 : 0;
            if (id10 != 0) {
                iA0H -= 10;
            }
        } else {
            AbstractC02134g.A07(strA0J, A0J(248, 46, 54) + iA0I);
            return null;
        }
        if (iA0I < 4) {
            int id11 = flags & 128;
            if (id11 != 0) {
                z = true;
            }
        }
        return new IF(iA0I, z, iA0H);
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0232 A[Catch: all -> 0x0273, TryCatch #0 {all -> 0x0273, blocks: (B:99:0x0169, B:168:0x023c, B:101:0x0171, B:108:0x0187, B:110:0x018f, B:118:0x01a9, B:127:0x01c1, B:138:0x01db, B:145:0x01ec, B:152:0x01fd, B:158:0x0214, B:165:0x022d, B:166:0x0232), top: B:174:0x015f }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame A0B(int frameId3, C02284v c02284v, boolean z, int i, IE ie) {
        int iA0I;
        int iA0K;
        int iA0M;
        Id3Frame id3FrameA07;
        int frameId2 = c02284v.A0I();
        int frameId1 = c02284v.A0I();
        int frameId0 = c02284v.A0I();
        if (frameId3 >= 3) {
            iA0I = c02284v.A0I();
        } else {
            iA0I = 0;
        }
        if (frameId3 == 4) {
            int iA0L = c02284v.A0L();
            if (!z) {
                int frameSize = iA0L >> 8;
                int i2 = (iA0L & PHIpAddressSearchManager.END_IP_SCAN) | ((frameSize & PHIpAddressSearchManager.END_IP_SCAN) << 7);
                int frameSize2 = iA0L >> 16;
                int i3 = i2 | ((frameSize2 & PHIpAddressSearchManager.END_IP_SCAN) << 14);
                int frameSize3 = iA0L >> 24;
                iA0K = i3 | ((frameSize3 & PHIpAddressSearchManager.END_IP_SCAN) << 21);
            } else {
                iA0K = iA0L;
            }
        } else if (frameId3 == 3) {
            iA0K = c02284v.A0L();
        } else {
            iA0K = c02284v.A0K();
        }
        if (frameId3 >= 3) {
            iA0M = c02284v.A0M();
        } else {
            iA0M = 0;
        }
        if (frameId2 == 0 && frameId1 == 0 && frameId0 == 0 && iA0I == 0 && iA0K == 0 && iA0M == 0) {
            c02284v.A0f(c02284v.A0A());
            return null;
        }
        int flags = c02284v.A09() + iA0K;
        int iA0A = c02284v.A0A();
        String strA0J = A0J(170, 10, 14);
        if (flags > iA0A) {
            AbstractC02134g.A07(strA0J, A0J(133, 37, 108));
            c02284v.A0f(c02284v.A0A());
            return null;
        }
        if (ie != null && !ie.A6Q(frameId3, frameId2, frameId1, frameId0, iA0I)) {
            c02284v.A0f(flags);
            String[] strArr = A02;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A02[4] = "e3YBkKHUVMVtsvvPrHCe6nHMIy";
            return null;
        }
        int nextFramePosition = 0;
        boolean hasDataLength = false;
        boolean isEncrypted = false;
        int i4 = 0;
        int frameSize4 = 0;
        if (frameId3 == 3) {
            i4 = (iA0M & 128) != 0 ? 1 : 0;
            hasDataLength = (iA0M & 64) != 0;
            frameSize4 = (iA0M & 32) != 0 ? 1 : 0;
            nextFramePosition = i4;
        } else if (frameId3 == 4) {
            frameSize4 = (iA0M & 64) != 0 ? 1 : 0;
            nextFramePosition = (iA0M & 8) != 0 ? 1 : 0;
            int i5 = iA0M & 4;
            String[] strArr2 = A02;
            if (strArr2[6].length() != strArr2[3].length()) {
                A02[5] = "YrGhE76fNDxr3LSniMVr4VzIG8CV74Mf";
                hasDataLength = i5 != 0;
            } else {
                A02[5] = "eLbk71BgL0f2DKr72Qx6greuw57xH3Wk";
                if (i5 != 0) {
                }
            }
            isEncrypted = (iA0M & 2) != 0;
            i4 = (iA0M & 1) != 0 ? 1 : 0;
        }
        if (nextFramePosition != 0 || hasDataLength) {
            AbstractC02134g.A07(strA0J, A0J(294, 50, 116));
            return null;
        }
        if (frameSize4 != 0) {
            iA0K--;
            c02284v.A0g(1);
        }
        if (i4 != 0) {
            iA0K -= 4;
            c02284v.A0g(4);
        }
        if (isEncrypted) {
            iA0K = A01(c02284v, iA0K);
        }
        try {
            if (frameId2 == 84 && frameId1 == 88 && frameId0 == 88 && (frameId3 == 2 || iA0I == 88)) {
                id3FrameA07 = A0E(c02284v, iA0K);
            } else if (frameId2 == 84) {
                id3FrameA07 = A0F(c02284v, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
            } else if (frameId2 == 87 && frameId1 == 88 && frameId0 == 88 && (frameId3 == 2 || iA0I == 88)) {
                id3FrameA07 = A0G(c02284v, iA0K);
            } else if (frameId2 == 87) {
                id3FrameA07 = A0H(c02284v, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
            } else if (frameId2 == 80 && frameId1 == 82 && frameId0 == 73 && iA0I == 86) {
                id3FrameA07 = A0D(c02284v, iA0K);
            } else if (frameId2 == 71 && frameId1 == 69 && frameId0 == 79 && (iA0I == 66 || frameId3 == 2)) {
                id3FrameA07 = A09(c02284v, iA0K);
            } else if (frameId3 != 2) {
                if (frameId2 == 65 && frameId1 == 80 && frameId0 == 73 && iA0I == 67) {
                    id3FrameA07 = A04(c02284v, iA0K, frameId3);
                } else if (frameId2 == 67) {
                    if (frameId2 != 67) {
                        if (frameId2 != 67) {
                        }
                    }
                }
            } else {
                if (frameId2 == 80 && frameId1 == 73 && frameId0 == 67) {
                    id3FrameA07 = A04(c02284v, iA0K, frameId3);
                }
                if (frameId2 == 67 || frameId1 != 79 || frameId0 != 77 || (iA0I != 77 && frameId3 != 2)) {
                    if (frameId2 != 67 && frameId1 == 72 && frameId0 == 65 && iA0I == 80) {
                        id3FrameA07 = A06(c02284v, iA0K, frameId3, z, i, ie);
                    } else {
                        id3FrameA07 = (frameId2 != 67 && frameId1 == 84 && frameId0 == 79 && iA0I == 67) ? A07(c02284v, iA0K, frameId3, z, i, ie) : (frameId2 != 77 && frameId1 == 76 && frameId0 == 76 && iA0I == 84) ? A0C(c02284v, iA0K) : A05(c02284v, iA0K, A0K(frameId3, frameId2, frameId1, frameId0, iA0I));
                    }
                } else {
                    id3FrameA07 = A08(c02284v, iA0K);
                }
            }
            if (id3FrameA07 == null) {
                AbstractC02134g.A07(strA0J, A0J(61, 27, 7) + A0K(frameId3, frameId2, frameId1, frameId0, iA0I) + A0J(18, 12, 39) + iA0K);
            }
            return id3FrameA07;
        } finally {
            c02284v.A0f(flags);
        }
    }

    public static PrivFrame A0D(C02284v c02284v, int i) {
        byte[] bArr = new byte[i];
        c02284v.A0k(bArr, 0, i);
        int iA02 = A02(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iA02, AbstractC1618k9.A00), A0Q(bArr, iA02 + 1, bArr.length));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0E(C02284v c02284v, int i) {
        if (i < 1) {
            return null;
        }
        int iA0I = c02284v.A0I();
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c02284v.A0k(bArr, 0, encoding2);
        int iA03 = A03(bArr, 0, iA0I);
        String str = new String(bArr, 0, iA03, A0M(iA0I));
        int encoding3 = A00(iA0I);
        return new TextInformationFrame(A0J(344, 4, 103), str, A0I(bArr, iA0I, encoding3 + iA03));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0F(C02284v c02284v, int i, String str) {
        if (i < 1) {
            return null;
        }
        int iA0I = c02284v.A0I();
        int encoding = i - 1;
        byte[] data2 = new byte[encoding];
        c02284v.A0k(data2, 0, i - 1);
        return new TextInformationFrame(str, null, A0I(data2, iA0I, 0));
    }

    public static UrlLinkFrame A0G(C02284v c02284v, int i) {
        if (i < 1) {
            return null;
        }
        int iA0I = c02284v.A0I();
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c02284v.A0k(bArr, 0, encoding2);
        int iA03 = A03(bArr, 0, iA0I);
        String str = new String(bArr, 0, iA03, A0M(iA0I));
        int descriptionEndIndex = A00(iA0I) + iA03;
        String description = A0L(bArr, descriptionEndIndex, A02(bArr, descriptionEndIndex), AbstractC1618k9.A00);
        return new UrlLinkFrame(A0J(398, 4, 35), str, description);
    }

    public static UrlLinkFrame A0H(C02284v c02284v, int i, String str) {
        byte[] bArr = new byte[i];
        c02284v.A0k(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, A02(bArr, 0), AbstractC1618k9.A00));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<java.lang.String> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static BP<String> A0I(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        String strA0J = A0J(0, 0, 108);
        if (i2 >= length) {
            return BP.A04(strA0J);
        }
        C2K c2kA01 = BP.A01();
        int valueEndIndex = A03(bArr, i2, i);
        while (i2 < valueEndIndex) {
            int valueStartIndex = valueEndIndex - i2;
            c2kA01.A04(new String(bArr, i2, valueStartIndex, A0M(i)));
            i2 = valueEndIndex + A00(i);
            valueEndIndex = A03(bArr, i2, i);
        }
        BP<String> bpA05 = c2kA01.A05();
        return bpA05.isEmpty() ? BP.A04(strA0J) : bpA05;
    }

    public static String A0K(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, A0J(4, 6, 69), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, A0J(10, 8, 1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String A0L(byte[] bArr, int i, int i2, Charset charset) {
        if (i2 <= i || i2 > bArr.length) {
            return A0J(0, 0, 108);
        }
        return new String(bArr, i, i2 - i, charset);
    }

    public static Charset A0M(int i) {
        switch (i) {
            case 1:
                return AbstractC1618k9.A02;
            case 2:
                return AbstractC1618k9.A03;
            case 3:
                return AbstractC1618k9.A05;
            default:
                Charset charset = AbstractC1618k9.A00;
                if (A02[5].charAt(22) == 'F') {
                    throw new RuntimeException();
                }
                A02[5] = "KvSqsioCKy57forlhJv7i4SYYwwKGyHr";
                return charset;
        }
    }

    public static /* synthetic */ boolean A0O(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0060 A[EDGE_INSN: B:84:0x0060->B:23:0x0060 BREAK  A[LOOP:0: B:77:0x0006->B:67:0x0108], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0P(C02284v c02284v, int i, int i2, boolean z) throws Throwable {
        int iA0C;
        long jA0Q;
        int iA0M;
        String[] strArr;
        int iA09 = c02284v.A09();
        while (true) {
            try {
                if (c02284v.A07() < i2) {
                    c02284v.A0f(iA09);
                    return true;
                }
                if (i >= 3) {
                    try {
                        iA0C = c02284v.A0C();
                        jA0Q = c02284v.A0Q();
                        iA0M = c02284v.A0M();
                    } catch (Throwable th) {
                        th = th;
                        c02284v.A0f(iA09);
                        throw th;
                    }
                } else {
                    iA0C = c02284v.A0K();
                    jA0Q = c02284v.A0K();
                    iA0M = 0;
                }
                if (iA0C == 0 && jA0Q == 0 && iA0M == 0) {
                    c02284v.A0f(iA09);
                    return true;
                }
                if (i != 4 || z) {
                    int id = 0;
                    int flags = 0;
                    if (i != 4) {
                        id = (iA0M & 64) != 0 ? 1 : 0;
                        flags = (iA0M & 1) == 0 ? 0 : 1;
                    } else if (i == 3) {
                        id = (iA0M & 32) != 0 ? 1 : 0;
                        flags = (iA0M & 128) == 0 ? 0 : 1;
                    }
                    int i3 = 0;
                    strArr = A02;
                    if (strArr[1].charAt(20) == strArr[7].charAt(20)) {
                        break;
                    }
                    String[] strArr2 = A02;
                    strArr2[1] = "MVZStPJLdDxKiV7nz1H6dv3NOIiLFLEe";
                    strArr2[7] = "QTxGzLkjWgw6uSVWxpxBdQfPOh5DKkgy";
                    if (id != 0) {
                        i3 = 0 + 1;
                    }
                    if (flags != 0) {
                        i3 += 4;
                    }
                    if (jA0Q < i3) {
                        c02284v.A0f(iA09);
                        return false;
                    }
                    int minimumFrameSize = c02284v.A07();
                    long j = minimumFrameSize;
                    String[] strArr3 = A02;
                    String str = strArr3[6];
                    String str2 = strArr3[3];
                    int length = str.length();
                    int minimumFrameSize2 = str2.length();
                    if (length == minimumFrameSize2) {
                        A02[5] = "edbBlZh6UxoMPnyEc6lG0E5oPDAO53n7";
                        if (j < jA0Q) {
                            break;
                        }
                        int minimumFrameSize3 = (int) jA0Q;
                        c02284v.A0g(minimumFrameSize3);
                    } else {
                        if (j < jA0Q) {
                            break;
                        }
                        int minimumFrameSize32 = (int) jA0Q;
                        c02284v.A0g(minimumFrameSize32);
                    }
                } else if ((8421504 & jA0Q) != 0) {
                    c02284v.A0f(iA09);
                    String[] strArr4 = A02;
                    if (strArr4[1].charAt(20) == strArr4[7].charAt(20)) {
                        String[] strArr5 = A02;
                        strArr5[1] = "5mCE9WytQNPeLFhBzaYSd2zmXPTMRlgu";
                        strArr5[7] = "AgecK2HA7Twj8m2CWduPdApaKwCpCynb";
                        return false;
                    }
                } else {
                    jA0Q = (((jA0Q >> 24) & 255) << 21) | (jA0Q & 255) | (((jA0Q >> 8) & 255) << 7) | (((jA0Q >> 16) & 255) << 14);
                    int id2 = 0;
                    int flags2 = 0;
                    if (i != 4) {
                    }
                    int i32 = 0;
                    strArr = A02;
                    if (strArr[1].charAt(20) == strArr[7].charAt(20)) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        c02284v.A0f(iA09);
        return false;
    }

    public static byte[] A0Q(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return C5C.A07;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1753mZ
    public final Metadata A0R(C03359e c03359e, ByteBuffer byteBuffer) {
        return A0S(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata A0S(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        C02284v c02284v = new C02284v(bArr, i);
        IF ifA0A = A0A(c02284v);
        if (ifA0A == null) {
            return null;
        }
        int startPosition = c02284v.A09();
        int frameHeaderSize = ifA0A.A01 == 2 ? 6 : 10;
        int iA01 = ifA0A.A00;
        if (ifA0A.A02) {
            iA01 = A01(c02284v, ifA0A.A00);
        }
        c02284v.A0e(startPosition + iA01);
        boolean z = false;
        if (!A0P(c02284v, ifA0A.A01, frameHeaderSize, false)) {
            if (ifA0A.A01 == 4 && A0P(c02284v, 4, frameHeaderSize, true)) {
                z = true;
            } else {
                AbstractC02134g.A07(A0J(170, 10, 14), A0J(88, 45, 57) + ifA0A.A01);
                return null;
            }
        }
        while (c02284v.A07() >= frameHeaderSize) {
            Id3Frame id3FrameA0B = A0B(ifA0A.A01, c02284v, z, frameHeaderSize, this.A00);
            if (id3FrameA0B != null) {
                arrayList.add(id3FrameA0B);
            }
        }
        return new Metadata(arrayList);
    }
}
