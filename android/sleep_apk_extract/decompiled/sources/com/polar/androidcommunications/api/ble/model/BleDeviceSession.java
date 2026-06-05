package com.polar.androidcommunications.api.ble.model;

import com.polar.androidcommunications.api.ble.model.advertisement.BleAdvertisementContent;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import io.reactivex.rxjava3.core.Single;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BleDeviceSession {
    protected BleAdvertisementContent advertisementContent;
    protected Set<BleGattBase> clients;
    private final List<String> connectionUuids;
    protected DeviceSessionState previousState;
    protected DeviceSessionState state;

    public enum DeviceSessionState {
        SESSION_CLOSED,
        SESSION_OPENING,
        SESSION_OPEN_PARK,
        SESSION_OPEN,
        SESSION_CLOSING
    }

    public BleDeviceSession() {
        DeviceSessionState deviceSessionState = DeviceSessionState.SESSION_CLOSED;
        this.state = deviceSessionState;
        this.previousState = deviceSessionState;
        this.advertisementContent = new BleAdvertisementContent();
        this.connectionUuids = new ArrayList();
    }

    public BleGattBase fetchClient(UUID uuid) {
        for (BleGattBase bleGattBase : this.clients) {
            if (bleGattBase.serviceBelongsToClient(uuid)) {
                return bleGattBase;
            }
        }
        return null;
    }

    public abstract String getAddress();

    public BleAdvertisementContent getAdvertisementContent() {
        return this.advertisementContent;
    }

    public List<String> getConnectionUuids() {
        return this.connectionUuids;
    }

    public String getName() {
        return this.advertisementContent.getName();
    }

    public String getPolarDeviceId() {
        return this.advertisementContent.getPolarDeviceId();
    }

    public String getPolarDeviceType() {
        return this.advertisementContent.getPolarDeviceType();
    }

    public DeviceSessionState getPreviousState() {
        return this.previousState;
    }

    public int getRssi() {
        return this.advertisementContent.getRssi();
    }

    public DeviceSessionState getSessionState() {
        return this.state;
    }

    public boolean isConnectableAdvertisement() {
        return !isNonConnectableAdvertisement();
    }

    public abstract boolean isNonConnectableAdvertisement();

    public abstract Single<List<UUID>> monitorServicesDiscovered(boolean z);

    public void setConnectionUuids(List<String> list) {
        this.connectionUuids.clear();
        this.connectionUuids.addAll(list);
    }
}
