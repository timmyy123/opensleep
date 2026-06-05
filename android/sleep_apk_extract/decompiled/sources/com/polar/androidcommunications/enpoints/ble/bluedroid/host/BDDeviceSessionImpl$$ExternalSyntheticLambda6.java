package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BDDeviceSessionImpl$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BDScanCallback f$0;

    public /* synthetic */ BDDeviceSessionImpl$$ExternalSyntheticLambda6(BDScanCallback bDScanCallback, int i) {
        this.$r8$classId = i;
        this.f$0 = bDScanCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        BDScanCallback bDScanCallback = this.f$0;
        switch (i) {
            case 0:
                bDScanCallback.stopScan();
                break;
            default:
                bDScanCallback.startScan();
                break;
        }
    }
}
