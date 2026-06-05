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
public final class Types$PbSensorOffline extends GeneratedMessageLite<Types$PbSensorOffline, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbSensorOffline DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbSensorOffline> PARSER = null;
    public static final int START_INDEX_FIELD_NUMBER = 1;
    public static final int STOP_INDEX_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int startIndex_;
    private int stopIndex_;

    static {
        Types$PbSensorOffline types$PbSensorOffline = new Types$PbSensorOffline();
        DEFAULT_INSTANCE = types$PbSensorOffline;
        GeneratedMessageLite.registerDefaultInstance(Types$PbSensorOffline.class, types$PbSensorOffline);
    }

    private Types$PbSensorOffline() {
    }

    private void clearStartIndex() {
        this.bitField0_ &= -2;
        this.startIndex_ = 0;
    }

    private void clearStopIndex() {
        this.bitField0_ &= -3;
        this.stopIndex_ = 0;
    }

    public static Types$PbSensorOffline getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbSensorOffline parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbSensorOffline parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbSensorOffline> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStartIndex(int i) {
        this.bitField0_ |= 1;
        this.startIndex_ = i;
    }

    private void setStopIndex(int i) {
        this.bitField0_ |= 2;
        this.stopIndex_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbSensorOffline();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔋ\u0001", new Object[]{"bitField0_", "startIndex_", "stopIndex_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbSensorOffline> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbSensorOffline.class) {
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

    public int getStartIndex() {
        return this.startIndex_;
    }

    public int getStopIndex() {
        return this.stopIndex_;
    }

    public boolean hasStartIndex() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasStopIndex() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbSensorOffline, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbSensorOffline.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbSensorOffline types$PbSensorOffline) {
        return DEFAULT_INSTANCE.createBuilder(types$PbSensorOffline);
    }

    public static Types$PbSensorOffline parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbSensorOffline parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbSensorOffline parseFrom(ByteString byteString) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbSensorOffline parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbSensorOffline parseFrom(byte[] bArr) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbSensorOffline parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbSensorOffline parseFrom(InputStream inputStream) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbSensorOffline parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbSensorOffline parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbSensorOffline parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorOffline) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
