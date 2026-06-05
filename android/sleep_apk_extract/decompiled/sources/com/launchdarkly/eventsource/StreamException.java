package com.launchdarkly.eventsource;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StreamException extends Exception {
    public StreamException(String str) {
        super(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            StreamException streamException = (StreamException) obj;
            if (Objects.equals(getMessage(), streamException.getMessage()) && Objects.equals(getCause(), streamException.getCause())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(getMessage(), getCause());
    }

    public StreamException(Exception exc) {
        super(exc);
    }
}
