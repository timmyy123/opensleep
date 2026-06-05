package com.urbandroid.sleep.captcha;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.urbandroid.sleep.captcha.finder.BaseCaptchaFinder;
import com.urbandroid.sleep.captcha.finder.CaptchaFinder;
import com.urbandroid.sleep.captcha.launcher.BaseCaptchaLauncher;
import com.urbandroid.sleep.captcha.launcher.CaptchaLauncher;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractCaptchaSupport implements CaptchaSupport {
    protected final Activity activity;
    protected final Context context;
    private final int currentCaptchaId;
    protected final CaptchaFinder finder;
    private final FinishReceiver finishReceiver;
    protected final Intent intent;
    protected final CaptchaLauncher launcher;
    private final RemainingTimeRunnable remainingTimeRunnable;
    protected int aliveTimeoutInSeconds = 60;
    private long lastAliveSent = -1;
    private final AtomicReference<RemainingTimeListener> remainingTimeListener = new AtomicReference<>();
    private final Handler handler = new Handler();

    public class FinishReceiver extends BroadcastReceiver {
        private final AtomicBoolean isRegistered;

        private FinishReceiver() {
            this.isRegistered = new AtomicBoolean(false);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractCaptchaSupport.this.activity.finish();
        }

        public void register() {
            if (this.isRegistered.get()) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.urbandroid.sleep.alarmclock.ALARM_SNOOZE");
            intentFilter.addAction("com.urbandroid.sleep.ACTION_FINISH_CAPTCHA");
            this.isRegistered.set(true);
            int i = Build.VERSION.SDK_INT;
            AbstractCaptchaSupport abstractCaptchaSupport = AbstractCaptchaSupport.this;
            if (i >= 33) {
                abstractCaptchaSupport.context.registerReceiver(this, intentFilter, 2);
            } else {
                abstractCaptchaSupport.context.registerReceiver(this, intentFilter);
            }
        }

        public void unregister() {
            if (this.isRegistered.get()) {
                AbstractCaptchaSupport.this.context.unregisterReceiver(this);
                this.isRegistered.set(false);
            }
        }
    }

    public class RemainingTimeRunnable implements Runnable {
        private RemainingTimeRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RemainingTimeListener remainingTimeListener = (RemainingTimeListener) AbstractCaptchaSupport.this.remainingTimeListener.get();
            if (remainingTimeListener == null) {
                return;
            }
            remainingTimeListener.timeRemain(AbstractCaptchaSupport.this.getRemainingTime(), AbstractCaptchaSupport.this.aliveTimeoutInSeconds);
            AbstractCaptchaSupport.this.handler.postDelayed(this, 500L);
        }
    }

    public AbstractCaptchaSupport(Activity activity, Intent intent, int i) {
        this.remainingTimeRunnable = new RemainingTimeRunnable();
        FinishReceiver finishReceiver = new FinishReceiver();
        this.finishReceiver = finishReceiver;
        this.activity = activity;
        Context applicationContext = activity.getApplicationContext();
        this.context = applicationContext;
        this.intent = intent;
        this.currentCaptchaId = intent != null ? intent.getIntExtra("captchaId", 0) : 0;
        this.finder = new BaseCaptchaFinder(applicationContext);
        BaseCaptchaLauncher baseCaptchaLauncher = new BaseCaptchaLauncher(applicationContext, activity.getClass().getName(), intent, i);
        baseCaptchaLauncher.suppressAlarmMode(getSuppressAlarmMode()).difficulty(getDifficulty()).operation(getOperation());
        baseCaptchaLauncher.parentMode(getParentMode());
        this.launcher = baseCaptchaLauncher;
        aliveTimeout(i);
        finishReceiver.register();
    }

    private String getOperation() {
        Intent intent = this.intent;
        if (intent != null && !intent.hasExtra("no_operation")) {
            if (this.intent.hasExtra("delete_alarm")) {
                return "delete_alarm";
            }
            if (this.intent.hasExtra("disable_alarm")) {
                return "disable_alarm";
            }
            if (this.intent.hasExtra("edit_alarm")) {
                return "edit_alarm";
            }
            if (this.intent.hasExtra("edit_alarm_time_extra")) {
                return "edit_alarm_time_extra";
            }
            if (this.intent.hasExtra("should_skip")) {
                return "should_skip";
            }
            if (this.intent.hasExtra("snooze_cancel")) {
                return "snooze_cancel";
            }
        }
        return "no_operation";
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public final void alive() {
        doAlive();
        this.lastAliveSent = System.currentTimeMillis();
    }

    public CaptchaSupport aliveTimeout(int i) {
        if (i < 5 || i > 300) {
            Log.w("captcha-support", "aliveTimeout out of range <5, 300>");
            return this;
        }
        Log.d("captcha-support", "aliveTimeout set: " + i);
        this.aliveTimeoutInSeconds = i;
        return this;
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public void destroy() {
        this.finishReceiver.unregister();
        RemainingTimeRunnable remainingTimeRunnable = this.remainingTimeRunnable;
        if (remainingTimeRunnable != null) {
            this.handler.removeCallbacks(remainingTimeRunnable);
            this.remainingTimeListener.set(null);
        }
    }

    public abstract void doAlive();

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public int getDifficulty() {
        Intent intent = this.intent;
        if (intent != null) {
            return intent.getIntExtra("difficulty", 1);
        }
        return 1;
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public CaptchaLauncher getLauncher() {
        return this.launcher;
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public int getMode() {
        if (isPreviewMode()) {
            return 2;
        }
        return isConfigurationMode() ? 3 : 1;
    }

    public int getParentMode() {
        Intent intent = this.intent;
        int intExtra = intent != null ? intent.getIntExtra("captchaParentMode", 0) : 0;
        return intExtra == 0 ? getMode() : intExtra;
    }

    public int getRemainingTime() {
        long j = this.lastAliveSent;
        if (j == -1) {
            return 5;
        }
        long jCurrentTimeMillis = ((j + ((long) (this.aliveTimeoutInSeconds * 1000))) - System.currentTimeMillis()) / 1000;
        if (jCurrentTimeMillis < 0) {
            return 0;
        }
        return (int) jCurrentTimeMillis;
    }

    public int getSuppressAlarmMode() {
        Intent intent = this.intent;
        if (intent != null) {
            return intent.getIntExtra("suppress-alarm-mode", 0);
        }
        return 0;
    }

    public boolean hasOperation() {
        Intent intent = this.intent;
        return (intent == null || intent.hasExtra("no_operation")) ? false : true;
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public boolean isConfigurationMode() {
        Intent intent = this.intent;
        return intent != null && "com.urbandroid.sleep.captcha.intent.action.CONFIG".equals(intent.getAction());
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public boolean isOperationalMode() {
        return (isPreviewMode() || isConfigurationMode()) ? false : true;
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public boolean isPreviewMode() {
        Intent intent = this.intent;
        return intent != null && intent.getBooleanExtra("preview", false);
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public CaptchaSupport setRemainingTimeListener(RemainingTimeListener remainingTimeListener) {
        if (hasOperation()) {
            Log.w("captcha-support", "Sleep operation set: RemainingTimeListener will be not active");
            return this;
        }
        if (!isOperationalMode()) {
            Log.w("captcha-support", "No operational mode: RemainingTimeListener will be not active");
            return this;
        }
        if (getParentMode() == 2) {
            Log.w("captcha-support", "Parent Captcha mode is preview: RemainingTimeListener will be not active");
            return this;
        }
        if (getSuppressAlarmMode() == 0) {
            Log.w("captcha-support", "SuppressAlarmMode: Full Alarm Volume - RemainingTimeListener will be not active");
            return this;
        }
        this.remainingTimeListener.set(remainingTimeListener);
        this.handler.removeCallbacks(this.remainingTimeRunnable);
        if (remainingTimeListener != null) {
            this.handler.postDelayed(this.remainingTimeRunnable, 500L);
        }
        return this;
    }
}
