package com.polar.sdk.impl;

import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.model.LedConfig;
import com.polar.sdk.impl.BDBleApiImpl;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDBleApiImpl$$ExternalSyntheticLambda0 implements Action, CompletableOnSubscribe {
    public final /* synthetic */ BDBleApiImpl f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ BDBleApiImpl$$ExternalSyntheticLambda0(BDBleApiImpl bDBleApiImpl, Object obj, Object obj2) {
        this.f$0 = bDBleApiImpl;
        this.f$1 = obj;
        this.f$2 = obj2;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        BDBleApiImpl.C20751.apply$lambda$0(this.f$0, (BleDeviceSession) this.f$1, (PolarBleApi.PolarBleSdkFeature) this.f$2);
    }

    @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
    public void subscribe(CompletableEmitter completableEmitter) {
        BDBleApiImpl.setLedConfig$lambda$17(this.f$0, (String) this.f$1, (LedConfig) this.f$2, completableEmitter);
    }
}
