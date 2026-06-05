package com.google.api.client.util;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Preconditions {
    public static void checkArgument(boolean z) {
        com.google.common.base.Preconditions.checkArgument(z);
    }

    public static <T> T checkNotNull(T t) {
        return (T) com.google.common.base.Preconditions.checkNotNull(t);
    }

    public static void checkState(boolean z) {
        com.google.common.base.Preconditions.checkState(z);
    }

    public static void checkArgument(boolean z, Object obj) {
        com.google.common.base.Preconditions.checkArgument(z, obj);
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        com.google.common.base.Preconditions.checkState(z, str, objArr);
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        com.google.common.base.Preconditions.checkArgument(z, str, objArr);
    }

    public static <T> T checkNotNull(T t, Object obj) {
        return (T) com.google.common.base.Preconditions.checkNotNull(t, obj);
    }

    public static <T> T checkNotNull(T t, String str, Object... objArr) {
        return (T) com.google.common.base.Preconditions.checkNotNull((Object) t, str, objArr);
    }
}
