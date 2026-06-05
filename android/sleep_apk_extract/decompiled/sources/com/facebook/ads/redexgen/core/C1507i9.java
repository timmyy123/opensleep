package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.i9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1507i9 implements InterfaceC0725Ou {
    private C0726Ov A00(InterfaceC0724Ot interfaceC0724Ot) {
        return (C0726Ov) interfaceC0724Ot.A7E();
    }

    public final void A01(InterfaceC0724Ot interfaceC0724Ot) {
        if (!interfaceC0724Ot.A9R()) {
            interfaceC0724Ot.AJl(0, 0, 0, 0);
            return;
        }
        float fA8S = A8S(interfaceC0724Ot);
        float fA8r = A8r(interfaceC0724Ot);
        float elevation = AbstractC0728Ox.A00(fA8S, fA8r, interfaceC0724Ot.A8q());
        int vPadding = (int) Math.ceil(elevation);
        float elevation2 = AbstractC0728Ox.A01(fA8S, fA8r, interfaceC0724Ot.A8q());
        int iCeil = (int) Math.ceil(elevation2);
        interfaceC0724Ot.AJl(vPadding, iCeil, vPadding, iCeil);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final ColorStateList A71(InterfaceC0724Ot interfaceC0724Ot) {
        return A00(interfaceC0724Ot).A05();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final float A7v(InterfaceC0724Ot interfaceC0724Ot) {
        return interfaceC0724Ot.A7F().getElevation();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final float A8S(InterfaceC0724Ot interfaceC0724Ot) {
        return A00(interfaceC0724Ot).A03();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final float A8X(InterfaceC0724Ot interfaceC0724Ot) {
        return A8r(interfaceC0724Ot) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final float A8Y(InterfaceC0724Ot interfaceC0724Ot) {
        return A8r(interfaceC0724Ot) * 2.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final float A8r(InterfaceC0724Ot interfaceC0724Ot) {
        return A00(interfaceC0724Ot).A04();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void AAE() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void AAG(InterfaceC0724Ot interfaceC0724Ot, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C0726Ov background = new C0726Ov(colorStateList, f);
        interfaceC0724Ot.AJK(background);
        View view = interfaceC0724Ot.A7F();
        view.setClipToOutline(true);
        view.setElevation(f2);
        AJX(interfaceC0724Ot, f3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void ADP(InterfaceC0724Ot interfaceC0724Ot) {
        AJX(interfaceC0724Ot, A8S(interfaceC0724Ot));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void AFT(InterfaceC0724Ot interfaceC0724Ot) {
        AJX(interfaceC0724Ot, A8S(interfaceC0724Ot));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void AJJ(InterfaceC0724Ot interfaceC0724Ot, ColorStateList colorStateList) {
        A00(interfaceC0724Ot).A08(colorStateList);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void AJP(InterfaceC0724Ot interfaceC0724Ot, float f) {
        interfaceC0724Ot.A7F().setElevation(f);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void AJX(InterfaceC0724Ot interfaceC0724Ot, float f) {
        A00(interfaceC0724Ot).A07(f, interfaceC0724Ot.A9R(), interfaceC0724Ot.A8q());
        A01(interfaceC0724Ot);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0725Ou
    public final void AJj(InterfaceC0724Ot interfaceC0724Ot, float f) {
        A00(interfaceC0724Ot).A06(f);
    }
}
