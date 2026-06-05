package com.polar.androidcommunications.api.ble.model.gatt;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.exceptions.BleAttributeError;
import com.polar.androidcommunications.api.ble.exceptions.BleCharacteristicNotFound;
import com.polar.androidcommunications.api.ble.exceptions.BleDisconnected;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.urbandroid.privacy.Consent$Companion$$ExternalSyntheticLambda0;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BleGattBase {
    private static final String TAG = "BleGattBase";
    private final AtomicInteger attMtuSize;
    private final AtomicSet<UUID> availableCharacteristics;
    private final AtomicSet<UUID> availableReadableCharacteristics;
    private final AtomicSet<UUID> availableWritableCharacteristics;
    private final HashMap<UUID, Boolean> characteristics;
    private final HashMap<UUID, Boolean> characteristicsRead;
    private boolean encryptionRequired;
    protected boolean isPrimaryService;
    private final HashMap<UUID, AtomicInteger> mandatoryNotificationCharacteristics;
    protected final AtomicInteger mtuSize;
    protected final AtomicBoolean serviceDiscovered;
    protected UUID serviceUuid;
    protected final BleGattTxInterface txInterface;

    public BleGattBase(BleGattTxInterface bleGattTxInterface, UUID uuid) {
        this.characteristics = new HashMap<>();
        this.characteristicsRead = new HashMap<>();
        this.mandatoryNotificationCharacteristics = new HashMap<>();
        this.availableCharacteristics = new AtomicSet<>();
        this.availableReadableCharacteristics = new AtomicSet<>();
        this.availableWritableCharacteristics = new AtomicSet<>();
        this.mtuSize = new AtomicInteger(20);
        this.attMtuSize = new AtomicInteger(23);
        this.isPrimaryService = false;
        this.serviceDiscovered = new AtomicBoolean(false);
        this.encryptionRequired = false;
        this.txInterface = bleGattTxInterface;
        this.serviceUuid = uuid;
    }

    private boolean contains(UUID uuid, Set<UUID> set) {
        return set.contains(uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$waitNotificationEnabled$1(boolean z, AtomicInteger atomicInteger, CompletableEmitter completableEmitter) {
        if (z) {
            try {
                if (!this.txInterface.isConnected()) {
                    throw new BleDisconnected();
                }
            } catch (Exception e) {
                if (completableEmitter.isDisposed()) {
                    return;
                }
                completableEmitter.tryOnError(e);
                return;
            }
        }
        if (atomicInteger == null) {
            throw new BleCharacteristicNotFound();
        }
        if (atomicInteger.get() == 0) {
            completableEmitter.onComplete();
            return;
        }
        if (atomicInteger.get() != -1) {
            throw new BleAttributeError("Failed to set characteristic notification or indication ", atomicInteger.get());
        }
        synchronized (atomicInteger) {
            atomicInteger.wait();
        }
        if (atomicInteger.get() == 0 || completableEmitter.isDisposed()) {
            completableEmitter.onComplete();
        } else {
            if (atomicInteger.get() == -1) {
                throw new BleDisconnected();
            }
            throw new BleAttributeError("Failed to set characteristic notification or indication ", atomicInteger.get());
        }
    }

    public void addAvailableCharacteristic(UUID uuid, int i) {
        if (containsCharacteristic(uuid) && !contains(uuid, this.availableCharacteristics.objects())) {
            this.availableCharacteristics.add(uuid);
        }
        if ((i & 2) != 0 && !contains(uuid, this.availableReadableCharacteristics.objects())) {
            this.availableReadableCharacteristics.add(uuid);
        }
        if (((i & 8) == 0 && (i & 4) == 0) || contains(uuid, this.availableWritableCharacteristics.objects())) {
            return;
        }
        this.availableWritableCharacteristics.add(uuid);
    }

    public void addCharacteristic(UUID uuid, int i) {
        if (((i & 16) != 0 || (i & 32) != 0) && !containsNotifyCharacteristic(uuid)) {
            this.mandatoryNotificationCharacteristics.put(uuid, new AtomicInteger(-1));
        }
        if ((i & 2) != 0 && !containsCharacteristicRead(uuid)) {
            this.characteristicsRead.put(uuid, Boolean.TRUE);
        }
        if (this.characteristics.containsKey(uuid)) {
            return;
        }
        this.characteristics.put(uuid, Boolean.TRUE);
    }

    public void addCharacteristicNotification(UUID uuid) {
        BleLogger.d(TAG, "Added notification characteristic for " + uuid.toString());
        addCharacteristic(uuid, 48);
    }

    public void addCharacteristicRead(UUID uuid) {
        addCharacteristic(uuid, 2);
    }

    public void authenticationCompleted() {
    }

    public void authenticationFailed(Throwable th) {
        BleLogger.e(TAG, "authentication failed: " + th.toString());
    }

    public Completable clientReady(boolean z) {
        return Completable.fromPublisher(Flowable.empty());
    }

    public boolean containsCharacteristic(UUID uuid) {
        return this.characteristics.containsKey(uuid);
    }

    public boolean containsCharacteristicRead(UUID uuid) {
        return this.characteristicsRead.containsKey(uuid);
    }

    public boolean containsNotifyCharacteristic(UUID uuid) {
        return this.mandatoryNotificationCharacteristics.containsKey(uuid);
    }

    public void descriptorWritten(UUID uuid, boolean z, int i) {
        AtomicInteger notificationAtomicInteger = getNotificationAtomicInteger(uuid);
        if (notificationAtomicInteger != null) {
            synchronized (notificationAtomicInteger) {
                try {
                    if (i != 0 || z) {
                        notificationAtomicInteger.set(i);
                    } else {
                        notificationAtomicInteger.set(PHIpAddressSearchManager.END_IP_SCAN);
                    }
                    notificationAtomicInteger.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public AtomicInteger getNotificationAtomicInteger(UUID uuid) {
        if (this.mandatoryNotificationCharacteristics.containsKey(uuid)) {
            return this.mandatoryNotificationCharacteristics.get(uuid);
        }
        return null;
    }

    public BleGattTxInterface getTxInterface() {
        return this.txInterface;
    }

    public boolean hasAllAvailableReadableCharacteristics(Set<UUID> set) {
        return hasCharacteristics(set, this.availableReadableCharacteristics.objects());
    }

    public boolean hasCharacteristics(Set<UUID> set, Set<UUID> set2) {
        return !set2.isEmpty() && set.containsAll(set2);
    }

    public boolean isAutomatic(UUID uuid) {
        return this.characteristics.containsKey(uuid) && this.characteristics.get(uuid).booleanValue();
    }

    public boolean isAutomaticRead(UUID uuid) {
        return this.characteristicsRead.containsKey(uuid) && this.characteristicsRead.get(uuid).booleanValue();
    }

    public boolean isPrimaryService() {
        return this.isPrimaryService;
    }

    public boolean isServiceDiscovered() {
        return this.serviceDiscovered.get();
    }

    public void processCharacteristicDiscovered(UUID uuid, int i) {
        addAvailableCharacteristic(uuid, i);
    }

    public abstract void processServiceData(UUID uuid, byte[] bArr, int i, boolean z);

    public abstract void processServiceDataWritten(UUID uuid, int i);

    public void processServiceDataWrittenWithResponse(UUID uuid, int i) {
        processServiceDataWritten(uuid, i);
    }

    public void removeCharacteristicNotification(UUID uuid) {
        BleLogger.d(TAG, "Remove notification characteristic for " + uuid.toString());
        if (containsNotifyCharacteristic(uuid)) {
            this.mandatoryNotificationCharacteristics.remove(uuid);
        }
        if (containsCharacteristic(uuid)) {
            this.characteristics.remove(uuid);
        }
    }

    public void reset() {
        this.availableCharacteristics.clear();
        this.availableReadableCharacteristics.clear();
        this.availableWritableCharacteristics.clear();
        for (AtomicInteger atomicInteger : this.mandatoryNotificationCharacteristics.values()) {
            synchronized (atomicInteger) {
                atomicInteger.set(-1);
                atomicInteger.notifyAll();
            }
        }
        synchronized (this.serviceDiscovered) {
            this.serviceDiscovered.set(false);
            this.serviceDiscovered.notifyAll();
        }
        this.mtuSize.set(20);
        this.attMtuSize.set(23);
    }

    public boolean serviceBelongsToClient(UUID uuid) {
        return this.serviceUuid.equals(uuid);
    }

    public void setIsPrimaryService(boolean z) {
        this.isPrimaryService = z;
    }

    public void setMtuSize(int i) {
        this.attMtuSize.set(i);
        this.mtuSize.set(i - 3);
    }

    public void setServiceDiscovered(boolean z, UUID uuid) {
        synchronized (this.serviceDiscovered) {
            this.serviceDiscovered.set(z);
            this.serviceDiscovered.notifyAll();
        }
    }

    public Completable waitNotificationEnabled(UUID uuid, boolean z, Scheduler scheduler) {
        return Completable.create(new Consent$Companion$$ExternalSyntheticLambda0(this, z, getNotificationAtomicInteger(uuid))).subscribeOn(scheduler);
    }

    public Completable waitNotificationEnabled(UUID uuid, boolean z) {
        return waitNotificationEnabled(uuid, z, Schedulers.io());
    }

    public void addCharacteristic(UUID uuid) {
        this.characteristics.put(uuid, Boolean.TRUE);
    }

    public BleGattBase(BleGattTxInterface bleGattTxInterface, UUID uuid, boolean z) {
        this.characteristics = new HashMap<>();
        this.characteristicsRead = new HashMap<>();
        this.mandatoryNotificationCharacteristics = new HashMap<>();
        this.availableCharacteristics = new AtomicSet<>();
        this.availableReadableCharacteristics = new AtomicSet<>();
        this.availableWritableCharacteristics = new AtomicSet<>();
        this.mtuSize = new AtomicInteger(20);
        this.attMtuSize = new AtomicInteger(23);
        this.isPrimaryService = false;
        this.serviceDiscovered = new AtomicBoolean(false);
        this.txInterface = bleGattTxInterface;
        this.serviceUuid = uuid;
        this.encryptionRequired = z;
    }
}
