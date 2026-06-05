package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnClickListenerC0998Zr implements View.OnClickListener {
    public final /* synthetic */ C0715Ok A00;
    public final /* synthetic */ C0988Zh A01;
    public final /* synthetic */ MD A02;

    public ViewOnClickListenerC0998Zr(MD md, C0988Zh c0988Zh, C0715Ok c0715Ok) {
        this.A02 = md;
        this.A01 = c0988Zh;
        this.A00 = c0715Ok;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A0D.AF4(this.A00);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
