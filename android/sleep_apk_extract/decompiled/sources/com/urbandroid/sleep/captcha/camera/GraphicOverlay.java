package com.urbandroid.sleep.captcha.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.urbandroid.sleep.captcha.camera.GraphicOverlay.Graphic;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class GraphicOverlay<T extends Graphic> extends View {
    private int mFacing;
    private T mFirstGraphic;
    private Set<T> mGraphics;
    private float mHeightScaleFactor;
    private final Object mLock;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private float mWidthScaleFactor;

    public static abstract class Graphic {
        private GraphicOverlay mOverlay;

        public Graphic(GraphicOverlay graphicOverlay) {
            this.mOverlay = graphicOverlay;
        }

        public abstract void draw(Canvas canvas);

        public void postInvalidate() {
            this.mOverlay.postInvalidate();
        }

        public float scaleX(float f) {
            return this.mOverlay.mWidthScaleFactor * f;
        }

        public float scaleY(float f) {
            return this.mOverlay.mHeightScaleFactor * f;
        }

        public float translateX(float f) {
            return this.mOverlay.mFacing == 1 ? this.mOverlay.getWidth() - scaleX(f) : scaleX(f);
        }

        public float translateY(float f) {
            return scaleY(f);
        }
    }

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLock = new Object();
        this.mWidthScaleFactor = 1.0f;
        this.mHeightScaleFactor = 1.0f;
        this.mFacing = 0;
        this.mGraphics = new HashSet();
    }

    public void add(T t) {
        synchronized (this.mLock) {
            try {
                this.mGraphics.add(t);
                if (this.mFirstGraphic == null) {
                    this.mFirstGraphic = t;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        postInvalidate();
    }

    public void clear() {
        synchronized (this.mLock) {
            this.mGraphics.clear();
            this.mFirstGraphic = null;
        }
        postInvalidate();
    }

    public T getFirstGraphic() {
        T t;
        synchronized (this.mLock) {
            t = this.mFirstGraphic;
        }
        return t;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.mLock) {
            try {
                if (this.mPreviewWidth != 0 && this.mPreviewHeight != 0) {
                    this.mWidthScaleFactor = canvas.getWidth() / this.mPreviewWidth;
                    this.mHeightScaleFactor = canvas.getHeight() / this.mPreviewHeight;
                }
                Iterator<T> it = this.mGraphics.iterator();
                while (it.hasNext()) {
                    it.next().draw(canvas);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void remove(T t) {
        synchronized (this.mLock) {
            try {
                this.mGraphics.remove(t);
                T t2 = this.mFirstGraphic;
                if (t2 != null && t2.equals(t)) {
                    this.mFirstGraphic = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        postInvalidate();
    }

    public void setCameraInfo(int i, int i2, int i3) {
        synchronized (this.mLock) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
            this.mFacing = i3;
        }
        postInvalidate();
    }
}
