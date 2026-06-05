package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1791nC implements F0 {
    public int A00;
    public int A01;
    public int A02;
    public C0472Ey[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;

    public C1791nC(boolean z, int i) {
        this(z, i, 0);
    }

    public C1791nC(boolean z, int i, int i2) {
        AbstractC02053y.A07(i > 0);
        AbstractC02053y.A07(i2 >= 0);
        this.A05 = z;
        this.A04 = i;
        this.A01 = i2;
        this.A03 = new C0472Ey[i2 + 100];
        if (i2 > 0) {
            this.A06 = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.A03[i3] = new C0472Ey(this.A06, i3 * i);
            }
            return;
        }
        this.A06 = null;
    }

    public final synchronized int A00() {
        return this.A00 * this.A04;
    }

    public final synchronized void A01() {
        if (this.A05) {
            A02(0);
        }
    }

    public final synchronized void A02(int i) {
        boolean targetBufferSizeReduced = i < this.A02;
        this.A02 = i;
        if (targetBufferSizeReduced) {
            AKT();
        }
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized C0472Ey A49() {
        C0472Ey c0472Ey;
        this.A00++;
        if (this.A01 > 0) {
            C0472Ey[] c0472EyArr = this.A03;
            int i = this.A01 - 1;
            this.A01 = i;
            c0472Ey = (C0472Ey) AbstractC02053y.A01(c0472EyArr[i]);
            this.A03[this.A01] = null;
        } else {
            c0472Ey = new C0472Ey(new byte[this.A04], 0);
            if (this.A00 > this.A03.length) {
                this.A03 = (C0472Ey[]) Arrays.copyOf(this.A03, this.A03.length * 2);
            }
        }
        return c0472Ey;
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final int A8I() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized void AHd(C0472Ey c0472Ey) {
        C0472Ey[] c0472EyArr = this.A03;
        int i = this.A01;
        this.A01 = i + 1;
        c0472EyArr[i] = c0472Ey;
        this.A00--;
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized void AHe(InterfaceC0473Ez interfaceC0473Ez) {
        while (interfaceC0473Ez != null) {
            C0472Ey[] c0472EyArr = this.A03;
            int i = this.A01;
            this.A01 = i + 1;
            c0472EyArr[i] = interfaceC0473Ez.A6u();
            this.A00--;
            interfaceC0473Ez = interfaceC0473Ez.ACc();
        }
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.core.F0
    public final synchronized void AKT() {
        int iA05 = C5C.A05(this.A02, this.A04);
        int targetAllocationCount = this.A00;
        int iMax = Math.max(0, iA05 - targetAllocationCount);
        int targetAllocationCount2 = this.A01;
        if (iMax >= targetAllocationCount2) {
            return;
        }
        if (this.A06 != null) {
            int lowIndex = 0;
            int targetAllocationCount3 = this.A01;
            int highIndex = targetAllocationCount3 - 1;
            while (lowIndex <= highIndex) {
                C0472Ey highAllocation = (C0472Ey) AbstractC02053y.A01(this.A03[lowIndex]);
                if (highAllocation.A01 == this.A06) {
                    lowIndex++;
                } else {
                    C0472Ey lowAllocation = (C0472Ey) AbstractC02053y.A01(this.A03[highIndex]);
                    if (lowAllocation.A01 != this.A06) {
                        highIndex--;
                    } else {
                        this.A03[lowIndex] = lowAllocation;
                        int targetAllocationCount4 = highIndex - 1;
                        this.A03[highIndex] = highAllocation;
                        highIndex = targetAllocationCount4;
                        lowIndex++;
                    }
                }
            }
            iMax = Math.max(iMax, lowIndex);
            int targetAllocationCount5 = this.A01;
            if (iMax >= targetAllocationCount5) {
                return;
            }
        }
        C0472Ey[] c0472EyArr = this.A03;
        int targetAvailableCount = this.A01;
        Arrays.fill(c0472EyArr, iMax, targetAvailableCount, (Object) null);
        this.A01 = iMax;
    }
}
