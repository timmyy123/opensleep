package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.polar.androidcommunications.api.ble.exceptions.BleNotImplemented;
import com.polar.androidcommunications.common.ble.TypeUtils;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0002)*BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010!\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\"R\u0019\u0010#\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b$\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame;", "", "data", "", "getPreviousTimeStamp", "Lkotlin/Function2;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;", "Lkotlin/ULong;", "getFactor", "Lkotlin/Function1;", "", "getSampleRate", "", "([BLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "dataContent", "getDataContent", "()[B", "factor", "()F", "frameType", "getFrameType", "()Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;", "isCompressedFrame", "", "()Z", "measurementType", "getMeasurementType", "()Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;", "previousTimeStamp", "getPreviousTimeStamp-s-VKNKU", "()J", "J", "sampleRate", "()I", "timeStamp", "getTimeStamp-s-VKNKU", "frameTypeByte", "Lkotlin/UByte;", "isCompressedFrame-7apg3OU", "(B)Z", "Companion", "PmdDataFrameType", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PmdDataFrame {
    private final byte[] dataContent;
    private final float factor;
    private final PmdDataFrameType frameType;
    private final boolean isCompressedFrame;
    private final PmdMeasurementType measurementType;
    private final long previousTimeStamp;
    private final int sampleRate;
    private final long timeStamp;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;", "", "id", "Lkotlin/UByte;", "(Ljava/lang/String;IB)V", "getId-w2LRezQ", "()B", "B", "TYPE_0", "TYPE_1", "TYPE_2", "TYPE_3", "TYPE_4", "TYPE_5", "TYPE_6", "TYPE_7", "TYPE_8", "TYPE_9", "TYPE_10", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PmdDataFrameType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PmdDataFrameType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final byte id;
        public static final PmdDataFrameType TYPE_0 = new PmdDataFrameType("TYPE_0", 0, (byte) 0);
        public static final PmdDataFrameType TYPE_1 = new PmdDataFrameType("TYPE_1", 1, (byte) 1);
        public static final PmdDataFrameType TYPE_2 = new PmdDataFrameType("TYPE_2", 2, (byte) 2);
        public static final PmdDataFrameType TYPE_3 = new PmdDataFrameType("TYPE_3", 3, (byte) 3);
        public static final PmdDataFrameType TYPE_4 = new PmdDataFrameType("TYPE_4", 4, (byte) 4);
        public static final PmdDataFrameType TYPE_5 = new PmdDataFrameType("TYPE_5", 5, (byte) 5);
        public static final PmdDataFrameType TYPE_6 = new PmdDataFrameType("TYPE_6", 6, (byte) 6);
        public static final PmdDataFrameType TYPE_7 = new PmdDataFrameType("TYPE_7", 7, (byte) 7);
        public static final PmdDataFrameType TYPE_8 = new PmdDataFrameType("TYPE_8", 8, (byte) 8);
        public static final PmdDataFrameType TYPE_9 = new PmdDataFrameType("TYPE_9", 9, (byte) 9);
        public static final PmdDataFrameType TYPE_10 = new PmdDataFrameType("TYPE_10", 10, (byte) 10);

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType$Companion;", "", "()V", "getTypeFromFrameDataByte", "Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;", "byte", "Lkotlin/UByte;", "getTypeFromFrameDataByte-7apg3OU", "(B)Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: renamed from: getTypeFromFrameDataByte-7apg3OU, reason: not valid java name */
            public final PmdDataFrameType m882getTypeFromFrameDataByte7apg3OU(byte b) throws BleNotImplemented {
                for (PmdDataFrameType pmdDataFrameType : PmdDataFrameType.values()) {
                    if (pmdDataFrameType.getId() == UByte.m2367constructorimpl((byte) (UByte.m2367constructorimpl((byte) 127) & b))) {
                        return pmdDataFrameType;
                    }
                }
                throw new BleNotImplemented(FileInsert$$ExternalSyntheticOutline0.m("PmdFrameType cannot be parsed from ", UByte.m2370toStringimpl(b)));
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ PmdDataFrameType[] $values() {
            return new PmdDataFrameType[]{TYPE_0, TYPE_1, TYPE_2, TYPE_3, TYPE_4, TYPE_5, TYPE_6, TYPE_7, TYPE_8, TYPE_9, TYPE_10};
        }

        static {
            PmdDataFrameType[] pmdDataFrameTypeArr$values = $values();
            $VALUES = pmdDataFrameTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(pmdDataFrameTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private PmdDataFrameType(String str, int i, byte b) {
            this.id = b;
        }

        public static PmdDataFrameType valueOf(String str) {
            return (PmdDataFrameType) Enum.valueOf(PmdDataFrameType.class, str);
        }

        public static PmdDataFrameType[] values() {
            return (PmdDataFrameType[]) $VALUES.clone();
        }

        /* JADX INFO: renamed from: getId-w2LRezQ, reason: not valid java name and from getter */
        public final byte getId() {
            return this.id;
        }
    }

    public PmdDataFrame(byte[] bArr, Function2<? super PmdMeasurementType, ? super PmdDataFrameType, ULong> function2, Function1<? super PmdMeasurementType, Float> function1, Function1<? super PmdMeasurementType, Integer> function12) throws BleNotImplemented {
        bArr.getClass();
        function2.getClass();
        function1.getClass();
        function12.getClass();
        PmdMeasurementType pmdMeasurementTypeFromId = PmdMeasurementType.INSTANCE.fromId(bArr[0]);
        this.measurementType = pmdMeasurementTypeFromId;
        this.timeStamp = TypeUtils.INSTANCE.m899convertArrayToUnsignedLongqJGtvoU(bArr, 1, 8);
        byte bM2367constructorimpl = UByte.m2367constructorimpl(bArr[9]);
        PmdDataFrameType pmdDataFrameTypeM882getTypeFromFrameDataByte7apg3OU = PmdDataFrameType.INSTANCE.m882getTypeFromFrameDataByte7apg3OU(bM2367constructorimpl);
        this.frameType = pmdDataFrameTypeM882getTypeFromFrameDataByte7apg3OU;
        this.isCompressedFrame = m878isCompressedFrame7apg3OU(bM2367constructorimpl);
        int length = bArr.length - 10;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 10, bArr2, 0, length);
        this.dataContent = bArr2;
        this.previousTimeStamp = function2.invoke(pmdMeasurementTypeFromId, pmdDataFrameTypeM882getTypeFromFrameDataByte7apg3OU).getData();
        this.factor = function1.invoke(pmdMeasurementTypeFromId).floatValue();
        this.sampleRate = function12.invoke(pmdMeasurementTypeFromId).intValue();
    }

    /* JADX INFO: renamed from: isCompressedFrame-7apg3OU, reason: not valid java name */
    private final boolean m878isCompressedFrame7apg3OU(byte frameTypeByte) {
        return Integer.compare(UInt.m2389constructorimpl(UByte.m2367constructorimpl((byte) (UByte.m2367constructorimpl((byte) -128) & frameTypeByte)) & 255) ^ Integer.MIN_VALUE, Integer.MIN_VALUE) > 0;
    }

    public final byte[] getDataContent() {
        return this.dataContent;
    }

    public final float getFactor() {
        return this.factor;
    }

    public final PmdDataFrameType getFrameType() {
        return this.frameType;
    }

    public final PmdMeasurementType getMeasurementType() {
        return this.measurementType;
    }

    /* JADX INFO: renamed from: getPreviousTimeStamp-s-VKNKU, reason: not valid java name and from getter */
    public final long getPreviousTimeStamp() {
        return this.previousTimeStamp;
    }

    public final int getSampleRate() {
        return this.sampleRate;
    }

    /* JADX INFO: renamed from: getTimeStamp-s-VKNKU, reason: not valid java name and from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    /* JADX INFO: renamed from: isCompressedFrame, reason: from getter */
    public final boolean getIsCompressedFrame() {
        return this.isCompressedFrame;
    }
}
