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
public final class Structures$PbVolumeTarget extends GeneratedMessageLite<Structures$PbVolumeTarget, Builder> implements MessageLiteOrBuilder {
    public static final int CALORIES_FIELD_NUMBER = 4;
    private static final Structures$PbVolumeTarget DEFAULT_INSTANCE;
    public static final int DISTANCE_FIELD_NUMBER = 3;
    public static final int DURATION_FIELD_NUMBER = 2;
    private static volatile Parser<Structures$PbVolumeTarget> PARSER = null;
    public static final int TARGET_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int calories_;
    private float distance_;
    private Types$PbDuration duration_;
    private byte memoizedIsInitialized = 2;
    private int targetType_;

    public enum PbVolymeTargetType implements Internal.EnumLite {
        VOLUME_TARGET_TYPE_DURATION(0),
        VOLUME_TARGET_TYPE_DISTANCE(1),
        VOLUME_TARGET_TYPE_CALORIES(2);

        private static final Internal.EnumLiteMap<PbVolymeTargetType> internalValueMap = new Internal.EnumLiteMap<PbVolymeTargetType>() { // from class: fi.polar.remote.representation.protobuf.Structures.PbVolumeTarget.PbVolymeTargetType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbVolymeTargetType findValueByNumber(int i) {
                return PbVolymeTargetType.forNumber(i);
            }
        };
        private final int value;

        public static final class PbVolymeTargetTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbVolymeTargetTypeVerifier();

            private PbVolymeTargetTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbVolymeTargetType.forNumber(i) != null;
            }
        }

        PbVolymeTargetType(int i) {
            this.value = i;
        }

        public static PbVolymeTargetType forNumber(int i) {
            if (i == 0) {
                return VOLUME_TARGET_TYPE_DURATION;
            }
            if (i == 1) {
                return VOLUME_TARGET_TYPE_DISTANCE;
            }
            if (i != 2) {
                return null;
            }
            return VOLUME_TARGET_TYPE_CALORIES;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbVolymeTargetTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Structures$PbVolumeTarget structures$PbVolumeTarget = new Structures$PbVolumeTarget();
        DEFAULT_INSTANCE = structures$PbVolumeTarget;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbVolumeTarget.class, structures$PbVolumeTarget);
    }

    private Structures$PbVolumeTarget() {
    }

    private void clearCalories() {
        this.bitField0_ &= -9;
        this.calories_ = 0;
    }

    private void clearDistance() {
        this.bitField0_ &= -5;
        this.distance_ = 0.0f;
    }

    private void clearDuration() {
        this.duration_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTargetType() {
        this.bitField0_ &= -2;
        this.targetType_ = 0;
    }

    public static Structures$PbVolumeTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.duration_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.duration_ = types$PbDuration;
        } else {
            this.duration_ = Types$PbDuration.newBuilder(this.duration_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbVolumeTarget parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbVolumeTarget parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbVolumeTarget> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalories(int i) {
        this.bitField0_ |= 8;
        this.calories_ = i;
    }

    private void setDistance(float f) {
        this.bitField0_ |= 4;
        this.distance_ = f;
    }

    private void setDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.duration_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    private void setTargetType(PbVolymeTargetType pbVolymeTargetType) {
        this.targetType_ = pbVolymeTargetType.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbVolumeTarget();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ခ\u0002\u0004ဋ\u0003", new Object[]{"bitField0_", "targetType_", PbVolymeTargetType.internalGetVerifier(), "duration_", "distance_", "calories_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbVolumeTarget> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbVolumeTarget.class) {
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

    public int getCalories() {
        return this.calories_;
    }

    public float getDistance() {
        return this.distance_;
    }

    public Types$PbDuration getDuration() {
        Types$PbDuration types$PbDuration = this.duration_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public PbVolymeTargetType getTargetType() {
        PbVolymeTargetType pbVolymeTargetTypeForNumber = PbVolymeTargetType.forNumber(this.targetType_);
        return pbVolymeTargetTypeForNumber == null ? PbVolymeTargetType.VOLUME_TARGET_TYPE_DURATION : pbVolymeTargetTypeForNumber;
    }

    public boolean hasCalories() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDistance() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasDuration() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTargetType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbVolumeTarget, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbVolumeTarget.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbVolumeTarget structures$PbVolumeTarget) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbVolumeTarget);
    }

    public static Structures$PbVolumeTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbVolumeTarget parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbVolumeTarget parseFrom(ByteString byteString) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbVolumeTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbVolumeTarget parseFrom(byte[] bArr) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbVolumeTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbVolumeTarget parseFrom(InputStream inputStream) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbVolumeTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbVolumeTarget parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbVolumeTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVolumeTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
