package kotlin.reflect.jvm.internal.calls;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectKCallable;
import kotlin.reflect.jvm.internal.ReflectKCallableKt;
import kotlin.reflect.jvm.internal.ReflectKProperty;
import kotlin.reflect.jvm.internal.UtilKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\b*\u00020\rH\u0002\u001aF\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0002\"\n\b\u0000\u0010\u0010*\u0004\u0018\u00010\r*\b\u0012\u0004\u0012\u0002H\u00100\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0000\u001a\u001c\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00142\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00142\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002\u001a\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014*\u0004\u0018\u00010\u000bH\u0000\u001a\u0010\u0010\u0017\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u0006H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u0019H\u0000\u001a\f\u0010\u001a\u001a\u00020\b*\u00020\u000bH\u0002¨\u0006\u001b"}, d2 = {"checkParametersSize", "", "Lkotlin/reflect/jvm/internal/calls/Caller;", "expectedArgsSize", "", "callable", "Lkotlin/reflect/jvm/internal/ReflectKCallable;", "isDefault", "", "makeKotlinParameterTypes", "", "Lkotlin/reflect/KType;", "member", "Ljava/lang/reflect/Member;", "acceptsBoxedReceiverParameter", "createValueClassAwareCallerIfNeeded", "M", "forbidUnboxingForIndices", "getInlineClassUnboxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getBoxMethod", "toInlineClass", "isGetterOfUnderlyingPropertyOfValueClass", "isUnderlyingPropertyOfValueClass", "Lkotlin/reflect/jvm/internal/ReflectKProperty;", "isPrimitiveType", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ValueClassAwareCallerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean acceptsBoxedReceiverParameter(Member member) {
        if (member.getDeclaringClass() == null) {
            return false;
        }
        return !JvmClassMappingKt.getKotlinClass(r0).isValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkParametersSize(Caller<?> caller, int i, ReflectKCallable<?> reflectKCallable, boolean z) {
        if (CallerKt.getArity(caller) == i) {
            return;
        }
        StringBuilder sb = new StringBuilder("Inconsistent number of parameters in the descriptor and Java reflection object: ");
        sb.append(CallerKt.getArity(caller));
        sb.append(" != ");
        sb.append(i);
        sb.append("\nCalling: ");
        sb.append(reflectKCallable);
        List<Type> parameterTypes = caller.getParameterTypes();
        sb.append("\nParameter types: ");
        sb.append(parameterTypes);
        sb.append(")\nDefault: ");
        sb.append(z);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <M extends Member> Caller<M> createValueClassAwareCallerIfNeeded(Caller<? extends M> caller, ReflectKCallable<?> reflectKCallable, boolean z, List<Integer> list) {
        caller.getClass();
        reflectKCallable.getClass();
        list.getClass();
        List<KParameter> parameters = reflectKCallable.getParameters();
        if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                if (UtilKt.isInlineClassType(((KParameter) it.next()).getType())) {
                    break;
                }
            }
            if (!UtilKt.isInlineClassType(reflectKCallable.getReturnType())) {
                return caller;
            }
        } else if (!UtilKt.isInlineClassType(reflectKCallable.getReturnType())) {
        }
        return new ValueClassAwareCaller(reflectKCallable, caller, z, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Method getBoxMethod(Class<?> cls, ReflectKCallable<?> reflectKCallable) {
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", getInlineClassUnboxMethod(cls, reflectKCallable).getReturnType());
            declaredMethod.getClass();
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            Events$$ExternalSyntheticBUOutline0.m$1("No box method found in inline class: ", cls, " (calling ", reflectKCallable);
            return null;
        }
    }

    public static final Method getInlineClassUnboxMethod(Class<?> cls, ReflectKCallable<?> reflectKCallable) {
        cls.getClass();
        reflectKCallable.getClass();
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            declaredMethod.getClass();
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            Events$$ExternalSyntheticBUOutline0.m$1("No unbox method found in inline class: ", cls, " (calling ", reflectKCallable);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isGetterOfUnderlyingPropertyOfValueClass(ReflectKCallable<?> reflectKCallable) {
        if (!(reflectKCallable instanceof KProperty.Getter)) {
            return false;
        }
        KAnnotatedElement property = ((KProperty.Getter) reflectKCallable).getProperty();
        property.getClass();
        return isUnderlyingPropertyOfValueClass((ReflectKProperty) property);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPrimitiveType(KType kType) {
        if (kType.getIsMarkedNullable()) {
            return false;
        }
        KClassifier classifier = kType.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        Class javaPrimitiveType = kClass != null ? JvmClassMappingKt.getJavaPrimitiveType(kClass) : null;
        return (javaPrimitiveType == null || Intrinsics.areEqual(javaPrimitiveType, Void.TYPE)) ? false : true;
    }

    public static final boolean isUnderlyingPropertyOfValueClass(ReflectKProperty<?> reflectKProperty) {
        reflectKProperty.getClass();
        List<KParameter> allParameters = reflectKProperty.getAllParameters();
        if (!(allParameters instanceof Collection) || !allParameters.isEmpty()) {
            Iterator<T> it = allParameters.iterator();
            while (it.hasNext()) {
                if (((KParameter) it.next()).getKind() != KParameter.Kind.INSTANCE) {
                    return false;
                }
            }
        }
        String name = reflectKProperty.getName();
        KDeclarationContainerImpl container = reflectKProperty.getContainer();
        KClassImpl kClassImpl = container instanceof KClassImpl ? (KClassImpl) container : null;
        return Intrinsics.areEqual(name, kClassImpl != null ? kClassImpl.getInlineClassUnderlyingPropertyName$kotlin_reflection() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<KType> makeKotlinParameterTypes(ReflectKCallable<?> reflectKCallable, Member member) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ClassBasedDeclarationContainer container = reflectKCallable.getContainer();
        if (!ReflectKCallableKt.isConstructor(reflectKCallable) && (container instanceof KClass)) {
            KClass kClass = (KClass) container;
            if (kClass.isValue()) {
                arrayList.add(KClasses.createDefaultType(kClass));
            }
        }
        if (ReflectKCallableKt.isConstructor(reflectKCallable)) {
            KClass kClass2 = container instanceof KClass ? (KClass) container : null;
            if (kClass2 != null) {
                z = true;
                if (!kClass2.isInner()) {
                }
            }
        } else {
            z = false;
        }
        for (KParameter kParameter : reflectKCallable.getAllParameters()) {
            if (kParameter.getKind() != KParameter.Kind.INSTANCE || z) {
                arrayList.add(kParameter.getType());
            }
        }
        return arrayList;
    }

    public static final Class<?> toInlineClass(KType kType) {
        KClassifier classifier = kType != null ? kType.getClassifier() : null;
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null || !kClass.isValue()) {
            return null;
        }
        if (!UtilKt.isNullableType(kType)) {
            return JvmClassMappingKt.getJavaClass(kClass);
        }
        KType kTypeUnsubstitutedUnderlyingType = UtilKt.unsubstitutedUnderlyingType(kType);
        if (kTypeUnsubstitutedUnderlyingType == null || UtilKt.isNullableType(kTypeUnsubstitutedUnderlyingType) || isPrimitiveType(kTypeUnsubstitutedUnderlyingType)) {
            return null;
        }
        return JvmClassMappingKt.getJavaClass(kClass);
    }
}
