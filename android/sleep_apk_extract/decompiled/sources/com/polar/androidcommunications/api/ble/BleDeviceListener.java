package com.polar.androidcommunications.api.ble;

import androidx.core.util.Pair;
import com.polar.androidcommunications.api.ble.model.BleDeviceSession;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattFactory;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BleDeviceListener {
    protected BleGattFactory factory;
    protected BleSearchPreFilter preFilter;

    public interface BlePowerStateChangedCallback {
        void stateChanged(boolean z);
    }

    public interface BleSearchPreFilter {
    }

    public BleDeviceListener(Set<Class<? extends BleGattBase>> set) {
        this.factory = new BleGattFactory(set);
    }

    public abstract boolean bleActive();

    public abstract Set<BleDeviceSession> deviceSessions();

    public abstract Observable<Pair<BleDeviceSession, BleDeviceSession.DeviceSessionState>> monitorDeviceSessionState();

    public abstract void openSessionDirect(BleDeviceSession bleDeviceSession);

    public abstract Flowable<BleDeviceSession> search(boolean z);

    public abstract void shutDown();
}
