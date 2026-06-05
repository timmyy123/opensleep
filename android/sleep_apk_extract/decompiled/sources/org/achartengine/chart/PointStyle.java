package org.achartengine.chart;

/* JADX INFO: loaded from: classes5.dex */
public enum PointStyle {
    X("x"),
    CIRCLE("circle"),
    TRIANGLE("triangle"),
    SQUARE("square"),
    DIAMOND("diamond"),
    POINT("point");

    private String mName;

    PointStyle(String str) {
        this.mName = str;
    }

    public static int getIndexForName(String str) {
        PointStyle[] pointStyleArrValues = values();
        int length = pointStyleArrValues.length;
        int i = -1;
        for (int i2 = 0; i2 < length && i < 0; i2++) {
            if (pointStyleArrValues[i2].mName.equals(str)) {
                i = i2;
            }
        }
        return Math.max(0, i);
    }

    public static PointStyle getPointStyleForName(String str) {
        PointStyle[] pointStyleArrValues = values();
        int length = pointStyleArrValues.length;
        PointStyle pointStyle = null;
        for (int i = 0; i < length && pointStyle == null; i++) {
            if (pointStyleArrValues[i].mName.equals(str)) {
                pointStyle = pointStyleArrValues[i];
            }
        }
        return pointStyle;
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
