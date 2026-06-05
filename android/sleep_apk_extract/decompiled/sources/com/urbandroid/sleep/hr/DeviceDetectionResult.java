package com.urbandroid.sleep.hr;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/hr/DeviceDetectionResult;", "", "Landroid/bluetooth/BluetoothDevice;", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "", "recognized", "", "internalName", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcom/urbandroid/sleep/hr/ReceiverClient;", "createClient", "<init>", "(Landroid/bluetooth/BluetoothDevice;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Landroid/bluetooth/BluetoothDevice;", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "Z", "getRecognized", "()Z", "Ljava/lang/String;", "getInternalName", "Lkotlin/jvm/functions/Function1;", "getCreateClient", "()Lkotlin/jvm/functions/Function1;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DeviceDetectionResult {
    private final Function1<Context, ReceiverClient> createClient;
    private final BluetoothDevice device;
    private final String internalName;
    private final boolean recognized;

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceDetectionResult(BluetoothDevice bluetoothDevice, boolean z, String str, Function1<? super Context, ? extends ReceiverClient> function1) {
        bluetoothDevice.getClass();
        str.getClass();
        function1.getClass();
        this.device = bluetoothDevice;
        this.recognized = z;
        this.internalName = str;
        this.createClient = function1;
    }

    public final Function1<Context, ReceiverClient> getCreateClient() {
        return this.createClient;
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final boolean getRecognized() {
        return this.recognized;
    }

    public String toString() {
        String address = this.device.getAddress();
        String name = this.device.getName();
        boolean z = this.recognized;
        String str = this.internalName;
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("DeviceDetectionResult(device='", address, " ", name, "', recognized=");
        sbM6m.append(z);
        sbM6m.append(", internalName='");
        sbM6m.append(str);
        sbM6m.append("')");
        return sbM6m.toString();
    }
}
