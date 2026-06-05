package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class VJ implements View.OnAttachStateChangeListener {
    public final /* synthetic */ VH A00;
    public final /* synthetic */ VI A01;

    public VJ(VI vi, VH vh) {
        this.A01 = vi;
        this.A00 = vh;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.A01.A04(this.A00, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
