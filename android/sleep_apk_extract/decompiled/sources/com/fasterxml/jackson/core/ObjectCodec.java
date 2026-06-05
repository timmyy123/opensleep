package com.fasterxml.jackson.core;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ObjectCodec extends TreeCodec {
    public abstract <T extends TreeNode> T readTree(JsonParser jsonParser);

    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj);
}
