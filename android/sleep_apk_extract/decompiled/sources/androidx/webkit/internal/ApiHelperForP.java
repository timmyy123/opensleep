package androidx.webkit.internal;

import android.os.Looper;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApiHelperForP {
    public static ClassLoader getWebViewClassLoader() {
        return WebView.getWebViewClassLoader();
    }

    public static Looper getWebViewLooper(WebView webView) {
        return webView.getWebViewLooper();
    }
}
