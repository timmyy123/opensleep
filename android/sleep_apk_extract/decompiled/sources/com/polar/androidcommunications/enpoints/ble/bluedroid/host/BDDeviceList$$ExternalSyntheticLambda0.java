package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothGatt;
import com.polar.androidcommunications.api.ble.model.advertisement.BleAdvertisementContent;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceList;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.functions.Action;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceList$$ExternalSyntheticLambda0 implements AtomicSet.CompareFunction, BDDeviceList.CompareFunction, RxUtils.Emitter, Action {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ BDDeviceList$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.polar.androidcommunications.common.ble.AtomicSet.CompareFunction
    public boolean compare(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return BDDeviceList.lambda$getSession$1((BluetoothGatt) obj2, (BDDeviceSessionImpl) obj);
            default:
                return ((BDDeviceList.CompareFunction) obj2).compare((BDDeviceSessionImpl) obj);
        }
    }

    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
    public void item(Object obj) {
        BDDeviceSessionImpl.lambda$handleServicesDiscovered$7((ArrayList) this.f$0, (SingleEmitter) obj);
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        BDScanCallback.startScanning$lambda$0((BDScanCallback) this.f$0);
    }

    @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceList.CompareFunction
    public boolean compare(BDDeviceSessionImpl bDDeviceSessionImpl) {
        return BDDeviceListenerImpl.AnonymousClass2.lambda$deviceDiscovered$1((BleAdvertisementContent) this.f$0, bDDeviceSessionImpl);
    }
}
