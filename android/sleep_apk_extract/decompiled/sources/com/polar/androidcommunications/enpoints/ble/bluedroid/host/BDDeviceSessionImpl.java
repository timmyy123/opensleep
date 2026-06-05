package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.exceptions.BleCharacteristicNotFound;
import com.polar.androidcommunications.api.ble.exceptions.BleDisconnected;
import com.polar.androidcommunications.api.ble.exceptions.BleGattNotInitialized;
import com.polar.androidcommunications.api.ble.exceptions.BleNotSupported;
import com.polar.androidcommunications.api.ble.exceptions.BleServiceNotFound;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattFactory;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.common.ble.AndroidBuildUtils;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.AttributeOperation;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDBondingListener;
import com.urbandroid.privacy.Consent$Companion$$ExternalSyntheticLambda0;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes4.dex */
public class BDDeviceSessionImpl extends BleDeviceSession implements BleGattTxInterface {
    private static final UUID DESCRIPTOR_CCC = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private static final String TAG = "BDDeviceSessionImpl";
    private final BDScanCallback bleScanCallback;
    private BluetoothDevice bluetoothDevice;
    private final BDBondingListener bondingManager;
    private final Context context;
    private BluetoothGatt gatt;
    private final Handler handler;
    Disposable serviceDiscovery;
    private final Object gattMutex = new Object();
    private final LinkedBlockingDeque<AttributeOperation> attOperations = new LinkedBlockingDeque<>();
    private final AtomicSet<SingleEmitter<? super List<UUID>>> servicesSubscriberAtomicList = new AtomicSet<>();
    private final AtomicSet<SingleEmitter<? super Integer>> rssiObservers = new AtomicSet<>();
    private final List<Disposable> subscriptions = new ArrayList();
    private final List<String> brandsNotImplementingAndroid13Api = Arrays.asList("OnePlus", "Oppo", "Realme");

