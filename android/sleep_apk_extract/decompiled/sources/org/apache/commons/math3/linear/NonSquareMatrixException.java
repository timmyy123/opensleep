package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes5.dex */
public class NonSquareMatrixException extends DimensionMismatchException {
    private static final long serialVersionUID = -660069396594485772L;

    public NonSquareMatrixException(int i, int i2) {
        super(LocalizedFormats.NON_SQUARE_MATRIX, i, i2);
    }
}
