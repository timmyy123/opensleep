package com.google.android.gms.internal.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zze extends GoogleApi<Api.ApiOptions.NoOptions> implements com.google.android.gms.clearcut.zzb {
    private zze(Context context) {
        super(context, ClearcutLogger.API, (Api.ApiOptions) null, new ApiExceptionMapper());
    }

    @Override // com.google.android.gms.clearcut.zzb
    public final PendingResult<Status> zzb(com.google.android.gms.clearcut.zze zzeVar) {
        return doBestEffortWrite(new zzh(zzeVar, asGoogleApiClient()));
    }

    public static com.google.android.gms.clearcut.zzb zzb(Context context) {
        return new zze(context);
    }
}
