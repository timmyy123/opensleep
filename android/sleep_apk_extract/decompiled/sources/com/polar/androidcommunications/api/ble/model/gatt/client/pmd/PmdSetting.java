package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.polar.androidcommunications.common.ble.TypeUtils;
import java.io.ByteArrayOutputStream;
import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0004\u0010\nJ)\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R4\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR<\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u001c8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting;", "", "", "data", "<init>", "([B)V", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting$PmdSettingType;", "", "selected", "(Ljava/util/Map;)V", "Ljava/util/EnumMap;", "", "parsePmdSettingsData", "([B)Ljava/util/EnumMap;", "", "updateSelectedFromStartResponse", "serializeSelected", "()[B", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "settings", "Ljava/util/EnumMap;", "getSettings", "()Ljava/util/EnumMap;", "setSettings", "(Ljava/util/EnumMap;)V", "", "<set-?>", "Ljava/util/Map;", "getSelected", "()Ljava/util/Map;", "Companion", "PmdSettingType", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdSetting {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<PmdSettingType, Integer> selected;
    private EnumMap<PmdSettingType, Set<Integer>> settings;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\nH\u0002J\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\rH\u0002J\"\u0010\u000e\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\nH\u0002¨\u0006\u0010"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting$Companion;", "", "()V", "typeToFieldSize", "", "type", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting$PmdSettingType;", "validateSelected", "", "settings", "", "validateSetting", "setting", "", "validateSettings", "", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PmdSettingType.values().length];
                try {
                    iArr[PmdSettingType.SAMPLE_RATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PmdSettingType.RESOLUTION.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PmdSettingType.RANGE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PmdSettingType.RANGE_MILLIUNIT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[PmdSettingType.CHANNELS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[PmdSettingType.FACTOR.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[PmdSettingType.SECURITY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int typeToFieldSize(PmdSettingType type) {
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    return 2;
                case 4:
                    return 4;
                case 5:
                    return 1;
                case 6:
                    return 4;
                case 7:
                    return 16;
                default:
                    Home$$ExternalSyntheticBUOutline0.m();
                    return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateSelected(Map<PmdSettingType, Integer> settings) {
            Iterator<Map.Entry<PmdSettingType, Integer>> it = settings.entrySet().iterator();
            while (it.hasNext()) {
                validateSetting(it.next());
            }
        }

        private final void validateSetting(Map.Entry<? extends PmdSettingType, Integer> setting) {
            int iTypeToFieldSize = typeToFieldSize(setting.getKey());
            int iIntValue = setting.getValue().intValue();
            if (iTypeToFieldSize == 1 && (iIntValue < 0 || 255 < iIntValue)) {
                Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(iTypeToFieldSize, iIntValue, "PmdSetting not in valid range. Field size: ", " value: "));
                return;
            }
            if (iTypeToFieldSize == 2 && (iIntValue < 0 || 65535 < iIntValue)) {
                Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(iTypeToFieldSize, iIntValue, "PmdSetting not in valid range. Field size: ", " value: "));
            } else if (iTypeToFieldSize == 3) {
                if (iIntValue < 0 || 16777215 < iIntValue) {
                    Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(iTypeToFieldSize, iIntValue, "PmdSetting not in valid range. Field size: ", " value: "));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateSettings(Map<PmdSettingType, ? extends Set<Integer>> settings) {
            for (Map.Entry<PmdSettingType, ? extends Set<Integer>> entry : settings.entrySet()) {
                PmdSettingType key = entry.getKey();
                Iterator<Integer> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    validateSetting(new AbstractMap.SimpleEntry(key, Integer.valueOf(it.next().intValue())));
                }
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting$PmdSettingType;", "", "numVal", "", "(Ljava/lang/String;II)V", "getNumVal", "()I", "SAMPLE_RATE", "RESOLUTION", "RANGE", "RANGE_MILLIUNIT", "CHANNELS", "FACTOR", "SECURITY", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PmdSettingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PmdSettingType[] $VALUES;
        private final int numVal;
        public static final PmdSettingType SAMPLE_RATE = new PmdSettingType("SAMPLE_RATE", 0, 0);
        public static final PmdSettingType RESOLUTION = new PmdSettingType("RESOLUTION", 1, 1);
        public static final PmdSettingType RANGE = new PmdSettingType("RANGE", 2, 2);
        public static final PmdSettingType RANGE_MILLIUNIT = new PmdSettingType("RANGE_MILLIUNIT", 3, 3);
        public static final PmdSettingType CHANNELS = new PmdSettingType("CHANNELS", 4, 4);
        public static final PmdSettingType FACTOR = new PmdSettingType("FACTOR", 5, 5);
        public static final PmdSettingType SECURITY = new PmdSettingType("SECURITY", 6, 6);

        private static final /* synthetic */ PmdSettingType[] $values() {
            return new PmdSettingType[]{SAMPLE_RATE, RESOLUTION, RANGE, RANGE_MILLIUNIT, CHANNELS, FACTOR, SECURITY};
        }

        static {
            PmdSettingType[] pmdSettingTypeArr$values = $values();
            $VALUES = pmdSettingTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pmdSettingTypeArr$values);
        }

        private PmdSettingType(String str, int i, int i2) {
            this.numVal = i2;
        }

        public static PmdSettingType valueOf(String str) {
            return (PmdSettingType) Enum.valueOf(PmdSettingType.class, str);
        }

        public static PmdSettingType[] values() {
            return (PmdSettingType[]) $VALUES.clone();
        }

        public final int getNumVal() {
            return this.numVal;
        }
    }

    public PmdSetting(byte[] bArr) {
        bArr.getClass();
        PmdSettingType[] pmdSettingTypeArrValues = PmdSettingType.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(pmdSettingTypeArrValues.length), 16));
        for (PmdSettingType pmdSettingType : pmdSettingTypeArrValues) {
            linkedHashMap.put(pmdSettingType, SetsKt.emptySet());
        }
        this.settings = new EnumMap<>(linkedHashMap);
        this.selected = new LinkedHashMap();
        EnumMap<PmdSettingType, Set<Integer>> pmdSettingsData = parsePmdSettingsData(bArr);
        INSTANCE.validateSettings(pmdSettingsData);
        this.settings = pmdSettingsData;
    }

    private final EnumMap<PmdSettingType, Set<Integer>> parsePmdSettingsData(byte[] data2) {
        EnumMap<PmdSettingType, Set<Integer>> enumMap = new EnumMap<>(PmdSettingType.class);
        if (data2.length > 1) {
            int i = 0;
            while (i < data2.length) {
                int i2 = i + 1;
                PmdSettingType pmdSettingType = PmdSettingType.values()[data2[i]];
                i += 2;
                int i3 = data2[i2];
                HashSet hashSet = new HashSet();
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 > 0) {
                        int iTypeToFieldSize = INSTANCE.typeToFieldSize(pmdSettingType);
                        Integer numValueOf = Integer.valueOf(TypeUtils.INSTANCE.convertArrayToSignedInt(data2, i, iTypeToFieldSize));
                        i += iTypeToFieldSize;
                        hashSet.add(numValueOf);
                        i3 = i4;
                    }
                }
                enumMap.put(pmdSettingType, hashSet);
            }
        }
        return enumMap;
    }

    public final Map<PmdSettingType, Integer> getSelected() {
        return this.selected;
    }

    public final EnumMap<PmdSettingType, Set<Integer>> getSettings() {
        return this.settings;
    }

    public final byte[] serializeSelected() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (Map.Entry<PmdSettingType, Integer> entry : this.selected.entrySet()) {
            PmdSettingType key = entry.getKey();
            int iIntValue = entry.getValue().intValue();
            if (key != PmdSettingType.FACTOR) {
                byteArrayOutputStream.write(key.getNumVal());
                byteArrayOutputStream.write(1);
                int iIntValue2 = Integer.valueOf(INSTANCE.typeToFieldSize(key)).intValue();
                for (int i = 0; i < iIntValue2; i++) {
                    byteArrayOutputStream.write(iIntValue >> (i * 8));
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\navailable settings: ");
        for (Map.Entry<PmdSettingType, Set<Integer>> entry : this.settings.entrySet()) {
            sb.append(entry.getKey() + " : " + entry.getValue() + " , ");
        }
        sb.append("\nselected settings: ");
        for (Map.Entry<PmdSettingType, Integer> entry2 : this.selected.entrySet()) {
            sb.append(entry2.getKey() + " : " + entry2.getValue() + " , ");
        }
        return sb.toString();
    }

    public final void updateSelectedFromStartResponse(byte[] data2) {
        data2.getClass();
        EnumMap<PmdSettingType, Set<Integer>> pmdSettingsData = parsePmdSettingsData(data2);
        if (pmdSettingsData != null) {
            PmdSettingType pmdSettingType = PmdSettingType.FACTOR;
            if (pmdSettingsData.containsKey(pmdSettingType)) {
                Map<PmdSettingType, Integer> map = this.selected;
                Set<Integer> set = pmdSettingsData.get(pmdSettingType);
                set.getClass();
                map.put(pmdSettingType, set.iterator().next());
            }
        }
    }

    public PmdSetting(Map<PmdSettingType, Integer> map) {
        map.getClass();
        PmdSettingType[] pmdSettingTypeArrValues = PmdSettingType.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(pmdSettingTypeArrValues.length), 16));
        for (PmdSettingType pmdSettingType : pmdSettingTypeArrValues) {
            linkedHashMap.put(pmdSettingType, SetsKt.emptySet());
        }
        this.settings = new EnumMap<>(linkedHashMap);
        this.selected = new LinkedHashMap();
        INSTANCE.validateSelected(map);
        this.selected = MapsKt.toMutableMap(map);
    }
}
