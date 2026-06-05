package com.facebook.ads.redexgen.core;

import android.webkit.WebView;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class UI implements Callable<String> {
    public final /* synthetic */ T8 A00;

    public UI(T8 t8) {
        this.A00 = t8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final String call() {
        String browserUserAgent = UJ.A03.get();
        if (browserUserAgent != null) {
            return browserUserAgent;
        }
        WebView webView = new WebView(this.A00.getApplicationContext());
        webView.setWebViewClient(new UH(this));
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.destroy();
        if (userAgentString != null) {
            UJ.A03.set(userAgentString);
        }
        return userAgentString;
    }
}
