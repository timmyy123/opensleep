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
public final class PftpResponse$PbPFtpDirectory extends GeneratedMessageLite<PftpResponse$PbPFtpDirectory, Builder> implements MessageLiteOrBuilder {
    private static final PftpResponse$PbPFtpDirectory DEFAULT_INSTANCE;
    public static final int ENTRIES_FIELD_NUMBER = 1;
    private static volatile Parser<PftpResponse$PbPFtpDirectory> PARSER;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<PftpResponse$PbPFtpEntry> entries_ = GeneratedMessageLite.emptyProtobufList();

    static {
        PftpResponse$PbPFtpDirectory pftpResponse$PbPFtpDirectory = new PftpResponse$PbPFtpDirectory();
        DEFAULT_INSTANCE = pftpResponse$PbPFtpDirectory;
        GeneratedMessageLite.registerDefaultInstance(PftpResponse$PbPFtpDirectory.class, pftpResponse$PbPFtpDirectory);
    }

    private PftpResponse$PbPFtpDirectory() {
    }

    private void addAllEntries(Iterable<? extends PftpResponse$PbPFtpEntry> iterable) {
        ensureEntriesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.entries_);
    }

    private void addEntries(PftpResponse$PbPFtpEntry pftpResponse$PbPFtpEntry) {
        pftpResponse$PbPFtpEntry.getClass();
        ensureEntriesIsMutable();
        this.entries_.add(pftpResponse$PbPFtpEntry);
    }

    private void clearEntries() {
        this.entries_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureEntriesIsMutable() {
        Internal.ProtobufList<PftpResponse$PbPFtpEntry> protobufList = this.entries_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.entries_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static PftpResponse$PbPFtpDirectory getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpResponse$PbPFtpDirectory parseDelimitedFrom(InputStream inputStream) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(ByteBuffer byteBuffer) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpResponse$PbPFtpDirectory> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEntries(int i) {
        ensureEntriesIsMutable();
        this.entries_.remove(i);
    }

    private void setEntries(int i, PftpResponse$PbPFtpEntry pftpResponse$PbPFtpEntry) {
        pftpResponse$PbPFtpEntry.getClass();
        ensureEntriesIsMutable();
        this.entries_.set(i, pftpResponse$PbPFtpEntry);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpResponse$PbPFtpDirectory();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"entries_", PftpResponse$PbPFtpEntry.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpResponse$PbPFtpDirectory> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpResponse$PbPFtpDirectory.class) {
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

    public PftpResponse$PbPFtpEntry getEntries(int i) {
        return this.entries_.get(i);
    }

    public int getEntriesCount() {
        return this.entries_.size();
    }

    public List<PftpResponse$PbPFtpEntry> getEntriesList() {
        return this.entries_;
    }

    public PftpResponse$PbPFtpEntryOrBuilder getEntriesOrBuilder(int i) {
        return this.entries_.get(i);
    }

    public List<? extends PftpResponse$PbPFtpEntryOrBuilder> getEntriesOrBuilderList() {
        return this.entries_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpResponse$PbPFtpDirectory, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpResponse$PbPFtpDirectory.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpResponse$PbPFtpDirectory pftpResponse$PbPFtpDirectory) {
        return DEFAULT_INSTANCE.createBuilder(pftpResponse$PbPFtpDirectory);
    }

    public static PftpResponse$PbPFtpDirectory parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(ByteString byteString) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addEntries(int i, PftpResponse$PbPFtpEntry pftpResponse$PbPFtpEntry) {
        pftpResponse$PbPFtpEntry.getClass();
        ensureEntriesIsMutable();
        this.entries_.add(i, pftpResponse$PbPFtpEntry);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(byte[] bArr) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(InputStream inputStream) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(CodedInputStream codedInputStream) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpResponse$PbPFtpDirectory parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDirectory) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
