package com.google.home.matter.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.FieldAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004VWXYB!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\r\u001a\f\u0012\u0004\u0012\u00028\u00000\fR\u00020\u0000\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0010\u001a\f\u0012\u0004\u0012\u00028\u00000\fR\u00020\u0000\"\b\b\u0000\u0010\t*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\t*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00122\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016JW\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a0\u0012\"\b\b\u0000\u0010\t*\u00020\u0001*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJQ\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0012\"\b\b\u0000\u0010\t*\u00020\u0001*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ_\u0010%\u001a\u00028\u0000\"\b\b\u0000\u0010\t*\u00020\u0001*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010 \u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b#\u0010$Jk\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\b\b\u0000\u0010\t*\u00020\u0001*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010 \u001a\u00020\u00132\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0!2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0002¢\u0006\u0004\b&\u0010'JA\u0010+\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\t*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\n\u0010\u0017\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0004\b)\u0010*R&\u0010\u0005\u001a\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010,R!\u0010.\u001a\f\u0012\u0004\u0012\u00020-0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R!\u00103\u001a\f\u0012\u0004\u0012\u0002020\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\b3\u0010/\u001a\u0004\b4\u00101R!\u00106\u001a\f\u0012\u0004\u0012\u0002050\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\b6\u0010/\u001a\u0004\b7\u00101R!\u00109\u001a\f\u0012\u0004\u0012\u0002080\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u00101R!\u0010<\u001a\f\u0012\u0004\u0012\u00020;0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\b<\u0010/\u001a\u0004\b=\u00101R!\u0010>\u001a\f\u0012\u0004\u0012\u00020\u00130\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\b>\u0010/\u001a\u0004\b?\u00101R!\u0010A\u001a\f\u0012\u0004\u0012\u00020@0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\bA\u0010/\u001a\u0004\bB\u00101R!\u0010C\u001a\f\u0012\u0004\u0012\u00020\u00030\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\bC\u0010/\u001a\u0004\bD\u00101R!\u0010F\u001a\f\u0012\u0004\u0012\u00020E0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\bF\u0010/\u001a\u0004\bG\u00101R!\u0010I\u001a\f\u0012\u0004\u0012\u00020H0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\bI\u0010/\u001a\u0004\bJ\u00101R!\u0010L\u001a\f\u0012\u0004\u0012\u00020K0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\bL\u0010/\u001a\u0004\bM\u00101R!\u0010O\u001a\f\u0012\u0004\u0012\u00020N0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\bO\u0010/\u001a\u0004\bP\u00101R!\u0010R\u001a\f\u0012\u0004\u0012\u00020Q0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\bR\u0010/\u001a\u0004\bS\u00101R!\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020T0\fR\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\bU\u00101¨\u0006Z"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayload;", "", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "payload", "<init>", "(Ljava/util/Map;)V", "Lcom/google/home/matter/serialization/ClusterEnum;", "T", "Lcom/google/home/matter/serialization/EnumAdapter;", "adapter", "Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "enum", "(Lcom/google/home/matter/serialization/EnumAdapter;)Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "bitmap", "(Lcom/google/home/matter/serialization/BitmapAdapter;)Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "Lcom/google/home/matter/serialization/OptionalValue;", "", "fieldName", "notNull", "(Lcom/google/home/matter/serialization/OptionalValue;Ljava/lang/String;)Lcom/google/home/matter/serialization/OptionalValue;", "tag", "Lkotlin/reflect/KClass;", "type", "", "getOptionalList-OsBMiQA", "(Ljava/util/Map;ILkotlin/reflect/KClass;)Lcom/google/home/matter/serialization/OptionalValue;", "getOptionalList", "getOptional-OsBMiQA", "getOptional", "name", "Lkotlin/Function0;", "defaultValue", "getOrThrow-roUYKiI", "(Ljava/util/Map;ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getOrThrow", "getListOrThrow-roUYKiI", "(Ljava/util/Map;ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;)Ljava/util/List;", "getListOrThrow", "getNullOrThrow-OsBMiQA", "(Ljava/util/Map;ILjava/lang/String;)Ljava/lang/Object;", "getNullOrThrow", "Ljava/util/Map;", "Lkotlin/ULong;", "ulong", "Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "getUlong", "()Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "", "long", "getLong", "", "boolean", "getBoolean", "", "float", "getFloat", "", "double", "getDouble", "string", "getString", "", "bytearray", "getBytearray", "uint", "getUint", "Lkotlin/UShort;", "ushort", "getUshort", "Lkotlin/UByte;", "ubyte", "getUbyte", "", "int", "getInt", "", "short", "getShort", "", "byte", "getByte", "Lcom/google/home/matter/serialization/Bitmap;", "getBitmap", "FieldReader", "AdaptedReader", "RawFieldReader", "RawFieldReaderNoDefault", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClusterPayload {
    private final FieldReader<Bitmap> bitmap;
    private final FieldReader<Boolean> boolean;
    private final FieldReader<Byte> byte;
    private final FieldReader<byte[]> bytearray;
    private final FieldReader<Double> double;
    private final FieldReader<Float> float;
    private final FieldReader<Integer> int;
    private final FieldReader<Long> long;
    private final Map<UInt, Object> payload;
    private final FieldReader<Short> short;
    private final FieldReader<String> string;
    private final FieldReader<UByte> ubyte;
    private final FieldReader<UInt> uint;
    private final FieldReader<ULong> ulong;
    private final FieldReader<UShort> ushort;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0017\b\u0082\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\f\u0012\u0004\u0012\u00028\u00010\u0004R\u00020\u0005B=\u0012\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u00000\u0004R\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00130\u00122\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00122\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J#\u0010\u001b\u001a\u00028\u00012\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001d\u001a\u0004\u0018\u00018\u00012\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ)\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR!\u0010\u0006\u001a\f\u0012\u0004\u0012\u00028\u00000\u0004R\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayload$AdaptedReader;", "", "FROM", "TO", "Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "Lcom/google/home/matter/serialization/ClusterPayload;", "field", "Lcom/google/home/matter/serialization/FieldAdapter;", "adapter", "Lkotlin/Function0;", "defaultValueGenerator", "<init>", "(Lcom/google/home/matter/serialization/ClusterPayload;Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;Lcom/google/home/matter/serialization/FieldAdapter;Lkotlin/jvm/functions/Function0;)V", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tag", "", "name", "Lcom/google/home/matter/serialization/OptionalValue;", "", "getOptionalNullableList-qim9Vi0", "(ILjava/lang/String;)Lcom/google/home/matter/serialization/OptionalValue;", "getOptionalNullableList", "getOptionalNullable-qim9Vi0", "getOptionalNullable", "get-qim9Vi0", "(ILjava/lang/String;)Ljava/lang/Object;", "get", "getNullable-qim9Vi0", "getNullable", "getList-qim9Vi0", "(ILjava/lang/String;)Ljava/util/List;", "getList", "Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "getField", "()Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "Lcom/google/home/matter/serialization/FieldAdapter;", "getAdapter", "()Lcom/google/home/matter/serialization/FieldAdapter;", "Lkotlin/jvm/functions/Function0;", "getDefaultValueGenerator", "()Lkotlin/jvm/functions/Function0;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class AdaptedReader<FROM, TO> extends FieldReader<TO> {
        private final FieldAdapter<FROM, TO> adapter;
        private final Function0<TO> defaultValueGenerator;
        private final FieldReader<FROM> field;
        final /* synthetic */ ClusterPayload this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AdaptedReader(ClusterPayload clusterPayload, FieldReader<FROM> fieldReader, FieldAdapter<FROM, TO> fieldAdapter, Function0<? extends TO> function0) {
            super();
            fieldReader.getClass();
            fieldAdapter.getClass();
            function0.getClass();
            this.this$0 = clusterPayload;
            this.field = fieldReader;
            this.adapter = fieldAdapter;
            this.defaultValueGenerator = function0;
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: get-qim9Vi0, reason: not valid java name */
        public TO mo546getqim9Vi0(int tag, String name) throws RequiredFieldException {
            name.getClass();
            FROM fromMo548getNullableqim9Vi0 = this.field.mo548getNullableqim9Vi0(tag, name);
            if (fromMo548getNullableqim9Vi0 != null) {
                return this.adapter.toRuntime(fromMo548getNullableqim9Vi0);
            }
            if (GlobalParserOptions.INSTANCE.getLenient()) {
                return getDefaultValueGenerator().invoke();
            }
            throw new RequiredFieldException(name, null, 2, null);
        }

        public final FieldAdapter<FROM, TO> getAdapter() {
            return this.adapter;
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        public Function0<TO> getDefaultValueGenerator() {
            return this.defaultValueGenerator;
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getList-qim9Vi0, reason: not valid java name */
        public List<TO> mo547getListqim9Vi0(int tag, String name) {
            name.getClass();
            List<FROM> listMo547getListqim9Vi0 = this.field.mo547getListqim9Vi0(tag, name);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listMo547getListqim9Vi0, 10));
            Iterator<T> it = listMo547getListqim9Vi0.iterator();
            while (it.hasNext()) {
                arrayList.add(this.adapter.toRuntime((FROM) it.next()));
            }
            return arrayList;
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getNullable-qim9Vi0, reason: not valid java name */
        public TO mo548getNullableqim9Vi0(int tag, String name) {
            name.getClass();
            FROM fromMo548getNullableqim9Vi0 = this.field.mo548getNullableqim9Vi0(tag, name);
            if (fromMo548getNullableqim9Vi0 != null) {
                return this.adapter.toRuntime(fromMo548getNullableqim9Vi0);
            }
            return null;
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getOptionalNullable-qim9Vi0, reason: not valid java name */
        public OptionalValue<TO> mo549getOptionalNullableqim9Vi0(int tag, String name) {
            name.getClass();
            return (OptionalValue<TO>) this.field.mo549getOptionalNullableqim9Vi0(tag, name).map(new Function1<FROM, TO>(this) { // from class: com.google.home.matter.serialization.ClusterPayload$AdaptedReader$getOptionalNullable$1
                final /* synthetic */ ClusterPayload.AdaptedReader<FROM, TO> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final TO invoke(FROM from) {
                    if (from != null) {
                        return this.this$0.getAdapter().toRuntime(from);
                    }
                    return null;
                }
            });
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getOptionalNullableList-qim9Vi0, reason: not valid java name */
        public OptionalValue<List<TO>> mo550getOptionalNullableListqim9Vi0(int tag, String name) {
            name.getClass();
            return (OptionalValue<List<TO>>) this.field.mo550getOptionalNullableListqim9Vi0(tag, name).map(new Function1<List<? extends FROM>, List<? extends TO>>(this) { // from class: com.google.home.matter.serialization.ClusterPayload$AdaptedReader$getOptionalNullableList$1
                final /* synthetic */ ClusterPayload.AdaptedReader<FROM, TO> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final List<TO> invoke(List<? extends FROM> list) {
                    if (list == null) {
                        return null;
                    }
                    List<? extends FROM> list2 = list;
                    FieldAdapter<FROM, TO> adapter = this.this$0.getAdapter();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(adapter.toRuntime(it.next()));
                    }
                    return arrayList;
                }
            });
        }

        public /* synthetic */ AdaptedReader(ClusterPayload clusterPayload, final FieldReader fieldReader, final FieldAdapter fieldAdapter, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(clusterPayload, fieldReader, fieldAdapter, (i & 4) != 0 ? new Function0<TO>() { // from class: com.google.home.matter.serialization.ClusterPayload.AdaptedReader.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final TO invoke() {
                    TO defaultValue = fieldAdapter.getDefaultValue();
                    return defaultValue == null ? (TO) fieldAdapter.toRuntime(fieldReader.getDefaultValueGenerator().invoke()) : defaultValue;
                }
            } : function0);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b¦\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\t\u001a\f\u0012\u0004\u0012\u00028\u00010\u0000R\u00020\b\"\b\b\u0001\u0010\u0005*\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\u00102\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0013J-\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00102\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0017\u0010\u0013J%\u0010\u001b\u001a\u00028\u00002\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u0004\u0018\u00018\u00002\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u001c\u0010\u001aJ+\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "", "T", "<init>", "(Lcom/google/home/matter/serialization/ClusterPayload;)V", "TO", "Lcom/google/home/matter/serialization/FieldAdapter;", "adapter", "Lcom/google/home/matter/serialization/ClusterPayload;", "adapt", "(Lcom/google/home/matter/serialization/FieldAdapter;)Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tag", "", "name", "Lcom/google/home/matter/serialization/OptionalValue;", "", "getOptionalNullableList-qim9Vi0", "(ILjava/lang/String;)Lcom/google/home/matter/serialization/OptionalValue;", "getOptionalNullableList", "getOptional-qim9Vi0", "getOptional", "getOptionalNullable-qim9Vi0", "getOptionalNullable", "get-qim9Vi0", "(ILjava/lang/String;)Ljava/lang/Object;", "get", "getNullable-qim9Vi0", "getNullable", "getList-qim9Vi0", "(ILjava/lang/String;)Ljava/util/List;", "getList", "Lkotlin/Function0;", "getDefaultValueGenerator", "()Lkotlin/jvm/functions/Function0;", "defaultValueGenerator", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public abstract class FieldReader<T> {
        public FieldReader() {
        }

        public final <TO> FieldReader<TO> adapt(FieldAdapter<T, TO> adapter) {
            adapter.getClass();
            return new AdaptedReader(ClusterPayload.this, this, adapter, null, 4, null);
        }

        /* JADX INFO: renamed from: get-qim9Vi0 */
        public abstract T mo546getqim9Vi0(int tag, String name);

        public abstract Function0<T> getDefaultValueGenerator();

        /* JADX INFO: renamed from: getList-qim9Vi0 */
        public abstract List<T> mo547getListqim9Vi0(int tag, String name);

        /* JADX INFO: renamed from: getNullable-qim9Vi0 */
        public abstract T mo548getNullableqim9Vi0(int tag, String name);

        /* JADX INFO: renamed from: getOptional-qim9Vi0, reason: not valid java name */
        public final OptionalValue<T> m551getOptionalqim9Vi0(int tag, String name) throws RequiredFieldException {
            name.getClass();
            ClusterPayload clusterPayload = ClusterPayload.this;
            OptionalValue<T> optionalValueMo549getOptionalNullableqim9Vi0 = mo549getOptionalNullableqim9Vi0(tag, name);
            clusterPayload.notNull(optionalValueMo549getOptionalNullableqim9Vi0, name);
            return optionalValueMo549getOptionalNullableqim9Vi0;
        }

        /* JADX INFO: renamed from: getOptionalNullable-qim9Vi0 */
        public abstract OptionalValue<T> mo549getOptionalNullableqim9Vi0(int tag, String name);

        /* JADX INFO: renamed from: getOptionalNullableList-qim9Vi0 */
        public abstract OptionalValue<List<T>> mo550getOptionalNullableListqim9Vi0(int tag, String name);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0096\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0012\u0004\u0012\u00028\u00000\u0003R\u00020\u0004B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f0\u000e2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J#\u0010\u0017\u001a\u00028\u00002\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u0004\u0018\u00018\u00002\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0016J)\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayload$RawFieldReaderNoDefault;", "", "T", "Lcom/google/home/matter/serialization/ClusterPayload$FieldReader;", "Lcom/google/home/matter/serialization/ClusterPayload;", "Lkotlin/reflect/KClass;", "type", "<init>", "(Lcom/google/home/matter/serialization/ClusterPayload;Lkotlin/reflect/KClass;)V", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tag", "", "name", "Lcom/google/home/matter/serialization/OptionalValue;", "", "getOptionalNullableList-qim9Vi0", "(ILjava/lang/String;)Lcom/google/home/matter/serialization/OptionalValue;", "getOptionalNullableList", "getOptionalNullable-qim9Vi0", "getOptionalNullable", "get-qim9Vi0", "(ILjava/lang/String;)Ljava/lang/Object;", "get", "getNullable-qim9Vi0", "getNullable", "getList-qim9Vi0", "(ILjava/lang/String;)Ljava/util/List;", "getList", "Lkotlin/reflect/KClass;", "getType", "()Lkotlin/reflect/KClass;", "Lkotlin/Function0;", "getDefaultValueGenerator", "()Lkotlin/jvm/functions/Function0;", "defaultValueGenerator", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public class RawFieldReaderNoDefault<T> extends FieldReader<T> {
        final /* synthetic */ ClusterPayload this$0;
        private final KClass<T> type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RawFieldReaderNoDefault(ClusterPayload clusterPayload, KClass<T> kClass) {
            super();
            kClass.getClass();
            this.this$0 = clusterPayload;
            this.type = kClass;
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: get-qim9Vi0 */
        public T mo546getqim9Vi0(int tag, String name) {
            name.getClass();
            ClusterPayload clusterPayload = this.this$0;
            return (T) clusterPayload.m544getOrThrowroUYKiI(clusterPayload.payload, tag, name, getDefaultValueGenerator(), this.type);
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        public abstract Function0<T> getDefaultValueGenerator();

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getList-qim9Vi0 */
        public List<T> mo547getListqim9Vi0(int tag, String name) {
            name.getClass();
            return this.this$0.m540getListOrThrowroUYKiI(this.this$0.payload, tag, name, ClusterPayload$RawFieldReaderNoDefault$getList$1.INSTANCE, this.type);
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getNullable-qim9Vi0 */
        public T mo548getNullableqim9Vi0(int tag, String name) {
            name.getClass();
            ClusterPayload clusterPayload = this.this$0;
            return (T) clusterPayload.m541getNullOrThrowOsBMiQA(clusterPayload.payload, tag, name);
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getOptionalNullable-qim9Vi0 */
        public OptionalValue<T> mo549getOptionalNullableqim9Vi0(int tag, String name) {
            name.getClass();
            KClass<T> kClass = this.type;
            ClusterPayload clusterPayload = this.this$0;
            return clusterPayload.m542getOptionalOsBMiQA(clusterPayload.payload, tag, kClass);
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.FieldReader
        /* JADX INFO: renamed from: getOptionalNullableList-qim9Vi0 */
        public OptionalValue<List<T>> mo550getOptionalNullableListqim9Vi0(int tag, String name) {
            name.getClass();
            KClass<T> kClass = this.type;
            ClusterPayload clusterPayload = this.this$0;
            return clusterPayload.m543getOptionalListOsBMiQA(clusterPayload.payload, tag, kClass);
        }
    }

    public ClusterPayload(Map<UInt, ? extends Object> map) {
        map.getClass();
        this.payload = map;
        RawFieldReader rawFieldReader = new RawFieldReader(this, ULong.m2410boximpl(0L), (KClass<ULong>) Reflection.getOrCreateKotlinClass(ULong.class));
        this.ulong = rawFieldReader;
        RawFieldReader rawFieldReader2 = new RawFieldReader(this, 0L, (KClass<long>) Reflection.getOrCreateKotlinClass(Long.TYPE));
        this.long = rawFieldReader2;
        this.boolean = new RawFieldReader(this, Boolean.FALSE, (KClass<Boolean>) Reflection.getOrCreateKotlinClass(Boolean.TYPE));
        this.float = new RawFieldReader(this, Float.valueOf(0.0f), (KClass<Float>) Reflection.getOrCreateKotlinClass(Float.TYPE));
        this.double = new RawFieldReader(this, Double.valueOf(0.0d), (KClass<Double>) Reflection.getOrCreateKotlinClass(Double.TYPE));
        this.string = new RawFieldReader(this, "", (KClass<String>) Reflection.getOrCreateKotlinClass(String.class));
        this.bytearray = new RawFieldReader(this, new byte[0], (KClass<byte[]>) Reflection.getOrCreateKotlinClass(byte[].class));
        FieldAdapter.Companion companion = FieldAdapter.INSTANCE;
        this.uint = rawFieldReader.adapt(companion.getULONG_UINT());
        this.ushort = rawFieldReader.adapt(companion.getULONG_USHORT());
        this.ubyte = rawFieldReader.adapt(companion.getULONG_UBYTE());
        this.int = rawFieldReader2.adapt(companion.getLONG_INT());
        this.short = rawFieldReader2.adapt(companion.getLONG_SHORT());
        this.byte = rawFieldReader2.adapt(companion.getLONG_BYTE());
        this.bitmap = rawFieldReader.adapt(Bitmap.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getListOrThrow-roUYKiI, reason: not valid java name */
    public final <T> List<T> m540getListOrThrowroUYKiI(Map<UInt, ? extends Object> map, int i, String str, Function0<? extends List<? extends T>> function0, KClass<T> kClass) throws RequiredFieldException {
        List<T> orNull = m543getOptionalListOsBMiQA(map, i, kClass).getOrNull();
        if (orNull != null) {
            return orNull;
        }
        if (GlobalParserOptions.INSTANCE.getLenient()) {
            return function0.invoke();
        }
        throw new RequiredFieldException(str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getNullOrThrow-OsBMiQA, reason: not valid java name */
    public final <T> T m541getNullOrThrowOsBMiQA(Map<UInt, ? extends Object> map, int i, String str) throws RequiredFieldException {
        if (map.containsKey(UInt.m2388boximpl(i))) {
            return (T) map.get(UInt.m2388boximpl(i));
        }
        if (GlobalParserOptions.INSTANCE.getLenient()) {
            return null;
        }
        throw new RequiredFieldException(str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOptional-OsBMiQA, reason: not valid java name */
    public final <T> OptionalValue<T> m542getOptionalOsBMiQA(Map<UInt, ? extends Object> map, int i, KClass<T> kClass) {
        if (!map.containsKey(UInt.m2388boximpl(i))) {
            return OptionalValue.INSTANCE.absent();
        }
        Object obj = map.get(UInt.m2388boximpl(i));
        return obj == null ? OptionalValue.INSTANCE.ofNullable(null) : Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(obj.getClass()), kClass) ? OptionalValue.INSTANCE.ofNullable(obj) : OptionalValue.INSTANCE.absent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getOptionalList-OsBMiQA, reason: not valid java name */
    public final <T> OptionalValue<List<T>> m543getOptionalListOsBMiQA(Map<UInt, ? extends Object> map, int i, KClass<T> kClass) {
        if (!map.containsKey(UInt.m2388boximpl(i))) {
            return OptionalValue.INSTANCE.absent();
        }
        Object obj = map.get(UInt.m2388boximpl(i));
        if (obj == null) {
            return OptionalValue.INSTANCE.ofNullable(null);
        }
        if (!(obj instanceof List)) {
            return OptionalValue.INSTANCE.absent();
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            return OptionalValue.INSTANCE.ofNullable(CollectionsKt.emptyList());
        }
        Object obj2 = list.get(0);
        obj2.getClass();
        return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(obj2.getClass()), kClass) ? OptionalValue.INSTANCE.ofNullable(list) : OptionalValue.INSTANCE.absent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getOrThrow-roUYKiI, reason: not valid java name */
    public final <T> T m544getOrThrowroUYKiI(Map<UInt, ? extends Object> map, int i, String str, Function0<? extends T> function0, KClass<T> kClass) throws RequiredFieldException {
        T orNull = m542getOptionalOsBMiQA(map, i, kClass).getOrNull();
        if (orNull != null) {
            return orNull;
        }
        if (GlobalParserOptions.INSTANCE.getLenient()) {
            return function0.invoke();
        }
        throw new RequiredFieldException(str, null, 2, null);
    }

    public final <T> FieldReader<T> bitmap(BitmapAdapter<T> adapter) {
        adapter.getClass();
        return (FieldReader<T>) this.bitmap.adapt(adapter);
    }

    /* JADX INFO: renamed from: enum, reason: not valid java name */
    public final <T extends ClusterEnum> FieldReader<T> m545enum(EnumAdapter<T> adapter) {
        adapter.getClass();
        return (FieldReader<T>) this.ulong.adapt(adapter);
    }

    public final FieldReader<Boolean> getBoolean() {
        return this.boolean;
    }

    public final FieldReader<Byte> getByte() {
        return this.byte;
    }

    public final FieldReader<byte[]> getBytearray() {
        return this.bytearray;
    }

    public final FieldReader<Double> getDouble() {
        return this.double;
    }

    public final FieldReader<Float> getFloat() {
        return this.float;
    }

    public final FieldReader<Integer> getInt() {
        return this.int;
    }

    public final FieldReader<Long> getLong() {
        return this.long;
    }

    public final FieldReader<Short> getShort() {
        return this.short;
    }

    public final FieldReader<String> getString() {
        return this.string;
    }

    public final FieldReader<UByte> getUbyte() {
        return this.ubyte;
    }

    public final FieldReader<UInt> getUint() {
        return this.uint;
    }

    public final FieldReader<ULong> getUlong() {
        return this.ulong;
    }

    public final FieldReader<UShort> getUshort() {
        return this.ushort;
    }

    public final <T> OptionalValue<T> notNull(OptionalValue<T> optionalValue, String str) throws RequiredFieldException {
        optionalValue.getClass();
        str.getClass();
        if (optionalValue instanceof OptionalNull) {
            throw new RequiredFieldException(str, null, 2, null);
        }
        return optionalValue;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0012\u0004\u0012\u0002H\u00010\u0003R\u00020\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nB\u001f\b\u0016\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayload$RawFieldReader;", "T", "", "Lcom/google/home/matter/serialization/ClusterPayload$RawFieldReaderNoDefault;", "Lcom/google/home/matter/serialization/ClusterPayload;", "defaultValueGenerator", "Lkotlin/Function0;", "type", "Lkotlin/reflect/KClass;", "<init>", "(Lcom/google/home/matter/serialization/ClusterPayload;Lkotlin/jvm/functions/Function0;Lkotlin/reflect/KClass;)V", SDKConstants.PARAM_VALUE, "(Lcom/google/home/matter/serialization/ClusterPayload;Ljava/lang/Object;Lkotlin/reflect/KClass;)V", "getDefaultValueGenerator", "()Lkotlin/jvm/functions/Function0;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class RawFieldReader<T> extends RawFieldReaderNoDefault<T> {
        private final Function0<T> defaultValueGenerator;
        final /* synthetic */ ClusterPayload this$0;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RawFieldReader(ClusterPayload clusterPayload, final T t, KClass<T> kClass) {
            this(clusterPayload, (Function0) new Function0<T>() { // from class: com.google.home.matter.serialization.ClusterPayload.RawFieldReader.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final T invoke() {
                    return t;
                }
            }, (KClass) kClass);
            t.getClass();
            kClass.getClass();
        }

        @Override // com.google.home.matter.serialization.ClusterPayload.RawFieldReaderNoDefault, com.google.home.matter.serialization.ClusterPayload.FieldReader
        public Function0<T> getDefaultValueGenerator() {
            return this.defaultValueGenerator;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public RawFieldReader(ClusterPayload clusterPayload, Function0<? extends T> function0, KClass<T> kClass) {
            super(clusterPayload, kClass);
            function0.getClass();
            kClass.getClass();
            this.this$0 = clusterPayload;
            this.defaultValueGenerator = function0;
        }
    }
}
