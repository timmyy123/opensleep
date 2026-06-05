package com.polar.androidcommunications.api.ble.model.gatt.client;

import com.facebook.internal.AnalyticsEvents;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0013\u001a\u00020\u000fJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\n0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/BleBattClient;", "Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattBase;", "txInterface", "Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattTxInterface;", "(Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattTxInterface;)V", "batteryChargeStateObservers", "Lcom/polar/androidcommunications/common/ble/AtomicSet;", "Lio/reactivex/rxjava3/core/FlowableEmitter;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/ChargeState;", "batteryStatusObservers", "", "cachedBatteryPercentage", "Ljava/util/concurrent/atomic/AtomicInteger;", "cachedChargeState", "isValidBatteryPercentage", "", "batteryPercentage", "monitorBatteryStatus", "Lio/reactivex/rxjava3/core/Flowable;", "checkConnection", "monitorChargingStatus", "parseBatteryStatus", "data", "", "processServiceData", "", "characteristic", "Ljava/util/UUID;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "notifying", "processServiceDataWritten", "reset", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BleBattClient extends BleGattBase {
    private static final UUID BATTERY_LEVEL_CHARACTERISTIC;
    private static final UUID BATTERY_LEVEL_STATUS_CHARACTERISTIC;
    public static final UUID BATTERY_SERVICE;
    private final AtomicSet<FlowableEmitter<? super ChargeState>> batteryChargeStateObservers;
    private final AtomicSet<FlowableEmitter<? super Integer>> batteryStatusObservers;
    private final AtomicInteger cachedBatteryPercentage;
    private ChargeState cachedChargeState;

    static {
        UUID uuidFromString = UUID.fromString("0000180f-0000-1000-8000-00805f9b34fb");
        uuidFromString.getClass();
        BATTERY_SERVICE = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00002a19-0000-1000-8000-00805f9b34fb");
        uuidFromString2.getClass();
        BATTERY_LEVEL_CHARACTERISTIC = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("00002bed-0000-1000-8000-00805f9b34fb");
        uuidFromString3.getClass();
        BATTERY_LEVEL_STATUS_CHARACTERISTIC = uuidFromString3;
    }

    public BleBattClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, BATTERY_SERVICE);
        this.batteryStatusObservers = new AtomicSet<>();
        this.cachedBatteryPercentage = new AtomicInteger(-1);
        this.batteryChargeStateObservers = new AtomicSet<>();
        this.cachedChargeState = ChargeState.UNKNOWN;
        UUID uuid = BATTERY_LEVEL_CHARACTERISTIC;
        addCharacteristicNotification(uuid);
        addCharacteristicRead(uuid);
        UUID uuid2 = BATTERY_LEVEL_STATUS_CHARACTERISTIC;
        addCharacteristicNotification(uuid2);
        addCharacteristicRead(uuid2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidBatteryPercentage(int batteryPercentage) {
        return batteryPercentage >= 0 && batteryPercentage < 101;
    }

    private final ChargeState parseBatteryStatus(byte[] data2) {
        int i = data2[1] & 243;
        return i != 163 ? i != 193 ? i != 195 ? ChargeState.UNKNOWN : ChargeState.DISCHARGING_INACTIVE : ChargeState.DISCHARGING_ACTIVE : ChargeState.CHARGING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processServiceData$lambda$0(BleBattClient bleBattClient, FlowableEmitter flowableEmitter) {
        bleBattClient.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(Integer.valueOf(bleBattClient.cachedBatteryPercentage.get()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processServiceData$lambda$1(BleBattClient bleBattClient, FlowableEmitter flowableEmitter) {
        bleBattClient.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(bleBattClient.cachedChargeState);
    }

    public final Flowable<Integer> monitorBatteryStatus(boolean checkConnection) {
        Flowable<Integer> flowableFilter = RxUtils.monitorNotifications(this.batteryStatusObservers, this.txInterface, checkConnection).startWith(Flowable.just(Integer.valueOf(this.cachedBatteryPercentage.get()))).filter(new Predicate() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.BleBattClient.monitorBatteryStatus.1
            @Override // io.reactivex.rxjava3.functions.Predicate
            public /* bridge */ /* synthetic */ boolean test(Object obj) {
                return test(((Number) obj).intValue());
            }

            public final boolean test(int i) {
                return BleBattClient.this.isValidBatteryPercentage(i);
            }
        });
        flowableFilter.getClass();
        return flowableFilter;
    }

    public final Flowable<ChargeState> monitorChargingStatus(boolean checkConnection) {
        Flowable<ChargeState> flowableStartWith = RxUtils.monitorNotifications(this.batteryChargeStateObservers, this.txInterface, checkConnection).startWith(Flowable.just(this.cachedChargeState));
        flowableStartWith.getClass();
        return flowableStartWith;
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID characteristic, byte[] data2, int status, boolean notifying) {
        characteristic.getClass();
        data2.getClass();
        if (status == 0) {
            if (Intrinsics.areEqual(characteristic, BATTERY_LEVEL_CHARACTERISTIC)) {
                final int i = 0;
                this.cachedBatteryPercentage.set(data2[0]);
                RxUtils.emitNext(this.batteryStatusObservers, new RxUtils.Emitter(this) { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.BleBattClient$$ExternalSyntheticLambda0
                    public final /* synthetic */ BleBattClient f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i2 = i;
                        BleBattClient bleBattClient = this.f$0;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i2) {
                            case 0:
                                BleBattClient.processServiceData$lambda$0(bleBattClient, flowableEmitter);
                                break;
                            default:
                                BleBattClient.processServiceData$lambda$1(bleBattClient, flowableEmitter);
                                break;
                        }
                    }
                });
            } else if (Intrinsics.areEqual(characteristic, BATTERY_LEVEL_STATUS_CHARACTERISTIC)) {
                this.cachedChargeState = parseBatteryStatus(data2);
                final int i2 = 1;
                RxUtils.emitNext(this.batteryChargeStateObservers, new RxUtils.Emitter(this) { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.BleBattClient$$ExternalSyntheticLambda0
                    public final /* synthetic */ BleBattClient f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                    public final void item(Object obj) {
                        int i22 = i2;
                        BleBattClient bleBattClient = this.f$0;
                        FlowableEmitter flowableEmitter = (FlowableEmitter) obj;
                        switch (i22) {
                            case 0:
                                BleBattClient.processServiceData$lambda$0(bleBattClient, flowableEmitter);
                                break;
                            default:
                                BleBattClient.processServiceData$lambda$1(bleBattClient, flowableEmitter);
                                break;
                        }
                    }
                });
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID characteristic, int status) {
        characteristic.getClass();
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        this.cachedBatteryPercentage.set(-1);
        RxUtils.postDisconnectedAndClearList(this.batteryStatusObservers);
        this.cachedChargeState = ChargeState.UNKNOWN;
        RxUtils.postDisconnectedAndClearList(this.batteryChargeStateObservers);
    }
}
