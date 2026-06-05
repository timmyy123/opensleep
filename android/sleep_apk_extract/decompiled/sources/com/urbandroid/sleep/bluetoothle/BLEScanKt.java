package com.urbandroid.sleep.bluetoothle;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.content.Context;
import android.content.IntentFilter;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import com.facebook.internal.NativeProtocol;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002\u001a\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"bleScan", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Landroid/bluetooth/BluetoothDevice;", "Lkotlinx/coroutines/CoroutineScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "capacity", "", "logMinorFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "checkScanCount", "scanCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class BLEScanKt {
    public static final ReceiveChannel<BluetoothDevice> bleScan(CoroutineScope coroutineScope, Context context, int i) {
        coroutineScope.getClass();
        context.getClass();
        if (!Environment.isJellyBean43OrGreater()) {
            Events$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(Environment.getAPILevel(), "At least API level 18 is required. "));
            return null;
        }
        if (!context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            Events$$ExternalSyntheticBUOutline0.m("Bluetooth Low Energy not supported");
            return null;
        }
        Object systemService = context.getSystemService("bluetooth");
        systemService.getClass();
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        if (adapter != null && !adapter.isEnabled()) {
            Events$$ExternalSyntheticBUOutline0.m("Bluetooth is not enabled");
            return null;
        }
        if (adapter.isDiscovering()) {
            Events$$ExternalSyntheticBUOutline0.m("Another discovery process is running");
            return null;
        }
        Channel channelChannel$default = ChannelKt.Channel$default(i, null, null, 6, null);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        if (Environment.isMOrGreater() || !context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            BLEScanKt$bleScan$receiver$1 bLEScanKt$bleScan$receiver$1 = new BLEScanKt$bleScan$receiver$1(atomicInteger, channelChannel$default, coroutineScope, adapter, context);
            Logger.logInfo("bleScan: Starting discovery", null);
            IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.FOUND");
            intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
            ContextCompat.registerReceiver(context, bLEScanKt$bleScan$receiver$1, intentFilter, 2);
            channelChannel$default.invokeOnClose(new CodecsKt$$ExternalSyntheticLambda2(bLEScanKt$bleScan$receiver$1, 10));
            adapter.startDiscovery();
            return channelChannel$default;
        }
        if (!Environment.isLollipopOrGreater() || adapter.getBluetoothLeScanner() == null) {
            BLEScanKt$bleScan$leScanCallback$1 bLEScanKt$bleScan$leScanCallback$1 = new BLEScanKt$bleScan$leScanCallback$1(atomicInteger, channelChannel$default, adapter, coroutineScope);
            Logger.logInfo("bleScan: Starting scan old", null);
            adapter.startLeScan(bLEScanKt$bleScan$leScanCallback$1);
            return channelChannel$default;
        }
        BLEScanKt$bleScan$scanCallback$1 bLEScanKt$bleScan$scanCallback$1 = new BLEScanKt$bleScan$scanCallback$1(atomicInteger, channelChannel$default, adapter, coroutineScope);
        Logger.logInfo("bleScan: Starting scan new", null);
        BluetoothLeScanner bluetoothLeScanner = adapter.getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            bluetoothLeScanner.startScan(bLEScanKt$bleScan$scanCallback$1);
        }
        return channelChannel$default;
    }

    public static /* synthetic */ ReceiveChannel bleScan$default(CoroutineScope coroutineScope, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        return bleScan(coroutineScope, context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bleScan$lambda$0(BLEScanKt$bleScan$receiver$1 bLEScanKt$bleScan$receiver$1, Throwable th) {
        bLEScanKt$bleScan$receiver$1.shutdown();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkScanCount(AtomicInteger atomicInteger) {
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        if (iIncrementAndGet < 1000 || iIncrementAndGet % 1000 != 0) {
            return;
        }
        Logger.logSevere("bleScan: scan is still running: " + iIncrementAndGet, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logMinorFailure(Exception exc) {
        Logger.logInfo("bleScan: " + exc.getClass().getName() + ": " + exc.getMessage(), null);
    }
}
