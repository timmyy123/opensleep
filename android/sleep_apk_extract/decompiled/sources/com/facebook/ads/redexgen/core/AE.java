package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AE implements InterfaceC1890oo, InterfaceC03007p {
    public int A00;
    public int A01;
    public long A02;
    public long A04;
    public C03037s A05;
    public C8O A06;
    public DT A07;
    public boolean A08;
    public boolean A09;
    public C1981qI[] A0A;
    public final int A0C;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D18870411: Adding start stall debug reason")
    public EnumC1547ir A0B = EnumC1547ir.A09;
    public final C02846z A0D = new C02846z();
    public long A03 = Long.MIN_VALUE;

    public abstract void A1Z();

    public abstract void A1a(long j, boolean z) throws AD;

    public abstract void A1c(C1981qI[] c1981qIArr, long j, long j2) throws AD;

    public AE(int i) {
        this.A0C = i;
    }

    private final int A1O() {
        return this.A00;
    }

    private void A1P(long j, boolean z) throws AD {
        this.A08 = false;
        this.A02 = j;
        this.A03 = j;
        A1a(j, z);
    }

    public final int A1Q(long j) {
        return ((DT) AbstractC02053y.A01(this.A07)).AK2(j - this.A04);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Keep track of the non-adjusted timestamp")
    public final int A1R(C02846z c02846z, C1902p0 c1902p0, int i) {
        int iAHP = ((DT) AbstractC02053y.A01(this.A07)).AHP(c02846z, c1902p0, i);
        if (iAHP == -4) {
            if (c1902p0.A05()) {
                this.A03 = Long.MIN_VALUE;
                return this.A08 ? -4 : -3;
            }
            c1902p0.A00 = c1902p0.A01;
            c1902p0.A01 += this.A04;
            this.A03 = Math.max(this.A03, c1902p0.A01);
        } else if (iAHP == -5) {
            C1981qI c1981qI = (C1981qI) AbstractC02053y.A01(c02846z.A00);
            if (c1981qI.A0M != Long.MAX_VALUE) {
                c02846z.A00 = c1981qI.A07().A0s(c1981qI.A0M + this.A04).A14();
            }
        }
        return iAHP;
    }

    public final AD A1S(Throwable th, C1981qI c1981qI, int i) {
        return A1T(th, c1981qI, false, i);
    }

    public final AD A1T(Throwable th, C1981qI c1981qI, boolean z, int i) {
        int iA03 = 4;
        if (c1981qI != null && !this.A09) {
            this.A09 = true;
            try {
                int formatSupport = AKM(c1981qI);
                iA03 = AbstractC02937i.A03(formatSupport);
            } catch (AD unused) {
            } catch (Throwable th2) {
                this.A09 = false;
                throw th2;
            }
            this.A09 = false;
        }
        return AD.A04(th, getName(), A1O(), c1981qI, iA03, z, i);
    }

    public final C02846z A1U() {
        this.A0D.A00();
        return this.A0D;
    }

    public final C03037s A1V() {
        return (C03037s) AbstractC02053y.A01(this.A05);
    }

    public final C8O A1W() {
        return (C8O) AbstractC02053y.A01(this.A06);
    }

    public void A1X() throws AD {
    }

    public void A1Y() {
    }

    public void A1b(boolean z, boolean z2) throws AD {
    }

    public final boolean A1d() {
        return A9p() ? this.A08 : ((DT) AbstractC02053y.A01(this.A07)).AAe();
    }

    public final C1981qI[] A1e() {
        return (C1981qI[]) AbstractC02053y.A01(this.A0A);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void A5x() {
        AbstractC02053y.A08(this.A01 == 1);
        this.A0D.A00();
        this.A01 = 0;
        this.A07 = null;
        this.A0A = null;
        this.A08 = false;
        A1Z();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void A6L(C03037s c03037s, C1981qI[] c1981qIArr, DT dt, long j, boolean z, boolean z2, long j2, long j3) throws AD {
        AbstractC02053y.A08(this.A01 == 0);
        this.A05 = c03037s;
        this.A01 = 1;
        A1b(z, z2);
        AIa(c1981qIArr, dt, j2, j3);
        A1P(j, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final InterfaceC03007p A7D() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public AnonymousClass78 A8T() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D18870411: Adding start stall debug reason")
    public final EnumC1547ir A99() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final int A9A() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final DT A9D() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo, com.facebook.ads.redexgen.core.InterfaceC03007p
    public final int A9N() {
        return this.A0C;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC02877c
    public void A9i(int i, Object obj) throws AD {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final boolean A9p() {
        return this.A03 == Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void AA9(int i, C8O c8o) {
        this.A00 = i;
        this.A06 = c8o;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final boolean AAN() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void ACU() throws IOException {
        ((DT) AbstractC02053y.A01(this.A07)).ACR();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void AIa(C1981qI[] c1981qIArr, DT dt, long j, long j2) throws AD {
        AbstractC02053y.A08(!this.A08);
        this.A07 = dt;
        if (this.A03 == Long.MIN_VALUE) {
            this.A03 = j;
        }
        this.A0A = c1981qIArr;
        this.A04 = j2;
        A1c(c1981qIArr, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void AIm(long j) throws AD {
        A1P(j, false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void AJN() {
        this.A08 = true;
    }

    public int AKO() throws AD {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void start() throws AD {
        AbstractC02053y.A08(this.A01 == 1);
        this.A01 = 2;
        A1X();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1890oo
    public final void stop() {
        AbstractC02053y.A08(this.A01 == 2);
        this.A01 = 1;
        A1Y();
    }
}
