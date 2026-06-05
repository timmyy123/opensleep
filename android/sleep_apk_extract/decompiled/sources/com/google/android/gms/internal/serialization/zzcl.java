package com.google.android.gms.internal.serialization;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.home.matter.discovery.DiscoveryClient;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcl extends GoogleApi implements DiscoveryClient {
    private static final Api.ClientKey zza;
    private static final Api.AbstractClientBuilder zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzcj zzcjVar = new zzcj();
        zzb = zzcjVar;
        zzc = new Api("DiscoveryClient.API", zzcjVar, clientKey);
    }

    public zzcl(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
