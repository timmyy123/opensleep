package com.facebook.ads.redexgen.core;

import android.text.Html;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.home.platform.traits.ValidationIssue;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ov, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1897ov implements EP {
    public static byte[] A01;
    public final /* synthetic */ C1896ou A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{118, 67, 67, 82, 90, 71, 67, 82, 83, 23, 67, 88, 23, 84, 69, 82, 86, 67, 82, 23, 83, 82, 84, 88, 83, 82, 69, 23, 81, 88, 69, 23, 66, 89, 68, 66, 71, 71, 88, 69, 67, 82, 83, 23, 81, 88, 69, 90, 86, 67, 28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 17, 20, 30, 28, 9, 20, 18, 19, 82, 30, 24, 28, 80, 75, 77, 69, 121, 104, 104, 116, 113, 123, 121, 108, 113, 119, 118, 55, 123, 125, 121, 53, 47, 40, 32, 107, 122, 122, 102, 99, 105, 107, 126, 99, 101, 100, 37, 110, 124, 104, 121, 127, 104, 121, 69, 84, 84, 72, 77, 71, 69, 80, 77, 75, 74, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 84, 67, 87, 5, 20, 20, 8, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 7, 5, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 75, 16, 16, 9, 8, 79, 28, 9, 8, 0, 17, 17, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 8, 2, 0, 21, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 78, 25, 76, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 85, 76, 2, 4, 0, 76, 87, 81, 89, 53, 36, 36, 56, 61, 55, 53, 32, 61, 59, 58, 123, 44, 121, 57, 36, 96, 121, 34, 32, 32, 50, 35, 35, 63, 58, 48, 50, 39, 58, 60, 61, 124, 43, 126, 34, 38, 58, 48, 56, 39, 58, 62, 54, 126, 39, 43, 96, 52, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 29, 29, 1, 4, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 25, 4, 2, 3, 66, 21, 64, 30, 24, 15, 31, 4, 29, 68, 85, 72, 68, 31, 70, 68, 68, 83, 66, 95, 83, 8, 95, 10, 84, 84, 70};
    }

    public C1897ov(C1896ou c1896ou) {
        this.A00 = c1896ou;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0009  */
    @Override // com.facebook.ads.redexgen.core.EP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InterfaceC1720lq A5K(C1981qI c1981qI) {
        byte b;
        String str = c1981qI.A0W;
        switch (str.hashCode()) {
            case -1351681404:
                b = !str.equals(A00(88, 19, 24)) ? (byte) -1 : (byte) 9;
                break;
            case -1248334819:
                if (str.equals(A00(107, 15, 54))) {
                    b = 10;
                    break;
                }
                break;
            case -1026075066:
                if (str.equals(A00(167, 21, 70))) {
                    b = 2;
                    break;
                }
                break;
            case -1004728940:
                if (str.equals(A00(236, 8, 34))) {
                    b = 0;
                    break;
                }
                break;
            case 691401887:
                if (str.equals(A00(188, 28, 65))) {
                    b = 5;
                    break;
                }
                break;
            case 822864842:
                if (str.equals(A00(244, 10, 53))) {
                    b = 1;
                    break;
                }
                break;
            case 930165504:
                if (str.equals(A00(142, 25, 115))) {
                    b = 7;
                    break;
                }
                break;
            case 1566015601:
                if (str.equals(A00(50, 19, 111))) {
                    b = 6;
                    break;
                }
                break;
            case 1566016562:
                if (str.equals(A00(69, 19, 10))) {
                    b = 8;
                    break;
                }
                break;
            case 1668750253:
                if (str.equals(A00(216, 20, 127))) {
                    b = 4;
                    break;
                }
                break;
            case 1693976202:
                if (str.equals(A00(122, 20, 118))) {
                    b = 3;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                return new C8T() { // from class: com.facebook.ads.redexgen.X.1M
                    public static byte[] A02;
                    public static String[] A03 = {"epLQ4LbruRQu4TauEDrO5bv5Gt", "lRHUrkH9gFGX2N51jXHSI4WiLesC2sz", "FQaGWX09aBSonO1KXWblQ89ZNSDo33Hs", "Tkmuz5Wj47OzYTdqGDI6w0S24YPshGEJ", "sgOZPElMCLLZtQnBcWUjhEzDIZNKx3Aa", "fl5M4MkFrWZTay9Eb0GxyqH", "d522uHqhkgB6wqoRNygeE3zqn3vb1GZ9", "ktGThckFXvstcJxcyByVYeW6HtIWaGJ1"};
                    public final C02284v A00;
                    public final KX A01;

                    public static String A01(int i, int i2, int i3) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 88);
                        }
                        return new String(bArrCopyOfRange);
                    }

                    public static void A02() {
                        A02 = new byte[]{123, 26, 73, 78, 67, 86, 95, 26, 88, 86, 85, 89, 81, 26, 77, 91, 73, 26, 92, 85, 79, 84, 94, 26, 91, 92, 78, 95, 72, 26, 78, 82, 95, 26, 92, 83, 72, 73, 78, 26, 89, 79, 95, 20, 108, 109, 118, 103, 88, 95, 82, 71, 78, 53, 7, 0, 20, 22, 22, 38, 7, 1, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 6, 7, 16};
                    }

                    static {
                        A02();
                    }

                    {
                        A01(53, 13, 58);
                        this.A00 = new C02284v();
                        this.A01 = new KX();
                    }

                    public static int A00(C02284v c02284v) {
                        int currentInputPosition = -1;
                        int iA09 = 0;
                        while (currentInputPosition == -1) {
                            iA09 = c02284v.A09();
                            String strA0T = c02284v.A0T();
                            if (strA0T == null) {
                                currentInputPosition = 0;
                            } else if (A01(48, 5, 83).equals(strA0T)) {
                                currentInputPosition = 2;
                            } else if (strA0T.startsWith(A01(44, 4, 122))) {
                                currentInputPosition = 1;
                            } else {
                                currentInputPosition = 3;
                            }
                        }
                        c02284v.A0f(iA09);
                        return currentInputPosition;
                    }

                    public static void A03(C02284v c02284v) {
                        while (!TextUtils.isEmpty(c02284v.A0T())) {
                        }
                    }

                    @Override // com.facebook.ads.redexgen.core.C8T
                    public final InterfaceC0585Jj A0g(byte[] bArr, int i, boolean z) throws C1713lj {
                        C0607Kf c0607KfA0A;
                        this.A00.A0j(bArr, i);
                        ArrayList arrayList = new ArrayList();
                        try {
                            AbstractC0616Ko.A04(this.A00);
                            while (!TextUtils.isEmpty(this.A00.A0T())) {
                            }
                            ArrayList arrayList2 = new ArrayList();
                            while (true) {
                                int iA00 = A00(this.A00);
                                if (iA00 == 0) {
                                    return new C1703lZ(arrayList2);
                                }
                                String[] strArr = A03;
                                if (strArr[3].charAt(29) != strArr[7].charAt(29)) {
                                    throw new RuntimeException();
                                }
                                String[] strArr2 = A03;
                                strArr2[5] = "xiLYwX29jkzhCedrUoNIffc";
                                strArr2[0] = "YvTJvYd1hKFZiQGGAeLzXV3lAN";
                                if (iA00 == 1) {
                                    A03(this.A00);
                                } else if (iA00 == 2) {
                                    if (arrayList2.isEmpty()) {
                                        this.A00.A0T();
                                        arrayList.addAll(this.A01.A0F(this.A00));
                                    } else {
                                        throw new C1713lj(A01(0, 44, 98));
                                    }
                                } else if (iA00 == 3 && (c0607KfA0A = AbstractC0615Kn.A0A(this.A00, arrayList)) != null) {
                                    arrayList2.add(c0607KfA0A);
                                }
                            }
                        } catch (C3K e) {
                            throw new C1713lj(e);
                        }
                    }
                };
            case 1:
                return new C1R(c1981qI.A0X);
            case 2:
                return new C8T() { // from class: com.facebook.ads.redexgen.X.1N
                    public static byte[] A01;
                    public final C02284v A00;

                    static {
                        A02();
                    }

                    public static String A01(int i, int i2, int i3) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 125);
                        }
                        return new String(bArrCopyOfRange);
                    }

                    public static void A02() {
                        A01 = new byte[]{22, 59, 48, 60, 58, 61, 57, 50, 65, 50, -19, 26, 61, 1, 36, 50, 47, 67, 65, 65, -19, 33, 60, 61, -19, 25, 50, 67, 50, 57, -19, 47, 60, 69, -19, 53, 50, 46, 49, 50, 63, -19, 51, 60, 66, 59, 49, -5, 47, 84, 73, 85, 83, 86, 82, 75, 90, 75, 6, 92, 90, 90, 6, 73, 91, 75, 6, 72, 85, 94, 6, 78, 75, 71, 74, 75, 88, 6, 76, 85, 91, 84, 74, 20, 62, 97, 37, 72, 86, 83, 103, 101, 101, 53, 86, 84, 96, 85, 86, 99};
                    }

                    {
                        A01(84, 16, 116);
                        this.A00 = new C02284v();
                    }

                    public static C1931pT A00(C02284v c02284v, int i) throws C1713lj {
                        C01953o c01953oA08 = null;
                        CharSequence charSequenceA01 = null;
                        while (i > 0) {
                            if (i >= 8) {
                                int iA0C = c02284v.A0C();
                                int boxType = c02284v.A0C();
                                int boxSize = iA0C - 8;
                                String strA0r = C5C.A0r(c02284v.A0l(), c02284v.A09(), boxSize);
                                c02284v.A0g(boxSize);
                                i = (i - 8) - boxSize;
                                if (boxType == 1937011815) {
                                    c01953oA08 = AbstractC0615Kn.A08(strA0r);
                                } else if (boxType == 1885436268) {
                                    charSequenceA01 = AbstractC0615Kn.A07(null, strA0r.trim(), Collections.emptyList());
                                }
                            } else {
                                throw new C1713lj(A01(48, 36, 105));
                            }
                        }
                        if (charSequenceA01 == null) {
                            charSequenceA01 = A01(0, 0, 70);
                        }
                        if (c01953oA08 != null) {
                            C01953o cueBuilder = c01953oA08.A0G(charSequenceA01);
                            return cueBuilder.A0H();
                        }
                        return AbstractC0615Kn.A09(charSequenceA01);
                    }

                    @Override // com.facebook.ads.redexgen.core.C8T
                    public final InterfaceC0585Jj A0g(byte[] bArr, int i, boolean z) throws C1713lj {
                        this.A00.A0j(bArr, i);
                        ArrayList arrayList = new ArrayList();
                        while (this.A00.A07() > 0) {
                            if (this.A00.A07() >= 8) {
                                int boxType = this.A00.A0C();
                                int boxSize = this.A00.A0C();
                                if (boxSize == 1987343459) {
                                    arrayList.add(A00(this.A00, boxType - 8));
                                } else {
                                    this.A00.A0g(boxType - 8);
                                }
                            } else {
                                throw new C1713lj(A01(0, 48, 80));
                            }
                        }
                        return new C1704la(arrayList);
                    }
                };
            case 3:
                return new C8T() { // from class: com.facebook.ads.redexgen.X.1P
                    public static byte[] A01;
                    public static String[] A02 = {"p1JjjwHZ", "QiEjWLFXcVg7o", "nhuwGOrxAOZ3j55eqRpahgaz0GwfX6tj", "6yXpXZapadp8VRb316vvjAm5hV4yaSxg", "TGmXy7X22d03bAdpvyZyh6X1I", "ARR0m23eYWSlS3UtdvlKiKeM", "Lwdw5zAjTw10lXQrei1yTZcIsGO5NNLU", "PxBJlerCHj8MDVjvQLeWSQf3c"};
                    public static final Pattern A03;
                    public static final Pattern A04;
                    public static final KJ A05;
                    public static final KK A06;
                    public static final Pattern A07;
                    public static final Pattern A08;
                    public static final Pattern A09;
                    public static final Pattern A0A;
                    public static final Pattern A0B;
                    public final XmlPullParserFactory A00;

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x00d3  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public static long A01(String str2, KK kk) throws C1713lj {
                        Matcher matcher = A08.matcher(str2);
                        byte b2 = 5;
                        if (matcher.matches()) {
                            double d = (Long.parseLong((String) AbstractC02053y.A01(matcher.group(1))) * 3600) + (Long.parseLong((String) AbstractC02053y.A01(matcher.group(2))) * 60) + Long.parseLong((String) AbstractC02053y.A01(matcher.group(3)));
                            String strGroup = matcher.group(4);
                            double d2 = d + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
                            String strGroup2 = matcher.group(5);
                            String[] strArr = A02;
                            if (strArr[1].length() == strArr[5].length()) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A02;
                            strArr2[6] = "mLEwrm7vKLrlfB6LVj0FJa0TtKMuAs5P";
                            strArr2[2] = "qTZwtworCWndH0Ay7tgKRNpRsf0PfjPC";
                            return (long) (1000000.0d * (d2 + (strGroup2 != null ? Long.parseLong(strGroup2) / kk.A00 : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r0) / ((double) kk.A01)) / ((double) kk.A00) : 0.0d)));
                        }
                        Matcher matcher2 = A0A.matcher(str2);
                        if (!matcher2.matches()) {
                            throw new C1713lj(A0A(708, 27, 100) + str2);
                        }
                        double d3 = Double.parseDouble((String) AbstractC02053y.A01(matcher2.group(1)));
                        String str3 = (String) AbstractC02053y.A01(matcher2.group(2));
                        switch (str3.hashCode()) {
                            case 102:
                                b2 = !str3.equals(A0A(1361, 1, 8)) ? (byte) -1 : (byte) 4;
                                break;
                            case 104:
                                if (str3.equals(A0A(1467, 1, 40))) {
                                    b2 = 0;
                                    break;
                                }
                                break;
                            case 109:
                                if (str3.equals(A0A(1552, 1, 100))) {
                                    b2 = 1;
                                    break;
                                }
                                break;
                            case 115:
                                if (str3.equals(A0A(1640, 1, 44))) {
                                    b2 = 2;
                                    break;
                                }
                                break;
                            case 116:
                                if (!str3.equals(A0A(1679, 1, 82))) {
                                }
                                break;
                            case 3494:
                                if (str3.equals(A0A(1561, 2, 125))) {
                                    b2 = 3;
                                    break;
                                }
                                break;
                        }
                        switch (b2) {
                            case 0:
                                d3 *= 3600.0d;
                                break;
                            case 1:
                                d3 *= 60.0d;
                                break;
                            case 3:
                                d3 /= 1000.0d;
                                break;
                            case 4:
                                d3 /= (double) kk.A00;
                                break;
                            case 5:
                                d3 /= (double) kk.A02;
                                break;
                        }
                        return (long) (1000000.0d * d3);
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    public static KJ A03(XmlPullParser xmlPullParser, KJ kj) throws C1713lj {
                        String attributeValue = xmlPullParser.getAttributeValue(A0A(1472, 35, 92), A0A(1285, 14, 65));
                        if (attributeValue == null) {
                            return kj;
                        }
                        Matcher matcher = A07.matcher(attributeValue);
                        boolean zMatches = matcher.matches();
                        String strA0A = A0A(166, 36, 70);
                        String strA0A2 = A0A(892, 11, 16);
                        if (!zMatches) {
                            AbstractC02134g.A07(strA0A2, strA0A + attributeValue);
                            return kj;
                        }
                        try {
                            int i = Integer.parseInt((String) AbstractC02053y.A01(matcher.group(1)));
                            int i2 = Integer.parseInt((String) AbstractC02053y.A01(matcher.group(2)));
                            if (i == 0 || i2 == 0) {
                                throw new C1713lj(A0A(557, 24, 126) + i + A0A(0, 1, 42) + i2);
                            }
                            return new KJ(i, i2);
                        } catch (NumberFormatException unused) {
                            AbstractC02134g.A07(strA0A2, strA0A + attributeValue);
                            return kj;
                        }
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
                    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
                    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
                    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
                    /* JADX WARN: Removed duplicated region for block: B:6:0x0039  */
                    /* JADX WARN: Removed duplicated region for block: B:74:0x003f A[SYNTHETIC] */
                    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
                        java.lang.UnsupportedOperationException
                        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
                        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
                        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
                        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
                        */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public static com.facebook.ads.redexgen.core.KM A06(org.xmlpull.v1.XmlPullParser r21, com.facebook.ads.redexgen.core.KM r22, java.util.Map<java.lang.String, com.facebook.ads.redexgen.core.KN> r23, com.facebook.ads.redexgen.core.KK r24) throws com.facebook.ads.redexgen.core.C1713lj {
                        /*
                            Method dump skipped, instruction units count: 416
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1P.A06(org.xmlpull.v1.XmlPullParser, com.facebook.ads.redexgen.X.KM, java.util.Map, com.facebook.ads.redexgen.X.KK):com.facebook.ads.redexgen.X.KM");
                    }

                    public static String A0A(int i, int i2, int i3) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                            byte b2 = bArrCopyOfRange[i4];
                            if (A02[0].length() == 7) {
                                throw new RuntimeException();
                            }
                            String[] strArr = A02;
                            strArr[1] = "MzedSJZDJL3LD";
                            strArr[5] = "g6loelR4939QZaycQmxedlYL";
                            bArrCopyOfRange[i4] = (byte) ((b2 - i3) - 113);
                        }
                        return new String(bArrCopyOfRange);
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    public static Map<String, KT> A0B(XmlPullParser xmlPullParser, Map<String, KT> map, KJ kj, KL kl, Map<String, KN> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
                        do {
                            xmlPullParser.next();
                            String strA0A = A0A(1655, 5, 93);
                            if (C5I.A04(xmlPullParser, strA0A)) {
                                String strA00 = C5I.A00(xmlPullParser, strA0A);
                                KT ktA09 = A09(xmlPullParser, new KT());
                                if (strA00 != null) {
                                    String[] strArrA0G = A0G(strA00);
                                    if (A02[3].charAt(8) != 'a') {
                                        throw new RuntimeException();
                                    }
                                    String[] strArr = A02;
                                    strArr[6] = "oxowjvWuzCcWkzEkDRByU8LkLZUydqr3";
                                    strArr[2] = "XAdwn62c6rSvSVMr71C9Wpdxl0LeAUIU";
                                    for (String str2 : strArrA0G) {
                                        ktA09.A0O(map.get(str2));
                                    }
                                }
                                String strA0X = ktA09.A0X();
                                if (strA0X != null) {
                                    map.put(strA0X, ktA09);
                                }
                            } else if (C5I.A04(xmlPullParser, A0A(1613, 6, 33))) {
                                KN knA07 = A07(xmlPullParser, kj, kl);
                                if (knA07 != null) {
                                    map2.put(knA07.A09, knA07);
                                }
                            } else {
                                boolean zA04 = C5I.A04(xmlPullParser, A0A(1553, 8, 69));
                                String[] strArr2 = A02;
                                if (strArr2[1].length() == strArr2[5].length()) {
                                    throw new RuntimeException();
                                }
                                String[] strArr3 = A02;
                                strArr3[6] = "B6Mw4qhmB6vQw7zev9YlYKUDY0kxCfVe";
                                strArr3[2] = "G12wwLtLBhQxBioY68m1H9JFDs55K6Az";
                                if (zA04) {
                                    A0E(xmlPullParser, map3);
                                }
                            }
                        } while (!C5I.A03(xmlPullParser, A0A(1468, 4, 96)));
                        return map;
                    }

                    public static void A0C() {
                        byte[] bArr = {-69, -57, 6, -27, -20, -36, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 55, 61, 52, 44, 54, -17, 60, -24, 43, 58, 45, 41, 60, 45, -24, 32, 53, 52, 24, 61, 52, 52, 24, 41, 58, 59, 45, 58, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 41, 43, 60, 55, 58, 65, -24, 49, 54, 59, 60, 41, 54, 43, 45, 28, 55, 63, 66, 59, 58, -10, 70, 55, 72, 73, 63, 68, 61, -10, 56, 55, 57, 65, 61, 72, 69, 75, 68, 58, -10, 76, 55, 66, 75, 59, 16, -10, -73, -46, -38, -35, -42, -43, -111, -31, -46, -29, -28, -38, -33, -40, -111, -44, -32, -35, -32, -29, -111, -25, -46, -35, -26, -42, -85, -111, 16, 43, 51, 54, 47, 46, -22, 58, 43, 60, 61, 51, 56, 49, -22, 48, 57, 56, 62, 29, 51, 68, 47, -22, 64, 43, 54, 63, 47, 4, -22, 0, 27, 35, 38, 31, 30, -38, 46, 41, -38, 42, 27, 44, 45, 31, -38, 45, 34, 31, 27, 44, -12, -38, 0, 30, 37, 38, 41, 32, 37, 30, -41, 36, 24, 35, 29, 38, 41, 36, 28, 27, -41, 26, 28, 35, 35, -41, 41, 28, 42, 38, 35, 44, 43, 32, 38, 37, -15, -41, 29, 59, 66, 67, 70, 61, 66, 59, -12, 65, 53, 64, 58, 67, 70, 65, 57, 56, -12, 72, 72, 71, -12, 57, 76, 72, 57, 66, 72, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -12, 52, 82, 89, 90, 93, 84, 89, 82, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 89, 90, 89, 24, 91, 84, 99, 80, 87, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 95, 95, 94, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 80, 99, 95, 80, 89, 95, 37, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1, 31, 38, 39, 42, 33, 38, 31, -40, 42, 29, 31, 33, 39, 38, -40, 47, 33, 44, 32, -40, 37, 25, 36, 30, 39, 42, 37, 29, 28, -40, 29, 48, 44, 29, 38, 44, -14, -40, -41, -11, -4, -3, 0, -9, -4, -11, -82, 0, -13, -11, -9, -3, -4, -82, 5, -9, 2, -10, -82, -5, -17, -6, -12, -3, 0, -5, -13, -14, -82, -3, 0, -9, -11, -9, -4, -56, -82, -15, 15, 22, 23, 26, 17, 22, 15, -56, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 15, 17, 23, 22, -56, 31, 17, 28, 16, -56, 21, 17, 27, 27, 17, 22, 15, -56, 28, 28, 27, -30, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 32, 28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 22, 28, -30, -56, 40, 70, 77, 78, 81, 72, 77, 70, -1, 81, 68, 70, 72, 78, 77, -1, 86, 72, 83, 71, -1, 84, 77, 82, 84, 79, 79, 78, 81, 83, 68, 67, -1, 68, 87, 83, 68, 77, 83, 25, -1, -9, 21, 28, 29, 32, 23, 28, 21, -50, 32, 19, 21, 23, 29, 28, -50, 37, 23, 34, 22, -50, 35, 28, 33, 35, 30, 30, 29, 32, 34, 19, 18, -50, 29, 32, 23, 21, 23, 28, -24, -50, -20, 10, 17, 18, 21, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 10, -61, 21, 8, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, 17, -61, 26, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 18, 24, 23, -61, 4, 17, -61, 8, 27, 23, 8, 17, 23, -57, -27, -20, -19, -16, -25, -20, -27, -98, -16, -29, -27, -25, -19, -20, -98, -11, -25, -14, -26, -19, -13, -14, -98, -33, -20, -98, -19, -16, -25, -27, -25, -20, 44, 74, 81, 82, 85, 76, 81, 74, 3, 88, 81, 86, 88, 83, 83, 82, 85, 87, 72, 71, 3, 87, 68, 74, 29, 3, 56, 93, 101, 80, 91, 88, 83, 15, 82, 84, 91, 91, 15, 97, 84, 98, 94, 91, 100, 99, 88, 94, 93, 15, -46, -9, -1, -22, -11, -14, -19, -87, -18, 1, -7, -5, -18, -4, -4, -14, -8, -9, -87, -17, -8, -5, -87, -17, -8, -9, -3, -36, -14, 3, -18, -61, -87, -80, 6, 43, 51, 30, 41, 38, 33, -35, 43, 50, 42, 31, 34, 47, -35, 44, 35, -35, 34, 43, 49, 47, 38, 34, 48, -35, 35, 44, 47, -35, 35, 44, 43, 49, 16, 38, 55, 34, -9, -35, -16, 21, 29, 8, 19, 16, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -57, 28, 21, 16, 27, -57, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 22, 25, -57, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 22, 21, 27, -6, 16, 33, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -31, -57, -50, 2, 39, 47, 26, 37, 34, 29, -39, 47, 26, 37, 46, 30, -39, 31, 40, 43, -39, 44, 33, 30, 26, 43, -13, -39, 34, 54, 65, 59, 68, 71, 66, 58, 57, -11, 73, 62, 66, 58, -11, 58, 77, 69, 71, 58, 72, 72, 62, 68, 67, 15, -11, 39, 79, 70, 78, 67, 74, 70, 63, -6, 80, 59, 70, 79, 63, 77, -6, 67, 72, -6, 64, 73, 72, 78, 45, 67, 84, 63, -6, 59, 78, 78, 76, 67, 60, 79, 78, 63, 8, -6, 42, 67, 61, 69, 67, 72, 65, -6, 78, 66, 63, -6, 77, 63, 61, 73, 72, 62, -6, 80, 59, 70, 79, 63, -6, 64, 73, 76, -6, 80, 63, 76, 78, 67, 61, 59, 70, -6, 64, 73, 72, 78, -6, 77, 67, 84, 63, -6, 59, 72, 62, -6, 67, 65, 72, 73, 76, 67, 72, 65, -6, 78, 66, 63, -6, 64, 67, 76, 77, 78, 8, -58, -25, -104, -52, -52, -59, -60, -104, -21, -19, -38, -20, -31, -20, -28, -35, -21, -104, -34, -25, -19, -26, -36, -31, 3, -2, -2, 0, -13, 1, 1, -9, -4, -11, -82, -2, -17, 0, 1, -13, 0, -82, -13, 0, 0, -3, 0, -43, -11, -18, -19, -59, -26, -28, -16, -27, -26, -13, -10, 15, 2, 3, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 6, -63, 21, 16, -63, 5, 6, 4, 16, 5, 6, -63, 20, 16, 22, 19, 4, 6, -25, 0, -9, 10, 2, -9, -11, 6, -9, -10, -78, -9, 4, 4, 1, 4, -78, 9, -6, -9, 0, -78, 4, -9, -13, -10, -5, 0, -7, -78, -5, 0, 2, 7, 6, -64, 9, 32, -40, -42, -96, -96, -45, -88, -91, -79, -43, -94, -90, -95, -73, -45, -88, -91, -79, -43, -93, -95, -96, -24, -16, -12, -35, -27, -12, -99, -95, -100, -16, -70, -19, -65, -67, -17, 
                        -47, -18, -10, -67, -18, -64, -47, -18, -10, -68, -47, -69, -73, -74, -47, -101, -50, -93, -96, -84, -48, -98, -101, -78, -83, -49, -95, -50, -93, -96, -84, -48, -98, -100, -78, -100, -101, -37, -17, -32, -17, -26, -17, -32, -26, -17, -39, -17, -25, -100, -105, 17, -37, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, -34, -36, -19, -37, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, -36, -19, -37, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, -36, -37, -14, -19, -37, 15, -31, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, -34, -36, 47, -19, -37, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, -36, -37, -14, -19, 15, -31, -37, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -29, -32, -20, 16, -34, -36, -36, -14, -36, -14, -41, 54, 0, 52, 60, 3, 1, -8, 0, 52, 60, 3, 1, -4, -49, -103, -51, -43, -100, -51, -97, -80, -51, -43, -101, -80, -102, -106, -111, -103, -51, -43, -100, -51, -97, -80, -51, -43, -101, -80, -102, -106, -107, 18, -36, 16, 24, -33, 16, -30, -13, 16, 24, -34, -13, -35, 36, 44, -44, -36, 16, 24, -33, 16, -30, -13, 16, 24, -34, -13, -35, 36, 44, -40, -9, -4, 10, -5, 8, 28, 39, 39, 58, 57, 59, 67, 63, 74, 71, 77, 70, 60, 27, 71, 68, 71, 74, 6, 5, 7, 15, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 22, 19, 25, 18, 8, -19, 17, 5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9, 76, 75, 93, 79, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 32, 18, -16, 28, 27, 33, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 22, 27, 18, 31, 54, 57, 58, 67, 70, 57, 15, 18, 20, 22, 27, -2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 21, 25, 38, 35, 27, 52, 68, 21, 23, 30, 30, 4, 23, 37, 33, 30, 39, 38, 27, 33, 32, -26, -24, -15, -9, -24, -11, 45, 57, 54, 57, 60, 79, 91, 90, 96, 77, 85, 90, 81, 94, -32, -35, -16, -35, -24, -23, -16, -19, -15, -19, -8, -23, -10, 68, 73, 83, 80, 76, 65, 89, 33, 76, 73, 71, 78, 61, 66, 79, 10, 27, 24, 34, 42, -25, -16, -26, 3, 22, 18, 3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, -33, -19, -10, -11, -5, -51, -24, -12, -16, -13, 0, -28, -19, -20, -14, -47, -25, -8, -29, 54, 63, 62, 68, 35, 68, 73, 60, 53, 4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, -11, 3, 7, 5, 6, 18, 80, 92, 75, 87, 79, 60, 75, 94, 79, -15, -3, -20, -8, -16, -35, -20, -1, -16, -40, 0, -9, -1, -12, -5, -9, -12, -16, -3, -20, -8, -25, -13, -21, -40, -25, -6, -21, -45, -5, -14, -6, -17, -10, -14, -17, -21, -8, -90, -22, -11, -21, -7, -12, -83, -6, -90, -18, -25, -4, -21, -90, -72, -90, -10, -25, -8, -6, -7, 1, 57, 54, 50, 53, 53, 65, 65, 61, 7, -4, -4, 68, 68, 68, -5, 68, 0, -5, 60, 63, 52, -4, 59, 64, -4, 65, 65, 58, 57, -16, 61, 46, 63, 46, 58, 50, 65, 50, 63, 52, 47, 3, 7, -5, 1, -1, -35, -30, -38, -29, -26, -31, -43, -24, -35, -29, -30, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -8, 3, 0, -6, 50, 39, 63, 53, 59, 58, 87, 80, 81, 95, 4, 1, 6, -3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 10, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -1, 0, 66, 35, 27, 42, 23, 26, 23, 42, 23, 91, 97, 40, 48, 39, 47, 36, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 42, 50, -4, 39, 36, 34, 41, 76, 77, 74, 71, 76, 67, 82, 70, 80, 77, 83, 69, 70, 60, 61, 60, 51, 25, 26, 32, 25, 15, 16, 29, 23, 20, 25, 16, 33, 36, 27, 25, 27, 32, -31, 80, 88, 4, -9, -7, -5, 1, 0, -3, -12, -14, -13, -1, 88, 91, 72, 95, 75, 78, 59, 82, 41, 72, 76, 66, 77, 66, 72, 71, 16, 37, 26, 23, 19, 36, 34, 31, 16, 29, 32, 33, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, 33, 65, 66, 71, 58, 51, 71, 72, 77, 64, 61, 66, 59, 74, 76, 57, 29, 73, 56, 68, 60, 41, 56, 75, 60, 55, 27, 9, 53, 35, 45, 51, -3, -21, -5, -11, 42, 27, 46, 42, 60, 45, 64, 60, 9, 52, 49, 47, 54, 60, 45, 64, 60, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 55, 53, 42, 49, 54, 45, -6, -21, -2, -6, -55, -11, -12, -6, -25, -17, -12, -21, -8, 67, 52, 71, 67, 19, 52, 50, 62, 65, 48, 67, 56, 62, 61, 22, 7, 26, 22, -25, 15, 18, 10, 3, 21, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 21, 80, 69, 63, 71, 46, 61, 80, 65, 29, 29, 47, 40, 30, 31, 44, 38, 35, 40, 31, -8, -13, -22, -11, -22, -17, -24, -50, -16, -27, -26};
                        String[] strArr = A02;
                        if (strArr[6].charAt(3) != strArr[2].charAt(3)) {
                            throw new RuntimeException();
                        }
                        A02[3] = "YYEb81Zja86Dd7gFpf2yHyw2w0ZKb0ns";
                        A01 = bArr;
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    @Override // com.facebook.ads.redexgen.core.C8T
                    public final InterfaceC0585Jj A0g(byte[] bArr, int i, boolean z) throws C1713lj {
                        String strA0A = A0A(0, 0, 87);
                        try {
                            XmlPullParser xmlPullParserNewPullParser = this.A00.newPullParser();
                            HashMap map = new HashMap();
                            HashMap map2 = new HashMap();
                            HashMap map3 = new HashMap();
                            map2.put(strA0A, new KN(strA0A));
                            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
                            C1706lc c1706lc = null;
                            ArrayDeque arrayDeque = new ArrayDeque();
                            int i2 = 0;
                            KK kkA04 = A06;
                            KJ kjA03 = A05;
                            KL klA05 = null;
                            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                                KM km = (KM) arrayDeque.peek();
                                if (i2 == 0) {
                                    String name = xmlPullParserNewPullParser.getName();
                                    String strA0A2 = A0A(1761, 2, 56);
                                    if (eventType == 2) {
                                        if (strA0A2.equals(name)) {
                                            kkA04 = A04(xmlPullParserNewPullParser);
                                            kjA03 = A03(xmlPullParserNewPullParser, A05);
                                            klA05 = A05(xmlPullParserNewPullParser);
                                        }
                                        boolean zA0F = A0F(name);
                                        String strA0A3 = A0A(892, 11, 16);
                                        if (!zA0F) {
                                            AbstractC02134g.A06(strA0A3, A0A(531, 26, 114) + xmlPullParserNewPullParser.getName());
                                            i2++;
                                        } else if (A0A(1468, 4, 96).equals(name)) {
                                            A0B(xmlPullParserNewPullParser, map, kjA03, klA05, map2, map3);
                                        } else {
                                            try {
                                                KM kmA06 = A06(xmlPullParserNewPullParser, km, map2, kkA04);
                                                arrayDeque.push(kmA06);
                                                if (km != null) {
                                                    km.A0F(kmA06);
                                                }
                                            } catch (C1713lj e) {
                                                AbstractC02134g.A0A(strA0A3, A0A(868, 24, 29), e);
                                                i2++;
                                            }
                                        }
                                    } else if (eventType == 4) {
                                        ((KM) AbstractC02053y.A01(km)).A0F(KM.A01(xmlPullParserNewPullParser.getText()));
                                    } else if (eventType == 3) {
                                        if (xmlPullParserNewPullParser.getName().equals(strA0A2)) {
                                            c1706lc = new C1706lc((KM) AbstractC02053y.A01((KM) arrayDeque.peek()), map, map2, map3);
                                        }
                                        arrayDeque.pop();
                                    }
                                } else {
                                    if (A02[0].length() == 7) {
                                        throw new RuntimeException();
                                    }
                                    A02[3] = "q6wSX38Wa3tvhMiP87hlFBAs7B3bq4ae";
                                    if (eventType == 2) {
                                        i2++;
                                    } else if (eventType == 3) {
                                        i2--;
                                    }
                                }
                                xmlPullParserNewPullParser.next();
                            }
                            if (c1706lc != null) {
                                return c1706lc;
                            }
                            throw new C1713lj(A0A(845, 23, 7));
                        } catch (IOException e2) {
                            throw new IllegalStateException(A0A(926, 36, 33), e2);
                        } catch (XmlPullParserException e3) {
                            throw new C1713lj(A0A(903, 23, 48), e3);
                        }
                    }

                    static {
                        A0C();
                        A08 = Pattern.compile(A0A(1051, 85, 66));
                        A0A = Pattern.compile(A0A(1014, 37, 2));
                        A09 = Pattern.compile(A0A(965, 29, 7));
                        A04 = Pattern.compile(A0A(994, 20, 33));
                        A03 = Pattern.compile(A0A(1149, 29, 0));
                        A0B = Pattern.compile(A0A(1178, 31, 67));
                        A07 = Pattern.compile(A0A(1136, 13, 103));
                        A06 = new KK(30.0f, 1, 1);
                        A05 = new KJ(32, 15);
                    }

                    {
                        A0A(892, 11, 16);
                        try {
                            this.A00 = XmlPullParserFactory.newInstance();
                            this.A00.setNamespaceAware(true);
                        } catch (XmlPullParserException e) {
                            throw new RuntimeException(A0A(6, 45, 87), e);
                        }
                    }

                    public static float A00(String str2) {
                        Matcher matcher = A04.matcher(str2);
                        boolean zMatches = matcher.matches();
                        String strA0A = A0A(892, 11, 16);
                        if (!zMatches) {
                            AbstractC02134g.A07(strA0A, A0A(683, 25, 72) + str2);
                            return Float.MAX_VALUE;
                        }
                        try {
                            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) AbstractC02053y.A01(matcher.group(1)))));
                        } catch (NumberFormatException e) {
                            AbstractC02134g.A0A(strA0A, A0A(143, 23, 73) + str2, e);
                            return Float.MAX_VALUE;
                        }
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public static Layout.Alignment A02(String str2) {
                        byte b2;
                        String strA01 = AbstractC1616k7.A01(str2);
                        switch (strA01.hashCode()) {
                            case -1364013995:
                                b2 = !strA01.equals(A0A(1299, 6, 18)) ? (byte) -1 : (byte) 4;
                                break;
                            case 100571:
                                if (strA01.equals(A0A(1352, 3, 17))) {
                                    b2 = 3;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (strA01.equals(A0A(1537, 4, 122))) {
                                    b2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (strA01.equals(A0A(1619, 5, 26))) {
                                    b2 = 2;
                                    break;
                                }
                                break;
                            case 109757538:
                                if (strA01.equals(A0A(1650, 5, 60))) {
                                    b2 = 1;
                                    break;
                                }
                                break;
                        }
                        switch (b2) {
                            case 0:
                            case 1:
                                return Layout.Alignment.ALIGN_NORMAL;
                            case 2:
                            case 3:
                                Layout.Alignment alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                if (A02[3].charAt(8) != 'a') {
                                    throw new RuntimeException();
                                }
                                A02[0] = "QuoyGMZU77HTmr";
                                return alignment;
                            case 4:
                                return Layout.Alignment.ALIGN_CENTER;
                            default:
                                return null;
                        }
                    }

                    public static KK A04(XmlPullParser xmlPullParser) throws C1713lj {
                        int tickRate = 30;
                        String strA0A = A0A(1399, 9, 121);
                        String strA0A2 = A0A(1472, 35, 92);
                        String attributeValue = xmlPullParser.getAttributeValue(strA0A2, strA0A);
                        if (attributeValue != null) {
                            tickRate = Integer.parseInt(attributeValue);
                        }
                        float numerator = 1.0f;
                        String attributeValue2 = xmlPullParser.getAttributeValue(strA0A2, A0A(1408, 19, 26));
                        if (attributeValue2 != null) {
                            String[] strArrA1O = C5C.A1O(attributeValue2, A0A(0, 1, 42));
                            if (strArrA1O.length == 2) {
                                int frameRate = Integer.parseInt(strArrA1O[0]);
                                float numerator2 = frameRate;
                                int frameRate2 = Integer.parseInt(strArrA1O[1]);
                                numerator = numerator2 / frameRate2;
                            } else {
                                String frameRateString = A0A(1427, 40, 21);
                                throw new C1713lj(frameRateString);
                            }
                        }
                        int subFrameRate = A06.A01;
                        String attributeValue3 = xmlPullParser.getAttributeValue(strA0A2, A0A(1667, 12, 102));
                        if (attributeValue3 != null) {
                            subFrameRate = Integer.parseInt(attributeValue3);
                        }
                        int i = A06.A02;
                        String strA0A3 = A0A(1753, 8, 107);
                        String[] strArr = A02;
                        String frameRateString2 = strArr[1];
                        String str2 = strArr[5];
                        int length = frameRateString2.length();
                        int frameRate3 = str2.length();
                        if (length == frameRate3) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A02;
                        strArr2[6] = "ZUswaBax6tLaE1IC4JCUj1Icv8MP2XMH";
                        strArr2[2] = "PhpwRqbX9uhXuGLmIXMh7Q7Ymyg4xhXC";
                        String attributeValue4 = xmlPullParser.getAttributeValue(strA0A2, strA0A3);
                        if (attributeValue4 != null) {
                            i = Integer.parseInt(attributeValue4);
                        }
                        return new KK(tickRate * numerator, subFrameRate, i);
                    }

                    public static KL A05(XmlPullParser xmlPullParser) {
                        String strA00 = C5I.A00(xmlPullParser, A0A(1355, 6, 45));
                        if (strA00 == null) {
                            return null;
                        }
                        Matcher matcher = A0B.matcher(strA00);
                        boolean zMatches = matcher.matches();
                        String strA0A = A0A(892, 11, 16);
                        if (!zMatches) {
                            StringBuilder sb = new StringBuilder();
                            String ttsExtent = A0A(233, 31, 122);
                            AbstractC02134g.A07(strA0A, sb.append(ttsExtent).append(strA00).toString());
                            return null;
                        }
                        try {
                            String ttsExtent2 = matcher.group(1);
                            int i = Integer.parseInt((String) AbstractC02053y.A01(ttsExtent2));
                            String ttsExtent3 = matcher.group(2);
                            return new KL(i, Integer.parseInt((String) AbstractC02053y.A01(ttsExtent3)));
                        } catch (NumberFormatException unused) {
                            StringBuilder sb2 = new StringBuilder();
                            String ttsExtent4 = A0A(ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER, 31, 99);
                            AbstractC02134g.A07(strA0A, sb2.append(ttsExtent4).append(strA00).toString());
                            return null;
                        }
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:41:0x01b7  */
                    /* JADX WARN: Removed duplicated region for block: B:47:0x01e1  */
                    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
                    /* JADX WARN: Type inference failed for: r3v2 */
                    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, java.lang.String] */
                    /* JADX WARN: Type inference failed for: r5v2 */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public static KN A07(XmlPullParser xmlPullParser, KJ kj, KL kl) {
                        float f;
                        float line;
                        float f2;
                        float f3;
                        byte b2;
                        String strA00 = C5I.A00(xmlPullParser, A0A(1507, 2, 90));
                        if (strA00 == null) {
                            return null;
                        }
                        String strA002 = C5I.A00(xmlPullParser, A0A(1604, 6, 65));
                        String strA0A = A0A(892, 11, 16);
                        if (strA002 != 0) {
                            Matcher matcher = A03.matcher(strA002);
                            Matcher matcher2 = A0B.matcher(strA002);
                            boolean zMatches = matcher.matches();
                            String strA0A2 = A0A(303, 39, 29);
                            String strA0A3 = A0A(342, 41, 55);
                            byte b3 = 2;
                            try {
                                if (zMatches) {
                                    try {
                                        f = Float.parseFloat((String) AbstractC02053y.A01(matcher.group(1))) / 100.0f;
                                        line = Float.parseFloat((String) AbstractC02053y.A01(matcher.group(2))) / 100.0f;
                                    } catch (NumberFormatException unused) {
                                        AbstractC02134g.A07(strA0A, strA0A2 + ((String) strA002));
                                        return null;
                                    }
                                } else {
                                    boolean zMatches2 = matcher2.matches();
                                    String[] strArr = A02;
                                    if (strArr[6].charAt(3) != strArr[2].charAt(3)) {
                                        throw new RuntimeException();
                                    }
                                    String[] strArr2 = A02;
                                    strArr2[4] = "JOMz8RfhZxjyjCW014gv2m0MH";
                                    strArr2[7] = "qk3Phvnbbo37fKBWKDjhM47dE";
                                    if (zMatches2) {
                                        if (kl == null) {
                                            AbstractC02134g.A07(strA0A, strA0A3 + ((String) strA002));
                                            return null;
                                        }
                                        int i = Integer.parseInt((String) AbstractC02053y.A01(matcher2.group(1)));
                                        int i2 = Integer.parseInt((String) AbstractC02053y.A01(matcher2.group(2)));
                                        int width = kl.A01;
                                        f = i / width;
                                        int width2 = kl.A00;
                                        line = i2 / width2;
                                    } else {
                                        AbstractC02134g.A07(strA0A, A0A(424, 41, 61) + ((String) strA002));
                                        return null;
                                    }
                                }
                                String strA003 = C5I.A00(xmlPullParser, A0A(1355, 6, 45));
                                if (strA003 != null) {
                                    Matcher matcher3 = A03.matcher(strA003);
                                    Matcher matcher4 = A0B.matcher(strA003);
                                    boolean zMatches3 = matcher3.matches();
                                    String strA0A4 = A0A(264, 39, 71);
                                    try {
                                        if (zMatches3) {
                                            try {
                                                f2 = Float.parseFloat((String) AbstractC02053y.A01(matcher3.group(1))) / 100.0f;
                                                f3 = Float.parseFloat((String) AbstractC02053y.A01(matcher3.group(2))) / 100.0f;
                                            } catch (NumberFormatException unused2) {
                                                AbstractC02134g.A07(strA0A, strA0A4 + ((String) strA002));
                                                return null;
                                            }
                                        } else if (matcher4.matches()) {
                                            if (kl == null) {
                                                AbstractC02134g.A07(strA0A, strA0A3 + ((String) strA002));
                                                return null;
                                            }
                                            int i3 = Integer.parseInt((String) AbstractC02053y.A01(matcher4.group(1)));
                                            int i4 = Integer.parseInt((String) AbstractC02053y.A01(matcher4.group(2)));
                                            int extentWidth = kl.A01;
                                            f2 = i3 / extentWidth;
                                            int extentWidth2 = kl.A00;
                                            f3 = i4 / extentWidth2;
                                        } else {
                                            AbstractC02134g.A07(strA0A, A0A(383, 41, 110) + ((String) strA002));
                                            return null;
                                        }
                                        int i5 = 0;
                                        strA002 = 1332;
                                        strA0A = 12;
                                        String strA004 = C5I.A00(xmlPullParser, A0A(1332, 12, 111));
                                        if (strA004 != null) {
                                            String strA01 = AbstractC1616k7.A01(strA004);
                                            switch (strA01.hashCode()) {
                                                case -1364013995:
                                                    b2 = !strA01.equals(A0A(1299, 6, 18)) ? (byte) -1 : (byte) 0;
                                                    break;
                                                case 92734940:
                                                    if (strA01.equals(A0A(1209, 5, 37))) {
                                                        b2 = 1;
                                                        break;
                                                    }
                                                    break;
                                            }
                                            switch (b2) {
                                                case 0:
                                                    i5 = 1;
                                                    float width3 = f3 / 2.0f;
                                                    line += width3;
                                                    break;
                                                case 1:
                                                    i5 = 2;
                                                    line += f3;
                                                    break;
                                            }
                                        }
                                        float width4 = kj.A01;
                                        float f4 = 1.0f / width4;
                                        int i6 = Integer.MIN_VALUE;
                                        String strA005 = C5I.A00(xmlPullParser, A0A(1772, 11, 16));
                                        if (strA005 != null) {
                                            String strA012 = AbstractC1616k7.A01(strA005);
                                            switch (strA012.hashCode()) {
                                                case 3694:
                                                    b3 = !strA012.equals(A0A(1680, 2, 54)) ? (byte) -1 : (byte) 0;
                                                    break;
                                                case 3553396:
                                                    if (strA012.equals(A0A(1682, 4, 80))) {
                                                        b3 = 1;
                                                        break;
                                                    }
                                                    break;
                                                case 3553576:
                                                    if (!strA012.equals(A0A(1686, 4, 24))) {
                                                    }
                                                    break;
                                            }
                                            switch (b3) {
                                                case 0:
                                                case 1:
                                                    i6 = 2;
                                                    break;
                                                case 2:
                                                    i6 = 1;
                                                    break;
                                            }
                                        }
                                        float regionTextHeight = f2;
                                        float position = f;
                                        return new KN(strA00, position, line, 0, i5, regionTextHeight, f3, 1, f4, i6);
                                    } catch (NumberFormatException unused3) {
                                        AbstractC02134g.A07(strA0A, strA0A4 + strA002);
                                        return null;
                                    }
                                }
                                AbstractC02134g.A07(strA0A, A0A(465, 33, 50));
                                return null;
                            } catch (NumberFormatException unused4) {
                                AbstractC02134g.A07(strA0A, strA0A2 + ((String) strA002));
                                return null;
                            }
                        }
                        AbstractC02134g.A07(strA0A, A0A(498, 33, 13));
                        return null;
                    }

                    public static KT A08(KT kt) {
                        return kt == null ? new KT() : kt;
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Removed duplicated region for block: B:106:0x02d4  */
                    /* JADX WARN: Removed duplicated region for block: B:107:0x02e2  */
                    /* JADX WARN: Removed duplicated region for block: B:108:0x02f0  */
                    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:112:0x032c  */
                    /* JADX WARN: Removed duplicated region for block: B:113:0x0343  */
                    /* JADX WARN: Removed duplicated region for block: B:114:0x034d  */
                    /* JADX WARN: Removed duplicated region for block: B:117:0x0379  */
                    /* JADX WARN: Removed duplicated region for block: B:120:0x03a6  */
                    /* JADX WARN: Removed duplicated region for block: B:165:0x0508  */
                    /* JADX WARN: Removed duplicated region for block: B:176:0x0557  */
                    /* JADX WARN: Removed duplicated region for block: B:193:0x03c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:205:0x002f A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:236:0x002f A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:237:0x002f A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
                    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
                    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
                    /* JADX WARN: Removed duplicated region for block: B:31:0x00d6  */
                    /* JADX WARN: Removed duplicated region for block: B:33:0x00e1  */
                    /* JADX WARN: Removed duplicated region for block: B:55:0x016d  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x0177  */
                    /* JADX WARN: Removed duplicated region for block: B:57:0x0181  */
                    /* JADX WARN: Removed duplicated region for block: B:58:0x018b  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x0195  */
                    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
                    /* JADX WARN: Removed duplicated region for block: B:71:0x01db  */
                    /* JADX WARN: Removed duplicated region for block: B:73:0x01e6  */
                    /* JADX WARN: Removed duplicated region for block: B:83:0x0226  */
                    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
                        java.lang.UnsupportedOperationException
                        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
                        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
                        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
                        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
                        */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public static com.facebook.ads.redexgen.core.KT A09(org.xmlpull.v1.XmlPullParser r15, com.facebook.ads.redexgen.core.KT r16) {
                        /*
                            Method dump skipped, instruction units count: 1666
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1P.A09(org.xmlpull.v1.XmlPullParser, com.facebook.ads.redexgen.X.KT):com.facebook.ads.redexgen.X.KT");
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Removed duplicated region for block: B:9:0x0038  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public static void A0D(String str2, KT kt) throws C1713lj {
                        Matcher matcher;
                        byte b2;
                        String[] strArrA1O = C5C.A1O(str2, A0A(962, 3, 60));
                        if (strArrA1O.length == 1) {
                            matcher = A09.matcher(str2);
                        } else if (strArrA1O.length == 2) {
                            matcher = A09.matcher(strArrA1O[1]);
                            AbstractC02134g.A07(A0A(892, 11, 16), A0A(735, 110, 105));
                        } else {
                            throw new C1713lj(A0A(615, 40, 76) + strArrA1O.length + A0A(5, 1, 61));
                        }
                        boolean zMatches = matcher.matches();
                        String strA0A = A0A(3, 2, 77);
                        if (zMatches) {
                            String str3 = (String) AbstractC02053y.A01(matcher.group(3));
                            switch (str3.hashCode()) {
                                case 37:
                                    b2 = !str3.equals(A0A(2, 1, 112)) ? (byte) -1 : (byte) 2;
                                    break;
                                case 3240:
                                    if (str3.equals(A0A(1350, 2, 76))) {
                                        b2 = 1;
                                        break;
                                    }
                                    break;
                                case 3592:
                                    if (str3.equals(A0A(1611, 2, 111))) {
                                        b2 = 0;
                                        break;
                                    }
                                    break;
                            }
                            switch (b2) {
                                case 0:
                                    kt.A0I(1);
                                    break;
                                case 1:
                                    kt.A0I(2);
                                    break;
                                case 2:
                                    kt.A0I(3);
                                    break;
                                default:
                                    throw new C1713lj(A0A(655, 28, 54) + str3 + strA0A);
                            }
                            kt.A0E(Float.parseFloat((String) AbstractC02053y.A01(matcher.group(1))));
                            return;
                        }
                        throw new C1713lj(A0A(581, 34, 24) + str2 + strA0A);
                    }

                    public static void A0E(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
                        String encodedBitmapData;
                        do {
                            xmlPullParser.next();
                            if (C5I.A04(xmlPullParser, A0A(1509, 5, 41)) && (encodedBitmapData = C5I.A00(xmlPullParser, A0A(1507, 2, 90))) != null) {
                                String id = xmlPullParser.nextText();
                                map.put(encodedBitmapData, id);
                            }
                        } while (!C5I.A03(xmlPullParser, A0A(1553, 8, 69)));
                    }

                    public static boolean A0F(String str2) {
                        if (!str2.equals(A0A(1761, 2, 56)) && !str2.equals(A0A(1468, 4, 96)) && !str2.equals(A0A(1275, 4, 43)) && !str2.equals(A0A(1344, 3, 104))) {
                            if (A02[3].charAt(8) == 'a') {
                                String[] strArr = A02;
                                strArr[6] = "5SOwrViEjml2jzAC0QTdKKqpMqKJiIIU";
                                strArr[2] = "utbwyOpqs8b3qaaxxsItXWquxXfcomKh";
                                if (!str2.equals(A0A(1610, 1, 0)) && !str2.equals(A0A(1646, 4, 62)) && !str2.equals(A0A(1283, 2, 97)) && !str2.equals(A0A(1655, 5, 93)) && !str2.equals(A0A(1660, 7, 99)) && !str2.equals(A0A(1531, 6, 85)) && !str2.equals(A0A(1613, 6, 33))) {
                                    if (A02[0].length() != 7) {
                                        String[] strArr2 = A02;
                                        strArr2[4] = "XYEsrL24jboJLM6xnETRDfm0d";
                                        strArr2[7] = "LekapK6bz2qvUkLFlJCVYN0VS";
                                        if (!str2.equals(A0A(1553, 8, 69)) && !str2.equals(A0A(1509, 5, 41)) && !str2.equals(A0A(1319, 4, 11)) && !str2.equals(A0A(1514, 11, 3))) {
                                            return false;
                                        }
                                    }
                                }
                            }
                            throw new RuntimeException();
                        }
                        return true;
                    }

                    public static String[] A0G(String str2) {
                        String strTrim = str2.trim();
                        return strTrim.isEmpty() ? new String[0] : C5C.A1O(strTrim, A0A(962, 3, 60));
                    }
                };
            case 4:
                return new C8T() { // from class: com.facebook.ads.redexgen.X.1Q
                    public static byte[] A02;
                    public static String[] A03 = {"V1ZZWdHDdvp1vpeLHdy", "beDgvqL", "qPeUfXz8O47jIG0mRxxGLFbgYUjiO6tn", "0K37", "zACOzYjEJA3uY03LtXi99GuZvxjyA3vu", "", "yqoUvvveMQQADX2xw", "YF66NynmqVwoWtjOGJ4L1x6BuFt5Rq6F"};
                    public static final Pattern A04;
                    public static final Pattern A05;
                    public final StringBuilder A00;
                    public final ArrayList<String> A01;

                    public static String A03(int i, int i2, int i3) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 94);
                        }
                        return new String(bArrCopyOfRange);
                    }

                    public static void A06() {
                        A02 = new byte[]{76, 18, 2, 78, 108, 84, 86, 79, 79, 86, 81, 88, 31, 86, 81, 73, 94, 83, 86, 91, 31, 86, 81, 91, 90, 71, 5, 31, 75, 115, 113, 104, 104, 113, 118, 127, 56, 113, 118, 110, 121, 116, 113, 124, 56, 108, 113, 117, 113, 118, 127, 34, 56, 123, 93, 74, 90, 65, 88, 108, 77, 75, 71, 76, 77, 90, 80, 107, 96, 125, 117, 96, 102, 113, 96, 97, 37, 96, 107, 97, 60, 19, 74, 72, 72, 95, 90, 72, 60, 4, 75, 73, 90, 73, 95, 72, 60, 4, 75, 73, 90, 72, 60, 4, 75, 73, 72, 95, 90, 76, 72, 60, 4, 75, 73, 73, 95, 73, 60, 19, 74, 77, 77, 94, 60, 19, 74, 72, 72, 95, 90, 72, 60, 4, 75, 73, 90, 73, 95, 72, 60, 4, 75, 73, 90, 72, 60, 4, 75, 73, 72, 95, 90, 76, 72, 60, 4, 75, 73, 73, 95, 73, 60, 19, 74, 9, 46, 9, 9, 123, 127, 106, 9, 40, 26, 61, 26, 26, 39, 40, 29, 119, 107, 127, 27, 26, 59, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 44, 17, 30, 65, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 19, 52, 9, 6, 90, 21, 31, 56, 5, 10, 87, 25, 74, 109, 80, 95, 5, 76, 125, 90, 103, 104, 51, 123, 117, 82, 111, 96, 56, 115, 38, 1, 60, 51, 106, 32, 127, 88, 101, 106, 60, 121, 59, 28, 33, 46, 121, 61};
                    }

                    static {
                        A06();
                        A05 = Pattern.compile(A03(80, 85, 62));
                        A04 = Pattern.compile(A03(165, 9, 11));
                    }

                    {
                        A03(53, 13, 118);
                        this.A00 = new StringBuilder();
                        this.A01 = new ArrayList<>();
                    }

                    public static float A00(int i) {
                        switch (i) {
                            case 0:
                                return 0.08f;
                            case 1:
                                return 0.5f;
                            case 2:
                                return 0.92f;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }

                    public static long A01(Matcher matcher, int i) {
                        long timestampMs;
                        String hours = matcher.group(i + 1);
                        if (hours != null) {
                            timestampMs = Long.parseLong(hours) * 60 * 60 * 1000;
                        } else {
                            timestampMs = 0;
                        }
                        long timestampMs2 = timestampMs + (Long.parseLong((String) AbstractC02053y.A01(matcher.group(i + 2))) * 60 * 1000) + (Long.parseLong((String) AbstractC02053y.A01(matcher.group(i + 3))) * 1000);
                        String hours2 = matcher.group(i + 4);
                        if (hours2 != null) {
                            long j = Long.parseLong(hours2);
                            if (A03[6].length() == 8) {
                                throw new RuntimeException();
                            }
                            A03[0] = "CtNVef4YfaKqE1U7uEo";
                            timestampMs2 += j;
                        }
                        return 1000 * timestampMs2;
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
                    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0  */
                    /* JADX WARN: Removed duplicated region for block: B:19:0x00a4  */
                    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x006e  */
                    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
                        java.lang.UnsupportedOperationException
                        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
                        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
                        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
                        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
                        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
                        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
                        */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    private com.facebook.ads.redexgen.core.C1931pT A02(android.text.Spanned r17, java.lang.String r18) {
                        /*
                            Method dump skipped, instruction units count: 504
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1Q.A02(android.text.Spanned, java.lang.String):com.facebook.ads.redexgen.X.pT");
                    }

                    private String A04(String str2, ArrayList<String> arrayList) {
                        String strTrim = str2.trim();
                        int i = 0;
                        StringBuilder sb = new StringBuilder(strTrim);
                        Matcher matcher = A04.matcher(strTrim);
                        while (matcher.find()) {
                            String strGroup = matcher.group();
                            arrayList.add(strGroup);
                            int tagLength = matcher.start() - i;
                            int start = strGroup.length();
                            sb.replace(tagLength, tagLength + start, A03(0, 0, 37));
                            i += start;
                        }
                        return sb.toString();
                    }

                    private Charset A05(C02284v c02284v) {
                        Charset charset = c02284v.A0Z();
                        return charset != null ? charset : AbstractC1618k9.A05;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:43:0x0174, code lost:
                    
                        return new com.facebook.ads.redexgen.core.C1707ld((com.facebook.ads.redexgen.core.C1931pT[]) r4.toArray(new com.facebook.ads.redexgen.core.C1931pT[0]), r3.A05());
                     */
                    @Override // com.facebook.ads.redexgen.core.C8T
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final InterfaceC0585Jj A0g(byte[] bArr, int i, boolean z) {
                        String strA03 = A03(53, 13, 118);
                        ArrayList arrayList = new ArrayList();
                        C02144h c02144h = new C02144h();
                        C02284v c02284v = new C02284v(bArr, i);
                        Charset charsetA05 = A05(c02284v);
                        while (true) {
                            String strA0Y = c02284v.A0Y(charsetA05);
                            if (strA0Y == null) {
                                break;
                            }
                            if (strA0Y.length() != 0) {
                                try {
                                    Integer.parseInt(strA0Y);
                                    String strA0Y2 = c02284v.A0Y(charsetA05);
                                    if (strA0Y2 != null) {
                                        Matcher matcher = A05.matcher(strA0Y2);
                                        if (matcher.matches()) {
                                            c02144h.A04(A01(matcher, 1));
                                            if (A03[6].length() == 8) {
                                                break;
                                            }
                                            A03[5] = "";
                                            c02144h.A04(A01(matcher, 6));
                                            this.A00.setLength(0);
                                            this.A01.clear();
                                            for (String strA0Y3 = c02284v.A0Y(charsetA05); !TextUtils.isEmpty(strA0Y3); strA0Y3 = c02284v.A0Y(charsetA05)) {
                                                if (this.A00.length() > 0) {
                                                    this.A00.append(A03(0, 4, 46));
                                                }
                                                this.A00.append(A04(strA0Y3, this.A01));
                                            }
                                            Spanned spannedFromHtml = Html.fromHtml(this.A00.toString());
                                            String alignmentTag = null;
                                            for (int i2 = 0; i2 < this.A01.size(); i2++) {
                                                String str2 = this.A01.get(i2);
                                                if (A03[5].length() != 0) {
                                                    if (str2.matches(A03(174, 13, 24))) {
                                                        alignmentTag = str2;
                                                        break;
                                                    }
                                                } else {
                                                    A03[5] = "";
                                                    if (str2.matches(A03(174, 13, 24))) {
                                                        alignmentTag = str2;
                                                        break;
                                                    }
                                                }
                                            }
                                            arrayList.add(A02(spannedFromHtml, alignmentTag));
                                            arrayList.add(C1931pT.A0J);
                                        } else {
                                            AbstractC02134g.A07(strA03, A03(28, 25, 70) + strA0Y2);
                                        }
                                    } else if (A03[0].length() == 19) {
                                        A03[6] = "HJ3yDRHWzcPXInAXvwJ005QsJz";
                                        AbstractC02134g.A07(strA03, A03(66, 14, 91));
                                    }
                                } catch (NumberFormatException unused) {
                                    AbstractC02134g.A07(strA03, A03(4, 24, 97) + strA0Y);
                                }
                            }
                        }
                        throw new RuntimeException();
                    }
                };
            case 5:
                final List<byte[]> list = c1981qI.A0X;
                return new C8T(list) { // from class: com.facebook.ads.redexgen.X.1O
                    public static byte[] A07;
                    public static String[] A08 = {"1x7tMScy3OwIpxpoM6szN", "Vc9HgGpBlB6xOFpUGzWjKY6X9B2Kx", "Pa2y8LS5d14E5c2iioTa3o6alel444yu", "nvl8EzHImhNd4skDgpAF61hzJTcSqLGr", "i0VKuTBNrkqino8Xl71fJI1fPr2JZBLb", "b0kCsBlNmzlDPYQHWIClkO446cJaLVwv", "T6LNoF", "e0xJgOhUsx7"};
                    public final float A00;
                    public final int A01;
                    public final int A02;
                    public final int A03;
                    public final C02284v A04;
                    public final String A05;
                    public final boolean A06;

                    public static String A00(int i, int i2, int i3) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
                        int i4 = 0;
                        while (true) {
                            int length = bArrCopyOfRange.length;
                            String[] strArr = A08;
                            if (strArr[5].charAt(1) != strArr[4].charAt(1)) {
                                throw new RuntimeException();
                            }
                            A08[7] = "yGrIv6QCmXhG";
                            if (i4 >= length) {
                                return new String(bArrCopyOfRange);
                            }
                            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 85);
                            i4++;
                        }
                    }

                    public static void A02() {
                        A07 = new byte[]{-36, -45, -15, -16, -45, 24, 33, 23, -45, -37, -21, -30, 54, 49, -30, 37, 55, 39, 22, 39, 58, 54, -16, 46, 39, 48, 41, 54, 42, -22, -21, -30, -22, -51, -46, 19, 49, 56, 57, 60, 51, 56, 49, -22, 61, 62, 67, 54, -22, 65, 51, 62, 50, -22, 61, 62, 43, 60, 62, -22, -14, -48, -30, -17, -26, -29, 20, 50, 53, 46, 35, 33, 52, 41, 46, 39, -32, 51, 52, 57, 44, -32, 37, 46, 36, -32, -24, 25, 61, -8, 44, 9, 42, 40, 52, 41, 42, 55, -48, -23, -32, -13, -21, -32, -34, -17, -32, -33, -101, -18, -16, -35, -17, -28, -17, -25, -32, -101, -31, -22, -19, -24, -36, -17, -87, 15, -3, 10, 15, -55, 15, 1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 5, 2, -31, -45, -32, -41, -44};
                    }

                    static {
                        A02();
                    }

                    {
                        super(A00(87, 11, 112));
                        this.A04 = new C02284v();
                        int size = list.size();
                        String strA00 = A00(125, 10, 71);
                        if (size == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
                            byte[] bArr = list.get(0);
                            this.A03 = bArr[24];
                            this.A02 = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
                            this.A05 = A00(61, 5, 40).equals(C5C.A0r(bArr, 43, bArr.length - 43)) ? A00(135, 5, 25) : strA00;
                            this.A01 = bArr[25] * 20;
                            this.A06 = (bArr[0] & 32) != 0;
                            if (this.A06) {
                                int requestedVerticalPlacement = ((bArr[10] & 255) << 8) | (bArr[11] & 255);
                                this.A00 = C5C.A00(requestedVerticalPlacement / this.A01, 0.0f, 0.95f);
                                return;
                            } else {
                                this.A00 = 0.85f;
                                return;
                            }
                        }
                        this.A03 = 0;
                        this.A02 = -1;
                        this.A05 = strA00;
                        this.A06 = false;
                        this.A00 = 0.85f;
                        this.A01 = -1;
                    }

                    public static String A01(C02284v c02284v) throws C1713lj {
                        A07(c02284v.A07() >= 2);
                        int bomSize = c02284v.A0M();
                        if (bomSize == 0) {
                            return A00(0, 0, 4);
                        }
                        int iA09 = c02284v.A09();
                        Charset charsetA0Z = c02284v.A0Z();
                        int textLength = c02284v.A09();
                        int bomSize2 = bomSize - (textLength - iA09);
                        if (charsetA0Z == null) {
                            charsetA0Z = AbstractC1618k9.A05;
                        }
                        return c02284v.A0X(bomSize2, charsetA0Z);
                    }

                    public static void A03(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
                        if (i != i2) {
                            int colorArgb = i5 | 33;
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(((i & PHIpAddressSearchManager.END_IP_SCAN) << 24) | (i >>> 8)), i3, i4, colorArgb);
                        }
                    }

                    public static void A04(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
                        if (i != i2) {
                            int i6 = i5 | 33;
                            int i7 = i & 1;
                            String[] strArr = A08;
                            String str2 = strArr[5];
                            String str3 = strArr[4];
                            int iCharAt = str2.charAt(1);
                            int flags = str3.charAt(1);
                            if (iCharAt != flags) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A08;
                            strArr2[0] = "CK5gR0nAI76s8EUE0bHGc";
                            strArr2[6] = "a3HU5o";
                            boolean z = i7 != 0;
                            int flags2 = i & 2;
                            boolean z2 = flags2 != 0;
                            if (z) {
                                if (z2) {
                                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                                } else {
                                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                                }
                            } else if (z2) {
                                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
                            }
                            int flags3 = i & 4;
                            boolean z3 = flags3 != 0;
                            if (z3) {
                                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
                            }
                            if (!z3 && !z && !z2) {
                                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
                            }
                        }
                    }

                    public static void A05(SpannableStringBuilder spannableStringBuilder, String str2, int i, int i2) {
                        if (str2 != A00(125, 10, 71)) {
                            spannableStringBuilder.setSpan(new TypefaceSpan(str2), i, i2, 16711713);
                        }
                    }

                    private void A06(C02284v c02284v, SpannableStringBuilder spannableStringBuilder) throws C1713lj {
                        A07(c02284v.A07() >= 12);
                        int fontFace = c02284v.A0M();
                        int iA0M = c02284v.A0M();
                        c02284v.A0g(2);
                        int iA0I = c02284v.A0I();
                        c02284v.A0g(1);
                        int iA0C = c02284v.A0C();
                        int length = spannableStringBuilder.length();
                        String strA00 = A00(33, 2, 79);
                        String strA002 = A00(87, 11, 112);
                        if (iA0M > length) {
                            StringBuilder sbAppend = new StringBuilder().append(A00(66, 21, 107)).append(iA0M).append(A00(10, 23, 109));
                            int start = spannableStringBuilder.length();
                            AbstractC02134g.A07(strA002, sbAppend.append(start).append(strA00).toString());
                            iA0M = spannableStringBuilder.length();
                        }
                        if (fontFace < iA0M) {
                            A04(spannableStringBuilder, iA0I, this.A03, fontFace, iA0M, 0);
                            A03(spannableStringBuilder, iA0C, this.A02, fontFace, iA0M, 0);
                        } else {
                            AbstractC02134g.A07(strA002, A00(35, 26, 117) + fontFace + A00(0, 10, 94) + iA0M + strA00);
                        }
                    }

                    public static void A07(boolean z) throws C1713lj {
                        if (z) {
                        } else {
                            throw new C1713lj(A00(98, 27, 38));
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:24:0x00b7  */
                    /* JADX WARN: Removed duplicated region for block: B:33:0x0102  */
                    @Override // com.facebook.ads.redexgen.core.C8T
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final InterfaceC0585Jj A0g(byte[] bArr, int i, boolean z) throws C1713lj {
                        this.A04.A0j(bArr, i);
                        String strA01 = A01(this.A04);
                        if (strA01.isEmpty()) {
                            return C1705lb.A02;
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strA01);
                        A04(spannableStringBuilder, this.A03, 0, 0, spannableStringBuilder.length(), 16711680);
                        A03(spannableStringBuilder, this.A02, -1, 0, spannableStringBuilder.length(), 16711680);
                        A05(spannableStringBuilder, this.A05, 0, spannableStringBuilder.length());
                        float fA00 = this.A00;
                        while (this.A04.A07() >= 8) {
                            int atomSize = this.A04.A09();
                            int iA0C = this.A04.A0C();
                            int iA0C2 = this.A04.A0C();
                            if (iA0C2 == 1937013100) {
                                int iA07 = this.A04.A07();
                                String[] strArr = A08;
                                String str2 = strArr[0];
                                String cueTextString = strArr[6];
                                if (str2.length() == cueTextString.length()) {
                                    throw new RuntimeException();
                                }
                                String[] strArr2 = A08;
                                strArr2[0] = "Z2UJzHF8zneH9ag5NgWte";
                                strArr2[6] = "yNPyx5";
                                A07(iA07 >= 2);
                                int position = this.A04.A0M();
                                for (int i2 = 0; i2 < position; i2++) {
                                    A06(this.A04, spannableStringBuilder);
                                }
                            } else if (iA0C2 == 1952608120) {
                                boolean z2 = this.A06;
                                String cueTextString2 = A08[1];
                                if (cueTextString2.length() == 29) {
                                    A08[1] = "paw5WSKbqYtpnsyQNjpQb8Noh3AWg";
                                    if (z2) {
                                    }
                                } else if (z2) {
                                    C02284v c02284v = this.A04;
                                    String[] strArr3 = A08;
                                    String str3 = strArr3[2];
                                    String cueTextString3 = strArr3[3];
                                    if (str3.length() != cueTextString3.length()) {
                                        if (c02284v.A07() < 2) {
                                            z = false;
                                        }
                                        A07(z);
                                        fA00 = C5C.A00(this.A04.A0M() / this.A01, 0.0f, 0.95f);
                                    } else {
                                        String[] strArr4 = A08;
                                        strArr4[0] = "wTXVya3nfhs0Hhsed0pql";
                                        strArr4[6] = "bT1NwA";
                                        if (c02284v.A07() < 2) {
                                        }
                                        A07(z);
                                        fA00 = C5C.A00(this.A04.A0M() / this.A01, 0.0f, 0.95f);
                                    }
                                }
                            }
                            this.A04.A0f(atomSize + iA0C);
                        }
                        return new C1705lb(new C01953o().A0G(spannableStringBuilder).A07(fA00, 0).A09(0).A0H());
                    }
                };
            case 6:
            case 7:
                return new C1X(c1981qI.A0W, c1981qI.A03, -9223372036854775807L);
            case 8:
                final int i = c1981qI.A03;
                final List list2 = null;
                return new C8M(i, list2) { // from class: com.facebook.ads.redexgen.X.1W
                    public static byte[] A0B;
                    public static String[] A0C = {"StgEnyZrIiHukKZI2mjNBpxMfWWHoY2N", "pPiD", "4nUZoZtFS8Fi7y", "soUNpDdTYgeZzoXYzwhXpymROnExsdJX", "jQfRXI2O9AZyEok5vhLK2LNFq5CUiSFO", "NRbI1hfkyM6vnftXJILRzJXuHgspnZLF", "iSpRtaxsShIsoCeM", "S"};
                    public int A00;
                    public C0591Jp A02;
                    public C0592Jq A03;
                    public List<C1931pT> A04;
                    public List<C1931pT> A05;
                    public final int A06;
                    public final boolean A09;
                    public final C0591Jp[] A0A;
                    public final C02284v A08 = new C02284v();
                    public final C02274u A07 = new C02274u();
                    public int A01 = -1;

                    public static String A00(int i2, int i3, int i4) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i3);
                        int i5 = 0;
                        while (true) {
                            int length = bArrCopyOfRange.length;
                            String[] strArr = A0C;
                            if (strArr[2].length() == strArr[7].length()) {
                                throw new RuntimeException();
                            }
                            A0C[1] = "zpnW";
                            if (i5 >= length) {
                                return new String(bArrCopyOfRange);
                            }
                            bArrCopyOfRange[i5] = (byte) ((bArrCopyOfRange[i5] - i4) - 124);
                            i5++;
                        }
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    private void A03() {
                        this.A02.A0C(this.A07.A04(4), this.A07.A04(2), this.A07.A04(2), this.A07.A0H(), this.A07.A0H(), this.A07.A04(3), this.A07.A04(3));
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    private void A04() {
                        int iA01 = C0591Jp.A01(this.A07.A04(2), this.A07.A04(2), this.A07.A04(2), this.A07.A04(2));
                        int iA012 = C0591Jp.A01(this.A07.A04(2), this.A07.A04(2), this.A07.A04(2), this.A07.A04(2));
                        this.A07.A09(2);
                        this.A02.A0B(iA01, iA012, C0591Jp.A00(this.A07.A04(2), this.A07.A04(2), this.A07.A04(2)));
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    private void A06() {
                        int iA01 = C0591Jp.A01(this.A07.A04(2), this.A07.A04(2), this.A07.A04(2), this.A07.A04(2));
                        int iA04 = this.A07.A04(2);
                        int iA00 = C0591Jp.A00(this.A07.A04(2), this.A07.A04(2), this.A07.A04(2));
                        if (this.A07.A0H()) {
                            iA04 |= 4;
                        }
                        boolean zA0H = this.A07.A0H();
                        int iA042 = this.A07.A04(2);
                        int iA043 = this.A07.A04(2);
                        int iA044 = this.A07.A04(2);
                        this.A07.A09(8);
                        this.A02.A0D(iA01, iA00, zA0H, iA04, iA042, iA043, iA044);
                    }

                    public static void A09() {
                        A0B = new byte[]{3, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 86, 72, 84, 88, 72, 81, 70, 72, 3, 81, 88, 80, 69, 72, 85, 3, 22, 89, 107, 104, 104, 91, 100, 106, 51, -5, -14, 73, 58, 55, 64, -14, 52, 62, 65, 53, 61, 37, 59, 76, 55, -14, 59, 69, -14, 2, 32, 50, 4, -8, 58, 77, 76, -8, 59, 77, 74, 74, 61, 70, 76, -8, 65, 70, 60, 61, 80, -8, 65, 75, -8, 8, 42, 38, -4, -11, -3, 9, 42, 40, 52, 41, 42, 55, 19, 69, 66, 66, 53, 62, 68, 60, 73, -16, 69, 62, 67, 69, 64, 64, 63, 66, 68, 53, 52, -16, 19, 31, 29, 29, 17, 30, 20, 47, 21, 40, 36, 1, -16, 19, 63, 61, 61, 49, 62, 52, 10, -16, -42, 8, 5, 5, -8, 1, 7, -1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -77, 8, 1, 6, 8, 3, 3, 2, 5, 7, -8, -9, -77, -42, -30, -32, -32, -44, -31, -41, -14, -29, -60, -55, -77, -42, 2, 0, 0, -12, 1, -9, -51, -77, -52, -4, -2, -53, -21, -40, -23, -21, -13, -19, -4, -88, -19, -10, -20, -19, -20, -88, -8, -6, -19, -11, -23, -4, -3, -6, -19, -12, 1, -61, -88, -5, -15, 2, -19, -88, -15, -5, -88, 22, 63, 52, 64, 70, 63, 69, 54, 67, 54, 53, -15, 21, 37, 39, 20, 20, 48, 33, 18, 20, 28, 22, 37, 48, 21, 18, 37, 18, -15, 51, 54, 55, 64, 67, 54, -15, 21, 37, 39, 20, 20, 48, 33, 18, 20, 28, 22, 37, 48, 36, 37, 18, 35, 37, 8, 45, 53, 32, 43, 40, 35, -33, 2, -17, -33, 34, 46, 44, 44, 32, 45, 35, -7, -33, 49, 86, 94, 73, 84, 81, 76, 8, 43, 25, 8, 75, 87, 85, 85, 73, 86, 76, 34, 8, -7, 30, 38, 17, 28, 25, 20, -48, -9, -30, -48, 19, 24, 17, 34, 17, 19, 36, 21, 34, -22, -48, -55, -18, -10, -31, -20, -23, -28, -96, -57, -77, -96, -29, -24, -31, -14, -31, -29, -12, -27, -14, -70, -96, -53, -16, -8, -29, -18, -21, -26, -94, -28, -29, -11, -25, -94, -27, -15, -17, -17, -29, -16, -26, -68, -94, -28, 9, 17, -4, 7, 4, -1, -69, 0, 19, 15, 0, 9, -1, 0, -1, -69, -2, 10, 8, 8, -4, 9, -1, -43, -69, -7, 30, 38, 17, 28, 25, 20, -48, 21, 40, 36, 21, 30, 20, 21, 20, -48, 35, 21, 34, 38, 25, 19, 21, -48, 30, 37, 29, 18, 21, 34, -22, -48, 42, 60, 72, 76, 60, 69, 58, 60, -9, 69, 76, 68, 57, 60, 73, -9, 59, 64, 74, 58, 70, 69, 75, 64, 69, 76, 64, 75, 80, 5, -9, 71, 73, 60, 77, 64, 70, 76, 74, 20, 66, 52, 65, 69, 56, 50, 52, 29, 68, 60, 49, 52, 65, -17, 56, 66, -17, 61, 62, 61, -4, 73, 52, 65, 62, -17, -9};
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    private void A0E(int i2) {
                        C0591Jp c0591Jp = this.A0A[i2];
                        this.A07.A09(2);
                        boolean zA0H = this.A07.A0H();
                        boolean zA0H2 = this.A07.A0H();
                        boolean zA0H3 = this.A07.A0H();
                        int iA04 = this.A07.A04(3);
                        boolean zA0H4 = this.A07.A0H();
                        int iA042 = this.A07.A04(7);
                        int iA043 = this.A07.A04(8);
                        int iA044 = this.A07.A04(4);
                        int iA045 = this.A07.A04(4);
                        this.A07.A09(2);
                        int iA046 = this.A07.A04(6);
                        this.A07.A09(2);
                        c0591Jp.A0F(zA0H, zA0H2, zA0H3, iA04, zA0H4, iA042, iA043, iA045, iA046, iA044, this.A07.A04(3), this.A07.A04(3));
                    }

                    static {
                        A09();
                    }

                    {
                        this.A06 = i == -1 ? 1 : i;
                        this.A09 = list2 != null && AnonymousClass46.A06(list2);
                        this.A0A = new C0591Jp[8];
                        for (int i2 = 0; i2 < 8; i2++) {
                            this.A0A[i2] = new C0591Jp();
                        }
                        this.A02 = this.A0A[0];
                    }

                    /* JADX WARN: Incorrect condition in loop: B:4:0x0014 */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    private List<C1931pT> A01() {
                        C0590Jo c0590JoA05;
                        ArrayList arrayList = new ArrayList();
                        int i2 = 0;
                        while (i == 111) {
                            A0C[6] = "prFtgZEgycD";
                            if (i2 < 8) {
                                if (!this.A0A[i2].A0H() && this.A0A[i2].A0I() && (c0590JoA05 = this.A0A[i2].A05()) != null) {
                                    arrayList.add(c0590JoA05);
                                }
                                i2++;
                            } else {
                                Collections.sort(arrayList, C0590Jo.A02);
                                ArrayList arrayList2 = new ArrayList(arrayList.size());
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    arrayList2.add(((C0590Jo) arrayList.get(i3)).A01);
                                }
                                return Collections.unmodifiableList(arrayList2);
                            }
                        }
                        throw new RuntimeException();
                    }

                    private void A02() {
                        if (this.A03 == null) {
                            return;
                        }
                        A07();
                        this.A03 = null;
                    }

                    private void A05() {
                        this.A07.A09(4);
                        int iA04 = this.A07.A04(4);
                        this.A07.A09(2);
                        int column = this.A07.A04(6);
                        this.A02.A0A(iA04, column);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:16:0x00fa, code lost:
                    
                        if (r13 == false) goto L99;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:17:0x00fc, code lost:
                    
                        r14.A04 = A01();
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:18:0x0102, code lost:
                    
                        return;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
                    
                        return;
                     */
                    @RequiresNonNull({"currentDtvCcPacket"})
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    private void A07() {
                        int iA03;
                        int i2 = this.A03.A00;
                        int i3 = (this.A03.A01 * 2) - 1;
                        String strA00 = A00(73, 13, 73);
                        if (i2 != i3) {
                            AbstractC02134g.A04(strA00, A00(173, 39, 12) + ((this.A03.A01 * 2) - 1) + A00(50, 23, 92) + this.A03.A00 + A00(0, 18, 103) + this.A03.A02 + A00(48, 2, 123));
                        }
                        boolean z = false;
                        this.A07.A0E(this.A03.A03, this.A03.A00);
                        loop0: while (true) {
                            if (this.A07.A01() <= 0) {
                                break;
                            }
                            int iA04 = this.A07.A04(3);
                            int command = this.A07.A04(5);
                            if (iA04 == 7) {
                                this.A07.A09(2);
                                iA04 = this.A07.A04(6);
                                if (iA04 < 7) {
                                    AbstractC02134g.A07(strA00, A00(399, 33, 52) + iA04);
                                }
                            }
                            if (command == 0) {
                                if (iA04 != 0) {
                                    AbstractC02134g.A07(strA00, A00(472, 27, 83) + iA04 + A00(27, 21, 86));
                                }
                            } else {
                                int i4 = this.A06;
                                int serviceNumber = A0C[5].charAt(13);
                                if (serviceNumber != 102) {
                                    break;
                                }
                                String[] strArr = A0C;
                                strArr[2] = "MRR8KxsQlbp3Ig";
                                strArr[7] = "Q";
                                if (iA04 != i4) {
                                    C02274u c02274u = this.A07;
                                    int serviceNumber2 = A0C[0].charAt(19);
                                    if (serviceNumber2 != 78) {
                                        break;
                                    }
                                    A0C[0] = "hkixqgWbeZd8Awyy7Q6N0KpGxYgVXqbw";
                                    c02274u.A0A(command);
                                } else {
                                    C02274u c02274u2 = this.A07;
                                    int serviceNumber3 = A0C[6].length();
                                    if (serviceNumber3 != 3) {
                                        A0C[6] = "3dsCRaEhFxrSmzAmtZA59dB";
                                        iA03 = c02274u2.A03() + (command * 8);
                                    } else {
                                        A0C[1] = "SHH7";
                                        iA03 = c02274u2.A03() + (command * 6);
                                    }
                                    while (this.A07.A03() < iA03) {
                                        int iA042 = this.A07.A04(8);
                                        if (iA042 != 16) {
                                            if (iA042 <= 31) {
                                                A0A(iA042);
                                            } else if (iA042 <= 127) {
                                                A0F(iA042);
                                                z = true;
                                            } else if (iA042 <= 159) {
                                                A0B(iA042);
                                                z = true;
                                            } else if (iA042 <= 255) {
                                                A0G(iA042);
                                                z = true;
                                            } else {
                                                AbstractC02134g.A07(strA00, A00(351, 22, 6) + iA042);
                                            }
                                        } else {
                                            C02274u c02274u3 = this.A07;
                                            int serviceNumber4 = A0C[5].charAt(13);
                                            if (serviceNumber4 != 102) {
                                                break loop0;
                                            }
                                            A0C[6] = "9u6P";
                                            int iA043 = c02274u3.A04(8);
                                            if (iA043 <= 31) {
                                                A0C(iA043);
                                            } else if (iA043 <= 127) {
                                                A0H(iA043);
                                                z = true;
                                            } else if (iA043 <= 159) {
                                                A0D(iA043);
                                            } else if (iA043 <= 255) {
                                                A0I(iA043);
                                                z = true;
                                            } else {
                                                AbstractC02134g.A07(strA00, A00(373, 26, 31) + iA043);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        throw new RuntimeException();
                    }

                    private void A08() {
                        for (int i2 = 0; i2 < 8; i2++) {
                            this.A0A[i2].A08();
                        }
                    }

                    private void A0A(int i2) {
                        switch (i2) {
                            case 0:
                            case 14:
                                return;
                            case 3:
                                this.A04 = A01();
                                return;
                            case 8:
                                this.A02.A06();
                                return;
                            case 12:
                                A08();
                                return;
                            case 13:
                                C0591Jp c0591Jp = this.A02;
                                if (A0C[1].length() == 4) {
                                    A0C[4] = "FGYJlLquXUr7pMFj0Rb0j1D1hbYlwPR1";
                                    c0591Jp.A09('\n');
                                    return;
                                }
                                break;
                            default:
                                String strA00 = A00(73, 13, 73);
                                if (i2 >= 17 && i2 <= 23) {
                                    AbstractC02134g.A07(strA00, A00(86, 44, 84) + i2);
                                    this.A07.A09(8);
                                    return;
                                } else if (A0C[1].length() == 4) {
                                    A0C[0] = "tIivKyJ4yVQrhz6naHsNX4hATBwVD1SZ";
                                    if (i2 >= 24 && i2 <= 31) {
                                        AbstractC02134g.A07(strA00, A00(130, 43, 23) + i2);
                                        this.A07.A09(16);
                                        return;
                                    } else {
                                        AbstractC02134g.A07(strA00, A00(267, 20, 67) + i2);
                                        return;
                                    }
                                }
                                break;
                        }
                        throw new RuntimeException();
                    }

                    /* JADX WARN: Removed duplicated region for block: B:64:0x014f  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    private void A0B(int i2) {
                        switch (i2) {
                            case 128:
                            case 129:
                            case 130:
                            case 131:
                            case 132:
                            case 133:
                            case 134:
                            case 135:
                                int i3 = i2 - 128;
                                int window = this.A00;
                                if (window == i3) {
                                    return;
                                }
                                this.A00 = i3;
                                this.A02 = this.A0A[i3];
                                return;
                            case 136:
                                for (int i4 = 1; i4 <= 8; i4++) {
                                    boolean zA0H = this.A07.A0H();
                                    if (A0C[4].charAt(20) != 'R') {
                                        A0C[4] = "wmiXxVCO1pDCphTe66oY7BPOwyAFxX93";
                                        if (zA0H) {
                                            int i5 = 8 - i4;
                                            this.A0A[i5].A07();
                                        }
                                    } else {
                                        A0C[3] = "RojSNoyJye4svFAgcf8I6qfTjBFYUXnP";
                                        if (zA0H) {
                                        }
                                    }
                                }
                                return;
                            case 137:
                                for (int i6 = 1; i6 <= 8; i6++) {
                                    if (this.A07.A0H()) {
                                        int i7 = 8 - i6;
                                        this.A0A[i7].A0E(true);
                                    }
                                }
                                return;
                            case 138:
                                for (int i8 = 1; i8 <= 8; i8++) {
                                    if (this.A07.A0H()) {
                                        int i9 = 8 - i8;
                                        this.A0A[i9].A0E(false);
                                    }
                                }
                                return;
                            case 139:
                                for (int i10 = 1; i10 <= 8; i10++) {
                                    if (this.A07.A0H()) {
                                        int i11 = 8 - i10;
                                        this.A0A[i11].A0E(!r1.A0I());
                                    }
                                }
                                return;
                            case 140:
                                for (int i12 = 1; i12 <= 8; i12++) {
                                    if (this.A07.A0H()) {
                                        int i13 = 8 - i12;
                                        this.A0A[i13].A08();
                                    }
                                }
                                return;
                            case 141:
                                C02274u c02274u = this.A07;
                                if (A0C[3].charAt(1) == 'o') {
                                    A0C[5] = "LOcI8geri01bbfSL3Un4ebrkDtb9fUkR";
                                    c02274u.A09(8);
                                    return;
                                }
                                break;
                            case 142:
                                return;
                            case 143:
                                A08();
                                return;
                            case 144:
                                boolean zA0G = this.A02.A0G();
                                if (A0C[5].charAt(13) == 'f') {
                                    A0C[6] = "3SE5mdYm5uC9wCg4PrUGVOVOhS7UyufG";
                                    if (!zA0G) {
                                        this.A07.A09(16);
                                        return;
                                    } else {
                                        A03();
                                        return;
                                    }
                                }
                                break;
                            case 145:
                                if (!this.A02.A0G()) {
                                    this.A07.A09(24);
                                    return;
                                } else {
                                    A04();
                                    return;
                                }
                            case 146:
                                if (!this.A02.A0G()) {
                                    this.A07.A09(16);
                                    return;
                                } else {
                                    A05();
                                    return;
                                }
                            case 147:
                            case 148:
                            case 149:
                            case 150:
                            default:
                                AbstractC02134g.A07(A00(73, 13, 73), A00(287, 20, 108) + i2);
                                return;
                            case 151:
                                if (!this.A02.A0G()) {
                                    this.A07.A09(32);
                                    return;
                                } else {
                                    A06();
                                    return;
                                }
                            case 152:
                            case 153:
                            case 154:
                            case 155:
                            case 156:
                            case 157:
                            case 158:
                            case 159:
                                int i14 = i2 - 152;
                                A0E(i14);
                                int window2 = this.A00;
                                if (window2 == i14) {
                                    return;
                                }
                                this.A00 = i14;
                                this.A02 = this.A0A[i14];
                                return;
                        }
                        throw new RuntimeException();
                    }

                    private void A0C(int i2) {
                        if (i2 <= 7) {
                            return;
                        }
                        if (i2 <= 15) {
                            this.A07.A09(8);
                        } else if (i2 <= 23) {
                            this.A07.A09(16);
                        } else {
                            if (i2 > 31) {
                                return;
                            }
                            this.A07.A09(24);
                        }
                    }

                    private void A0D(int i2) {
                        if (i2 <= 135) {
                            this.A07.A09(32);
                            return;
                        }
                        if (i2 <= 143) {
                            this.A07.A09(40);
                        } else {
                            if (i2 > 159) {
                                return;
                            }
                            this.A07.A09(2);
                            int length = this.A07.A04(6);
                            this.A07.A09(length * 8);
                        }
                    }

                    private void A0F(int i2) {
                        if (i2 == 127) {
                            this.A02.A09((char) 9835);
                        } else {
                            this.A02.A09((char) (i2 & PHIpAddressSearchManager.END_IP_SCAN));
                        }
                    }

                    private void A0G(int i2) {
                        this.A02.A09((char) (i2 & PHIpAddressSearchManager.END_IP_SCAN));
                    }

                    private void A0H(int i2) {
                        switch (i2) {
                            case 32:
                                this.A02.A09(' ');
                                return;
                            case 33:
                                this.A02.A09((char) 160);
                                return;
                            case 37:
                                this.A02.A09((char) 8230);
                                return;
                            case 42:
                                this.A02.A09((char) 352);
                                return;
                            case 44:
                                this.A02.A09((char) 338);
                                return;
                            case 48:
                                this.A02.A09((char) 9608);
                                return;
                            case 49:
                                this.A02.A09((char) 8216);
                                return;
                            case 50:
                                C0591Jp c0591Jp = this.A02;
                                if (A0C[6].length() != 3) {
                                    A0C[1] = "dnPp";
                                    c0591Jp.A09((char) 8217);
                                    return;
                                }
                                throw new RuntimeException();
                            case 51:
                                this.A02.A09((char) 8220);
                                return;
                            case 52:
                                this.A02.A09((char) 8221);
                                return;
                            case 53:
                                this.A02.A09((char) 8226);
                                return;
                            case 57:
                                this.A02.A09((char) 8482);
                                return;
                            case 58:
                                this.A02.A09((char) 353);
                                return;
                            case 60:
                                this.A02.A09((char) 339);
                                return;
                            case 61:
                                C0591Jp c0591Jp2 = this.A02;
                                if (A0C[0].charAt(19) == 'N') {
                                    A0C[6] = "g2xlw";
                                    c0591Jp2.A09((char) 8480);
                                    return;
                                }
                                break;
                            case 63:
                                this.A02.A09((char) 376);
                                return;
                            case 118:
                                this.A02.A09((char) 8539);
                                return;
                            case 119:
                                this.A02.A09((char) 8540);
                                return;
                            case 120:
                                this.A02.A09((char) 8541);
                                return;
                            case 121:
                                this.A02.A09((char) 8542);
                                return;
                            case 122:
                                C0591Jp c0591Jp3 = this.A02;
                                if (A0C[0].charAt(19) == 'N') {
                                    String[] strArr = A0C;
                                    strArr[2] = "AONnD2CR0STnJG";
                                    strArr[7] = "K";
                                    c0591Jp3.A09((char) 9474);
                                    return;
                                }
                                break;
                            case 123:
                                this.A02.A09((char) 9488);
                                return;
                            case 124:
                                this.A02.A09((char) 9492);
                                return;
                            case 125:
                                this.A02.A09((char) 9472);
                                return;
                            case 126:
                                this.A02.A09((char) 9496);
                                return;
                            case 127:
                                this.A02.A09((char) 9484);
                                return;
                            default:
                                AbstractC02134g.A07(A00(73, 13, 73), A00(307, 22, 52) + i2);
                                return;
                        }
                        throw new RuntimeException();
                    }

                    private void A0I(int i2) {
                        if (i2 == 160) {
                            this.A02.A09((char) 13252);
                            return;
                        }
                        AbstractC02134g.A07(A00(73, 13, 73), A00(329, 22, 4) + i2);
                        this.A02.A09('_');
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M
                    /* JADX INFO: renamed from: A0W */
                    public final /* bridge */ /* synthetic */ C8S A5r() throws C1713lj {
                        return super.A5r();
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M
                    /* JADX INFO: renamed from: A0X */
                    public final /* bridge */ /* synthetic */ C8P A5t() throws C1713lj {
                        return super.A5t();
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M
                    public final C1711lh A0Z() {
                        this.A05 = this.A04;
                        return new C1711lh((List) AbstractC02053y.A01(this.A04));
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M
                    /* JADX INFO: renamed from: A0a */
                    public final /* bridge */ /* synthetic */ void AHJ(C8S c8s) throws C1713lj {
                        super.AHJ(c8s);
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M
                    public final void A0b(C8S c8s) {
                        ByteBuffer byteBuffer = (ByteBuffer) AbstractC02053y.A01(c8s.A02);
                        this.A08.A0j(byteBuffer.array(), byteBuffer.limit());
                        while (true) {
                            C02284v c02284v = this.A08;
                            if (A0C[3].charAt(1) != 'o') {
                                throw new RuntimeException();
                            }
                            A0C[5] = "2zTM8NXP9KhrrfnQUZAXf9x7h4oPwvMb";
                            if (c02284v.A07() >= 3) {
                                C02284v c02284v2 = this.A08;
                                if (A0C[6].length() == 3) {
                                    throw new RuntimeException();
                                }
                                A0C[5] = "a4C0oLfpRPdUSfve8yJk6dKzwRXOoh8W";
                                int iA0I = c02284v2.A0I() & 7;
                                int i2 = iA0I & 3;
                                boolean z = (iA0I & 4) == 4;
                                byte bA0I = (byte) this.A08.A0I();
                                byte bA0I2 = (byte) this.A08.A0I();
                                if (i2 == 2 || i2 == 3) {
                                    if (z) {
                                        String strA00 = A00(73, 13, 73);
                                        if (i2 == 3) {
                                            A02();
                                            int i3 = (bA0I & 192) >> 6;
                                            int ccType = this.A01;
                                            if (ccType != -1 && i3 != (this.A01 + 1) % 4) {
                                                A08();
                                                AbstractC02134g.A07(strA00, A00(432, 40, 91) + this.A01 + A00(18, 9, 122) + i3);
                                            }
                                            this.A01 = i3;
                                            int i4 = bA0I & 63;
                                            if (i4 == 0) {
                                                i4 = 64;
                                            }
                                            this.A03 = new C0592Jq(i3, i4);
                                            byte[] inputBufferData = this.A03.A03;
                                            C0592Jq c0592Jq = this.A03;
                                            int i5 = c0592Jq.A00;
                                            c0592Jq.A00 = i5 + 1;
                                            inputBufferData[i5] = bA0I2;
                                        } else {
                                            AbstractC02053y.A07(i2 == 2);
                                            if (this.A03 == null) {
                                                AbstractC02134g.A05(strA00, A00(212, 55, 85));
                                            } else {
                                                byte[] inputBufferData2 = this.A03.A03;
                                                String[] strArr = A0C;
                                                if (strArr[2].length() == strArr[7].length()) {
                                                    throw new RuntimeException();
                                                }
                                                A0C[4] = "YjvVjm4QPcLmngCUKURICEhYITyNXaIl";
                                                C0592Jq c0592Jq2 = this.A03;
                                                int i6 = c0592Jq2.A00;
                                                c0592Jq2.A00 = i6 + 1;
                                                inputBufferData2[i6] = bA0I;
                                                byte[] inputBufferData3 = this.A03.A03;
                                                C0592Jq c0592Jq3 = this.A03;
                                                int i7 = c0592Jq3.A00;
                                                c0592Jq3.A00 = i7 + 1;
                                                inputBufferData3[i7] = bA0I2;
                                            }
                                        }
                                        if (this.A03.A00 == (this.A03.A01 * 2) - 1) {
                                            A02();
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                return;
                            }
                        }
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M
                    public final boolean A0d() {
                        return this.A04 != this.A05;
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M, com.facebook.ads.redexgen.core.AnonymousClass60
                    public final /* bridge */ /* synthetic */ void AHb() {
                        super.AHb();
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M, com.facebook.ads.redexgen.core.InterfaceC1720lq
                    public final /* bridge */ /* synthetic */ void AJh(long j) {
                        super.AJh(j);
                    }

                    @Override // com.facebook.ads.redexgen.core.C8M, com.facebook.ads.redexgen.core.AnonymousClass60
                    public final void flush() {
                        super.flush();
                        this.A04 = null;
                        this.A05 = null;
                        this.A00 = 0;
                        this.A02 = this.A0A[this.A00];
                        A08();
                        this.A03 = null;
                    }
                };
            case 9:
                final List<byte[]> list3 = c1981qI.A0X;
                return new C8T(list3) { // from class: com.facebook.ads.redexgen.X.1T
                    public static byte[] A01;
                    public final K2 A00;

                    static {
                        A01();
                    }

                    /* JADX WARN: Failed to parse debug info
                    java.lang.ArrayIndexOutOfBoundsException
                     */
                    {
                        super(A00(0, 10, 35));
                        C02284v c02284v = new C02284v(list3.get(0));
                        this.A00 = new K2(c02284v.A0M(), c02284v.A0M());
                    }

                    public static String A00(int i2, int i3, int i4) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
                        for (int i5 = 0; i5 < bArrCopyOfRange.length; i5++) {
                            bArrCopyOfRange[i5] = (byte) ((bArrCopyOfRange[i5] - i4) - 106);
                        }
                        return new String(bArrCopyOfRange);
                    }

                    public static void A01() {
                        A01 = new byte[]{-47, 3, -17, -47, -14, -16, -4, -15, -14, -1};
                    }

                    @Override // com.facebook.ads.redexgen.core.C8T
                    public final InterfaceC0585Jj A0g(byte[] bArr, int i2, boolean z) {
                        if (z) {
                            this.A00.A0J();
                        }
                        return new C1710lg(this.A00.A0I(bArr, i2));
                    }
                };
            case 10:
                return new C8T() { // from class: com.facebook.ads.redexgen.X.1S
                    public static byte[] A04;
                    public static String[] A05 = {"76NlL2uX7lwdFYW1QMx5a8yy6e1HTIfb", "PPHM0li7JhLOVOPCGl5v88MgokGKQYEj", "LiwvhCZeMt7eMvNF2Pj8LYB8xSxq2ldh", "dFyDCM0ueCIxVfSox0aflDZ7gvAI841l", "LzKPlW0IyQE1s7YXIJw5EfFPQg4N9HTr", "CSOqnRNK1RYkqInl5L0si0E", "7S3a0phqj2SDINZS1RTIUWP", "6mBJEewaGVYJqmHVNKA"};
                    public Inflater A00;
                    public final C02284v A01;
                    public final C02284v A02;
                    public final K5 A03;

                    public static String A01(int i2, int i3, int i4) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
                        int i5 = 0;
                        while (true) {
                            int length = bArrCopyOfRange.length;
                            if (A05[2].charAt(24) != 'x') {
                                throw new RuntimeException();
                            }
                            String[] strArr = A05;
                            strArr[6] = "onjCODWUldEJohp5LCZVLSR";
                            strArr[5] = "Jw3HdCuNfu1JKaBA98S5ZsK";
                            if (i5 >= length) {
                                return new String(bArrCopyOfRange);
                            }
                            bArrCopyOfRange[i5] = (byte) ((bArrCopyOfRange[i5] - i4) - 74);
                            i5++;
                        }
                    }

                    public static void A02() {
                        A04 = new byte[]{-79, -56, -44, -91, -58, -60, -48, -59, -58, -45};
                    }

                    static {
                        A02();
                    }

                    {
                        A01(0, 10, 23);
                        this.A01 = new C02284v();
                        this.A02 = new C02284v();
                        this.A03 = new K5();
                    }

                    public static C1931pT A00(C02284v c02284v, K5 k5) {
                        int limit = c02284v.A0A();
                        int nextSectionPosition = c02284v.A0I();
                        int sectionLength = c02284v.A0M();
                        int sectionType = c02284v.A09() + sectionLength;
                        if (sectionType > limit) {
                            c02284v.A0f(limit);
                            return null;
                        }
                        C1931pT c1931pTA06 = null;
                        switch (nextSectionPosition) {
                            case 20:
                                k5.A02(c02284v, sectionLength);
                                break;
                            case 21:
                                k5.A00(c02284v, sectionLength);
                                break;
                            case 22:
                                k5.A01(c02284v, sectionLength);
                                break;
                            case 128:
                                c1931pTA06 = k5.A06();
                                k5.A07();
                                break;
                        }
                        c02284v.A0f(sectionType);
                        return c1931pTA06;
                    }

                    private void A03(C02284v c02284v) {
                        if (c02284v.A07() > 0 && c02284v.A0B() == 120) {
                            if (this.A00 == null) {
                                this.A00 = new Inflater();
                            }
                            C02284v c02284v2 = this.A02;
                            Inflater inflater = this.A00;
                            if (A05[3].charAt(5) != 'M') {
                                throw new RuntimeException();
                            }
                            A05[2] = "qzpsP6hj6GdiA1o5yIc6icGGxX8HbfHZ";
                            if (C5C.A1D(c02284v, c02284v2, inflater)) {
                                c02284v.A0j(this.A02.A0l(), this.A02.A0A());
                            }
                        }
                    }

                    @Override // com.facebook.ads.redexgen.core.C8T
                    public final InterfaceC0585Jj A0g(byte[] bArr, int i2, boolean z) throws C1713lj {
                        this.A01.A0j(bArr, i2);
                        A03(this.A01);
                        this.A03.A07();
                        ArrayList arrayList = new ArrayList();
                        while (true) {
                            int iA07 = this.A01.A07();
                            if (A05[7].length() != 19) {
                                throw new RuntimeException();
                            }
                            A05[7] = "qQU5NmoFNSXVl5etyHU";
                            if (iA07 >= 3) {
                                C1931pT c1931pTA00 = A00(this.A01, this.A03);
                                if (c1931pTA00 != null) {
                                    arrayList.add(c1931pTA00);
                                }
                            } else {
                                return new C1709lf(Collections.unmodifiableList(arrayList));
                            }
                        }
                    }
                };
            default:
                throw new IllegalArgumentException(A00(0, 50, 37));
        }
    }

    @Override // com.facebook.ads.redexgen.core.EP
    public final boolean AKN(C1981qI c1981qI) {
        String str = c1981qI.A0W;
        String mimeType = A00(236, 8, 34);
        if (!mimeType.equals(str)) {
            String mimeType2 = A00(244, 10, 53);
            if (!mimeType2.equals(str)) {
                String mimeType3 = A00(122, 20, 118);
                if (!mimeType3.equals(str)) {
                    String mimeType4 = A00(167, 21, 70);
                    if (!mimeType4.equals(str)) {
                        String mimeType5 = A00(216, 20, 127);
                        if (!mimeType5.equals(str)) {
                            String mimeType6 = A00(188, 28, 65);
                            if (!mimeType6.equals(str)) {
                                String mimeType7 = A00(50, 19, 111);
                                if (!mimeType7.equals(str)) {
                                    String mimeType8 = A00(142, 25, 115);
                                    if (!mimeType8.equals(str)) {
                                        String mimeType9 = A00(69, 19, 10);
                                        if (!mimeType9.equals(str)) {
                                            String mimeType10 = A00(88, 19, 24);
                                            if (!mimeType10.equals(str)) {
                                                String mimeType11 = A00(107, 15, 54);
                                                if (!mimeType11.equals(str)) {
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
