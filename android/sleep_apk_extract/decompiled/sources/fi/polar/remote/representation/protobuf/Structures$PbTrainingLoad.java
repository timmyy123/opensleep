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
public final class Structures$PbTrainingLoad extends GeneratedMessageLite<Structures$PbTrainingLoad, Builder> implements MessageLiteOrBuilder {
    public static final int CARBOHYDRATE_CONSUMPTION_FIELD_NUMBER = 3;
    public static final int CARBOHYDRATE_GRAMS_FIELD_NUMBER = 6;
    private static final Structures$PbTrainingLoad DEFAULT_INSTANCE;
    public static final int FAT_CONSUMPTION_FIELD_NUMBER = 5;
    public static final int FAT_GRAMS_FIELD_NUMBER = 8;
    public static final int FUELING_REMINDERS_FIELD_NUMBER = 10;
    public static final int MEAL_SIZE_FIELD_NUMBER = 9;
    private static volatile Parser<Structures$PbTrainingLoad> PARSER = null;
    public static final int PROTEIN_CONSUMPTION_FIELD_NUMBER = 4;
    public static final int PROTEIN_GRAMS_FIELD_NUMBER = 7;
    public static final int RECOVERY_TIME_FIELD_NUMBER = 2;
    public static final int TRAINING_LOAD_VAL_FIELD_NUMBER = 1;
    private int bitField0_;
    private int carbohydrateConsumption_;
    private float carbohydrateGrams_;
    private int fatConsumption_;
    private float fatGrams_;
    private float mealSize_;
    private int proteinConsumption_;
    private float proteinGrams_;
    private Types$PbDuration recoveryTime_;
    private int trainingLoadVal_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Structures$PbFuelingReminder> fuelingReminders_ = GeneratedMessageLite.emptyProtobufList();

