package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class NumberIsTooLargeException extends MathIllegalNumberException {
    private static final long serialVersionUID = 4330003017885151975L;
    private final boolean boundIsAllowed;
    private final Number max;

    public NumberIsTooLargeException(Localizable localizable, Number number, Number number2, boolean z) {
        super(localizable, number, number2);
        this.max = number2;
        this.boundIsAllowed = z;
    }

    public NumberIsTooLargeException(Number number, Number number2, boolean z) {
        this(z ? LocalizedFormats.NUMBER_TOO_LARGE : LocalizedFormats.NUMBER_TOO_LARGE_BOUND_EXCLUDED, number, number2, z);
    }
}
