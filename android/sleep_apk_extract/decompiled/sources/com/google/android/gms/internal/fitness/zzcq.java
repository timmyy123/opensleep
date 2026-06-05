package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.zzj;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcq extends zzx {
    final /* synthetic */ DataSet zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcq(zzcz zzczVar, GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
        super(googleApiClient);
        this.zza = dataSet;
        Objects.requireNonNull(zzczVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzbj) ((zzy) anyClient).getService()).zze(new zzj(this.zza, (zzbz) new zzdw(this), false));
    }
}
