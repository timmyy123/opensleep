package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface NodeApi {

    @Deprecated
    public interface GetConnectedNodesResult extends Result {
        List<Node> getNodes();
    }
}
