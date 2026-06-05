package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DS implements InterfaceC1335fK {
    public TransitionDrawable A00;
    public TransitionDrawable A01;
    public final int A03;
    public final Drawable A04;
    public final Drawable A05;
    public final View A07;
    public final Handler A06 = new Handler();
    public EnumC1334fJ A02 = EnumC1334fJ.A04;

    public DS(View view, int i, Drawable drawable, Drawable drawable2) {
        this.A03 = i;
        this.A07 = view;
        this.A05 = drawable;
        this.A04 = drawable2;
        this.A01 = new TransitionDrawable(new Drawable[]{drawable, drawable2});
        this.A01.setCrossFadeEnabled(true);
        this.A00 = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        this.A00.setCrossFadeEnabled(true);
        YB.A0V(this.A07, this.A01);
    }

    private void A04(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = EnumC1334fJ.A05;
            YB.A0V(this.A07, this.A00);
            this.A00.startTransition(this.A03);
            this.A06.postDelayed(new DV(this), this.A03);
            return;
        }
        YB.A0V(this.A07, this.A05);
        this.A02 = EnumC1334fJ.A04;
    }

    private void A05(boolean z) {
        this.A06.removeCallbacksAndMessages(null);
        if (z) {
            this.A02 = EnumC1334fJ.A03;
            YB.A0V(this.A07, this.A01);
            this.A01.startTransition(this.A03);
            this.A06.postDelayed(new DY(this), this.A03);
            return;
        }
        YB.A0V(this.A07, this.A04);
        this.A02 = EnumC1334fJ.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1335fK
    public final void A4A(boolean z, boolean z2) {
        if (z2) {
            A04(z);
        } else {
            A05(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1335fK
    public final EnumC1334fJ A9B() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1335fK
    public final void cancel() {
        EnumC1334fJ enumC1334fJ;
        this.A06.removeCallbacksAndMessages(null);
        this.A01.resetTransition();
        this.A00.resetTransition();
        if (this.A02 == EnumC1334fJ.A03) {
            enumC1334fJ = EnumC1334fJ.A04;
        } else {
            enumC1334fJ = EnumC1334fJ.A02;
        }
        this.A02 = enumC1334fJ;
    }
}
