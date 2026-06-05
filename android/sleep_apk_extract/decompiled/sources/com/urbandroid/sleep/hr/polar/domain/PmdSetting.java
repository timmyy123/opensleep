package com.urbandroid.sleep.hr.polar.domain;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.ByteArrayOutputStream;
import java.util.AbstractMap;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class PmdSetting {
    private static final EnumMap<PmdSettingType, Integer> typeToFieldSize = new EnumMap<PmdSettingType, Integer>(PmdSettingType.class) { // from class: com.urbandroid.sleep.hr.polar.domain.PmdSetting.1
        {
            put(PmdSettingType.SAMPLE_RATE, 2);
            put(PmdSettingType.RESOLUTION, 2);
            put(PmdSettingType.RANGE, 2);
            put(PmdSettingType.RANGE_MILLIUNIT, 4);
            put(PmdSettingType.CHANNELS, 1);
            put(PmdSettingType.FACTOR, 4);
        }
    };
    public volatile Map<PmdSettingType, Integer> selected;
    public volatile Map<PmdSettingType, Set<Integer>> settings;

    public enum PmdSettingType {
        SAMPLE_RATE(0),
        RESOLUTION(1),
        RANGE(2),
        RANGE_MILLIUNIT(3),
        CHANNELS(4),
        FACTOR(5);

        private final int numVal;

        PmdSettingType(int i) {
            this.numVal = i;
        }
    }

    public PmdSetting(byte[] bArr) {
        this.settings = new TreeMap();
        EnumMap<PmdSettingType, Set<Integer>> pmdSettingsData = parsePmdSettingsData(bArr);
        validateSettings(pmdSettingsData);
        this.settings = pmdSettingsData;
    }

    private static void validateSetting(Map.Entry<PmdSettingType, Integer> entry) {
        int iIntValue = typeToFieldSize.get(entry.getKey()).intValue();
        int iIntValue2 = entry.getValue().intValue();
        if (iIntValue == 1 && (iIntValue2 < 0 || 255 < iIntValue2)) {
            Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(iIntValue, iIntValue2, "PmdSetting not in valid range. Field size: ", " value: "));
            return;
        }
        if (iIntValue == 2 && (iIntValue2 < 0 || 65535 < iIntValue2)) {
            Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(iIntValue, iIntValue2, "PmdSetting not in valid range. Field size: ", " value: "));
        } else if (iIntValue == 3) {
            if (iIntValue2 < 0 || 16777215 < iIntValue2) {
                Types$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(iIntValue, iIntValue2, "PmdSetting not in valid range. Field size: ", " value: "));
            }
        }
    }

    private static void validateSettings(Map<PmdSettingType, Set<Integer>> map) {
        for (Map.Entry<PmdSettingType, Set<Integer>> entry : map.entrySet()) {
            PmdSettingType key = entry.getKey();
            Iterator<Integer> it = entry.getValue().iterator();
            while (it.hasNext()) {
                validateSetting(new AbstractMap.SimpleEntry(key, it.next()));
            }
        }
    }

    public EnumMap<PmdSettingType, Set<Integer>> parsePmdSettingsData(byte[] bArr) {
        EnumMap<PmdSettingType, Set<Integer>> enumMap = new EnumMap<>(PmdSettingType.class);
        if (bArr.length > 1) {
            int i = 0;
            while (i < bArr.length) {
                int i2 = i + 1;
                PmdSettingType pmdSettingType = PmdSettingType.values()[bArr[i]];
                i += 2;
                int i3 = bArr[i2];
                HashSet hashSet = new HashSet();
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 > 0) {
                        Integer num = typeToFieldSize.get(pmdSettingType);
                        Objects.requireNonNull(num);
                        int iIntValue = num.intValue();
                        int iConvertArrayToUnsignedInt = BleUtils.convertArrayToUnsignedInt(bArr, i, iIntValue);
                        i += iIntValue;
                        hashSet.add(Integer.valueOf(iConvertArrayToUnsignedInt));
                        i3 = i4;
                    }
                }
                enumMap.put(pmdSettingType, hashSet);
            }
        }
        return enumMap;
    }

    public byte[] serializeSelected() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (Map.Entry<PmdSettingType, Integer> entry : this.selected.entrySet()) {
            if (entry.getKey() != PmdSettingType.FACTOR) {
                byteArrayOutputStream.write((byte) entry.getKey().numVal);
                byteArrayOutputStream.write(1);
                int iIntValue = entry.getValue().intValue();
                Integer num = typeToFieldSize.get(entry.getKey());
                Objects.requireNonNull(num);
                int iIntValue2 = num.intValue();
                for (int i = 0; i < iIntValue2; i++) {
                    byteArrayOutputStream.write((byte) (iIntValue >> (i * 8)));
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        return "PmdSetting{settings=" + this.settings + ", selected=" + this.selected + '}';
    }
}
