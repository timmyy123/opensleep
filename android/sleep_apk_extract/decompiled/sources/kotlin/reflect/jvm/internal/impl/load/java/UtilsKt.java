package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UtilsKt {
    public static final AnnotationDescriptor extractNullabilityAnnotationOnBoundedWildcard(LazyJavaResolverContext lazyJavaResolverContext, JavaWildcardType javaWildcardType) {
        lazyJavaResolverContext.getClass();
        javaWildcardType.getClass();
        AnnotationDescriptor annotationDescriptor = null;
        if (javaWildcardType.getBound() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Nullability annotations on unbounded wildcards aren't supported");
            return null;
        }
        Iterator<AnnotationDescriptor> it = new LazyJavaAnnotations(lazyJavaResolverContext, javaWildcardType, false, 4, null).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                break;
            }
            AnnotationDescriptor next = it.next();
            AnnotationDescriptor annotationDescriptor2 = next;
            for (FqName fqName : JavaNullabilityAnnotationSettingsKt.getRXJAVA3_ANNOTATIONS()) {
                if (Intrinsics.areEqual(annotationDescriptor2.getFqName(), fqName)) {
                    annotationDescriptor = next;
                    break loop0;
                }
            }
        }
        return annotationDescriptor;
    }

    public static final boolean hasErasedValueParameters(CallableMemberDescriptor callableMemberDescriptor) {
        callableMemberDescriptor.getClass();
        return (callableMemberDescriptor instanceof FunctionDescriptor) && Intrinsics.areEqual(callableMemberDescriptor.getUserData(JavaMethodDescriptor.HAS_ERASED_VALUE_PARAMETERS), Boolean.TRUE);
    }

    public static final boolean isJspecifyEnabledInStrictMode(JavaTypeEnhancementState javaTypeEnhancementState) {
        javaTypeEnhancementState.getClass();
        return javaTypeEnhancementState.getGetReportLevelForAnnotation().invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.STRICT;
    }

    public static final DescriptorVisibility toDescriptorVisibility(Visibility visibility) {
        visibility.getClass();
        DescriptorVisibility descriptorVisibility = JavaDescriptorVisibilities.toDescriptorVisibility(visibility);
        descriptorVisibility.getClass();
        return descriptorVisibility;
    }
}
