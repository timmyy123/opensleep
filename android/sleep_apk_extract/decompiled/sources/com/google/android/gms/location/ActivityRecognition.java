package com.google.android.gms.location;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ActivityRecognition {

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API = com.google.android.gms.internal.identity.zzaj.zzb;

    @Deprecated
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.internal.identity.zzaf();

    public static ActivityRecognitionClient getClient(Context context) {
        return new com.google.android.gms.internal.identity.zzaj(context);
    }
}
