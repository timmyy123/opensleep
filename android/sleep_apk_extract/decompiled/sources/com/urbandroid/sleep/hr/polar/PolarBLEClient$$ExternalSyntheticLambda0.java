package com.urbandroid.sleep.hr.polar;

import android.bluetooth.BluetoothGattCharacteristic;
import com.urbandroid.sleep.hr.polar.PolarBLEClient;
import com.urbandroid.sleep.hr.polar.domain.AccData;
import com.urbandroid.sleep.hr.polar.domain.PpiData;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PolarBLEClient$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ PolarBLEClient f$0;

    public /* synthetic */ PolarBLEClient$$ExternalSyntheticLambda0(PolarBLEClient polarBLEClient, int i) {
        this.$r8$classId = i;
        this.f$0 = polarBLEClient;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        PolarBLEClient polarBLEClient = this.f$0;
        switch (i) {
            case 0:
                return PolarBLEClient.connect$lambda$0(polarBLEClient, (AccData) obj);
            case 1:
                return PolarBLEClient.C21292.invokeSuspend$lambda$0$0(polarBLEClient, (PpiData) obj);
            case 2:
                return PolarBLEClient.C21301.invokeSuspend$lambda$0$0(polarBLEClient, (BluetoothGattCharacteristic) obj);
            default:
                return PolarBLEClient.connect$lambda$1(polarBLEClient, (PpiData) obj);
        }
    }
}
