package org.achartengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.model.Point;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.tools.FitZoom;
import org.achartengine.tools.Zoom;

/* JADX INFO: loaded from: classes5.dex */
public class GraphicalView extends View {
    private static final int ZOOM_BUTTONS_COLOR = Color.argb(175, 150, 150, 150);
    private Bitmap fitZoomImage;
    private AbstractChart mChart;
    private boolean mDrawn;
    private FitZoom mFitZoom;
    private Handler mHandler;
    private Paint mPaint;
    private Rect mRect;
    private DefaultRenderer mRenderer;
    private ITouchHandler mTouchHandler;
    private Zoom mZoomIn;
    private Zoom mZoomOut;
    private RectF mZoomR;
    private float oldX;
    private float oldY;
    private Bitmap zoomInImage;
    private Bitmap zoomOutImage;
    private int zoomSize;

    public GraphicalView(Context context, AbstractChart abstractChart) {
        int iIntValue;
        super(context);
        this.mRect = new Rect();
        this.mZoomR = new RectF();
        this.zoomSize = 50;
        this.mPaint = new Paint();
        this.mChart = abstractChart;
        this.mHandler = new Handler();
        AbstractChart abstractChart2 = this.mChart;
        if (abstractChart2 instanceof XYChart) {
            this.mRenderer = ((XYChart) abstractChart2).getRenderer();
        } else {
            this.mRenderer = ((RoundChart) abstractChart2).getRenderer();
        }
        if (this.mRenderer.isZoomButtonsVisible()) {
            this.zoomInImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom_in.png"));
            this.zoomOutImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom_out.png"));
            this.fitZoomImage = BitmapFactory.decodeStream(GraphicalView.class.getResourceAsStream("image/zoom-1.png"));
        }
        DefaultRenderer defaultRenderer = this.mRenderer;
        if ((defaultRenderer instanceof XYMultipleSeriesRenderer) && ((XYMultipleSeriesRenderer) defaultRenderer).getMarginsColor() == 0) {
            ((XYMultipleSeriesRenderer) this.mRenderer).setMarginsColor(this.mPaint.getColor());
        }
        if ((this.mRenderer.isZoomEnabled() && this.mRenderer.isZoomButtonsVisible()) || this.mRenderer.isExternalZoomEnabled()) {
            this.mZoomIn = new Zoom(this.mChart, true, this.mRenderer.getZoomRate());
            this.mZoomOut = new Zoom(this.mChart, false, this.mRenderer.getZoomRate());
            this.mFitZoom = new FitZoom(this.mChart);
        }
        try {
            iIntValue = Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (Exception unused) {
            iIntValue = 7;
        }
        AbstractChart abstractChart3 = this.mChart;
        if (iIntValue < 7) {
            this.mTouchHandler = new TouchHandlerOld(this, abstractChart3);
        } else {
            this.mTouchHandler = new TouchHandler(this, abstractChart3);
        }
    }

    public AbstractChart getChart() {
        return this.mChart;
    }

    public SeriesSelection getCurrentSeriesAndPoint() {
        return this.mChart.getSeriesAndPointForScreenCoordinate(new Point(this.oldX, this.oldY));
    }

    public RectF getZoomRectangle() {
        return this.mZoomR;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        canvas.getClipBounds(this.mRect);
        Rect rect = this.mRect;
        int i3 = rect.top;
        int i4 = rect.left;
        int iWidth = rect.width();
        int iHeight = this.mRect.height();
        if (this.mRenderer.isInScroll()) {
            iWidth = getMeasuredWidth();
            iHeight = getMeasuredHeight();
            i2 = 0;
            i = 0;
        } else {
            i = i3;
            i2 = i4;
        }
        int i5 = iWidth;
        int i6 = iHeight;
        this.mChart.draw(canvas, i2, i, i5, i6, this.mPaint);
        DefaultRenderer defaultRenderer = this.mRenderer;
        if (defaultRenderer != null && defaultRenderer.isZoomEnabled() && this.mRenderer.isZoomButtonsVisible()) {
            this.mPaint.setColor(ZOOM_BUTTONS_COLOR);
            int iMax = Math.max(this.zoomSize, Math.min(i5, i6) / 7);
            this.zoomSize = iMax;
            float f = i + i6;
            float f2 = i2 + i5;
            this.mZoomR.set(r6 - (iMax * 3), f - (iMax * 0.775f), f2, f);
            RectF rectF = this.mZoomR;
            int i7 = this.zoomSize;
            canvas.drawRoundRect(rectF, i7 / 3, i7 / 3, this.mPaint);
            int i8 = this.zoomSize;
            float f3 = f - (i8 * 0.625f);
            canvas.drawBitmap(this.zoomInImage, f2 - (i8 * 2.75f), f3, (Paint) null);
            canvas.drawBitmap(this.zoomOutImage, f2 - (this.zoomSize * 1.75f), f3, (Paint) null);
            canvas.drawBitmap(this.fitZoomImage, f2 - (this.zoomSize * 0.75f), f3, (Paint) null);
        }
        this.mDrawn = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.oldX = motionEvent.getX();
            this.oldY = motionEvent.getY();
        }
        DefaultRenderer defaultRenderer = this.mRenderer;
        if (defaultRenderer != null && this.mDrawn && ((defaultRenderer.isPanEnabled() || this.mRenderer.isZoomEnabled()) && this.mTouchHandler.handleTouch(motionEvent))) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void repaint() {
        this.mHandler.post(new Runnable() { // from class: org.achartengine.GraphicalView.1
            @Override // java.lang.Runnable
            public void run() {
                GraphicalView.this.invalidate();
            }
        });
    }

    public void setZoomRate(float f) {
        Zoom zoom = this.mZoomIn;
        if (zoom == null || this.mZoomOut == null) {
            return;
        }
        zoom.setZoomRate(f);
        this.mZoomOut.setZoomRate(f);
    }

    public void zoomIn() {
        Zoom zoom = this.mZoomIn;
        if (zoom != null) {
            zoom.apply(0);
            repaint();
        }
    }

    public void zoomOut() {
        Zoom zoom = this.mZoomOut;
        if (zoom != null) {
            zoom.apply(0);
            repaint();
        }
    }

    public void zoomReset() {
        FitZoom fitZoom = this.mFitZoom;
        if (fitZoom != null) {
            fitZoom.apply();
            this.mZoomIn.notifyZoomResetListeners();
            repaint();
        }
    }
}
