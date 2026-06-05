package com.google.firebase.ai.common;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class APIController$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ APIController f$0;

    public /* synthetic */ APIController$$ExternalSyntheticLambda0(APIController aPIController, int i) {
        this.$r8$classId = i;
        this.f$0 = aPIController;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        APIController aPIController = this.f$0;
        switch (i) {
            case 0:
                return APIController.getWebSocketSession$lambda$15(aPIController, (HttpRequestBuilder) obj);
            case 1:
                return APIController.client$lambda$4$lambda$2(aPIController, (HttpTimeoutConfig) obj);
            default:
                return APIController.client$lambda$4(aPIController, (HttpClientConfig) obj);
        }
    }
}
