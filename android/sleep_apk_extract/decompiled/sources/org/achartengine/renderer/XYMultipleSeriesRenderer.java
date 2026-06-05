package org.achartengine.renderer;

import android.graphics.Paint;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class XYMultipleSeriesRenderer extends DefaultRenderer {
    private Map<Integer, double[]> initialRange;
    private float mAxisTitleTextSize;
    private double mBarSpacing;
    private float mBarWidth;
    private int[] mGridColors;
    private int mMarginsColor;
    private double[] mMaxX;
    private double[] mMaxY;
    private double[] mMinX;
    private double[] mMinY;
    private Orientation mOrientation;
    private double[] mPanLimits;
    private boolean mPanXEnabled;
    private boolean mPanYEnabled;
    private float mPointSize;
    private NumberFormat mXLabelFormat;
    private int mXLabels;
    private float mXLabelsAngle;
    private int mXLabelsColor;
    private float mXLabelsPadding;
    private boolean mXRoundedLabels;
    private Map<Double, String> mXTextLabels;
    private String mXTitle;
    private NumberFormat[] mYLabelFormat;
    private int mYLabels;
    private float mYLabelsAngle;
    private int[] mYLabelsColor;
    private float mYLabelsPadding;
    private float mYLabelsVerticalPadding;
    private Map<Integer, Map<Double, String>> mYTextLabels;
    private String[] mYTitle;
    private double mZoomInLimitX;
    private double mZoomInLimitY;
    private double[] mZoomLimits;
    private boolean mZoomXEnabled;
    private boolean mZoomYEnabled;
    private int scalesCount;
    private Paint.Align xLabelsAlign;
    private Paint.Align[] yAxisAlign;
    private Paint.Align[] yLabelsAlign;

    public enum Orientation {
        HORIZONTAL(0),
        VERTICAL(90);

        private int mAngle;

        Orientation(int i) {
            this.mAngle = i;
        }

        public int getAngle() {
            return this.mAngle;
        }
    }

    public XYMultipleSeriesRenderer(int i) {
        this.mXTitle = "";
        this.mAxisTitleTextSize = 12.0f;
        this.mXLabels = 5;
        this.mYLabels = 5;
        this.mOrientation = Orientation.HORIZONTAL;
        this.mXTextLabels = new HashMap();
        this.mYTextLabels = new LinkedHashMap();
        this.mPanXEnabled = true;
        this.mPanYEnabled = true;
        this.mZoomXEnabled = true;
        this.mZoomYEnabled = true;
        this.mBarSpacing = 0.0d;
        this.mMarginsColor = 0;
        this.initialRange = new LinkedHashMap();
        this.mPointSize = 3.0f;
        this.xLabelsAlign = Paint.Align.CENTER;
        this.mXLabelsPadding = 0.0f;
        this.mYLabelsPadding = 0.0f;
        this.mYLabelsVerticalPadding = 2.0f;
        this.mXLabelsColor = Color.LTGRAY;
        this.mYLabelsColor = new int[]{Color.LTGRAY};
        this.mXRoundedLabels = true;
        this.mBarWidth = -1.0f;
        this.mZoomInLimitX = 0.0d;
        this.mZoomInLimitY = 0.0d;
        this.scalesCount = i;
        initAxesRange(i);
    }

    public synchronized void addXTextLabel(double d, String str) {
        this.mXTextLabels.put(Double.valueOf(d), str);
    }

    public synchronized void addYTextLabel(double d, String str, int i) {
        this.mYTextLabels.get(Integer.valueOf(i)).put(Double.valueOf(d), str);
    }

    public float getAxisTitleTextSize() {
        return this.mAxisTitleTextSize;
    }

    public double getBarSpacing() {
        return this.mBarSpacing;
    }

    public float getBarWidth() {
        return this.mBarWidth;
    }

    public int getGridColor(int i) {
        return this.mGridColors[i];
    }

    public double[] getInitialRange(int i) {
        return this.initialRange.get(Integer.valueOf(i));
    }

    public NumberFormat getLabelFormat() {
        return getXLabelFormat();
    }

    public int getMarginsColor() {
        return this.mMarginsColor;
    }

    public Orientation getOrientation() {
        return this.mOrientation;
    }

    public double[] getPanLimits() {
        return this.mPanLimits;
    }

    public float getPointSize() {
        return this.mPointSize;
    }

    public int getScalesCount() {
        return this.scalesCount;
    }

    public double getXAxisMax(int i) {
        return this.mMaxX[i];
    }

    public double getXAxisMin(int i) {
        return this.mMinX[i];
    }

    public NumberFormat getXLabelFormat() {
        return this.mXLabelFormat;
    }

    public int getXLabels() {
        return this.mXLabels;
    }

    public Paint.Align getXLabelsAlign() {
        return this.xLabelsAlign;
    }

    public float getXLabelsAngle() {
        return this.mXLabelsAngle;
    }

    public int getXLabelsColor() {
        return this.mXLabelsColor;
    }

    public float getXLabelsPadding() {
        return this.mXLabelsPadding;
    }

    public synchronized String getXTextLabel(Double d) {
        return this.mXTextLabels.get(d);
    }

    public synchronized Double[] getXTextLabelLocations() {
        return (Double[]) this.mXTextLabels.keySet().toArray(new Double[0]);
    }

    public String getXTitle() {
        return this.mXTitle;
    }

    public Paint.Align getYAxisAlign(int i) {
        return this.yAxisAlign[i];
    }

    public double getYAxisMax(int i) {
        return this.mMaxY[i];
    }

    public double getYAxisMin(int i) {
        return this.mMinY[i];
    }

    public NumberFormat getYLabelFormat(int i) {
        return this.mYLabelFormat[i];
    }

    public int getYLabels() {
        return this.mYLabels;
    }

    public Paint.Align getYLabelsAlign(int i) {
        return this.yLabelsAlign[i];
    }

    public float getYLabelsAngle() {
        return this.mYLabelsAngle;
    }

    public int getYLabelsColor(int i) {
        return this.mYLabelsColor[i];
    }

    public float getYLabelsPadding() {
        return this.mYLabelsPadding;
    }

    public float getYLabelsVerticalPadding() {
        return this.mYLabelsVerticalPadding;
    }

    public synchronized String getYTextLabel(Double d, int i) {
        return this.mYTextLabels.get(Integer.valueOf(i)).get(d);
    }

    public synchronized Double[] getYTextLabelLocations(int i) {
        return (Double[]) this.mYTextLabels.get(Integer.valueOf(i)).keySet().toArray(new Double[0]);
    }

    public String getYTitle() {
        return getYTitle(0);
    }

    public double getZoomInLimitX() {
        return this.mZoomInLimitX;
    }

    public double getZoomInLimitY() {
        return this.mZoomInLimitY;
    }

    public double[] getZoomLimits() {
        return this.mZoomLimits;
    }

    public void initAxesRange(int i) {
        this.mYTitle = new String[i];
        this.yLabelsAlign = new Paint.Align[i];
        this.yAxisAlign = new Paint.Align[i];
        this.mYLabelsColor = new int[i];
        this.mYLabelFormat = new NumberFormat[i];
        this.mMinX = new double[i];
        this.mMaxX = new double[i];
        this.mMinY = new double[i];
        this.mMaxY = new double[i];
        this.mGridColors = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.mYLabelsColor[i2] = -3355444;
            this.mYLabelFormat[i2] = NumberFormat.getNumberInstance();
            this.mGridColors[i2] = android.graphics.Color.argb(75, 200, 200, 200);
            initAxesRangeForScale(i2);
        }
    }

    public void initAxesRangeForScale(int i) {
        double[] dArr = this.mMinX;
        dArr[i] = Double.MAX_VALUE;
        double[] dArr2 = this.mMaxX;
        dArr2[i] = -1.7976931348623157E308d;
        double[] dArr3 = this.mMinY;
        dArr3[i] = Double.MAX_VALUE;
        this.mMaxY[i] = -1.7976931348623157E308d;
        this.initialRange.put(Integer.valueOf(i), new double[]{dArr[i], dArr2[i], dArr3[i], -1.7976931348623157E308d});
        this.mYTitle[i] = "";
        this.mYTextLabels.put(Integer.valueOf(i), new HashMap());
        this.yLabelsAlign[i] = Paint.Align.CENTER;
        this.yAxisAlign[i] = Paint.Align.LEFT;
    }

    public boolean isInitialRangeSet(int i) {
        return this.initialRange.get(Integer.valueOf(i)) != null;
    }

    public boolean isMaxXSet(int i) {
        return this.mMaxX[i] != -1.7976931348623157E308d;
    }

    public boolean isMaxYSet(int i) {
        return this.mMaxY[i] != -1.7976931348623157E308d;
    }

    public boolean isMinXSet(int i) {
        return this.mMinX[i] != Double.MAX_VALUE;
    }

    public boolean isMinYSet(int i) {
        return this.mMinY[i] != Double.MAX_VALUE;
    }

    @Override // org.achartengine.renderer.DefaultRenderer
    public boolean isPanEnabled() {
        return isPanXEnabled() || isPanYEnabled();
    }

    public boolean isPanXEnabled() {
        return this.mPanXEnabled;
    }

    public boolean isPanYEnabled() {
        return this.mPanYEnabled;
    }

    public boolean isXRoundedLabels() {
        return this.mXRoundedLabels;
    }

    @Override // org.achartengine.renderer.DefaultRenderer
    public boolean isZoomEnabled() {
        return isZoomXEnabled() || isZoomYEnabled();
    }

    public boolean isZoomXEnabled() {
        return this.mZoomXEnabled;
    }

    public boolean isZoomYEnabled() {
        return this.mZoomYEnabled;
    }

    public void setAxisTitleTextSize(float f) {
        this.mAxisTitleTextSize = f;
    }

    public void setBarSpacing(double d) {
        this.mBarSpacing = d;
    }

    public void setBarWidth(float f) {
        this.mBarWidth = f;
    }

    public void setGridColor(int i) {
        setGridColor(i, 0);
    }

    public void setMarginsColor(int i) {
        this.mMarginsColor = i;
    }

    public void setPanEnabled(boolean z, boolean z2) {
        this.mPanXEnabled = z;
        this.mPanYEnabled = z2;
    }

    public void setPanLimits(double[] dArr) {
        this.mPanLimits = dArr;
    }

    public void setPointSize(float f) {
        this.mPointSize = f;
    }

    public void setRange(double[] dArr, int i) {
        setXAxisMin(dArr[0], i);
        setXAxisMax(dArr[1], i);
        setYAxisMin(dArr[2], i);
        setYAxisMax(dArr[3], i);
    }

    public void setXAxisMax(double d, int i) {
        if (!isMaxXSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[1] = d;
        }
        this.mMaxX[i] = d;
    }

    public void setXAxisMin(double d, int i) {
        if (!isMinXSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[0] = d;
        }
        this.mMinX[i] = d;
    }

    public void setXLabels(int i) {
        this.mXLabels = i;
    }

    public void setXLabelsAlign(Paint.Align align) {
        this.xLabelsAlign = align;
    }

    public void setXLabelsAngle(float f) {
        this.mXLabelsAngle = f;
    }

    public void setXLabelsPadding(float f) {
        this.mXLabelsPadding = f;
    }

    public void setXTitle(String str) {
        this.mXTitle = str;
    }

    public void setYAxisMax(double d, int i) {
        if (!isMaxYSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[3] = d;
        }
        this.mMaxY[i] = d;
    }

    public void setYAxisMin(double d, int i) {
        if (!isMinYSet(i)) {
            this.initialRange.get(Integer.valueOf(i))[2] = d;
        }
        this.mMinY[i] = d;
    }

    public void setYLabelFormat(NumberFormat numberFormat, int i) {
        this.mYLabelFormat[i] = numberFormat;
    }

    public void setYLabels(int i) {
        this.mYLabels = i;
    }

    public void setYLabelsAlign(Paint.Align align) {
        setYLabelsAlign(align, 0);
    }

    public void setYLabelsAngle(float f) {
        this.mYLabelsAngle = f;
    }

    public void setYLabelsPadding(float f) {
        this.mYLabelsPadding = f;
    }

    public void setYTitle(String str) {
        setYTitle(str, 0);
    }

    public void setZoomEnabled(boolean z, boolean z2) {
        this.mZoomXEnabled = z;
        this.mZoomYEnabled = z2;
    }

    public void setZoomInLimitY(double d) {
        this.mZoomInLimitY = d;
    }

    public void setZoomLimits(double[] dArr) {
        this.mZoomLimits = dArr;
    }

    public void setGridColor(int i, int i2) {
        this.mGridColors[i2] = i;
    }

    public void setPanEnabled(boolean z) {
        setPanEnabled(z, z);
    }

    public void setYLabelsAlign(Paint.Align align, int i) {
        this.yLabelsAlign[i] = align;
    }

    public void setYTitle(String str, int i) {
        this.mYTitle[i] = str;
    }

    public String getYTitle(int i) {
        return this.mYTitle[i];
    }

    public boolean isInitialRangeSet() {
        return isInitialRangeSet(0);
    }

    public void addYTextLabel(double d, String str) {
        addYTextLabel(d, str, 0);
    }

    public void setXAxisMax(double d) {
        setXAxisMax(d, 0);
    }

    public void setXAxisMin(double d) {
        setXAxisMin(d, 0);
    }

    public void setYAxisMax(double d) {
        setYAxisMax(d, 0);
    }

    public void setYAxisMin(double d) {
        setYAxisMin(d, 0);
    }

    public XYMultipleSeriesRenderer() {
        this(1);
    }
}
