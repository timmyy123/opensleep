package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YJ implements View.OnTouchListener {
    public final GestureDetector A00;

    public YJ(int i, int i2, Context context, YI yi) {
        this.A00 = new GestureDetector(context, new YH(this, yi, i, i2));
    }

    public final void A00(View view) {
        if (view != null) {
            view.setOnTouchListener(this);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.A00.onTouchEvent(motionEvent);
    }
}
