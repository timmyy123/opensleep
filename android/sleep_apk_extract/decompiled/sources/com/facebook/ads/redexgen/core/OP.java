package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class OP {

    @Nullable
    public static OO A00;
    public static final AtomicBoolean A01 = new AtomicBoolean();

    public static OO A00(C1417ge c1417ge) {
        if (A00 == null) {
            A00 = new OO(c1417ge);
        }
        return A00;
    }

    public static void A01(C1417ge c1417ge) {
        if (AbstractC0874Us.A0F(c1417ge)) {
            A03(c1417ge);
        }
    }

    public static void A02(C1417ge c1417ge) {
        if (AbstractC0874Us.A0E(c1417ge)) {
            A03(c1417ge);
        }
    }

    public static void A03(C1417ge c1417ge) {
        if (A01.compareAndSet(false, true)) {
            Y4.A01.execute(new C1520iN(c1417ge));
        }
    }
}
