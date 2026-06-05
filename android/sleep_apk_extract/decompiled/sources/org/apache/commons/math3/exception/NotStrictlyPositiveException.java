package org.apache.commons.math3.exception;

/* JADX INFO: loaded from: classes5.dex */
public class NotStrictlyPositiveException extends NumberIsTooSmallException {
    private static final long serialVersionUID = -7824848630829852237L;

    public NotStrictlyPositiveException(Number number) {
        super(number, MathIllegalNumberException.INTEGER_ZERO, false);
    }
}
