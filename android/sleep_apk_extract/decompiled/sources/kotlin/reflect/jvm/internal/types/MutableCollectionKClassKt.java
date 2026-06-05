package kotlin.reflect.jvm.internal.types;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.full.KClassifiers;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.StandardKTypes;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001a\u0015\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005\"\u0006\b\u0000\u0010\u0007\u0018\u0001H\u0082\b¨\u0006\b"}, d2 = {"getMutableCollectionKClass", "Lkotlin/reflect/jvm/internal/types/MutableCollectionKClass;", "mutableFqName", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "readonlyKClass", "Lkotlin/reflect/KClass;", "mutableClassOf", "T", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class MutableCollectionKClassKt {
    public static final MutableCollectionKClass<?> getMutableCollectionKClass(final FqName fqName, final KClass<?> kClass) {
        fqName.getClass();
        kClass.getClass();
        return new MutableCollectionKClass<>(kClass, fqName.asString(), new Function1(kClass, fqName) { // from class: kotlin.reflect.jvm.internal.types.MutableCollectionKClassKt$$Lambda$0
            private final KClass arg$0;
            private final FqName arg$1;

            {
                this.arg$0 = kClass;
                this.arg$1 = fqName;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return MutableCollectionKClassKt.getMutableCollectionKClass$lambda$0(this.arg$0, this.arg$1, (MutableCollectionKClass) obj);
            }
        }, new Function1(fqName, kClass) { // from class: kotlin.reflect.jvm.internal.types.MutableCollectionKClassKt$$Lambda$1
            private final FqName arg$0;
            private final KClass arg$1;

            {
                this.arg$0 = fqName;
                this.arg$1 = kClass;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return MutableCollectionKClassKt.getMutableCollectionKClass$lambda$1(this.arg$0, this.arg$1, (MutableCollectionKClass) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getMutableCollectionKClass$lambda$0(KClass kClass, FqName fqName, MutableCollectionKClass mutableCollectionKClass) {
        mutableCollectionKClass.getClass();
        List<KTypeParameter> typeParameters = kClass.getTypeParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            KTypeParameterImpl kTypeParameterImpl = new KTypeParameterImpl(mutableCollectionKClass, ((KTypeParameter) it.next()).getName(), (Intrinsics.areEqual(fqName, StandardNames.FqNames.mutableIterable) || Intrinsics.areEqual(fqName, StandardNames.FqNames.mutableIterator)) ? KVariance.OUT : KVariance.INVARIANT, false);
            kTypeParameterImpl.setUpperBounds(CollectionsKt.listOf(StandardKTypes.INSTANCE.getNULLABLE_ANY()));
            arrayList.add(kTypeParameterImpl);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2 A[LOOP:0: B:31:0x00cc->B:33:0x00d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010e A[LOOP:1: B:35:0x0108->B:37:0x010e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List getMutableCollectionKClass$lambda$1(FqName fqName, KClass kClass, MutableCollectionKClass mutableCollectionKClass) {
        KClass<?> mutableCollectionClass;
        Iterator<T> it;
        Iterator it2;
        mutableCollectionKClass.getClass();
        KClass<?> kClass2 = null;
        if (Intrinsics.areEqual(fqName, StandardNames.FqNames.mutableCollection)) {
            KType kTypeMutableCollectionType = Reflection.mutableCollectionType(Reflection.typeOf(Iterable.class, KTypeProjection.INSTANCE.getSTAR()));
            kTypeMutableCollectionType.getClass();
            mutableCollectionClass = ((AbstractKType) kTypeMutableCollectionType).getMutableCollectionClass();
            if (mutableCollectionClass == null) {
                Events$$ExternalSyntheticBUOutline0.m$2("No mutable collection class found: ", Reflection.getOrCreateKotlinClass(Iterable.class));
                return null;
            }
        } else if (Intrinsics.areEqual(fqName, StandardNames.FqNames.mutableList)) {
            KType kTypeMutableCollectionType2 = Reflection.mutableCollectionType(Reflection.typeOf(Collection.class, KTypeProjection.INSTANCE.getSTAR()));
            kTypeMutableCollectionType2.getClass();
            mutableCollectionClass = ((AbstractKType) kTypeMutableCollectionType2).getMutableCollectionClass();
            if (mutableCollectionClass == null) {
                Events$$ExternalSyntheticBUOutline0.m$2("No mutable collection class found: ", Reflection.getOrCreateKotlinClass(Collection.class));
                return null;
            }
        } else {
            if (!Intrinsics.areEqual(fqName, StandardNames.FqNames.mutableSet)) {
                if (Intrinsics.areEqual(fqName, StandardNames.FqNames.mutableListIterator)) {
                    KType kTypeMutableCollectionType3 = Reflection.mutableCollectionType(Reflection.typeOf(Iterator.class, KTypeProjection.INSTANCE.getSTAR()));
                    kTypeMutableCollectionType3.getClass();
                    mutableCollectionClass = ((AbstractKType) kTypeMutableCollectionType3).getMutableCollectionClass();
                    if (mutableCollectionClass == null) {
                        Events$$ExternalSyntheticBUOutline0.m$2("No mutable collection class found: ", Reflection.getOrCreateKotlinClass(Iterator.class));
                        return null;
                    }
                }
                List<KTypeParameter> typeParameters = mutableCollectionKClass.getTypeParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters, 10));
                it = typeParameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(KTypeProjection.INSTANCE.invariant(KClassifiers.createType$default((KTypeParameter) it.next(), null, false, null, 7, null)));
                }
                List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new KClass[]{kClass, kClass2});
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOfNotNull, 10));
                it2 = listListOfNotNull.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(KClassifiers.createType$default((KClass) it2.next(), arrayList, false, null, 6, null));
                }
                return arrayList2;
            }
            KType kTypeMutableCollectionType4 = Reflection.mutableCollectionType(Reflection.typeOf(Collection.class, KTypeProjection.INSTANCE.getSTAR()));
            kTypeMutableCollectionType4.getClass();
            mutableCollectionClass = ((AbstractKType) kTypeMutableCollectionType4).getMutableCollectionClass();
            if (mutableCollectionClass == null) {
                Events$$ExternalSyntheticBUOutline0.m$2("No mutable collection class found: ", Reflection.getOrCreateKotlinClass(Collection.class));
                return null;
            }
        }
        kClass2 = mutableCollectionClass;
        List<KTypeParameter> typeParameters2 = mutableCollectionKClass.getTypeParameters();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(typeParameters2, 10));
        it = typeParameters2.iterator();
        while (it.hasNext()) {
        }
        List listListOfNotNull2 = CollectionsKt.listOfNotNull((Object[]) new KClass[]{kClass, kClass2});
        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOfNotNull2, 10));
        it2 = listListOfNotNull2.iterator();
        while (it2.hasNext()) {
        }
        return arrayList22;
    }
}
