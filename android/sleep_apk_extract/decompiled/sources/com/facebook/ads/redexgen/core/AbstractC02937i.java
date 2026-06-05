package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class AbstractC02937i {
    public static int A00(int i) {
        return A06(i, 0, 0);
    }

    public static int A01(int i) {
        return i & 24;
    }

    public static int A02(int i) {
        return i & 384;
    }

    public static int A03(int i) {
        return i & 7;
    }

    public static int A04(int i) {
        return i & 64;
    }

    public static int A05(int i) {
        return i & 32;
    }

    public static int A06(int i, int i2, int i3) {
        return A07(i, i2, i3, 0, 128);
    }

    public static int A07(int i, int i2, int i3, int i4, int i5) {
        return i | i2 | i3 | i4 | i5;
    }
}
