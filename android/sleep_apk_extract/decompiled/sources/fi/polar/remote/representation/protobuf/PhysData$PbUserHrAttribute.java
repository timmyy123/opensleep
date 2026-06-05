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
public final class PhysData$PbUserHrAttribute extends GeneratedMessageLite<PhysData$PbUserHrAttribute, Builder> implements MessageLiteOrBuilder {
    private static final PhysData$PbUserHrAttribute DEFAULT_INSTANCE;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 2;
    private static volatile Parser<PhysData$PbUserHrAttribute> PARSER = null;
    public static final int SETTING_SOURCE_FIELD_NUMBER = 3;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbSystemDateTime lastModified_;
    private byte memoizedIsInitialized = 2;
    private int settingSource_;
    private int value_;

    public enum HrSettingSource implements Internal.EnumLite {
        SOURCE_DEFAULT(0),
        SOURCE_AGE_BASED(1),
        SOURCE_USER(2),
        SOURCE_MEASURED(3),
        SOURCE_KEEP(4);

        private static final Internal.EnumLiteMap<HrSettingSource> internalValueMap = new Internal.EnumLiteMap<HrSettingSource>() { // from class: fi.polar.remote.representation.protobuf.PhysData.PbUserHrAttribute.HrSettingSource.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public HrSettingSource findValueByNumber(int i) {
                return HrSettingSource.forNumber(i);
            }
        };
        private final int value;

        public static final class HrSettingSourceVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new HrSettingSourceVerifier();

            private HrSettingSourceVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return HrSettingSource.forNumber(i) != null;
            }
        }

        HrSettingSource(int i) {
            this.value = i;
        }

        public static HrSettingSource forNumber(int i) {
            if (i == 0) {
                return SOURCE_DEFAULT;
            }
            if (i == 1) {
                return SOURCE_AGE_BASED;
            }
            if (i == 2) {
                return SOURCE_USER;
            }
            if (i == 3) {
                return SOURCE_MEASURED;
            }
            if (i != 4) {
                return null;
            }
            return SOURCE_KEEP;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return HrSettingSourceVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        PhysData$PbUserHrAttribute physData$PbUserHrAttribute = new PhysData$PbUserHrAttribute();
        DEFAULT_INSTANCE = physData$PbUserHrAttribute;
        GeneratedMessageLite.registerDefaultInstance(PhysData$PbUserHrAttribute.class, physData$PbUserHrAttribute);
    }

    private PhysData$PbUserHrAttribute() {
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

    public static PhysData$PbUserHrAttribute getDefaultInstance() {
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

    public static PhysData$PbUserHrAttribute parseDelimitedFrom(InputStream inputStream) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserHrAttribute parseFrom(ByteBuffer byteBuffer) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhysData$PbUserHrAttribute> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    private void setSettingSource(HrSettingSource hrSettingSource) {
        this.settingSource_ = hrSettingSource.getNumber();
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
                return new PhysData$PbUserHrAttribute();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔉ\u0001\u0003ဌ\u0002", new Object[]{"bitField0_", "value_", "lastModified_", "settingSource_", HrSettingSource.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhysData$PbUserHrAttribute> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhysData$PbUserHrAttribute.class) {
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

    public HrSettingSource getSettingSource() {
        HrSettingSource hrSettingSourceForNumber = HrSettingSource.forNumber(this.settingSource_);
        return hrSettingSourceForNumber == null ? HrSettingSource.SOURCE_DEFAULT : hrSettingSourceForNumber;
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

    public static final class Builder extends GeneratedMessageLite.Builder<PhysData$PbUserHrAttribute, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PhysData$PbUserHrAttribute.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PhysData$PbUserHrAttribute physData$PbUserHrAttribute) {
        return DEFAULT_INSTANCE.createBuilder(physData$PbUserHrAttribute);
    }

    public static PhysData$PbUserHrAttribute parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserHrAttribute parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhysData$PbUserHrAttribute parseFrom(ByteString byteString) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhysData$PbUserHrAttribute parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PhysData$PbUserHrAttribute parseFrom(byte[] bArr) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhysData$PbUserHrAttribute parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhysData$PbUserHrAttribute parseFrom(InputStream inputStream) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserHrAttribute parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserHrAttribute parseFrom(CodedInputStream codedInputStream) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhysData$PbUserHrAttribute parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserHrAttribute) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
