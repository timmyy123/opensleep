package fi.polar.remote.representation.protobuf;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
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
public final class TrainingSession$PbTrainingSession extends GeneratedMessageLite<TrainingSession$PbTrainingSession, Builder> implements MessageLiteOrBuilder {
    public static final int BENEFIT_FIELD_NUMBER = 17;
    public static final int CALORIES_FIELD_NUMBER = 7;
    public static final int CARDIO_LOAD_FIELD_NUMBER = 23;
    public static final int CARDIO_LOAD_INTERPRETATION_FIELD_NUMBER = 24;
    private static final TrainingSession$PbTrainingSession DEFAULT_INSTANCE;
    public static final int DEVICE_ID_FIELD_NUMBER = 3;
    public static final int DISTANCE_FIELD_NUMBER = 6;
    public static final int DURATION_FIELD_NUMBER = 5;
    public static final int END_FIELD_NUMBER = 20;
    public static final int EXERCISE_COUNT_FIELD_NUMBER = 2;
    public static final int FEELING_FIELD_NUMBER = 12;
    public static final int HEART_RATE_FIELD_NUMBER = 8;
    public static final int HEART_RATE_ZONE_DURATION_FIELD_NUMBER = 9;
    public static final int LATITUDE_FIELD_NUMBER = 15;
    public static final int LONGITUDE_FIELD_NUMBER = 16;
    public static final int MODEL_NAME_FIELD_NUMBER = 4;
    public static final int MUSCLE_LOAD_FIELD_NUMBER = 27;
    public static final int MUSCLE_LOAD_INTERPRETATION_FIELD_NUMBER = 28;
    public static final int NOTE_FIELD_NUMBER = 13;
    private static volatile Parser<TrainingSession$PbTrainingSession> PARSER = null;
    public static final int PERIOD_UUID_FIELD_NUMBER = 29;
    public static final int PLACE_FIELD_NUMBER = 14;
    public static final int SESSION_NAME_FIELD_NUMBER = 11;
    public static final int SPORT_FIELD_NUMBER = 18;
    public static final int START_FIELD_NUMBER = 1;
    public static final int START_TRIGGER_FIELD_NUMBER = 30;
    public static final int TRAINING_LOAD_FIELD_NUMBER = 10;
    private int bitField0_;
    private int calories_;
    private int cardioLoadInterpretation_;
    private Types$PbCardioLoad cardioLoad_;
    private float distance_;
    private Types$PbDuration duration_;
    private Types$PbLocalDateTime end_;
    private int exerciseCount_;
    private float feeling_;
    private TrainingSession$PbSessionHeartRateStatistics heartRate_;
    private double latitude_;
    private double longitude_;
    private int muscleLoadInterpretation_;
    private float muscleLoad_;
    private Structures$PbMultiLineText note_;
    private Structures$PbOneLineText place_;
    private Structures$PbOneLineText sessionName_;
    private Structures$PbSportIdentifier sport_;
    private int startTrigger_;
    private Types$PbLocalDateTime start_;
    private Structures$PbTrainingLoad trainingLoad_;
    private byte memoizedIsInitialized = 2;
    private String deviceId_ = "";
    private String modelName_ = "";
    private Internal.ProtobufList<Types$PbDuration> heartRateZoneDuration_ = GeneratedMessageLite.emptyProtobufList();
    private int benefit_ = 1;
    private ByteString periodUuid_ = ByteString.EMPTY;

    public enum PbTrainingStartTrigger implements Internal.EnumLite {
        MANUAL(0),
        AUTOMATIC_TRAINING_DETECTION(1);

        private static final Internal.EnumLiteMap<PbTrainingStartTrigger> internalValueMap = new Internal.EnumLiteMap<PbTrainingStartTrigger>() { // from class: fi.polar.remote.representation.protobuf.TrainingSession.PbTrainingSession.PbTrainingStartTrigger.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbTrainingStartTrigger findValueByNumber(int i) {
                return PbTrainingStartTrigger.forNumber(i);
            }
        };
        private final int value;

        public static final class PbTrainingStartTriggerVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbTrainingStartTriggerVerifier();

            private PbTrainingStartTriggerVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbTrainingStartTrigger.forNumber(i) != null;
            }
        }

        PbTrainingStartTrigger(int i) {
            this.value = i;
        }

        public static PbTrainingStartTrigger forNumber(int i) {
            if (i == 0) {
                return MANUAL;
            }
            if (i != 1) {
                return null;
            }
            return AUTOMATIC_TRAINING_DETECTION;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbTrainingStartTriggerVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        TrainingSession$PbTrainingSession trainingSession$PbTrainingSession = new TrainingSession$PbTrainingSession();
        DEFAULT_INSTANCE = trainingSession$PbTrainingSession;
        GeneratedMessageLite.registerDefaultInstance(TrainingSession$PbTrainingSession.class, trainingSession$PbTrainingSession);
    }

    private TrainingSession$PbTrainingSession() {
    }

    private void addAllHeartRateZoneDuration(Iterable<? extends Types$PbDuration> iterable) {
        ensureHeartRateZoneDurationIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.heartRateZoneDuration_);
    }

    private void addHeartRateZoneDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        ensureHeartRateZoneDurationIsMutable();
        this.heartRateZoneDuration_.add(types$PbDuration);
    }

    private void clearBenefit() {
        this.bitField0_ &= -65537;
        this.benefit_ = 1;
    }

    private void clearCalories() {
        this.bitField0_ &= -129;
        this.calories_ = 0;
    }

    private void clearCardioLoad() {
        this.cardioLoad_ = null;
        this.bitField0_ &= -262145;
    }

    private void clearCardioLoadInterpretation() {
        this.bitField0_ &= -524289;
        this.cardioLoadInterpretation_ = 0;
    }

    private void clearDeviceId() {
        this.bitField0_ &= -9;
        this.deviceId_ = getDefaultInstance().getDeviceId();
    }

    private void clearDistance() {
        this.bitField0_ &= -65;
        this.distance_ = 0.0f;
    }

    private void clearDuration() {
        this.duration_ = null;
        this.bitField0_ &= -33;
    }

    private void clearEnd() {
        this.end_ = null;
        this.bitField0_ &= -3;
    }

    private void clearExerciseCount() {
        this.bitField0_ &= -5;
        this.exerciseCount_ = 0;
    }

    private void clearFeeling() {
        this.bitField0_ &= -2049;
        this.feeling_ = 0.0f;
    }

    private void clearHeartRate() {
        this.heartRate_ = null;
        this.bitField0_ &= -257;
    }

    private void clearHeartRateZoneDuration() {
        this.heartRateZoneDuration_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearLatitude() {
        this.bitField0_ &= -16385;
        this.latitude_ = 0.0d;
    }

    private void clearLongitude() {
        this.bitField0_ &= -32769;
        this.longitude_ = 0.0d;
    }

    private void clearModelName() {
        this.bitField0_ &= -17;
        this.modelName_ = getDefaultInstance().getModelName();
    }

    private void clearMuscleLoad() {
        this.bitField0_ &= -1048577;
        this.muscleLoad_ = 0.0f;
    }

    private void clearMuscleLoadInterpretation() {
        this.bitField0_ &= -2097153;
        this.muscleLoadInterpretation_ = 0;
    }

    private void clearNote() {
        this.note_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearPeriodUuid() {
        this.bitField0_ &= -4194305;
        this.periodUuid_ = getDefaultInstance().getPeriodUuid();
    }

    private void clearPlace() {
        this.place_ = null;
        this.bitField0_ &= -8193;
    }

    private void clearSessionName() {
        this.sessionName_ = null;
        this.bitField0_ &= -1025;
    }

    private void clearSport() {
        this.sport_ = null;
        this.bitField0_ &= -131073;
    }

    private void clearStart() {
        this.start_ = null;
        this.bitField0_ &= -2;
    }

    private void clearStartTrigger() {
        this.bitField0_ &= -8388609;
        this.startTrigger_ = 0;
    }

    private void clearTrainingLoad() {
        this.trainingLoad_ = null;
        this.bitField0_ &= -513;
    }

    private void ensureHeartRateZoneDurationIsMutable() {
        Internal.ProtobufList<Types$PbDuration> protobufList = this.heartRateZoneDuration_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.heartRateZoneDuration_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static TrainingSession$PbTrainingSession getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCardioLoad(Types$PbCardioLoad types$PbCardioLoad) {
        types$PbCardioLoad.getClass();
        Types$PbCardioLoad types$PbCardioLoad2 = this.cardioLoad_;
        if (types$PbCardioLoad2 == null || types$PbCardioLoad2 == Types$PbCardioLoad.getDefaultInstance()) {
            this.cardioLoad_ = types$PbCardioLoad;
        } else {
            this.cardioLoad_ = Types$PbCardioLoad.newBuilder(this.cardioLoad_).mergeFrom(types$PbCardioLoad).buildPartial();
        }
        this.bitField0_ |= 262144;
    }

    private void mergeDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.duration_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.duration_ = types$PbDuration;
        } else {
            this.duration_ = Types$PbDuration.newBuilder(this.duration_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    private void mergeEnd(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        Types$PbLocalDateTime types$PbLocalDateTime2 = this.end_;
        if (types$PbLocalDateTime2 == null || types$PbLocalDateTime2 == Types$PbLocalDateTime.getDefaultInstance()) {
            this.end_ = types$PbLocalDateTime;
        } else {
            this.end_ = Types$PbLocalDateTime.newBuilder(this.end_).mergeFrom(types$PbLocalDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeHeartRate(TrainingSession$PbSessionHeartRateStatistics trainingSession$PbSessionHeartRateStatistics) {
        trainingSession$PbSessionHeartRateStatistics.getClass();
        TrainingSession$PbSessionHeartRateStatistics trainingSession$PbSessionHeartRateStatistics2 = this.heartRate_;
        if (trainingSession$PbSessionHeartRateStatistics2 == null || trainingSession$PbSessionHeartRateStatistics2 == TrainingSession$PbSessionHeartRateStatistics.getDefaultInstance()) {
            this.heartRate_ = trainingSession$PbSessionHeartRateStatistics;
        } else {
            this.heartRate_ = TrainingSession$PbSessionHeartRateStatistics.newBuilder(this.heartRate_).mergeFrom(trainingSession$PbSessionHeartRateStatistics).buildPartial();
        }
        this.bitField0_ |= 256;
    }

    private void mergeNote(Structures$PbMultiLineText structures$PbMultiLineText) {
        structures$PbMultiLineText.getClass();
        Structures$PbMultiLineText structures$PbMultiLineText2 = this.note_;
        if (structures$PbMultiLineText2 == null || structures$PbMultiLineText2 == Structures$PbMultiLineText.getDefaultInstance()) {
            this.note_ = structures$PbMultiLineText;
        } else {
            this.note_ = Structures$PbMultiLineText.newBuilder(this.note_).mergeFrom(structures$PbMultiLineText).buildPartial();
        }
        this.bitField0_ |= 4096;
    }

    private void mergePlace(Structures$PbOneLineText structures$PbOneLineText) {
        structures$PbOneLineText.getClass();
        Structures$PbOneLineText structures$PbOneLineText2 = this.place_;
        if (structures$PbOneLineText2 == null || structures$PbOneLineText2 == Structures$PbOneLineText.getDefaultInstance()) {
            this.place_ = structures$PbOneLineText;
        } else {
            this.place_ = Structures$PbOneLineText.newBuilder(this.place_).mergeFrom(structures$PbOneLineText).buildPartial();
        }
        this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    private void mergeSessionName(Structures$PbOneLineText structures$PbOneLineText) {
        structures$PbOneLineText.getClass();
        Structures$PbOneLineText structures$PbOneLineText2 = this.sessionName_;
        if (structures$PbOneLineText2 == null || structures$PbOneLineText2 == Structures$PbOneLineText.getDefaultInstance()) {
            this.sessionName_ = structures$PbOneLineText;
        } else {
            this.sessionName_ = Structures$PbOneLineText.newBuilder(this.sessionName_).mergeFrom(structures$PbOneLineText).buildPartial();
        }
        this.bitField0_ |= 1024;
    }

    private void mergeSport(Structures$PbSportIdentifier structures$PbSportIdentifier) {
        structures$PbSportIdentifier.getClass();
        Structures$PbSportIdentifier structures$PbSportIdentifier2 = this.sport_;
        if (structures$PbSportIdentifier2 == null || structures$PbSportIdentifier2 == Structures$PbSportIdentifier.getDefaultInstance()) {
            this.sport_ = structures$PbSportIdentifier;
        } else {
            this.sport_ = Structures$PbSportIdentifier.newBuilder(this.sport_).mergeFrom(structures$PbSportIdentifier).buildPartial();
        }
        this.bitField0_ |= 131072;
    }

    private void mergeStart(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        Types$PbLocalDateTime types$PbLocalDateTime2 = this.start_;
        if (types$PbLocalDateTime2 == null || types$PbLocalDateTime2 == Types$PbLocalDateTime.getDefaultInstance()) {
            this.start_ = types$PbLocalDateTime;
        } else {
            this.start_ = Types$PbLocalDateTime.newBuilder(this.start_).mergeFrom(types$PbLocalDateTime).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    private void mergeTrainingLoad(Structures$PbTrainingLoad structures$PbTrainingLoad) {
        structures$PbTrainingLoad.getClass();
        Structures$PbTrainingLoad structures$PbTrainingLoad2 = this.trainingLoad_;
        if (structures$PbTrainingLoad2 == null || structures$PbTrainingLoad2 == Structures$PbTrainingLoad.getDefaultInstance()) {
            this.trainingLoad_ = structures$PbTrainingLoad;
        } else {
            this.trainingLoad_ = Structures$PbTrainingLoad.newBuilder(this.trainingLoad_).mergeFrom(structures$PbTrainingLoad).buildPartial();
        }
        this.bitField0_ |= 512;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TrainingSession$PbTrainingSession parseDelimitedFrom(InputStream inputStream) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TrainingSession$PbTrainingSession parseFrom(ByteBuffer byteBuffer) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TrainingSession$PbTrainingSession> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeHeartRateZoneDuration(int i) {
        ensureHeartRateZoneDurationIsMutable();
        this.heartRateZoneDuration_.remove(i);
    }

    private void setBenefit(Types$PbExerciseFeedback types$PbExerciseFeedback) {
        this.benefit_ = types$PbExerciseFeedback.getNumber();
        this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    private void setCalories(int i) {
        this.bitField0_ |= 128;
        this.calories_ = i;
    }

    private void setCardioLoad(Types$PbCardioLoad types$PbCardioLoad) {
        types$PbCardioLoad.getClass();
        this.cardioLoad_ = types$PbCardioLoad;
        this.bitField0_ |= 262144;
    }

    private void setCardioLoadInterpretation(int i) {
        this.bitField0_ |= 524288;
        this.cardioLoadInterpretation_ = i;
    }

    private void setDeviceId(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.deviceId_ = str;
    }

    private void setDeviceIdBytes(ByteString byteString) {
        this.deviceId_ = byteString.toStringUtf8();
        this.bitField0_ |= 8;
    }

    private void setDistance(float f) {
        this.bitField0_ |= 64;
        this.distance_ = f;
    }

    private void setDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.duration_ = types$PbDuration;
        this.bitField0_ |= 32;
    }

    private void setEnd(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.end_ = types$PbLocalDateTime;
        this.bitField0_ |= 2;
    }

    private void setExerciseCount(int i) {
        this.bitField0_ |= 4;
        this.exerciseCount_ = i;
    }

    private void setFeeling(float f) {
        this.bitField0_ |= 2048;
        this.feeling_ = f;
    }

    private void setHeartRate(TrainingSession$PbSessionHeartRateStatistics trainingSession$PbSessionHeartRateStatistics) {
        trainingSession$PbSessionHeartRateStatistics.getClass();
        this.heartRate_ = trainingSession$PbSessionHeartRateStatistics;
        this.bitField0_ |= 256;
    }

    private void setHeartRateZoneDuration(int i, Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        ensureHeartRateZoneDurationIsMutable();
        this.heartRateZoneDuration_.set(i, types$PbDuration);
    }

    private void setLatitude(double d) {
        this.bitField0_ |= 16384;
        this.latitude_ = d;
    }

    private void setLongitude(double d) {
        this.bitField0_ |= 32768;
        this.longitude_ = d;
    }

    private void setModelName(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.modelName_ = str;
    }

    private void setModelNameBytes(ByteString byteString) {
        this.modelName_ = byteString.toStringUtf8();
        this.bitField0_ |= 16;
    }

    private void setMuscleLoad(float f) {
        this.bitField0_ |= 1048576;
        this.muscleLoad_ = f;
    }

    private void setMuscleLoadInterpretation(int i) {
        this.bitField0_ |= 2097152;
        this.muscleLoadInterpretation_ = i;
    }

    private void setNote(Structures$PbMultiLineText structures$PbMultiLineText) {
        structures$PbMultiLineText.getClass();
        this.note_ = structures$PbMultiLineText;
        this.bitField0_ |= 4096;
    }

    private void setPeriodUuid(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 4194304;
        this.periodUuid_ = byteString;
    }

    private void setPlace(Structures$PbOneLineText structures$PbOneLineText) {
        structures$PbOneLineText.getClass();
        this.place_ = structures$PbOneLineText;
        this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    private void setSessionName(Structures$PbOneLineText structures$PbOneLineText) {
        structures$PbOneLineText.getClass();
        this.sessionName_ = structures$PbOneLineText;
        this.bitField0_ |= 1024;
    }

    private void setSport(Structures$PbSportIdentifier structures$PbSportIdentifier) {
        structures$PbSportIdentifier.getClass();
        this.sport_ = structures$PbSportIdentifier;
        this.bitField0_ |= 131072;
    }

    private void setStart(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.start_ = types$PbLocalDateTime;
        this.bitField0_ |= 1;
    }

    private void setStartTrigger(PbTrainingStartTrigger pbTrainingStartTrigger) {
        this.startTrigger_ = pbTrainingStartTrigger.getNumber();
        this.bitField0_ |= 8388608;
    }

    private void setTrainingLoad(Structures$PbTrainingLoad structures$PbTrainingLoad) {
        structures$PbTrainingLoad.getClass();
        this.trainingLoad_ = structures$PbTrainingLoad;
        this.bitField0_ |= 512;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (TrainingSession$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TrainingSession$PbTrainingSession();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0019\u0000\u0001\u0001\u001e\u0019\u0000\u0001\t\u0001ᔉ\u0000\u0002ᔋ\u0002\u0003ဈ\u0003\u0004ဈ\u0004\u0005ဉ\u0005\u0006ခ\u0006\u0007ဋ\u0007\bဉ\b\t\u001b\nᐉ\t\u000bᐉ\n\fခ\u000b\rᐉ\f\u000eᐉ\r\u000fက\u000e\u0010က\u000f\u0011ဌ\u0010\u0012ᐉ\u0011\u0014ᐉ\u0001\u0017ᐉ\u0012\u0018ဋ\u0013\u001bခ\u0014\u001cဋ\u0015\u001dည\u0016\u001eဌ\u0017", new Object[]{"bitField0_", "start_", "exerciseCount_", "deviceId_", "modelName_", "duration_", "distance_", "calories_", "heartRate_", "heartRateZoneDuration_", Types$PbDuration.class, "trainingLoad_", "sessionName_", "feeling_", "note_", "place_", "latitude_", "longitude_", "benefit_", Types$PbExerciseFeedback.internalGetVerifier(), "sport_", "end_", "cardioLoad_", "cardioLoadInterpretation_", "muscleLoad_", "muscleLoadInterpretation_", "periodUuid_", "startTrigger_", PbTrainingStartTrigger.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TrainingSession$PbTrainingSession> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TrainingSession$PbTrainingSession.class) {
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

    public Types$PbExerciseFeedback getBenefit() {
        Types$PbExerciseFeedback types$PbExerciseFeedbackForNumber = Types$PbExerciseFeedback.forNumber(this.benefit_);
        return types$PbExerciseFeedbackForNumber == null ? Types$PbExerciseFeedback.FEEDBACK_NONE : types$PbExerciseFeedbackForNumber;
    }

    public int getCalories() {
        return this.calories_;
    }

    public Types$PbCardioLoad getCardioLoad() {
        Types$PbCardioLoad types$PbCardioLoad = this.cardioLoad_;
        return types$PbCardioLoad == null ? Types$PbCardioLoad.getDefaultInstance() : types$PbCardioLoad;
    }

    public int getCardioLoadInterpretation() {
        return this.cardioLoadInterpretation_;
    }

    public String getDeviceId() {
        return this.deviceId_;
    }

    public ByteString getDeviceIdBytes() {
        return ByteString.copyFromUtf8(this.deviceId_);
    }

    public float getDistance() {
        return this.distance_;
    }

    public Types$PbDuration getDuration() {
        Types$PbDuration types$PbDuration = this.duration_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbLocalDateTime getEnd() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.end_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public int getExerciseCount() {
        return this.exerciseCount_;
    }

    public float getFeeling() {
        return this.feeling_;
    }

    public TrainingSession$PbSessionHeartRateStatistics getHeartRate() {
        TrainingSession$PbSessionHeartRateStatistics trainingSession$PbSessionHeartRateStatistics = this.heartRate_;
        return trainingSession$PbSessionHeartRateStatistics == null ? TrainingSession$PbSessionHeartRateStatistics.getDefaultInstance() : trainingSession$PbSessionHeartRateStatistics;
    }

    public Types$PbDuration getHeartRateZoneDuration(int i) {
        return this.heartRateZoneDuration_.get(i);
    }

    public int getHeartRateZoneDurationCount() {
        return this.heartRateZoneDuration_.size();
    }

    public List<Types$PbDuration> getHeartRateZoneDurationList() {
        return this.heartRateZoneDuration_;
    }

    public Types$PbDurationOrBuilder getHeartRateZoneDurationOrBuilder(int i) {
        return this.heartRateZoneDuration_.get(i);
    }

    public List<? extends Types$PbDurationOrBuilder> getHeartRateZoneDurationOrBuilderList() {
        return this.heartRateZoneDuration_;
    }

    public double getLatitude() {
        return this.latitude_;
    }

    public double getLongitude() {
        return this.longitude_;
    }

    public String getModelName() {
        return this.modelName_;
    }

    public ByteString getModelNameBytes() {
        return ByteString.copyFromUtf8(this.modelName_);
    }

    public float getMuscleLoad() {
        return this.muscleLoad_;
    }

    public int getMuscleLoadInterpretation() {
        return this.muscleLoadInterpretation_;
    }

    public Structures$PbMultiLineText getNote() {
        Structures$PbMultiLineText structures$PbMultiLineText = this.note_;
        return structures$PbMultiLineText == null ? Structures$PbMultiLineText.getDefaultInstance() : structures$PbMultiLineText;
    }

    public ByteString getPeriodUuid() {
        return this.periodUuid_;
    }

    public Structures$PbOneLineText getPlace() {
        Structures$PbOneLineText structures$PbOneLineText = this.place_;
        return structures$PbOneLineText == null ? Structures$PbOneLineText.getDefaultInstance() : structures$PbOneLineText;
    }

    public Structures$PbOneLineText getSessionName() {
        Structures$PbOneLineText structures$PbOneLineText = this.sessionName_;
        return structures$PbOneLineText == null ? Structures$PbOneLineText.getDefaultInstance() : structures$PbOneLineText;
    }

    public Structures$PbSportIdentifier getSport() {
        Structures$PbSportIdentifier structures$PbSportIdentifier = this.sport_;
        return structures$PbSportIdentifier == null ? Structures$PbSportIdentifier.getDefaultInstance() : structures$PbSportIdentifier;
    }

    public Types$PbLocalDateTime getStart() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.start_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public PbTrainingStartTrigger getStartTrigger() {
        PbTrainingStartTrigger pbTrainingStartTriggerForNumber = PbTrainingStartTrigger.forNumber(this.startTrigger_);
        return pbTrainingStartTriggerForNumber == null ? PbTrainingStartTrigger.MANUAL : pbTrainingStartTriggerForNumber;
    }

    public Structures$PbTrainingLoad getTrainingLoad() {
        Structures$PbTrainingLoad structures$PbTrainingLoad = this.trainingLoad_;
        return structures$PbTrainingLoad == null ? Structures$PbTrainingLoad.getDefaultInstance() : structures$PbTrainingLoad;
    }

    public boolean hasBenefit() {
        return (this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0;
    }

    public boolean hasCalories() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasCardioLoad() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasCardioLoadInterpretation() {
        return (this.bitField0_ & 524288) != 0;
    }

    public boolean hasDeviceId() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDistance() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasDuration() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasEnd() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasExerciseCount() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasFeeling() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasHeartRate() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasLatitude() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasLongitude() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasModelName() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasMuscleLoad() {
        return (this.bitField0_ & 1048576) != 0;
    }

    public boolean hasMuscleLoadInterpretation() {
        return (this.bitField0_ & 2097152) != 0;
    }

    public boolean hasNote() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasPeriodUuid() {
        return (this.bitField0_ & 4194304) != 0;
    }

    public boolean hasPlace() {
        return (this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public boolean hasSessionName() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasSport() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasStart() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasStartTrigger() {
        return (this.bitField0_ & 8388608) != 0;
    }

    public boolean hasTrainingLoad() {
        return (this.bitField0_ & 512) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<TrainingSession$PbTrainingSession, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(TrainingSession$PbTrainingSession.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(TrainingSession$PbTrainingSession trainingSession$PbTrainingSession) {
        return DEFAULT_INSTANCE.createBuilder(trainingSession$PbTrainingSession);
    }

    public static TrainingSession$PbTrainingSession parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TrainingSession$PbTrainingSession parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TrainingSession$PbTrainingSession parseFrom(ByteString byteString) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TrainingSession$PbTrainingSession parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addHeartRateZoneDuration(int i, Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        ensureHeartRateZoneDurationIsMutable();
        this.heartRateZoneDuration_.add(i, types$PbDuration);
    }

    public static TrainingSession$PbTrainingSession parseFrom(byte[] bArr) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TrainingSession$PbTrainingSession parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TrainingSession$PbTrainingSession parseFrom(InputStream inputStream) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TrainingSession$PbTrainingSession parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TrainingSession$PbTrainingSession parseFrom(CodedInputStream codedInputStream) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TrainingSession$PbTrainingSession parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbTrainingSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
