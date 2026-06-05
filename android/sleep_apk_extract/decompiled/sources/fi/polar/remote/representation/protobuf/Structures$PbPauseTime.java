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
public final class Structures$PbPauseTime extends GeneratedMessageLite<Structures$PbPauseTime, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbPauseTime DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 2;
    private static volatile Parser<Structures$PbPauseTime> PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbDuration duration_;
    private byte memoizedIsInitialized = 2;
    private Types$PbDuration startTime_;

    static {
        Structures$PbPauseTime structures$PbPauseTime = new Structures$PbPauseTime();
        DEFAULT_INSTANCE = structures$PbPauseTime;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbPauseTime.class, structures$PbPauseTime);
    }

    private Structures$PbPauseTime() {
    }

    private void clearDuration() {
        this.duration_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStartTime() {
        this.startTime_ = null;
        this.bitField0_ &= -2;
    }

    public static Structures$PbPauseTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.duration_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.duration_ = types$PbDuration;
        } else {
            this.duration_ = Types$PbDuration.newBuilder(this.duration_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStartTime(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.startTime_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.startTime_ = types$PbDuration;
        } else {
            this.startTime_ = Types$PbDuration.newBuilder(this.startTime_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbPauseTime parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbPauseTime parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbPauseTime> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.duration_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    private void setStartTime(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.startTime_ = types$PbDuration;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbPauseTime();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔉ\u0000\u0002ᔉ\u0001", new Object[]{"bitField0_", "startTime_", "duration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbPauseTime> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbPauseTime.class) {
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

    public Types$PbDuration getDuration() {
        Types$PbDuration types$PbDuration = this.duration_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getStartTime() {
        Types$PbDuration types$PbDuration = this.startTime_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public boolean hasDuration() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStartTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbPauseTime, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbPauseTime.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbPauseTime structures$PbPauseTime) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbPauseTime);
    }

    public static Structures$PbPauseTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbPauseTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbPauseTime parseFrom(ByteString byteString) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbPauseTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbPauseTime parseFrom(byte[] bArr) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbPauseTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbPauseTime parseFrom(InputStream inputStream) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbPauseTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbPauseTime parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbPauseTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPauseTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
