package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
abstract class NullnessCasts {
    public static <T> T uncheckedCastNullableTToT(@CheckForNull T t) {
        return t;
    }

    public static <T> T uncheckedNull() {
        return null;
    }
}
