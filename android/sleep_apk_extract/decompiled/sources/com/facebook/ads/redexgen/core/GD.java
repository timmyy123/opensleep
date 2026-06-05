package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class GD implements InterfaceC1252dy {
    public final /* synthetic */ GB A00;

    public GD(GB gb) {
        this.A00 = gb;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1252dy
    public final void AIY() {
        this.A00.A0B();
        if (!this.A00.A0E || this.A00.A01 == null) {
            if (this.A00.A07 == null) {
                this.A00.A0C.A4j(this.A00.A0D.A81());
                this.A00.A0C.A4j(this.A00.A0D.A7w());
                return;
            }
            this.A00.A04 = this.A00.A05(this.A00.A0D, this.A00.A07, Boolean.valueOf(this.A00.A05.A1n()));
            if (this.A00.A02 != null && this.A00.A00 != null) {
                this.A00.A04.AAu(this.A00.A02, this.A00.A03, this.A00.A00);
                return;
            }
            return;
        }
        if (this.A00.A01 instanceof MW) {
            this.A00.A04 = this.A00.A01;
            ((MW) this.A00.A04).A0b();
        }
    }
}
