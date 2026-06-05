package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.km.KmAnnotation;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadContext;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignatureKt;
import kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmMetadataExtensions implements MetadataExtensions {
    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmClassExtension createClassExtension() {
        return new JvmClassExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmConstructorExtension createConstructorExtension() {
        return new JvmConstructorExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmEnumEntryExtension createEnumEntryExtension() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmFunctionExtension createFunctionExtension() {
        return new JvmFunctionExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmPackageExtension createPackageExtension() {
        return new JvmPackageExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmPropertyExtension createPropertyExtension() {
        return new JvmPropertyExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmTypeAliasExtension createTypeAliasExtension() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmTypeExtension createTypeExtension() {
        return new JvmTypeExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmTypeParameterExtension createTypeParameterExtension() {
        return new JvmTypeParameterExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public KmValueParameterExtension createValueParameterExtension() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readClassExtensions(KmClass kmClass, ProtoBuf$Class protoBuf$Class, ReadContext readContext) {
        String str;
        kmClass.getClass();
        protoBuf$Class.getClass();
        readContext.getClass();
        JvmClassExtension jvm = JvmExtensionNodesKt.getJvm(kmClass);
        List<ProtoBuf$Annotation> annotationList = protoBuf$Class.getAnnotationList();
        annotationList.getClass();
        List<KmAnnotation> annotations = kmClass.getAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation : annotationList) {
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, Integer> generatedExtension = JvmProtoBuf.anonymousObjectOriginName;
        generatedExtension.getClass();
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Class, generatedExtension);
        if (num != null) {
            jvm.setAnonymousObjectOriginName(readContext.get(num.intValue()));
        }
        for (ProtoBuf$Property protoBuf$Property : (List) protoBuf$Class.getExtension(JvmProtoBuf.classLocalVariable)) {
            List<KmProperty> localDelegatedProperties = jvm.getLocalDelegatedProperties();
            protoBuf$Property.getClass();
            localDelegatedProperties.add(ReadersKt.toKmProperty(protoBuf$Property, readContext));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, Integer> generatedExtension2 = JvmProtoBuf.classModuleName;
        generatedExtension2.getClass();
        Integer num2 = (Integer) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Class, generatedExtension2);
        if (num2 == null || (str = readContext.get(num2.intValue())) == null) {
            str = "main";
        }
        jvm.setModuleName(str);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, Integer> generatedExtension3 = JvmProtoBuf.jvmClassFlags;
        generatedExtension3.getClass();
        Integer num3 = (Integer) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Class, generatedExtension3);
        if (num3 != null) {
            jvm.setJvmFlags(num3.intValue());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readConstructorExtensions(KmConstructor kmConstructor, ProtoBuf$Constructor protoBuf$Constructor, ReadContext readContext) {
        kmConstructor.getClass();
        protoBuf$Constructor.getClass();
        readContext.getClass();
        JvmConstructorExtension jvm = JvmExtensionNodesKt.getJvm(kmConstructor);
        List<ProtoBuf$Annotation> annotationList = protoBuf$Constructor.getAnnotationList();
        annotationList.getClass();
        List<KmAnnotation> annotations = kmConstructor.getAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation : annotationList) {
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
        JvmMemberSignature.Method jvmConstructorSignature = JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature(protoBuf$Constructor, readContext.getStrings(), readContext.getTypes());
        jvm.setSignature(jvmConstructorSignature != null ? JvmMemberSignatureKt.wrapAsPublic(jvmConstructorSignature) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readEnumEntryExtensions(KmEnumEntry kmEnumEntry, ProtoBuf$EnumEntry protoBuf$EnumEntry, ReadContext readContext) {
        kmEnumEntry.getClass();
        protoBuf$EnumEntry.getClass();
        readContext.getClass();
        for (ProtoBuf$Annotation protoBuf$Annotation : protoBuf$EnumEntry.getAnnotationList()) {
            List<KmAnnotation> annotations = kmEnumEntry.getAnnotations();
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readFunctionExtensions(KmFunction kmFunction, ProtoBuf$Function protoBuf$Function, ReadContext readContext) {
        kmFunction.getClass();
        protoBuf$Function.getClass();
        readContext.getClass();
        JvmFunctionExtension jvm = JvmExtensionNodesKt.getJvm(kmFunction);
        List<ProtoBuf$Annotation> annotationList = protoBuf$Function.getAnnotationList();
        annotationList.getClass();
        List<KmAnnotation> annotations = kmFunction.getAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation : annotationList) {
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
        List<ProtoBuf$Annotation> extensionReceiverAnnotationList = protoBuf$Function.getExtensionReceiverAnnotationList();
        extensionReceiverAnnotationList.getClass();
        List<KmAnnotation> extensionReceiverParameterAnnotations = kmFunction.getExtensionReceiverParameterAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation2 : extensionReceiverAnnotationList) {
            protoBuf$Annotation2.getClass();
            extensionReceiverParameterAnnotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation2, readContext.getStrings()));
        }
        JvmMemberSignature.Method jvmMethodSignature = JvmProtoBufUtil.INSTANCE.getJvmMethodSignature(protoBuf$Function, readContext.getStrings(), readContext.getTypes());
        jvm.setSignature(jvmMethodSignature != null ? JvmMemberSignatureKt.wrapAsPublic(jvmMethodSignature) : null);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, Integer> generatedExtension = JvmProtoBuf.lambdaClassOriginName;
        generatedExtension.getClass();
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Function, generatedExtension);
        if (num != null) {
            jvm.setLambdaClassOriginName(readContext.get(num.intValue()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readPackageExtensions(KmPackage kmPackage, ProtoBuf$Package protoBuf$Package, ReadContext readContext) {
        String str;
        kmPackage.getClass();
        protoBuf$Package.getClass();
        readContext.getClass();
        JvmPackageExtension jvm = JvmExtensionNodesKt.getJvm(kmPackage);
        for (ProtoBuf$Property protoBuf$Property : (List) protoBuf$Package.getExtension(JvmProtoBuf.packageLocalVariable)) {
            List<KmProperty> localDelegatedProperties = jvm.getLocalDelegatedProperties();
            protoBuf$Property.getClass();
            localDelegatedProperties.add(ReadersKt.toKmProperty(protoBuf$Property, readContext));
        }
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Package, Integer> generatedExtension = JvmProtoBuf.packageModuleName;
        generatedExtension.getClass();
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Package, generatedExtension);
        if (num == null || (str = readContext.get(num.intValue())) == null) {
            str = "main";
        }
        jvm.setModuleName(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readPropertyExtensions(KmProperty kmProperty, ProtoBuf$Property protoBuf$Property, ReadContext readContext) {
        kmProperty.getClass();
        protoBuf$Property.getClass();
        readContext.getClass();
        JvmPropertyExtension jvm = JvmExtensionNodesKt.getJvm(kmProperty);
        List<ProtoBuf$Annotation> annotationList = protoBuf$Property.getAnnotationList();
        annotationList.getClass();
        List<KmAnnotation> annotations = kmProperty.getAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation : annotationList) {
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
        List<ProtoBuf$Annotation> getterAnnotationList = protoBuf$Property.getGetterAnnotationList();
        getterAnnotationList.getClass();
        List<KmAnnotation> annotations2 = kmProperty.getGetter().getAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation2 : getterAnnotationList) {
            protoBuf$Annotation2.getClass();
            annotations2.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation2, readContext.getStrings()));
        }
        KmPropertyAccessorAttributes setter = kmProperty.getSetter();
        if (setter != null) {
            List<ProtoBuf$Annotation> setterAnnotationList = protoBuf$Property.getSetterAnnotationList();
            setterAnnotationList.getClass();
            List<KmAnnotation> annotations3 = setter.getAnnotations();
            for (ProtoBuf$Annotation protoBuf$Annotation3 : setterAnnotationList) {
                protoBuf$Annotation3.getClass();
                annotations3.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation3, readContext.getStrings()));
            }
        }
        List<ProtoBuf$Annotation> extensionReceiverAnnotationList = protoBuf$Property.getExtensionReceiverAnnotationList();
        extensionReceiverAnnotationList.getClass();
        List<KmAnnotation> extensionReceiverParameterAnnotations = kmProperty.getExtensionReceiverParameterAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation4 : extensionReceiverAnnotationList) {
            protoBuf$Annotation4.getClass();
            extensionReceiverParameterAnnotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation4, readContext.getStrings()));
        }
        List<ProtoBuf$Annotation> backingFieldAnnotationList = protoBuf$Property.getBackingFieldAnnotationList();
        backingFieldAnnotationList.getClass();
        List<KmAnnotation> backingFieldAnnotations = kmProperty.getBackingFieldAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation5 : backingFieldAnnotationList) {
            protoBuf$Annotation5.getClass();
            backingFieldAnnotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation5, readContext.getStrings()));
        }
        List<ProtoBuf$Annotation> delegateFieldAnnotationList = protoBuf$Property.getDelegateFieldAnnotationList();
        delegateFieldAnnotationList.getClass();
        List<KmAnnotation> delegateFieldAnnotations = kmProperty.getDelegateFieldAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation6 : delegateFieldAnnotationList) {
            protoBuf$Annotation6.getClass();
            delegateFieldAnnotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation6, readContext.getStrings()));
        }
        JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, protoBuf$Property, readContext.getStrings(), readContext.getTypes(), false, 8, null);
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        generatedExtension.getClass();
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(protoBuf$Property, generatedExtension);
        JvmProtoBuf.JvmMethodSignature getter = (jvmPropertySignature == null || !jvmPropertySignature.hasGetter()) ? null : jvmPropertySignature.getGetter();
        JvmProtoBuf.JvmMethodSignature setter2 = (jvmPropertySignature == null || !jvmPropertySignature.hasSetter()) ? null : jvmPropertySignature.getSetter();
        Object extension = protoBuf$Property.getExtension(JvmProtoBuf.flags);
        extension.getClass();
        jvm.setJvmFlags(((Number) extension).intValue());
        jvm.setFieldSignature(jvmFieldSignature$default != null ? JvmMemberSignatureKt.wrapAsPublic(jvmFieldSignature$default) : null);
        jvm.setGetterSignature(getter != null ? new JvmMethodSignature(readContext.get(getter.getName()), readContext.get(getter.getDesc())) : null);
        jvm.setSetterSignature(setter2 != null ? new JvmMethodSignature(readContext.get(setter2.getName()), readContext.get(setter2.getDesc())) : null);
        JvmProtoBuf.JvmMethodSignature syntheticMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasSyntheticMethod()) ? null : jvmPropertySignature.getSyntheticMethod();
        jvm.setSyntheticMethodForAnnotations(syntheticMethod != null ? new JvmMethodSignature(readContext.get(syntheticMethod.getName()), readContext.get(syntheticMethod.getDesc())) : null);
        JvmProtoBuf.JvmMethodSignature delegateMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasDelegateMethod()) ? null : jvmPropertySignature.getDelegateMethod();
        jvm.setSyntheticMethodForDelegate(delegateMethod != null ? new JvmMethodSignature(readContext.get(delegateMethod.getName()), readContext.get(delegateMethod.getDesc())) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeAliasExtensions(KmTypeAlias kmTypeAlias, ProtoBuf$TypeAlias protoBuf$TypeAlias, ReadContext readContext) {
        kmTypeAlias.getClass();
        protoBuf$TypeAlias.getClass();
        readContext.getClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeExtensions(KmType kmType, ProtoBuf$Type protoBuf$Type, ReadContext readContext) {
        kmType.getClass();
        protoBuf$Type.getClass();
        readContext.getClass();
        JvmTypeExtension jvm = JvmExtensionNodesKt.getJvm(kmType);
        Object extension = protoBuf$Type.getExtension(JvmProtoBuf.isRaw);
        extension.getClass();
        jvm.setRaw(((Boolean) extension).booleanValue());
        for (ProtoBuf$Annotation protoBuf$Annotation : protoBuf$Type.getAnnotationList()) {
            List<KmAnnotation> annotations = jvm.getAnnotations();
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf$TypeParameter protoBuf$TypeParameter, ReadContext readContext) {
        kmTypeParameter.getClass();
        protoBuf$TypeParameter.getClass();
        readContext.getClass();
        JvmTypeParameterExtension jvm = JvmExtensionNodesKt.getJvm(kmTypeParameter);
        for (ProtoBuf$Annotation protoBuf$Annotation : protoBuf$TypeParameter.getAnnotationList()) {
            List<KmAnnotation> annotations = jvm.getAnnotations();
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readValueParameterExtensions(KmValueParameter kmValueParameter, ProtoBuf$ValueParameter protoBuf$ValueParameter, ReadContext readContext) {
        kmValueParameter.getClass();
        protoBuf$ValueParameter.getClass();
        readContext.getClass();
        List<ProtoBuf$Annotation> annotationList = protoBuf$ValueParameter.getAnnotationList();
        annotationList.getClass();
        List<KmAnnotation> annotations = kmValueParameter.getAnnotations();
        for (ProtoBuf$Annotation protoBuf$Annotation : annotationList) {
            protoBuf$Annotation.getClass();
            annotations.add(ReadUtilsKt.readAnnotation(protoBuf$Annotation, readContext.getStrings()));
        }
    }
}
