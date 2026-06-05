package com.urbandroid.sleep.captcha.agentsheep;

import android.util.Log;
import android.webkit.JavascriptInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/captcha/agentsheep/CaptchaJavascriptInterface;", "", "captcha", "Lcom/urbandroid/sleep/captcha/agentsheep/AgentSheepCaptcha;", "<init>", "(Lcom/urbandroid/sleep/captcha/agentsheep/AgentSheepCaptcha;)V", "solved", "", "unsolved", "userInteracted", "getDifficulty", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaJavascriptInterface {
    private final AgentSheepCaptcha captcha;

    public CaptchaJavascriptInterface(AgentSheepCaptcha agentSheepCaptcha) {
        agentSheepCaptcha.getClass();
        this.captcha = agentSheepCaptcha;
    }

    @JavascriptInterface
    public final String getDifficulty() {
        Log.d("Captcha", "getDifficulty " + this.captcha.getCaptchaSupport().getDifficulty());
        return String.valueOf(this.captcha.getCaptchaSupport().getDifficulty());
    }

    @JavascriptInterface
    public final void solved() {
        Log.d("Captcha", "solved");
        Log.d("Captcha", "solved " + this.captcha);
        this.captcha.setSolved();
        this.captcha.finish();
    }

    @JavascriptInterface
    public final void unsolved() {
        Log.d("Captcha", "unsolved");
        this.captcha.setUnsolved();
    }

    @JavascriptInterface
    public final void userInteracted() {
        Log.d("Captcha", "userInteracted");
        this.captcha.onUserInteraction();
    }
}
