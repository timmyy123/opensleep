package com.urbandroid.sleep.captcha.agentsheep;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.captcha.AbstractCaptchaActivity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0015¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0086D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/captcha/agentsheep/AgentSheepCaptcha;", "Lcom/urbandroid/sleep/captcha/AbstractCaptchaActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "setSolved", "setUnsolved", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AgentSheepCaptcha extends AbstractCaptchaActivity {
    private final String tag = "AgentSheepCaptcha";

    @Override // com.urbandroid.sleep.captcha.AbstractCaptchaActivity, com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Log.d(this.tag, "onCreate");
        setRequestedOrientation(0);
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(getString(R.string.captcha_jumping_sheep));
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.transparent)));
        }
        setContentView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.addJavascriptInterface(new CaptchaJavascriptInterface(this), "Captcha");
        webView.loadUrl("file:///android_asset/agent_sheep/index.html");
    }

    public final void setSolved() {
        getCaptchaSupport().solved();
    }

    public final void setUnsolved() {
        getCaptchaSupport().unsolved();
    }
}
