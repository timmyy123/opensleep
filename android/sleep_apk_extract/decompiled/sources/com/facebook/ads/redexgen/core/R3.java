package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class R3 extends ViewGroup.MarginLayoutParams {
    public RK A00;
    public boolean A01;
    public boolean A02;
    public final Rect A03;

    public R3(int i, int i2) {
        super(i, i2);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public R3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public R3(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public R3(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public R3(R3 r3) {
        super((ViewGroup.LayoutParams) r3);
        this.A03 = new Rect();
        this.A01 = true;
        this.A02 = false;
    }

    public final int A00() {
        return this.A00.A0O();
    }

    public final boolean A01() {
        return this.A00.A0j();
    }

    public final boolean A02() {
        return this.A00.A0g();
    }

    public final boolean A03() {
        return this.A00.A0f();
    }
}
