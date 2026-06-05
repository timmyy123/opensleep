package org.achartengine;

import android.graphics.RectF;
import android.view.MotionEvent;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.tools.Pan;
import org.achartengine.tools.Zoom;

/* JADX INFO: loaded from: classes5.dex */
public class TouchHandler implements ITouchHandler {
    private GraphicalView graphicalView;
    private Pan mPan;
    private Zoom mPinchZoom;
    private DefaultRenderer mRenderer;
    private float oldX;
    private float oldX2;
    private float oldY;
    private float oldY2;
    private RectF zoomR;

    public TouchHandler(GraphicalView graphicalView, AbstractChart abstractChart) {
        this.zoomR = new RectF();
        this.graphicalView = graphicalView;
        this.zoomR = graphicalView.getZoomRectangle();
        if (abstractChart instanceof XYChart) {
            this.mRenderer = ((XYChart) abstractChart).getRenderer();
        } else {
            this.mRenderer = ((RoundChart) abstractChart).getRenderer();
        }
        if (this.mRenderer.isPanEnabled()) {
            this.mPan = new Pan(abstractChart);
        }
        if (this.mRenderer.isZoomEnabled()) {
            this.mPinchZoom = new Zoom(abstractChart, true, 1.0f);
        }
    }

    private void applyZoom(float f, int i) {
        float fMin = Math.min(Math.max(f, 0.9f), 1.1f);
        Zoom zoom = this.mPinchZoom;
        if (zoom != null) {
            double d = fMin;
            if (d <= 0.9d || d >= 1.1d) {
                return;
            }
            zoom.setZoomRate(fMin);
            this.mPinchZoom.apply(i);
        }
    }

    @Override // org.achartengine.ITouchHandler
    public boolean handleTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mRenderer == null || action != 2) {
            if (action == 0) {
                this.oldX = motionEvent.getX(0);
                this.oldY = motionEvent.getY(0);
                DefaultRenderer defaultRenderer = this.mRenderer;
                if (defaultRenderer != null && defaultRenderer.isZoomEnabled() && this.zoomR.contains(this.oldX, this.oldY)) {
                    float f = this.oldX;
                    RectF rectF = this.zoomR;
                    if (f < (rectF.width() / 3.0f) + rectF.left) {
                        this.graphicalView.zoomIn();
                    } else {
                        float f2 = this.oldX;
                        RectF rectF2 = this.zoomR;
                        float fWidth = ((rectF2.width() * 2.0f) / 3.0f) + rectF2.left;
                        GraphicalView graphicalView = this.graphicalView;
                        if (f2 < fWidth) {
                            graphicalView.zoomOut();
                        } else {
                            graphicalView.zoomReset();
                        }
                    }
                    return true;
                }
            } else if (action == 1 || action == 6) {
                this.oldX = 0.0f;
                this.oldY = 0.0f;
                this.oldX2 = 0.0f;
                this.oldY2 = 0.0f;
                if (action == 6) {
                    this.oldX = -1.0f;
                    this.oldY = -1.0f;
                }
            }
        } else if (this.oldX >= 0.0f || this.oldY >= 0.0f) {
            float x = motionEvent.getX(0);
            float y = motionEvent.getY(0);
            if (motionEvent.getPointerCount() > 1 && ((this.oldX2 >= 0.0f || this.oldY2 >= 0.0f) && this.mRenderer.isZoomEnabled())) {
                float x2 = motionEvent.getX(1);
                float y2 = motionEvent.getY(1);
                float fAbs = Math.abs(x - x2);
                float fAbs2 = Math.abs(y - y2);
                float fAbs3 = Math.abs(this.oldX - this.oldX2);
                float fAbs4 = Math.abs(this.oldY - this.oldY2);
                float fAbs5 = Math.abs(y - this.oldY) / Math.abs(x - this.oldX);
                float fAbs6 = Math.abs(y2 - this.oldY2) / Math.abs(x2 - this.oldX2);
                double d = fAbs5;
                if (d <= 0.25d && fAbs6 <= 0.25d) {
                    applyZoom(fAbs / fAbs3, 1);
                } else if (d < 3.73d || fAbs6 < 3.73d) {
                    applyZoom(Math.abs(x - this.oldX) >= Math.abs(y - this.oldY) ? fAbs / fAbs3 : fAbs2 / fAbs4, 0);
                } else {
                    applyZoom(fAbs2 / fAbs4, 2);
                }
                this.oldX2 = x2;
                this.oldY2 = y2;
            } else if (this.mRenderer.isPanEnabled()) {
                this.mPan.apply(this.oldX, this.oldY, x, y);
                this.oldX2 = 0.0f;
                this.oldY2 = 0.0f;
            }
            this.oldX = x;
            this.oldY = y;
            this.graphicalView.repaint();
            return true;
        }
        return !this.mRenderer.isClickEnabled();
    }
}
