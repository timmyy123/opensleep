package com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.exceptions.NegativeTimeStampError;
import com.polar.androidcommunications.api.ble.exceptions.SampleSizeMissingError;
import com.polar.androidcommunications.api.ble.exceptions.TimeStampAndFrequencyZeroError;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrameUtils;
import com.polar.androidcommunications.common.ble.TypeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0003\b\t\nB\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgData;", "", "()V", "ecgSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgDataSample;", "getEcgSamples", "()Ljava/util/List;", "Companion", "EcgSample", "EcgSampleFrameType3", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EcgData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<EcgDataSample> ecgSamples = new ArrayList();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgData$Companion;", "", "()V", "TYPE_0_SAMPLE_SIZE_IN_BYTES", "", "TYPE_1_SAMPLE_SIZE_IN_BYTES", "TYPE_2_SAMPLE_SIZE_IN_BYTES", "TYPE_3_DATA_0_SIZE", "TYPE_3_DATA_1_SIZE", "TYPE_3_SAMPLE_SIZE_IN_BYTES", "TYPE_3_STATUS_SIZE", "dataFromRawType0", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgData;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "dataFromRawType1", "dataFromRawType2", "dataFromRawType3", "parseDataFromDataFrame", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private final EcgData dataFromRawType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            EcgData ecgData = new EcgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 3, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                int iConvertArrayToSignedInt = TypeUtils.INSTANCE.convertArrayToSignedInt(frame.getDataContent(), i, 3);
                i += 3;
                ecgData.getEcgSamples().add(new EcgSample(listM890getTimeStampsx53JL5M.get(i2).getData(), iConvertArrayToSignedInt, false, (byte) 0, (byte) 0, (byte) 0, (byte) 0, 124, null));
                i2++;
            }
            return ecgData;
        }

        private final EcgData dataFromRawType1(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            EcgData ecgData = new EcgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 3, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                int i3 = ((frame.getDataContent()[i] & 255) | ((frame.getDataContent()[i + 1] & 63) << 8)) & 16383;
                int i4 = i + 2;
                i += 3;
                ecgData.getEcgSamples().add(new EcgSample(listM890getTimeStampsx53JL5M.get(i2).getData(), i3, (frame.getDataContent()[i4] & 1) != 0, (byte) ((frame.getDataContent()[i4] & 6) >> 1), (byte) ((frame.getDataContent()[i4] & 24) >> 3), (byte) 0, (byte) 0, 96, null));
                i2++;
            }
            return ecgData;
        }

        private final EcgData dataFromRawType2(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            EcgData ecgData = new EcgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 3, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                int i3 = i + 2;
                i += 3;
                ecgData.getEcgSamples().add(new EcgSample(listM890getTimeStampsx53JL5M.get(i2).getData(), ((frame.getDataContent()[i] & 255) | ((frame.getDataContent()[i + 1] & 255) << 8) | ((frame.getDataContent()[i3] & 3) << 16)) & 4194303, false, (byte) 0, (byte) 0, (byte) ((frame.getDataContent()[i3] & 28) >> 2), (byte) ((frame.getDataContent()[i3] & 224) >> 5), 28, null));
                i2++;
            }
            return ecgData;
        }

        private final EcgData dataFromRawType3(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            EcgData ecgData = new EcgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 7, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                PmdDataFrameUtils pmdDataFrameUtils = PmdDataFrameUtils.INSTANCE;
                byte[] bArrSliceArray = ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i, i + 2));
                BlePMDClient.PmdDataFieldEncoding pmdDataFieldEncoding = BlePMDClient.PmdDataFieldEncoding.SIGNED_INT;
                Object frameDataField = pmdDataFrameUtils.parseFrameDataField(bArrSliceArray, pmdDataFieldEncoding);
                frameDataField.getClass();
                int iIntValue = ((Integer) frameDataField).intValue();
                Object frameDataField2 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i + 3, i + 5)), pmdDataFieldEncoding);
                frameDataField2.getClass();
                int iIntValue2 = ((Integer) frameDataField2).intValue();
                int i3 = i + 6;
                Object frameDataField3 = pmdDataFrameUtils.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), new IntRange(i3, i3)), BlePMDClient.PmdDataFieldEncoding.UNSIGNED_BYTE);
                frameDataField3.getClass();
                i += 7;
                ecgData.getEcgSamples().add(new EcgSampleFrameType3(listM890getTimeStampsx53JL5M.get(i2).getData(), iIntValue, iIntValue2, ((UByte) frameDataField3).getData(), null));
                i2++;
            }
            return ecgData;
        }

        public final EcgData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (frame.getIsCompressedFrame()) {
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by EcgData data parser"));
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
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by EcgData data parser"));
        }

        private Companion() {
        }
    }

    public final List<EcgDataSample> getEcgSamples() {
        return this.ecgSamples;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001a\u0010\u000fR\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgData$EcgSampleFrameType3;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "data0", "data1", "Lkotlin/UByte;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "<init>", "(JIIBLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "I", "getData0", "getData1", "B", "getStatus-w2LRezQ", "()B", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class EcgSampleFrameType3 extends EcgDataSample {
        private final int data0;
        private final int data1;
        private final byte status;
        private final long timeStamp;

        private EcgSampleFrameType3(long j, int i, int i2, byte b) {
            super(null);
            this.timeStamp = j;
            this.data0 = i;
            this.data1 = i2;
            this.status = b;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EcgSampleFrameType3)) {
                return false;
            }
            EcgSampleFrameType3 ecgSampleFrameType3 = (EcgSampleFrameType3) other;
            return this.timeStamp == ecgSampleFrameType3.timeStamp && this.data0 == ecgSampleFrameType3.data0 && this.data1 == ecgSampleFrameType3.data1 && this.status == ecgSampleFrameType3.status;
        }

        public int hashCode() {
            return UByte.m2369hashCodeimpl(this.status) + FileInsert$$ExternalSyntheticOutline0.m(this.data1, FileInsert$$ExternalSyntheticOutline0.m(this.data0, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            int i = this.data0;
            int i2 = this.data1;
            String strM2370toStringimpl = UByte.m2370toStringimpl(this.status);
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, "EcgSampleFrameType3(timeStamp=", strM2414toStringimpl, ", data0=", ", data1=");
            sbM.append(i2);
            sbM.append(", status=");
            sbM.append(strM2370toStringimpl);
            sbM.append(")");
            return sbM.toString();
        }

        public /* synthetic */ EcgSampleFrameType3(long j, int i, int i2, byte b, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i, i2, b);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BK\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b$\u0010\"R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b%\u0010\"\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgData$EcgSample;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/EcgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "microVolts", "", "overSampling", "", "skinContactBit", "contactImpedance", "ecgDataTag", "paceDataTag", "<init>", "(JIZBBBBLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "I", "getMicroVolts", "Z", "getOverSampling", "()Z", "B", "getSkinContactBit", "()B", "getContactImpedance", "getEcgDataTag", "getPaceDataTag", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class EcgSample extends EcgDataSample {
        private final byte contactImpedance;
        private final byte ecgDataTag;
        private final int microVolts;
        private final boolean overSampling;
        private final byte paceDataTag;
        private final byte skinContactBit;
        private final long timeStamp;

        public /* synthetic */ EcgSample(long j, int i, boolean z, byte b, byte b2, byte b3, byte b4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? (byte) 0 : b, (i2 & 16) != 0 ? (byte) 0 : b2, (i2 & 32) != 0 ? (byte) 0 : b3, (i2 & 64) != 0 ? (byte) 0 : b4, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EcgSample)) {
                return false;
            }
            EcgSample ecgSample = (EcgSample) other;
            return this.timeStamp == ecgSample.timeStamp && this.microVolts == ecgSample.microVolts && this.overSampling == ecgSample.overSampling && this.skinContactBit == ecgSample.skinContactBit && this.contactImpedance == ecgSample.contactImpedance && this.ecgDataTag == ecgSample.ecgDataTag && this.paceDataTag == ecgSample.paceDataTag;
        }

        public int hashCode() {
            return Byte.hashCode(this.paceDataTag) + ((Byte.hashCode(this.ecgDataTag) + ((Byte.hashCode(this.contactImpedance) + ((Byte.hashCode(this.skinContactBit) + FileInsert$$ExternalSyntheticOutline0.m(this.overSampling, FileInsert$$ExternalSyntheticOutline0.m(this.microVolts, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            int i = this.microVolts;
            boolean z = this.overSampling;
            byte b = this.skinContactBit;
            byte b2 = this.contactImpedance;
            byte b3 = this.ecgDataTag;
            byte b4 = this.paceDataTag;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, "EcgSample(timeStamp=", strM2414toStringimpl, ", microVolts=", ", overSampling=");
            sbM.append(z);
            sbM.append(", skinContactBit=");
            sbM.append((int) b);
            sbM.append(", contactImpedance=");
            Fragment$$ExternalSyntheticOutline1.m(sbM, b2, ", ecgDataTag=", b3, ", paceDataTag=");
            return FileInsert$$ExternalSyntheticOutline0.m((int) b4, ")", sbM);
        }

        public /* synthetic */ EcgSample(long j, int i, boolean z, byte b, byte b2, byte b3, byte b4, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i, z, b, b2, b3, b4);
        }

        private EcgSample(long j, int i, boolean z, byte b, byte b2, byte b3, byte b4) {
            super(null);
            this.timeStamp = j;
            this.microVolts = i;
            this.overSampling = z;
            this.skinContactBit = b;
            this.contactImpedance = b2;
            this.ecgDataTag = b3;
            this.paceDataTag = b4;
        }
    }
}
