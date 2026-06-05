package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0773Qu extends AbstractRunnableC0908Wc {
    public static byte[] A01;
    public static String[] A02 = {"s6McyFvuEc1XiqBn", "hcEKpUAFoi0", "Uxw7Yfkl7Y0EbUXumb1zp", "2eIZNGpCiZfiyfWjpoEHXYEZ89sKOMjU", "P6wJZ5NPzNm0cd9T3B6a4kCxx00um", "avjdKGQRQHprL3nlmChXTO66aPxw1Ezk", "jTYXriUGWk0Q5Onqj2MBy1ZRmPDEVS5l", "vP4DO0q8Z4bTalFPzqbCoE7Mp2WJV4fR"};
    public final /* synthetic */ Context A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[3].charAt(28) == 'p') {
                throw new RuntimeException();
            }
            A02[3] = "yencg2WQyjWgLr4Htapu7BwNwN3x2Tit";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 60);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-127, -80, -80, -115, -87, -82, -109, -92, -85, -106, -91, -78, -77, -87, -81, -82};
    }

    static {
        A01();
    }

    public C0773Qu(Context context) {
        this.A00 = context;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        int iA02;
        if (XK.A04 == XJ.A02) {
            return;
        }
        SharedPreferences sharedPreferencesA00 = WN.A00(this.A00);
        String strA00 = A00(0, 16, 4);
        int i = sharedPreferencesA00.getInt(strA00, -1);
        if (i == -1) {
            if (Build.VERSION.SDK_INT < 24) {
                iA02 = XK.A02(this.A00);
            } else {
                iA02 = XK.A03(this.A00);
            }
            int unused = XK.A00 = iA02;
            sharedPreferencesA00.edit().putInt(strA00, iA02).commit();
            XK.A04 = XJ.A02;
            return;
        }
        int unused2 = XK.A00 = i;
        XJ xj = XJ.A02;
        String[] strArr = A02;
        if (strArr[1].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A02[5] = "hUCmhtQ8p32Ulvvxz3h93PNa760nZTZ8";
        XK.A04 = xj;
    }
}
