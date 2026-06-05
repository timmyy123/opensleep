package kotlinx.serialization.builtins;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlin.uuid.Uuid;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanArraySerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharArraySerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleArraySerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.LongArraySerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.NothingSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.ShortArraySerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.UByteArraySerializer;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntArraySerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongArraySerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortArraySerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.internal.UnitSerializer;
import kotlinx.serialization.internal.UuidSerializer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000À\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\u001aG\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001aG\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\t\u0010\u0007\u001aa\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00100\u0002\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b\"\u0004\b\u0002\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0002*\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002*\u00020\u001a¢\u0006\u0004\b\u0015\u0010\u001c\u001a\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0002¢\u0006\u0004\b\u001e\u0010\u0019\u001a\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0002H\u0007¢\u0006\u0004\b \u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\"0\u0002*\u00020!¢\u0006\u0004\b\u0015\u0010#\u001a\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0002¢\u0006\u0004\b%\u0010\u0019\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0002H\u0007¢\u0006\u0004\b'\u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020)0\u0002*\u00020(¢\u0006\u0004\b\u0015\u0010*\u001a\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0002¢\u0006\u0004\b,\u0010\u0019\u001a\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u0002H\u0007¢\u0006\u0004\b.\u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002000\u0002*\u00020/¢\u0006\u0004\b\u0015\u00101\u001a\u0013\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0002¢\u0006\u0004\b3\u0010\u0019\u001a\u0015\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0002H\u0007¢\u0006\u0004\b5\u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002070\u0002*\u000206¢\u0006\u0004\b\u0015\u00108\u001a\u0013\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0002¢\u0006\u0004\b:\u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020<0\u0002*\u00020;¢\u0006\u0004\b\u0015\u0010=\u001a\u0013\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u0002¢\u0006\u0004\b?\u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020A0\u0002*\u00020@¢\u0006\u0004\b\u0015\u0010B\u001a\u0013\u0010D\u001a\b\u0012\u0004\u0012\u00020C0\u0002¢\u0006\u0004\bD\u0010\u0019\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020E0\u0002*\u00020E¢\u0006\u0004\b\u0015\u0010F\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020H0\u0002*\u00020G¢\u0006\u0004\b\u0015\u0010I\u001aM\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010P0\u0002\"\b\b\u0000\u0010K*\u00020J\"\n\b\u0001\u0010L*\u0004\u0018\u00018\u00002\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000M2\f\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bQ\u0010R\u001a-\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000S0\u0002\"\u0004\b\u0000\u0010K2\f\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\bT\u0010U\u001a-\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000V0\u0002\"\u0004\b\u0000\u0010K2\f\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\bW\u0010U\u001aG\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010X0\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\bY\u0010\u0007\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020[0\u0002*\u00020Z¢\u0006\u0004\b\u0015\u0010\\\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020^0\u0002*\u00020]¢\u0006\u0004\b\u0015\u0010_\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020a0\u0002*\u00020`¢\u0006\u0004\b\u0015\u0010b\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020d0\u0002*\u00020c¢\u0006\u0004\b\u0015\u0010e\u001a\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020g0\u0002*\u00020f¢\u0006\u0004\b\u0015\u0010h\u001a\u0019\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020j0\u0002*\u00020iH\u0007¢\u0006\u0004\b\u0015\u0010k\u001a\u0015\u0010m\u001a\b\u0012\u0004\u0012\u00020l0\u0002H\u0007¢\u0006\u0004\bm\u0010\u0019\"3\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\"\b\b\u0000\u0010K*\u00020J*\b\u0012\u0004\u0012\u00028\u00000\u00028F¢\u0006\f\u0012\u0004\bo\u0010p\u001a\u0004\bn\u0010U¨\u0006r"}, d2 = {"K", "V", "Lkotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "Lkotlin/Pair;", "PairSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "MapEntrySerializer", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "Lkotlin/Triple;", "TripleSerializer", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "Lkotlin/Char$Companion;", "", "serializer", "(Lkotlin/jvm/internal/CharCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "CharArraySerializer", "()Lkotlinx/serialization/KSerializer;", "Lkotlin/Byte$Companion;", "", "(Lkotlin/jvm/internal/ByteCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "ByteArraySerializer", "Lkotlin/UByteArray;", "UByteArraySerializer", "Lkotlin/Short$Companion;", "", "(Lkotlin/jvm/internal/ShortCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "ShortArraySerializer", "Lkotlin/UShortArray;", "UShortArraySerializer", "Lkotlin/Int$Companion;", "", "(Lkotlin/jvm/internal/IntCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "IntArraySerializer", "Lkotlin/UIntArray;", "UIntArraySerializer", "Lkotlin/Long$Companion;", "", "(Lkotlin/jvm/internal/LongCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "LongArraySerializer", "Lkotlin/ULongArray;", "ULongArraySerializer", "Lkotlin/Float$Companion;", "", "(Lkotlin/jvm/internal/FloatCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "FloatArraySerializer", "Lkotlin/Double$Companion;", "", "(Lkotlin/jvm/internal/DoubleCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "DoubleArraySerializer", "Lkotlin/Boolean$Companion;", "", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "BooleanArraySerializer", "", "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", "Lkotlin/String$Companion;", "", "(Lkotlin/jvm/internal/StringCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "T", "E", "Lkotlin/reflect/KClass;", "kClass", "elementSerializer", "", "ArraySerializer", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "ListSerializer", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "", "SetSerializer", "", "MapSerializer", "Lkotlin/UInt$Companion;", "Lkotlin/UInt;", "(Lkotlin/UInt$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/ULong$Companion;", "Lkotlin/ULong;", "(Lkotlin/ULong$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/UByte$Companion;", "Lkotlin/UByte;", "(Lkotlin/UByte$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/UShort$Companion;", "Lkotlin/UShort;", "(Lkotlin/UShort$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/time/Duration$Companion;", "Lkotlin/time/Duration;", "(Lkotlin/time/Duration$Companion;)Lkotlinx/serialization/KSerializer;", "Lkotlin/uuid/Uuid$Companion;", "Lkotlin/uuid/Uuid;", "(Lkotlin/uuid/Uuid$Companion;)Lkotlinx/serialization/KSerializer;", "", "NothingSerializer", "getNullable", "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "nullable", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class BuiltinSerializersKt {
    public static final <T, E extends T> KSerializer<E[]> ArraySerializer(KClass<T> kClass, KSerializer<E> kSerializer) {
        kClass.getClass();
        kSerializer.getClass();
        return new ReferenceArraySerializer(kClass, kSerializer);
    }

    public static final KSerializer<boolean[]> BooleanArraySerializer() {
        return BooleanArraySerializer.INSTANCE;
    }

    public static final KSerializer<byte[]> ByteArraySerializer() {
        return ByteArraySerializer.INSTANCE;
    }

    public static final KSerializer<char[]> CharArraySerializer() {
        return CharArraySerializer.INSTANCE;
    }

    public static final KSerializer<double[]> DoubleArraySerializer() {
        return DoubleArraySerializer.INSTANCE;
    }

    public static final KSerializer<float[]> FloatArraySerializer() {
        return FloatArraySerializer.INSTANCE;
    }

    public static final KSerializer<int[]> IntArraySerializer() {
        return IntArraySerializer.INSTANCE;
    }

    public static final <T> KSerializer<List<T>> ListSerializer(KSerializer<T> kSerializer) {
        kSerializer.getClass();
        return new ArrayListSerializer(kSerializer);
    }

    public static final KSerializer<long[]> LongArraySerializer() {
        return LongArraySerializer.INSTANCE;
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> MapEntrySerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        kSerializer.getClass();
        kSerializer2.getClass();
        return new MapEntrySerializer(kSerializer, kSerializer2);
    }

    public static final <K, V> KSerializer<Map<K, V>> MapSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        kSerializer.getClass();
        kSerializer2.getClass();
        return new LinkedHashMapSerializer(kSerializer, kSerializer2);
    }

    public static final KSerializer NothingSerializer() {
        return NothingSerializer.INSTANCE;
    }

    public static final <K, V> KSerializer<Pair<K, V>> PairSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        kSerializer.getClass();
        kSerializer2.getClass();
        return new PairSerializer(kSerializer, kSerializer2);
    }

    public static final <T> KSerializer<Set<T>> SetSerializer(KSerializer<T> kSerializer) {
        kSerializer.getClass();
        return new LinkedHashSetSerializer(kSerializer);
    }

    public static final KSerializer<short[]> ShortArraySerializer() {
        return ShortArraySerializer.INSTANCE;
    }

    public static final <A, B, C> KSerializer<Triple<A, B, C>> TripleSerializer(KSerializer<A> kSerializer, KSerializer<B> kSerializer2, KSerializer<C> kSerializer3) {
        kSerializer.getClass();
        kSerializer2.getClass();
        kSerializer3.getClass();
        return new TripleSerializer(kSerializer, kSerializer2, kSerializer3);
    }

    public static final KSerializer<UByteArray> UByteArraySerializer() {
        return UByteArraySerializer.INSTANCE;
    }

    public static final KSerializer<UIntArray> UIntArraySerializer() {
        return UIntArraySerializer.INSTANCE;
    }

    public static final KSerializer<ULongArray> ULongArraySerializer() {
        return ULongArraySerializer.INSTANCE;
    }

    public static final KSerializer<UShortArray> UShortArraySerializer() {
        return UShortArraySerializer.INSTANCE;
    }

    public static final <T> KSerializer<T> getNullable(KSerializer<T> kSerializer) {
        kSerializer.getClass();
        return kSerializer.getDescriptor().isNullable() ? kSerializer : new NullableSerializer(kSerializer);
    }

    public static final KSerializer<Character> serializer(CharCompanionObject charCompanionObject) {
        charCompanionObject.getClass();
        return CharSerializer.INSTANCE;
    }

    public static final KSerializer<Byte> serializer(ByteCompanionObject byteCompanionObject) {
        byteCompanionObject.getClass();
        return ByteSerializer.INSTANCE;
    }

    public static final KSerializer<Short> serializer(ShortCompanionObject shortCompanionObject) {
        shortCompanionObject.getClass();
        return ShortSerializer.INSTANCE;
    }

    public static final KSerializer<Integer> serializer(IntCompanionObject intCompanionObject) {
        intCompanionObject.getClass();
        return IntSerializer.INSTANCE;
    }

    public static final KSerializer<Long> serializer(LongCompanionObject longCompanionObject) {
        longCompanionObject.getClass();
        return LongSerializer.INSTANCE;
    }

    public static final KSerializer<Float> serializer(FloatCompanionObject floatCompanionObject) {
        floatCompanionObject.getClass();
        return FloatSerializer.INSTANCE;
    }

    public static final KSerializer<Double> serializer(DoubleCompanionObject doubleCompanionObject) {
        doubleCompanionObject.getClass();
        return DoubleSerializer.INSTANCE;
    }

    public static final KSerializer<Boolean> serializer(BooleanCompanionObject booleanCompanionObject) {
        booleanCompanionObject.getClass();
        return BooleanSerializer.INSTANCE;
    }

    public static final KSerializer<Unit> serializer(Unit unit) {
        unit.getClass();
        return UnitSerializer.INSTANCE;
    }

    public static final KSerializer<String> serializer(StringCompanionObject stringCompanionObject) {
        stringCompanionObject.getClass();
        return StringSerializer.INSTANCE;
    }

    public static final KSerializer<UInt> serializer(UInt.Companion companion) {
        companion.getClass();
        return UIntSerializer.INSTANCE;
    }

    public static final KSerializer<ULong> serializer(ULong.Companion companion) {
        companion.getClass();
        return ULongSerializer.INSTANCE;
    }

    public static final KSerializer<UByte> serializer(UByte.Companion companion) {
        companion.getClass();
        return UByteSerializer.INSTANCE;
    }

    public static final KSerializer<UShort> serializer(UShort.Companion companion) {
        companion.getClass();
        return UShortSerializer.INSTANCE;
    }

    public static final KSerializer<Duration> serializer(Duration.Companion companion) {
        companion.getClass();
        return DurationSerializer.INSTANCE;
    }

    public static final KSerializer<Uuid> serializer(Uuid.Companion companion) {
        companion.getClass();
        return UuidSerializer.INSTANCE;
    }
}
