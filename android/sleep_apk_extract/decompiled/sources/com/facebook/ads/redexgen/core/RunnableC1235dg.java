package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1235dg implements Runnable {
    public final /* synthetic */ AnonymousClass55 A00;

    public RunnableC1235dg(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0B = true;
            this.A00.A0Z.AFw(true);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
