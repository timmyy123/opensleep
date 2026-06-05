package org.achartengine;

import android.graphics.RectF;
import android.view.MotionEvent;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.tools.Pan;

/* JADX INFO: loaded from: classes5.dex */
public class TouchHandlerOld implements ITouchHandler {
    private GraphicalView graphicalView;
    private Pan mPan;
    private DefaultRenderer mRenderer;
    private float oldX;
    private float oldY;
    private RectF zoomR;

    public TouchHandlerOld(GraphicalView graphicalView, AbstractChart abstractChart) {
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
    }

    @Override // org.achartengine.ITouchHandler
    public boolean handleTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mRenderer == null || action != 2) {
            if (action == 0) {
                this.oldX = motionEvent.getX();
                this.oldY = motionEvent.getY();
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
            } else if (action == 1) {
                this.oldX = 0.0f;
                this.oldY = 0.0f;
            }
        } else if (this.oldX >= 0.0f || this.oldY >= 0.0f) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.mRenderer.isPanEnabled()) {
                this.mPan.apply(this.oldX, this.oldY, x, y);
            }
            this.oldX = x;
            this.oldY = y;
            this.graphicalView.repaint();
            return true;
        }
        return !this.mRenderer.isClickEnabled();
    }
}
