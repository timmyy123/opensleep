package org.apache.commons.math3.optimization.general;

import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DiagonalMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.optimization.ConvergenceChecker;
import org.apache.commons.math3.optimization.DifferentiableMultivariateVectorOptimizer;
import org.apache.commons.math3.optimization.InitialGuess;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointVectorValuePair;
import org.apache.commons.math3.optimization.Target;
import org.apache.commons.math3.optimization.Weight;
import org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractLeastSquaresOptimizer extends BaseAbstractMultivariateVectorOptimizer<DifferentiableMultivariateVectorFunction> implements DifferentiableMultivariateVectorOptimizer {

    @Deprecated
    protected int cols;

    @Deprecated
    protected double cost;
    private MultivariateDifferentiableVectorFunction jF;
    private int jacobianEvaluations;

    @Deprecated
    protected double[] point;

    @Deprecated
    protected int rows;
    private RealMatrix weightMatrixSqrt;

    public AbstractLeastSquaresOptimizer(ConvergenceChecker<PointVectorValuePair> convergenceChecker) {
        super(convergenceChecker);
    }

    private RealMatrix squareRoot(RealMatrix realMatrix) {
        if (!(realMatrix instanceof DiagonalMatrix)) {
            return new EigenDecomposition(realMatrix).getSquareRoot();
        }
        int rowDimension = realMatrix.getRowDimension();
        DiagonalMatrix diagonalMatrix = new DiagonalMatrix(rowDimension);
        for (int i = 0; i < rowDimension; i++) {
            diagonalMatrix.setEntry(i, i, FastMath.sqrt(realMatrix.getEntry(i, i)));
        }
        return diagonalMatrix;
    }

    public double computeCost(double[] dArr) {
        ArrayRealVector arrayRealVector = new ArrayRealVector(dArr);
        return FastMath.sqrt(arrayRealVector.dotProduct(getWeight().operate(arrayRealVector)));
    }

    public double[] computeResiduals(double[] dArr) {
        double[] target = getTarget();
        if (dArr.length != target.length) {
            throw new DimensionMismatchException(target.length, dArr.length);
        }
        double[] dArr2 = new double[target.length];
        for (int i = 0; i < target.length; i++) {
            dArr2[i] = target[i] - dArr[i];
        }
        return dArr2;
    }

    public RealMatrix computeWeightedJacobian(double[] dArr) {
        this.jacobianEvaluations++;
        DerivativeStructure[] derivativeStructureArr = new DerivativeStructure[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            derivativeStructureArr[i] = new DerivativeStructure(length, 1, i, dArr[i]);
        }
        DerivativeStructure[] derivativeStructureArrValue = this.jF.value(derivativeStructureArr);
        int length2 = getTarget().length;
        if (derivativeStructureArrValue.length != length2) {
            throw new DimensionMismatchException(derivativeStructureArrValue.length, length2);
        }
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length2, length);
        for (int i2 = 0; i2 < length2; i2++) {
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = 1;
                dArr2[i2][i3] = derivativeStructureArrValue[i2].getPartialDerivative(iArr);
                iArr[i3] = 0;
            }
        }
        return this.weightMatrixSqrt.multiply(MatrixUtils.createRealMatrix(dArr2));
    }

    public double getChiSquare() {
        double d = this.cost;
        return d * d;
    }

    public double getRMS() {
        return FastMath.sqrt(getChiSquare() / ((double) this.rows));
    }

    public RealMatrix getWeightSquareRoot() {
        return this.weightMatrixSqrt.copy();
    }

    @Override // org.apache.commons.math3.optimization.BaseMultivariateVectorOptimizer
    @Deprecated
    public PointVectorValuePair optimize(int i, DifferentiableMultivariateVectorFunction differentiableMultivariateVectorFunction, double[] dArr, double[] dArr2, double[] dArr3) {
        return optimizeInternal(i, FunctionUtils.toMultivariateDifferentiableVectorFunction(differentiableMultivariateVectorFunction), new Target(dArr), new Weight(dArr2), new InitialGuess(dArr3));
    }

    @Deprecated
    public PointVectorValuePair optimizeInternal(int i, MultivariateDifferentiableVectorFunction multivariateDifferentiableVectorFunction, OptimizationData... optimizationDataArr) {
        return super.optimizeInternal(i, FunctionUtils.toDifferentiableMultivariateVectorFunction(multivariateDifferentiableVectorFunction), optimizationDataArr);
    }

    public void setCost(double d) {
        this.cost = d;
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateVectorOptimizer
    public void setUp() {
        super.setUp();
        this.jacobianEvaluations = 0;
        this.weightMatrixSqrt = squareRoot(getWeight());
        this.jF = FunctionUtils.toMultivariateDifferentiableVectorFunction(getObjectiveFunction());
        this.point = getStartPoint();
        this.rows = getTarget().length;
        this.cols = this.point.length;
    }
}
