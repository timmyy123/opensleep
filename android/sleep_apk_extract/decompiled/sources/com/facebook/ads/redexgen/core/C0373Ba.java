package com.facebook.ads.redexgen.core;

import android.media.MediaCodecInfo;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ba, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Deprecated
public final class C0373Ba {
    public static int A00;
    public static byte[] A01;
    public static String[] A02 = {"eqdzSiIdqnT3hCSsTENYLmZ4", "qLAEi2WvCJu9wjJ", "toce", "QmOxXIzlvE53d2X", "WAyVnYX8HOamSHc7hCznsAV7J1o4yjh4", "2Jg1vBhmBkCi6YoALSajSHGhL27exhse", "FyqWibsIBjeEGSoGFPMxHwupdmiGrYAl", "dJbg5x7m2zG"};
    public static final HashMap<BW, List<B3>> A03;
    public static final Pattern A04;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A00() throws BX {
        int i = A00;
        String[] strArr = A02;
        if (strArr[0].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A02[7] = "ayn8";
        if (i == -1) {
            int iMax = 0;
            B3 b3A0J = A0J(A0N(1756, 9, 19), false, false);
            if (b3A0J != null) {
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : b3A0J.A0V()) {
                    iMax = Math.max(A03(codecProfileLevel.level), iMax);
                }
                iMax = Math.max(iMax, C5C.A02 >= 21 ? 345600 : 172800);
            }
            A00 = iMax;
        }
        return A00;
    }

