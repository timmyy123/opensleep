package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.ExtensionNodesKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmExtensionNodesKt {
    public static final JvmClassExtension getJvm(KmClass kmClass) {
        kmClass.getClass();
        KmClassExtension extension = ExtensionNodesKt.getExtension(kmClass, JvmClassExtension.Companion.getTYPE());
        extension.getClass();
        return (JvmClassExtension) extension;
    }

    public static final JvmPackageExtension getJvm(KmPackage kmPackage) {
        kmPackage.getClass();
        KmPackageExtension extension = ExtensionNodesKt.getExtension(kmPackage, JvmPackageExtension.TYPE);
        extension.getClass();
        return (JvmPackageExtension) extension;
    }

    public static final JvmFunctionExtension getJvm(KmFunction kmFunction) {
        kmFunction.getClass();
        KmFunctionExtension extension = ExtensionNodesKt.getExtension(kmFunction, JvmFunctionExtension.TYPE);
        extension.getClass();
        return (JvmFunctionExtension) extension;
    }

    public static final JvmPropertyExtension getJvm(KmProperty kmProperty) {
        kmProperty.getClass();
        KmPropertyExtension extension = ExtensionNodesKt.getExtension(kmProperty, JvmPropertyExtension.TYPE);
        extension.getClass();
        return (JvmPropertyExtension) extension;
    }

    public static final JvmConstructorExtension getJvm(KmConstructor kmConstructor) {
        kmConstructor.getClass();
        KmConstructorExtension extension = ExtensionNodesKt.getExtension(kmConstructor, JvmConstructorExtension.TYPE);
        extension.getClass();
        return (JvmConstructorExtension) extension;
    }

    public static final JvmTypeParameterExtension getJvm(KmTypeParameter kmTypeParameter) {
        kmTypeParameter.getClass();
        KmTypeParameterExtension extension = ExtensionNodesKt.getExtension(kmTypeParameter, JvmTypeParameterExtension.TYPE);
        extension.getClass();
        return (JvmTypeParameterExtension) extension;
    }

    public static final JvmTypeExtension getJvm(KmType kmType) {
        kmType.getClass();
        KmTypeExtension extension = ExtensionNodesKt.getExtension(kmType, JvmTypeExtension.TYPE);
        extension.getClass();
        return (JvmTypeExtension) extension;
    }
}
