package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03389h extends AbstractC1792nD {
    public static byte[] A07;
    public static String[] A08 = {"yr7s5jzv1addyUjDczkFmKgb3TbXTjPI", "k5bxDF12X7IfueMvpCyLhsS14secbcRr", "A1nn9z9SPvnfAziOnMuSk0GZzxZ0jVfY", "Bn8GSVMc2Ww3cTp6j1ZQIVGuo4fvIYJ3", "KOSGSA", "kbDMqlVGuQuF7sZpY9G1V32bVqx23m", "bfxskyCfRQ3e5JfVyMYK1TBq", "KPf5jweXKATwb3ocWNu711OjnnCWcsTU"};
    public static final AbstractC1983qK<Integer> A09;
    public static final AbstractC1983qK<Integer> A0A;
    public C1987qQ A00;
    public C03399i A01;
    public C0453Ef A02;
    public final Context A03;
    public final InterfaceC0460Em A04;
    public final Object A05;
    public final boolean A06;

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c7, code lost:
    
        if (r18.A01.A0A == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
    
        if (r7.isEmpty() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d5, code lost:
    
        if (r7.size() != r10.A01) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d7, code lost:
    
        r6.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e7, code lost:
    
        if (com.facebook.ads.redexgen.core.C03389h.A08[1].charAt(16) == 'p') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e9, code lost:
    
        com.facebook.ads.redexgen.core.C03389h.A08[4] = "67hsDi";
        r6.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f3, code lost:
    
        r14.addAll(r6);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:
    
        com.facebook.ads.redexgen.core.C03389h.A08[4] = "yJ8LwG";
        r6.add(r7);
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("D25277746")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T extends AbstractC0455Eh<T>> Pair<C0459El, Integer> A0A(int i, C0462Eo c0462Eo, int[][][] iArr, InterfaceC0454Eg<T> interfaceC0454Eg, Comparator<List<T>> comparator) {
        List arrayList;
        ArrayList arrayList2 = new ArrayList();
        int iA02 = c0462Eo.A02();
        for (int i2 = 0; i2 < iA02; i2++) {
            if (i == c0462Eo.A03(i2)) {
                C1811nW c1811nWA07 = c0462Eo.A07(i2);
                int i3 = 0;
                while (i3 < c1811nWA07.A01) {
                    C1944pg c1944pgA05 = c1811nWA07.A05(i3);
                    List<T> listA5F = interfaceC0454Eg.A5F(i2, c1944pgA05, iArr[i2][i3]);
                    boolean[] zArr = new boolean[c1944pgA05.A01];
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    int i4 = 0;
                    while (true) {
                        int i5 = c1944pgA05.A01;
                        if (A08[4].length() != 6) {
                            throw new RuntimeException();
                        }
                        A08[7] = "GGTbcpljDMs4NAqJNauGpoXnSvHOQ6AN";
                        if (i4 >= i5) {
                            break;
                        }
                        T t = listA5F.get(i4);
                        int iA08 = t.A08();
                        if (!zArr[i4] && iA08 != 0) {
                            if (iA08 == 1) {
                                arrayList = BP.A04(t);
                                arrayList3.add(t);
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(t);
                                int i6 = i4 + 1;
                                while (i6 < c1944pgA05.A01) {
                                    T t2 = listA5F.get(i6);
                                    if (t2.A08() == 2 && t.A09(t2)) {
                                        arrayList.add(t2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    if (A08[1].charAt(16) == 'p') {
                                        A08[7] = "CPvHWQWYEszLaRsxiIiXKw3X1jOClslA";
                                    }
                                }
                            }
                            arrayList4.add(arrayList);
                        }
                        i4++;
                    }
                }
            }
        }
        boolean zIsEmpty = arrayList2.isEmpty();
        if (A08[1].charAt(16) != 'p') {
            throw new RuntimeException();
        }
        A08[4] = "ji0WxR";
        if (zIsEmpty) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iArr2[i7] = ((AbstractC0455Eh) list.get(i7)).A01;
        }
        AbstractC0455Eh abstractC0455Eh = (AbstractC0455Eh) list.get(0);
        return Pair.create(new C0459El(abstractC0455Eh.A03, iArr2), Integer.valueOf(abstractC0455Eh.A00));
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A08[5].length() == 27) {
                throw new RuntimeException();
            }
            A08[4] = "58VoVy";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 10);
            i4++;
        }
    }

    public static void A0M() {
        A07 = new byte[]{91, 92, -112, 127, -124, -118, 59, 126, -125, 124, -119, -119, -128, -121, 59, 126, -118, -112, -119, -113, 59, 126, -118, -119, -114, -113, -115, 124, -124, -119, -113, -114, 59, 126, 124, -119, -119, -118, -113, 59, 125, -128, 59, 124, -117, -117, -121, -124, -128, 127, 59, -110, -124, -113, -125, -118, -112, -113, 59, -115, -128, -127, -128, -115, -128, -119, 126, -128, 59, -113, -118, 59, 94, -118, -119, -113, -128, -109, -113, 73, 59, 93, -112, -124, -121, 127, 59, -113, -125, -128, 59, -113, -115, 124, 126, -122, 59, -114, -128, -121, -128, 126, -113, -118, -115, 59, -124, -119, -114, -113, 124, -119, 126, -128, 59, -110, -124, -113, -125, 59, -118, -119, -128, 59, -118, -127, 59, -113, -125, -128, 59, -119, -118, -119, 72, 127, -128, -117, -115, -128, 126, 124, -113, -128, 127, 59, 126, -118, -119, -114, -113, -115, -112, 126, -113, -118, -115, -114, 59, -113, -125, 124, -113, 59, -113, 124, -122, -128, 59, 124, 59, 94, -118, -119, -113, -128, -109, -113, 59, 124, -115, -126, -112, -120, -128, -119, -113, 73, -103, -70, -69, -74, -54, -63, -55, -87, -57, -74, -72, -64, -88, -70, -63, -70, -72, -55, -60, -57, -57, -37, -54, -49, -43, -107, -57, -55, -103, -83, -63, -80, -75, -69, 123, -83, -81, -128, -49, -29, -46, -41, -35, -99, -45, -49, -47, -95, -70, -50, -67, -62, -56, -120, -66, -70, -68, -116, -122, -61, -56, -68, -54, -61, -71, -119, 124, 119, 120, -126, 66, 116, -119, 67, 68, -98, -111, -116, -115, -105, 87, -119, -98, -117, -33, -46, -51, -50, -40, -104, -51, -40, -43, -53, -30, -106, -33, -46, -36, -46, -40, -41, -92, -105, -110, -109, -99, 93, -106, -109, -92, -111, -11, -24, -29, -28, -18, -82, -9, -84, -11, -19, -29, -83, -18, -19, -79, -83, -11, -17, -72};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0N(C1811nW c1811nW, C1940pc c1940pc, Map<Integer, C1942pe> map) {
        C1942pe c1942pe;
        for (int i = 0; i < c1811nW.A01; i++) {
            C1942pe c1942pe2 = c1940pc.A0G.get(c1811nW.A05(i));
            if (c1942pe2 != null && ((c1942pe = map.get(Integer.valueOf(c1942pe2.A01()))) == null || (c1942pe.A01.isEmpty() && !c1942pe2.A01.isEmpty()))) {
                map.put(Integer.valueOf(c1942pe2.A01()), c1942pe2);
            }
        }
    }

    static {
        A0M();
        A09 = AbstractC1983qK.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.EZ
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C03389h.A05((Integer) obj, (Integer) obj2);
            }
        });
        A0A = AbstractC1983qK.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.Ea
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C03389h.A06((Integer) obj, (Integer) obj2);
            }
        });
    }

    @Deprecated
    public C03389h() {
        this(C03399i.A0J, new C1806nR());
    }

    @MetaExoPlayerCustomization(type = {"NEW_CONSTRUCTOR"}, value = "Backward Compatible Constructor")
    public C03389h(InterfaceC0460Em interfaceC0460Em) {
        this(C03399i.A0J, interfaceC0460Em);
    }

    @Deprecated
    public C03389h(C1940pc c1940pc, InterfaceC0460Em interfaceC0460Em) {
        this(c1940pc, interfaceC0460Em, null);
    }

    public C03389h(C1940pc c1940pc, InterfaceC0460Em interfaceC0460Em, Context context) {
        this.A05 = new Object();
        this.A03 = context != null ? context.getApplicationContext() : null;
        this.A04 = interfaceC0460Em;
        if (c1940pc instanceof C03399i) {
            this.A01 = (C03399i) c1940pc;
        } else {
            C03399i defaultParameters = context == null ? C03399i.A0J : C03399i.A02(context);
            this.A01 = defaultParameters.A0P().A0u(c1940pc).A0p();
        }
        this.A00 = C1987qQ.A07;
        this.A06 = context != null && C5C.A18(context);
        if (!this.A06 && context != null && C5C.A02 >= 32) {
            this.A02 = C0453Ef.A00(context);
        }
        if (this.A01.A08 && context == null) {
            AbstractC02134g.A07(A0J(188, 20, 75), A0J(1, 187, 17));
        }
    }

    public static int A00(int i, int i2) {
        if (i != 0 && i == i2) {
            return Integer.MAX_VALUE;
        }
        return Integer.bitCount(i & i2);
    }

    public static int A02(C1981qI c1981qI, String str, boolean z) {
        String strA0K;
        if (TextUtils.isEmpty(str)) {
            String strA0K2 = A0K(str);
            strA0K = A0K(c1981qI.A0V);
            if (strA0K != null) {
            }
            if (z) {
                return 0;
            }
        }
        String str2 = c1981qI.A0V;
        String[] strArr = A08;
        if (strArr[6].length() != strArr[3].length()) {
            A08[7] = "utaRfuDCbQDIc6IM3a2tNPgwwhECnGgZ";
            if (str.equals(str2)) {
                if (A08[4].length() != 6) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[6] = "bdPum8qTTDlHeCQDHcvgSGFt";
                strArr2[3] = "zx28NE7Z14W3AzzAuoWnzSjL1M2eUdTs";
                return 4;
            }
            String strA0K22 = A0K(str);
            strA0K = A0K(c1981qI.A0V);
            if (strA0K != null || strA0K22 == null) {
                return (z && strA0K == null) ? 1 : 0;
            }
            if (strA0K.startsWith(strA0K22) || strA0K22.startsWith(strA0K)) {
                return 3;
            }
            String strA0J = A0J(0, 1, 36);
            String str3 = C5C.A1P(strA0K, strA0J)[0];
            String formatMainLanguage = C5C.A1P(strA0K22, strA0J)[0];
            String[] strArr3 = A08;
            String str4 = strArr3[6];
            String formatLanguage = strArr3[3];
            if (str4.length() != formatLanguage.length()) {
                A08[4] = "rXSrCW";
                if (!str3.equals(formatMainLanguage)) {
                    return 0;
                }
                return 2;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x000e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(C1944pg c1944pg, int i, int i2, boolean z) {
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        int i3 = Integer.MAX_VALUE;
        for (int videoPixels = 0; videoPixels < maxVideoPixelsToRetain; videoPixels++) {
            C1981qI c1981qIA08 = c1944pg.A08(videoPixels);
            int maxVideoPixelsToRetain = c1981qIA08.A0L;
            if (maxVideoPixelsToRetain > 0) {
                int maxVideoPixelsToRetain2 = c1981qIA08.A0A;
                if (maxVideoPixelsToRetain2 > 0) {
                    int i4 = c1981qIA08.A0L;
                    int maxVideoPixelsToRetain3 = c1981qIA08.A0A;
                    Point pointA09 = A09(z, i, i2, i4, maxVideoPixelsToRetain3);
                    int i5 = c1981qIA08.A0L;
                    int maxVideoPixelsToRetain4 = c1981qIA08.A0A;
                    int i6 = i5 * maxVideoPixelsToRetain4;
                    int i7 = c1981qIA08.A0L;
                    int maxVideoPixelsToRetain5 = pointA09.x;
                    if (i7 >= ((int) (maxVideoPixelsToRetain5 * 0.98f))) {
                        int i8 = c1981qIA08.A0A;
                        int maxVideoPixelsToRetain6 = pointA09.y;
                        if (i8 >= ((int) (maxVideoPixelsToRetain6 * 0.98f)) && i6 < i3) {
                            i3 = i6;
                        }
                    }
                }
            }
        }
        return i3;
    }

    public static /* synthetic */ int A05(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        int iIntValue = num.intValue();
        int iIntValue2 = num2.intValue();
        if (A08[4].length() != 6) {
            throw new RuntimeException();
        }
        A08[1] = "gB7bm57sTKDjvfC8pNahT9wGVNX6TDKL";
        return iIntValue - iIntValue2;
    }

    public static /* synthetic */ int A06(Integer num, Integer num2) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[RETURN] */
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
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A07(java.lang.String r9) {
        /*
            r8 = 0
            if (r9 != 0) goto L4
            return r8
        L4:
            int r0 = r9.hashCode()
            r7 = 1
            r6 = 2
            r5 = 3
            r4 = 4
            switch(r0) {
                case -1851077871: goto L75;
                case -1662735862: goto L4a;
                case -1662541442: goto L38;
                case 1331836730: goto L26;
                case 1599127257: goto L14;
                default: goto Lf;
            }
        Lf:
            r0 = -1
        L10:
            switch(r0) {
                case 0: goto L8b;
                case 1: goto L8a;
                case 2: goto L89;
                case 3: goto L88;
                case 4: goto L87;
                default: goto L13;
            }
        L13:
            return r8
        L14:
            r2 = 300(0x12c, float:4.2E-43)
            r1 = 19
            r0 = 117(0x75, float:1.64E-43)
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 3
            goto L10
        L26:
            r2 = 263(0x107, float:3.69E-43)
            r1 = 9
            r0 = 30
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 4
            goto L10
        L38:
            r2 = 290(0x122, float:4.06E-43)
            r1 = 10
            r0 = 36
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 2
            goto L10
        L4a:
            r3 = 253(0xfd, float:3.55E-43)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C03389h.A08
            r0 = 6
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L8d
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C03389h.A08
            java.lang.String r1 = "cKYBOGEqW486lDdcpu93NQ9TicEen6vk"
            r0 = 1
            r2[r0] = r1
            r1 = 10
            r0 = 9
            java.lang.String r0 = A0J(r3, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 1
            goto L10
        L75:
            r2 = 272(0x110, float:3.81E-43)
            r1 = 18
            r0 = 95
            java.lang.String r0 = A0J(r2, r1, r0)
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto Lf
            r0 = 0
            goto L10
        L87:
            return r7
        L88:
            return r6
        L89:
            return r5
        L8a:
            return r4
        L8b:
            r0 = 5
            return r0
        L8d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C03389h.A07(java.lang.String):int");
    }

    @MetaExoPlayerCustomization("Made public in D13395849")
    public static Point A09(boolean z, int tempViewportWidth, int i, int i2, int i3) {
        if (z) {
            if ((i2 > i3) != (tempViewportWidth > i)) {
                tempViewportWidth = i;
                i = tempViewportWidth;
            }
        }
        if (i2 * i >= i3 * tempViewportWidth) {
            return new Point(tempViewportWidth, C5C.A05(tempViewportWidth * i3, i2));
        }
        return new Point(C5C.A05(i * i2, i3), i);
    }

    private final Pair<C0459El, Integer> A0B(C0462Eo c0462Eo, int[][][] iArr, final C03399i c03399i, final String str) throws AD {
        return A0A(3, c0462Eo, iArr, new InterfaceC0454Eg() { // from class: com.facebook.ads.redexgen.X.nN
            @Override // com.facebook.ads.redexgen.core.InterfaceC0454Eg
            public final List A5F(int i, C1944pg c1944pg, int[] iArr2) {
                return C1795nG.A02(i, c1944pg, c03399i, iArr2, str);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EY
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1795nG.A01((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<C0459El, Integer> A0C(C0462Eo c0462Eo, int[][][] iArr, int[] iArr2, final C03399i c03399i) throws AD {
        final boolean z = false;
        int i = 0;
        while (true) {
            if (i < c0462Eo.A02()) {
                if (2 == c0462Eo.A03(i) && c0462Eo.A07(i).A01 > 0) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return A0A(1, c0462Eo, iArr, new InterfaceC0454Eg() { // from class: com.facebook.ads.redexgen.X.nO
            @Override // com.facebook.ads.redexgen.core.InterfaceC0454Eg
            public final List A5F(int i2, C1944pg c1944pg, int[] iArr3) {
                return this.A01.A0e(c03399i, z, i2, c1944pg, iArr3);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EX
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1801nM.A02((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<C0459El, Integer> A0D(C0462Eo c0462Eo, int[][][] iArr, final int[] iArr2, final C03399i c03399i, final String str) throws AD {
        return A0A(2, c0462Eo, iArr, new InterfaceC0454Eg() { // from class: com.facebook.ads.redexgen.X.nQ
            @Override // com.facebook.ads.redexgen.core.InterfaceC0454Eg
            public final List A5F(int i, C1944pg c1944pg, int[] iArr3) {
                return C1794nF.A06(i, c1944pg, c03399i, iArr3, str, iArr2[i]);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EW
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1794nF.A05((List) obj, (List) obj2);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final C0459El A0E(int i, C1811nW c1811nW, int[][] iArr, C03399i c03399i) throws AD {
        C1944pg c1944pg = null;
        int i2 = 0;
        C0450Ec c0450Ec = null;
        int i3 = 0;
        loop0: while (i3 < c1811nW.A01) {
            C1944pg trackGroup = c1811nW.A05(i3);
            int[] iArr2 = iArr[i3];
            int groupIndex = 0;
            while (true) {
                int i4 = trackGroup.A01;
                int selectedTrackIndex = A08[7].charAt(4);
                if (selectedTrackIndex == 114) {
                    break loop0;
                }
                A08[7] = "eXe48tlcaaFOVphj3tBJsJZ33XViaUIe";
                if (groupIndex < i4) {
                    int i5 = iArr2[groupIndex];
                    int selectedTrackIndex2 = A08[7].charAt(4);
                    if (selectedTrackIndex2 == 114) {
                        throw new RuntimeException();
                    }
                    A08[7] = "FFBXZuvHsKfXoft1igGzNsuMgLJqlaBK";
                    if (A0S(i5, c03399i.A0B)) {
                        C0450Ec trackScore = new C0450Ec(trackGroup.A08(groupIndex), iArr2[groupIndex]);
                        if (c0450Ec != null) {
                            int iA00 = trackScore.compareTo(c0450Ec);
                            String[] strArr = A08;
                            String str = strArr[0];
                            String str2 = strArr[2];
                            int selectedTrackIndex3 = str.charAt(9);
                            if (selectedTrackIndex3 == str2.charAt(9)) {
                                break loop0;
                            }
                            A08[1] = "us6BKPnONaHSk6j2pgBHNNPTLKUclzqr";
                            if (iA00 > 0) {
                                c1944pg = trackGroup;
                                i2 = groupIndex;
                                c0450Ec = trackScore;
                            }
                        }
                    }
                    groupIndex++;
                }
            }
            throw new RuntimeException();
        }
        if (c1944pg == null) {
            return null;
        }
        return new C0459El(c1944pg, i2);
    }

    public static String A0K(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, A0J(250, 3, 75))) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        boolean z;
        synchronized (this.A05) {
            z = this.A01.A08 && !this.A06 && C5C.A02 >= 32 && this.A02 != null && this.A02.A06();
        }
        if (z) {
            A01();
        }
    }

    public static void A0P(C0462Eo c0462Eo, C1940pc c1940pc, C0459El[] c0459ElArr) {
        C0459El c0459El;
        int iA02 = c0462Eo.A02();
        HashMap map = new HashMap();
        for (int i = 0; i < iA02; i++) {
            A0N(c0462Eo.A07(i), c1940pc, map);
        }
        A0N(c0462Eo.A06(), c1940pc, map);
        for (int i2 = 0; i2 < iA02; i2++) {
            int rendererCount = c0462Eo.A03(i2);
            C1942pe c1942pe = (C1942pe) map.get(Integer.valueOf(rendererCount));
            if (c1942pe != null) {
                boolean zIsEmpty = c1942pe.A01.isEmpty();
                if (A08[7].charAt(4) == 'r') {
                    throw new RuntimeException();
                }
                A08[4] = "YbaSeo";
                if (!zIsEmpty && c0462Eo.A07(i2).A04(c1942pe.A00) != -1) {
                    c0459El = new C0459El(c1942pe.A00, AbstractC0365As.A0B(c1942pe.A01));
                } else {
                    c0459El = null;
                }
                c0459ElArr[i2] = c0459El;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0Q(C0462Eo c0462Eo, C03399i c03399i, C0459El[] c0459ElArr) {
        C0459El c0459El;
        int iA02 = c0462Eo.A02();
        for (int i = 0; i < iA02; i++) {
            C1811nW c1811nWA07 = c0462Eo.A07(i);
            if (c03399i.A0S(i, c1811nWA07)) {
                C1796nH c1796nHA0Q = c03399i.A0Q(i, c1811nWA07);
                String[] strArr = A08;
                String str = strArr[6];
                String str2 = strArr[3];
                int rendererIndex = str.length();
                int rendererCount = str2.length();
                if (rendererIndex == rendererCount) {
                    throw new RuntimeException();
                }
                A08[5] = "K8f1XF422sl3cXXm";
                if (c1796nHA0Q != null) {
                    int length = c1796nHA0Q.A03.length;
                    String[] strArr2 = A08;
                    String str3 = strArr2[6];
                    String str4 = strArr2[3];
                    int rendererIndex2 = str3.length();
                    int rendererCount2 = str4.length();
                    if (rendererIndex2 == rendererCount2) {
                        throw new RuntimeException();
                    }
                    A08[4] = "KnBpd5";
                    if (length != 0) {
                        int rendererCount3 = c1796nHA0Q.A00;
                        C1944pg c1944pgA05 = c1811nWA07.A05(rendererCount3);
                        int[] iArr = c1796nHA0Q.A03;
                        int rendererIndex3 = c1796nHA0Q.A02;
                        c0459El = new C0459El(c1944pgA05, iArr, rendererIndex3);
                    } else {
                        c0459El = null;
                    }
                    c0459ElArr[i] = c0459El;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
    
        if (r4 != 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r4 != 2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        if (r3 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        if (A0W(r12[r7], r11.A07(r7), r3) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        if (r4 != 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r9 == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (r8 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r4 != 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0088, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0R(C0462Eo c0462Eo, int[][][] iArr, C03037s[] c03037sArr, InterfaceC1793nE[] interfaceC1793nEArr) {
        int i = -1;
        int i2 = -1;
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int i5 = c0462Eo.A02();
            int tunnelingVideoRendererIndex = A08[4].length();
            if (tunnelingVideoRendererIndex == 6) {
                A08[1] = "NZY9D9dgjYLNZ0XYpF4W2GrX5uVEwVhV";
                if (i4 >= i5) {
                    break;
                }
                int rendererType = c0462Eo.A03(i4);
                InterfaceC1793nE interfaceC1793nE = interfaceC1793nEArr[i4];
                String[] strArr = A08;
                String str = strArr[0];
                String str2 = strArr[2];
                int tunnelingVideoRendererIndex2 = str.charAt(9);
                int tunnelingAudioRendererIndex = str2.charAt(9);
                if (tunnelingVideoRendererIndex2 != tunnelingAudioRendererIndex) {
                    A08[4] = "nPMicF";
                } else {
                    String[] strArr2 = A08;
                    strArr2[6] = "5F5ko3NIDU1YMXmZZUDVXdSE";
                    strArr2[3] = "1c60xx4jFCOb1nSxKeVAoj10cRAS07b7";
                }
            } else {
                throw new RuntimeException();
            }
            i4++;
        }
        int tunnelingAudioRendererIndex2 = (i == -1 || i2 == -1) ? 0 : 1;
        if ((i3 & tunnelingAudioRendererIndex2) != 0) {
            C03037s c03037s = new C03037s(true);
            c03037sArr[i] = c03037s;
            c03037sArr[i2] = c03037s;
        }
    }

    @MetaExoPlayerCustomization("Made public for customization on DashManifestHelper")
    public static boolean A0S(int i, boolean z) {
        int iA03 = AbstractC02937i.A03(i);
        return iA03 == 4 || (z && iA03 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0T(C1981qI c1981qI) {
        boolean z;
        synchronized (this.A05) {
            z = !this.A01.A08 || this.A06 || c1981qI.A06 <= 2 || (A0U(c1981qI) && (C5C.A02 < 32 || this.A02 == null || !this.A02.A06())) || (C5C.A02 >= 32 && this.A02 != null && this.A02.A06() && this.A02.A04() && this.A02.A05() && this.A02.A07(this.A00, c1981qI));
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0U(C1981qI c1981qI) {
        byte b;
        if (c1981qI.A0W == null) {
            return false;
        }
        String str = c1981qI.A0W;
        switch (str.hashCode()) {
            case -2123537834:
                b = !str.equals(A0J(236, 14, 79)) ? (byte) -1 : (byte) 2;
                break;
            case 187078296:
                if (str.equals(A0J(208, 9, 92))) {
                    b = 0;
                    break;
                }
                break;
            case 187078297:
                if (str.equals(A0J(217, 9, 66))) {
                    b = 3;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(A0J(226, 10, 100))) {
                    b = 1;
                    break;
                }
                break;
        }
        switch (b) {
        }
        return false;
    }

    public static boolean A0W(int[][] iArr, C1811nW c1811nW, InterfaceC1793nE interfaceC1793nE) {
        if (interfaceC1793nE == null) {
            return false;
        }
        int iA04 = c1811nW.A04(interfaceC1793nE.A9L());
        for (int i = 0; i < interfaceC1793nE.length(); i++) {
            int trackGroupIndex = AbstractC02937i.A05(iArr[iA04][interfaceC1793nE.A8H(i)]);
            if (trackGroupIndex != 32) {
                return false;
            }
        }
        return true;
    }

    private final C0459El[] A0X(C0462Eo c0462Eo, int[][][] iArr, int[] iArr2, C03399i c03399i) throws AD {
        String str;
        int iA02 = c0462Eo.A02();
        C0459El[] c0459ElArr = new C0459El[iA02];
        Pair<C0459El, Integer> pairA0C = A0C(c0462Eo, iArr, iArr2, c03399i);
        if (pairA0C != null) {
            Object obj = pairA0C.second;
            String[] strArr = A08;
            String str2 = strArr[0];
            String str3 = strArr[2];
            int iCharAt = str2.charAt(9);
            int rendererCount = str3.charAt(9);
            if (iCharAt == rendererCount) {
                throw new RuntimeException();
            }
            A08[7] = "yBKbxgl1qoYBYNtasAVV61g1RQWhRN9O";
            c0459ElArr[((Integer) obj).intValue()] = (C0459El) pairA0C.first;
        }
        if (pairA0C == null) {
            str = null;
        } else {
            C1944pg c1944pg = ((C0459El) pairA0C.first).A01;
            int rendererCount2 = ((C0459El) pairA0C.first).A02[0];
            str = c1944pg.A08(rendererCount2).A0V;
        }
        Pair<C0459El, Integer> pairA0D = A0D(c0462Eo, iArr, iArr2, c03399i, str);
        if (pairA0D != null) {
            c0459ElArr[((Integer) pairA0D.second).intValue()] = (C0459El) pairA0D.first;
        }
        Pair<C0459El, Integer> pairA0B = A0B(c0462Eo, iArr, c03399i, str);
        if (pairA0B != null) {
            c0459ElArr[((Integer) pairA0B.second).intValue()] = (C0459El) pairA0B.first;
        }
        for (int i = 0; i < iA02; i++) {
            int i2 = c0462Eo.A03(i);
            if (i2 != 2 && i2 != 1) {
                String[] strArr2 = A08;
                String str4 = strArr2[0];
                String str5 = strArr2[2];
                int iCharAt2 = str4.charAt(9);
                int rendererCount3 = str5.charAt(9);
                if (iCharAt2 == rendererCount3) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A08;
                strArr3[6] = "1xsmyE1OdjkvrsbXr4cEFZBV";
                strArr3[3] = "D4xPicyrc2caIP01Cw6NBhV2pRXBVsmG";
                if (i2 != 3) {
                    c0459ElArr[i] = A0E(i2, c0462Eo.A07(i), iArr[i], c03399i);
                }
            }
        }
        return c0459ElArr;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0470Ew
    public final boolean A0Y() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1792nD
    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "final removed in D35162315")
    public final Pair<C03037s[], InterfaceC1793nE[]> A0d(C0462Eo c0462Eo, int[][][] iArr, int[] iArr2, C1829no c1829no, Timeline timeline) throws Throwable {
        C03399i c03399i;
        synchronized (this.A05) {
            try {
                c03399i = this.A01;
                if (c03399i.A08 && C5C.A02 >= 32 && this.A02 != null) {
                    this.A02.A03(this, (Looper) AbstractC02053y.A02(Looper.myLooper()));
                }
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        int iA02 = c0462Eo.A02();
        C0459El[] c0459ElArrA0X = A0X(c0462Eo, iArr, iArr2, c03399i);
        A0P(c0462Eo, c03399i, c0459ElArrA0X);
        A0Q(c0462Eo, c03399i, c0459ElArrA0X);
        for (int rendererCount = 0; rendererCount < iA02; rendererCount++) {
            int iA03 = c0462Eo.A03(rendererCount);
            if (c03399i.A0R(rendererCount) || c03399i.A0H.contains(Integer.valueOf(iA03))) {
                c0459ElArrA0X[rendererCount] = null;
            }
        }
        InterfaceC1793nE[] interfaceC1793nEArrA5b = this.A04.A5b(c0459ElArrA0X, A00(), c1829no, timeline);
        C03037s[] c03037sArr = new C03037s[iA02];
        for (int i = 0; i < iA02; i++) {
            c03037sArr[i] = !(c03399i.A0R(i) || c03399i.A0H.contains(Integer.valueOf(c0462Eo.A03(i)))) && (c0462Eo.A03(i) == -2 || interfaceC1793nEArrA5b[i] != null) ? C03037s.A01 : null;
        }
        if (c03399i.A0D) {
            A0R(c0462Eo, iArr, c03037sArr, interfaceC1793nEArrA5b);
        }
        return Pair.create(c03037sArr, interfaceC1793nEArrA5b);
    }

    public final /* synthetic */ BP A0e(C03399i c03399i, boolean z, int i, C1944pg c1944pg, int[] iArr) {
        return C1801nM.A03(i, c1944pg, c03399i, iArr, z, new InterfaceC1652kj() { // from class: com.facebook.ads.redexgen.X.nP
            @Override // com.facebook.ads.redexgen.core.InterfaceC1652kj
            public final boolean A4C(Object obj) {
                return this.A00.A0T((C1981qI) obj);
            }
        });
    }
}
