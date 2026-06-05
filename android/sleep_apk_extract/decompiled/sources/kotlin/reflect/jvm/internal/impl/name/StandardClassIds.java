package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.ranges.RangesKt;
import twitter4j.TwitterImpl$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class StandardClassIds {
    private static final ClassId AbstractMap;
    private static final ClassId Annotation;
    private static final ClassId AnnotationRetention;
    private static final ClassId AnnotationTarget;
    private static final ClassId Any;
    private static final ClassId Array;
    private static final ClassId AtomicArray;
    private static final ClassId AtomicBoolean;
    private static final ClassId AtomicInt;
    private static final ClassId AtomicIntArray;
    private static final ClassId AtomicLong;
    private static final ClassId AtomicLongArray;
    private static final ClassId AtomicReference;
    private static final FqName BASE_ANNOTATIONS_JVM_PACKAGE;
    private static final FqName BASE_ANNOTATION_PACKAGE;
    private static final FqName BASE_COLLECTIONS_PACKAGE;
    private static final FqName BASE_CONCURRENT_ATOMICS_PACKAGE;
    private static final FqName BASE_CONCURRENT_PACKAGE;
    private static final FqName BASE_CONTRACTS_PACKAGE;
    private static final FqName BASE_COROUTINES_INTRINSICS_PACKAGE;
    private static final FqName BASE_COROUTINES_PACKAGE;
    private static final FqName BASE_ENUMS_PACKAGE;
    private static final FqName BASE_EXPERIMENTAL_PACKAGE;
    private static final FqName BASE_INTERNAL_IR_PACKAGE;
    private static final FqName BASE_INTERNAL_PACKAGE;
    private static final FqName BASE_JS_PACKAGE;
    private static final FqName BASE_JVM_FUNCTIONS_PACKAGE;
    private static final FqName BASE_JVM_INTERNAL_PACKAGE;
    private static final FqName BASE_JVM_PACKAGE;
    private static final FqName BASE_KOTLIN_PACKAGE;
    private static final FqName BASE_RANGES_PACKAGE;
    private static final FqName BASE_REFLECT_PACKAGE;
    private static final FqName BASE_SEQUENCES_PACKAGE;
    private static final FqName BASE_TEST_PACKAGE;
    private static final FqName BASE_TEXT_PACKAGE;
    private static final ClassId Boolean;
    private static final ClassId Byte;
    private static final ClassId Char;
    private static final ClassId CharIterator;
    private static final ClassId CharRange;
    private static final ClassId CharSequence;
    private static final ClassId Cloneable;
    private static final ClassId Collection;
    private static final ClassId Comparable;
    private static final ClassId Continuation;
    private static final ClassId DeprecationLevel;
    private static final ClassId Double;
    private static final ClassId Enum;
    private static final ClassId EnumEntries;
    private static final ClassId Float;
    private static final ClassId Function;
    public static final StandardClassIds INSTANCE = new StandardClassIds();
    private static final ClassId Int;
    private static final ClassId IntRange;
    private static final ClassId Iterable;
    private static final ClassId Iterator;
    private static final ClassId KCallable;
    private static final ClassId KClass;
    private static final ClassId KFunction;
    private static final ClassId KMutableProperty;
    private static final ClassId KMutableProperty0;
    private static final ClassId KMutableProperty1;
    private static final ClassId KMutableProperty2;
    private static final ClassId KProperty;
    private static final ClassId KProperty0;
    private static final ClassId KProperty1;
    private static final ClassId KProperty2;
    private static final ClassId KType;
    private static final ClassId List;
    private static final ClassId ListIterator;
    private static final ClassId Long;
    private static final ClassId LongRange;
    private static final ClassId Map;
    private static final ClassId MapEntry;
    private static final ClassId MutableCollection;
    private static final ClassId MutableIterable;
    private static final ClassId MutableIterator;
    private static final ClassId MutableList;
    private static final ClassId MutableListIterator;
    private static final ClassId MutableMap;
    private static final ClassId MutableMapEntry;
    private static final ClassId MutableSet;
    private static final ClassId Nothing;
    private static final ClassId Number;
    private static final ClassId Result;
    private static final ClassId Sequence;
    private static final ClassId Set;
    private static final ClassId Short;
    private static final ClassId String;
    private static final ClassId SuspendFunction;
    private static final ClassId Throwable;
    private static final ClassId UByte;
    private static final ClassId UInt;
    private static final ClassId ULong;
    private static final ClassId UShort;
    private static final ClassId Unit;
    private static final Set<ClassId> allBuiltinTypes;
    private static final Map<ClassId, ClassId> atomicArrayByPrimitive;
    private static final Map<ClassId, ClassId> atomicByPrimitive;
    private static final Set<FqName> builtInsPackages;
    private static final Set<FqName> builtInsPackagesWithDefaultNamedImport;
    private static final Set<ClassId> constantAllowedTypes;
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType;
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType;
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType;
    private static final Set<ClassId> primitiveTypes;
    private static final Set<ClassId> signedIntegerTypes;
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType;
    private static final Set<ClassId> unsignedTypes;

    static {
        FqName fqName = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = fqName;
        FqName fqNameM = TwitterImpl$$ExternalSyntheticOutline0.m("reflect", fqName);
        BASE_REFLECT_PACKAGE = fqNameM;
        BASE_EXPERIMENTAL_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("experimental", fqName);
        FqName fqNameM2 = TwitterImpl$$ExternalSyntheticOutline0.m("collections", fqName);
        BASE_COLLECTIONS_PACKAGE = fqNameM2;
        BASE_SEQUENCES_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("sequences", fqName);
        FqName fqNameM3 = TwitterImpl$$ExternalSyntheticOutline0.m("ranges", fqName);
        BASE_RANGES_PACKAGE = fqNameM3;
        FqName fqNameM4 = TwitterImpl$$ExternalSyntheticOutline0.m("jvm", fqName);
        BASE_JVM_PACKAGE = fqNameM4;
        BASE_JS_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("js", fqName);
        BASE_ANNOTATIONS_JVM_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("jvm", TwitterImpl$$ExternalSyntheticOutline0.m("annotations", fqName));
        BASE_JVM_INTERNAL_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("internal", fqNameM4);
        BASE_JVM_FUNCTIONS_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("functions", fqNameM4);
        FqName fqNameM5 = TwitterImpl$$ExternalSyntheticOutline0.m("annotation", fqName);
        BASE_ANNOTATION_PACKAGE = fqNameM5;
        FqName fqNameM6 = TwitterImpl$$ExternalSyntheticOutline0.m("internal", fqName);
        BASE_INTERNAL_PACKAGE = fqNameM6;
        BASE_INTERNAL_IR_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("ir", fqNameM6);
        FqName fqNameM7 = TwitterImpl$$ExternalSyntheticOutline0.m("coroutines", fqName);
        BASE_COROUTINES_PACKAGE = fqNameM7;
        BASE_COROUTINES_INTRINSICS_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("intrinsics", fqNameM7);
        BASE_ENUMS_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("enums", fqName);
        BASE_CONTRACTS_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("contracts", fqName);
        FqName fqNameM8 = TwitterImpl$$ExternalSyntheticOutline0.m("concurrent", fqName);
        BASE_CONCURRENT_PACKAGE = fqNameM8;
        FqName fqNameM9 = TwitterImpl$$ExternalSyntheticOutline0.m("atomics", fqNameM8);
        BASE_CONCURRENT_ATOMICS_PACKAGE = fqNameM9;
        BASE_TEST_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("test", fqName);
        BASE_TEXT_PACKAGE = TwitterImpl$$ExternalSyntheticOutline0.m("text", fqName);
        builtInsPackagesWithDefaultNamedImport = SetsKt.setOf((Object[]) new FqName[]{fqName, fqNameM2, fqNameM3, fqNameM5});
        builtInsPackages = SetsKt.setOf((Object[]) new FqName[]{fqName, fqNameM2, fqNameM3, fqNameM5, fqNameM, fqNameM6, fqNameM7, fqNameM9});
        Nothing = StandardClassIdsKt.baseId("Nothing");
        Unit = StandardClassIdsKt.baseId("Unit");
        Any = StandardClassIdsKt.baseId("Any");
        Enum = StandardClassIdsKt.baseId("Enum");
        Annotation = StandardClassIdsKt.baseId("Annotation");
        Array = StandardClassIdsKt.baseId("Array");
        ClassId classIdBaseId = StandardClassIdsKt.baseId("Boolean");
        Boolean = classIdBaseId;
        ClassId classIdBaseId2 = StandardClassIdsKt.baseId("Char");
        Char = classIdBaseId2;
        ClassId classIdBaseId3 = StandardClassIdsKt.baseId("Byte");
        Byte = classIdBaseId3;
        ClassId classIdBaseId4 = StandardClassIdsKt.baseId("Short");
        Short = classIdBaseId4;
        ClassId classIdBaseId5 = StandardClassIdsKt.baseId("Int");
        Int = classIdBaseId5;
        ClassId classIdBaseId6 = StandardClassIdsKt.baseId("Long");
        Long = classIdBaseId6;
        ClassId classIdBaseId7 = StandardClassIdsKt.baseId("Float");
        Float = classIdBaseId7;
        ClassId classIdBaseId8 = StandardClassIdsKt.baseId("Double");
        Double = classIdBaseId8;
        UByte = StandardClassIdsKt.unsignedId(classIdBaseId3);
        UShort = StandardClassIdsKt.unsignedId(classIdBaseId4);
        UInt = StandardClassIdsKt.unsignedId(classIdBaseId5);
        ULong = StandardClassIdsKt.unsignedId(classIdBaseId6);
        CharSequence = StandardClassIdsKt.baseId("CharSequence");
        String = StandardClassIdsKt.baseId("String");
        Throwable = StandardClassIdsKt.baseId("Throwable");
        Cloneable = StandardClassIdsKt.baseId("Cloneable");
        KProperty = StandardClassIdsKt.reflectId("KProperty");
        KMutableProperty = StandardClassIdsKt.reflectId("KMutableProperty");
        KProperty0 = StandardClassIdsKt.reflectId("KProperty0");
        KMutableProperty0 = StandardClassIdsKt.reflectId("KMutableProperty0");
        KProperty1 = StandardClassIdsKt.reflectId("KProperty1");
        KMutableProperty1 = StandardClassIdsKt.reflectId("KMutableProperty1");
        KProperty2 = StandardClassIdsKt.reflectId("KProperty2");
        KMutableProperty2 = StandardClassIdsKt.reflectId("KMutableProperty2");
        KFunction = StandardClassIdsKt.reflectId("KFunction");
        KClass = StandardClassIdsKt.reflectId("KClass");
        KCallable = StandardClassIdsKt.reflectId("KCallable");
        KType = StandardClassIdsKt.reflectId("KType");
        Sequence = StandardClassIdsKt.sequencesId("Sequence");
        Comparable = StandardClassIdsKt.baseId("Comparable");
        Number = StandardClassIdsKt.baseId("Number");
        Function = StandardClassIdsKt.baseId("Function");
        SuspendFunction = StandardClassIdsKt.coroutinesId("SuspendFunction");
        Set<ClassId> of = SetsKt.setOf((Object[]) new ClassId[]{classIdBaseId, classIdBaseId2, classIdBaseId3, classIdBaseId4, classIdBaseId5, classIdBaseId6, classIdBaseId7, classIdBaseId8});
        primitiveTypes = of;
        signedIntegerTypes = SetsKt.setOf((Object[]) new ClassId[]{classIdBaseId3, classIdBaseId4, classIdBaseId5, classIdBaseId6});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(of, 10)), 16));
        for (Object obj : of) {
            linkedHashMap.put(obj, StandardClassIdsKt.primitiveArrayId(((ClassId) obj).getShortClassName()));
        }
        primitiveArrayTypeByElementType = linkedHashMap;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.inverseMap(linkedHashMap);
        Set<ClassId> of2 = SetsKt.setOf((Object[]) new ClassId[]{UByte, UShort, UInt, ULong});
        unsignedTypes = of2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(of2, 10)), 16));
        for (Object obj2 : of2) {
            linkedHashMap2.put(obj2, StandardClassIdsKt.primitiveArrayId(((ClassId) obj2).getShortClassName()));
        }
        unsignedArrayTypeByElementType = linkedHashMap2;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.inverseMap(linkedHashMap2);
        Set<ClassId> set = primitiveTypes;
        Set<ClassId> set2 = unsignedTypes;
        Set setPlus = SetsKt.plus((Set) set, (Iterable) set2);
        ClassId classId = String;
        constantAllowedTypes = SetsKt.plus((Set<? extends ClassId>) setPlus, classId);
        Continuation = StandardClassIdsKt.coroutinesId("Continuation");
        Iterator = StandardClassIdsKt.collectionsId("Iterator");
        Iterable = StandardClassIdsKt.collectionsId("Iterable");
        Collection = StandardClassIdsKt.collectionsId("Collection");
        List = StandardClassIdsKt.collectionsId("List");
        ListIterator = StandardClassIdsKt.collectionsId("ListIterator");
        Set = StandardClassIdsKt.collectionsId("Set");
        ClassId classIdCollectionsId = StandardClassIdsKt.collectionsId("Map");
        Map = classIdCollectionsId;
        AbstractMap = StandardClassIdsKt.collectionsId("AbstractMap");
        MutableIterator = StandardClassIdsKt.collectionsId("MutableIterator");
        CharIterator = StandardClassIdsKt.collectionsId("CharIterator");
        MutableIterable = StandardClassIdsKt.collectionsId("MutableIterable");
        MutableCollection = StandardClassIdsKt.collectionsId("MutableCollection");
        MutableList = StandardClassIdsKt.collectionsId("MutableList");
        MutableListIterator = StandardClassIdsKt.collectionsId("MutableListIterator");
        MutableSet = StandardClassIdsKt.collectionsId("MutableSet");
        ClassId classIdCollectionsId2 = StandardClassIdsKt.collectionsId("MutableMap");
        MutableMap = classIdCollectionsId2;
        Name nameIdentifier = Name.identifier("Entry");
        nameIdentifier.getClass();
        MapEntry = classIdCollectionsId.createNestedClassId(nameIdentifier);
        Name nameIdentifier2 = Name.identifier("MutableEntry");
        nameIdentifier2.getClass();
        MutableMapEntry = classIdCollectionsId2.createNestedClassId(nameIdentifier2);
        Result = StandardClassIdsKt.baseId("Result");
        IntRange = StandardClassIdsKt.rangesId("IntRange");
        LongRange = StandardClassIdsKt.rangesId("LongRange");
        CharRange = StandardClassIdsKt.rangesId("CharRange");
        AnnotationRetention = StandardClassIdsKt.annotationId("AnnotationRetention");
        AnnotationTarget = StandardClassIdsKt.annotationId("AnnotationTarget");
        DeprecationLevel = StandardClassIdsKt.baseId("DeprecationLevel");
        EnumEntries = StandardClassIdsKt.enumsId("EnumEntries");
        ClassId classIdAtomicsId = StandardClassIdsKt.atomicsId("AtomicBoolean");
        AtomicBoolean = classIdAtomicsId;
        ClassId classIdAtomicsId2 = StandardClassIdsKt.atomicsId("AtomicInt");
        AtomicInt = classIdAtomicsId2;
        ClassId classIdAtomicsId3 = StandardClassIdsKt.atomicsId("AtomicLong");
        AtomicLong = classIdAtomicsId3;
        AtomicReference = StandardClassIdsKt.atomicsId("AtomicReference");
        Pair pair = TuplesKt.to(Boolean, classIdAtomicsId);
        ClassId classId2 = Int;
        Pair pair2 = TuplesKt.to(classId2, classIdAtomicsId2);
        ClassId classId3 = Long;
        atomicByPrimitive = MapsKt.mapOf(pair, pair2, TuplesKt.to(classId3, classIdAtomicsId3));
        AtomicArray = StandardClassIdsKt.atomicsId("AtomicArray");
        ClassId classIdAtomicsId4 = StandardClassIdsKt.atomicsId("AtomicIntArray");
        AtomicIntArray = classIdAtomicsId4;
        ClassId classIdAtomicsId5 = StandardClassIdsKt.atomicsId("AtomicLongArray");
        AtomicLongArray = classIdAtomicsId5;
        atomicArrayByPrimitive = MapsKt.mapOf(TuplesKt.to(classId2, classIdAtomicsId4), TuplesKt.to(classId3, classIdAtomicsId5));
        allBuiltinTypes = SetsKt.plus((Set<? extends ClassId>) SetsKt.plus((Set<? extends ClassId>) SetsKt.plus((Set<? extends ClassId>) SetsKt.plus((Set<? extends ClassId>) SetsKt.plus((Set) set, (Iterable) set2), classId), Unit), Any), Enum);
    }

    private StandardClassIds() {
    }

    public final ClassId getArray() {
        return Array;
    }

    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    public final FqName getBASE_CONCURRENT_ATOMICS_PACKAGE() {
        return BASE_CONCURRENT_ATOMICS_PACKAGE;
    }

    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    public final FqName getBASE_ENUMS_PACKAGE() {
        return BASE_ENUMS_PACKAGE;
    }

    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    public final FqName getBASE_SEQUENCES_PACKAGE() {
        return BASE_SEQUENCES_PACKAGE;
    }

    public final ClassId getEnumEntries() {
        return EnumEntries;
    }

    public final ClassId getKClass() {
        return KClass;
    }

    public final ClassId getKFunction() {
        return KFunction;
    }

    public final ClassId getMutableList() {
        return MutableList;
    }

    public final ClassId getMutableMap() {
        return MutableMap;
    }

    public final ClassId getMutableSet() {
        return MutableSet;
    }
}