    /* JADX INFO: renamed from: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$polar$androidcommunications$enpoints$ble$bluedroid$host$AttributeOperation$AttributeOperationCommand;

        static {
            int[] iArr = new int[AttributeOperation.AttributeOperationCommand.values().length];
            $SwitchMap$com$polar$androidcommunications$enpoints$ble$bluedroid$host$AttributeOperation$AttributeOperationCommand = iArr;
            try {
                iArr[AttributeOperation.AttributeOperationCommand.CHARACTERISTIC_READ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$polar$androidcommunications$enpoints$ble$bluedroid$host$AttributeOperation$AttributeOperationCommand[AttributeOperation.AttributeOperationCommand.CHARACTERISTIC_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$polar$androidcommunications$enpoints$ble$bluedroid$host$AttributeOperation$AttributeOperationCommand[AttributeOperation.AttributeOperationCommand.DESCRIPTOR_WRITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BDDeviceSessionImpl(Context context, BluetoothDevice bluetoothDevice, BDScanCallback bDScanCallback, BDBondingListener bDBondingListener, BleGattFactory bleGattFactory) {
        this.context = context;
        this.handler = new Handler(context.getMainLooper());
        this.bluetoothDevice = bluetoothDevice;
        this.bleScanCallback = bDScanCallback;
        this.bondingManager = bDBondingListener;
        this.clients = bleGattFactory.getRemoteServices(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthenticationFailed(Throwable th) {
        processNextAttributeOperation(false);
        Iterator<BleGattBase> it = this.clients.iterator();
        while (it.hasNext()) {
            it.next().authenticationFailed(th);
        }
    }

    private void handleServiceDiscovered(List<AttributeOperation> list, BluetoothGattService bluetoothGattService) {
        BleGattBase bleGattBaseFetchClient = fetchClient(bluetoothGattService.getUuid());
        String str = TAG;
        BleLogger.d(str, " SERVICE: " + bluetoothGattService.getUuid().toString());
        if (bleGattBaseFetchClient == null) {
            BleLogger.d(str, "No client found for SERVICE: " + bluetoothGattService.getUuid().toString() + " chrs: " + bluetoothGattService.getCharacteristics().size());
            return;
        }
        bleGattBaseFetchClient.setServiceDiscovered(true, bluetoothGattService.getUuid());
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
            BleLogger.d(TAG, "     CHARACTERISTIC: " + bluetoothGattCharacteristic.getUuid().toString() + " PROPERTIES: " + bluetoothGattCharacteristic.getProperties());
            bleGattBaseFetchClient.processCharacteristicDiscovered(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getProperties());
            if (bleGattBaseFetchClient.containsNotifyCharacteristic(bluetoothGattCharacteristic.getUuid()) && (((bluetoothGattCharacteristic.getProperties() & 16) != 0 || (bluetoothGattCharacteristic.getProperties() & 32) != 0) && bleGattBaseFetchClient.isAutomatic(bluetoothGattCharacteristic.getUuid()))) {
                AttributeOperation attributeOperation = new AttributeOperation(AttributeOperation.AttributeOperationCommand.DESCRIPTOR_WRITE, bluetoothGattCharacteristic, true);
                attributeOperation.setIsPartOfPrimaryService(bleGattBaseFetchClient.isPrimaryService());
                list.add(attributeOperation);
            }
            if (bleGattBaseFetchClient.containsCharacteristicRead(bluetoothGattCharacteristic.getUuid()) && (bluetoothGattCharacteristic.getProperties() & 2) != 0 && bleGattBaseFetchClient.isAutomaticRead(bluetoothGattCharacteristic.getUuid())) {
                AttributeOperation attributeOperation2 = new AttributeOperation(AttributeOperation.AttributeOperationCommand.CHARACTERISTIC_READ, bluetoothGattCharacteristic);
                attributeOperation2.setIsPartOfPrimaryService(bleGattBaseFetchClient.isPrimaryService());
                list.add(attributeOperation2);
            }
        }
    }

    private boolean isBrandImplementingAndroid13Api(final String str) {
        return this.brandsNotImplementingAndroid13Api.stream().noneMatch(new Predicate() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return BDDeviceSessionImpl.lambda$isBrandImplementingAndroid13Api$4(str, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$authenticate$0(BDBondingListener.BondingObserver[] bondingObserverArr, final CompletableEmitter completableEmitter) {
        if (getSessionState() != BleDeviceSession.DeviceSessionState.SESSION_OPEN) {
            completableEmitter.onError(new BleDisconnected());
            return;
        }
        switch (this.bluetoothDevice.getBondState()) {
            case 10:
                if (!this.bluetoothDevice.createBond()) {
                    completableEmitter.tryOnError(new Throwable("BD bonding start failed"));
                    return;
                }
                break;
            case 11:
                break;
            case 12:
                completableEmitter.onComplete();
                return;
            default:
                return;
        }
        BDBondingListener.BondingObserver bondingObserver = new BDBondingListener.BondingObserver(this, this.bluetoothDevice) { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDDeviceSessionImpl.1
            @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDBondingListener.AuthenticationObserverInterface
            public void bondNone() {
            }

            @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDBondingListener.AuthenticationObserverInterface
            public void bonded() {
                completableEmitter.onComplete();
            }

            @Override // com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDBondingListener.AuthenticationObserverInterface
            public void bonding() {
            }
        };
        bondingObserverArr[0] = bondingObserver;
        this.bondingManager.addObserver(bondingObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$authenticate$1(BDBondingListener.BondingObserver[] bondingObserverArr) {
        this.bondingManager.removeObserver(bondingObserverArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleServicesDiscovered$7(List list, SingleEmitter singleEmitter) {
        singleEmitter.onSuccess(new ArrayList(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isBrandImplementingAndroid13Api$4(String str, String str2) {
        return str2.equalsIgnoreCase(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$monitorServicesDiscovered$5(boolean z, SingleEmitter[] singleEmitterArr, SingleEmitter singleEmitter) {
        if (z && getSessionState() != BleDeviceSession.DeviceSessionState.SESSION_OPEN) {
            singleEmitter.tryOnError(new BleDisconnected());
            return;
        }
        singleEmitterArr[0] = singleEmitter;
        this.servicesSubscriberAtomicList.add(singleEmitter);
        synchronized (this.gattMutex) {
            try {
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt != null && !bluetoothGatt.getServices().isEmpty()) {
                    List<BluetoothGattService> services = this.gatt.getServices();
                    ArrayList arrayList = new ArrayList();
                    Iterator<BluetoothGattService> it = services.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getUuid());
                    }
                    singleEmitter.onSuccess(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$monitorServicesDiscovered$6(SingleEmitter[] singleEmitterArr) {
        this.servicesSubscriberAtomicList.remove((SingleEmitter<? super List<UUID>>) singleEmitterArr[0]);
    }

    private void logIfError(String str, int i) {
        if (i != 0) {
            BleLogger.e(TAG, str + " Failed with error: " + i);
        }
    }

    private boolean sendNextAttributeOperation(AttributeOperation attributeOperation) {
        byte[] bArr;
        BluetoothGattCharacteristic characteristic = attributeOperation.getCharacteristic();
        synchronized (getGattMutex()) {
            try {
                if (this.gatt == null) {
                    throw new BleGattNotInitialized("Attribute operation tried while gatt is uninitialized");
                }
                int i = AnonymousClass2.$SwitchMap$com$polar$androidcommunications$enpoints$ble$bluedroid$host$AttributeOperation$AttributeOperationCommand[attributeOperation.getAttributeOperation().ordinal()];
                if (i == 1) {
                    return getGatt().readCharacteristic(characteristic);
                }
                int i2 = 2;
                if (i == 2) {
                    if (!attributeOperation.isWithResponse() || (characteristic.getProperties() & 8) == 0) {
                        if ((characteristic.getProperties() & 4) == 0) {
                            BleLogger.e(TAG, "Undefined state. BluetoothGattCharacteristic write type cannot be defined.");
                            return false;
                        }
                        i2 = 1;
                    }
                    if (AndroidBuildUtils.getBuildVersion() < 33) {
                        characteristic.setWriteType(i2);
                        characteristic.setValue(attributeOperation.getData());
                        return this.gatt.writeCharacteristic(characteristic);
                    }
                    int iWriteCharacteristic = this.gatt.writeCharacteristic(characteristic, attributeOperation.getData(), i2);
                    if (iWriteCharacteristic == 0) {
                        return true;
                    }
                    BleLogger.e(TAG, "Error: characteristic write failed. Reason: " + iWriteCharacteristic);
                    return false;
                }
                if (i != 3) {
                    throw new BleNotSupported("not supported");
                }
                BluetoothGattDescriptor descriptor = attributeOperation.getCharacteristic().getDescriptor(DESCRIPTOR_CCC);
                if ((characteristic.getProperties() & 16) > 0) {
                    bArr = attributeOperation.isEnable() ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                } else {
                    if ((characteristic.getProperties() & 32) <= 0) {
                        return false;
                    }
                    bArr = attributeOperation.isEnable() ? BluetoothGattDescriptor.ENABLE_INDICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                }
                this.gatt.setCharacteristicNotification(characteristic, attributeOperation.isEnable());
                boolean zIsEmpty = getPolarDeviceType().isEmpty();
                if (AndroidBuildUtils.getBuildVersion() < 33 || !(isBrandImplementingAndroid13Api(AndroidBuildUtils.getBrand()) || zIsEmpty)) {
                    BleLogger.d(TAG, "using deprecated descriptor write");
                    descriptor.setValue(bArr);
                    return this.gatt.writeDescriptor(descriptor);
                }
                int iWriteDescriptor = this.gatt.writeDescriptor(descriptor, bArr);
                if (iWriteDescriptor == 0) {
                    return true;
                }
                BleLogger.e(TAG, "Error: descriptor write failed. Reason: " + iWriteDescriptor);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void startAuthentication(Action action) {
        this.subscriptions.add(authenticate().toObservable().delaySubscription(500L, TimeUnit.MILLISECONDS).ignoreElements().observeOn(AndroidSchedulers.from(this.context.getMainLooper())).subscribe(action, new BDDeviceSessionImpl$$ExternalSyntheticLambda1(this)));
    }

    public Completable authenticate() {
        BDBondingListener.BondingObserver[] bondingObserverArr = {null};
        return Completable.create(new BDDeviceSessionImpl$$ExternalSyntheticLambda8(this, bondingObserverArr)).doFinally(new BDDeviceSessionImpl$$ExternalSyntheticLambda8(this, bondingObserverArr));
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface
    public void gattClientRequestStopScanning() {
        BleLogger.d(TAG, "GATT client request stop scanning");
        Handler handler = this.handler;
        BDScanCallback bDScanCallback = this.bleScanCallback;
        Objects.requireNonNull(bDScanCallback);
        handler.post(new BDDeviceSessionImpl$$ExternalSyntheticLambda6(bDScanCallback, 0));
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface
    public void gattClientResumeScanning() {
        BleLogger.d(TAG, "GATT client request continue scanning");
        Handler handler = this.handler;
        BDScanCallback bDScanCallback = this.bleScanCallback;
        Objects.requireNonNull(bDScanCallback);
        handler.post(new BDDeviceSessionImpl$$ExternalSyntheticLambda6(bDScanCallback, 1));
    }

    @Override // com.polar.androidcommunications.api.ble.model.BleDeviceSession
    public String getAddress() {
        return this.bluetoothDevice.getAddress();
    }

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public BluetoothGatt getGatt() {
        return this.gatt;
    }

    public Object getGattMutex() {
        return this.gattMutex;
    }

    public AtomicSet<SingleEmitter<? super Integer>> getRssiObservers() {
        return this.rssiObservers;
    }

    public void handleAuthenticationComplete() {
        processNextAttributeOperation(false);
        Iterator<BleGattBase> it = this.clients.iterator();
        while (it.hasNext()) {
            it.next().authenticationCompleted();
        }
    }

    public void handleCharacteristicRead(BluetoothGattService bluetoothGattService, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        logIfError("handleCharacteristicRead uuid: " + bluetoothGattCharacteristic.getUuid().toString(), i);
        if (i == 5 || i == 15) {
            BleLogger.e(TAG, "Attribute operation read failed due the reason: " + i);
            startAuthentication(new BDDeviceSessionImpl$$ExternalSyntheticLambda1(this));
        }
        if (i != 5 && i != 15) {
            processNextAttributeOperation(true);
        }
        BleGattBase bleGattBaseFetchClient = fetchClient(bluetoothGattService.getUuid());
        if (bleGattBaseFetchClient == null || !bleGattBaseFetchClient.containsCharacteristic(bluetoothGattCharacteristic.getUuid())) {
            return;
        }
        bleGattBaseFetchClient.processServiceData(bluetoothGattCharacteristic.getUuid(), bArr, i, false);
    }

    public void handleCharacteristicValueUpdated(BluetoothGattService bluetoothGattService, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        BleGattBase bleGattBaseFetchClient = fetchClient(bluetoothGattService.getUuid());
        if (bleGattBaseFetchClient == null || !bleGattBaseFetchClient.containsCharacteristic(bluetoothGattCharacteristic.getUuid())) {
            BleLogger.e(TAG, "Unhandled notification received");
        } else {
            bleGattBaseFetchClient.processServiceData(bluetoothGattCharacteristic.getUuid(), bArr, 0, true);
        }
    }

    public void handleCharacteristicWrite(BluetoothGattService bluetoothGattService, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        logIfError("handleCharacteristicWrite uuid: " + bluetoothGattCharacteristic.getUuid().toString(), i);
        if (i == 5 || i == 15) {
            BleLogger.e(TAG, "Attribute operation write failed due the reason: " + i);
            startAuthentication(new BDDeviceSessionImpl$$ExternalSyntheticLambda1(this));
        }
        BleGattBase bleGattBaseFetchClient = fetchClient(bluetoothGattService.getUuid());
        if (bleGattBaseFetchClient != null && bleGattBaseFetchClient.containsCharacteristic(bluetoothGattCharacteristic.getUuid())) {
            if (this.attOperations.isEmpty() || !this.attOperations.peek().isWithResponse()) {
                bleGattBaseFetchClient.processServiceDataWritten(bluetoothGattCharacteristic.getUuid(), i);
            } else {
                bleGattBaseFetchClient.processServiceDataWrittenWithResponse(bluetoothGattCharacteristic.getUuid(), i);
            }
        }
        if (i == 5 || i == 15) {
            return;
        }
        processNextAttributeOperation(true);
    }

    public void handleDescriptorRead(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i) {
        BleLogger.d(TAG, "onDescriptorRead status: " + i);
        processNextAttributeOperation(true);
    }

    public void handleDescriptorWrite(BluetoothGattService bluetoothGattService, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        String str = TAG;
        BleLogger.d(str, "onDescriptorWrite uuid: " + bluetoothGattCharacteristic.getUuid().toString() + " status: " + i);
        if (i == 5 || i == 15) {
            BleLogger.e(str, "Attribute operation descriptor write failed due the reason: " + i);
            startAuthentication(new BDDeviceSessionImpl$$ExternalSyntheticLambda1(this));
        }
        if (i != 5 && i != 15) {
            processNextAttributeOperation(true);
        }
        boolean z = !Arrays.equals(new byte[]{0, 0}, bArr);
        if (i != 0) {
            z = false;
        }
        BleGattBase bleGattBaseFetchClient = fetchClient(bluetoothGattService.getUuid());
        if (bleGattBaseFetchClient == null || !bleGattBaseFetchClient.containsCharacteristic(bluetoothGattCharacteristic.getUuid())) {
            return;
        }
        bleGattBaseFetchClient.descriptorWritten(bluetoothGattCharacteristic.getUuid(), z, i);
    }

    public void handleDisconnection() {
        BleLogger.d(TAG, "disconnected");
        this.advertisementContent.resetAdvertisementData();
        this.attOperations.clear();
        Iterator<BleGattBase> it = this.clients.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        RxUtils.postDisconnectedAndClearList(this.servicesSubscriberAtomicList);
        RxUtils.postDisconnectedAndClearList(this.rssiObservers);
        Iterator<Disposable> it2 = this.subscriptions.iterator();
        while (it2.hasNext()) {
            it2.next().dispose();
        }
        this.subscriptions.clear();
        Disposable disposable = this.serviceDiscovery;
        if (disposable != null) {
            disposable.dispose();
            this.serviceDiscovery = null;
        }
    }

    public void handleMtuChanged(int i, int i2) {
        BleLogger.d(TAG, "handleMtuChanged status: " + i2 + " mtu: " + i);
        if (i2 == 0) {
            Iterator<BleGattBase> it = this.clients.iterator();
            while (it.hasNext()) {
                it.next().setMtuSize(i);
            }
        }
    }

    public void handleServicesDiscovered() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (this.gattMutex) {
            try {
                for (BluetoothGattService bluetoothGattService : this.gatt.getServices()) {
                    arrayList2.add(bluetoothGattService.getUuid());
                    handleServiceDiscovered(arrayList, bluetoothGattService);
                    for (BluetoothGattService bluetoothGattService2 : bluetoothGattService.getIncludedServices()) {
                        BleLogger.d(TAG, " INCLUDED SERVICE: " + bluetoothGattService2.getUuid());
                        arrayList2.add(bluetoothGattService2.getUuid());
                        handleServiceDiscovered(arrayList, bluetoothGattService2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        RxUtils.emitNext(this.servicesSubscriberAtomicList, new BDDeviceList$$ExternalSyntheticLambda0(arrayList2, 3));
        Collections.sort(arrayList);
        this.attOperations.clear();
        this.attOperations.addAll(arrayList);
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface
    public boolean isConnected() {
        return getSessionState() == BleDeviceSession.DeviceSessionState.SESSION_OPEN;
    }

    @Override // com.polar.androidcommunications.api.ble.model.BleDeviceSession
    public boolean isNonConnectableAdvertisement() {
        return this.advertisementContent.isNonConnectableAdvertisement();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [io.reactivex.rxjava3.core.SingleEmitter[], java.io.Serializable, java.lang.Object[]] */
    @Override // com.polar.androidcommunications.api.ble.model.BleDeviceSession
    public Single<List<UUID>> monitorServicesDiscovered(boolean z) {
        ?? r0 = new SingleEmitter[1];
        return Single.create(new Consent$Companion$$ExternalSyntheticLambda0(this, z, (Serializable) r0)).doFinally(new BDDeviceSessionImpl$$ExternalSyntheticLambda4(this, r0, 0));
    }

