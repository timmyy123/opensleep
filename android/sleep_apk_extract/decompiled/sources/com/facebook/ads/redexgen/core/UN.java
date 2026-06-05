package com.facebook.ads.redexgen.core;

import com.facebook.ads.redexgen.core.UL;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class UN<T extends UL> {
    public abstract Class<T> A01();

    public abstract void A03(T t);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.UN != com.facebook.ads.internal.events.EventSubscriber<T extends com.facebook.ads.redexgen.X.UL> */
    public final boolean A00(T event) {
        return true;
    }
}
