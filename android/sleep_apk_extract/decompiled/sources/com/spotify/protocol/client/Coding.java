package com.spotify.protocol.client;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Coding {
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Null is not allowed here.");
        return null;
    }
}
