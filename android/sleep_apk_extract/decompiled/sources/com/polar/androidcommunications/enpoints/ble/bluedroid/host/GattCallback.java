package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.common.ble.RxUtils;
import com.polar.androidcommunications.enpoints.ble.bluedroid.host.connection.ConnectionHandler;
import com.urbandroid.util.EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda2;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J \u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J \u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0017J \u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0017J \u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J \u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J(\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0017J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/GattCallback;", "Landroid/bluetooth/BluetoothGattCallback;", "connectionHandler", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler;", "sessions", "Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceList;", "(Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/connection/ConnectionHandler;Lcom/polar/androidcommunications/enpoints/ble/bluedroid/host/BDDeviceList;)V", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", SDKConstants.PARAM_VALUE, "", "onCharacteristicRead", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onMtuChanged", "mtu", "onPhyRead", "txPhy", "rxPhy", "onPhyUpdate", "onReadRemoteRssi", "rssi", "onServiceChanged", "onServicesDiscovered", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GattCallback extends BluetoothGattCallback {
    private final ConnectionHandler connectionHandler;
    private final BDDeviceList sessions;

    public GattCallback(ConnectionHandler connectionHandler, BDDeviceList bDDeviceList) {
        connectionHandler.getClass();
        bDDeviceList.getClass();
        this.connectionHandler = connectionHandler;
        this.sessions = bDDeviceList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectionStateChange$lambda$0(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        gattCallback.connectionHandler.connectionInitialized(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectionStateChange$lambda$1(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        gattCallback.connectionHandler.deviceDisconnected(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectionStateChange$lambda$2(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        gattCallback.connectionHandler.deviceDisconnected(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMtuChanged$lambda$7(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        gattCallback.connectionHandler.mtuUpdated(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPhyRead$lambda$9(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        gattCallback.connectionHandler.phyUpdated(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPhyUpdate$lambda$8(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        gattCallback.connectionHandler.phyUpdated(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReadRemoteRssi$lambda$6(int i, SingleEmitter singleEmitter) {
        singleEmitter.getClass();
        singleEmitter.onSuccess(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onServicesDiscovered$lambda$4(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        bDDeviceSessionImpl.getClass();
        gattCallback.connectionHandler.servicesDiscovered(bDDeviceSessionImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onServicesDiscovered$lambda$5(GattCallback gattCallback, BDDeviceSessionImpl bDDeviceSessionImpl) {
        gattCallback.getClass();
        bDDeviceSessionImpl.getClass();
        gattCallback.connectionHandler.disconnectDevice(bDDeviceSessionImpl);
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        gatt.getClass();
        characteristic.getClass();
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleCharacteristicValueUpdated(characteristic.getService(), characteristic, characteristic.getValue());
        } else {
            BleLogger.INSTANCE.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        gatt.getClass();
        characteristic.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "GATT onCharacteristicRead characteristic:" + characteristic.getUuid() + " status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleCharacteristicRead(characteristic.getService(), characteristic, characteristic.getValue(), status);
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        gatt.getClass();
        characteristic.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "GATT onCharacteristicWrite characteristic:" + characteristic.getUuid() + " status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleCharacteristicWrite(characteristic.getService(), characteristic, status);
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        gatt.getClass();
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", Fragment$$ExternalSyntheticOutline1.m(newState, status, "GATT state changed device newState: ", " status: "));
        if (session == null) {
            companion.e("GattCallback", "Dead gatt object received");
            gatt.close();
        } else if (newState == 0) {
            Completable.fromAction(new GattCallback$$ExternalSyntheticLambda0(this, session, 6)).subscribeOn(Schedulers.io()).subscribe();
        } else {
            if (newState != 2) {
                return;
            }
            if (status == 0) {
                Completable.timer(500L, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new GattCallback$$ExternalSyntheticLambda0(this, session, 4));
            } else {
                Completable.fromAction(new GattCallback$$ExternalSyntheticLambda0(this, session, 5)).subscribeOn(Schedulers.io()).subscribe();
            }
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        gatt.getClass();
        descriptor.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "GATT onDescriptorRead descriptor:" + descriptor.getUuid() + " status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleDescriptorRead(descriptor, descriptor.getValue(), status);
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        gatt.getClass();
        descriptor.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "GATT onDescriptorWrite descriptor: " + descriptor.getUuid() + " status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleDescriptorWrite(descriptor.getCharacteristic().getService(), descriptor.getCharacteristic(), descriptor.getValue(), status);
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
        gatt.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "onMtuChanged status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleMtuChanged(mtu, status);
            Completable.fromAction(new GattCallback$$ExternalSyntheticLambda0(this, session, 2)).subscribeOn(Schedulers.io()).subscribe();
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onPhyRead(BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
        gatt.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(txPhy, rxPhy, " phy read tx: ", " rx: ", " status: ");
        sbM.append(status);
        companion.d("GattCallback", sbM.toString());
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            Completable.fromAction(new GattCallback$$ExternalSyntheticLambda0(this, session, 3)).subscribeOn(Schedulers.io()).subscribe();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onPhyUpdate(BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
        gatt.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(txPhy, rxPhy, " phy updated tx: ", " rx: ", " status: ");
        sbM.append(status);
        companion.d("GattCallback", sbM.toString());
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            Completable.fromAction(new GattCallback$$ExternalSyntheticLambda0(this, session, 7)).subscribeOn(Schedulers.io()).subscribe();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
        gatt.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "onReadRemoteRssi status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            RxUtils.emitNext(session.getRssiObservers(), new EdgeToEdgeUtil$Companion$$ExternalSyntheticLambda2(rssi, 1));
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServiceChanged(BluetoothGatt gatt) {
        gatt.getClass();
        super.onServiceChanged(gatt);
        BleLogger.INSTANCE.d("GattCallback", " onServiceChanged");
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onServicesDiscovered(BluetoothGatt gatt, int status) {
        gatt.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "GATT onServicesDiscovered. Status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session == null) {
            companion.e("GattCallback", "services discovered on non known gatt");
            return;
        }
        Disposable disposable = session.serviceDiscovery;
        if (disposable != null) {
            disposable.dispose();
            session.serviceDiscovery = null;
        }
        if (status == 0) {
            session.handleServicesDiscovered();
            Completable.timer(500L, TimeUnit.MILLISECONDS).observeOn(Schedulers.io()).subscribe(new GattCallback$$ExternalSyntheticLambda0(this, session, 0));
        } else {
            companion.e("GattCallback", "service discovery failed: " + status);
            Completable.fromAction(new GattCallback$$ExternalSyntheticLambda0(this, session, 1)).subscribeOn(Schedulers.io()).subscribe();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value) {
        gatt.getClass();
        characteristic.getClass();
        value.getClass();
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleCharacteristicValueUpdated(characteristic.getService(), characteristic, value);
        } else {
            BleLogger.INSTANCE.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status, byte[] value) {
        gatt.getClass();
        descriptor.getClass();
        value.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "GATT onDescriptorRead descriptor:" + descriptor.getUuid() + " status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleDescriptorRead(descriptor, value, status);
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }

    @Override // android.bluetooth.BluetoothGattCallback
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value, int status) {
        gatt.getClass();
        characteristic.getClass();
        value.getClass();
        BleLogger.Companion companion = BleLogger.INSTANCE;
        companion.d("GattCallback", "GATT onCharacteristicRead characteristic:" + characteristic.getUuid() + " status: " + status);
        BDDeviceSessionImpl session = this.sessions.getSession(gatt);
        if (session != null) {
            session.handleCharacteristicRead(characteristic.getService(), characteristic, value, status);
        } else {
            companion.e("GattCallback", "Dead gatt event?");
            gatt.close();
        }
    }
}
