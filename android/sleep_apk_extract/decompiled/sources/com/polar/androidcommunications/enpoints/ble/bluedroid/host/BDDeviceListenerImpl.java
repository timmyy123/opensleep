package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import androidx.core.util.Pair;
import com.polar.androidcommunications.api.ble.BleDeviceListener;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.exceptions.BleNotAvailableInDevice;
import com.polar.androidcommunications.api.ble.exceptions.BleStartScanError;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.api.ble.model.advertisement.BleAdvertisementContent;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.common.ble.AndroidBuildUtils;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.BleUtils;
import com.polar.androidcommunications.common.ble.PhoneUtils;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDPowerListener;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandler;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandlerObserver;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ScannerInterface;
import com.polar.sdk.impl.BDBleApiImpl;
import com.polar.sdk.impl.BDBleApiImpl$$ExternalSyntheticLambda1;
import com.urbandroid.privacy.Consent$Companion$$ExternalSyntheticLambda0;
import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class BDDeviceListenerImpl extends BleDeviceListener {
    private static final String TAG = "BDDeviceListenerImpl";
    private final BDPowerListener.BlePowerState blePowerStateListener;
    private BluetoothAdapter bluetoothAdapter;
    private final BDBondingListener bondingManager;
    private final BluetoothManager btManager;
    private final ConnectionHandler connectionHandler;
    private final ConnectionHandlerObserver connectionHandlerObserver;
    private final ConnectionInterface connectionInterface;
    private final Context context;
    private final BehaviorSubject<Pair<BleDeviceSession, BleDeviceSession.DeviceSessionState>> deviceSessionStateSubject;
    private final GattCallback gattCallback;
    private final AtomicSet<FlowableEmitter<? super BleDeviceSession>> observers;
    private final BDPowerListener powerManager;
    private BleDeviceListener.BlePowerStateChangedCallback powerStateChangedCallback;
    private int preferredMTU;
    private final BDScanCallback scanCallback;
    private final BDScanCallback.BDScanCallbackInterface scanCallbackInterface;
    private final ScannerInterface scannerInterface;
    private final BDDeviceList sessions;

    /* JADX INFO: renamed from: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements ConnectionInterface {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startServiceDiscovery$0(BDDeviceSessionImpl bDDeviceSessionImpl) {
            BleLogger.e(BDDeviceListenerImpl.TAG, "service discovery timed out");
            if (bDDeviceSessionImpl.getGatt() != null) {
                BDDeviceListenerImpl.this.gattCallback.onServicesDiscovered(bDDeviceSessionImpl.getGatt(), 257);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startServiceDiscovery$1(BDDeviceSessionImpl bDDeviceSessionImpl, Throwable th) {
            BleLogger.e(BDDeviceListenerImpl.TAG, "service discovery timer failed: " + th.getLocalizedMessage());
            if (bDDeviceSessionImpl.getGatt() != null) {
                BDDeviceListenerImpl.this.gattCallback.onServicesDiscovered(bDDeviceSessionImpl.getGatt(), 257);
            }
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface
        public void cancelDeviceConnection(BDDeviceSessionImpl bDDeviceSessionImpl) {
            synchronized (bDDeviceSessionImpl.getGattMutex()) {
                try {
                    if (bDDeviceSessionImpl.getGatt() != null) {
                        bDDeviceSessionImpl.getGatt().disconnect();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface
        public void connectDevice(BDDeviceSessionImpl bDDeviceSessionImpl) {
            BluetoothGatt bluetoothGattConnectGatt;
            if (AndroidBuildUtils.getBuildVersion() >= 26) {
                int i = BDDeviceListenerImpl.this.bluetoothAdapter.isLe2MPhySupported() ? 3 : 1;
                BleLogger.d(BDDeviceListenerImpl.TAG, "Attempt connect to device " + bDDeviceSessionImpl.getName() + " with the mask " + i);
                bluetoothGattConnectGatt = bDDeviceSessionImpl.getBluetoothDevice().connectGatt(BDDeviceListenerImpl.this.context, false, BDDeviceListenerImpl.this.gattCallback, 2, i);
            } else {
                BleLogger.d(BDDeviceListenerImpl.TAG, "Attempt connect to device " + bDDeviceSessionImpl.getName());
                bluetoothGattConnectGatt = bDDeviceSessionImpl.getBluetoothDevice().connectGatt(BDDeviceListenerImpl.this.context, false, BDDeviceListenerImpl.this.gattCallback, 2);
            }
            bDDeviceSessionImpl.setGatt(bluetoothGattConnectGatt);
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface
        public void disconnectDevice(BDDeviceSessionImpl bDDeviceSessionImpl) {
            synchronized (bDDeviceSessionImpl.getGattMutex()) {
                try {
                    if (bDDeviceSessionImpl.getGatt() != null) {
                        bDDeviceSessionImpl.getGatt().disconnect();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface
        public boolean isPowered() {
            return BDDeviceListenerImpl.this.bleActive();
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface
        public boolean setMtu(BDDeviceSessionImpl bDDeviceSessionImpl) {
            boolean zRequestMtu;
            if (BDDeviceListenerImpl.this.preferredMTU == 0 || PhoneUtils.isMtuNegotiationBroken(AndroidBuildUtils.getBrand(), AndroidBuildUtils.getModel())) {
                if (bDDeviceSessionImpl.getGatt() == null) {
                    return true;
                }
                BDDeviceListenerImpl.this.gattCallback.onMtuChanged(bDDeviceSessionImpl.getGatt(), 23, 0);
                return true;
            }
            synchronized (bDDeviceSessionImpl.getGattMutex()) {
                try {
                    zRequestMtu = bDDeviceSessionImpl.getGatt() != null ? bDDeviceSessionImpl.getGatt().requestMtu(BDDeviceListenerImpl.this.preferredMTU) : false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zRequestMtu;
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface
        public void setPhy(BDDeviceSessionImpl bDDeviceSessionImpl) {
            if (bDDeviceSessionImpl.getGatt() != null) {
                if (AndroidBuildUtils.getBuildVersion() < 26) {
                    BDDeviceListenerImpl.this.gattCallback.onPhyUpdate(bDDeviceSessionImpl.getGatt(), 1, 1, 0);
                    return;
                }
                synchronized (bDDeviceSessionImpl.getGattMutex()) {
                    bDDeviceSessionImpl.getGatt().setPreferredPhy(2, 2, 0);
                }
            }
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionInterface
        public boolean startServiceDiscovery(BDDeviceSessionImpl bDDeviceSessionImpl) {
            boolean zDiscoverServices;
            synchronized (bDDeviceSessionImpl.getGattMutex()) {
                try {
                    zDiscoverServices = bDDeviceSessionImpl.getGatt() != null ? bDDeviceSessionImpl.getGatt().discoverServices() : false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            Disposable disposable = bDDeviceSessionImpl.serviceDiscovery;
            if (disposable != null) {
                disposable.dispose();
            }
            bDDeviceSessionImpl.serviceDiscovery = Completable.timer(10L, TimeUnit.SECONDS, Schedulers.newThread()).observeOn(Schedulers.io()).subscribe(new BDDeviceListenerImpl$1$$ExternalSyntheticLambda0(this, bDDeviceSessionImpl), new BDDeviceListenerImpl$1$$ExternalSyntheticLambda0(this, bDDeviceSessionImpl));
            return zDiscoverServices;
        }
    }

    /* JADX INFO: renamed from: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements BDScanCallback.BDScanCallbackInterface {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$deviceDiscovered$1(BleAdvertisementContent bleAdvertisementContent, BDDeviceSessionImpl bDDeviceSessionImpl) {
            return bDDeviceSessionImpl.getAdvertisementContent().getPolarDeviceId().equals(bleAdvertisementContent.getPolarDeviceId());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$isScanningNeeded$0(BDDeviceSessionImpl bDDeviceSessionImpl) {
            return bDDeviceSessionImpl.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK;
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback.BDScanCallbackInterface
        public void deviceDiscovered(BluetoothDevice bluetoothDevice, int i, byte[] bArr, BleUtils.EVENT_TYPE event_type) {
            BDDeviceSessionImpl bDDeviceSessionImplFetch;
            BDDeviceSessionImpl session = BDDeviceListenerImpl.this.sessions.getSession(bluetoothDevice);
            HashMap<BleUtils.AD_TYPE, byte[]> mapAdvertisementBytes2Map = BleUtils.advertisementBytes2Map(bArr);
            String str = Build.MANUFACTURER;
            String name = bluetoothDevice.getName();
            if (name != null && str.equalsIgnoreCase("samsung")) {
                mapAdvertisementBytes2Map.remove(BleUtils.AD_TYPE.GAP_ADTYPE_LOCAL_NAME_SHORT);
                mapAdvertisementBytes2Map.put(BleUtils.AD_TYPE.GAP_ADTYPE_LOCAL_NAME_COMPLETE, name.getBytes());
            }
            if (session == null) {
                BleAdvertisementContent bleAdvertisementContent = new BleAdvertisementContent();
                bleAdvertisementContent.processAdvertisementData(mapAdvertisementBytes2Map, event_type, i);
                if (((BleDeviceListener) BDDeviceListenerImpl.this).preFilter != null) {
                    ((BDBleApiImpl$$ExternalSyntheticLambda1) ((BleDeviceListener) BDDeviceListenerImpl.this).preFilter).getClass();
                    if (!BDBleApiImpl.filter$lambda$0(bleAdvertisementContent)) {
                        return;
                    }
                }
                if (bleAdvertisementContent.getPolarHrAdvertisement().isPresent() && bleAdvertisementContent.getPolarDeviceIdInt() != 0 && ((bleAdvertisementContent.getPolarDeviceType().equals("H10") || bleAdvertisementContent.getPolarDeviceType().equals("H9")) && (bDDeviceSessionImplFetch = BDDeviceListenerImpl.this.sessions.fetch(new BDDeviceList$$ExternalSyntheticLambda0(bleAdvertisementContent, 2))) != null && (bDDeviceSessionImplFetch.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_CLOSED || bDDeviceSessionImplFetch.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK))) {
                    BleLogger.d(BDDeviceListenerImpl.TAG, "old polar device found name: " + bDDeviceSessionImplFetch.getAdvertisementContent().getName() + " dev name: " + bluetoothDevice.getName() + " old name: " + bDDeviceSessionImplFetch.getBluetoothDevice().getName() + " old addr: " + bDDeviceSessionImplFetch.getAddress() + " device: " + bluetoothDevice);
                    bDDeviceSessionImplFetch.setBluetoothDevice(bluetoothDevice);
                    bDDeviceSessionImplFetch.getAdvertisementContent().processAdvertisementData(mapAdvertisementBytes2Map, event_type, i);
                    session = bDDeviceSessionImplFetch;
                }
                if (session == null) {
                    BDDeviceSessionImpl bDDeviceSessionImpl = new BDDeviceSessionImpl(BDDeviceListenerImpl.this.context, bluetoothDevice, BDDeviceListenerImpl.this.scanCallback, BDDeviceListenerImpl.this.bondingManager, ((BleDeviceListener) BDDeviceListenerImpl.this).factory);
                    bDDeviceSessionImpl.getAdvertisementContent().processAdvertisementData(mapAdvertisementBytes2Map, event_type, i);
                    BleLogger.d(BDDeviceListenerImpl.TAG, "new device allocated name: " + bDDeviceSessionImpl.getAdvertisementContent().getName());
                    BDDeviceListenerImpl.this.sessions.addSession(bDDeviceSessionImpl);
                    session = bDDeviceSessionImpl;
                }
            } else {
                session.getAdvertisementContent().processAdvertisementData(mapAdvertisementBytes2Map, event_type, i);
            }
            BDDeviceListenerImpl.this.connectionHandler.advertisementHeadReceived(session);
            RxUtils.emitNext(BDDeviceListenerImpl.this.observers, new BDDeviceSessionImpl$$ExternalSyntheticLambda1(session));
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback.BDScanCallbackInterface
        public boolean isScanningNeeded() {
            return (BDDeviceListenerImpl.this.observers.size() == 0 && BDDeviceListenerImpl.this.sessions.fetch(new BDDeviceListenerImpl$$ExternalSyntheticLambda0(1)) == null) ? false : true;
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDScanCallback.BDScanCallbackInterface
        public void scanStartError(String str) {
            BleLogger.e(BDDeviceListenerImpl.TAG, "scanStartError " + str);
            RxUtils.postError(BDDeviceListenerImpl.this.observers, new BleStartScanError(str));
        }
    }

    /* JADX INFO: renamed from: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements ConnectionHandlerObserver {
        public AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$deviceSessionStateChanged$0(BDDeviceSessionImpl bDDeviceSessionImpl) {
            return bDDeviceSessionImpl.getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK;
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandlerObserver
        public void deviceConnectionCancelled(BDDeviceSessionImpl bDDeviceSessionImpl) {
            bDDeviceSessionImpl.reset();
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandlerObserver
        public void deviceDisconnected(BDDeviceSessionImpl bDDeviceSessionImpl) {
            bDDeviceSessionImpl.handleDisconnection();
            bDDeviceSessionImpl.reset();
        }

        @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandlerObserver
        public void deviceSessionStateChanged(BDDeviceSessionImpl bDDeviceSessionImpl) {
            BDDeviceSessionImpl bDDeviceSessionImplFetch = BDDeviceListenerImpl.this.sessions.fetch(new BDDeviceListenerImpl$$ExternalSyntheticLambda0(2));
            BDDeviceListenerImpl bDDeviceListenerImpl = BDDeviceListenerImpl.this;
            if (bDDeviceSessionImplFetch != null) {
                bDDeviceListenerImpl.scanCallback.clientAdded();
            } else {
                bDDeviceListenerImpl.scanCallback.clientRemoved();
            }
            BDDeviceListenerImpl.this.getClass();
            if (BDDeviceListenerImpl.this.deviceSessionStateSubject.hasObservers()) {
                BleDeviceSession.DeviceSessionState sessionState = bDDeviceSessionImpl.getSessionState();
                BleDeviceSession.DeviceSessionState deviceSessionState = BleDeviceSession.DeviceSessionState.SESSION_OPEN_PARK;
                if (sessionState != deviceSessionState || bDDeviceSessionImpl.getPreviousState() != BleDeviceSession.DeviceSessionState.SESSION_OPEN) {
                    BDDeviceListenerImpl.this.getClass();
                    BDDeviceListenerImpl.this.deviceSessionStateSubject.onNext(new Pair(bDDeviceSessionImpl, bDDeviceSessionImpl.getSessionState()));
                    return;
                }
                BDDeviceListenerImpl.this.getClass();
                BDDeviceListenerImpl.this.deviceSessionStateSubject.onNext(new Pair(bDDeviceSessionImpl, BleDeviceSession.DeviceSessionState.SESSION_CLOSED));
                if (bDDeviceSessionImpl.getSessionState() == deviceSessionState) {
                    BDDeviceListenerImpl.this.getClass();
                    BDDeviceListenerImpl.this.deviceSessionStateSubject.onNext(new Pair(bDDeviceSessionImpl, deviceSessionState));
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$polar$androidcommunications$api$ble$model$BleDeviceSession$DeviceSessionState;

        static {
            int[] iArr = new int[BleDeviceSession.DeviceSessionState.values().length];
            $SwitchMap$com$polar$androidcommunications$api$ble$model$BleDeviceSession$DeviceSessionState = iArr;
            try {
                iArr[BleDeviceSession.DeviceSessionState.SESSION_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$polar$androidcommunications$api$ble$model$BleDeviceSession$DeviceSessionState[BleDeviceSession.DeviceSessionState.SESSION_OPENING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$polar$androidcommunications$api$ble$model$BleDeviceSession$DeviceSessionState[BleDeviceSession.DeviceSessionState.SESSION_CLOSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BDDeviceListenerImpl(Context context, Set<Class<? extends BleGattBase>> set) throws BleNotAvailableInDevice {
        super(set);
        BDDeviceList bDDeviceList = new BDDeviceList();
        this.sessions = bDDeviceList;
        this.observers = new AtomicSet<>();
        this.deviceSessionStateSubject = BehaviorSubject.create();
        this.powerStateChangedCallback = null;
        this.preferredMTU = 512;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        this.connectionInterface = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        this.scanCallbackInterface = anonymousClass2;
        ScannerInterface scannerInterface = new ScannerInterface() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl.3
            @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ScannerInterface
            public void connectionHandlerRequestStopScanning() {
                BDDeviceListenerImpl.this.scanCallback.stopScan();
            }

            @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ScannerInterface
            public void connectionHandlerResumeScanning() {
                BDDeviceListenerImpl.this.scanCallback.startScan();
            }
        };
        this.scannerInterface = scannerInterface;
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        this.connectionHandlerObserver = anonymousClass4;
        BDPowerListener.BlePowerState blePowerState = new BDPowerListener.BlePowerState() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceListenerImpl.5
            @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDPowerListener.BlePowerState
            public void blePoweredOff() {
                BleLogger.e(BDDeviceListenerImpl.TAG, "BLE powered off");
                BDDeviceListenerImpl.this.scanCallback.powerOff();
                if (BDDeviceListenerImpl.this.powerStateChangedCallback != null) {
                    BDDeviceListenerImpl.this.powerStateChangedCallback.stateChanged(false);
                }
                for (BDDeviceSessionImpl bDDeviceSessionImpl : BDDeviceListenerImpl.this.sessions.getSessions().objects()) {
                    int i = AnonymousClass6.$SwitchMap$com$polar$androidcommunications$api$ble$model$BleDeviceSession$DeviceSessionState[bDDeviceSessionImpl.getSessionState().ordinal()];
                    if (i != 1 && i != 2 && i != 3) {
                        BDDeviceListenerImpl.this.connectionHandler.deviceDisconnected(bDDeviceSessionImpl);
                    } else if (bDDeviceSessionImpl.getGatt() != null) {
                        BDDeviceListenerImpl.this.gattCallback.onConnectionStateChange(bDDeviceSessionImpl.getGatt(), 0, 0);
                    }
                }
            }

            @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDPowerListener.BlePowerState
            public void blePoweredOn() {
                BleLogger.d(BDDeviceListenerImpl.TAG, "BLE powered on");
                BDDeviceListenerImpl.this.scanCallback.powerOn();
                if (BDDeviceListenerImpl.this.powerStateChangedCallback != null) {
                    BDDeviceListenerImpl.this.powerStateChangedCallback.stateChanged(true);
                }
            }
        };
        this.blePowerStateListener = blePowerState;
        this.context = context;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.btManager = bluetoothManager;
        if (bluetoothManager != null) {
            this.bluetoothAdapter = bluetoothManager.getAdapter();
        }
        if (bluetoothManager == null || this.bluetoothAdapter == null) {
            throw new BleNotAvailableInDevice("Device doesn't support BLE");
        }
        ConnectionHandler connectionHandler = new ConnectionHandler(anonymousClass1, scannerInterface, anonymousClass4);
        this.connectionHandler = connectionHandler;
        this.gattCallback = new GattCallback(connectionHandler, bDDeviceList);
        this.bondingManager = new BDBondingListener(context);
        this.scanCallback = new BDScanCallback(context, this.bluetoothAdapter, anonymousClass2);
        this.powerManager = new BDPowerListener(this.bluetoothAdapter, context, blePowerState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$search$0(boolean z, FlowableEmitter[] flowableEmitterArr, FlowableEmitter flowableEmitter) {
        if (z) {
            for (BluetoothDevice bluetoothDevice : this.btManager.getDevicesMatchingConnectionStates(7, new int[]{3})) {
                if (bluetoothDevice.getType() == 2 && this.sessions.getSession(bluetoothDevice) == null) {
                    this.sessions.addSession(new BDDeviceSessionImpl(this.context, bluetoothDevice, this.scanCallback, this.bondingManager, this.factory));
                }
            }
            for (BluetoothDevice bluetoothDevice2 : this.bluetoothAdapter.getBondedDevices()) {
                if (bluetoothDevice2.getType() == 2 && this.sessions.getSession(bluetoothDevice2) == null) {
                    this.sessions.addSession(new BDDeviceSessionImpl(this.context, bluetoothDevice2, this.scanCallback, this.bondingManager, this.factory));
                }
            }
            Iterator<BleDeviceSession> it = this.sessions.copyDeviceList().iterator();
            while (it.hasNext()) {
                flowableEmitter.onNext(it.next());
            }
        }
        flowableEmitterArr[0] = flowableEmitter;
        this.observers.add(flowableEmitter);
        this.scanCallback.clientAdded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$search$1() {
        BleLogger.w(TAG, "search backpressure buffer full");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$search$2(FlowableEmitter[] flowableEmitterArr) {
        this.observers.remove((FlowableEmitter<? super BleDeviceSession>) flowableEmitterArr[0]);
        this.scanCallback.clientRemoved();
    }

    @Override // com.polar.androidcommunications.api.ble.BleDeviceListener
    public boolean bleActive() {
        BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
        return bluetoothAdapter != null && bluetoothAdapter.isEnabled();
    }

    @Override // com.polar.androidcommunications.api.ble.BleDeviceListener
    public Set<BleDeviceSession> deviceSessions() {
        return this.sessions.copyDeviceList();
    }

    @Override // com.polar.androidcommunications.api.ble.BleDeviceListener
    public Observable<Pair<BleDeviceSession, BleDeviceSession.DeviceSessionState>> monitorDeviceSessionState() {
        return this.deviceSessionStateSubject;
    }

    @Override // com.polar.androidcommunications.api.ble.BleDeviceListener
    public void openSessionDirect(BleDeviceSession bleDeviceSession) {
        bleDeviceSession.setConnectionUuids(new ArrayList());
        this.connectionHandler.connectDevice((BDDeviceSessionImpl) bleDeviceSession, bleActive());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.rxjava3.core.FlowableEmitter[], java.io.Serializable, java.lang.Object[]] */
    @Override // com.polar.androidcommunications.api.ble.BleDeviceListener
    public Flowable<BleDeviceSession> search(boolean z) {
        ?? r0 = new FlowableEmitter[1];
        return Flowable.create(new Consent$Companion$$ExternalSyntheticLambda0(this, z, (Serializable) r0), BackpressureStrategy.BUFFER).onBackpressureBuffer(200L, new BDDeviceListenerImpl$$ExternalSyntheticLambda0(3), BackpressureOverflowStrategy.DROP_OLDEST).doFinally(new BDDeviceSessionImpl$$ExternalSyntheticLambda4(this, r0, 1));
    }

    public void setBlePowerStateCallback(BleDeviceListener.BlePowerStateChangedCallback blePowerStateChangedCallback) {
        this.powerStateChangedCallback = blePowerStateChangedCallback;
        if (blePowerStateChangedCallback != null) {
            blePowerStateChangedCallback.stateChanged(bleActive());
        }
    }

    public void setScanPreFilter(BleDeviceListener.BleSearchPreFilter bleSearchPreFilter) {
        this.preFilter = bleSearchPreFilter;
    }

    @Override // com.polar.androidcommunications.api.ble.BleDeviceListener
    public void shutDown() {
        this.bondingManager.stopBroadcastReceiver();
        this.powerManager.stopBroadcastReceiver();
        this.scanCallback.stopScan();
        this.sessions.getSessions().accessAll(new BDDeviceListenerImpl$$ExternalSyntheticLambda0(0));
        this.sessions.getSessions().clear();
    }
}
