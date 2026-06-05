package com.polar.androidcommunications.api.ble.model.gatt.client;

import android.util.Pair;
import androidx.work.ListenableFutureKt$$ExternalSyntheticLambda0;
import androidx.work.WorkerKt$$ExternalSyntheticLambda0;
import com.polar.androidcommunications.api.ble.exceptions.BleAttributeError;
import com.polar.androidcommunications.api.ble.exceptions.BleDisconnected;
import com.polar.androidcommunications.api.ble.model.DisInfo;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.v2.GroupImpl$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.v2.SwitchFactory$$ExternalSyntheticLambda5;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes4.dex */
public class BleDisClient extends BleGattBase {
    private final AtomicSet<FlowableEmitter<DisInfo>> disInfoObservers;
    private final HashMap<UUID, String> disInformation;
    private final Set<DisInfo> disInformationDataSet;
    private final AtomicSet<FlowableEmitter<? super Pair<UUID, String>>> disObserverAtomicList;
    public static final UUID DIS_SERVICE = UUID.fromString("0000180a-0000-1000-8000-00805f9b34fb");
    public static final UUID MODEL_NUMBER_STRING = UUID.fromString("00002a24-0000-1000-8000-00805f9b34fb");
    public static final UUID MANUFACTURER_NAME_STRING = UUID.fromString("00002a29-0000-1000-8000-00805f9b34fb");
    public static final UUID HARDWARE_REVISION_STRING = UUID.fromString("00002a27-0000-1000-8000-00805f9b34fb");
    public static final UUID FIRMWARE_REVISION_STRING = UUID.fromString("00002a26-0000-1000-8000-00805f9b34fb");
    public static final UUID SOFTWARE_REVISION_STRING = UUID.fromString("00002a28-0000-1000-8000-00805f9b34fb");
    public static final UUID SERIAL_NUMBER_STRING = UUID.fromString("00002a25-0000-1000-8000-00805f9b34fb");
    public static final UUID SYSTEM_ID = UUID.fromString("00002a23-0000-1000-8000-00805f9b34fb");
    public static final UUID IEEE_11073_20601 = UUID.fromString("00002a2a-0000-1000-8000-00805f9b34fb");
    public static final UUID PNP_ID = UUID.fromString("00002a50-0000-1000-8000-00805f9b34fb");

