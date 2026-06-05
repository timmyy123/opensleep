package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Structures$PbZones extends GeneratedMessageLite<Structures$PbZones, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbZones DEFAULT_INSTANCE;
    public static final int HEART_RATE_SETTING_SOURCE_FIELD_NUMBER = 10;
    public static final int HEART_RATE_ZONE_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbZones> PARSER = null;
    public static final int POWER_SETTING_SOURCE_FIELD_NUMBER = 11;
    public static final int POWER_ZONE_CALCULATION_METHOD_FIELD_NUMBER = 13;
    public static final int POWER_ZONE_FIELD_NUMBER = 3;
    public static final int SPEED_SETTING_SOURCE_FIELD_NUMBER = 12;
    public static final int SPEED_ZONE_CALCULATION_METHOD_FIELD_NUMBER = 14;
    public static final int SPEED_ZONE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int heartRateSettingSource_;
    private int powerSettingSource_;
    private int powerZoneCalculationMethod_;
    private int speedSettingSource_;
    private int speedZoneCalculationMethod_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Structures$PbHeartRateZone> heartRateZone_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<Structures$PbSpeedZone> speedZone_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<Structures$PbPowerZone> powerZone_ = GeneratedMessageLite.emptyProtobufList();

    static {
        Structures$PbZones structures$PbZones = new Structures$PbZones();
        DEFAULT_INSTANCE = structures$PbZones;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbZones.class, structures$PbZones);
    }

    private Structures$PbZones() {
    }

    private void addAllHeartRateZone(Iterable<? extends Structures$PbHeartRateZone> iterable) {
        ensureHeartRateZoneIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.heartRateZone_);
    }

    private void addAllPowerZone(Iterable<? extends Structures$PbPowerZone> iterable) {
        ensurePowerZoneIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.powerZone_);
    }

    private void addAllSpeedZone(Iterable<? extends Structures$PbSpeedZone> iterable) {
        ensureSpeedZoneIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.speedZone_);
    }

    private void addHeartRateZone(Structures$PbHeartRateZone structures$PbHeartRateZone) {
        structures$PbHeartRateZone.getClass();
        ensureHeartRateZoneIsMutable();
        this.heartRateZone_.add(structures$PbHeartRateZone);
    }

    private void addPowerZone(Structures$PbPowerZone structures$PbPowerZone) {
        structures$PbPowerZone.getClass();
        ensurePowerZoneIsMutable();
        this.powerZone_.add(structures$PbPowerZone);
    }

    private void addSpeedZone(Structures$PbSpeedZone structures$PbSpeedZone) {
        structures$PbSpeedZone.getClass();
        ensureSpeedZoneIsMutable();
        this.speedZone_.add(structures$PbSpeedZone);
    }

    private void clearHeartRateSettingSource() {
        this.bitField0_ &= -2;
        this.heartRateSettingSource_ = 0;
    }

    private void clearHeartRateZone() {
        this.heartRateZone_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPowerSettingSource() {
        this.bitField0_ &= -3;
        this.powerSettingSource_ = 0;
    }

    private void clearPowerZone() {
        this.powerZone_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearPowerZoneCalculationMethod() {
        this.bitField0_ &= -9;
        this.powerZoneCalculationMethod_ = 0;
    }

    private void clearSpeedSettingSource() {
        this.bitField0_ &= -5;
        this.speedSettingSource_ = 0;
    }

    private void clearSpeedZone() {
        this.speedZone_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSpeedZoneCalculationMethod() {
        this.bitField0_ &= -17;
        this.speedZoneCalculationMethod_ = 0;
    }

    private void ensureHeartRateZoneIsMutable() {
        Internal.ProtobufList<Structures$PbHeartRateZone> protobufList = this.heartRateZone_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.heartRateZone_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensurePowerZoneIsMutable() {
        Internal.ProtobufList<Structures$PbPowerZone> protobufList = this.powerZone_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.powerZone_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSpeedZoneIsMutable() {
        Internal.ProtobufList<Structures$PbSpeedZone> protobufList = this.speedZone_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.speedZone_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Structures$PbZones getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbZones parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbZones) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbZones parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbZones> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeHeartRateZone(int i) {
        ensureHeartRateZoneIsMutable();
        this.heartRateZone_.remove(i);
    }

    private void removePowerZone(int i) {
        ensurePowerZoneIsMutable();
        this.powerZone_.remove(i);
    }

    private void removeSpeedZone(int i) {
        ensureSpeedZoneIsMutable();
        this.speedZone_.remove(i);
    }

    private void setHeartRateSettingSource(Types$PbHeartRateZoneSettingSource types$PbHeartRateZoneSettingSource) {
        this.heartRateSettingSource_ = types$PbHeartRateZoneSettingSource.getNumber();
        this.bitField0_ |= 1;
    }

    private void setHeartRateZone(int i, Structures$PbHeartRateZone structures$PbHeartRateZone) {
        structures$PbHeartRateZone.getClass();
        ensureHeartRateZoneIsMutable();
        this.heartRateZone_.set(i, structures$PbHeartRateZone);
    }

    private void setPowerSettingSource(Types$PbPowerZoneSettingSource types$PbPowerZoneSettingSource) {
        this.powerSettingSource_ = types$PbPowerZoneSettingSource.getNumber();
        this.bitField0_ |= 2;
    }

    private void setPowerZone(int i, Structures$PbPowerZone structures$PbPowerZone) {
        structures$PbPowerZone.getClass();
        ensurePowerZoneIsMutable();
        this.powerZone_.set(i, structures$PbPowerZone);
    }

    private void setPowerZoneCalculationMethod(Types$PbPowerZoneCalculationMethod types$PbPowerZoneCalculationMethod) {
        this.powerZoneCalculationMethod_ = types$PbPowerZoneCalculationMethod.getNumber();
        this.bitField0_ |= 8;
    }

    private void setSpeedSettingSource(Types$PbSpeedZoneSettingSource types$PbSpeedZoneSettingSource) {
        this.speedSettingSource_ = types$PbSpeedZoneSettingSource.getNumber();
        this.bitField0_ |= 4;
    }

    private void setSpeedZone(int i, Structures$PbSpeedZone structures$PbSpeedZone) {
        structures$PbSpeedZone.getClass();
        ensureSpeedZoneIsMutable();
        this.speedZone_.set(i, structures$PbSpeedZone);
    }

    private void setSpeedZoneCalculationMethod(Types$PbSpeedZoneCalculationMethod types$PbSpeedZoneCalculationMethod) {
        this.speedZoneCalculationMethod_ = types$PbSpeedZoneCalculationMethod.getNumber();
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbZones();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\u000e\b\u0000\u0003\u0003\u0001Л\u0002Л\u0003Л\nဌ\u0000\u000bဌ\u0001\fဌ\u0002\rဌ\u0003\u000eဌ\u0004", new Object[]{"bitField0_", "heartRateZone_", Structures$PbHeartRateZone.class, "speedZone_", Structures$PbSpeedZone.class, "powerZone_", Structures$PbPowerZone.class, "heartRateSettingSource_", Types$PbHeartRateZoneSettingSource.internalGetVerifier(), "powerSettingSource_", Types$PbPowerZoneSettingSource.internalGetVerifier(), "speedSettingSource_", Types$PbSpeedZoneSettingSource.internalGetVerifier(), "powerZoneCalculationMethod_", Types$PbPowerZoneCalculationMethod.internalGetVerifier(), "speedZoneCalculationMethod_", Types$PbSpeedZoneCalculationMethod.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbZones> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbZones.class) {
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

    public Types$PbHeartRateZoneSettingSource getHeartRateSettingSource() {
        Types$PbHeartRateZoneSettingSource types$PbHeartRateZoneSettingSourceForNumber = Types$PbHeartRateZoneSettingSource.forNumber(this.heartRateSettingSource_);
        return types$PbHeartRateZoneSettingSourceForNumber == null ? Types$PbHeartRateZoneSettingSource.HEART_RATE_ZONE_SETTING_SOURCE_DEFAULT : types$PbHeartRateZoneSettingSourceForNumber;
    }

    public Structures$PbHeartRateZone getHeartRateZone(int i) {
        return this.heartRateZone_.get(i);
    }

    public int getHeartRateZoneCount() {
        return this.heartRateZone_.size();
    }

    public List<Structures$PbHeartRateZone> getHeartRateZoneList() {
        return this.heartRateZone_;
    }

    public Structures$PbHeartRateZoneOrBuilder getHeartRateZoneOrBuilder(int i) {
        return this.heartRateZone_.get(i);
    }

    public List<? extends Structures$PbHeartRateZoneOrBuilder> getHeartRateZoneOrBuilderList() {
        return this.heartRateZone_;
    }

    public Types$PbPowerZoneSettingSource getPowerSettingSource() {
        Types$PbPowerZoneSettingSource types$PbPowerZoneSettingSourceForNumber = Types$PbPowerZoneSettingSource.forNumber(this.powerSettingSource_);
        return types$PbPowerZoneSettingSourceForNumber == null ? Types$PbPowerZoneSettingSource.POWER_ZONE_SETTING_SOURCE_DEFAULT : types$PbPowerZoneSettingSourceForNumber;
    }

    public Structures$PbPowerZone getPowerZone(int i) {
        return this.powerZone_.get(i);
    }

    public Types$PbPowerZoneCalculationMethod getPowerZoneCalculationMethod() {
        Types$PbPowerZoneCalculationMethod types$PbPowerZoneCalculationMethodForNumber = Types$PbPowerZoneCalculationMethod.forNumber(this.powerZoneCalculationMethod_);
        return types$PbPowerZoneCalculationMethodForNumber == null ? Types$PbPowerZoneCalculationMethod.POWER_ZONE_CALCULATION_METHOD_UNKNOWN : types$PbPowerZoneCalculationMethodForNumber;
    }

    public int getPowerZoneCount() {
        return this.powerZone_.size();
    }

    public List<Structures$PbPowerZone> getPowerZoneList() {
        return this.powerZone_;
    }

    public Structures$PbPowerZoneOrBuilder getPowerZoneOrBuilder(int i) {
        return this.powerZone_.get(i);
    }

    public List<? extends Structures$PbPowerZoneOrBuilder> getPowerZoneOrBuilderList() {
        return this.powerZone_;
    }

    public Types$PbSpeedZoneSettingSource getSpeedSettingSource() {
        Types$PbSpeedZoneSettingSource types$PbSpeedZoneSettingSourceForNumber = Types$PbSpeedZoneSettingSource.forNumber(this.speedSettingSource_);
        return types$PbSpeedZoneSettingSourceForNumber == null ? Types$PbSpeedZoneSettingSource.SPEED_ZONE_SETTING_SOURCE_DEFAULT : types$PbSpeedZoneSettingSourceForNumber;
    }

    public Structures$PbSpeedZone getSpeedZone(int i) {
        return this.speedZone_.get(i);
    }

    public Types$PbSpeedZoneCalculationMethod getSpeedZoneCalculationMethod() {
        Types$PbSpeedZoneCalculationMethod types$PbSpeedZoneCalculationMethodForNumber = Types$PbSpeedZoneCalculationMethod.forNumber(this.speedZoneCalculationMethod_);
        return types$PbSpeedZoneCalculationMethodForNumber == null ? Types$PbSpeedZoneCalculationMethod.SPEED_ZONE_CALCULATION_METHOD_UNKNOWN : types$PbSpeedZoneCalculationMethodForNumber;
    }

    public int getSpeedZoneCount() {
        return this.speedZone_.size();
    }

    public List<Structures$PbSpeedZone> getSpeedZoneList() {
        return this.speedZone_;
    }

    public Structures$PbSpeedZoneOrBuilder getSpeedZoneOrBuilder(int i) {
        return this.speedZone_.get(i);
    }

    public List<? extends Structures$PbSpeedZoneOrBuilder> getSpeedZoneOrBuilderList() {
        return this.speedZone_;
    }

    public boolean hasHeartRateSettingSource() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPowerSettingSource() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPowerZoneCalculationMethod() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSpeedSettingSource() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSpeedZoneCalculationMethod() {
        return (this.bitField0_ & 16) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbZones, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbZones.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbZones structures$PbZones) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbZones);
    }

    public static Structures$PbZones parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbZones) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbZones parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbZones parseFrom(ByteString byteString) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbZones parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addHeartRateZone(int i, Structures$PbHeartRateZone structures$PbHeartRateZone) {
        structures$PbHeartRateZone.getClass();
        ensureHeartRateZoneIsMutable();
        this.heartRateZone_.add(i, structures$PbHeartRateZone);
    }

    private void addPowerZone(int i, Structures$PbPowerZone structures$PbPowerZone) {
        structures$PbPowerZone.getClass();
        ensurePowerZoneIsMutable();
        this.powerZone_.add(i, structures$PbPowerZone);
    }

    private void addSpeedZone(int i, Structures$PbSpeedZone structures$PbSpeedZone) {
        structures$PbSpeedZone.getClass();
        ensureSpeedZoneIsMutable();
        this.speedZone_.add(i, structures$PbSpeedZone);
    }

    public static Structures$PbZones parseFrom(byte[] bArr) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbZones parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbZones parseFrom(InputStream inputStream) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbZones parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbZones parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbZones parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbZones) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
