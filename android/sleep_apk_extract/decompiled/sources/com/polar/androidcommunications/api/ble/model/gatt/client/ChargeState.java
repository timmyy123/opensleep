package com.polar.androidcommunications.api.ble.model.gatt.client;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/ChargeState;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "CHARGING", "DISCHARGING_ACTIVE", "DISCHARGING_INACTIVE", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChargeState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChargeState[] $VALUES;
    public static final ChargeState UNKNOWN = new ChargeState("UNKNOWN", 0);
    public static final ChargeState CHARGING = new ChargeState("CHARGING", 1);
    public static final ChargeState DISCHARGING_ACTIVE = new ChargeState("DISCHARGING_ACTIVE", 2);
    public static final ChargeState DISCHARGING_INACTIVE = new ChargeState("DISCHARGING_INACTIVE", 3);

    private static final /* synthetic */ ChargeState[] $values() {
        return new ChargeState[]{UNKNOWN, CHARGING, DISCHARGING_ACTIVE, DISCHARGING_INACTIVE};
    }

    static {
        ChargeState[] chargeStateArr$values = $values();
        $VALUES = chargeStateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(chargeStateArr$values);
    }

    private ChargeState(String str, int i) {
    }

    public static ChargeState valueOf(String str) {
        return (ChargeState) Enum.valueOf(ChargeState.class, str);
    }

    public static ChargeState[] values() {
        return (ChargeState[]) $VALUES.clone();
    }
}
