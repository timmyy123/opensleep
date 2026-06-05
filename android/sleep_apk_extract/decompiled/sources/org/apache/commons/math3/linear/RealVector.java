package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes5.dex */
public abstract class RealVector {
    public abstract void checkVectorDimensions(RealVector realVector);

    public double dotProduct(RealVector realVector) {
        checkVectorDimensions(realVector);
        int dimension = getDimension();
        double entry = 0.0d;
        for (int i = 0; i < dimension; i++) {
            entry += realVector.getEntry(i) * getEntry(i);
        }
        return entry;
    }

    public abstract int getDimension();

    public abstract double getEntry(int i);

    public abstract boolean isNaN();
}
