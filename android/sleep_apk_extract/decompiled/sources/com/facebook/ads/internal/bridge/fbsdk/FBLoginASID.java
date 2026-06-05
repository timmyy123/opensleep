package com.facebook.ads.internal.bridge.fbsdk;

import com.facebook.AccessToken;

/* JADX INFO: loaded from: classes.dex */
public class FBLoginASID {
    public static String getFBLoginASID() {
        try {
            AccessToken.Companion companion = AccessToken.INSTANCE;
            Object objInvoke = AccessToken.class.getDeclaredMethod("getCurrentAccessToken", null).invoke(null, null);
            if (objInvoke != null) {
                return (String) AccessToken.class.getDeclaredMethod("getUserId", null).invoke(objInvoke, null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
