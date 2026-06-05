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
public final class ExerciseSamples$PbExerciseSamples extends GeneratedMessageLite<ExerciseSamples$PbExerciseSamples, Builder> implements MessageLiteOrBuilder {
    private static final ExerciseSamples$PbExerciseSamples DEFAULT_INSTANCE;
    public static final int HEART_RATE_SAMPLES_FIELD_NUMBER = 2;
    private static volatile Parser<ExerciseSamples$PbExerciseSamples> PARSER = null;
    public static final int RECORDING_INTERVAL_FIELD_NUMBER = 1;
    public static final int RR_SAMPLES_FIELD_NUMBER = 28;
    private int bitField0_;
    private Types$PbDuration recordingInterval_;
    private ExerciseRRSamples$PbExerciseRRIntervals rrSamples_;
    private int heartRateSamplesMemoizedSerializedSize = -1;
    private byte memoizedIsInitialized = 2;
    private Internal.IntList heartRateSamples_ = GeneratedMessageLite.emptyIntList();

    static {
        ExerciseSamples$PbExerciseSamples exerciseSamples$PbExerciseSamples = new ExerciseSamples$PbExerciseSamples();
        DEFAULT_INSTANCE = exerciseSamples$PbExerciseSamples;
        GeneratedMessageLite.registerDefaultInstance(ExerciseSamples$PbExerciseSamples.class, exerciseSamples$PbExerciseSamples);
    }

    private ExerciseSamples$PbExerciseSamples() {
    }

    private void addAllHeartRateSamples(Iterable<? extends Integer> iterable) {
        ensureHeartRateSamplesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.heartRateSamples_);
    }

    private void addHeartRateSamples(int i) {
        ensureHeartRateSamplesIsMutable();
        this.heartRateSamples_.addInt(i);
    }

    private void clearHeartRateSamples() {
        this.heartRateSamples_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearRecordingInterval() {
        this.recordingInterval_ = null;
        this.bitField0_ &= -2;
    }

    private void clearRrSamples() {
        this.rrSamples_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureHeartRateSamplesIsMutable() {
        Internal.IntList intList = this.heartRateSamples_;
        if (intList.isModifiable()) {
            return;
        }
        this.heartRateSamples_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static ExerciseSamples$PbExerciseSamples getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRecordingInterval(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.recordingInterval_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.recordingInterval_ = types$PbDuration;
        } else {
            this.recordingInterval_ = Types$PbDuration.newBuilder(this.recordingInterval_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    private void mergeRrSamples(ExerciseRRSamples$PbExerciseRRIntervals exerciseRRSamples$PbExerciseRRIntervals) {
        exerciseRRSamples$PbExerciseRRIntervals.getClass();
        ExerciseRRSamples$PbExerciseRRIntervals exerciseRRSamples$PbExerciseRRIntervals2 = this.rrSamples_;
        if (exerciseRRSamples$PbExerciseRRIntervals2 == null || exerciseRRSamples$PbExerciseRRIntervals2 == ExerciseRRSamples$PbExerciseRRIntervals.getDefaultInstance()) {
            this.rrSamples_ = exerciseRRSamples$PbExerciseRRIntervals;
        } else {
            this.rrSamples_ = ExerciseRRSamples$PbExerciseRRIntervals.newBuilder(this.rrSamples_).mergeFrom(exerciseRRSamples$PbExerciseRRIntervals).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ExerciseSamples$PbExerciseSamples parseDelimitedFrom(InputStream inputStream) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(ByteBuffer byteBuffer) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ExerciseSamples$PbExerciseSamples> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeartRateSamples(int i, int i2) {
        ensureHeartRateSamplesIsMutable();
        this.heartRateSamples_.setInt(i, i2);
    }

    private void setRecordingInterval(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.recordingInterval_ = types$PbDuration;
        this.bitField0_ |= 1;
    }

    private void setRrSamples(ExerciseRRSamples$PbExerciseRRIntervals exerciseRRSamples$PbExerciseRRIntervals) {
        exerciseRRSamples$PbExerciseRRIntervals.getClass();
        this.rrSamples_ = exerciseRRSamples$PbExerciseRRIntervals;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (ExerciseSamples$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ExerciseSamples$PbExerciseSamples();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u001c\u0003\u0000\u0001\u0001\u0001ᔉ\u0000\u0002+\u001cဉ\u0001", new Object[]{"bitField0_", "recordingInterval_", "heartRateSamples_", "rrSamples_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ExerciseSamples$PbExerciseSamples> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ExerciseSamples$PbExerciseSamples.class) {
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

    public int getHeartRateSamples(int i) {
        return this.heartRateSamples_.getInt(i);
    }

    public int getHeartRateSamplesCount() {
        return this.heartRateSamples_.size();
    }

    public List<Integer> getHeartRateSamplesList() {
        return this.heartRateSamples_;
    }

    public Types$PbDuration getRecordingInterval() {
        Types$PbDuration types$PbDuration = this.recordingInterval_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public ExerciseRRSamples$PbExerciseRRIntervals getRrSamples() {
        ExerciseRRSamples$PbExerciseRRIntervals exerciseRRSamples$PbExerciseRRIntervals = this.rrSamples_;
        return exerciseRRSamples$PbExerciseRRIntervals == null ? ExerciseRRSamples$PbExerciseRRIntervals.getDefaultInstance() : exerciseRRSamples$PbExerciseRRIntervals;
    }

    public boolean hasRecordingInterval() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRrSamples() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ExerciseSamples$PbExerciseSamples, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(ExerciseSamples$PbExerciseSamples.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(ExerciseSamples$PbExerciseSamples exerciseSamples$PbExerciseSamples) {
        return DEFAULT_INSTANCE.createBuilder(exerciseSamples$PbExerciseSamples);
    }

    public static ExerciseSamples$PbExerciseSamples parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(ByteString byteString) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(byte[] bArr) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(InputStream inputStream) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(CodedInputStream codedInputStream) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ExerciseSamples$PbExerciseSamples parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseSamples$PbExerciseSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
