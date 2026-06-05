package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.Function;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CctTransportBackend$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ CctTransportBackend f$0;

    public /* synthetic */ CctTransportBackend$$ExternalSyntheticLambda0(CctTransportBackend cctTransportBackend) {
        this.f$0 = cctTransportBackend;
    }

    public final Object apply(Object obj) {
        return this.f$0.doSend((CctTransportBackend.HttpRequest) obj);
    }
}
