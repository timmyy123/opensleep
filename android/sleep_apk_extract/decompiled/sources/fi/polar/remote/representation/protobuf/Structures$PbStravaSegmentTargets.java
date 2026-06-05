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
public final class Structures$PbStravaSegmentTargets extends GeneratedMessageLite<Structures$PbStravaSegmentTargets, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbStravaSegmentTargets DEFAULT_INSTANCE;
    public static final int KOM_QOM_FIELD_NUMBER = 2;
    public static final int OWN_BEST_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbStravaSegmentTargets> PARSER;
    private int bitField0_;
    private Types$PbDuration komQom_;
    private Types$PbDuration ownBest_;

    static {
        Structures$PbStravaSegmentTargets structures$PbStravaSegmentTargets = new Structures$PbStravaSegmentTargets();
        DEFAULT_INSTANCE = structures$PbStravaSegmentTargets;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbStravaSegmentTargets.class, structures$PbStravaSegmentTargets);
    }

    private Structures$PbStravaSegmentTargets() {
    }

    private void clearKomQom() {
        this.komQom_ = null;
        this.bitField0_ &= -3;
    }

    private void clearOwnBest() {
        this.ownBest_ = null;
        this.bitField0_ &= -2;
    }

    public static Structures$PbStravaSegmentTargets getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeKomQom(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.komQom_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.komQom_ = types$PbDuration;
        } else {
            this.komQom_ = Types$PbDuration.newBuilder(this.komQom_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeOwnBest(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.ownBest_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.ownBest_ = types$PbDuration;
        } else {
            this.ownBest_ = Types$PbDuration.newBuilder(this.ownBest_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbStravaSegmentTargets parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbStravaSegmentTargets> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setKomQom(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.komQom_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    private void setOwnBest(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.ownBest_ = types$PbDuration;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbStravaSegmentTargets();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "ownBest_", "komQom_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbStravaSegmentTargets> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbStravaSegmentTargets.class) {
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

    public Types$PbDuration getKomQom() {
        Types$PbDuration types$PbDuration = this.komQom_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public Types$PbDuration getOwnBest() {
        Types$PbDuration types$PbDuration = this.ownBest_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public boolean hasKomQom() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOwnBest() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbStravaSegmentTargets, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbStravaSegmentTargets.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbStravaSegmentTargets structures$PbStravaSegmentTargets) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbStravaSegmentTargets);
    }

    public static Structures$PbStravaSegmentTargets parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(ByteString byteString) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(byte[] bArr) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(InputStream inputStream) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbStravaSegmentTargets parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbStravaSegmentTargets) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
