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
public final class PhysData$PbUserVo2Max extends GeneratedMessageLite<PhysData$PbUserVo2Max, Builder> implements MessageLiteOrBuilder {
    private static final PhysData$PbUserVo2Max DEFAULT_INSTANCE;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 2;
    private static volatile Parser<PhysData$PbUserVo2Max> PARSER = null;
    public static final int SETTING_SOURCE_FIELD_NUMBER = 3;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbSystemDateTime lastModified_;
    private byte memoizedIsInitialized = 2;
    private int settingSource_;
    private int value_;

    public enum Vo2MaxSettingSource implements Internal.EnumLite {
        SOURCE_DEFAULT(0),
        SOURCE_ESTIMATE(1),
        SOURCE_USER(2),
        SOURCE_FITNESSTEST(3);

        private static final Internal.EnumLiteMap<Vo2MaxSettingSource> internalValueMap = new Internal.EnumLiteMap<Vo2MaxSettingSource>() { // from class: fi.polar.remote.representation.protobuf.PhysData.PbUserVo2Max.Vo2MaxSettingSource.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Vo2MaxSettingSource findValueByNumber(int i) {
                return Vo2MaxSettingSource.forNumber(i);
            }
        };
        private final int value;

        public static final class Vo2MaxSettingSourceVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new Vo2MaxSettingSourceVerifier();

            private Vo2MaxSettingSourceVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Vo2MaxSettingSource.forNumber(i) != null;
            }
        }

        Vo2MaxSettingSource(int i) {
            this.value = i;
        }

        public static Vo2MaxSettingSource forNumber(int i) {
            if (i == 0) {
                return SOURCE_DEFAULT;
            }
            if (i == 1) {
                return SOURCE_ESTIMATE;
            }
            if (i == 2) {
                return SOURCE_USER;
            }
            if (i != 3) {
                return null;
            }
            return SOURCE_FITNESSTEST;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return Vo2MaxSettingSourceVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        PhysData$PbUserVo2Max physData$PbUserVo2Max = new PhysData$PbUserVo2Max();
        DEFAULT_INSTANCE = physData$PbUserVo2Max;
        GeneratedMessageLite.registerDefaultInstance(PhysData$PbUserVo2Max.class, physData$PbUserVo2Max);
    }

    private PhysData$PbUserVo2Max() {
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSettingSource() {
        this.bitField0_ &= -5;
        this.settingSource_ = 0;
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 0;
    }

    public static PhysData$PbUserVo2Max getDefaultInstance() {
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

    public static PhysData$PbUserVo2Max parseDelimitedFrom(InputStream inputStream) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserVo2Max parseFrom(ByteBuffer byteBuffer) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhysData$PbUserVo2Max> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    private void setSettingSource(Vo2MaxSettingSource vo2MaxSettingSource) {
        this.settingSource_ = vo2MaxSettingSource.getNumber();
        this.bitField0_ |= 4;
    }

    private void setValue(int i) {
        this.bitField0_ |= 1;
        this.value_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PhysData$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhysData$PbUserVo2Max();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔉ\u0001\u0003ဌ\u0002", new Object[]{"bitField0_", "value_", "lastModified_", "settingSource_", Vo2MaxSettingSource.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhysData$PbUserVo2Max> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhysData$PbUserVo2Max.class) {
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

    public Vo2MaxSettingSource getSettingSource() {
        Vo2MaxSettingSource vo2MaxSettingSourceForNumber = Vo2MaxSettingSource.forNumber(this.settingSource_);
        return vo2MaxSettingSourceForNumber == null ? Vo2MaxSettingSource.SOURCE_DEFAULT : vo2MaxSettingSourceForNumber;
    }

    public int getValue() {
        return this.value_;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSettingSource() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PhysData$PbUserVo2Max, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PhysData$PbUserVo2Max.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PhysData$PbUserVo2Max physData$PbUserVo2Max) {
        return DEFAULT_INSTANCE.createBuilder(physData$PbUserVo2Max);
    }

    public static PhysData$PbUserVo2Max parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserVo2Max parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhysData$PbUserVo2Max parseFrom(ByteString byteString) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhysData$PbUserVo2Max parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PhysData$PbUserVo2Max parseFrom(byte[] bArr) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhysData$PbUserVo2Max parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhysData$PbUserVo2Max parseFrom(InputStream inputStream) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserVo2Max parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserVo2Max parseFrom(CodedInputStream codedInputStream) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhysData$PbUserVo2Max parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserVo2Max) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
