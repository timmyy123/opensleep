package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes5.dex */
public class MathIllegalArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = -6024911025449780478L;
    private final ExceptionContext context;

    public MathIllegalArgumentException(Localizable localizable, Object... objArr) {
        ExceptionContext exceptionContext = new ExceptionContext(this);
        this.context = exceptionContext;
        exceptionContext.addMessage(localizable, objArr);
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.context.getLocalizedMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.context.getMessage();
    }
}
