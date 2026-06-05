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
public final class PhysData$PbUserHeight extends GeneratedMessageLite<PhysData$PbUserHeight, Builder> implements MessageLiteOrBuilder {
    private static final PhysData$PbUserHeight DEFAULT_INSTANCE;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 2;
    private static volatile Parser<PhysData$PbUserHeight> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbSystemDateTime lastModified_;
    private byte memoizedIsInitialized = 2;
    private float value_;

    static {
        PhysData$PbUserHeight physData$PbUserHeight = new PhysData$PbUserHeight();
        DEFAULT_INSTANCE = physData$PbUserHeight;
        GeneratedMessageLite.registerDefaultInstance(PhysData$PbUserHeight.class, physData$PbUserHeight);
    }

    private PhysData$PbUserHeight() {
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 0.0f;
    }

    public static PhysData$PbUserHeight getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.lastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.lastModified_ = types$PbSystemDateTime;
        } else {
            this.lastModified_ = Types$PbSystemDateTime.newBuilder(this.lastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PhysData$PbUserHeight parseDelimitedFrom(InputStream inputStream) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserHeight parseFrom(ByteBuffer byteBuffer) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhysData$PbUserHeight> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    private void setValue(float f) {
        this.bitField0_ |= 1;
        this.value_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PhysData$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhysData$PbUserHeight();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔁ\u0000\u0002ᔉ\u0001", new Object[]{"bitField0_", "value_", "lastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhysData$PbUserHeight> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhysData$PbUserHeight.class) {
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

    public Types$PbSystemDateTime getLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.lastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public float getValue() {
        return this.value_;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PhysData$PbUserHeight, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PhysData$PbUserHeight.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PhysData$PbUserHeight physData$PbUserHeight) {
        return DEFAULT_INSTANCE.createBuilder(physData$PbUserHeight);
    }

    public static PhysData$PbUserHeight parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserHeight parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhysData$PbUserHeight parseFrom(ByteString byteString) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhysData$PbUserHeight parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PhysData$PbUserHeight parseFrom(byte[] bArr) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhysData$PbUserHeight parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhysData$PbUserHeight parseFrom(InputStream inputStream) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserHeight parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserHeight parseFrom(CodedInputStream codedInputStream) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhysData$PbUserHeight parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHeight) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
