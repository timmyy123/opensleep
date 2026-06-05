package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSerializerBase extends TypeSerializer {
    protected final TypeIdResolver _idResolver;
    protected final BeanProperty _property;

    public TypeSerializerBase(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        this._idResolver = typeIdResolver;
        this._property = beanProperty;
    }

    private WritableTypeId _writeTypePrefixForNull(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        JsonToken jsonToken = writableTypeId.valueShape;
        writableTypeId.wrapperWritten = false;
        if (jsonToken == JsonToken.START_OBJECT) {
            jsonGenerator.writeStartObject(writableTypeId.forValue);
            return writableTypeId;
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            jsonGenerator.writeStartArray(writableTypeId.forValue);
        }
        return writableTypeId;
    }

    private WritableTypeId _writeTypeSuffixfixForNull(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        JsonToken jsonToken = writableTypeId.valueShape;
        if (jsonToken == JsonToken.START_OBJECT) {
            jsonGenerator.writeEndObject();
            return writableTypeId;
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            jsonGenerator.writeEndArray();
        }
        return writableTypeId;
    }

    public void _generateTypeId(WritableTypeId writableTypeId) {
        if (writableTypeId.id == null) {
            Object obj = writableTypeId.forValue;
            Class<?> cls = writableTypeId.forValueType;
            writableTypeId.id = cls == null ? idFromValue(obj) : idFromValueAndType(obj, cls);
        }
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public String getPropertyName() {
        return null;
    }

    public void handleMissingId(Object obj) {
    }

    public String idFromValue(Object obj) {
        String strIdFromValue = this._idResolver.idFromValue(obj);
        if (strIdFromValue == null) {
            handleMissingId(obj);
        }
        return strIdFromValue;
    }

    public String idFromValueAndType(Object obj, Class<?> cls) {
        String strIdFromValueAndType = this._idResolver.idFromValueAndType(obj, cls);
        if (strIdFromValueAndType == null) {
            handleMissingId(obj);
        }
        return strIdFromValueAndType;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public WritableTypeId writeTypePrefix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        _generateTypeId(writableTypeId);
        return writableTypeId.id == null ? _writeTypePrefixForNull(jsonGenerator, writableTypeId) : jsonGenerator.writeTypePrefix(writableTypeId);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public WritableTypeId writeTypeSuffix(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) {
        return writableTypeId == null ? _writeTypeSuffixfixForNull(jsonGenerator, writableTypeId) : jsonGenerator.writeTypeSuffix(writableTypeId);
    }
}
