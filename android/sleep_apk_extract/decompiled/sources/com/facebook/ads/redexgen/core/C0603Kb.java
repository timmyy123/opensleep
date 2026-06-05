package com.facebook.ads.redexgen.core;

import android.text.Layout;
import android.text.TextUtils;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0603Kb {
    public static byte[] A0I;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;

    @MetaExoPlayerCustomization("Removed parameter in r2.18")
    public Layout.Alignment A09;
    public String A0A;
    public String A0B;
    public String A0C;
    public String A0D;
    public Set<String> A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0I = new byte[]{-70, -39, -37, -29, -33, -22, -25, -19, -26, -36, -104, -37, -25, -28, -25, -22, -104, -26, -25, -20, -104, -36, -35, -34, -31, -26, -35, -36, -90, -104, -63, -64, -58, 114, -75, -63, -66, -63, -60, 114, -64, -63, -58, 114, -74, -73, -72, -69, -64, -73, -74};
    }

    public C0603Kb() {
        String strA01 = A01(0, 0, 10);
        this.A0B = strA01;
        this.A0C = strA01;
        this.A0E = Collections.emptySet();
        this.A0D = strA01;
        this.A0A = null;
        this.A0H = false;
        this.A0G = false;
        this.A06 = -1;
        this.A08 = -1;
        this.A02 = -1;
        this.A05 = -1;
        this.A04 = -1;
        this.A09 = null;
        this.A07 = -1;
        this.A0F = false;
    }

    public static int A00(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    public final float A03() {
        return this.A00;
    }

    public final int A04() {
        if (this.A0G) {
            return this.A01;
        }
        throw new IllegalStateException(A01(0, 29, 118));
    }

    public final int A05() {
        if (this.A0H) {
            return this.A03;
        }
        throw new IllegalStateException(A01(29, 22, 80));
    }

    public final int A06() {
        return this.A04;
    }

    public final int A07() {
        return this.A07;
    }

    public final int A08() {
        if (this.A02 == -1 && this.A05 == -1) {
            return -1;
        }
        return (this.A02 == 1 ? 1 : 0) | (this.A05 == 1 ? 2 : 0);
    }

    public final int A09(String str, String str2, Set<String> set, String str3) {
        if (this.A0B.isEmpty() && this.A0C.isEmpty() && this.A0E.isEmpty() && this.A0D.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int iA00 = A00(A00(A00(0, this.A0B, str, 1073741824), this.A0C, str2, 2), this.A0D, str3, 4);
        if (iA00 == -1 || !set.containsAll(this.A0E)) {
            return 0;
        }
        return iA00 + (this.A0E.size() * 4);
    }

    public final C0603Kb A0A(float f) {
        this.A00 = f;
        return this;
    }

    public final C0603Kb A0B(int i) {
        this.A01 = i;
        this.A0G = true;
        return this;
    }

    public final C0603Kb A0C(int i) {
        this.A03 = i;
        this.A0H = true;
        return this;
    }

    public final C0603Kb A0D(int i) {
        this.A04 = i;
        return this;
    }

    public final C0603Kb A0E(int i) {
        this.A07 = i;
        return this;
    }

    public final C0603Kb A0F(String str) {
        this.A0A = str == null ? null : AbstractC1616k7.A01(str);
        return this;
    }

    public final C0603Kb A0G(boolean z) {
        this.A02 = z ? 1 : 0;
        return this;
    }

    public final C0603Kb A0H(boolean z) {
        this.A0F = z;
        return this;
    }

    public final C0603Kb A0I(boolean z) {
        this.A05 = z ? 1 : 0;
        return this;
    }

    public final C0603Kb A0J(boolean z) {
        this.A08 = z ? 1 : 0;
        return this;
    }

    public final String A0K() {
        return this.A0A;
    }

    public final void A0L(String str) {
        this.A0B = str;
    }

    public final void A0M(String str) {
        this.A0C = str;
    }

    public final void A0N(String str) {
        this.A0D = str;
    }

    public final void A0O(String[] strArr) {
        this.A0E = new HashSet(Arrays.asList(strArr));
    }

    public final boolean A0P() {
        return this.A0F;
    }

    public final boolean A0Q() {
        return this.A0G;
    }

    public final boolean A0R() {
        return this.A0H;
    }

    public final boolean A0S() {
        return this.A06 == 1;
    }

    public final boolean A0T() {
        return this.A08 == 1;
    }
}
