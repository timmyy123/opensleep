package com.spotify.protocol.mappers;

/* JADX INFO: loaded from: classes4.dex */
public interface JsonObject {
    <T> T getAs(Class<T> cls);

    String toJson();
}
