package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class ClassNameIdResolver extends TypeIdResolverBase implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Set<String> _allowedSubtypes;
    protected final PolymorphicTypeValidator _subTypeValidator;

    public ClassNameIdResolver(JavaType javaType, TypeFactory typeFactory, Collection<NamedType> collection, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory);
        this._subTypeValidator = polymorphicTypeValidator;
        Set<String> hashSet = null;
        if (collection != null) {
            for (NamedType namedType : collection) {
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                }
                hashSet.add(namedType.getType().getName());
            }
        }
        this._allowedSubtypes = hashSet == null ? Collections.EMPTY_SET : hashSet;
    }

    public static ClassNameIdResolver construct(JavaType javaType, MapperConfig<?> mapperConfig, Collection<NamedType> collection, PolymorphicTypeValidator polymorphicTypeValidator) {
        return new ClassNameIdResolver(javaType, mapperConfig.getTypeFactory(), collection, polymorphicTypeValidator);
    }

    public String _idFrom(Object obj, Class<?> cls, TypeFactory typeFactory) {
        Class<?> cls_resolveToParentAsNecessary = _resolveToParentAsNecessary(cls);
        String name = cls_resolveToParentAsNecessary.getName();
        if (name.startsWith("java.util.")) {
            if (obj instanceof EnumSet) {
                return typeFactory.constructCollectionType(EnumSet.class, ClassUtil.findEnumType((EnumSet<?>) obj)).toCanonical();
            }
            if (obj instanceof EnumMap) {
                return typeFactory.constructMapType(EnumMap.class, ClassUtil.findEnumType((EnumMap<?, ?>) obj), Object.class).toCanonical();
            }
        } else if (name.indexOf(36) >= 0 && ClassUtil.getOuterClass(cls_resolveToParentAsNecessary) != null && ClassUtil.getOuterClass(this._baseType.getRawClass()) == null) {
            return this._baseType.getRawClass().getName();
        }
        return name;
    }

    public JavaType _typeFromId(String str, DatabindContext databindContext) throws JsonMappingException {
        DeserializationContext deserializationContext = databindContext instanceof DeserializationContext ? (DeserializationContext) databindContext : null;
        if (this._allowedSubtypes != null && deserializationContext != null && deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_SUBTYPE_CLASS_NOT_REGISTERED) && !this._allowedSubtypes.contains(str)) {
            throw deserializationContext.invalidTypeIdException(this._baseType, str, "`DeserializationFeature.FAIL_ON_SUBTYPE_CLASS_NOT_REGISTERED` is enabled and the input class is not registered using `@JsonSubTypes` annotation");
        }
        JavaType javaTypeResolveAndValidateSubType = databindContext.resolveAndValidateSubType(this._baseType, str, this._subTypeValidator);
        return (javaTypeResolveAndValidateSubType != null || deserializationContext == null) ? javaTypeResolveAndValidateSubType : deserializationContext.handleUnknownTypeId(this._baseType, str, this, "no such class found");
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public String getDescForKnownTypeIds() {
        return "class name used as type id";
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public String idFromValue(Object obj) {
        return _idFrom(obj, obj.getClass(), this._typeFactory);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public String idFromValueAndType(Object obj, Class<?> cls) {
        return _idFrom(obj, cls, this._typeFactory);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public JavaType typeFromId(DatabindContext databindContext, String str) {
        return _typeFromId(str, databindContext);
    }
}
