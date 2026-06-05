package com.polar.androidcommunications.api.ble.model.gatt.client;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.functions.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u001a0\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/BleHrClient;", "Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattBase;", "Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattTxInterface;", "txInterface", "<init>", "(Lcom/polar/androidcommunications/api/ble/model/gatt/BleGattTxInterface;)V", "", "reset", "()V", "Ljava/util/UUID;", "characteristic", "", "data", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "notifying", "processServiceData", "(Ljava/util/UUID;[BIZ)V", "processServiceDataWritten", "(Ljava/util/UUID;I)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "checkConnection", "Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/BleHrClient$HrNotificationData;", "observeHrNotifications", "(Z)Lio/reactivex/rxjava3/core/Flowable;", "Lcom/polar/androidcommunications/common/ble/AtomicSet;", "Lio/reactivex/rxjava3/core/FlowableEmitter;", "hrObserverAtomicList", "Lcom/polar/androidcommunications/common/ble/AtomicSet;", "Companion", "HrNotificationData", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BleHrClient extends BleGattBase {
    private static final UUID BODY_SENSOR_LOCATION;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UUID HR_MEASUREMENT;
    private static final UUID HR_SERVICE;
    private final AtomicSet<FlowableEmitter<? super HrNotificationData>> hrObserverAtomicList;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/BleHrClient$Companion;", "", "<init>", "()V", "", "rrsRaw", "mapRr1024ToRrMs", "(I)I", "Ljava/util/UUID;", "HR_SERVICE", "Ljava/util/UUID;", "getHR_SERVICE", "()Ljava/util/UUID;", "", "HR_SERVICE_16BIT_UUID", "Ljava/lang/String;", "TAG", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int mapRr1024ToRrMs(int rrsRaw) {
            return MathKt.roundToInt((((double) rrsRaw) / 1024.0d) * 1000.0d);
        }

        public final UUID getHR_SERVICE() {
            return BleHrClient.HR_SERVICE;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001b\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b \u0010\u001aR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/BleHrClient$HrNotificationData;", "", "", "hrValue", "", "sensorContact", "energy", "", "rrs", "rrsMs", "sensorContactSupported", "rrPresent", "<init>", "(IZILjava/util/List;Ljava/util/List;ZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getHrValue", "Z", "getSensorContact", "()Z", "getEnergy", "Ljava/util/List;", "getRrs", "()Ljava/util/List;", "getRrsMs", "getSensorContactSupported", "getRrPresent", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class HrNotificationData {
        private final int energy;
        private final int hrValue;
        private final boolean rrPresent;
        private final List<Integer> rrs;
        private final List<Integer> rrsMs;
        private final boolean sensorContact;
        private final boolean sensorContactSupported;

        public HrNotificationData(int i, boolean z, int i2, List<Integer> list, List<Integer> list2, boolean z2, boolean z3) {
            list.getClass();
            list2.getClass();
            this.hrValue = i;
            this.sensorContact = z;
            this.energy = i2;
            this.rrs = list;
            this.rrsMs = list2;
            this.sensorContactSupported = z2;
            this.rrPresent = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HrNotificationData)) {
                return false;
            }
            HrNotificationData hrNotificationData = (HrNotificationData) other;
            return this.hrValue == hrNotificationData.hrValue && this.sensorContact == hrNotificationData.sensorContact && this.energy == hrNotificationData.energy && Intrinsics.areEqual(this.rrs, hrNotificationData.rrs) && Intrinsics.areEqual(this.rrsMs, hrNotificationData.rrsMs) && this.sensorContactSupported == hrNotificationData.sensorContactSupported && this.rrPresent == hrNotificationData.rrPresent;
        }

        public final int getHrValue() {
            return this.hrValue;
        }

        public final boolean getRrPresent() {
            return this.rrPresent;
        }

        public final List<Integer> getRrsMs() {
            return this.rrsMs;
        }

        public final boolean getSensorContact() {
            return this.sensorContact;
        }

        public final boolean getSensorContactSupported() {
            return this.sensorContactSupported;
        }

        public int hashCode() {
            return Boolean.hashCode(this.rrPresent) + FileInsert$$ExternalSyntheticOutline0.m(this.sensorContactSupported, FileInsert$$ExternalSyntheticOutline0.m((List) this.rrsMs, FileInsert$$ExternalSyntheticOutline0.m((List) this.rrs, FileInsert$$ExternalSyntheticOutline0.m(this.energy, FileInsert$$ExternalSyntheticOutline0.m(this.sensorContact, Integer.hashCode(this.hrValue) * 31, 31), 31), 31), 31), 31);
        }

        public String toString() {
            return "HrNotificationData(hrValue=" + this.hrValue + ", sensorContact=" + this.sensorContact + ", energy=" + this.energy + ", rrs=" + this.rrs + ", rrsMs=" + this.rrsMs + ", sensorContactSupported=" + this.sensorContactSupported + ", rrPresent=" + this.rrPresent + ")";
        }
    }

    static {
        UUID uuidFromString = UUID.fromString("00002a38-0000-1000-8000-00805f9b34fb");
        uuidFromString.getClass();
        BODY_SENSOR_LOCATION = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb");
        uuidFromString2.getClass();
        HR_MEASUREMENT = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("0000180D-0000-1000-8000-00805f9b34fb");
        uuidFromString3.getClass();
        HR_SERVICE = uuidFromString3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BleHrClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, HR_SERVICE);
        bleGattTxInterface.getClass();
        this.hrObserverAtomicList = new AtomicSet<>();
        addCharacteristicRead(BODY_SENSOR_LOCATION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeHrNotifications$lambda$1(BleHrClient bleHrClient) {
        bleHrClient.getClass();
        BleLogger.INSTANCE.d("BleHrClient", "Start observing HR");
        UUID uuid = HR_MEASUREMENT;
        bleHrClient.addCharacteristicNotification(uuid);
        bleHrClient.getTxInterface().setCharacteristicNotify(HR_SERVICE, uuid, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeHrNotifications$lambda$2(BleHrClient bleHrClient) {
        bleHrClient.getClass();
        BleLogger.INSTANCE.d("BleHrClient", "Stop observing HR");
        UUID uuid = HR_MEASUREMENT;
        bleHrClient.removeCharacteristicNotification(uuid);
        try {
            bleHrClient.getTxInterface().setCharacteristicNotify(HR_SERVICE, uuid, false);
        } catch (Exception e) {
            BleLogger.INSTANCE.d("BleHrClient", "HR client is not able to set characteristic notify to false. Reason " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processServiceData$lambda$0(int i, boolean z, int i2, List list, List list2, boolean z2, int i3, FlowableEmitter flowableEmitter) {
        list.getClass();
        list2.getClass();
        flowableEmitter.getClass();
        flowableEmitter.onNext(new HrNotificationData(i, z, i2, list, list2, z2, i3 == 1));
    }

    public final Flowable<HrNotificationData> observeHrNotifications(boolean checkConnection) {
        final int i = 0;
        Flowable flowableStartWith = RxUtils.monitorNotifications(this.hrObserverAtomicList, this.txInterface, checkConnection).startWith(Completable.fromAction(new Action(this) { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.BleHrClient$$ExternalSyntheticLambda1
            public final /* synthetic */ BleHrClient f$0;

            {
                this.f$0 = this;
            }

            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                int i2 = i;
                BleHrClient bleHrClient = this.f$0;
                switch (i2) {
                    case 0:
                        BleHrClient.observeHrNotifications$lambda$1(bleHrClient);
                        break;
                    default:
                        BleHrClient.observeHrNotifications$lambda$2(bleHrClient);
                        break;
                }
            }
        }));
        final int i2 = 1;
        Flowable<HrNotificationData> flowableDoFinally = flowableStartWith.doFinally(new Action(this) { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.BleHrClient$$ExternalSyntheticLambda1
            public final /* synthetic */ BleHrClient f$0;

            {
                this.f$0 = this;
            }

            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                int i22 = i2;
                BleHrClient bleHrClient = this.f$0;
                switch (i22) {
                    case 0:
                        BleHrClient.observeHrNotifications$lambda$1(bleHrClient);
                        break;
                    default:
                        BleHrClient.observeHrNotifications$lambda$2(bleHrClient);
                        break;
                }
            }
        });
        flowableDoFinally.getClass();
        return flowableDoFinally;
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID characteristic, byte[] data2, int status, boolean notifying) {
        characteristic.getClass();
        data2.getClass();
        BleLogger.INSTANCE.d("BleHrClient", Fragment$$ExternalSyntheticOutline1.m(status, data2.length, "Processing service data. Status: ", ".  Data length: "));
        if (status == 0 && Intrinsics.areEqual(characteristic, HR_MEASUREMENT)) {
            int i = 0;
            byte b = data2[0];
            int i2 = b & 1;
            final boolean z = ((b & 6) >> 1) == 3;
            final boolean z2 = (b & 4) != 0;
            int i3 = (b & 8) >> 3;
            final int i4 = (b & 16) >> 4;
            final int iIntValue = (i2 == 1 ? Integer.valueOf((data2[1] & 255) + (data2[2] << 8)) : Byte.valueOf(data2[1])).intValue() & (i2 == 1 ? 65535 : 255);
            int i5 = i2 + 2;
            if (i3 == 1) {
                i = (data2[i5] & 255) + ((data2[i2 + 3] & 255) << 8);
                i5 = i2 + 4;
            }
            final int i6 = i;
            final ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            if (i4 == 1) {
                int length = data2.length;
                while (i5 < length) {
                    int i7 = (data2[i5] & 255) + ((data2[i5 + 1] & 255) << 8);
                    i5 += 2;
                    arrayList.add(Integer.valueOf(i7));
                    arrayList2.add(Integer.valueOf(INSTANCE.mapRr1024ToRrMs(i7)));
                }
            }
            RxUtils.emitNext(this.hrObserverAtomicList, new RxUtils.Emitter() { // from class: com.polar.androidcommunications.api.ble.model.gatt.client.BleHrClient$$ExternalSyntheticLambda0
                @Override // com.polar.androidcommunications.common.ble.RxUtils.Emitter
                public final void item(Object obj) {
                    BleHrClient.processServiceData$lambda$0(iIntValue, z, i6, arrayList, arrayList2, z2, i4, (FlowableEmitter) obj);
                }
            });
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID characteristic, int status) {
        characteristic.getClass();
        BleLogger.INSTANCE.d("BleHrClient", "Service data written not processed in BleHrClient");
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        RxUtils.postDisconnectedAndClearList(this.hrObserverAtomicList);
    }

    public String toString() {
        return "HR gatt client";
    }
}
