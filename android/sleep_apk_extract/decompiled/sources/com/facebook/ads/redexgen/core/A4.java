package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class A4 implements InterfaceC01923l {
    public final C03489y A00;
    public final C1859oJ A01;
    public final InterfaceC01913k[] A02;

    public A4(InterfaceC01913k... interfaceC01913kArr) {
        this(interfaceC01913kArr, new C03489y(), new C1859oJ());
    }

    public A4(InterfaceC01913k[] interfaceC01913kArr, C03489y c03489y, C1859oJ c1859oJ) {
        this.A02 = new InterfaceC01913k[interfaceC01913kArr.length + 2];
        System.arraycopy(interfaceC01913kArr, 0, this.A02, 0, interfaceC01913kArr.length);
        this.A00 = c03489y;
        this.A01 = c1859oJ;
        this.A02[interfaceC01913kArr.length] = c03489y;
        this.A02[interfaceC01913kArr.length + 1] = c1859oJ;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01923l
    public final C1960px A4F(C1960px c1960px) {
        this.A01.A02(c1960px.A01);
        this.A01.A01(c1960px.A00);
        return c1960px;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01923l
    public final boolean A4G(boolean z) {
        this.A00.A0D(z);
        return z;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01923l
    public final InterfaceC01913k[] A6z() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01923l
    public final long A8U(long j) {
        return this.A01.A00(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01923l
    public final long A98() {
        return this.A00.A0C();
    }
}
