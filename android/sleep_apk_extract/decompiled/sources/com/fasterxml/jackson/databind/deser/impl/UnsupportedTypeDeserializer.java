package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

/* JADX INFO: loaded from: classes3.dex */
public class UnsupportedTypeDeserializer extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final String _message;
    protected final JavaType _type;

    public UnsupportedTypeDeserializer(JavaType javaType, String str) {
        super(javaType);
        this._type = javaType;
        this._message = str;
    }

    @Override // com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws InvalidDefinitionException {
        Object embeddedObject;
        if (jsonParser.currentToken() == JsonToken.VALUE_EMBEDDED_OBJECT && ((embeddedObject = jsonParser.getEmbeddedObject()) == null || this._type.getRawClass().isAssignableFrom(embeddedObject.getClass()))) {
            return embeddedObject;
        }
        deserializationContext.reportBadDefinition(this._type, this._message);
        return null;
    }
}
