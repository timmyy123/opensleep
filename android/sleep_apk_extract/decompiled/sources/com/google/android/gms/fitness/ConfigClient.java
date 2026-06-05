package com.google.android.gms.fitness;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzp;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ConfigClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final ConfigApi zzb = new zzcm();

    public ConfigClient(Context context, Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, (Api<Api.ApiOptions.HasGoogleSignInAccountOptions>) zzp.zzg, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> disableFit() {
        return PendingResultUtil.toVoidTask(zzb.disableFit(asGoogleApiClient()));
    }
}
