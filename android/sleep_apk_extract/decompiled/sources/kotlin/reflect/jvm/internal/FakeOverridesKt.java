package kotlin.reflect.jvm.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.full.KTypes;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.EqualityMode;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.types.AbstractKType;
import kotlin.reflect.jvm.internal.types.KTypeSubstitutor;
import kotlin.reflect.jvm.internal.types.MutableCollectionKClass;
import kotlin.reflect.jvm.internal.types.ReflectTypeSystemContext;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001c\u0010\u0011\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a \u0010\u0013\u001a\u00020\u00122\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000\u001aX\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0019\"\b\b\u0001\u0010\u0018*\u00020\b*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00180\u000e2\u0006\u0010\u001a\u001a\u0002H\u00192\u0006\u0010\u001b\u001a\u0002H\u00182\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00180\u001dH\u0082\b¢\u0006\u0002\u0010\u001e\u001a-\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0\u000b\"\b\b\u0000\u0010**\u00020+*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010,\u001a\u0002H*H\u0002¢\u0006\u0002\u0010-\u001a\"\u00106\u001a\u0004\u0018\u000107*\b\u0012\u0004\u0012\u000209082\f\u0010:\u001a\b\u0012\u0004\u0012\u00020908H\u0002\u001a\u0014\u0010;\u001a\u00020<*\u00020<2\u0006\u0010=\u001a\u00020>H\u0002\u001a \u0010?\u001a\b\u0012\u0004\u0012\u00020<08*\b\u0012\u0004\u0012\u00020<082\u0006\u0010=\u001a\u00020>H\u0002\u001a\u0018\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020<H\u0002\"&\u0010\u001f\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020 j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002`!X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\"\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u001c\u0010$\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010#\"\u001c\u0010%\u001a\u00020\u0016*\u0006\u0012\u0002\b\u00030&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u001c\u0010.\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u00100\",\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030&8BX\u0082\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b4\u00105*8\b\u0002\u0010\t\"\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\n2\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\n*8\b\u0002\u0010\r\"\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000e2\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000e*8\b\u0002\u0010\u000f\"\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000e2\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000e¨\u0006C"}, d2 = {"getAllMembers", "", "Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "kClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "starProjectionInTopLevelTypeIsNotPossible", "", "containerForDebug", "", "MembersJavaSignatureMap", "", "Lkotlin/reflect/jvm/internal/EquatableCallableSignature;", "Lkotlin/reflect/jvm/internal/EqualityMode$JavaSignature;", "MutableMembersJavaSignatureMap", "", "MutableMembersKotlinSignatureMap", "Lkotlin/reflect/jvm/internal/EqualityMode$KotlinSignature;", "isStaticMethodInInterface", "", "skipDeclaredMember", "member", "computeFakeOverrideMembers", "Lkotlin/reflect/jvm/internal/FakeOverrideMembers;", "mergeWith", "V", "K", SDKConstants.PARAM_KEY, SDKConstants.PARAM_VALUE, "remappingFunction", "Lkotlin/Function2;", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "modalityIntersectionOverrideComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "isStatic", "(Lkotlin/reflect/jvm/internal/DescriptorKCallable;)Z", "isJavaField", "fakeOverrideMembers", "Lkotlin/reflect/KClass;", "getFakeOverrideMembers", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/jvm/internal/FakeOverrideMembers;", "toEquatableCallableSignature", "T", "Lkotlin/reflect/jvm/internal/EqualityMode;", "equalityMode", "(Lkotlin/reflect/jvm/internal/DescriptorKCallable;Lkotlin/reflect/jvm/internal/EqualityMode;)Lkotlin/reflect/jvm/internal/EquatableCallableSignature;", "isKotlin", "Ljava/lang/Class;", "(Ljava/lang/Class;)Z", "declaredDescriptorKCallableMembers", "getDeclaredDescriptorKCallableMembers$annotations", "(Lkotlin/reflect/KClass;)V", "getDeclaredDescriptorKCallableMembers", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "substitutedWith", "Lkotlin/reflect/jvm/internal/types/KTypeSubstitutor;", "", "Lkotlin/reflect/KTypeParameter;", "arguments", "coerceFlexibleTypesAndMutabilityRecursive", "Lkotlin/reflect/KType;", "memberNameForDebug", "", "sortedUpperBounds", "areEqualKTypes", "a", "b", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class FakeOverridesKt {
    private static final Comparator<DescriptorKCallable<?>> modalityIntersectionOverrideComparator = ComparisonsKt.compareBy(new Function1() { // from class: kotlin.reflect.jvm.internal.FakeOverridesKt$$Lambda$0
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return FakeOverridesKt.modalityIntersectionOverrideComparator$lambda$0((DescriptorKCallable) obj);
        }
    }, new Function1() { // from class: kotlin.reflect.jvm.internal.FakeOverridesKt$$Lambda$1
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return FakeOverridesKt.modalityIntersectionOverrideComparator$lambda$1((DescriptorKCallable) obj);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean areEqualKTypes(KType kType, KType kType2) {
        return KTypes.isSubtypeOf(kType, kType2) && KTypes.isSubtypeOf(kType2, kType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KType coerceFlexibleTypesAndMutabilityRecursive(KType kType, String str) {
        ReflectTypeSystemContext reflectTypeSystemContext = ReflectTypeSystemContext.INSTANCE;
        AbstractKType abstractKType = kType instanceof AbstractKType ? (AbstractKType) kType : null;
        if (abstractKType != null && reflectTypeSystemContext.isError(abstractKType)) {
            return kType;
        }
        KClassifier classifier = kType.getClassifier();
        if (classifier != null) {
            List<KTypeProjection> arguments = kType.getArguments();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
            for (KTypeProjection kTypeProjection : arguments) {
                KType type = kTypeProjection.getType();
                arrayList.add(KTypeProjection.copy$default(kTypeProjection, null, type != null ? coerceFlexibleTypesAndMutabilityRecursive(type, str) : null, 1, null));
            }
            return KClassifiers.createType(classifier, arrayList, false, kType.getAnnotations());
        }
        StringBuilder sb = new StringBuilder("Non-denotable parameter types are not possible. Some parameter types appear non-denotable for type '");
        sb.append(kType);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(kType.getClass());
        sb.append("' (");
        sb.append(orCreateKotlinClass);
        sb.append(") which belongs to member '");
        sb.append(str);
        sb.append('\'');
        throw new IllegalStateException(sb.toString().toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, kotlin.reflect.jvm.internal.DescriptorKCallable] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static final FakeOverrideMembers computeFakeOverrideMembers(KClassImpl<?> kClassImpl) {
        kClassImpl.getClass();
        HashMap map = new HashMap();
        ReceiverParameterDescriptor thisAsReceiverParameter = kClassImpl.getDescriptor().getThisAsReceiverParameter();
        thisAsReceiverParameter.getClass();
        boolean zIsKotlin = isKotlin(JvmClassMappingKt.getJavaClass(kClassImpl));
        HashMap map2 = new HashMap();
        if (zIsKotlin) {
            for (DescriptorKCallable<?> descriptorKCallable : getDeclaredDescriptorKCallableMembers(kClassImpl)) {
                if (!skipDeclaredMember(kClassImpl, descriptorKCallable)) {
                    map2.put(toEquatableCallableSignature(descriptorKCallable, EqualityMode.KotlinSignature.INSTANCE), descriptorKCallable);
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        for (KType kType : kClassImpl.getSupertypes()) {
            KClassifier classifier = kType.getClassifier();
            KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass == null) {
                Events$$ExternalSyntheticBUOutline0.m$2("Non-denotable supertypes are not possible. Supertype '", kType, "' appears non-denotable in class '", kClassImpl);
                return null;
            }
            KTypeSubstitutor kTypeSubstitutorCreate = KTypeSubstitutor.INSTANCE.create(kType);
            FakeOverrideMembers fakeOverrideMembers = getFakeOverrideMembers(kClass);
            z = z || fakeOverrideMembers.getContainsInheritedStatics();
            z2 = z2 || fakeOverrideMembers.getContainsPackagePrivate();
            Iterator<Map.Entry<EquatableCallableSignature<EqualityMode.JavaSignature>, DescriptorKCallable<?>>> it = fakeOverrideMembers.getMembers().entrySet().iterator();
            while (it.hasNext()) {
                DescriptorKCallable<?> value = it.next().getValue();
                ?? ShallowCopy$kotlin_reflection = value.shallowCopy$kotlin_reflection(KCallableOverriddenStorage.copy$default(value.getOverriddenStorage(), isStatic(value) ? null : thisAsReceiverParameter, value.getOverriddenStorage().getTypeSubstitutor().combinedWith(kTypeSubstitutorCreate), null, true, false, false, false, false, 244, null));
                EquatableCallableSignature equatableCallableSignature = toEquatableCallableSignature(ShallowCopy$kotlin_reflection, EqualityMode.KotlinSignature.INSTANCE);
                if (!map2.containsKey(equatableCallableSignature)) {
                    EquatableCallableSignature equatableCallableSignatureWithEqualityMode = equatableCallableSignature.withEqualityMode(EqualityMode.JavaSignature.INSTANCE);
                    Object obj = map.get(equatableCallableSignatureWithEqualityMode);
                    if (obj != null) {
                        KAnnotatedElement kAnnotatedElement = (DescriptorKCallable) obj;
                        DescriptorKCallable descriptorKCallableShallowCopy$kotlin_reflection = (DescriptorKCallable) ComparisonsKt.minOf(kAnnotatedElement, ShallowCopy$kotlin_reflection, CovariantOverrideComparator.INSTANCE);
                        if ((kAnnotatedElement instanceof KFunction) && (ShallowCopy$kotlin_reflection instanceof KFunction)) {
                            KFunction kFunction = (KFunction) kAnnotatedElement;
                            descriptorKCallableShallowCopy$kotlin_reflection = descriptorKCallableShallowCopy$kotlin_reflection.shallowCopy$kotlin_reflection(KCallableOverriddenStorage.copy$default(descriptorKCallableShallowCopy$kotlin_reflection.getOverriddenStorage(), null, null, ((DescriptorKCallable) ComparisonsKt.minOf(kAnnotatedElement, ShallowCopy$kotlin_reflection, modalityIntersectionOverrideComparator)).getModality$kotlin_reflection(), false, kFunction.isExternal() || ((KFunction) ShallowCopy$kotlin_reflection).isExternal(), kFunction.isOperator() || ((KFunction) ShallowCopy$kotlin_reflection).isOperator(), kFunction.isInfix() || ((KFunction) ShallowCopy$kotlin_reflection).isInfix(), kFunction.isInline() || ((KFunction) ShallowCopy$kotlin_reflection).isInline(), 11, null));
                        }
                        if (descriptorKCallableShallowCopy$kotlin_reflection != null) {
                            ShallowCopy$kotlin_reflection = descriptorKCallableShallowCopy$kotlin_reflection;
                        }
                    }
                    map.put(equatableCallableSignatureWithEqualityMode, ShallowCopy$kotlin_reflection);
                }
            }
        }
        for (Map.Entry entry : map2.entrySet()) {
            EquatableCallableSignature equatableCallableSignature2 = (EquatableCallableSignature) entry.getKey();
            DescriptorKCallable descriptorKCallable2 = (DescriptorKCallable) entry.getValue();
            z = z || isStatic(descriptorKCallable2);
            z2 = z2 || descriptorKCallable2.isPackagePrivate$kotlin_reflection();
            map.put(equatableCallableSignature2.withEqualityMode(EqualityMode.JavaSignature.INSTANCE), descriptorKCallable2);
        }
        if (!zIsKotlin) {
            for (DescriptorKCallable<?> descriptorKCallable3 : getDeclaredDescriptorKCallableMembers(kClassImpl)) {
                if (!skipDeclaredMember(kClassImpl, descriptorKCallable3)) {
                    z = z || isStatic(descriptorKCallable3);
                    z2 = z2 || descriptorKCallable3.isPackagePrivate$kotlin_reflection();
                    map.put(toEquatableCallableSignature(descriptorKCallable3, EqualityMode.JavaSignature.INSTANCE), descriptorKCallable3);
                }
            }
        }
        return new FakeOverrideMembers(map, z, z2);
    }

    public static final Collection<DescriptorKCallable<?>> getAllMembers(KClassImpl<?> kClassImpl) {
        HashMap map;
        kClassImpl.getClass();
        FakeOverrideMembers fakeOverrideMembers$kotlin_reflection = kClassImpl.getData().getValue().getFakeOverrideMembers$kotlin_reflection();
        boolean zIsKotlin = isKotlin(JvmClassMappingKt.getJavaClass(kClassImpl));
        boolean z = fakeOverrideMembers$kotlin_reflection.getContainsInheritedStatics() && kClassImpl.getClassKind$kotlin_reflection() != ClassKind.ENUM_CLASS && zIsKotlin;
        boolean z2 = fakeOverrideMembers$kotlin_reflection.getContainsPackagePrivate() || z;
        if (z2) {
            Map<EquatableCallableSignature<EqualityMode.JavaSignature>, DescriptorKCallable<?>> members = fakeOverrideMembers$kotlin_reflection.getMembers();
            map = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(fakeOverrideMembers$kotlin_reflection.getMembers().size());
            for (Map.Entry<EquatableCallableSignature<EqualityMode.JavaSignature>, DescriptorKCallable<?>> entry : members.entrySet()) {
                DescriptorKCallable<?> value = entry.getValue();
                if (!z || !isStatic(value)) {
                    if (!value.isPackagePrivate$kotlin_reflection() || Intrinsics.areEqual(value.getContainer().getJClass().getPackage(), JvmClassMappingKt.getJavaClass(kClassImpl).getPackage())) {
                        map.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } else {
            if (z2) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            map = new HashMap(fakeOverrideMembers$kotlin_reflection.getMembers());
        }
        HashMap map2 = new HashMap();
        for (DescriptorKCallable<?> descriptorKCallable : getDeclaredDescriptorKCallableMembers(kClassImpl)) {
            if (isStaticMethodInInterface(descriptorKCallable, kClassImpl)) {
                if (zIsKotlin) {
                    throw new IllegalStateException(("Kotlin doesn't have statics. '" + descriptorKCallable.getName() + "' appears to be declared static member in '" + kClassImpl.getSimpleName() + '\'').toString());
                }
                map.put(toEquatableCallableSignature(descriptorKCallable, EqualityMode.JavaSignature.INSTANCE), descriptorKCallable);
            } else if (descriptorKCallable.getVisibility() == KVisibility.PRIVATE) {
                if (zIsKotlin) {
                    map2.put(toEquatableCallableSignature(descriptorKCallable, EqualityMode.KotlinSignature.INSTANCE), descriptorKCallable);
                } else {
                    map.put(toEquatableCallableSignature(descriptorKCallable, EqualityMode.JavaSignature.INSTANCE), descriptorKCallable);
                }
            }
        }
        Collection collectionValues = map.values();
        collectionValues.getClass();
        return CollectionsKt.plus(collectionValues, (Iterable) map2.values());
    }

    private static final Collection<DescriptorKCallable<?>> getDeclaredDescriptorKCallableMembers(KClass<?> kClass) {
        Collection declaredMembers = KClasses.getDeclaredMembers(kClass);
        declaredMembers.getClass();
        return declaredMembers;
    }

    private static final FakeOverrideMembers getFakeOverrideMembers(KClass<?> kClass) {
        if (kClass instanceof KClassImpl) {
            return ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getFakeOverrideMembers$kotlin_reflection();
        }
        if (kClass instanceof MutableCollectionKClass) {
            return getFakeOverrideMembers(((MutableCollectionKClass) kClass).getKlass());
        }
        FacebookSdk$$ExternalSyntheticLambda1.m$2("Unknown type ", Reflection.getOrCreateKotlinClass(kClass.getClass()));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final boolean isJavaField(DescriptorKCallable<?> descriptorKCallable) {
        Field javaField;
        Class<?> declaringClass;
        return (!(descriptorKCallable instanceof KProperty) || (javaField = ReflectJvmMapping.getJavaField((KProperty) descriptorKCallable)) == null || (declaringClass = javaField.getDeclaringClass()) == null || isKotlin(declaringClass)) ? false : true;
    }

    public static final boolean isKotlin(Class<?> cls) {
        cls.getClass();
        return cls.getAnnotation(Metadata.class) != null;
    }

    public static final boolean isStatic(DescriptorKCallable<?> descriptorKCallable) {
        descriptorKCallable.getClass();
        return UtilKt.getInstanceReceiverParameter(descriptorKCallable) == null;
    }

    private static final boolean isStaticMethodInInterface(DescriptorKCallable<?> descriptorKCallable, KClassImpl<?> kClassImpl) {
        return isStatic(descriptorKCallable) && kClassImpl.getClassKind$kotlin_reflection() == ClassKind.INTERFACE && !isJavaField(descriptorKCallable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable modalityIntersectionOverrideComparator$lambda$0(DescriptorKCallable descriptorKCallable) {
        Class javaClass;
        descriptorKCallable.getClass();
        ClassBasedDeclarationContainer container = descriptorKCallable.getContainer();
        KClass kClass = container instanceof KClass ? (KClass) container : null;
        boolean z = false;
        if (kClass != null && (javaClass = JvmClassMappingKt.getJavaClass(kClass)) != null && javaClass.isInterface()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable modalityIntersectionOverrideComparator$lambda$1(DescriptorKCallable descriptorKCallable) {
        descriptorKCallable.getClass();
        return Boolean.valueOf(Intrinsics.areEqual(descriptorKCallable.getContainer(), Reflection.getOrCreateKotlinClass(Object.class)));
    }

    private static final boolean skipDeclaredMember(KClassImpl<?> kClassImpl, DescriptorKCallable<?> descriptorKCallable) {
        return descriptorKCallable.getVisibility() == KVisibility.PRIVATE || isStaticMethodInInterface(descriptorKCallable, kClassImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<KType> sortedUpperBounds(List<? extends KType> list, final String str) {
        return CollectionsKt.sortedWith(list, new Comparator() { // from class: kotlin.reflect.jvm.internal.FakeOverridesKt$sortedUpperBounds$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Class<?> cls;
                String name;
                String name2;
                KClassifier classifier = ((KType) t).getClassifier();
                if (classifier == null) {
                    throw new IllegalStateException(("Upper bounds are always denotable. Upper bounds appear non-denotable for member: '" + str + '\'').toString());
                }
                if (classifier instanceof KClass) {
                    name = JvmClassMappingKt.getJavaClass((KClass) classifier).getName();
                } else {
                    if (!(classifier instanceof KTypeParameter)) {
                        cls = classifier.getClass();
                        FacebookSdk$$ExternalSyntheticLambda1.m$2("Unknown upper bound classifier: ", Reflection.getOrCreateKotlinClass(cls));
                        return 0;
                    }
                    name = ((KTypeParameter) classifier).getName();
                }
                KClassifier classifier2 = ((KType) t2).getClassifier();
                if (classifier2 == null) {
                    throw new IllegalStateException(("Upper bounds are always denotable. Upper bounds appear non-denotable for member: '" + str + '\'').toString());
                }
                if (classifier2 instanceof KClass) {
                    name2 = JvmClassMappingKt.getJavaClass((KClass) classifier2).getName();
                } else {
                    if (!(classifier2 instanceof KTypeParameter)) {
                        cls = classifier2.getClass();
                        FacebookSdk$$ExternalSyntheticLambda1.m$2("Unknown upper bound classifier: ", Reflection.getOrCreateKotlinClass(cls));
                        return 0;
                    }
                    name2 = ((KTypeParameter) classifier2).getName();
                }
                return ComparisonsKt.compareValues(name, name2);
            }
        });
    }

    public static final Void starProjectionInTopLevelTypeIsNotPossible(Object obj) {
        obj.getClass();
        throw new IllegalStateException(("Star projection in top level type is not possible. Star projection appeared in the following container: '" + obj + '\'').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KTypeSubstitutor substitutedWith(List<? extends KTypeParameter> list, List<? extends KTypeParameter> list2) {
        if (list.size() != list2.size()) {
            return null;
        }
        if (list2.isEmpty() || list.isEmpty()) {
            return KTypeSubstitutor.INSTANCE.getEMPTY();
        }
        List<Pair> listZip = CollectionsKt.zip(list, list2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) listZip, 10, 16));
        for (Pair pair : listZip) {
            Pair pair2 = new Pair((KTypeParameter) pair.component1(), KTypeProjection.INSTANCE.invariant(KClassifiers.createType$default((KTypeParameter) pair.component2(), null, false, null, 7, null)));
            linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
        }
        return new KTypeSubstitutor(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T extends EqualityMode> EquatableCallableSignature<T> toEquatableCallableSignature(DescriptorKCallable<?> descriptorKCallable, T t) {
        SignatureKind signatureKind;
        List<KParameter> parameters = descriptorKCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() != KParameter.Kind.INSTANCE) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((KParameter) it.next()).getType());
        }
        if (isJavaField(descriptorKCallable)) {
            signatureKind = SignatureKind.FIELD_IN_JAVA_CLASS;
        } else if (descriptorKCallable instanceof KProperty) {
            signatureKind = SignatureKind.PROPERTY;
        } else {
            if (!(descriptorKCallable instanceof KFunction)) {
                FacebookSdk$$ExternalSyntheticLambda1.m$2("Unknown kind for ", Reflection.getOrCreateKotlinClass(descriptorKCallable.getClass()));
                return null;
            }
            signatureKind = SignatureKind.FUNCTION;
        }
        SignatureKind signatureKind2 = signatureKind;
        KFunction kFunction = descriptorKCallable instanceof KFunction ? (KFunction) descriptorKCallable : null;
        Method javaMethod = kFunction != null ? ReflectJvmMapping.getJavaMethod(kFunction) : null;
        Type[] genericParameterTypes = javaMethod != null ? javaMethod.getGenericParameterTypes() : null;
        if (genericParameterTypes == null) {
            genericParameterTypes = new Type[0];
        }
        List list = ArraysKt.toList(genericParameterTypes);
        Class<?>[] parameterTypes = javaMethod != null ? javaMethod.getParameterTypes() : null;
        if (parameterTypes == null) {
            parameterTypes = new Class[0];
        }
        List list2 = ArraysKt.toList(parameterTypes);
        return new EquatableCallableSignature<>(signatureKind2, descriptorKCallable.getName(), javaMethod != null ? javaMethod.getName() : null, descriptorKCallable.getTypeParameters(), arrayList2, list2, list, isStatic(descriptorKCallable), t);
    }
}
