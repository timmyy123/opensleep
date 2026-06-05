package com.urbandroid.sleep.nearby.core;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Endpoint$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Endpoint f$0;

    public /* synthetic */ Endpoint$$ExternalSyntheticLambda3(Endpoint endpoint, int i) {
        this.$r8$classId = i;
        this.f$0 = endpoint;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Endpoint endpoint = this.f$0;
        Void r2 = (Void) obj;
        switch (i) {
            case 0:
                return Endpoint.send$lambda$0$0(endpoint, r2);
            case 1:
                return Endpoint.requestConnection$lambda$0(endpoint, r2);
            case 2:
                return Endpoint.startDiscovery$lambda$0(endpoint, r2);
            default:
                return Endpoint.startAdvertising$lambda$0(endpoint, r2);
        }
    }
}
