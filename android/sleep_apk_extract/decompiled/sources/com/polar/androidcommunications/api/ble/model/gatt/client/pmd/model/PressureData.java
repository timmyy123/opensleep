package com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.exceptions.NegativeTimeStampError;
import com.polar.androidcommunications.api.ble.exceptions.SampleSizeMissingError;
import com.polar.androidcommunications.api.ble.exceptions.TimeStampAndFrequencyZeroError;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrameUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PressureData;", "", "()V", "pressureSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PressureData$PressureSample;", "getPressureSamples", "()Ljava/util/List;", "Companion", "PressureSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PressureData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<PressureSample> pressureSamples = new ArrayList();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PressureData$Companion;", "", "()V", "TYPE_0_CHANNELS_IN_SAMPLE", "", "TYPE_0_SAMPLE_SIZE_IN_BITS", "TYPE_0_SAMPLE_SIZE_IN_BYTES", "dataFromCompressedType0", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PressureData;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "dataFromRawType0", "parseDataFromDataFrame", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PressureData dataFromCompressedType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PressureData pressureData = new PressureData();
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 1, 32, BlePMDClient.PmdDataFieldEncoding.FLOAT_IEEE754);
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                float factor = frame.getFactor();
                float fIntBitsToFloat = Float.intBitsToFloat(list.get(0).intValue());
                if (factor != 1.0f) {
                    fIntBitsToFloat *= frame.getFactor();
                }
                pressureData.getPressureSamples().add(new PressureSample(listM890getTimeStampsx53JL5M.get(i).getData(), fIntBitsToFloat, null));
                i = i2;
            }
            return pressureData;
        }

        private final PressureData dataFromRawType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PressureData pressureData = new PressureData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 4, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                int i3 = i + 4;
                Object frameDataField = PmdDataFrameUtils.INSTANCE.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i, i3)), BlePMDClient.PmdDataFieldEncoding.FLOAT_IEEE754);
                frameDataField.getClass();
                pressureData.getPressureSamples().add(new PressureSample(listM890getTimeStampsx53JL5M.get(i2).getData(), ((Float) frameDataField).floatValue(), null));
                i2++;
                i = i3;
            }
            return pressureData;
        }

        public final PressureData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (frame.getIsCompressedFrame()) {
                if (WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()] == 1) {
                    return dataFromCompressedType0(frame);
                }
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by Pressure data parser"));
            }
            if (WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()] == 1) {
                return dataFromRawType0(frame);
            }
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by Pressure data parser"));
        }

        private Companion() {
        }
    }

    public final List<PressureSample> getPressureSamples() {
        return this.pressureSamples;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PressureData$PressureSample;", "", "Lkotlin/ULong;", "timeStamp", "", "pressure", "<init>", "(JFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "F", "getPressure", "()F", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PressureSample {
        private final float pressure;
        private final long timeStamp;

        private PressureSample(long j, float f) {
            this.timeStamp = j;
            this.pressure = f;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PressureSample)) {
                return false;
            }
            PressureSample pressureSample = (PressureSample) other;
            return this.timeStamp == pressureSample.timeStamp && Float.compare(this.pressure, pressureSample.pressure) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.pressure) + (ULong.m2413hashCodeimpl(this.timeStamp) * 31);
        }

        public String toString() {
            return "PressureSample(timeStamp=" + ULong.m2414toStringimpl(this.timeStamp) + ", pressure=" + this.pressure + ")";
        }

        public /* synthetic */ PressureSample(long j, float f, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, f);
        }
    }
}
