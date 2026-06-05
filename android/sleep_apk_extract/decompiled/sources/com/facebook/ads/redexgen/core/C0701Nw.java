package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0701Nw implements InterfaceC0955Ya {
    public static String[] A01 = {"dAENZa04S5kpLZ1505OVGzU", "BCWAX", "x4EBtM5L1", "d5mzvX7vdf5oGTbdkf23a85QS6J33UuP", "T3xMk8xyeuXfnP2cHDF22zgmf4sSWk7a", "D6RnJQb1nSkQk7teZoJG77p", "lMrZ8D5HcAsH09zpnUIM78ubrFXrhoz6", "r7D6OIPJDO7XxyVdFUwVLtQI1zZlrgYr"};
    public final /* synthetic */ NO A00;

    public C0701Nw(NO no) {
        this.A00 = no;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0955Ya
    public final void ACl(AbstractC0956Yb abstractC0956Yb) {
        if (this.A00.A0Y() && !this.A00.A0b.get()) {
            this.A00.A0Z.A07(this.A00);
            return;
        }
        NO no = this.A00;
        if (A01[4].charAt(5) == '8') {
            A01[1] = "011C";
            if (!no.A0d || this.A00.A0b.get() || !this.A00.A0X()) {
                this.A00.A0T.A04(VH.A07, null);
                if (this.A00.A0P.A0c()) {
                    this.A00.A0R.A0F().AEO();
                }
                this.A00.A0R.A0F().AB0();
                InterfaceC0962Yh interfaceC0962Yh = this.A00.A0W;
                String strA7w = this.A00.A0X.A7w();
                if (A01[6].charAt(7) != 'V') {
                    String[] strArr = A01;
                    strArr[3] = "iNY9OvP3hEWy4eydF9NsffnrPtCfLtIx";
                    strArr[7] = "zl19Behk0RYI4HrdG27XeFY6Dxp3Bz2i";
                    interfaceC0962Yh.A4j(strA7w);
                    return;
                }
            } else {
                this.A00.A0g.setToolbarActionMode(0);
                this.A00.A0N();
                return;
            }
        }
        throw new RuntimeException();
    }
}
