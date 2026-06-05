package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzda {
    private static Boolean zza;

    public static void zza(WebView webView, String str) {
        boolean zBooleanValue;
        synchronized (zzda.class) {
            if (zza == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zza = Boolean.TRUE;
                } catch (IllegalStateException unused) {
                    zza = Boolean.FALSE;
                }
                zBooleanValue = zza.booleanValue();
            } else {
                zBooleanValue = zza.booleanValue();
            }
        }
        if (zBooleanValue) {
            webView.evaluateJavascript(str, null);
        } else {
            webView.loadUrl("javascript:".concat(str));
        }
    }
}
