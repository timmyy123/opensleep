package com.polar.androidcommunications.api.ble.model.gatt.client;

import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BleDisClient$$ExternalSyntheticLambda8 implements Action {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BleDisClient f$0;
    public final /* synthetic */ FlowableEmitter[] f$1;

    public /* synthetic */ BleDisClient$$ExternalSyntheticLambda8(BleDisClient bleDisClient, FlowableEmitter[] flowableEmitterArr, int i) {
        this.$r8$classId = i;
        this.f$0 = bleDisClient;
        this.f$1 = flowableEmitterArr;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.$r8$classId;
        FlowableEmitter[] flowableEmitterArr = this.f$1;
        BleDisClient bleDisClient = this.f$0;
        switch (i) {
            case 0:
                bleDisClient.lambda$observeDisInfoWithKeysAsStrings$8(flowableEmitterArr);
                break;
            default:
                bleDisClient.lambda$observeDisInfo$4(flowableEmitterArr);
                break;
        }
    }
}
