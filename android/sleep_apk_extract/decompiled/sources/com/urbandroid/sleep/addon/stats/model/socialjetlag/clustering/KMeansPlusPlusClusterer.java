package com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering;

import com.urbandroid.sleep.addon.stats.model.socialjetlag.CyclicDoubleKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.clustering.Clusterer;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public class KMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {
    private final double[] cycles;
    private final int k;
    private final int maxIterations;
    private final RandomGenerator random;

    /* JADX INFO: loaded from: classes4.dex */
    public static class CyclicEuclideanDistance implements DistanceMeasure {
        private final double[] cycles;

        public CyclicEuclideanDistance(double[] dArr) {
            this.cycles = dArr;
        }

        @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
        public double compute(double[] dArr, double[] dArr2) {
            double d = 0.0d;
            for (int i = 0; i < dArr.length; i++) {
                double dDistance = CyclicDoubleKt.distance(dArr[i], dArr2[i], this.cycles[i]);
                d += dDistance * dDistance;
            }
            return FastMath.sqrt(d);
        }
    }

    public KMeansPlusPlusClusterer(int i, int i2, double[] dArr) {
        super(new CyclicEuclideanDistance(dArr));
        this.k = i;
        this.maxIterations = i2;
        this.random = new JDKRandomGenerator();
        this.cycles = dArr;
    }

    private int assignPointsToClusters(List<CentroidCluster<T>> list, Collection<T> collection, int[] iArr) {
        int i = 0;
        int i2 = 0;
        for (T t : collection) {
            int nearestCluster = getNearestCluster(list, t);
            if (nearestCluster != iArr[i2]) {
                i++;
            }
            list.get(nearestCluster).addPoint(t);
            iArr[i2] = nearestCluster;
            i2++;
        }
        return i;
    }

    private Clusterable centroidOf(Collection<T> collection) {
        int length = this.cycles.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            double[] dArr2 = new double[collection.size()];
            Iterator<T> it = collection.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                dArr2[i2] = it.next().getPoint()[i];
                i2++;
            }
            dArr[i] = CyclicDoubleKt.center(dArr2, this.cycles[i]);
        }
        return new DoublePoint(dArr);
    }

    private List<CentroidCluster<T>> chooseInitialCenters(Collection<T> collection) {
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(collection));
        int size = listUnmodifiableList.size();
        boolean[] zArr = new boolean[size];
        ArrayList arrayList = new ArrayList();
        int iNextInt = this.random.nextInt(size);
        Clusterable clusterable = (Clusterable) listUnmodifiableList.get(iNextInt);
        arrayList.add(new CentroidCluster(clusterable));
        zArr[iNextInt] = true;
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            if (i != iNextInt) {
                double dDistance = distance(clusterable, (Clusterable) listUnmodifiableList.get(i));
                dArr[i] = dDistance * dDistance;
            }
        }
        while (arrayList.size() < this.k) {
            double d = 0.0d;
            double d2 = 0.0d;
            for (int i2 = 0; i2 < size; i2++) {
                if (!zArr[i2]) {
                    d2 += dArr[i2];
                }
            }
            double dNextDouble = this.random.nextDouble() * d2;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (!zArr[i3]) {
                    d += dArr[i3];
                    if (d >= dNextDouble) {
                        break;
                    }
                }
                i3++;
            }
            if (i3 == -1) {
                int i4 = size - 1;
                while (true) {
                    if (i4 < 0) {
                        break;
                    }
                    if (!zArr[i4]) {
                        i3 = i4;
                        break;
                    }
                    i4--;
                }
            }
            if (i3 < 0) {
                break;
            }
            Clusterable clusterable2 = (Clusterable) listUnmodifiableList.get(i3);
            arrayList.add(new CentroidCluster(clusterable2));
            zArr[i3] = true;
            if (arrayList.size() < this.k) {
                for (int i5 = 0; i5 < size; i5++) {
                    if (!zArr[i5]) {
                        double dDistance2 = distance(clusterable2, (Clusterable) listUnmodifiableList.get(i5));
                        double d3 = dDistance2 * dDistance2;
                        if (d3 < dArr[i5]) {
                            dArr[i5] = d3;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private int getNearestCluster(Collection<CentroidCluster<T>> collection, T t) {
        Iterator<CentroidCluster<T>> it = collection.iterator();
        double d = Double.MAX_VALUE;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            double dDistance = distance(t, it.next().getCenter());
            if (dDistance < d) {
                i = i2;
                d = dDistance;
            }
            i2++;
        }
        return i;
    }

    private T getPointFromLargestVarianceCluster(Collection<CentroidCluster<T>> collection) {
        double d = Double.NEGATIVE_INFINITY;
        CentroidCluster<T> centroidCluster = null;
        for (CentroidCluster<T> centroidCluster2 : collection) {
            if (!centroidCluster2.getPoints().isEmpty()) {
                Clusterable center = centroidCluster2.getCenter();
                Variance variance = new Variance();
                Iterator<T> it = centroidCluster2.getPoints().iterator();
                while (it.hasNext()) {
                    variance.increment(distance(it.next(), center));
                }
                double result = variance.getResult();
                if (result > d) {
                    centroidCluster = centroidCluster2;
                    d = result;
                }
            }
        }
        if (centroidCluster == null) {
            throw new ConvergenceException(LocalizedFormats.EMPTY_CLUSTER_IN_K_MEANS, new Object[0]);
        }
        List<T> points = centroidCluster.getPoints();
        return points.remove(this.random.nextInt(points.size()));
    }

    public List<CentroidCluster<T>> cluster(Collection<T> collection) {
        boolean z;
        Clusterable pointFromLargestVarianceCluster;
        MathUtils.checkNotNull(collection);
        if (collection.size() < this.k) {
            throw new NumberIsTooSmallException(Integer.valueOf(collection.size()), Integer.valueOf(this.k), false);
        }
        List<CentroidCluster<T>> listChooseInitialCenters = chooseInitialCenters(collection);
        int[] iArr = new int[collection.size()];
        assignPointsToClusters(listChooseInitialCenters, collection, iArr);
        int i = this.maxIterations;
        if (i < 0) {
            i = Integer.MAX_VALUE;
        }
        int i2 = 0;
        while (i2 < i) {
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            for (CentroidCluster<T> centroidCluster : listChooseInitialCenters) {
                if (centroidCluster.getPoints().isEmpty()) {
                    pointFromLargestVarianceCluster = getPointFromLargestVarianceCluster(listChooseInitialCenters);
                    z = true;
                } else {
                    Clusterable clusterableCentroidOf = centroidOf(centroidCluster.getPoints());
                    z = z2;
                    pointFromLargestVarianceCluster = clusterableCentroidOf;
                }
                arrayList.add(new CentroidCluster(pointFromLargestVarianceCluster));
                z2 = z;
            }
            if (assignPointsToClusters(arrayList, collection, iArr) == 0 && !z2) {
                return arrayList;
            }
            i2++;
            listChooseInitialCenters = arrayList;
        }
        return listChooseInitialCenters;
    }
}
