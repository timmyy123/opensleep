package com.google.home.automation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/automation/BaseUnit;", "", "tagId", "", "<init>", "(Ljava/lang/String;II)V", "getTagId", "()I", "METERS", "SECONDS", "PERCENT", "CELSIUS", "MIRED", "PARTS_PER_MILLION", "KG_PER_CUBIC_METER", "PARTICLES_PER_CUBIC_METER", "BECQUEREL_PER_CUBIC_METER", "DEGREES", "KELVIN", "AMPERE", "WATT_HOUR", "AIR_QUALITY_INDEX", "WATT", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BaseUnit {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BaseUnit[] $VALUES;
    private final int tagId;
    public static final BaseUnit METERS = new BaseUnit("METERS", 0, 1);
    public static final BaseUnit SECONDS = new BaseUnit("SECONDS", 1, 2);
    public static final BaseUnit PERCENT = new BaseUnit("PERCENT", 2, 3);
    public static final BaseUnit CELSIUS = new BaseUnit("CELSIUS", 3, 4);
    public static final BaseUnit MIRED = new BaseUnit("MIRED", 4, 5);
    public static final BaseUnit PARTS_PER_MILLION = new BaseUnit("PARTS_PER_MILLION", 5, 6);
    public static final BaseUnit KG_PER_CUBIC_METER = new BaseUnit("KG_PER_CUBIC_METER", 6, 7);
    public static final BaseUnit PARTICLES_PER_CUBIC_METER = new BaseUnit("PARTICLES_PER_CUBIC_METER", 7, 8);
    public static final BaseUnit BECQUEREL_PER_CUBIC_METER = new BaseUnit("BECQUEREL_PER_CUBIC_METER", 8, 9);
    public static final BaseUnit DEGREES = new BaseUnit("DEGREES", 9, 10);
    public static final BaseUnit KELVIN = new BaseUnit("KELVIN", 10, 11);
    public static final BaseUnit AMPERE = new BaseUnit("AMPERE", 11, 12);
    public static final BaseUnit WATT_HOUR = new BaseUnit("WATT_HOUR", 12, 13);
    public static final BaseUnit AIR_QUALITY_INDEX = new BaseUnit("AIR_QUALITY_INDEX", 13, 14);
    public static final BaseUnit WATT = new BaseUnit("WATT", 14, 15);

    private static final /* synthetic */ BaseUnit[] $values() {
        return new BaseUnit[]{METERS, SECONDS, PERCENT, CELSIUS, MIRED, PARTS_PER_MILLION, KG_PER_CUBIC_METER, PARTICLES_PER_CUBIC_METER, BECQUEREL_PER_CUBIC_METER, DEGREES, KELVIN, AMPERE, WATT_HOUR, AIR_QUALITY_INDEX, WATT};
    }

    static {
        BaseUnit[] baseUnitArr$values = $values();
        $VALUES = baseUnitArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(baseUnitArr$values);
    }

    private BaseUnit(String str, int i, int i2) {
        this.tagId = i2;
    }

    public static BaseUnit valueOf(String str) {
        return (BaseUnit) Enum.valueOf(BaseUnit.class, str);
    }

    public static BaseUnit[] values() {
        return (BaseUnit[]) $VALUES.clone();
    }

    public final int getTagId() {
        return this.tagId;
    }
}
