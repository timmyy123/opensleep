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
public final class SleepanalysisResult$PbSleepAnalysisResult extends GeneratedMessageLite<SleepanalysisResult$PbSleepAnalysisResult, Builder> implements MessageLiteOrBuilder {
    public static final int ALARM_TIME_FIELD_NUMBER = 7;
    public static final int BATTERY_RAN_OUT_FIELD_NUMBER = 12;
    public static final int CREATED_TIMESTAMP_FIELD_NUMBER = 15;
    private static final SleepanalysisResult$PbSleepAnalysisResult DEFAULT_INSTANCE;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 3;
    public static final int ORIGINAL_SLEEP_RANGE_FIELD_NUMBER = 16;
    private static volatile Parser<SleepanalysisResult$PbSleepAnalysisResult> PARSER = null;
    public static final int RECORDING_DEVICE_FIELD_NUMBER = 11;
    public static final int SLEEPWAKE_PHASES_FIELD_NUMBER = 5;
    public static final int SLEEP_CYCLES_FIELD_NUMBER = 13;
    public static final int SLEEP_END_OFFSET_SECONDS_FIELD_NUMBER = 9;
    public static final int SLEEP_END_TIME_FIELD_NUMBER = 2;
    public static final int SLEEP_GOAL_MINUTES_FIELD_NUMBER = 4;
    public static final int SLEEP_RESULT_DATE_FIELD_NUMBER = 14;
    public static final int SLEEP_START_OFFSET_SECONDS_FIELD_NUMBER = 8;
    public static final int SLEEP_START_TIME_FIELD_NUMBER = 1;
    public static final int SNOOZE_TIME_FIELD_NUMBER = 6;
    public static final int USER_SLEEP_RATING_FIELD_NUMBER = 10;
    private Types$PbLocalDateTime alarmTime_;
    private boolean batteryRanOut_;
    private int bitField0_;
    private Types$PbSystemDateTime createdTimestamp_;
    private Types$PbSystemDateTime lastModified_;
    private Types$PbLocalDateTimeRange originalSleepRange_;
    private Structures$PbDeviceId recordingDevice_;
    private int sleepEndOffsetSeconds_;
    private Types$PbLocalDateTime sleepEndTime_;
    private int sleepGoalMinutes_;
    private Types$PbDate sleepResultDate_;
    private int sleepStartOffsetSeconds_;
    private Types$PbLocalDateTime sleepStartTime_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<SleepanalysisResult$PbSleepWakePhase> sleepwakePhases_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<Types$PbLocalDateTime> snoozeTime_ = GeneratedMessageLite.emptyProtobufList();
    private int userSleepRating_ = -1;
    private Internal.ProtobufList<SleepanalysisResult$PbSleepCycle> sleepCycles_ = GeneratedMessageLite.emptyProtobufList();

    static {
        SleepanalysisResult$PbSleepAnalysisResult sleepanalysisResult$PbSleepAnalysisResult = new SleepanalysisResult$PbSleepAnalysisResult();
        DEFAULT_INSTANCE = sleepanalysisResult$PbSleepAnalysisResult;
        GeneratedMessageLite.registerDefaultInstance(SleepanalysisResult$PbSleepAnalysisResult.class, sleepanalysisResult$PbSleepAnalysisResult);
    }

    private SleepanalysisResult$PbSleepAnalysisResult() {
    }

