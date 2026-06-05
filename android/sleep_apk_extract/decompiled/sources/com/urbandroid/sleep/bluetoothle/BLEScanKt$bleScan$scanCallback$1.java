package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import com.urbandroid.common.logging.Logger;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\f"}, d2 = {"com/urbandroid/sleep/bluetoothle/BLEScanKt$bleScan$scanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "callback", "Lcom/urbandroid/sleep/bluetoothle/BLEScanKt$bleScan$scanCallback$1;", "onScanResult", "", "callbackType", "", "result", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BLEScanKt$bleScan$scanCallback$1 extends ScanCallback {
    final /* synthetic */ BluetoothAdapter $btAdapter;
    final /* synthetic */ Channel<BluetoothDevice> $channel;
    final /* synthetic */ AtomicInteger $scanCounter;
    final /* synthetic */ CoroutineScope $this_bleScan;
    private final BLEScanKt$bleScan$scanCallback$1 callback = this;

    public BLEScanKt$bleScan$scanCallback$1(AtomicInteger atomicInteger, Channel<BluetoothDevice> channel, BluetoothAdapter bluetoothAdapter, CoroutineScope coroutineScope) {
        this.$scanCounter = atomicInteger;
        this.$channel = channel;
        this.$btAdapter = bluetoothAdapter;
        this.$this_bleScan = coroutineScope;
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanFailed(int errorCode) {
        Logger.logInfo("bleScan: scan failed", null);
        SendChannel.close$default(this.$channel, null, 1, null);
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int callbackType, ScanResult result) {
        BluetoothAdapter bluetoothAdapter;
        BluetoothLeScanner bluetoothLeScanner;
        result.getClass();
        BLEScanKt.checkScanCount(this.$scanCounter);
        if (this.$channel.isClosedForSend() && (bluetoothAdapter = this.$btAdapter) != null && (bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner()) != null) {
            bluetoothLeScanner.stopScan(this.callback);
        }
        BuildersKt__Builders_commonKt.launch$default(this.$this_bleScan, null, null, new BLEScanKt$bleScan$scanCallback$1$onScanResult$1(this.$channel, result, this.$btAdapter, this, null), 3, null);
    }
}
