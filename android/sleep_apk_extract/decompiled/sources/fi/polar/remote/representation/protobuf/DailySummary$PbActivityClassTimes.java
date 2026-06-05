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
public final class DailySummary$PbActivityClassTimes extends GeneratedMessageLite<DailySummary$PbActivityClassTimes, Builder> implements MessageLiteOrBuilder {
    private static final DailySummary$PbActivityClassTimes DEFAULT_INSTANCE;
    private static volatile Parser<DailySummary$PbActivityClassTimes> PARSER = null;
    public static final int TIME_CONTINUOUS_MODERATE_FIELD_NUMBER = 5;
    public static final int TIME_CONTINUOUS_VIGOROUS_FIELD_NUMBER = 7;
    public static final int TIME_INTERMITTENT_MODERATE_FIELD_NUMBER = 6;
    public static final int TIME_INTERMITTENT_VIGOROUS_FIELD_NUMBER = 8;
    public static final int TIME_LIGHT_ACTIVITY_FIELD_NUMBER = 4;
    public static final int TIME_NON_WEAR_FIELD_NUMBER = 1;
    public static final int TIME_SEDENTARY_FIELD_NUMBER = 3;
    public static final int TIME_SLEEP_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private Types$PbDuration timeContinuousModerate_;
    private Types$PbDuration timeContinuousVigorous_;
    private Types$PbDuration timeIntermittentModerate_;
    private Types$PbDuration timeIntermittentVigorous_;
    private Types$PbDuration timeLightActivity_;
    private Types$PbDuration timeNonWear_;
    private Types$PbDuration timeSedentary_;
    private Types$PbDuration timeSleep_;

    static {
        DailySummary$PbActivityClassTimes dailySummary$PbActivityClassTimes = new DailySummary$PbActivityClassTimes();
        DEFAULT_INSTANCE = dailySummary$PbActivityClassTimes;
        GeneratedMessageLite.registerDefaultInstance(DailySummary$PbActivityClassTimes.class, dailySummary$PbActivityClassTimes);
    }

    private DailySummary$PbActivityClassTimes() {
    }

    private void clearTimeContinuousModerate() {
        this.timeContinuousModerate_ = null;
        this.bitField0_ &= -17;
    }

    private void clearTimeContinuousVigorous() {
        this.timeContinuousVigorous_ = null;
        this.bitField0_ &= -65;
    }

    private void clearTimeIntermittentModerate() {
        this.timeIntermittentModerate_ = null;
        this.bitField0_ &= -33;
    }

    private void clearTimeIntermittentVigorous() {
        this.timeIntermittentVigorous_ = null;
        this.bitField0_ &= -129;
    }

    private void clearTimeLightActivity() {
        this.timeLightActivity_ = null;
        this.bitField0_ &= -9;
    }