    public static String A0N(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 13);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013c A[Catch: Exception -> 0x01b2, PHI: r0
      0x013c: PHI (r0v18 java.lang.String) = (r0v16 java.lang.String), (r0v22 java.lang.String) binds: [B:66:0x013a, B:63:0x012d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #7 {Exception -> 0x01b2, blocks: (B:3:0x0014, B:5:0x002a, B:8:0x0035, B:11:0x0040, B:59:0x0101, B:71:0x0170, B:72:0x01aa, B:67:0x013c, B:69:0x0142), top: B:93:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.facebook.ads.redexgen.X.BX.<init>(java.lang.Throwable, com.facebook.ads.redexgen.X.BV):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:298)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:197)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
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
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.ArrayList<com.facebook.ads.redexgen.core.B3> A0Q(com.facebook.ads.redexgen.core.BW r23, com.facebook.ads.redexgen.core.BY r24) throws com.facebook.ads.redexgen.core.BX {
        /*
            Method dump skipped, instruction units count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0373Ba.A0Q(com.facebook.ads.redexgen.X.BW, com.facebook.ads.redexgen.X.BY):java.util.ArrayList");
    }

    public static void A0S() {
        A01 = new byte[]{-121, -113, 94, 102, -92, -97, -89, -86, -93, -94, 94, -78, -83, 94, -81, -77, -93, -80, -73, 94, -95, -97, -82, -97, -96, -89, -86, -89, -78, -89, -93, -79, 103, 56, -111, -125, -92, -42, -42, -40, -48, -52, -47, -54, -99, -125, 65, -122, 120, 118, -120, -123, 120, -72, -3, 1, -72, 66, 66, -90, -89, 85, 87, -84, -81, 111, 115, 65, 70, -115, -109, -98, -91, -95, -87, 99, 108, -73, -89, -90, 87, 87, 65, 66, 68, 70, 103, -116, -120, -116, -85, -101, -127, -127, -125, -124, -91, -93, -81, -92, -91, -78, 92, 74, 78, 73, 77, 119, 101, 105, 100, 105, 121, 103, 108, 102, 106, -113, 125, -126, 124, -127, -97, -110, -110, -116, -114, -70, -83, -83, -89, -86, -59, -72, -72, -78, -72, 90, 77, 77, 72, 77, -72, -66, -59, -74, -74, -72, -71, -38, -40, -28, -39, -38, -25, -60, -54, -47, -62, -50, -45, -49, -61, -59, -26, -28, -16, -27, -26, -13, -73, -67, -60, -63, -60, -89, -72, -39, -41, -29, -40, -39, -26, -51, -45, -38, -32, -7, -4, -20, -13, -3, -50, -17, -19, -7, -18, -17, -4, -81, -54, -46, -43, -50, -51, -119, -35, -40, -119, -38, -34, -50, -37, -30, -119, -52, -40, -51, -50, -52, -119, -63, -86, -85, -87, 103, 80, 81, 82, -68, -91, -87, -92, -119, 114, 118, 116, -58, -81, -77, -76, -78, -101, -94, -102, 88, 65, 72, 67, -128, 105, 112, 110, -95, -116, -119, -79, -97, -103, -117, 121, 118, 114, 99, 90, -93, -108, -114, -84, -79, -107, -77, -70, -69, -66, -75, -70, -77, 108, -71, -83, -72, -78, -69, -66, -71, -79, -80, 108, -115, -94, 125, 108, -81, -69, -80, -79, -81, 108, -65, -64, -66, -75, -70, -77, -122, 108, 120, -106, -99, -98, -95, -104, -99, -106, 79, -100, -112, -101, -107, -98, -95, -100, -108, -109, 79, 112, -123, 114, 79, -110, -98, -109, -108, -110, 79, -94, -93, -95, -104, -99, -106, 105, 79, -85, -55, -48, -47, -44, -53, -48, -55, -126, -49, -61, -50, -56, -47, -44, -49, -57, -58, -126, -90, -47, -50, -60, -37, -126, -72, -53, -43, -53, -47, -48, -126, -59, -47, -58, -57, -59, -126, -43, -42, -44, -53, -48, -55, -100, -126, -122, -92, -85, -84, -81, -90, -85, -92, 93, -86, -98, -87, -93, -84, -81, -86, -94, -95, 93, -123, -126, -109, -128, 93, -96, -84, -95, -94, -96, 93, -80, -79, -81, -90, -85, -92, 119, 93, -71, -41, -34, -33, -30, -39, -34, -41, -112, -35, -47, -36, -42, -33, -30, -35, -43, -44, -112, -67, -64, -92, -79, -112, -45, -33, -44, -43, -45, -112, -29, -28, -30, -39, -34, -41, -86, -112, 90, 120, 127, -128, -125, 122, 127, 120, 49, 126, 114, 125, 119, -128, -125, 126, 118, 117, 49, 103, 97, 74, 49, 116, -128, 117, 118, 116, 49, -124, -123, -125, 122, 127, 120, 75, 49, -112, 117, 118, 116, -53, -80, -79, -78, -65, -92, -88, -93, -63, -90, -86, -88, -124, 105, 109, 110, -92, -119, -112, -120, -64, -91, -84, -89, 108, 81, 88, 86, -66, -91, -94, -61, -86, -83, -33, -98, -120, -126, -44, -66, -69, -96, -115, -124, -119, 118, 112, 92, 95, 66, 83, 116, 114, 126, 115, 116, -127, -105, -81, -82, -77, -85, -115, -71, -82, -81, -83, -106, -77, -67, -66, 106, -117, -102, -109, 106, -82, -77, -82, -72, 113, -66, 106, -74, -77, -67, -66, 106, -67, -81, -83, -65, -68, -81, 106, -82, -81, -83, -71, -82, -81, -68, 106, -80, -71, -68, -124, 106, -86, -62, -63, -58, -66, -96, -52, -63, -62, -64, -78, -47, -58, -55, -85, -87, -76, -118, -95, -44, -43, -54, -53, -49, -118, -99, -99, -97, -118, -96, -63, -65, -53, -64, -63, -50, -40, -42, -31, -73, -42, -36, -73, -47, -50, -33, -52, -51, -33, -73, -51, -18, -20, -8, -19, -18, -5, -48, -50, -39, -81, -50, -43, -52, -81, -62, -42, -59, -54, -48, -81, -59, -58, -60, -48, -59, -58, -45, -81, -62, -62, -60, -68, -70, -59, -101, -70, -63, -72, -101, -82, -62, -79, -74, -68, -101, -79, -78, -80, -68, -79, -78, -65, -101, -79, -64, -67, -82, -80, -96, -120, -122, -111, 103, -122, -115, -124, 103, 122, -114, 125, -126, -120, 103, 125, 126, 124, -120, 125, 126, -117, 103, -117, 122, -112, -102, -104, -93, 121, -99, -97, -106, 121, -63, -76, -81, -80, -70, 121, -81, -80, -82, -70, -81, -80, -67, -127, 127, -118, 96, -123, 119, 117, 96, 127, -126, 101, 96, 118, -105, -107, -95, -106, -105, -92, -46, -48, -37, -79, -42, -56, -58, -79, -28, -28, -26, -79, -25, -24, -26, -82, -84, -73, -115, -78, -92, -94, -115, -52, -49, -110, -115, -61, -60, -62, -126, -128, -117, 97, -122, 120, 118, 97, -87, -93, 107, 97, -105, -104, -106, -119, -121, -110, 104, -100, -84, -99, -89, 104, -101, -81, -98, -93, -87, 104, -89, -86, 109, 104, -98, -97, -99, -87, -98, -97, -84, -124, -126, -115, 99, -100, -92, -92, -100, -95, -102, -86, -88, -77, -119, -62, -54, -54, -62, -57, -64, -119, -51, -68, -46, -119, -65, -64, -66, -54, -65, -64, -51, -84, -86, -75, -117, -55, -60, -62, -117, -66, -64, -112, -117, -63, -62, -64, -52, -63, -62, -49, -72, -74, -63, -105, -43, -48, -50, -105, -54, -43, -54, -52, -105, -51, -50, -52, -40, -51, -50, -37, -114, -116, -105, 109, -85, -90, -92, 109, -91, -85, -96, -94, 109, -93, -92, -94, -82, -93, -92, -79, 108, 106, 117, 75, -114, -128, -116, -118, 75, 126, -110, -127, -122, -116, 75, -127, -126, -128, -116, -127, -126, -113, 75, 126, 126, -128, 107, 105, 116, 74, -115, 127, -117, -119, 74, 125, -111, -128, -123, -117, 74, -128, -127, 127, -117, -128, -127, -114, 
        74, -119, -116, 79, -75, -77, -66, -108, -41, -55, -43, -45, -108, -36, -49, -54, -53, -43, -108, -54, -53, -55, -43, -54, -53, -40, -108, -36, -42, -98, 114, 112, 123, 81, -108, -105, -116, 81, -124, -104, -121, -116, -110, 81, -121, -120, -122, -110, -121, -120, -107, 81, -119, -113, -124, -122, -105, -107, -96, 118, -70, -83, -87, -76, -68, -83, -77, 118, -66, -79, -84, -83, -73, 118, -84, -83, -85, -73, -84, -83, -70, 118, -68, -67, -74, -74, -83, -76, -83, -84, -80, -105, -102, -118, 116, 119, 123, -114, -40, -56, -78, -75, -70, -52, -45, -61, -42, -77, -79, -121, -125, 97, 100, 102, 121, -112, -88, -90, -83, -83, -90, -85, -92, 93, -96, -84, -95, -94, -96, 93, -50, -25, -28, -25, -24, -16, -25, -103, -70, -49, -86, -103, -37, -30, -19, -103, -35, -34, -23, -19, -31, -77, -103, -78, -53, -56, -53, -52, -44, -53, 125, -98, -77, -114, 125, -55, -62, -45, -62, -55, -105, 125, -41, -16, -19, -16, -15, -7, -16, -94, -61, -40, -77, -94, -14, -12, -15, -24, -21, -18, -25, -68, -94, -124, -99, -102, -99, -98, -90, -99, 79, 112, -123, 114, 79, -101, -108, -91, -108, -101, 105, 79, -84, -59, -62, -59, -58, -50, -59, 119, -104, -83, -102, 119, -57, -55, -58, -67, -64, -61, -68, -111, 119, -111, -86, -89, -86, -85, -77, -86, 92, -128, -85, -88, -98, -75, 92, -110, -91, -81, -91, -85, -86, 92, -88, -95, -78, -95, -88, 92, -81, -80, -82, -91, -86, -93, 118, 92, 100, 125, 122, 125, 126, -122, 125, 47, 83, 126, 123, 113, -120, 47, 101, 120, -126, 120, 126, 125, 47, 127, -127, 126, 117, 120, 123, 116, 47, -126, -125, -127, 120, 125, 118, 73, 47, -75, -50, -53, -50, -49, -41, -50, -128, -88, -91, -74, -93, -128, -52, -59, -42, -59, -52, -128, -45, -44, -46, -55, -50, -57, -102, -128, -52, -27, -30, -27, -26, -18, -27, -105, -65, -68, -51, -70, -105, -25, -23, -26, -35, -32, -29, -36, -105, -22, -21, -23, -32, -27, -34, -79, -105, -93, -68, -71, -68, -67, -59, -68, 110, -92, -98, -121, 110, -70, -77, -60, -77, -70, -120, 110, -101, -76, -79, -76, -75, -67, -76, 102, -100, -106, 127, 102, -74, -72, -75, -84, -81, -78, -85, -128, 102, 112, -127, 121, -121, -123, -127, -44, -90, -37, -39, -63, -68, -91, -39, -31, -88, -90, -95, -89, 125, 118, -36, -19, -34, -87, 122, -114, 125, -126, -120, 72, 122, 124, 76, -38, -18, -35, -30, -24, -88, -38, -27, -38, -36, 116, -120, 119, 124, -126, 66, 120, 116, 118, 70, -48, -28, -45, -40, -34, -98, -44, -48, -46, -94, -100, -39, -34, -46, -96, -76, -93, -88, -82, 110, -91, -85, -96, -94, 120, -116, 123, -128, -122, 70, -125, 126, 68, 120, 122, 74, -125, -105, -122, -117, -111, 81, -113, -110, 86, -125, 79, -114, -125, -106, -113, -54, -34, -51, -46, -40, -104, -37, -54, -32, -46, -26, -43, -38, -32, -96, -23, -98, -35, -40, -98, -46, -35, -46, -44, -37, -17, -34, -29, -23, -87, -14, -89, -26, -31, -89, -32, -26, -37, -35, -118, -97, 89, 90, 127, -108, -127, 79, 126, -109, -128, 79, -82, 125, 121, -101, 106, 102, -103, -90, -100, -86, -89, -95, -100, -59, -108, -112, -61, -48, -58, -44, -47, -53, -58, -112, 114, 65, 61, 118, 126, 126, 118, 123, 116, 61, 120, 70, -39, -31, -19, -22, -17, -19, -19, -96, -99, -82, 105, -21, -7, -26, -76, -33, -37, -31, -23, -38, -82, -94, -77, -86, -81, -90, -83, -75, -90, -94, -75, -75, -113, -110, 86, -125, -58, -60, -49, -123, -54, -56, -45, -119, -63, -63, -56, -53, -64, -62, -119, -88, -90, -79, 103, -96, -88, -88, -96, -91, -98, 103, -66, -68, -57, 125, -64, -78, -66, -68, 125, -59, -72, -77, -76, -66, 125, -77, -76, -78, -66, -77, -76, -63, 125, -73, -76, -59, -78, -62, -58, -59, -77, -76, -78, -100, -102, -91, 91, -96, -110, -112, 91, -10, -8, -11, -6, -11, -5, -116, 122, -122, -116, -114, -121, -128, -109, -127, -114, -108, -113, -109, -8, -22, -24, -6, -9, -22, -78, -11, -15, -26, -2, -25, -26, -24, -16, -119, 123, -120, -120, 119, -124, -123, -69, 119, -82, -81, -88, -88, -97, -90, -97, -98, 103, -86, -90, -101, -77, -100, -101, -99, -91, -106, -119, -124, -123, -113, 79, -127, -106, -125, -99, -112, -117, -116, -106, 86, -117, -106, -109, -119, -96, 84, -99, -112, -102, -112, -106, -107, -77, -90, -95, -94, -84, 108, -95, -77, -100, -91, -94, -77, -96, -101, -114, -119, -118, -108, 84, -115, -118, -101, -120, -66, -79, -84, -83, -73, 119, -80, -83, -66, -85, -84, -66, -28, -41, -38, -38, -45, -107, -120, -117, -117, -124, -126, 81, -64, -77, -74, -74, -81, -70, -74, -65, -67, -78, -84, 108, 117, -64, -85, -76, -78, -70, -85, -43, -64, -51, -54, -63, -57, -49, -64, -52, -73, -60, -63, -66, -58, -73};
    }

    static {
        A0S();
        A04 = Pattern.compile(A0N(1409, 10, 112));
        A03 = new HashMap<>();
        A00 = -1;
    }

    public static int A01(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                if (A02[7].length() == 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[1] = "p3tScLodvmBhgJu";
                strArr[3] = "blAckLRsjuERKNr";
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return Utility.DEFAULT_STREAM_BUFFER_SIZE;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                String[] strArr2 = A02;
                if (strArr2[6].charAt(8) == strArr2[5].charAt(8)) {
                    A02[7] = "bdr4r1uDMPeXB3s0e5pOX5Q";
                    return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                }
                break;
            case 17:
                return 131072;
            case 18:
                String[] strArr3 = A02;
                if (strArr3[6].charAt(8) != strArr3[5].charAt(8)) {
                    String[] strArr4 = A02;
                    strArr4[6] = "34IRfUzRBRFF7aBglEcwMApXZqeFGI1m";
                    strArr4[5] = "iRGVlhZlB1b37DNJ3kG6hrLab0t0wQjp";
                    return 262144;
                }
                String[] strArr5 = A02;
                strArr5[0] = "eT6IL44S7u9o4A5QFAcxcvIY";
                strArr5[2] = "bWAi";
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                String[] strArr6 = A02;
                if (strArr6[6].charAt(8) != strArr6[5].charAt(8)) {
                    A02[4] = "Kx02KfDWNZB3bbiKdLxxGACkAkNM6rJP";
                    return 2097152;
                }
                A02[4] = "WnzQHL4oKpbMUVBkEywLAA92oYxlOTj8";
                return 2097152;
            case 22:
                if (A02[4].charAt(21) == 'A') {
                    A02[4] = "cAiGKOliFB77vtIZojZGlA8hvOCkEVbR";
                    return 4194304;
                }
                break;
            case 23:
                return 8388608;
            default:
                return -1;
        }
        throw new RuntimeException();
    }

    public static int A02(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            case 20:
                return 32;
            case 21:
                return 64;
            case 22:
                return 128;
            case 30:
                return 256;
            case 31:
                return 512;
            case 32:
                return 1024;
            case 40:
                return 2048;
            case 41:
                return 4096;
            case 42:
                return Utility.DEFAULT_STREAM_BUFFER_SIZE;
            case 50:
                return 16384;
            case 51:
                String[] strArr = A02;
                if (strArr[1].length() != strArr[3].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[1] = "Dd2HPoEYdkjLRr8";
                strArr2[3] = "8RMIphYW42mwAMu";
                return 32768;
            case 52:
                return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
            default:
                return -1;
        }
    }

    public static int A03(int i) {
        switch (i) {
            case 1:
            case 2:
                return 25344;
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                String[] strArr = A02;
                if (strArr[0].length() == strArr[2].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[1] = "3QcVs4uE13o5U89";
                strArr2[3] = "HwwNiq3rR5E2ArP";
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST /* 65536 */:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    public static int A04(int i) {
        switch (i) {
            case 66:
                return 1;
            case 77:
                return 2;
            case 88:
                return 4;
            case 100:
                return 8;
            case 110:
                return 16;
            case 122:
                return 32;
            case 244:
                return 64;
            default:
                return -1;
        }
    }

    public static int A05(int i) {
        switch (i) {
            case 1:
                if (A02[4].charAt(21) != 'A') {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[0] = "QMC9ZT5BEMY9TcRggpPTke3A";
                strArr[2] = "gCyl";
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                String[] strArr2 = A02;
                if (strArr2[6].charAt(8) != strArr2[5].charAt(8)) {
                    throw new RuntimeException();
                }
                A02[4] = "69A91wQXEtxdKe6VEWAWvAWn2bPjhSLd";
                return 5;
            case 6:
                return 6;
            case 17:
                return 17;
            case 20:
                return 20;
            case 23:
                return 23;
            case 29:
                return 29;
            case 39:
                return 39;
            case 42:
                return 42;
            default:
                return -1;
        }
    }

    public static int A06(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 2;
            case 20:
                return 4;
            case 21:
                return 8;
            case 30:
                return 16;
            case 31:
                return 32;
            case 40:
                return 64;
            case 41:
                if (A02[7].length() == 25) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[1] = "FYHyz6Jn9nffJKB";
                strArr[3] = "LZRAC8LId4dogw6";
                return 128;
            case 50:
                return 256;
            case 51:
                return 512;
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return Utility.DEFAULT_STREAM_BUFFER_SIZE;
            default:
                return -1;
        }
    }

    public static int A07(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                if (A02[7].length() == 25) {
                    throw new RuntimeException();
                }
                A02[4] = "pIa0SKSMXaKd1ZRZCUAsSAHaUimoLOpx";
                return 8;
            default:
                String[] strArr = A02;
                if (strArr[0].length() == strArr[2].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[0] = "vDav2EVX30wYgrXK4P9ZX6kx";
                strArr2[2] = "QW4Z";
                return -1;
        }
    }

    public static /* synthetic */ int A08(B3 b3) {
        String str = b3.A03;
        String name = A0N(861, 10, 40);
        if (str.startsWith(name)) {
            return 1;
        }
        String name2 = A0N(1560, 10, 43);
        if (str.startsWith(name2)) {
            return 1;
        }
        if (C5C.A02 >= 26) {
            return 0;
        }
        String name3 = A0N(725, 25, 44);
        if (str.equals(name3)) {
            return -1;
        }
        return 0;
    }

    public static /* synthetic */ int A09(B3 b3) {
        return b3.A03.startsWith(A0N(861, 10, 40)) ? 1 : 0;
    }

    public static /* synthetic */ int A0A(BZ bz, Object obj, Object obj2) {
        return bz.A8w(obj2) - bz.A8w(obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010b  */
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
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> A0B(com.facebook.ads.redexgen.core.C1981qI r8) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0373Ba.A0B(com.facebook.ads.redexgen.X.qI):android.util.Pair");
    }

    public static Pair<Integer, Integer> A0C(String str, String[] strArr) {
        int length = strArr.length;
        String strA0N = A0N(428, 38, 99);
        String strA0N2 = A0N(615, 14, 80);
        if (length != 3) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
            return null;
        }
        try {
            int objectTypeIndication = Integer.parseInt(strArr[1], 16);
            if (A0N(1491, 15, 21).equals(C3J.A05(objectTypeIndication))) {
                int objectTypeIndication2 = Integer.parseInt(strArr[2]);
                int iA05 = A05(objectTypeIndication2);
                if (iA05 != -1) {
                    return new Pair<>(Integer.valueOf(iA05), 0);
                }
            }
        } catch (NumberFormatException unused) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
        }
        return null;
    }

    public static Pair<Integer, Integer> A0D(String str, String[] strArr) {
        int i;
        int i2;
        int length = strArr.length;
        String strA0N = A0N(307, 37, 34);
        String strA0N2 = A0N(615, 14, 80);
        if (length < 2) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i2 = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                i = Integer.parseInt(strArr[1]);
                i2 = Integer.parseInt(strArr[2]);
            } else {
                AbstractC02134g.A07(strA0N2, strA0N + str);
                return null;
            }
            int iA04 = A04(i);
            if (iA04 == -1) {
                AbstractC02134g.A07(strA0N2, A0N(1212, 21, 74) + i);
                return null;
            }
            int levelInteger = A02(i2);
            if (levelInteger == -1) {
                AbstractC02134g.A07(strA0N2, A0N(1193, 19, 34) + i2);
                return null;
            }
            return new Pair<>(Integer.valueOf(iA04), Integer.valueOf(levelInteger));
        } catch (NumberFormatException unused) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
            return null;
        }
    }

    public static Pair<Integer, Integer> A0E(String str, String[] strArr) {
        int length = strArr.length;
        String strA0N = A0N(344, 46, 85);
        String levelString = A0N(615, 14, 80);
        if (length < 3) {
            AbstractC02134g.A07(levelString, strA0N + str);
            return null;
        }
        Matcher matcher = A04.matcher(strArr[1]);
        if (!matcher.matches()) {
            AbstractC02134g.A07(levelString, strA0N + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer profile = A0L(strGroup);
        if (profile == null) {
            AbstractC02134g.A07(levelString, A0N(1268, 37, 2) + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numA0K = A0K(str2);
        if (numA0K == null) {
            AbstractC02134g.A07(levelString, A0N(1233, 35, 47) + str2);
            return null;
        }
        return new Pair<>(profile, numA0K);
    }

    public static Pair<Integer, Integer> A0F(String str, String[] strArr) {
        int length = strArr.length;
        String strA0N = A0N(466, 37, 4);
        String strA0N2 = A0N(615, 14, 80);
        if (length < 3) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int profile = A07(i);
            if (profile == -1) {
                AbstractC02134g.A07(strA0N2, A0N(1380, 21, 57) + i);
                return null;
            }
            int profileInteger = A06(i2);
            if (profileInteger == -1) {
                AbstractC02134g.A07(strA0N2, A0N(1361, 19, 65) + i2);
                return null;
            }
            return new Pair<>(Integer.valueOf(profile), Integer.valueOf(profileInteger));
        } catch (NumberFormatException unused) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> A0G(String str, String[] strArr, ColorInfo colorInfo) {
        int bitDepthInteger;
        int length = strArr.length;
        String strA0N = A0N(270, 37, 63);
        String strA0N2 = A0N(615, 14, 80);
        if (length < 4) {
            AbstractC02134g.A07(strA0N2, ((String) strA0N) + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2].substring(0, 2));
            strA0N = Integer.parseInt(strArr[3]);
            if (i != 0) {
                AbstractC02134g.A07(strA0N2, A0N(1172, 21, 117) + i);
                return null;
            }
            if (strA0N != 8 && strA0N != 10) {
                AbstractC02134g.A07(strA0N2, A0N(1130, 23, 108) + ((int) strA0N));
                return null;
            }
            if (strA0N == 8) {
                bitDepthInteger = 1;
            } else if (colorInfo != null) {
                byte[] bArr = colorInfo.A04;
                int levelInteger = A02[4].charAt(21);
                if (levelInteger != 65) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[0] = "3Naka6lMBkjhse4CHD6m4SHW";
                strArr2[2] = "4qp9";
                if (bArr == null) {
                    int levelInteger2 = colorInfo.A03;
                    if (levelInteger2 != 7) {
                        int levelInteger3 = colorInfo.A03;
                        if (levelInteger3 != 6) {
                            bitDepthInteger = 2;
                        }
                    }
                }
                bitDepthInteger = 4096;
            }
            int levelInteger4 = A01(i2);
            if (levelInteger4 == -1) {
                AbstractC02134g.A07(strA0N2, A0N(1153, 19, 80) + i2);
                return null;
            }
            return new Pair<>(Integer.valueOf(bitDepthInteger), Integer.valueOf(levelInteger4));
        } catch (NumberFormatException unused) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
            return null;
        }
    }

    public static Pair<Integer, Integer> A0H(String str, String[] strArr, ColorInfo colorInfo) {
        int i;
        int length = strArr.length;
        String strA0N = A0N(390, 38, 48);
        String strA0N2 = A0N(615, 14, 80);
        if (length < 4) {
            AbstractC02134g.A07(strA0N2, strA0N + str);
            return null;
        }
        Matcher matcher = A04.matcher(strArr[1]);
        boolean zMatches = matcher.matches();
        if (A02[7].length() != 25) {
            String[] strArr2 = A02;
            strArr2[6] = "KQD5T9TnBB7A1Qau37dPwA8fp0YnC9XP";
            strArr2[5] = "pnb4d0x2BWoBz7rcvfU2b1k7Wl63lPA1";
            if (!zMatches) {
                AbstractC02134g.A07(strA0N2, strA0N + str);
                return null;
            }
            String strGroup = matcher.group(1);
            if (A0N(77, 1, 121).equals(strGroup)) {
                i = 1;
            } else if (A0N(86, 1, 40).equals(strGroup)) {
                if (colorInfo != null && colorInfo.A03 == 6) {
                    i = 4096;
                } else {
                    i = 2;
                }
            } else {
                AbstractC02134g.A07(strA0N2, A0N(1332, 29, 106) + strGroup);
                return null;
            }
            String[] strArr3 = A02;
            if (strArr3[6].charAt(8) == strArr3[5].charAt(8)) {
                A02[7] = "4AE";
                String profileString = strArr[3];
                Integer numA0M = A0M(profileString);
                if (numA0M == null) {
                    AbstractC02134g.A07(strA0N2, A0N(1305, 27, 83) + profileString);
                    return null;
                }
                return new Pair<>(Integer.valueOf(i), numA0M);
            }
        }
        throw new RuntimeException();
    }

    public static B3 A0I() throws BX {
        return A0J(A0N(1506, 9, 92), false, false);
    }

    public static B3 A0J(String str, boolean z, boolean z2) throws BX {
        List<B3> listA0R = A0R(str, z, z2);
        if (listA0R.isEmpty()) {
            return null;
        }
        return listA0R.get(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014 A[RETURN] */
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
    public static java.lang.Integer A0K(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0373Ba.A0K(java.lang.String):java.lang.Integer");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Integer A0L(String str) {
        byte b;
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case 1536:
                b = !str.equals(A0N(57, 2, 5)) ? (byte) -1 : (byte) 0;
                break;
            case 1537:
                if (str.equals(A0N(59, 2, 105))) {
                    b = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals(A0N(61, 2, 24))) {
                    b = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals(A0N(63, 2, 111))) {
                    b = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals(A0N(65, 2, 50))) {
                    b = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals(A0N(67, 2, 4))) {
                    b = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals(A0N(69, 2, 80))) {
                    b = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals(A0N(71, 2, 97))) {
                    b = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals(A0N(73, 2, 100))) {
                    b = 8;
                    break;
                }
                break;
            case 1545:
                if (str.equals(A0N(75, 2, 38))) {
                    b = 9;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                String[] strArr = A02;
                if (strArr[6].charAt(8) != strArr[5].charAt(8)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[6] = "0KPemZPlBkz6ir7aaqTED1Pw3reeXjRU";
                strArr2[5] = "kXrOI8miBty6c848hwuI9lm7Gcuo04IC";
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[RETURN] */
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
    public static java.lang.Integer A0M(java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0373Ba.A0M(java.lang.String):java.lang.Integer");
    }

    public static String A0O(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(A0N(1765, 18, 26))) {
            if (A0N(651, 21, 124).equals(str)) {
                return A0N(1806, 12, 59);
            }
            String[] strArr = A02;
            if (strArr[1].length() == strArr[3].length()) {
                String[] strArr2 = A02;
                strArr2[0] = "SNR7DEuQkTqundc8fpfLWSSq";
                strArr2[2] = "Am34";
                if (A0N(750, 21, 62).equals(str) || A0N(1056, 34, 59).equals(str)) {
                    return A0N(1783, 13, 48);
                }
                return null;
            }
        } else {
            if (str2.equals(A0N(1435, 10, 108)) && A0N(912, 20, 92).equals(str)) {
                return A0N(1515, 15, 100);
            }
            String[] strArr3 = A02;
            if (strArr3[1].length() == strArr3[3].length()) {
                String[] strArr4 = A02;
                strArr4[0] = "F6UQuKTk39X0DFpi3syODLNA";
                strArr4[2] = "oGjK";
                if (str2.equals(A0N(1469, 10, 50)) && A0N(932, 20, 50).equals(str)) {
                    return A0N(1530, 15, 109);
                }
                if (str2.equals(A0N(1426, 9, 12)) && A0N(893, 19, 80).equals(str)) {
                    return A0N(1479, 12, 10);
                }
                return null;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String A0P(C1981qI c1981qI) {
        Pair<Integer, Integer> codecProfileAndLevel;
        if (A0N(1455, 14, 98).equals(c1981qI.A0W)) {
            String strA0N = A0N(1445, 10, 6);
            if (A02[7].length() != 25) {
                String[] strArr = A02;
                strArr[6] = "ZfndW6AJBdBNuLe7GaNBaOlzT6fPhO3e";
                strArr[5] = "cwvehiRLBehKtkGil8NX01GWyhG4bC3G";
                return strA0N;
            }
        } else if (!A0N(1765, 18, 26).equals(c1981qI.A0W) || (codecProfileAndLevel = A0B(c1981qI)) == null) {
            String[] strArr2 = A02;
            if (strArr2[0].length() != strArr2[2].length()) {
                String[] strArr3 = A02;
                strArr3[6] = "fWQmLDMHB8f7NLxxt23iYDut8JSJcJup";
                strArr3[5] = "lo0RJuE4BwIH2JQYtOHz0H7ocrHx9GAy";
                return null;
            }
        } else {
            int profile = ((Integer) codecProfileAndLevel.first).intValue();
            if (profile == 16 || profile == 256) {
                return A0N(1796, 10, 24);
            }
            if (profile == 512) {
                String[] strArr4 = A02;
                if (strArr4[0].length() != strArr4[2].length()) {
                    A02[7] = "uUyr2eIguxRStOoGPtni7X3Qg6do19s";
                    return A0N(1756, 9, 19);
                }
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.mediacodec.MediaCodecInfo> */
    public static synchronized List<B3> A0R(String str, boolean z, boolean z2) throws BX {
        BY c1848o8;
        BW bw = new BW(str, z, z2);
        List<B3> list = A03.get(bw);
        if (list != null) {
            return list;
        }
        if (C5C.A02 >= 21) {
            c1848o8 = new C1847o7(z, z2);
        } else {
            c1848o8 = new C1848o8();
        }
        ArrayList<B3> arrayListA0Q = A0Q(bw, c1848o8);
        if (z && arrayListA0Q.isEmpty() && 21 <= C5C.A02 && C5C.A02 <= 23) {
            arrayListA0Q = A0Q(bw, new C1848o8());
            if (!arrayListA0Q.isEmpty()) {
                AbstractC02134g.A07(A0N(615, 14, 80), A0N(564, 51, 61) + str + A0N(34, 12, 86) + arrayListA0Q.get(0).A03);
            }
        }
        A0T(str, arrayListA0Q);
        BP bpA05 = BP.A05(arrayListA0Q);
        A03.put(bw, bpA05);
        return bpA05;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0T(String str, List<B3> list) {
        if (A0N(1506, 9, 92).equals(str)) {
            if (C5C.A02 < 26 && C5C.A03.equals(A0N(1090, 2, 81))) {
                int size = list.size();
                String[] strArr = A02;
                if (strArr[1].length() != strArr[3].length()) {
                    throw new RuntimeException();
                }
                A02[7] = "javvHYyhFf0KGd1kb";
                if (size == 1 && list.get(0).A03.equals(A0N(725, 25, 44))) {
                    list.add(B3.A02(A0N(871, 22, 78), A0N(1506, 9, 92), A0N(1506, 9, 92), null, false, true, false, false, false));
                }
            }
            A0U(list, new BZ() { // from class: com.facebook.ads.redexgen.X.oA
                @Override // com.facebook.ads.redexgen.core.BZ
                public final int A8w(Object obj) {
                    return C0373Ba.A08((B3) obj);
                }
            });
        }
        if (C5C.A02 < 21 && list.size() > 1) {
            String str2 = list.get(0).A03;
            String firstCodecName = A0N(805, 15, 82);
            if (!firstCodecName.equals(str2)) {
                String firstCodecName2 = A0N(771, 19, 37);
                if (!firstCodecName2.equals(str2)) {
                    String firstCodecName3 = A0N(835, 26, 45);
                    if (firstCodecName3.equals(str2)) {
                        A0U(list, new BZ() { // from class: com.facebook.ads.redexgen.X.o9
                            @Override // com.facebook.ads.redexgen.core.BZ
                            public final int A8w(Object obj) {
                                return C0373Ba.A09((B3) obj);
                            }
                        });
                    }
                }
            }
        }
        if (C5C.A02 < 32 && list.size() > 1) {
            String str3 = list.get(0).A03;
            String firstCodecName4 = A0N(1030, 26, 22);
            if (firstCodecName4.equals(str3)) {
                list.add(list.remove(0));
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BZ != com.facebook.ads.androidx.media3.exoplayer.mediacodec.MediaCodecUtil$ScoreProvider<T> */
    public static <T> void A0U(List<T> list, final BZ<T> bz) {
        Collections.sort(list, new Comparator() { // from class: com.facebook.ads.redexgen.X.BU
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C0373Ba.A0A(bz, obj, obj2);
            }
        });
    }

    public static boolean A0V(MediaCodecInfo mediaCodecInfo) {
        return C5C.A02 >= 29 && A0W(mediaCodecInfo);
    }

    public static boolean A0W(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean A0X(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean A0Y(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean A0Z(MediaCodecInfo mediaCodecInfo) {
        if (C5C.A02 >= 29) {
            return A0a(mediaCodecInfo);
        }
        String strA01 = AbstractC1616k7.A01(mediaCodecInfo.getName());
        String codecName = A0N(1644, 11, 44);
        if (!strA01.startsWith(codecName)) {
            String codecName2 = A0N(1570, 11, 85);
            if (!strA01.startsWith(codecName2)) {
                String codecName3 = A0N(1581, 10, 2);
                if (!strA01.startsWith(codecName3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean A0a(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static boolean A0b(MediaCodecInfo mediaCodecInfo, String str) {
        if (C5C.A02 >= 29) {
            return A0X(mediaCodecInfo);
        }
        boolean zA0c = A0c(mediaCodecInfo, str);
        if (A02[7].length() == 25) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[1] = "KoKjuGysRdwz5u0";
        strArr[3] = "VFpylWMq2S0rj93";
        return !zA0c;
    }

    public static boolean A0c(MediaCodecInfo mediaCodecInfo, String str) {
        if (C5C.A02 >= 29) {
            boolean zA0Y = A0Y(mediaCodecInfo);
            if (A02[7].length() == 25) {
                throw new RuntimeException();
            }
            A02[7] = "d";
            return zA0Y;
        }
        if (C3J.A0C(str)) {
            return true;
        }
        String strA01 = AbstractC1616k7.A01(mediaCodecInfo.getName());
        String codecName = A0N(1422, 4, 110);
        if (strA01.startsWith(codecName)) {
            return false;
        }
        String codecName2 = A0N(1644, 11, 44);
        if (strA01.startsWith(codecName2)) {
            return true;
        }
        String codecName3 = A0N(1633, 11, 78);
        if (strA01.startsWith(codecName3)) {
            return true;
        }
        String codecName4 = A0N(1688, 8, 32);
        if (strA01.startsWith(codecName4)) {
            String strA0N = A0N(53, 4, 125);
            String[] strArr = A02;
            if (strArr[6].charAt(8) == strArr[5].charAt(8)) {
                A02[4] = "Tb2zdMoNeySIBbx0V3f9cAwRo38zez7f";
                if (strA01.contains(strA0N)) {
                    return true;
                }
            } else if (strA01.contains(strA0N)) {
                return true;
            }
        }
        String codecName5 = A0N(1655, 33, 66);
        if (strA01.equals(codecName5)) {
            return true;
        }
        String codecName6 = A0N(1570, 11, 85);
        if (strA01.startsWith(codecName6)) {
            return true;
        }
        String codecName7 = A0N(1581, 10, 2);
        if (strA01.startsWith(codecName7)) {
            return true;
        }
        String codecName8 = A0N(1629, 4, 74);
        if (!strA01.startsWith(codecName8)) {
            String codecName9 = A0N(1557, 3, 62);
            if (!strA01.startsWith(codecName9)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0335, code lost:
    
        if (A0N(1104, 5, 115).equals(com.facebook.ads.redexgen.core.C5C.A03) != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03df, code lost:
    
        if (r3 != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c5, code lost:
    
        if (com.facebook.ads.redexgen.core.C5C.A03.startsWith(A0N(268, 2, 87)) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01c7, code lost:
    
        if (A0N(1109, 6, 39).equals(com.facebook.ads.redexgen.core.C5C.A03) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0239, code lost:
    
        if (A0N(117, 5, 63).equals(com.facebook.ads.redexgen.core.C5C.A03) != false) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0326  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0d(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(A0N(46, 7, 6)))) {
            return false;
        }
        if (C5C.A02 < 21 && (A0N(142, 13, 104).equals(str) || A0N(170, 13, 103).equals(str) || A0N(183, 16, 125).equals(str) || A0N(155, 15, 116).equals(str) || A0N(92, 10, 51).equals(str) || A0N(554, 10, 2).equals(str))) {
            return false;
        }
        if (C5C.A02 < 18 && A0N(672, 25, 116).equals(str)) {
            if (!A0N(1419, 3, 57).equals(C5C.A03)) {
                if (A0N(1401, 6, 11).equals(C5C.A05)) {
                }
            }
            return false;
        }
        if (C5C.A02 == 16 && A0N(978, 26, 15).equals(str)) {
            if (!A0N(1593, 4, 104).equals(C5C.A03)) {
                if (!A0N(1696, 6, 121).equals(C5C.A03)) {
                    if (!A0N(1818, 5, 97).equals(C5C.A03)) {
                        if (!A0N(1830, 9, 61).equals(C5C.A03)) {
                            if (!A0N(1823, 7, 18).equals(C5C.A03)) {
                                String str3 = C5C.A03;
                                String[] strArr = A02;
                                if (strArr[0].length() != strArr[2].length()) {
                                    String[] strArr2 = A02;
                                    strArr2[6] = "F0Gn9cxfBSvii7fa0UF93GCV4uv6K8de";
                                    strArr2[5] = "DcyddPg9BiXD105tQwV5IePfZ0bLVn4M";
                                    if (!str3.startsWith(A0N(1597, 3, 123))) {
                                        if (!A0N(122, 5, 79).equals(C5C.A03)) {
                                            if (!A0N(127, 5, 106).equals(C5C.A03)) {
                                                if (!A0N(132, 5, 117).equals(C5C.A03)) {
                                                    if (!A0N(137, 5, 10).equals(C5C.A03)) {
                                                        if (!A0N(538, 4, 106).equals(C5C.A03)) {
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
            }
            return false;
        }
        if (C5C.A02 == 16 && A0N(952, 26, 16).equals(str)) {
            if (!A0N(102, 5, 12).equals(C5C.A03)) {
                String str4 = C5C.A03;
                if (A02[7].length() != 25) {
                    String[] strArr3 = A02;
                    strArr3[6] = "nydJBFHRBD5hk7o2D4tykvKlgMFsP1SM";
                    strArr3[5] = "WWeXBCZuBCRG7EUvuKiPsTkRgK8ERGfC";
                    if (!A0N(107, 5, 39).equals(str4)) {
                        if (!A0N(112, 5, 41).equals(C5C.A03)) {
                        }
                    }
                }
            }
            return false;
        }
        int i = C5C.A02;
        String[] strArr4 = A02;
        if (strArr4[6].charAt(8) == strArr4[5].charAt(8)) {
            String[] strArr5 = A02;
            strArr5[6] = "GkRyYjTYByrmgDH0WlXKVdmPSNZ8lCgN";
            strArr5[5] = "ni9nM4uSBMddlB6zBZSK6aFbzoXzwy3u";
            String strA0N = A0N(1702, 7, 12);
            if (i < 24 && ((A0N(790, 15, 118).equals(str) || A0N(629, 22, 79).equals(str)) && strA0N.equals(C5C.A05))) {
                if (!C5C.A03.startsWith(A0N(1849, 8, 78)) && !C5C.A03.startsWith(A0N(1857, 7, 69)) && !C5C.A03.startsWith(A0N(1843, 6, 57))) {
                    if (!A0N(1098, 6, 120).equals(C5C.A03)) {
                        if (!A0N(1613, 12, 52).equals(C5C.A03)) {
                            if (!A0N(87, 5, 75).equals(C5C.A03)) {
                                String str5 = C5C.A03;
                                String[] strArr6 = A02;
                                if (strArr6[6].charAt(8) != strArr6[5].charAt(8)) {
                                    if (!A0N(1092, 6, 58).equals(str5)) {
                                    }
                                } else {
                                    String[] strArr7 = A02;
                                    strArr7[0] = "nYvmQZpdwFAwcv6gzbNkZZWF";
                                    strArr7[2] = "X6eS";
                                    if (!A0N(1092, 6, 58).equals(str5)) {
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            int i2 = C5C.A02;
            String strA0N2 = A0N(1608, 5, 104);
            if (i2 <= 19 && A0N(820, 15, 38).equals(str) && strA0N.equals(C5C.A05)) {
                if (!C5C.A03.startsWith(A0N(1591, 2, 7)) && !C5C.A03.startsWith(A0N(1730, 7, 9)) && !C5C.A03.startsWith(strA0N2) && !C5C.A03.startsWith(A0N(1709, 6, 19))) {
                    boolean zStartsWith = C5C.A03.startsWith(A0N(1737, 2, 58));
                    String[] strArr8 = A02;
                    if (strArr8[0].length() == strArr8[2].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr9 = A02;
                    strArr9[6] = "JGSFe5hHB2u94PbOntGCWQqPSFCJeXlP";
                    strArr9[5] = "TkGozbnrBqdw4Stmffdx8IiId823o3dX";
                }
                return false;
            }
            if (C5C.A02 <= 19 && C5C.A03.startsWith(strA0N2) && A0N(1004, 26, 89).equals(str)) {
                return false;
            }
            return (C5C.A02 <= 23 && A0N(1455, 14, 98).equals(str2) && A0N(697, 28, 96).equals(str)) ? false : true;
        }
        throw new RuntimeException();
    }
}
