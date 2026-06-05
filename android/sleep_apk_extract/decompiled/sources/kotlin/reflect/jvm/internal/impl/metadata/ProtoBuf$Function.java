package kotlin.reflect.jvm.internal.impl.metadata;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public final class ProtoBuf$Function extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Function> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Function> PARSER = new AbstractParser<ProtoBuf$Function>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Function parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Function(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Function defaultInstance;
    private List<ProtoBuf$Annotation> annotation_;
    private int bitField0_;
    private List<ProtoBuf$CompilerPluginData> compilerPluginData_;
    private List<ProtoBuf$ValueParameter> contextParameter_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private ProtoBuf$Contract contract_;
    private List<ProtoBuf$Annotation> extensionReceiverAnnotation_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    static {
        ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(true);
        defaultInstance = protoBuf$Function;
        protoBuf$Function.initFields();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0394  */
    /* JADX WARN: Type inference failed for: r11v19, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARN: Type inference failed for: r11v52, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$Builder] */
    /* JADX WARN: Type inference failed for: r11v9, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Builder] */
    /* JADX WARN: Type inference failed for: r12v33, types: [kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$Builder] */
    /* JADX WARN: Type inference failed for: r4v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ProtoBuf$Function(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        int i;
        int i2;
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output outputNewOutput = ByteString.newOutput();
        boolean z = true;
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            int i4 = 32768;
            boolean z3 = z;
            ?? unknownField = 256;
             = 256;
            ?? r4 = 256;
            if (z2) {
                if ((i3 & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i3 & 2048) == 2048) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                }
                if ((i3 & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if ((i3 & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((i3 & 1024) == 1024) {
                    this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                }
                if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if ((i3 & 32768) == 32768) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                }
                if ((i3 & 131072) == 131072) {
                    this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.unknownFields = outputNewOutput.toByteString();
                    throw th;
                }
                this.unknownFields = outputNewOutput.toByteString();
                makeExtensionsImmutable();
                return;
            }
            try {
                int tag = codedInputStream.readTag();
                switch (tag) {
                    case 0:
                        z2 = z3;
                        z = z3;
                        break;
                    case 8:
                        this.bitField0_ |= 2;
                        this.oldFlags_ = codedInputStream.readInt32();
                        z = z3;
                        break;
                    case 16:
                        this.bitField0_ |= 4;
                        this.name_ = codedInputStream.readInt32();
                        z = z3;
                        break;
                    case 26:
                        ?? builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                        ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                        this.returnType_ = protoBuf$Type;
                        if (builder != 0) {
                            builder.mergeFrom(protoBuf$Type);
                            this.returnType_ = builder.buildPartial();
                        }
                        this.bitField0_ |= 8;
                        z = z3;
                        break;
                    case 34:
                        if ((i3 & 32) != 32) {
                            this.typeParameter_ = new ArrayList();
                            i3 |= 32;
                        }
                        this.typeParameter_.add((ProtoBuf$TypeParameter) codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                        z = z3;
                        break;
                    case 42:
                        ?? builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                        ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                        this.receiverType_ = protoBuf$Type2;
                        if (builder2 != 0) {
                            builder2.mergeFrom(protoBuf$Type2);
                            this.receiverType_ = builder2.buildPartial();
                        }
                        this.bitField0_ |= 32;
                        z = z3;
                        break;
                    case 50:
                        if ((i3 & 2048) != 2048) {
                            this.valueParameter_ = new ArrayList();
                            i3 |= 2048;
                        }
                        this.valueParameter_.add((ProtoBuf$ValueParameter) codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite));
                        z = z3;
                        break;
                    case 56:
                        this.bitField0_ |= 16;
                        this.returnTypeId_ = codedInputStream.readInt32();
                        z = z3;
                        break;
                    case 64:
                        this.bitField0_ |= 64;
                        this.receiverTypeId_ = codedInputStream.readInt32();
                        z = z3;
                        break;
                    case 72:
                        this.bitField0_ |= 1;
                        this.flags_ = codedInputStream.readInt32();
                        z = z3;
                        break;
                    case 82:
                        if ((i3 & 256) != 256) {
                            this.contextReceiverType_ = new ArrayList();
                            i3 |= 256;
                        }
                        this.contextReceiverType_.add((ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                        z = z3;
                        break;
                    case 88:
                        if ((i3 & 512) != 512) {
                            this.contextReceiverTypeId_ = new ArrayList();
                            i3 |= 512;
                        }
                        this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                        z = z3;
                        break;
                    case 90:
                        int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if ((i3 & 512) != 512 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.contextReceiverTypeId_ = new ArrayList();
                            i3 |= 512;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                        }
                        codedInputStream.popLimit(iPushLimit);
                        z = z3;
                        break;
                    case 98:
                        if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 65536) {
                            this.annotation_ = new ArrayList();
                            i3 |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        }
                        this.annotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                        z = z3;
                        break;
                    case 106:
                        if ((i3 & 1024) != 1024) {
                            this.contextParameter_ = new ArrayList();
                            i3 |= 1024;
                        }
                        this.contextParameter_.add((ProtoBuf$ValueParameter) codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite));
                        z = z3;
                        break;
                    case 242:
                        ?? builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                        ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) codedInputStream.readMessage(ProtoBuf$TypeTable.PARSER, extensionRegistryLite);
                        this.typeTable_ = protoBuf$TypeTable;
                        if (builder3 != 0) {
                            builder3.mergeFrom(protoBuf$TypeTable);
                            this.typeTable_ = builder3.buildPartial();
                        }
                        this.bitField0_ |= 128;
                        z = z3;
                        break;
                    case 248:
                        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 8192) {
                            this.versionRequirement_ = new ArrayList();
                            i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        }
                        this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                        z = z3;
                        break;
                    case 250:
                        i2 = 131072;
                        int iPushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 8192 && codedInputStream.getBytesUntilLimit() > 0) {
                            this.versionRequirement_ = new ArrayList();
                            i3 |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                        }
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            i = i4;
                            try {
                                try {
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                    i4 = i;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if ((i3 & 32) == 32) {
                                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                                    }
                                    if ((i3 & 2048) == 2048) {
                                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                                    }
                                    if ((i3 & 256) == r4) {
                                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                                    }
                                    if ((i3 & 512) == 512) {
                                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                                    }
                                    if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536) {
                                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                                    }
                                    if ((i3 & 1024) == 1024) {
                                        this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                                    }
                                    if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192) {
                                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                                    }
                                    if ((i3 & i) == i) {
                                        this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                                    }
                                    if ((i3 & i2) == i2) {
                                        this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                                    }
                                    try {
                                        codedOutputStreamNewInstance.flush();
                                        break;
                                    } catch (IOException unused2) {
                                    } catch (Throwable th3) {
                                        this.unknownFields = outputNewOutput.toByteString();
                                        throw th3;
                                    }
                                    this.unknownFields = outputNewOutput.toByteString();
                                    makeExtensionsImmutable();
                                    throw th;
                                }
                            } catch (InvalidProtocolBufferException e) {
                                e = e;
                                throw e.setUnfinishedMessage(this);
                            } catch (IOException e2) {
                                e = e2;
                                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                            }
                        }
                        codedInputStream.popLimit(iPushLimit2);
                        z = z3;
                        break;
                    case 258:
                        ?? builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                        ProtoBuf$Contract protoBuf$Contract = (ProtoBuf$Contract) codedInputStream.readMessage(ProtoBuf$Contract.PARSER, extensionRegistryLite);
                        this.contract_ = protoBuf$Contract;
                        if (builder4 != 0) {
                            builder4.mergeFrom(protoBuf$Contract);
                            this.contract_ = builder4.buildPartial();
                        }
                        this.bitField0_ |= 256;
                        z = z3;
                        break;
                    case 266:
                        if ((i3 & 32768) != 32768) {
                            this.compilerPluginData_ = new ArrayList();
                            i3 |= 32768;
                        }
                        this.compilerPluginData_.add((ProtoBuf$CompilerPluginData) codedInputStream.readMessage(ProtoBuf$CompilerPluginData.PARSER, extensionRegistryLite));
                        z = z3;
                        break;
                    case 274:
                        if ((i3 & 131072) != 131072) {
                            this.extensionReceiverAnnotation_ = new ArrayList();
                            i3 |= 131072;
                        }
                        try {
                            i2 = 131072;
                        } catch (InvalidProtocolBufferException e3) {
                            e = e3;
                        } catch (IOException e4) {
                            e = e4;
                        } catch (Throwable th4) {
                            th = th4;
                            i2 = 131072;
                        }
                        try {
                            this.extensionReceiverAnnotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            z = z3;
                        } catch (InvalidProtocolBufferException e5) {
                            e = e5;
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e6) {
                            e = e6;
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        } catch (Throwable th5) {
                            th = th5;
                            i = 32768;
                            if ((i3 & 32) == 32) {
                            }
                            if ((i3 & 2048) == 2048) {
                            }
                            if ((i3 & 256) == r4) {
                            }
                            if ((i3 & 512) == 512) {
                            }
                            if ((i3 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536) {
                            }
                            if ((i3 & 1024) == 1024) {
                            }
                            if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192) {
                            }
                            if ((i3 & i) == i) {
                            }
                            if ((i3 & i2) == i2) {
                            }
                            codedOutputStreamNewInstance.flush();
                            this.unknownFields = outputNewOutput.toByteString();
                            makeExtensionsImmutable();
                            throw th;
                        }
                        break;
                    default:
                        unknownField = parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag);
                        if (unknownField == 0) {
                        }
                        z = z3;
                        break;
                }
            } catch (InvalidProtocolBufferException e7) {
                e = e7;
            } catch (IOException e8) {
                e = e8;
            } catch (Throwable th6) {
                th = th6;
                i = 32768;
                i2 = 131072;
                r4 = unknownField;
            }
        }
    }

    public static ProtoBuf$Function getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        List list = Collections.EMPTY_LIST;
        this.typeParameter_ = list;
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = list;
        this.contextReceiverTypeId_ = list;
        this.contextParameter_ = list;
        this.valueParameter_ = list;
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirement_ = list;
        this.contract_ = ProtoBuf$Contract.getDefaultInstance();
        this.compilerPluginData_ = list;
        this.annotation_ = list;
        this.extensionReceiverAnnotation_ = list;
    }

    public static Builder newBuilder(ProtoBuf$Function protoBuf$Function) {
        return newBuilder().mergeFrom(protoBuf$Function);
    }

    public static ProtoBuf$Function parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public ProtoBuf$Annotation getAnnotation(int i) {
        return this.annotation_.get(i);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<ProtoBuf$Annotation> getAnnotationList() {
        return this.annotation_;
    }

    public ProtoBuf$CompilerPluginData getCompilerPluginData(int i) {
        return this.compilerPluginData_.get(i);
    }

    public int getCompilerPluginDataCount() {
        return this.compilerPluginData_.size();
    }

    public List<ProtoBuf$CompilerPluginData> getCompilerPluginDataList() {
        return this.compilerPluginData_;
    }

    public ProtoBuf$ValueParameter getContextParameter(int i) {
        return this.contextParameter_.get(i);
    }

    public int getContextParameterCount() {
        return this.contextParameter_.size();
    }

    public List<ProtoBuf$ValueParameter> getContextParameterList() {
        return this.contextParameter_;
    }

    public ProtoBuf$Type getContextReceiverType(int i) {
        return this.contextReceiverType_.get(i);
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public ProtoBuf$Contract getContract() {
        return this.contract_;
    }

    public ProtoBuf$Annotation getExtensionReceiverAnnotation(int i) {
        return this.extensionReceiverAnnotation_.get(i);
    }

    public int getExtensionReceiverAnnotationCount() {
        return this.extensionReceiverAnnotation_.size();
    }

    public List<ProtoBuf$Annotation> getExtensionReceiverAnnotationList() {
        return this.extensionReceiverAnnotation_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    public ProtoBuf$Type getReceiverType() {
        return this.receiverType_;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public ProtoBuf$Type getReturnType() {
        return this.returnType_;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) : 0;
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
        }
        for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i3));
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.flags_);
        }
        for (int i4 = 0; i4 < this.contextReceiverType_.size(); i4++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(i4));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i5 = 0; i5 < this.contextReceiverTypeId_.size(); i5++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i5).intValue());
        }
        int iComputeMessageSize = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getContextReceiverTypeIdList().isEmpty()) {
            iComputeMessageSize = iComputeMessageSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        for (int i6 = 0; i6 < this.annotation_.size(); i6++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(12, this.annotation_.get(i6));
        }
        for (int i7 = 0; i7 < this.contextParameter_.size(); i7++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(13, this.contextParameter_.get(i7));
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int iComputeInt32SizeNoTag2 = 0;
        for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i8).intValue());
        }
        int size = (getVersionRequirementList().size() * 2) + iComputeMessageSize + iComputeInt32SizeNoTag2;
        if ((this.bitField0_ & 256) == 256) {
            size += CodedOutputStream.computeMessageSize(32, this.contract_);
        }
        for (int i9 = 0; i9 < this.compilerPluginData_.size(); i9++) {
            size += CodedOutputStream.computeMessageSize(33, this.compilerPluginData_.get(i9));
        }
        for (int i10 = 0; i10 < this.extensionReceiverAnnotation_.size(); i10++) {
            size += CodedOutputStream.computeMessageSize(34, this.extensionReceiverAnnotation_.get(i10));
        }
        int size2 = this.unknownFields.size() + extensionsSerializedSize() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public ProtoBuf$TypeParameter getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public ProtoBuf$ValueParameter getValueParameter(int i) {
        return this.valueParameter_.get(i);
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
    }

    public List<ProtoBuf$ValueParameter> getValueParameterList() {
        return this.valueParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasContract() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasOldFlags() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReceiverType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasReceiverTypeId() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasReturnType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasReturnTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 128) == 128;
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasReturnType() && !getReturnType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasReceiverType() && !getReceiverType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < getContextReceiverTypeCount(); i2++) {
            if (!getContextReceiverType(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getContextParameterCount(); i3++) {
            if (!getContextParameter(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < getValueParameterCount(); i4++) {
            if (!getValueParameter(i4).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasContract() && !getContract().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i5 = 0; i5 < getCompilerPluginDataCount(); i5++) {
            if (!getCompilerPluginData(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getAnnotationCount(); i6++) {
            if (!getAnnotation(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getExtensionReceiverAnnotationCount(); i7++) {
            if (!getExtensionReceiverAnnotation(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (extensionsAreInitialized()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(3, this.returnType_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeMessage(5, this.receiverType_);
        }
        for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
            codedOutputStream.writeMessage(6, this.valueParameter_.get(i2));
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(9, this.flags_);
        }
        for (int i3 = 0; i3 < this.contextReceiverType_.size(); i3++) {
            codedOutputStream.writeMessage(10, this.contextReceiverType_.get(i3));
        }
        if (getContextReceiverTypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(90);
            codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i4 = 0; i4 < this.contextReceiverTypeId_.size(); i4++) {
            codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.annotation_.size(); i5++) {
            codedOutputStream.writeMessage(12, this.annotation_.get(i5));
        }
        for (int i6 = 0; i6 < this.contextParameter_.size(); i6++) {
            codedOutputStream.writeMessage(13, this.contextParameter_.get(i6));
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i7 = 0; i7 < this.versionRequirement_.size(); i7++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i7).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(32, this.contract_);
        }
        for (int i8 = 0; i8 < this.compilerPluginData_.size(); i8++) {
            codedOutputStream.writeMessage(33, this.compilerPluginData_.get(i8));
        }
        for (int i9 = 0; i9 < this.extensionReceiverAnnotation_.size(); i9++) {
            codedOutputStream.writeMessage(34, this.extensionReceiverAnnotation_.get(i9));
        }
        extensionWriterNewExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Function getDefaultInstanceForType() {
        return defaultInstance;
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

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Function, Builder> implements MessageLiteOrBuilder {
        private List<ProtoBuf$Annotation> annotation_;
        private int bitField0_;
        private List<ProtoBuf$CompilerPluginData> compilerPluginData_;
        private List<ProtoBuf$ValueParameter> contextParameter_;
        private List<Integer> contextReceiverTypeId_;
        private List<ProtoBuf$Type> contextReceiverType_;
        private ProtoBuf$Contract contract_;
        private List<ProtoBuf$Annotation> extensionReceiverAnnotation_;
        private int name_;
        private int receiverTypeId_;
        private ProtoBuf$Type receiverType_;
        private int returnTypeId_;
        private List<ProtoBuf$TypeParameter> typeParameter_;
        private ProtoBuf$TypeTable typeTable_;
        private List<ProtoBuf$ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;
        private int flags_ = 6;
        private int oldFlags_ = 6;
        private ProtoBuf$Type returnType_ = ProtoBuf$Type.getDefaultInstance();

        private Builder() {
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
            this.contextReceiverType_ = list;
            this.contextReceiverTypeId_ = list;
            this.contextParameter_ = list;
            this.valueParameter_ = list;
            this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
            this.versionRequirement_ = list;
            this.contract_ = ProtoBuf$Contract.getDefaultInstance();
            this.compilerPluginData_ = list;
            this.annotation_ = list;
            this.extensionReceiverAnnotation_ = list;
            maybeForceBuilderInitialization();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Builder create() {
            return new Builder();
        }

        private void ensureAnnotationIsMutable() {
            if ((this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 65536) {
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
            }
        }

        private void ensureCompilerPluginDataIsMutable() {
            if ((this.bitField0_ & 32768) != 32768) {
                this.compilerPluginData_ = new ArrayList(this.compilerPluginData_);
                this.bitField0_ |= 32768;
            }
        }

        private void ensureContextParameterIsMutable() {
            if ((this.bitField0_ & 1024) != 1024) {
                this.contextParameter_ = new ArrayList(this.contextParameter_);
                this.bitField0_ |= 1024;
            }
        }

        private void ensureContextReceiverTypeIdIsMutable() {
            if ((this.bitField0_ & 512) != 512) {
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
            }
        }

        private void ensureContextReceiverTypeIsMutable() {
            if ((this.bitField0_ & 256) != 256) {
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
            }
        }

        private void ensureExtensionReceiverAnnotationIsMutable() {
            if ((this.bitField0_ & 131072) != 131072) {
                this.extensionReceiverAnnotation_ = new ArrayList(this.extensionReceiverAnnotation_);
                this.bitField0_ |= 131072;
            }
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureValueParameterIsMutable() {
            if ((this.bitField0_ & 2048) != 2048) {
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 2048;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 8192) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Function build() {
            ProtoBuf$Function protoBuf$FunctionBuildPartial = buildPartial();
            if (protoBuf$FunctionBuildPartial.isInitialized()) {
                return protoBuf$FunctionBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$FunctionBuildPartial);
        }

        public ProtoBuf$Function buildPartial() {
            ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 1 ? 0 : 1;
            protoBuf$Function.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Function.oldFlags_ = this.oldFlags_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Function.name_ = this.name_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Function.returnType_ = this.returnType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Function.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Function.typeParameter_ = this.typeParameter_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Function.receiverType_ = this.receiverType_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Function.receiverTypeId_ = this.receiverTypeId_;
            if ((this.bitField0_ & 256) == 256) {
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            }
            protoBuf$Function.contextReceiverType_ = this.contextReceiverType_;
            if ((this.bitField0_ & 512) == 512) {
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -513;
            }
            protoBuf$Function.contextReceiverTypeId_ = this.contextReceiverTypeId_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Function.contextParameter_ = this.contextParameter_;
            if ((this.bitField0_ & 2048) == 2048) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -2049;
            }
            protoBuf$Function.valueParameter_ = this.valueParameter_;
            if ((i & 4096) == 4096) {
                i2 |= 128;
            }
            protoBuf$Function.typeTable_ = this.typeTable_;
            if ((this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -8193;
            }
            protoBuf$Function.versionRequirement_ = this.versionRequirement_;
            if ((i & 16384) == 16384) {
                i2 |= 256;
            }
            protoBuf$Function.contract_ = this.contract_;
            if ((this.bitField0_ & 32768) == 32768) {
                this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                this.bitField0_ &= -32769;
            }
            protoBuf$Function.compilerPluginData_ = this.compilerPluginData_;
            if ((this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -65537;
            }
            protoBuf$Function.annotation_ = this.annotation_;
            if ((this.bitField0_ & 131072) == 131072) {
                this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                this.bitField0_ &= -131073;
            }
            protoBuf$Function.extensionReceiverAnnotation_ = this.extensionReceiverAnnotation_;
            protoBuf$Function.bitField0_ = i2;
            return protoBuf$Function;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        public Builder mergeContract(ProtoBuf$Contract protoBuf$Contract) {
            if ((this.bitField0_ & 16384) != 16384 || this.contract_ == ProtoBuf$Contract.getDefaultInstance()) {
                this.contract_ = protoBuf$Contract;
            } else {
                this.contract_ = ProtoBuf$Contract.newBuilder(this.contract_).mergeFrom(protoBuf$Contract).buildPartial();
            }
            this.bitField0_ |= 16384;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Function protoBuf$Function) {
            if (protoBuf$Function == ProtoBuf$Function.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Function.hasFlags()) {
                setFlags(protoBuf$Function.getFlags());
            }
            if (protoBuf$Function.hasOldFlags()) {
                setOldFlags(protoBuf$Function.getOldFlags());
            }
            if (protoBuf$Function.hasName()) {
                setName(protoBuf$Function.getName());
            }
            if (protoBuf$Function.hasReturnType()) {
                mergeReturnType(protoBuf$Function.getReturnType());
            }
            if (protoBuf$Function.hasReturnTypeId()) {
                setReturnTypeId(protoBuf$Function.getReturnTypeId());
            }
            if (!protoBuf$Function.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Function.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Function.typeParameter_);
                }
            }
            if (protoBuf$Function.hasReceiverType()) {
                mergeReceiverType(protoBuf$Function.getReceiverType());
            }
            if (protoBuf$Function.hasReceiverTypeId()) {
                setReceiverTypeId(protoBuf$Function.getReceiverTypeId());
            }
            if (!protoBuf$Function.contextReceiverType_.isEmpty()) {
                if (this.contextReceiverType_.isEmpty()) {
                    this.contextReceiverType_ = protoBuf$Function.contextReceiverType_;
                    this.bitField0_ &= -257;
                } else {
                    ensureContextReceiverTypeIsMutable();
                    this.contextReceiverType_.addAll(protoBuf$Function.contextReceiverType_);
                }
            }
            if (!protoBuf$Function.contextReceiverTypeId_.isEmpty()) {
                if (this.contextReceiverTypeId_.isEmpty()) {
                    this.contextReceiverTypeId_ = protoBuf$Function.contextReceiverTypeId_;
                    this.bitField0_ &= -513;
                } else {
                    ensureContextReceiverTypeIdIsMutable();
                    this.contextReceiverTypeId_.addAll(protoBuf$Function.contextReceiverTypeId_);
                }
            }
            if (!protoBuf$Function.contextParameter_.isEmpty()) {
                if (this.contextParameter_.isEmpty()) {
                    this.contextParameter_ = protoBuf$Function.contextParameter_;
                    this.bitField0_ &= -1025;
                } else {
                    ensureContextParameterIsMutable();
                    this.contextParameter_.addAll(protoBuf$Function.contextParameter_);
                }
            }
            if (!protoBuf$Function.valueParameter_.isEmpty()) {
                if (this.valueParameter_.isEmpty()) {
                    this.valueParameter_ = protoBuf$Function.valueParameter_;
                    this.bitField0_ &= -2049;
                } else {
                    ensureValueParameterIsMutable();
                    this.valueParameter_.addAll(protoBuf$Function.valueParameter_);
                }
            }
            if (protoBuf$Function.hasTypeTable()) {
                mergeTypeTable(protoBuf$Function.getTypeTable());
            }
            if (!protoBuf$Function.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Function.versionRequirement_;
                    this.bitField0_ &= -8193;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Function.versionRequirement_);
                }
            }
            if (protoBuf$Function.hasContract()) {
                mergeContract(protoBuf$Function.getContract());
            }
            if (!protoBuf$Function.compilerPluginData_.isEmpty()) {
                if (this.compilerPluginData_.isEmpty()) {
                    this.compilerPluginData_ = protoBuf$Function.compilerPluginData_;
                    this.bitField0_ &= -32769;
                } else {
                    ensureCompilerPluginDataIsMutable();
                    this.compilerPluginData_.addAll(protoBuf$Function.compilerPluginData_);
                }
            }
            if (!protoBuf$Function.annotation_.isEmpty()) {
                if (this.annotation_.isEmpty()) {
                    this.annotation_ = protoBuf$Function.annotation_;
                    this.bitField0_ &= -65537;
                } else {
                    ensureAnnotationIsMutable();
                    this.annotation_.addAll(protoBuf$Function.annotation_);
                }
            }
            if (!protoBuf$Function.extensionReceiverAnnotation_.isEmpty()) {
                if (this.extensionReceiverAnnotation_.isEmpty()) {
                    this.extensionReceiverAnnotation_ = protoBuf$Function.extensionReceiverAnnotation_;
                    this.bitField0_ &= -131073;
                } else {
                    ensureExtensionReceiverAnnotationIsMutable();
                    this.extensionReceiverAnnotation_.addAll(protoBuf$Function.extensionReceiverAnnotation_);
                }
            }
            mergeExtensionFields(protoBuf$Function);
            setUnknownFields(getUnknownFields().concat(protoBuf$Function.unknownFields));
            return this;
        }

        public Builder mergeReceiverType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 64) != 64 || this.receiverType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.receiverType_ = protoBuf$Type;
            } else {
                this.receiverType_ = ProtoBuf$Type.newBuilder(this.receiverType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 64;
            return this;
        }

        public Builder mergeReturnType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.returnType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.returnType_ = protoBuf$Type;
            } else {
                this.returnType_ = ProtoBuf$Type.newBuilder(this.returnType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder mergeTypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.bitField0_ & 4096) != 4096 || this.typeTable_ == ProtoBuf$TypeTable.getDefaultInstance()) {
                this.typeTable_ = protoBuf$TypeTable;
            } else {
                this.typeTable_ = ProtoBuf$TypeTable.newBuilder(this.typeTable_).mergeFrom(protoBuf$TypeTable).buildPartial();
            }
            this.bitField0_ |= 4096;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setName(int i) {
            this.bitField0_ |= 4;
            this.name_ = i;
            return this;
        }

        public Builder setOldFlags(int i) {
            this.bitField0_ |= 2;
            this.oldFlags_ = i;
            return this;
        }

        public Builder setReceiverTypeId(int i) {
            this.bitField0_ |= 128;
            this.receiverTypeId_ = i;
            return this;
        }

        public Builder setReturnTypeId(int i) {
            this.bitField0_ |= 16;
            this.returnTypeId_ = i;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$Function protoBuf$Function = null;
            try {
                try {
                    ProtoBuf$Function partialFrom = ProtoBuf$Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$Function protoBuf$Function2 = (ProtoBuf$Function) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Function = protoBuf$Function2;
                        if (protoBuf$Function != null) {
                            mergeFrom(protoBuf$Function);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Function != null) {
                }
                throw th;
            }
        }
    }

    private ProtoBuf$Function(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Function, ?> extendableBuilder) {
        super(extendableBuilder);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Function(boolean z) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }
}
