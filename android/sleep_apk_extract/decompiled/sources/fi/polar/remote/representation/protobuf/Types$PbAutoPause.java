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
public final class Types$PbAutoPause extends GeneratedMessageLite<Types$PbAutoPause, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbAutoPause DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbAutoPause> PARSER = null;
    public static final int SPEED_THRESHOLD_FIELD_NUMBER = 2;
    public static final int TRIGGER_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private float speedThreshold_;
    private int trigger_;

    public enum PbAutoPauseTrigger implements Internal.EnumLite {
        AUTO_PAUSE_OFF(0),
        AUTO_PAUSE_TRIGGER_SPEED(1);

        private static final Internal.EnumLiteMap<PbAutoPauseTrigger> internalValueMap = new Internal.EnumLiteMap<PbAutoPauseTrigger>() { // from class: fi.polar.remote.representation.protobuf.Types.PbAutoPause.PbAutoPauseTrigger.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbAutoPauseTrigger findValueByNumber(int i) {
                return PbAutoPauseTrigger.forNumber(i);
            }
        };
        private final int value;

        public static final class PbAutoPauseTriggerVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbAutoPauseTriggerVerifier();

            private PbAutoPauseTriggerVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbAutoPauseTrigger.forNumber(i) != null;
            }
        }

        PbAutoPauseTrigger(int i) {
            this.value = i;
        }

        public static PbAutoPauseTrigger forNumber(int i) {
            if (i == 0) {
                return AUTO_PAUSE_OFF;
            }
            if (i != 1) {
                return null;
            }
            return AUTO_PAUSE_TRIGGER_SPEED;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbAutoPauseTriggerVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Types$PbAutoPause types$PbAutoPause = new Types$PbAutoPause();
        DEFAULT_INSTANCE = types$PbAutoPause;
        GeneratedMessageLite.registerDefaultInstance(Types$PbAutoPause.class, types$PbAutoPause);
    }

    private Types$PbAutoPause() {
    }

    private void clearSpeedThreshold() {
        this.bitField0_ &= -3;
        this.speedThreshold_ = 0.0f;
    }

    private void clearTrigger() {
        this.bitField0_ &= -2;
        this.trigger_ = 0;
    }

    public static Types$PbAutoPause getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbAutoPause parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbAutoPause parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbAutoPause> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSpeedThreshold(float f) {
        this.bitField0_ |= 2;
        this.speedThreshold_ = f;
    }

    private void setTrigger(PbAutoPauseTrigger pbAutoPauseTrigger) {
        this.trigger_ = pbAutoPauseTrigger.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbAutoPause();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ခ\u0001", new Object[]{"bitField0_", "trigger_", PbAutoPauseTrigger.internalGetVerifier(), "speedThreshold_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbAutoPause> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbAutoPause.class) {
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

    public float getSpeedThreshold() {
        return this.speedThreshold_;
    }

    public PbAutoPauseTrigger getTrigger() {
        PbAutoPauseTrigger pbAutoPauseTriggerForNumber = PbAutoPauseTrigger.forNumber(this.trigger_);
        return pbAutoPauseTriggerForNumber == null ? PbAutoPauseTrigger.AUTO_PAUSE_OFF : pbAutoPauseTriggerForNumber;
    }

    public boolean hasSpeedThreshold() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTrigger() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbAutoPause, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbAutoPause.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbAutoPause types$PbAutoPause) {
        return DEFAULT_INSTANCE.createBuilder(types$PbAutoPause);
    }

    public static Types$PbAutoPause parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbAutoPause parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbAutoPause parseFrom(ByteString byteString) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbAutoPause parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbAutoPause parseFrom(byte[] bArr) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbAutoPause parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbAutoPause parseFrom(InputStream inputStream) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbAutoPause parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbAutoPause parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbAutoPause parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAutoPause) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
