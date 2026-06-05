package protocol;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import fi.polar.remote.representation.protobuf.Types$PbSystemDateTime;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class PftpResponse$PbPFtpEntry extends GeneratedMessageLite<PftpResponse$PbPFtpEntry, Builder> implements PftpResponse$PbPFtpEntryOrBuilder {
    public static final int CREATED_FIELD_NUMBER = 3;
    private static final PftpResponse$PbPFtpEntry DEFAULT_INSTANCE;
    public static final int MODIFIED_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<PftpResponse$PbPFtpEntry> PARSER = null;
    public static final int SIZE_FIELD_NUMBER = 2;
    public static final int TOUCHED_FIELD_NUMBER = 5;
    private int bitField0_;
    private Types$PbSystemDateTime created_;
    private Types$PbSystemDateTime modified_;
    private long size_;
    private Types$PbSystemDateTime touched_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";

    static {
        PftpResponse$PbPFtpEntry pftpResponse$PbPFtpEntry = new PftpResponse$PbPFtpEntry();
        DEFAULT_INSTANCE = pftpResponse$PbPFtpEntry;
        GeneratedMessageLite.registerDefaultInstance(PftpResponse$PbPFtpEntry.class, pftpResponse$PbPFtpEntry);
    }

    private PftpResponse$PbPFtpEntry() {
    }

    private void clearCreated() {
        this.created_ = null;
        this.bitField0_ &= -5;
    }

    private void clearModified() {
        this.modified_ = null;
        this.bitField0_ &= -9;
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearSize() {
        this.bitField0_ &= -3;
        this.size_ = 0L;
    }

    private void clearTouched() {
        this.touched_ = null;
        this.bitField0_ &= -17;
    }

    public static PftpResponse$PbPFtpEntry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeCreated(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.created_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.created_ = types$PbSystemDateTime;
        } else {
            this.created_ = Types$PbSystemDateTime.newBuilder(this.created_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    private void mergeModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.modified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.modified_ = types$PbSystemDateTime;
        } else {
            this.modified_ = Types$PbSystemDateTime.newBuilder(this.modified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    private void mergeTouched(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.touched_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.touched_ = types$PbSystemDateTime;
        } else {
            this.touched_ = Types$PbSystemDateTime.newBuilder(this.touched_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpResponse$PbPFtpEntry parseDelimitedFrom(InputStream inputStream) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(ByteBuffer byteBuffer) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpResponse$PbPFtpEntry> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCreated(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.created_ = types$PbSystemDateTime;
        this.bitField0_ |= 4;
    }

    private void setModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.modified_ = types$PbSystemDateTime;
        this.bitField0_ |= 8;
    }

    private void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    private void setNameBytes(ByteString byteString) {
        this.name_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    private void setSize(long j) {
        this.bitField0_ |= 2;
        this.size_ = j;
    }

    private void setTouched(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.touched_ = types$PbSystemDateTime;
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpResponse$PbPFtpEntry();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0005\u0001ᔈ\u0000\u0002ᔃ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005ᐉ\u0004", new Object[]{"bitField0_", "name_", "size_", "created_", "modified_", "touched_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpResponse$PbPFtpEntry> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpResponse$PbPFtpEntry.class) {
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

    public Types$PbSystemDateTime getCreated() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.created_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public Types$PbSystemDateTime getModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.modified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public long getSize() {
        return this.size_;
    }

    public Types$PbSystemDateTime getTouched() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.touched_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public boolean hasCreated() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasModified() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSize() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTouched() {
        return (this.bitField0_ & 16) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpResponse$PbPFtpEntry, Builder> implements PftpResponse$PbPFtpEntryOrBuilder {
        private Builder() {
            super(PftpResponse$PbPFtpEntry.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpResponse$PbPFtpEntry pftpResponse$PbPFtpEntry) {
        return DEFAULT_INSTANCE.createBuilder(pftpResponse$PbPFtpEntry);
    }

    public static PftpResponse$PbPFtpEntry parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(ByteString byteString) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(byte[] bArr) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(InputStream inputStream) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(CodedInputStream codedInputStream) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpResponse$PbPFtpEntry parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpEntry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
