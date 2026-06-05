package com.urbandroid.sleep.captcha.launcher;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.facebook.GraphResponse;
import com.urbandroid.sleep.captcha.CaptchaSupportException;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.intent.CallbackIntentCreator;
import com.urbandroid.sleep.captcha.intent.IntentExtraSetter;
import com.urbandroid.sleep.captcha.util.IntentUtil;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCaptchaLauncher implements CaptchaLauncher {
    private int aliveTimeout;
    protected CallbackIntentCreator callbackIntentCreator;
    protected final String captchaClassName;
    protected final Context context;
    protected int difficulty;
    protected int flags;
    protected IntentExtraSetter intentExtraSetter;
    protected int mode;
    protected String operation;
    protected final Intent originIntent;
    protected int parentMode;
    protected int suppressAlarmMode;

    public BaseCaptchaLauncher(Context context, String str, Intent intent, int i) {
        this.difficulty = 1;
        this.suppressAlarmMode = 0;
        this.mode = 1;
        this.parentMode = 0;
        this.operation = "no_operation";
        this.flags = 805306368;
        this.context = context;
        this.captchaClassName = str;
        this.originIntent = intent;
        this.aliveTimeout = i;
        if (intent == null || i == -1) {
            return;
        }
        intent.putExtra("aliveTimeout", i);
    }

    private Intent postProcess(Intent intent) {
        IntentExtraSetter intentExtraSetter = this.intentExtraSetter;
        if (intentExtraSetter != null) {
            intentExtraSetter.setExtras(intent);
        }
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.addFlags(8388608);
        return intent;
    }

    @Override // com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
    public CaptchaLauncher addFlags(int i) {
        this.flags = i | this.flags;
        return this;
    }

    public CaptchaLauncher callbackIntentCreator(CallbackIntentCreator callbackIntentCreator) {
        this.callbackIntentCreator = callbackIntentCreator;
        return this;
    }

    @Override // com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
    public CaptchaLauncher difficulty(int i) {
        this.difficulty = i;
        return this;
    }

    @Override // com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
    public CaptchaLauncher extraSetter(IntentExtraSetter intentExtraSetter) {
        this.intentExtraSetter = intentExtraSetter;
        return this;
    }

    @Override // com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
    public CaptchaLauncher mode(int i) {
        this.mode = i;
        return this;
    }

    @Override // com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
    public CaptchaLauncher operation(String str) {
        this.operation = str;
        return this;
    }

    public CaptchaLauncher parentMode(int i) {
        this.parentMode = i;
        return this;
    }

    public Intent prepareIntent(CaptchaInfo captchaInfo) {
        int i = this.mode;
        if (i == 1) {
            CallbackIntentCreator callbackIntentCreator = this.callbackIntentCreator;
            Intent className = callbackIntentCreator == null ? new Intent("com.urbandroid.sleep.captcha.intent.action.SOLVED").putExtra("originIntent", this.originIntent).putExtra(GraphResponse.SUCCESS_KEY, true).addFlags(ClientDefaults.MAX_MSG_SIZE).setClassName(this.context.getPackageName(), this.captchaClassName) : callbackIntentCreator.createSolvedIntent(this.context, this.operation);
            className.putExtra(this.operation, true);
            className.putExtra("captchaInfo", captchaInfo.getId());
            CallbackIntentCreator callbackIntentCreator2 = this.callbackIntentCreator;
            Intent className2 = callbackIntentCreator2 == null ? new Intent("com.urbandroid.sleep.captcha.intent.action.SOLVED").putExtra("originIntent", this.originIntent).putExtra(GraphResponse.SUCCESS_KEY, false).addFlags(ClientDefaults.MAX_MSG_SIZE).setClassName(this.context.getPackageName(), this.captchaClassName) : callbackIntentCreator2.createUnsolvedIntent(this.context, this.operation);
            className2.putExtra("captchaInfo", captchaInfo.getId());
            Intent intentPutExtra = new Intent("com.urbandroid.sleep.captcha.intent.action.OPEN").setClassName(captchaInfo.getPackageName(), captchaInfo.getActivityName()).setFlags(this.flags).putExtra("solved", className).putExtra("unsolved", className2).putExtra("alive", new Intent("com.urbandroid.sleep.captcha.intent.action.ALIVE").setPackage("com.urbandroid.sleep")).putExtra("difficulty", this.difficulty).putExtra("suppress-alarm-mode", this.suppressAlarmMode).putExtra(this.operation, true);
            int i2 = this.aliveTimeout;
            if (i2 != -1) {
                intentPutExtra.putExtra("aliveTimeout", i2);
            }
            return postProcess(intentPutExtra);
        }
        if (i == 2) {
            Intent intentPutExtra2 = new Intent("com.urbandroid.sleep.captcha.intent.action.OPEN").setClassName(captchaInfo.getPackageName(), captchaInfo.getActivityName()).addFlags(ClientDefaults.MAX_MSG_SIZE).putExtra("difficulty", this.difficulty).putExtra("suppress-alarm-mode", this.suppressAlarmMode).putExtra("preview", true);
            int i3 = this.aliveTimeout;
            if (i3 != -1) {
                intentPutExtra2.putExtra("aliveTimeout", i3);
            }
            return postProcess(intentPutExtra2);
        }
        if (i != 3) {
            throw new CaptchaSupportException("Unknown captcha mode: " + this.mode);
        }
        Intent intentPutExtra3 = new Intent("com.urbandroid.sleep.captcha.intent.action.CONFIG").setClassName(captchaInfo.getPackageName(), captchaInfo.getConfigActivityName()).addFlags(ClientDefaults.MAX_MSG_SIZE).putExtra("suppress-alarm-mode", this.suppressAlarmMode).putExtra("difficulty", this.difficulty);
        int i4 = this.aliveTimeout;
        if (i4 != -1) {
            intentPutExtra3.putExtra("aliveTimeout", i4);
        }
        return postProcess(intentPutExtra3);
    }

    @Override // com.urbandroid.sleep.captcha.launcher.CaptchaLauncher
    public void start(CaptchaInfo captchaInfo) {
        Log.i("captcha-support", "Starting captcha mode: " + this.mode + " difficulty: " + this.difficulty + " aliveTimeout: " + this.aliveTimeout + " operation: " + this.operation + " " + captchaInfo);
        Intent intentPrepareIntent = prepareIntent(captchaInfo);
        intentPrepareIntent.putExtra("captchaId", captchaInfo.getId());
        Intent intent = this.originIntent;
        intentPrepareIntent.putExtra("captchaParentId", intent != null ? intent.getIntExtra("captchaId", 0) : 0);
        intentPrepareIntent.putExtra("captchaParentMode", this.parentMode);
        Log.d("captcha-support", IntentUtil.traceIntent(intentPrepareIntent));
        this.context.startActivity(intentPrepareIntent);
    }

    public CaptchaLauncher suppressAlarmMode(int i) {
        this.suppressAlarmMode = i;
        return this;
    }

    public BaseCaptchaLauncher(Context context, String str, Intent intent) {
        this(context, str, intent, -1);
    }
}
