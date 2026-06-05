package com.urbandroid.sleep.captcha;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.sensor.AccelManager;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.WaveDrawable;

/* JADX INFO: loaded from: classes4.dex */
public class ShakeItCaptcha extends AbstractCaptchaActivity {
    private static int COUNT_CACHE;
    private static long COUNT_CACHE_TS;
    private int count;
    private int countStart;
    private TextView countText;
    private ShakeView shakeView;
    private AccelThread thread;
    private WaveDrawable waveDrawable;

    public class AccelThread extends Thread {
        public AccelThread() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            Logger.logInfo("ShakeIt: cache reset");
            ShakeItCaptcha.COUNT_CACHE = 0;
            ShakeItCaptcha.this.solved();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AccelManager accelManager = new AccelManager(ShakeItCaptcha.this, false, 0, false);
            try {
                accelManager.start();
                int i = ShakeItCaptcha.this.count;
                int i2 = 100;
                while (true) {
                    try {
                        Thread.sleep(500L);
                        ShakeItCaptcha.this.count -= (int) accelManager.resetChangeNonBatched();
                        Logger.logInfo("ShakeIt: cache count  " + ShakeItCaptcha.this.count);
                        ShakeItCaptcha.COUNT_CACHE = ShakeItCaptcha.this.count;
                        ShakeItCaptcha.COUNT_CACHE_TS = System.currentTimeMillis();
                        i2 -= i - ShakeItCaptcha.this.count;
                        i = ShakeItCaptcha.this.count;
                        if (i2 < 0) {
                            ShakeItCaptcha.this.alive();
                            i2 = 100;
                        }
                        int i3 = ShakeItCaptcha.this.count;
                        ShakeItCaptcha shakeItCaptcha = ShakeItCaptcha.this;
                        int i4 = 1;
                        if (i3 < 1) {
                            shakeItCaptcha.runOnUiThread(new BaseScanningCaptcha$$ExternalSyntheticLambda6(this, i4));
                            accelManager.stop();
                            return;
                        }
                        shakeItCaptcha.runOnUiThread(new Runnable() { // from class: com.urbandroid.sleep.captcha.ShakeItCaptcha.AccelThread.1
                            @Override // java.lang.Runnable
                            public void run() {
                                float f = 1.0f - (ShakeItCaptcha.this.count / ShakeItCaptcha.this.countStart);
                                TextView textView = ShakeItCaptcha.this.countText;
                                ShakeItCaptcha shakeItCaptcha2 = ShakeItCaptcha.this;
                                textView.setText(Html.fromHtml(shakeItCaptcha2.getProgressText(shakeItCaptcha2.count, ShakeItCaptcha.this.countStart)));
                                ShakeItCaptcha.this.shakeView.setStatus(1.0f - (ShakeItCaptcha.this.count / ShakeItCaptcha.this.countStart));
                                ShakeItCaptcha.this.shakeView.invalidate();
                                ShakeItCaptcha.this.waveDrawable.setWaterLevel(0, f);
                                ShakeItCaptcha.this.waveDrawable.setWaterLevel(1, f * 0.8f);
                            }
                        });
                    } catch (InterruptedException unused) {
                        accelManager.stop();
                        return;
                    }
                }
            } catch (Throwable th) {
                accelManager.stop();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getProgressText(int i, int i2) {
        return String.format("%d<small>%%</small>", Integer.valueOf(Math.round((1.0f - (i / i2)) * 100.0f)));
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.captcha_shake_it);
        if (getResources().getBoolean(R.bool.tablet)) {
            setRequestedOrientation(0);
            setRequestedOrientation(14);
        } else {
            setRequestedOrientation(1);
            setRequestedOrientation(14);
        }
        if (getLastCustomNonConfigurationInstance() == null || !(getLastCustomNonConfigurationInstance() instanceof Integer)) {
            int difficulty = getDifficulty();
            this.count = difficulty == 1 ? 500 : difficulty * 1000;
        } else {
            this.count = ((Integer) getLastCustomNonConfigurationInstance()).intValue();
        }
        int i = this.count;
        this.countStart = i;
        if (bundle != null) {
            this.count = bundle.getInt("count", i);
        }
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("ShakeIt: cache "), COUNT_CACHE);
        if (COUNT_CACHE_TS == -1 || System.currentTimeMillis() - COUNT_CACHE_TS > 10000) {
            Logger.logInfo("ShakeIt: reset cache");
            COUNT_CACHE = 0;
        }
        int i2 = COUNT_CACHE;
        if (i2 > 0 && i2 < this.count) {
            StringBuilder sb = new StringBuilder("ShakeIt: cache ");
            sb.append(this.count);
            sb.append(" = ");
            zza$$ExternalSyntheticOutline0.m(sb, COUNT_CACHE);
            this.count = COUNT_CACHE;
        }
        AccelThread accelThread = new AccelThread();
        this.thread = accelThread;
        accelThread.start();
        this.countText = (TextView) findViewById(R.id.captcha_si_count);
        setTitle(R.string.captcha_shake_it_title);
        ShakeView shakeView = (ShakeView) findViewById(R.id.captcha_si);
        this.shakeView = shakeView;
        shakeView.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.ShakeItCaptcha.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShakeItCaptcha.this.userInteraction();
            }
        });
        this.countText.setText(Html.fromHtml(getProgressText(this.count, this.countStart)));
        WaveDrawable waveDrawable = new WaveDrawable();
        this.waveDrawable = waveDrawable;
        waveDrawable.setInterval(20);
        this.waveDrawable.setFastMode(true);
        this.waveDrawable.addWave(60, 1, ColorUtil.i(this, R.color.tint), 1.8f, 0.02f, 0.7f);
        this.waveDrawable.addWave(40, 18, ColorUtil.i(this, R.color.tint_background), 2.4f, 0.0016f, 0.9f);
        this.waveDrawable.setAlpha(150);
        ((ViewGroup) findViewById(R.id.wave)).setBackgroundDrawable(this.waveDrawable);
        this.waveDrawable.start();
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.waveDrawable.start();
    }

    @Override // androidx.view.ComponentActivity
    public Object onRetainCustomNonConfigurationInstance() {
        return Integer.valueOf(this.count);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.putInt("count", this.count);
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AccelThread accelThread;
        super.onStop();
        if (!isFinishing() || (accelThread = this.thread) == null) {
            return;
        }
        accelThread.interrupt();
    }
}
