package com.polar.sdk.impl;

import com.polar.androidcommunications.api.ble.BleDeviceListener;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Function;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDBleApiImpl$$ExternalSyntheticLambda1 implements Action, BleDeviceListener.BleSearchPreFilter, Function {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BDBleApiImpl$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // io.reactivex.rxjava3.functions.Function
    public Object apply(Object obj) {
        BlePMDClient blePMDClient = (BlePMDClient) obj;
        switch (this.$r8$classId) {
            case 4:
                return BDBleApiImpl.startAccStreaming$lambda$36(blePMDClient);
            default:
                return BDBleApiImpl.startPpiStreaming$lambda$38(blePMDClient);
        }
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public void run() {
        switch (this.$r8$classId) {
            case 1:
                BDBleApiImpl$setupDevice$disposable$2.apply$lambda$1();
                break;
            case 2:
                BDBleApiImpl$setupDevice$disposable$2.apply$lambda$2();
                break;
            default:
                BDBleApiImpl.stopPmdStreaming$lambda$74();
                break;
        }
    }
}
