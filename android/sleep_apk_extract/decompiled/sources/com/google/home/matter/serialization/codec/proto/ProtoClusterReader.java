package com.google.home.matter.serialization.codec.proto;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.OptionalValue;
import com.google.home.matter.serialization.SerializedPayload;
import com.google.home.matter.serialization.StructAdapter;
import com.google.home.matter.serialization.TagIdKt;
import com.google.home.matter.serialization.codec.proto.ProtoFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJQ\u0010\u0014\u001a\u00020\u00132\u001e\u0010\u000e\u001a\u001a\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\t2\u0018\u0010\u0010\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001a\u001a\u00020\u00132\u0018\u0010\u0010\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\n\u0010\u0016\u001a\u00060\nj\u0002`\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\u001c\u001a\u00020\u00132\u0018\u0010\u0010\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\n\u0010\u0016\u001a\u00060\nj\u0002`\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001b\u0010\u0019JA\u0010\u001d\u001a\u0014\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t2\u001e\u0010\u000e\u001a\u001a\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJA\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0 2\u0006\u0010\u001f\u001a\u00020\u00112\u001e\u0010\u000e\u001a\u001a\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\tH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J#\u0010)\u001a\u00028\u0000\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b)\u0010*J/\u0010,\u001a\u00020+2\u001e\u0010\u000e\u001a\u001a\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\tH\u0016¢\u0006\u0004\b,\u0010-J!\u00100\u001a\u00020\u00132\u0010\u0010/\u001a\f\u0012\b\u0012\u00060\nj\u0002`\u000b0.H\u0016¢\u0006\u0004\b0\u00101J/\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u0010'*\u00020\u00062\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\u0006\u00102\u001a\u00020\u0000¢\u0006\u0004\b3\u00104R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u00105\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/google/home/matter/serialization/codec/proto/ProtoClusterReader;", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "", "strictOperationValidation", "<init>", "(Z)V", "Lcom/google/home/matter/serialization/codec/proto/CodedInputStream;", "input", "()Lcom/google/home/matter/serialization/codec/proto/CodedInputStream;", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "Lcom/google/home/matter/serialization/StructAdapter;", "", "adapters", "", "map", "", "protoFieldNumber", "", "readVendorContents", "(Ljava/util/Map;Ljava/util/Map;I)V", "id", SDKConstants.PARAM_VALUE, "addListValue-OsBMiQA", "(Ljava/util/Map;ILjava/lang/Object;)V", "addListValue", "addSingleValue-OsBMiQA", "addSingleValue", "readStructContents", "(Ljava/util/Map;)Ljava/util/Map;", "fieldNumber", "Lcom/google/home/matter/serialization/OptionalValue;", "getValue", "(ILjava/util/Map;)Lcom/google/home/matter/serialization/OptionalValue;", "Lcom/google/home/matter/serialization/SerializedPayload;", "payload", "init", "(Lcom/google/home/matter/serialization/SerializedPayload;)V", "T", "adapter", "read", "(Lcom/google/home/matter/serialization/StructAdapter;)Ljava/lang/Object;", "Lcom/google/home/matter/serialization/ClusterPayload;", "readPayload", "(Ljava/util/Map;)Lcom/google/home/matter/serialization/ClusterPayload;", "", "tags", "unwrapPayload", "(Ljava/util/List;)V", "reader", "readStruct", "(Lcom/google/home/matter/serialization/codec/proto/CodedInputStream;Lcom/google/home/matter/serialization/StructAdapter;Lcom/google/home/matter/serialization/codec/proto/ProtoClusterReader;)Ljava/lang/Object;", "Z", "getStrictOperationValidation", "()Z", "codedInputStream", "Lcom/google/home/matter/serialization/codec/proto/CodedInputStream;", "java.com.google.home.matter.serialization.codec.proto_proto-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProtoClusterReader implements ClusterPayloadReader {
    private CodedInputStream codedInputStream = CodedInputStream.INSTANCE.newInstance(new byte[0]);
    private final boolean strictOperationValidation;

    public ProtoClusterReader(boolean z) {
        this.strictOperationValidation = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addListValue-OsBMiQA, reason: not valid java name */
    public final void m583addListValueOsBMiQA(Map<UInt, Object> map, int id, Object value) {
        Object obj = map.get(UInt.m2388boximpl(id));
        if (value == null) {
            if (obj == null) {
                map.put(UInt.m2388boximpl(id), CollectionsKt.emptyList());
                return;
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$3("List: unexpected previous value for ".concat(String.valueOf(UInt.m2392toStringimpl(id))));
                return;
            }
        }
        if (obj == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(value);
            map.put(UInt.m2388boximpl(id), arrayList);
        } else if (TypeIntrinsics.isMutableList(obj)) {
            TypeIntrinsics.asMutableList(obj).add(value);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("List: unexpected previous value for ".concat(String.valueOf(UInt.m2392toStringimpl(id))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: addSingleValue-OsBMiQA, reason: not valid java name */
    public final void m584addSingleValueOsBMiQA(Map<UInt, Object> map, int id, Object value) {
        if (map.get(UInt.m2388boximpl(id)) == null) {
            map.put(UInt.m2388boximpl(id), value);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Single: unexpected previous value for ".concat(String.valueOf(UInt.m2392toStringimpl(id))));
        }
    }

    private final OptionalValue<? extends Object> getValue(int fieldNumber, Map<UInt, ? extends StructAdapter<? extends Object>> adapters) {
        ProtoFormat protoFormat = ProtoFormat.INSTANCE;
        int iM605getIdFromFieldNumberOGnWXxg = protoFormat.m605getIdFromFieldNumberOGnWXxg(fieldNumber);
        ProtoFormat.Type typeFromFieldNumber = protoFormat.getTypeFromFieldNumber(fieldNumber);
        ProtoFormat.Type.Companion companion = ProtoFormat.Type.INSTANCE;
        switch (typeFromFieldNumber.ordinal()) {
            case 0:
                return OptionalValue.INSTANCE.present(ULong.m2410boximpl(getCodedInputStream().m580readUInt64sVKNKU()));
            case 1:
                return OptionalValue.INSTANCE.present(Long.valueOf(getCodedInputStream().readSInt64()));
            case 2:
                return OptionalValue.INSTANCE.present(Boolean.valueOf(getCodedInputStream().readBool()));
            case 3:
                return OptionalValue.INSTANCE.present(getCodedInputStream().readString());
            case 4:
                return OptionalValue.INSTANCE.present(getCodedInputStream().readByteArray());
            case 5:
                return OptionalValue.INSTANCE.present(readStruct(getCodedInputStream(), adapters.get(UInt.m2388boximpl(iM605getIdFromFieldNumberOGnWXxg)), this));
            case 6:
                return OptionalValue.INSTANCE.present(Float.valueOf(getCodedInputStream().readFloat()));
            case 7:
                return OptionalValue.INSTANCE.present(Double.valueOf(getCodedInputStream().readDouble()));
            case 8:
                return getCodedInputStream().readBool() ? OptionalValue.INSTANCE.presentNull() : OptionalValue.INSTANCE.absent();
            default:
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
        }
    }

    /* JADX INFO: renamed from: input, reason: from getter */
    private final CodedInputStream getCodedInputStream() {
        return this.codedInputStream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<UInt, Object> readStructContents(Map<UInt, ? extends StructAdapter<? extends Object>> adapters) {
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            int tag = getCodedInputStream().readTag();
            if (tag == 0) {
                return linkedHashMap;
            }
            int tagFieldNumber = WireFormat.INSTANCE.getTagFieldNumber(tag);
            ProtoFormat protoFormat = ProtoFormat.INSTANCE;
            if (protoFormat.getIsVendorFromFieldNumber(tagFieldNumber)) {
                readVendorContents(adapters, linkedHashMap, tagFieldNumber);
            } else {
                final int iM605getIdFromFieldNumberOGnWXxg = protoFormat.m605getIdFromFieldNumberOGnWXxg(tagFieldNumber);
                boolean isListFromFieldNumber = protoFormat.getIsListFromFieldNumber(tagFieldNumber);
                boolean isPrimitiveFromFieldNumber = protoFormat.getIsPrimitiveFromFieldNumber(tagFieldNumber);
                boolean isLengthDelimitedFromTagNumber = protoFormat.getIsLengthDelimitedFromTagNumber(tag);
                if (!isListFromFieldNumber) {
                    getValue(tagFieldNumber, adapters).doWhenPresent(new Function1<?, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterReader.readStructContents.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                            ProtoClusterReader.this.m584addSingleValueOsBMiQA(linkedHashMap, iM605getIdFromFieldNumberOGnWXxg, obj);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke2((Object) obj);
                            return Unit.INSTANCE;
                        }
                    });
                } else if (isPrimitiveFromFieldNumber && isLengthDelimitedFromTagNumber) {
                    int iPushLimit = getCodedInputStream().pushLimit(getCodedInputStream().readRawVarint32());
                    while (getCodedInputStream().getBytesUntilLimit() > 0) {
                        getValue(tagFieldNumber, adapters).doWhenPresent(new Function1<?, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterReader.readStructContents.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj) {
                                ProtoClusterReader.this.m583addListValueOsBMiQA(linkedHashMap, iM605getIdFromFieldNumberOGnWXxg, obj);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke2((Object) obj);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    getCodedInputStream().popLimit(iPushLimit);
                } else {
                    getValue(tagFieldNumber, adapters).doWhenPresent(new Function1<?, Unit>() { // from class: com.google.home.matter.serialization.codec.proto.ProtoClusterReader.readStructContents.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Object obj) {
                            ProtoClusterReader.this.m583addListValueOsBMiQA(linkedHashMap, iM605getIdFromFieldNumberOGnWXxg, obj);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                            invoke2((Object) obj);
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        }
    }

    private final void readVendorContents(Map<UInt, ? extends StructAdapter<? extends Object>> adapters, Map<UInt, Object> map, int protoFieldNumber) {
        ProtoFormat protoFormat = ProtoFormat.INSTANCE;
        if (protoFormat.getTypeFromFieldNumber(protoFieldNumber) != ProtoFormat.Type.NULL) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Vendor: type must be null");
            return;
        }
        if (protoFormat.getIsListFromFieldNumber(protoFieldNumber)) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Vendor: list must be false");
            return;
        }
        int iM605getIdFromFieldNumberOGnWXxg = protoFormat.m605getIdFromFieldNumberOGnWXxg(protoFieldNumber);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<UInt, ? extends StructAdapter<? extends Object>> entry : adapters.entrySet()) {
            if (TagIdKt.m569vendorWZ4Q5Ns(entry.getKey().getData()) == iM605getIdFromFieldNumberOGnWXxg) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(UInt.m2388boximpl(TagIdKt.m567idWZ4Q5Ns(((UInt) entry2.getKey()).getData())), entry2.getValue());
        }
        int iPushLimit = getCodedInputStream().pushLimit(getCodedInputStream().readRawVarint32());
        Map<UInt, Object> structContents = readStructContents(linkedHashMap2);
        getCodedInputStream().checkLastTagWas(0);
        if (getCodedInputStream().getBytesUntilLimit() != 0) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Vendor: unexpected bytes");
            return;
        }
        getCodedInputStream().popLimit(iPushLimit);
        for (Map.Entry<UInt, Object> entry3 : structContents.entrySet()) {
            int iM568setVendorfeOb9K0 = TagIdKt.m568setVendorfeOb9K0(entry3.getKey().getData(), iM605getIdFromFieldNumberOGnWXxg);
            if (map.get(UInt.m2388boximpl(iM568setVendorfeOb9K0)) != null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Vendor: unexpected previous value for ".concat(String.valueOf(UInt.m2392toStringimpl(iM568setVendorfeOb9K0))));
                return;
            }
            map.put(UInt.m2388boximpl(iM568setVendorfeOb9K0), entry3.getValue());
        }
    }

    public void init(SerializedPayload payload) {
        payload.getClass();
        if (payload instanceof ProtoPayload) {
            this.codedInputStream = CodedInputStream.INSTANCE.newInstance(((ProtoPayload) payload).getPayload());
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Payload is not a ProtoPayload");
        }
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadReader
    public <T> T read(StructAdapter<T> adapter) {
        adapter.getClass();
        return adapter.read(this);
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadReader
    public ClusterPayload readPayload(Map<UInt, ? extends StructAdapter<? extends Object>> adapters) {
        adapters.getClass();
        return new ClusterPayload(readStructContents(adapters));
    }

    public final <T> T readStruct(CodedInputStream codedInputStream, StructAdapter<T> structAdapter, ProtoClusterReader protoClusterReader) {
        codedInputStream.getClass();
        protoClusterReader.getClass();
        if (structAdapter == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Expected adapter");
            return null;
        }
        int iPushLimit = protoClusterReader.getCodedInputStream().pushLimit(protoClusterReader.getCodedInputStream().readRawVarint32());
        T t = structAdapter.read(protoClusterReader);
        protoClusterReader.getCodedInputStream().checkLastTagWas(0);
        if (protoClusterReader.getCodedInputStream().getBytesUntilLimit() == 0) {
            protoClusterReader.getCodedInputStream().popLimit(iPushLimit);
            return t;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Unexpected bytes");
        return null;
    }

    @Override // com.google.home.matter.serialization.ClusterPayloadReader
    public void unwrapPayload(List<UInt> tags) {
        tags.getClass();
        CodedInputStream codedInputStreamNewInstance = this.codedInputStream;
        Iterator<UInt> it = tags.iterator();
        while (it.hasNext()) {
            if (ProtoFormat.INSTANCE.m604getContainerIdFromFieldNumberOGnWXxg(codedInputStreamNewInstance.readTag()) != it.next().getData()) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Check failed.");
                return;
            }
            codedInputStreamNewInstance = CodedInputStream.INSTANCE.newInstance(codedInputStreamNewInstance.readByteArray());
        }
        this.codedInputStream = codedInputStreamNewInstance;
    }
}
