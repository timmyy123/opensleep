package com.polar.androidcommunications.api.ble.model.proto;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class CommunicationsPftpRequest$PbPFtpOperation extends GeneratedMessageLite<CommunicationsPftpRequest$PbPFtpOperation, Builder> implements MessageLiteOrBuilder {
    public static final int COMMAND_FIELD_NUMBER = 1;
    private static final CommunicationsPftpRequest$PbPFtpOperation DEFAULT_INSTANCE;
    private static volatile Parser<CommunicationsPftpRequest$PbPFtpOperation> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 2;
    private int bitField0_;
    private int command_;
    private byte memoizedIsInitialized = 2;
    private String path_ = "";

    public enum Command implements Internal.EnumLite {
        GET(0),
        PUT(1),
        MERGE(2),
        REMOVE(3);

        private static final Internal.EnumLiteMap<Command> internalValueMap = new Internal.EnumLiteMap<Command>() { // from class: com.polar.androidcommunications.api.ble.model.proto.CommunicationsPftpRequest.PbPFtpOperation.Command.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Command findValueByNumber(int i) {
                return Command.forNumber(i);
            }
        };
        private final int value;

        public static final class CommandVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new CommandVerifier();

            private CommandVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Command.forNumber(i) != null;
            }
        }

        Command(int i) {
            this.value = i;
        }

        public static Command forNumber(int i) {
            if (i == 0) {
                return GET;
            }
            if (i == 1) {
                return PUT;
            }
            if (i == 2) {
                return MERGE;
            }
            if (i != 3) {
                return null;
            }
            return REMOVE;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CommandVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        CommunicationsPftpRequest$PbPFtpOperation communicationsPftpRequest$PbPFtpOperation = new CommunicationsPftpRequest$PbPFtpOperation();
        DEFAULT_INSTANCE = communicationsPftpRequest$PbPFtpOperation;
        GeneratedMessageLite.registerDefaultInstance(CommunicationsPftpRequest$PbPFtpOperation.class, communicationsPftpRequest$PbPFtpOperation);
    }

    private CommunicationsPftpRequest$PbPFtpOperation() {
    }

    private void clearCommand() {
        this.bitField0_ &= -2;
        this.command_ = 0;
    }

    private void clearPath() {
        this.bitField0_ &= -3;
        this.path_ = getDefaultInstance().getPath();
    }

    public static CommunicationsPftpRequest$PbPFtpOperation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseDelimitedFrom(InputStream inputStream) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(ByteBuffer byteBuffer) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CommunicationsPftpRequest$PbPFtpOperation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCommand(Command command) {
        this.command_ = command.getNumber();
        this.bitField0_ |= 1;
    }

    private void setPath(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.path_ = str;
    }

    private void setPathBytes(ByteString byteString) {
        this.path_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (CommunicationsPftpRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new CommunicationsPftpRequest$PbPFtpOperation();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔌ\u0000\u0002ᔈ\u0001", new Object[]{"bitField0_", "command_", Command.internalGetVerifier(), "path_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CommunicationsPftpRequest$PbPFtpOperation> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CommunicationsPftpRequest$PbPFtpOperation.class) {
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

    public Command getCommand() {
        Command commandForNumber = Command.forNumber(this.command_);
        return commandForNumber == null ? Command.GET : commandForNumber;
    }

    public String getPath() {
        return this.path_;
    }

    public ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    public boolean hasCommand() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPath() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CommunicationsPftpRequest$PbPFtpOperation, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(CommunicationsPftpRequest$PbPFtpOperation.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(CommunicationsPftpRequest$PbPFtpOperation communicationsPftpRequest$PbPFtpOperation) {
        return DEFAULT_INSTANCE.createBuilder(communicationsPftpRequest$PbPFtpOperation);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(ByteString byteString) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(byte[] bArr) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(InputStream inputStream) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(CodedInputStream codedInputStream) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CommunicationsPftpRequest$PbPFtpOperation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (CommunicationsPftpRequest$PbPFtpOperation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
