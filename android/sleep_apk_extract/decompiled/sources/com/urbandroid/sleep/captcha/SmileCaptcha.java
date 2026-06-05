package com.urbandroid.sleep.captcha;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.camera.AbstractVisionCaptcha;
import com.urbandroid.sleep.captcha.camera.GraphicOverlay;

/* JADX INFO: loaded from: classes4.dex */
public final class SmileCaptcha extends AbstractVisionCaptcha {
    private float targetHapiness = 0.6f;

    @Override // com.urbandroid.sleep.captcha.camera.AbstractVisionCaptcha
    public Detector createDetector() {
        FaceDetector faceDetectorBuild = new FaceDetector.Builder(getApplicationContext()).setClassificationType(1).build();
        if (!faceDetectorBuild.isOperational()) {
            getCaptchaSupport().solved();
            finish();
            Toast.makeText(this, "Sorry Google Vision service is down, please configure another CAPTCHA.", 1).show();
        }
        faceDetectorBuild.setProcessor(new MultiProcessor.Builder(new GraphicFaceTrackerFactory(this, 0)).build());
        return faceDetectorBuild;
    }

    @Override // com.urbandroid.sleep.captcha.camera.AbstractVisionCaptcha
    public int getCameraFacing() {
        return 1;
    }

    @Override // com.urbandroid.sleep.captcha.camera.AbstractVisionCaptcha
    public int getLayoutResource() {
        return R.layout.captcha_smile;
    }

    @Override // com.urbandroid.sleep.captcha.camera.AbstractVisionCaptcha, com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getResources().getBoolean(R.bool.portrait_only)) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        getSupportActionBar().setTitle(R.string.hint_smile);
        this.targetHapiness = (getCaptchaSupport().getDifficulty() * 0.05f) + 0.55f;
        final ImageView imageView = (ImageView) findViewById(R.id.smile);
        imageView.setVisibility(0);
        final Animation animationLoadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        new Handler().postDelayed(new Runnable() { // from class: com.urbandroid.sleep.captcha.SmileCaptcha.1
            @Override // java.lang.Runnable
            public void run() {
                imageView.startAnimation(animationLoadAnimation);
                imageView.setVisibility(8);
            }
        }, 1000L);
    }

    public class GraphicFaceTracker extends Tracker<Face> {
        private SmileGraphic mFaceGraphic;
        private GraphicOverlay mOverlay;

        public GraphicFaceTracker(GraphicOverlay graphicOverlay) {
            this.mOverlay = graphicOverlay;
            SmileGraphic smileGraphic = new SmileGraphic(graphicOverlay);
            this.mFaceGraphic = smileGraphic;
            smileGraphic.setTargetHapiness(SmileCaptcha.this.targetHapiness);
        }

        @Override // com.google.android.gms.vision.Tracker
        public void onDone() {
            this.mOverlay.remove(this.mFaceGraphic);
        }

        @Override // com.google.android.gms.vision.Tracker
        public void onMissing(Detector.Detections<Face> detections) {
            this.mOverlay.remove(this.mFaceGraphic);
        }

        @Override // com.google.android.gms.vision.Tracker
        public void onUpdate(Detector.Detections<Face> detections, Face face) {
            this.mOverlay.add(this.mFaceGraphic);
            this.mFaceGraphic.updateFace(face);
            if (Math.max(0.0f, face.getIsSmilingProbability()) > SmileCaptcha.this.targetHapiness) {
                SmileCaptcha.this.getCaptchaSupport().solved();
                SmileCaptcha.this.finish();
            }
        }

        @Override // com.google.android.gms.vision.Tracker
        public void onNewItem(int i, Face face) {
            this.mFaceGraphic.setId(i);
        }
    }

    public class GraphicFaceTrackerFactory implements MultiProcessor.Factory<Face> {
        private GraphicFaceTrackerFactory() {
        }

        @Override // com.google.android.gms.vision.MultiProcessor.Factory
        public Tracker<Face> create(Face face) {
            SmileCaptcha smileCaptcha = SmileCaptcha.this;
            return smileCaptcha.new GraphicFaceTracker(smileCaptcha.getGraphicOverlay());
        }

        public /* synthetic */ GraphicFaceTrackerFactory(SmileCaptcha smileCaptcha, int i) {
            this();
        }
    }
}
