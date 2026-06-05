package com.google.home.matter.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001CJ-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\bH&¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0002*\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0014\u001a\u00020\u00132\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0010j\u0002`\u00110\u000fH&¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0017\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001eR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001eR\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u001eR\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020.0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001eR\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002010\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001eR\u001a\u00106\u001a\b\u0012\u0004\u0012\u0002040\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001eR\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002070\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u001eR\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020:0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u001eR\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020=0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u001eR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020@0\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006DÀ\u0006\u0001"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "", "T", "Lcom/google/home/matter/serialization/BitmapAdapter;", "adapter", "Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "bitmap", "(Lcom/google/home/matter/serialization/BitmapAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lcom/google/home/matter/serialization/StructAdapter;", "struct", "(Lcom/google/home/matter/serialization/StructAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "Lcom/google/home/matter/serialization/ClusterEnum;", "Lcom/google/home/matter/serialization/EnumAdapter;", "enum", "(Lcom/google/home/matter/serialization/EnumAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tags", "", "wrapPayload", "(Ljava/util/List;)V", SDKConstants.PARAM_VALUE, "write", "(Lcom/google/home/matter/serialization/StructAdapter;Ljava/lang/Object;)V", "", "getStrictOperationValidation", "()Z", "strictOperationValidation", "getUint", "()Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "uint", "Lkotlin/ULong;", "getUlong", "ulong", "", "getInt", "int", "", "getLong", "long", "getBoolean", "boolean", "", "getFloat", "float", "", "getDouble", "double", "", "getString", "string", "Lkotlin/UShort;", "getUshort", "ushort", "", "getShort", "short", "", "getByte", "byte", "Lkotlin/UByte;", "getUbyte", "ubyte", "", "getBytearray", "bytearray", "FieldWriter", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ClusterPayloadWriter {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J%\u0010\n\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\b\u0010\tJ-\u0010\n\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u000bH&¢\u0006\u0004\b\b\u0010\fJ+\u0010\u0010\u001a\u00020\u00072\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\u0011*\u00020\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "", "T", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tag", SDKConstants.PARAM_VALUE, "", "write-qim9Vi0", "(ILjava/lang/Object;)V", "write", "Lcom/google/home/matter/serialization/OptionalValue;", "(ILcom/google/home/matter/serialization/OptionalValue;)V", "", "writeList-qim9Vi0", "(ILjava/util/List;)V", "writeList", "NEWTYPE", "Lcom/google/home/matter/serialization/FieldAdapter;", "adapter", "adapt", "(Lcom/google/home/matter/serialization/FieldAdapter;)Lcom/google/home/matter/serialization/ClusterPayloadWriter$FieldWriter;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface FieldWriter<T> {
        <NEWTYPE> FieldWriter<NEWTYPE> adapt(FieldAdapter<T, NEWTYPE> adapter);

        /* JADX INFO: renamed from: write-qim9Vi0, reason: not valid java name */
        void mo553writeqim9Vi0(int tag, OptionalValue<? extends T> value);

        /* JADX INFO: renamed from: write-qim9Vi0, reason: not valid java name */
        void mo554writeqim9Vi0(int tag, T value);

        /* JADX INFO: renamed from: writeList-qim9Vi0, reason: not valid java name */
        void mo555writeListqim9Vi0(int tag, List<? extends T> value);
    }

    <T> FieldWriter<T> bitmap(BitmapAdapter<T> adapter);

    /* JADX INFO: renamed from: enum, reason: not valid java name */
    default <T extends ClusterEnum> FieldWriter<T> m552enum(EnumAdapter<T> adapter) {
        adapter.getClass();
        return (FieldWriter<T>) getUlong().adapt(adapter);
    }

    FieldWriter<Boolean> getBoolean();

    FieldWriter<Byte> getByte();

    FieldWriter<byte[]> getBytearray();

    FieldWriter<Double> getDouble();

    FieldWriter<Float> getFloat();

    FieldWriter<Integer> getInt();

    FieldWriter<Long> getLong();

    FieldWriter<Short> getShort();

    boolean getStrictOperationValidation();

    FieldWriter<String> getString();

    FieldWriter<UByte> getUbyte();

    FieldWriter<UInt> getUint();

    FieldWriter<ULong> getUlong();

    FieldWriter<UShort> getUshort();

    <T> FieldWriter<T> struct(StructAdapter<T> adapter);

    void wrapPayload(List<UInt> tags);

    <T> void write(StructAdapter<T> adapter, T value);
}
