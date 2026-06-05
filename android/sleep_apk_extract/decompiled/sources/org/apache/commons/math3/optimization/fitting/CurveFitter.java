package org.apache.commons.math3.optimization.fitting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class CurveFitter<T extends ParametricUnivariateFunction> {
    private final List<WeightedObservedPoint> observations = new ArrayList();

    @Deprecated
    private final DifferentiableMultivariateVectorOptimizer oldOptimizer;

    @Deprecated
    public class OldTheoreticalValuesFunction implements DifferentiableMultivariateVectorFunction {
        private final ParametricUnivariateFunction f;

        public OldTheoreticalValuesFunction(ParametricUnivariateFunction parametricUnivariateFunction) {
            this.f = parametricUnivariateFunction;
        }

        @Override // org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction
        public MultivariateMatrixFunction jacobian() {
            return new MultivariateMatrixFunction() { // from class: org.apache.commons.math3.optimization.fitting.CurveFitter.OldTheoreticalValuesFunction.1
                @Override // org.apache.commons.math3.analysis.MultivariateMatrixFunction
                public double[][] value(double[] dArr) {
                    double[][] dArr2 = new double[CurveFitter.this.observations.size()][];
                    Iterator it = CurveFitter.this.observations.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        dArr2[i] = OldTheoreticalValuesFunction.this.f.gradient(((WeightedObservedPoint) it.next()).getX(), dArr);
                        i++;
                    }
                    return dArr2;
                }
            };
        }

        @Override // org.apache.commons.math3.analysis.MultivariateVectorFunction
        public double[] value(double[] dArr) {
            double[] dArr2 = new double[CurveFitter.this.observations.size()];
            Iterator it = CurveFitter.this.observations.iterator();
            int i = 0;
            while (it.hasNext()) {
                dArr2[i] = this.f.value(((WeightedObservedPoint) it.next()).getX(), dArr);
                i++;
            }
            return dArr2;
        }
    }

    @Deprecated
    public CurveFitter(DifferentiableMultivariateVectorOptimizer differentiableMultivariateVectorOptimizer) {
        this.oldOptimizer = differentiableMultivariateVectorOptimizer;
    }

    public void addObservedPoint(double d, double d2, double d3) {
        this.observations.add(new WeightedObservedPoint(d, d2, d3));
    }

    public double[] fit(int i, T t, double[] dArr) {
        double[] dArr2 = new double[this.observations.size()];
        double[] dArr3 = new double[this.observations.size()];
        int i2 = 0;
        for (WeightedObservedPoint weightedObservedPoint : this.observations) {
            dArr2[i2] = weightedObservedPoint.getY();
            dArr3[i2] = weightedObservedPoint.getWeight();
            i2++;
        }
        return this.oldOptimizer.optimize(i, new OldTheoreticalValuesFunction(t), dArr2, dArr3, dArr).getPointRef();
    }

    public void addObservedPoint(double d, double d2) {
        addObservedPoint(1.0d, d, d2);
    }

    public double[] fit(T t, double[] dArr) {
        return fit(Integer.MAX_VALUE, t, dArr);
    }
}
