package com.facebook.ads.redexgen.core;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0615Kn {
    public static byte[] A00;
    public static String[] A01 = {"6VJGxYRVGzkOFylAWqo", "TQDRStRjVTcp84EAqriMHD1W", "Y0YMWliml1c9R0RakThzWHnpZrTCSrBu", "hjS3TiOTsIfHHkhXtOFrFHFAaycKEbQY", "GvjOo5wC83Psjizly91M8Dr7lGNbFkes", "VFbjP0ZwmY6IK0pKGb7V8NSJj5u1SgyV", "T0F9FjreghpLds1JHOV1Zh8xCqpA0ysb", "F9ZBXP7xE9Rr53rKOaE"};
    public static final Pattern A02;
    public static final Map<String, Integer> A03;
    public static final Map<String, Integer> A04;
    public static final Pattern A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A06(List<C0603Kb> list, String str, C0611Kj c0611Kj) {
        List<C0612Kk> listA0E = A0E(list, str, c0611Kj);
        for (int i = 0; i < listA0E.size(); i++) {
            C0603Kb c0603Kb = listA0E.get(i).A01;
            if (c0603Kb.A07() != -1) {
                return c0603Kb.A07();
            }
        }
        return -1;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannedString A07(String str, String str2, List<C0603Kb> list) {
        int i;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        int iA05 = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int length = str2.length();
            if (A01[3].charAt(21) == 'Z') {
                throw new RuntimeException();
            }
            A01[5] = "AeTA9zfG0TGme9BEKFHCyzeTODloAdj0";
            if (iA05 >= length) {
                while (!arrayDeque.isEmpty()) {
                    A0K(str, (C0611Kj) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                A0K(str, C0611Kj.A00(), Collections.emptyList(), spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char cCharAt = str2.charAt(iA05);
            switch (cCharAt) {
                case '&':
                    int iIndexOf = str2.indexOf(59, iA05 + 1);
                    int iIndexOf2 = str2.indexOf(32, iA05 + 1);
                    if (iIndexOf == -1) {
                        iIndexOf = iIndexOf2;
                    } else if (iIndexOf2 != -1) {
                        iIndexOf = Math.min(iIndexOf, iIndexOf2);
                    }
                    if (iIndexOf == -1) {
                        spannableStringBuilder.append(cCharAt);
                        iA05++;
                    } else {
                        A0J(str2.substring(iA05 + 1, iIndexOf), spannableStringBuilder);
                        if (iIndexOf == iIndexOf2) {
                            spannableStringBuilder.append((CharSequence) A0C(1, 1, 38));
                        }
                        iA05 = iIndexOf + 1;
                    }
                    break;
                case '<':
                    if (iA05 + 1 < str2.length()) {
                        int i2 = iA05;
                        boolean z = str2.charAt(i2 + 1) == '/';
                        iA05 = A05(str2, i2 + 1);
                        boolean z2 = str2.charAt(iA05 + (-2)) == '/';
                        int i3 = (z ? 2 : 1) + i2;
                        if (A01[1].length() != 9) {
                            String[] strArr = A01;
                            strArr[2] = "RmddLkS1dXQ96i0rYlSMmYhsPXo1tsUj";
                            strArr[6] = "bXvTM6kBQx9RsuQ7PFPuWtENxJrNvh3v";
                            i = z2 ? iA05 - 2 : iA05 - 1;
                        } else if (z2) {
                        }
                        String strSubstring = str2.substring(i3, i);
                        if (!strSubstring.trim().isEmpty()) {
                            String strA0D = A0D(strSubstring);
                            if (A0O(strA0D)) {
                                if (z) {
                                    while (!arrayDeque.isEmpty()) {
                                        C0611Kj c0611Kj = (C0611Kj) arrayDeque.pop();
                                        A0K(str, c0611Kj, arrayList, spannableStringBuilder, list);
                                        if (!arrayDeque.isEmpty()) {
                                            arrayList.add(new C0610Ki(c0611Kj, spannableStringBuilder.length()));
                                        } else if (A01[1].length() != 9) {
                                            A01[3] = "6LBQPk5FkDk3NWAQRRtmrnBQ3lB0BSgu";
                                            arrayList.clear();
                                        } else {
                                            arrayList.clear();
                                        }
                                        if (c0611Kj.A01.equals(strA0D)) {
                                        }
                                        break;
                                    }
                                } else if (!z2) {
                                    int length2 = spannableStringBuilder.length();
                                    if (A01[4].charAt(3) == 'a') {
                                        arrayDeque.push(C0611Kj.A01(strSubstring, length2));
                                    } else {
                                        String[] strArr2 = A01;
                                        strArr2[0] = "wdDtpexUk8e3MYkSHhs";
                                        strArr2[7] = "WrocTxwzP1SCyFuF7cP";
                                        arrayDeque.push(C0611Kj.A01(strSubstring, length2));
                                    }
                                }
                            }
                        }
                    } else {
                        iA05++;
                    }
                    break;
                default:
                    spannableStringBuilder.append(cCharAt);
                    iA05++;
                    break;
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C0607Kf A0A(C02284v c02284v, List<C0603Kb> list) {
        String strA0T = c02284v.A0T();
        if (strA0T == null) {
            return null;
        }
        Matcher matcher = A02.matcher(strA0T);
        if (matcher.matches()) {
            return A0B(null, matcher, c02284v, list);
        }
        String strA0T2 = c02284v.A0T();
        if (strA0T2 == null) {
            return null;
        }
        Matcher matcher2 = A02.matcher(strA0T2);
        if (matcher2.matches()) {
            return A0B(strA0T.trim(), matcher2, c02284v, list);
        }
        return null;
    }

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0F() {
        A00 = new byte[]{81, 0, 85, 68, 48, 63, 71, 83, 69, 86, 68, 48, 63, 71, 69, 0, 106, 118, 51, 20, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 27, 22, 19, 30, 90, 93, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 31, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 25, 27, 22, 93, 90, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 27, 22, 15, 31, 64, 90, 63, 24, 0, 23, 26, 31, 18, 86, 23, 26, 31, 17, 24, 27, 19, 24, 2, 86, 0, 23, 26, 3, 19, 76, 86, 82, 117, 109, 122, 119, 114, 127, 59, 122, 117, 120, 115, 116, 105, 59, 109, 122, 119, 110, 126, 33, 59, 46, 22, 20, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 20, 19, 26, 93, 31, 28, 25, 93, 30, 8, 24, 93, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 24, 9, 9, 20, 19, 26, 71, 93, 63, 7, 5, 28, 28, 5, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 76, 15, 25, 9, 76, 27, 5, 24, 4, 76, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 8, 76, 4, 9, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 8, 9, 30, 86, 76, 53, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 23, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 64, 3, 21, 5, 64, 19, 5, 20, 20, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 7, 64, 10, 56, 63, 43, 41, 41, 30, 40, 56, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 60, 47, 46, 56, 47, 40, 83, 47, 93, 46, 123, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 121, 118, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 121, 86, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 8, 8, 27, 121, 86, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 121, 118, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 26, 1, 81, 92, 89, 87, 94, 10, 6, 27, 45, 93, 88, 96, 93, 83, 94, 92, 84, 4, 1, 57, 4, 10, 19, 3, 119, 114, 74, 118, 108, 116, 123, 118, 115, 75, 120, 125, 121, 113, 7, 2, 58, 8, 4, 2, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 17, 4, 39, 34, 26, 55, 32, 33, 64, 69, 125, 85, 74, 75, 86, 71, 91, 94, 102, 64, 92, 85, 85, 86, 78, 6, 8, 5, 7, 15, 15, 1, 24, 8, 7, 101, 99, 104, 114, 99, 116, 7, 29, 5, 10, 117, 126, 116, 65, 82, 0, 3, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 4, 5, 24, 3, 4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 74, 31, 4, 25, 31, 26, 26, 5, 24, 30, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 74, 15, 4, 30, 3, 30, 19, 80, 74, 77, 76, 90, 87, 88, 81, 69, 76, 79, 93, 107, 110, 106, 98, 65, 68, 67, 72, 35, 38, 33, 42, 98, 35, 42, 41, 59, 113, 116, 115, 120, 48, 111, 116, 122, 117, 105, 106, 116, 113, 105, 79, 67, 69, 71, 76, 86, 67, 5, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 53, 57, 40, 43, 29, 2, 30, 4, 25, 4, 2, 3, 73, 94, 95, 84, 79, 65, 78, 82, 37, 59, 69, 67, 7, 0, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 86, 76, 95, 64, 0, 7, 18, 1, 7, 110, 124, 44, 63, 40, 46, 51, 57, 59, 54, 68, 91, 90, 71, 86, 52, 40, 33, 33, 34, 58};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0H(SpannableStringBuilder spannableStringBuilder, String str, C0611Kj c0611Kj, List<C0610Ki> list, List<C0603Kb> list2) {
        int iA06 = A06(list2, str, c0611Kj);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, C0610Ki.A03());
        int length = 0;
        int i = c0611Kj.A00;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (A0C(415, 2, 49).equals(((C0610Ki) arrayList.get(i2)).A01.A01)) {
                C0610Ki c0610Ki = (C0610Ki) arrayList.get(i2);
                int iA00 = A00(A06(list2, str, c0610Ki.A01), iA06, 1);
                int i3 = c0610Ki.A01.A00 - length;
                int i4 = c0610Ki.A00 - length;
                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i3, i4);
                spannableStringBuilder.delete(i3, i4);
                spannableStringBuilder.setSpan(new C1927pP(charSequenceSubSequence.toString(), iA00), i, i3, 33);
                length += charSequenceSubSequence.length();
                i = i3;
            }
        }
    }

    static {
        A0F();
        A02 = Pattern.compile(A0C(187, 26, 35));
        A05 = Pattern.compile(A0C(3, 12, 106));
        HashMap map = new HashMap();
        map.put(A0C(440, 5, 53), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN)));
        map.put(A0C(349, 4, 1), Integer.valueOf(Color.rgb(0, PHIpAddressSearchManager.END_IP_SCAN, 0)));
        map.put(A0C(300, 4, 98), Integer.valueOf(Color.rgb(0, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN)));
        map.put(A0C(405, 3, 61), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, 0, 0)));
        map.put(A0C(445, 6, 75), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, 0)));
        map.put(A0C(380, 7, 36), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, 0, PHIpAddressSearchManager.END_IP_SCAN)));
        map.put(A0C(289, 4, 107), Integer.valueOf(Color.rgb(0, 0, PHIpAddressSearchManager.END_IP_SCAN)));
        map.put(A0C(284, 5, 98), Integer.valueOf(Color.rgb(0, 0, 0)));
        Map<String, Integer> defaultColors = Collections.unmodifiableMap(map);
        A04 = defaultColors;
        HashMap map2 = new HashMap();
        map2.put(A0C(267, 8, 36), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN)));
        map2.put(A0C(244, 7, 18), Integer.valueOf(Color.rgb(0, PHIpAddressSearchManager.END_IP_SCAN, 0)));
        map2.put(A0C(237, 7, 19), Integer.valueOf(Color.rgb(0, PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN)));
        map2.put(A0C(261, 6, 67), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, 0, 0)));
        map2.put(A0C(275, 9, 63), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, PHIpAddressSearchManager.END_IP_SCAN, 0)));
        map2.put(A0C(251, 10, 99), Integer.valueOf(Color.rgb(PHIpAddressSearchManager.END_IP_SCAN, 0, PHIpAddressSearchManager.END_IP_SCAN)));
        map2.put(A0C(230, 7, 96), Integer.valueOf(Color.rgb(0, 0, PHIpAddressSearchManager.END_IP_SCAN)));
        map2.put(A0C(222, 8, 57), Integer.valueOf(Color.rgb(0, 0, 0)));
        Map<String, Integer> defaultBackgroundColors = Collections.unmodifiableMap(map2);
        A03 = defaultBackgroundColors;
    }

    public static int A00(int i, int i2, int i3) {
        if (i != -1) {
            return i;
        }
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A01(java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r7 = 2
            r6 = 1
            r5 = 0
            switch(r0) {
                case -1364013995: goto L80;
                case -1074341483: goto L5b;
                case 100571: goto L4a;
                case 109757538: goto L39;
                default: goto La;
            }
        La:
            r0 = -1
        Lb:
            switch(r0) {
                case 0: goto L93;
                case 1: goto L92;
                case 2: goto L92;
                case 3: goto L91;
                default: goto Le;
            }
        Le:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 69
            r1 = 22
            r0 = 29
            java.lang.String r0 = A0C(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.String r3 = r0.toString()
            r2 = 167(0xa7, float:2.34E-43)
            r1 = 15
            r0 = 91
            java.lang.String r0 = A0C(r2, r1, r0)
            com.facebook.ads.redexgen.core.AbstractC02134g.A07(r0, r3)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            return r0
        L39:
            r2 = 425(0x1a9, float:5.96E-43)
            r1 = 5
            r0 = 117(0x75, float:1.64E-43)
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 0
            goto Lb
        L4a:
            r2 = 304(0x130, float:4.26E-43)
            r1 = 3
            r0 = 22
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 3
            goto Lb
        L5b:
            r4 = 387(0x183, float:5.42E-43)
            r3 = 6
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AbstractC0615Kn.A01
            r0 = 1
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 9
            if (r1 == r0) goto L94
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC0615Kn.A01
            java.lang.String r1 = "zDr3pXiReOD9C2voGl4pNyTssnTsthj2"
            r0 = 4
            r2[r0] = r1
            r0 = 110(0x6e, float:1.54E-43)
            java.lang.String r0 = A0C(r4, r3, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 2
            goto Lb
        L80:
            r2 = 294(0x126, float:4.12E-43)
            r1 = 6
            r0 = 0
            java.lang.String r0 = A0C(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto La
            r0 = 1
            goto Lb
        L91:
            return r7
        L92:
            return r6
        L93:
            return r5
        L94:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC0615Kn.A01(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A02(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1842484672:
                b = !str.equals(A0C(357, 9, 73)) ? (byte) -1 : (byte) 0;
                break;
            case -1364013995:
                if (str.equals(A0C(294, 6, 0))) {
                    b = 2;
                    break;
                }
                break;
            case -1276788989:
                if (str.equals(A0C(366, 10, 27))) {
                    b = 4;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals(A0C(387, 6, 110))) {
                    b = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals(A0C(304, 3, 22))) {
                    b = 5;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(A0C(425, 5, 117))) {
                    b = 1;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            default:
                AbstractC02134g.A07(A0C(167, 15, 91), A0C(69, 22, 29) + str);
                return Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(String str) {
        byte b;
        switch (str.hashCode()) {
            case -1364013995:
                b = !str.equals(A0C(294, 6, 0)) ? (byte) -1 : (byte) 2;
                break;
            case -1074341483:
                if (str.equals(A0C(387, 6, 110))) {
                    b = 3;
                    break;
                }
                break;
            case 100571:
                if (str.equals(A0C(304, 3, 22))) {
                    b = 4;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(A0C(345, 4, 47))) {
                    b = 1;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(A0C(408, 5, 32))) {
                    b = 5;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(A0C(425, 5, 117))) {
                    b = 0;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                return 1;
            case 1:
                return 4;
            case 2:
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            default:
                AbstractC02134g.A07(A0C(167, 15, 91), A0C(44, 25, 112) + str);
                return 2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A04(String str) {
        byte b;
        switch (str.hashCode()) {
            case 3462:
                b = !str.equals(A0C(376, 2, 0)) ? (byte) -1 : (byte) 1;
                break;
            case 3642:
                if (str.equals(A0C(413, 2, 81))) {
                    b = 0;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                AbstractC02134g.A07(A0C(167, 15, 91), A0C(18, 26, 124) + str);
                return Integer.MIN_VALUE;
        }
    }

    public static int A05(String str, int i) {
        int iIndexOf = str.indexOf(62, i);
        if (iIndexOf == -1) {
            int index = str.length();
            return index;
        }
        int index2 = iIndexOf + 1;
        return index2;
    }

    public static C01953o A08(String str) {
        C0614Km builder = new C0614Km();
        A0L(str, builder);
        return builder.A07();
    }

    public static C1931pT A09(CharSequence charSequence) {
        C0614Km infoBuilder = new C0614Km();
        infoBuilder.A0A = charSequence;
        return infoBuilder.A07().A0H();
    }

    public static C0607Kf A0B(String str, Matcher matcher, C02284v c02284v, List<C0603Kb> list) {
        C0614Km c0614Km = new C0614Km();
        try {
            c0614Km.A09 = AbstractC0616Ko.A01((String) AbstractC02053y.A01(matcher.group(1)));
            c0614Km.A08 = AbstractC0616Ko.A01((String) AbstractC02053y.A01(matcher.group(2)));
            A0L((String) AbstractC02053y.A01(matcher.group(3)), c0614Km);
            StringBuilder sb = new StringBuilder();
            String strA0T = c02284v.A0T();
            while (true) {
                boolean zIsEmpty = TextUtils.isEmpty(strA0T);
                if (A01[5].charAt(2) == 'h') {
                    throw new RuntimeException();
                }
                A01[1] = "2AwiW2AhFaTR";
                if (!zIsEmpty) {
                    if (sb.length() > 0) {
                        sb.append(A0C(0, 1, 93));
                    }
                    sb.append(strA0T.trim());
                    strA0T = c02284v.A0T();
                } else {
                    c0614Km.A0A = A07(str, sb.toString(), list);
                    return c0614Km.A08();
                }
            }
        } catch (NumberFormatException unused) {
            AbstractC02134g.A07(A0C(167, 15, 91), A0C(117, 30, 106) + matcher.group());
            return null;
        }
    }

    public static String A0D(String str) {
        String strTrim = str.trim();
        AbstractC02053y.A07(!strTrim.isEmpty());
        return C5C.A1P(strTrim, A0C(182, 5, 117))[0];
    }

    public static List<C0612Kk> A0E(List<C0603Kb> list, String str, C0611Kj c0611Kj) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C0603Kb c0603Kb = list.get(i);
            int i2 = c0603Kb.A09(str, c0611Kj.A01, c0611Kj.A03, c0611Kj.A02);
            if (i2 > 0) {
                arrayList.add(new C0612Kk(i2, c0603Kb));
            }
        }
        Collections.sort(arrayList);
        if (A01[3].charAt(21) == 'Z') {
            throw new RuntimeException();
        }
        A01[3] = "10DtqaDx3Mjis7pngfRsmCfeCaw0vB2Q";
        return arrayList;
    }

    public static void A0G(SpannableStringBuilder spannableStringBuilder, C0603Kb c0603Kb, int i, int i2) {
        if (c0603Kb == null) {
            return;
        }
        if (c0603Kb.A08() != -1) {
            AbstractC02003t.A00(spannableStringBuilder, new StyleSpan(c0603Kb.A08()), i, i2, 33);
        }
        if (c0603Kb.A0S()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        boolean zA0T = c0603Kb.A0T();
        if (A01[3].charAt(21) != 'Z') {
            A01[3] = "1YLI45HvZzSZe2yut9V0MUcCwjpGC5gE";
            if (zA0T) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (c0603Kb.A0R()) {
                AbstractC02003t.A00(spannableStringBuilder, new ForegroundColorSpan(c0603Kb.A05()), i, i2, 33);
            }
            if (c0603Kb.A0Q()) {
                AbstractC02003t.A00(spannableStringBuilder, new BackgroundColorSpan(c0603Kb.A04()), i, i2, 33);
            }
            if (c0603Kb.A0K() != null) {
                AbstractC02003t.A00(spannableStringBuilder, new TypefaceSpan(c0603Kb.A0K()), i, i2, 33);
            }
            switch (c0603Kb.A06()) {
                case 1:
                    AbstractC02003t.A00(spannableStringBuilder, new AbsoluteSizeSpan((int) c0603Kb.A03(), true), i, i2, 33);
                    break;
                case 2:
                    AbstractC02003t.A00(spannableStringBuilder, new RelativeSizeSpan(c0603Kb.A03()), i, i2, 33);
                    break;
                case 3:
                    AbstractC02003t.A00(spannableStringBuilder, new RelativeSizeSpan(c0603Kb.A03() / 100.0f), i, i2, 33);
                    break;
            }
            if (c0603Kb.A0P()) {
                spannableStringBuilder.setSpan(new C1928pQ(), i, i2, 33);
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public static void A0I(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i, int i2) {
        for (String str : set) {
            boolean zContainsKey = A04.containsKey(str);
            if (A01[1].length() == 9) {
                throw new RuntimeException();
            }
            A01[5] = "YNIn8hUAyZDjSH3JhERqEXsouXgj93JS";
            if (zContainsKey) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(A04.get(str).intValue()), i, i2, 33);
            } else {
                Map<String, Integer> map = A03;
                String className = A01[3];
                if (className.charAt(21) != 'Z') {
                    A01[3] = "z1JdxX10iLj514Di1TKQv9nGlpU0X7eV";
                    if (map.containsKey(str)) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(A03.get(str).intValue()), i, i2, 33);
                    }
                } else if (map.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(A03.get(str).intValue()), i, i2, 33);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0J(java.lang.String r4, android.text.SpannableStringBuilder r5) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC0615Kn.A0J(java.lang.String, android.text.SpannableStringBuilder):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0 A[LOOP:0: B:42:0x00ea->B:44:0x00f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017 A[RETURN] */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0K(java.lang.String r8, com.facebook.ads.redexgen.core.C0611Kj r9, java.util.List<com.facebook.ads.redexgen.core.C0610Ki> r10, android.text.SpannableStringBuilder r11, java.util.List<com.facebook.ads.redexgen.core.C0603Kb> r12) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC0615Kn.A0K(java.lang.String, com.facebook.ads.redexgen.X.Kj, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    public static void A0L(String str, C0614Km c0614Km) {
        String value = A0C(167, 15, 91);
        Matcher matcher = A05.matcher(str);
        while (matcher.find()) {
            Object objA01 = AbstractC02053y.A01(matcher.group(1));
            String[] strArr = A01;
            if (strArr[2].charAt(10) == strArr[6].charAt(10)) {
                throw new RuntimeException();
            }
            A01[3] = "IuLRiWa83LmFflMS6GnqXQo4BkpBDAaM";
            String str2 = (String) objA01;
            String str3 = (String) AbstractC02053y.A01(matcher.group(2));
            try {
                if (A0C(353, 4, 43).equals(str2)) {
                    A0M(str3, c0614Km);
                } else if (A0C(213, 5, 54).equals(str2)) {
                    c0614Km.A06 = A03(str3);
                } else if (A0C(397, 8, 107).equals(str2)) {
                    A0N(str3, c0614Km);
                } else if (A0C(421, 4, 35).equals(str2)) {
                    c0614Km.A02 = AbstractC0616Ko.A00(str3);
                } else if (A0C(432, 8, 92).equals(str2)) {
                    c0614Km.A07 = A04(str3);
                } else {
                    AbstractC02134g.A07(value, A0C(147, 20, 102) + str2 + A0C(15, 1, 60) + str3);
                }
            } catch (NumberFormatException unused) {
                AbstractC02134g.A07(value, A0C(91, 26, 123) + matcher.group());
            }
        }
    }

    public static void A0M(String str, C0614Km c0614Km) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            int commaIndex = iIndexOf + 1;
            c0614Km.A03 = A01(str.substring(commaIndex));
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith(A0C(2, 1, 118))) {
            c0614Km.A00 = AbstractC0616Ko.A00(str);
            c0614Km.A04 = 0;
        } else {
            int commaIndex2 = Integer.parseInt(str);
            c0614Km.A00 = commaIndex2;
            c0614Km.A04 = 1;
        }
    }

    public static void A0N(String str, C0614Km c0614Km) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            int commaIndex = iIndexOf + 1;
            c0614Km.A05 = A02(str.substring(commaIndex));
            str = str.substring(0, iIndexOf);
        }
        c0614Km.A01 = AbstractC0616Ko.A00(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000d A[RETURN] */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0O(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC0615Kn.A0O(java.lang.String):boolean");
    }
}
