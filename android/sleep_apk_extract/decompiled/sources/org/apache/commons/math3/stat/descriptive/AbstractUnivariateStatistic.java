package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractUnivariateStatistic implements UnivariateStatistic {
    private double[] storedData;

    public double evaluate(double[] dArr) {
        test(dArr, 0, 0);
        return evaluate(dArr, 0, dArr.length);
    }

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic
    public abstract double evaluate(double[] dArr, int i, int i2);

    public double[] getDataRef() {
        return this.storedData;
    }

    public boolean test(double[] dArr, int i, int i2) {
        return MathArrays.verifyValues(dArr, i, i2, false);
    }

    public boolean test(double[] dArr, int i, int i2, boolean z) {
        return MathArrays.verifyValues(dArr, i, i2, z);
    }
}
