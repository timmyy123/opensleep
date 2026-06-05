package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class DailySummary$PbDailySummary extends GeneratedMessageLite<DailySummary$PbDailySummary, Builder> implements MessageLiteOrBuilder {
    public static final int ACTIVITY_CALORIES_FIELD_NUMBER = 3;
    public static final int ACTIVITY_CLASS_TIMES_FIELD_NUMBER = 7;
    public static final int ACTIVITY_DISTANCE_FIELD_NUMBER = 8;
    public static final int BMR_CALORIES_FIELD_NUMBER = 5;
    private static final DailySummary$PbDailySummary DEFAULT_INSTANCE;
    private static volatile Parser<DailySummary$PbDailySummary> PARSER = null;
    public static final int TRAINING_CALORIES_FIELD_NUMBER = 4;
    private int activityCalories_;
    private DailySummary$PbActivityClassTimes activityClassTimes_;
    private float activityDistance_;
    private int bitField0_;
    private int bmrCalories_;
    private byte memoizedIsInitialized = 2;
    private int trainingCalories_;

    static {
        DailySummary$PbDailySummary dailySummary$PbDailySummary = new DailySummary$PbDailySummary();
        DEFAULT_INSTANCE = dailySummary$PbDailySummary;
        GeneratedMessageLite.registerDefaultInstance(DailySummary$PbDailySummary.class, dailySummary$PbDailySummary);
    }

    private DailySummary$PbDailySummary() {
    }

    private void clearActivityCalories() {
        this.bitField0_ &= -2;
        this.activityCalories_ = 0;
    }

    private void clearActivityClassTimes() {
        this.activityClassTimes_ = null;
        this.bitField0_ &= -9;
    }

    private void clearActivityDistance() {
        this.bitField0_ &= -17;
        this.activityDistance_ = 0.0f;
    }

    private void clearBmrCalories() {
        this.bitField0_ &= -5;
        this.bmrCalories_ = 0;
    }

    private void clearTrainingCalories() {
        this.bitField0_ &= -3;
        this.trainingCalories_ = 0;
    }

    public static DailySummary$PbDailySummary getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeActivityClassTimes(DailySummary$PbActivityClassTimes dailySummary$PbActivityClassTimes) {
        dailySummary$PbActivityClassTimes.getClass();
        DailySummary$PbActivityClassTimes dailySummary$PbActivityClassTimes2 = this.activityClassTimes_;
        if (dailySummary$PbActivityClassTimes2 == null || dailySummary$PbActivityClassTimes2 == DailySummary$PbActivityClassTimes.getDefaultInstance()) {
            this.activityClassTimes_ = dailySummary$PbActivityClassTimes;
        } else {
            this.activityClassTimes_ = DailySummary$PbActivityClassTimes.newBuilder(this.activityClassTimes_).mergeFrom(dailySummary$PbActivityClassTimes).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DailySummary$PbDailySummary parseDelimitedFrom(InputStream inputStream) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DailySummary$PbDailySummary parseFrom(ByteBuffer byteBuffer) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DailySummary$PbDailySummary> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setActivityCalories(int i) {
        this.bitField0_ |= 1;
        this.activityCalories_ = i;
    }

    private void setActivityClassTimes(DailySummary$PbActivityClassTimes dailySummary$PbActivityClassTimes) {
        dailySummary$PbActivityClassTimes.getClass();
        this.activityClassTimes_ = dailySummary$PbActivityClassTimes;
        this.bitField0_ |= 8;
    }

    private void setActivityDistance(float f) {
        this.bitField0_ |= 16;
        this.activityDistance_ = f;
    }

    private void setBmrCalories(int i) {
        this.bitField0_ |= 4;
        this.bmrCalories_ = i;
    }

    private void setTrainingCalories(int i) {
        this.bitField0_ |= 2;
        this.trainingCalories_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (DailySummary$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new DailySummary$PbDailySummary();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0003\b\u0005\u0000\u0000\u0001\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0007ᐉ\u0003\bခ\u0004", new Object[]{"bitField0_", "activityCalories_", "trainingCalories_", "bmrCalories_", "activityClassTimes_", "activityDistance_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DailySummary$PbDailySummary> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DailySummary$PbDailySummary.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj != null ? 1 : 0);
                return null;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    public int getActivityCalories() {
        return this.activityCalories_;
    }

    public DailySummary$PbActivityClassTimes getActivityClassTimes() {
        DailySummary$PbActivityClassTimes dailySummary$PbActivityClassTimes = this.activityClassTimes_;
        return dailySummary$PbActivityClassTimes == null ? DailySummary$PbActivityClassTimes.getDefaultInstance() : dailySummary$PbActivityClassTimes;
    }

    public float getActivityDistance() {
        return this.activityDistance_;
    }

    public int getBmrCalories() {
        return this.bmrCalories_;
    }

    public int getTrainingCalories() {
        return this.trainingCalories_;
    }

    public boolean hasActivityCalories() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasActivityClassTimes() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasActivityDistance() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasBmrCalories() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTrainingCalories() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<DailySummary$PbDailySummary, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(DailySummary$PbDailySummary.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(DailySummary$PbDailySummary dailySummary$PbDailySummary) {
        return DEFAULT_INSTANCE.createBuilder(dailySummary$PbDailySummary);
    }

    public static DailySummary$PbDailySummary parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DailySummary$PbDailySummary parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DailySummary$PbDailySummary parseFrom(ByteString byteString) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DailySummary$PbDailySummary parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DailySummary$PbDailySummary parseFrom(byte[] bArr) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DailySummary$PbDailySummary parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DailySummary$PbDailySummary parseFrom(InputStream inputStream) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DailySummary$PbDailySummary parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DailySummary$PbDailySummary parseFrom(CodedInputStream codedInputStream) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DailySummary$PbDailySummary parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbDailySummary) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
