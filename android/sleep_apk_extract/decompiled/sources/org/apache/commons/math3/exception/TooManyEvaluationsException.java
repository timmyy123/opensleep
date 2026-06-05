package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class TooManyEvaluationsException extends MaxCountExceededException {
    private static final long serialVersionUID = 4330003017885151975L;

    public TooManyEvaluationsException(Number number) {
        super(number);
        getContext().addMessage(LocalizedFormats.EVALUATIONS, new Object[0]);
    }
}
