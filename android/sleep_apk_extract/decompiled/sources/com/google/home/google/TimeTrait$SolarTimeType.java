package com.google.home.google;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/google/home/google/TimeTrait$SolarTimeType", "", "Lcom/google/home/google/TimeTrait$SolarTimeType;", "<init>", "(Ljava/lang/String;I)V", "Sunrise", "Sunset", "java.com.google.home.whdm.src.com.google.home.google_time_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimeTrait$SolarTimeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TimeTrait$SolarTimeType[] $VALUES;
    public static final TimeTrait$SolarTimeType Sunrise = new TimeTrait$SolarTimeType("Sunrise", 0);
    public static final TimeTrait$SolarTimeType Sunset = new TimeTrait$SolarTimeType("Sunset", 1);

    private static final /* synthetic */ TimeTrait$SolarTimeType[] $values() {
        return new TimeTrait$SolarTimeType[]{Sunrise, Sunset};
    }

    static {
        TimeTrait$SolarTimeType[] timeTrait$SolarTimeTypeArr$values = $values();
        $VALUES = timeTrait$SolarTimeTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(timeTrait$SolarTimeTypeArr$values);
    }

    private TimeTrait$SolarTimeType(String str, int i) {
    }

    public static TimeTrait$SolarTimeType valueOf(String str) {
        return (TimeTrait$SolarTimeType) Enum.valueOf(TimeTrait$SolarTimeType.class, str);
    }

    public static TimeTrait$SolarTimeType[] values() {
        return (TimeTrait$SolarTimeType[]) $VALUES.clone();
    }
}
