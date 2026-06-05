package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeEnhancementUtilsKt {
    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers javaTypeQualifiers, Collection<JavaTypeQualifiers> collection, boolean z, boolean z2, boolean z3) {
        NullabilityQualifier nullabilityQualifierSelect;
        boolean z4;
        MutabilityQualifier mutabilityQualifier;
        javaTypeQualifiers.getClass();
        collection.getClass();
        Collection<JavaTypeQualifiers> collection2 = collection;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            NullabilityQualifier nullabilityForErrors = getNullabilityForErrors((JavaTypeQualifiers) it.next());
            if (nullabilityForErrors != null) {
                arrayList.add(nullabilityForErrors);
            }
        }
        NullabilityQualifier nullabilityQualifierSelect2 = select(CollectionsKt.toSet(arrayList), getNullabilityForErrors(javaTypeQualifiers), z);
        if (nullabilityQualifierSelect2 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = collection2.iterator();
            while (it2.hasNext()) {
                NullabilityQualifier nullability = ((JavaTypeQualifiers) it2.next()).getNullability();
                if (nullability != null) {
                    arrayList2.add(nullability);
                }
            }
            nullabilityQualifierSelect = select(CollectionsKt.toSet(arrayList2), javaTypeQualifiers.getNullability(), z);
        } else {
            nullabilityQualifierSelect = nullabilityQualifierSelect2;
        }
        NullabilityQualifier nullabilityQualifier = (nullabilityQualifierSelect == null || z3 || (z2 && nullabilityQualifierSelect == NullabilityQualifier.NULLABLE)) ? null : nullabilityQualifierSelect;
        boolean z5 = nullabilityQualifier != null && nullabilityQualifierSelect2 == null;
        if (nullabilityQualifier == NullabilityQualifier.NOT_NULL) {
            if (!isDefinitelyNotNullAndSameSeverity(javaTypeQualifiers, z5)) {
                if (!collection2.isEmpty()) {
                    Iterator<T> it3 = collection2.iterator();
                    while (it3.hasNext()) {
                        if (isDefinitelyNotNullAndSameSeverity((JavaTypeQualifiers) it3.next(), z5)) {
                        }
                    }
                }
                z4 = false;
            }
            z4 = true;
            break;
        }
        z4 = false;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it4 = collection2.iterator();
        while (it4.hasNext()) {
            MutabilityQualifier mutabilityForErrors = getMutabilityForErrors((JavaTypeQualifiers) it4.next());
            if (mutabilityForErrors != null) {
                arrayList3.add(mutabilityForErrors);
            }
        }
        MutabilityQualifier mutabilityQualifier2 = (MutabilityQualifier) select(CollectionsKt.toSet(arrayList3), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, getMutabilityForErrors(javaTypeQualifiers), z);
        if (mutabilityQualifier2 == null) {
            ArrayList arrayList4 = new ArrayList();
            Iterator<T> it5 = collection2.iterator();
            while (it5.hasNext()) {
                MutabilityQualifier mutability = ((JavaTypeQualifiers) it5.next()).getMutability();
                if (mutability != null) {
                    arrayList4.add(mutability);
                }
            }
            mutabilityQualifier = (MutabilityQualifier) select(CollectionsKt.toSet(arrayList4), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, javaTypeQualifiers.getMutability(), z);
        } else {
            mutabilityQualifier = mutabilityQualifier2;
        }
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z4, z5, mutabilityQualifier != null && mutabilityQualifier2 == null);
    }

    private static final MutabilityQualifier getMutabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isMutabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getMutability();
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        typeSystemCommonBackendContext.getClass();
        kotlinTypeMarker.getClass();
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        fqName.getClass();
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, fqName);
    }

    private static final boolean isDefinitelyNotNullAndSameSeverity(JavaTypeQualifiers javaTypeQualifiers, boolean z) {
        return javaTypeQualifiers.isNullabilityQualifierForWarning() == z && javaTypeQualifiers.getDefinitelyNotNull();
    }

    private static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set<? extends T> set2;
        if (!z) {
            if (t3 != null && (set2 = CollectionsKt.toSet(SetsKt.plus(set, t3))) != null) {
                set = set2;
            }
            return (T) CollectionsKt.singleOrNull(set);
        }
        T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
        if (Intrinsics.areEqual(t4, t) && Intrinsics.areEqual(t3, t2)) {
            return null;
        }
        return t3 == null ? t4 : t3;
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.FORCE_FLEXIBILITY;
        return nullabilityQualifier == nullabilityQualifier2 ? nullabilityQualifier2 : (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }
}
