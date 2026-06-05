package com.urbandroid.sleep.hr;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DetectDevice$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BluetoothDevice f$0;

    public /* synthetic */ DetectDevice$$ExternalSyntheticLambda0(BluetoothDevice bluetoothDevice, int i) {
        this.$r8$classId = i;
        this.f$0 = bluetoothDevice;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        BluetoothDevice bluetoothDevice = this.f$0;
        Context context = (Context) obj;
        switch (i) {
            case 0:
                return DetectDevice.detectHrDevice$lambda$0(bluetoothDevice, context);
            case 1:
                return DetectDevice.detectHrDevice$lambda$1(bluetoothDevice, context);
            case 2:
                return DetectDevice.detectHrDevice$lambda$2$0(bluetoothDevice, context);
            case 3:
                return DetectDevice.detectAccelDevice$lambda$0(bluetoothDevice, context);
            default:
                return DetectDevice.detectAccelDevice$lambda$1(bluetoothDevice, context);
        }
    }
}
