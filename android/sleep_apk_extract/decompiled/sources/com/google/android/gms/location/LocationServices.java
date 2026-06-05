package com.google.android.gms.location;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.identity.zzbb;
import com.google.android.gms.internal.identity.zzbi;
import com.google.android.gms.internal.identity.zzcr;
import com.google.android.gms.internal.identity.zzcz;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LocationServices {

    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API = zzbi.zzb;

    @Deprecated
    public static final FusedLocationProviderApi FusedLocationApi = new zzbb();

    @Deprecated
    public static final GeofencingApi GeofencingApi = new zzcr();

    @Deprecated
    public static final SettingsApi SettingsApi = new zzcz();

    public static FusedLocationProviderClient getFusedLocationProviderClient(Context context) {
        return new zzbi(context);
    }
}
