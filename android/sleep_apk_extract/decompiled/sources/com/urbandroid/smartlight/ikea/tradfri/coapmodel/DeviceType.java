package com.urbandroid.smartlight.ikea.tradfri.coapmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/smartlight/ikea/tradfri/coapmodel/DeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "Light", "Plug", "Blinder", "Motion_Sensor", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceType[] $VALUES;
    public static final DeviceType Light = new DeviceType("Light", 0);
    public static final DeviceType Plug = new DeviceType("Plug", 1);
    public static final DeviceType Blinder = new DeviceType("Blinder", 2);
    public static final DeviceType Motion_Sensor = new DeviceType("Motion_Sensor", 3);

    private static final /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{Light, Plug, Blinder, Motion_Sensor};
    }

    static {
        DeviceType[] deviceTypeArr$values = $values();
        $VALUES = deviceTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deviceTypeArr$values);
    }

    private DeviceType(String str, int i) {
    }

    public static EnumEntries<DeviceType> getEntries() {
        return $ENTRIES;
    }

    public static DeviceType valueOf(String str) {
        return (DeviceType) Enum.valueOf(DeviceType.class, str);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }
}
