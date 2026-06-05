package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.ExceptionUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Java7Support {
    static {
        try {
            if (ClassUtil.createInstance(Java7SupportImpl.class, false) == null) {
            } else {
                throw new ClassCastException();
            }
        } catch (IllegalAccessError unused) {
        } catch (Throwable th) {
            ExceptionUtil.rethrowIfFatal(th);
        }
    }

    public static Java7Support instance() {
        return null;
    }
}
