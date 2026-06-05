package com.google.android.datatransport;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Event<T> {
    public static <T> Event<T> ofData(T t) {
        return new AutoValue_Event(null, t, Priority.DEFAULT);
    }

    public abstract Integer getCode();

    public abstract T getPayload();

    public abstract Priority getPriority();
}
