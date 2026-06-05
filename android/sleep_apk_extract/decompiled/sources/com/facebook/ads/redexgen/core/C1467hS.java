package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1467hS implements InterfaceC0962Yh {
    public static String[] A01 = {"8tOzOPKLz5DDIwqC88XBXxH90bmVDotF", "YCktuRbEMhZaz9U821mncTHWO05lwCqY", "Eq7g3criU65KDBPK", "XEHycrxPk7FQv1FkL381pmPNBNbKujpl", "niYnM4G6gzmxtC7fq", "sRQOtQAi", "8G5qrnHnaOtx52JqPPi", "6arHmIfqlBfM2iqNpfy3RxuQJelIt1eI"};
    public final WeakReference<C0783Re> A00;

    public C1467hS(C0783Re c0783Re) {
        this.A00 = new WeakReference<>(c0783Re);
    }

    private void A00(C0783Re c0783Re) {
        C1269eF c1269eFA07 = c0783Re.A07();
        if (c1269eFA07 != null && c0783Re.A04() != null) {
            c0783Re.A04().bringChildToFront(c1269eFA07);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0962Yh
    public void A44(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        C0783Re c0783Re = this.A00.get();
        if (c0783Re != null && c0783Re.A04() != null) {
            c0783Re.A04().addView(view, i, layoutParams);
            A00(c0783Re);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0962Yh
    public void A45(View view, RelativeLayout.LayoutParams layoutParams) {
        C0783Re c0783Re = this.A00.get();
        if (c0783Re != null && c0783Re.A04() != null) {
            c0783Re.A04().addView(view, layoutParams);
            A00(c0783Re);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0962Yh
    public void A4j(String str) {
        if (this.A00.get() != null) {
            this.A00.get().A0C(str);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0962Yh
    public void A4k(String str, UL ul) {
        if (this.A00.get() != null) {
            this.A00.get().A0E(str, ul);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0962Yh
    public void AAo(String str, C0691Nm c0691Nm) {
        if (this.A00.get() != null) {
            WeakReference<C0783Re> weakReference = this.A00;
            if (A01[4].length() == 0) {
                throw new RuntimeException();
            }
            A01[2] = "IO1gKUYJJG6YtU6JnI8y";
            weakReference.get().A0D(str, c0691Nm);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0962Yh
    public void ADJ(int i) {
        C0783Re activityApi = this.A00.get();
        if (activityApi != null) {
            activityApi.finish(i);
        }
    }
}
