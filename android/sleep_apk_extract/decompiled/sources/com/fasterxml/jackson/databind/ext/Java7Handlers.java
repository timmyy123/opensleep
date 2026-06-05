package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Java7Handlers {
    private static final Java7Handlers IMPL = new Java7HandlersImpl();

    public static Java7Handlers instance() {
        return IMPL;
    }

    public abstract JsonDeserializer<?> getDeserializerForJavaNioFilePath(Class<?> cls);

    public abstract JsonSerializer<?> getSerializerForJavaNioFilePath(Class<?> cls);
}
