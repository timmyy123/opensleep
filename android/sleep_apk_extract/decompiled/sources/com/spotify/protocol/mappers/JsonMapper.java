package com.spotify.protocol.mappers;

/* JADX INFO: loaded from: classes4.dex */
public interface JsonMapper {
    String toJson(Object obj);

    JsonArray toJsonArray(String str);
}
