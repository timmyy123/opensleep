package org.apache.commons.math3.analysis;

/* JADX INFO: loaded from: classes5.dex */
public interface ParametricUnivariateFunction {
    double[] gradient(double d, double... dArr);

    double value(double d, double... dArr);
}
