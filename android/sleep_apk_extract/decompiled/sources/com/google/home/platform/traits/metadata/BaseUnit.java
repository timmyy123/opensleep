package com.google.home.platform.traits.metadata;

import com.google.android.gms.internal.serialization.zzzk;
import com.google.android.gms.internal.serialization.zzzl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public enum BaseUnit implements zzzk {
    BASE_UNIT_UNSPECIFIED(0),
    BASE_UNIT_METERS(1),
    BASE_UNIT_SECOND(2),
    BASE_UNIT_PERCENT(3),
    BASE_UNIT_CELSIUS(4),
    BASE_UNIT_KELVIN(11),
    BASE_UNIT_MIRED(5),
    BASE_UNIT_PARTS_PER_MILLION(6),
    BASE_UNIT_KG_PER_CUBIC_METER(7),
    BASE_UNIT_PARTICLES_PER_CUBIC_METER(8),
    BASE_UNIT_BECQUEREL_PER_CUBIC_METER(9),
    BASE_UNIT_DEGREES(10),
    BASE_UNIT_AMPERE(12),
    BASE_UNIT_WATT_HOUR(13),
    BASE_UNIT_AIR_QUALITY_INDEX(14),
    BASE_UNIT_WATT(15),
    UNRECOGNIZED(-1);

    private static final zzzl<BaseUnit> internalValueMap = new zzzl<BaseUnit>() { // from class: com.google.home.platform.traits.metadata.BaseUnit.1
        @Override // com.google.android.gms.internal.serialization.zzzl
        public BaseUnit findValueByNumber(int i) {
            return BaseUnit.forNumber(i);
        }
    };
    private final int value;

    BaseUnit(int i) {
        this.value = i;
    }

    public static BaseUnit forNumber(int i) {
        switch (i) {
            case 0:
                return BASE_UNIT_UNSPECIFIED;
            case 1:
                return BASE_UNIT_METERS;
            case 2:
                return BASE_UNIT_SECOND;
            case 3:
                return BASE_UNIT_PERCENT;
            case 4:
                return BASE_UNIT_CELSIUS;
            case 5:
                return BASE_UNIT_MIRED;
            case 6:
                return BASE_UNIT_PARTS_PER_MILLION;
            case 7:
                return BASE_UNIT_KG_PER_CUBIC_METER;
            case 8:
                return BASE_UNIT_PARTICLES_PER_CUBIC_METER;
            case 9:
                return BASE_UNIT_BECQUEREL_PER_CUBIC_METER;
            case 10:
                return BASE_UNIT_DEGREES;
            case 11:
                return BASE_UNIT_KELVIN;
            case 12:
                return BASE_UNIT_AMPERE;
            case 13:
                return BASE_UNIT_WATT_HOUR;
            case 14:
                return BASE_UNIT_AIR_QUALITY_INDEX;
            case 15:
                return BASE_UNIT_WATT;
            default:
                return null;
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzzk
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(getNumber());
    }
}
