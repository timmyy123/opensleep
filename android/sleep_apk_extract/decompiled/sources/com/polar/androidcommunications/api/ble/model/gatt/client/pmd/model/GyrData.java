package com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.exceptions.NegativeTimeStampError;
import com.polar.androidcommunications.api.ble.exceptions.SampleSizeMissingError;
import com.polar.androidcommunications.api.ble.exceptions.TimeStampAndFrequencyZeroError;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.BlePMDClient;
import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GyrData;", "", "()V", "gyrSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GyrData$GyrSample;", "getGyrSamples", "()Ljava/util/List;", "Companion", "GyrSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GyrData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<GyrSample> gyrSamples = new ArrayList();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GyrData$Companion;", "", "()V", "TYPE_0_CHANNELS_IN_SAMPLE", "", "TYPE_0_SAMPLE_SIZE_IN_BITS", "TYPE_0_SAMPLE_SIZE_IN_BYTES", "TYPE_1_CHANNELS_IN_SAMPLE", "TYPE_1_SAMPLE_SIZE_IN_BITS", "TYPE_1_SAMPLE_SIZE_IN_BYTES", "dataFromCompressedType0", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GyrData;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "dataFromCompressedType1", "parseDataFromDataFrame", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GyrData dataFromCompressedType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 3, 16, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            GyrData gyrData = new GyrData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                gyrData.getGyrSamples().add(new GyrSample(listM890getTimeStampsx53JL5M.get(i).getData(), frame.getFactor() == 1.0f ? list.get(0).intValue() : list.get(0).floatValue() * frame.getFactor(), frame.getFactor() == 1.0f ? list.get(1).intValue() : list.get(1).floatValue() * frame.getFactor(), frame.getFactor() == 1.0f ? r6.intValue() : list.get(2).floatValue() * frame.getFactor(), null));
                i = i2;
            }
            return gyrData;
        }

        private final GyrData dataFromCompressedType1(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 3, 32, BlePMDClient.PmdDataFieldEncoding.FLOAT_IEEE754);
            GyrData gyrData = new GyrData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                float fIntBitsToFloat = frame.getFactor() == 1.0f ? Float.intBitsToFloat(list.get(0).intValue()) : Float.intBitsToFloat(list.get(0).intValue()) * frame.getFactor();
                float fIntBitsToFloat2 = frame.getFactor() == 1.0f ? Float.intBitsToFloat(list.get(1).intValue()) : Float.intBitsToFloat(list.get(1).intValue()) * frame.getFactor();
                float factor = frame.getFactor();
                float fIntBitsToFloat3 = Float.intBitsToFloat(list.get(2).intValue());
                if (factor != 1.0f) {
                    fIntBitsToFloat3 *= frame.getFactor();
                }
                gyrData.getGyrSamples().add(new GyrSample(listM890getTimeStampsx53JL5M.get(i).getData(), fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, null));
                i = i2;
            }
            return gyrData;
        }

        public final GyrData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (!frame.getIsCompressedFrame()) {
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by Gyro data parser"));
            }
            int i = WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()];
            if (i == 1) {
                return dataFromCompressedType0(frame);
            }
            if (i == 2) {
                return dataFromCompressedType1(frame);
            }
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by Gyro data parser"));
        }

        private Companion() {
        }
    }

    public final List<GyrSample> getGyrSamples() {
        return this.gyrSamples;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/GyrData$GyrSample;", "", "Lkotlin/ULong;", "timeStamp", "", "x", "y", "z", "<init>", "(JFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "F", "getX", "()F", "getY", "getZ", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class GyrSample {
        private final long timeStamp;
        private final float x;
        private final float y;
        private final float z;

        private GyrSample(long j, float f, float f2, float f3) {
            this.timeStamp = j;
            this.x = f;
            this.y = f2;
            this.z = f3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GyrSample)) {
                return false;
            }
            GyrSample gyrSample = (GyrSample) other;
            return this.timeStamp == gyrSample.timeStamp && Float.compare(this.x, gyrSample.x) == 0 && Float.compare(this.y, gyrSample.y) == 0 && Float.compare(this.z, gyrSample.z) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.z) + Fragment$$ExternalSyntheticOutline1.m(this.y, Fragment$$ExternalSyntheticOutline1.m(this.x, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31);
        }

        public String toString() {
            return "GyrSample(timeStamp=" + ULong.m2414toStringimpl(this.timeStamp) + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ")";
        }

        public /* synthetic */ GyrSample(long j, float f, float f2, float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, f, f2, f3);
        }
    }
}
