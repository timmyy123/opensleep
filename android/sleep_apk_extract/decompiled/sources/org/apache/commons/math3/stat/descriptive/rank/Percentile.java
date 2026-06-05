package org.apache.commons.math3.stat.descriptive.rank;

import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.KthSelector;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.MedianOf3PivotingStrategy;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes5.dex */
public class Percentile extends AbstractUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -8091216485095130416L;
    private int[] cachedPivots;
    private final EstimationType estimationType;
    private final KthSelector kthSelector;
    private final NaNStrategy nanStrategy;
    private double quantile;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.descriptive.rank.Percentile$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy;

        static {
            int[] iArr = new int[NaNStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy = iArr;
            try {
                iArr[NaNStrategy.MAXIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.MINIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public Percentile(double d, EstimationType estimationType, NaNStrategy naNStrategy, KthSelector kthSelector) {
        setQuantile(d);
        this.cachedPivots = null;
        MathUtils.checkNotNull(estimationType);
        MathUtils.checkNotNull(naNStrategy);
        MathUtils.checkNotNull(kthSelector);
        this.estimationType = estimationType;
        this.nanStrategy = naNStrategy;
        this.kthSelector = kthSelector;
    }

    private static double[] copyOf(double[] dArr, int i, int i2) {
        MathArrays.verifyValues(dArr, i, i2);
        return MathArrays.copyOfRange(dArr, i, i2 + i);
    }

    private int[] getPivots(double[] dArr) {
        if (dArr == getDataRef()) {
            return this.cachedPivots;
        }
        int[] iArr = new int[512];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private static double[] removeAndSlice(double[] dArr, int i, int i2, double d) {
        int i3;
        MathArrays.verifyValues(dArr, i, i2);
        BitSet bitSet = new BitSet(i2);
        int i4 = i;
        while (true) {
            i3 = i + i2;
            if (i4 >= i3) {
                break;
            }
            if (Precision.equalsIncludingNaN(d, dArr[i4])) {
                bitSet.set(i4 - i);
            }
            i4++;
        }
        if (bitSet.isEmpty()) {
            return copyOf(dArr, i, i2);
        }
        int iNextClearBit = 0;
        if (bitSet.cardinality() == i2) {
            return new double[0];
        }
        double[] dArr2 = new double[i2 - bitSet.cardinality()];
        int i5 = i;
        int i6 = 0;
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(iNextClearBit);
            if (iNextSetBit == -1) {
                break;
            }
            int i7 = iNextSetBit - iNextClearBit;
            System.arraycopy(dArr, i5, dArr2, i6, i7);
            i6 += i7;
            iNextClearBit = bitSet.nextClearBit(iNextSetBit);
            i5 = i + iNextClearBit;
        }
        if (i5 < i3) {
            System.arraycopy(dArr, i5, dArr2, i6, i3 - i5);
        }
        return dArr2;
    }

    private static double[] replaceAndSlice(double[] dArr, int i, int i2, double d, double d2) {
        double[] dArrCopyOf = copyOf(dArr, i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            dArrCopyOf[i3] = Precision.equalsIncludingNaN(d, dArrCopyOf[i3]) ? d2 : dArrCopyOf[i3];
        }
        return dArrCopyOf;
    }

    public double evaluate(double[] dArr, int i, int i2, double d) {
        test(dArr, i, i2);
        if (d > 100.0d || d <= 0.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(d), 0, 100);
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        if (i2 == 1) {
            return dArr[i];
        }
        double[] workArray = getWorkArray(dArr, i, i2);
        int[] pivots = getPivots(dArr);
        if (workArray.length == 0) {
            return Double.NaN;
        }
        return this.estimationType.evaluate(workArray, pivots, d, this.kthSelector);
    }

    public double[] getWorkArray(double[] dArr, int i, int i2) {
        if (dArr == getDataRef()) {
            return getDataRef();
        }
        int i3 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[this.nanStrategy.ordinal()];
        if (i3 == 1) {
            return replaceAndSlice(dArr, i, i2, Double.NaN, Double.POSITIVE_INFINITY);
        }
        if (i3 == 2) {
            return replaceAndSlice(dArr, i, i2, Double.NaN, Double.NEGATIVE_INFINITY);
        }
        if (i3 == 3) {
            return removeAndSlice(dArr, i, i2, Double.NaN);
        }
        if (i3 != 4) {
            return copyOf(dArr, i, i2);
        }
        double[] dArrCopyOf = copyOf(dArr, i, i2);
        MathArrays.checkNotNaN(dArrCopyOf);
        return dArrCopyOf;
    }

    public void setQuantile(double d) {
        if (d <= 0.0d || d > 100.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(d), 0, 100);
        }
        this.quantile = d;
    }

    public enum EstimationType {
        LEGACY("Legacy Apache Commons Math") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.1
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return Double.compare(d, 1.0d) == 0 ? i : d * ((double) (i + 1));
            }
        },
        R_1("R-1") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.2
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double estimate(double[] dArr, int[] iArr, double d, int i, KthSelector kthSelector) {
                return super.estimate(dArr, iArr, FastMath.ceil(d - 0.5d), i, kthSelector);
            }

            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return (((double) i) * d) + 0.5d;
            }
        },
        R_2("R-2") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.3
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double estimate(double[] dArr, int[] iArr, double d, int i, KthSelector kthSelector) {
                return (super.estimate(dArr, iArr, FastMath.ceil(d - 0.5d), i, kthSelector) + super.estimate(dArr, iArr, FastMath.floor(d + 0.5d), i, kthSelector)) / 2.0d;
            }

            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                if (Double.compare(d, 1.0d) == 0) {
                    return i;
                }
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return (((double) i) * d) + 0.5d;
            }
        },
        R_3("R-3") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.4
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                double d2 = i;
                if (Double.compare(d, 0.5d / d2) <= 0) {
                    return 0.0d;
                }
                return FastMath.rint(d2 * d);
            }
        },
        R_4("R-4") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.5
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                double d2 = i;
                if (Double.compare(d, 1.0d / d2) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, 1.0d) == 0 ? d2 : d2 * d;
            }
        },
        R_5("R-5") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.6
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                double d2 = i;
                double d3 = (d2 - 0.5d) / d2;
                if (Double.compare(d, 0.5d / d2) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d3) >= 0 ? d2 : (d2 * d) + 0.5d;
            }
        },
        R_6("R-6") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.7
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                double d2 = i + 1;
                double d3 = i;
                double d4 = (1.0d * d3) / d2;
                if (Double.compare(d, 1.0d / d2) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d4) >= 0 ? d3 : d2 * d;
            }
        },
        R_7("R-7") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.8
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return Double.compare(d, 1.0d) == 0 ? i : (((double) (i - 1)) * d) + 1.0d;
            }
        },
        R_8("R-8") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.9
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                double d2 = i;
                double d3 = d2 + 0.3333333333333333d;
                double d4 = (d2 - 0.3333333333333333d) / d3;
                if (Double.compare(d, 0.6666666666666666d / d3) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d4) >= 0 ? d2 : (d3 * d) + 0.3333333333333333d;
            }
        },
        R_9("R-9") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.10
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i) {
                double d2 = i;
                double d3 = 0.25d + d2;
                double d4 = (d2 - 0.375d) / d3;
                if (Double.compare(d, 0.625d / d3) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d4) >= 0 ? d2 : (d3 * d) + 0.375d;
            }
        };

        private final String name;

        EstimationType(String str) {
            this.name = str;
        }

        public double estimate(double[] dArr, int[] iArr, double d, int i, KthSelector kthSelector) {
            double dFloor = FastMath.floor(d);
            int i2 = (int) dFloor;
            double d2 = d - dFloor;
            if (d < 1.0d) {
                return kthSelector.select(dArr, iArr, 0);
            }
            if (d >= i) {
                return kthSelector.select(dArr, iArr, i - 1);
            }
            double dSelect = kthSelector.select(dArr, iArr, i2 - 1);
            return ((kthSelector.select(dArr, iArr, i2) - dSelect) * d2) + dSelect;
        }

        public double evaluate(double[] dArr, int[] iArr, double d, KthSelector kthSelector) {
            MathUtils.checkNotNull(dArr);
            if (d > 100.0d || d <= 0.0d) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(d), 0, 100);
            }
            return estimate(dArr, iArr, index(d / 100.0d, dArr.length), dArr.length, kthSelector);
        }

        public abstract double index(double d, int i);

        /* synthetic */ EstimationType(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }
    }

    public Percentile(double d) {
        this(d, EstimationType.LEGACY, NaNStrategy.REMOVED, new KthSelector(new MedianOf3PivotingStrategy()));
    }

    public Percentile() {
        this(50.0d);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic
    public double evaluate(double[] dArr, int i, int i2) {
        return evaluate(dArr, i, i2, this.quantile);
    }

    public double evaluate(double[] dArr, double d) {
        test(dArr, 0, 0);
        return evaluate(dArr, 0, dArr.length, d);
    }
}
