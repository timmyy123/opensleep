package kotlin.reflect.jvm.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u001a#\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005*\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\"\u001c\u0010\r\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0012\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\"\u001c\u0010\u0013\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u0014"}, d2 = {"", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "callable", "coerceToExpectedReceiverType", "(Ljava/lang/Object;Lkotlin/reflect/jvm/internal/ReflectKCallable;)Ljava/lang/Object;", "", "computeAbsentArguments", "(Lkotlin/reflect/jvm/internal/ReflectKCallable;)[Ljava/lang/Object;", "Lkotlin/reflect/KType;", "type", "defaultEmptyArray", "(Lkotlin/reflect/KType;)Ljava/lang/Object;", "", "isBound", "(Lkotlin/reflect/jvm/internal/ReflectKCallable;)Z", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/ReflectKCallable;)Ljava/lang/Object;", "boundReceiver", "isConstructor", "isAnnotationConstructor", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ReflectKCallableKt {
    private static final Object coerceToExpectedReceiverType(Object obj, ReflectKCallable<?> reflectKCallable) {
        Class<?> inlineClass;
        Method inlineClassUnboxMethod;
        if ((reflectKCallable instanceof ReflectKProperty) && ValueClassAwareCallerKt.isUnderlyingPropertyOfValueClass((ReflectKProperty) reflectKCallable)) {
            return obj;
        }
        Iterator<T> it = reflectKCallable.getAllParameters().iterator();
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
            } else {
                Object next = it.next();
                if (((KParameter) next).getKind() != KParameter.Kind.VALUE) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            }
        }
        obj2 = null;
        KParameter kParameter = (KParameter) obj2;
        KType type = kParameter != null ? kParameter.getType() : null;
        return (type == null || (inlineClass = ValueClassAwareCallerKt.toInlineClass(type)) == null || (inlineClassUnboxMethod = ValueClassAwareCallerKt.getInlineClassUnboxMethod(inlineClass, reflectKCallable)) == null) ? obj : inlineClassUnboxMethod.invoke(obj, null);
    }

    public static final Object[] computeAbsentArguments(ReflectKCallable<?> reflectKCallable) {
        int i;
        reflectKCallable.getClass();
        List<KParameter> parameters = reflectKCallable.getParameters();
        int size = (reflectKCallable.isSuspend() ? 1 : 0) + parameters.size();
        List<KParameter> list = parameters;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (KParameter kParameter : list) {
                if (kParameter.getKind() == KParameter.Kind.VALUE || kParameter.getKind() == KParameter.Kind.CONTEXT) {
                    i++;
                    if (i < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
        }
        int i2 = (i + 31) / 32;
        Object[] objArr = new Object[size + i2 + 1];
        for (KParameter kParameter2 : list) {
            if (kParameter2.isOptional() && !UtilKt.isInlineClassType(kParameter2.getType())) {
                objArr[kParameter2.getIndex()] = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(kParameter2.getType()));
            } else if (kParameter2.isVararg()) {
                objArr[kParameter2.getIndex()] = defaultEmptyArray(kParameter2.getType());
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[size + i3] = 0;
        }
        return objArr;
    }

    private static final Object defaultEmptyArray(KType kType) {
        Class javaClass = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object objNewInstance = Array.newInstance(javaClass.getComponentType(), 0);
            objNewInstance.getClass();
            return objNewInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    public static final Object getBoundReceiver(ReflectKCallable<?> reflectKCallable) {
        reflectKCallable.getClass();
        return coerceToExpectedReceiverType(reflectKCallable.getRawBoundReceiver(), reflectKCallable);
    }

    public static final boolean isAnnotationConstructor(ReflectKCallable<?> reflectKCallable) {
        reflectKCallable.getClass();
        return isConstructor(reflectKCallable) && reflectKCallable.getContainer().getJClass().isAnnotation();
    }

    public static final boolean isBound(ReflectKCallable<?> reflectKCallable) {
        reflectKCallable.getClass();
        return reflectKCallable.getRawBoundReceiver() != CallableReference.NO_RECEIVER;
    }

    public static final boolean isConstructor(ReflectKCallable<?> reflectKCallable) {
        reflectKCallable.getClass();
        return Intrinsics.areEqual(reflectKCallable.getName(), "<init>");
    }
}
