package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MultiDimensionMismatchException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -8415396756375798143L;
    private final Integer[] expected;
    private final Integer[] wrong;

    public MultiDimensionMismatchException(Localizable localizable, Integer[] numArr, Integer[] numArr2) {
        super(localizable, numArr, numArr2);
        this.wrong = (Integer[]) numArr.clone();
        this.expected = (Integer[]) numArr2.clone();
    }
}
