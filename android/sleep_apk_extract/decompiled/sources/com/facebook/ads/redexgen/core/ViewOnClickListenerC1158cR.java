package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1158cR implements View.OnClickListener {
    public final /* synthetic */ KE A00;

    public ViewOnClickListenerC1158cR(KE ke) {
        this.A00 = ke;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A0M) {
                this.A00.A0N = true;
                if (this.A00.A0b != null) {
                    this.A00.A0f(((AnonymousClass85) this.A00.A0b).A0M().toString());
                }
                if (this.A00.A0E.A0q() >= 0) {
                    this.A00.A08.postDelayed(this.A00.A0h, this.A00.A0E.A0q());
                }
            }
            this.A00.A0i(this.A00.A0M ? false : true);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
