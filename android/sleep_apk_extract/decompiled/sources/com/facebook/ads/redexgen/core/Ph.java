package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class Ph {
    public static final C0737Pg A00;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            A00 = new C0h() { // from class: com.facebook.ads.redexgen.X.0e
            };
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            A00 = new C0h();
        } else if (Build.VERSION.SDK_INT >= 23) {
            A00 = new C0k();
        } else {
            A00 = new C0n();
        }
    }

    public static int A00(View view) {
        return A00.A02(view);
    }

    public static int A01(View view) {
        return A00.A03(view);
    }

    public static int A02(View view) {
        return A00.A04(view);
    }

    public static int A03(View view) {
        return A00.A05(view);
    }

    public static Display A04(View view) {
        return A00.A06(view);
    }

    public static C0752Py A05(View view, C0752Py c0752Py) {
        return A00.A07(view, c0752Py);
    }

    public static C0752Py A06(View view, C0752Py c0752Py) {
        return A00.A08(view, c0752Py);
    }

    public static void A07(View view) {
        A00.A09(view);
    }

    public static void A08(View view) {
        A00.A0A(view);
    }

    public static void A09(View view, int i) {
        A00.A0B(view, i);
    }

    public static void A0A(View view, Drawable drawable) {
        A00.A0C(view, drawable);
    }

    public static void A0B(View view, PL pl2) {
        A00.A0D(view, pl2);
    }

    public static void A0C(View view, PR pr) {
        A00.A0E(view, pr);
    }

    public static void A0D(View view, Runnable runnable) {
        A00.A0F(view, runnable);
    }

    public static void A0E(View view, Runnable runnable, long j) {
        A00.A0G(view, runnable, j);
    }

    public static boolean A0F(View view) {
        return A00.A0H(view);
    }

    public static boolean A0G(View view) {
        return A00.A0I(view);
    }

    public static boolean A0H(View view) {
        return A00.A0J(view);
    }
}