    public BleDisClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, DIS_SERVICE);
        this.disInformation = new HashMap<>();
        this.disObserverAtomicList = new AtomicSet<>();
        this.disInformationDataSet = new HashSet();
        this.disInfoObservers = new AtomicSet<>();
        addCharacteristicRead(MODEL_NUMBER_STRING);
        addCharacteristicRead(MANUFACTURER_NAME_STRING);
        addCharacteristicRead(HARDWARE_REVISION_STRING);
        addCharacteristicRead(FIRMWARE_REVISION_STRING);
        addCharacteristicRead(SOFTWARE_REVISION_STRING);
        addCharacteristicRead(SERIAL_NUMBER_STRING);
        addCharacteristicRead(SYSTEM_ID);
        addCharacteristicRead(IEEE_11073_20601);
        addCharacteristicRead(PNP_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidUUIDString(String str) {
        try {
            UUID.fromString(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observeDisInfo$3(boolean z, FlowableEmitter[] flowableEmitterArr, FlowableEmitter flowableEmitter) {
        if (z && !this.txInterface.isConnected()) {
            if (flowableEmitter.isCancelled()) {
                return;
            }
            flowableEmitter.tryOnError(new BleDisconnected());
            return;
        }
        flowableEmitterArr[0] = flowableEmitter;
        this.disObserverAtomicList.add(flowableEmitter);
        synchronized (this.disInformation) {
            try {
                for (UUID uuid : this.disInformation.keySet()) {
                    flowableEmitter.onNext(new Pair(uuid, this.disInformation.get(uuid)));
                }
                if (hasAllAvailableReadableCharacteristics(this.disInformation.keySet())) {
                    flowableEmitter.onComplete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observeDisInfo$4(FlowableEmitter[] flowableEmitterArr) {
        this.disObserverAtomicList.remove((FlowableEmitter<? super Pair<UUID, String>>) flowableEmitterArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$observeDisInfoWithKeysAsStrings$5(DisInfo disInfo) {
        return isValidUUIDString(disInfo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UUID lambda$observeDisInfoWithKeysAsStrings$6(DisInfo disInfo) {
        return UUID.fromString(disInfo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observeDisInfoWithKeysAsStrings$7(boolean z, FlowableEmitter[] flowableEmitterArr, FlowableEmitter flowableEmitter) {
        if (z && !this.txInterface.isConnected()) {
            if (flowableEmitter.isCancelled()) {
                return;
            }
            flowableEmitter.tryOnError(new BleDisconnected());
            return;
        }
        flowableEmitterArr[0] = flowableEmitter;
        this.disInfoObservers.add(flowableEmitter);
        synchronized (this.disInformationDataSet) {
            try {
                Iterator<DisInfo> it = this.disInformationDataSet.iterator();
                while (it.hasNext()) {
                    flowableEmitter.onNext(it.next());
                }
                if (hasAllAvailableReadableCharacteristics((Set) this.disInformationDataSet.stream().filter(new BleDisClient$$ExternalSyntheticLambda5(this, 1)).map(new Color$$ExternalSyntheticLambda0(2)).collect(Collectors.toSet()))) {
                    flowableEmitter.onComplete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$observeDisInfoWithKeysAsStrings$8(FlowableEmitter[] flowableEmitterArr) {
        this.disInfoObservers.remove((FlowableEmitter<DisInfo>) flowableEmitterArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processServiceData$0(UUID uuid, byte[] bArr, FlowableEmitter flowableEmitter) {
        flowableEmitter.onNext(new Pair(uuid, new String(bArr, StandardCharsets.UTF_8)));
        synchronized (this.disInformation) {
            try {
                if (hasAllAvailableReadableCharacteristics(this.disInformation.keySet())) {
                    flowableEmitter.onComplete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$processServiceData$1(UUID uuid, DisInfo disInfo) {
        return (uuid.equals(SYSTEM_ID) && disInfo.getKey().equals("SYSTEM_ID_HEX")) || uuid.toString().equals(disInfo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processServiceData$2(UUID uuid, FlowableEmitter flowableEmitter) {
        int i = 1;
        Optional<DisInfo> optionalFindFirst = this.disInformationDataSet.stream().filter(new GroupImpl$$ExternalSyntheticLambda0(uuid, i)).findFirst();
        Objects.requireNonNull(flowableEmitter);
        optionalFindFirst.ifPresent(new SwitchFactory$$ExternalSyntheticLambda5(flowableEmitter, i));
        synchronized (this.disInformationDataSet) {
            try {
                if (hasAllAvailableReadableCharacteristics((Set) this.disInformationDataSet.stream().map(new Color$$ExternalSyntheticLambda0(3)).filter(new BleDisClient$$ExternalSyntheticLambda5(this, 0)).map(new Color$$ExternalSyntheticLambda0(4)).collect(Collectors.toSet()))) {
                    flowableEmitter.onComplete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private String systemIdBytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int length = bArr.length - 1; length >= 0; length--) {
            sb.append(String.format("%02X", Byte.valueOf(bArr[length])));
        }
        return sb.toString();
    }

    public Flowable<Pair<UUID, String>> observeDisInfo(boolean z) {
        FlowableEmitter[] flowableEmitterArr = new FlowableEmitter[1];
        int i = 1;
        return Flowable.create(new BleDisClient$$ExternalSyntheticLambda7(this, z, flowableEmitterArr, i), BackpressureStrategy.BUFFER).doFinally(new BleDisClient$$ExternalSyntheticLambda8(this, flowableEmitterArr, i));
    }

    public Flowable<DisInfo> observeDisInfoWithKeysAsStrings(boolean z) {
        FlowableEmitter[] flowableEmitterArr = new FlowableEmitter[1];
        int i = 0;
        return Flowable.create(new BleDisClient$$ExternalSyntheticLambda7(this, z, flowableEmitterArr, i), BackpressureStrategy.BUFFER).doFinally(new BleDisClient$$ExternalSyntheticLambda8(this, flowableEmitterArr, i));
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID uuid, byte[] bArr, int i, boolean z) {
        if (i != 0) {
            RxUtils.postError(this.disObserverAtomicList, new BleAttributeError("dis ", i));
            return;
        }
        String str = new String(bArr, StandardCharsets.UTF_8);
        synchronized (this.disInformation) {
            this.disInformation.put(uuid, str);
        }
        synchronized (this.disInformationDataSet) {
            try {
                if (uuid.equals(SYSTEM_ID)) {
                    this.disInformationDataSet.add(new DisInfo("SYSTEM_ID_HEX", systemIdBytesToHex(bArr)));
                } else {
                    this.disInformationDataSet.add(new DisInfo(uuid.toString(), str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        RxUtils.emitNext(this.disObserverAtomicList, new ListenableFutureKt$$ExternalSyntheticLambda0(this, uuid, bArr, 4));
        RxUtils.emitNext(this.disInfoObservers, new WorkerKt$$ExternalSyntheticLambda0(this, uuid, 15));
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID uuid, int i) {
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        synchronized (this.disInformation) {
            this.disInformation.clear();
            this.disInformationDataSet.clear();
        }
        RxUtils.postDisconnectedAndClearList(this.disObserverAtomicList);
        RxUtils.postDisconnectedAndClearList(this.disInfoObservers);
    }

    public String toString() {
        return "Device info service";
    }
}
