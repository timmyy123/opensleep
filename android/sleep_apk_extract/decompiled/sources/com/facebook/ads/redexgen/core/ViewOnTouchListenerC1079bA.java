package com.facebook.ads.redexgen.core;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1079bA implements View.OnTouchListener {
    public final /* synthetic */ ViewOnClickListenerC1080bB A00;

    public ViewOnTouchListenerC1079bA(ViewOnClickListenerC1080bB viewOnClickListenerC1080bB) {
        this.A00 = viewOnClickListenerC1080bB;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.A00.A00(motionEvent.getX(), motionEvent.getY());
            return false;
        }
        return false;
    }
}
