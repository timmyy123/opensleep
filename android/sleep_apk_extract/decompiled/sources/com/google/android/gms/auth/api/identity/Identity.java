package com.google.android.gms.auth.api.identity;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbad;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Identity {
    public static AuthorizationClient getAuthorizationClient(Context context) {
        return new zbad((Context) Preconditions.checkNotNull(context), new zba(null));
    }
}
