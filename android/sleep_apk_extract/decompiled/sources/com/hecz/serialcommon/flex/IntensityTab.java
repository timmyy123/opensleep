package com.hecz.serialcommon.flex;

import com.hecz.common.logging.Log;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public class IntensityTab {
    private int iIntensityTab = 0;
    public double[] intensityTabSec = new double[1000];
    public double[] intensityTabValue = new double[1000];
    int intensityCounter = 0;
    public int iMyIntensity = 0;
    public int myIntensityCounter = 0;
    private double lastValue = 1.0d;

    public IntensityTab() {
        Log.logger.log(Level.INFO, "IntensityTab::IntensityTab");
    }

    public void insert2intensityTab(double d, double d2) {
        if (this.lastValue != d2) {
            this.lastValue = d2;
            double[] dArr = this.intensityTabSec;
            int i = this.iIntensityTab;
            dArr[i] = d;
            double[] dArr2 = this.intensityTabValue;
            int i2 = i + 1;
            this.iIntensityTab = i2;
            dArr2[i] = d2;
            if (i2 >= dArr.length) {
                this.iIntensityTab = 0;
            }
            this.intensityCounter++;
        }
    }
}
