package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class NullArgumentException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -6024911025449780478L;

    public NullArgumentException() {
        this(LocalizedFormats.NULL_NOT_ALLOWED, new Object[0]);
    }

    public NullArgumentException(Localizable localizable, Object... objArr) {
        super(localizable, objArr);
    }
}
