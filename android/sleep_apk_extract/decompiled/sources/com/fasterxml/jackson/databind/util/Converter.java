package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.type.TypeFactory;

/* JADX INFO: loaded from: classes3.dex */
public interface Converter<IN, OUT> {

    public static abstract class None implements Converter<Object, Object> {
    }

    default OUT convert(DeserializationContext deserializationContext, IN in) {
        return convert(in);
    }

    OUT convert(IN in);

    JavaType getInputType(TypeFactory typeFactory);

    JavaType getOutputType(TypeFactory typeFactory);

    default OUT convert(SerializerProvider serializerProvider, IN in) {
        return convert(in);
    }
}
