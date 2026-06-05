package com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.exceptions.NegativeTimeStampError;
import com.polar.androidcommunications.api.ble.exceptions.SampleSizeMissingError;
import com.polar.androidcommunications.api.ble.exceptions.TimeStampAndFrequencyZeroError;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrameUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0006\b\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData;", "", "()V", "gnssLocationDataSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationDataSample;", "getGnssLocationDataSamples", "()Ljava/util/List;", "Companion", "GnssCoordinateSample", "GnssGpsNMEASample", "GnssSatelliteDilutionSample", "GnssSatelliteSummary", "GnssSatelliteSummarySample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GnssLocationData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<GnssLocationDataSample> gnssLocationDataSamples = new ArrayList();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$Companion;", "", "()V", "TYPE_0_SAMPLE_IN_BYTES", "", "TYPE_1_SAMPLE_IN_BYTES", "TYPE_2_SAMPLE_IN_BYTES", "dataFromRawType0", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "dataFromRawType1", "dataFromRawType2", "dataFromRawType3", "parseDataFromDataFrame", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PmdDataFrame.PmdDataFrameType.values().length];
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_0.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_1.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_2.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_3.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GnssLocationData dataFromRawType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            GnssLocationData gnssLocationData = new GnssLocationData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 51, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                PmdDataFrameUtils pmdDataFrameUtils = PmdDataFrameUtils.INSTANCE;
                byte[] bArrSliceArray = ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i, i + 7));
                BlePMDClient.PmdDataFieldEncoding pmdDataFieldEncoding = BlePMDClient.PmdDataFieldEncoding.DOUBLE_IEEE754;
                Object frameDataField = pmdDataFrameUtils.parseFrameDataField(bArrSliceArray, pmdDataFieldEncoding);
                frameDataField.getClass();
                double dDoubleValue = ((Double) frameDataField).doubleValue();
                Object frameDataField2 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i + 8, i + 15)), pmdDataFieldEncoding);
                frameDataField2.getClass();
                double dDoubleValue2 = ((Double) frameDataField2).doubleValue();
                byte[] bArrSliceArray2 = ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i + 16, i + 17));
                BlePMDClient.PmdDataFieldEncoding pmdDataFieldEncoding2 = BlePMDClient.PmdDataFieldEncoding.UNSIGNED_INT;
                Object frameDataField3 = pmdDataFrameUtils.parseFrameDataField(bArrSliceArray2, pmdDataFieldEncoding2);
                frameDataField3.getClass();
                int data2 = ((UInt) frameDataField3).getData();
                int i3 = i + 18;
                Object frameDataField4 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i3, i3)), pmdDataFieldEncoding2);
                frameDataField4.getClass();
                int data3 = ((UInt) frameDataField4).getData();
                int i4 = i + 19;
                Object frameDataField5 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i4, i4)), pmdDataFieldEncoding2);
                frameDataField5.getClass();
                int data4 = ((UInt) frameDataField5).getData();
                GnssLocationData gnssLocationData2 = gnssLocationData;
                Object frameDataField6 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i + 20, i + 23)), pmdDataFieldEncoding2);
                frameDataField6.getClass();
                int data5 = ((UInt) frameDataField6).getData();
                int i5 = i + 24;
                int iM2389constructorimpl = UInt.m2389constructorimpl(data5 & 1023);
                int iM2389constructorimpl2 = UInt.m2389constructorimpl(UInt.m2389constructorimpl(data5 & 31744) >>> 10);
                int iM2389constructorimpl3 = UInt.m2389constructorimpl(UInt.m2389constructorimpl(data5 & 2064384) >>> 15);
                int iM2389constructorimpl4 = UInt.m2389constructorimpl(UInt.m2389constructorimpl(data5 & 132120576) >>> 21);
                String str = String.format("%04d", Arrays.copyOf(new Object[]{Integer.valueOf(data2)}, 1));
                String str2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(data3)}, 1));
                int i6 = i;
                String str3 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(data4)}, 1));
                String str4 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iM2389constructorimpl2)}, 1));
                String str5 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iM2389constructorimpl3)}, 1));
                String str6 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iM2389constructorimpl4)}, 1));
                String str7 = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(iM2389constructorimpl)}, 1));
                StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(str, "-", str2, "-", str3);
                FileInsert$$ExternalSyntheticOutline0.m(sbM66m, "T", str4, ":", str5);
                String strM = Fragment$$ExternalSyntheticOutline1.m(sbM66m, ":", str6, ".", str7);
                Object frameDataField7 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i5, i6 + 27)), pmdDataFieldEncoding2);
                frameDataField7.getClass();
                double dUintToDouble = UnsignedKt.uintToDouble(((UInt) frameDataField7).getData()) / 10.0d;
                byte[] bArrSliceArray3 = ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i6 + 28, i6 + 31));
                BlePMDClient.PmdDataFieldEncoding pmdDataFieldEncoding3 = BlePMDClient.PmdDataFieldEncoding.FLOAT_IEEE754;
                Object frameDataField8 = pmdDataFrameUtils.parseFrameDataField(bArrSliceArray3, pmdDataFieldEncoding3);
                frameDataField8.getClass();
                float fFloatValue = ((Float) frameDataField8).floatValue();
                Object frameDataField9 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i6 + 32, i6 + 35)), pmdDataFieldEncoding3);
                frameDataField9.getClass();
                float fFloatValue2 = ((Float) frameDataField9).floatValue();
                Object frameDataField10 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i6 + 36, i6 + 39)), pmdDataFieldEncoding3);
                frameDataField10.getClass();
                float fFloatValue3 = ((Float) frameDataField10).floatValue();
                Object frameDataField11 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i6 + 40, i6 + 43)), pmdDataFieldEncoding3);
                frameDataField11.getClass();
                float fFloatValue4 = ((Float) frameDataField11).floatValue();
                Object frameDataField12 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i6 + 44, i6 + 45)), pmdDataFieldEncoding2);
                frameDataField12.getClass();
                float fUintToDouble = ((float) UnsignedKt.uintToDouble(((UInt) frameDataField12).getData())) / 100.0f;
                Object frameDataField13 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i6 + 46, i6 + 47)), pmdDataFieldEncoding2);
                frameDataField13.getClass();
                float fUintToDouble2 = ((float) UnsignedKt.uintToDouble(((UInt) frameDataField13).getData())) / 100.0f;
                int i7 = i6 + 48;
                Object frameDataField14 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i7, i7)), BlePMDClient.PmdDataFieldEncoding.BOOLEAN);
                frameDataField14.getClass();
                boolean zBooleanValue = ((Boolean) frameDataField14).booleanValue();
                int i8 = i6 + 49;
                Object frameDataField15 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i8, i8)), BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
                frameDataField15.getClass();
                int iIntValue = ((Integer) frameDataField15).intValue();
                int i9 = i6 + 50;
                Object frameDataField16 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i9, i9)), pmdDataFieldEncoding2);
                frameDataField16.getClass();
                gnssLocationData2.getGnssLocationDataSamples().add(new GnssCoordinateSample(listM890getTimeStampsx53JL5M.get(i2).getData(), dDoubleValue, dDoubleValue2, strM, dUintToDouble, fFloatValue, fFloatValue2, fFloatValue3, fFloatValue4, fUintToDouble, fUintToDouble2, zBooleanValue, iIntValue, ((UInt) frameDataField16).getData(), null));
                i2++;
                gnssLocationData = gnssLocationData2;
                i = i6 + 51;
            }
            return gnssLocationData;
        }

        private final GnssLocationData dataFromRawType1(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            GnssLocationData gnssLocationData = new GnssLocationData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 6, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                PmdDataFrameUtils pmdDataFrameUtils = PmdDataFrameUtils.INSTANCE;
                byte[] bArrSliceArray = ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i, i + 1));
                BlePMDClient.PmdDataFieldEncoding pmdDataFieldEncoding = BlePMDClient.PmdDataFieldEncoding.UNSIGNED_INT;
                Object frameDataField = pmdDataFrameUtils.parseFrameDataField(bArrSliceArray, pmdDataFieldEncoding);
                frameDataField.getClass();
                float fUintToDouble = ((float) UnsignedKt.uintToDouble(((UInt) frameDataField).getData())) / 100.0f;
                Object frameDataField2 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i + 2, i + 3)), BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
                frameDataField2.getClass();
                int iIntValue = ((Integer) frameDataField2).intValue();
                int i3 = i + 4;
                Object frameDataField3 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i3, i3)), pmdDataFieldEncoding);
                frameDataField3.getClass();
                int data2 = ((UInt) frameDataField3).getData();
                int i4 = i + 5;
                Object frameDataField4 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i4, i4)), BlePMDClient.PmdDataFieldEncoding.BOOLEAN);
                frameDataField4.getClass();
                i += 6;
                gnssLocationData.getGnssLocationDataSamples().add(new GnssSatelliteDilutionSample(listM890getTimeStampsx53JL5M.get(i2).getData(), fUintToDouble, iIntValue, data2, ((Boolean) frameDataField4).booleanValue(), null));
                i2++;
            }
            return gnssLocationData;
        }

        private final GnssLocationData dataFromRawType2(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            GnssLocationData gnssLocationData = new GnssLocationData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 41, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                GnssSatelliteSummary gnssSatelliteSummary = new GnssSatelliteSummary(UByte.m2367constructorimpl(frame.getDataContent()[0]), UByte.m2367constructorimpl(frame.getDataContent()[1]), UByte.m2367constructorimpl(frame.getDataContent()[2]), UByte.m2367constructorimpl(frame.getDataContent()[3]), UByte.m2367constructorimpl(frame.getDataContent()[4]), UByte.m2367constructorimpl(frame.getDataContent()[5]), UByte.m2367constructorimpl(frame.getDataContent()[6]), UByte.m2367constructorimpl(frame.getDataContent()[7]), UByte.m2367constructorimpl(frame.getDataContent()[8]), UByte.m2367constructorimpl(frame.getDataContent()[9]), null);
                GnssSatelliteSummary gnssSatelliteSummary2 = new GnssSatelliteSummary(UByte.m2367constructorimpl(frame.getDataContent()[10]), UByte.m2367constructorimpl(frame.getDataContent()[11]), UByte.m2367constructorimpl(frame.getDataContent()[12]), UByte.m2367constructorimpl(frame.getDataContent()[13]), UByte.m2367constructorimpl(frame.getDataContent()[14]), UByte.m2367constructorimpl(frame.getDataContent()[15]), UByte.m2367constructorimpl(frame.getDataContent()[16]), UByte.m2367constructorimpl(frame.getDataContent()[17]), UByte.m2367constructorimpl(frame.getDataContent()[18]), UByte.m2367constructorimpl(frame.getDataContent()[19]), null);
                GnssSatelliteSummary gnssSatelliteSummary3 = new GnssSatelliteSummary(UByte.m2367constructorimpl(frame.getDataContent()[20]), UByte.m2367constructorimpl(frame.getDataContent()[21]), UByte.m2367constructorimpl(frame.getDataContent()[22]), UByte.m2367constructorimpl(frame.getDataContent()[23]), UByte.m2367constructorimpl(frame.getDataContent()[24]), UByte.m2367constructorimpl(frame.getDataContent()[25]), UByte.m2367constructorimpl(frame.getDataContent()[26]), UByte.m2367constructorimpl(frame.getDataContent()[27]), UByte.m2367constructorimpl(frame.getDataContent()[28]), UByte.m2367constructorimpl(frame.getDataContent()[29]), null);
                GnssSatelliteSummary gnssSatelliteSummary4 = new GnssSatelliteSummary(UByte.m2367constructorimpl(frame.getDataContent()[30]), UByte.m2367constructorimpl(frame.getDataContent()[31]), UByte.m2367constructorimpl(frame.getDataContent()[32]), UByte.m2367constructorimpl(frame.getDataContent()[33]), UByte.m2367constructorimpl(frame.getDataContent()[34]), UByte.m2367constructorimpl(frame.getDataContent()[35]), UByte.m2367constructorimpl(frame.getDataContent()[36]), UByte.m2367constructorimpl(frame.getDataContent()[37]), UByte.m2367constructorimpl(frame.getDataContent()[38]), UByte.m2367constructorimpl(frame.getDataContent()[39]), null);
                int i3 = i + 40;
                Object frameDataField = PmdDataFrameUtils.INSTANCE.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i3, i3)), BlePMDClient.PmdDataFieldEncoding.UNSIGNED_INT);
                frameDataField.getClass();
                i += 41;
                gnssLocationData.getGnssLocationDataSamples().add(new GnssSatelliteSummarySample(listM890getTimeStampsx53JL5M.get(i2).getData(), gnssSatelliteSummary, gnssSatelliteSummary2, gnssSatelliteSummary3, gnssSatelliteSummary4, ((UInt) frameDataField).getData(), null));
                i2++;
            }
            return gnssLocationData;
        }

        private final GnssLocationData dataFromRawType3(PmdDataFrame frame) {
            GnssLocationData gnssLocationData = new GnssLocationData();
            int i = 0;
            while (i < frame.getDataContent().length) {
                PmdDataFrameUtils pmdDataFrameUtils = PmdDataFrameUtils.INSTANCE;
                byte[] bArrSliceArray = ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i, i + 3));
                BlePMDClient.PmdDataFieldEncoding pmdDataFieldEncoding = BlePMDClient.PmdDataFieldEncoding.UNSIGNED_INT;
                Object frameDataField = pmdDataFrameUtils.parseFrameDataField(bArrSliceArray, pmdDataFieldEncoding);
                frameDataField.getClass();
                int data2 = ((UInt) frameDataField).getData();
                Object frameDataField2 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i + 4, i + 5)), pmdDataFieldEncoding);
                frameDataField2.getClass();
                int data3 = ((UInt) frameDataField2).getData();
                int i2 = i + 6;
                Object frameDataField3 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i2, i2)), BlePMDClient.PmdDataFieldEncoding.UNSIGNED_BYTE);
                frameDataField3.getClass();
                int i3 = i + 7;
                int i4 = i3 + data3;
                gnssLocationData.getGnssLocationDataSamples().add(new GnssGpsNMEASample(frame.getTimeStamp(), data2, data3, ((UByte) frameDataField3).getData(), new String(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i3, i4)), Charsets.UTF_8), null));
                i = i4;
            }
            return gnssLocationData;
        }

        public final GnssLocationData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (frame.getIsCompressedFrame()) {
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by Location data parser"));
            }
            int i = WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()];
            if (i == 1) {
                return dataFromRawType0(frame);
            }
            if (i == 2) {
                return dataFromRawType1(frame);
            }
            if (i == 3) {
                return dataFromRawType2(frame);
            }
            if (i == 4) {
                return dataFromRawType3(frame);
            }
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by Location data parser"));
        }

        private Companion() {
        }
    }

    public final List<GnssLocationDataSample> getGnssLocationDataSamples() {
        return this.gnssLocationDataSamples;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u0012R\u001d\u0010\t\u001a\u00020\b8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001f\u0010\u0012R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteDilutionSample;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationDataSample;", "Lkotlin/ULong;", "timeStamp", "", "dilution", "", "altitude", "Lkotlin/UInt;", "numberOfSatellites", "", "fix", "<init>", "(JFIIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "F", "getDilution", "()F", "I", "getAltitude", "getNumberOfSatellites-pVg5ArA", "Z", "getFix", "()Z", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GnssSatelliteDilutionSample extends GnssLocationDataSample {
        private final int altitude;
        private final float dilution;
        private final boolean fix;
        private final int numberOfSatellites;
        private final long timeStamp;

        private GnssSatelliteDilutionSample(long j, float f, int i, int i2, boolean z) {
            super(null);
            this.timeStamp = j;
            this.dilution = f;
            this.altitude = i;
            this.numberOfSatellites = i2;
            this.fix = z;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GnssSatelliteDilutionSample)) {
                return false;
            }
            GnssSatelliteDilutionSample gnssSatelliteDilutionSample = (GnssSatelliteDilutionSample) other;
            return this.timeStamp == gnssSatelliteDilutionSample.timeStamp && Float.compare(this.dilution, gnssSatelliteDilutionSample.dilution) == 0 && this.altitude == gnssSatelliteDilutionSample.altitude && this.numberOfSatellites == gnssSatelliteDilutionSample.numberOfSatellites && this.fix == gnssSatelliteDilutionSample.fix;
        }

        public int hashCode() {
            return Boolean.hashCode(this.fix) + ((UInt.m2391hashCodeimpl(this.numberOfSatellites) + FileInsert$$ExternalSyntheticOutline0.m(this.altitude, Fragment$$ExternalSyntheticOutline1.m(this.dilution, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31)) * 31);
        }

        public String toString() {
            return "GnssSatelliteDilutionSample(timeStamp=" + ULong.m2414toStringimpl(this.timeStamp) + ", dilution=" + this.dilution + ", altitude=" + this.altitude + ", numberOfSatellites=" + UInt.m2392toStringimpl(this.numberOfSatellites) + ", fix=" + this.fix + ")";
        }

        public /* synthetic */ GnssSatelliteDilutionSample(long j, float f, int i, int i2, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, f, i, i2, z);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0011R\u001d\u0010\u0006\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u0011R\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssGpsNMEASample;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationDataSample;", "Lkotlin/ULong;", "timeStamp", "Lkotlin/UInt;", "measurementPeriod", "messageLength", "Lkotlin/UByte;", "statusFlags", "", "nmeaMessage", "<init>", "(JIIBLjava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "I", "getMeasurementPeriod-pVg5ArA", "getMessageLength-pVg5ArA", "B", "getStatusFlags-w2LRezQ", "()B", "Ljava/lang/String;", "getNmeaMessage", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GnssGpsNMEASample extends GnssLocationDataSample {
        private final int measurementPeriod;
        private final int messageLength;
        private final String nmeaMessage;
        private final byte statusFlags;
        private final long timeStamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GnssGpsNMEASample(long j, int i, int i2, byte b, String str) {
            super(null);
            str.getClass();
            this.timeStamp = j;
            this.measurementPeriod = i;
            this.messageLength = i2;
            this.statusFlags = b;
            this.nmeaMessage = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GnssGpsNMEASample)) {
                return false;
            }
            GnssGpsNMEASample gnssGpsNMEASample = (GnssGpsNMEASample) other;
            return this.timeStamp == gnssGpsNMEASample.timeStamp && this.measurementPeriod == gnssGpsNMEASample.measurementPeriod && this.messageLength == gnssGpsNMEASample.messageLength && this.statusFlags == gnssGpsNMEASample.statusFlags && Intrinsics.areEqual(this.nmeaMessage, gnssGpsNMEASample.nmeaMessage);
        }

        public int hashCode() {
            return this.nmeaMessage.hashCode() + ((UByte.m2369hashCodeimpl(this.statusFlags) + ((UInt.m2391hashCodeimpl(this.messageLength) + ((UInt.m2391hashCodeimpl(this.measurementPeriod) + (ULong.m2413hashCodeimpl(this.timeStamp) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            String strM2392toStringimpl = UInt.m2392toStringimpl(this.measurementPeriod);
            String strM2392toStringimpl2 = UInt.m2392toStringimpl(this.messageLength);
            String strM2370toStringimpl = UByte.m2370toStringimpl(this.statusFlags);
            String str = this.nmeaMessage;
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("GnssGpsNMEASample(timeStamp=", strM2414toStringimpl, ", measurementPeriod=", strM2392toStringimpl, ", messageLength=");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, strM2392toStringimpl2, ", statusFlags=", strM2370toStringimpl, ", nmeaMessage=");
            return FileInsert$$ExternalSyntheticOutline0.m(sbM6m, str, ")");
        }

        public /* synthetic */ GnssGpsNMEASample(long j, int i, int i2, byte b, String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i, i2, b, str);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BY\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b \u0010\u001bR\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b!\u0010\u001bR\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b$\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;", "", "Lkotlin/UByte;", "gpsNbrOfSat", "gpsMaxSnr", "glonassNbrOfSat", "glonassMaxSnr", "galileoNbrOfSat", "galileoMaxSnr", "beidouNbrOfSat", "beidouMaxSnr", "nbrOfSat", "snrTop5Avg", "<init>", "(BBBBBBBBBBLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "B", "getGpsNbrOfSat-w2LRezQ", "()B", "getGpsMaxSnr-w2LRezQ", "getGlonassNbrOfSat-w2LRezQ", "getGlonassMaxSnr-w2LRezQ", "getGalileoNbrOfSat-w2LRezQ", "getGalileoMaxSnr-w2LRezQ", "getBeidouNbrOfSat-w2LRezQ", "getBeidouMaxSnr-w2LRezQ", "getNbrOfSat-w2LRezQ", "getSnrTop5Avg-w2LRezQ", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GnssSatelliteSummary {
        private final byte beidouMaxSnr;
        private final byte beidouNbrOfSat;
        private final byte galileoMaxSnr;
        private final byte galileoNbrOfSat;
        private final byte glonassMaxSnr;
        private final byte glonassNbrOfSat;
        private final byte gpsMaxSnr;
        private final byte gpsNbrOfSat;
        private final byte nbrOfSat;
        private final byte snrTop5Avg;

        private GnssSatelliteSummary(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10) {
            this.gpsNbrOfSat = b;
            this.gpsMaxSnr = b2;
            this.glonassNbrOfSat = b3;
            this.glonassMaxSnr = b4;
            this.galileoNbrOfSat = b5;
            this.galileoMaxSnr = b6;
            this.beidouNbrOfSat = b7;
            this.beidouMaxSnr = b8;
            this.nbrOfSat = b9;
            this.snrTop5Avg = b10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GnssSatelliteSummary)) {
                return false;
            }
            GnssSatelliteSummary gnssSatelliteSummary = (GnssSatelliteSummary) other;
            return this.gpsNbrOfSat == gnssSatelliteSummary.gpsNbrOfSat && this.gpsMaxSnr == gnssSatelliteSummary.gpsMaxSnr && this.glonassNbrOfSat == gnssSatelliteSummary.glonassNbrOfSat && this.glonassMaxSnr == gnssSatelliteSummary.glonassMaxSnr && this.galileoNbrOfSat == gnssSatelliteSummary.galileoNbrOfSat && this.galileoMaxSnr == gnssSatelliteSummary.galileoMaxSnr && this.beidouNbrOfSat == gnssSatelliteSummary.beidouNbrOfSat && this.beidouMaxSnr == gnssSatelliteSummary.beidouMaxSnr && this.nbrOfSat == gnssSatelliteSummary.nbrOfSat && this.snrTop5Avg == gnssSatelliteSummary.snrTop5Avg;
        }

        public int hashCode() {
            return UByte.m2369hashCodeimpl(this.snrTop5Avg) + ((UByte.m2369hashCodeimpl(this.nbrOfSat) + ((UByte.m2369hashCodeimpl(this.beidouMaxSnr) + ((UByte.m2369hashCodeimpl(this.beidouNbrOfSat) + ((UByte.m2369hashCodeimpl(this.galileoMaxSnr) + ((UByte.m2369hashCodeimpl(this.galileoNbrOfSat) + ((UByte.m2369hashCodeimpl(this.glonassMaxSnr) + ((UByte.m2369hashCodeimpl(this.glonassNbrOfSat) + ((UByte.m2369hashCodeimpl(this.gpsMaxSnr) + (UByte.m2369hashCodeimpl(this.gpsNbrOfSat) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            String strM2370toStringimpl = UByte.m2370toStringimpl(this.gpsNbrOfSat);
            String strM2370toStringimpl2 = UByte.m2370toStringimpl(this.gpsMaxSnr);
            String strM2370toStringimpl3 = UByte.m2370toStringimpl(this.glonassNbrOfSat);
            String strM2370toStringimpl4 = UByte.m2370toStringimpl(this.glonassMaxSnr);
            String strM2370toStringimpl5 = UByte.m2370toStringimpl(this.galileoNbrOfSat);
            String strM2370toStringimpl6 = UByte.m2370toStringimpl(this.galileoMaxSnr);
            String strM2370toStringimpl7 = UByte.m2370toStringimpl(this.beidouNbrOfSat);
            String strM2370toStringimpl8 = UByte.m2370toStringimpl(this.beidouMaxSnr);
            String strM2370toStringimpl9 = UByte.m2370toStringimpl(this.nbrOfSat);
            String strM2370toStringimpl10 = UByte.m2370toStringimpl(this.snrTop5Avg);
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("GnssSatelliteSummary(gpsNbrOfSat=", strM2370toStringimpl, ", gpsMaxSnr=", strM2370toStringimpl2, ", glonassNbrOfSat=");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, strM2370toStringimpl3, ", glonassMaxSnr=", strM2370toStringimpl4, ", galileoNbrOfSat=");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, strM2370toStringimpl5, ", galileoMaxSnr=", strM2370toStringimpl6, ", beidouNbrOfSat=");
            FileInsert$$ExternalSyntheticOutline0.m(sbM6m, strM2370toStringimpl7, ", beidouMaxSnr=", strM2370toStringimpl8, ", nbrOfSat=");
            return Fragment$$ExternalSyntheticOutline1.m(sbM6m, strM2370toStringimpl9, ", snrTop5Avg=", strM2370toStringimpl10, ")");
        }

        public /* synthetic */ GnssSatelliteSummary(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, DefaultConstructorMarker defaultConstructorMarker) {
            this(b, b2, b3, b4, b5, b6, b7, b8, b9, b10);
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001d\u0010\n\u001a\u00020\t8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummarySample;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationDataSample;", "Lkotlin/ULong;", "timeStamp", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;", "seenGnssSatelliteSummaryBand1", "usedGnssSatelliteSummaryBand1", "seenGnssSatelliteSummaryBand2", "usedGnssSatelliteSummaryBand2", "Lkotlin/UInt;", "maxSnr", "<init>", "(JLcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;", "getSeenGnssSatelliteSummaryBand1", "()Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssSatelliteSummary;", "getUsedGnssSatelliteSummaryBand1", "getSeenGnssSatelliteSummaryBand2", "getUsedGnssSatelliteSummaryBand2", "I", "getMaxSnr-pVg5ArA", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GnssSatelliteSummarySample extends GnssLocationDataSample {
        private final int maxSnr;
        private final GnssSatelliteSummary seenGnssSatelliteSummaryBand1;
        private final GnssSatelliteSummary seenGnssSatelliteSummaryBand2;
        private final long timeStamp;
        private final GnssSatelliteSummary usedGnssSatelliteSummaryBand1;
        private final GnssSatelliteSummary usedGnssSatelliteSummaryBand2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GnssSatelliteSummarySample(long j, GnssSatelliteSummary gnssSatelliteSummary, GnssSatelliteSummary gnssSatelliteSummary2, GnssSatelliteSummary gnssSatelliteSummary3, GnssSatelliteSummary gnssSatelliteSummary4, int i) {
            super(null);
            gnssSatelliteSummary.getClass();
            gnssSatelliteSummary2.getClass();
            gnssSatelliteSummary3.getClass();
            gnssSatelliteSummary4.getClass();
            this.timeStamp = j;
            this.seenGnssSatelliteSummaryBand1 = gnssSatelliteSummary;
            this.usedGnssSatelliteSummaryBand1 = gnssSatelliteSummary2;
            this.seenGnssSatelliteSummaryBand2 = gnssSatelliteSummary3;
            this.usedGnssSatelliteSummaryBand2 = gnssSatelliteSummary4;
            this.maxSnr = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GnssSatelliteSummarySample)) {
                return false;
            }
            GnssSatelliteSummarySample gnssSatelliteSummarySample = (GnssSatelliteSummarySample) other;
            return this.timeStamp == gnssSatelliteSummarySample.timeStamp && Intrinsics.areEqual(this.seenGnssSatelliteSummaryBand1, gnssSatelliteSummarySample.seenGnssSatelliteSummaryBand1) && Intrinsics.areEqual(this.usedGnssSatelliteSummaryBand1, gnssSatelliteSummarySample.usedGnssSatelliteSummaryBand1) && Intrinsics.areEqual(this.seenGnssSatelliteSummaryBand2, gnssSatelliteSummarySample.seenGnssSatelliteSummaryBand2) && Intrinsics.areEqual(this.usedGnssSatelliteSummaryBand2, gnssSatelliteSummarySample.usedGnssSatelliteSummaryBand2) && this.maxSnr == gnssSatelliteSummarySample.maxSnr;
        }

        public int hashCode() {
            return UInt.m2391hashCodeimpl(this.maxSnr) + ((this.usedGnssSatelliteSummaryBand2.hashCode() + ((this.seenGnssSatelliteSummaryBand2.hashCode() + ((this.usedGnssSatelliteSummaryBand1.hashCode() + ((this.seenGnssSatelliteSummaryBand1.hashCode() + (ULong.m2413hashCodeimpl(this.timeStamp) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            return "GnssSatelliteSummarySample(timeStamp=" + ULong.m2414toStringimpl(this.timeStamp) + ", seenGnssSatelliteSummaryBand1=" + this.seenGnssSatelliteSummaryBand1 + ", usedGnssSatelliteSummaryBand1=" + this.usedGnssSatelliteSummaryBand1 + ", seenGnssSatelliteSummaryBand2=" + this.seenGnssSatelliteSummaryBand2 + ", usedGnssSatelliteSummaryBand2=" + this.usedGnssSatelliteSummaryBand2 + ", maxSnr=" + UInt.m2392toStringimpl(this.maxSnr) + ")";
        }

        public /* synthetic */ GnssSatelliteSummarySample(long j, GnssSatelliteSummary gnssSatelliteSummary, GnssSatelliteSummary gnssSatelliteSummary2, GnssSatelliteSummary gnssSatelliteSummary3, GnssSatelliteSummary gnssSatelliteSummary4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, gnssSatelliteSummary, gnssSatelliteSummary2, gnssSatelliteSummary3, gnssSatelliteSummary4, i);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001By\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u001aR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b*\u0010&R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b.\u0010-R\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010+\u001a\u0004\b/\u0010-R\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b0\u0010-R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b1\u0010-R\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b2\u0010-R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u00106\u001a\u0004\b7\u0010\u001cR\u001d\u0010\u0016\u001a\u00020\u00158\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0016\u00106\u001a\u0004\b8\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationData$GnssCoordinateSample;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GnssLocationDataSample;", "Lkotlin/ULong;", "timeStamp", "", "latitude", "longitude", "", "date", "cumulativeDistance", "", "speed", "usedAccelerationSpeed", "coordinateSpeed", "accelerationSpeedFactor", "course", "gpsChipSpeed", "", "fix", "", "speedFlag", "Lkotlin/UInt;", "fusionState", "<init>", "(JDDLjava/lang/String;DFFFFFFZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "D", "getLatitude", "()D", "getLongitude", "Ljava/lang/String;", "getDate", "getCumulativeDistance", "F", "getSpeed", "()F", "getUsedAccelerationSpeed", "getCoordinateSpeed", "getAccelerationSpeedFactor", "getCourse", "getGpsChipSpeed", "Z", "getFix", "()Z", "I", "getSpeedFlag", "getFusionState-pVg5ArA", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GnssCoordinateSample extends GnssLocationDataSample {
        private final float accelerationSpeedFactor;
        private final float coordinateSpeed;
        private final float course;
        private final double cumulativeDistance;
        private final String date;
        private final boolean fix;
        private final int fusionState;
        private final float gpsChipSpeed;
        private final double latitude;
        private final double longitude;
        private final float speed;
        private final int speedFlag;
        private final long timeStamp;
        private final float usedAccelerationSpeed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private GnssCoordinateSample(long j, double d, double d2, String str, double d3, float f, float f2, float f3, float f4, float f5, float f6, boolean z, int i, int i2) {
            super(null);
            str.getClass();
            this.timeStamp = j;
            this.latitude = d;
            this.longitude = d2;
            this.date = str;
            this.cumulativeDistance = d3;
            this.speed = f;
            this.usedAccelerationSpeed = f2;
            this.coordinateSpeed = f3;
            this.accelerationSpeedFactor = f4;
            this.course = f5;
            this.gpsChipSpeed = f6;
            this.fix = z;
            this.speedFlag = i;
            this.fusionState = i2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GnssCoordinateSample)) {
                return false;
            }
            GnssCoordinateSample gnssCoordinateSample = (GnssCoordinateSample) other;
            return this.timeStamp == gnssCoordinateSample.timeStamp && Double.compare(this.latitude, gnssCoordinateSample.latitude) == 0 && Double.compare(this.longitude, gnssCoordinateSample.longitude) == 0 && Intrinsics.areEqual(this.date, gnssCoordinateSample.date) && Double.compare(this.cumulativeDistance, gnssCoordinateSample.cumulativeDistance) == 0 && Float.compare(this.speed, gnssCoordinateSample.speed) == 0 && Float.compare(this.usedAccelerationSpeed, gnssCoordinateSample.usedAccelerationSpeed) == 0 && Float.compare(this.coordinateSpeed, gnssCoordinateSample.coordinateSpeed) == 0 && Float.compare(this.accelerationSpeedFactor, gnssCoordinateSample.accelerationSpeedFactor) == 0 && Float.compare(this.course, gnssCoordinateSample.course) == 0 && Float.compare(this.gpsChipSpeed, gnssCoordinateSample.gpsChipSpeed) == 0 && this.fix == gnssCoordinateSample.fix && this.speedFlag == gnssCoordinateSample.speedFlag && this.fusionState == gnssCoordinateSample.fusionState;
        }

        public int hashCode() {
            return UInt.m2391hashCodeimpl(this.fusionState) + FileInsert$$ExternalSyntheticOutline0.m(this.speedFlag, FileInsert$$ExternalSyntheticOutline0.m(this.fix, Fragment$$ExternalSyntheticOutline1.m(this.gpsChipSpeed, Fragment$$ExternalSyntheticOutline1.m(this.course, Fragment$$ExternalSyntheticOutline1.m(this.accelerationSpeedFactor, Fragment$$ExternalSyntheticOutline1.m(this.coordinateSpeed, Fragment$$ExternalSyntheticOutline1.m(this.usedAccelerationSpeed, Fragment$$ExternalSyntheticOutline1.m(this.speed, (Double.hashCode(this.cumulativeDistance) + FileInsert$$ExternalSyntheticOutline0.m((Double.hashCode(this.longitude) + ((Double.hashCode(this.latitude) + (ULong.m2413hashCodeimpl(this.timeStamp) * 31)) * 31)) * 31, 31, this.date)) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            double d = this.latitude;
            double d2 = this.longitude;
            String str = this.date;
            double d3 = this.cumulativeDistance;
            float f = this.speed;
            float f2 = this.usedAccelerationSpeed;
            float f3 = this.coordinateSpeed;
            float f4 = this.accelerationSpeedFactor;
            float f5 = this.course;
            float f6 = this.gpsChipSpeed;
            boolean z = this.fix;
            int i = this.speedFlag;
            String strM2392toStringimpl = UInt.m2392toStringimpl(this.fusionState);
            StringBuilder sb = new StringBuilder("GnssCoordinateSample(timeStamp=");
            sb.append(strM2414toStringimpl);
            sb.append(", latitude=");
            sb.append(d);
            sb.append(", longitude=");
            sb.append(d2);
            sb.append(", date=");
            sb.append(str);
            sb.append(", cumulativeDistance=");
            sb.append(d3);
            sb.append(", speed=");
            sb.append(f);
            sb.append(", usedAccelerationSpeed=");
            sb.append(f2);
            sb.append(", coordinateSpeed=");
            sb.append(f3);
            sb.append(", accelerationSpeedFactor=");
            sb.append(f4);
            sb.append(", course=");
            sb.append(f5);
            sb.append(", gpsChipSpeed=");
            sb.append(f6);
            sb.append(", fix=");
            sb.append(z);
            sb.append(", speedFlag=");
            sb.append(i);
            return Fragment$$ExternalSyntheticOutline1.m(sb, ", fusionState=", strM2392toStringimpl, ")");
        }

        public /* synthetic */ GnssCoordinateSample(long j, double d, double d2, String str, double d3, float f, float f2, float f3, float f4, float f5, float f6, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, d, d2, str, d3, f, f2, f3, f4, f5, f6, z, i, i2);
        }
    }
}
