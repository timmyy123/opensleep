package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdn extends zzap {
    final /* synthetic */ SessionInsertRequest zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdn(zzdt zzdtVar, GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
        super(googleApiClient);
        this.zza = sessionInsertRequest;
        Objects.requireNonNull(zzdtVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzbn) ((zzaq) anyClient).getService()).zzf(new SessionInsertRequest(this.zza, new zzdw(this)));
    }
}
