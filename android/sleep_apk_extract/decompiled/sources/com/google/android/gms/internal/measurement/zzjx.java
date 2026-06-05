package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzjx {

    @Deprecated
    public static final Api zza;
    private static final Api.ClientKey zzb;
    private static final Api.AbstractClientBuilder zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zzb = clientKey;
        zzjw zzjwVar = new zzjw();
        zzc = zzjwVar;
        zza = new Api("Phenotype.API", zzjwVar, clientKey);
    }

    public static zzkk zza(Context context) {
        return new zzkk(context);
    }
}
