package com.fasterxml.jackson.core;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class JacksonException extends IOException {
    private static final long serialVersionUID = 123;

    public JacksonException(String str) {
        super(str);
    }

    public abstract JsonLocation getLocation();

    public abstract String getOriginalMessage();

    public abstract Object getProcessor();

    public JacksonException(String str, Throwable th) {
        super(str, th);
    }
}
