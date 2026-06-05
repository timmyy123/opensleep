package com.urbandroid.sleep.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/domain/SensorType;", "", "<init>", "(Ljava/lang/String;I)V", "PHONE_ACCEL", "SMARTWATCH", "SLEEPPHASER", "SONAR", "BLE_ACCEL", "isSmartWatch", "", "isPhaser", "isSonar", "isPhoneAccel", "isBleAccel", "isAccelerometer", "isWearableAccelerometer", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SensorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SensorType[] $VALUES;
    public static final SensorType PHONE_ACCEL = new SensorType("PHONE_ACCEL", 0);
    public static final SensorType SMARTWATCH = new SensorType("SMARTWATCH", 1);
    public static final SensorType SLEEPPHASER = new SensorType("SLEEPPHASER", 2);
    public static final SensorType SONAR = new SensorType("SONAR", 3);
    public static final SensorType BLE_ACCEL = new SensorType("BLE_ACCEL", 4);

    private static final /* synthetic */ SensorType[] $values() {
        return new SensorType[]{PHONE_ACCEL, SMARTWATCH, SLEEPPHASER, SONAR, BLE_ACCEL};
    }

    static {
        SensorType[] sensorTypeArr$values = $values();
        $VALUES = sensorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sensorTypeArr$values);
    }

    private SensorType(String str, int i) {
    }

    public static SensorType valueOf(String str) {
        return (SensorType) Enum.valueOf(SensorType.class, str);
    }

    public static SensorType[] values() {
        return (SensorType[]) $VALUES.clone();
    }

    public final boolean isAccelerometer() {
        return isPhoneAccel() || isSmartWatch() || isBleAccel();
    }

    public final boolean isBleAccel() {
        return this == BLE_ACCEL;
    }

    public final boolean isPhaser() {
        return this == SLEEPPHASER;
    }

    public final boolean isPhoneAccel() {
        return this == PHONE_ACCEL;
    }

    public final boolean isSmartWatch() {
        return this == SMARTWATCH;
    }

    public final boolean isSonar() {
        return this == SONAR;
    }

    public final boolean isWearableAccelerometer() {
        return isSmartWatch() || isBleAccel();
    }
}
