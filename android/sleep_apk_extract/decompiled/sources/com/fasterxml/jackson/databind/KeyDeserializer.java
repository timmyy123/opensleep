package com.fasterxml.jackson.databind;

/* JADX INFO: loaded from: classes3.dex */
public abstract class KeyDeserializer {

    public static abstract class None extends KeyDeserializer {
    }

    public abstract Object deserializeKey(String str, DeserializationContext deserializationContext);
}
