package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

/* JADX INFO: loaded from: classes3.dex */
public class ValueInjector extends BeanProperty.Std {
    private static final long serialVersionUID = 1;
    protected final Boolean _optional;
    protected final Boolean _useInput;
    protected final Object _valueId;

    public ValueInjector(PropertyName propertyName, JavaType javaType, AnnotatedMember annotatedMember, Object obj, Boolean bool, Boolean bool2) {
        super(propertyName, javaType, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
        this._valueId = obj;
        this._optional = bool;
        this._useInput = bool2;
    }

    public Object findValue(DeserializationContext deserializationContext, Object obj) {
        return deserializationContext.findInjectableValue(this._valueId, this, obj, this._optional, this._useInput);
    }

    public void inject(DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        Object objFindValue = findValue(deserializationContext, obj);
        if (objFindValue == null) {
            if (Boolean.FALSE.equals(this._optional)) {
                throw deserializationContext.missingInjectableValueException(String.format("No injectable value with id '%s' found (for property '%s')", this._valueId, getName()), this._valueId, null, obj);
            }
        } else {
            if (Boolean.TRUE.equals(this._useInput)) {
                return;
            }
            this._member.setValue(obj, objFindValue);
        }
    }
}
