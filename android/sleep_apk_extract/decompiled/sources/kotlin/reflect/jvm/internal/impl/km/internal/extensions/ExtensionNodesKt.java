package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExtensionNodesKt {
    public static final KmClassExtension getExtension(KmClass kmClass, KmExtensionType kmExtensionType) {
        kmClass.getClass();
        kmExtensionType.getClass();
        return (KmClassExtension) singleOfType(kmClass.getExtensions$kotlin_metadata(), kmExtensionType);
    }

    private static final <N extends KmExtension> N singleOfType(Collection<? extends N> collection, KmExtensionType kmExtensionType) {
        N n = null;
        for (N n2 : collection) {
            if (Intrinsics.areEqual(n2.getType(), kmExtensionType)) {
                if (n != null) {
                    Home$$ExternalSyntheticBUOutline0.m$2("Multiple extensions handle the same extension type: ", kmExtensionType);
                    return null;
                }
                n = n2;
            }
        }
        if (n != null) {
            return n;
        }
        Home$$ExternalSyntheticBUOutline0.m$2("No extensions handle the extension type: ", kmExtensionType);
        return null;
    }

    public static final KmPackageExtension getExtension(KmPackage kmPackage, KmExtensionType kmExtensionType) {
        kmPackage.getClass();
        kmExtensionType.getClass();
        return (KmPackageExtension) singleOfType(kmPackage.getExtensions$kotlin_metadata(), kmExtensionType);
    }

    public static final KmFunctionExtension getExtension(KmFunction kmFunction, KmExtensionType kmExtensionType) {
        kmFunction.getClass();
        kmExtensionType.getClass();
        return (KmFunctionExtension) singleOfType(kmFunction.getExtensions$kotlin_metadata(), kmExtensionType);
    }

    public static final KmPropertyExtension getExtension(KmProperty kmProperty, KmExtensionType kmExtensionType) {
        kmProperty.getClass();
        kmExtensionType.getClass();
        return (KmPropertyExtension) singleOfType(kmProperty.getExtensions$kotlin_metadata(), kmExtensionType);
    }

    public static final KmConstructorExtension getExtension(KmConstructor kmConstructor, KmExtensionType kmExtensionType) {
        kmConstructor.getClass();
        kmExtensionType.getClass();
        return (KmConstructorExtension) singleOfType(kmConstructor.getExtensions$kotlin_metadata(), kmExtensionType);
    }

    public static final KmTypeParameterExtension getExtension(KmTypeParameter kmTypeParameter, KmExtensionType kmExtensionType) {
        kmTypeParameter.getClass();
        kmExtensionType.getClass();
        return (KmTypeParameterExtension) singleOfType(kmTypeParameter.getExtensions$kotlin_metadata(), kmExtensionType);
    }

    public static final KmTypeExtension getExtension(KmType kmType, KmExtensionType kmExtensionType) {
        kmType.getClass();
        kmExtensionType.getClass();
        return (KmTypeExtension) singleOfType(kmType.getExtensions$kotlin_metadata(), kmExtensionType);
    }
}
