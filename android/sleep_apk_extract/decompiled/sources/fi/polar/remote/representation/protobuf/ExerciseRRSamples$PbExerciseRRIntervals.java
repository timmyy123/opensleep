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
public final class ExerciseRRSamples$PbExerciseRRIntervals extends GeneratedMessageLite<ExerciseRRSamples$PbExerciseRRIntervals, Builder> implements MessageLiteOrBuilder {
    private static final ExerciseRRSamples$PbExerciseRRIntervals DEFAULT_INSTANCE;
    private static volatile Parser<ExerciseRRSamples$PbExerciseRRIntervals> PARSER = null;
    public static final int RR_INTERVALS_FIELD_NUMBER = 1;
    private int rrIntervalsMemoizedSerializedSize = -1;
    private Internal.IntList rrIntervals_ = GeneratedMessageLite.emptyIntList();

    static {
        ExerciseRRSamples$PbExerciseRRIntervals exerciseRRSamples$PbExerciseRRIntervals = new ExerciseRRSamples$PbExerciseRRIntervals();
        DEFAULT_INSTANCE = exerciseRRSamples$PbExerciseRRIntervals;
        GeneratedMessageLite.registerDefaultInstance(ExerciseRRSamples$PbExerciseRRIntervals.class, exerciseRRSamples$PbExerciseRRIntervals);
    }

    private ExerciseRRSamples$PbExerciseRRIntervals() {
    }

    private void addAllRrIntervals(Iterable<? extends Integer> iterable) {
        ensureRrIntervalsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.rrIntervals_);
    }

    private void addRrIntervals(int i) {
        ensureRrIntervalsIsMutable();
        this.rrIntervals_.addInt(i);
    }

    private void clearRrIntervals() {
        this.rrIntervals_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureRrIntervalsIsMutable() {
        Internal.IntList intList = this.rrIntervals_;
        if (intList.isModifiable()) {
            return;
        }
        this.rrIntervals_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseDelimitedFrom(InputStream inputStream) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(ByteBuffer byteBuffer) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ExerciseRRSamples$PbExerciseRRIntervals> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRrIntervals(int i, int i2) {
        ensureRrIntervalsIsMutable();
        this.rrIntervals_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (ExerciseRRSamples$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ExerciseRRSamples$PbExerciseRRIntervals();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001+", new Object[]{"rrIntervals_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ExerciseRRSamples$PbExerciseRRIntervals> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ExerciseRRSamples$PbExerciseRRIntervals.class) {
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
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public int getRrIntervals(int i) {
        return this.rrIntervals_.getInt(i);
    }

    public int getRrIntervalsCount() {
        return this.rrIntervals_.size();
    }

    public List<Integer> getRrIntervalsList() {
        return this.rrIntervals_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ExerciseRRSamples$PbExerciseRRIntervals, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(ExerciseRRSamples$PbExerciseRRIntervals.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(ExerciseRRSamples$PbExerciseRRIntervals exerciseRRSamples$PbExerciseRRIntervals) {
        return DEFAULT_INSTANCE.createBuilder(exerciseRRSamples$PbExerciseRRIntervals);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(ByteString byteString) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(byte[] bArr) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(InputStream inputStream) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(CodedInputStream codedInputStream) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ExerciseRRSamples$PbExerciseRRIntervals parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ExerciseRRSamples$PbExerciseRRIntervals) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
