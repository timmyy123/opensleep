package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnLongClickListenerC0790Rl implements View.OnLongClickListener {
    public final /* synthetic */ C1461hM A00;
    public final /* synthetic */ C1075b6 A01;

    public ViewOnLongClickListenerC0790Rl(C1461hM c1461hM, C1075b6 c1075b6) {
        this.A00 = c1461hM;
        this.A01 = c1075b6;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (this.A00.A00 != null) {
            this.A01.setBounds(0, 0, this.A00.A00.getWidth(), this.A00.A00.getHeight());
            this.A01.A0D(!this.A01.A0E());
        }
        return true;
    }
}