    static {
        Structures$PbTrainingLoad structures$PbTrainingLoad = new Structures$PbTrainingLoad();
        DEFAULT_INSTANCE = structures$PbTrainingLoad;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbTrainingLoad.class, structures$PbTrainingLoad);
    }

    private Structures$PbTrainingLoad() {
    }

    private void addAllFuelingReminders(Iterable<? extends Structures$PbFuelingReminder> iterable) {
        ensureFuelingRemindersIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.fuelingReminders_);
    }

    private void addFuelingReminders(Structures$PbFuelingReminder structures$PbFuelingReminder) {
        structures$PbFuelingReminder.getClass();
        ensureFuelingRemindersIsMutable();
        this.fuelingReminders_.add(structures$PbFuelingReminder);
    }

    private void clearCarbohydrateConsumption() {
        this.bitField0_ &= -5;
        this.carbohydrateConsumption_ = 0;
    }

    private void clearCarbohydrateGrams() {
        this.bitField0_ &= -33;
        this.carbohydrateGrams_ = 0.0f;
    }

    private void clearFatConsumption() {
        this.bitField0_ &= -17;
        this.fatConsumption_ = 0;
    }

    private void clearFatGrams() {
        this.bitField0_ &= -129;
        this.fatGrams_ = 0.0f;
    }

    private void clearFuelingReminders() {
        this.fuelingReminders_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMealSize() {
        this.bitField0_ &= -257;
        this.mealSize_ = 0.0f;
    }

    private void clearProteinConsumption() {
        this.bitField0_ &= -9;
        this.proteinConsumption_ = 0;
    }

    private void clearProteinGrams() {
        this.bitField0_ &= -65;
        this.proteinGrams_ = 0.0f;
    }

    private void clearRecoveryTime() {
        this.recoveryTime_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTrainingLoadVal() {
        this.bitField0_ &= -2;
        this.trainingLoadVal_ = 0;
    }

    private void ensureFuelingRemindersIsMutable() {
        Internal.ProtobufList<Structures$PbFuelingReminder> protobufList = this.fuelingReminders_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.fuelingReminders_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Structures$PbTrainingLoad getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRecoveryTime(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.recoveryTime_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.recoveryTime_ = types$PbDuration;
        } else {
            this.recoveryTime_ = Types$PbDuration.newBuilder(this.recoveryTime_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbTrainingLoad parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbTrainingLoad parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbTrainingLoad> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFuelingReminders(int i) {
        ensureFuelingRemindersIsMutable();
        this.fuelingReminders_.remove(i);
    }

    private void setCarbohydrateConsumption(int i) {
        this.bitField0_ |= 4;
        this.carbohydrateConsumption_ = i;
    }

    private void setCarbohydrateGrams(float f) {
        this.bitField0_ |= 32;
        this.carbohydrateGrams_ = f;
    }

    private void setFatConsumption(int i) {
        this.bitField0_ |= 16;
        this.fatConsumption_ = i;
    }

    private void setFatGrams(float f) {
        this.bitField0_ |= 128;
        this.fatGrams_ = f;
    }

    private void setFuelingReminders(int i, Structures$PbFuelingReminder structures$PbFuelingReminder) {
        structures$PbFuelingReminder.getClass();
        ensureFuelingRemindersIsMutable();
        this.fuelingReminders_.set(i, structures$PbFuelingReminder);
    }

    private void setMealSize(float f) {
        this.bitField0_ |= 256;
        this.mealSize_ = f;
    }

    private void setProteinConsumption(int i) {
        this.bitField0_ |= 8;
        this.proteinConsumption_ = i;
    }

    private void setProteinGrams(float f) {
        this.bitField0_ |= 64;
        this.proteinGrams_ = f;
    }

    private void setRecoveryTime(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.recoveryTime_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    private void setTrainingLoadVal(int i) {
        this.bitField0_ |= 1;
        this.trainingLoadVal_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbTrainingLoad();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0001\u0001\u0001ဋ\u0000\u0002ဉ\u0001\u0003ဋ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tခ\b\nЛ", new Object[]{"bitField0_", "trainingLoadVal_", "recoveryTime_", "carbohydrateConsumption_", "proteinConsumption_", "fatConsumption_", "carbohydrateGrams_", "proteinGrams_", "fatGrams_", "mealSize_", "fuelingReminders_", Structures$PbFuelingReminder.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbTrainingLoad> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbTrainingLoad.class) {
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

    public int getCarbohydrateConsumption() {
        return this.carbohydrateConsumption_;
    }

    public float getCarbohydrateGrams() {
        return this.carbohydrateGrams_;
    }

    public int getFatConsumption() {
        return this.fatConsumption_;
    }

    public float getFatGrams() {
        return this.fatGrams_;
    }

    public Structures$PbFuelingReminder getFuelingReminders(int i) {
        return this.fuelingReminders_.get(i);
    }

    public int getFuelingRemindersCount() {
        return this.fuelingReminders_.size();
    }

    public List<Structures$PbFuelingReminder> getFuelingRemindersList() {
        return this.fuelingReminders_;
    }

    public Structures$PbFuelingReminderOrBuilder getFuelingRemindersOrBuilder(int i) {
        return this.fuelingReminders_.get(i);
    }

    public List<? extends Structures$PbFuelingReminderOrBuilder> getFuelingRemindersOrBuilderList() {
        return this.fuelingReminders_;
    }

    public float getMealSize() {
        return this.mealSize_;
    }

    public int getProteinConsumption() {
        return this.proteinConsumption_;
    }

    public float getProteinGrams() {
        return this.proteinGrams_;
    }

    public Types$PbDuration getRecoveryTime() {
        Types$PbDuration types$PbDuration = this.recoveryTime_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public int getTrainingLoadVal() {
        return this.trainingLoadVal_;
    }

    public boolean hasCarbohydrateConsumption() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasCarbohydrateGrams() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasFatConsumption() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasFatGrams() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasMealSize() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasProteinConsumption() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasProteinGrams() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasRecoveryTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTrainingLoadVal() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbTrainingLoad, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbTrainingLoad.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbTrainingLoad structures$PbTrainingLoad) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbTrainingLoad);
    }

    public static Structures$PbTrainingLoad parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbTrainingLoad parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbTrainingLoad parseFrom(ByteString byteString) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbTrainingLoad parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addFuelingReminders(int i, Structures$PbFuelingReminder structures$PbFuelingReminder) {
        structures$PbFuelingReminder.getClass();
        ensureFuelingRemindersIsMutable();
        this.fuelingReminders_.add(i, structures$PbFuelingReminder);
    }

    public static Structures$PbTrainingLoad parseFrom(byte[] bArr) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbTrainingLoad parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbTrainingLoad parseFrom(InputStream inputStream) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbTrainingLoad parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbTrainingLoad parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbTrainingLoad parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
