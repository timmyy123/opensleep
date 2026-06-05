package com.urbandroid.sleep.hr.polar.domain;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.hr.polar.domain.PmdSetting;
import com.urbandroid.sleep.hr.polar.domain.PpgData;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class PmdDataParser {

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.polar.domain.PmdDataParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$hr$polar$domain$PmdMeasurementType;
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$hr$polar$domain$PpgData$PpgFrameType;

        static {
            int[] iArr = new int[PmdMeasurementType.values().length];
            $SwitchMap$com$urbandroid$sleep$hr$polar$domain$PmdMeasurementType = iArr;
            try {
                iArr[PmdMeasurementType.PPG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$hr$polar$domain$PmdMeasurementType[PmdMeasurementType.ACC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$hr$polar$domain$PmdMeasurementType[PmdMeasurementType.PPI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[PpgData.PpgFrameType.values().length];
            $SwitchMap$com$urbandroid$sleep$hr$polar$domain$PpgData$PpgFrameType = iArr2;
            try {
                iArr2[PpgData.PpgFrameType.PPG1_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$hr$polar$domain$PpgData$PpgFrameType[PpgData.PpgFrameType.PPG0_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class PmdMeasurement<T> {

        /* JADX INFO: renamed from: data, reason: collision with root package name */
        public final T f69data;
        public final PmdMeasurementType type;

        public PmdMeasurement(PmdMeasurementType pmdMeasurementType, T t) {
            this.type = pmdMeasurementType;
            this.f69data = t;
        }

        public String toString() {
            return "PmdMeasurement{type=" + this.type + ", data=" + this.f69data + "}";
        }
    }

    public static PmdMeasurement<? extends Object> parse(byte[] bArr, PmdSetting pmdSetting) {
        PmdMeasurementType pmdMeasurementTypeFromId = PmdMeasurementType.fromId(bArr[0]);
        long jConvertArrayToUnsignedLong = BleUtils.convertArrayToUnsignedLong(bArr, 1, 8);
        long jConvertArrayToUnsignedLong2 = BleUtils.convertArrayToUnsignedLong(bArr, 9, 1);
        int length = bArr.length - 10;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 10, bArr2, 0, length);
        int i = AnonymousClass1.$SwitchMap$com$urbandroid$sleep$hr$polar$domain$PmdMeasurementType[pmdMeasurementTypeFromId.ordinal()];
        if (i == 1) {
            int i2 = (int) jConvertArrayToUnsignedLong2;
            PpgData.PpgFrameType ppgFrameTypeFromId = PpgData.PpgFrameType.fromId(i2);
            int i3 = AnonymousClass1.$SwitchMap$com$urbandroid$sleep$hr$polar$domain$PpgData$PpgFrameType[ppgFrameTypeFromId.ordinal()];
            if (i3 == 1 || i3 == 2) {
                return new PmdMeasurement<>(pmdMeasurementTypeFromId, new PpgData(bArr2, jConvertArrayToUnsignedLong, i2));
            }
            return unsupportedDataType("Unknown PPG frame type received: " + ppgFrameTypeFromId);
        }
        if (i != 2) {
            if (i == 3) {
                return jConvertArrayToUnsignedLong2 == 0 ? new PmdMeasurement<>(pmdMeasurementTypeFromId, new PpiData(bArr2, jConvertArrayToUnsignedLong)) : unsupportedDataType(zzba$$ExternalSyntheticOutline0.m(jConvertArrayToUnsignedLong2, "Unknown PPI frame type received: "));
            }
            return unsupportedDataType("Unsupported PmdMeasurementType: " + pmdMeasurementTypeFromId);
        }
        if (jConvertArrayToUnsignedLong2 <= 2) {
            return new PmdMeasurement<>(pmdMeasurementTypeFromId, new AccData((byte) jConvertArrayToUnsignedLong2, bArr2, jConvertArrayToUnsignedLong));
        }
        if (pmdSetting == null || pmdSetting.selected == null) {
            return unsupportedDataType("ACC data, frame type 128: missing settings");
        }
        Map<PmdSetting.PmdSettingType, Integer> map = pmdSetting.selected;
        PmdSetting.PmdSettingType pmdSettingType = PmdSetting.PmdSettingType.FACTOR;
        try {
            return new PmdMeasurement<>(pmdMeasurementTypeFromId, new AccData(bArr2, map.containsKey(pmdSettingType) ? Float.intBitsToFloat(pmdSetting.selected.get(pmdSettingType).intValue()) : 2.4242424E-4f, pmdSetting.selected.get(PmdSetting.PmdSettingType.RESOLUTION).intValue(), jConvertArrayToUnsignedLong));
        } catch (RuntimeException e) {
            return unsupportedDataType("ACC data, frame type 128: parse error: " + e.getClass().getName() + " " + e.getMessage());
        }
    }

    private static PmdMeasurement<?> unsupportedDataType(String str) {
        return new PmdMeasurement<>(PmdMeasurementType.UNKNOWN_TYPE, str);
    }
}
