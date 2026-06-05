package kotlin.reflect.jvm.internal.impl.storage;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
class SingleThreadValue<T> {
    private final Thread thread = Thread.currentThread();
    private final T value;

    public SingleThreadValue(T t) {
        this.value = t;
    }

    public T getValue() {
        if (hasValue()) {
            return this.value;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("No value in this thread (hasValue should be checked before)");
        return null;
    }

    public boolean hasValue() {
        return this.thread == Thread.currentThread();
    }
}
