package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes5.dex */
public interface RealMatrix extends AnyMatrix {
    RealMatrix copy();

    double[][] getData();

    double getEntry(int i, int i2);

    RealMatrix multiply(RealMatrix realMatrix);

    RealVector operate(RealVector realVector);

    double[] operate(double[] dArr);

    RealMatrix scalarMultiply(double d);

    void setColumnVector(int i, RealVector realVector);

    void setEntry(int i, int i2, double d);

    void setRowVector(int i, RealVector realVector);

    RealMatrix transpose();
}
