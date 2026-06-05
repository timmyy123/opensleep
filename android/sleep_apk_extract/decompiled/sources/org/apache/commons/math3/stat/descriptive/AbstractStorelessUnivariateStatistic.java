package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractStorelessUnivariateStatistic extends AbstractUnivariateStatistic implements StorelessUnivariateStatistic {
    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract void clear();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractStorelessUnivariateStatistic)) {
            return false;
        }
        AbstractStorelessUnivariateStatistic abstractStorelessUnivariateStatistic = (AbstractStorelessUnivariateStatistic) obj;
        return Precision.equalsIncludingNaN(abstractStorelessUnivariateStatistic.getResult(), getResult()) && Precision.equalsIncludingNaN((float) abstractStorelessUnivariateStatistic.getN(), (float) getN());
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] dArr, int i, int i2) {
        if (test(dArr, i, i2)) {
            clear();
            incrementAll(dArr, i, i2);
        }
        return getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract double getResult();

    public int hashCode() {
        return MathUtils.hash(getN()) + ((MathUtils.hash(getResult()) + 31) * 31);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract void increment(double d);

    public void incrementAll(double[] dArr, int i, int i2) {
        if (test(dArr, i, i2)) {
            int i3 = i2 + i;
            while (i < i3) {
                increment(dArr[i]);
                i++;
            }
        }
    }
}
