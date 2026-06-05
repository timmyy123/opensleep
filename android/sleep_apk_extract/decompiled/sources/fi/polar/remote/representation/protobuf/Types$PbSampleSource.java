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
public final class Types$PbSampleSource extends GeneratedMessageLite<Types$PbSampleSource, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbSampleSource DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbSampleSource> PARSER = null;
    public static final int SAMPLE_SOURCE_TYPE_FIELD_NUMBER = 1;
    public static final int START_INDEX_FIELD_NUMBER = 2;
    public static final int STOP_INDEX_FIELD_NUMBER = 3;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int sampleSourceType_;
    private int startIndex_;
    private int stopIndex_;

    static {
        Types$PbSampleSource types$PbSampleSource = new Types$PbSampleSource();
        DEFAULT_INSTANCE = types$PbSampleSource;
        GeneratedMessageLite.registerDefaultInstance(Types$PbSampleSource.class, types$PbSampleSource);
    }

    private Types$PbSampleSource() {
    }

    private void clearSampleSourceType() {
        this.bitField0_ &= -2;
        this.sampleSourceType_ = 0;
    }

    private void clearStartIndex() {
        this.bitField0_ &= -3;
        this.startIndex_ = 0;
    }

    private void clearStopIndex() {
        this.bitField0_ &= -5;
        this.stopIndex_ = 0;
    }

    public static Types$PbSampleSource getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbSampleSource parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbSampleSource parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbSampleSource> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSampleSourceType(Types$PbSampleSourceType types$PbSampleSourceType) {
        this.sampleSourceType_ = types$PbSampleSourceType.getNumber();
        this.bitField0_ |= 1;
    }

    private void setStartIndex(int i) {
        this.bitField0_ |= 2;
        this.startIndex_ = i;
    }

    private void setStopIndex(int i) {
        this.bitField0_ |= 4;
        this.stopIndex_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbSampleSource();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔌ\u0000\u0002ᔋ\u0001\u0003ᔋ\u0002", new Object[]{"bitField0_", "sampleSourceType_", Types$PbSampleSourceType.internalGetVerifier(), "startIndex_", "stopIndex_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbSampleSource> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbSampleSource.class) {
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

    public Types$PbSampleSourceType getSampleSourceType() {
        Types$PbSampleSourceType types$PbSampleSourceTypeForNumber = Types$PbSampleSourceType.forNumber(this.sampleSourceType_);
        return types$PbSampleSourceTypeForNumber == null ? Types$PbSampleSourceType.SAMPLE_SOURCE_TYPE_UNDEFINED : types$PbSampleSourceTypeForNumber;
    }

    public int getStartIndex() {
        return this.startIndex_;
    }

    public int getStopIndex() {
        return this.stopIndex_;
    }

    public boolean hasSampleSourceType() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasStartIndex() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStopIndex() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbSampleSource, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbSampleSource.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbSampleSource types$PbSampleSource) {
        return DEFAULT_INSTANCE.createBuilder(types$PbSampleSource);
    }

    public static Types$PbSampleSource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbSampleSource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbSampleSource parseFrom(ByteString byteString) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbSampleSource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbSampleSource parseFrom(byte[] bArr) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbSampleSource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbSampleSource parseFrom(InputStream inputStream) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbSampleSource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbSampleSource parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbSampleSource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSampleSource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
