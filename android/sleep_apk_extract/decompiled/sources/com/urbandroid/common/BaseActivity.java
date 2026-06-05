package com.urbandroid.common;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.captcha.CaptchaCallbackReceiver;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public static boolean SHOWN = false;
    protected Handler h;
    private boolean isAlwaysDarkTheme = false;
    private int lastNightMode = -1;

    public static StringBuilder traceBundle(StringBuilder sb, Bundle bundle) {
        sb.append(" {EX:");
        if (bundle == null) {
            sb.append("null");
        } else {
            for (String str : bundle.keySet()) {
                sb.append(str);
                sb.append(" ");
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() > 0) {
                        Fragment$$ExternalSyntheticOutline1.m67m(sb, "(", str2, ") ");
                    }
                } else {
                    String string = obj != null ? obj.toString() : "NULL";
                    if (string.length() > 0 && string.length() < 100) {
                        Fragment$$ExternalSyntheticOutline1.m67m(sb, "(", string, ") ");
                    }
                }
            }
        }
        sb.append("}");
        return sb;
    }

    public static StringBuilder traceIntent(StringBuilder sb, Intent intent) {
        sb.append(" [I:");
        if (intent == null) {
            sb.append("null");
        } else {
            if (intent.getAction() != null) {
                sb.append("(");
                sb.append(intent.getAction());
                sb.append(") ");
            }
            traceBundle(sb, intent.getExtras());
        }
        sb.append("]");
        return sb;
    }

    public static StringBuilder traceMethod(Class cls, String str) {
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("");
        sbM.append(cls.getSimpleName());
        sbM.append(":");
        if (str != null) {
            sbM.append(str);
            sbM.append("()");
        }
        return sbM;
    }

    public boolean isAlwaysDarkTheme() {
        return this.isAlwaysDarkTheme;
    }

    public void log(String str) {
        Logger.logInfo(((CharSequence) traceMethod(getClass(), null)) + " " + str);
    }

    public void logDebug(String str) {
        Logger.logDebug(((CharSequence) traceMethod(getClass(), null)) + " " + str);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.alwaysDarkTheme, typedValue, false);
        if (typedValue.type != 0) {
            this.isAlwaysDarkTheme = true;
        }
        super.onCreate(bundle);
        this.h = new Handler();
        this.lastNightMode = getResources().getConfiguration().uiMode & 48;
        GlobalInitializator.initializeIfRequired(this);
        Logger.logInfo("Theme: setting last " + getClass().getSimpleName() + " " + this.lastNightMode);
        Logger.logInfo(traceIntent(traceBundle(traceMethod(getClass(), "onCreate"), bundle), getIntent()).toString());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Logger.logDebug(traceMethod(getClass(), "onDestroy").toString());
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Logger.logInfo(traceIntent(traceMethod(getClass(), "onNewIntent"), intent).toString());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        SHOWN = false;
        Logger.logInfo(traceMethod(getClass(), "onPause").toString());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        Logger.logInfo("Theme: onPostResume() ".concat(getClass().getSimpleName()));
        if (this.isAlwaysDarkTheme) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.h.postDelayed(new Runnable() { // from class: com.urbandroid.common.BaseActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int i = BaseActivity.this.getResources().getConfiguration().uiMode & 48;
                if (i == BaseActivity.this.lastNightMode || !RecreateCounter.canRecreate(getClass())) {
                    Logger.logInfo("Theme: onPostResumeAfterRecreate() ");
                    BaseActivity.this.h.postDelayed(new Runnable() { // from class: com.urbandroid.common.BaseActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseActivity.this.onPostResumeAfterRecreate();
                        }
                    }, 500L);
                    return;
                }
                Logger.logInfo("Theme: theme changed recreate() " + BaseActivity.this.getClass().getSimpleName() + " new " + i + " != old " + BaseActivity.this.lastNightMode + " exectTime: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (System.currentTimeMillis() - jCurrentTimeMillis < 30000) {
                    BaseActivity.this.recreate();
                    RecreateCounter.recreatedCalled(getClass());
                }
            }
        }, 100L);
    }

    public void onPostResumeAfterRecreate() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SHOWN = true;
        Logger.logDebug(traceMethod(getClass(), "onResume").toString());
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Logger.logInfo(traceIntent(traceBundle(traceMethod(getClass(), "onSaveInstanceState"), bundle), getIntent()).toString());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Logger.logDebug(traceMethod(getClass(), "onStart").toString());
        if (AlarmKlaxon.isRunning()) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CaptchaCallbackReceiver.CAPTCHA_ACTION_UPDATE));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Logger.logDebug(traceMethod(getClass(), "onStop").toString());
        if (AlarmKlaxon.isRunning()) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CaptchaCallbackReceiver.CAPTCHA_ACTION_UPDATE));
        }
    }
}
