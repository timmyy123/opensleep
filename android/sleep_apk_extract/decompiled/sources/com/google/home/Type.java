package com.google.home;

import com.google.home.matter.serialization.StringSerializer;
import com.google.home.matter.serialization.ValueSerializer;
import com.google.home.platform.traits.Value;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\b\u0002\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/google/home/Type;", "", "valueSerializer", "Lcom/google/home/matter/serialization/ValueSerializer;", "<init>", "(Ljava/lang/String;ILcom/google/home/matter/serialization/ValueSerializer;)V", "getValueSerializer", "()Lcom/google/home/matter/serialization/ValueSerializer;", "Dynamic", "Byte", "Short", "Int", "Long", "UByte", "UShort", "UInt", "ULong", "Float", "Double", "String", "Boolean", "ByteArray", "Enum", "Bitmap", "Struct", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Type {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Type[] $VALUES;
    public static final Type Bitmap;
    public static final Type Boolean;
    public static final Type Byte;
    public static final Type ByteArray;
    public static final Type Double;
    public static final Type Dynamic;
    public static final Type Enum;
    public static final Type Float;
    public static final Type Int;
    public static final Type Long;
    public static final Type Short;
    public static final Type String;
    public static final Type Struct;
    public static final Type UByte;
    public static final Type UInt;
    public static final Type ULong;
    public static final Type UShort;
    private final ValueSerializer<?> valueSerializer;

    private static final /* synthetic */ Type[] $values() {
        return new Type[]{Dynamic, Byte, Short, Int, Long, UByte, UShort, UInt, ULong, Float, Double, String, Boolean, ByteArray, Enum, Bitmap, Struct};
    }

    static {
        UnsupportedValueSerializer unsupportedValueSerializer = new ValueSerializer<Object>() { // from class: com.google.home.UnsupportedValueSerializer
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Object deserialize(Value valueProto) {
                valueProto.getClass();
                throw new UnsupportedOperationException("Type cannot be deserialized");
            }
        };
        Dynamic = new Type("Dynamic", 0, unsupportedValueSerializer);
        Byte = new Type("Byte", 1, new ValueSerializer<Byte>() { // from class: com.google.home.matter.serialization.ByteSerializer
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Byte deserialize(Value valueProto) {
                valueProto.getClass();
                return Byte.valueOf((byte) valueProto.getIntValue());
            }
        });
        Short = new Type("Short", 2, new ValueSerializer<Short>() { // from class: com.google.home.matter.serialization.ShortSerializer
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Short deserialize(Value valueProto) {
                valueProto.getClass();
                return Short.valueOf((short) valueProto.getIntValue());
            }
        });
        Int = new Type("Int", 3, new ValueSerializer<Integer>() { // from class: com.google.home.matter.serialization.IntSerializer
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Integer deserialize(Value valueProto) {
                valueProto.getClass();
                return Integer.valueOf(valueProto.getIntValue());
            }
        });
        Long = new Type("Long", 4, new ValueSerializer<Long>() { // from class: com.google.home.matter.serialization.LongSerializer
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Long deserialize(Value valueProto) {
                valueProto.getClass();
                return Long.valueOf(valueProto.getLongValue());
            }
        });
        UByte = new Type("UByte", 5, new ValueSerializer<UByte>() { // from class: com.google.home.matter.serialization.UByteSerializer
            @Override // com.google.home.matter.serialization.ValueSerializer
            public /* bridge */ /* synthetic */ UByte deserialize(Value value) {
                return UByte.m2366boximpl(m570deserializeWa3L5BU(value));
            }

            /* JADX INFO: renamed from: deserialize-Wa3L5BU, reason: not valid java name */
            public byte m570deserializeWa3L5BU(Value valueProto) {
                valueProto.getClass();
                return UByte.m2367constructorimpl((byte) valueProto.getUintValue());
            }
        });
        UShort = new Type("UShort", 6, new ValueSerializer<UShort>() { // from class: com.google.home.matter.serialization.UShortSerializer
            @Override // com.google.home.matter.serialization.ValueSerializer
            public /* bridge */ /* synthetic */ UShort deserialize(Value value) {
                return UShort.m2432boximpl(m573deserializeBwKQO78(value));
            }

            /* JADX INFO: renamed from: deserialize-BwKQO78, reason: not valid java name */
            public short m573deserializeBwKQO78(Value valueProto) {
                valueProto.getClass();
                return UShort.m2433constructorimpl((short) valueProto.getUintValue());
            }
        });
        UInt = new Type("UInt", 7, new ValueSerializer<UInt>() { // from class: com.google.home.matter.serialization.UIntSerializer
            @Override // com.google.home.matter.serialization.ValueSerializer
            public /* bridge */ /* synthetic */ UInt deserialize(Value value) {
                return UInt.m2388boximpl(m571deserializeOGnWXxg(value));
            }

            /* JADX INFO: renamed from: deserialize-OGnWXxg, reason: not valid java name */
            public int m571deserializeOGnWXxg(Value valueProto) {
                valueProto.getClass();
                return UInt.m2389constructorimpl(valueProto.getUintValue());
            }
        });
        ULong = new Type("ULong", 8, new ValueSerializer<ULong>() { // from class: com.google.home.matter.serialization.ULongSerializer
            @Override // com.google.home.matter.serialization.ValueSerializer
            public /* bridge */ /* synthetic */ ULong deserialize(Value value) {
                return ULong.m2410boximpl(m572deserializeI7RO_PI(value));
            }

            /* JADX INFO: renamed from: deserialize-I7RO_PI, reason: not valid java name */
            public long m572deserializeI7RO_PI(Value valueProto) {
                valueProto.getClass();
                return ULong.m2411constructorimpl(valueProto.getUlongValue());
            }
        });
        Float = new Type("Float", 9, new ValueSerializer<Float>() { // from class: com.google.home.matter.serialization.FloatSerializer
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Float deserialize(Value valueProto) {
                valueProto.getClass();
                return Float.valueOf(valueProto.getFloatValue());
            }
        });
        Double = new Type("Double", 10, new ValueSerializer<Double>() { // from class: com.google.home.matter.serialization.DoubleSerializer
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Double deserialize(Value valueProto) {
                valueProto.getClass();
                return Double.valueOf(valueProto.getDoubleValue());
            }
        });
        String = new Type("String", 11, StringSerializer.INSTANCE);
        Boolean = new Type("Boolean", 12, new ValueSerializer<Boolean>() { // from class: com.google.home.matter.serialization.BooleanSerializer
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.ValueSerializer
            public Boolean deserialize(Value valueProto) {
                valueProto.getClass();
                return Boolean.valueOf(valueProto.getBoolValue());
            }
        });
        ByteArray = new Type("ByteArray", 13, new ValueSerializer<byte[]>() { // from class: com.google.home.matter.serialization.ByteArraySerializer
            @Override // com.google.home.matter.serialization.ValueSerializer
            public byte[] deserialize(Value valueProto) {
                valueProto.getClass();
                byte[] bArrZzn = valueProto.getBytesValue().zzn();
                bArrZzn.getClass();
                return bArrZzn;
            }
        });
        Enum = new Type("Enum", 14, unsupportedValueSerializer);
        Bitmap = new Type("Bitmap", 15, unsupportedValueSerializer);
        Struct = new Type("Struct", 16, unsupportedValueSerializer);
        Type[] typeArr$values = $values();
        $VALUES = typeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
    }

    private Type(String str, int i, ValueSerializer valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public static Type valueOf(String str) {
        return (Type) Enum.valueOf(Type.class, str);
    }

    public static Type[] values() {
        return (Type[]) $VALUES.clone();
    }

    public final ValueSerializer<?> getValueSerializer() {
        return this.valueSerializer;
    }
}
