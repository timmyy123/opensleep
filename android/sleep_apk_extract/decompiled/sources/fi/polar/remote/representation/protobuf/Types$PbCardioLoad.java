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
public final class Types$PbCardioLoad extends GeneratedMessageLite<Types$PbCardioLoad, Builder> implements MessageLiteOrBuilder {
    public static final int ACTIVITY_LOAD_FIELD_NUMBER = 1;
    private static final Types$PbCardioLoad DEFAULT_INSTANCE;
    public static final int EXERCISE_LOAD_FIELD_NUMBER = 2;
    private static volatile Parser<Types$PbCardioLoad> PARSER;
    private float activityLoad_;
    private int bitField0_;
    private float exerciseLoad_;
    private byte memoizedIsInitialized = 2;

    static {
        Types$PbCardioLoad types$PbCardioLoad = new Types$PbCardioLoad();
        DEFAULT_INSTANCE = types$PbCardioLoad;
        GeneratedMessageLite.registerDefaultInstance(Types$PbCardioLoad.class, types$PbCardioLoad);
    }

    private Types$PbCardioLoad() {
    }

    private void clearActivityLoad() {
        this.bitField0_ &= -2;
        this.activityLoad_ = 0.0f;
    }

    private void clearExerciseLoad() {
        this.bitField0_ &= -3;
        this.exerciseLoad_ = 0.0f;
    }

    public static Types$PbCardioLoad getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbCardioLoad parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbCardioLoad parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbCardioLoad> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setActivityLoad(float f) {
        this.bitField0_ |= 1;
        this.activityLoad_ = f;
    }

    private void setExerciseLoad(float f) {
        this.bitField0_ |= 2;
        this.exerciseLoad_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbCardioLoad();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔁ\u0000\u0002ᔁ\u0001", new Object[]{"bitField0_", "activityLoad_", "exerciseLoad_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbCardioLoad> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbCardioLoad.class) {
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

    public float getActivityLoad() {
        return this.activityLoad_;
    }

    public float getExerciseLoad() {
        return this.exerciseLoad_;
    }

    public boolean hasActivityLoad() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasExerciseLoad() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbCardioLoad, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbCardioLoad.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbCardioLoad types$PbCardioLoad) {
        return DEFAULT_INSTANCE.createBuilder(types$PbCardioLoad);
    }

    public static Types$PbCardioLoad parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbCardioLoad parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbCardioLoad parseFrom(ByteString byteString) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbCardioLoad parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbCardioLoad parseFrom(byte[] bArr) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbCardioLoad parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbCardioLoad parseFrom(InputStream inputStream) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbCardioLoad parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbCardioLoad parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbCardioLoad parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCardioLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
