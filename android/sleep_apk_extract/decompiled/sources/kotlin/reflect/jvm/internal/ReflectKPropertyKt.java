package kotlin.reflect.jvm.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KParameter;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.KCallablesJvm;
import kotlin.reflect.jvm.internal.DescriptorKProperty;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0000\"\u001c\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\n"}, d2 = {"isLocalDelegated", "", "Lkotlin/reflect/jvm/internal/ReflectKProperty;", "(Lkotlin/reflect/jvm/internal/ReflectKProperty;)Z", "getDelegateImpl", "", "fieldOrMethod", "Ljava/lang/reflect/Member;", "receiver1", "receiver2", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ReflectKPropertyKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object getDelegateImpl(ReflectKProperty<?> reflectKProperty, Member member, Object obj, Object obj2) throws IllegalPropertyDelegateAccessException {
        reflectKProperty.getClass();
        try {
            DescriptorKProperty.Companion companion = DescriptorKProperty.INSTANCE;
            if (obj == companion.getEXTENSION_PROPERTY_DELEGATE() || obj2 == companion.getEXTENSION_PROPERTY_DELEGATE()) {
                List<KParameter> parameters = reflectKProperty.getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    Iterator<T> it = parameters.iterator();
                    while (it.hasNext()) {
                        if (((KParameter) it.next()).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                        }
                    }
                }
                throw new RuntimeException('\'' + reflectKProperty + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object boundReceiver = ReflectKCallableKt.isBound(reflectKProperty) ? ReflectKCallableKt.getBoundReceiver(reflectKProperty) : obj;
            DescriptorKProperty.Companion companion2 = DescriptorKProperty.INSTANCE;
            if (boundReceiver == companion2.getEXTENSION_PROPERTY_DELEGATE()) {
                boundReceiver = null;
            }
            if (!ReflectKCallableKt.isBound(reflectKProperty)) {
                obj = obj2;
            }
            if (obj == companion2.getEXTENSION_PROPERTY_DELEGATE()) {
                obj = null;
            }
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(KCallablesJvm.isAccessible(reflectKProperty));
            }
            if (member == 0) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(boundReceiver);
            }
            if (!(member instanceof Method)) {
                throw new AssertionError("delegate field/method " + member + " neither field nor method");
            }
            int length = ((Method) member).getParameterTypes().length;
            if (length == 0) {
                return ((Method) member).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) member;
                if (boundReceiver == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    cls.getClass();
                    boundReceiver = UtilKt.defaultPrimitiveValue(cls);
                }
                return method.invoke(null, boundReceiver);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                cls2.getClass();
                obj = UtilKt.defaultPrimitiveValue(cls2);
            }
            return method2.invoke(null, boundReceiver, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalPropertyDelegateAccessException(e);
        }
    }

    public static final boolean isLocalDelegated(ReflectKProperty<?> reflectKProperty) {
        reflectKProperty.getClass();
        return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE.matches(reflectKProperty.getSignature());
    }
}
