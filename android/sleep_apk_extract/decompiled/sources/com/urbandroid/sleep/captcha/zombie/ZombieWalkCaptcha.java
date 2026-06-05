package com.urbandroid.sleep.captcha.zombie;

import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.AbstractCaptchaActivity;

/* JADX INFO: loaded from: classes4.dex */
public class ZombieWalkCaptcha extends AbstractCaptchaActivity implements SensorEventListener {
    private AnimationDrawable anim;
    private SensorManager sensorManager;
    private Sensor stepDetector;
    private int target = 15;
    private int steps = 0;
    private boolean solvedAlready = false;

    private void animate() {
        ImageView imageView = (ImageView) findViewById(R.id.zombie);
        imageView.setImageResource(R.drawable.captcha_zombie_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        this.anim = animationDrawable;
        animationDrawable.setOneShot(true);
        this.anim.start();
    }

    private void registerSensor() {
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.sensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(18);
        this.stepDetector = defaultSensor;
        this.sensorManager.registerListener(this, defaultSensor, 3);
    }

    private void updateSteps() {
        getSupportActionBar().setTitle(getResources().getString(R.string.steps, String.valueOf(Math.max(0, this.target - this.steps))));
        if (this.steps % 10 == 0) {
            SoundPool soundPoolBuild = new SoundPool.Builder().build();
            soundPoolBuild.load(this, R.raw.zombie, 1);
            soundPoolBuild.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.urbandroid.sleep.captcha.zombie.ZombieWalkCaptcha.1
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                    soundPool.play(i, 0.3f, 0.3f, 1, 0, 1.0f);
                }
            });
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.captcha_zombie);
        this.solvedAlready = false;
        this.target = getCaptchaSupport().getDifficulty() * 15;
        if (bundle != null) {
            this.steps = bundle.getInt("steps");
        }
        ((ImageView) findViewById(R.id.zombie)).setImageResource(R.drawable.captcha_zombie_anim);
        updateSteps();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        registerSensor();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("steps", this.steps);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Logger.logInfo("Steps " + sensorEvent.values[0]);
        this.steps = this.steps + 1;
        animate();
        if (this.target - this.steps <= 0 && !this.solvedAlready) {
            this.solvedAlready = true;
            solved();
            finish();
        }
        updateSteps();
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        animate();
        Logger.logInfo("Steps sensor registered" + this.stepDetector);
        if (Build.VERSION.SDK_INT >= 29 && ContextCompat.checkSelfPermission(this, "android.permission.ACTIVITY_RECOGNITION") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACTIVITY_RECOGNITION"}, 12);
        }
        registerSensor();
        Logger.logInfo("Steps sensor " + this.stepDetector);
        if (this.stepDetector == null) {
            Toast.makeText(this, R.string.compatibility_sensor, 1).show();
            solved();
            finish();
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.sensorManager.unregisterListener(this, this.stepDetector);
    }
}
