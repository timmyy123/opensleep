package com.urbandroid.sleep.mic;

import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class NaiveBayesClassifier {
    private ClassDistribution[] dist;

    public static class ClassDistribution {
        private double aprioryProbability;
        private double[] means;
        private double[] stdev;

        public ClassDistribution(double d, double[] dArr, double[] dArr2) {
            this.aprioryProbability = d;
            this.means = dArr;
            this.stdev = dArr2;
        }
    }

    public NaiveBayesClassifier(ClassDistribution... classDistributionArr) {
        this.dist = classDistributionArr;
    }

    public int classify(Double[] dArr) {
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        while (true) {
            ClassDistribution[] classDistributionArr = this.dist;
            if (i >= classDistributionArr.length) {
                return i2;
            }
            ClassDistribution classDistribution = classDistributionArr[i];
            if (dArr.length != classDistribution.means.length || dArr.length != classDistribution.stdev.length) {
                break;
            }
            double dPow = classDistribution.aprioryProbability;
            int i3 = 0;
            while (i3 < dArr.length) {
                double dDoubleValue = dArr[i3].doubleValue();
                double d2 = classDistribution.means[i3];
                double dPow2 = Math.pow(classDistribution.stdev[i3], 2.0d);
                dPow *= Math.pow(2.718281828459045d, (Math.pow(dDoubleValue - d2, 2.0d) * (-1.0d)) / (dPow2 * 2.0d)) * (1.0d / Math.sqrt(6.283185307179586d * dPow2));
                i3++;
                d = d;
            }
            double d3 = d;
            if (dPow > d3) {
                i2 = i;
                d = dPow;
            } else {
                d = d3;
            }
            i++;
        }
        Fragment$$ExternalSyntheticBUOutline0.m(dArr.length, "Instance length does not match the classifier, length ");
        return 0;
    }

    public int classify(double[]... dArr) {
        LinkedList linkedList = new LinkedList();
        for (double[] dArr2 : dArr) {
            for (double d : dArr2) {
                linkedList.add(Double.valueOf(d));
            }
        }
        return classify((Double[]) linkedList.toArray(new Double[0]));
    }
}
