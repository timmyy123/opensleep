package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.q2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1965q2 implements AnonymousClass24 {
    public final Uri A00;
    public final Uri A01;
    public final Bundle A02;
    public final AbstractC1956pt A03;
    public final AbstractC1956pt A04;
    public final Boolean A05;
    public final CharSequence A06;
    public final CharSequence A07;
    public final CharSequence A08;
    public final CharSequence A09;
    public final CharSequence A0A;
    public final CharSequence A0B;
    public final CharSequence A0C;
    public final CharSequence A0D;
    public final CharSequence A0E;
    public final CharSequence A0F;
    public final CharSequence A0G;
    public final CharSequence A0H;
    public final CharSequence A0I;
    public final Integer A0J;
    public final Integer A0K;
    public final Integer A0L;
    public final Integer A0M;
    public final Integer A0N;
    public final Integer A0O;
    public final Integer A0P;
    public final Integer A0Q;
    public final Integer A0R;
    public final Integer A0S;
    public final Integer A0T;
    public final Integer A0U;

    @Deprecated
    public final Integer A0V;
    public final byte[] A0W;
    public static String[] A0X = {"zubbJHIGN62aQpEy91CnZekmJL7fZhcj", "Tf6Wii3TFEDBDD0h8UvX5qaY8eXSzTkW", "PzB8ZoZFbpUrc7pgJ0ghLttm", "08PAkH52X5piiuzTKugWbIZJ7g2fzjWB", "K8DhncAAf645aMURmZckD", "VnMvQYKg2m3XsU3GlEglt4TQFPWPFThI", "CnA0hK2Gvuh", "oHxylVIJyzccCX3kgnuGG4BXvpn"};
    public static final C1965q2 A0Z = new AnonymousClass37().A11();
    public static final AnonymousClass23<C1965q2> A0Y = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.q6
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C1965q2.A00(bundle);
        }
    };

    public C1965q2(AnonymousClass37 anonymousClass37) {
        this.A0H = anonymousClass37.A0H;
        this.A08 = anonymousClass37.A08;
        this.A07 = anonymousClass37.A07;
        this.A06 = anonymousClass37.A06;
        this.A0D = anonymousClass37.A0D;
        this.A0G = anonymousClass37.A0G;
        this.A0C = anonymousClass37.A0C;
        this.A01 = anonymousClass37.A01;
        this.A04 = anonymousClass37.A04;
        this.A03 = anonymousClass37.A03;
        this.A0W = anonymousClass37.A0V;
        this.A0J = anonymousClass37.A0J;
        this.A00 = anonymousClass37.A00;
        this.A0U = anonymousClass37.A0U;
        this.A0T = anonymousClass37.A0T;
        this.A0L = anonymousClass37.A0L;
        this.A05 = anonymousClass37.A05;
        this.A0V = anonymousClass37.A0O;
        this.A0O = anonymousClass37.A0O;
        this.A0N = anonymousClass37.A0N;
        this.A0M = anonymousClass37.A0M;
        this.A0R = anonymousClass37.A0R;
        this.A0Q = anonymousClass37.A0Q;
        this.A0P = anonymousClass37.A0P;
        this.A0I = anonymousClass37.A0I;
        this.A0A = anonymousClass37.A0A;
        this.A0B = anonymousClass37.A0B;
        this.A0K = anonymousClass37.A0K;
        this.A0S = anonymousClass37.A0S;
        this.A0E = anonymousClass37.A0E;
        this.A09 = anonymousClass37.A09;
        this.A0F = anonymousClass37.A0F;
        this.A02 = anonymousClass37.A02;
    }

    public static C1965q2 A00(Bundle bundle) {
        Integer numValueOf;
        Bundle fieldBundle;
        Bundle fieldBundle2;
        AnonymousClass37 anonymousClass37 = new AnonymousClass37();
        AnonymousClass37 anonymousClass37A0X = anonymousClass37.A0n(bundle.getCharSequence(A02(0))).A0e(bundle.getCharSequence(A02(1))).A0d(bundle.getCharSequence(A02(2))).A0c(bundle.getCharSequence(A02(3))).A0j(bundle.getCharSequence(A02(4))).A0m(bundle.getCharSequence(A02(5))).A0i(bundle.getCharSequence(A02(6))).A0X((Uri) bundle.getParcelable(A02(7)));
        byte[] byteArray = bundle.getByteArray(A02(10));
        if (bundle.containsKey(A02(29))) {
            numValueOf = Integer.valueOf(bundle.getInt(A02(29)));
        } else {
            numValueOf = null;
        }
        anonymousClass37A0X.A10(byteArray, numValueOf).A0W((Uri) bundle.getParcelable(A02(11))).A0o(bundle.getCharSequence(A02(22))).A0g(bundle.getCharSequence(A02(23))).A0h(bundle.getCharSequence(A02(24))).A0k(bundle.getCharSequence(A02(27))).A0f(bundle.getCharSequence(A02(28))).A0l(bundle.getCharSequence(A02(30))).A0Y(bundle.getBundle(A02(1000)));
        if (bundle.containsKey(A02(8)) && (fieldBundle2 = bundle.getBundle(A02(8))) != null) {
            anonymousClass37.A0a((AbstractC1956pt) AbstractC1956pt.A03.A6f(fieldBundle2));
        }
        if (bundle.containsKey(A02(9)) && (fieldBundle = bundle.getBundle(A02(9))) != null) {
            anonymousClass37.A0Z((AbstractC1956pt) AbstractC1956pt.A03.A6f(fieldBundle));
        }
        if (bundle.containsKey(A02(12))) {
            anonymousClass37.A0z(Integer.valueOf(bundle.getInt(A02(12))));
        }
        if (bundle.containsKey(A02(13))) {
            anonymousClass37.A0y(Integer.valueOf(bundle.getInt(A02(13))));
        }
        if (bundle.containsKey(A02(14))) {
            anonymousClass37.A0q(Integer.valueOf(bundle.getInt(A02(14))));
        }
        if (bundle.containsKey(A02(15))) {
            anonymousClass37.A0b(Boolean.valueOf(bundle.getBoolean(A02(15))));
        }
        if (bundle.containsKey(A02(16))) {
            anonymousClass37.A0t(Integer.valueOf(bundle.getInt(A02(16))));
        }
        if (bundle.containsKey(A02(17))) {
            anonymousClass37.A0s(Integer.valueOf(bundle.getInt(A02(17))));
        }
        if (bundle.containsKey(A02(18))) {
            anonymousClass37.A0r(Integer.valueOf(bundle.getInt(A02(18))));
        }
        if (bundle.containsKey(A02(19))) {
            anonymousClass37.A0w(Integer.valueOf(bundle.getInt(A02(19))));
        }
        if (bundle.containsKey(A02(20))) {
            anonymousClass37.A0v(Integer.valueOf(bundle.getInt(A02(20))));
        }
        if (bundle.containsKey(A02(21))) {
            anonymousClass37.A0u(Integer.valueOf(bundle.getInt(A02(21))));
        }
        if (bundle.containsKey(A02(25))) {
            anonymousClass37.A0p(Integer.valueOf(bundle.getInt(A02(25))));
        }
        if (bundle.containsKey(A02(26))) {
            anonymousClass37.A0x(Integer.valueOf(bundle.getInt(A02(26))));
        }
        return anonymousClass37.A11();
    }

    public static String A02(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1965q2 c1965q2 = (C1965q2) obj;
        if (C5C.A1E(this.A0H, c1965q2.A0H) && C5C.A1E(this.A08, c1965q2.A08) && C5C.A1E(this.A07, c1965q2.A07) && C5C.A1E(this.A06, c1965q2.A06) && C5C.A1E(this.A0D, c1965q2.A0D) && C5C.A1E(this.A0G, c1965q2.A0G) && C5C.A1E(this.A0C, c1965q2.A0C) && C5C.A1E(this.A01, c1965q2.A01) && C5C.A1E(this.A04, c1965q2.A04) && C5C.A1E(this.A03, c1965q2.A03)) {
            byte[] bArr = this.A0W;
            if (A0X[7].length() == 26) {
                throw new RuntimeException();
            }
            A0X[7] = "M3w6qihAe";
            if (Arrays.equals(bArr, c1965q2.A0W) && C5C.A1E(this.A0J, c1965q2.A0J) && C5C.A1E(this.A00, c1965q2.A00)) {
                boolean zA1E = C5C.A1E(this.A0U, c1965q2.A0U);
                if (A0X[1].charAt(3) != 'C') {
                    A0X[1] = "sGLE1KFsO49Fm5sc1i2fDCDxvKajbosH";
                    if (zA1E) {
                        if (C5C.A1E(this.A0T, c1965q2.A0T) && C5C.A1E(this.A0L, c1965q2.A0L) && C5C.A1E(this.A05, c1965q2.A05)) {
                            Integer num = this.A0O;
                            String[] strArr = A0X;
                            if (strArr[5].charAt(18) != strArr[3].charAt(18)) {
                                if (C5C.A1E(num, c1965q2.A0O)) {
                                    if (C5C.A1E(this.A0N, c1965q2.A0N) && C5C.A1E(this.A0M, c1965q2.A0M) && C5C.A1E(this.A0R, c1965q2.A0R) && C5C.A1E(this.A0Q, c1965q2.A0Q) && C5C.A1E(this.A0P, c1965q2.A0P) && C5C.A1E(this.A0I, c1965q2.A0I) && C5C.A1E(this.A0A, c1965q2.A0A) && C5C.A1E(this.A0B, c1965q2.A0B) && C5C.A1E(this.A0K, c1965q2.A0K) && C5C.A1E(this.A0S, c1965q2.A0S) && C5C.A1E(this.A0E, c1965q2.A0E) && C5C.A1E(this.A09, c1965q2.A09) && C5C.A1E(this.A0F, c1965q2.A0F)) {
                                        return true;
                                    }
                                }
                            } else {
                                A0X[1] = "FzzazV5V7n9nSTJyboWGAvjneHgdA0Tq";
                                if (C5C.A1E(num, c1965q2.A0O)) {
                                }
                            }
                        }
                    }
                } else {
                    String[] strArr2 = A0X;
                    strArr2[5] = "7vhYmT0vu97iLL1XFRgpkTAhMizvZPwW";
                    strArr2[3] = "Q2QItTO3MMpvxLwffhgMDG758PSZ9Zd3";
                    if (zA1E) {
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return CB.A00(this.A0H, this.A08, this.A07, this.A06, this.A0D, this.A0G, this.A0C, this.A01, this.A04, this.A03, Integer.valueOf(Arrays.hashCode(this.A0W)), this.A0J, this.A00, this.A0U, this.A0T, this.A0L, this.A05, this.A0O, this.A0N, this.A0M, this.A0R, this.A0Q, this.A0P, this.A0I, this.A0A, this.A0B, this.A0K, this.A0S, this.A0E, this.A09, this.A0F);
    }
}
