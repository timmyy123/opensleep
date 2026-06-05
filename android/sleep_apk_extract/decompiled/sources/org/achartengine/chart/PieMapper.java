package org.achartengine.chart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;

/* JADX INFO: loaded from: classes5.dex */
public class PieMapper implements Serializable {
    private int mCenterX;
    private int mCenterY;
    private int mPieChartRadius;
    private List<PieSegment> mPieSegmentList = new ArrayList();

    public void addPieSegment(int i, float f, float f2, float f3) {
        this.mPieSegmentList.add(new PieSegment(i, f, f2, f3));
    }

    public boolean areAllSegmentPresent(int i) {
        return this.mPieSegmentList.size() == i;
    }

    public void clearPieSegments() {
        this.mPieSegmentList.clear();
    }

    public double getAngle(Point point) {
        double dAtan2 = Math.atan2(-(point.getY() - this.mCenterY), point.getX() - this.mCenterX);
        return Math.toDegrees(dAtan2 < 0.0d ? Math.abs(dAtan2) : 6.283185307179586d - dAtan2);
    }

    public SeriesSelection getSeriesAndPointForScreenCoordinate(Point point) {
        if (!isOnPieChart(point)) {
            return null;
        }
        double angle = getAngle(point);
        for (PieSegment pieSegment : this.mPieSegmentList) {
            if (pieSegment.isInSegment(angle)) {
                return new SeriesSelection(0, pieSegment.getDataIndex(), pieSegment.getValue(), pieSegment.getValue());
            }
        }
        return null;
    }

    public boolean isOnPieChart(Point point) {
        double dPow = Math.pow(this.mCenterY - point.getY(), 2.0d) + Math.pow(this.mCenterX - point.getX(), 2.0d);
        int i = this.mPieChartRadius;
        return dPow <= ((double) (i * i));
    }

    public void setDimensions(int i, int i2, int i3) {
        this.mPieChartRadius = i;
        this.mCenterX = i2;
        this.mCenterY = i3;
    }
}
