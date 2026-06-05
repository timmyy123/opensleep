package kotlin.reflect.jvm.internal;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.types.AbstractKType;
import kotlin.reflect.jvm.internal.types.FlexibleKType;
import kotlin.reflect.jvm.internal.types.MutableCollectionKClassKt;
import kotlin.reflect.jvm.internal.types.SimpleKType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0000\u001a>\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\n2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H\u0002\u001a,\u0010\u0016\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002\u001a\u001a\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0011*\u0006\u0012\u0002\b\u00030\u0018H\u0000\u001a\u0012\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011*\u00020\u001bH\u0002\u001a$\u0010\u001c\u001a\u00020\u0012*\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002\u001a(\u0010!\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00052\u0016\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002\u001a#\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011*\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050#H\u0000¢\u0006\u0002\u0010$\u001a\u0014\u0010%\u001a\u00020&*\u00020\f2\u0006\u0010'\u001a\u00020\u0002H\u0002\"\u001c\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006("}, d2 = {"toKType", "Lkotlin/reflect/KType;", "Ljava/lang/reflect/Type;", "knownTypeParameters", "", "Ljava/lang/reflect/TypeVariable;", "Lkotlin/reflect/KTypeParameter;", "nullability", "Lkotlin/reflect/jvm/internal/TypeNullability;", "replaceNonArrayArgumentsWithStarProjections", "", "createJavaSimpleType", "Lkotlin/reflect/jvm/internal/types/SimpleKType;", "type", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "mutableCollectionClass", "Lkotlin/reflect/KClass;", "createRawJavaType", "klass", "Ljava/lang/Class;", "allTypeParameters", "collectAllArguments", "Ljava/lang/reflect/ParameterizedType;", "toKTypeProjection", "kotlinContainer", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "getKotlinContainer", "(Ljava/lang/reflect/TypeVariable;)Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "findKTypeParameterInContainer", "toKTypeParameters", "", "([Ljava/lang/reflect/TypeVariable;)Ljava/util/List;", "toFlexibleArrayElementVarianceType", "Lkotlin/reflect/jvm/internal/types/FlexibleKType;", "javaType", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ConvertFromJavaKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TypeNullability.values().length];
            try {
                iArr[TypeNullability.NOT_NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TypeNullability.NULLABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List<TypeVariable<?>> allTypeParameters(Class<?> cls) {
        cls.getClass();
        return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(cls, new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromJavaKt.allTypeParameters$lambda$0((Class) obj);
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$6
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromJavaKt.allTypeParameters$lambda$1((Class) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Class allTypeParameters$lambda$0(Class cls) {
        cls.getClass();
        if (Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        return cls.getDeclaringClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Sequence allTypeParameters$lambda$1(Class cls) {
        cls.getClass();
        TypeVariable[] typeParameters = cls.getTypeParameters();
        typeParameters.getClass();
        return ArraysKt.asSequence(typeParameters);
    }

    private static final List<Type> collectAllArguments(ParameterizedType parameterizedType) {
        return SequencesKt.toList(SequencesKt.flatMapIterable(SequencesKt.generateSequence(parameterizedType, new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$7
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromJavaKt.collectAllArguments$lambda$0((ParameterizedType) obj);
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$8
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return ConvertFromJavaKt.collectAllArguments$lambda$1((ParameterizedType) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParameterizedType collectAllArguments$lambda$0(ParameterizedType parameterizedType) {
        parameterizedType.getClass();
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable collectAllArguments$lambda$1(ParameterizedType parameterizedType) {
        parameterizedType.getClass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        actualTypeArguments.getClass();
        return ArraysKt.toList(actualTypeArguments);
    }

    private static final SimpleKType createJavaSimpleType(final Type type, KClassifier kClassifier, List<KTypeProjection> list, boolean z, KClass<?> kClass) {
        return new SimpleKType(kClassifier, list, z, CollectionsKt.emptyList(), null, false, false, false, kClass, new Function0(type) { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$2
            private final Type arg$0;

            {
                this.arg$0 = type;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromJavaKt.createJavaSimpleType$lambda$0(this.arg$0);
            }
        });
    }

    public static /* synthetic */ SimpleKType createJavaSimpleType$default(Type type, KClassifier kClassifier, List list, boolean z, KClass kClass, int i, Object obj) {
        if ((i & 16) != 0) {
            kClass = null;
        }
        return createJavaSimpleType(type, kClassifier, list, z, kClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type createJavaSimpleType$lambda$0(Type type) {
        return type;
    }

    private static final KType createRawJavaType(final Class<?> cls, Map<TypeVariable<?>, ? extends KTypeParameter> map) {
        FlexibleKType.Companion companion = FlexibleKType.INSTANCE;
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
        List<TypeVariable<?>> listAllTypeParameters = allTypeParameters(cls);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAllTypeParameters, 10));
        Iterator<T> it = listAllTypeParameters.iterator();
        while (it.hasNext()) {
            Type[] bounds = ((TypeVariable) SequencesKt.last(SequencesKt.generateSequence((TypeVariable) it.next(), new Function1() { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    return ConvertFromJavaKt.createRawJavaType$lambda$0$0((TypeVariable) obj);
                }
            }))).getBounds();
            bounds.getClass();
            Type type = (Type) ArraysKt.first(bounds);
            KTypeProjection.Companion companion2 = KTypeProjection.INSTANCE;
            type.getClass();
            arrayList.add(companion2.invariant(toKType$default(type, map, null, true, 2, null)));
        }
        SimpleKType simpleKTypeCreateJavaSimpleType$default = createJavaSimpleType$default(cls, kotlinClass, arrayList, false, null, 16, null);
        KClass kotlinClass2 = JvmClassMappingKt.getKotlinClass(cls);
        List<TypeVariable<?>> listAllTypeParameters2 = allTypeParameters(cls);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAllTypeParameters2, 10));
        Iterator<T> it2 = listAllTypeParameters2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(KTypeProjection.INSTANCE.getSTAR());
        }
        return companion.create(simpleKTypeCreateJavaSimpleType$default, createJavaSimpleType$default(cls, kotlinClass2, arrayList2, true, null, 16, null), true, new Function0(cls) { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$4
            private final Class arg$0;

            {
                this.arg$0 = cls;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromJavaKt.createRawJavaType$lambda$2(this.arg$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeVariable createRawJavaType$lambda$0$0(TypeVariable typeVariable) {
        typeVariable.getClass();
        Type[] bounds = typeVariable.getBounds();
        bounds.getClass();
        Object objFirst = ArraysKt.first(bounds);
        if (objFirst instanceof TypeVariable) {
            return (TypeVariable) objFirst;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type createRawJavaType$lambda$2(Class cls) {
        return cls;
    }

    private static final KTypeParameter findKTypeParameterInContainer(TypeVariable<?> typeVariable, Map<TypeVariable<?>, ? extends KTypeParameter> map) {
        KTypeParameter kTypeParameter = map.get(typeVariable);
        if (kTypeParameter != null) {
            return kTypeParameter;
        }
        Iterator<T> it = getKotlinContainer(typeVariable).getTypeParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (Intrinsics.areEqual(((KTypeParameter) next).getName(), typeVariable.getName())) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        KTypeParameter kTypeParameter2 = (KTypeParameter) obj;
        if (kTypeParameter2 != null) {
            return kTypeParameter2;
        }
        throw new KotlinReflectionInternalError("Type parameter " + typeVariable.getName() + " is not found in " + getKotlinContainer(typeVariable));
    }

    private static final KTypeParameterOwnerImpl getKotlinContainer(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (!(genericDeclaration instanceof Class)) {
            Events$$ExternalSyntheticBUOutline0.m$1("Non-class container of a type parameter is not supported: ", genericDeclaration, " (", typeVariable);
            return null;
        }
        KClass kotlinClass = JvmClassMappingKt.getKotlinClass((Class) genericDeclaration);
        kotlinClass.getClass();
        return (KClassImpl) kotlinClass;
    }

    private static final FlexibleKType toFlexibleArrayElementVarianceType(SimpleKType simpleKType, final Type type) {
        KTypeProjection kTypeProjectionCovariant;
        FlexibleKType.Companion companion = FlexibleKType.INSTANCE;
        KClassifier classifier = simpleKType.getClassifier();
        List<KTypeProjection> arguments = simpleKType.getArguments();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        for (KTypeProjection kTypeProjection : arguments) {
            KType type2 = kTypeProjection.getType();
            if (type2 != null && (kTypeProjectionCovariant = KTypeProjection.INSTANCE.covariant(type2)) != null) {
                kTypeProjection = kTypeProjectionCovariant;
            }
            arrayList.add(kTypeProjection);
        }
        AbstractKType abstractKTypeCreate = companion.create(simpleKType, createJavaSimpleType$default(type, classifier, arrayList, true, null, 16, null), false, new Function0(type) { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$9
            private final Type arg$0;

            {
                this.arg$0 = type;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromJavaKt.toFlexibleArrayElementVarianceType$lambda$1(this.arg$0);
            }
        });
        abstractKTypeCreate.getClass();
        return (FlexibleKType) abstractKTypeCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type toFlexibleArrayElementVarianceType$lambda$1(Type type) {
        return type;
    }

    public static final KType toKType(Type type, Map<TypeVariable<?>, ? extends KTypeParameter> map, TypeNullability typeNullability, boolean z) {
        final Type type2;
        AbstractKType abstractKTypeCreateJavaSimpleType$default;
        ArrayList arrayList;
        String qualifiedName;
        type.getClass();
        map.getClass();
        typeNullability.getClass();
        FqNameUnsafe fqNameUnsafe = null;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!allTypeParameters(cls).isEmpty() && !z) {
                return createRawJavaType(cls, map);
            }
            if (cls.isArray()) {
                KClass kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
                Class<?> componentType = cls.getComponentType();
                componentType.getClass();
                return toFlexibleArrayElementVarianceType(createJavaSimpleType$default(type, kotlinClass, CollectionsKt.listOf(toKTypeProjection(componentType, map)), false, null, 16, null), type);
            }
            type2 = type;
            KClass kotlinClass2 = JvmClassMappingKt.getKotlinClass(cls);
            List<TypeVariable<?>> listAllTypeParameters = allTypeParameters(cls);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAllTypeParameters, 10));
            Iterator<T> it = listAllTypeParameters.iterator();
            while (it.hasNext()) {
                arrayList2.add(KTypeProjection.INSTANCE.getSTAR());
            }
            abstractKTypeCreateJavaSimpleType$default = createJavaSimpleType$default(type2, kotlinClass2, arrayList2, false, null, 16, null);
        } else {
            type2 = type;
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                genericComponentType.getClass();
                KTypeProjection kTypeProjection = toKTypeProjection(genericComponentType, map);
                KType type3 = kTypeProjection.getType();
                type3.getClass();
                return toFlexibleArrayElementVarianceType(createJavaSimpleType$default(type2, JvmClassMappingKt.getKotlinClass(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(type3)))), CollectionsKt.listOf(kTypeProjection), false, null, 16, null), type2);
            }
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type2;
                Type rawType = parameterizedType.getRawType();
                rawType.getClass();
                KClass kotlinClass3 = JvmClassMappingKt.getKotlinClass((Class) rawType);
                if (z) {
                    List<Type> listCollectAllArguments = collectAllArguments(parameterizedType);
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listCollectAllArguments, 10));
                    for (Type type4 : listCollectAllArguments) {
                        arrayList3.add(KTypeProjection.INSTANCE.getSTAR());
                    }
                    arrayList = arrayList3;
                } else {
                    List<Type> listCollectAllArguments2 = collectAllArguments(parameterizedType);
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listCollectAllArguments2, 10));
                    Iterator<T> it2 = listCollectAllArguments2.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(toKTypeProjection((Type) it2.next(), map));
                    }
                    arrayList = arrayList4;
                }
                abstractKTypeCreateJavaSimpleType$default = createJavaSimpleType$default(type2, kotlinClass3, arrayList, false, null, 16, null);
            } else {
                if (!(type2 instanceof TypeVariable)) {
                    if (type2 instanceof WildcardType) {
                        Events$$ExternalSyntheticBUOutline0.m$1("Wildcard type is not possible here: ", type2);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("Type is not supported: ");
                    sb.append(type2);
                    Class<?> cls2 = type2.getClass();
                    sb.append(" (");
                    sb.append(cls2);
                    sb.append(')');
                    throw new KotlinReflectionInternalError(sb.toString());
                }
                abstractKTypeCreateJavaSimpleType$default = createJavaSimpleType$default(type2, findKTypeParameterInContainer((TypeVariable) type2, map), CollectionsKt.emptyList(), false, null, 16, null);
            }
        }
        KClassifier classifier = abstractKTypeCreateJavaSimpleType$default.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
        if (kClass != null && (qualifiedName = kClass.getQualifiedName()) != null) {
            fqNameUnsafe = new FqNameUnsafe(qualifiedName);
        }
        FqName onlyToMutable = javaToKotlinClassMap.readOnlyToMutable(fqNameUnsafe);
        if (onlyToMutable != null && kClass != null) {
            abstractKTypeCreateJavaSimpleType$default = FlexibleKType.INSTANCE.create(createJavaSimpleType(type2, abstractKTypeCreateJavaSimpleType$default.getClassifier(), abstractKTypeCreateJavaSimpleType$default.getArguments(), abstractKTypeCreateJavaSimpleType$default.getIsMarkedNullable(), MutableCollectionKClassKt.getMutableCollectionKClass(onlyToMutable, kClass)), abstractKTypeCreateJavaSimpleType$default, false, new Function0(type2) { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$0
                private final Type arg$0;

                {
                    this.arg$0 = type2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return ConvertFromJavaKt.toKType$lambda$3$0(this.arg$0);
                }
            });
        }
        int i = WhenMappings.$EnumSwitchMapping$0[typeNullability.ordinal()];
        if (i == 1) {
            return abstractKTypeCreateJavaSimpleType$default;
        }
        if (i == 2) {
            return abstractKTypeCreateJavaSimpleType$default.makeNullableAsSpecified(true);
        }
        FlexibleKType.Companion companion = FlexibleKType.INSTANCE;
        AbstractKType lowerBound = abstractKTypeCreateJavaSimpleType$default.getLowerBound();
        if (lowerBound == null) {
            lowerBound = abstractKTypeCreateJavaSimpleType$default;
        }
        AbstractKType upperBound = abstractKTypeCreateJavaSimpleType$default.getUpperBound();
        if (upperBound != null) {
            abstractKTypeCreateJavaSimpleType$default = upperBound;
        }
        return companion.create(lowerBound, abstractKTypeCreateJavaSimpleType$default.makeNullableAsSpecified(true), false, new Function0(type2) { // from class: kotlin.reflect.jvm.internal.ConvertFromJavaKt$$Lambda$1
            private final Type arg$0;

            {
                this.arg$0 = type2;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return ConvertFromJavaKt.toKType$lambda$4(this.arg$0);
            }
        });
    }

    public static /* synthetic */ KType toKType$default(Type type, Map map, TypeNullability typeNullability, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            typeNullability = TypeNullability.FLEXIBLE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return toKType(type, map, typeNullability, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type toKType$lambda$3$0(Type type) {
        return type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type toKType$lambda$4(Type type) {
        return type;
    }

    public static final List<KTypeParameter> toKTypeParameters(TypeVariable<?>[] typeVariableArr) {
        typeVariableArr.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeVariableArr.length), 16));
        for (TypeVariable<?> typeVariable : typeVariableArr) {
            KTypeParameterOwnerImpl kotlinContainer = getKotlinContainer(typeVariable);
            String name = typeVariable.getName();
            name.getClass();
            linkedHashMap.put(typeVariable, new KTypeParameterImpl(kotlinContainer, name, KVariance.INVARIANT, false));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            TypeVariable typeVariable2 = (TypeVariable) entry.getKey();
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) entry.getValue();
            Type[] bounds = typeVariable2.getBounds();
            bounds.getClass();
            ArrayList arrayList = new ArrayList(bounds.length);
            for (Type type : bounds) {
                type.getClass();
                arrayList.add(toKType$default(type, linkedHashMap, null, false, 6, null));
            }
            kTypeParameterImpl.setUpperBounds(arrayList);
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    private static final KTypeProjection toKTypeProjection(Type type, Map<TypeVariable<?>, ? extends KTypeParameter> map) {
        if (!(type instanceof WildcardType)) {
            return KTypeProjection.INSTANCE.invariant(toKType$default(type, map, null, false, 6, null));
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] upperBounds = wildcardType.getUpperBounds();
        Type[] lowerBounds = wildcardType.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            Events$$ExternalSyntheticBUOutline0.m$1("Wildcard types with many bounds are not supported: ", type);
            return null;
        }
        if (lowerBounds.length == 1) {
            KTypeProjection.Companion companion = KTypeProjection.INSTANCE;
            Object objSingle = ArraysKt.single(lowerBounds);
            objSingle.getClass();
            return companion.contravariant(toKType$default((Type) objSingle, map, null, false, 6, null));
        }
        if (upperBounds.length != 1) {
            return KTypeProjection.INSTANCE.getSTAR();
        }
        KTypeProjection.Companion companion2 = KTypeProjection.INSTANCE;
        Object objSingle2 = ArraysKt.single(upperBounds);
        objSingle2.getClass();
        return companion2.covariant(toKType$default((Type) objSingle2, map, null, false, 6, null));
    }
}
