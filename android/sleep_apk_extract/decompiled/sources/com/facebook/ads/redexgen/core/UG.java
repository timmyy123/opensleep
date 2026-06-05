package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class UG {
    public static UG A00 = new UG();

    public static UG A00() {
        return A00;
    }

    public final ZJ A01(T8 t8, boolean z) {
        return new ZJ(t8, z, new C0817Sn());
    }

    public final Map<String, String> A02(T8 t8) {
        try {
            return A01(t8, false).A06();
        } catch (Throwable th) {
            t8.A08().A4I(th);
            return U8.A01(t8);
        }
    }
}
