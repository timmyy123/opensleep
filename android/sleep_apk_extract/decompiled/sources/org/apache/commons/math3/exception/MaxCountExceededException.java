package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class MaxCountExceededException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;
    private final Number max;

    public MaxCountExceededException(Localizable localizable, Number number, Object... objArr) {
        getContext().addMessage(localizable, number, objArr);
        this.max = number;
    }

    public Number getMax() {
        return this.max;
    }

    public MaxCountExceededException(Number number) {
        this(LocalizedFormats.MAX_COUNT_EXCEEDED, number, new Object[0]);
    }
}
