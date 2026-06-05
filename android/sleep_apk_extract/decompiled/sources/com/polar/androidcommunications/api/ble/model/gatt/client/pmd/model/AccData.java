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
import com.polar.androidcommunications.common.ble.TypeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData;", "", "()V", "accSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData$AccSample;", "getAccSamples", "()Ljava/util/List;", "AccSample", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<AccSample> accSamples = new ArrayList();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData$Companion;", "", "()V", "TYPE_0_CHANNELS_IN_SAMPLE", "", "TYPE_0_SAMPLE_SIZE_IN_BITS", "TYPE_0_SAMPLE_SIZE_IN_BYTES", "TYPE_1_CHANNELS_IN_SAMPLE", "TYPE_1_SAMPLE_SIZE_IN_BITS", "TYPE_1_SAMPLE_SIZE_IN_BYTES", "TYPE_2_CHANNELS_IN_SAMPLE", "TYPE_2_SAMPLE_SIZE_IN_BITS", "TYPE_2_SAMPLE_SIZE_IN_BYTES", "dataFromCompressedType0", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "dataFromCompressedType1", "dataFromRawType0", "dataFromRawType1", "dataFromRawType2", "parseDataFromDataFrame", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AccData dataFromCompressedType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            AccData accData = new AccData();
            float factor = frame.getFactor() * 1000.0f;
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 3, 16, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                accData.getAccSamples().add(new AccSample(listM890getTimeStampsx53JL5M.get(i).getData(), (int) (list.get(0).floatValue() * factor), (int) (list.get(1).floatValue() * factor), (int) (list.get(2).floatValue() * factor), null));
                i++;
            }
            return accData;
        }

        private final AccData dataFromCompressedType1(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            AccData accData = new AccData();
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 3, 16, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                int iIntValue = frame.getFactor() == 1.0f ? list.get(0).intValue() : (int) (frame.getFactor() * list.get(0).intValue());
                int iIntValue2 = frame.getFactor() == 1.0f ? list.get(1).intValue() : (int) (frame.getFactor() * list.get(1).intValue());
                float factor = frame.getFactor();
                int iIntValue3 = list.get(2).intValue();
                if (factor != 1.0f) {
                    iIntValue3 = (int) (frame.getFactor() * iIntValue3);
                }
                accData.getAccSamples().add(new AccSample(listM890getTimeStampsx53JL5M.get(i).getData(), iIntValue, iIntValue2, iIntValue3, null));
                i = i2;
            }
            return accData;
        }

        private final AccData dataFromRawType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            AccData accData = new AccData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 3, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                TypeUtils typeUtils = TypeUtils.INSTANCE;
                int iConvertArrayToSignedInt = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i, 1);
                int iConvertArrayToSignedInt2 = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i + 1, 1);
                int iConvertArrayToSignedInt3 = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i + 2, 1);
                i += 3;
                accData.getAccSamples().add(new AccSample(listM890getTimeStampsx53JL5M.get(i2).getData(), iConvertArrayToSignedInt, iConvertArrayToSignedInt2, iConvertArrayToSignedInt3, null));
                i2++;
            }
            return accData;
        }

        private final AccData dataFromRawType1(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            AccData accData = new AccData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 6, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                TypeUtils typeUtils = TypeUtils.INSTANCE;
                int iConvertArrayToSignedInt = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i, 2);
                int iConvertArrayToSignedInt2 = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i + 2, 2);
                int iConvertArrayToSignedInt3 = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i + 4, 2);
                i += 6;
                accData.getAccSamples().add(new AccSample(listM890getTimeStampsx53JL5M.get(i2).getData(), iConvertArrayToSignedInt, iConvertArrayToSignedInt2, iConvertArrayToSignedInt3, null));
                i2++;
            }
            return accData;
        }

        private final AccData dataFromRawType2(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            AccData accData = new AccData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 9, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                TypeUtils typeUtils = TypeUtils.INSTANCE;
                int iConvertArrayToSignedInt = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i, 3);
                int iConvertArrayToSignedInt2 = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i + 3, 3);
                int iConvertArrayToSignedInt3 = typeUtils.convertArrayToSignedInt(frame.getDataContent(), i + 6, 3);
                i += 9;
                accData.getAccSamples().add(new AccSample(listM890getTimeStampsx53JL5M.get(i2).getData(), iConvertArrayToSignedInt, iConvertArrayToSignedInt2, iConvertArrayToSignedInt3, null));
                i2++;
            }
            return accData;
        }

        public final AccData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (frame.getIsCompressedFrame()) {
                int i = WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()];
                if (i == 1) {
                    return dataFromCompressedType0(frame);
                }
                if (i == 2) {
                    return dataFromCompressedType1(frame);
                }
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by ACC data parser"));
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()];
            if (i2 == 1) {
                return dataFromRawType0(frame);
            }
            if (i2 == 2) {
                return dataFromRawType1(frame);
            }
            if (i2 == 3) {
                return dataFromRawType2(frame);
            }
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by ACC data parser"));
        }

        private Companion() {
        }
    }

    public final List<AccSample> getAccSamples() {
        return this.accSamples;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\u0002HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001d\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001e\u0010\u000e\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/AccData$AccSample;", "", "Lkotlin/ULong;", "timeStamp", "", "x", "y", "z", "<init>", "(JIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "component1-s-VKNKU", "()J", "component1", "component2", "()I", "component3", "component4", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "I", "getX", "getY", "getZ", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AccSample {
        private final long timeStamp;
        private final int x;
        private final int y;
        private final int z;

        private AccSample(long j, int i, int i2, int i3) {
            this.timeStamp = j;
            this.x = i;
            this.y = i2;
            this.z = i3;
        }

        /* JADX INFO: renamed from: component1-s-VKNKU, reason: not valid java name and from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getZ() {
            return this.z;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AccSample)) {
                return false;
            }
            AccSample accSample = (AccSample) other;
            return this.timeStamp == accSample.timeStamp && this.x == accSample.x && this.y == accSample.y && this.z == accSample.z;
        }

        public int hashCode() {
            return Integer.hashCode(this.z) + FileInsert$$ExternalSyntheticOutline0.m(this.y, FileInsert$$ExternalSyntheticOutline0.m(this.x, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            int i = this.x;
            int i2 = this.y;
            int i3 = this.z;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i, "AccSample(timeStamp=", strM2414toStringimpl, ", x=", ", y=");
            sbM.append(i2);
            sbM.append(", z=");
            sbM.append(i3);
            sbM.append(")");
            return sbM.toString();
        }

        public /* synthetic */ AccSample(long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i, i2, i3);
        }
    }
}
