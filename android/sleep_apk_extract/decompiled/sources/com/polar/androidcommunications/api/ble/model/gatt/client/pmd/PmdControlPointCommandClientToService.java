package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdControlPointCommandClientToService;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "NULL_ITEM", "GET_MEASUREMENT_SETTINGS", "REQUEST_MEASUREMENT_START", "STOP_MEASUREMENT", "GET_SDK_MODE_MEASUREMENT_SETTINGS", "GET_MEASUREMENT_STATUS", "GET_SDK_MODE_STATUS", "GET_OFFLINE_RECORDING_TRIGGER_STATUS", "SET_OFFLINE_RECORDING_TRIGGER_MODE", "SET_OFFLINE_RECORDING_TRIGGER_SETTINGS", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdControlPointCommandClientToService {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PmdControlPointCommandClientToService[] $VALUES;
    private final int code;
    public static final PmdControlPointCommandClientToService NULL_ITEM = new PmdControlPointCommandClientToService("NULL_ITEM", 0, 0);
    public static final PmdControlPointCommandClientToService GET_MEASUREMENT_SETTINGS = new PmdControlPointCommandClientToService("GET_MEASUREMENT_SETTINGS", 1, 1);
    public static final PmdControlPointCommandClientToService REQUEST_MEASUREMENT_START = new PmdControlPointCommandClientToService("REQUEST_MEASUREMENT_START", 2, 2);
    public static final PmdControlPointCommandClientToService STOP_MEASUREMENT = new PmdControlPointCommandClientToService("STOP_MEASUREMENT", 3, 3);
    public static final PmdControlPointCommandClientToService GET_SDK_MODE_MEASUREMENT_SETTINGS = new PmdControlPointCommandClientToService("GET_SDK_MODE_MEASUREMENT_SETTINGS", 4, 4);
    public static final PmdControlPointCommandClientToService GET_MEASUREMENT_STATUS = new PmdControlPointCommandClientToService("GET_MEASUREMENT_STATUS", 5, 5);
    public static final PmdControlPointCommandClientToService GET_SDK_MODE_STATUS = new PmdControlPointCommandClientToService("GET_SDK_MODE_STATUS", 6, 6);
    public static final PmdControlPointCommandClientToService GET_OFFLINE_RECORDING_TRIGGER_STATUS = new PmdControlPointCommandClientToService("GET_OFFLINE_RECORDING_TRIGGER_STATUS", 7, 7);
    public static final PmdControlPointCommandClientToService SET_OFFLINE_RECORDING_TRIGGER_MODE = new PmdControlPointCommandClientToService("SET_OFFLINE_RECORDING_TRIGGER_MODE", 8, 8);
    public static final PmdControlPointCommandClientToService SET_OFFLINE_RECORDING_TRIGGER_SETTINGS = new PmdControlPointCommandClientToService("SET_OFFLINE_RECORDING_TRIGGER_SETTINGS", 9, 9);

    private static final /* synthetic */ PmdControlPointCommandClientToService[] $values() {
        return new PmdControlPointCommandClientToService[]{NULL_ITEM, GET_MEASUREMENT_SETTINGS, REQUEST_MEASUREMENT_START, STOP_MEASUREMENT, GET_SDK_MODE_MEASUREMENT_SETTINGS, GET_MEASUREMENT_STATUS, GET_SDK_MODE_STATUS, GET_OFFLINE_RECORDING_TRIGGER_STATUS, SET_OFFLINE_RECORDING_TRIGGER_MODE, SET_OFFLINE_RECORDING_TRIGGER_SETTINGS};
    }

    static {
        PmdControlPointCommandClientToService[] pmdControlPointCommandClientToServiceArr$values = $values();
        $VALUES = pmdControlPointCommandClientToServiceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pmdControlPointCommandClientToServiceArr$values);
    }

    private PmdControlPointCommandClientToService(String str, int i, int i2) {
        this.code = i2;
    }

    public static PmdControlPointCommandClientToService valueOf(String str) {
        return (PmdControlPointCommandClientToService) Enum.valueOf(PmdControlPointCommandClientToService.class, str);
    }

    public static PmdControlPointCommandClientToService[] values() {
        return (PmdControlPointCommandClientToService[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
