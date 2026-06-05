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
public final class Structures$PbRunningIndex extends GeneratedMessageLite<Structures$PbRunningIndex, Builder> implements MessageLiteOrBuilder {
    public static final int CALCULATION_TIME_FIELD_NUMBER = 2;
    private static final Structures$PbRunningIndex DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbRunningIndex> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbDuration calculationTime_;
    private byte memoizedIsInitialized = 2;
    private int value_;

    static {
        Structures$PbRunningIndex structures$PbRunningIndex = new Structures$PbRunningIndex();
        DEFAULT_INSTANCE = structures$PbRunningIndex;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbRunningIndex.class, structures$PbRunningIndex);
    }

    private Structures$PbRunningIndex() {
    }

    private void clearCalculationTime() {
        this.calculationTime_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 0;
    }

    public static Structures$PbRunningIndex getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCalculationTime(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.calculationTime_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.calculationTime_ = types$PbDuration;
        } else {
            this.calculationTime_ = Types$PbDuration.newBuilder(this.calculationTime_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbRunningIndex parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbRunningIndex parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbRunningIndex> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalculationTime(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.calculationTime_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    private void setValue(int i) {
        this.bitField0_ |= 1;
        this.value_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbRunningIndex();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔋ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "value_", "calculationTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbRunningIndex> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbRunningIndex.class) {
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

    public Types$PbDuration getCalculationTime() {
        Types$PbDuration types$PbDuration = this.calculationTime_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public int getValue() {
        return this.value_;
    }

    public boolean hasCalculationTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbRunningIndex, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbRunningIndex.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbRunningIndex structures$PbRunningIndex) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbRunningIndex);
    }

    public static Structures$PbRunningIndex parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbRunningIndex parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbRunningIndex parseFrom(ByteString byteString) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbRunningIndex parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbRunningIndex parseFrom(byte[] bArr) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbRunningIndex parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbRunningIndex parseFrom(InputStream inputStream) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbRunningIndex parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbRunningIndex parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbRunningIndex parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbRunningIndex) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
