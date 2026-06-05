package org.apache.commons.math3.stat.descriptive;

/* JADX INFO: loaded from: classes5.dex */
public interface StorelessUnivariateStatistic extends UnivariateStatistic {
    void clear();

    long getN();

    double getResult();

    void increment(double d);
}
