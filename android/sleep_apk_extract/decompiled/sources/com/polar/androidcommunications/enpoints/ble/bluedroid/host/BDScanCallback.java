package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.ParcelUuid;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleHrClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpUtils;
import com.polar.androidcommunications.common.ble.AndroidBuildUtils;
import com.polar.androidcommunications.common.ble.BleUtils;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.streams.jdk8.StreamsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 K2\u00020\u0001:\u0004LKMNB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u0017J\u0017\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0003¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0003¢\u0006\u0004\b\"\u0010\u0017J\r\u0010#\u001a\u00020\f¢\u0006\u0004\b#\u0010\u0017J\r\u0010$\u001a\u00020\f¢\u0006\u0004\b$\u0010\u0017J\r\u0010%\u001a\u00020\f¢\u0006\u0004\b%\u0010\u0017J\r\u0010&\u001a\u00020\f¢\u0006\u0004\b&\u0010\u0017J\r\u0010'\u001a\u00020\f¢\u0006\u0004\b'\u0010\u0017J\r\u0010(\u001a\u00020\f¢\u0006\u0004\b(\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010)R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010*R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010.R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u00109\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006O"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$BDScanCallbackInterface;", "scanCallbackInterface", "<init>", "(Landroid/content/Context;Landroid/bluetooth/BluetoothAdapter;Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$BDScanCallbackInterface;)V", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$ScanAction;", "action", "", "commandState", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$ScanAction;)V", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$ScannerState;", "newState", "changeState", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$ScannerState;)V", "scannerIdleState", "scannerAdminState", "scannerScanningState", "startScanning", "()V", "Landroid/bluetooth/le/ScanResult;", "result", "Lcom/polar/androidcommunications/common/ble/BleUtils$EVENT_TYPE;", "fetchAdvType", "(Landroid/bluetooth/le/ScanResult;)Lcom/polar/androidcommunications/common/ble/BleUtils$EVENT_TYPE;", "startLScan", "Landroid/bluetooth/le/ScanSettings;", "scanSettings", "callStartScanL", "(Landroid/bluetooth/le/ScanSettings;)V", "stopScanning", "clientAdded", "clientRemoved", "stopScan", "startScan", "powerOn", "powerOff", "Landroid/bluetooth/BluetoothAdapter;", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$BDScanCallbackInterface;", "", "Landroid/bluetooth/le/ScanFilter;", "scanFilter", "Ljava/util/List;", "", "", "scanPool", "Lio/reactivex/rxjava3/core/Scheduler;", "delayScheduler", "Lio/reactivex/rxjava3/core/Scheduler;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$ScannerState;", "", "lowPowerEnabled", "Z", "getLowPowerEnabled", "()Z", "setLowPowerEnabled", "(Z)V", "opportunistic", "getOpportunistic", "setOpportunistic", "", "adminStops", "I", "Lio/reactivex/rxjava3/disposables/Disposable;", "delaySubscription", "Lio/reactivex/rxjava3/disposables/Disposable;", "opportunisticScanTimer", "Landroid/bluetooth/le/ScanCallback;", "leScanCallback", "Landroid/bluetooth/le/ScanCallback;", "Companion", "BDScanCallbackInterface", "ScanAction", "ScannerState", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BDScanCallback {
    private int adminStops;
    private final BluetoothAdapter bluetoothAdapter;
    private final Scheduler delayScheduler;
    private Disposable delaySubscription;
    private final ScanCallback leScanCallback;
    private boolean lowPowerEnabled;
    private boolean opportunistic;
    private Disposable opportunisticScanTimer;
    private final BDScanCallbackInterface scanCallbackInterface;
    private List<ScanFilter> scanFilter;
    private final List<Long> scanPool;
    private ScannerState state;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$BDScanCallbackInterface;", "", "deviceDiscovered", "", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Landroid/bluetooth/BluetoothDevice;", "rssi", "", "scanRecord", "", "type", "Lcom/polar/androidcommunications/common/ble/BleUtils$EVENT_TYPE;", "isScanningNeeded", "", "scanStartError", "error", "", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BDScanCallbackInterface {
        void deviceDiscovered(BluetoothDevice device, int rssi, byte[] scanRecord, BleUtils.EVENT_TYPE type);

        boolean isScanningNeeded();

        void scanStartError(String error);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$ScanAction;", "", "(Ljava/lang/String;I)V", "ENTRY", "EXIT", "CLIENT_START_SCAN", "CLIENT_REMOVED", "ADMIN_START_SCAN", "ADMIN_STOP_SCAN", "BLE_POWER_OFF", "BLE_POWER_ON", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScanAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScanAction[] $VALUES;
        public static final ScanAction ENTRY = new ScanAction("ENTRY", 0);
        public static final ScanAction EXIT = new ScanAction("EXIT", 1);
        public static final ScanAction CLIENT_START_SCAN = new ScanAction("CLIENT_START_SCAN", 2);
        public static final ScanAction CLIENT_REMOVED = new ScanAction("CLIENT_REMOVED", 3);
        public static final ScanAction ADMIN_START_SCAN = new ScanAction("ADMIN_START_SCAN", 4);
        public static final ScanAction ADMIN_STOP_SCAN = new ScanAction("ADMIN_STOP_SCAN", 5);
        public static final ScanAction BLE_POWER_OFF = new ScanAction("BLE_POWER_OFF", 6);
        public static final ScanAction BLE_POWER_ON = new ScanAction("BLE_POWER_ON", 7);

        private static final /* synthetic */ ScanAction[] $values() {
            return new ScanAction[]{ENTRY, EXIT, CLIENT_START_SCAN, CLIENT_REMOVED, ADMIN_START_SCAN, ADMIN_STOP_SCAN, BLE_POWER_OFF, BLE_POWER_ON};
        }

        static {
            ScanAction[] scanActionArr$values = $values();
            $VALUES = scanActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scanActionArr$values);
        }

        private ScanAction(String str, int i) {
        }

        public static ScanAction valueOf(String str) {
            return (ScanAction) Enum.valueOf(ScanAction.class, str);
        }

        public static ScanAction[] values() {
            return (ScanAction[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDScanCallback$ScannerState;", "", "(Ljava/lang/String;I)V", "IDLE", "STOPPED", "SCANNING", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScannerState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScannerState[] $VALUES;
        public static final ScannerState IDLE = new ScannerState("IDLE", 0);
        public static final ScannerState STOPPED = new ScannerState("STOPPED", 1);
        public static final ScannerState SCANNING = new ScannerState("SCANNING", 2);

        private static final /* synthetic */ ScannerState[] $values() {
            return new ScannerState[]{IDLE, STOPPED, SCANNING};
        }

        static {
            ScannerState[] scannerStateArr$values = $values();
            $VALUES = scannerStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scannerStateArr$values);
        }

        private ScannerState(String str, int i) {
        }

        public static ScannerState valueOf(String str) {
            return (ScannerState) Enum.valueOf(ScannerState.class, str);
        }

        public static ScannerState[] values() {
            return (ScannerState[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ScannerState.values().length];
            try {
                iArr[ScannerState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScannerState.STOPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScannerState.SCANNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ScanAction.values().length];
            try {
                iArr2[ScanAction.ENTRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScanAction.EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ScanAction.ADMIN_START_SCAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ScanAction.CLIENT_REMOVED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ScanAction.BLE_POWER_OFF.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ScanAction.CLIENT_START_SCAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ScanAction.ADMIN_STOP_SCAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[ScanAction.BLE_POWER_ON.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public BDScanCallback(Context context, BluetoothAdapter bluetoothAdapter, BDScanCallbackInterface bDScanCallbackInterface) {
        context.getClass();
        bluetoothAdapter.getClass();
        bDScanCallbackInterface.getClass();
        this.bluetoothAdapter = bluetoothAdapter;
        this.scanCallbackInterface = bDScanCallbackInterface;
        ArrayList arrayList = new ArrayList();
        ScanFilter scanFilterBuild = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(BleHrClient.INSTANCE.getHR_SERVICE().toString())).build();
        scanFilterBuild.getClass();
        arrayList.add(scanFilterBuild);
        ScanFilter scanFilterBuild2 = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(BlePsFtpUtils.RFC77_PFTP_SERVICE.toString())).build();
        scanFilterBuild2.getClass();
        arrayList.add(scanFilterBuild2);
        ScanFilter scanFilterBuild3 = new ScanFilter.Builder().setManufacturerData(107, new byte[0]).build();
        scanFilterBuild3.getClass();
        arrayList.add(scanFilterBuild3);
        this.scanFilter = arrayList;
        this.scanPool = new CopyOnWriteArrayList();
        Scheduler schedulerFrom = AndroidSchedulers.from(context.getMainLooper());
        schedulerFrom.getClass();
        this.delayScheduler = schedulerFrom;
        this.state = ScannerState.IDLE;
        this.opportunistic = true;
        this.leScanCallback = new ScanCallback() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback$leScanCallback$1
            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> results) {
                results.getClass();
                for (ScanResult scanResult : results) {
                    ScanRecord scanRecord = scanResult.getScanRecord();
                    byte[] bytes = scanRecord != null ? scanRecord.getBytes() : null;
                    if (bytes == null) {
                        bytes = new byte[0];
                    }
                    this.this$0.scanCallbackInterface.deviceDiscovered(scanResult.getDevice(), scanResult.getRssi(), bytes, this.this$0.fetchAdvType(scanResult));
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int errorCode) {
                String strM = FileInsert$$ExternalSyntheticOutline0.m(errorCode, "Scan start failed to ScanCallback errorCode: ");
                BleLogger.INSTANCE.e("BDScanCallback", strM);
                this.this$0.scanCallbackInterface.scanStartError(strM);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int callbackType, ScanResult result) {
                result.getClass();
                super.onScanResult(callbackType, result);
                ScanRecord scanRecord = result.getScanRecord();
                byte[] bytes = scanRecord != null ? scanRecord.getBytes() : null;
                if (bytes == null) {
                    bytes = new byte[0];
                }
                this.this$0.scanCallbackInterface.deviceDiscovered(result.getDevice(), result.getRssi(), bytes, this.this$0.fetchAdvType(result));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callStartScanL(ScanSettings scanSettings) {
        try {
            this.bluetoothAdapter.getBluetoothLeScanner().startScan(this.scanFilter, scanSettings, this.leScanCallback);
            Stream<Long> streamFilter = this.scanPool.stream().filter(new BDScanCallback$$ExternalSyntheticLambda1());
            streamFilter.getClass();
            List list = StreamsKt.toList(streamFilter);
            this.scanPool.clear();
            this.scanPool.addAll(list);
            this.scanPool.add(Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("Failed to start scan. Reason: ", e.getMessage());
            BleLogger.INSTANCE.e("BDScanCallback", strM);
            this.scanCallbackInterface.scanStartError(strM);
            changeState(ScannerState.IDLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean callStartScanL$lambda$1(Long l) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        l.getClass();
        return jCurrentTimeMillis - l.longValue() < 30000;
    }

    private final void changeState(ScannerState newState) {
        commandState(ScanAction.EXIT);
        this.state = newState;
        commandState(ScanAction.ENTRY);
    }

    private final void commandState(ScanAction action) {
        BleLogger.INSTANCE.d("BDScanCallback", "commandState state:" + this.state + " action: " + action);
        int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (i == 1) {
            scannerIdleState(action);
        } else if (i == 2) {
            scannerAdminState(action);
        } else {
            if (i != 3) {
                return;
            }
            scannerScanningState(action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BleUtils.EVENT_TYPE fetchAdvType(ScanResult result) {
        BleUtils.EVENT_TYPE event_type = BleUtils.EVENT_TYPE.ADV_IND;
        return (AndroidBuildUtils.INSTANCE.getBuildVersion() < 26 || result.isConnectable()) ? event_type : BleUtils.EVENT_TYPE.ADV_NONCONN_IND;
    }

    private final void scannerAdminState(ScanAction action) {
        int i = WhenMappings.$EnumSwitchMapping$1[action.ordinal()];
        if (i == 1) {
            this.adminStops = 1;
            return;
        }
        if (i == 2) {
            this.adminStops = 0;
            return;
        }
        if (i != 3) {
            if (i == 5) {
                changeState(ScannerState.IDLE);
                return;
            } else {
                if (i != 7) {
                    return;
                }
                this.adminStops++;
                return;
            }
        }
        int i2 = this.adminStops - 1;
        this.adminStops = i2;
        if (i2 <= 0) {
            changeState(ScannerState.IDLE);
            return;
        }
        BleLogger.INSTANCE.d("BDScanCallback", "Waiting admins to call start c: " + i2);
    }

    private final void scannerIdleState(ScanAction action) {
        int i = WhenMappings.$EnumSwitchMapping$1[action.ordinal()];
        if (i == 1) {
            this.bluetoothAdapter.isEnabled();
            if (this.bluetoothAdapter.isEnabled() && this.scanCallbackInterface.isScanningNeeded()) {
                changeState(ScannerState.SCANNING);
                return;
            }
            return;
        }
        if (i == 6) {
            if (!this.bluetoothAdapter.isEnabled()) {
                BleLogger.INSTANCE.d("BDScanCallback", "Skipped scan start, because of ble power off");
                return;
            } else {
                if (this.scanCallbackInterface.isScanningNeeded()) {
                    changeState(ScannerState.SCANNING);
                    return;
                }
                return;
            }
        }
        if (i == 7) {
            changeState(ScannerState.STOPPED);
        } else if (i == 8 && this.scanCallbackInterface.isScanningNeeded()) {
            changeState(ScannerState.SCANNING);
        }
    }

    private final void scannerScanningState(ScanAction action) {
        int i = WhenMappings.$EnumSwitchMapping$1[action.ordinal()];
        if (i == 1) {
            startScanning();
            return;
        }
        if (i == 2) {
            stopScanning();
            Disposable disposable = this.opportunisticScanTimer;
            if (disposable != null) {
                disposable.dispose();
            }
            this.opportunisticScanTimer = null;
            return;
        }
        if (i == 4) {
            if (this.scanCallbackInterface.isScanningNeeded()) {
                return;
            }
            changeState(ScannerState.IDLE);
        } else {
            if (i == 5) {
                changeState(ScannerState.IDLE);
                return;
            }
            if (i == 7) {
                changeState(ScannerState.STOPPED);
            } else {
                if (i != 8) {
                    return;
                }
                BleLogger.INSTANCE.e("BDScanCallback", "INCORRECT event received in scanning state: " + action);
            }
        }
    }

    private final void startLScan() {
        final ScanSettings scanSettingsBuild;
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("BDScanCallback", "Scan started -->");
        if (this.lowPowerEnabled) {
            scanSettingsBuild = new ScanSettings.Builder().setScanMode(0).build();
            scanSettingsBuild.getClass();
        } else {
            scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
            scanSettingsBuild.getClass();
        }
        try {
            callStartScanL(scanSettingsBuild);
            if (this.opportunistic) {
                this.opportunisticScanTimer = Observable.interval(30L, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(this.delayScheduler).subscribe(new Consumer() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback.startLScan.1
                    public final void accept(long j) {
                        BleLogger.INSTANCE.d("BDScanCallback", "RESTARTING scan to avoid opportunistic");
                        BDScanCallback.this.stopScanning();
                        BDScanCallback.this.callStartScanL(scanSettingsBuild);
                    }

                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public /* bridge */ /* synthetic */ void accept(Object obj) {
                        accept(((Number) obj).longValue());
                    }
                }, new Consumer() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback.startLScan.2
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Throwable th) {
                        th.getClass();
                        BleLogger.INSTANCE.e("BDScanCallback", "TIMER failed: " + th.getLocalizedMessage());
                    }
                });
            }
            companion.d("BDScanCallback", "Scan started <--");
        } catch (NullPointerException unused) {
            BleLogger.INSTANCE.e("BDScanCallback", "startScan did throw null pointer exception");
            changeState(ScannerState.IDLE);
        }
    }

    private final void startScanning() {
        if (!this.scanPool.isEmpty()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.scanPool.get(0).longValue();
            if (this.scanPool.size() > 3 && jCurrentTimeMillis < 30000) {
                long j = 30200 - jCurrentTimeMillis;
                BleLogger.INSTANCE.d("BDScanCallback", FileInsert$$ExternalSyntheticOutline0.m(jCurrentTimeMillis, "ms", FileInsert$$ExternalSyntheticOutline0.m("Prevent scanning too frequently delay: ", "ms elapsed: ", j)));
                Disposable disposable = this.delaySubscription;
                if (disposable != null) {
                    disposable.dispose();
                }
                this.delaySubscription = Observable.timer(j, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(this.delayScheduler).subscribe(new Consumer() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback.startScanning.1
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public /* bridge */ /* synthetic */ void accept(Object obj) {
                        accept(((Number) obj).longValue());
                    }

                    public final void accept(long j2) {
                    }
                }, new Consumer() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback.startScanning.2
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Throwable th) {
                        th.getClass();
                        BleLogger.INSTANCE.e("BDScanCallback", "timer failed: " + th.getLocalizedMessage());
                    }
                }, new BDDeviceList$$ExternalSyntheticLambda0(this, 4));
                return;
            }
        }
        BleLogger.INSTANCE.d("BDScanCallback", "timestamps left: " + this.scanPool.size());
        startLScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startScanning$lambda$0(BDScanCallback bDScanCallback) {
        bDScanCallback.getClass();
        BleLogger.INSTANCE.d("BDScanCallback", "delayed scan starting");
        if (!bDScanCallback.scanPool.isEmpty()) {
            bDScanCallback.scanPool.remove(0);
        }
        bDScanCallback.startLScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopScanning() {
        BleLogger.INSTANCE.d("BDScanCallback", "Stop scanning");
        Disposable disposable = this.delaySubscription;
        if (disposable != null) {
            disposable.dispose();
        }
        this.delaySubscription = null;
        try {
            this.bluetoothAdapter.getBluetoothLeScanner().stopScan(this.leScanCallback);
        } catch (Exception e) {
            BleLogger.INSTANCE.e("BDScanCallback", "stopScan did throw exception: " + e.getLocalizedMessage());
        }
    }

    public final void clientAdded() {
        commandState(ScanAction.CLIENT_START_SCAN);
    }

    public final void clientRemoved() {
        commandState(ScanAction.CLIENT_REMOVED);
    }

    public final void powerOff() {
        commandState(ScanAction.BLE_POWER_OFF);
    }

    public final void powerOn() {
        commandState(ScanAction.BLE_POWER_ON);
    }

    public final void startScan() {
        commandState(ScanAction.ADMIN_START_SCAN);
    }

    public final void stopScan() {
        commandState(ScanAction.ADMIN_STOP_SCAN);
    }
}
