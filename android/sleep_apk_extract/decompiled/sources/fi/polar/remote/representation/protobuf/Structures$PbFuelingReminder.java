package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class Structures$PbFuelingReminder extends GeneratedMessageLite<Structures$PbFuelingReminder, Builder> implements Structures$PbFuelingReminderOrBuilder {
    private static final Structures$PbFuelingReminder DEFAULT_INSTANCE;
    public static final int FUELING_REMINDER_TYPE_FIELD_NUMBER = 2;
    private static volatile Parser<Structures$PbFuelingReminder> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbDuration timestamp_;
    private byte memoizedIsInitialized = 2;
    private int fuelingReminderType_ = 1;

    public enum PbFuelingReminderType implements Internal.EnumLite {
        REMINDER_TYPE_ENERGY_MANUAL(1),
        REMINDER_TYPE_ENERGY_SMART(2),
        REMINDER_TYPE_HYDRATION(3),
        REMINDER_TYPE_HYDRATION_AND_ENERGY_MANUAL(4),
        REMINDER_TYPE_HYDRATION_AND_ENERGY_SMART(5);

        private static final Internal.EnumLiteMap<PbFuelingReminderType> internalValueMap = new Internal.EnumLiteMap<PbFuelingReminderType>() { // from class: fi.polar.remote.representation.protobuf.Structures.PbFuelingReminder.PbFuelingReminderType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbFuelingReminderType findValueByNumber(int i) {
                return PbFuelingReminderType.forNumber(i);
            }
        };
        private final int value;

        public static final class PbFuelingReminderTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbFuelingReminderTypeVerifier();

            private PbFuelingReminderTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbFuelingReminderType.forNumber(i) != null;
            }
        }

        PbFuelingReminderType(int i) {
            this.value = i;
        }

        public static PbFuelingReminderType forNumber(int i) {
            if (i == 1) {
                return REMINDER_TYPE_ENERGY_MANUAL;
            }
            if (i == 2) {
                return REMINDER_TYPE_ENERGY_SMART;
            }
            if (i == 3) {
                return REMINDER_TYPE_HYDRATION;
            }
            if (i == 4) {
                return REMINDER_TYPE_HYDRATION_AND_ENERGY_MANUAL;
            }
            if (i != 5) {
                return null;
            }
            return REMINDER_TYPE_HYDRATION_AND_ENERGY_SMART;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbFuelingReminderTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Structures$PbFuelingReminder structures$PbFuelingReminder = new Structures$PbFuelingReminder();
        DEFAULT_INSTANCE = structures$PbFuelingReminder;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbFuelingReminder.class, structures$PbFuelingReminder);
    }

    private Structures$PbFuelingReminder() {
    }

    private void clearFuelingReminderType() {
        this.bitField0_ &= -3;
        this.fuelingReminderType_ = 1;
    }

    private void clearTimestamp() {
        this.timestamp_ = null;
        this.bitField0_ &= -2;
    }

    public static Structures$PbFuelingReminder getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTimestamp(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.timestamp_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.timestamp_ = types$PbDuration;
        } else {
            this.timestamp_ = Types$PbDuration.newBuilder(this.timestamp_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbFuelingReminder parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbFuelingReminder parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbFuelingReminder> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFuelingReminderType(PbFuelingReminderType pbFuelingReminderType) {
        this.fuelingReminderType_ = pbFuelingReminderType.getNumber();
        this.bitField0_ |= 2;
    }

    private void setTimestamp(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.timestamp_ = types$PbDuration;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbFuelingReminder();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔉ\u0000\u0002ဌ\u0001", new Object[]{"bitField0_", "timestamp_", "fuelingReminderType_", PbFuelingReminderType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbFuelingReminder> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbFuelingReminder.class) {
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

    public PbFuelingReminderType getFuelingReminderType() {
        PbFuelingReminderType pbFuelingReminderTypeForNumber = PbFuelingReminderType.forNumber(this.fuelingReminderType_);
        return pbFuelingReminderTypeForNumber == null ? PbFuelingReminderType.REMINDER_TYPE_ENERGY_MANUAL : pbFuelingReminderTypeForNumber;
    }

    public Types$PbDuration getTimestamp() {
        Types$PbDuration types$PbDuration = this.timestamp_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public boolean hasFuelingReminderType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbFuelingReminder, Builder> implements Structures$PbFuelingReminderOrBuilder {
        private Builder() {
            super(Structures$PbFuelingReminder.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbFuelingReminder structures$PbFuelingReminder) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbFuelingReminder);
    }

    public static Structures$PbFuelingReminder parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbFuelingReminder parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbFuelingReminder parseFrom(ByteString byteString) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbFuelingReminder parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbFuelingReminder parseFrom(byte[] bArr) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbFuelingReminder parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbFuelingReminder parseFrom(InputStream inputStream) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbFuelingReminder parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbFuelingReminder parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbFuelingReminder parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFuelingReminder) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
