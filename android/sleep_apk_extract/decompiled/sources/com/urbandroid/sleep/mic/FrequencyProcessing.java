package com.urbandroid.sleep.mic;

import com.urbandroid.common.logging.Logger;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class FrequencyProcessing {
    public int borderIndex;
    public double threshold;
    public ArrayList<Float> vData = new ArrayList<>();
    public double[] peaks = new double[1];
    public double powerSum = 0.0d;
    public double fMax = 0.0d;
    public double fPeak = 0.0d;
    public double fMean = 0.0d;
    public double ratio = 0.0d;
    public double addition = 0.0d;
    public final int REDUCTION = 0;

    private double abs(double d, double d2) {
        return Math.sqrt(Math.pow(d2, 2.0d) + Math.pow(d, 2.0d));
    }

    public boolean[] detectSnoring(double[] dArr) {
        Logger.logInfo("DETECT START");
        boolean[] zArr = new boolean[2];
        if (dArr.length < 2) {
            zArr[0] = false;
            zArr[1] = false;
        }
        int length = dArr.length - 1;
        double[] dArr2 = new double[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            dArr2[i] = dArr[i2] - dArr[i];
            i = i2;
        }
        for (int i3 = 1; i3 < length; i3++) {
            double d = dArr2[i3 - 1];
            double d2 = 1.333d * d;
            double d3 = dArr2[i3];
            if (d2 > d3) {
                int i4 = (d3 > (d * 0.666d) ? 1 : (d3 == (d * 0.666d) ? 0 : -1));
            }
        }
        double d4 = this.fPeak;
        boolean z = (d4 > 40.0d && d4 < 300.0d) || (d4 > 400.0d && d4 < 1200.0d);
        Logger.logInfo("\nfPeak : " + this.fPeak + " Hz \nfMax : " + this.fMax + " Hz \nfMean : " + this.fMean + " Hz \nRatio :" + this.ratio);
        zArr[0] = z;
        Logger.logInfo("DETECT END");
        return zArr;
    }

    public double[] enlargeArray(double[] dArr) {
        double[] dArr2 = new double[dArr.length + 1];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
    }

    public double[][] enlargeDoubleArray(double[][] dArr) {
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, dArr.length + 1, dArr[0].length);
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
    }

    public int getBorderIndex() {
        return this.borderIndex;
    }

    public ArrayList<double[]> getFftArray(double[] dArr, int i) {
        return null;
    }

    public double[] getFrequencyArray(int i, int i2) {
        Logger.logInfo("FREQ START");
        double[] dArr = new double[i];
        dArr[0] = 0.0d;
        for (int i3 = 1; i3 < i; i3++) {
            dArr[i3] = (((double) i2) / ((double) i)) * ((double) i3);
        }
        Logger.logInfo("FREQ END");
        return dArr;
    }

    public double[] getPeaks(double[][] dArr) {
        Logger.logInfo("PEAK DETECT START");
        int i = 0;
        for (int i2 = 1; i2 < dArr.length - 1; i2++) {
            double d = dArr[i2 - 1][1];
            double[] dArr2 = dArr[i2];
            double d2 = dArr2[1];
            if (d < d2 && d2 > dArr[i2 + 1][1]) {
                double[] dArr3 = this.peaks;
                dArr3[i] = dArr2[0];
                this.peaks = enlargeArray(dArr3);
                i++;
            }
        }
        Logger.logInfo("PEAK END");
        return this.peaks;
    }

    public double[][] getSignificantFrequencies(double[] dArr, double[] dArr2, int i, double d) {
        double d2;
        double[][] dArrEnlargeDoubleArray = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 1, 2);
        Logger.logInfo("SIGNIFICANT START");
        double d3 = 0.9d * d;
        double d4 = d * 0.5d;
        double d5 = 0.0d;
        int i2 = 0;
        double d6 = 0.0d;
        double d7 = 0.0d;
        int i3 = 0;
        while (true) {
            if (i2 >= dArr.length) {
                break;
            }
            double d8 = dArr[i2];
            d6 += d8;
            if (dArr2[i2] <= 800.0d) {
                d7 += d8;
            }
            if (d6 <= d4 || this.fMean != d5) {
                d2 = d5;
            } else {
                int i4 = i2 - 1;
                d2 = d5;
                this.fMean = dArr2[i4];
                Logger.logInfo("mean   freq " + dArr2[i4]);
            }
            if (d6 > d3 && this.fMax == d2) {
                StringBuilder sb = new StringBuilder("max   freq ");
                int i5 = i2 - 1;
                sb.append(dArr2[i5]);
                Logger.logInfo(sb.toString());
                this.fMax = dArr2[i5];
                this.borderIndex = i2;
                this.ratio = d6 / d7;
                break;
            }
            if (dArr2[i2] < 60.0d) {
                i3++;
            }
            i2++;
            d5 = d2;
        }
        this.threshold = reducedMaximum(dArr, i3, 0) * 0.5d;
        int i6 = 0;
        for (int i7 = 4; i7 < dArr.length - 4; i7++) {
            double d9 = dArr[i7];
            double d10 = this.threshold;
            if (d9 > d10) {
                double d11 = dArr2[i7];
                if (d11 > 60.0d) {
                    double[] dArr3 = dArrEnlargeDoubleArray[i6];
                    dArr3[0] = d11;
                    dArr3[1] = (dArr[i7] / (d10 / 0.5d)) * 100.0d;
                    dArrEnlargeDoubleArray = enlargeDoubleArray(dArrEnlargeDoubleArray);
                    double[] dArr4 = dArrEnlargeDoubleArray[i6];
                    if (dArr4[1] == 100.0d) {
                        this.fPeak = dArr4[0];
                    }
                    i6++;
                }
            }
        }
        Logger.logInfo("SIGNIFICANT END");
        return dArrEnlargeDoubleArray;
    }

    public double reducedMaximum(double[] dArr, int i, int i2) {
        double d = 0.0d;
        while (i < dArr.length - i2) {
            if ((i % 50 == 0) & (i < (dArr.length / 2) - i2)) {
                this.vData.add(Float.valueOf((float) dArr[i]));
            }
            double d2 = dArr[i];
            if (d2 > d) {
                d = d2;
            }
            i++;
        }
        return d;
    }

    public void showFreqsInLog(double[] dArr) {
        for (double d : dArr) {
            Logger.logInfo("Interesting frequency : " + d + " Hz");
        }
    }
}
