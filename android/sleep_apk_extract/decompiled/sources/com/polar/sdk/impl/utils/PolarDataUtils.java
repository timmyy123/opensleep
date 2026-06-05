package com.polar.sdk.impl.utils;

import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdMeasurementType;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdOfflineRecTriggerMode;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdSetting;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.AccData;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model.PpiData;
import com.polar.sdk.api.PolarBleApi;
import com.polar.sdk.api.model.PolarAccelerometerData;
import com.polar.sdk.api.model.PolarOfflineRecordingTriggerMode;
import com.polar.sdk.api.model.PolarPpiData;
import com.polar.sdk.api.model.PolarSensorSetting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/polar/sdk/impl/utils/PolarDataUtils;", "", "<init>", "()V", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData;", "ppiData", "Lcom/polar/sdk/api/model/PolarPpiData;", "mapPMDClientPpiDataToPolarPpiData", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpiData;)Lcom/polar/sdk/api/model/PolarPpiData;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData;", "accData", "Lcom/polar/sdk/api/model/PolarAccelerometerData;", "mapPmdClientAccDataToPolarAcc", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData;)Lcom/polar/sdk/api/model/PolarAccelerometerData;", "Lcom/polar/sdk/api/model/PolarSensorSetting;", "polarSensorSetting", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting;", "mapPolarSettingsToPmdSettings", "(Lcom/polar/sdk/api/model/PolarSensorSetting;)Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting;", "pmd", "", "fromSelected", "mapPmdSettingsToPolarSettings", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdSetting;Z)Lcom/polar/sdk/api/model/PolarSensorSetting;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PolarDataUtils {
    public static final PolarDataUtils INSTANCE = new PolarDataUtils();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;

        static {
            int[] iArr = new int[PolarBleApi.PolarDeviceDataType.values().length];
            try {
                iArr[PolarBleApi.PolarDeviceDataType.ECG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.ACC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.PPG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.PPI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.GYRO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.MAGNETOMETER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.PRESSURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.LOCATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.TEMPERATURE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.SKIN_TEMPERATURE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PolarBleApi.PolarDeviceDataType.HR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PmdMeasurementType.values().length];
            try {
                iArr2[PmdMeasurementType.ECG.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[PmdMeasurementType.PPG.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[PmdMeasurementType.ACC.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[PmdMeasurementType.PPI.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[PmdMeasurementType.GYRO.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[PmdMeasurementType.MAGNETOMETER.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[PmdMeasurementType.LOCATION.ordinal()] = 7;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[PmdMeasurementType.PRESSURE.ordinal()] = 8;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[PmdMeasurementType.TEMPERATURE.ordinal()] = 9;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[PmdMeasurementType.OFFLINE_HR.ordinal()] = 10;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[PmdMeasurementType.SKIN_TEMP.ordinal()] = 11;
            } catch (NoSuchFieldError unused22) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PolarOfflineRecordingTriggerMode.values().length];
            try {
                iArr3[PolarOfflineRecordingTriggerMode.TRIGGER_SYSTEM_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr3[PolarOfflineRecordingTriggerMode.TRIGGER_EXERCISE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr3[PolarOfflineRecordingTriggerMode.TRIGGER_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[PmdOfflineRecTriggerMode.values().length];
            try {
                iArr4[PmdOfflineRecTriggerMode.TRIGGER_DISABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr4[PmdOfflineRecTriggerMode.TRIGGER_SYSTEM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr4[PmdOfflineRecTriggerMode.TRIGGER_EXERCISE_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[PmdSetting.PmdSettingType.values().length];
            try {
                iArr5[PmdSetting.PmdSettingType.SAMPLE_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr5[PmdSetting.PmdSettingType.RESOLUTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr5[PmdSetting.PmdSettingType.RANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr5[PmdSetting.PmdSettingType.CHANNELS.ordinal()] = 4;
            } catch (NoSuchFieldError unused32) {
            }
            $EnumSwitchMapping$4 = iArr5;
        }
    }

    private PolarDataUtils() {
    }

    public final PolarPpiData mapPMDClientPpiDataToPolarPpiData(PpiData ppiData) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        ppiData.getClass();
        ArrayList arrayList = new ArrayList();
        for (PpiData.PpiSample ppiSample : ppiData.getPpiSamples()) {
            int hr = ppiSample.getHr();
            int ppInMs = ppiSample.getPpInMs();
            int ppErrorEstimate = ppiSample.getPpErrorEstimate();
            int blockerBit = ppiSample.getBlockerBit();
            int skinContactStatus = ppiSample.getSkinContactStatus();
            int skinContactSupported = ppiSample.getSkinContactSupported();
            long timeStamp = ppiSample.getTimeStamp();
            boolean z3 = false;
            if (blockerBit != 0) {
                i = skinContactStatus;
                z = true;
            } else {
                i = skinContactStatus;
                z = false;
            }
            if (i != 0) {
                i2 = skinContactSupported;
                z2 = true;
            } else {
                i2 = skinContactSupported;
                z2 = false;
            }
            if (i2 != 0) {
                z3 = true;
            }
            arrayList.add(new PolarPpiData.PolarPpiSample(ppInMs, ppErrorEstimate, hr, z, z2, z3, timeStamp, null));
        }
        return new PolarPpiData(arrayList);
    }

    public final PolarAccelerometerData mapPmdClientAccDataToPolarAcc(AccData accData) {
        accData.getClass();
        ArrayList arrayList = new ArrayList();
        for (AccData.AccSample accSample : accData.getAccSamples()) {
            arrayList.add(new PolarAccelerometerData.PolarAccelerometerDataSample(accSample.getTimeStamp(), accSample.getX(), accSample.getY(), accSample.getZ()));
        }
        return new PolarAccelerometerData(arrayList);
    }

    public final PolarSensorSetting mapPmdSettingsToPolarSettings(PmdSetting pmd, boolean fromSelected) {
        pmd.getClass();
        if (fromSelected) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<PmdSetting.PmdSettingType, Integer> entry : pmd.getSelected().entrySet()) {
                PmdSetting.PmdSettingType key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                int i = WhenMappings.$EnumSwitchMapping$4[key.ordinal()];
                if (i == 1) {
                    linkedHashMap.put(PolarSensorSetting.SettingType.SAMPLE_RATE, Integer.valueOf(iIntValue));
                } else if (i == 2) {
                    linkedHashMap.put(PolarSensorSetting.SettingType.RESOLUTION, Integer.valueOf(iIntValue));
                } else if (i == 3) {
                    linkedHashMap.put(PolarSensorSetting.SettingType.RANGE, Integer.valueOf(iIntValue));
                } else if (i == 4) {
                    linkedHashMap.put(PolarSensorSetting.SettingType.CHANNELS, Integer.valueOf(iIntValue));
                }
            }
            return new PolarSensorSetting((Map<PolarSensorSetting.SettingType, Integer>) MapsKt.toMap(linkedHashMap));
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<PmdSetting.PmdSettingType, Set<Integer>> entry2 : pmd.getSettings().entrySet()) {
            PmdSetting.PmdSettingType key2 = entry2.getKey();
            Set<Integer> value = entry2.getValue();
            int i2 = key2 == null ? -1 : WhenMappings.$EnumSwitchMapping$4[key2.ordinal()];
            if (i2 == 1) {
                PolarSensorSetting.SettingType settingType = PolarSensorSetting.SettingType.SAMPLE_RATE;
                value.getClass();
                linkedHashMap2.put(settingType, value);
            } else if (i2 == 2) {
                PolarSensorSetting.SettingType settingType2 = PolarSensorSetting.SettingType.RESOLUTION;
                value.getClass();
                linkedHashMap2.put(settingType2, value);
            } else if (i2 == 3) {
                PolarSensorSetting.SettingType settingType3 = PolarSensorSetting.SettingType.RANGE;
                value.getClass();
                linkedHashMap2.put(settingType3, value);
            } else if (i2 == 4) {
                PolarSensorSetting.SettingType settingType4 = PolarSensorSetting.SettingType.CHANNELS;
                value.getClass();
                linkedHashMap2.put(settingType4, value);
            }
        }
        return new PolarSensorSetting((List<? extends Pair<? extends PolarSensorSetting.SettingType, ? extends Set<Integer>>>) MapsKt.toList(linkedHashMap2));
    }

    public final PmdSetting mapPolarSettingsToPmdSettings(PolarSensorSetting polarSensorSetting) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (polarSensorSetting != null) {
            for (Map.Entry<PolarSensorSetting.SettingType, Set<Integer>> entry : polarSensorSetting.getSettings().entrySet()) {
                PolarSensorSetting.SettingType key = entry.getKey();
                Set<Integer> value = entry.getValue();
                PmdSetting.PmdSettingType pmdSettingType = PmdSetting.PmdSettingType.values()[key.getNumVal()];
                Object objMax = Collections.max(value);
                objMax.getClass();
                linkedHashMap.put(pmdSettingType, objMax);
            }
        }
        return new PmdSetting(linkedHashMap);
    }
}
