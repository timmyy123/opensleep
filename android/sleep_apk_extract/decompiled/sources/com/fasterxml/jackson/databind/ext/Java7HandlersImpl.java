package com.fasterxml.jackson.databind.ext;

import com.facebook.FacebookSdk$$ExternalSyntheticLambda3;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class Java7HandlersImpl extends Java7Handlers {
    private final Class<?> _pathClass = FacebookSdk$$ExternalSyntheticLambda3.m();

    @Override // com.fasterxml.jackson.databind.ext.Java7Handlers
    public JsonDeserializer<?> getDeserializerForJavaNioFilePath(Class<?> cls) {
        if (cls == this._pathClass) {
            return new NioPathDeserializer();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.ext.Java7Handlers
    public JsonSerializer<?> getSerializerForJavaNioFilePath(Class<?> cls) {
        if (this._pathClass.isAssignableFrom(cls)) {
            return new NioPathSerializer();
        }
        return null;
    }
}
