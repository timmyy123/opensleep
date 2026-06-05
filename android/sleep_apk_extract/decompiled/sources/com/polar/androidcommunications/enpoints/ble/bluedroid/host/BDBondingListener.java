package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.common.ble.AtomicSet;

/* JADX INFO: loaded from: classes4.dex */
class BDBondingListener {
    private static final String TAG = "BDBondingListener";
    private final Context context;
    private final AtomicSet<BondingObserver> authenticationObservers = new AtomicSet<>();
    private BroadcastReceiver mReceiver = new AnonymousClass1();

    /* JADX INFO: renamed from: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDBondingListener$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceive$0(BluetoothDevice bluetoothDevice, BondingObserver bondingObserver) {
            if (bondingObserver.getDevice().equals(bluetoothDevice)) {
                bondingObserver.bonding();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceive$1(BluetoothDevice bluetoothDevice, BondingObserver bondingObserver) {
            if (bondingObserver.getDevice().equals(bluetoothDevice)) {
                bondingObserver.bonded();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onReceive$2(BluetoothDevice bluetoothDevice, BondingObserver bondingObserver) {
            if (bondingObserver.getDevice().equals(bluetoothDevice)) {
                bondingObserver.bondNone();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null || action == null || !action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                return;
            }
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
            BleLogger.d(BDBondingListener.TAG, "Bond manager state:" + intExtra + " action: " + intent);
            switch (intExtra) {
                case 10:
                    BDBondingListener.this.authenticationObservers.accessAll(new BDDeviceList$$ExternalSyntheticLambda2(bluetoothDevice, 3));
                    break;
                case 11:
                    BDBondingListener.this.authenticationObservers.accessAll(new BDDeviceList$$ExternalSyntheticLambda2(bluetoothDevice, 1));
                    break;
                case 12:
                    BDBondingListener.this.authenticationObservers.accessAll(new BDDeviceList$$ExternalSyntheticLambda2(bluetoothDevice, 2));
                    break;
            }
        }
    }

    public interface AuthenticationObserverInterface {
        void bondNone();

        void bonded();

        void bonding();
    }

    public static abstract class BondingObserver implements AuthenticationObserverInterface {
        private final BluetoothDevice device;

        public BondingObserver(BluetoothDevice bluetoothDevice) {
            this.device = bluetoothDevice;
        }

        public BluetoothDevice getDevice() {
            return this.device;
        }
    }

    public BDBondingListener(Context context) {
        this.context = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        context.registerReceiver(this.mReceiver, intentFilter);
    }

    public void addObserver(BondingObserver bondingObserver) {
        this.authenticationObservers.add(bondingObserver);
    }

    public void removeObserver(BondingObserver bondingObserver) {
        this.authenticationObservers.remove(bondingObserver);
    }

    public void stopBroadcastReceiver() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.mReceiver = null;
        }
    }
}
