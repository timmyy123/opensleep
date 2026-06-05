package kotlin.reflect.jvm.internal.impl.km.jvm;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmExtensionsKt {
    public static final List<KmAnnotation> getAnnotations(KmType kmType) {
        kmType.getClass();
        return JvmExtensionNodesKt.getJvm(kmType).getAnnotations();
    }

    public static final JvmFieldSignature getFieldSignature(KmProperty kmProperty) {
        kmProperty.getClass();
        return JvmExtensionNodesKt.getJvm(kmProperty).getFieldSignature();
    }

    public static final JvmMethodSignature getGetterSignature(KmProperty kmProperty) {
        kmProperty.getClass();
        return JvmExtensionNodesKt.getJvm(kmProperty).getGetterSignature();
    }

    public static final List<KmProperty> getLocalDelegatedProperties(KmClass kmClass) {
        kmClass.getClass();
        return JvmExtensionNodesKt.getJvm(kmClass).getLocalDelegatedProperties();
    }

    public static final String getModuleName(KmClass kmClass) {
        kmClass.getClass();
        return JvmExtensionNodesKt.getJvm(kmClass).getModuleName();
    }

    public static final JvmMethodSignature getSetterSignature(KmProperty kmProperty) {
        kmProperty.getClass();
        return JvmExtensionNodesKt.getJvm(kmProperty).getSetterSignature();
    }

    public static final JvmMethodSignature getSignature(KmFunction kmFunction) {
        kmFunction.getClass();
        return JvmExtensionNodesKt.getJvm(kmFunction).getSignature();
    }

    public static final JvmMethodSignature getSyntheticMethodForDelegate(KmProperty kmProperty) {
        kmProperty.getClass();
        return JvmExtensionNodesKt.getJvm(kmProperty).getSyntheticMethodForDelegate();
    }

    public static final boolean isRaw(KmType kmType) {
        kmType.getClass();
        return JvmExtensionNodesKt.getJvm(kmType).isRaw();
    }

    public static final List<KmProperty> getLocalDelegatedProperties(KmPackage kmPackage) {
        kmPackage.getClass();
        return JvmExtensionNodesKt.getJvm(kmPackage).getLocalDelegatedProperties();
    }

    public static final JvmMethodSignature getSignature(KmConstructor kmConstructor) {
        kmConstructor.getClass();
        return JvmExtensionNodesKt.getJvm(kmConstructor).getSignature();
    }
}
