package com.google.android.gms.wearable.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeClient;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class zzhy extends NodeClient {
    final NodeApi zza;

    public zzhy(Context context, GoogleApi.Settings settings) {
        super(context, settings);
        this.zza = new zzhq();
    }

    @Override // com.google.android.gms.wearable.NodeClient
    public final Task<List<Node>> getConnectedNodes() {
        GoogleApiClient googleApiClientAsGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(googleApiClientAsGoogleApiClient.enqueue(new zzhn((zzhq) this.zza, googleApiClientAsGoogleApiClient)), zzhu.zza);
    }
}
