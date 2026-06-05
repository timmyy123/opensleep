package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ZY implements View.OnClickListener {
    public final /* synthetic */ C0982Zb A00;

    public ZY(C0982Zb c0982Zb) {
        this.A00 = c0982Zb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A05) {
                this.A00.A04.A53();
            } else {
                this.A00.A04.A54();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
