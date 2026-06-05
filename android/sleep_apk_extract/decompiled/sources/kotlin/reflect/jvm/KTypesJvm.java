package kotlin.reflect.jvm;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\"\"\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/reflect/KType;", "Lkotlin/reflect/KClass;", "getJvmErasure", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "jvmErasure", "Lkotlin/reflect/KClassifier;", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KTypesJvm {
    public static final KClass<?> getJvmErasure(KClassifier kClassifier) {
        KClass<?> jvmErasure;
        kClassifier.getClass();
        if (kClassifier instanceof KClass) {
            return (KClass) kClassifier;
        }
        Object obj = null;
        if (!(kClassifier instanceof KTypeParameter)) {
            Events$$ExternalSyntheticBUOutline0.m$1("Cannot calculate JVM erasure for type: ", kClassifier);
            return null;
        }
        List<KType> upperBounds = ((KTypeParameter) kClassifier).getUpperBounds();
        Iterator<T> it = upperBounds.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            KClassifier classifier = ((KType) next).getClassifier();
            KClassImpl kClassImpl = classifier instanceof KClassImpl ? (KClassImpl) classifier : null;
            if (kClassImpl != null && kClassImpl.getClassKind$kotlin_reflection() != ClassKind.INTERFACE && kClassImpl.getClassKind$kotlin_reflection() != ClassKind.ANNOTATION_CLASS) {
                obj = next;
                break;
            }
        }
        KType kType = (KType) obj;
        if (kType == null) {
            kType = (KType) CollectionsKt.firstOrNull((List) upperBounds);
        }
        return (kType == null || (jvmErasure = getJvmErasure(kType)) == null) ? Reflection.getOrCreateKotlinClass(Object.class) : jvmErasure;
    }

    public static final KClass<?> getJvmErasure(KType kType) {
        KClass<?> jvmErasure;
        kType.getClass();
        KClassifier classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Cannot calculate JVM erasure for type: ", kType);
        return null;
    }
}
