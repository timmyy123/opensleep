package org.apache.commons.math3.optimization.fitting;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class PolynomialFitter extends CurveFitter<PolynomialFunction.Parametric> {

    @Deprecated
    private final int degree;

    @Deprecated
    public PolynomialFitter(int i, DifferentiableMultivariateVectorOptimizer differentiableMultivariateVectorOptimizer) {
        super(differentiableMultivariateVectorOptimizer);
        this.degree = i;
    }

    @Deprecated
    public double[] fit() {
        return fit(new PolynomialFunction.Parametric(), new double[this.degree + 1]);
    }
}
