package androidx.webkit;

import androidx.webkit.internal.WebViewFeatureInternal;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebViewFeature {
    public static boolean isFeatureSupported(String str) {
        return WebViewFeatureInternal.isSupported(str);
    }
}
