package com.polar.androidcommunications.api.ble.model.gatt;

import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleBattClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleDisClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleH7SettingsClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleHrClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BlePfcClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BlePsdClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleRscClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpClient;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class BleGattFactory {
    private static final String TAG = "BleGattFactory";
    private final Set<Class<? extends BleGattBase>> classesRemote;

    public BleGattFactory(Set<Class<? extends BleGattBase>> set) {
        HashSet hashSet = new HashSet();
        this.classesRemote = hashSet;
        hashSet.addAll(set);
    }

    public Set<BleGattBase> getRemoteServices(BleGattTxInterface bleGattTxInterface) {
        HashSet hashSet = new HashSet();
        Iterator<Class<? extends BleGattBase>> it = this.classesRemote.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(it.next().getDeclaredConstructor(BleGattTxInterface.class).newInstance(bleGattTxInterface));
            } catch (Exception e) {
                BleLogger.e(TAG, "remote services reflections usage failed: " + e.getLocalizedMessage());
                hashSet.clear();
                if (this.classesRemote.contains(BlePsFtpClient.class)) {
                    hashSet.add(new BlePsFtpClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BleHrClient.class)) {
                    hashSet.add(new BleHrClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BlePsdClient.class)) {
                    hashSet.add(new BlePsdClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BleH7SettingsClient.class)) {
                    hashSet.add(new BleH7SettingsClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BlePfcClient.class)) {
                    hashSet.add(new BlePfcClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BleDisClient.class)) {
                    hashSet.add(new BleDisClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BleBattClient.class)) {
                    hashSet.add(new BleBattClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BleRscClient.class)) {
                    hashSet.add(new BleRscClient(bleGattTxInterface));
                }
                if (this.classesRemote.contains(BlePMDClient.class)) {
                    hashSet.add(new BlePMDClient(bleGattTxInterface));
                }
            }
        }
        return hashSet;
    }
}
