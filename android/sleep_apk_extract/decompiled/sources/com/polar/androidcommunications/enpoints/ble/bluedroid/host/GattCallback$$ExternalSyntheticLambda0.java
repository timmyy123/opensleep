package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class GattCallback$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ GattCallback f$0;
    public final /* synthetic */ BDDeviceSessionImpl f$1;

    public /* synthetic */ GattCallback$$ExternalSyntheticLambda0(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl, int i) {
        this.$r8$classId = i;
        this.f$0 = gattCallback;
        this.f$1 = bDDeviceSessionImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.$r8$classId;
        BDDeviceSessionImpl bDDeviceSessionImpl = this.f$1;
        GattCallback gattCallback = this.f$0;
        switch (i) {
            case 0:
                GattCallback.onServicesDiscovered$lambda$4(gattCallback, bDDeviceSessionImpl);
                break;
            case 1:
                GattCallback.onServicesDiscovered$lambda$5(gattCallback, bDDeviceSessionImpl);
                break;
            case 2:
                GattCallback.onMtuChanged$lambda$7(gattCallback, bDDeviceSessionImpl);
                break;
            case 3:
                GattCallback.onPhyRead$lambda$9(gattCallback, bDDeviceSessionImpl);
                break;
            case 4:
                GattCallback.onConnectionStateChange$lambda$0(gattCallback, bDDeviceSessionImpl);
                break;
            case 5:
                GattCallback.onConnectionStateChange$lambda$1(gattCallback, bDDeviceSessionImpl);
                break;
            case 6:
                GattCallback.onConnectionStateChange$lambda$2(gattCallback, bDDeviceSessionImpl);
                break;
            default:
                GattCallback.onPhyUpdate$lambda$8(gattCallback, bDDeviceSessionImpl);
                break;
        }
    }
}
