package org.achartengine.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MathHelper {
    private static final NumberFormat FORMAT = NumberFormat.getNumberInstance();

    private static double[] computeLabels(double d, double d2, int i) {
        boolean z;
        if (Math.abs(d - d2) < 1.0000000116860974E-7d) {
            return new double[]{d, d, 0.0d};
        }
        if (d > d2) {
            d2 = d;
            d = d2;
            z = true;
        } else {
            z = false;
        }
        double dRoundUp = roundUp(Math.abs(d - d2) / ((double) i));
        double dCeil = Math.ceil(d / dRoundUp) * dRoundUp;
        double dFloor = Math.floor(d2 / dRoundUp) * dRoundUp;
        return z ? new double[]{dFloor, dCeil, dRoundUp * (-1.0d)} : new double[]{dCeil, dFloor, dRoundUp};
    }

    public static List<Double> getLabels(double d, double d2, int i) {
        ArrayList arrayList = new ArrayList();
        if (i > 0) {
            FORMAT.setMaximumFractionDigits(5);
            double[] dArrComputeLabels = computeLabels(d, d2, i);
            int i2 = ((int) ((dArrComputeLabels[1] - dArrComputeLabels[0]) / dArrComputeLabels[2])) + 1;
            for (int i3 = 0; i3 < i2; i3++) {
                double dDoubleValue = (((double) i3) * dArrComputeLabels[2]) + dArrComputeLabels[0];
                try {
                    NumberFormat numberFormat = FORMAT;
                    dDoubleValue = numberFormat.parse(numberFormat.format(dDoubleValue)).doubleValue();
                } catch (ParseException unused) {
                }
                arrayList.add(Double.valueOf(dDoubleValue));
            }
        }
        return arrayList;
    }

    private static double roundUp(double d) {
        int iFloor = (int) Math.floor(Math.log10(d));
        double dPow = Math.pow(10.0d, -iFloor) * d;
        if (dPow > 5.0d) {
            dPow = 10.0d;
        } else if (dPow > 2.0d) {
            dPow = 5.0d;
        } else if (dPow > 1.0d) {
            dPow = 2.0d;
        }
        return Math.pow(10.0d, iFloor) * dPow;
    }
}
