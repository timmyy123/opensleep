package com.polar.androidcommunications.api.ble.model.gatt.client.pmd.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \b2\u00020\u0001:\t\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData;", "", "()V", "ppgSamples", "", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "getPpgSamples", "()Ljava/util/List;", "Companion", "PpgDataFrameType0", "PpgDataFrameType10", "PpgDataFrameType4", "PpgDataFrameType5", "PpgDataFrameType7", "PpgDataFrameType8", "PpgDataFrameType9", "PpgDataSampleSportId", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PpgData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<PpgDataSample> ppgSamples = new ArrayList();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0015\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0014\u0010\u001d\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0014\u0010 \u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010!\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010$\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010%\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u0017R\u0014\u0010&\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u0017R\u0014\u0010'\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0017R\u0014\u0010(\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0017R\u0014\u0010)\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0017R\u0014\u0010*\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0017R\u0014\u0010+\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\u0017¨\u0006,"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$Companion;", "", "<init>", "()V", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "frame", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData;", "dataFromRawType0", "(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;)Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData;", "dataFromRawType4", "dataFromRawType5", "dataFromRawType6", "dataFromRawType9", "dataFromCompressedType0", "dataFromCompressedType7", "dataFromCompressedType8", "dataFromCompressedType10", "parseDataFromDataFrame", "", "TAG", "Ljava/lang/String;", "", "TYPE_0_CHANNELS_IN_SAMPLE", "I", "TYPE_0_SAMPLE_SIZE_IN_BITS", "TYPE_0_SAMPLE_SIZE_IN_BYTES", "TYPE_10_CHANNELS_IN_SAMPLE", "TYPE_10_SAMPLE_SIZE_IN_BITS", "TYPE_10_SAMPLE_SIZE_IN_BYTES", "TYPE_10_STATUS_SIZE", "TYPE_4_CHANNEL_0_AND_1_SIZE", "TYPE_4_NUM_INTS_SIZE", "TYPE_4_SAMPLE_SIZE_IN_BYTES", "TYPE_5_SAMPLE_SIZE_IN_BYTES", "TYPE_6_SAMPLE_SIZE_IN_BYTES", "TYPE_7_CHANNELS_IN_SAMPLE", "TYPE_7_SAMPLE_SIZE_IN_BITS", "TYPE_7_SAMPLE_SIZE_IN_BYTES", "TYPE_8_CHANNELS_IN_SAMPLE", "TYPE_8_SAMPLE_SIZE_IN_BITS", "TYPE_8_SAMPLE_SIZE_IN_BYTES", "TYPE_9_CHANNEL_0_AND_1_SIZE", "TYPE_9_NUM_INTS_SIZE", "TYPE_9_SAMPLE_SIZE_IN_BYTES", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_7.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_8.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_10.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_4.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_5.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_6.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[PmdDataFrame.PmdDataFrameType.TYPE_9.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final PpgData dataFromCompressedType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 4, 24, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                ppgData.getPpgSamples().add(new PpgDataFrameType0(listM890getTimeStampsx53JL5M.get(i).getData(), CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) (frame.getFactor() * list.get(0).intValue())), Integer.valueOf((int) (frame.getFactor() * list.get(1).intValue())), Integer.valueOf((int) (frame.getFactor() * list.get(2).intValue()))}), (int) (frame.getFactor() * list.get(3).intValue()), null));
                i++;
            }
            return ppgData;
        }

        private final PpgData dataFromCompressedType10(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 21, 24, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                List<Integer> listSubList = list.subList(0, 8);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
                Iterator<T> it = listSubList.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (frame.getFactor() != 1.0f) {
                        iIntValue = (int) (frame.getFactor() * iIntValue);
                    }
                    arrayList.add(Integer.valueOf(iIntValue));
                }
                List<Integer> listSubList2 = list.subList(8, 14);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList2, 10));
                Iterator<T> it2 = listSubList2.iterator();
                while (it2.hasNext()) {
                    int iIntValue2 = ((Number) it2.next()).intValue();
                    if (frame.getFactor() != 1.0f) {
                        iIntValue2 = (int) (frame.getFactor() * iIntValue2);
                    }
                    arrayList2.add(Integer.valueOf(iIntValue2));
                }
                List<Integer> listSubList3 = list.subList(14, 20);
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList3, 10));
                Iterator<T> it3 = listSubList3.iterator();
                while (it3.hasNext()) {
                    int iIntValue3 = ((Number) it3.next()).intValue();
                    if (frame.getFactor() != 1.0f) {
                        iIntValue3 = (int) (frame.getFactor() * iIntValue3);
                    }
                    arrayList3.add(Integer.valueOf(iIntValue3));
                }
                ppgData.getPpgSamples().add(new PpgDataFrameType10(listM890getTimeStampsx53JL5M.get(i).getData(), arrayList2, arrayList, arrayList3, ((Number) CollectionsKt.last((List) list)).intValue(), null));
                i = i2;
            }
            return ppgData;
        }

        private final PpgData dataFromCompressedType7(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 17, 24, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                List<Integer> listSubList = list.subList(0, 16);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
                Iterator<T> it = listSubList.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (frame.getFactor() != 1.0f) {
                        iIntValue = (int) (frame.getFactor() * iIntValue);
                    }
                    arrayList.add(Integer.valueOf(iIntValue));
                }
                ppgData.getPpgSamples().add(new PpgDataFrameType7(listM890getTimeStampsx53JL5M.get(i).getData(), arrayList, UInt.m2389constructorimpl(list.get(16).intValue() & 16777215), null));
                i = i2;
            }
            return ppgData;
        }

        private final PpgData dataFromCompressedType8(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<List<Integer>> deltaFramesAll = BlePMDClient.INSTANCE.parseDeltaFramesAll(frame.getDataContent(), 25, 24, BlePMDClient.PmdDataFieldEncoding.SIGNED_INT);
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), deltaFramesAll.size(), frame.getSampleRate());
            int i = 0;
            for (List<Integer> list : deltaFramesAll) {
                int i2 = i + 1;
                List<Integer> listSubList = list.subList(0, 24);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
                Iterator<T> it = listSubList.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (frame.getFactor() != 1.0f) {
                        iIntValue = (int) (frame.getFactor() * iIntValue);
                    }
                    arrayList.add(Integer.valueOf(iIntValue));
                }
                ppgData.getPpgSamples().add(new PpgDataFrameType8(listM890getTimeStampsx53JL5M.get(i).getData(), arrayList, UInt.m2389constructorimpl(list.get(24).intValue() & 16777215), null));
                i = i2;
            }
            return ppgData;
        }

        private final PpgData dataFromRawType0(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 12, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < 4; i3++) {
                    arrayList.add(Integer.valueOf(TypeUtils.INSTANCE.convertArrayToSignedInt(frame.getDataContent(), i, 3)));
                    i += 3;
                }
                ppgData.getPpgSamples().add(new PpgDataFrameType0(listM890getTimeStampsx53JL5M.get(i2).getData(), arrayList.subList(0, 3), ((Number) arrayList.get(3)).intValue(), null));
                i2++;
            }
            return ppgData;
        }

        private final PpgData dataFromRawType4(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 36, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                int i3 = i + 12;
                byte[] bArrSliceArray = ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i, i3));
                ArrayList arrayList = new ArrayList(bArrSliceArray.length);
                for (byte b : bArrSliceArray) {
                    arrayList.add(UInt.m2388boximpl(UInt.m2389constructorimpl(UByte.m2367constructorimpl(b) & 255)));
                }
                i += 36;
                List<Byte> list = ArraysKt.toList(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i3, i)));
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = list.iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    UInt uIntM2388boximpl = i4 % 2 == 0 ? UInt.m2388boximpl(UInt.m2389constructorimpl((byte) (((Number) next).byteValue() & 7))) : null;
                    if (uIntM2388boximpl != null) {
                        arrayList2.add(uIntM2388boximpl);
                    }
                    i4 = i5;
                }
                List<Byte> list2 = ArraysKt.toList(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i3, i)));
                ArrayList arrayList3 = new ArrayList();
                int i6 = 0;
                for (Object obj : list2) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    UInt uIntM2388boximpl2 = i6 % 2 == 1 ? UInt.m2388boximpl(UInt.m2389constructorimpl((byte) (((Number) obj).byteValue() & 7))) : null;
                    if (uIntM2388boximpl2 != null) {
                        arrayList3.add(uIntM2388boximpl2);
                    }
                    i6 = i7;
                }
                ppgData.getPpgSamples().add(new PpgDataFrameType4(listM890getTimeStampsx53JL5M.get(i2).getData(), arrayList, arrayList2, arrayList3, null));
                i2++;
            }
            return ppgData;
        }

        private final PpgData dataFromRawType5(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 4, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                int i3 = i + 4;
                Object frameDataField = PmdDataFrameUtils.INSTANCE.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i, i3)), BlePMDClient.PmdDataFieldEncoding.UNSIGNED_INT);
                frameDataField.getClass();
                ppgData.getPpgSamples().add(new PpgDataFrameType5(listM890getTimeStampsx53JL5M.get(i2).getData(), ((UInt) frameDataField).getData(), null));
                i2++;
                i = i3;
            }
            return ppgData;
        }

        private final PpgData dataFromRawType6(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            Object frameDataField = PmdDataFrameUtils.INSTANCE.parseFrameDataField(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(0, 8)), BlePMDClient.PmdDataFieldEncoding.UNSIGNED_LONG);
            frameDataField.getClass();
            ppgData.getPpgSamples().add(new PpgDataSampleSportId(((ULong) CollectionsKt.first((List) PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 8, frame.getSampleRate()))).getData(), ((ULong) frameDataField).getData(), null));
            return ppgData;
        }

        private final PpgData dataFromRawType9(PmdDataFrame frame) throws SampleSizeMissingError, NegativeTimeStampError, TimeStampAndFrequencyZeroError {
            PpgData ppgData = new PpgData();
            List<ULong> listM890getTimeStampsx53JL5M = PmdTimeStampUtils.INSTANCE.m890getTimeStampsx53JL5M(frame.getPreviousTimeStamp(), frame.getTimeStamp(), frame.getDataContent().length / 36, frame.getSampleRate());
            int i = 0;
            int i2 = 0;
            while (i < frame.getDataContent().length) {
                int i3 = i + 12;
                byte[] bArrSliceArray = ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i, i3));
                ArrayList arrayList = new ArrayList(bArrSliceArray.length);
                for (byte b : bArrSliceArray) {
                    arrayList.add(UInt.m2388boximpl(UInt.m2389constructorimpl(UByte.m2367constructorimpl(b) & 255)));
                }
                i += 36;
                List<Byte> list = ArraysKt.toList(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i3, i)));
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = list.iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    UInt uIntM2388boximpl = i4 % 2 == 0 ? UInt.m2388boximpl(UInt.m2389constructorimpl((byte) (((Number) next).byteValue() & 7))) : null;
                    if (uIntM2388boximpl != null) {
                        arrayList2.add(uIntM2388boximpl);
                    }
                    i4 = i5;
                }
                List<Byte> list2 = ArraysKt.toList(ArraysKt.sliceArray(frame.getDataContent(), RangesKt.until(i3, i)));
                ArrayList arrayList3 = new ArrayList();
                int i6 = 0;
                for (Object obj : list2) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    UInt uIntM2388boximpl2 = i6 % 2 == 1 ? UInt.m2388boximpl(UInt.m2389constructorimpl((byte) (((Number) obj).byteValue() & 7))) : null;
                    if (uIntM2388boximpl2 != null) {
                        arrayList3.add(uIntM2388boximpl2);
                    }
                    i6 = i7;
                }
                ppgData.getPpgSamples().add(new PpgDataFrameType9(listM890getTimeStampsx53JL5M.get(i2).getData(), arrayList, arrayList2, arrayList3, null));
                i2++;
            }
            return ppgData;
        }

        public final PpgData parseDataFromDataFrame(PmdDataFrame frame) throws Exception {
            frame.getClass();
            if (frame.getIsCompressedFrame()) {
                int i = WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()];
                if (i == 1) {
                    return dataFromCompressedType0(frame);
                }
                if (i == 2) {
                    return dataFromCompressedType7(frame);
                }
                if (i == 3) {
                    return dataFromCompressedType8(frame);
                }
                if (i == 4) {
                    return dataFromCompressedType10(frame);
                }
                throw new Exception(zza$$ExternalSyntheticOutline0.m("Compressed FrameType: ", frame.getFrameType(), " is not supported by PPG data parser"));
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[frame.getFrameType().ordinal()];
            if (i2 == 1) {
                return dataFromRawType0(frame);
            }
            if (i2 == 5) {
                return dataFromRawType4(frame);
            }
            if (i2 == 6) {
                return dataFromRawType5(frame);
            }
            if (i2 == 7) {
                return dataFromRawType6(frame);
            }
            if (i2 == 8) {
                return dataFromRawType9(frame);
            }
            throw new Exception(zza$$ExternalSyntheticOutline0.m("Raw FrameType: ", frame.getFrameType(), " is not supported by PPG data parser"));
        }

        private Companion() {
        }
    }

    public final List<PpgDataSample> getPpgSamples() {
        return this.ppgSamples;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataFrameType5;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "Lkotlin/UInt;", "operationMode", "<init>", "(JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "I", "getOperationMode-pVg5ArA", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataFrameType5 extends PpgDataSample {
        private final int operationMode;
        private final long timeStamp;

        private PpgDataFrameType5(long j, int i) {
            super(null);
            this.timeStamp = j;
            this.operationMode = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataFrameType5)) {
                return false;
            }
            PpgDataFrameType5 ppgDataFrameType5 = (PpgDataFrameType5) other;
            return this.timeStamp == ppgDataFrameType5.timeStamp && this.operationMode == ppgDataFrameType5.operationMode;
        }

        public int hashCode() {
            return UInt.m2391hashCodeimpl(this.operationMode) + (ULong.m2413hashCodeimpl(this.timeStamp) * 31);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("PpgDataFrameType5(timeStamp=", ULong.m2414toStringimpl(this.timeStamp), ", operationMode=", UInt.m2392toStringimpl(this.operationMode), ")");
        }

        public /* synthetic */ PpgDataFrameType5(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, i);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataSampleSportId;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "sportId", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "getSportId-s-VKNKU", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataSampleSportId extends PpgDataSample {
        private final long sportId;
        private final long timeStamp;

        private PpgDataSampleSportId(long j, long j2) {
            super(null);
            this.timeStamp = j;
            this.sportId = j2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataSampleSportId)) {
                return false;
            }
            PpgDataSampleSportId ppgDataSampleSportId = (PpgDataSampleSportId) other;
            return this.timeStamp == ppgDataSampleSportId.timeStamp && this.sportId == ppgDataSampleSportId.sportId;
        }

        public int hashCode() {
            return ULong.m2413hashCodeimpl(this.sportId) + (ULong.m2413hashCodeimpl(this.timeStamp) * 31);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("PpgDataSampleSportId(timeStamp=", ULong.m2414toStringimpl(this.timeStamp), ", sportId=", ULong.m2414toStringimpl(this.sportId), ")");
        }

        public /* synthetic */ PpgDataSampleSportId(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataFrameType0;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "", "ppgDataSamples", "ambientSample", "<init>", "(JLjava/util/List;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "Ljava/util/List;", "getPpgDataSamples", "()Ljava/util/List;", "I", "getAmbientSample", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataFrameType0 extends PpgDataSample {
        private final int ambientSample;
        private final List<Integer> ppgDataSamples;
        private final long timeStamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private PpgDataFrameType0(long j, List<Integer> list, int i) {
            super(null);
            list.getClass();
            this.timeStamp = j;
            this.ppgDataSamples = list;
            this.ambientSample = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataFrameType0)) {
                return false;
            }
            PpgDataFrameType0 ppgDataFrameType0 = (PpgDataFrameType0) other;
            return this.timeStamp == ppgDataFrameType0.timeStamp && Intrinsics.areEqual(this.ppgDataSamples, ppgDataFrameType0.ppgDataSamples) && this.ambientSample == ppgDataFrameType0.ambientSample;
        }

        public int hashCode() {
            return Integer.hashCode(this.ambientSample) + FileInsert$$ExternalSyntheticOutline0.m((List) this.ppgDataSamples, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            List<Integer> list = this.ppgDataSamples;
            int i = this.ambientSample;
            StringBuilder sb = new StringBuilder("PpgDataFrameType0(timeStamp=");
            sb.append(strM2414toStringimpl);
            sb.append(", ppgDataSamples=");
            sb.append(list);
            sb.append(", ambientSample=");
            return FileInsert$$ExternalSyntheticOutline0.m(i, ")", sb);
        }

        public /* synthetic */ PpgDataFrameType0(long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, i);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataFrameType7;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "", "ppgDataSamples", "Lkotlin/UInt;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "<init>", "(JLjava/util/List;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "Ljava/util/List;", "getPpgDataSamples", "()Ljava/util/List;", "I", "getStatus-pVg5ArA", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataFrameType7 extends PpgDataSample {
        private final List<Integer> ppgDataSamples;
        private final int status;
        private final long timeStamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private PpgDataFrameType7(long j, List<Integer> list, int i) {
            super(null);
            list.getClass();
            this.timeStamp = j;
            this.ppgDataSamples = list;
            this.status = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataFrameType7)) {
                return false;
            }
            PpgDataFrameType7 ppgDataFrameType7 = (PpgDataFrameType7) other;
            return this.timeStamp == ppgDataFrameType7.timeStamp && Intrinsics.areEqual(this.ppgDataSamples, ppgDataFrameType7.ppgDataSamples) && this.status == ppgDataFrameType7.status;
        }

        public int hashCode() {
            return UInt.m2391hashCodeimpl(this.status) + FileInsert$$ExternalSyntheticOutline0.m((List) this.ppgDataSamples, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            List<Integer> list = this.ppgDataSamples;
            String strM2392toStringimpl = UInt.m2392toStringimpl(this.status);
            StringBuilder sb = new StringBuilder("PpgDataFrameType7(timeStamp=");
            sb.append(strM2414toStringimpl);
            sb.append(", ppgDataSamples=");
            sb.append(list);
            sb.append(", status=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, strM2392toStringimpl, ")");
        }

        public /* synthetic */ PpgDataFrameType7(long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, i);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataFrameType8;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "", "ppgDataSamples", "Lkotlin/UInt;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "<init>", "(JLjava/util/List;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "Ljava/util/List;", "getPpgDataSamples", "()Ljava/util/List;", "I", "getStatus-pVg5ArA", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataFrameType8 extends PpgDataSample {
        private final List<Integer> ppgDataSamples;
        private final int status;
        private final long timeStamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private PpgDataFrameType8(long j, List<Integer> list, int i) {
            super(null);
            list.getClass();
            this.timeStamp = j;
            this.ppgDataSamples = list;
            this.status = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataFrameType8)) {
                return false;
            }
            PpgDataFrameType8 ppgDataFrameType8 = (PpgDataFrameType8) other;
            return this.timeStamp == ppgDataFrameType8.timeStamp && Intrinsics.areEqual(this.ppgDataSamples, ppgDataFrameType8.ppgDataSamples) && this.status == ppgDataFrameType8.status;
        }

        public int hashCode() {
            return UInt.m2391hashCodeimpl(this.status) + FileInsert$$ExternalSyntheticOutline0.m((List) this.ppgDataSamples, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            List<Integer> list = this.ppgDataSamples;
            String strM2392toStringimpl = UInt.m2392toStringimpl(this.status);
            StringBuilder sb = new StringBuilder("PpgDataFrameType8(timeStamp=");
            sb.append(strM2414toStringimpl);
            sb.append(", ppgDataSamples=");
            sb.append(list);
            sb.append(", status=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, strM2392toStringimpl, ")");
        }

        public /* synthetic */ PpgDataFrameType8(long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, i);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B;\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataFrameType4;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "Lkotlin/UInt;", "numIntTs", "channel1GainTs", "channel2GainTs", "<init>", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "Ljava/util/List;", "getNumIntTs", "()Ljava/util/List;", "getChannel1GainTs", "getChannel2GainTs", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataFrameType4 extends PpgDataSample {
        private final List<UInt> channel1GainTs;
        private final List<UInt> channel2GainTs;
        private final List<UInt> numIntTs;
        private final long timeStamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private PpgDataFrameType4(long j, List<UInt> list, List<UInt> list2, List<UInt> list3) {
            super(null);
            list.getClass();
            list2.getClass();
            list3.getClass();
            this.timeStamp = j;
            this.numIntTs = list;
            this.channel1GainTs = list2;
            this.channel2GainTs = list3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataFrameType4)) {
                return false;
            }
            PpgDataFrameType4 ppgDataFrameType4 = (PpgDataFrameType4) other;
            return this.timeStamp == ppgDataFrameType4.timeStamp && Intrinsics.areEqual(this.numIntTs, ppgDataFrameType4.numIntTs) && Intrinsics.areEqual(this.channel1GainTs, ppgDataFrameType4.channel1GainTs) && Intrinsics.areEqual(this.channel2GainTs, ppgDataFrameType4.channel2GainTs);
        }

        public int hashCode() {
            return this.channel2GainTs.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) this.channel1GainTs, FileInsert$$ExternalSyntheticOutline0.m((List) this.numIntTs, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31);
        }

        public String toString() {
            return "PpgDataFrameType4(timeStamp=" + ULong.m2414toStringimpl(this.timeStamp) + ", numIntTs=" + this.numIntTs + ", channel1GainTs=" + this.channel1GainTs + ", channel2GainTs=" + this.channel2GainTs + ")";
        }

        public /* synthetic */ PpgDataFrameType4(long j, List list, List list2, List list3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, list2, list3);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B;\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataFrameType9;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "Lkotlin/UInt;", "numIntTs", "channel1GainTs", "channel2GainTs", "<init>", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "Ljava/util/List;", "getNumIntTs", "()Ljava/util/List;", "getChannel1GainTs", "getChannel2GainTs", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataFrameType9 extends PpgDataSample {
        private final List<UInt> channel1GainTs;
        private final List<UInt> channel2GainTs;
        private final List<UInt> numIntTs;
        private final long timeStamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private PpgDataFrameType9(long j, List<UInt> list, List<UInt> list2, List<UInt> list3) {
            super(null);
            list.getClass();
            list2.getClass();
            list3.getClass();
            this.timeStamp = j;
            this.numIntTs = list;
            this.channel1GainTs = list2;
            this.channel2GainTs = list3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataFrameType9)) {
                return false;
            }
            PpgDataFrameType9 ppgDataFrameType9 = (PpgDataFrameType9) other;
            return this.timeStamp == ppgDataFrameType9.timeStamp && Intrinsics.areEqual(this.numIntTs, ppgDataFrameType9.numIntTs) && Intrinsics.areEqual(this.channel1GainTs, ppgDataFrameType9.channel1GainTs) && Intrinsics.areEqual(this.channel2GainTs, ppgDataFrameType9.channel2GainTs);
        }

        public int hashCode() {
            return this.channel2GainTs.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) this.channel1GainTs, FileInsert$$ExternalSyntheticOutline0.m((List) this.numIntTs, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31);
        }

        public String toString() {
            return "PpgDataFrameType9(timeStamp=" + ULong.m2414toStringimpl(this.timeStamp) + ", numIntTs=" + this.numIntTs + ", channel1GainTs=" + this.channel1GainTs + ", channel2GainTs=" + this.channel2GainTs + ")";
        }

        public /* synthetic */ PpgDataFrameType9(long j, List list, List list2, List list3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, list2, list3);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgData$PpgDataFrameType10;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/model/PpgDataSample;", "Lkotlin/ULong;", "timeStamp", "", "", "greenSamples", "redSamples", "irSamples", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "<init>", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimeStamp-s-VKNKU", "()J", "Ljava/util/List;", "getGreenSamples", "()Ljava/util/List;", "getRedSamples", "getIrSamples", "I", "getStatus", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PpgDataFrameType10 extends PpgDataSample {
        private final List<Integer> greenSamples;
        private final List<Integer> irSamples;
        private final List<Integer> redSamples;
        private final int status;
        private final long timeStamp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private PpgDataFrameType10(long j, List<Integer> list, List<Integer> list2, List<Integer> list3, int i) {
            super(null);
            list.getClass();
            list2.getClass();
            list3.getClass();
            this.timeStamp = j;
            this.greenSamples = list;
            this.redSamples = list2;
            this.irSamples = list3;
            this.status = i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PpgDataFrameType10)) {
                return false;
            }
            PpgDataFrameType10 ppgDataFrameType10 = (PpgDataFrameType10) other;
            return this.timeStamp == ppgDataFrameType10.timeStamp && Intrinsics.areEqual(this.greenSamples, ppgDataFrameType10.greenSamples) && Intrinsics.areEqual(this.redSamples, ppgDataFrameType10.redSamples) && Intrinsics.areEqual(this.irSamples, ppgDataFrameType10.irSamples) && this.status == ppgDataFrameType10.status;
        }

        public int hashCode() {
            return Integer.hashCode(this.status) + FileInsert$$ExternalSyntheticOutline0.m((List) this.irSamples, FileInsert$$ExternalSyntheticOutline0.m((List) this.redSamples, FileInsert$$ExternalSyntheticOutline0.m((List) this.greenSamples, ULong.m2413hashCodeimpl(this.timeStamp) * 31, 31), 31), 31);
        }

        public String toString() {
            String strM2414toStringimpl = ULong.m2414toStringimpl(this.timeStamp);
            List<Integer> list = this.greenSamples;
            List<Integer> list2 = this.redSamples;
            List<Integer> list3 = this.irSamples;
            int i = this.status;
            StringBuilder sb = new StringBuilder("PpgDataFrameType10(timeStamp=");
            sb.append(strM2414toStringimpl);
            sb.append(", greenSamples=");
            sb.append(list);
            sb.append(", redSamples=");
            sb.append(list2);
            sb.append(", irSamples=");
            sb.append(list3);
            sb.append(", status=");
            return FileInsert$$ExternalSyntheticOutline0.m(i, ")", sb);
        }

        public /* synthetic */ PpgDataFrameType10(long j, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, list, list2, list3, i);
        }
    }
}
