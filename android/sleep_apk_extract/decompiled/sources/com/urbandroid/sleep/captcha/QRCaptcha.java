package com.urbandroid.sleep.captcha;

import android.content.Intent;
import android.widget.Toast;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CryptoUtil;
import com.urbandroid.sleep.QRCodePreviewActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.HashSet;

/* JADX INFO: loaded from: classes4.dex */
public class QRCaptcha extends BaseScanningCaptcha<String> {
    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void addScannedValue(String str) {
        SharedApplicationContext.getSettings().addQRCaptcha(str);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public String convertToMD5(String str) {
        return CryptoUtil.md5(str.replaceAll("\\s", ""));
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void forgetAllCaptchas() {
        SharedApplicationContext.getSettings().forgetAllQRCaptcha();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public String[] getStoredValues() {
        return SharedApplicationContext.getSettings().getQRCaptcha();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public int getTitleResource() {
        return R.string.captcha_qr_code_title;
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public Class getTutorialActivity() {
        return QRCodePreviewActivity.class;
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean isHomeMode() {
        return SharedApplicationContext.getSettings().isQRCaptchaHomeOnly();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean isMultiscanMode() {
        return SharedApplicationContext.getSettings().isQRCaptchaMultiscan();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean isValueEqual(String str, String str2) {
        return str2.equals(convertToMD5(str));
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public String parseScannedValue(int i, int i2, Intent intent) {
        IntentResult activityResult = IntentIntegrator.parseActivityResult(i, i2, intent);
        if (activityResult == null) {
            Logger.logSevere("Captcha software returned null, still disabling alarm. Solved!");
            solved();
            return null;
        }
        String contents = activityResult.getContents();
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.captcha_scanned));
        sb.append(": ");
        sb.append(contents == null ? "?" : contents);
        Toast.makeText(this, sb.toString(), 1).show();
        return contents;
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void setHomeMode(boolean z) {
        SharedApplicationContext.getSettings().setQRCaptchaHomeOnly(z);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void setMultiscanMode(boolean z) {
        SharedApplicationContext.getSettings().setQRCaptchaMultiscan(z);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean showTutorial() {
        return SharedApplicationContext.getSettings().isFirstUsageQRCaptcha();
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public void startScanner(boolean z) {
        HashSet hashSet = new HashSet();
        hashSet.add("QR_CODE_MODE");
        new IntentIntegrator(this).initiateScan(hashSet, z ? 49374 : 49373);
    }

    @Override // com.urbandroid.sleep.captcha.BaseScanningCaptcha
    public boolean wasExecutedInLearnMode(int i) {
        return i == 49374;
    }
}
