package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes5.dex */
public class ConvergenceException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;

    public ConvergenceException(Localizable localizable, Object... objArr) {
        getContext().addMessage(localizable, objArr);
    }
}
