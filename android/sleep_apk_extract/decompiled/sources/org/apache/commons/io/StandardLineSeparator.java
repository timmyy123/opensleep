package org.apache.commons.io;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public enum StandardLineSeparator {
    CR("\r"),
    CRLF("\r\n"),
    LF("\n");

    private final String lineSeparator;

    StandardLineSeparator(String str) {
        Objects.requireNonNull(str, "lineSeparator");
        this.lineSeparator = str;
    }

    public String getString() {
        return this.lineSeparator;
    }
}
