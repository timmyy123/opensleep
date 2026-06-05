package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.wearable.Wearable;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzt extends BaseImplementation$ApiMethodImpl {
    public zzt(GoogleApiClient googleApiClient) {
        super(Wearable.API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        setResult((Result) obj);
    }
}