    private void addAllSleepCycles(Iterable<? extends SleepanalysisResult$PbSleepCycle> iterable) {
        ensureSleepCyclesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.sleepCycles_);
    }

    private void addAllSleepwakePhases(Iterable<? extends SleepanalysisResult$PbSleepWakePhase> iterable) {
        ensureSleepwakePhasesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.sleepwakePhases_);
    }

    private void addAllSnoozeTime(Iterable<? extends Types$PbLocalDateTime> iterable) {
        ensureSnoozeTimeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.snoozeTime_);
    }

    private void addSleepCycles(SleepanalysisResult$PbSleepCycle sleepanalysisResult$PbSleepCycle) {
        sleepanalysisResult$PbSleepCycle.getClass();
        ensureSleepCyclesIsMutable();
        this.sleepCycles_.add(sleepanalysisResult$PbSleepCycle);
    }

    private void addSleepwakePhases(SleepanalysisResult$PbSleepWakePhase sleepanalysisResult$PbSleepWakePhase) {
        sleepanalysisResult$PbSleepWakePhase.getClass();
        ensureSleepwakePhasesIsMutable();
        this.sleepwakePhases_.add(sleepanalysisResult$PbSleepWakePhase);
    }

    private void addSnoozeTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        ensureSnoozeTimeIsMutable();
        this.snoozeTime_.add(types$PbLocalDateTime);
    }

    private void clearAlarmTime() {
        this.alarmTime_ = null;
        this.bitField0_ &= -17;
    }

    private void clearBatteryRanOut() {
        this.bitField0_ &= -513;
        this.batteryRanOut_ = false;
    }

    private void clearCreatedTimestamp() {
        this.createdTimestamp_ = null;
        this.bitField0_ &= -2049;
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -5;
    }

    private void clearOriginalSleepRange() {
        this.originalSleepRange_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearRecordingDevice() {
        this.recordingDevice_ = null;
        this.bitField0_ &= -257;
    }

    private void clearSleepCycles() {
        this.sleepCycles_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSleepEndOffsetSeconds() {
        this.bitField0_ &= -65;
        this.sleepEndOffsetSeconds_ = 0;
    }

    private void clearSleepEndTime() {
        this.sleepEndTime_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSleepGoalMinutes() {
        this.bitField0_ &= -9;
        this.sleepGoalMinutes_ = 0;
    }

    private void clearSleepResultDate() {
        this.sleepResultDate_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearSleepStartOffsetSeconds() {
        this.bitField0_ &= -33;
        this.sleepStartOffsetSeconds_ = 0;
    }

    private void clearSleepStartTime() {
        this.sleepStartTime_ = null;
        this.bitField0_ &= -2;
    }

    private void clearSleepwakePhases() {
        this.sleepwakePhases_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSnoozeTime() {
        this.snoozeTime_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUserSleepRating() {
        this.bitField0_ &= -129;
        this.userSleepRating_ = -1;
    }

    private void ensureSleepCyclesIsMutable() {
        Internal.ProtobufList<SleepanalysisResult$PbSleepCycle> protobufList = this.sleepCycles_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.sleepCycles_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSleepwakePhasesIsMutable() {
        Internal.ProtobufList<SleepanalysisResult$PbSleepWakePhase> protobufList = this.sleepwakePhases_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.sleepwakePhases_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSnoozeTimeIsMutable() {
        Internal.ProtobufList<Types$PbLocalDateTime> protobufList = this.snoozeTime_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.snoozeTime_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeAlarmTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        Types$PbLocalDateTime types$PbLocalDateTime2 = this.alarmTime_;
        if (types$PbLocalDateTime2 == null || types$PbLocalDateTime2 == Types$PbLocalDateTime.getDefaultInstance()) {
            this.alarmTime_ = types$PbLocalDateTime;
        } else {
            this.alarmTime_ = Types$PbLocalDateTime.newBuilder(this.alarmTime_).mergeFrom(types$PbLocalDateTime).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    private void mergeCreatedTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.createdTimestamp_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.createdTimestamp_ = types$PbSystemDateTime;
        } else {
            this.createdTimestamp_ = Types$PbSystemDateTime.newBuilder(this.createdTimestamp_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 2048;
    }

    private void mergeLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.lastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.lastModified_ = types$PbSystemDateTime;
        } else {
            this.lastModified_ = Types$PbSystemDateTime.newBuilder(this.lastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    private void mergeOriginalSleepRange(Types$PbLocalDateTimeRange types$PbLocalDateTimeRange) {
        types$PbLocalDateTimeRange.getClass();
        Types$PbLocalDateTimeRange types$PbLocalDateTimeRange2 = this.originalSleepRange_;
        if (types$PbLocalDateTimeRange2 == null || types$PbLocalDateTimeRange2 == Types$PbLocalDateTimeRange.getDefaultInstance()) {
            this.originalSleepRange_ = types$PbLocalDateTimeRange;
        } else {
            this.originalSleepRange_ = Types$PbLocalDateTimeRange.newBuilder(this.originalSleepRange_).mergeFrom(types$PbLocalDateTimeRange).buildPartial();
        }
        this.bitField0_ |= 4096;
    }

    private void mergeRecordingDevice(Structures$PbDeviceId structures$PbDeviceId) {
        structures$PbDeviceId.getClass();
        Structures$PbDeviceId structures$PbDeviceId2 = this.recordingDevice_;
        if (structures$PbDeviceId2 == null || structures$PbDeviceId2 == Structures$PbDeviceId.getDefaultInstance()) {
            this.recordingDevice_ = structures$PbDeviceId;
        } else {
            this.recordingDevice_ = Structures$PbDeviceId.newBuilder(this.recordingDevice_).mergeFrom(structures$PbDeviceId).buildPartial();
        }
        this.bitField0_ |= 256;
    }

    private void mergeSleepEndTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        Types$PbLocalDateTime types$PbLocalDateTime2 = this.sleepEndTime_;
        if (types$PbLocalDateTime2 == null || types$PbLocalDateTime2 == Types$PbLocalDateTime.getDefaultInstance()) {
            this.sleepEndTime_ = types$PbLocalDateTime;
        } else {
            this.sleepEndTime_ = Types$PbLocalDateTime.newBuilder(this.sleepEndTime_).mergeFrom(types$PbLocalDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeSleepResultDate(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        Types$PbDate types$PbDate2 = this.sleepResultDate_;
        if (types$PbDate2 == null || types$PbDate2 == Types$PbDate.getDefaultInstance()) {
            this.sleepResultDate_ = types$PbDate;
        } else {
            this.sleepResultDate_ = Types$PbDate.newBuilder(this.sleepResultDate_).mergeFrom(types$PbDate).buildPartial();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeSleepStartTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        Types$PbLocalDateTime types$PbLocalDateTime2 = this.sleepStartTime_;
        if (types$PbLocalDateTime2 == null || types$PbLocalDateTime2 == Types$PbLocalDateTime.getDefaultInstance()) {
            this.sleepStartTime_ = types$PbLocalDateTime;
        } else {
            this.sleepStartTime_ = Types$PbLocalDateTime.newBuilder(this.sleepStartTime_).mergeFrom(types$PbLocalDateTime).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseDelimitedFrom(InputStream inputStream) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(ByteBuffer byteBuffer) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SleepanalysisResult$PbSleepAnalysisResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeSleepCycles(int i) {
        ensureSleepCyclesIsMutable();
        this.sleepCycles_.remove(i);
    }

    private void removeSleepwakePhases(int i) {
        ensureSleepwakePhasesIsMutable();
        this.sleepwakePhases_.remove(i);
    }

    private void removeSnoozeTime(int i) {
        ensureSnoozeTimeIsMutable();
        this.snoozeTime_.remove(i);
    }

    private void setAlarmTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.alarmTime_ = types$PbLocalDateTime;
        this.bitField0_ |= 16;
    }

    private void setBatteryRanOut(boolean z) {
        this.bitField0_ |= 512;
        this.batteryRanOut_ = z;
    }

    private void setCreatedTimestamp(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.createdTimestamp_ = types$PbSystemDateTime;
        this.bitField0_ |= 2048;
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 4;
    }

    private void setOriginalSleepRange(Types$PbLocalDateTimeRange types$PbLocalDateTimeRange) {
        types$PbLocalDateTimeRange.getClass();
        this.originalSleepRange_ = types$PbLocalDateTimeRange;
        this.bitField0_ |= 4096;
    }

    private void setRecordingDevice(Structures$PbDeviceId structures$PbDeviceId) {
        structures$PbDeviceId.getClass();
        this.recordingDevice_ = structures$PbDeviceId;
        this.bitField0_ |= 256;
    }

    private void setSleepCycles(int i, SleepanalysisResult$PbSleepCycle sleepanalysisResult$PbSleepCycle) {
        sleepanalysisResult$PbSleepCycle.getClass();
        ensureSleepCyclesIsMutable();
        this.sleepCycles_.set(i, sleepanalysisResult$PbSleepCycle);
    }

    private void setSleepEndOffsetSeconds(int i) {
        this.bitField0_ |= 64;
        this.sleepEndOffsetSeconds_ = i;
    }

    private void setSleepEndTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.sleepEndTime_ = types$PbLocalDateTime;
        this.bitField0_ |= 2;
    }

    private void setSleepGoalMinutes(int i) {
        this.bitField0_ |= 8;
        this.sleepGoalMinutes_ = i;
    }

    private void setSleepResultDate(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        this.sleepResultDate_ = types$PbDate;
        this.bitField0_ |= 1024;
    }

    private void setSleepStartOffsetSeconds(int i) {
        this.bitField0_ |= 32;
        this.sleepStartOffsetSeconds_ = i;
    }

    private void setSleepStartTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.sleepStartTime_ = types$PbLocalDateTime;
        this.bitField0_ |= 1;
    }

    private void setSleepwakePhases(int i, SleepanalysisResult$PbSleepWakePhase sleepanalysisResult$PbSleepWakePhase) {
        sleepanalysisResult$PbSleepWakePhase.getClass();
        ensureSleepwakePhasesIsMutable();
        this.sleepwakePhases_.set(i, sleepanalysisResult$PbSleepWakePhase);
    }

    private void setSnoozeTime(int i, Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        ensureSnoozeTimeIsMutable();
        this.snoozeTime_.set(i, types$PbLocalDateTime);
    }

    private void setUserSleepRating(Types$PbSleepUserRating types$PbSleepUserRating) {
        this.userSleepRating_ = types$PbSleepUserRating.getNumber();
        this.bitField0_ |= 128;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (SleepanalysisResult$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SleepanalysisResult$PbSleepAnalysisResult();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0003\f\u0001ᔉ\u0000\u0002ᔉ\u0001\u0003ᔉ\u0002\u0004ᔋ\u0003\u0005Л\u0006Л\u0007ᐉ\u0004\bင\u0005\tင\u0006\nဌ\u0007\u000bᐉ\b\fဇ\t\rЛ\u000eᐉ\n\u000fᐉ\u000b\u0010ᐉ\f", new Object[]{"bitField0_", "sleepStartTime_", "sleepEndTime_", "lastModified_", "sleepGoalMinutes_", "sleepwakePhases_", SleepanalysisResult$PbSleepWakePhase.class, "snoozeTime_", Types$PbLocalDateTime.class, "alarmTime_", "sleepStartOffsetSeconds_", "sleepEndOffsetSeconds_", "userSleepRating_", Types$PbSleepUserRating.internalGetVerifier(), "recordingDevice_", "batteryRanOut_", "sleepCycles_", SleepanalysisResult$PbSleepCycle.class, "sleepResultDate_", "createdTimestamp_", "originalSleepRange_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SleepanalysisResult$PbSleepAnalysisResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SleepanalysisResult$PbSleepAnalysisResult.class) {
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

    public Types$PbLocalDateTime getAlarmTime() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.alarmTime_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public boolean getBatteryRanOut() {
        return this.batteryRanOut_;
    }

    public Types$PbSystemDateTime getCreatedTimestamp() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.createdTimestamp_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public Types$PbSystemDateTime getLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.lastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public Types$PbLocalDateTimeRange getOriginalSleepRange() {
        Types$PbLocalDateTimeRange types$PbLocalDateTimeRange = this.originalSleepRange_;
        return types$PbLocalDateTimeRange == null ? Types$PbLocalDateTimeRange.getDefaultInstance() : types$PbLocalDateTimeRange;
    }

    public Structures$PbDeviceId getRecordingDevice() {
        Structures$PbDeviceId structures$PbDeviceId = this.recordingDevice_;
        return structures$PbDeviceId == null ? Structures$PbDeviceId.getDefaultInstance() : structures$PbDeviceId;
    }

    public SleepanalysisResult$PbSleepCycle getSleepCycles(int i) {
        return this.sleepCycles_.get(i);
    }

    public int getSleepCyclesCount() {
        return this.sleepCycles_.size();
    }

    public List<SleepanalysisResult$PbSleepCycle> getSleepCyclesList() {
        return this.sleepCycles_;
    }

    public SleepanalysisResult$PbSleepCycleOrBuilder getSleepCyclesOrBuilder(int i) {
        return this.sleepCycles_.get(i);
    }

    public List<? extends SleepanalysisResult$PbSleepCycleOrBuilder> getSleepCyclesOrBuilderList() {
        return this.sleepCycles_;
    }

    public int getSleepEndOffsetSeconds() {
        return this.sleepEndOffsetSeconds_;
    }

    public Types$PbLocalDateTime getSleepEndTime() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.sleepEndTime_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public int getSleepGoalMinutes() {
        return this.sleepGoalMinutes_;
    }

    public Types$PbDate getSleepResultDate() {
        Types$PbDate types$PbDate = this.sleepResultDate_;
        return types$PbDate == null ? Types$PbDate.getDefaultInstance() : types$PbDate;
    }

    public int getSleepStartOffsetSeconds() {
        return this.sleepStartOffsetSeconds_;
    }

    public Types$PbLocalDateTime getSleepStartTime() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.sleepStartTime_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public SleepanalysisResult$PbSleepWakePhase getSleepwakePhases(int i) {
        return this.sleepwakePhases_.get(i);
    }

    public int getSleepwakePhasesCount() {
        return this.sleepwakePhases_.size();
    }

    public List<SleepanalysisResult$PbSleepWakePhase> getSleepwakePhasesList() {
        return this.sleepwakePhases_;
    }

    public SleepanalysisResult$PbSleepWakePhaseOrBuilder getSleepwakePhasesOrBuilder(int i) {
        return this.sleepwakePhases_.get(i);
    }

    public List<? extends SleepanalysisResult$PbSleepWakePhaseOrBuilder> getSleepwakePhasesOrBuilderList() {
        return this.sleepwakePhases_;
    }

    public Types$PbLocalDateTime getSnoozeTime(int i) {
        return this.snoozeTime_.get(i);
    }

    public int getSnoozeTimeCount() {
        return this.snoozeTime_.size();
    }

    public List<Types$PbLocalDateTime> getSnoozeTimeList() {
        return this.snoozeTime_;
    }

    public Types$PbLocalDateTimeOrBuilder getSnoozeTimeOrBuilder(int i) {
        return this.snoozeTime_.get(i);
    }

    public List<? extends Types$PbLocalDateTimeOrBuilder> getSnoozeTimeOrBuilderList() {
        return this.snoozeTime_;
    }

    public Types$PbSleepUserRating getUserSleepRating() {
        Types$PbSleepUserRating types$PbSleepUserRatingForNumber = Types$PbSleepUserRating.forNumber(this.userSleepRating_);
        return types$PbSleepUserRatingForNumber == null ? Types$PbSleepUserRating.PB_SLEPT_UNDEFINED : types$PbSleepUserRatingForNumber;
    }

    public boolean hasAlarmTime() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasBatteryRanOut() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasCreatedTimestamp() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasOriginalSleepRange() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasRecordingDevice() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasSleepEndOffsetSeconds() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasSleepEndTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSleepGoalMinutes() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSleepResultDate() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasSleepStartOffsetSeconds() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasSleepStartTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUserSleepRating() {
        return (this.bitField0_ & 128) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<SleepanalysisResult$PbSleepAnalysisResult, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(SleepanalysisResult$PbSleepAnalysisResult.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(SleepanalysisResult$PbSleepAnalysisResult sleepanalysisResult$PbSleepAnalysisResult) {
        return DEFAULT_INSTANCE.createBuilder(sleepanalysisResult$PbSleepAnalysisResult);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(ByteString byteString) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addSleepCycles(int i, SleepanalysisResult$PbSleepCycle sleepanalysisResult$PbSleepCycle) {
        sleepanalysisResult$PbSleepCycle.getClass();
        ensureSleepCyclesIsMutable();
        this.sleepCycles_.add(i, sleepanalysisResult$PbSleepCycle);
    }

    private void addSleepwakePhases(int i, SleepanalysisResult$PbSleepWakePhase sleepanalysisResult$PbSleepWakePhase) {
        sleepanalysisResult$PbSleepWakePhase.getClass();
        ensureSleepwakePhasesIsMutable();
        this.sleepwakePhases_.add(i, sleepanalysisResult$PbSleepWakePhase);
    }

    private void addSnoozeTime(int i, Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        ensureSnoozeTimeIsMutable();
        this.snoozeTime_.add(i, types$PbLocalDateTime);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(byte[] bArr) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(InputStream inputStream) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(CodedInputStream codedInputStream) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SleepanalysisResult$PbSleepAnalysisResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepAnalysisResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
