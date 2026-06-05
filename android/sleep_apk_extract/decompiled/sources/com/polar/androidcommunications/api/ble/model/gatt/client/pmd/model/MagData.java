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
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0003\b\t\nB\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData;", "", "()V", "magSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$MagSample;", "getMagSamples", "()Ljava/util/List;", "CalibrationStatus", "Companion", "MagSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MagData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<MagSample> magSamples = new ArrayList();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$CalibrationStatus;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "NOT_AVAILABLE", "UNKNOWN", "POOR", "OK", "GOOD", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CalibrationStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CalibrationStatus[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int id;
        public static final CalibrationStatus NOT_AVAILABLE = new CalibrationStatus("NOT_AVAILABLE", 0, -1);
        public static final CalibrationStatus UNKNOWN = new CalibrationStatus("UNKNOWN", 1, 0);
        public static final CalibrationStatus POOR = new CalibrationStatus("POOR", 2, 1);
        public static final CalibrationStatus OK = new CalibrationStatus("OK", 3, 2);
        public static final CalibrationStatus GOOD = new CalibrationStatus("GOOD", 4, 3);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$CalibrationStatus$Companion;", "", "()V", "getById", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$CalibrationStatus;", "id", "", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final CalibrationStatus getById(int id) {
                try {
                    for (CalibrationStatus calibrationStatus : CalibrationStatus.values()) {
                        if (calibrationStatus.getId() == id) {
                            return calibrationStatus;
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                } catch (NoSuchElementException unused) {
                    return CalibrationStatus.NOT_AVAILABLE;
                }
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ CalibrationStatus[] $values() {
            return new CalibrationStatus[]{NOT_AVAILABLE, UNKNOWN, POOR, OK, GOOD};
        }

        static {
            CalibrationStatus[] calibrationStatusArr$values = $values();
            $VALUES = calibrationStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(calibrationStatusArr$values);
            INSTANCE = new Companion(null);
        }

        private CalibrationStatus(String str, int i, int i2) {
            this.id = i2;
        }

        public static CalibrationStatus valueOf(String str) {
            return (CalibrationStatus) Enum.valueOf(CalibrationStatus.class, str);
        }

        public static CalibrationStatus[] values() {
            return (CalibrationStatus[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$Companion;", "", "()V", "TYPE_0_CHANNELS_IN_SAMPLE", "", "TYPE_0_SAMPLE_SIZE_IN_BITS", "TYPE_0_SAMPLE_SIZE_IN_BYTES", "TYPE_1_CHANNELS_IN_SAMPLE", "TYPE_1_SAMPLE_SIZE_IN_BITS", "TYPE_1_SAMPLE_SIZE_IN_BYTES", "dataCompressedFromType0", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "dataCompressedFromType1", "parseDataFromDataFrame", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private final MagData dataCompressedFromType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 3, 16, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            MagData magData = new MagData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                magData.getMagSamples().add(new MagSample(listM890getTimeStampsx53JL5M.get(i).getData(), frame.getFactor() == 1.0f ? list.get(0).intValue() : list.get(0).floatValue() * frame.getFactor(), frame.getFactor() == 1.0f ? list.get(1).intValue() : list.get(1).floatValue() * frame.getFactor(), frame.getFactor() == 1.0f ? r6.intValue() : list.get(2).floatValue() * frame.getFactor(), null, 16, null));
                i = i2;
            }
            return magData;
        }

        private final MagData dataCompressedFromType1(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 4, 16, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            MagData magData = new MagData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                magData.getMagSamples().add(new MagSample(listM890getTimeStampsx53JL5M.get(i).getData(), (frame.getFactor() == 1.0f ? list.get(0).intValue() : list.get(0).floatValue() * frame.getFactor()) / 1000.0f, (frame.getFactor() == 1.0f ? list.get(1).intValue() : list.get(1).floatValue() * frame.getFactor()) / 1000.0f, (frame.getFactor() == 1.0f ? list.get(2).intValue() : list.get(2).floatValue() * frame.getFactor()) / 1000.0f, CalibrationStatus.INSTANCE.getById(list.get(3).intValue()), null));
                i = i2;
            }
            return magData;
        }

        public final MagData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (!frame.getIsCompressedFrame()) {
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by Magnetometer data parser"));
            }
            int i = WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()];
            if (i == 1) {
                return dataCompressedFromType0(frame);
            }
            if (i == 2) {
                return dataCompressedFromType1(frame);
            }
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by Magnetometer data parser"));
        }

        private Companion() {
        }
    }

    public final List<MagSample> getMagSamples() {
        return this.magSamples;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B5\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$MagSample;", "", "Lkotlin/ULong;", "timeStamp", "", "x", "y", "z", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$CalibrationStatus;", "calibrationStatus", "<init>", "(JFFFLcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$CalibrationStatus;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "F", "getX", "()F", "getY", "getZ", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$CalibrationStatus;", "getCalibrationStatus", "()Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/MagData$CalibrationStatus;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class MagSample {
        private final CalibrationStatus calibrationStatus;
        private final long timeStamp;
        private final float x;
        private final float y;
        private final float z;

        public /* synthetic */ MagSample(long j, float f, float f2, float f3, CalibrationStatus calibrationStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, f, f2, f3, (i & 16) != 0 ? CalibrationStatus.NOT_AVAILABLE : calibrationStatus, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MagSample)) {
                return false;
            }
            MagSample magSample = (MagSample) other;
            return this.timeStamp == magSample.timeStamp && Float.compare(this.x, magSample.x) == 0 && Float.compare(this.y, magSample.y) == 0 && Float.compare(this.z, magSample.z) == 0 && this.calibrationStatus == magSample.calibrationStatus;
        }

        public int hashCode() {
            return this.calibrationStatus.hashCode() + Fragment$$ExternalSyntheticOutline1.m(this.z, Fragment$$ExternalSyntheticOutline1.m(this.y, Fragment$$ExternalSyntheticOutline1.m(this.x, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31), 31);
        }

        public String toString() {
            return "MagSample(timeStamp=" + ULong.m2414toStringimpl(this.timeStamp) + ", x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", calibrationStatus=" + this.calibrationStatus + ")";
        }

        private MagSample(long j, float f, float f2, float f3, CalibrationStatus calibrationStatus) {
            calibrationStatus.getClass();
            this.timeStamp = j;
            this.x = f;
            this.y = f2;
            this.z = f3;
            this.calibrationStatus = calibrationStatus;
        }

        public /* synthetic */ MagSample(long j, float f, float f2, float f3, CalibrationStatus calibrationStatus, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, f, f2, f3, calibrationStatus);
        }
    }
}
