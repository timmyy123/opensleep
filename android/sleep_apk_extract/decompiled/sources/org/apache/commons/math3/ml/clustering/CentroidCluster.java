package org.apache.commons.math3.ml.clustering;

import org.apache.commons.math3.ml.clustering.Clusterable;

/* JADX INFO: loaded from: classes5.dex */
public class CentroidCluster<T extends Clusterable> extends Cluster<T> {
    private static final long serialVersionUID = -3075288519071812288L;
    private final Clusterable center;

    public CentroidCluster(Clusterable clusterable) {
        this.center = clusterable;
    }

    public Clusterable getCenter() {
        return this.center;
    }
}
