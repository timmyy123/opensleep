package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.logging.Logger;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0006\u0010\b\u001a\u00020\u0003¨\u0006\t"}, d2 = {"com/urbandroid/sleep/bluetoothle/BLEScanKt$bleScan$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "ctx", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "shutdown", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BLEScanKt$bleScan$receiver$1 extends BroadcastReceiver {
    final /* synthetic */ BluetoothAdapter $btAdapter;
    final /* synthetic */ Channel<BluetoothDevice> $channel;
    final /* synthetic */ Context $context;
    final /* synthetic */ AtomicInteger $scanCounter;
    final /* synthetic */ CoroutineScope $this_bleScan;

    public BLEScanKt$bleScan$receiver$1(AtomicInteger atomicInteger, Channel<BluetoothDevice> channel, CoroutineScope coroutineScope, BluetoothAdapter bluetoothAdapter, Context context) {
        this.$scanCounter = atomicInteger;
        this.$channel = channel;
        this.$this_bleScan = coroutineScope;
        this.$btAdapter = bluetoothAdapter;
        this.$context = context;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context ctx, Intent intent) {
        ctx.getClass();
        intent.getClass();
        BLEScanKt.checkScanCount(this.$scanCounter);
        if (this.$channel.isClosedForSend()) {
            shutdown();
        }
        if (Intrinsics.areEqual("android.bluetooth.device.action.FOUND", intent.getAction())) {
            BuildersKt__Builders_commonKt.launch$default(this.$this_bleScan, null, null, new BLEScanKt$bleScan$receiver$1$onReceive$1((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"), this, this.$channel, null), 3, null);
        } else if (Intrinsics.areEqual("android.bluetooth.adapter.action.DISCOVERY_FINISHED", intent.getAction())) {
            Logger.logInfo("bleScan: Discovery finished", null);
            shutdown();
            SendChannel.close$default(this.$channel, null, 1, null);
        }
    }

    public final void shutdown() {
        try {
            this.$btAdapter.cancelDiscovery();
        } catch (Exception e) {
            BLEScanKt.logMinorFailure(e);
        }
        try {
            this.$context.unregisterReceiver(this);
        } catch (Exception e2) {
            BLEScanKt.logMinorFailure(e2);
        }
    }
}
