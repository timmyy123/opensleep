package com.facebook.ads.redexgen.core;

import android.app.Activity;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class X0 {
    public static final X0 A04 = new X0(new C0778Qz(), new C0774Qv());
    public final InterfaceC0928Wz A02;
    public final Y0 A03;
    public boolean A01 = true;
    public long A00 = -1;

    public X0(Y0 y0, InterfaceC0928Wz interfaceC0928Wz) {
        this.A03 = y0;
        this.A02 = interfaceC0928Wz;
    }

    public static X0 A00() {
        return A04;
    }

    public final synchronized void A01() {
        this.A01 = false;
        this.A00 = this.A03.A5n();
    }

    public final synchronized void A02() {
        this.A00 = -1L;
    }

    public final boolean A03() {
        Activity lastResumedActivity = this.A02.A8M();
        boolean z = true;
        if (lastResumedActivity != null) {
            return true;
        }
        synchronized (X0.class) {
            if (this.A01) {
                return true;
            }
            if (this.A00 >= 0 && this.A03.A5n() - this.A00 >= 1000) {
                z = false;
            }
            return z;
        }
    }
}
