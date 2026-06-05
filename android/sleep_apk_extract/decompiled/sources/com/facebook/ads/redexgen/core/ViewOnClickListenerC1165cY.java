package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1165cY implements View.OnClickListener {
    public final /* synthetic */ KB A00;

    public ViewOnClickListenerC1165cY(KB kb) {
        this.A00 = kb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A03 == null || this.A00.A03.getVisibility() != 8) {
                this.A00.A0P();
                this.A00.A0B.removeCallbacks(this.A00.A0V);
                this.A00.A0T(8);
            } else {
                this.A00.A0T(0);
                this.A00.A0B.postDelayed(this.A00.A0V, 1500L);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
