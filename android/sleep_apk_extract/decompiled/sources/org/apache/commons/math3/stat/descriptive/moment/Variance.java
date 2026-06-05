package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;

/* JADX INFO: loaded from: classes5.dex */
public class Variance extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -9111962718267217978L;
    protected boolean incMoment = true;
    private boolean isBiasCorrected = true;
    protected SecondMoment moment;

    public Variance() {
        this.moment = null;
        this.moment = new SecondMoment();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void clear() {
        if (this.incMoment) {
            this.moment.clear();
        }
    }

    public double evaluate(double[] dArr, double d, int i, int i2) {
        double d2;
        if (!test(dArr, i, i2)) {
            return Double.NaN;
        }
        double d3 = 0.0d;
        if (i2 == 1) {
            return 0.0d;
        }
        if (i2 <= 1) {
            return Double.NaN;
        }
        double d4 = 0.0d;
        for (int i3 = i; i3 < i + i2; i3++) {
            double d5 = dArr[i3] - d;
            d3 += d5 * d5;
            d4 += d5;
        }
        double d6 = i2;
        if (this.isBiasCorrected) {
            d2 = d3 - ((d4 * d4) / d6);
            d6 -= 1.0d;
        } else {
            d2 = d3 - ((d4 * d4) / d6);
        }
        return d2 / d6;
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public long getN() {
        return this.moment.getN();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public double getResult() {
        double d;
        double d2;
        SecondMoment secondMoment = this.moment;
        long j = secondMoment.n;
        if (j == 0) {
            return Double.NaN;
        }
        if (j == 1) {
            return 0.0d;
        }
        if (this.isBiasCorrected) {
            d = secondMoment.m2;
            d2 = j - 1.0d;
        } else {
            d = secondMoment.m2;
            d2 = j;
        }
        return d / d2;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void increment(double d) {
        if (this.incMoment) {
            this.moment.increment(d);
        }
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic, org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] dArr, int i, int i2) {
        if (!test(dArr, i, i2)) {
            return Double.NaN;
        }
        clear();
        if (i2 == 1) {
            return 0.0d;
        }
        if (i2 > 1) {
            return evaluate(dArr, new Mean().evaluate(dArr, i, i2), i, i2);
        }
        return Double.NaN;
    }
}
