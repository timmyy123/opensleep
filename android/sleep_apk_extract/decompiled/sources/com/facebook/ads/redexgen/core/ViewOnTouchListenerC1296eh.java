package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1296eh implements View.OnTouchListener {
    public final /* synthetic */ C0458Ek A00;

    public ViewOnTouchListenerC1296eh(C0458Ek c0458Ek) {
        this.A00 = c0458Ek;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.A00.A0C.A02(new C0442Du(view, motionEvent));
        return false;
    }
}
