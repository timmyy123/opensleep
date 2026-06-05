package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceListenerImpl$1$$ExternalSyntheticLambda0 implements Action, Consumer {
    public final /* synthetic */ BDDeviceListenerImpl.AnonymousClass1 f$0;
    public final /* synthetic */ BDDeviceSessionImpl f$1;

    public /* synthetic */ BDDeviceListenerImpl$1$$ExternalSyntheticLambda0(BDDeviceListenerImpl.AnonymousClass1 anonymousClass1, BDDeviceSessionImpl bDDeviceSessionImpl) {
        this.f$0 = anonymousClass1;
        this.f$1 = bDDeviceSessionImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Object obj) {
        this.f$0.lambda$startServiceDiscovery$1(this.f$1, (Throwable) obj);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        this.f$0.lambda$startServiceDiscovery$0(this.f$1);
    }
}
