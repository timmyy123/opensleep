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
public final class ActivitySamples$PbActivitySamples extends GeneratedMessageLite<ActivitySamples$PbActivitySamples, Builder> implements MessageLiteOrBuilder {
    private static final ActivitySamples$PbActivitySamples DEFAULT_INSTANCE;
    private static volatile Parser<ActivitySamples$PbActivitySamples> PARSER = null;
    public static final int STEPS_SAMPLES_FIELD_NUMBER = 5;
    private int stepsSamplesMemoizedSerializedSize = -1;
    private Internal.IntList stepsSamples_ = GeneratedMessageLite.emptyIntList();

    static {
        ActivitySamples$PbActivitySamples activitySamples$PbActivitySamples = new ActivitySamples$PbActivitySamples();
        DEFAULT_INSTANCE = activitySamples$PbActivitySamples;
        GeneratedMessageLite.registerDefaultInstance(ActivitySamples$PbActivitySamples.class, activitySamples$PbActivitySamples);
    }

    private ActivitySamples$PbActivitySamples() {
    }

    private void addAllStepsSamples(Iterable<? extends Integer> iterable) {
        ensureStepsSamplesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.stepsSamples_);
    }

    private void addStepsSamples(int i) {
        ensureStepsSamplesIsMutable();
        this.stepsSamples_.addInt(i);
    }

    private void clearStepsSamples() {
        this.stepsSamples_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureStepsSamplesIsMutable() {
        Internal.IntList intList = this.stepsSamples_;
        if (intList.isModifiable()) {
            return;
        }
        this.stepsSamples_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static ActivitySamples$PbActivitySamples getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ActivitySamples$PbActivitySamples parseDelimitedFrom(InputStream inputStream) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(ByteBuffer byteBuffer) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ActivitySamples$PbActivitySamples> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setStepsSamples(int i, int i2) {
        ensureStepsSamplesIsMutable();
        this.stepsSamples_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (ActivitySamples$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new ActivitySamples$PbActivitySamples();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0005\u0005\u0001\u0000\u0001\u0000\u0005+", new Object[]{"stepsSamples_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ActivitySamples$PbActivitySamples> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ActivitySamples$PbActivitySamples.class) {
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

    public int getStepsSamples(int i) {
        return this.stepsSamples_.getInt(i);
    }

    public int getStepsSamplesCount() {
        return this.stepsSamples_.size();
    }

    public List<Integer> getStepsSamplesList() {
        return this.stepsSamples_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ActivitySamples$PbActivitySamples, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(ActivitySamples$PbActivitySamples.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(ActivitySamples$PbActivitySamples activitySamples$PbActivitySamples) {
        return DEFAULT_INSTANCE.createBuilder(activitySamples$PbActivitySamples);
    }

    public static ActivitySamples$PbActivitySamples parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(ByteString byteString) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(byte[] bArr) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(InputStream inputStream) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(CodedInputStream codedInputStream) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ActivitySamples$PbActivitySamples parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ActivitySamples$PbActivitySamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
