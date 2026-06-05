package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.az, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1068az implements Runnable {
    public final /* synthetic */ C1069b0 A00;
    public final /* synthetic */ InterfaceC1070b1 A01;

    public RunnableC1068az(C1069b0 c1069b0, InterfaceC1070b1 interfaceC1070b1) {
        this.A00 = c1069b0;
        this.A01 = interfaceC1070b1;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A01.ACz();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
