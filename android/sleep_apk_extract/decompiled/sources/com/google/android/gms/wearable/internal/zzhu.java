package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.wearable.NodeApi;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class zzhu implements PendingResultUtil.ResultConverter {
    static final /* synthetic */ zzhu zza = new zzhu();

    private /* synthetic */ zzhu() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final /* synthetic */ Object convert(Result result) {
        return ((NodeApi.GetConnectedNodesResult) result).getNodes();
    }
}
