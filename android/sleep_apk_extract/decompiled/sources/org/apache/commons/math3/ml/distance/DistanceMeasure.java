package org.apache.commons.math3.ml.distance;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public interface DistanceMeasure extends Serializable {
    double compute(double[] dArr, double[] dArr2);
}
