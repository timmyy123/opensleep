package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class Z5 implements View.OnClickListener {
    public final /* synthetic */ NO A00;

    public Z5(NO no) {
        this.A00 = no;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0T.A04(VH.A07, null);
            this.A00.A0W.A4j(this.A00.A0X.A7w());
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
