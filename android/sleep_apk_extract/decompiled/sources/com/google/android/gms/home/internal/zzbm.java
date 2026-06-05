package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"CLIENT_KEY", "Lcom/google/android/gms/common/api/Api$ClientKey;", "Lcom/google/android/gms/home/internal/PermissionsClientImpl;", "clientBuilder", "com/google/android/gms/home/internal/InternalPermissionsClientKt$clientBuilder$1", "Lcom/google/android/gms/home/internal/InternalPermissionsClientKt$clientBuilder$1;", "API", "Lcom/google/android/gms/common/api/Api;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzbm {
    private static final Api.ClientKey zza;
    private static final zzbl zzb;
    private static final Api zzc;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzbl zzblVar = new zzbl();
        zzb = zzblVar;
        zzc = new Api("Home.Permissions.API", zzblVar, clientKey);
    }
}
