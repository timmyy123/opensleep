package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceList;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl;
import io.reactivex.rxjava3.functions.Action;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceListenerImpl$$ExternalSyntheticLambda0 implements BDDeviceList.CompareFunction, AtomicSet.ObjectAccess, Action {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BDDeviceListenerImpl$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.polar.androidcommunications.common.ble.AtomicSet.ObjectAccess
    public void access(Object obj) {
        ((BDDeviceSessionImpl) obj).resetGatt();
    }

    @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceList.CompareFunction
    public boolean compare(BDDeviceSessionImpl bDDeviceSessionImpl) {
        switch (this.$r8$classId) {
            case 1:
                return BDDeviceListenerImpl.AnonymousClass2.lambda$isScanningNeeded$0(bDDeviceSessionImpl);
            default:
                return BDDeviceListenerImpl.AnonymousClass4.lambda$deviceSessionStateChanged$0(bDDeviceSessionImpl);
        }
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        BDDeviceListenerImpl.lambda$search$1();
    }
}
