package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.text.Layout;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C01953o {
    public float A00;
    public float A01;
    public float A02;
    public float A03;
    public float A04;
    public float A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public int A0B;
    public Bitmap A0C;
    public Layout.Alignment A0D;
    public Layout.Alignment A0E;
    public CharSequence A0F;
    public boolean A0G;

    public C01953o() {
        this.A0F = null;
        this.A0C = null;
        this.A0E = null;
        this.A0D = null;
        this.A01 = -3.4028235E38f;
        this.A07 = Integer.MIN_VALUE;
        this.A06 = Integer.MIN_VALUE;
        this.A02 = -3.4028235E38f;
        this.A08 = Integer.MIN_VALUE;
        this.A09 = Integer.MIN_VALUE;
        this.A05 = -3.4028235E38f;
        this.A04 = -3.4028235E38f;
        this.A00 = -3.4028235E38f;
        this.A0G = false;
        this.A0B = Color.BLACK;
        this.A0A = Integer.MIN_VALUE;
    }

    public C01953o(C1931pT c1931pT) {
        this.A0F = c1931pT.A0F;
        this.A0C = c1931pT.A0C;
        this.A0E = c1931pT.A0E;
        this.A0D = c1931pT.A0D;
        this.A01 = c1931pT.A01;
        this.A07 = c1931pT.A07;
        this.A06 = c1931pT.A06;
        this.A02 = c1931pT.A02;
        this.A08 = c1931pT.A08;
        this.A09 = c1931pT.A09;
        this.A05 = c1931pT.A05;
        this.A04 = c1931pT.A04;
        this.A00 = c1931pT.A00;
        this.A0G = c1931pT.A0G;
        this.A0B = c1931pT.A0B;
        this.A0A = c1931pT.A0A;
        this.A03 = c1931pT.A03;
    }

    @Pure
    public final int A00() {
        return this.A06;
    }

    @Pure
    public final int A01() {
        return this.A08;
    }

    public final C01953o A02() {
        this.A0G = false;
        return this;
    }

    public final C01953o A03(float f) {
        this.A00 = f;
        return this;
    }

    public final C01953o A04(float f) {
        this.A02 = f;
        return this;
    }

    public final C01953o A05(float f) {
        this.A03 = f;
        return this;
    }

    public final C01953o A06(float f) {
        this.A04 = f;
        return this;
    }

    public final C01953o A07(float f, int i) {
        this.A01 = f;
        this.A07 = i;
        return this;
    }

    public final C01953o A08(float f, int i) {
        this.A05 = f;
        this.A09 = i;
        return this;
    }

    public final C01953o A09(int i) {
        this.A06 = i;
        return this;
    }

    public final C01953o A0A(int i) {
        this.A08 = i;
        return this;
    }

    public final C01953o A0B(int i) {
        this.A0A = i;
        return this;
    }

    public final C01953o A0C(int i) {
        this.A0B = i;
        this.A0G = true;
        return this;
    }

    public final C01953o A0D(Bitmap bitmap) {
        this.A0C = bitmap;
        return this;
    }

    public final C01953o A0E(Layout.Alignment alignment) {
        this.A0D = alignment;
        return this;
    }

    public final C01953o A0F(Layout.Alignment alignment) {
        this.A0E = alignment;
        return this;
    }

    public final C01953o A0G(CharSequence charSequence) {
        this.A0F = charSequence;
        return this;
    }

    public final C1931pT A0H() {
        return new C1931pT(this.A0F, this.A0E, this.A0D, this.A0C, this.A01, this.A07, this.A06, this.A02, this.A08, this.A09, this.A05, this.A04, this.A00, this.A0G, this.A0B, this.A0A, this.A03);
    }

    @Pure
    public final CharSequence A0I() {
        return this.A0F;
    }
}
