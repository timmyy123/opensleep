package com.facebook.ads.redexgen.core;

import android.webkit.WebView;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1564jA implements InterfaceC0819Sp {
    public final C0693No A00;
    public final O3 A01;
    public final C0827Sx A02;
    public final C1421gi A03;
    public final boolean A04;

    public C1564jA(C1421gi c1421gi, O3 o3, C0827Sx c0827Sx, C0693No c0693No, boolean z) {
        this.A03 = c1421gi;
        this.A01 = o3;
        this.A02 = c0827Sx;
        this.A00 = c0693No;
        this.A04 = z;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        O4 playableWebViewClient = new O4(this.A00, this.A01, this.A04);
        webView.setWebViewClient(playableWebViewClient);
        webView.loadUrl(this.A00.A0L());
        playableWebViewClient.A03();
    }

    private void A01(boolean z) {
        if (this.A00.A0G() == EnumC0694Np.A05) {
            A00();
            return;
        }
        String strA0L = this.A00.A0L();
        if (z) {
            C0827Sx c0827Sx = this.A02;
            String markupUrlResult = this.A00.A0L();
            strA0L = c0827Sx.A0S(markupUrlResult);
        }
        this.A00.A0T(strA0L);
        this.A01.AFG();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0819Sp
    public final void ADL() {
        if (this.A04) {
            this.A01.AFF(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0819Sp
    public final void ADT() {
        A01(true);
    }
}
