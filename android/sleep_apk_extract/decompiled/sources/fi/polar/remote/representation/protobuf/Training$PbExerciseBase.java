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
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Training$PbExerciseBase extends GeneratedMessageLite<Training$PbExerciseBase, Builder> implements MessageLiteOrBuilder {
    public static final int ACCUMULATED_TORQUE_FIELD_NUMBER = 20;
    public static final int ASCENT_FIELD_NUMBER = 10;
    public static final int AVAILABLE_SENSOR_FEATURES_FIELD_NUMBER = 7;
    public static final int CALORIES_FIELD_NUMBER = 5;
    public static final int CARDIO_LOAD_FIELD_NUMBER = 25;
    public static final int CARDIO_LOAD_INTERPRETATION_FIELD_NUMBER = 26;
    public static final int CYCLING_POWER_ENERGY_FIELD_NUMBER = 21;
    private static final Training$PbExerciseBase DEFAULT_INSTANCE;
    public static final int DESCENT_FIELD_NUMBER = 11;
    public static final int DEVICE_LOCATION_FIELD_NUMBER = 23;
    public static final int DISTANCE_FIELD_NUMBER = 4;
    public static final int DURATION_FIELD_NUMBER = 2;
    public static final int EXERCISE_COUNTERS_FIELD_NUMBER = 16;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 100;
    public static final int LATITUDE_FIELD_NUMBER = 12;
    public static final int LONGITUDE_FIELD_NUMBER = 13;
    public static final int MUSCLE_LOAD_FIELD_NUMBER = 29;
    public static final int MUSCLE_LOAD_INTERPRETATION_FIELD_NUMBER = 30;
    public static final int OBSOLETE_SPEED_CALIBRATION_OFFSET_FIELD_NUMBER = 17;
    private static volatile Parser<Training$PbExerciseBase> PARSER = null;
    public static final int PERCEIVED_LOAD_FIELD_NUMBER = 27;
    public static final int PERCEIVED_LOAD_INTERPRETATION_FIELD_NUMBER = 28;
    public static final int PLACE_FIELD_NUMBER = 14;
    public static final int POWER_SAMPLE_SOURCE_DEVICE_FIELD_NUMBER = 24;
    public static final int RUNNING_INDEX_FIELD_NUMBER = 9;
    public static final int SENSOR_CALIBRATION_OFFSET_FIELD_NUMBER = 22;
    public static final int SPORT_FIELD_NUMBER = 3;
    public static final int START_FIELD_NUMBER = 1;
    public static final int TRAINING_LOAD_FIELD_NUMBER = 6;
    public static final int WALKING_DISTANCE_FIELD_NUMBER = 18;
    public static final int WALKING_DURATION_FIELD_NUMBER = 19;
    private static final Internal.ListAdapter.Converter<Integer, Types$PbFeatureType> availableSensorFeatures_converter_ = new Internal.ListAdapter.Converter<Integer, Types$PbFeatureType>() { // from class: fi.polar.remote.representation.protobuf.Training$PbExerciseBase.1
        @Override // com.google.protobuf.Internal.ListAdapter.Converter
        public Types$PbFeatureType convert(Integer num) {
            Types$PbFeatureType types$PbFeatureTypeForNumber = Types$PbFeatureType.forNumber(num.intValue());
            return types$PbFeatureTypeForNumber == null ? Types$PbFeatureType.FEATURE_TYPE_HEART_RATE : types$PbFeatureTypeForNumber;
        }
    };
    private int accumulatedTorque_;
    private float ascent_;
    private int bitField0_;
    private int calories_;
    private int cardioLoadInterpretation_;
    private Types$PbCardioLoad cardioLoad_;
    private int cyclingPowerEnergy_;
    private float descent_;
    private int deviceLocation_;
    private float distance_;
    private Types$PbDuration duration_;
    private Training$PbExerciseCounters exerciseCounters_;
    private Types$PbSystemDateTime lastModified_;
    private double latitude_;
    private double longitude_;
    private int muscleLoadInterpretation_;
    private float muscleLoad_;
    private float oBSOLETESpeedCalibrationOffset_;
    private int perceivedLoadInterpretation_;
    private Types$PbPerceivedLoad perceivedLoad_;
    private Structures$PbRunningIndex runningIndex_;
    private Structures$PbSportIdentifier sport_;
    private Types$PbLocalDateTime start_;
    private Structures$PbTrainingLoad trainingLoad_;
    private float walkingDistance_;
    private Types$PbDuration walkingDuration_;
    private byte memoizedIsInitialized = 2;
    private Internal.IntList availableSensorFeatures_ = GeneratedMessageLite.emptyIntList();
    private String place_ = "";
    private Internal.ProtobufList<Types$PbSensorCalibrationOffset> sensorCalibrationOffset_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<Structures$PbSampleSourceDevice> powerSampleSourceDevice_ = GeneratedMessageLite.emptyProtobufList();

    static {
        Training$PbExerciseBase training$PbExerciseBase = new Training$PbExerciseBase();
        DEFAULT_INSTANCE = training$PbExerciseBase;
        GeneratedMessageLite.registerDefaultInstance(Training$PbExerciseBase.class, training$PbExerciseBase);
    }

    private Training$PbExerciseBase() {
    }

    private void addAllAvailableSensorFeatures(Iterable<? extends Types$PbFeatureType> iterable) {
        ensureAvailableSensorFeaturesIsMutable();
        Iterator<? extends Types$PbFeatureType> it = iterable.iterator();
        while (it.hasNext()) {
            this.availableSensorFeatures_.addInt(it.next().getNumber());
        }
    }

    private void addAllPowerSampleSourceDevice(Iterable<? extends Structures$PbSampleSourceDevice> iterable) {
        ensurePowerSampleSourceDeviceIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.powerSampleSourceDevice_);
    }

    private void addAllSensorCalibrationOffset(Iterable<? extends Types$PbSensorCalibrationOffset> iterable) {
        ensureSensorCalibrationOffsetIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.sensorCalibrationOffset_);
    }

    private void addAvailableSensorFeatures(Types$PbFeatureType types$PbFeatureType) {
        types$PbFeatureType.getClass();
        ensureAvailableSensorFeaturesIsMutable();
        this.availableSensorFeatures_.addInt(types$PbFeatureType.getNumber());
    }

    private void addPowerSampleSourceDevice(Structures$PbSampleSourceDevice structures$PbSampleSourceDevice) {
        structures$PbSampleSourceDevice.getClass();
        ensurePowerSampleSourceDeviceIsMutable();
        this.powerSampleSourceDevice_.add(structures$PbSampleSourceDevice);
    }

    private void addSensorCalibrationOffset(Types$PbSensorCalibrationOffset types$PbSensorCalibrationOffset) {
        types$PbSensorCalibrationOffset.getClass();
        ensureSensorCalibrationOffsetIsMutable();
        this.sensorCalibrationOffset_.add(types$PbSensorCalibrationOffset);
    }

    private void clearAccumulatedTorque() {
        this.bitField0_ &= -65537;
        this.accumulatedTorque_ = 0;
    }

    private void clearAscent() {
        this.bitField0_ &= -129;
        this.ascent_ = 0.0f;
    }

    private void clearAvailableSensorFeatures() {
        this.availableSensorFeatures_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearCalories() {
        this.bitField0_ &= -17;
        this.calories_ = 0;
    }

    private void clearCardioLoad() {
        this.cardioLoad_ = null;
        this.bitField0_ &= -524289;
    }

    private void clearCardioLoadInterpretation() {
        this.bitField0_ &= -1048577;
        this.cardioLoadInterpretation_ = 0;
    }

    private void clearCyclingPowerEnergy() {
        this.bitField0_ &= -131073;
        this.cyclingPowerEnergy_ = 0;
    }

    private void clearDescent() {
        this.bitField0_ &= -257;
        this.descent_ = 0.0f;
    }

    private void clearDeviceLocation() {
        this.bitField0_ &= -262145;
        this.deviceLocation_ = 0;
    }

    private void clearDistance() {
        this.bitField0_ &= -9;
        this.distance_ = 0.0f;
    }

    private void clearDuration() {
        this.duration_ = null;
        this.bitField0_ &= -3;
    }

    private void clearExerciseCounters() {
        this.exerciseCounters_ = null;
        this.bitField0_ &= -4097;
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -33554433;
    }

    private void clearLatitude() {
        this.bitField0_ &= -513;
        this.latitude_ = 0.0d;
    }

    private void clearLongitude() {
        this.bitField0_ &= -1025;
        this.longitude_ = 0.0d;
    }

    private void clearMuscleLoad() {
        this.bitField0_ &= -8388609;
        this.muscleLoad_ = 0.0f;
    }

    private void clearMuscleLoadInterpretation() {
        this.bitField0_ &= -16777217;
        this.muscleLoadInterpretation_ = 0;
    }

    private void clearOBSOLETESpeedCalibrationOffset() {
        this.bitField0_ &= -8193;
        this.oBSOLETESpeedCalibrationOffset_ = 0.0f;
    }

    private void clearPerceivedLoad() {
        this.perceivedLoad_ = null;
        this.bitField0_ &= -2097153;
    }

    private void clearPerceivedLoadInterpretation() {
        this.bitField0_ &= -4194305;
        this.perceivedLoadInterpretation_ = 0;
    }

    private void clearPlace() {
        this.bitField0_ &= -2049;
        this.place_ = getDefaultInstance().getPlace();
    }

    private void clearPowerSampleSourceDevice() {
        this.powerSampleSourceDevice_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearRunningIndex() {
        this.runningIndex_ = null;
        this.bitField0_ &= -65;
    }

    private void clearSensorCalibrationOffset() {
        this.sensorCalibrationOffset_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSport() {
        this.sport_ = null;
        this.bitField0_ &= -5;
    }

    private void clearStart() {
        this.start_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTrainingLoad() {
        this.trainingLoad_ = null;
        this.bitField0_ &= -33;
    }

    private void clearWalkingDistance() {
        this.bitField0_ &= -16385;
        this.walkingDistance_ = 0.0f;
    }

    private void clearWalkingDuration() {
        this.walkingDuration_ = null;
        this.bitField0_ &= -32769;
    }

    private void ensureAvailableSensorFeaturesIsMutable() {
        Internal.IntList intList = this.availableSensorFeatures_;
        if (intList.isModifiable()) {
            return;
        }
        this.availableSensorFeatures_ = GeneratedMessageLite.mutableCopy(intList);
    }

    private void ensurePowerSampleSourceDeviceIsMutable() {
        Internal.ProtobufList<Structures$PbSampleSourceDevice> protobufList = this.powerSampleSourceDevice_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.powerSampleSourceDevice_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSensorCalibrationOffsetIsMutable() {
        Internal.ProtobufList<Types$PbSensorCalibrationOffset> protobufList = this.sensorCalibrationOffset_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.sensorCalibrationOffset_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Training$PbExerciseBase getDefaultInstance() {
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
        this.bitField0_ |= 524288;
    }

    private void mergeDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.duration_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.duration_ = types$PbDuration;
        } else {
            this.duration_ = Types$PbDuration.newBuilder(this.duration_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeExerciseCounters(Training$PbExerciseCounters training$PbExerciseCounters) {
        training$PbExerciseCounters.getClass();
        Training$PbExerciseCounters training$PbExerciseCounters2 = this.exerciseCounters_;
        if (training$PbExerciseCounters2 == null || training$PbExerciseCounters2 == Training$PbExerciseCounters.getDefaultInstance()) {
            this.exerciseCounters_ = training$PbExerciseCounters;
        } else {
            this.exerciseCounters_ = Training$PbExerciseCounters.newBuilder(this.exerciseCounters_).mergeFrom(training$PbExerciseCounters).buildPartial();
        }
        this.bitField0_ |= 4096;
    }

    private void mergeLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.lastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.lastModified_ = types$PbSystemDateTime;
        } else {
            this.lastModified_ = Types$PbSystemDateTime.newBuilder(this.lastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 33554432;
    }

    private void mergePerceivedLoad(Types$PbPerceivedLoad types$PbPerceivedLoad) {
        types$PbPerceivedLoad.getClass();
        Types$PbPerceivedLoad types$PbPerceivedLoad2 = this.perceivedLoad_;
        if (types$PbPerceivedLoad2 == null || types$PbPerceivedLoad2 == Types$PbPerceivedLoad.getDefaultInstance()) {
            this.perceivedLoad_ = types$PbPerceivedLoad;
        } else {
            this.perceivedLoad_ = Types$PbPerceivedLoad.newBuilder(this.perceivedLoad_).mergeFrom(types$PbPerceivedLoad).buildPartial();
        }
        this.bitField0_ |= 2097152;
    }

    private void mergeRunningIndex(Structures$PbRunningIndex structures$PbRunningIndex) {
        structures$PbRunningIndex.getClass();
        Structures$PbRunningIndex structures$PbRunningIndex2 = this.runningIndex_;
        if (structures$PbRunningIndex2 == null || structures$PbRunningIndex2 == Structures$PbRunningIndex.getDefaultInstance()) {
            this.runningIndex_ = structures$PbRunningIndex;
        } else {
            this.runningIndex_ = Structures$PbRunningIndex.newBuilder(this.runningIndex_).mergeFrom(structures$PbRunningIndex).buildPartial();
        }
        this.bitField0_ |= 64;
    }

    private void mergeSport(Structures$PbSportIdentifier structures$PbSportIdentifier) {
        structures$PbSportIdentifier.getClass();
        Structures$PbSportIdentifier structures$PbSportIdentifier2 = this.sport_;
        if (structures$PbSportIdentifier2 == null || structures$PbSportIdentifier2 == Structures$PbSportIdentifier.getDefaultInstance()) {
            this.sport_ = structures$PbSportIdentifier;
        } else {
            this.sport_ = Structures$PbSportIdentifier.newBuilder(this.sport_).mergeFrom(structures$PbSportIdentifier).buildPartial();
        }
        this.bitField0_ |= 4;
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
        this.bitField0_ |= 32;
    }

    private void mergeWalkingDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.walkingDuration_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.walkingDuration_ = types$PbDuration;
        } else {
            this.walkingDuration_ = Types$PbDuration.newBuilder(this.walkingDuration_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 32768;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Training$PbExerciseBase parseDelimitedFrom(InputStream inputStream) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Training$PbExerciseBase parseFrom(ByteBuffer byteBuffer) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Training$PbExerciseBase> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePowerSampleSourceDevice(int i) {
        ensurePowerSampleSourceDeviceIsMutable();
        this.powerSampleSourceDevice_.remove(i);
    }

    private void removeSensorCalibrationOffset(int i) {
        ensureSensorCalibrationOffsetIsMutable();
        this.sensorCalibrationOffset_.remove(i);
    }

    private void setAccumulatedTorque(int i) {
        this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.accumulatedTorque_ = i;
    }

    private void setAscent(float f) {
        this.bitField0_ |= 128;
        this.ascent_ = f;
    }

    private void setAvailableSensorFeatures(int i, Types$PbFeatureType types$PbFeatureType) {
        types$PbFeatureType.getClass();
        ensureAvailableSensorFeaturesIsMutable();
        this.availableSensorFeatures_.setInt(i, types$PbFeatureType.getNumber());
    }

    private void setCalories(int i) {
        this.bitField0_ |= 16;
        this.calories_ = i;
    }

    private void setCardioLoad(Types$PbCardioLoad types$PbCardioLoad) {
        types$PbCardioLoad.getClass();
        this.cardioLoad_ = types$PbCardioLoad;
        this.bitField0_ |= 524288;
    }

    private void setCardioLoadInterpretation(int i) {
        this.bitField0_ |= 1048576;
        this.cardioLoadInterpretation_ = i;
    }

    private void setCyclingPowerEnergy(int i) {
        this.bitField0_ |= 131072;
        this.cyclingPowerEnergy_ = i;
    }

    private void setDescent(float f) {
        this.bitField0_ |= 256;
        this.descent_ = f;
    }

    private void setDeviceLocation(Types$PbDeviceLocation types$PbDeviceLocation) {
        this.deviceLocation_ = types$PbDeviceLocation.getNumber();
        this.bitField0_ |= 262144;
    }

    private void setDistance(float f) {
        this.bitField0_ |= 8;
        this.distance_ = f;
    }

    private void setDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.duration_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    private void setExerciseCounters(Training$PbExerciseCounters training$PbExerciseCounters) {
        training$PbExerciseCounters.getClass();
        this.exerciseCounters_ = training$PbExerciseCounters;
        this.bitField0_ |= 4096;
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 33554432;
    }

    private void setLatitude(double d) {
        this.bitField0_ |= 512;
        this.latitude_ = d;
    }

    private void setLongitude(double d) {
        this.bitField0_ |= 1024;
        this.longitude_ = d;
    }

    private void setMuscleLoad(float f) {
        this.bitField0_ |= 8388608;
        this.muscleLoad_ = f;
    }

    private void setMuscleLoadInterpretation(int i) {
        this.bitField0_ |= 16777216;
        this.muscleLoadInterpretation_ = i;
    }

    private void setOBSOLETESpeedCalibrationOffset(float f) {
        this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.oBSOLETESpeedCalibrationOffset_ = f;
    }

    private void setPerceivedLoad(Types$PbPerceivedLoad types$PbPerceivedLoad) {
        types$PbPerceivedLoad.getClass();
        this.perceivedLoad_ = types$PbPerceivedLoad;
        this.bitField0_ |= 2097152;
    }

    private void setPerceivedLoadInterpretation(int i) {
        this.bitField0_ |= 4194304;
        this.perceivedLoadInterpretation_ = i;
    }

    private void setPlace(String str) {
        str.getClass();
        this.bitField0_ |= 2048;
        this.place_ = str;
    }

    private void setPlaceBytes(ByteString byteString) {
        this.place_ = byteString.toStringUtf8();
        this.bitField0_ |= 2048;
    }

    private void setPowerSampleSourceDevice(int i, Structures$PbSampleSourceDevice structures$PbSampleSourceDevice) {
        structures$PbSampleSourceDevice.getClass();
        ensurePowerSampleSourceDeviceIsMutable();
        this.powerSampleSourceDevice_.set(i, structures$PbSampleSourceDevice);
    }

    private void setRunningIndex(Structures$PbRunningIndex structures$PbRunningIndex) {
        structures$PbRunningIndex.getClass();
        this.runningIndex_ = structures$PbRunningIndex;
        this.bitField0_ |= 64;
    }

    private void setSensorCalibrationOffset(int i, Types$PbSensorCalibrationOffset types$PbSensorCalibrationOffset) {
        types$PbSensorCalibrationOffset.getClass();
        ensureSensorCalibrationOffsetIsMutable();
        this.sensorCalibrationOffset_.set(i, types$PbSensorCalibrationOffset);
    }

    private void setSport(Structures$PbSportIdentifier structures$PbSportIdentifier) {
        structures$PbSportIdentifier.getClass();
        this.sport_ = structures$PbSportIdentifier;
        this.bitField0_ |= 4;
    }

    private void setStart(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.start_ = types$PbLocalDateTime;
        this.bitField0_ |= 1;
    }

    private void setTrainingLoad(Structures$PbTrainingLoad structures$PbTrainingLoad) {
        structures$PbTrainingLoad.getClass();
        this.trainingLoad_ = structures$PbTrainingLoad;
        this.bitField0_ |= 32;
    }

    private void setWalkingDistance(float f) {
        this.bitField0_ |= 16384;
        this.walkingDistance_ = f;
    }

    private void setWalkingDuration(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.walkingDuration_ = types$PbDuration;
        this.bitField0_ |= 32768;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Training$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Training$PbExerciseBase();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u001d\u0000\u0001\u0001d\u001d\u0000\u0003\n\u0001ᔉ\u0000\u0002ᔉ\u0001\u0003ᔉ\u0002\u0004ခ\u0003\u0005ဋ\u0004\u0006ᐉ\u0005\u0007\u001e\tᐉ\u0006\nခ\u0007\u000bခ\b\fက\t\rက\n\u000eဈ\u000b\u0010ဉ\f\u0011ခ\r\u0012ခ\u000e\u0013ဉ\u000f\u0014ဋ\u0010\u0015ဋ\u0011\u0016Л\u0017ဌ\u0012\u0018Л\u0019ᐉ\u0013\u001aဋ\u0014\u001bᐉ\u0015\u001cဋ\u0016\u001dခ\u0017\u001eဋ\u0018dᐉ\u0019", new Object[]{"bitField0_", "start_", "duration_", "sport_", "distance_", "calories_", "trainingLoad_", "availableSensorFeatures_", Types$PbFeatureType.internalGetVerifier(), "runningIndex_", "ascent_", "descent_", "latitude_", "longitude_", "place_", "exerciseCounters_", "oBSOLETESpeedCalibrationOffset_", "walkingDistance_", "walkingDuration_", "accumulatedTorque_", "cyclingPowerEnergy_", "sensorCalibrationOffset_", Types$PbSensorCalibrationOffset.class, "deviceLocation_", Types$PbDeviceLocation.internalGetVerifier(), "powerSampleSourceDevice_", Structures$PbSampleSourceDevice.class, "cardioLoad_", "cardioLoadInterpretation_", "perceivedLoad_", "perceivedLoadInterpretation_", "muscleLoad_", "muscleLoadInterpretation_", "lastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Training$PbExerciseBase> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Training$PbExerciseBase.class) {
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

    public int getAccumulatedTorque() {
        return this.accumulatedTorque_;
    }

    public float getAscent() {
        return this.ascent_;
    }

    public Types$PbFeatureType getAvailableSensorFeatures(int i) {
        Types$PbFeatureType types$PbFeatureTypeForNumber = Types$PbFeatureType.forNumber(this.availableSensorFeatures_.getInt(i));
        return types$PbFeatureTypeForNumber == null ? Types$PbFeatureType.FEATURE_TYPE_HEART_RATE : types$PbFeatureTypeForNumber;
    }

    public int getAvailableSensorFeaturesCount() {
        return this.availableSensorFeatures_.size();
    }

    public List<Types$PbFeatureType> getAvailableSensorFeaturesList() {
        return new Internal.ListAdapter(this.availableSensorFeatures_, availableSensorFeatures_converter_);
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

    public int getCyclingPowerEnergy() {
        return this.cyclingPowerEnergy_;
    }

    public float getDescent() {
        return this.descent_;
    }

    public Types$PbDeviceLocation getDeviceLocation() {
        Types$PbDeviceLocation types$PbDeviceLocationForNumber = Types$PbDeviceLocation.forNumber(this.deviceLocation_);
        return types$PbDeviceLocationForNumber == null ? Types$PbDeviceLocation.DEVICE_LOCATION_UNDEFINED : types$PbDeviceLocationForNumber;
    }

    public float getDistance() {
        return this.distance_;
    }

    public Types$PbDuration getDuration() {
        Types$PbDuration types$PbDuration = this.duration_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Training$PbExerciseCounters getExerciseCounters() {
        Training$PbExerciseCounters training$PbExerciseCounters = this.exerciseCounters_;
        return training$PbExerciseCounters == null ? Training$PbExerciseCounters.getDefaultInstance() : training$PbExerciseCounters;
    }

    public Types$PbSystemDateTime getLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.lastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public double getLatitude() {
        return this.latitude_;
    }

    public double getLongitude() {
        return this.longitude_;
    }

    public float getMuscleLoad() {
        return this.muscleLoad_;
    }

    public int getMuscleLoadInterpretation() {
        return this.muscleLoadInterpretation_;
    }

    public float getOBSOLETESpeedCalibrationOffset() {
        return this.oBSOLETESpeedCalibrationOffset_;
    }

    public Types$PbPerceivedLoad getPerceivedLoad() {
        Types$PbPerceivedLoad types$PbPerceivedLoad = this.perceivedLoad_;
        return types$PbPerceivedLoad == null ? Types$PbPerceivedLoad.getDefaultInstance() : types$PbPerceivedLoad;
    }

    public int getPerceivedLoadInterpretation() {
        return this.perceivedLoadInterpretation_;
    }

    public String getPlace() {
        return this.place_;
    }

    public ByteString getPlaceBytes() {
        return ByteString.copyFromUtf8(this.place_);
    }

    public Structures$PbSampleSourceDevice getPowerSampleSourceDevice(int i) {
        return this.powerSampleSourceDevice_.get(i);
    }

    public int getPowerSampleSourceDeviceCount() {
        return this.powerSampleSourceDevice_.size();
    }

    public List<Structures$PbSampleSourceDevice> getPowerSampleSourceDeviceList() {
        return this.powerSampleSourceDevice_;
    }

    public Structures$PbSampleSourceDeviceOrBuilder getPowerSampleSourceDeviceOrBuilder(int i) {
        return this.powerSampleSourceDevice_.get(i);
    }

    public List<? extends Structures$PbSampleSourceDeviceOrBuilder> getPowerSampleSourceDeviceOrBuilderList() {
        return this.powerSampleSourceDevice_;
    }

    public Structures$PbRunningIndex getRunningIndex() {
        Structures$PbRunningIndex structures$PbRunningIndex = this.runningIndex_;
        return structures$PbRunningIndex == null ? Structures$PbRunningIndex.getDefaultInstance() : structures$PbRunningIndex;
    }

    public Types$PbSensorCalibrationOffset getSensorCalibrationOffset(int i) {
        return this.sensorCalibrationOffset_.get(i);
    }

    public int getSensorCalibrationOffsetCount() {
        return this.sensorCalibrationOffset_.size();
    }

    public List<Types$PbSensorCalibrationOffset> getSensorCalibrationOffsetList() {
        return this.sensorCalibrationOffset_;
    }

    public Types$PbSensorCalibrationOffsetOrBuilder getSensorCalibrationOffsetOrBuilder(int i) {
        return this.sensorCalibrationOffset_.get(i);
    }

    public List<? extends Types$PbSensorCalibrationOffsetOrBuilder> getSensorCalibrationOffsetOrBuilderList() {
        return this.sensorCalibrationOffset_;
    }

    public Structures$PbSportIdentifier getSport() {
        Structures$PbSportIdentifier structures$PbSportIdentifier = this.sport_;
        return structures$PbSportIdentifier == null ? Structures$PbSportIdentifier.getDefaultInstance() : structures$PbSportIdentifier;
    }

    public Types$PbLocalDateTime getStart() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.start_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public Structures$PbTrainingLoad getTrainingLoad() {
        Structures$PbTrainingLoad structures$PbTrainingLoad = this.trainingLoad_;
        return structures$PbTrainingLoad == null ? Structures$PbTrainingLoad.getDefaultInstance() : structures$PbTrainingLoad;
    }

    public float getWalkingDistance() {
        return this.walkingDistance_;
    }

    public Types$PbDuration getWalkingDuration() {
        Types$PbDuration types$PbDuration = this.walkingDuration_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public boolean hasAccumulatedTorque() {
        return (this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0;
    }

    public boolean hasAscent() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasCalories() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasCardioLoad() {
        return (this.bitField0_ & 524288) != 0;
    }

    public boolean hasCardioLoadInterpretation() {
        return (this.bitField0_ & 1048576) != 0;
    }

    public boolean hasCyclingPowerEnergy() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasDescent() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasDeviceLocation() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasDistance() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasDuration() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasExerciseCounters() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 33554432) != 0;
    }

    public boolean hasLatitude() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasLongitude() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasMuscleLoad() {
        return (this.bitField0_ & 8388608) != 0;
    }

    public boolean hasMuscleLoadInterpretation() {
        return (this.bitField0_ & 16777216) != 0;
    }

    public boolean hasOBSOLETESpeedCalibrationOffset() {
        return (this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public boolean hasPerceivedLoad() {
        return (this.bitField0_ & 2097152) != 0;
    }

    public boolean hasPerceivedLoadInterpretation() {
        return (this.bitField0_ & 4194304) != 0;
    }

    public boolean hasPlace() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasRunningIndex() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasSport() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasStart() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTrainingLoad() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasWalkingDistance() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasWalkingDuration() {
        return (this.bitField0_ & 32768) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Training$PbExerciseBase, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Training$PbExerciseBase.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Training$PbExerciseBase training$PbExerciseBase) {
        return DEFAULT_INSTANCE.createBuilder(training$PbExerciseBase);
    }

    public static Training$PbExerciseBase parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Training$PbExerciseBase parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Training$PbExerciseBase parseFrom(ByteString byteString) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Training$PbExerciseBase parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addPowerSampleSourceDevice(int i, Structures$PbSampleSourceDevice structures$PbSampleSourceDevice) {
        structures$PbSampleSourceDevice.getClass();
        ensurePowerSampleSourceDeviceIsMutable();
        this.powerSampleSourceDevice_.add(i, structures$PbSampleSourceDevice);
    }

    private void addSensorCalibrationOffset(int i, Types$PbSensorCalibrationOffset types$PbSensorCalibrationOffset) {
        types$PbSensorCalibrationOffset.getClass();
        ensureSensorCalibrationOffsetIsMutable();
        this.sensorCalibrationOffset_.add(i, types$PbSensorCalibrationOffset);
    }

    public static Training$PbExerciseBase parseFrom(byte[] bArr) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Training$PbExerciseBase parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Training$PbExerciseBase parseFrom(InputStream inputStream) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Training$PbExerciseBase parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Training$PbExerciseBase parseFrom(CodedInputStream codedInputStream) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Training$PbExerciseBase parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Training$PbExerciseBase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
