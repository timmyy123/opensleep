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
public final class AutomaticSamples$PbAutomaticSampleSessions extends GeneratedMessageLite<AutomaticSamples$PbAutomaticSampleSessions, Builder> implements MessageLiteOrBuilder {
    public static final int DAY_FIELD_NUMBER = 1;
    private static final AutomaticSamples$PbAutomaticSampleSessions DEFAULT_INSTANCE;
    private static volatile Parser<AutomaticSamples$PbAutomaticSampleSessions> PARSER = null;
    public static final int PPI_SAMPLES_FIELD_NUMBER = 3;
    public static final int SAMPLES_FIELD_NUMBER = 2;
    private int bitField0_;
    private Types$PbDate day_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<AutomaticSamples$PbAutomaticHeartRateSamples> samples_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<AutomaticSamples$PbPpIntervalAutoSamples> ppiSamples_ = GeneratedMessageLite.emptyProtobufList();

    static {
        AutomaticSamples$PbAutomaticSampleSessions automaticSamples$PbAutomaticSampleSessions = new AutomaticSamples$PbAutomaticSampleSessions();
        DEFAULT_INSTANCE = automaticSamples$PbAutomaticSampleSessions;
        GeneratedMessageLite.registerDefaultInstance(AutomaticSamples$PbAutomaticSampleSessions.class, automaticSamples$PbAutomaticSampleSessions);
    }

    private AutomaticSamples$PbAutomaticSampleSessions() {
    }

