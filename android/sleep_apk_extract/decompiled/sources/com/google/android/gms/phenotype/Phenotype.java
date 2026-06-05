package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Phenotype {

    @Deprecated
    private static final Api<Api.ApiOptions.NoOptions> API;
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.phenotype.zze, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
    private static final Api.ClientKey<com.google.android.gms.internal.phenotype.zze> CLIENT_KEY;

    @Deprecated
    private static final zzm zzaj;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.phenotype.zzd, com.google.android.gms.phenotype.zzm] */
    static {
        Api.ClientKey<com.google.android.gms.internal.phenotype.zze> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zzl zzlVar = new zzl();
        CLIENT_BUILDER = zzlVar;
        API = new Api<>("Phenotype.API", zzlVar, clientKey);
        zzaj = new com.google.android.gms.internal.phenotype.zzd();
    }

    public static Uri getContentProviderUri(String str) {
        String strValueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(strValueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(strValueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
