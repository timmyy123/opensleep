package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzck extends zzo {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzck(zzcm zzcmVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        Objects.requireNonNull(zzcmVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzbh) ((zzp) anyClient).getService()).zzf(new com.google.android.gms.fitness.request.zzu((zzbz) new zzdw(this)));
    }
}
