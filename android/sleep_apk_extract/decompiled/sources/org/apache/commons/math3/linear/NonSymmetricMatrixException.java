package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class NonSymmetricMatrixException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -7518495577824189882L;
    private final int column;
    private final int row;
    private final double threshold;

    public NonSymmetricMatrixException(int i, int i2, double d) {
        super(LocalizedFormats.NON_SYMMETRIC_MATRIX, Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d));
        this.row = i;
        this.column = i2;
        this.threshold = d;
    }
}
