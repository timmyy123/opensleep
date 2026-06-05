package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class NotANumberException extends MathIllegalNumberException {
    private static final long serialVersionUID = 20120906;

    public NotANumberException() {
        super(LocalizedFormats.NAN_NOT_ALLOWED, Double.valueOf(Double.NaN), new Object[0]);
    }
}
