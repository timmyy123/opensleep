package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class A7 extends AbstractC1866oQ {
    public int[] A00;
    public int[] A01;

    @Override // com.facebook.ads.redexgen.core.AbstractC1866oQ
    public final C01893i A09(C01893i c01893i) throws C01903j {
        int[] iArr = this.A01;
        if (iArr == null) {
            return C01893i.A05;
        }
        if (c01893i.A02 == 2) {
            int i = c01893i.A01 != iArr.length ? 1 : 0;
            int i2 = 0;
            while (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 < c01893i.A01) {
                    i |= i3 != i2 ? 1 : 0;
                    i2++;
                } else {
                    throw new C01903j(c01893i);
                }
            }
            if (i != 0) {
                return new C01893i(c01893i.A03, iArr.length, 2);
            }
            return C01893i.A05;
        }
        throw new C01903j(c01893i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1866oQ
    public final void A0A() {
        this.A00 = this.A01;
    }

    public final void A0C(int[] iArr) {
        this.A01 = iArr;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public final void AHH(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) AbstractC02053y.A01(this.A00);
        int iPosition = byteBuffer.position();
        int outputSize = byteBuffer.limit();
        int position = outputSize - iPosition;
        ByteBuffer byteBufferA00 = A00(this.A06.A00 * (position / this.A05.A00));
        while (iPosition < outputSize) {
            for (int i : iArr) {
                byteBufferA00.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.A05.A00;
        }
        byteBuffer.position(outputSize);
        byteBufferA00.flip();
    }
}
