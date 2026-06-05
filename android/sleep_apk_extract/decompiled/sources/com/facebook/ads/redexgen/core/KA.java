package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class KA implements InterfaceC1059aq {
    public static byte[] A01;
    public static String[] A02 = {"Lf", "nmAxyBcQYqE4UmHMsUF1rAa8zTrMAPgx", "yXHjwHYuNIdrzaXYLvaZZ8rDuk", "9P19JGz6dEYaA5InwGx6w36V1Sjc1fgT", "Uaeemoya7byMjdbMYqkdDOMCW0kva5u1", "a9sExJmhm07IJOfFlJQHVREgKDfvTtqT", "zS9IM7X0AIqJ7SZD2m", "JScTq5ptQGF6W5ukeGazDvn9iL3"};
    public final /* synthetic */ C0584Ji A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-29, -31, -45, -32, -51, -36, -49, -28, -41, -43, -49, -30, -41, -35, -36, -51, -41, -49, -48};
    }

    static {
        A01();
    }

    public KA(C0584Ji c0584Ji) {
        this.A00 = c0584Ji;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AF7(String str) {
        this.A00.A0K = false;
        if (this.A00.A07 != null) {
            this.A00.A07.setProgress(100);
        }
        YB.A0O(this.A00.A07, 8);
        if (this.A00.A0X.A1l() && this.A00.A08 != null) {
            String strA14 = this.A00.A0X.A14();
            if (!TextUtils.isEmpty(strA14)) {
                this.A00.A08.loadUrl(strA14);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AF9(String str) {
        this.A00.A0K = true;
        YB.A0O(this.A00.A07, 0);
        if (this.A00.A06 != null) {
            this.A00.A06.setUrl(str);
        }
        C0584Ji c0584Ji = this.A00;
        String[] strArr = A02;
        if (strArr[4].charAt(17) != strArr[5].charAt(17)) {
            A02[2] = "wX256yuF2";
            if (!c0584Ji.A0I && this.A00.A00 > 1) {
                this.A00.A0I = true;
                this.A00.A0o(A00(0, 19, 95));
            }
            C0584Ji.A02(this.A00);
            if (A02[2].length() != 27) {
                A02[6] = "lsrcQj4qqEXeVsDQCf";
                return;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AFY(int i) {
        if (this.A00.A0K && this.A00.A07 != null) {
            this.A00.A07.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AFb(String str) {
        if (this.A00.A06 != null) {
            this.A00.A06.setTitle(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AFe() {
        this.A00.A0b.A0C().ADJ(14);
    }
}
