package com.urbandroid.sleep.captcha.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.google.android.gms.common.images.Size;

/* JADX INFO: loaded from: classes4.dex */
public class CameraSourcePreview extends ViewGroup {
    private CameraSource mCameraSource;
    private Context mContext;
    private GraphicOverlay mOverlay;
    private boolean mStartRequested;
    private boolean mSurfaceAvailable;
    private SurfaceView mSurfaceView;

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mStartRequested = false;
        this.mSurfaceAvailable = false;
        SurfaceView surfaceView = new SurfaceView(context);
        this.mSurfaceView = surfaceView;
        surfaceView.getHolder().addCallback(new SurfaceCallback(this, 0));
        addView(this.mSurfaceView);
    }

    private boolean isPortraitMode() {
        int i = this.mContext.getResources().getConfiguration().orientation;
        if (i == 2) {
            return false;
        }
        if (i == 1) {
            return true;
        }
        Log.d("CameraSourcePreview", "isPortraitMode returning false by default");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startIfReady() {
        if (this.mStartRequested && this.mSurfaceAvailable) {
            this.mCameraSource.start(this.mSurfaceView.getHolder());
            if (this.mOverlay != null) {
                Size previewSize = this.mCameraSource.getPreviewSize();
                int iMin = Math.min(previewSize.getWidth(), previewSize.getHeight());
                int iMax = Math.max(previewSize.getWidth(), previewSize.getHeight());
                boolean zIsPortraitMode = isPortraitMode();
                GraphicOverlay graphicOverlay = this.mOverlay;
                if (zIsPortraitMode) {
                    graphicOverlay.setCameraInfo(iMin, iMax, this.mCameraSource.getCameraFacing());
                } else {
                    graphicOverlay.setCameraInfo(iMax, iMin, this.mCameraSource.getCameraFacing());
                }
                this.mOverlay.clear();
            }
            this.mStartRequested = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int height;
        Size previewSize;
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource == null || (previewSize = cameraSource.getPreviewSize()) == null) {
            width = 320;
            height = 240;
        } else {
            width = previewSize.getWidth();
            height = previewSize.getHeight();
        }
        if (!isPortraitMode()) {
            int i5 = width;
            width = height;
            height = i5;
        }
        int i6 = i3 - i;
        int i7 = i4 - i2;
        float f = height;
        float f2 = width;
        int i8 = (int) ((i6 / f) * f2);
        if (i8 > i7) {
            i6 = (int) ((i7 / f2) * f);
        } else {
            i7 = i8;
        }
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            getChildAt(i9).layout(0, 0, i6, i7);
        }
        try {
            startIfReady();
        } catch (Exception e) {
            Log.e("CameraSourcePreview", "Could not start camera source.", e);
        }
    }

    public void release() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.release();
            this.mCameraSource = null;
        }
    }

    public void start(CameraSource cameraSource) {
        if (cameraSource == null) {
            stop();
        }
        this.mCameraSource = cameraSource;
        if (cameraSource != null) {
            this.mStartRequested = true;
            try {
                startIfReady();
            } catch (Exception e) {
                Log.e("CameraSourcePreview", "Could not start camera source.", e);
            }
        }
    }

    public void stop() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.stop();
        }
    }

    public class SurfaceCallback implements SurfaceHolder.Callback {
        private SurfaceCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.mSurfaceAvailable = true;
            try {
                CameraSourcePreview.this.startIfReady();
            } catch (Exception e) {
                Log.e("CameraSourcePreview", "Could not start camera source.", e);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.mSurfaceAvailable = false;
        }

        public /* synthetic */ SurfaceCallback(CameraSourcePreview cameraSourcePreview, int i) {
            this();
        }
    }

    public void start(CameraSource cameraSource, GraphicOverlay graphicOverlay) {
        this.mOverlay = graphicOverlay;
        start(cameraSource);
    }
}