    private void clearTimeNonWear() {
        this.timeNonWear_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTimeSedentary() {
        this.timeSedentary_ = null;
        this.bitField0_ &= -5;
    }

    private void clearTimeSleep() {
        this.timeSleep_ = null;
        this.bitField0_ &= -3;
    }

    public static DailySummary$PbActivityClassTimes getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTimeContinuousModerate(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeContinuousModerate_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeContinuousModerate_ = types$PbDuration;
        } else {
            this.timeContinuousModerate_ = Types$PbDuration.newBuilder(this.timeContinuousModerate_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    private void mergeTimeContinuousVigorous(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeContinuousVigorous_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeContinuousVigorous_ = types$PbDuration;
        } else {
            this.timeContinuousVigorous_ = Types$PbDuration.newBuilder(this.timeContinuousVigorous_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 64;
    }

    private void mergeTimeIntermittentModerate(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeIntermittentModerate_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeIntermittentModerate_ = types$PbDuration;
        } else {
            this.timeIntermittentModerate_ = Types$PbDuration.newBuilder(this.timeIntermittentModerate_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    private void mergeTimeIntermittentVigorous(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeIntermittentVigorous_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeIntermittentVigorous_ = types$PbDuration;
        } else {
            this.timeIntermittentVigorous_ = Types$PbDuration.newBuilder(this.timeIntermittentVigorous_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 128;
    }

    private void mergeTimeLightActivity(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeLightActivity_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeLightActivity_ = types$PbDuration;
        } else {
            this.timeLightActivity_ = Types$PbDuration.newBuilder(this.timeLightActivity_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    private void mergeTimeNonWear(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeNonWear_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeNonWear_ = types$PbDuration;
        } else {
            this.timeNonWear_ = Types$PbDuration.newBuilder(this.timeNonWear_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTimeSedentary(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeSedentary_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeSedentary_ = types$PbDuration;
        } else {
            this.timeSedentary_ = Types$PbDuration.newBuilder(this.timeSedentary_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    private void mergeTimeSleep(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timeSleep_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timeSleep_ = types$PbDuration;
        } else {
            this.timeSleep_ = Types$PbDuration.newBuilder(this.timeSleep_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static DailySummary$PbActivityClassTimes parseDelimitedFrom(InputStream inputStream) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(ByteBuffer byteBuffer) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DailySummary$PbActivityClassTimes> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTimeContinuousModerate(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeContinuousModerate_ = types$PbDuration;
        this.bitField0_ |= 16;
    }

    private void setTimeContinuousVigorous(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeContinuousVigorous_ = types$PbDuration;
        this.bitField0_ |= 64;
    }

    private void setTimeIntermittentModerate(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeIntermittentModerate_ = types$PbDuration;
        this.bitField0_ |= 32;
    }

    private void setTimeIntermittentVigorous(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeIntermittentVigorous_ = types$PbDuration;
        this.bitField0_ |= 128;
    }

    private void setTimeLightActivity(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeLightActivity_ = types$PbDuration;
        this.bitField0_ |= 8;
    }

    private void setTimeNonWear(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeNonWear_ = types$PbDuration;
        this.bitField0_ |= 1;
    }

    private void setTimeSedentary(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeSedentary_ = types$PbDuration;
        this.bitField0_ |= 4;
    }

    private void setTimeSleep(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timeSleep_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (DailySummary$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new DailySummary$PbActivityClassTimes();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\b\u0001ᔉ\u0000\u0002ᔉ\u0001\u0003ᔉ\u0002\u0004ᔉ\u0003\u0005ᔉ\u0004\u0006ᔉ\u0005\u0007ᔉ\u0006\bᔉ\u0007", new Object[]{"bitField0_", "timeNonWear_", "timeSleep_", "timeSedentary_", "timeLightActivity_", "timeContinuousModerate_", "timeIntermittentModerate_", "timeContinuousVigorous_", "timeIntermittentVigorous_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DailySummary$PbActivityClassTimes> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (DailySummary$PbActivityClassTimes.class) {
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

    public Types$PbDuration getTimeContinuousModerate() {
        Types$PbDuration types$PbDuration = this.timeContinuousModerate_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getTimeContinuousVigorous() {
        Types$PbDuration types$PbDuration = this.timeContinuousVigorous_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getTimeIntermittentModerate() {
        Types$PbDuration types$PbDuration = this.timeIntermittentModerate_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getTimeIntermittentVigorous() {
        Types$PbDuration types$PbDuration = this.timeIntermittentVigorous_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getTimeLightActivity() {
        Types$PbDuration types$PbDuration = this.timeLightActivity_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getTimeNonWear() {
        Types$PbDuration types$PbDuration = this.timeNonWear_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getTimeSedentary() {
        Types$PbDuration types$PbDuration = this.timeSedentary_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getTimeSleep() {
        Types$PbDuration types$PbDuration = this.timeSleep_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public boolean hasTimeContinuousModerate() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasTimeContinuousVigorous() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasTimeIntermittentModerate() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasTimeIntermittentVigorous() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasTimeLightActivity() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTimeNonWear() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTimeSedentary() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTimeSleep() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<DailySummary$PbActivityClassTimes, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(DailySummary$PbActivityClassTimes.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(DailySummary$PbActivityClassTimes dailySummary$PbActivityClassTimes) {
        return DEFAULT_INSTANCE.createBuilder(dailySummary$PbActivityClassTimes);
    }

    public static DailySummary$PbActivityClassTimes parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(ByteString byteString) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(byte[] bArr) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(InputStream inputStream) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(CodedInputStream codedInputStream) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DailySummary$PbActivityClassTimes parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (DailySummary$PbActivityClassTimes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
