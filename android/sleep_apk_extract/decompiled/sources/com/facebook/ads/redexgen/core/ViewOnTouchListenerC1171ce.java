package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ce, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1171ce implements View.OnTouchListener {
    public static byte[] A01;
    public static String[] A02 = {"0HVxtLG0sPkx2", "hiZzr77KokQTc", "mNnSSdkwXzrOg41hebGrtMF8fEOYdjGE", "NiiVAR3ay3HziijWMkU57MyJi0qOk8bf", "5RCf0Yx637qOFKYGhhAOV12LnRlJgv3P", "3PZq2jvav8U89", "SINF4Npt4bG7GbW3rji", "p0cbgO4lXEkOYy0C0Gpe"};
    public final /* synthetic */ C0584Ji A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 39;
            String[] strArr = A02;
            if (strArr[1].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[7] = "15sr1U6GzUIP4MnHZRSc";
            strArr2[5] = "N9mozJJ8LQfhA";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-83, -85, -99, -86, -105, -101, -92, -95, -101, -93, -105, -95, -103, -102, -67, -69, -83, -70, -89, -77, -83, -63, -72, -87, -84, -89, -85, -76, -79, -85, -77, -89, -79, -87, -86};
    }

    static {
        A01();
    }

    public ViewOnTouchListenerC1171ce(C0584Ji c0584Ji) {
        this.A00 = c0584Ji;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (!this.A00.A0H && this.A00.A0V != null && this.A00.A0V.isAcceptingText()) {
                    this.A00.A0H = true;
                    this.A00.A0o(A00(14, 21, 33));
                }
                break;
            case 1:
                C0584Ji c0584Ji = this.A00;
                String[] strArr = A02;
                if (strArr[1].length() != strArr[0].length()) {
                    A02[6] = "OcZWYNEqCaLP";
                    C0584Ji.A04(c0584Ji);
                    if (!this.A00.A0G) {
                        if (this.A00.A01 >= 5) {
                            this.A00.A0G = true;
                            this.A00.A0o(A00(0, 14, 17));
                        }
                    }
                    break;
                } else {
                    String[] strArr2 = A02;
                    strArr2[1] = "icFIHzt0T1qa8";
                    strArr2[0] = "30YVfIVk012ko";
                    C0584Ji.A04(c0584Ji);
                    if (!this.A00.A0G) {
                    }
                }
                break;
        }
        if (A02[4].charAt(7) != '6') {
            throw new RuntimeException();
        }
        A02[4] = "w8TKL5U61DrXWGWK9GXi8K1kZSuhi8qi";
        return false;
    }
}
