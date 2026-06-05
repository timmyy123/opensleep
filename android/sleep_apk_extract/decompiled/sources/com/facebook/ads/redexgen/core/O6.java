package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class O6 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 76, 80, 73, 72, 121, 126, 100, 117, 98, 99, 100, 121, 100, 121, 113, 124, 101, 114, 96, 118, 101, 115, 114, 115, 72, 97, 126, 115, 114, 120};
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x00da */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A02(C1421gi c1421gi, C0827Sx c0827Sx, C02967l c02967l) {
        c0827Sx.A0d(new C0825Sv(c02967l.A2C().A01(), C1258e4.A04, C1258e4.A04, c02967l.A1D(), A00(17, 14, 113)));
        boolean zA1g = c02967l.A1g();
        String strA00 = A00(17, 14, 113);
        if (zA1g) {
            C0823St c0823St = new C0823St(c02967l.A0x(), c02967l.A1D(), strA00);
            c0823St.A04 = true;
            c0823St.A03 = A00(0, 5, 66);
            c0827Sx.A0Y(c0823St);
        }
        boolean zA30 = C0871Up.A30(c1421gi, C1348fX.A03());
        C0823St c0823St2 = new C0823St(c02967l.A29().A0H().A09(), c02967l.A1D(), A00(17, 14, 113), c02967l.A29().A0H().A06());
        if (zA1g && !zA30) {
            c0827Sx.A0Y(c0823St2);
        } else {
            c0827Sx.A0b(c0823St2);
        }
        c0827Sx.A0d(new C0825Sv(c02967l.A29().A0H().A08(), O1.A00(c02967l.A29().A0H()), O1.A01(c02967l.A29().A0H()), c02967l.A1D(), A00(17, 14, 113)));
        O0.A00(c02967l, c0827Sx, strA00);
        Iterator<String> it = c02967l.A29().A0K().A02().iterator();
        while (isDSL) {
            String url = it.next();
            c0827Sx.A0d(new C0825Sv(url, -1, -1, c02967l.A1D(), A00(17, 14, 113)));
        }
    }

    public static void A03(C1421gi c1421gi, C0827Sx c0827Sx, C02967l c02967l) {
        int i = 0;
        for (NR nr : c02967l.A2G()) {
            C0825Sv c0825Sv = new C0825Sv(nr.A0H().A08(), O1.A00(nr.A0H()), O1.A01(nr.A0H()), c02967l.A1D(), A00(5, 12, 118));
            if (i == 0) {
                c0827Sx.A0c(c0825Sv);
            } else {
                c0827Sx.A0d(c0825Sv);
            }
            O0.A00(c02967l, c0827Sx, A00(17, 14, 113));
            Iterator<String> it = nr.A0K().A02().iterator();
            while (it.hasNext()) {
                c0827Sx.A0d(new C0825Sv(it.next(), -1, -1, c02967l.A1D(), A00(5, 12, 118)));
            }
            if (!TextUtils.isEmpty(nr.A0H().A09())) {
                new C0823St(nr.A0H().A09(), c02967l.A1D(), A00(5, 12, 118), nr.A0H().A06()).A04 = false;
            }
            i++;
        }
    }
}
