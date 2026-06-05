package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class DimensionMismatchException extends MathIllegalNumberException {
    private static final long serialVersionUID = -8415396756375798143L;
    private final int dimension;

    public DimensionMismatchException(Localizable localizable, int i, int i2) {
        super(localizable, Integer.valueOf(i), Integer.valueOf(i2));
        this.dimension = i2;
    }

    public DimensionMismatchException(int i, int i2) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, i, i2);
    }
}
