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
public final class Types$PbAutoLapSettings extends GeneratedMessageLite<Types$PbAutoLapSettings, Builder> implements MessageLiteOrBuilder {
    public static final int AUTOMATIC_LAP_DISTANCE_FIELD_NUMBER = 2;
    public static final int AUTOMATIC_LAP_DURATION_FIELD_NUMBER = 3;
    public static final int AUTOMATIC_LAP_FIELD_NUMBER = 1;
    private static final Types$PbAutoLapSettings DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbAutoLapSettings> PARSER;
    private float automaticLapDistance_;
    private Types$PbDuration automaticLapDuration_;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int automaticLap_ = 1;

    public enum PbAutomaticLap implements Internal.EnumLite {
        AUTOMATIC_LAP_OFF(1),
        AUTOMATIC_LAP_DISTANCE(2),
        AUTOMATIC_LAP_DURATION(3),
        AUTOMATIC_LAP_LOCATION(4);

        private static final Internal.EnumLiteMap<PbAutomaticLap> internalValueMap = new Internal.EnumLiteMap<PbAutomaticLap>() { // from class: fi.polar.remote.representation.protobuf.Types.PbAutoLapSettings.PbAutomaticLap.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbAutomaticLap findValueByNumber(int i) {
                return PbAutomaticLap.forNumber(i);
            }
        };
        private final int value;

        public static final class PbAutomaticLapVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbAutomaticLapVerifier();

            private PbAutomaticLapVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbAutomaticLap.forNumber(i) != null;
            }
        }

        PbAutomaticLap(int i) {
            this.value = i;
        }

        public static PbAutomaticLap forNumber(int i) {
            if (i == 1) {
                return AUTOMATIC_LAP_OFF;
            }
            if (i == 2) {
                return AUTOMATIC_LAP_DISTANCE;
            }
            if (i == 3) {
                return AUTOMATIC_LAP_DURATION;
            }
            if (i != 4) {
                return null;
            }
            return AUTOMATIC_LAP_LOCATION;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbAutomaticLapVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Types$PbAutoLapSettings types$PbAutoLapSettings = new Types$PbAutoLapSettings();
        DEFAULT_INSTANCE = types$PbAutoLapSettings;
        GeneratedMessageLite.registerDefaultInstance(Types$PbAutoLapSettings.class, types$PbAutoLapSettings);
    }

    private Types$PbAutoLapSettings() {
    }

    private void clearAutomaticLap() {
        this.bitField0_ &= -2;
        this.automaticLap_ = 1;
    }

    private void clearAutomaticLapDistance() {
        this.bitField0_ &= -3;
        this.automaticLapDistance_ = 0.0f;
    }

    private void clearAutomaticLapDuration() {
        this.automaticLapDuration_ = null;
        this.bitField0_ &= -5;
    }

    public static Types$PbAutoLapSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAutomaticLapDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.automaticLapDuration_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.automaticLapDuration_ = types$PbDuration;
        } else {
            this.automaticLapDuration_ = Types$PbDuration.newBuilder(this.automaticLapDuration_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbAutoLapSettings parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbAutoLapSettings parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbAutoLapSettings> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAutomaticLap(PbAutomaticLap pbAutomaticLap) {
        this.automaticLap_ = pbAutomaticLap.getNumber();
        this.bitField0_ |= 1;
    }

    private void setAutomaticLapDistance(float f) {
        this.bitField0_ |= 2;
        this.automaticLapDistance_ = f;
    }

    private void setAutomaticLapDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.automaticLapDuration_ = types$PbDuration;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbAutoLapSettings();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ခ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "automaticLap_", PbAutomaticLap.internalGetVerifier(), "automaticLapDistance_", "automaticLapDuration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbAutoLapSettings> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbAutoLapSettings.class) {
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

    public PbAutomaticLap getAutomaticLap() {
        PbAutomaticLap pbAutomaticLapForNumber = PbAutomaticLap.forNumber(this.automaticLap_);
        return pbAutomaticLapForNumber == null ? PbAutomaticLap.AUTOMATIC_LAP_OFF : pbAutomaticLapForNumber;
    }

    public float getAutomaticLapDistance() {
        return this.automaticLapDistance_;
    }

    public Types$PbDuration getAutomaticLapDuration() {
        Types$PbDuration types$PbDuration = this.automaticLapDuration_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public boolean hasAutomaticLap() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasAutomaticLapDistance() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasAutomaticLapDuration() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbAutoLapSettings, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbAutoLapSettings.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbAutoLapSettings types$PbAutoLapSettings) {
        return DEFAULT_INSTANCE.createBuilder(types$PbAutoLapSettings);
    }

    public static Types$PbAutoLapSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbAutoLapSettings parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbAutoLapSettings parseFrom(ByteString byteString) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbAutoLapSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbAutoLapSettings parseFrom(byte[] bArr) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbAutoLapSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbAutoLapSettings parseFrom(InputStream inputStream) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbAutoLapSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbAutoLapSettings parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbAutoLapSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoLapSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
