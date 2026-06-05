package com.urbandroid.sleep.captcha;

import android.graphics.drawable.AnimationDrawable;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.RandUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.util.VolumeUtil;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class WakedroidCaptcha extends AbstractCaptchaActivity {
    private AnimationDrawable anim;
    private ImageView droid;
    private SoundPool soundPool;
    private final String TAG = "WakedroidCaptcha";
    private int target = 100;
    private int progress = 0;
    private Runnable progressRunnable = new WakedroidCaptcha$$ExternalSyntheticLambda0(this, 0);

    private void animate() {
        ImageView imageView = (ImageView) findViewById(R.id.droid);
        imageView.setImageResource(R.drawable.captcha_wakedroid_sleeping_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        this.anim = animationDrawable;
        animationDrawable.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4() {
        this.progress = RandUtil.range(5, 20) + this.progress;
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(int[] iArr, View view) {
        wake(iArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(int[] iArr, View view) {
        wake(iArr[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(int[] iArr, View view) {
        wake(iArr[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(int[] iArr, View view) {
        wake(iArr[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$update$5() {
        this.droid.setImageResource(R.drawable.captcha_wakedroid_sleeping_anim);
        animate();
    }

    private int setInitialTarget() {
        int difficulty = getCaptchaSupport().getDifficulty() * 100;
        if (difficulty < 0) {
            return 100;
        }
        return difficulty;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: solve, reason: merged with bridge method [inline-methods] */
    public void lambda$update$6() {
        solved();
        finish();
    }

    private void update() {
        int iRound = Math.round((this.progress / this.target) * 100.0f);
        Logger.logInfo("Wakedroid: " + this.progress + " / " + this.target + " " + iRound + "%");
        TextView textView = (TextView) findViewById(R.id.score);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.min(iRound, 100));
        sb.append("%");
        textView.setText(sb.toString());
        this.droid.setImageResource(R.drawable.captcha_wakedroid_half_wake);
        ((ProgressBar) findViewById(R.id.progress)).setProgress(iRound);
        ((ProgressBar) findViewById(R.id.progress)).setMax(100);
        if (iRound < 95) {
            this.h.postDelayed(new WakedroidCaptcha$$ExternalSyntheticLambda0(this, 1), 1000L);
        } else {
            this.droid.setImageResource(R.drawable.captcha_wakedroid_wake);
            this.h.postDelayed(new WakedroidCaptcha$$ExternalSyntheticLambda0(this, 2), 1000L);
        }
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.captcha_wakedroid);
        this.target = setInitialTarget();
        this.droid = (ImageView) findViewById(R.id.droid);
        if (bundle != null) {
            this.progress = bundle.getInt("progress");
        }
        ActionBar supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.setTitle(R.string.captcha_wakedroid);
        SoundPool soundPoolBuild = new SoundPool.Builder().build();
        this.soundPool = soundPoolBuild;
        final int i = 1;
        final int[] iArr = {soundPoolBuild.load(this, R.raw.captcha_wekedroid_sound1, 1), this.soundPool.load(this, R.raw.captcha_wekedroid_sound2, 1), this.soundPool.load(this, R.raw.captcha_wekedroid_sound3, 1), this.soundPool.load(this, R.raw.captcha_wekedroid_sound4, 1)};
        final int i2 = 0;
        findViewById(R.id.sound1).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.WakedroidCaptcha$$ExternalSyntheticLambda1
            public final /* synthetic */ WakedroidCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                int[] iArr2 = iArr;
                WakedroidCaptcha wakedroidCaptcha = this.f$0;
                switch (i3) {
                    case 0:
                        wakedroidCaptcha.lambda$onCreate$0(iArr2, view);
                        break;
                    case 1:
                        wakedroidCaptcha.lambda$onCreate$1(iArr2, view);
                        break;
                    case 2:
                        wakedroidCaptcha.lambda$onCreate$2(iArr2, view);
                        break;
                    default:
                        wakedroidCaptcha.lambda$onCreate$3(iArr2, view);
                        break;
                }
            }
        });
        findViewById(R.id.sound2).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.WakedroidCaptcha$$ExternalSyntheticLambda1
            public final /* synthetic */ WakedroidCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                int[] iArr2 = iArr;
                WakedroidCaptcha wakedroidCaptcha = this.f$0;
                switch (i3) {
                    case 0:
                        wakedroidCaptcha.lambda$onCreate$0(iArr2, view);
                        break;
                    case 1:
                        wakedroidCaptcha.lambda$onCreate$1(iArr2, view);
                        break;
                    case 2:
                        wakedroidCaptcha.lambda$onCreate$2(iArr2, view);
                        break;
                    default:
                        wakedroidCaptcha.lambda$onCreate$3(iArr2, view);
                        break;
                }
            }
        });
        final int i3 = 2;
        findViewById(R.id.sound3).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.WakedroidCaptcha$$ExternalSyntheticLambda1
            public final /* synthetic */ WakedroidCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i3;
                int[] iArr2 = iArr;
                WakedroidCaptcha wakedroidCaptcha = this.f$0;
                switch (i32) {
                    case 0:
                        wakedroidCaptcha.lambda$onCreate$0(iArr2, view);
                        break;
                    case 1:
                        wakedroidCaptcha.lambda$onCreate$1(iArr2, view);
                        break;
                    case 2:
                        wakedroidCaptcha.lambda$onCreate$2(iArr2, view);
                        break;
                    default:
                        wakedroidCaptcha.lambda$onCreate$3(iArr2, view);
                        break;
                }
            }
        });
        final int i4 = 3;
        findViewById(R.id.sound4).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.captcha.WakedroidCaptcha$$ExternalSyntheticLambda1
            public final /* synthetic */ WakedroidCaptcha f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i4;
                int[] iArr2 = iArr;
                WakedroidCaptcha wakedroidCaptcha = this.f$0;
                switch (i32) {
                    case 0:
                        wakedroidCaptcha.lambda$onCreate$0(iArr2, view);
                        break;
                    case 1:
                        wakedroidCaptcha.lambda$onCreate$1(iArr2, view);
                        break;
                    case 2:
                        wakedroidCaptcha.lambda$onCreate$2(iArr2, view);
                        break;
                    default:
                        wakedroidCaptcha.lambda$onCreate$3(iArr2, view);
                        break;
                }
            }
        });
        animate();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("progress", this.progress);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        animate();
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public void wake(int i) {
        VolumeUtil.setStreamVolume(this, 3, 100);
        this.soundPool.play(i, RandUtil.range(80, 100) / 100.0f, RandUtil.range(80, 100) / 100.0f, 1, 0, RandUtil.range(50, 100) / 100.0f);
        this.h.removeCallbacks(this.progressRunnable);
        this.h.postDelayed(this.progressRunnable, 1000L);
    }
}
