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
public final class Types$PbLocation extends GeneratedMessageLite<Types$PbLocation, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbLocation DEFAULT_INSTANCE;
    public static final int FIX_FIELD_NUMBER = 4;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile Parser<Types$PbLocation> PARSER = null;
    public static final int SATELLITES_FIELD_NUMBER = 5;
    public static final int TIMESTAMP_FIELD_NUMBER = 3;
    private int bitField0_;
    private int fix_;
    private double latitude_;
    private double longitude_;
    private byte memoizedIsInitialized = 2;
    private int satellites_;
    private Types$PbSystemDateTime timestamp_;

    public enum Fix implements Internal.EnumLite {
        FIX_NONE(0),
        FIX_2D(1),
        FIX_3D(2);

        private static final Internal.EnumLiteMap<Fix> internalValueMap = new Internal.EnumLiteMap<Fix>() { // from class: fi.polar.remote.representation.protobuf.Types.PbLocation.Fix.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Fix findValueByNumber(int i) {
                return Fix.forNumber(i);
            }
        };
        private final int value;

        public static final class FixVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new FixVerifier();

            private FixVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Fix.forNumber(i) != null;
            }
        }

        Fix(int i) {
            this.value = i;
        }

        public static Fix forNumber(int i) {
            if (i == 0) {
                return FIX_NONE;
            }
            if (i == 1) {
                return FIX_2D;
            }
            if (i != 2) {
                return null;
            }
            return FIX_3D;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return FixVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Types$PbLocation types$PbLocation = new Types$PbLocation();
        DEFAULT_INSTANCE = types$PbLocation;
        GeneratedMessageLite.registerDefaultInstance(Types$PbLocation.class, types$PbLocation);
    }

    private Types$PbLocation() {
    }

    private void clearFix() {
        this.bitField0_ &= -9;
        this.fix_ = 0;
    }

    private void clearLatitude() {
        this.bitField0_ &= -2;
        this.latitude_ = 0.0d;
    }

    private void clearLongitude() {
        this.bitField0_ &= -3;
        this.longitude_ = 0.0d;
    }

    private void clearSatellites() {
        this.bitField0_ &= -17;
        this.satellites_ = 0;
    }

    private void clearTimestamp() {
        this.timestamp_ = null;
        this.bitField0_ &= -5;
    }

    public static Types$PbLocation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.timestamp_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.timestamp_ = types$PbSystemDateTime;
        } else {
            this.timestamp_ = Types$PbSystemDateTime.newBuilder(this.timestamp_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbLocation parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbLocation parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbLocation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFix(Fix fix) {
        this.fix_ = fix.getNumber();
        this.bitField0_ |= 8;
    }

    private void setLatitude(double d) {
        this.bitField0_ |= 1;
        this.latitude_ = d;
    }

    private void setLongitude(double d) {
        this.bitField0_ |= 2;
        this.longitude_ = d;
    }

    private void setSatellites(int i) {
        this.bitField0_ |= 16;
        this.satellites_ = i;
    }

    private void setTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.timestamp_ = types$PbSystemDateTime;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbLocation();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0003\u0001ᔀ\u0000\u0002ᔀ\u0001\u0003ᐉ\u0002\u0004ဌ\u0003\u0005ဋ\u0004", new Object[]{"bitField0_", "latitude_", "longitude_", "timestamp_", "fix_", Fix.internalGetVerifier(), "satellites_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbLocation> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbLocation.class) {
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

    public Fix getFix() {
        Fix fixForNumber = Fix.forNumber(this.fix_);
        return fixForNumber == null ? Fix.FIX_NONE : fixForNumber;
    }

    public double getLatitude() {
        return this.latitude_;
    }

    public double getLongitude() {
        return this.longitude_;
    }

    public int getSatellites() {
        return this.satellites_;
    }

    public Types$PbSystemDateTime getTimestamp() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.timestamp_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public boolean hasFix() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLatitude() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLongitude() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSatellites() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasTimestamp() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbLocation, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbLocation.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbLocation types$PbLocation) {
        return DEFAULT_INSTANCE.createBuilder(types$PbLocation);
    }

    public static Types$PbLocation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbLocation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbLocation parseFrom(ByteString byteString) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbLocation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbLocation parseFrom(byte[] bArr) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbLocation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbLocation parseFrom(InputStream inputStream) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbLocation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbLocation parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbLocation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
