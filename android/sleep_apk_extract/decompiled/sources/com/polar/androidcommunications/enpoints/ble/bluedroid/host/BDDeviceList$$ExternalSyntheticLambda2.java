package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothDevice;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDBondingListener;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceList$$ExternalSyntheticLambda2 implements AtomicSet.ObjectAccess, AtomicSet.CompareFunction {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BluetoothDevice f$0;

    public /* synthetic */ BDDeviceList$$ExternalSyntheticLambda2(BluetoothDevice bluetoothDevice, int i) {
        this.$r8$classId = i;
        this.f$0 = bluetoothDevice;
    }

    @Override // com.polar.androidcommunications.common.ble.AtomicSet.ObjectAccess
    public void access(Object obj) {
        int i = this.$r8$classId;
        BluetoothDevice bluetoothDevice = this.f$0;
        BDBondingListener.BondingObserver bondingObserver = (BDBondingListener.BondingObserver) obj;
        switch (i) {
            case 1:
                BDBondingListener.AnonymousClass1.lambda$onReceive$0(bluetoothDevice, bondingObserver);
                break;
            case 2:
                BDBondingListener.AnonymousClass1.lambda$onReceive$1(bluetoothDevice, bondingObserver);
                break;
            default:
                BDBondingListener.AnonymousClass1.lambda$onReceive$2(bluetoothDevice, bondingObserver);
                break;
        }
    }

    @Override // com.polar.androidcommunications.common.ble.AtomicSet.CompareFunction
    public boolean compare(Object obj) {
        return BDDeviceList.lambda$getSession$0(this.f$0, (BDDeviceSessionImpl) obj);
    }
}
