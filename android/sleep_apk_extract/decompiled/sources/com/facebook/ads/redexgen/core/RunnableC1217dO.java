package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dO, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1217dO implements Runnable {
    public final /* synthetic */ C5S A00;

    public RunnableC1217dO(C5S c5s) {
        this.A00 = c5s;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A08 = true;
            this.A00.A0P.AFw(true);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
