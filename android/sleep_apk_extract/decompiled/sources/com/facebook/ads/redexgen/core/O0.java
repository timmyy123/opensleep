package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class O0 {
    public static String[] A00 = {"8XYGd5ZHSKJUGKcOBZRj1wh994qBk", "BxRxgsb39CeS8gUybSCvfMthfoa7WN", "MbLF7RBGQJ5IZlZwsL", "5COIZmJumnkEkrhpQeQyhRhZGCLVsyVV", "KxSUW8Yx0pGLd", "vVb3IVkHxruGPbcu6dN9QNWQiYSW5FCa", "S8VYx", "aJn40"};

    public static void A00(NQ nq, C0827Sx c0827Sx, String str) {
        if (nq.A0t() != null && nq.A0t().A05() != null) {
            int iA04 = nq.A0t().A04();
            if (A00[2].length() == 15) {
                throw new RuntimeException();
            }
            A00[4] = "IYXFBoSH0TRoN";
            if (iA04 > 0 && nq.A0t().A03() > 0) {
                c0827Sx.A0c(new C0825Sv(nq.A0t().A05(), (int) (nq.A0t().A03() * XX.A02), (int) (nq.A0t().A04() * XX.A02), nq.A1D(), str));
            }
        }
    }
}
