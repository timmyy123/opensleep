package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0498Fz implements InterfaceC1185cs {
    public final /* synthetic */ C0497Fy A00;

    public C0498Fz(C0497Fy c0497Fy) {
        this.A00 = c0497Fy;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1185cs
    public final void AGW(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1185cs
    public final void AGY(View view) {
        AbstractC0582Jg abstractC0582Jg = (AbstractC0582Jg) view;
        abstractC0582Jg.A1T();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) abstractC0582Jg.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
