package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class StdKeyDeserializers implements KeyDeserializers, Serializable {
    private static final long serialVersionUID = 1;

    private static KeyDeserializer _constructCreatorKeyDeserializer(DeserializationConfig deserializationConfig, AnnotatedMember annotatedMember) {
        if (annotatedMember instanceof AnnotatedConstructor) {
            Constructor<?> annotated = ((AnnotatedConstructor) annotatedMember).getAnnotated();
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(annotated, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new StdKeyDeserializer.StringCtorKeyDeserializer(annotated);
        }
        Method annotated2 = ((AnnotatedMethod) annotatedMember).getAnnotated();
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(annotated2, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new StdKeyDeserializer.StringFactoryKeyDeserializer(annotated2);
    }

    private static AnnotatedMethod _findExplicitStringFactoryMethod(List<AnnotatedAndMetadata<AnnotatedMethod, JsonCreator.Mode>> list) {
        AnnotatedMethod annotatedMethod = null;
        for (AnnotatedAndMetadata<AnnotatedMethod, JsonCreator.Mode> annotatedAndMetadata : list) {
            if (annotatedAndMetadata.metadata != null) {
                A a = annotatedAndMetadata.annotated;
                if (annotatedMethod != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Multiple suitable annotated Creator factory methods to be used as the Key deserializer for type ", ClassUtil.nameOf(((AnnotatedMethod) a).getDeclaringClass()));
                    return null;
                }
                annotatedMethod = (AnnotatedMethod) a;
            }
        }
        return annotatedMethod;
    }

    private static AnnotatedAndMetadata<AnnotatedConstructor, JsonCreator.Mode> _findStringConstructor(BeanDescription beanDescription) {
        for (AnnotatedAndMetadata<AnnotatedConstructor, JsonCreator.Mode> annotatedAndMetadata : beanDescription.getConstructorsWithMode()) {
            AnnotatedConstructor annotatedConstructor = (AnnotatedConstructor) annotatedAndMetadata.annotated;
            if (annotatedConstructor.getParameterCount() == 1 && String.class == annotatedConstructor.getRawParameterType(0)) {
                return annotatedAndMetadata;
            }
        }
        return null;
    }

    public static KeyDeserializer constructDelegatingKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
        return new StdKeyDeserializer.DelegatingKD(javaType.getRawClass(), jsonDeserializer);
    }

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver, EnumResolver enumResolver2, EnumResolver enumResolver3, EnumResolver enumResolver4) {
        return new StdKeyDeserializer.EnumKD(enumResolver, null, enumResolver2, enumResolver3, enumResolver4);
    }

    public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) {
        BeanDescription beanDescriptionIntrospectForCreation = deserializationConfig.introspectForCreation(javaType);
        AnnotatedAndMetadata<AnnotatedConstructor, JsonCreator.Mode> annotatedAndMetadata_findStringConstructor = _findStringConstructor(beanDescriptionIntrospectForCreation);
        if (annotatedAndMetadata_findStringConstructor != null && annotatedAndMetadata_findStringConstructor.metadata != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, (AnnotatedMember) annotatedAndMetadata_findStringConstructor.annotated);
        }
        List<AnnotatedAndMetadata<AnnotatedMethod, JsonCreator.Mode>> factoryMethodsWithMode = beanDescriptionIntrospectForCreation.getFactoryMethodsWithMode();
        factoryMethodsWithMode.removeIf(new Color$$ExternalSyntheticLambda1(1));
        AnnotatedMethod annotatedMethod_findExplicitStringFactoryMethod = _findExplicitStringFactoryMethod(factoryMethodsWithMode);
        if (annotatedMethod_findExplicitStringFactoryMethod != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, annotatedMethod_findExplicitStringFactoryMethod);
        }
        if (annotatedAndMetadata_findStringConstructor != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, (AnnotatedMember) annotatedAndMetadata_findStringConstructor.annotated);
        }
        if (factoryMethodsWithMode.isEmpty()) {
            return null;
        }
        return _constructCreatorKeyDeserializer(deserializationConfig, (AnnotatedMember) factoryMethodsWithMode.get(0).annotated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findStringBasedKeyDeserializer$0(AnnotatedAndMetadata annotatedAndMetadata) {
        return (((AnnotatedMethod) annotatedAndMetadata.annotated).getParameterCount() == 1 && ((AnnotatedMethod) annotatedAndMetadata.annotated).getRawParameterType(0) == String.class && annotatedAndMetadata.metadata != JsonCreator.Mode.PROPERTIES) ? false : true;
    }

    @Override // com.fasterxml.jackson.databind.deser.KeyDeserializers
    public KeyDeserializer findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            rawClass = ClassUtil.wrapperType(rawClass);
        }
        return StdKeyDeserializer.forType(rawClass);
    }

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver, AnnotatedMethod annotatedMethod, EnumResolver enumResolver2, EnumResolver enumResolver3, EnumResolver enumResolver4) {
        return new StdKeyDeserializer.EnumKD(enumResolver, annotatedMethod, enumResolver2, enumResolver3, enumResolver4);
    }
}
