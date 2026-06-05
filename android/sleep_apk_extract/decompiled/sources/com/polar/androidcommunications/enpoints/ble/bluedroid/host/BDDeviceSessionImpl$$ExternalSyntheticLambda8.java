package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDBondingListener;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceSessionImpl$$ExternalSyntheticLambda8 implements CompletableOnSubscribe, Action {
    public final /* synthetic */ BDDeviceSessionImpl f$0;
    public final /* synthetic */ BDBondingListener.BondingObserver[] f$1;

    public /* synthetic */ BDDeviceSessionImpl$$ExternalSyntheticLambda8(BDDeviceSessionImpl bDDeviceSessionImpl, BDBondingListener.BondingObserver[] bondingObserverArr) {
        this.f$0 = bDDeviceSessionImpl;
        this.f$1 = bondingObserverArr;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        this.f$0.lambda$authenticate$1(this.f$1);
    }

    @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
    public void subscribe(CompletableEmitter completableEmitter) {
        this.f$0.lambda$authenticate$0(this.f$1, completableEmitter);
    }
}
