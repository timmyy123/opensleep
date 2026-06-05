package com.urbandroid.sleep.nearby.core;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Endpoint$$ExternalSyntheticLambda5 implements OnFailureListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Endpoint f$0;

    public /* synthetic */ Endpoint$$ExternalSyntheticLambda5(Endpoint endpoint, int i) {
        this.$r8$classId = i;
        this.f$0 = endpoint;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        int i = this.$r8$classId;
        Endpoint endpoint = this.f$0;
        switch (i) {
            case 0:
                Endpoint.send$lambda$0$2(endpoint, exc);
                break;
            case 1:
                Endpoint.startAdvertising$lambda$2(endpoint, exc);
                break;
            case 2:
                Endpoint.requestConnection$lambda$2(endpoint, exc);
                break;
            default:
                Endpoint.startDiscovery$lambda$2(endpoint, exc);
                break;
        }
    }
}
