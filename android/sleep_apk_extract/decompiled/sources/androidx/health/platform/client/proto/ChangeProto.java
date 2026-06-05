package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ChangeProto {

    /* JADX INFO: renamed from: androidx.health.platform.client.proto.ChangeProto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public interface ChangesEventOrBuilder extends MessageLiteOrBuilder {
        DataChange getChanges(int i);

        int getChangesCount();

        List<DataChange> getChangesList();

        String getNextChangesToken();

        ByteString getNextChangesTokenBytes();

        boolean hasNextChangesToken();
    }

    public interface DataChangeOrBuilder extends MessageLiteOrBuilder {
        DataChange.ChangeCase getChangeCase();

        String getDeleteUid();

        ByteString getDeleteUidBytes();

        DataProto.DataPoint getUpsertDataPoint();

        boolean hasDeleteUid();

        boolean hasUpsertDataPoint();
    }

    private ChangeProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    public static final class ChangesEvent extends GeneratedMessageLite<ChangesEvent, Builder> implements ChangesEventOrBuilder {
        public static final int CHANGES_FIELD_NUMBER = 2;
        private static final ChangesEvent DEFAULT_INSTANCE;
        public static final int NEXT_CHANGES_TOKEN_FIELD_NUMBER = 1;
        private static volatile Parser<ChangesEvent> PARSER;
        private int bitField0_;
        private String nextChangesToken_ = "";
        private Internal.ProtobufList<DataChange> changes_ = GeneratedMessageLite.emptyProtobufList();

        static {
            ChangesEvent changesEvent = new ChangesEvent();
            DEFAULT_INSTANCE = changesEvent;
            GeneratedMessageLite.registerDefaultInstance(ChangesEvent.class, changesEvent);
        }

        private ChangesEvent() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChanges(Iterable<? extends DataChange> iterable) {
            ensureChangesIsMutable();
            AbstractMessageLite.addAll(iterable, this.changes_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(DataChange dataChange) {
            dataChange.getClass();
            ensureChangesIsMutable();
            this.changes_.add(dataChange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChanges() {
            this.changes_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNextChangesToken() {
            this.bitField0_ &= -2;
            this.nextChangesToken_ = getDefaultInstance().getNextChangesToken();
        }

        private void ensureChangesIsMutable() {
            Internal.ProtobufList<DataChange> protobufList = this.changes_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.changes_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ChangesEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ChangesEvent parseDelimitedFrom(InputStream inputStream) {
            return (ChangesEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChangesEvent parseFrom(ByteBuffer byteBuffer) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ChangesEvent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeChanges(int i) {
            ensureChangesIsMutable();
            this.changes_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanges(int i, DataChange dataChange) {
            dataChange.getClass();
            ensureChangesIsMutable();
            this.changes_.set(i, dataChange);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesToken(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.nextChangesToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesTokenBytes(ByteString byteString) {
            this.nextChangesToken_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ChangesEvent();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"bitField0_", "nextChangesToken_", "changes_", DataChange.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ChangesEvent> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ChangesEvent.class) {
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

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public DataChange getChanges(int i) {
            return this.changes_.get(i);
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public int getChangesCount() {
            return this.changes_.size();
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public List<DataChange> getChangesList() {
            return this.changes_;
        }

        public DataChangeOrBuilder getChangesOrBuilder(int i) {
            return this.changes_.get(i);
        }

        public List<? extends DataChangeOrBuilder> getChangesOrBuilderList() {
            return this.changes_;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public String getNextChangesToken() {
            return this.nextChangesToken_;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public ByteString getNextChangesTokenBytes() {
            return ByteString.copyFromUtf8(this.nextChangesToken_);
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public boolean hasNextChangesToken() {
            return (this.bitField0_ & 1) != 0;
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ChangesEvent, Builder> implements ChangesEventOrBuilder {
            private Builder() {
                super(ChangesEvent.DEFAULT_INSTANCE);
            }

            public Builder addAllChanges(Iterable<? extends DataChange> iterable) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addAllChanges(iterable);
                return this;
            }

            public Builder addChanges(DataChange.Builder builder) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(builder.build());
                return this;
            }

            public Builder clearChanges() {
                copyOnWrite();
                ((ChangesEvent) this.instance).clearChanges();
                return this;
            }

            public Builder clearNextChangesToken() {
                copyOnWrite();
                ((ChangesEvent) this.instance).clearNextChangesToken();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public DataChange getChanges(int i) {
                return ((ChangesEvent) this.instance).getChanges(i);
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public int getChangesCount() {
                return ((ChangesEvent) this.instance).getChangesCount();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public List<DataChange> getChangesList() {
                return Collections.unmodifiableList(((ChangesEvent) this.instance).getChangesList());
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public String getNextChangesToken() {
                return ((ChangesEvent) this.instance).getNextChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public ByteString getNextChangesTokenBytes() {
                return ((ChangesEvent) this.instance).getNextChangesTokenBytes();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public boolean hasNextChangesToken() {
                return ((ChangesEvent) this.instance).hasNextChangesToken();
            }

            public Builder removeChanges(int i) {
                copyOnWrite();
                ((ChangesEvent) this.instance).removeChanges(i);
                return this;
            }

            public Builder setChanges(int i, DataChange.Builder builder) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setChanges(i, builder.build());
                return this;
            }

            public Builder setNextChangesToken(String str) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setNextChangesToken(str);
                return this;
            }

            public Builder setNextChangesTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setNextChangesTokenBytes(byteString);
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addChanges(int i, DataChange dataChange) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(i, dataChange);
                return this;
            }

            public Builder setChanges(int i, DataChange dataChange) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setChanges(i, dataChange);
                return this;
            }

            public Builder addChanges(DataChange dataChange) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(dataChange);
                return this;
            }

            public Builder addChanges(int i, DataChange.Builder builder) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(i, builder.build());
                return this;
            }
        }

        public static Builder newBuilder(ChangesEvent changesEvent) {
            return DEFAULT_INSTANCE.createBuilder(changesEvent);
        }

        public static ChangesEvent parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ChangesEvent) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ChangesEvent parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ChangesEvent parseFrom(ByteString byteString) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ChangesEvent parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(int i, DataChange dataChange) {
            dataChange.getClass();
            ensureChangesIsMutable();
            this.changes_.add(i, dataChange);
        }

        public static ChangesEvent parseFrom(byte[] bArr) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ChangesEvent parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ChangesEvent parseFrom(InputStream inputStream) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ChangesEvent parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ChangesEvent parseFrom(CodedInputStream codedInputStream) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ChangesEvent parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public static final class DataChange extends GeneratedMessageLite<DataChange, Builder> implements DataChangeOrBuilder {
        private static final DataChange DEFAULT_INSTANCE;
        public static final int DELETE_UID_FIELD_NUMBER = 2;
        private static volatile Parser<DataChange> PARSER = null;
        public static final int UPSERT_DATA_POINT_FIELD_NUMBER = 1;
        private int changeCase_ = 0;
        private Object change_;

        static {
            DataChange dataChange = new DataChange();
            DEFAULT_INSTANCE = dataChange;
            GeneratedMessageLite.registerDefaultInstance(DataChange.class, dataChange);
        }

        private DataChange() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChange() {
            this.changeCase_ = 0;
            this.change_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeleteUid() {
            if (this.changeCase_ == 2) {
                this.changeCase_ = 0;
                this.change_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpsertDataPoint() {
            if (this.changeCase_ == 1) {
                this.changeCase_ = 0;
                this.change_ = null;
            }
        }

        public static DataChange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUpsertDataPoint(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            if (this.changeCase_ != 1 || this.change_ == DataProto.DataPoint.getDefaultInstance()) {
                this.change_ = dataPoint;
            } else {
                this.change_ = DataProto.DataPoint.newBuilder((DataProto.DataPoint) this.change_).mergeFrom(dataPoint).buildPartial();
            }
            this.changeCase_ = 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static DataChange parseDelimitedFrom(InputStream inputStream) {
            return (DataChange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataChange parseFrom(ByteBuffer byteBuffer) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<DataChange> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeleteUid(String str) {
            str.getClass();
            this.changeCase_ = 2;
            this.change_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeleteUidBytes(ByteString byteString) {
            this.change_ = byteString.toStringUtf8();
            this.changeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpsertDataPoint(DataProto.DataPoint dataPoint) {
            dataPoint.getClass();
            this.change_ = dataPoint;
            this.changeCase_ = 1;
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new DataChange();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002;\u0000", new Object[]{"change_", "changeCase_", DataProto.DataPoint.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DataChange> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DataChange.class) {
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

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public ChangeCase getChangeCase() {
            return ChangeCase.forNumber(this.changeCase_);
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public String getDeleteUid() {
            return this.changeCase_ == 2 ? (String) this.change_ : "";
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public ByteString getDeleteUidBytes() {
            return ByteString.copyFromUtf8(this.changeCase_ == 2 ? (String) this.change_ : "");
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public DataProto.DataPoint getUpsertDataPoint() {
            return this.changeCase_ == 1 ? (DataProto.DataPoint) this.change_ : DataProto.DataPoint.getDefaultInstance();
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public boolean hasDeleteUid() {
            return this.changeCase_ == 2;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public boolean hasUpsertDataPoint() {
            return this.changeCase_ == 1;
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataChange, Builder> implements DataChangeOrBuilder {
            private Builder() {
                super(DataChange.DEFAULT_INSTANCE);
            }

            public Builder clearChange() {
                copyOnWrite();
                ((DataChange) this.instance).clearChange();
                return this;
            }

            public Builder clearDeleteUid() {
                copyOnWrite();
                ((DataChange) this.instance).clearDeleteUid();
                return this;
            }

            public Builder clearUpsertDataPoint() {
                copyOnWrite();
                ((DataChange) this.instance).clearUpsertDataPoint();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public ChangeCase getChangeCase() {
                return ((DataChange) this.instance).getChangeCase();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public String getDeleteUid() {
                return ((DataChange) this.instance).getDeleteUid();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public ByteString getDeleteUidBytes() {
                return ((DataChange) this.instance).getDeleteUidBytes();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public DataProto.DataPoint getUpsertDataPoint() {
                return ((DataChange) this.instance).getUpsertDataPoint();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public boolean hasDeleteUid() {
                return ((DataChange) this.instance).hasDeleteUid();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public boolean hasUpsertDataPoint() {
                return ((DataChange) this.instance).hasUpsertDataPoint();
            }

            public Builder mergeUpsertDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((DataChange) this.instance).mergeUpsertDataPoint(dataPoint);
                return this;
            }

            public Builder setDeleteUid(String str) {
                copyOnWrite();
                ((DataChange) this.instance).setDeleteUid(str);
                return this;
            }

            public Builder setDeleteUidBytes(ByteString byteString) {
                copyOnWrite();
                ((DataChange) this.instance).setDeleteUidBytes(byteString);
                return this;
            }

            public Builder setUpsertDataPoint(DataProto.DataPoint.Builder builder) {
                copyOnWrite();
                ((DataChange) this.instance).setUpsertDataPoint(builder.build());
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder setUpsertDataPoint(DataProto.DataPoint dataPoint) {
                copyOnWrite();
                ((DataChange) this.instance).setUpsertDataPoint(dataPoint);
                return this;
            }
        }

        public enum ChangeCase {
            UPSERT_DATA_POINT(1),
            DELETE_UID(2),
            CHANGE_NOT_SET(0);

            private final int value;

            ChangeCase(int i) {
                this.value = i;
            }

            public static ChangeCase forNumber(int i) {
                if (i == 0) {
                    return CHANGE_NOT_SET;
                }
                if (i == 1) {
                    return UPSERT_DATA_POINT;
                }
                if (i != 2) {
                    return null;
                }
                return DELETE_UID;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ChangeCase valueOf(int i) {
                return forNumber(i);
            }
        }

        public static Builder newBuilder(DataChange dataChange) {
            return DEFAULT_INSTANCE.createBuilder(dataChange);
        }

        public static DataChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DataChange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static DataChange parseFrom(ByteString byteString) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static DataChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static DataChange parseFrom(byte[] bArr) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static DataChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static DataChange parseFrom(InputStream inputStream) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static DataChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static DataChange parseFrom(CodedInputStream codedInputStream) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static DataChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }
}
