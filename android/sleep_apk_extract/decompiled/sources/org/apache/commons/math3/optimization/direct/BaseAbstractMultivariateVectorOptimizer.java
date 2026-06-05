package org.apache.commons.math3.optimization.direct;

import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.util.Incrementor;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class BaseAbstractMultivariateVectorOptimizer<FUNC extends MultivariateVectorFunction> implements BaseMultivariateVectorOptimizer<FUNC> {
    protected final Incrementor evaluations = new Incrementor();
    private FUNC function;
    private double[] start;
    private double[] target;

    @Deprecated
    private double[] weight;
    private RealMatrix weightMatrix;

    public BaseAbstractMultivariateVectorOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
    }

    private void checkParameters() {
        if (this.target.length != this.weightMatrix.getColumnDimension()) {
            throw new DimensionMismatchException(this.target.length, this.weightMatrix.getColumnDimension());
        }
    }

    private void parseOptimizationData(OptimizationData... optimizationDataArr) {
        for (OptimizationData optimizationData : optimizationDataArr) {
            if (optimizationData instanceof Target) {
                this.target = ((Target) optimizationData).getTarget();
            } else if (optimizationData instanceof Weight) {
                this.weightMatrix = ((Weight) optimizationData).getWeight();
            } else if (optimizationData instanceof InitialGuess) {
                this.start = ((InitialGuess) optimizationData).getInitialGuess();
            }
        }
    }

    public double[] computeObjectiveValue(double[] dArr) {
        try {
            this.evaluations.incrementCount();
            return this.function.value(dArr);
        } catch (MaxCountExceededException e) {
            throw new TooManyEvaluationsException(e.getMax());
        }
    }

    public abstract PointVectorValuePair doOptimize();

    public ConvergenceChecker<PointVectorValuePair> getConvergenceChecker() {
        return null;
    }

    public FUNC getObjectiveFunction() {
        return this.function;
    }

    public double[] getStartPoint() {
        return (double[]) this.start.clone();
    }

    public double[] getTarget() {
        return (double[]) this.target.clone();
    }

    public RealMatrix getWeight() {
        return this.weightMatrix.copy();
    }

    public PointVectorValuePair optimizeInternal(int i, FUNC func, OptimizationData... optimizationDataArr) {
        this.evaluations.setMaximalCount(i);
        this.evaluations.resetCount();
        this.function = func;
        parseOptimizationData(optimizationDataArr);
        checkParameters();
        setUp();
        return doOptimize();
    }

    public void setUp() {
        int length = this.target.length;
        this.weight = new double[length];
        for (int i = 0; i < length; i++) {
            this.weight[i] = this.weightMatrix.getEntry(i, i);
        }
    }
}
