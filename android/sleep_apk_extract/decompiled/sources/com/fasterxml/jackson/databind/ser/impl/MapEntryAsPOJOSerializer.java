package com.fasterxml.jackson.databind.ser.impl;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MapEntryAsPOJOSerializer extends StdSerializer<Map.Entry<?, ?>> {
    private static final long serialVersionUID = 1;

    public MapEntryAsPOJOSerializer(JavaType javaType) {
        super(javaType);
    }

    public static MapEntryAsPOJOSerializer create(SerializerProvider serializerProvider, JavaType javaType) {
        return new MapEntryAsPOJOSerializer(javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject(entry);
        serializerProvider.defaultSerializeField(SDKConstants.PARAM_KEY, entry.getKey(), jsonGenerator);
        serializerProvider.defaultSerializeField(SDKConstants.PARAM_VALUE, entry.getValue(), jsonGenerator);
        jsonGenerator.writeEndObject();
    }
}
