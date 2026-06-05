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
public final class Training$PbExerciseCounters extends GeneratedMessageLite<Training$PbExerciseCounters, Builder> implements MessageLiteOrBuilder {
    private static final Training$PbExerciseCounters DEFAULT_INSTANCE;
    private static volatile Parser<Training$PbExerciseCounters> PARSER = null;
    public static final int SPRINT_COUNT_FIELD_NUMBER = 1;
    private int bitField0_;
    private int sprintCount_;

    static {
        Training$PbExerciseCounters training$PbExerciseCounters = new Training$PbExerciseCounters();
        DEFAULT_INSTANCE = training$PbExerciseCounters;
        GeneratedMessageLite.registerDefaultInstance(Training$PbExerciseCounters.class, training$PbExerciseCounters);
    }

    private Training$PbExerciseCounters() {
    }

    private void clearSprintCount() {
        this.bitField0_ &= -2;
        this.sprintCount_ = 0;
    }

    public static Training$PbExerciseCounters getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Training$PbExerciseCounters parseDelimitedFrom(InputStream inputStream) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Training$PbExerciseCounters parseFrom(ByteBuffer byteBuffer) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Training$PbExerciseCounters> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSprintCount(int i) {
        this.bitField0_ |= 1;
        this.sprintCount_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Training$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Training$PbExerciseCounters();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဋ\u0000", new Object[]{"bitField0_", "sprintCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Training$PbExerciseCounters> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Training$PbExerciseCounters.class) {
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
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public int getSprintCount() {
        return this.sprintCount_;
    }

    public boolean hasSprintCount() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Training$PbExerciseCounters, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Training$PbExerciseCounters.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Training$PbExerciseCounters training$PbExerciseCounters) {
        return DEFAULT_INSTANCE.createBuilder(training$PbExerciseCounters);
    }

    public static Training$PbExerciseCounters parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Training$PbExerciseCounters parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Training$PbExerciseCounters parseFrom(ByteString byteString) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Training$PbExerciseCounters parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Training$PbExerciseCounters parseFrom(byte[] bArr) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Training$PbExerciseCounters parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Training$PbExerciseCounters parseFrom(InputStream inputStream) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Training$PbExerciseCounters parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Training$PbExerciseCounters parseFrom(CodedInputStream codedInputStream) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Training$PbExerciseCounters parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseCounters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
