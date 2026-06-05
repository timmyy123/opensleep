package protocol;

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
public final class PftpNotification$PbPftpDHRestApiEvent extends GeneratedMessageLite<PftpNotification$PbPftpDHRestApiEvent, Builder> implements MessageLiteOrBuilder {
    private static final PftpNotification$PbPftpDHRestApiEvent DEFAULT_INSTANCE;
    public static final int EVENT_FIELD_NUMBER = 1;
    private static volatile Parser<PftpNotification$PbPftpDHRestApiEvent> PARSER = null;
    public static final int UNCOMPRESSED_FIELD_NUMBER = 2;
    private int bitField0_;
    private Internal.ProtobufList<ByteString> event_ = GeneratedMessageLite.emptyProtobufList();
    private boolean uncompressed_;

    static {
        PftpNotification$PbPftpDHRestApiEvent pftpNotification$PbPftpDHRestApiEvent = new PftpNotification$PbPftpDHRestApiEvent();
        DEFAULT_INSTANCE = pftpNotification$PbPftpDHRestApiEvent;
        GeneratedMessageLite.registerDefaultInstance(PftpNotification$PbPftpDHRestApiEvent.class, pftpNotification$PbPftpDHRestApiEvent);
    }

    private PftpNotification$PbPftpDHRestApiEvent() {
    }

    private void addAllEvent(Iterable<? extends ByteString> iterable) {
        ensureEventIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.event_);
    }

    private void addEvent(ByteString byteString) {
        byteString.getClass();
        ensureEventIsMutable();
        this.event_.add(byteString);
    }

    private void clearEvent() {
        this.event_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUncompressed() {
        this.bitField0_ &= -2;
        this.uncompressed_ = false;
    }

    private void ensureEventIsMutable() {
        Internal.ProtobufList<ByteString> protobufList = this.event_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.event_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static PftpNotification$PbPftpDHRestApiEvent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseDelimitedFrom(InputStream inputStream) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(ByteBuffer byteBuffer) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpNotification$PbPftpDHRestApiEvent> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEvent(int i, ByteString byteString) {
        byteString.getClass();
        ensureEventIsMutable();
        this.event_.set(i, byteString);
    }

    private void setUncompressed(boolean z) {
        this.bitField0_ |= 1;
        this.uncompressed_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpNotification$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpNotification$PbPftpDHRestApiEvent();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001c\u0002ဇ\u0000", new Object[]{"bitField0_", "event_", "uncompressed_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpNotification$PbPftpDHRestApiEvent> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpNotification$PbPftpDHRestApiEvent.class) {
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

    public ByteString getEvent(int i) {
        return this.event_.get(i);
    }

    public int getEventCount() {
        return this.event_.size();
    }

    public List<ByteString> getEventList() {
        return this.event_;
    }

    public boolean getUncompressed() {
        return this.uncompressed_;
    }

    public boolean hasUncompressed() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpNotification$PbPftpDHRestApiEvent, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpNotification$PbPftpDHRestApiEvent.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpNotification$PbPftpDHRestApiEvent pftpNotification$PbPftpDHRestApiEvent) {
        return DEFAULT_INSTANCE.createBuilder(pftpNotification$PbPftpDHRestApiEvent);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(ByteString byteString) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(byte[] bArr) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(InputStream inputStream) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(CodedInputStream codedInputStream) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpNotification$PbPftpDHRestApiEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPftpDHRestApiEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
