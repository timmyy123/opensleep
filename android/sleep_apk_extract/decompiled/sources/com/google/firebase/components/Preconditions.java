package com.google.firebase.components;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Preconditions {
    public static void checkArgument(boolean z, String str) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2(str);
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        Types$$ExternalSyntheticBUOutline0.m$1(str);
        return null;
    }

    public static void checkState(boolean z, String str) {
        if (z) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(str);
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }
}
