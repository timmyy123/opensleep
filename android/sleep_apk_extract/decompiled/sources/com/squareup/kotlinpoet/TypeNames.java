package com.squareup.kotlinpoet;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0005H\u0007¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\bH\u0007¢\u0006\u0004\b\u0002\u0010\t\"\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b\"\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b\"\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000b\"\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000b\"\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000b\"\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000b\"\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000b\"\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000b\"\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000b\"\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000b\"\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000b\"\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000b\"\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u000b\"\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000b\"\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u000b\"\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u000b\"\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u000b\"\u0014\u0010\u001f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u000b\"\u0014\u0010 \u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010\u000b\"\u0014\u0010!\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b!\u0010\u000b\"\u0014\u0010\"\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u000b\"\u0014\u0010#\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\u000b\"\u0014\u0010$\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b$\u0010\u000b\"\u0014\u0010%\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b%\u0010\u000b\"\u0014\u0010&\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010\u000b\"\u0014\u0010'\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010\u000b\"\u0014\u0010(\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b(\u0010\u000b\"\u0014\u0010)\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b)\u0010\u000b\"\u0014\u0010*\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b*\u0010\u000b\"\u0014\u0010+\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b+\u0010\u000b\"\u0014\u0010,\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b,\u0010\u000b\"\u0014\u0010-\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b-\u0010\u000b\"\u0014\u0010.\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010\u000b\"\u0014\u0010/\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u0010\u000b\"\u0014\u00100\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u0010\u000b\"\u0014\u00101\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u0010\u000b\"\u0014\u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010\u000b\"\u0014\u00103\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b3\u0010\u000b\"\u0014\u00104\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b4\u0010\u000b\"\u0014\u00105\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b5\u0010\u000b\"\u0014\u00106\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b6\u0010\u000b\"\u0014\u00107\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b7\u0010\u000b\"\u0014\u00108\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b8\u0010\u000b\"\u0014\u00109\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b9\u0010\u000b\"\u0014\u0010;\u001a\u00020:8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b;\u0010<\"\u0014\u0010>\u001a\u00020=8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006@"}, d2 = {"Ljavax/lang/model/type/TypeMirror;", "Lcom/squareup/kotlinpoet/TypeName;", "get", "(Ljavax/lang/model/type/TypeMirror;)Lcom/squareup/kotlinpoet/TypeName;", "asTypeName", "Lkotlin/reflect/KClass;", "Lcom/squareup/kotlinpoet/ClassName;", "(Lkotlin/reflect/KClass;)Lcom/squareup/kotlinpoet/ClassName;", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)Lcom/squareup/kotlinpoet/TypeName;", "ANY", "Lcom/squareup/kotlinpoet/ClassName;", "ARRAY", "UNIT", "BOOLEAN", "BYTE", "SHORT", "INT", "LONG", "CHAR", "FLOAT", "DOUBLE", "STRING", "CHAR_SEQUENCE", "COMPARABLE", "THROWABLE", "ANNOTATION", "NOTHING", "NUMBER", "ITERABLE", "COLLECTION", "LIST", "SET", "MAP", "MAP_ENTRY", "MUTABLE_ITERABLE", "MUTABLE_COLLECTION", "MUTABLE_LIST", "MUTABLE_SET", "MUTABLE_MAP", "MUTABLE_MAP_ENTRY", "BOOLEAN_ARRAY", "BYTE_ARRAY", "CHAR_ARRAY", "SHORT_ARRAY", "INT_ARRAY", "LONG_ARRAY", "FLOAT_ARRAY", "DOUBLE_ARRAY", "ENUM", "U_BYTE", "U_SHORT", "U_INT", "U_LONG", "U_BYTE_ARRAY", "U_SHORT_ARRAY", "U_INT_ARRAY", "U_LONG_ARRAY", "Lcom/squareup/kotlinpoet/WildcardTypeName;", "STAR", "Lcom/squareup/kotlinpoet/WildcardTypeName;", "Lcom/squareup/kotlinpoet/Dynamic;", "DYNAMIC", "Lcom/squareup/kotlinpoet/Dynamic;", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TypeNames {
    public static final ClassName ANNOTATION;
    public static final ClassName ANY;
    public static final ClassName ARRAY;
    public static final ClassName BOOLEAN;
    public static final ClassName BOOLEAN_ARRAY;
    public static final ClassName BYTE;
    public static final ClassName BYTE_ARRAY;
    public static final ClassName CHAR;
    public static final ClassName CHAR_ARRAY;
    public static final ClassName CHAR_SEQUENCE;
    public static final ClassName COLLECTION;
    public static final ClassName COMPARABLE;
    public static final ClassName DOUBLE;
    public static final ClassName DOUBLE_ARRAY;
    public static final Dynamic DYNAMIC;
    public static final ClassName ENUM;
    public static final ClassName FLOAT;
    public static final ClassName FLOAT_ARRAY;
    public static final ClassName INT;
    public static final ClassName INT_ARRAY;
    public static final ClassName ITERABLE;
    public static final ClassName LIST;
    public static final ClassName LONG;
    public static final ClassName LONG_ARRAY;
    public static final ClassName MAP;
    public static final ClassName MAP_ENTRY;
    public static final ClassName MUTABLE_COLLECTION;
    public static final ClassName MUTABLE_ITERABLE;
    public static final ClassName MUTABLE_LIST;
    public static final ClassName MUTABLE_MAP;
    public static final ClassName MUTABLE_MAP_ENTRY;
    public static final ClassName MUTABLE_SET;
    public static final ClassName NOTHING;
    public static final ClassName NUMBER;
    public static final ClassName SET;
    public static final ClassName SHORT;
    public static final ClassName SHORT_ARRAY;
    public static final WildcardTypeName STAR;
    public static final ClassName STRING;
    public static final ClassName THROWABLE;
    public static final ClassName UNIT;
    public static final ClassName U_BYTE;
    public static final ClassName U_BYTE_ARRAY;
    public static final ClassName U_INT;
    public static final ClassName U_INT_ARRAY;
    public static final ClassName U_LONG;
    public static final ClassName U_LONG_ARRAY;
    public static final ClassName U_SHORT;
    public static final ClassName U_SHORT_ARRAY;

    static {
        ClassName className = new ClassName("kotlin", "Any");
        ANY = className;
        ARRAY = new ClassName("kotlin", "Array");
        UNIT = new ClassName("kotlin", "Unit");
        BOOLEAN = new ClassName("kotlin", "Boolean");
        BYTE = new ClassName("kotlin", "Byte");
        SHORT = new ClassName("kotlin", "Short");
        INT = new ClassName("kotlin", "Int");
        LONG = new ClassName("kotlin", "Long");
        CHAR = new ClassName("kotlin", "Char");
        FLOAT = new ClassName("kotlin", "Float");
        DOUBLE = new ClassName("kotlin", "Double");
        STRING = new ClassName("kotlin", "String");
        CHAR_SEQUENCE = new ClassName("kotlin", "CharSequence");
        COMPARABLE = new ClassName("kotlin", "Comparable");
        THROWABLE = new ClassName("kotlin", "Throwable");
        ANNOTATION = new ClassName("kotlin", "Annotation");
        NOTHING = new ClassName("kotlin", "Nothing");
        NUMBER = new ClassName("kotlin", "Number");
        ITERABLE = new ClassName("kotlin.collections", "Iterable");
        COLLECTION = new ClassName("kotlin.collections", "Collection");
        LIST = new ClassName("kotlin.collections", "List");
        SET = new ClassName("kotlin.collections", "Set");
        ClassName className2 = new ClassName("kotlin.collections", "Map");
        MAP = className2;
        MAP_ENTRY = className2.nestedClass("Entry");
        MUTABLE_ITERABLE = new ClassName("kotlin.collections", "MutableIterable");
        MUTABLE_COLLECTION = new ClassName("kotlin.collections", "MutableCollection");
        MUTABLE_LIST = new ClassName("kotlin.collections", "MutableList");
        MUTABLE_SET = new ClassName("kotlin.collections", "MutableSet");
        ClassName className3 = new ClassName("kotlin.collections", "MutableMap");
        MUTABLE_MAP = className3;
        MUTABLE_MAP_ENTRY = className3.nestedClass("Entry");
        BOOLEAN_ARRAY = new ClassName("kotlin", "BooleanArray");
        BYTE_ARRAY = new ClassName("kotlin", "ByteArray");
        CHAR_ARRAY = new ClassName("kotlin", "CharArray");
        SHORT_ARRAY = new ClassName("kotlin", "ShortArray");
        INT_ARRAY = new ClassName("kotlin", "IntArray");
        LONG_ARRAY = new ClassName("kotlin", "LongArray");
        FLOAT_ARRAY = new ClassName("kotlin", "FloatArray");
        DOUBLE_ARRAY = new ClassName("kotlin", "DoubleArray");
        ENUM = new ClassName("kotlin", "Enum");
        U_BYTE = new ClassName("kotlin", "UByte");
        U_SHORT = new ClassName("kotlin", "UShort");
        U_INT = new ClassName("kotlin", "UInt");
        U_LONG = new ClassName("kotlin", "ULong");
        U_BYTE_ARRAY = new ClassName("kotlin", "UByteArray");
        U_SHORT_ARRAY = new ClassName("kotlin", "UShortArray");
        U_INT_ARRAY = new ClassName("kotlin", "UIntArray");
        U_LONG_ARRAY = new ClassName("kotlin", "ULongArray");
        STAR = WildcardTypeName.INSTANCE.producerOf(TypeName.copy$default(className, true, null, 2, null));
        DYNAMIC = Dynamic.INSTANCE;
    }

    public static final TypeName get(TypeMirror typeMirror) {
        typeMirror.getClass();
        return TypeName.INSTANCE.get$kotlinpoet(typeMirror, new LinkedHashMap());
    }

    public static final ClassName get(KClass<?> kClass) {
        kClass.getClass();
        return ClassNames.get(kClass);
    }

    public static final TypeName get(Type type) {
        type.getClass();
        return TypeName.INSTANCE.get$kotlinpoet(type, new LinkedHashMap());
    }
}
