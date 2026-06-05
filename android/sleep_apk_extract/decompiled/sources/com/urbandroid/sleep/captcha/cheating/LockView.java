package com.urbandroid.sleep.captcha.cheating;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.CaptchaAntiCheatingAccessibilityService;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.AlarmAlertFullScreen;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class LockView extends RelativeLayout {
    private boolean cloaked;
    private Handler h;
    private WindowManager.LayoutParams layoutParams;
    private Runnable prepareCloakedRunnable;
    private boolean shown;
    private UpdateRunnable updateRunnable;
    private WindowManager windowManager;

    public LockView(Context context) {
        super(context, null, 2132017935);
        this.shown = false;
        this.cloaked = false;
        this.h = new Handler();
        this.prepareCloakedRunnable = new Runnable() { // from class: com.urbandroid.sleep.captcha.cheating.LockView.2
            @Override // java.lang.Runnable
            public void run() {
                LockView.this.cloaked = true;
            }
        };
        this.updateRunnable = new UpdateRunnable(this, 0);
        InflatorUtil.get(context).inflate(R.layout.lock_view, this);
        setLayoutParamsShown();
        findViewById(R.id.lock_view_button).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.captcha.cheating.LockView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LockView.this.showProgress(true);
                Intent intent = new Intent(LockView.this.getContext(), (Class<?>) AlarmAlertFullScreen.class);
                intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
                if (AlarmKlaxon.currentAlarm != null) {
                    intent.putExtra("intent.extra.alarm_raw", AlarmKlaxon.currentAlarm.serializeToArray());
                }
                LockView.this.getContext().startActivity(intent);
            }
        });
    }

    private int getOverlayType(boolean z) {
        if (z) {
            return 2032;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        return AdError.INTERNAL_ERROR_2006;
    }

    private boolean isAccessibility() {
        if (getContext() instanceof CaptchaAntiCheatingAccessibilityService) {
            return (SharedApplicationContext.isManufacturer("Samsung") && Build.VERSION.SDK_INT == 31) ? false : true;
        }
        return false;
    }

    private void setLayoutParamsShown(int i) {
        if (Build.VERSION.SDK_INT < 26) {
            i = AdError.INTERNAL_ERROR_2003;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, i, 1280, -3);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 8388659;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.windowManager = windowManager;
        int statusBarHeight = getStatusBarHeight() + getNavigationBarHeight() + Math.max(windowManager.getDefaultDisplay().getHeight(), this.windowManager.getDefaultDisplay().getWidth());
        WindowManager.LayoutParams layoutParams2 = this.layoutParams;
        layoutParams2.width = -1;
        layoutParams2.height = statusBarHeight;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgress(boolean z) {
        findViewById(R.id.progress).setVisibility(z ? 0 : 8);
    }

    public void cloak() {
        this.h.removeCallbacks(this.prepareCloakedRunnable);
        if (this.cloaked) {
            return;
        }
        findViewById(R.id.main).setVisibility(8);
        hide();
        this.cloaked = true;
        showProgress(false);
    }

    public int getNavigationBarHeight() {
        Resources resources = getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public synchronized void hide() {
        if (this.shown) {
            Logger.logInfo("CAPTCHA Cheating: Hiding");
            try {
                this.windowManager.removeView(this);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
            this.shown = false;
            this.h.removeCallbacks(this.updateRunnable);
        }
    }

    public synchronized void show() {
        if (!this.shown) {
            Logger.logInfo("CAPTCHA Cheating: Showing");
            WindowManager windowManager = (WindowManager) super.getContext().getSystemService("window");
            this.windowManager = windowManager;
            try {
                windowManager.removeView(this);
            } catch (Exception unused) {
            }
            try {
                Logger.logInfo("CAPTCHA Cheating: adding view 1# " + isAccessibility());
                setLayoutParamsShown(getOverlayType(isAccessibility()));
                this.windowManager.addView(this, this.layoutParams);
            } catch (Exception e) {
                Logger.logSevere(e);
                try {
                    this.windowManager.removeView(this);
                } catch (Exception unused2) {
                }
                try {
                    Logger.logInfo("CAPTCHA Cheating: adding view 2#");
                    setLayoutParamsShown(getOverlayType(!isAccessibility()));
                    this.windowManager.addView(this, this.layoutParams);
                } catch (Exception e2) {
                    Logger.logSevere(e2);
                    return;
                }
            }
            this.shown = true;
            this.h.removeCallbacks(this.updateRunnable);
            this.h.post(this.updateRunnable);
        }
    }

    public void uncloak() {
        Logger.logInfo("Progress uncloak");
        if (this.cloaked) {
            findViewById(R.id.main).setVisibility(0);
            setLayoutParamsShown();
            hide();
            show();
            this.cloaked = false;
            showProgress(false);
        }
    }

    public class UpdateRunnable implements Runnable {
        private UpdateRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT <= 31) {
                try {
                    LockView.this.getContext().sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                } catch (Exception unused) {
                }
            }
            LockView.this.h.postDelayed(LockView.this.updateRunnable, 50L);
        }

        public /* synthetic */ UpdateRunnable(LockView lockView, int i) {
            this();
        }
    }

    private void setLayoutParamsShown() {
        setLayoutParamsShown(getOverlayType(isAccessibility()));
    }
}
