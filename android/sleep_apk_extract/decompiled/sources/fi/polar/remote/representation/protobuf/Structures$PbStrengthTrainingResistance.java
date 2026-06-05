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
public final class Structures$PbStrengthTrainingResistance extends GeneratedMessageLite<Structures$PbStrengthTrainingResistance, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbStrengthTrainingResistance DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbStrengthTrainingResistance> PARSER = null;
    public static final int RESISTANCE_TYPE_FIELD_NUMBER = 1;
    public static final int WEIGHT_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int resistanceType_;
    private float weight_;

    public enum PbStrengthTrainingResistanceType implements Internal.EnumLite {
        BODY_WEIGHT(0),
        WEIGHT(1);

        private static final Internal.EnumLiteMap<PbStrengthTrainingResistanceType> internalValueMap = new Internal.EnumLiteMap<PbStrengthTrainingResistanceType>() { // from class: fi.polar.remote.representation.protobuf.Structures.PbStrengthTrainingResistance.PbStrengthTrainingResistanceType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbStrengthTrainingResistanceType findValueByNumber(int i) {
                return PbStrengthTrainingResistanceType.forNumber(i);
            }
        };
        private final int value;

        public static final class PbStrengthTrainingResistanceTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbStrengthTrainingResistanceTypeVerifier();

            private PbStrengthTrainingResistanceTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbStrengthTrainingResistanceType.forNumber(i) != null;
            }
        }

        PbStrengthTrainingResistanceType(int i) {
            this.value = i;
        }

        public static PbStrengthTrainingResistanceType forNumber(int i) {
            if (i == 0) {
                return BODY_WEIGHT;
            }
            if (i != 1) {
                return null;
            }
            return WEIGHT;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbStrengthTrainingResistanceTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Structures$PbStrengthTrainingResistance structures$PbStrengthTrainingResistance = new Structures$PbStrengthTrainingResistance();
        DEFAULT_INSTANCE = structures$PbStrengthTrainingResistance;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbStrengthTrainingResistance.class, structures$PbStrengthTrainingResistance);
    }

    private Structures$PbStrengthTrainingResistance() {
    }

    private void clearResistanceType() {
        this.bitField0_ &= -2;
        this.resistanceType_ = 0;
    }

    private void clearWeight() {
        this.bitField0_ &= -3;
        this.weight_ = 0.0f;
    }

    public static Structures$PbStrengthTrainingResistance getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbStrengthTrainingResistance parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbStrengthTrainingResistance> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setResistanceType(PbStrengthTrainingResistanceType pbStrengthTrainingResistanceType) {
        this.resistanceType_ = pbStrengthTrainingResistanceType.getNumber();
        this.bitField0_ |= 1;
    }

    private void setWeight(float f) {
        this.bitField0_ |= 2;
        this.weight_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbStrengthTrainingResistance();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ခ\u0001", new Object[]{"bitField0_", "resistanceType_", PbStrengthTrainingResistanceType.internalGetVerifier(), "weight_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbStrengthTrainingResistance> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbStrengthTrainingResistance.class) {
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

    public PbStrengthTrainingResistanceType getResistanceType() {
        PbStrengthTrainingResistanceType pbStrengthTrainingResistanceTypeForNumber = PbStrengthTrainingResistanceType.forNumber(this.resistanceType_);
        return pbStrengthTrainingResistanceTypeForNumber == null ? PbStrengthTrainingResistanceType.BODY_WEIGHT : pbStrengthTrainingResistanceTypeForNumber;
    }

    public float getWeight() {
        return this.weight_;
    }

    public boolean hasResistanceType() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasWeight() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbStrengthTrainingResistance, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbStrengthTrainingResistance.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbStrengthTrainingResistance structures$PbStrengthTrainingResistance) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbStrengthTrainingResistance);
    }

    public static Structures$PbStrengthTrainingResistance parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(ByteString byteString) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(byte[] bArr) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(InputStream inputStream) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbStrengthTrainingResistance parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStrengthTrainingResistance) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
