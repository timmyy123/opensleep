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
public final class Types$PbRangeOptions extends GeneratedMessageLite<Types$PbRangeOptions, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbRangeOptions DEFAULT_INSTANCE;
    public static final int MAX_VALUE_FIELD_NUMBER = 2;
    public static final int MIN_VALUE_FIELD_NUMBER = 1;
    private static volatile Parser<Types$PbRangeOptions> PARSER;
    private int bitField0_;
    private int maxValue_;
    private int minValue_;

    static {
        Types$PbRangeOptions types$PbRangeOptions = new Types$PbRangeOptions();
        DEFAULT_INSTANCE = types$PbRangeOptions;
        GeneratedMessageLite.registerDefaultInstance(Types$PbRangeOptions.class, types$PbRangeOptions);
    }

    private Types$PbRangeOptions() {
    }

    private void clearMaxValue() {
        this.bitField0_ &= -3;
        this.maxValue_ = 0;
    }

    private void clearMinValue() {
        this.bitField0_ &= -2;
        this.minValue_ = 0;
    }

    public static Types$PbRangeOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbRangeOptions parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbRangeOptions parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbRangeOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMaxValue(int i) {
        this.bitField0_ |= 2;
        this.maxValue_ = i;
    }

    private void setMinValue(int i) {
        this.bitField0_ |= 1;
        this.minValue_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbRangeOptions();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "minValue_", "maxValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbRangeOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbRangeOptions.class) {
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

    public int getMaxValue() {
        return this.maxValue_;
    }

    public int getMinValue() {
        return this.minValue_;
    }

    public boolean hasMaxValue() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMinValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbRangeOptions, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbRangeOptions.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbRangeOptions types$PbRangeOptions) {
        return DEFAULT_INSTANCE.createBuilder(types$PbRangeOptions);
    }

    public static Types$PbRangeOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbRangeOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbRangeOptions parseFrom(ByteString byteString) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbRangeOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbRangeOptions parseFrom(byte[] bArr) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbRangeOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbRangeOptions parseFrom(InputStream inputStream) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbRangeOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbRangeOptions parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbRangeOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbRangeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
