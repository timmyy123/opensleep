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
public final class Structures$PbStravaSegmentTarget extends GeneratedMessageLite<Structures$PbStravaSegmentTarget, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbStravaSegmentTarget DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbStravaSegmentTarget> PARSER = null;
    public static final int STRAVA_SEGMENT_TARGETS_FIELD_NUMBER = 2;
    public static final int STRAVA_SEGMENT_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Structures$PbStravaSegmentTargets stravaSegmentTargets_;
    private byte memoizedIsInitialized = 2;
    private int stravaSegmentType_ = 1;

    public enum PbStravaSegmentType implements Internal.EnumLite {
        STRAVA_SEGMENT_TYPE_RIDE(1),
        STRAVA_SEGMENT_TYPE_RUN(2);

        private static final Internal.EnumLiteMap<PbStravaSegmentType> internalValueMap = new Internal.EnumLiteMap<PbStravaSegmentType>() { // from class: fi.polar.remote.representation.protobuf.Structures.PbStravaSegmentTarget.PbStravaSegmentType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbStravaSegmentType findValueByNumber(int i) {
                return PbStravaSegmentType.forNumber(i);
            }
        };
        private final int value;

        public static final class PbStravaSegmentTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbStravaSegmentTypeVerifier();

            private PbStravaSegmentTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbStravaSegmentType.forNumber(i) != null;
            }
        }

        PbStravaSegmentType(int i) {
            this.value = i;
        }

        public static PbStravaSegmentType forNumber(int i) {
            if (i == 1) {
                return STRAVA_SEGMENT_TYPE_RIDE;
            }
            if (i != 2) {
                return null;
            }
            return STRAVA_SEGMENT_TYPE_RUN;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbStravaSegmentTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Structures$PbStravaSegmentTarget structures$PbStravaSegmentTarget = new Structures$PbStravaSegmentTarget();
        DEFAULT_INSTANCE = structures$PbStravaSegmentTarget;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbStravaSegmentTarget.class, structures$PbStravaSegmentTarget);
    }

    private Structures$PbStravaSegmentTarget() {
    }

    private void clearStravaSegmentTargets() {
        this.stravaSegmentTargets_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStravaSegmentType() {
        this.bitField0_ &= -2;
        this.stravaSegmentType_ = 1;
    }

    public static Structures$PbStravaSegmentTarget getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeStravaSegmentTargets(Structures$PbStravaSegmentTargets structures$PbStravaSegmentTargets) {
        structures$PbStravaSegmentTargets.getClass();
        Structures$PbStravaSegmentTargets structures$PbStravaSegmentTargets2 = this.stravaSegmentTargets_;
        if (structures$PbStravaSegmentTargets2 == null || structures$PbStravaSegmentTargets2 == Structures$PbStravaSegmentTargets.getDefaultInstance()) {
            this.stravaSegmentTargets_ = structures$PbStravaSegmentTargets;
        } else {
            this.stravaSegmentTargets_ = Structures$PbStravaSegmentTargets.newBuilder(this.stravaSegmentTargets_).mergeFrom(structures$PbStravaSegmentTargets).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbStravaSegmentTarget parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbStravaSegmentTarget> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStravaSegmentTargets(Structures$PbStravaSegmentTargets structures$PbStravaSegmentTargets) {
        structures$PbStravaSegmentTargets.getClass();
        this.stravaSegmentTargets_ = structures$PbStravaSegmentTargets;
        this.bitField0_ |= 2;
    }

    private void setStravaSegmentType(PbStravaSegmentType pbStravaSegmentType) {
        this.stravaSegmentType_ = pbStravaSegmentType.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbStravaSegmentTarget();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "stravaSegmentType_", PbStravaSegmentType.internalGetVerifier(), "stravaSegmentTargets_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbStravaSegmentTarget> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbStravaSegmentTarget.class) {
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

    public Structures$PbStravaSegmentTargets getStravaSegmentTargets() {
        Structures$PbStravaSegmentTargets structures$PbStravaSegmentTargets = this.stravaSegmentTargets_;
        return structures$PbStravaSegmentTargets == null ? Structures$PbStravaSegmentTargets.getDefaultInstance() : structures$PbStravaSegmentTargets;
    }

    public PbStravaSegmentType getStravaSegmentType() {
        PbStravaSegmentType pbStravaSegmentTypeForNumber = PbStravaSegmentType.forNumber(this.stravaSegmentType_);
        return pbStravaSegmentTypeForNumber == null ? PbStravaSegmentType.STRAVA_SEGMENT_TYPE_RIDE : pbStravaSegmentTypeForNumber;
    }

    public boolean hasStravaSegmentTargets() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStravaSegmentType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbStravaSegmentTarget, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbStravaSegmentTarget.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbStravaSegmentTarget structures$PbStravaSegmentTarget) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbStravaSegmentTarget);
    }

    public static Structures$PbStravaSegmentTarget parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(ByteString byteString) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(byte[] bArr) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(InputStream inputStream) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbStravaSegmentTarget parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTarget) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
