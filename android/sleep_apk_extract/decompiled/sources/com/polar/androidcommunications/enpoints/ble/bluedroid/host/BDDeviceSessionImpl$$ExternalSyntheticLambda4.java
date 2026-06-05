package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceSessionImpl$$ExternalSyntheticLambda4 implements Action {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object[] f$1;

    public /* synthetic */ BDDeviceSessionImpl$$ExternalSyntheticLambda4(Object obj, Object[] objArr, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = objArr;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.$r8$classId;
        Object[] objArr = this.f$1;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ((BDDeviceSessionImpl) obj).lambda$monitorServicesDiscovered$6((SingleEmitter[]) objArr);
                break;
            default:
                ((BDDeviceListenerImpl) obj).lambda$search$2((FlowableEmitter[]) objArr);
                break;
        }
    }
}
