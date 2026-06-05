package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ds, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1246ds implements Runnable {
    public final /* synthetic */ GS A00;

    public RunnableC1246ds(GS gs) {
        this.A00 = gs;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0H(VH.A0b);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
