package org.apache.commons.math3.stat;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.UnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Max;
import org.apache.commons.math3.stat.descriptive.rank.Min;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.stat.descriptive.summary.SumOfLogs;
import org.apache.commons.math3.stat.descriptive.summary.SumOfSquares;

/* JADX INFO: loaded from: classes5.dex */
public abstract class StatUtils {
    private static final UnivariateStatistic SUM = new Sum();
    private static final UnivariateStatistic SUM_OF_SQUARES = new SumOfSquares();
    private static final UnivariateStatistic PRODUCT = new Product();
    private static final UnivariateStatistic SUM_OF_LOGS = new SumOfLogs();
    private static final UnivariateStatistic MIN = new Min();
    private static final UnivariateStatistic MAX = new Max();
    private static final UnivariateStatistic MEAN = new Mean();
    private static final Variance VARIANCE = new Variance();
    private static final Percentile PERCENTILE = new Percentile();
    private static final GeometricMean GEOMETRIC_MEAN = new GeometricMean();

    private static double[] getMode(double[] dArr, int i, int i2) {
        Frequency frequency = new Frequency();
        for (int i3 = i; i3 < i + i2; i3++) {
            double d = dArr[i3];
            if (!Double.isNaN(d)) {
                frequency.addValue(Double.valueOf(d));
            }
        }
        List<Comparable<?>> mode = frequency.getMode();
        double[] dArr2 = new double[mode.size()];
        Iterator<Comparable<?>> it = mode.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            dArr2[i4] = ((Double) it.next()).doubleValue();
            i4++;
        }
        return dArr2;
    }

    public static double[] mode(double[] dArr) {
        if (dArr != null) {
            return getMode(dArr, 0, dArr.length);
        }
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }
}
