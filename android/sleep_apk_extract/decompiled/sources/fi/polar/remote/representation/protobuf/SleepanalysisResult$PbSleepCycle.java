package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class SleepanalysisResult$PbSleepCycle extends GeneratedMessageLite<SleepanalysisResult$PbSleepCycle, Builder> implements SleepanalysisResult$PbSleepCycleOrBuilder {
    private static final SleepanalysisResult$PbSleepCycle DEFAULT_INSTANCE;
    private static volatile Parser<SleepanalysisResult$PbSleepCycle> PARSER = null;
    public static final int SECONDS_FROM_SLEEP_START_FIELD_NUMBER = 1;
    public static final int SLEEP_DEPTH_START_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int secondsFromSleepStart_;
    private float sleepDepthStart_;

    static {
        SleepanalysisResult$PbSleepCycle sleepanalysisResult$PbSleepCycle = new SleepanalysisResult$PbSleepCycle();
        DEFAULT_INSTANCE = sleepanalysisResult$PbSleepCycle;
        GeneratedMessageLite.registerDefaultInstance(SleepanalysisResult$PbSleepCycle.class, sleepanalysisResult$PbSleepCycle);
    }

    private SleepanalysisResult$PbSleepCycle() {
    }

    private void clearSecondsFromSleepStart() {
        this.bitField0_ &= -2;
        this.secondsFromSleepStart_ = 0;
    }

    private void clearSleepDepthStart() {
        this.bitField0_ &= -3;
        this.sleepDepthStart_ = 0.0f;
    }

    public static SleepanalysisResult$PbSleepCycle getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SleepanalysisResult$PbSleepCycle parseDelimitedFrom(InputStream inputStream) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(ByteBuffer byteBuffer) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SleepanalysisResult$PbSleepCycle> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSecondsFromSleepStart(int i) {
        this.bitField0_ |= 1;
        this.secondsFromSleepStart_ = i;
    }

    private void setSleepDepthStart(float f) {
        this.bitField0_ |= 2;
        this.sleepDepthStart_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (SleepanalysisResult$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SleepanalysisResult$PbSleepCycle();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔁ\u0001", new Object[]{"bitField0_", "secondsFromSleepStart_", "sleepDepthStart_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SleepanalysisResult$PbSleepCycle> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SleepanalysisResult$PbSleepCycle.class) {
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

    public int getSecondsFromSleepStart() {
        return this.secondsFromSleepStart_;
    }

    public float getSleepDepthStart() {
        return this.sleepDepthStart_;
    }

    public boolean hasSecondsFromSleepStart() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSleepDepthStart() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<SleepanalysisResult$PbSleepCycle, Builder> implements SleepanalysisResult$PbSleepCycleOrBuilder {
        private Builder() {
            super(SleepanalysisResult$PbSleepCycle.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(SleepanalysisResult$PbSleepCycle sleepanalysisResult$PbSleepCycle) {
        return DEFAULT_INSTANCE.createBuilder(sleepanalysisResult$PbSleepCycle);
    }

    public static SleepanalysisResult$PbSleepCycle parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(ByteString byteString) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(byte[] bArr) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(InputStream inputStream) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(CodedInputStream codedInputStream) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SleepanalysisResult$PbSleepCycle parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepCycle) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
