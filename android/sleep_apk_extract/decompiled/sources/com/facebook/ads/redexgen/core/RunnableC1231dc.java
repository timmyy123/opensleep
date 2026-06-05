package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1231dc implements Runnable {
    public final /* synthetic */ AnonymousClass55 A00;

    public RunnableC1231dc(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A07 != null && this.A00.getResources().getConfiguration().orientation == 1) {
                this.A00.A07.A0A();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
