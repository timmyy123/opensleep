package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
abstract class NullnessCasts {
    public static <T> T uncheckedCastNullableTToT(@CheckForNull T t) {
        return t;
    }
}
