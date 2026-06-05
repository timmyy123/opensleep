package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcr extends zzx {
    final /* synthetic */ DataDeleteRequest zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcr(zzcz zzczVar, GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
        super(googleApiClient);
        this.zza = dataDeleteRequest;
        Objects.requireNonNull(zzczVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzbj) ((zzy) anyClient).getService()).zzf(new DataDeleteRequest(this.zza, new zzdw(this)));
    }
}
