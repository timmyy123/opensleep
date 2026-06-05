package kotlin.reflect.full;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.types.CapturedKTypeKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\",\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\",\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000f*\u0006\u0012\u0002\b\u00030\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "createDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "base", "", "isSubclassOf", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)Z", "", "Lkotlin/reflect/KCallable;", "getDeclaredMembers", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "getDeclaredMembers$annotations", "(Lkotlin/reflect/KClass;)V", "declaredMembers", "", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "getSuperclasses$annotations", "superclasses", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KClasses {
    public static final KType createDefaultType(KClass<?> kClass) {
        kClass.getClass();
        List<KTypeParameter> listAllTypeParameters = CapturedKTypeKt.allTypeParameters(kClass);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listAllTypeParameters, 10));
        Iterator<T> it = listAllTypeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeProjection(KVariance.INVARIANT, KClassifiers.createType$default((KTypeParameter) it.next(), null, false, null, 7, null)));
        }
        return KClassifiers.createType$default(kClass, arrayList, false, null, 6, null);
    }

    public static final Collection<KCallable<?>> getDeclaredMembers(KClass<?> kClass) {
        kClass.getClass();
        return ((KClassImpl.Data) ((KClassImpl) kClass).getData().getValue()).getDeclaredMembers();
    }

    public static final List<KClass<?>> getSuperclasses(KClass<?> kClass) {
        kClass.getClass();
        List<KType> supertypes = kClass.getSupertypes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            KClassifier classifier = ((KType) it.next()).getClassifier();
            KClass kClass2 = classifier instanceof KClass ? (KClass) classifier : null;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }

    public static final boolean isSubclassOf(KClass<?> kClass, final KClass<?> kClass2) {
        kClass.getClass();
        kClass2.getClass();
        if (Intrinsics.areEqual(kClass, kClass2)) {
            return true;
        }
        List listListOf = CollectionsKt.listOf(kClass);
        final AnonymousClass1 anonymousClass1 = new PropertyReference1Impl() { // from class: kotlin.reflect.full.KClasses.isSubclassOf.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return KClasses.getSuperclasses((KClass) obj);
            }
        };
        return DFS.ifAny(listListOf, new DFS.Neighbors(anonymousClass1) { // from class: kotlin.reflect.full.KClasses$$Lambda$1
            private final KProperty1 arg$0;

            {
                this.arg$0 = anonymousClass1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public Iterable getNeighbors(Object obj) {
                return KClasses.isSubclassOf$lambda$0(this.arg$0, (KClass) obj);
            }
        }, new Function1(kClass2) { // from class: kotlin.reflect.full.KClasses$$Lambda$2
            private final KClass arg$0;

            {
                this.arg$0 = kClass2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return KClasses.isSubclassOf$lambda$1(this.arg$0, (KClass) obj);
            }
        }).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable isSubclassOf$lambda$0(KProperty1 kProperty1, KClass kClass) {
        return (Iterable) kProperty1.invoke(kClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean isSubclassOf$lambda$1(KClass kClass, KClass kClass2) {
        return Boolean.valueOf(Intrinsics.areEqual(kClass2, kClass));
    }
}
