package com.urbandroid.sleep.captcha.light;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.AbstractCaptchaActivity;

/* JADX INFO: loaded from: classes4.dex */
public class LightCaptcha extends AbstractCaptchaActivity implements SensorEventListener {
    private AnimationDrawable anim;
    private Handler handler;
    private Sensor lightSensor;
    private SensorManager sensorManager;
    private final String TAG = "LightCaptcha";
    private final int HUMAN_READABLE_PROGRESS_MAX = 100;
    private int overThresholdProgressCheckPoints = 0;
    private int target = 20000;
    private int overThresholdProgress = 0;
    private int threshold = 80;
    private long overThresholdStartTs = -1;
    private boolean solvedAlready = false;
    Runnable updateOverThresholdProgressRunnable = new Runnable() { // from class: com.urbandroid.sleep.captcha.light.LightCaptcha.1
        @Override // java.lang.Runnable
        public void run() {
            if (LightCaptcha.this.overThresholdStartTs > 0) {
                LightCaptcha.this.updateOverThresholdProgress();
                ((ProgressBar) LightCaptcha.this.findViewById(R.id.progress)).setMax(LightCaptcha.this.target);
                ((ProgressBar) LightCaptcha.this.findViewById(R.id.progress)).setProgress(LightCaptcha.this.overThresholdProgress);
                int iMin = Math.min(Math.round((LightCaptcha.this.overThresholdProgress * 100) / LightCaptcha.this.target), 100);
                ((TextView) LightCaptcha.this.findViewById(R.id.score)).setText(LightCaptcha.this.getString(R.string.hint_light_sufficient) + "\n" + iMin + "%");
                if (iMin / 10 > LightCaptcha.this.overThresholdProgressCheckPoints) {
                    LightCaptcha.this.getCaptchaSupport().alive();
                    LightCaptcha.this.overThresholdProgressCheckPoints++;
                }
                if (iMin == 100 && !LightCaptcha.this.solvedAlready) {
                    LightCaptcha.this.solve();
                }
            }
            LightCaptcha.this.handler.removeCallbacks(this);
            LightCaptcha.this.handler.postDelayed(this, 500L);
        }
    };

    private void initializeLightAnimation() {
        ImageView imageView = (ImageView) findViewById(R.id.zombie);
        imageView.setBackgroundDrawable(null);
        imageView.setBackgroundResource(R.drawable.captcha_light_bg_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        this.anim = animationDrawable;
        animationDrawable.start();
    }

    private void initializeSensorOrFinish() {
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.sensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.lightSensor = defaultSensor;
        if (defaultSensor == null) {
            Toast.makeText(getApplicationContext(), getString(R.string.compatibility_sensor), 1).show();
            solved();
            finish();
        }
    }

    private void resetOverThresholdProgress(float f) {
        ((ProgressBar) findViewById(R.id.progress)).setMax(this.threshold);
        ((ProgressBar) findViewById(R.id.progress)).setProgress((int) f);
        resetOverThresholdProgressCheckpoints();
        updateUiLight(f);
        ((TextView) findViewById(R.id.score)).setText(getString(R.string.hint_light_insufficient) + "\n" + Math.round(f) + " LUX ");
    }

    private void resetOverThresholdProgressCheckpoints() {
        this.overThresholdProgressCheckPoints = 0;
    }

    private int setInitialTarget() {
        int difficulty = getCaptchaSupport().getDifficulty() * 20000;
        if (difficulty < 0) {
            return 20000;
        }
        return difficulty;
    }

    private int setInitialThreshold() {
        return (getCaptchaSupport().getDifficulty() * 50) + 30;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void solve() {
        this.solvedAlready = true;
        solved();
        finish();
    }

    private void startOverThresholdProgress() {
        this.handler.post(this.updateOverThresholdProgressRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateOverThresholdProgress() {
        this.overThresholdProgress = (int) (System.currentTimeMillis() - this.overThresholdStartTs);
    }

    private void updateUiLight(float f) {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        int iRound = Math.round((f / this.threshold) * Math.min(defaultDisplay.getWidth(), defaultDisplay.getHeight()));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iRound, iRound);
        layoutParams.addRule(13, -1);
        ((ImageView) findViewById(R.id.zombie)).setLayoutParams(layoutParams);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.captcha_light);
        this.handler = new Handler();
        initializeSensorOrFinish();
        this.solvedAlready = false;
        this.threshold = setInitialThreshold();
        this.target = setInitialTarget();
        if (bundle != null) {
            this.overThresholdProgress = bundle.getInt("overThresholdProgress");
            this.overThresholdStartTs = bundle.getLong("over");
            this.overThresholdProgressCheckPoints = bundle.getInt("overThresholdProgressCheckPoints");
        }
        getSupportActionBar().setTitle(R.string.hint_light);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("overThresholdProgressCheckPoints", this.overThresholdProgressCheckPoints);
        bundle.putInt("overThresholdProgress", this.overThresholdProgress);
        bundle.putLong("over", this.overThresholdStartTs);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (f < 0.0f) {
            this.sensorManager.unregisterListener(this, this.lightSensor);
            this.sensorManager.registerListener(this, this.lightSensor, 3);
        }
        if (f > this.threshold) {
            updateUiLight(f);
            if (this.overThresholdStartTs < 0) {
                this.overThresholdStartTs = System.currentTimeMillis();
            }
            updateOverThresholdProgress();
        } else {
            this.overThresholdStartTs = -1L;
            this.overThresholdProgress = 0;
        }
        if (this.target - this.overThresholdProgress <= 0 && !this.solvedAlready) {
            solve();
        }
        if (this.overThresholdStartTs == -1) {
            resetOverThresholdProgress(f);
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.sensorManager.registerListener(this, this.lightSensor, 3);
        initializeLightAnimation();
        resetOverThresholdProgress(0.0f);
        startOverThresholdProgress();
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.sensorManager.unregisterListener(this, this.lightSensor);
        this.anim.stop();
    }
}
