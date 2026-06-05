package com.spotify.android.appremote.internal;

import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Validate {
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("The object is expected to be not null");
        return null;
    }
}
