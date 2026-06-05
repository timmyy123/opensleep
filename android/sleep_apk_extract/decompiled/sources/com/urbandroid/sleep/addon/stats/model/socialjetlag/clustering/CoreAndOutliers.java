package com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes4.dex */
public class CoreAndOutliers<T> {
    private final List<T> core;
    private final List<T> outliers = new ArrayList();

    public CoreAndOutliers(Collection<T> collection) {
        this.core = new ArrayList(collection);
    }

    @SafeVarargs
    public static <T> CoreAndOutliers<T> compoundQuantileDistance(Collection<T> collection, double d, double d2, DoubleFunction<T>... doubleFunctionArr) {
        CoreAndOutliers<T> coreAndOutliers = new CoreAndOutliers<>(collection);
        int length = doubleFunctionArr.length;
        int i = 0;
        while (i < length) {
            Collection<T> collection2 = collection;
            coreAndOutliers = coreAndOutliers.markOutliers(getQuantileDistanceOutliers(collection2, d, d2, doubleFunctionArr[i]));
            i++;
            collection = collection2;
        }
        return coreAndOutliers;
    }

    public static <T> CoreAndOutliers<T> compoundQuantileDistanceXY(Collection<T> collection, double d, double d2, DoubleFunction<T> doubleFunction, double d3, double d4, DoubleFunction<T> doubleFunction2) {
        return new CoreAndOutliers(collection).markOutliers(getQuantileDistanceOutliers(collection, d, d2, doubleFunction)).markOutliers(getQuantileDistanceOutliers(collection, d3, d4, doubleFunction2));
    }

    private static <T> Set<T> getQuantileDistanceOutliers(Collection<T> collection, double d, double d2, DoubleFunction<T> doubleFunction) {
        if (d <= 0.0d || d >= 1.0d) {
            Home$$ExternalSyntheticBUOutline0.m("quantile: ", d);
            return null;
        }
        if (d2 < 0.0d) {
            Home$$ExternalSyntheticBUOutline0.m("threshold: ", d2);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : collection) {
            arrayList.add(Pair.create(Double.valueOf(doubleFunction.apply(t)), t));
        }
        Collections.sort(arrayList, new Comparator<Pair<Double, T>>() { // from class: com.urbandroid.sleep.addon.stats.model.socialjetlag.clustering.CoreAndOutliers.1
            @Override // java.util.Comparator
            public int compare(Pair<Double, T> pair, Pair<Double, T> pair2) {
                return Double.compare(pair.getFirst().doubleValue(), pair2.getFirst().doubleValue());
            }
        });
        int size = arrayList.size();
        int iIntValue = new Double(Math.ceil(d * ((double) size))).intValue();
        if (iIntValue >= size) {
            iIntValue = size - 1;
        }
        int i = (size - iIntValue) - 1;
        if (i - iIntValue < 3) {
            return Collections.EMPTY_SET;
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = iIntValue;
        while (i2 < i) {
            int i3 = i2 + 1;
            arrayList2.add(Double.valueOf(((Double) ((Pair) arrayList.get(i3)).getFirst()).doubleValue() - ((Double) ((Pair) arrayList.get(i2)).getFirst()).doubleValue()));
            i2 = i3;
        }
        double dEvaluate = new Percentile().evaluate(ScienceUtil.toDoubleArray(arrayList2), 80.0d) * d2;
        while (iIntValue > 0 && ((Double) ((Pair) arrayList.get(iIntValue)).getFirst()).doubleValue() - ((Double) ((Pair) arrayList.get(iIntValue - 1)).getFirst()).doubleValue() <= dEvaluate) {
            iIntValue--;
        }
        while (i < size - 1) {
            int i4 = i + 1;
            if (((Double) ((Pair) arrayList.get(i4)).getFirst()).doubleValue() - ((Double) ((Pair) arrayList.get(i)).getFirst()).doubleValue() > dEvaluate) {
                break;
            }
            i = i4;
        }
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < iIntValue; i5++) {
            hashSet.add(((Pair) arrayList.get(i5)).getSecond());
        }
        while (true) {
            i++;
            if (i >= size) {
                return hashSet;
            }
            hashSet.add(((Pair) arrayList.get(i)).getSecond());
        }
    }

    public List<T> getCore() {
        return this.core;
    }

    public List<T> getOutliers() {
        return this.outliers;
    }

    public CoreAndOutliers<T> markOutliers(Collection<T> collection) {
        HashSet hashSet = new HashSet(collection);
        CoreAndOutliers<T> coreAndOutliers = new CoreAndOutliers<>(Collections.EMPTY_LIST);
        coreAndOutliers.outliers.addAll(this.outliers);
        for (T t : this.core) {
            if (hashSet.contains(t)) {
                coreAndOutliers.outliers.add(t);
            } else {
                coreAndOutliers.core.add(t);
            }
        }
        return coreAndOutliers;
    }
}
