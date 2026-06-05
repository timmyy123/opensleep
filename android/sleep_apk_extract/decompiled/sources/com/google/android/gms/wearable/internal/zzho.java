package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzho implements NodeApi.GetConnectedNodesResult {
    private final Status zza;
    private final List zzb;

    public zzho(Status status, List list) {
        this.zza = status;
        this.zzb = list;
    }

    @Override // com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
    public final List<Node> getNodes() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
