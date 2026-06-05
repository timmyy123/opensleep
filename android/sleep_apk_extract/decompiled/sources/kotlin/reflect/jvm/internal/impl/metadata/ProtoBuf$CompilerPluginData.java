package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoBuf$CompilerPluginData extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$CompilerPluginData> PARSER = new AbstractParser<ProtoBuf$CompilerPluginData>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$CompilerPluginData.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$CompilerPluginData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$CompilerPluginData(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$CompilerPluginData defaultInstance;
    private int bitField0_;
    private ByteString data_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int pluginId_;
    private final ByteString unknownFields;

    static {
        ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData = new ProtoBuf$CompilerPluginData(true);
        defaultInstance = protoBuf$CompilerPluginData;
        protoBuf$CompilerPluginData.initFields();
    }

    private ProtoBuf$CompilerPluginData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output outputNewOutput = ByteString.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.pluginId_ = codedInputStream.readInt32();
                        } else if (tag == 18) {
                            this.bitField0_ |= 2;
                            this.data_ = codedInputStream.readBytes();
                        } else if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = outputNewOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = outputNewOutput.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = outputNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = outputNewOutput.toByteString();
        makeExtensionsImmutable();
    }

    public static ProtoBuf$CompilerPluginData getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.pluginId_ = 0;
        this.data_ = ByteString.EMPTY;
    }

    public static Builder newBuilder(ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData) {
        return newBuilder().mergeFrom(protoBuf$CompilerPluginData);
    }

    public ByteString getData() {
        return this.data_;
    }

    public int getPluginId() {
        return this.pluginId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.pluginId_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeBytesSize(2, this.data_);
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasData() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasPluginId() {
        return (this.bitField0_ & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        if (!hasPluginId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasData()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.pluginId_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeBytes(2, this.data_);
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$CompilerPluginData, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private ByteString data_ = ByteString.EMPTY;
        private int pluginId_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$CompilerPluginData build() {
            ProtoBuf$CompilerPluginData protoBuf$CompilerPluginDataBuildPartial = buildPartial();
            if (protoBuf$CompilerPluginDataBuildPartial.isInitialized()) {
                return protoBuf$CompilerPluginDataBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$CompilerPluginDataBuildPartial);
        }

        public ProtoBuf$CompilerPluginData buildPartial() {
            ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData = new ProtoBuf$CompilerPluginData(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 1 ? 0 : 1;
            protoBuf$CompilerPluginData.pluginId_ = this.pluginId_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$CompilerPluginData.data_ = this.data_;
            protoBuf$CompilerPluginData.bitField0_ = i2;
            return protoBuf$CompilerPluginData;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData) {
            if (protoBuf$CompilerPluginData == ProtoBuf$CompilerPluginData.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$CompilerPluginData.hasPluginId()) {
                setPluginId(protoBuf$CompilerPluginData.getPluginId());
            }
            if (protoBuf$CompilerPluginData.hasData()) {
                setData(protoBuf$CompilerPluginData.getData());
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$CompilerPluginData.unknownFields));
            return this;
        }

        public Builder setData(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.data_ = byteString;
            return this;
        }

        public Builder setPluginId(int i) {
            this.bitField0_ |= 1;
            this.pluginId_ = i;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData = null;
            try {
                try {
                    ProtoBuf$CompilerPluginData partialFrom = ProtoBuf$CompilerPluginData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$CompilerPluginData protoBuf$CompilerPluginData2 = (ProtoBuf$CompilerPluginData) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$CompilerPluginData = protoBuf$CompilerPluginData2;
                        if (protoBuf$CompilerPluginData != null) {
                            mergeFrom(protoBuf$CompilerPluginData);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$CompilerPluginData != null) {
                }
                throw th;
            }
        }
    }

    private ProtoBuf$CompilerPluginData(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$CompilerPluginData(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }
}
