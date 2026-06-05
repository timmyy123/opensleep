package com.google.android.gms.internal.fitness;

import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzcv extends zzv {
    final /* synthetic */ DataReadRequest zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcv(zzcz zzczVar, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
        super(googleApiClient);
        this.zza = dataReadRequest;
        Objects.requireNonNull(zzczVar);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        DataReadRequest dataReadRequest = this.zza;
        List<DataType> dataTypes = dataReadRequest.getDataTypes();
        List<DataSource> dataSources = dataReadRequest.getDataSources();
        Parcelable.Creator<DataReadResult> creator = DataReadResult.CREATOR;
        ArrayList arrayList = new ArrayList();
        Iterator<DataSource> it = dataSources.iterator();
        while (it.hasNext()) {
            arrayList.add(DataSet.builder(it.next()).build());
        }
        for (DataType dataType : dataTypes) {
            DataSource.Builder builder = new DataSource.Builder();
            builder.setType(1);
            builder.setDataType(dataType);
            builder.setStreamName("Default");
            arrayList.add(DataSet.builder(builder.build()).build());
        }
        return new DataReadResult(arrayList, Collections.EMPTY_LIST, status);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzbj) ((zzy) anyClient).getService()).zzd(new DataReadRequest(this.zza, new zzcy(this, null)));
    }
}
