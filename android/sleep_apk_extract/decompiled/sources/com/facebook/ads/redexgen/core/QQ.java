package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class QQ {
    public static byte[] A03;
    public static String[] A04 = {"90ZggfNQsOg49XfX2Gw1SU3vAhU", "6e03JoSoFcAuCj0XHJ07P", "X2n0FB8CLVE6QonP7j41AEQOs", "oGNNWvZthHEo2sMGR9jx6vYqjxoachM9", "D9nn", "xFc2wx6BEzvoHtEzkiYe1GtwM37", "KcMIoFUA4KOHORJmTS9CHMjc27bv2njt", "Hz1lzGXaGkVdCftBSZ2HywJOuLsdaxmO"};
    public final QP A01;
    public final QO A00 = new QO();
    public final List<View> A02 = new ArrayList();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-113, -125, -53, -52, -57, -57, -56, -47, -125, -49, -52, -42, -41, -99, -21, -23, -16, -32, -27, -34, -105, -21, -26, -105, -20, -27, -33, -32, -37, -36, -105, -40, -105, -19, -32, -36, -18, -105, -21, -33, -40, -21, -105, -18, -40, -22, -105, -27, -26, -21, -105, -33, -32, -37, -37, -36, -27, 43, 30, 26, 44, -43, 30, 40, -43, 35, 36, 41, -43, 22, -43, 24, 29, 30, 33, 25, -31, -43, 24, 22, 35, 35, 36, 41, -43, 29, 30, 25, 26, -43};
    }

    static {
        A02();
    }

    public QQ(QP qp) {
        this.A01 = qp;
    }

    private int A00(int i) {
        if (i < 0) {
            return -1;
        }
        int offset = this.A01.A7I();
        int limit = i;
        while (limit < offset) {
            int iA03 = i - (limit - this.A00.A03(limit));
            if (iA03 == 0) {
                while (this.A00.A08(limit)) {
                    limit++;
                }
                return limit;
            }
            limit += iA03;
        }
        return -1;
    }

    private void A03(View view) {
        this.A02.add(view);
        this.A01.ADo(view);
    }

    private boolean A04(View view) {
        if (this.A02.remove(view)) {
            this.A01.AEa(view);
            return true;
        }
        return false;
    }

    public final int A05() {
        return this.A01.A7I() - this.A02.size();
    }

    public final int A06() {
        return this.A01.A7I();
    }

    public final int A07(View view) {
        int iAA7 = this.A01.AA7(view);
        if (iAA7 == -1 || this.A00.A08(iAA7)) {
            return -1;
        }
        int index = this.A00.A03(iAA7);
        return iAA7 - index;
    }

    public final View A08(int i) {
        int size = this.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.A02.get(i2);
            RK rkA7L = this.A01.A7L(view);
            int count = rkA7L.A0O();
            if (count == i && !rkA7L.A0f() && !rkA7L.A0g()) {
                return view;
            }
        }
        return null;
    }

    public final View A09(int i) {
        return this.A01.A7H(A00(i));
    }

    public final View A0A(int i) {
        return this.A01.A7H(i);
    }

    public final void A0B() {
        this.A00.A04();
        for (int size = this.A02.size() - 1; size >= 0; size--) {
            this.A01.AEa(this.A02.get(size));
            this.A02.remove(size);
        }
        this.A01.AIQ();
    }

    public final void A0C(int i) {
        int iA00 = A00(i);
        this.A00.A09(iA00);
        this.A01.A5w(iA00);
    }

    public final void A0D(int i) {
        int iA00 = A00(i);
        View view = this.A01.A7H(iA00);
        if (view == null) {
            return;
        }
        if (this.A00.A09(iA00)) {
            A04(view);
        }
        this.A01.AIW(iA00);
    }

    public final void A0E(View view) {
        int iAA7 = this.A01.AA7(view);
        if (iAA7 >= 0) {
            this.A00.A06(iAA7);
            A03(view);
            return;
        }
        throw new IllegalArgumentException(A01(57, 33, 85) + view);
    }

    public final void A0F(View view) {
        int iAA7 = this.A01.AA7(view);
        if (iAA7 < 0) {
            return;
        }
        if (this.A00.A09(iAA7)) {
            A04(view);
        }
        this.A01.AIW(iAA7);
    }

    public final void A0G(View view) {
        int iAA7 = this.A01.AA7(view);
        if (iAA7 >= 0) {
            if (this.A00.A08(iAA7)) {
                this.A00.A05(iAA7);
                if (A04[7].charAt(2) == 'x') {
                    throw new RuntimeException();
                }
                String[] strArr = A04;
                strArr[5] = "8IGbKDWrlSqGtsrcKzoZxkVKvdJ";
                strArr[0] = "U0TRNaLdUZe04yrOWBaiBfN34lF";
                A04(view);
                return;
            }
            throw new RuntimeException(A01(14, 43, 23) + view);
        }
        throw new IllegalArgumentException(A01(57, 33, 85) + view);
    }

    public final void A0H(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iA00;
        if (i < 0) {
            iA00 = this.A01.A7I();
        } else {
            iA00 = A00(i);
        }
        this.A00.A07(iA00, z);
        if (z) {
            A03(view);
        }
        this.A01.A4K(view, iA00, layoutParams);
    }

    public final void A0I(View view, int i, boolean z) {
        int iA00;
        if (i < 0) {
            QP qp = this.A01;
            String[] strArr = A04;
            if (strArr[5].length() == strArr[0].length()) {
                String[] strArr2 = A04;
                strArr2[1] = "WWxR4kuTyiSS3k1dOopZM";
                strArr2[2] = "jpAqbovCz6NUDLwJv0FYFncHe";
                iA00 = qp.A7I();
            }
            throw new RuntimeException();
        }
        iA00 = A00(i);
        this.A00.A07(iA00, z);
        if (A04[7].charAt(2) != 'x') {
            A04[4] = "lrFB";
            if (z) {
                A03(view);
            }
            this.A01.addView(view, iA00);
            return;
        }
        throw new RuntimeException();
    }

    public final void A0J(View view, boolean z) {
        A0I(view, -1, z);
    }

    public final boolean A0K(View view) {
        return this.A02.contains(view);
    }

    public final boolean A0L(View view) {
        int iAA7 = this.A01.AA7(view);
        if (iAA7 == -1) {
            A04(view);
            return true;
        }
        if (this.A00.A08(iAA7)) {
            this.A00.A09(iAA7);
            A04(view);
            this.A01.AIW(iAA7);
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.A00.toString() + A01(0, 14, 3) + this.A02.size();
    }
}
