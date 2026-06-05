package com.facebook.ads.redexgen.core;

import android.util.Log;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RD {
    public static byte[] A07;
    public static String[] A08 = {"Pvnt", "Nt2K241MgRq22KzubAG1E2apF", "Vdgual6oAXALnhRQ4thM2YMw", "OMMTDpWLjpz6jtrYJbYN7s1", "W2dFPnHzaLwituG", "4j3XDogoyZgqzsm2DW15mEco0CAT7CGw", "eQqq", "jFkfoBffmcshIEwi45Rbk0NXRUENoMTZ"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public Interpolator A05;
    public boolean A06;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        String[] strArr = A08;
        if (strArr[7].charAt(16) == strArr[5].charAt(16)) {
            throw new RuntimeException();
        }
        A08[3] = "xuBDHwCCeJFwoWJXOKQP0R9";
        A07 = new byte[]{-96, -67, 119, -48, -58, -52, 119, -57, -55, -58, -51, -64, -69, -68, 119, -72, -59, 119, -64, -59, -53, -68, -55, -57, -58, -61, -72, -53, -58, -55, -125, 119, -48, -58, -52, 119, -60, -52, -54, -53, 119, -54, -68, -53, 119, -72, 119, -57, -58, -54, -64, -53, -64, -51, -68, 119, -69, -52, -55, -72, -53, -64, -58, -59, 93, 112, 110, -124, 110, 119, 112, 125, 97, 116, 112, -126, 118, -122, -107, -110, -113, -113, 67, -121, -104, -107, -124, -105, -116, -110, -111, 67, -112, -104, -106, -105, 67, -123, -120, 67, -124, 67, -109, -110, -106, -116, -105, -116, -103, -120, 67, -111, -104, -112, -123, -120, -107, -88, -62, -60, -60, -55, -67, 117, -88, -72, -57, -60, -63, -63, 117, -74, -72, -55, -66, -60, -61, 117, -66, -56, 117, -73, -70, -66, -61, -68, 117, -54, -59, -71, -74, -55, -70, -71, 117, -55, -60, -60, 117, -69, -57, -70, -58, -54, -70, -61, -55, -63, -50, -125, 117, -94, -74, -64, -70, 117, -56, -54, -57, -70, 117, -50, -60, -54, 117, -74, -57, -70, 117, -61, -60, -55, 117, -72, -67, -74, -61, -68, -66, -61, -68, 117, -66, -55, 117, -54, -61, -63, -70, -56, -56, 117, -61, -70, -72, -70, -56, -56, -74, -57, -50};
    }

    static {
        A02();
    }

    public RD(int i, int i2) {
        this(i, i2, Integer.MIN_VALUE, null);
    }

    public RD(int i, int i2, int i3, Interpolator interpolator) {
        this.A04 = -1;
        this.A06 = false;
        this.A00 = 0;
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A05 = interpolator;
    }

    private void A01() {
        if (this.A05 == null || this.A01 >= 1) {
            if (this.A01 >= 1) {
                return;
            } else {
                throw new IllegalStateException(A00(76, 41, 31));
            }
        }
        throw new IllegalStateException(A00(0, 64, 83));
    }

    public final void A03(int i) {
        this.A04 = i;
    }

    public final void A04(int i, int i2, int i3, Interpolator interpolator) {
        this.A02 = i;
        this.A03 = i2;
        this.A01 = i3;
        this.A05 = interpolator;
        this.A06 = true;
    }

    public final void A05(C7M c7m) {
        if (this.A04 >= 0) {
            int i = this.A04;
            this.A04 = -1;
            c7m.A1U(i);
            this.A06 = false;
            return;
        }
        if (this.A06) {
            A01();
            Interpolator interpolator = this.A05;
            if (A08[6].length() == 20) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[2] = "O0czx9uFUzFwUeJrPkRP61AB";
            strArr[0] = "AYyk";
            if (interpolator == null) {
                if (this.A01 == Integer.MIN_VALUE) {
                    c7m.A08.A0A(this.A02, this.A03);
                } else {
                    RJ rj = c7m.A08;
                    int i2 = this.A02;
                    int i3 = this.A03;
                    if (A08[1].length() != 25) {
                        rj.A0B(i2, i3, this.A01);
                    } else {
                        String[] strArr2 = A08;
                        strArr2[7] = "WLL7Xa5cC4PfSmY4OKeTHvZ3MFGwUNY7";
                        strArr2[5] = "1QT7rx7s1eUCzctaxezGIMAtvqNEmmGR";
                        rj.A0B(i2, i3, this.A01);
                    }
                }
            } else {
                c7m.A08.A0C(this.A02, this.A03, this.A01, this.A05);
            }
            this.A00++;
            if (this.A00 > 10) {
                Log.e(A00(64, 12, 7), A00(117, 104, 81));
            }
            this.A06 = false;
            return;
        }
        this.A00 = 0;
    }

    public final boolean A06() {
        return this.A04 >= 0;
    }
}
