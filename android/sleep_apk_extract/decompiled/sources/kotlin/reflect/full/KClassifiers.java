package kotlin.reflect.full;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.SystemPropertiesKt;
import kotlin.reflect.jvm.internal.types.CapturedKTypeKt;
import kotlin.reflect.jvm.internal.types.SimpleKType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a=\u0010\t\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001aM\u0010\r\u001a\u00020\b*\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkotlin/reflect/KClassifier;", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "", "nullable", "", "annotations", "Lkotlin/reflect/KType;", "createType", "(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;)Lkotlin/reflect/KType;", "Lkotlin/reflect/KClass;", "mutableCollectionClass", "createTypeImpl", "(Lkotlin/reflect/KClassifier;Ljava/util/List;ZLjava/util/List;Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "", "parametersSize", "argumentsSize", "", "checkArgumentsSize", "(II)V", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KClassifiers {
    public static final void checkArgumentsSize(int i, int i2) {
        if (i == i2) {
            return;
        }
        Events$$ExternalSyntheticBUOutline0.m("Class declares ", i, " type parameters, but ", i2, " were provided.");
    }

    public static final KType createType(KClassifier kClassifier, List<KTypeProjection> list, boolean z, List<? extends Annotation> list2) {
        kClassifier.getClass();
        list.getClass();
        list2.getClass();
        return createTypeImpl$default(kClassifier, list, z, list2, null, 8, null);
    }

    public static /* synthetic */ KType createType$default(KClassifier kClassifier, List list, boolean z, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return createType(kClassifier, list, z, list2);
    }

    public static final KType createTypeImpl(KClassifier kClassifier, List<KTypeProjection> list, boolean z, List<? extends Annotation> list2, KClass<?> kClass) {
        kClassifier.getClass();
        list.getClass();
        list2.getClass();
        if (SystemPropertiesKt.getUseK1Implementation()) {
            return K1ImplementationKt.createK1KType(kClassifier, list, z);
        }
        KClass kClass2 = kClassifier instanceof KClass ? (KClass) kClassifier : null;
        List<KTypeParameter> listAllTypeParameters = kClass2 != null ? CapturedKTypeKt.allTypeParameters(kClass2) : null;
        if (listAllTypeParameters == null) {
            listAllTypeParameters = CollectionsKt.emptyList();
        }
        checkArgumentsSize(listAllTypeParameters.size(), list.size());
        return new SimpleKType(kClassifier, list, z, list2, null, false, false, false, kClass, null, 512, null);
    }

    public static /* synthetic */ KType createTypeImpl$default(KClassifier kClassifier, List list, boolean z, List list2, KClass kClass, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            kClass = null;
        }
        return createTypeImpl(kClassifier, list, z, list2, kClass);
    }
}
