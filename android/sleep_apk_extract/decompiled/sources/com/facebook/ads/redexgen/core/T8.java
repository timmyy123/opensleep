package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class T8 extends ContextWrapper {
    public final TA A00;
    public final AtomicReference<String> A01;

    public T8(Context context, TA ta) {
        super(context.getApplicationContext());
        this.A01 = new AtomicReference<>();
        this.A00 = ta;
    }

    public final InterfaceC0651Lx A00(T8 t8) {
        return this.A00.A8C(t8);
    }

    public final T1 A01() {
        return this.A00.A7G();
    }

    public final C1417ge A02() {
        return this.A00.A8z(this);
    }

    public final T9 A03() {
        return this.A00.A74(this);
    }

    public final TB A04() {
        return this.A00.A7x(this);
    }

    public final TD A05() {
        return this.A00.A8y(this);
    }

    public final TE A06() {
        return this.A00.A9F();
    }

    public final TP A07() {
        return this.A00.A7l(this);
    }

    public final InterfaceC0832Tc A08() {
        return this.A00.A7n(this);
    }

    public final U7 A09() {
        return this.A00.A96();
    }

    public final VA A0A() {
        return this.A00.A6n(A02());
    }

    public final VM A0B() {
        return this.A00.A90(A02());
    }

    public final String A0C() {
        return this.A01.get();
    }

    public final void A0D(String str) {
        this.A01.set(str);
    }
}
