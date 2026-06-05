package com.polar.sdk.api.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0012B\u001d\b\u0016\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007B)\b\u0010\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\t0\b¢\u0006\u0004\b\u0006\u0010\fRH\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/polar/sdk/api/model/PolarSensorSetting;", "", "", "Lcom/polar/sdk/api/model/PolarSensorSetting$SettingType;", "", "settings", "<init>", "(Ljava/util/Map;)V", "", "Lkotlin/Pair;", "", "setting", "(Ljava/util/List;)V", "", "<set-?>", "Ljava/util/Map;", "getSettings", "()Ljava/util/Map;", "SettingType", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PolarSensorSetting {
    private Map<SettingType, Set<Integer>> settings;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/polar/sdk/api/model/PolarSensorSetting$SettingType;", "", "numVal", "", "(Ljava/lang/String;II)V", "getNumVal", "()I", "SAMPLE_RATE", "RESOLUTION", "RANGE", "CHANNELS", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SettingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SettingType[] $VALUES;
        private final int numVal;
        public static final SettingType SAMPLE_RATE = new SettingType("SAMPLE_RATE", 0, 0);
        public static final SettingType RESOLUTION = new SettingType("RESOLUTION", 1, 1);
        public static final SettingType RANGE = new SettingType("RANGE", 2, 2);
        public static final SettingType CHANNELS = new SettingType("CHANNELS", 3, 4);

        private static final /* synthetic */ SettingType[] $values() {
            return new SettingType[]{SAMPLE_RATE, RESOLUTION, RANGE, CHANNELS};
        }

        static {
            SettingType[] settingTypeArr$values = $values();
            $VALUES = settingTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(settingTypeArr$values);
        }

        private SettingType(String str, int i, int i2) {
            this.numVal = i2;
        }

        public static SettingType valueOf(String str) {
            return (SettingType) Enum.valueOf(SettingType.class, str);
        }

        public static SettingType[] values() {
            return (SettingType[]) $VALUES.clone();
        }

        public final int getNumVal() {
            return this.numVal;
        }
    }

    public PolarSensorSetting(Map<SettingType, Integer> map) {
        map.getClass();
        this.settings = new LinkedHashMap();
        for (Map.Entry<SettingType, Integer> entry : map.entrySet()) {
            this.settings.put(entry.getKey(), SetsKt.setOf(Integer.valueOf(entry.getValue().intValue())));
        }
    }

    public final Map<SettingType, Set<Integer>> getSettings() {
        return this.settings;
    }

    public PolarSensorSetting(List<? extends Pair<? extends SettingType, ? extends Set<Integer>>> list) {
        list.getClass();
        this.settings = new LinkedHashMap();
        this.settings = MapsKt.toMutableMap(MapsKt.toMap(list));
    }
}
