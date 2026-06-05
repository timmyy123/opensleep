package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1594jl extends N3 {
    public static byte[] A06;
    public static final String A07;
    public C1596jn A00;
    public EnumC0895Vp A01;
    public boolean A02;
    public final C1421gi A03;
    public final VA A04;
    public final AbstractC1067ay A05;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A06 = new byte[]{-55, -56, -43, -43, -52, -39};
    }

    static {
        A05();
        A07 = C1594jl.class.getSimpleName();
    }

    public C1594jl(C1421gi c1421gi, VA va, AbstractC1067ay abstractC1067ay, C1366fp c1366fp, N4 n4, EnumC0895Vp enumC0895Vp) {
        super(c1421gi, n4, c1366fp);
        this.A04 = va;
        this.A05 = abstractC1067ay;
        this.A03 = c1421gi;
        this.A01 = enumC0895Vp;
    }

    @Override // com.facebook.ads.redexgen.core.N3
    public final void A08(Map<String, String> map) {
        String string;
        if (this.A00 != null && !TextUtils.isEmpty(this.A00.A7O())) {
            this.A03.A0F().A3L();
            AbstractC0705Oa.A02(this.A00.A05(), AbstractC0941Xm.A00(A04(0, 6, 50)));
            this.A04.ABJ(this.A00.A7O(), map);
            if (C0871Up.A1A(this.A03)) {
                if (this.A01 == EnumC0895Vp.A09) {
                    string = AdPlacementType.MEDIUM_RECTANGLE.toString();
                } else {
                    string = AdPlacementType.BANNER.toString();
                }
                C0917Wl c0917WlA00 = C0917Wl.A00(this.A03);
                String placementType = this.A00.A7O();
                c0917WlA00.A0E(string, placementType);
            }
        }
    }

    public final synchronized void A09() {
        if (!this.A02 && this.A00 != null) {
            this.A02 = true;
            if (!TextUtils.isEmpty(this.A00.A03())) {
                Y4.A00(new C1595jm(this));
            }
        }
    }

    public final void A0A(C1596jn c1596jn) {
        this.A00 = c1596jn;
    }
}
