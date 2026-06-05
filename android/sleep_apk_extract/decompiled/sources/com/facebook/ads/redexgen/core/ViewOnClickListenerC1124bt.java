package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1124bt implements View.OnClickListener {
    public final /* synthetic */ ViewOnClickListenerC0619Kr A00;
    public final /* synthetic */ String A01;

    public ViewOnClickListenerC1124bt(ViewOnClickListenerC0619Kr viewOnClickListenerC0619Kr, String str) {
        this.A00 = viewOnClickListenerC0619Kr;
        this.A01 = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0E(this.A01);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
