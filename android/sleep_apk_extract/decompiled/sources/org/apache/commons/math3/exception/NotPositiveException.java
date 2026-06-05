package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes5.dex */
public class NotPositiveException extends NumberIsTooSmallException {
    private static final long serialVersionUID = -2250556892093726375L;

    public NotPositiveException(Localizable localizable, Number number) {
        super(localizable, number, MathIllegalNumberException.INTEGER_ZERO, true);
    }
}