    public void processNextAttributeOperation(boolean z) {
        if (this.attOperations.isEmpty()) {
            return;
        }
        if (z) {
            try {
                this.attOperations.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
        if (this.attOperations.isEmpty()) {
            return;
        }
        AttributeOperation attributeOperationPeek = this.attOperations.peek();
        Objects.requireNonNull(attributeOperationPeek);
        try {
            try {
                if (sendNextAttributeOperation(attributeOperationPeek)) {
                    return;
                }
                BleLogger.w(TAG, "Attribute operation still pending");
            } catch (BleGattNotInitialized unused) {
                BleLogger.e(TAG, "attribute operation failed due to reason gatt not initialized, ALL att operations will be removed");
                this.attOperations.clear();
            }
        } catch (BleNotSupported e2) {
            BleLogger.e(TAG, "attribute operation failed due to reason: " + e2.getLocalizedMessage());
            processNextAttributeOperation(true);
        } catch (Throwable unused2) {
            this.attOperations.clear();
        }
    }

    public void reset() {
        BleLogger.d(TAG, "reset");
        resetGatt();
    }

    public void resetGatt() {
        synchronized (this.gattMutex) {
            BluetoothGatt bluetoothGatt = this.gatt;
            if (bluetoothGatt != null) {
                try {
                    bluetoothGatt.close();
                } catch (Exception e) {
                    BleLogger.e(TAG, "gatt error: " + e);
                }
                this.gatt = null;
            }
        }
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.bluetoothDevice = bluetoothDevice;
        resetGatt();
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface
    public void setCharacteristicNotify(UUID uuid, UUID uuid2, boolean z) {
        synchronized (this.gattMutex) {
            try {
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt == null) {
                    throw new BleGattNotInitialized();
                }
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    if (bluetoothGattService.getUuid().equals(uuid)) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                            if (bluetoothGattCharacteristic.getUuid().equals(uuid2)) {
                                if ((bluetoothGattCharacteristic.getProperties() & 16) > 0 || (bluetoothGattCharacteristic.getProperties() & 32) > 0) {
                                    this.attOperations.add(new AttributeOperation(AttributeOperation.AttributeOperationCommand.DESCRIPTOR_WRITE, bluetoothGattCharacteristic, z));
                                    if (this.attOperations.size() == 1) {
                                        processNextAttributeOperation(false);
                                    }
                                }
                            }
                        }
                        throw new BleCharacteristicNotFound();
                    }
                }
                throw new BleServiceNotFound();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setGatt(BluetoothGatt bluetoothGatt) {
        synchronized (getGattMutex()) {
            this.gatt = bluetoothGatt;
        }
    }

    public void setSessionState(BleDeviceSession.DeviceSessionState deviceSessionState) {
        this.previousState = this.state;
        this.state = deviceSessionState;
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface
    public void transmitMessage(UUID uuid, UUID uuid2, byte[] bArr, boolean z) {
        synchronized (this.gattMutex) {
            try {
                BluetoothGatt bluetoothGatt = this.gatt;
                if (bluetoothGatt == null) {
                    throw new BleGattNotInitialized();
                }
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    if (bluetoothGattService.getUuid().equals(uuid)) {
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                            if (bluetoothGattCharacteristic.getUuid().equals(uuid2)) {
                                this.attOperations.add(new AttributeOperation(AttributeOperation.AttributeOperationCommand.CHARACTERISTIC_WRITE, bArr, bluetoothGattCharacteristic, z));
                                if (this.attOperations.size() == 1) {
                                    processNextAttributeOperation(false);
                                }
                            }
                        }
                        throw new BleCharacteristicNotFound();
                    }
                }
                throw new BleServiceNotFound();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface
    public void transmitMessages(UUID uuid, UUID uuid2, List<byte[]> list, boolean z) {
        Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            transmitMessage(uuid, uuid2, it.next(), z);
        }
    }
}
