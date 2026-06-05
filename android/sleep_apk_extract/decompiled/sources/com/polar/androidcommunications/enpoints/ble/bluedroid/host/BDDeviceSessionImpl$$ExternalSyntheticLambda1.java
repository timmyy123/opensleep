package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import com.polar.androidcommunications.common.ble.RxUtils;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceSessionImpl$$ExternalSyntheticLambda1 implements RxUtils.Emitter, Action, Consumer {
    public final /* synthetic */ BDDeviceSessionImpl f$0;

    public /* synthetic */ BDDeviceSessionImpl$$ExternalSyntheticLambda1(BDDeviceSessionImpl bDDeviceSessionImpl) {
        this.f$0 = bDDeviceSessionImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Object obj) {
        this.f$0.handleAuthenticationFailed((Throwable) obj);
    }

    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
    public void item(Object obj) {
        ((FlowableEmitter) obj).onNext(this.f$0);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        this.f$0.handleAuthenticationComplete();
    }
}
