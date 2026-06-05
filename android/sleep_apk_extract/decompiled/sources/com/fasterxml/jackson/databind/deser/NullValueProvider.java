package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationContext;

/* JADX INFO: loaded from: classes3.dex */
public interface NullValueProvider {
    default Object getAbsentValue(DeserializationContext deserializationContext) {
        return getNullValue(deserializationContext);
    }

    Object getNullValue(DeserializationContext deserializationContext);
}
