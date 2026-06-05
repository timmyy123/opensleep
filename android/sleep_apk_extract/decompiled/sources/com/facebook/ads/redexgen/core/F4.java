package com.facebook.ads.redexgen.core;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class F4 {
    public final CopyOnWriteArrayList<F3> A00 = new CopyOnWriteArrayList<>();

    public final void A00(int i, long j, long j2) {
        Iterator<F3> it = this.A00.iterator();
        if (it.hasNext()) {
            it.next();
            F3.A02(null);
            throw null;
        }
    }
}
