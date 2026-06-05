package com.urbandroid.sleep.captcha;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.urbandroid.sleep.captcha.intent.IntentExtraSetter;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class BaseCaptchaSupport extends AbstractCaptchaSupport {
    public BaseCaptchaSupport(Activity activity, Intent intent, int i) {
        super(activity, intent, i);
    }

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaSupport
    public void doAlive() {
        send("alive", new IntentExtraSetter() { // from class: com.urbandroid.sleep.captcha.BaseCaptchaSupport.1
            @Override // com.urbandroid.sleep.captcha.intent.IntentExtraSetter
            public void setExtras(Intent intent) {
                if (intent.getPackage() == null && intent.getComponent() == null) {
                    intent.setPackage(BaseCaptchaSupport.this.activity.getPackageName());
                }
                intent.putExtra("timeAddInSeconds", BaseCaptchaSupport.this.aliveTimeoutInSeconds);
            }
        });
    }

    public void send(String str, IntentExtraSetter intentExtraSetter) {
        String str2;
        if (isOperationalMode()) {
            Intent intent = this.intent;
            Intent intent2 = intent != null ? (Intent) intent.getParcelableExtra(str) : null;
            StringBuilder sb = new StringBuilder("Calling ");
            sb.append(str);
            if (intent2 != null) {
                str2 = ": " + intent2 + " package: " + intent2.getPackage() + " component:" + intent2.getComponent();
            } else {
                str2 = "";
            }
            sb.append(str2);
            Log.i("captcha-support", sb.toString());
            if (intent2 == null) {
                return;
            }
            if (intentExtraSetter != null) {
                intentExtraSetter.setExtras(intent2);
            }
            str.getClass();
            switch (str) {
                case "solved":
                    boolean z = this.intent.getIntExtra("captchaParentId", 0) != 0;
                    if (hasOperation() && !z) {
                        this.context.sendBroadcast(intent2);
                        break;
                    } else {
                        try {
                            intent2.addFlags(67108864);
                            intent2.addFlags(536870912);
                            intent2.addFlags(32);
                            intent2.addFlags(ClientDefaults.MAX_MSG_SIZE);
                            this.intent.setPackage("com.urbandroid.sleep.captchapack");
                            StringBuilder sb2 = new StringBuilder("Starting CAPTCHA 0 ");
                            sb2.append(str);
                            sb2.append(": " + intent2 + " package: " + intent2.getPackage() + " component:" + intent2.getComponent());
                            Log.i("captcha-support", sb2.toString());
                            this.activity.startActivity(intent2);
                            break;
                        } catch (Exception e) {
                            Log.e("captcha-support", "Failed to start CAPTCHA 0 " + e.getMessage());
                            Intent intent3 = new Intent(intent2.getAction());
                            try {
                                intent3.addFlags(intent2.getFlags());
                                intent3.addFlags(67108864);
                                intent3.addFlags(536870912);
                                intent3.addFlags(32);
                                intent3.addFlags(ClientDefaults.MAX_MSG_SIZE);
                                intent3.setComponent(intent2.getComponent());
                                intent3.setPackage("com.urbandroid.sleep.captchapack");
                                intent3.putExtras(intent2.getExtras());
                                StringBuilder sb3 = new StringBuilder("Starting CAPTCHA 1 ");
                                sb3.append(str);
                                sb3.append(": " + intent3 + " package: " + intent3.getPackage() + " component:" + intent3.getComponent());
                                Log.i("captcha-support", sb3.toString());
                                this.activity.startActivity(intent3);
                                return;
                            } catch (Exception e2) {
                                Log.e("captcha-support", "Failed to start CAPTCHA 1 " + e2.getMessage());
                                Intent intent4 = new Intent(intent2.getAction());
                                try {
                                    intent4.addFlags(67108864);
                                    intent4.addFlags(536870912);
                                    intent4.addFlags(32);
                                    intent4.addFlags(ClientDefaults.MAX_MSG_SIZE);
                                    intent4.putExtras(intent2.getExtras());
                                    intent4.setPackage("com.urbandroid.sleep.captchapack");
                                    intent4.setClassName("com.urbandroid.sleep.captchapack", "com.urbandroid.sleep.captchapack.multi.InOrderCaptcha");
                                    StringBuilder sb4 = new StringBuilder("Starting CAPTCHA 2 ");
                                    sb4.append(str);
                                    sb4.append(": " + intent4 + " package: " + intent4.getPackage() + " component:" + intent4.getComponent());
                                    Log.i("captcha-support", sb4.toString());
                                    this.activity.startActivity(intent4);
                                    return;
                                } catch (Exception e3) {
                                    Log.e("captcha-support", "Failed to start CAPTCHA 2 " + e3.getMessage());
                                    Intent intent5 = new Intent();
                                    try {
                                        intent5.addFlags(67108864);
                                        intent5.addFlags(536870912);
                                        intent5.addFlags(32);
                                        intent5.addFlags(ClientDefaults.MAX_MSG_SIZE);
                                        intent5.putExtras(intent2.getExtras());
                                        intent5.setPackage("com.urbandroid.sleep.captchapack");
                                        intent5.setClassName("com.urbandroid.sleep.captchapack", "com.urbandroid.sleep.captchapack.multi.InOrderCaptcha");
                                        StringBuilder sb5 = new StringBuilder("Starting CAPTCHA 3 ");
                                        sb5.append(str);
                                        sb5.append(": " + intent5 + " package: " + intent5.getPackage() + " component:" + intent5.getComponent());
                                        Log.i("captcha-support", sb5.toString());
                                        this.activity.startActivity(intent5);
                                        return;
                                    } catch (Exception e4) {
                                        Log.e("captcha-support", "Failed to start CAPTCHA 3 " + e4.getMessage());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "unsolved":
                    if (!hasOperation()) {
                        intent2.addFlags(67108864);
                        intent2.addFlags(536870912);
                        this.context.startActivity(intent2);
                        break;
                    }
                    break;
                case "alive":
                    this.context.sendBroadcast(intent2);
                    break;
            }
        }
    }

    public void solved(IntentExtraSetter intentExtraSetter) {
        send("solved", intentExtraSetter);
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public void unsolved() {
        send("unsolved", null);
    }

    @Override // com.urbandroid.sleep.captcha.CaptchaSupport
    public void solved() {
        solved(null);
    }
}
