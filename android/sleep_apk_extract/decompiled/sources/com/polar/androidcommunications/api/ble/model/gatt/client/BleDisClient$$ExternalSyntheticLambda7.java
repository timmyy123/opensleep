package com.polar.androidcommunications.api.ble.model.gatt.client;

import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BleDisClient$$ExternalSyntheticLambda7 implements FlowableOnSubscribe {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BleDisClient f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ FlowableEmitter[] f$2;

    public /* synthetic */ BleDisClient$$ExternalSyntheticLambda7(BleDisClient bleDisClient, boolean z, FlowableEmitter[] flowableEmitterArr, int i) {
        this.$r8$classId = i;
        this.f$0 = bleDisClient;
        this.f$1 = z;
        this.f$2 = flowableEmitterArr;
    }

    @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter flowableEmitter) {
        int i = this.$r8$classId;
        FlowableEmitter[] flowableEmitterArr = this.f$2;
        boolean z = this.f$1;
        BleDisClient bleDisClient = this.f$0;
        switch (i) {
            case 0:
                bleDisClient.lambda$observeDisInfoWithKeysAsStrings$7(z, flowableEmitterArr, flowableEmitter);
                break;
            default:
                bleDisClient.lambda$observeDisInfo$3(z, flowableEmitterArr, flowableEmitter);
                break;
        }
    }
}
