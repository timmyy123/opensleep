package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1398gL {
    A09(A00(145, 13, 123), EnumC1400gN.A03, true),
    A08(A00(128, 17, 124), EnumC1400gN.A04, true),
    A07(A00(114, 14, 33), EnumC1400gN.A04, false),
    A0A(A00(171, 23, 15), EnumC1400gN.A04, false),
    A0B(A00(158, 13, 28), EnumC1400gN.A04, true),
    A06(A00(97, 17, 115), EnumC1400gN.A04, false);

    public static byte[] A03;
    public static String[] A04 = {"ycwuSagCCCN4l2dI41z3qVhXiq7PFx6V", "eCechoSCzkY2xErzr1Uj4eXJDYPAMm21", "Tj2V", "5PPeuyR1XhCZ68o08D3eM2L3nt7", "QkjbeLtEXK6xGgNvZ4ng7fB3y1rOF3bp", "NI4HGGG8cjGbKqK", "UN1b1Vv9e1ysvCUt5x8q6t9LXfdcX8lO", "wYekL4qvcaeL43S"};
    public EnumC1400gN A00;
    public String A01;
    public boolean A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A04;
            if (strArr[1].charAt(7) != strArr[0].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[6] = "1sEbNeEn9yAQIM08pYF4gKbNN1PUoHvf";
            strArr2[4] = "yyBbFHXEa0Kbel6c5iwsjMz13YxOyOJd";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 21);
            i4++;
        }
    }

    public static void A01() {
        A03 = new byte[]{-68, -61, -66, -66, -65, -52, -39, -50, -55, -59, -65, -56, -39, -61, -56, -64, -55, -70, -71, -75, -56, -55, -58, -71, -45, -73, -61, -62, -70, -67, -69, -34, -38, -49, -47, -45, -37, -45, -36, -30, -19, -44, -35, -32, -37, -49, -30, -31, -78, -82, -93, -91, -89, -81, -89, -80, -74, -63, -85, -90, -75, -107, -105, -118, -117, -118, -103, -120, -115, -118, -119, -92, -122, -119, -92, -105, -118, -104, -107, -108, -109, -104, -118, -104, 105, 107, 94, 95, 94, 109, 92, 97, 120, 110, 107, 101, 108, -22, -15, -20, -20, -19, -6, -25, -4, -9, -13, -19, -10, -25, -15, -10, -18, -9, -100, -101, -105, -86, -85, -88, -101, -107, -103, -91, -92, -100, -97, -99, 1, -3, -14, -12, -10, -2, -10, -1, 5, -66, -9, 0, 3, -2, -14, 5, 4, 0, -4, -15, -13, -11, -3, -11, -2, 4, -67, -7, -12, 3, -95, -93, -106, -105, -106, -91, -108, -103, -112, -90, -93, -99, -92, -108, -106, -119, -118, -119, -104, -121, -116, -119, -120, 81, -123, -120, 81, -106, -119, -105, -108, -109, -110, -105, -119, -105};
    }

    static {
        A01();
    }

    EnumC1398gL(String str, EnumC1400gN enumC1400gN, boolean z) {
        this.A01 = str;
        this.A00 = enumC1400gN;
        this.A02 = z;
    }

    public final EnumC1400gN A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }

    public final boolean A05() {
        return this.A02;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC1398gL[] valuesCustom() {
        EnumC1398gL[] enumC1398gLArrValuesCustom = values();
        String[] strArr = A04;
        if (strArr[7].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[1] = "AD9B2u3CpUm8RcifiDyOxQh6hnzeqyLc";
        strArr2[0] = "O9mPnP3CfsWUFNDjzVqrQcoADApw1Amm";
        return (EnumC1398gL[]) enumC1398gLArrValuesCustom.clone();
    }
}
