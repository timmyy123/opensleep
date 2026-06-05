package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.common.ble.BleUtils;
import com.polar.androidcommunications.common.ble.TypeUtils;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrameUtils;", "", "()V", "parseFrameDataField", "data", "", "coding", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/BlePMDClient$PmdDataFieldEncoding;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdDataFrameUtils {
    public static final PmdDataFrameUtils INSTANCE = new PmdDataFrameUtils();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BlePMDClient.PmdDataFieldEncoding.values().length];
            try {
                iArr[BlePMDClient.PmdDataFieldEncoding.FLOAT_IEEE754.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BlePMDClient.PmdDataFieldEncoding.DOUBLE_IEEE754.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BlePMDClient.PmdDataFieldEncoding.SIGNED_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BlePMDClient.PmdDataFieldEncoding.UNSIGNED_BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BlePMDClient.PmdDataFieldEncoding.UNSIGNED_INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[BlePMDClient.PmdDataFieldEncoding.UNSIGNED_LONG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[BlePMDClient.PmdDataFieldEncoding.BOOLEAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PmdDataFrameUtils() {
    }

    public final Object parseFrameDataField(byte[] data2, BlePMDClient.PmdDataFieldEncoding coding) {
        boolean z;
        data2.getClass();
        coding.getClass();
        switch (WhenMappings.$EnumSwitchMapping$0[coding.ordinal()]) {
            case 1:
                z = data2.length == 4;
                BleUtils.validate(z, "PMD parser expects data size 4 when FLOAT_IEEE754 parsed. Input data size was " + data2.length);
                return Float.valueOf(Float.intBitsToFloat(TypeUtils.INSTANCE.m897convertArrayToUnsignedInt_W1zjd8(data2, 0, data2.length)));
            case 2:
                z = data2.length == 8;
                BleUtils.validate(z, "PMD parser expects data size 8 when DOUBLE_IEEE754 parsed. Input data size was " + data2.length);
                return Double.valueOf(Double.longBitsToDouble(TypeUtils.INSTANCE.m899convertArrayToUnsignedLongqJGtvoU(data2, 0, data2.length)));
            case 3:
                z = data2.length <= 4;
                BleUtils.validate(z, "PMD parser expects data size smaller than 4 when SIGNED_INT parsed. Input data size was " + data2.length);
                return Integer.valueOf(TypeUtils.INSTANCE.convertArrayToSignedInt(data2, 0, data2.length));
            case 4:
                z = data2.length == 1;
                BleUtils.validate(z, "PMD parser expects data size 1 when UNSIGNED_BYTE parsed. Input data size was " + data2.length);
                return UByte.m2366boximpl(TypeUtils.INSTANCE.m895convertArrayToUnsignedByteWa3L5BU(data2));
            case 5:
                z = data2.length <= 4;
                BleUtils.validate(z, "PMD parser expects data size smaller than 4 when UNSIGNED_INT parsed. Input data size was " + data2.length);
                return UInt.m2388boximpl(TypeUtils.INSTANCE.m896convertArrayToUnsignedIntOGnWXxg(data2));
            case 6:
                z = data2.length <= 8;
                BleUtils.validate(z, "PMD parser expects data size smaller than 8 when UNSIGNED_LONG parsed. Input data size was " + data2.length);
                return ULong.m2410boximpl(TypeUtils.INSTANCE.m898convertArrayToUnsignedLongI7RO_PI(data2));
            case 7:
                boolean z2 = data2.length == 1;
                BleUtils.validate(z2, "PMD parser expects data size 1 when BOOLEAN parsed. Input data size was " + data2.length);
                return Boolean.valueOf(data2[0] != 0);
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
    }
}
