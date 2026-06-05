package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC1088bJ implements View.OnClickListener {
    public final /* synthetic */ LK A00;

    public ViewOnClickListenerC1088bJ(LK lk) {
        this.A00 = lk;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0I.getVisibility() != 8) {
                this.A00.A0W();
                this.A00.A0G.removeCallbacks(this.A00.A0X);
                this.A00.A0t(8);
            } else {
                this.A00.A0t(0);
                this.A00.A0G.postDelayed(this.A00.A0X, 1500L);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
