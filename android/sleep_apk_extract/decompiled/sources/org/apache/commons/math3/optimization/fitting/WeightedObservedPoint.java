package org.apache.commons.math3.optimization.fitting;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class WeightedObservedPoint implements Serializable {
    private static final long serialVersionUID = 5306874947404636157L;
    private final double weight;
    private final double x;
    private final double y;

    public WeightedObservedPoint(double d, double d2, double d3) {
        this.weight = d;
        this.x = d2;
        this.y = d3;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
