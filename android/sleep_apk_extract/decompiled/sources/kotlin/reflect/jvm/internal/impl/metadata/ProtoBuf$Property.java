package kotlin.reflect.jvm.internal.impl.metadata;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
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
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Property> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Property> PARSER = new AbstractParser<ProtoBuf$Property>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Property parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Property(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Property defaultInstance;
    private List<ProtoBuf$Annotation> annotation_;
    private List<ProtoBuf$Annotation> backingFieldAnnotation_;
    private int bitField0_;
    private List<ProtoBuf$CompilerPluginData> compilerPluginData_;
    private List<ProtoBuf$ValueParameter> contextParameter_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private List<ProtoBuf$Annotation> delegateFieldAnnotation_;
    private List<ProtoBuf$Annotation> extensionReceiverAnnotation_;
    private int flags_;
    private List<ProtoBuf$Annotation> getterAnnotation_;
    private ProtoBuf$Contract getterContract_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private List<ProtoBuf$Annotation> setterAnnotation_;
    private ProtoBuf$Contract setterContract_;
    private int setterFlags_;
    private ProtoBuf$ValueParameter setterValueParameter_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private final ByteString unknownFields;
    private List<Integer> versionRequirement_;

    static {
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(true);
        defaultInstance = protoBuf$Property;
        protoBuf$Property.initFields();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ProtoBuf$Property(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output outputNewOutput = ByteString.newOutput();
        boolean z = true;
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(outputNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (true) {
            boolean z3 = z;
            if (z2) {
                if ((i & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if ((i & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if ((i & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((i & 131072) == 131072) {
                    this.getterAnnotation_ = Collections.unmodifiableList(this.getterAnnotation_);
                }
                if ((i & 262144) == 262144) {
                    this.setterAnnotation_ = Collections.unmodifiableList(this.setterAnnotation_);
                }
                if ((i & 1024) == 1024) {
                    this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                }
                if ((i & 16384) == 16384) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                if ((i & 32768) == 32768) {
                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                }
                if ((i & 524288) == 524288) {
                    this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                }
                if ((i & 1048576) == 1048576) {
                    this.backingFieldAnnotation_ = Collections.unmodifiableList(this.backingFieldAnnotation_);
                }
                if ((i & 2097152) == 2097152) {
                    this.delegateFieldAnnotation_ = Collections.unmodifiableList(this.delegateFieldAnnotation_);
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
                            ProtoBuf$Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
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
                            if ((i & 32) != 32) {
                                this.typeParameter_ = new ArrayList();
                                i |= 32;
                            }
                            this.typeParameter_.add((ProtoBuf$TypeParameter) codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 42:
                            ProtoBuf$Type.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
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
                            ProtoBuf$ValueParameter.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                            ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite);
                            this.setterValueParameter_ = protoBuf$ValueParameter;
                            if (builder3 != 0) {
                                builder3.mergeFrom(protoBuf$ValueParameter);
                                this.setterValueParameter_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            z = z3;
                            break;
                        case 56:
                            this.bitField0_ |= 256;
                            this.getterFlags_ = codedInputStream.readInt32();
                            z = z3;
                            break;
                        case 64:
                            this.bitField0_ |= 512;
                            this.setterFlags_ = codedInputStream.readInt32();
                            z = z3;
                            break;
                        case 72:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = codedInputStream.readInt32();
                            z = z3;
                            break;
                        case 80:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = codedInputStream.readInt32();
                            z = z3;
                            break;
                        case 88:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            z = z3;
                            break;
                        case 98:
                            if ((i & 256) != 256) {
                                this.contextReceiverType_ = new ArrayList();
                                i |= 256;
                            }
                            this.contextReceiverType_.add((ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 104:
                            if ((i & 512) != 512) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i |= 512;
                            }
                            this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            z = z3;
                            break;
                        case 106:
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 512) != 512 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_ = new ArrayList();
                                i |= 512;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit);
                            z = z3;
                            break;
                        case 114:
                            if ((i & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 65536) {
                                this.annotation_ = new ArrayList();
                                i |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                            }
                            this.annotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 122:
                            if ((i & 131072) != 131072) {
                                this.getterAnnotation_ = new ArrayList();
                                i |= 131072;
                            }
                            this.getterAnnotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 130:
                            if ((i & 262144) != 262144) {
                                this.setterAnnotation_ = new ArrayList();
                                i |= 262144;
                            }
                            this.setterAnnotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 138:
                            if ((i & 1024) != 1024) {
                                this.contextParameter_ = new ArrayList();
                                i |= 1024;
                            }
                            this.contextParameter_.add((ProtoBuf$ValueParameter) codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 248:
                            if ((i & 16384) != 16384) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            z = z3;
                            break;
                        case 250:
                            int iPushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 16384) != 16384 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit2);
                            z = z3;
                            break;
                        case 258:
                            if ((i & 32768) != 32768) {
                                this.compilerPluginData_ = new ArrayList();
                                i |= 32768;
                            }
                            this.compilerPluginData_.add((ProtoBuf$CompilerPluginData) codedInputStream.readMessage(ProtoBuf$CompilerPluginData.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 266:
                            if ((i & 524288) != 524288) {
                                this.extensionReceiverAnnotation_ = new ArrayList();
                                i |= 524288;
                            }
                            this.extensionReceiverAnnotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 274:
                            if ((i & 1048576) != 1048576) {
                                this.backingFieldAnnotation_ = new ArrayList();
                                i |= 1048576;
                            }
                            this.backingFieldAnnotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 282:
                            if ((i & 2097152) != 2097152) {
                                this.delegateFieldAnnotation_ = new ArrayList();
                                i |= 2097152;
                            }
                            this.delegateFieldAnnotation_.add((ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            z = z3;
                            break;
                        case 322:
                            ProtoBuf$Contract.Builder builder4 = (this.bitField0_ & 1024) == 1024 ? this.getterContract_.toBuilder() : null;
                            ProtoBuf$Contract protoBuf$Contract = (ProtoBuf$Contract) codedInputStream.readMessage(ProtoBuf$Contract.PARSER, extensionRegistryLite);
                            this.getterContract_ = protoBuf$Contract;
                            if (builder4 != 0) {
                                builder4.mergeFrom(protoBuf$Contract);
                                this.getterContract_ = builder4.buildPartial();
                            }
                            this.bitField0_ |= 1024;
                            z = z3;
                            break;
                        case 330:
                            try {
                                ProtoBuf$Contract.Builder builder5 = (this.bitField0_ & 2048) == 2048 ? this.setterContract_.toBuilder() : null;
                                ProtoBuf$Contract protoBuf$Contract2 = (ProtoBuf$Contract) codedInputStream.readMessage(ProtoBuf$Contract.PARSER, extensionRegistryLite);
                                this.setterContract_ = protoBuf$Contract2;
                                if (builder5 != 0) {
                                    builder5.mergeFrom(protoBuf$Contract2);
                                    this.setterContract_ = builder5.buildPartial();
                                }
                                this.bitField0_ |= 2048;
                                z = z3;
                            } catch (InvalidProtocolBufferException e) {
                                e = e;
                                throw e.setUnfinishedMessage(this);
                            } catch (IOException e2) {
                                e = e2;
                                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                            } catch (Throwable th2) {
                                th = th2;
                                if ((i & 32) == 32) {
                                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                                }
                                if ((i & 256) == 256) {
                                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                                }
                                if ((i & 512) == 512) {
                                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                                }
                                if ((i & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536) {
                                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                                }
                                if ((i & 131072) == 131072) {
                                    this.getterAnnotation_ = Collections.unmodifiableList(this.getterAnnotation_);
                                }
                                if ((i & 262144) == 262144) {
                                    this.setterAnnotation_ = Collections.unmodifiableList(this.setterAnnotation_);
                                }
                                if ((i & 1024) == 1024) {
                                    this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                                }
                                if ((i & 16384) == 16384) {
                                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                                }
                                if ((i & 32768) == 32768) {
                                    this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                                }
                                if ((i & 524288) == 524288) {
                                    this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                                }
                                if ((i & 1048576) == 1048576) {
                                    this.backingFieldAnnotation_ = Collections.unmodifiableList(this.backingFieldAnnotation_);
                                }
                                if ((i & 2097152) == 2097152) {
                                    this.delegateFieldAnnotation_ = Collections.unmodifiableList(this.delegateFieldAnnotation_);
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
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                            }
                            z = z3;
                            break;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (InvalidProtocolBufferException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        }
    }

    public static ProtoBuf$Property getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
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
        this.setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = list;
        this.compilerPluginData_ = list;
        this.annotation_ = list;
        this.getterAnnotation_ = list;
        this.setterAnnotation_ = list;
        this.extensionReceiverAnnotation_ = list;
        this.backingFieldAnnotation_ = list;
        this.delegateFieldAnnotation_ = list;
        this.getterContract_ = ProtoBuf$Contract.getDefaultInstance();
        this.setterContract_ = ProtoBuf$Contract.getDefaultInstance();
    }

    public static Builder newBuilder(ProtoBuf$Property protoBuf$Property) {
        return newBuilder().mergeFrom(protoBuf$Property);
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

    public ProtoBuf$Annotation getBackingFieldAnnotation(int i) {
        return this.backingFieldAnnotation_.get(i);
    }

    public int getBackingFieldAnnotationCount() {
        return this.backingFieldAnnotation_.size();
    }

    public List<ProtoBuf$Annotation> getBackingFieldAnnotationList() {
        return this.backingFieldAnnotation_;
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

    public ProtoBuf$Annotation getDelegateFieldAnnotation(int i) {
        return this.delegateFieldAnnotation_.get(i);
    }

    public int getDelegateFieldAnnotationCount() {
        return this.delegateFieldAnnotation_.size();
    }

    public List<ProtoBuf$Annotation> getDelegateFieldAnnotationList() {
        return this.delegateFieldAnnotation_;
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

    public ProtoBuf$Annotation getGetterAnnotation(int i) {
        return this.getterAnnotation_.get(i);
    }

    public int getGetterAnnotationCount() {
        return this.getterAnnotation_.size();
    }

    public List<ProtoBuf$Annotation> getGetterAnnotationList() {
        return this.getterAnnotation_;
    }

    public ProtoBuf$Contract getGetterContract() {
        return this.getterContract_;
    }

    public int getGetterFlags() {
        return this.getterFlags_;
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
        if ((this.bitField0_ & 128) == 128) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
        }
        for (int i3 = 0; i3 < this.contextReceiverType_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(i3));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < this.contextReceiverTypeId_.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i4).intValue());
        }
        int iComputeMessageSize = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getContextReceiverTypeIdList().isEmpty()) {
            iComputeMessageSize = iComputeMessageSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        for (int i5 = 0; i5 < this.annotation_.size(); i5++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(14, this.annotation_.get(i5));
        }
        for (int i6 = 0; i6 < this.getterAnnotation_.size(); i6++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(15, this.getterAnnotation_.get(i6));
        }
        for (int i7 = 0; i7 < this.setterAnnotation_.size(); i7++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(16, this.setterAnnotation_.get(i7));
        }
        for (int i8 = 0; i8 < this.contextParameter_.size(); i8++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(17, this.contextParameter_.get(i8));
        }
        int iComputeInt32SizeNoTag2 = 0;
        for (int i9 = 0; i9 < this.versionRequirement_.size(); i9++) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i9).intValue());
        }
        int size = (getVersionRequirementList().size() * 2) + iComputeMessageSize + iComputeInt32SizeNoTag2;
        for (int i10 = 0; i10 < this.compilerPluginData_.size(); i10++) {
            size += CodedOutputStream.computeMessageSize(32, this.compilerPluginData_.get(i10));
        }
        for (int i11 = 0; i11 < this.extensionReceiverAnnotation_.size(); i11++) {
            size += CodedOutputStream.computeMessageSize(33, this.extensionReceiverAnnotation_.get(i11));
        }
        for (int i12 = 0; i12 < this.backingFieldAnnotation_.size(); i12++) {
            size += CodedOutputStream.computeMessageSize(34, this.backingFieldAnnotation_.get(i12));
        }
        for (int i13 = 0; i13 < this.delegateFieldAnnotation_.size(); i13++) {
            size += CodedOutputStream.computeMessageSize(35, this.delegateFieldAnnotation_.get(i13));
        }
        if ((this.bitField0_ & 1024) == 1024) {
            size += CodedOutputStream.computeMessageSize(40, this.getterContract_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            size += CodedOutputStream.computeMessageSize(41, this.setterContract_);
        }
        int size2 = this.unknownFields.size() + extensionsSerializedSize() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public ProtoBuf$Annotation getSetterAnnotation(int i) {
        return this.setterAnnotation_.get(i);
    }

    public int getSetterAnnotationCount() {
        return this.setterAnnotation_.size();
    }

    public List<ProtoBuf$Annotation> getSetterAnnotationList() {
        return this.setterAnnotation_;
    }

    public ProtoBuf$Contract getSetterContract() {
        return this.setterContract_;
    }

    public int getSetterFlags() {
        return this.setterFlags_;
    }

    public ProtoBuf$ValueParameter getSetterValueParameter() {
        return this.setterValueParameter_;
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

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasGetterContract() {
        return (this.bitField0_ & 1024) == 1024;
    }

    public boolean hasGetterFlags() {
        return (this.bitField0_ & 256) == 256;
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

    public boolean hasSetterContract() {
        return (this.bitField0_ & 2048) == 2048;
    }

    public boolean hasSetterFlags() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasSetterValueParameter() {
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
        if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i4 = 0; i4 < getCompilerPluginDataCount(); i4++) {
            if (!getCompilerPluginData(i4).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < getAnnotationCount(); i5++) {
            if (!getAnnotation(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getGetterAnnotationCount(); i6++) {
            if (!getGetterAnnotation(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getSetterAnnotationCount(); i7++) {
            if (!getSetterAnnotation(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i8 = 0; i8 < getExtensionReceiverAnnotationCount(); i8++) {
            if (!getExtensionReceiverAnnotation(i8).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i9 = 0; i9 < getBackingFieldAnnotationCount(); i9++) {
            if (!getBackingFieldAnnotation(i9).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i10 = 0; i10 < getDelegateFieldAnnotationCount(); i10++) {
            if (!getDelegateFieldAnnotation(i10).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasGetterContract() && !getGetterContract().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasSetterContract() && !getSetterContract().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
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
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeInt32(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(11, this.flags_);
        }
        for (int i2 = 0; i2 < this.contextReceiverType_.size(); i2++) {
            codedOutputStream.writeMessage(12, this.contextReceiverType_.get(i2));
        }
        if (getContextReceiverTypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(106);
            codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i3 = 0; i3 < this.contextReceiverTypeId_.size(); i3++) {
            codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i3).intValue());
        }
        for (int i4 = 0; i4 < this.annotation_.size(); i4++) {
            codedOutputStream.writeMessage(14, this.annotation_.get(i4));
        }
        for (int i5 = 0; i5 < this.getterAnnotation_.size(); i5++) {
            codedOutputStream.writeMessage(15, this.getterAnnotation_.get(i5));
        }
        for (int i6 = 0; i6 < this.setterAnnotation_.size(); i6++) {
            codedOutputStream.writeMessage(16, this.setterAnnotation_.get(i6));
        }
        for (int i7 = 0; i7 < this.contextParameter_.size(); i7++) {
            codedOutputStream.writeMessage(17, this.contextParameter_.get(i7));
        }
        for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i8).intValue());
        }
        for (int i9 = 0; i9 < this.compilerPluginData_.size(); i9++) {
            codedOutputStream.writeMessage(32, this.compilerPluginData_.get(i9));
        }
        for (int i10 = 0; i10 < this.extensionReceiverAnnotation_.size(); i10++) {
            codedOutputStream.writeMessage(33, this.extensionReceiverAnnotation_.get(i10));
        }
        for (int i11 = 0; i11 < this.backingFieldAnnotation_.size(); i11++) {
            codedOutputStream.writeMessage(34, this.backingFieldAnnotation_.get(i11));
        }
        for (int i12 = 0; i12 < this.delegateFieldAnnotation_.size(); i12++) {
            codedOutputStream.writeMessage(35, this.delegateFieldAnnotation_.get(i12));
        }
        if ((this.bitField0_ & 1024) == 1024) {
            codedOutputStream.writeMessage(40, this.getterContract_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            codedOutputStream.writeMessage(41, this.setterContract_);
        }
        extensionWriterNewExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Property getDefaultInstanceForType() {
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

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Property, Builder> implements MessageLiteOrBuilder {
        private List<ProtoBuf$Annotation> annotation_;
        private List<ProtoBuf$Annotation> backingFieldAnnotation_;
        private int bitField0_;
        private List<ProtoBuf$CompilerPluginData> compilerPluginData_;
        private List<ProtoBuf$ValueParameter> contextParameter_;
        private List<Integer> contextReceiverTypeId_;
        private List<ProtoBuf$Type> contextReceiverType_;
        private List<ProtoBuf$Annotation> delegateFieldAnnotation_;
        private List<ProtoBuf$Annotation> extensionReceiverAnnotation_;
        private List<ProtoBuf$Annotation> getterAnnotation_;
        private ProtoBuf$Contract getterContract_;
        private int getterFlags_;
        private int name_;
        private int receiverTypeId_;
        private ProtoBuf$Type receiverType_;
        private int returnTypeId_;
        private List<ProtoBuf$Annotation> setterAnnotation_;
        private ProtoBuf$Contract setterContract_;
        private int setterFlags_;
        private ProtoBuf$ValueParameter setterValueParameter_;
        private List<ProtoBuf$TypeParameter> typeParameter_;
        private List<Integer> versionRequirement_;
        private int flags_ = 518;
        private int oldFlags_ = 2054;
        private ProtoBuf$Type returnType_ = ProtoBuf$Type.getDefaultInstance();

        private Builder() {
            List list = Collections.EMPTY_LIST;
            this.typeParameter_ = list;
            this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
            this.contextReceiverType_ = list;
            this.contextReceiverTypeId_ = list;
            this.contextParameter_ = list;
            this.setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
            this.versionRequirement_ = list;
            this.compilerPluginData_ = list;
            this.annotation_ = list;
            this.getterAnnotation_ = list;
            this.setterAnnotation_ = list;
            this.extensionReceiverAnnotation_ = list;
            this.backingFieldAnnotation_ = list;
            this.delegateFieldAnnotation_ = list;
            this.getterContract_ = ProtoBuf$Contract.getDefaultInstance();
            this.setterContract_ = ProtoBuf$Contract.getDefaultInstance();
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

        private void ensureBackingFieldAnnotationIsMutable() {
            if ((this.bitField0_ & 1048576) != 1048576) {
                this.backingFieldAnnotation_ = new ArrayList(this.backingFieldAnnotation_);
                this.bitField0_ |= 1048576;
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

        private void ensureDelegateFieldAnnotationIsMutable() {
            if ((this.bitField0_ & 2097152) != 2097152) {
                this.delegateFieldAnnotation_ = new ArrayList(this.delegateFieldAnnotation_);
                this.bitField0_ |= 2097152;
            }
        }

        private void ensureExtensionReceiverAnnotationIsMutable() {
            if ((this.bitField0_ & 524288) != 524288) {
                this.extensionReceiverAnnotation_ = new ArrayList(this.extensionReceiverAnnotation_);
                this.bitField0_ |= 524288;
            }
        }

        private void ensureGetterAnnotationIsMutable() {
            if ((this.bitField0_ & 131072) != 131072) {
                this.getterAnnotation_ = new ArrayList(this.getterAnnotation_);
                this.bitField0_ |= 131072;
            }
        }

        private void ensureSetterAnnotationIsMutable() {
            if ((this.bitField0_ & 262144) != 262144) {
                this.setterAnnotation_ = new ArrayList(this.setterAnnotation_);
                this.bitField0_ |= 262144;
            }
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 16384) != 16384) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 16384;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Property build() {
            ProtoBuf$Property protoBuf$PropertyBuildPartial = buildPartial();
            if (protoBuf$PropertyBuildPartial.isInitialized()) {
                return protoBuf$PropertyBuildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(protoBuf$PropertyBuildPartial);
        }

        public ProtoBuf$Property buildPartial() {
            ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(this);
            int i = this.bitField0_;
            int i2 = (i & 1) != 1 ? 0 : 1;
            protoBuf$Property.flags_ = this.flags_;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            protoBuf$Property.oldFlags_ = this.oldFlags_;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            protoBuf$Property.name_ = this.name_;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            protoBuf$Property.returnType_ = this.returnType_;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            protoBuf$Property.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Property.typeParameter_ = this.typeParameter_;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            protoBuf$Property.receiverType_ = this.receiverType_;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            protoBuf$Property.receiverTypeId_ = this.receiverTypeId_;
            if ((this.bitField0_ & 256) == 256) {
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            }
            protoBuf$Property.contextReceiverType_ = this.contextReceiverType_;
            if ((this.bitField0_ & 512) == 512) {
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -513;
            }
            protoBuf$Property.contextReceiverTypeId_ = this.contextReceiverTypeId_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.contextParameter_ = Collections.unmodifiableList(this.contextParameter_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Property.contextParameter_ = this.contextParameter_;
            if ((i & 2048) == 2048) {
                i2 |= 128;
            }
            protoBuf$Property.setterValueParameter_ = this.setterValueParameter_;
            if ((i & 4096) == 4096) {
                i2 |= 256;
            }
            protoBuf$Property.getterFlags_ = this.getterFlags_;
            if ((i & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 8192) {
                i2 |= 512;
            }
            protoBuf$Property.setterFlags_ = this.setterFlags_;
            if ((this.bitField0_ & 16384) == 16384) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -16385;
            }
            protoBuf$Property.versionRequirement_ = this.versionRequirement_;
            if ((this.bitField0_ & 32768) == 32768) {
                this.compilerPluginData_ = Collections.unmodifiableList(this.compilerPluginData_);
                this.bitField0_ &= -32769;
            }
            protoBuf$Property.compilerPluginData_ = this.compilerPluginData_;
            if ((this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -65537;
            }
            protoBuf$Property.annotation_ = this.annotation_;
            if ((this.bitField0_ & 131072) == 131072) {
                this.getterAnnotation_ = Collections.unmodifiableList(this.getterAnnotation_);
                this.bitField0_ &= -131073;
            }
            protoBuf$Property.getterAnnotation_ = this.getterAnnotation_;
            if ((this.bitField0_ & 262144) == 262144) {
                this.setterAnnotation_ = Collections.unmodifiableList(this.setterAnnotation_);
                this.bitField0_ &= -262145;
            }
            protoBuf$Property.setterAnnotation_ = this.setterAnnotation_;
            if ((this.bitField0_ & 524288) == 524288) {
                this.extensionReceiverAnnotation_ = Collections.unmodifiableList(this.extensionReceiverAnnotation_);
                this.bitField0_ &= -524289;
            }
            protoBuf$Property.extensionReceiverAnnotation_ = this.extensionReceiverAnnotation_;
            if ((this.bitField0_ & 1048576) == 1048576) {
                this.backingFieldAnnotation_ = Collections.unmodifiableList(this.backingFieldAnnotation_);
                this.bitField0_ &= -1048577;
            }
            protoBuf$Property.backingFieldAnnotation_ = this.backingFieldAnnotation_;
            if ((this.bitField0_ & 2097152) == 2097152) {
                this.delegateFieldAnnotation_ = Collections.unmodifiableList(this.delegateFieldAnnotation_);
                this.bitField0_ &= -2097153;
            }
            protoBuf$Property.delegateFieldAnnotation_ = this.delegateFieldAnnotation_;
            if ((4194304 & i) == 4194304) {
                i2 |= 1024;
            }
            protoBuf$Property.getterContract_ = this.getterContract_;
            if ((i & 8388608) == 8388608) {
                i2 |= 2048;
            }
            protoBuf$Property.setterContract_ = this.setterContract_;
            protoBuf$Property.bitField0_ = i2;
            return protoBuf$Property;
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Property protoBuf$Property) {
            if (protoBuf$Property == ProtoBuf$Property.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Property.hasFlags()) {
                setFlags(protoBuf$Property.getFlags());
            }
            if (protoBuf$Property.hasOldFlags()) {
                setOldFlags(protoBuf$Property.getOldFlags());
            }
            if (protoBuf$Property.hasName()) {
                setName(protoBuf$Property.getName());
            }
            if (protoBuf$Property.hasReturnType()) {
                mergeReturnType(protoBuf$Property.getReturnType());
            }
            if (protoBuf$Property.hasReturnTypeId()) {
                setReturnTypeId(protoBuf$Property.getReturnTypeId());
            }
            if (!protoBuf$Property.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Property.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Property.typeParameter_);
                }
            }
            if (protoBuf$Property.hasReceiverType()) {
                mergeReceiverType(protoBuf$Property.getReceiverType());
            }
            if (protoBuf$Property.hasReceiverTypeId()) {
                setReceiverTypeId(protoBuf$Property.getReceiverTypeId());
            }
            if (!protoBuf$Property.contextReceiverType_.isEmpty()) {
                if (this.contextReceiverType_.isEmpty()) {
                    this.contextReceiverType_ = protoBuf$Property.contextReceiverType_;
                    this.bitField0_ &= -257;
                } else {
                    ensureContextReceiverTypeIsMutable();
                    this.contextReceiverType_.addAll(protoBuf$Property.contextReceiverType_);
                }
            }
            if (!protoBuf$Property.contextReceiverTypeId_.isEmpty()) {
                if (this.contextReceiverTypeId_.isEmpty()) {
                    this.contextReceiverTypeId_ = protoBuf$Property.contextReceiverTypeId_;
                    this.bitField0_ &= -513;
                } else {
                    ensureContextReceiverTypeIdIsMutable();
                    this.contextReceiverTypeId_.addAll(protoBuf$Property.contextReceiverTypeId_);
                }
            }
            if (!protoBuf$Property.contextParameter_.isEmpty()) {
                if (this.contextParameter_.isEmpty()) {
                    this.contextParameter_ = protoBuf$Property.contextParameter_;
                    this.bitField0_ &= -1025;
                } else {
                    ensureContextParameterIsMutable();
                    this.contextParameter_.addAll(protoBuf$Property.contextParameter_);
                }
            }
            if (protoBuf$Property.hasSetterValueParameter()) {
                mergeSetterValueParameter(protoBuf$Property.getSetterValueParameter());
            }
            if (protoBuf$Property.hasGetterFlags()) {
                setGetterFlags(protoBuf$Property.getGetterFlags());
            }
            if (protoBuf$Property.hasSetterFlags()) {
                setSetterFlags(protoBuf$Property.getSetterFlags());
            }
            if (!protoBuf$Property.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Property.versionRequirement_;
                    this.bitField0_ &= -16385;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Property.versionRequirement_);
                }
            }
            if (!protoBuf$Property.compilerPluginData_.isEmpty()) {
                if (this.compilerPluginData_.isEmpty()) {
                    this.compilerPluginData_ = protoBuf$Property.compilerPluginData_;
                    this.bitField0_ &= -32769;
                } else {
                    ensureCompilerPluginDataIsMutable();
                    this.compilerPluginData_.addAll(protoBuf$Property.compilerPluginData_);
                }
            }
            if (!protoBuf$Property.annotation_.isEmpty()) {
                if (this.annotation_.isEmpty()) {
                    this.annotation_ = protoBuf$Property.annotation_;
                    this.bitField0_ &= -65537;
                } else {
                    ensureAnnotationIsMutable();
                    this.annotation_.addAll(protoBuf$Property.annotation_);
                }
            }
            if (!protoBuf$Property.getterAnnotation_.isEmpty()) {
                if (this.getterAnnotation_.isEmpty()) {
                    this.getterAnnotation_ = protoBuf$Property.getterAnnotation_;
                    this.bitField0_ &= -131073;
                } else {
                    ensureGetterAnnotationIsMutable();
                    this.getterAnnotation_.addAll(protoBuf$Property.getterAnnotation_);
                }
            }
            if (!protoBuf$Property.setterAnnotation_.isEmpty()) {
                if (this.setterAnnotation_.isEmpty()) {
                    this.setterAnnotation_ = protoBuf$Property.setterAnnotation_;
                    this.bitField0_ &= -262145;
                } else {
                    ensureSetterAnnotationIsMutable();
                    this.setterAnnotation_.addAll(protoBuf$Property.setterAnnotation_);
                }
            }
            if (!protoBuf$Property.extensionReceiverAnnotation_.isEmpty()) {
                if (this.extensionReceiverAnnotation_.isEmpty()) {
                    this.extensionReceiverAnnotation_ = protoBuf$Property.extensionReceiverAnnotation_;
                    this.bitField0_ &= -524289;
                } else {
                    ensureExtensionReceiverAnnotationIsMutable();
                    this.extensionReceiverAnnotation_.addAll(protoBuf$Property.extensionReceiverAnnotation_);
                }
            }
            if (!protoBuf$Property.backingFieldAnnotation_.isEmpty()) {
                if (this.backingFieldAnnotation_.isEmpty()) {
                    this.backingFieldAnnotation_ = protoBuf$Property.backingFieldAnnotation_;
                    this.bitField0_ &= -1048577;
                } else {
                    ensureBackingFieldAnnotationIsMutable();
                    this.backingFieldAnnotation_.addAll(protoBuf$Property.backingFieldAnnotation_);
                }
            }
            if (!protoBuf$Property.delegateFieldAnnotation_.isEmpty()) {
                if (this.delegateFieldAnnotation_.isEmpty()) {
                    this.delegateFieldAnnotation_ = protoBuf$Property.delegateFieldAnnotation_;
                    this.bitField0_ &= -2097153;
                } else {
                    ensureDelegateFieldAnnotationIsMutable();
                    this.delegateFieldAnnotation_.addAll(protoBuf$Property.delegateFieldAnnotation_);
                }
            }
            if (protoBuf$Property.hasGetterContract()) {
                mergeGetterContract(protoBuf$Property.getGetterContract());
            }
            if (protoBuf$Property.hasSetterContract()) {
                mergeSetterContract(protoBuf$Property.getSetterContract());
            }
            mergeExtensionFields(protoBuf$Property);
            setUnknownFields(getUnknownFields().concat(protoBuf$Property.unknownFields));
            return this;
        }

        public Builder mergeGetterContract(ProtoBuf$Contract protoBuf$Contract) {
            if ((this.bitField0_ & 4194304) != 4194304 || this.getterContract_ == ProtoBuf$Contract.getDefaultInstance()) {
                this.getterContract_ = protoBuf$Contract;
            } else {
                this.getterContract_ = ProtoBuf$Contract.newBuilder(this.getterContract_).mergeFrom(protoBuf$Contract).buildPartial();
            }
            this.bitField0_ |= 4194304;
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

        public Builder mergeSetterContract(ProtoBuf$Contract protoBuf$Contract) {
            if ((this.bitField0_ & 8388608) != 8388608 || this.setterContract_ == ProtoBuf$Contract.getDefaultInstance()) {
                this.setterContract_ = protoBuf$Contract;
            } else {
                this.setterContract_ = ProtoBuf$Contract.newBuilder(this.setterContract_).mergeFrom(protoBuf$Contract).buildPartial();
            }
            this.bitField0_ |= 8388608;
            return this;
        }

        public Builder mergeSetterValueParameter(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if ((this.bitField0_ & 2048) != 2048 || this.setterValueParameter_ == ProtoBuf$ValueParameter.getDefaultInstance()) {
                this.setterValueParameter_ = protoBuf$ValueParameter;
            } else {
                this.setterValueParameter_ = ProtoBuf$ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(protoBuf$ValueParameter).buildPartial();
            }
            this.bitField0_ |= 2048;
            return this;
        }

        public Builder setFlags(int i) {
            this.bitField0_ |= 1;
            this.flags_ = i;
            return this;
        }

        public Builder setGetterFlags(int i) {
            this.bitField0_ |= 4096;
            this.getterFlags_ = i;
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

        public Builder setSetterFlags(int i) {
            this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            this.setterFlags_ = i;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            ProtoBuf$Property protoBuf$Property = null;
            try {
                try {
                    ProtoBuf$Property partialFrom = ProtoBuf$Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    ProtoBuf$Property protoBuf$Property2 = (ProtoBuf$Property) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Property = protoBuf$Property2;
                        if (protoBuf$Property != null) {
                            mergeFrom(protoBuf$Property);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Property != null) {
                }
                throw th;
            }
        }
    }

    private ProtoBuf$Property(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Property, ?> extendableBuilder) {
        super(extendableBuilder);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Property(boolean z) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }
}
