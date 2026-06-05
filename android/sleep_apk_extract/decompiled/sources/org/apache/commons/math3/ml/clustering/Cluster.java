package org.apache.commons.math3.ml.clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.ml.clustering.Clusterable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Cluster<T extends Clusterable> implements Serializable {
    private static final long serialVersionUID = -3442297081515880464L;
    private final List<T> points = new ArrayList();

    public void addPoint(T t) {
        this.points.add(t);
    }

    public List<T> getPoints() {
        return this.points;
    }
}
