package com.urbandroid.sleep.captcha.barcode;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facebook.ads.AdError;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.CaptchaSupport;
import com.urbandroid.sleep.captcha.CaptchaSupportFactory;
import com.urbandroid.sleep.captcha.QRCaptcha;
import com.urbandroid.sleep.captcha.camera.CameraSource;
import com.urbandroid.sleep.captcha.camera.CameraSourcePreview;
import com.urbandroid.sleep.captcha.camera.GraphicOverlay;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public final class BarcodeCaptureActivity extends BaseActivity {
    private CaptchaSupport captchaSupport;
    private GestureDetector gestureDetector;
    private Handler h;
    private CameraSource mCameraSource;
    private GraphicOverlay<BarcodeGraphic> mGraphicOverlay;
    private CameraSourcePreview mPreview;
    private ScaleGestureDetector scaleGestureDetector;
    private boolean useFlash = false;
    private boolean autoFocus = true;
    private Runnable checkDetector = new Runnable() { // from class: com.urbandroid.sleep.captcha.barcode.BarcodeCaptureActivity.1
        @Override // java.lang.Runnable
        public void run() {
            BarcodeCaptureActivity.this.onTap(0.0f, 0.0f);
            BarcodeCaptureActivity.this.h.postDelayed(this, 2000L);
        }
    };

    private void createCameraSource(boolean z, boolean z2) {
        BarcodeDetector barcodeDetectorBuild = new BarcodeDetector.Builder(getApplicationContext()).build();
        barcodeDetectorBuild.setProcessor(new MultiProcessor.Builder(new BarcodeTrackerFactory(this.mGraphicOverlay)).build());
        if (!barcodeDetectorBuild.isOperational()) {
            Logger.logWarning("QR Scanner: Camera permission is not granted. Requesting permission");
            if (ContextCompat.registerReceiver(this, null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW"), 2) != null) {
                Toast.makeText(this, "Low storage space", 1).show();
                Logger.logWarning("QR Scanner: Low storage space");
            } else {
                Toast.makeText(this, "Google Vision API error. Please install Barcode Scanner, QRDroid or Google Goggles.", 1).show();
            }
            Intent intent = new Intent();
            intent.putExtra("SCAN_RESULT", "com.urbandroid.sleep.ERROR_CANNOT_SCAN_CODE");
            setResult(-1, intent);
            finish();
        }
        this.mCameraSource = new CameraSource.Builder(getApplicationContext(), barcodeDetectorBuild).setFacing(0).setRequestedPreviewSize(1600, 1024).setRequestedFps(15.0f).setFocusMode(z ? "continuous-picture" : null).setFlashMode(z2 ? "torch" : null).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onTap(float f, float f2) {
        Barcode barcode;
        BarcodeGraphic barcodeGraphic = (BarcodeGraphic) this.mGraphicOverlay.getFirstGraphic();
        if (barcodeGraphic != null) {
            barcode = barcodeGraphic.getBarcode();
            if (barcode != null) {
                Intent intent = new Intent();
                intent.putExtra("SCAN_RESULT", barcode.rawValue);
                intent.putExtra("SCAN_RESULT_BYTES", barcode.rawValue.getBytes());
                setResult(-1, intent);
                finish();
            } else {
                Logger.logInfo("QR Scanner: barcode data is null");
            }
        } else {
            Logger.logInfo("QR Scanner: no barcode detected");
            barcode = null;
        }
        return barcode != null;
    }

    private void requestCameraPermission() {
        Logger.logInfo("QR Scanner: Camera permission is not granted. Requesting permission");
        final String[] strArr = {"android.permission.CAMERA"};
        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
            ActivityCompat.requestPermissions(this, strArr, 2);
        } else {
            Snackbar.make(this.mGraphicOverlay, "We need camera permission to be able to scan QR codes through your camera", -2).setAction(R.string.button_ok, new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.barcode.BarcodeCaptureActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(this, strArr, 2);
                }
            }).show();
        }
    }

    private void startCameraSource() {
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getApplicationContext());
        if (iIsGooglePlayServicesAvailable != 0) {
            GoogleApiAvailability.getInstance().getErrorDialog(this, iIsGooglePlayServicesAvailable, AdError.AD_PRESENTATION_ERROR_CODE).show();
        }
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            try {
                this.mPreview.start(cameraSource, this.mGraphicOverlay);
                this.h.postDelayed(this.checkDetector, 2000L);
            } catch (Exception e) {
                Logger.logSevere("QR Scanner: Unable to start camera source.", e);
                CameraSource cameraSource2 = this.mCameraSource;
                if (cameraSource2 != null) {
                    cameraSource2.release();
                }
                this.mCameraSource = null;
            }
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_barcode_capture);
        if (getResources().getBoolean(R.bool.portrait_only)) {
            setRequestedOrientation(1);
        }
        getWindow().addFlags(128);
        KeyguardUtil.disable(this);
        this.h = new Handler();
        this.mPreview = (CameraSourcePreview) findViewById(R.id.preview);
        this.mGraphicOverlay = (GraphicOverlay) findViewById(R.id.graphicOverlay);
        this.autoFocus = getIntent().getBooleanExtra("AutoFocus", true);
        int i = 0;
        this.useFlash = getIntent().getBooleanExtra("UseFlash", false);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            createCameraSource(this.autoFocus, this.useFlash);
        } else {
            requestCameraPermission();
        }
        this.gestureDetector = new GestureDetector(this, new CaptureGestureListener(this, i));
        this.scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener(this, i));
        this.captchaSupport = CaptchaSupportFactory.create(this).setRemainingTimeListener(null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(SharedApplicationContext.getSettings().isCodeCaptchaFallback() ? R.menu.barcode_menu : R.menu.barcode_menu_no_fallback, menu);
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.release();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        } else if (menuItem.getItemId() == R.id.flashlight) {
            toggleFlashlight();
        } else if (menuItem.getItemId() == R.id.menu_fallback) {
            Intent intent = new Intent(this, (Class<?>) QRCaptcha.class);
            intent.putExtra("extra_fallback", true);
            intent.addFlags(872546304);
            startActivity(intent);
            finish();
        }
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.stop();
        }
        this.h.removeCallbacks(this.checkDetector);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 2) {
            zza$$ExternalSyntheticOutline0.m(i, "QR Scanner: Got unexpected permission result: ");
            super.onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        if (iArr.length != 0 && iArr[0] == 0) {
            Logger.logInfo("QR Scanner: Camera permission granted - initialize the camera source");
            createCameraSource(getIntent().getBooleanExtra("AutoFocus", false), getIntent().getBooleanExtra("UseFlash", false));
            return;
        }
        StringBuilder sb = new StringBuilder("QR Scanner: Permission not granted: results len = ");
        sb.append(iArr.length);
        sb.append(" Result code = ");
        sb.append(iArr.length > 0 ? Integer.valueOf(iArr[0]) : "(empty)");
        Logger.logSevere(sb.toString());
        DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this).setTitle((CharSequence) "Multitracker sample").setMessage((CharSequence) "We need to have a permission to access your camera").setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.captcha.barcode.BarcodeCaptureActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                BarcodeCaptureActivity.this.finish();
            }
        }).show(), R.color.white);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        startCameraSource();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector = this.scaleGestureDetector;
        if (scaleGestureDetector == null || this.gestureDetector == null) {
            return false;
        }
        return scaleGestureDetector.onTouchEvent(motionEvent) || this.gestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void toggleFlashlight() {
        this.useFlash = !this.useFlash;
        CameraSourcePreview cameraSourcePreview = this.mPreview;
        if (cameraSourcePreview != null) {
            cameraSourcePreview.stop();
        }
        this.h.removeCallbacks(this.checkDetector);
        createCameraSource(this.autoFocus, this.useFlash);
        startCameraSource();
    }

    public class CaptureGestureListener extends GestureDetector.SimpleOnGestureListener {
        private CaptureGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return BarcodeCaptureActivity.this.onTap(motionEvent.getRawX(), motionEvent.getRawY()) || super.onSingleTapConfirmed(motionEvent);
        }

        public /* synthetic */ CaptureGestureListener(BarcodeCaptureActivity barcodeCaptureActivity, int i) {
            this();
        }
    }

    public class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {
        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            if (BarcodeCaptureActivity.this.mCameraSource != null) {
                BarcodeCaptureActivity.this.mCameraSource.doZoom(scaleGestureDetector.getScaleFactor());
            }
        }

        public /* synthetic */ ScaleListener(BarcodeCaptureActivity barcodeCaptureActivity, int i) {
            this();
        }
    }
}
