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
public final class PpIntervals$PbPpIntervalSamples extends GeneratedMessageLite<PpIntervals$PbPpIntervalSamples, Builder> implements MessageLiteOrBuilder {
    private static final PpIntervals$PbPpIntervalSamples DEFAULT_INSTANCE;
    private static volatile Parser<PpIntervals$PbPpIntervalSamples> PARSER = null;
    public static final int PPI_DELTA_FIELD_NUMBER = 1;
    public static final int PPI_ERROR_ESTIMATE_DELTA_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 3;
    private int ppiDeltaMemoizedSerializedSize = -1;
    private int ppiErrorEstimateDeltaMemoizedSerializedSize = -1;
    private int statusMemoizedSerializedSize = -1;
    private Internal.IntList ppiDelta_ = GeneratedMessageLite.emptyIntList();
    private Internal.IntList ppiErrorEstimateDelta_ = GeneratedMessageLite.emptyIntList();
    private Internal.IntList status_ = GeneratedMessageLite.emptyIntList();

    static {
        PpIntervals$PbPpIntervalSamples ppIntervals$PbPpIntervalSamples = new PpIntervals$PbPpIntervalSamples();
        DEFAULT_INSTANCE = ppIntervals$PbPpIntervalSamples;
        GeneratedMessageLite.registerDefaultInstance(PpIntervals$PbPpIntervalSamples.class, ppIntervals$PbPpIntervalSamples);
    }

    private PpIntervals$PbPpIntervalSamples() {
    }

    private void addAllPpiDelta(Iterable<? extends Integer> iterable) {
        ensurePpiDeltaIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.ppiDelta_);
    }

    private void addAllPpiErrorEstimateDelta(Iterable<? extends Integer> iterable) {
        ensurePpiErrorEstimateDeltaIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.ppiErrorEstimateDelta_);
    }

    private void addAllStatus(Iterable<? extends Integer> iterable) {
        ensureStatusIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.status_);
    }

    private void addPpiDelta(int i) {
        ensurePpiDeltaIsMutable();
        this.ppiDelta_.addInt(i);
    }

    private void addPpiErrorEstimateDelta(int i) {
        ensurePpiErrorEstimateDeltaIsMutable();
        this.ppiErrorEstimateDelta_.addInt(i);
    }

    private void addStatus(int i) {
        ensureStatusIsMutable();
        this.status_.addInt(i);
    }

    private void clearPpiDelta() {
        this.ppiDelta_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearPpiErrorEstimateDelta() {
        this.ppiErrorEstimateDelta_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearStatus() {
        this.status_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensurePpiDeltaIsMutable() {
        Internal.IntList intList = this.ppiDelta_;
        if (intList.isModifiable()) {
            return;
        }
        this.ppiDelta_ = GeneratedMessageLite.mutableCopy(intList);
    }

    private void ensurePpiErrorEstimateDeltaIsMutable() {
        Internal.IntList intList = this.ppiErrorEstimateDelta_;
        if (intList.isModifiable()) {
            return;
        }
        this.ppiErrorEstimateDelta_ = GeneratedMessageLite.mutableCopy(intList);
    }

    private void ensureStatusIsMutable() {
        Internal.IntList intList = this.status_;
        if (intList.isModifiable()) {
            return;
        }
        this.status_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static PpIntervals$PbPpIntervalSamples getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PpIntervals$PbPpIntervalSamples parseDelimitedFrom(InputStream inputStream) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(ByteBuffer byteBuffer) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PpIntervals$PbPpIntervalSamples> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPpiDelta(int i, int i2) {
        ensurePpiDeltaIsMutable();
        this.ppiDelta_.setInt(i, i2);
    }

    private void setPpiErrorEstimateDelta(int i, int i2) {
        ensurePpiErrorEstimateDeltaIsMutable();
        this.ppiErrorEstimateDelta_.setInt(i, i2);
    }

    private void setStatus(int i, int i2) {
        ensureStatusIsMutable();
        this.status_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PpIntervals$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PpIntervals$PbPpIntervalSamples();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0000\u0001/\u0002/\u0003+", new Object[]{"ppiDelta_", "ppiErrorEstimateDelta_", "status_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PpIntervals$PbPpIntervalSamples> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PpIntervals$PbPpIntervalSamples.class) {
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

    public int getPpiDelta(int i) {
        return this.ppiDelta_.getInt(i);
    }

    public int getPpiDeltaCount() {
        return this.ppiDelta_.size();
    }

    public List<Integer> getPpiDeltaList() {
        return this.ppiDelta_;
    }

    public int getPpiErrorEstimateDelta(int i) {
        return this.ppiErrorEstimateDelta_.getInt(i);
    }

    public int getPpiErrorEstimateDeltaCount() {
        return this.ppiErrorEstimateDelta_.size();
    }

    public List<Integer> getPpiErrorEstimateDeltaList() {
        return this.ppiErrorEstimateDelta_;
    }

    public int getStatus(int i) {
        return this.status_.getInt(i);
    }

    public int getStatusCount() {
        return this.status_.size();
    }

    public List<Integer> getStatusList() {
        return this.status_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PpIntervals$PbPpIntervalSamples, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PpIntervals$PbPpIntervalSamples.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PpIntervals$PbPpIntervalSamples ppIntervals$PbPpIntervalSamples) {
        return DEFAULT_INSTANCE.createBuilder(ppIntervals$PbPpIntervalSamples);
    }

    public static PpIntervals$PbPpIntervalSamples parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(ByteString byteString) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(byte[] bArr) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(InputStream inputStream) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(CodedInputStream codedInputStream) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PpIntervals$PbPpIntervalSamples parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PpIntervals$PbPpIntervalSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
