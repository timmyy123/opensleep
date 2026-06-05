package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;", "", "Lkotlin/UByte;", "numVal", "<init>", "(Ljava/lang/String;IB)V", "B", "getNumVal-w2LRezQ", "()B", "Companion", "ECG", "PPG", "ACC", "PPI", "GYRO", "MAGNETOMETER", "SKIN_TEMP", "SDK_MODE", "LOCATION", "PRESSURE", "TEMPERATURE", "OFFLINE_RECORDING", "OFFLINE_HR", "UNKNOWN_TYPE", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdMeasurementType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PmdMeasurementType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final byte numVal;
    public static final PmdMeasurementType ECG = new PmdMeasurementType("ECG", 0, (byte) 0);
    public static final PmdMeasurementType PPG = new PmdMeasurementType("PPG", 1, (byte) 1);
    public static final PmdMeasurementType ACC = new PmdMeasurementType("ACC", 2, (byte) 2);
    public static final PmdMeasurementType PPI = new PmdMeasurementType("PPI", 3, (byte) 3);
    public static final PmdMeasurementType GYRO = new PmdMeasurementType("GYRO", 4, (byte) 5);
    public static final PmdMeasurementType MAGNETOMETER = new PmdMeasurementType("MAGNETOMETER", 5, (byte) 6);
    public static final PmdMeasurementType SKIN_TEMP = new PmdMeasurementType("SKIN_TEMP", 6, (byte) 7);
    public static final PmdMeasurementType SDK_MODE = new PmdMeasurementType("SDK_MODE", 7, (byte) 9);
    public static final PmdMeasurementType LOCATION = new PmdMeasurementType("LOCATION", 8, (byte) 10);
    public static final PmdMeasurementType PRESSURE = new PmdMeasurementType("PRESSURE", 9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK);
    public static final PmdMeasurementType TEMPERATURE = new PmdMeasurementType("TEMPERATURE", 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ);
    public static final PmdMeasurementType OFFLINE_RECORDING = new PmdMeasurementType("OFFLINE_RECORDING", 11, MqttWireMessage.MESSAGE_TYPE_PINGRESP);
    public static final PmdMeasurementType OFFLINE_HR = new PmdMeasurementType("OFFLINE_HR", 12, MqttWireMessage.MESSAGE_TYPE_DISCONNECT);
    public static final PmdMeasurementType UNKNOWN_TYPE = new PmdMeasurementType("UNKNOWN_TYPE", 13, (byte) 63);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0003\u001a\u00020\u0004X\u0082Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType$Companion;", "", "()V", "MEASUREMENT_TYPE_BIT_MASK", "Lkotlin/UByte;", "B", "fromByteArray", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;", "data", "", "fromId", "id", "", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<PmdMeasurementType> fromByteArray(byte[] data2) {
            data2.getClass();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[1]) & 1) != 0) {
                linkedHashSet.add(PmdMeasurementType.ECG);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[1]) & 2) != 0) {
                linkedHashSet.add(PmdMeasurementType.PPG);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[1]) & 4) != 0) {
                linkedHashSet.add(PmdMeasurementType.ACC);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[1]) & 8) != 0) {
                linkedHashSet.add(PmdMeasurementType.PPI);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[1]) & 32) != 0) {
                linkedHashSet.add(PmdMeasurementType.GYRO);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[1]) & 64) != 0) {
                linkedHashSet.add(PmdMeasurementType.MAGNETOMETER);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[1]) & 128) != 0) {
                linkedHashSet.add(PmdMeasurementType.SKIN_TEMP);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[2]) & 2) != 0) {
                linkedHashSet.add(PmdMeasurementType.SDK_MODE);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[2]) & 4) != 0) {
                linkedHashSet.add(PmdMeasurementType.LOCATION);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[2]) & 8) != 0) {
                linkedHashSet.add(PmdMeasurementType.PRESSURE);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[2]) & 16) != 0) {
                linkedHashSet.add(PmdMeasurementType.TEMPERATURE);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[2]) & 32) != 0) {
                linkedHashSet.add(PmdMeasurementType.OFFLINE_RECORDING);
            }
            if (UInt.m2389constructorimpl(UInt.m2389constructorimpl(data2[2]) & 64) != 0) {
                linkedHashSet.add(PmdMeasurementType.OFFLINE_HR);
            }
            return linkedHashSet;
        }

        public final PmdMeasurementType fromId(byte id) {
            for (PmdMeasurementType pmdMeasurementType : PmdMeasurementType.values()) {
                if (pmdMeasurementType.getNumVal() == UByte.m2367constructorimpl((byte) (UByte.m2367constructorimpl(id) & 63))) {
                    return pmdMeasurementType;
                }
            }
            return PmdMeasurementType.UNKNOWN_TYPE;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PmdMeasurementType[] $values() {
        return new PmdMeasurementType[]{ECG, PPG, ACC, PPI, GYRO, MAGNETOMETER, SKIN_TEMP, SDK_MODE, LOCATION, PRESSURE, TEMPERATURE, OFFLINE_RECORDING, OFFLINE_HR, UNKNOWN_TYPE};
    }

    static {
        PmdMeasurementType[] pmdMeasurementTypeArr$values = $values();
        $VALUES = pmdMeasurementTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pmdMeasurementTypeArr$values);
        INSTANCE = new Companion(null);
    }

    private PmdMeasurementType(String str, int i, byte b) {
        this.numVal = b;
    }

    public static PmdMeasurementType valueOf(String str) {
        return (PmdMeasurementType) Enum.valueOf(PmdMeasurementType.class, str);
    }

    public static PmdMeasurementType[] values() {
        return (PmdMeasurementType[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getNumVal-w2LRezQ, reason: not valid java name and from getter */
    public final byte getNumVal() {
        return this.numVal;
    }
}
