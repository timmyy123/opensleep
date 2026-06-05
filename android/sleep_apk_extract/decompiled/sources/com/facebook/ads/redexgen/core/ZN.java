package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ZN implements View.OnClickListener {
    public final /* synthetic */ MI A00;

    public ZN(MI mi) {
        this.A00 = mi;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A07.ADv();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
