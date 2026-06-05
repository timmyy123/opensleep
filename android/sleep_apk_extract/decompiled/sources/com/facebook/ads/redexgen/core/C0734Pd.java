package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0734Pd implements InterfaceC1059aq {
    public static byte[] A01;
    public final /* synthetic */ ViewOnClickListenerC02826x A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-36, -38, -52, -39, -58, -55, -36, -51, -51, -52, -39, -52, -53, -58, -54, -45, -48, -54, -46, -58, -48, -56, -55, -58, -43, -56, -35, -48, -50, -56, -37, -48, -42, -43};
    }

    public C0734Pd(ViewOnClickListenerC02826x viewOnClickListenerC02826x) {
        this.A00 = viewOnClickListenerC02826x;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AF7(String str) {
        this.A00.A0C.setProgress(100);
        ((PZ) this.A00).A05 = false;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AF9(String str) {
        ((PZ) this.A00).A05 = true;
        this.A00.A0F.setUrl(str);
        if (this.A00.A00 > 1) {
            this.A00.A0I(A00(0, 34, 31));
        }
        ViewOnClickListenerC02826x.A02(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AFY(int i) {
        if (((PZ) this.A00).A05) {
            this.A00.A0C.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AFb(String str) {
        this.A00.A0F.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059aq
    public final void AFe() {
        this.A00.A0B.ADJ(14);
    }
}
