package com.urbandroid.sleep.captcha.camera;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.urbandroid.common.logging.Logger;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class CameraSource {
    private Map<byte[], ByteBuffer> mBytesToByteBuffer;
    private Camera mCamera;
    private final Object mCameraLock;
    private Context mContext;
    private int mFacing;
    private String mFlashMode;
    private String mFocusMode;
    private FrameProcessingRunnable mFrameProcessor;
    private Size mPreviewSize;
    private Thread mProcessingThread;
    private float mRequestedFps;
    private int mRequestedPreviewHeight;
    private int mRequestedPreviewWidth;
    private int mRotation;

    public static class Builder {
        private CameraSource mCameraSource;
        private final Detector<?> mDetector;

        public Builder(Context context, Detector<?> detector) {
            CameraSource cameraSource = new CameraSource(0);
            this.mCameraSource = cameraSource;
            if (context == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("No context supplied.");
                throw null;
            }
            if (detector == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("No detector supplied.");
                throw null;
            }
            this.mDetector = detector;
            cameraSource.mContext = context;
        }

        public CameraSource build() {
            CameraSource cameraSource = this.mCameraSource;
            Objects.requireNonNull(cameraSource);
            cameraSource.mFrameProcessor = cameraSource.new FrameProcessingRunnable(this.mDetector);
            return this.mCameraSource;
        }

        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                this.mCameraSource.mFacing = i;
                return this;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Invalid camera: "));
            return null;
        }

        public Builder setFlashMode(String str) {
            this.mCameraSource.mFlashMode = str;
            return this;
        }

        public Builder setFocusMode(String str) {
            this.mCameraSource.mFocusMode = str;
            return this;
        }

        public Builder setRequestedFps(float f) {
            if (f > 0.0f) {
                this.mCameraSource.mRequestedFps = f;
                return this;
            }
            Events$$ExternalSyntheticBUOutline0.m("Invalid fps: ", f);
            return null;
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(Fragment$$ExternalSyntheticOutline1.m(i, i2, "Invalid preview size: ", "x"));
                return null;
            }
            this.mCameraSource.mRequestedPreviewWidth = i;
            this.mCameraSource.mRequestedPreviewHeight = i2;
            return this;
        }
    }

    public class FrameProcessingRunnable implements Runnable {
        private Detector<?> mDetector;
        private ByteBuffer mPendingFrameData;
        private long mPendingTimeMillis;
        private long mStartTimeMillis = SystemClock.elapsedRealtime();
        private final Object mLock = new Object();
        private boolean mActive = true;
        private int mPendingFrameId = 0;

        public FrameProcessingRunnable(Detector<?> detector) {
            this.mDetector = detector;
        }

        public void release() {
            this.mDetector.release();
            this.mDetector = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Frame frameBuild;
            while (true) {
                synchronized (this.mLock) {
                    while (true) {
                        z = this.mActive;
                        if (!z || this.mPendingFrameData != null) {
                            break;
                        }
                        try {
                            this.mLock.wait();
                        } catch (InterruptedException e) {
                            Log.d("OpenCameraSource", "Frame processing loop terminated.", e);
                            return;
                        }
                    }
                    if (!z) {
                        return;
                    }
                    frameBuild = new Frame.Builder().setImageData(this.mPendingFrameData, CameraSource.this.mPreviewSize.getWidth(), CameraSource.this.mPreviewSize.getHeight(), 17).setId(this.mPendingFrameId).setTimestampMillis(this.mPendingTimeMillis).setRotation(CameraSource.this.mRotation).build();
                    ByteBuffer byteBuffer = this.mPendingFrameData;
                    this.mPendingFrameData = null;
                }
                try {
                    this.mDetector.receiveFrame(frameBuild);
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }

        public void setActive(boolean z) {
            synchronized (this.mLock) {
                this.mActive = z;
                this.mLock.notifyAll();
            }
        }

        public void setNextFrame(byte[] bArr, Camera camera) {
            synchronized (this.mLock) {
                try {
                    ByteBuffer byteBuffer = this.mPendingFrameData;
                    if (byteBuffer != null) {
                        camera.addCallbackBuffer(byteBuffer.array());
                        this.mPendingFrameData = null;
                    }
                    if (!CameraSource.this.mBytesToByteBuffer.containsKey(bArr)) {
                        Log.d("OpenCameraSource", "Skipping frame.  Could not find ByteBuffer associated with the image data from the camera.");
                        return;
                    }
                    this.mPendingTimeMillis = SystemClock.elapsedRealtime() - this.mStartTimeMillis;
                    this.mPendingFrameId++;
                    this.mPendingFrameData = (ByteBuffer) CameraSource.this.mBytesToByteBuffer.get(bArr);
                    this.mLock.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class SizePair {
        private Size mPicture;
        private Size mPreview;

        public SizePair(Camera.Size size, Camera.Size size2) {
            this.mPreview = new Size(size.width, size.height);
            if (size2 != null) {
                this.mPicture = new Size(size2.width, size2.height);
            }
        }

        public Size pictureSize() {
            return this.mPicture;
        }

        public Size previewSize() {
            return this.mPreview;
        }
    }

    private CameraSource() {
        this.mCameraLock = new Object();
        this.mFacing = 0;
        this.mRequestedFps = 30.0f;
        this.mRequestedPreviewWidth = 1024;
        this.mRequestedPreviewHeight = 768;
        this.mFocusMode = null;
        this.mFlashMode = null;
        this.mBytesToByteBuffer = new HashMap();
    }

    private Camera createCamera() {
        int idForRequestedCamera = getIdForRequestedCamera(this.mFacing);
        if (idForRequestedCamera == -1) {
            Types$$ExternalSyntheticBUOutline0.m$2("Could not find requested camera.");
            return null;
        }
        Camera cameraOpen = Camera.open(idForRequestedCamera);
        SizePair sizePairSelectSizePair = selectSizePair(cameraOpen, this.mRequestedPreviewWidth, this.mRequestedPreviewHeight);
        if (sizePairSelectSizePair == null) {
            Types$$ExternalSyntheticBUOutline0.m$2("Could not find suitable preview size.");
            return null;
        }
        Size sizePictureSize = sizePairSelectSizePair.pictureSize();
        this.mPreviewSize = sizePairSelectSizePair.previewSize();
        int[] iArrSelectPreviewFpsRange = selectPreviewFpsRange(cameraOpen, this.mRequestedFps);
        if (iArrSelectPreviewFpsRange == null) {
            Types$$ExternalSyntheticBUOutline0.m$2("Could not find suitable preview frames per second range.");
            return null;
        }
        Camera.Parameters parameters = cameraOpen.getParameters();
        if (sizePictureSize != null) {
            parameters.setPictureSize(sizePictureSize.getWidth(), sizePictureSize.getHeight());
        }
        parameters.setPreviewSize(this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight());
        int i = 0;
        parameters.setPreviewFpsRange(iArrSelectPreviewFpsRange[0], iArrSelectPreviewFpsRange[1]);
        parameters.setPreviewFormat(17);
        setRotation(cameraOpen, parameters, idForRequestedCamera);
        if (this.mFocusMode != null) {
            boolean zContains = parameters.getSupportedFocusModes().contains(this.mFocusMode);
            String str = this.mFocusMode;
            if (zContains) {
                parameters.setFocusMode(str);
            } else {
                Log.i("OpenCameraSource", "Camera focus mode: " + str + " is not supported on this device.");
            }
        }
        this.mFocusMode = parameters.getFocusMode();
        if (this.mFlashMode != null) {
            boolean zContains2 = parameters.getSupportedFlashModes().contains(this.mFlashMode);
            String str2 = this.mFlashMode;
            if (zContains2) {
                parameters.setFlashMode(str2);
            } else {
                Log.i("OpenCameraSource", "Camera flash mode: " + str2 + " is not supported on this device.");
            }
        }
        this.mFlashMode = parameters.getFlashMode();
        cameraOpen.setParameters(parameters);
        cameraOpen.setPreviewCallbackWithBuffer(new CameraPreviewCallback(this, i));
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        cameraOpen.addCallbackBuffer(createPreviewBuffer(this.mPreviewSize));
        return cameraOpen;
    }

    private byte[] createPreviewBuffer(Size size) {
        byte[] bArr = new byte[((int) Math.ceil(((double) ((size.getWidth() * size.getHeight()) * ImageFormat.getBitsPerPixel(17))) / 8.0d)) + 1];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (byteBufferWrap.hasArray() && byteBufferWrap.array() == bArr) {
            this.mBytesToByteBuffer.put(bArr, byteBufferWrap);
            return bArr;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Failed to create valid buffer for camera source.");
        return null;
    }

    private static List<SizePair> generateValidPreviewSizeList(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = size.width / size.height;
            Iterator<Camera.Size> it = supportedPictureSizes.iterator();
            while (true) {
                if (it.hasNext()) {
                    Camera.Size next = it.next();
                    if (Math.abs(f - (next.width / next.height)) < 0.01f) {
                        arrayList.add(new SizePair(size, next));
                        break;
                    }
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("OpenCameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            Iterator<Camera.Size> it2 = supportedPreviewSizes.iterator();
            while (it2.hasNext()) {
                arrayList.add(new SizePair(it2.next(), null));
            }
        }
        return arrayList;
    }

    private static int getIdForRequestedCamera(int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                return i2;
            }
        }
        return -1;
    }

    private int[] selectPreviewFpsRange(Camera camera, float f) {
        int i = (int) (f * 1000.0f);
        int[] iArr = null;
        int i2 = Integer.MAX_VALUE;
        for (int[] iArr2 : camera.getParameters().getSupportedPreviewFpsRange()) {
            int i3 = i - iArr2[0];
            int i4 = i - iArr2[1];
            int iAbs = Math.abs(i4) + Math.abs(i3);
            if (iAbs < i2) {
                iArr = iArr2;
                i2 = iAbs;
            }
        }
        return iArr;
    }

    private static SizePair selectSizePair(Camera camera, int i, int i2) {
        SizePair sizePair = null;
        int i3 = Integer.MAX_VALUE;
        for (SizePair sizePair2 : generateValidPreviewSizeList(camera)) {
            Size sizePreviewSize = sizePair2.previewSize();
            int iAbs = Math.abs(sizePreviewSize.getHeight() - i2) + Math.abs(sizePreviewSize.getWidth() - i);
            if (iAbs < i3) {
                sizePair = sizePair2;
                i3 = iAbs;
            }
        }
        return sizePair;
    }

    private void setRotation(Camera camera, Camera.Parameters parameters, int i) {
        int i2;
        int i3;
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        int i4 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i4 = 90;
            } else if (rotation == 2) {
                i4 = 180;
            } else if (rotation != 3) {
                Log.e("OpenCameraSource", "Bad rotation value: " + rotation);
            } else {
                i4 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int i5 = cameraInfo.facing;
        int i6 = cameraInfo.orientation;
        if (i5 == 1) {
            i2 = (i6 + i4) % 360;
            i3 = 360 - i2;
        } else {
            i2 = ((i6 - i4) + 360) % 360;
            i3 = i2;
        }
        this.mRotation = i2 / 90;
        try {
            camera.setDisplayOrientation(i3);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        parameters.setRotation(i2);
    }

    public int doZoom(float f) {
        float f2;
        synchronized (this.mCameraLock) {
            Camera camera = this.mCamera;
            if (camera == null) {
                return 0;
            }
            try {
                Camera.Parameters parameters = camera.getParameters();
                if (!parameters.isZoomSupported()) {
                    Log.w("OpenCameraSource", "Zoom is not supported on this device");
                    return 0;
                }
                int maxZoom = parameters.getMaxZoom();
                int zoom = parameters.getZoom() + 1;
                if (f > 1.0f) {
                    f2 = (f * (maxZoom / 10)) + zoom;
                } else {
                    f2 = f * zoom;
                }
                int iRound = Math.round(f2) - 1;
                if (iRound < 0) {
                    maxZoom = 0;
                } else if (iRound <= maxZoom) {
                    maxZoom = iRound;
                }
                parameters.setZoom(maxZoom);
                this.mCamera.setParameters(parameters);
                return maxZoom;
            } catch (Exception e) {
                Logger.logSevere(e);
                return 0;
            }
        }
    }

    public int getCameraFacing() {
        return this.mFacing;
    }

    public Size getPreviewSize() {
        return this.mPreviewSize;
    }

    public void release() {
        synchronized (this.mCameraLock) {
            stop();
            this.mFrameProcessor.release();
        }
    }

    public CameraSource start(SurfaceHolder surfaceHolder) {
        synchronized (this.mCameraLock) {
            try {
                if (this.mCamera != null) {
                    return this;
                }
                Camera cameraCreateCamera = createCamera();
                this.mCamera = cameraCreateCamera;
                cameraCreateCamera.setPreviewDisplay(surfaceHolder);
                this.mCamera.startPreview();
                this.mProcessingThread = new Thread(this.mFrameProcessor);
                this.mFrameProcessor.setActive(true);
                this.mProcessingThread.start();
                return this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028 A[Catch: all -> 0x0014, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0005, B:7:0x0010, B:12:0x001d, B:13:0x001f, B:15:0x0028, B:16:0x0030, B:20:0x0048, B:19:0x0037, B:21:0x004f, B:11:0x0016), top: B:27:0x0005, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: all -> 0x0014, DONT_GENERATE, TryCatch #1 {, blocks: (B:4:0x0005, B:7:0x0010, B:12:0x001d, B:13:0x001f, B:15:0x0028, B:16:0x0030, B:20:0x0048, B:19:0x0037, B:21:0x004f, B:11:0x0016), top: B:27:0x0005, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void stop() {
        Camera camera;
        synchronized (this.mCameraLock) {
            this.mFrameProcessor.setActive(false);
            Thread thread = this.mProcessingThread;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused) {
                    Log.d("OpenCameraSource", "Frame processing thread interrupted on release.");
                }
                this.mProcessingThread = null;
                this.mBytesToByteBuffer.clear();
                camera = this.mCamera;
                if (camera == null) {
                    camera.stopPreview();
                    this.mCamera.setPreviewCallbackWithBuffer(null);
                    try {
                        this.mCamera.setPreviewTexture(null);
                    } catch (Exception e) {
                        Log.e("OpenCameraSource", "Failed to clear camera preview: " + e);
                    }
                    this.mCamera.release();
                    this.mCamera = null;
                }
            } else {
                this.mBytesToByteBuffer.clear();
                camera = this.mCamera;
                if (camera == null) {
                }
            }
        }
    }

    public class CameraPreviewCallback implements Camera.PreviewCallback {
        private CameraPreviewCallback() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.mFrameProcessor.setNextFrame(bArr, camera);
        }

        public /* synthetic */ CameraPreviewCallback(CameraSource cameraSource, int i) {
            this();
        }
    }

    public /* synthetic */ CameraSource(int i) {
        this();
    }
}
