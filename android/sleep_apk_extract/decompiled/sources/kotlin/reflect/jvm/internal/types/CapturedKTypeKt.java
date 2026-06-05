package kotlin.reflect.jvm.internal.types;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"captureKTypeFromArguments", "Lkotlin/reflect/KType;", "type", "allTypeParameters", "", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KClass;", "javaTypeNotSupported", "", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class CapturedKTypeKt {
    public static final List<KTypeParameter> allTypeParameters(KClass<?> kClass) {
        kClass.getClass();
        return SequencesKt.toList(SequencesKt.flatMapIterable(SequencesKt.generateSequence(kClass, new Function1() { // from class: kotlin.reflect.jvm.internal.types.CapturedKTypeKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return CapturedKTypeKt.allTypeParameters$lambda$0((KClass) obj);
            }
        }), new Function1() { // from class: kotlin.reflect.jvm.internal.types.CapturedKTypeKt$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return CapturedKTypeKt.allTypeParameters$lambda$1((KClass) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KClass allTypeParameters$lambda$0(KClass kClass) {
        Class<?> declaringClass;
        kClass.getClass();
        if (!kClass.isInner() || (declaringClass = JvmClassMappingKt.getJavaClass(kClass).getDeclaringClass()) == null) {
            return null;
        }
        return JvmClassMappingKt.getKotlinClass(declaringClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable allTypeParameters$lambda$1(KClass kClass) {
        kClass.getClass();
        return kClass.getTypeParameters();
    }

    public static final KType captureKTypeFromArguments(KType kType) {
        int i;
        kType.getClass();
        KClassifier classifier = kType.getClassifier();
        KClass<?> kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass != null) {
            List<KTypeProjection> arguments = kType.getArguments();
            List<KTypeProjection> list = arguments;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((KTypeProjection) it.next()).getVariance() != KVariance.INVARIANT) {
                        List<KTypeParameter> listAllTypeParameters = allTypeParameters(kClass);
                        if (listAllTypeParameters.size() == arguments.size()) {
                            List<KTypeProjection> list2 = arguments;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            Iterator<T> it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                KTypeProjection kTypeProjectionInvariant = (KTypeProjection) it2.next();
                                if (kTypeProjectionInvariant.getVariance() != KVariance.INVARIANT) {
                                    KType type = kTypeProjectionInvariant.getType();
                                    if (kTypeProjectionInvariant.getVariance() != KVariance.IN) {
                                        type = null;
                                    }
                                    kTypeProjectionInvariant = KTypeProjection.INSTANCE.invariant(new CapturedKType(type, new CapturedKTypeConstructor(kTypeProjectionInvariant), false));
                                }
                                arrayList.add(kTypeProjectionInvariant);
                            }
                            KTypeSubstitutor kTypeSubstitutorCreate = KTypeSubstitutor.INSTANCE.create(kClass, arrayList, false);
                            int size = arguments.size();
                            for (i = 0; i < size; i++) {
                                KTypeProjection kTypeProjection = arguments.get(i);
                                if (kTypeProjection.getVariance() != KVariance.INVARIANT) {
                                    List<KType> upperBounds = listAllTypeParameters.get(i).getUpperBounds();
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator<T> it3 = upperBounds.iterator();
                                    while (it3.hasNext()) {
                                        KType type2 = KTypeSubstitutor.substitute$default(kTypeSubstitutorCreate, (KType) it3.next(), null, 2, null).getType();
                                        type2.getClass();
                                        arrayList2.add(type2);
                                    }
                                    if (kTypeProjection.getVariance() == KVariance.OUT) {
                                        KType type3 = kTypeProjection.getType();
                                        type3.getClass();
                                        arrayList2.add(type3);
                                    }
                                    KType type4 = ((KTypeProjection) arrayList.get(i)).getType();
                                    type4.getClass();
                                    ((CapturedKType) type4).getTypeConstructor().setSupertypes(arrayList2);
                                }
                            }
                            boolean isMarkedNullable = kType.getIsMarkedNullable();
                            List<Annotation> annotations = kType.getAnnotations();
                            boolean z = kType instanceof AbstractKType;
                            AbstractKType abstractKType = z ? (AbstractKType) kType : null;
                            KType abbreviation = abstractKType != null ? abstractKType.getAbbreviation() : null;
                            AbstractKType abstractKType2 = z ? (AbstractKType) kType : null;
                            return new SimpleKType(kClass, arrayList, isMarkedNullable, annotations, abbreviation, false, false, false, abstractKType2 != null ? abstractKType2.getMutableCollectionClass() : null, null, 512, null);
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void javaTypeNotSupported() {
        throw new KotlinReflectionInternalError("javaType for captured types is not supported");
    }
}
