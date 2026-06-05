package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1866oQ implements InterfaceC01913k {
    public boolean A04;
    public ByteBuffer A02 = InterfaceC01913k.A00;
    public ByteBuffer A03 = InterfaceC01913k.A00;
    public C01893i A00 = C01893i.A05;
    public C01893i A01 = C01893i.A05;
    public C01893i A05 = C01893i.A05;
    public C01893i A06 = C01893i.A05;

    public abstract C01893i A09(C01893i c01893i) throws C01903j;

    public final ByteBuffer A00(int i) {
        if (this.A02.capacity() < i) {
            this.A02 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        this.A03 = this.A02;
        return this.A02;
    }

    public final boolean A01() {
        return this.A03.hasRemaining();
    }

    public void A0A() {
    }

    public void A0B() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public final C01893i A57(C01893i c01893i) throws C01903j {
        this.A00 = c01893i;
        this.A01 = A09(c01893i);
        return AAL() ? this.A01 : C01893i.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public ByteBuffer A8d() {
        ByteBuffer byteBuffer = this.A03;
        ByteBuffer outputBuffer = InterfaceC01913k.A00;
        this.A03 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public boolean AAL() {
        return this.A01 != C01893i.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public boolean AAP() {
        return this.A04 && this.A03 == InterfaceC01913k.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public final void AHG() {
        this.A04 = true;
        A0B();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public final void flush() {
        this.A03 = InterfaceC01913k.A00;
        this.A04 = false;
        this.A05 = this.A00;
        this.A06 = this.A01;
        A0A();
    }
}
