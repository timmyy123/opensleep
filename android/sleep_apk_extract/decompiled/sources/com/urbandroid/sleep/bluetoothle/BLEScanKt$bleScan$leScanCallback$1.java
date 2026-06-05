package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0002\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\f"}, d2 = {"com/urbandroid/sleep/bluetoothle/BLEScanKt$bleScan$leScanCallback$1", "Landroid/bluetooth/BluetoothAdapter$LeScanCallback;", "callback", "Lcom/urbandroid/sleep/bluetoothle/BLEScanKt$bleScan$leScanCallback$1;", "onLeScan", "", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroid/bluetooth/BluetoothDevice;", "rssi", "", "scanRecord", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BLEScanKt$bleScan$leScanCallback$1 implements BluetoothAdapter.LeScanCallback {
    final /* synthetic */ BluetoothAdapter $btAdapter;
    final /* synthetic */ Channel<BluetoothDevice> $channel;
    final /* synthetic */ AtomicInteger $scanCounter;
    final /* synthetic */ CoroutineScope $this_bleScan;
    private final BLEScanKt$bleScan$leScanCallback$1 callback = this;

    public BLEScanKt$bleScan$leScanCallback$1(AtomicInteger atomicInteger, Channel<BluetoothDevice> channel, BluetoothAdapter bluetoothAdapter, CoroutineScope coroutineScope) {
        this.$scanCounter = atomicInteger;
        this.$channel = channel;
        this.$btAdapter = bluetoothAdapter;
        this.$this_bleScan = coroutineScope;
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
        device.getClass();
        BLEScanKt.checkScanCount(this.$scanCounter);
        if (this.$channel.isClosedForSend()) {
            this.$btAdapter.stopLeScan(this.callback);
        }
        BuildersKt__Builders_commonKt.launch$default(this.$this_bleScan, null, null, new BLEScanKt$bleScan$leScanCallback$1$onLeScan$1(this.$channel, device, this.$btAdapter, this, null), 3, null);
    }
}
