package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcm implements ConfigApi {
    @Override // com.google.android.gms.fitness.ConfigApi
    public final PendingResult<Status> disableFit(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzck(this, googleApiClient));
    }
}
