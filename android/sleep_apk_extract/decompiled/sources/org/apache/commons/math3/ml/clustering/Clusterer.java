package org.apache.commons.math3.ml.clustering;

import org.apache.commons.math3.ml.clustering.Clusterable;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Clusterer<T extends Clusterable> {
    private DistanceMeasure measure;

    public Clusterer(DistanceMeasure distanceMeasure) {
        this.measure = distanceMeasure;
    }

    public double distance(Clusterable clusterable, Clusterable clusterable2) {
        return this.measure.compute(clusterable.getPoint(), clusterable2.getPoint());
    }
}
