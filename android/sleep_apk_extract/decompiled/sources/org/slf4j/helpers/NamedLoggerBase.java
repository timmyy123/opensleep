package org.slf4j.helpers;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
abstract class NamedLoggerBase implements Logger, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;

    @Override // org.slf4j.Logger
    public abstract String getName();

    public Object readResolve() {
        return LoggerFactory.getLogger(getName());
    }
}
