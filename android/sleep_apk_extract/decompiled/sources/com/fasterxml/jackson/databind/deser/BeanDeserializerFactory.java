package com.fasterxml.jackson.databind.deser;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.ErrorThrowingDeserializer;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.SubTypeValidator;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.SimpleBeanPropertyDefinition;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());
    private static final long serialVersionUID = 1;

    public BeanDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        super(deserializerFactoryConfig);
    }

    private boolean _isSetterlessType(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    private SettableAnyProperty _resolveAnySetter(DeserializationContext deserializationContext, BeanDescription beanDescription, SettableBeanProperty[] settableBeanPropertyArr) {
        if (settableBeanPropertyArr != null) {
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                AnnotatedMember member = settableBeanProperty.getMember();
                if (member != null && Boolean.TRUE.equals(deserializationContext.getAnnotationIntrospector().hasAnySetter(member))) {
                    return constructAnySetter(deserializationContext, beanDescription, member);
                }
            }
        }
        AnnotatedMember annotatedMemberFindAnySetterAccessor = beanDescription.findAnySetterAccessor();
        if (annotatedMemberFindAnySetterAccessor != null) {
            return constructAnySetter(deserializationContext, beanDescription, annotatedMemberFindAnySetterAccessor);
        }
        return null;
    }

    public JsonDeserializer<Object> _findUnsupportedTypeDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        String strCheckUnsupportedType = BeanUtil.checkUnsupportedType(deserializationContext.getConfig(), javaType);
        if (strCheckUnsupportedType == null || deserializationContext.getConfig().findMixInClassFor(javaType.getRawClass()) != null) {
            return null;
        }
        return new UnsupportedTypeDeserializer(javaType, strCheckUnsupportedType);
    }

    public void _validateSubType(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        SubTypeValidator.instance().validateSubType(deserializationContext, javaType, beanDescription);
    }

    public void addBackReferenceProperties(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws InvalidDefinitionException {
        List<BeanPropertyDefinition> listFindBackReferences = beanDescription.findBackReferences();
        if (listFindBackReferences != null) {
            for (BeanPropertyDefinition beanPropertyDefinition : listFindBackReferences) {
                if (beanDescription.isRecordType()) {
                    deserializationContext.reportBadTypeDefinition(beanDescription, "Cannot add back-reference to a `java.lang.Record` type (property '%s')", beanPropertyDefinition.getName());
                }
                beanDeserializerBuilder.addBackReferenceProperty(beanPropertyDefinition.findReferenceName(), constructSettableProperty(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.getPrimaryType()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addBeanProps(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) throws InvalidDefinitionException {
        Set<String> setFindIgnoredForDeserialization;
        Set<String> included;
        SettableBeanProperty settableBeanPropertyConstructSetterlessProperty;
        CreatorProperty creatorProperty;
        ValueInstantiator valueInstantiator = beanDeserializerBuilder.getValueInstantiator();
        SettableBeanProperty settableBeanProperty = null;
        SettableBeanProperty[] fromObjectArguments = valueInstantiator != null ? valueInstantiator.getFromObjectArguments(deserializationContext.getConfig()) : null;
        boolean z = fromObjectArguments != null;
        JsonIgnoreProperties.Value defaultPropertyIgnorals = deserializationContext.getConfig().getDefaultPropertyIgnorals(beanDescription.getBeanClass(), beanDescription.getClassInfo());
        if (defaultPropertyIgnorals != null) {
            beanDeserializerBuilder.setIgnoreUnknownProperties(defaultPropertyIgnorals.getIgnoreUnknown());
            setFindIgnoredForDeserialization = defaultPropertyIgnorals.findIgnoredForDeserialization();
            Iterator<String> it = setFindIgnoredForDeserialization.iterator();
            while (it.hasNext()) {
                beanDeserializerBuilder.addIgnorable(it.next());
            }
        } else {
            setFindIgnoredForDeserialization = Collections.EMPTY_SET;
        }
        JsonIncludeProperties.Value defaultPropertyInclusions = deserializationContext.getConfig().getDefaultPropertyInclusions(beanDescription.getBeanClass(), beanDescription.getClassInfo());
        if (defaultPropertyInclusions != null) {
            included = defaultPropertyInclusions.getIncluded();
            if (included != null) {
                Iterator<String> it2 = included.iterator();
                while (it2.hasNext()) {
                    beanDeserializerBuilder.addIncludable(it2.next());
                }
            }
        } else {
            included = null;
        }
        SettableAnyProperty settableAnyProperty_resolveAnySetter = _resolveAnySetter(deserializationContext, beanDescription, fromObjectArguments);
        if (settableAnyProperty_resolveAnySetter != null) {
            beanDeserializerBuilder.setAnySetter(settableAnyProperty_resolveAnySetter);
        } else {
            Set<String> ignoredPropertyNames = beanDescription.getIgnoredPropertyNames();
            if (ignoredPropertyNames != null) {
                Iterator<String> it3 = ignoredPropertyNames.iterator();
                while (it3.hasNext()) {
                    beanDeserializerBuilder.addIgnorable(it3.next());
                }
            }
        }
        boolean z2 = deserializationContext.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS) && deserializationContext.isEnabled(MapperFeature.AUTO_DETECT_GETTERS);
        List<BeanPropertyDefinition> listFilterBeanProps = filterBeanProps(deserializationContext, beanDescription, beanDeserializerBuilder, beanDescription.findProperties(), setFindIgnoredForDeserialization, included);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it4 = this._factoryConfig.deserializerModifiers().iterator();
            if (it4.hasNext()) {
                if (it4.next() != null) {
                    Events$$ExternalSyntheticBUOutline0.m();
                    return;
                } else {
                    deserializationContext.getConfig();
                    throw null;
                }
            }
        }
        for (BeanPropertyDefinition beanPropertyDefinition : listFilterBeanProps) {
            if (beanPropertyDefinition.hasSetter()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.getSetter().getParameterType(0));
            } else if (beanPropertyDefinition.hasField()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, beanDescription, beanPropertyDefinition, beanPropertyDefinition.getField().getType());
            } else {
                AnnotatedMethod getter = beanPropertyDefinition.getGetter();
                if (getter == null) {
                    settableBeanPropertyConstructSetterlessProperty = settableBeanProperty;
                } else if (z2 && _isSetterlessType(getter.getRawType())) {
                    if (!beanDeserializerBuilder.hasIgnorable(beanPropertyDefinition.getName())) {
                        settableBeanPropertyConstructSetterlessProperty = constructSetterlessProperty(deserializationContext, beanDescription, beanPropertyDefinition);
                    }
                } else if (!beanPropertyDefinition.hasConstructorParameter() && beanPropertyDefinition.getMetadata().getMergeInfo() != null) {
                    settableBeanPropertyConstructSetterlessProperty = constructSetterlessProperty(deserializationContext, beanDescription, beanPropertyDefinition);
                }
            }
            if (z && beanPropertyDefinition.hasConstructorParameter()) {
                String name = beanPropertyDefinition.getName();
                int length = fromObjectArguments.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        creatorProperty = null;
                        break;
                    }
                    SettableBeanProperty settableBeanProperty2 = fromObjectArguments[i];
                    if (name.equals(settableBeanProperty2.getName()) && (settableBeanProperty2 instanceof CreatorProperty)) {
                        creatorProperty = (CreatorProperty) settableBeanProperty2;
                        break;
                    }
                    i++;
                }
                if (creatorProperty == null) {
                    ArrayList arrayList = new ArrayList();
                    for (SettableBeanProperty settableBeanProperty3 : fromObjectArguments) {
                        arrayList.add(settableBeanProperty3.getName());
                    }
                    deserializationContext.reportBadPropertyDefinition(beanDescription, beanPropertyDefinition, "Could not find creator property with name %s (known Creator properties: %s)", ClassUtil.name(name), arrayList);
                } else {
                    if (settableBeanPropertyConstructSetterlessProperty != null) {
                        creatorProperty.setFallbackSetter(settableBeanPropertyConstructSetterlessProperty);
                    }
                    Class<?>[] clsArrFindViews = beanPropertyDefinition.findViews();
                    if (clsArrFindViews == null) {
                        clsArrFindViews = beanDescription.findDefaultViews();
                    }
                    creatorProperty.setViews(clsArrFindViews);
                    beanDeserializerBuilder.addCreatorProperty(creatorProperty);
                }
            } else if (settableBeanPropertyConstructSetterlessProperty != null) {
                Class<?>[] clsArrFindViews2 = beanPropertyDefinition.findViews();
                if (clsArrFindViews2 == null) {
                    clsArrFindViews2 = beanDescription.findDefaultViews();
                }
                settableBeanPropertyConstructSetterlessProperty.setViews(clsArrFindViews2);
                beanDeserializerBuilder.addProperty(settableBeanPropertyConstructSetterlessProperty);
            }
            settableBeanProperty = null;
        }
    }

    public void addInjectables(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        Boolean useInput;
        Boolean bool;
        Map<Object, AnnotatedMember> mapFindInjectables = beanDescription.findInjectables();
        if (mapFindInjectables != null) {
            AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
            for (Map.Entry<Object, AnnotatedMember> entry : mapFindInjectables.entrySet()) {
                AnnotatedMember value = entry.getValue();
                JacksonInject.Value valueFindInjectableValue = annotationIntrospector.findInjectableValue(value);
                if (valueFindInjectableValue == null) {
                    bool = null;
                    useInput = null;
                } else {
                    Boolean optional = valueFindInjectableValue.getOptional();
                    useInput = valueFindInjectableValue.getUseInput();
                    bool = optional;
                }
                beanDeserializerBuilder.addInjectable(PropertyName.construct(value.getName()), value.getType(), beanDescription.getClassAnnotations(), value, entry.getKey(), bool, useInput);
            }
        }
    }

    public void addObjectIdReader(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder) {
        SettableBeanProperty settableBeanPropertyFindProperty;
        ObjectIdGenerator<?> objectIdGeneratorObjectIdGeneratorInstance;
        JavaType javaType;
        ObjectIdInfo objectIdInfo = beanDescription.getObjectIdInfo();
        if (objectIdInfo == null) {
            return;
        }
        Class<? extends ObjectIdGenerator<?>> generatorType = objectIdInfo.getGeneratorType();
        deserializationContext.objectIdResolverInstance(beanDescription.getClassInfo(), objectIdInfo);
        if (generatorType == ObjectIdGenerators$PropertyGenerator.class) {
            PropertyName propertyName = objectIdInfo.getPropertyName();
            settableBeanPropertyFindProperty = beanDeserializerBuilder.findProperty(propertyName);
            if (settableBeanPropertyFindProperty == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m("Invalid Object Id definition for ", ClassUtil.getTypeDescription(beanDescription.getType()), ": cannot find property with name ", ClassUtil.name(propertyName)));
                return;
            }
            JavaType type = settableBeanPropertyFindProperty.getType();
            javaType = type;
            objectIdGeneratorObjectIdGeneratorInstance = new PropertyBasedObjectIdGenerator(objectIdInfo.getScope());
        } else {
            JavaType javaType2 = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType((Class<?>) generatorType), ObjectIdGenerator.class)[0];
            settableBeanPropertyFindProperty = null;
            objectIdGeneratorObjectIdGeneratorInstance = deserializationContext.objectIdGeneratorInstance(beanDescription.getClassInfo(), objectIdInfo);
            javaType = javaType2;
        }
        SettableBeanProperty settableBeanProperty = settableBeanPropertyFindProperty;
        beanDeserializerBuilder.setObjectIdReader(ObjectIdReader.construct(javaType, objectIdInfo.getPropertyName(), objectIdGeneratorObjectIdGeneratorInstance, deserializationContext.findRootValueDeserializer(javaType), settableBeanProperty, null));
    }

    public JsonDeserializer<Object> buildBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        try {
            ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
            BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
            beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(valueInstantiatorFindValueInstantiator);
            addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addObjectIdReader(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addBackReferenceProperties(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addInjectables(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            deserializationContext.getConfig();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
                if (it.hasNext()) {
                    throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
                }
            }
            JsonDeserializer<?> jsonDeserializerBuild = (!javaType.isAbstract() || valueInstantiatorFindValueInstantiator.canInstantiate()) ? beanDeserializerBuilderConstructBeanDeserializerBuilder.build() : beanDeserializerBuilderConstructBeanDeserializerBuilder.buildAbstract();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
                if (it2.hasNext()) {
                    throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it2);
                }
            }
            return jsonDeserializerBuild;
        } catch (IllegalArgumentException e) {
            throw InvalidDefinitionException.from(deserializationContext.getParser(), ClassUtil.exceptionMessage(e), beanDescription, (BeanPropertyDefinition) null).withCause(e);
        } catch (NoClassDefFoundError e2) {
            return new ErrorThrowingDeserializer(e2);
        }
    }

    public JsonDeserializer<Object> buildBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws InvalidDefinitionException {
        try {
            ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, beanDescription);
            DeserializationConfig config = deserializationContext.getConfig();
            BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
            beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(valueInstantiatorFindValueInstantiator);
            addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addObjectIdReader(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addBackReferenceProperties(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            addInjectables(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
            JsonPOJOBuilder.Value valueFindPOJOBuilderConfig = beanDescription.findPOJOBuilderConfig();
            String str = valueFindPOJOBuilderConfig == null ? InAppPurchaseConstants.METHOD_BUILD : valueFindPOJOBuilderConfig.buildMethodName;
            AnnotatedMethod annotatedMethodFindMethod = beanDescription.findMethod(str, null);
            if (annotatedMethodFindMethod != null && config.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(annotatedMethodFindMethod.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            beanDeserializerBuilderConstructBeanDeserializerBuilder.setPOJOBuilder(annotatedMethodFindMethod, valueFindPOJOBuilderConfig);
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
                if (it.hasNext()) {
                    throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
                }
            }
            JsonDeserializer<?> jsonDeserializerBuildBuilderBased = beanDeserializerBuilderConstructBeanDeserializerBuilder.buildBuilderBased(javaType, str);
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
                if (it2.hasNext()) {
                    throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it2);
                }
            }
            return jsonDeserializerBuildBuilderBased;
        } catch (IllegalArgumentException e) {
            throw InvalidDefinitionException.from(deserializationContext.getParser(), ClassUtil.exceptionMessage(e), beanDescription, (BeanPropertyDefinition) null);
        } catch (NoClassDefFoundError e2) {
            return new ErrorThrowingDeserializer(e2);
        }
    }

    public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws InvalidDefinitionException {
        DeserializationConfig config = deserializationContext.getConfig();
        BeanDeserializerBuilder beanDeserializerBuilderConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, beanDescription);
        beanDeserializerBuilderConstructBeanDeserializerBuilder.setValueInstantiator(findValueInstantiator(deserializationContext, beanDescription));
        addBeanProps(deserializationContext, beanDescription, beanDeserializerBuilderConstructBeanDeserializerBuilder);
        Iterator<SettableBeanProperty> properties = beanDeserializerBuilderConstructBeanDeserializerBuilder.getProperties();
        while (true) {
            if (!properties.hasNext()) {
                break;
            }
            if ("setCause".equals(properties.next().getMember().getName())) {
                properties.remove();
                break;
            }
        }
        AnnotatedMethod annotatedMethodFindMethod = beanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (annotatedMethodFindMethod != null) {
            SettableBeanProperty settableBeanPropertyFindProperty = beanDeserializerBuilderConstructBeanDeserializerBuilder.findProperty(PropertyName.construct("cause"));
            if (settableBeanPropertyFindProperty instanceof CreatorProperty) {
                ((CreatorProperty) settableBeanPropertyFindProperty).setFallbackSetter(null);
            } else {
                config.getPropertyNamingStrategy();
                SettableBeanProperty settableBeanPropertyConstructSettableProperty = constructSettableProperty(deserializationContext, beanDescription, SimpleBeanPropertyDefinition.construct(deserializationContext.getConfig(), annotatedMethodFindMethod, new PropertyName("cause")), annotatedMethodFindMethod.getParameterType(0));
                if (settableBeanPropertyConstructSettableProperty != null) {
                    beanDeserializerBuilderConstructBeanDeserializerBuilder.addOrReplaceProperty(settableBeanPropertyConstructSettableProperty, true);
                }
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it);
            }
        }
        JsonDeserializer<?> jsonDeserializerBuild = beanDeserializerBuilderConstructBeanDeserializerBuilder.build();
        if (jsonDeserializerBuild instanceof BeanDeserializer) {
            jsonDeserializerBuild = ThrowableDeserializer.construct(deserializationContext, (BeanDeserializer) jsonDeserializerBuild);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<BeanDeserializerModifier> it2 = this._factoryConfig.deserializerModifiers().iterator();
            if (it2.hasNext()) {
                throw FileInsert$$ExternalSyntheticOutline0.m((Iterator) it2);
            }
        }
        return jsonDeserializerBuild;
    }

    public SettableAnyProperty constructAnySetter(DeserializationContext deserializationContext, BeanDescription beanDescription, AnnotatedMember annotatedMember) throws InvalidDefinitionException {
        BeanProperty.Std std;
        JavaType contentType;
        JavaType keyType;
        boolean z = annotatedMember instanceof AnnotatedField;
        boolean z2 = annotatedMember instanceof AnnotatedParameter;
        int i = -1;
        if (annotatedMember instanceof AnnotatedMethod) {
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
            keyType = annotatedMethod.getParameterType(0);
            JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, annotatedMethod.getParameterType(1));
            std = new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
            contentType = javaTypeResolveMemberAndTypeAnnotations;
        } else if (z) {
            JavaType type = ((AnnotatedField) annotatedMember).getType();
            if (!type.isMapLikeType()) {
                if (type.hasRawClass(JsonNode.class) || type.hasRawClass(ObjectNode.class)) {
                    JavaType javaTypeResolveMemberAndTypeAnnotations2 = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, type);
                    JavaType javaTypeConstructType = deserializationContext.constructType(JsonNode.class);
                    return SettableAnyProperty.constructForJsonNodeField(deserializationContext, new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations2, null, annotatedMember, PropertyMetadata.STD_OPTIONAL), annotatedMember, javaTypeConstructType, deserializationContext.findRootValueDeserializer(javaTypeConstructType));
                }
                return (SettableAnyProperty) deserializationContext.reportBadDefinition(beanDescription.getType(), "Unsupported type for any-setter: " + ClassUtil.getTypeDescription(type) + " -- only support `Map`s, `JsonNode` and `ObjectNode` ");
            }
            JavaType javaTypeResolveMemberAndTypeAnnotations3 = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, type);
            keyType = javaTypeResolveMemberAndTypeAnnotations3.getKeyType();
            contentType = javaTypeResolveMemberAndTypeAnnotations3.getContentType();
            std = new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations3, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
        } else {
            if (!z2) {
                return (SettableAnyProperty) deserializationContext.reportBadDefinition(beanDescription.getType(), "Unrecognized mutator type for any-setter: " + ClassUtil.nameOf(annotatedMember.getClass()));
            }
            AnnotatedParameter annotatedParameter = (AnnotatedParameter) annotatedMember;
            JavaType type2 = annotatedParameter.getType();
            int index = annotatedParameter.getIndex();
            if (!type2.isMapLikeType()) {
                if (type2.hasRawClass(JsonNode.class) || type2.hasRawClass(ObjectNode.class)) {
                    JavaType javaTypeResolveMemberAndTypeAnnotations4 = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, type2);
                    JavaType javaTypeConstructType2 = deserializationContext.constructType(JsonNode.class);
                    return SettableAnyProperty.constructForJsonNodeParameter(deserializationContext, new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations4, null, annotatedMember, PropertyMetadata.STD_OPTIONAL), annotatedMember, javaTypeConstructType2, deserializationContext.findRootValueDeserializer(javaTypeConstructType2), index);
                }
                return (SettableAnyProperty) deserializationContext.reportBadDefinition(beanDescription.getType(), "Unsupported type for any-setter: " + ClassUtil.getTypeDescription(type2) + " -- only support `Map`s, `JsonNode` and `ObjectNode` ");
            }
            JavaType javaTypeResolveMemberAndTypeAnnotations5 = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, type2);
            JavaType keyType2 = javaTypeResolveMemberAndTypeAnnotations5.getKeyType();
            JavaType contentType2 = javaTypeResolveMemberAndTypeAnnotations5.getContentType();
            std = new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations5, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
            contentType = contentType2;
            i = index;
            keyType = keyType2;
        }
        KeyDeserializer keyDeserializerFindKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (keyDeserializerFindKeyDeserializerFromAnnotation == null) {
            keyDeserializerFindKeyDeserializerFromAnnotation = (KeyDeserializer) keyType.getValueHandler();
        }
        if (keyDeserializerFindKeyDeserializerFromAnnotation == null) {
            keyDeserializerFindKeyDeserializerFromAnnotation = deserializationContext.findKeyDeserializer(keyType, std);
        }
        JsonDeserializer<?> jsonDeserializerFindContentDeserializerFromAnnotation = findContentDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (jsonDeserializerFindContentDeserializerFromAnnotation == null) {
            jsonDeserializerFindContentDeserializerFromAnnotation = (JsonDeserializer) contentType.getValueHandler();
        }
        if (jsonDeserializerFindContentDeserializerFromAnnotation != null) {
            jsonDeserializerFindContentDeserializerFromAnnotation = deserializationContext.handlePrimaryContextualization(jsonDeserializerFindContentDeserializerFromAnnotation, std, contentType);
        }
        JsonDeserializer<?> jsonDeserializer = jsonDeserializerFindContentDeserializerFromAnnotation;
        TypeDeserializer typeDeserializer = (TypeDeserializer) contentType.getTypeHandler();
        if (z) {
            return SettableAnyProperty.constructForMapField(deserializationContext, std, annotatedMember, contentType, keyDeserializerFindKeyDeserializerFromAnnotation, jsonDeserializer, typeDeserializer);
        }
        KeyDeserializer keyDeserializer = keyDeserializerFindKeyDeserializerFromAnnotation;
        return z2 ? SettableAnyProperty.constructForMapParameter(deserializationContext, std, annotatedMember, contentType, keyDeserializer, jsonDeserializer, typeDeserializer, i) : SettableAnyProperty.constructForMethod(deserializationContext, std, annotatedMember, contentType, keyDeserializer, jsonDeserializer, typeDeserializer);
    }

    public BeanDeserializerBuilder constructBeanDeserializerBuilder(DeserializationContext deserializationContext, BeanDescription beanDescription) {
        return new BeanDeserializerBuilder(beanDescription, deserializationContext);
    }

    public SettableBeanProperty constructSettableProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType) throws InvalidDefinitionException {
        BeanPropertyDefinition beanPropertyDefinition2;
        SettableBeanProperty fieldProperty;
        AnnotatedMember nonConstructorMutator = beanPropertyDefinition.getNonConstructorMutator();
        if (nonConstructorMutator == null) {
            deserializationContext.reportBadPropertyDefinition(beanDescription, beanPropertyDefinition, "No non-constructor mutator available", new Object[0]);
        }
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, nonConstructorMutator, javaType);
        TypeDeserializer typeDeserializer = (TypeDeserializer) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler();
        if (nonConstructorMutator instanceof AnnotatedMethod) {
            beanPropertyDefinition2 = beanPropertyDefinition;
            fieldProperty = new MethodProperty(beanPropertyDefinition2, javaTypeResolveMemberAndTypeAnnotations, typeDeserializer, beanDescription.getClassAnnotations(), (AnnotatedMethod) nonConstructorMutator);
        } else {
            beanPropertyDefinition2 = beanPropertyDefinition;
            fieldProperty = new FieldProperty(beanPropertyDefinition2, javaTypeResolveMemberAndTypeAnnotations, typeDeserializer, beanDescription.getClassAnnotations(), (AnnotatedField) nonConstructorMutator);
        }
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, nonConstructorMutator);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        if (jsonDeserializerFindDeserializerFromAnnotation != null) {
            fieldProperty = fieldProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(jsonDeserializerFindDeserializerFromAnnotation, fieldProperty, javaTypeResolveMemberAndTypeAnnotations));
        }
        AnnotationIntrospector.ReferenceProperty referencePropertyFindReferenceType = beanPropertyDefinition2.findReferenceType();
        if (referencePropertyFindReferenceType != null && referencePropertyFindReferenceType.isManagedReference()) {
            fieldProperty.setManagedReferenceName(referencePropertyFindReferenceType.getName());
        }
        ObjectIdInfo objectIdInfoFindObjectIdInfo = beanPropertyDefinition2.findObjectIdInfo();
        if (objectIdInfoFindObjectIdInfo != null) {
            fieldProperty.setObjectIdInfo(objectIdInfoFindObjectIdInfo);
        }
        return fieldProperty;
    }

    public SettableBeanProperty constructSetterlessProperty(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition) {
        AnnotatedMethod getter = beanPropertyDefinition.getGetter();
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, getter, getter.getType());
        SetterlessProperty setterlessProperty = new SetterlessProperty(beanPropertyDefinition, javaTypeResolveMemberAndTypeAnnotations, (TypeDeserializer) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler(), beanDescription.getClassAnnotations(), getter);
        JsonDeserializer<?> jsonDeserializerFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, getter);
        if (jsonDeserializerFindDeserializerFromAnnotation == null) {
            jsonDeserializerFindDeserializerFromAnnotation = (JsonDeserializer) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        return jsonDeserializerFindDeserializerFromAnnotation != null ? setterlessProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(jsonDeserializerFindDeserializerFromAnnotation, setterlessProperty, javaTypeResolveMemberAndTypeAnnotations)) : setterlessProperty;
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<Object> createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        JavaType javaTypeMaterializeAbstractType;
        DeserializationConfig config = deserializationContext.getConfig();
        JsonDeserializer<Object> jsonDeserializer_findCustomBeanDeserializer = _findCustomBeanDeserializer(javaType, config, beanDescription);
        if (jsonDeserializer_findCustomBeanDeserializer != null) {
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        Events$$ExternalSyntheticBUOutline0.m();
                        return null;
                    }
                    deserializationContext.getConfig();
                    throw null;
                }
            }
            return jsonDeserializer_findCustomBeanDeserializer;
        }
        if (javaType.isThrowable()) {
            return buildThrowableDeserializer(deserializationContext, javaType, beanDescription);
        }
        if (javaType.isAbstract() && !javaType.isPrimitive() && !javaType.isEnumType() && (javaTypeMaterializeAbstractType = materializeAbstractType(deserializationContext, javaType, beanDescription)) != null) {
            return buildBeanDeserializer(deserializationContext, javaTypeMaterializeAbstractType, config.introspect(javaTypeMaterializeAbstractType));
        }
        JsonDeserializer<?> jsonDeserializerFindStdDeserializer = findStdDeserializer(deserializationContext, javaType, beanDescription);
        if (jsonDeserializerFindStdDeserializer != null) {
            return jsonDeserializerFindStdDeserializer;
        }
        if (!isPotentialBeanType(javaType.getRawClass())) {
            return null;
        }
        _validateSubType(deserializationContext, javaType, beanDescription);
        JsonDeserializer<Object> jsonDeserializer_findUnsupportedTypeDeserializer = _findUnsupportedTypeDeserializer(deserializationContext, javaType, beanDescription);
        return jsonDeserializer_findUnsupportedTypeDeserializer != null ? jsonDeserializer_findUnsupportedTypeDeserializer : buildBeanDeserializer(deserializationContext, javaType, beanDescription);
    }

    @Override // com.fasterxml.jackson.databind.deser.DeserializerFactory
    public JsonDeserializer<Object> createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription, Class<?> cls) {
        return buildBuilderBasedDeserializer(deserializationContext, javaType, deserializationContext.getConfig().introspectForBuilder(deserializationContext.isEnabled(MapperFeature.INFER_BUILDER_TYPE_BINDINGS) ? deserializationContext.getTypeFactory().constructParametricType(cls, javaType.getBindings()) : deserializationContext.constructType(cls), beanDescription));
    }

    public List<BeanPropertyDefinition> filterBeanProps(DeserializationContext deserializationContext, BeanDescription beanDescription, BeanDeserializerBuilder beanDeserializerBuilder, List<BeanPropertyDefinition> list, Set<String> set, Set<String> set2) {
        Class<?> rawPrimaryType;
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap map = new HashMap();
        for (BeanPropertyDefinition beanPropertyDefinition : list) {
            String name = beanPropertyDefinition.getName();
            if (!IgnorePropertiesUtil.shouldIgnore(name, set, set2)) {
                if (beanPropertyDefinition.hasConstructorParameter() || (rawPrimaryType = beanPropertyDefinition.getRawPrimaryType()) == null || !isIgnorableType(deserializationContext.getConfig(), beanPropertyDefinition, rawPrimaryType, map)) {
                    arrayList.add(beanPropertyDefinition);
                } else {
                    beanDeserializerBuilder.addIgnorable(name);
                }
            }
        }
        return arrayList;
    }

    public JsonDeserializer<?> findStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        JsonDeserializer<?> jsonDeserializerFindDefaultDeserializer = findDefaultDeserializer(deserializationContext, javaType, beanDescription);
        if (jsonDeserializerFindDefaultDeserializer == null || !this._factoryConfig.hasDeserializerModifiers()) {
            return jsonDeserializerFindDefaultDeserializer;
        }
        Iterator<BeanDeserializerModifier> it = this._factoryConfig.deserializerModifiers().iterator();
        if (!it.hasNext()) {
            return jsonDeserializerFindDefaultDeserializer;
        }
        if (it.next() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        deserializationContext.getConfig();
        throw null;
    }

    public boolean isIgnorableType(DeserializationConfig deserializationConfig, BeanPropertyDefinition beanPropertyDefinition, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean isIgnoredType;
        Boolean bool = map.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        if (cls == String.class || cls.isPrimitive()) {
            isIgnoredType = Boolean.FALSE;
        } else {
            isIgnoredType = deserializationConfig.getConfigOverride(cls).getIsIgnoredType();
            if (isIgnoredType == null) {
                isIgnoredType = deserializationConfig.getAnnotationIntrospector().isIgnorableType(deserializationConfig.introspectClassAnnotations(cls).getClassInfo());
                if (isIgnoredType == null) {
                    isIgnoredType = Boolean.FALSE;
                }
            }
        }
        map.put(cls, isIgnoredType);
        return isIgnoredType.booleanValue();
    }

    public boolean isPotentialBeanType(Class<?> cls) {
        String strCanBeABeanType = ClassUtil.canBeABeanType(cls);
        if (strCanBeABeanType != null) {
            OggIO$$ExternalSyntheticBUOutline0.m(cls.getName(), " (of type ", strCanBeABeanType, ") as a Bean", "Cannot deserialize Class ");
            return false;
        }
        if (ClassUtil.isProxyType(cls)) {
            Gson$$ExternalSyntheticBUOutline0.m("Cannot deserialize Proxy class ", cls.getName(), " as a Bean");
            return false;
        }
        String strIsLocalType = ClassUtil.isLocalType(cls, true);
        if (strIsLocalType == null) {
            return true;
        }
        OggIO$$ExternalSyntheticBUOutline0.m(cls.getName(), " (of type ", strIsLocalType, ") as a Bean", "Cannot deserialize Class ");
        return false;
    }

    public JavaType materializeAbstractType(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) {
        Iterator<AbstractTypeResolver> it = this._factoryConfig.abstractTypeResolvers().iterator();
        if (!it.hasNext()) {
            return null;
        }
        if (it.next() != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        deserializationContext.getConfig();
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.BasicDeserializerFactory
    public DeserializerFactory withConfig(DeserializerFactoryConfig deserializerFactoryConfig) {
        if (this._factoryConfig == deserializerFactoryConfig) {
            return this;
        }
        ClassUtil.verifyMustOverride(BeanDeserializerFactory.class, this, "withConfig");
        return new BeanDeserializerFactory(deserializerFactoryConfig);
    }
}
