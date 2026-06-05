package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class PhysData$PbUserTypicalDay extends GeneratedMessageLite<PhysData$PbUserTypicalDay, Builder> implements MessageLiteOrBuilder {
    private static final PhysData$PbUserTypicalDay DEFAULT_INSTANCE;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 2;
    private static volatile Parser<PhysData$PbUserTypicalDay> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbSystemDateTime lastModified_;
    private byte memoizedIsInitialized = 2;
    private int value_ = 1;

    public enum TypicalDay implements Internal.EnumLite {
        MOSTLY_SITTING(1),
        MOSTLY_STANDING(2),
        MOSTLY_MOVING(3);

        private static final Internal.EnumLiteMap<TypicalDay> internalValueMap = new Internal.EnumLiteMap<TypicalDay>() { // from class: fi.polar.remote.representation.protobuf.PhysData.PbUserTypicalDay.TypicalDay.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TypicalDay findValueByNumber(int i) {
                return TypicalDay.forNumber(i);
            }
        };
        private final int value;

        public static final class TypicalDayVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new TypicalDayVerifier();

            private TypicalDayVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return TypicalDay.forNumber(i) != null;
            }
        }

        TypicalDay(int i) {
            this.value = i;
        }

        public static TypicalDay forNumber(int i) {
            if (i == 1) {
                return MOSTLY_SITTING;
            }
            if (i == 2) {
                return MOSTLY_STANDING;
            }
            if (i != 3) {
                return null;
            }
            return MOSTLY_MOVING;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TypicalDayVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        PhysData$PbUserTypicalDay physData$PbUserTypicalDay = new PhysData$PbUserTypicalDay();
        DEFAULT_INSTANCE = physData$PbUserTypicalDay;
        GeneratedMessageLite.registerDefaultInstance(PhysData$PbUserTypicalDay.class, physData$PbUserTypicalDay);
    }

    private PhysData$PbUserTypicalDay() {
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 1;
    }

    public static PhysData$PbUserTypicalDay getDefaultInstance() {
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

    public static PhysData$PbUserTypicalDay parseDelimitedFrom(InputStream inputStream) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserTypicalDay parseFrom(ByteBuffer byteBuffer) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhysData$PbUserTypicalDay> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    private void setValue(TypicalDay typicalDay) {
        this.value_ = typicalDay.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PhysData$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhysData$PbUserTypicalDay();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔌ\u0000\u0002ᔉ\u0001", new Object[]{"bitField0_", "value_", TypicalDay.internalGetVerifier(), "lastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhysData$PbUserTypicalDay> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhysData$PbUserTypicalDay.class) {
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

    public TypicalDay getValue() {
        TypicalDay typicalDayForNumber = TypicalDay.forNumber(this.value_);
        return typicalDayForNumber == null ? TypicalDay.MOSTLY_SITTING : typicalDayForNumber;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PhysData$PbUserTypicalDay, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PhysData$PbUserTypicalDay.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PhysData$PbUserTypicalDay physData$PbUserTypicalDay) {
        return DEFAULT_INSTANCE.createBuilder(physData$PbUserTypicalDay);
    }

    public static PhysData$PbUserTypicalDay parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserTypicalDay parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhysData$PbUserTypicalDay parseFrom(ByteString byteString) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhysData$PbUserTypicalDay parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PhysData$PbUserTypicalDay parseFrom(byte[] bArr) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhysData$PbUserTypicalDay parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhysData$PbUserTypicalDay parseFrom(InputStream inputStream) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserTypicalDay parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserTypicalDay parseFrom(CodedInputStream codedInputStream) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhysData$PbUserTypicalDay parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTypicalDay) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