    private void addAllPpiSamples(Iterable<? extends AutomaticSamples$PbPpIntervalAutoSamples> iterable) {
        ensurePpiSamplesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.ppiSamples_);
    }

    private void addAllSamples(Iterable<? extends AutomaticSamples$PbAutomaticHeartRateSamples> iterable) {
        ensureSamplesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.samples_);
    }

    private void addPpiSamples(AutomaticSamples$PbPpIntervalAutoSamples automaticSamples$PbPpIntervalAutoSamples) {
        automaticSamples$PbPpIntervalAutoSamples.getClass();
        ensurePpiSamplesIsMutable();
        this.ppiSamples_.add(automaticSamples$PbPpIntervalAutoSamples);
    }

    private void addSamples(AutomaticSamples$PbAutomaticHeartRateSamples automaticSamples$PbAutomaticHeartRateSamples) {
        automaticSamples$PbAutomaticHeartRateSamples.getClass();
        ensureSamplesIsMutable();
        this.samples_.add(automaticSamples$PbAutomaticHeartRateSamples);
    }

    private void clearDay() {
        this.day_ = null;
        this.bitField0_ &= -2;
    }

    private void clearPpiSamples() {
        this.ppiSamples_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSamples() {
        this.samples_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensurePpiSamplesIsMutable() {
        Internal.ProtobufList<AutomaticSamples$PbPpIntervalAutoSamples> protobufList = this.ppiSamples_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.ppiSamples_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSamplesIsMutable() {
        Internal.ProtobufList<AutomaticSamples$PbAutomaticHeartRateSamples> protobufList = this.samples_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.samples_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDay(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        Types$PbDate types$PbDate2 = this.day_;
        if (types$PbDate2 == null || types$PbDate2 == Types$PbDate.getDefaultInstance()) {
            this.day_ = types$PbDate;
        } else {
            this.day_ = Types$PbDate.newBuilder(this.day_).mergeFrom(types$PbDate).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseDelimitedFrom(InputStream inputStream) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(ByteBuffer byteBuffer) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AutomaticSamples$PbAutomaticSampleSessions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removePpiSamples(int i) {
        ensurePpiSamplesIsMutable();
        this.ppiSamples_.remove(i);
    }

    private void removeSamples(int i) {
        ensureSamplesIsMutable();
        this.samples_.remove(i);
    }

    private void setDay(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        this.day_ = types$PbDate;
        this.bitField0_ |= 1;
    }

    private void setPpiSamples(int i, AutomaticSamples$PbPpIntervalAutoSamples automaticSamples$PbPpIntervalAutoSamples) {
        automaticSamples$PbPpIntervalAutoSamples.getClass();
        ensurePpiSamplesIsMutable();
        this.ppiSamples_.set(i, automaticSamples$PbPpIntervalAutoSamples);
    }

    private void setSamples(int i, AutomaticSamples$PbAutomaticHeartRateSamples automaticSamples$PbAutomaticHeartRateSamples) {
        automaticSamples$PbAutomaticHeartRateSamples.getClass();
        ensureSamplesIsMutable();
        this.samples_.set(i, automaticSamples$PbAutomaticHeartRateSamples);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AutomaticSamples$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AutomaticSamples$PbAutomaticSampleSessions();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0003\u0001ᔉ\u0000\u0002Л\u0003Л", new Object[]{"bitField0_", "day_", "samples_", AutomaticSamples$PbAutomaticHeartRateSamples.class, "ppiSamples_", AutomaticSamples$PbPpIntervalAutoSamples.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AutomaticSamples$PbAutomaticSampleSessions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AutomaticSamples$PbAutomaticSampleSessions.class) {
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

    public Types$PbDate getDay() {
        Types$PbDate types$PbDate = this.day_;
        return types$PbDate == null ? Types$PbDate.getDefaultInstance() : types$PbDate;
    }

    public AutomaticSamples$PbPpIntervalAutoSamples getPpiSamples(int i) {
        return this.ppiSamples_.get(i);
    }

    public int getPpiSamplesCount() {
        return this.ppiSamples_.size();
    }

    public List<AutomaticSamples$PbPpIntervalAutoSamples> getPpiSamplesList() {
        return this.ppiSamples_;
    }

    public AutomaticSamples$PbPpIntervalAutoSamplesOrBuilder getPpiSamplesOrBuilder(int i) {
        return this.ppiSamples_.get(i);
    }

    public List<? extends AutomaticSamples$PbPpIntervalAutoSamplesOrBuilder> getPpiSamplesOrBuilderList() {
        return this.ppiSamples_;
    }

    public AutomaticSamples$PbAutomaticHeartRateSamples getSamples(int i) {
        return this.samples_.get(i);
    }

    public int getSamplesCount() {
        return this.samples_.size();
    }

    public List<AutomaticSamples$PbAutomaticHeartRateSamples> getSamplesList() {
        return this.samples_;
    }

    public AutomaticSamples$PbAutomaticHeartRateSamplesOrBuilder getSamplesOrBuilder(int i) {
        return this.samples_.get(i);
    }

    public List<? extends AutomaticSamples$PbAutomaticHeartRateSamplesOrBuilder> getSamplesOrBuilderList() {
        return this.samples_;
    }

    public boolean hasDay() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AutomaticSamples$PbAutomaticSampleSessions, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(AutomaticSamples$PbAutomaticSampleSessions.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(AutomaticSamples$PbAutomaticSampleSessions automaticSamples$PbAutomaticSampleSessions) {
        return DEFAULT_INSTANCE.createBuilder(automaticSamples$PbAutomaticSampleSessions);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(ByteString byteString) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addPpiSamples(int i, AutomaticSamples$PbPpIntervalAutoSamples automaticSamples$PbPpIntervalAutoSamples) {
        automaticSamples$PbPpIntervalAutoSamples.getClass();
        ensurePpiSamplesIsMutable();
        this.ppiSamples_.add(i, automaticSamples$PbPpIntervalAutoSamples);
    }

    private void addSamples(int i, AutomaticSamples$PbAutomaticHeartRateSamples automaticSamples$PbAutomaticHeartRateSamples) {
        automaticSamples$PbAutomaticHeartRateSamples.getClass();
        ensureSamplesIsMutable();
        this.samples_.add(i, automaticSamples$PbAutomaticHeartRateSamples);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(byte[] bArr) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(InputStream inputStream) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(CodedInputStream codedInputStream) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AutomaticSamples$PbAutomaticSampleSessions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticSampleSessions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
