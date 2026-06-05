package com.google.gson.internal;

import com.google.gson.stream.JsonReader;

/* JADX INFO: loaded from: classes4.dex */
public abstract class JsonReaderInternalAccess {
    public static volatile JsonReaderInternalAccess INSTANCE;

    public abstract void promoteNameToValue(JsonReader jsonReader);
}
