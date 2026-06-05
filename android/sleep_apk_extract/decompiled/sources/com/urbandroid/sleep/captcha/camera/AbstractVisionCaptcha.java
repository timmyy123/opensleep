package com.urbandroid.sleep.captcha.camera;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facebook.ads.AdError;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.vision.Detector;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.AbstractCaptchaActivity;
import com.urbandroid.sleep.captcha.camera.CameraSource;
import com.urbandroid.sleep.gui.dialog.DialogUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractVisionCaptcha extends AbstractCaptchaActivity {
    private GraphicOverlay mGraphicOverlay;
    private CameraSourcePreview mPreview;
    private CameraSource mCameraSource = null;
    private float targetHapiness = 0.6f;

    private void createCameraSource() {
        Context applicationContext = getApplicationContext();
        Detector detectorCreateDetector = createDetector();
        if (!detectorCreateDetector.isOperational()) {
            Log.w("FaceTracker", "Detector dependencies are not yet available.");
        }
        this.mCameraSource = new CameraSource.Builder(applicationContext, detectorCreateDetector).setRequestedPreviewSize(640, 480).setFacing(getCameraFacing()).setRequestedFps(30.0f).build();
    }

    private void requestCameraPermission() {
        Log.w("FaceTracker", "Camera permission is not granted. Requesting permission");
        final String[] strArr = {"android.permission.CAMERA"};
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
            Snackbar.make(this.mGraphicOverlay, R.string.no_permission, -2).setAction(R.string.button_ok, new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.camera.AbstractVisionCaptcha.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.w("FaceTracker", "Camera permission tap");
                    ActivityCompat.requestPermissions(this, strArr, 2);
                }
            }).show();
        } else {
            Log.w("FaceTracker", "Camera no rationale");
            ActivityCompat.requestPermissions(this, strArr, 2);
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
            } catch (Exception e) {
                Log.e("FaceTracker", "Unable to start camera source.", e);
                Toast.makeText(this, "Cannot start the camera", 1).show();
                CameraSource cameraSource2 = this.mCameraSource;
                if (cameraSource2 != null) {
                    cameraSource2.release();
                    this.mCameraSource = null;
                }
                getCaptchaSupport().solved();
                finish();
            }
        }
    }

    public abstract Detector createDetector();

    public abstract int getCameraFacing();

    public GraphicOverlay getGraphicOverlay() {
        return this.mGraphicOverlay;
    }

    public abstract int getLayoutResource();

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.w("FaceTracker", "Create layout");
        setContentView(getLayoutResource());
        this.mPreview = (CameraSourcePreview) findViewById(R.id.preview);
        this.mGraphicOverlay = (GraphicOverlay) findViewById(R.id.faceOverlay);
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
            Log.w("FaceTracker", "Create camera");
            createCameraSource();
        } else {
            Log.w("FaceTracker", "Ask permission");
            requestCameraPermission();
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource != null) {
            cameraSource.release();
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mPreview.stop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 2) {
            Log.d("FaceTracker", "Got unexpected permission result: " + i);
            super.onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        if (iArr.length != 0 && iArr[0] == 0) {
            Log.d("FaceTracker", "Camera permission granted - initialize the camera source");
            createCameraSource();
            return;
        }
        StringBuilder sb = new StringBuilder("Permission not granted: results len = ");
        sb.append(iArr.length);
        sb.append(" Result code = ");
        sb.append(iArr.length > 0 ? Integer.valueOf(iArr[0]) : "(empty)");
        Log.e("FaceTracker", sb.toString());
        DialogUtil.fixButtonsAndDivider(new MaterialAlertDialogBuilder(this).setTitle((CharSequence) "Face Tracker sample").setMessage((CharSequence) "No CAMERA permission").setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.captcha.camera.AbstractVisionCaptcha.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                AbstractVisionCaptcha.this.finish();
            }
        }).show(), R.color.white);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        startCameraSource();
    }
}
