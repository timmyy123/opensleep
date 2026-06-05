package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class PhysData$PbUserPhysData extends GeneratedMessageLite<PhysData$PbUserPhysData, Builder> implements MessageLiteOrBuilder {
    public static final int BIRTHDAY_FIELD_NUMBER = 1;
    private static final PhysData$PbUserPhysData DEFAULT_INSTANCE;
    public static final int GENDER_FIELD_NUMBER = 2;
    public static final int HEIGHT_FIELD_NUMBER = 4;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 100;
    public static final int MAXIMUM_HEARTRATE_FIELD_NUMBER = 5;
    private static volatile Parser<PhysData$PbUserPhysData> PARSER = null;
    public static final int RESTING_HEARTRATE_FIELD_NUMBER = 6;
    public static final int SLEEP_GOAL_FIELD_NUMBER = 17;
    public static final int TRAINING_BACKGROUND_FIELD_NUMBER = 11;
    public static final int TYPICAL_DAY_FIELD_NUMBER = 12;
    public static final int VO2MAX_FIELD_NUMBER = 10;
    public static final int WEIGHT_FIELD_NUMBER = 3;
    private PhysData$PbUserBirthday birthday_;
    private int bitField0_;
    private PhysData$PbUserGender gender_;
    private PhysData$PbUserHeight height_;
    private Types$PbSystemDateTime lastModified_;
    private PhysData$PbUserHrAttribute maximumHeartrate_;
    private byte memoizedIsInitialized = 2;
    private PhysData$PbUserHrAttribute restingHeartrate_;
    private PhysData$PbSleepGoal sleepGoal_;
    private PhysData$PbUserTrainingBackground trainingBackground_;
    private PhysData$PbUserTypicalDay typicalDay_;
    private PhysData$PbUserVo2Max vo2Max_;
    private PhysData$PbUserWeight weight_;

    static {
        PhysData$PbUserPhysData physData$PbUserPhysData = new PhysData$PbUserPhysData();
        DEFAULT_INSTANCE = physData$PbUserPhysData;
        GeneratedMessageLite.registerDefaultInstance(PhysData$PbUserPhysData.class, physData$PbUserPhysData);
    }

    private PhysData$PbUserPhysData() {
    }

    private void clearBirthday() {
        this.birthday_ = null;
        this.bitField0_ &= -2;
    }

    private void clearGender() {
        this.gender_ = null;
        this.bitField0_ &= -3;
    }

    private void clearHeight() {
        this.height_ = null;
        this.bitField0_ &= -9;
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearMaximumHeartrate() {
        this.maximumHeartrate_ = null;
        this.bitField0_ &= -17;
    }

    private void clearRestingHeartrate() {
        this.restingHeartrate_ = null;
        this.bitField0_ &= -33;
    }

    private void clearSleepGoal() {
        this.sleepGoal_ = null;
        this.bitField0_ &= -513;
    }

    private void clearTrainingBackground() {
        this.trainingBackground_ = null;
        this.bitField0_ &= -129;
    }

    private void clearTypicalDay() {
        this.typicalDay_ = null;
        this.bitField0_ &= -257;
    }

    private void clearVo2Max() {
        this.vo2Max_ = null;
        this.bitField0_ &= -65;
    }

    private void clearWeight() {
        this.weight_ = null;
        this.bitField0_ &= -5;
    }

    public static PhysData$PbUserPhysData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeBirthday(PhysData$PbUserBirthday physData$PbUserBirthday) {
        physData$PbUserBirthday.getClass();
        PhysData$PbUserBirthday physData$PbUserBirthday2 = this.birthday_;
        if (physData$PbUserBirthday2 == null || physData$PbUserBirthday2 == PhysData$PbUserBirthday.getDefaultInstance()) {
            this.birthday_ = physData$PbUserBirthday;
        } else {
            this.birthday_ = PhysData$PbUserBirthday.newBuilder(this.birthday_).mergeFrom(physData$PbUserBirthday).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    private void mergeGender(PhysData$PbUserGender physData$PbUserGender) {
        physData$PbUserGender.getClass();
        PhysData$PbUserGender physData$PbUserGender2 = this.gender_;
        if (physData$PbUserGender2 == null || physData$PbUserGender2 == PhysData$PbUserGender.getDefaultInstance()) {
            this.gender_ = physData$PbUserGender;
        } else {
            this.gender_ = PhysData$PbUserGender.newBuilder(this.gender_).mergeFrom(physData$PbUserGender).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeHeight(PhysData$PbUserHeight physData$PbUserHeight) {
        physData$PbUserHeight.getClass();
        PhysData$PbUserHeight physData$PbUserHeight2 = this.height_;
        if (physData$PbUserHeight2 == null || physData$PbUserHeight2 == PhysData$PbUserHeight.getDefaultInstance()) {
            this.height_ = physData$PbUserHeight;
        } else {
            this.height_ = PhysData$PbUserHeight.newBuilder(this.height_).mergeFrom(physData$PbUserHeight).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    private void mergeLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.lastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.lastModified_ = types$PbSystemDateTime;
        } else {
            this.lastModified_ = Types$PbSystemDateTime.newBuilder(this.lastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeMaximumHeartrate(PhysData$PbUserHrAttribute physData$PbUserHrAttribute) {
        physData$PbUserHrAttribute.getClass();
        PhysData$PbUserHrAttribute physData$PbUserHrAttribute2 = this.maximumHeartrate_;
        if (physData$PbUserHrAttribute2 == null || physData$PbUserHrAttribute2 == PhysData$PbUserHrAttribute.getDefaultInstance()) {
            this.maximumHeartrate_ = physData$PbUserHrAttribute;
        } else {
            this.maximumHeartrate_ = PhysData$PbUserHrAttribute.newBuilder(this.maximumHeartrate_).mergeFrom(physData$PbUserHrAttribute).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    private void mergeRestingHeartrate(PhysData$PbUserHrAttribute physData$PbUserHrAttribute) {
        physData$PbUserHrAttribute.getClass();
        PhysData$PbUserHrAttribute physData$PbUserHrAttribute2 = this.restingHeartrate_;
        if (physData$PbUserHrAttribute2 == null || physData$PbUserHrAttribute2 == PhysData$PbUserHrAttribute.getDefaultInstance()) {
            this.restingHeartrate_ = physData$PbUserHrAttribute;
        } else {
            this.restingHeartrate_ = PhysData$PbUserHrAttribute.newBuilder(this.restingHeartrate_).mergeFrom(physData$PbUserHrAttribute).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    private void mergeSleepGoal(PhysData$PbSleepGoal physData$PbSleepGoal) {
        physData$PbSleepGoal.getClass();
        PhysData$PbSleepGoal physData$PbSleepGoal2 = this.sleepGoal_;
        if (physData$PbSleepGoal2 == null || physData$PbSleepGoal2 == PhysData$PbSleepGoal.getDefaultInstance()) {
            this.sleepGoal_ = physData$PbSleepGoal;
        } else {
            this.sleepGoal_ = PhysData$PbSleepGoal.newBuilder(this.sleepGoal_).mergeFrom(physData$PbSleepGoal).buildPartial();
        }
        this.bitField0_ |= 512;
    }

    private void mergeTrainingBackground(PhysData$PbUserTrainingBackground physData$PbUserTrainingBackground) {
        physData$PbUserTrainingBackground.getClass();
        PhysData$PbUserTrainingBackground physData$PbUserTrainingBackground2 = this.trainingBackground_;
        if (physData$PbUserTrainingBackground2 == null || physData$PbUserTrainingBackground2 == PhysData$PbUserTrainingBackground.getDefaultInstance()) {
            this.trainingBackground_ = physData$PbUserTrainingBackground;
        } else {
            this.trainingBackground_ = PhysData$PbUserTrainingBackground.newBuilder(this.trainingBackground_).mergeFrom(physData$PbUserTrainingBackground).buildPartial();
        }
        this.bitField0_ |= 128;
    }

    private void mergeTypicalDay(PhysData$PbUserTypicalDay physData$PbUserTypicalDay) {
        physData$PbUserTypicalDay.getClass();
        PhysData$PbUserTypicalDay physData$PbUserTypicalDay2 = this.typicalDay_;
        if (physData$PbUserTypicalDay2 == null || physData$PbUserTypicalDay2 == PhysData$PbUserTypicalDay.getDefaultInstance()) {
            this.typicalDay_ = physData$PbUserTypicalDay;
        } else {
            this.typicalDay_ = PhysData$PbUserTypicalDay.newBuilder(this.typicalDay_).mergeFrom(physData$PbUserTypicalDay).buildPartial();
        }
        this.bitField0_ |= 256;
    }

    private void mergeVo2Max(PhysData$PbUserVo2Max physData$PbUserVo2Max) {
        physData$PbUserVo2Max.getClass();
        PhysData$PbUserVo2Max physData$PbUserVo2Max2 = this.vo2Max_;
        if (physData$PbUserVo2Max2 == null || physData$PbUserVo2Max2 == PhysData$PbUserVo2Max.getDefaultInstance()) {
            this.vo2Max_ = physData$PbUserVo2Max;
        } else {
            this.vo2Max_ = PhysData$PbUserVo2Max.newBuilder(this.vo2Max_).mergeFrom(physData$PbUserVo2Max).buildPartial();
        }
        this.bitField0_ |= 64;
    }

    private void mergeWeight(PhysData$PbUserWeight physData$PbUserWeight) {
        physData$PbUserWeight.getClass();
        PhysData$PbUserWeight physData$PbUserWeight2 = this.weight_;
        if (physData$PbUserWeight2 == null || physData$PbUserWeight2 == PhysData$PbUserWeight.getDefaultInstance()) {
            this.weight_ = physData$PbUserWeight;
        } else {
            this.weight_ = PhysData$PbUserWeight.newBuilder(this.weight_).mergeFrom(physData$PbUserWeight).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PhysData$PbUserPhysData parseDelimitedFrom(InputStream inputStream) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserPhysData parseFrom(ByteBuffer byteBuffer) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhysData$PbUserPhysData> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setBirthday(PhysData$PbUserBirthday physData$PbUserBirthday) {
        physData$PbUserBirthday.getClass();
        this.birthday_ = physData$PbUserBirthday;
        this.bitField0_ |= 1;
    }

    private void setGender(PhysData$PbUserGender physData$PbUserGender) {
        physData$PbUserGender.getClass();
        this.gender_ = physData$PbUserGender;
        this.bitField0_ |= 2;
    }

    private void setHeight(PhysData$PbUserHeight physData$PbUserHeight) {
        physData$PbUserHeight.getClass();
        this.height_ = physData$PbUserHeight;
        this.bitField0_ |= 8;
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 1024;
    }

    private void setMaximumHeartrate(PhysData$PbUserHrAttribute physData$PbUserHrAttribute) {
        physData$PbUserHrAttribute.getClass();
        this.maximumHeartrate_ = physData$PbUserHrAttribute;
        this.bitField0_ |= 16;
    }

    private void setRestingHeartrate(PhysData$PbUserHrAttribute physData$PbUserHrAttribute) {
        physData$PbUserHrAttribute.getClass();
        this.restingHeartrate_ = physData$PbUserHrAttribute;
        this.bitField0_ |= 32;
    }

    private void setSleepGoal(PhysData$PbSleepGoal physData$PbSleepGoal) {
        physData$PbSleepGoal.getClass();
        this.sleepGoal_ = physData$PbSleepGoal;
        this.bitField0_ |= 512;
    }

    private void setTrainingBackground(PhysData$PbUserTrainingBackground physData$PbUserTrainingBackground) {
        physData$PbUserTrainingBackground.getClass();
        this.trainingBackground_ = physData$PbUserTrainingBackground;
        this.bitField0_ |= 128;
    }

    private void setTypicalDay(PhysData$PbUserTypicalDay physData$PbUserTypicalDay) {
        physData$PbUserTypicalDay.getClass();
        this.typicalDay_ = physData$PbUserTypicalDay;
        this.bitField0_ |= 256;
    }

    private void setVo2Max(PhysData$PbUserVo2Max physData$PbUserVo2Max) {
        physData$PbUserVo2Max.getClass();
        this.vo2Max_ = physData$PbUserVo2Max;
        this.bitField0_ |= 64;
    }

    private void setWeight(PhysData$PbUserWeight physData$PbUserWeight) {
        physData$PbUserWeight.getClass();
        this.weight_ = physData$PbUserWeight;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PhysData$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhysData$PbUserPhysData();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001d\u000b\u0000\u0000\u000b\u0001ᔉ\u0000\u0002ᔉ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005ᐉ\u0004\u0006ᐉ\u0005\nᐉ\u0006\u000bᐉ\u0007\fᐉ\b\u0011ᐉ\tdᐉ\n", new Object[]{"bitField0_", "birthday_", "gender_", "weight_", "height_", "maximumHeartrate_", "restingHeartrate_", "vo2Max_", "trainingBackground_", "typicalDay_", "sleepGoal_", "lastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhysData$PbUserPhysData> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhysData$PbUserPhysData.class) {
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

    public PhysData$PbUserBirthday getBirthday() {
        PhysData$PbUserBirthday physData$PbUserBirthday = this.birthday_;
        return physData$PbUserBirthday == null ? PhysData$PbUserBirthday.getDefaultInstance() : physData$PbUserBirthday;
    }

    public PhysData$PbUserGender getGender() {
        PhysData$PbUserGender physData$PbUserGender = this.gender_;
        return physData$PbUserGender == null ? PhysData$PbUserGender.getDefaultInstance() : physData$PbUserGender;
    }

    public PhysData$PbUserHeight getHeight() {
        PhysData$PbUserHeight physData$PbUserHeight = this.height_;
        return physData$PbUserHeight == null ? PhysData$PbUserHeight.getDefaultInstance() : physData$PbUserHeight;
    }

    public Types$PbSystemDateTime getLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.lastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public PhysData$PbUserHrAttribute getMaximumHeartrate() {
        PhysData$PbUserHrAttribute physData$PbUserHrAttribute = this.maximumHeartrate_;
        return physData$PbUserHrAttribute == null ? PhysData$PbUserHrAttribute.getDefaultInstance() : physData$PbUserHrAttribute;
    }

    public PhysData$PbUserHrAttribute getRestingHeartrate() {
        PhysData$PbUserHrAttribute physData$PbUserHrAttribute = this.restingHeartrate_;
        return physData$PbUserHrAttribute == null ? PhysData$PbUserHrAttribute.getDefaultInstance() : physData$PbUserHrAttribute;
    }

    public PhysData$PbSleepGoal getSleepGoal() {
        PhysData$PbSleepGoal physData$PbSleepGoal = this.sleepGoal_;
        return physData$PbSleepGoal == null ? PhysData$PbSleepGoal.getDefaultInstance() : physData$PbSleepGoal;
    }

    public PhysData$PbUserTrainingBackground getTrainingBackground() {
        PhysData$PbUserTrainingBackground physData$PbUserTrainingBackground = this.trainingBackground_;
        return physData$PbUserTrainingBackground == null ? PhysData$PbUserTrainingBackground.getDefaultInstance() : physData$PbUserTrainingBackground;
    }

    public PhysData$PbUserTypicalDay getTypicalDay() {
        PhysData$PbUserTypicalDay physData$PbUserTypicalDay = this.typicalDay_;
        return physData$PbUserTypicalDay == null ? PhysData$PbUserTypicalDay.getDefaultInstance() : physData$PbUserTypicalDay;
    }

    public PhysData$PbUserVo2Max getVo2Max() {
        PhysData$PbUserVo2Max physData$PbUserVo2Max = this.vo2Max_;
        return physData$PbUserVo2Max == null ? PhysData$PbUserVo2Max.getDefaultInstance() : physData$PbUserVo2Max;
    }

    public PhysData$PbUserWeight getWeight() {
        PhysData$PbUserWeight physData$PbUserWeight = this.weight_;
        return physData$PbUserWeight == null ? PhysData$PbUserWeight.getDefaultInstance() : physData$PbUserWeight;
    }

    public boolean hasBirthday() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasGender() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasHeight() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasMaximumHeartrate() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasRestingHeartrate() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasSleepGoal() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasTrainingBackground() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasTypicalDay() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasVo2Max() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasWeight() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PhysData$PbUserPhysData, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PhysData$PbUserPhysData.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PhysData$PbUserPhysData physData$PbUserPhysData) {
        return DEFAULT_INSTANCE.createBuilder(physData$PbUserPhysData);
    }

    public static PhysData$PbUserPhysData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserPhysData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhysData$PbUserPhysData parseFrom(ByteString byteString) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhysData$PbUserPhysData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PhysData$PbUserPhysData parseFrom(byte[] bArr) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhysData$PbUserPhysData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhysData$PbUserPhysData parseFrom(InputStream inputStream) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserPhysData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserPhysData parseFrom(CodedInputStream codedInputStream) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhysData$PbUserPhysData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserPhysData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
