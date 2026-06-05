package com.spotify.sdk.android.auth;

import com.spotify.sdk.android.auth.browser.BrowserAuthHandler;

/* JADX INFO: loaded from: classes4.dex */
public class FallbackHandlerProvider {
    public AuthorizationHandler provideFallback() {
        return new BrowserAuthHandler();
    }
}
