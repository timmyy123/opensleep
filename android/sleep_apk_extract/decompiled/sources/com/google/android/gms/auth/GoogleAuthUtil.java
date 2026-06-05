package com.google.android.gms.auth;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class GoogleAuthUtil extends zzl {
    public static void clearToken(Context context, String str) throws GoogleAuthException, IOException {
        zzl.clearToken(context, str);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        return zzl.getToken(context, str, str2);
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        zzl.invalidateToken(context, str);
    }
}
