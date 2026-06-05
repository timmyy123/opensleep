package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1461hM extends N2 {
    public static byte[] A03;
    public static String[] A04 = {"G2rh", "Fb5x", "6CyVQJjLjUxkB4NOtEwwqOuY7kB2daf", "v2svMG5ZVzKjVXyH1MXvdM9krQWCKsNq", "oRWr7RpHwOoI3beQIRyDA09DO9LlUwST", "SjgxBMhR0kRV74MEQavsGpgIJGrbvWLl", "8l9W", "lapvzpZuNASF"};
    public View A00;
    public final C0782Rd A01;
    public final AnonymousClass76 A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {69, 103, 104, 104, 105, 114, 38, 118, 116, 99, 117, 99, 104, 114, 38, 104, 115, 106, 106, 38, 103, 98, 80, 111, 99, 113};
        if (A04[7].length() == 31) {
            throw new RuntimeException();
        }
        A04[0] = "ScK1";
        A03 = bArr;
    }

    static {
        A03();
    }

    public C1461hM(C0782Rd c0782Rd) {
        this.A02 = c0782Rd.A09();
        this.A01 = c0782Rd;
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0C() {
        this.A02.A0F().A4U();
        WT.A00(new C1463hO(this));
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0D() {
        this.A02.A0F().A4X();
        WT.A00(new C1462hN(this));
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0E(View view) {
        if (view != null) {
            AnonymousClass76 anonymousClass76 = this.A02;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A04[0] = "eqHc";
            anonymousClass76.A0F().A4W();
            this.A00 = view;
            this.A01.A07().removeAllViews();
            this.A01.A07().addView(this.A00);
            if ((this.A00 instanceof LV) || (this.A00 instanceof Z2)) {
                AbstractC0898Vs.A01(this.A01.A05(), this.A00, this.A01.A0A());
            }
            C02957k controller = this.A01.A08();
            if (controller != null) {
                controller.A0L();
            }
            WT.A00(new C1464hP(this));
            this.A01.A0B(this.A01.A07(), this.A00);
            if (C0871Up.A1C(this.A01.A07().getContext())) {
                C1075b6 c1075b6 = new C1075b6();
                this.A01.A0D(c1075b6);
                c1075b6.A0C(this.A01.getPlacementId());
                c1075b6.A0B(this.A01.A07().getContext().getPackageName());
                if (this.A01.A08() != null && this.A01.A08().A0J() != null) {
                    c1075b6.A09(this.A01.A08().A0J().A0C());
                }
                if (this.A00 instanceof LV) {
                    c1075b6.A0A(((LV) this.A00).getViewabilityChecker());
                }
                this.A00.setOnLongClickListener(new ViewOnLongClickListenerC0790Rl(this, c1075b6));
                this.A00.getOverlay().add(c1075b6);
                return;
            }
            return;
        }
        throw new IllegalStateException(A02(0, 26, 22));
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0F(N1 n1) {
        this.A02.A0F().A4V(this.A01.A08() != null);
        if (this.A01.A08() != null) {
            this.A01.A08().A0M();
        }
    }

    @Override // com.facebook.ads.redexgen.core.N2
    public final void A0G(C0893Vm c0893Vm) {
        this.A02.A0F().A3N(Y1.A01(this.A01.A04()), c0893Vm.A03().getErrorCode(), c0893Vm.A04());
        WT.A00(new C1465hQ(this, c0893Vm));
    }
}
